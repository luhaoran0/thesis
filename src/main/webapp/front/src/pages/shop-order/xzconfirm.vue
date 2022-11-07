<template>
  <div :style='{"width":"1200px","padding":"20px","boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.302)","margin":"10px auto","position":"relative","background":"#fff"}'>
    <div class="section-title" :style='{"border":"4px solid rgba(197, 19, 19, 1)","margin":"10px 0","fontSize":"20px","lineHeight":"54px","color":"#333","textAlign":"center"}'>Confirm order</div>
    <el-descriptions title="List"></el-descriptions>
    <el-table
      :data="tableData"
      style="width: 100%">
      <el-table-column
        label="Buy goods">
        <template slot-scope="scope">
          <div class="shangpin">
            <el-image
              style="width: 100px; height: 100px"
              :src="baseUrl + '/' + scope.row.picture"
              fit="fill"></el-image>
            <span style="margin-left: 10px">{{ scope.row.goodname }}</span>
          </div>
        </template>
      </el-table-column>
      <el-table-column
        label="Price">
        <template slot-scope="scope">
          <span v-if="type == 2">{{ scope.row.price }} integral</span>
          <span v-else>￥{{ scope.row.price.toFixed(2) }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="座位">
        <template slot-scope="scope">
          <span>{{ scope.row.address }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="Total price">
        <template slot-scope="scope">
          <span v-if="type == 1">￥{{ (scope.row.price * buyNum).toFixed(2) }}</span>
          <span v-if="type == 2">{{ scope.row.price * 1 }} integral</span>
        </template>
      </el-table-column>
    </el-table>
    <div class="buy" v-if="tableData.length > 0">
      <template v-if="type == 2">
        <span style="color: red;margin-right: 10px;font-weight: 700;">Total price：{{totalJifen}} integral</span>
        <el-button
          type="warning"
          @click="redeem">exchange</el-button>
      </template>
      <template v-else>
        <span style="color: red;margin-right: 10px;font-weight: 700;">Total price：￥{{totalPrice}}</span>
        <el-button
          type="warning"
          @click="payClick">Balance payment</el-button>
      </template>
    </div>
  </div>
</template>

<script>
  import config from '@/config/config'
  export default {
    data() {
      return {
        baseUrl: config.baseUrl,
        userTableName: localStorage.getItem('UserTableName'),
        tableData: [],
        order: {
          address: "",
          buynumber: 0,
          discountprice: 0,
          discounttotal: 0,
          goodid: 0,
          goodname: "",
          orderid: "",
          picture: "",
          price: 0,
          status: "Unpaid",
          tablename: "",
          total: 0,
          type: 1,
          userid: localStorage.getItem('userid')
        },
        session: {},
        type: 0,
        goodid: 0,
        goodname: '',
        price: '',
        picture: '',
        address: '',
        buyNum: 0,
        tablename: '',
        detail: {}
      }
    },
    created() {
      this.goodid = this.$route.query.id;
      this.type = this.$route.query.type;
      this.goodname = this.$route.query.goodname;
      this.price = parseFloat(this.$route.query.price);
      this.picture = this.$route.query.picture;
      this.address = this.$route.query.address;
      this.buyNum = this.address.split(',').length;
      this.tablename = this.$route.query.tablename;
      if (this.type == 1) {
        this.tableData.push({
          goodname: this.goodname,
          picture: this.picture,
          address: this.address,
          price: this.price
        });
      }
      if (this.type == 2) {
        this.detail = JSON.parse(this.$route.query.detailObj);
        this.tableData.push({
          goodname: this.goodname,
          picture: this.picture,
          address: this.address,
          price: parseFloat(this.detail.jf)
        });
      }
      this.getSession();
    },
    methods: {
      getSession() {
        this.$http.get(`${this.userTableName}/session`, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.session = res.data.data;
          }
        });
      },
      payClick() {
        if (this.session.money < this.totalPrice) {
          this.$message({
            message: 'Insufficient balance, please recharge first',
            type: 'error',
            duration: 1500
          });
          return;
        }
        this.$http.get(`${this.tablename}/detail/${this.goodid}`).then(res => {
          if (res.data.code == 0) {
            let resData = res.data.data;
            resData.selected = resData.selected + ',' + this.address;
            this.detail = resData;
            this.$http.post(`${this.tablename}/update`, resData).then(res => {});

            let orderid = this.createOrder();
            this.order.address = this.address;
            this.order.buynumber = this.buyNum;
            this.order.price = this.price;
            this.order.discountprice = this.detail.vipprice ? this.detail.vipprice : this.price;
            this.order.total = (this.price * this.buyNum).toFixed(2);
            this.order.discounttotal = (this.order.discountprice * this.buyNum).toFixed(2);
            this.order.goodid = this.goodid;
            this.order.goodname = this.goodname;
            this.order.orderid = orderid;
            this.order.picture = this.picture;
            this.order.tablename = this.tablename;
            this.order.status = 'Paid';
            
            this.$http.post('orders/add', this.order).then(res => {});

            if (resData.jf) {
              this.session.jf = Number(this.session.jf) + Number(resData.price * this.buyNum);
            }
            this.session.money -= this.order.discounttotal;
            this.$http.post(`${this.userTableName}/update`, this.session).then(res => {});
          }
        });

        this.$message({
          message: 'Reservation succeeded!',
          type: 'success',
          duration: 1500,
          onClose: () => {
            this.$router.push('/index/shop-order/order');
          }
        });
      },
      redeem() {
        if (this.session.jf < this.totalJifen) {
          this.$message({
            message: 'Insufficient integer, unable to exchange',
            type: 'error',
            duration: 1500
          });
          return;
        }

        this.detail.selected = this.detail.selected + ',' + this.address;
        this.$http.post(`${this.tablename}/update`, this.detail).then(res => {});

        let orderid = this.createOrder();
        this.order.address = this.address;
        this.order.buynumber = 1;
        this.order.price = this.detail.jf;
        this.order.discountprice = this.detail.jf;
        this.order.total = this.detail.jf;
        this.order.discounttotal = this.detail.jf;
        this.order.goodid = this.goodid;
        this.order.goodname = this.goodname;
        this.order.orderid = orderid;
        this.order.picture = this.picture;
        this.order.tablename = this.tablename;
        this.order.type = 2;
        this.order.status = 'Paid';
        
        this.$http.post('orders/add', this.order).then(res => {});

        this.session.jf -= this.order.discounttotal;
        this.$http.post(`${this.userTableName}/update`, this.session).then(res => {});

        this.$message({
          message: 'Exchange succeeded',
          type: 'success',
          duration: 1500,
          onClose: () => {
            this.$router.push('/index/shop-order/order');
          }
        });
      },
      createOrder() {
        let order = '';
        let now = new Date();
        order += now.getFullYear();
        order += now.getMonth() + 1;
        order += now.getDate();
        order += now.getHours();
        order += now.getMinutes();
        order += now.getSeconds();
        order += now.getMilliseconds();

        return order;
      }
    },
    computed: {
      totalPrice() {
        let totalPrice = 0;
        this.tableData.forEach(item => {
          totalPrice += item.price * this.buyNum;
        });

        return totalPrice.toFixed(2);
      },
      totalJifen() {
        let totalJifen = 0;
        this.tableData.forEach(item => {
          totalJifen += item.price * 1;
        });

        return totalJifen;
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .section {
    width: 900px;
    margin: 0 auto;
  }

  .shangpin {
    display: flex;
  }
  .buy {
    text-align: right;
    padding-right: 82px;
  }
</style>
