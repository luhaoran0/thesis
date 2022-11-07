<template>
  <div :style='{"width":"1200px","padding":"20px","boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.302)","margin":"10px auto","position":"relative","background":"#fff"}'>
    <div class="section-title" :style='{"border":"4px solid rgba(197, 19, 19, 1)","margin":"10px 0","fontSize":"20px","lineHeight":"54px","color":"#333","textAlign":"center"}'>Confirm order</div>
    <el-descriptions title="select收货Address"></el-descriptions>
    <el-table
      :data="addressList"
      style="width: 100%;padding: 0 10px;">
      <el-table-column
        label="select"
        width="55">
        <template slot-scope="scope">
          <el-radio
            v-model="radio"
            :label="scope.$index"
            @change.native="getCurrentRow(scope.$index)">
            &nbsp;</el-radio>
        </template>
      </el-table-column>
      <el-table-column
        label="addressee"
        prop="name">
      </el-table-column>
      <el-table-column
        label="contact info"
        prop="phone">
      </el-table-column>
      <el-table-column
        label="Address"
        prop="address">
      </el-table-column>
    </el-table>
    <el-descriptions title="List"></el-descriptions>
    <el-table
      :data="tableData"
      style="width: 100%">
      <el-table-column
        label="Product Name">
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
          <span v-else><span :style='{"fontSize":"12px"}'>￥</span>{{ scope.row.price }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="quantity">
        <template slot-scope="scope">
          <span>{{ scope.row.buynumber }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="Total price">
        <template slot-scope="scope">
          <span v-if="type == 2">{{ scope.row.price * scope.row.buynumber }} integral</span>
          <span v-else><span :style='{"fontSize":"12px"}'>￥</span>{{ (scope.row.price * scope.row.buynumber).toFixed(2) }}</span>
        </template>
      </el-table-column>
    </el-table>
    <div style="width: 100%;padding: 12px;box-sizing: border-box;display: flex;align-items: center;">
        <span style="width: 80px; font-size: 14px;">Remarks：</span><el-input type="textarea" v-model="remark" placeholder="Remarks" style="width: calc(100% - 80px);"></el-input>
    </div>
    <div class="buy" v-if="tableData.length > 0">
      <template v-if="type == 2">
        <span style="color: red;margin-right: 10px;font-weight: 700;">Total price：{{totalPrice}} integral</span>
        <el-button type="warning" @click="jfClick">exchange</el-button>
      </template>
      <template v-else>
        <span style="color: red;margin-right: 10px;font-weight: 700;">Total price：<span :style='{"fontSize":"12px"}'>￥</span>{{totalPrice}}</span>
        <el-button type="success" @click="payClick">Balance payment</el-button>
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
        addressList: [],
        tableData: [],
        currentRow: null,
        radio: -1,
        order: {
          address: "",
          buynumber: 0,
          consignee: '',
          discountprice: 0,
          discounttotal: 0,
          goodid: 0,
          goodname: "",
          maijiaxuehao : "",
          orderid: "",
          picture: "",
          price: 0,
          status: "Unpaid",
          tablename: "",
          tel: "",
          total: 0,
          type: 1,
          userid: localStorage.getItem('userid')
        },
        user: {},
        type: 0,
        buynumber: 0,
        remark:''
      }
    },
    created() {
      if (this.$route.query.type != undefined) {
        this.type = this.$route.query.type;
      }
      if (this.$route.query.tablename != undefined) {
        this.order.tablename = this.$route.query.tablename;
      }

      this.getSession();
      this.getAddrList();
      // 获取porduct购买的List
      var orderGoods = localStorage.getItem('orderGoods')
      // 转换成json类型，localstorageSave的Yesstring数据
      this.tableData = JSON.parse(orderGoods);
      this.type = this.$route.query.type;
    },
    methods: {
      getSession() {
        this.$http.get(`${this.userTableName}/session`, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.user = res.data.data;
          }
        });
      },
      getCurrentRow(index) {
        this.radio = index;　
      },
      getAddrList() {
        this.$http.get('address/list', {params: {userid: localStorage.getItem('userid')}}).then(res => {
          if (res.data.code == 0) {
            this.addressList = res.data.data.list;
            this.addressList.forEach((item, index) => {
              if (item.isdefault == 'Yes') {
                this.radio = index;
              }
            });
          }
        });
      },
      getCartList() {
        this.$http.get('cart/list', {params: {page: 1, limit: 1000, userid: localStorage.getItem('userid')}}).then(res => {
          if (res.data.code == 0) {
            this.tableData = res.data.data.list;
            if (this.$route.query.id != undefined || this.$route.query.type != undefined) {
              this.tableData = [];
              this.buynumber = this.$route.query.buynumber;
              let detailObj = JSON.parse(this.$route.query.detailObj);
              this.order.tablename = this.$route.query.tablename;
              if (this.$route.query.type == 1) {
                this.tableData.push({
                  buynumber: this.buynumber,
                  goodid: detailObj.id,
                  picture: this.$route.query.picture,
                  goodname: this.$route.query.goodname,
                  tablename: this.$route.query.tablename,
                  userid: localStorage.getItem('userid'),
                  price: this.$route.query.price
                });
              }
              if (this.$route.query.type == 2) {
                this.tableData.push({
                  buynumber: this.buynumber,
                  goodid: detailObj.id,
                  picture: this.$route.query.picture,
                  goodname: this.$route.query.goodname,
                  tablename: this.$route.query.tablename,
                  userid: localStorage.getItem('userid'),
                  jf: detailObj.jf
                });
              }
            }
          }
        });
      },
      handleChange(value, index, goodid) {
        this.$http.get(`${this.order.tablename}/detail/${goodid}`).then(res => {
          if (res.data.code == 0 && value > res.data.data.onelimittimes) {
            this.tableData[index].buynumber = --value;
            this.$message.error(`Each person can only buy one time ${res.data.data.onelimittimes}件`);
          }
        });
      },
        // 正常下单，生成Order，减少balance，Addintegral，减少stock，UpdateStatusPaid
        payClick() {
            if (this.radio == -1) {
              this.$message({
                message: 'Please select the receiving address',
                type: 'error',
                duration: 1500
              });
              return;
            }

            // 生成Order
            this.tableData.forEach(item => {
                // 获取porductDetails info
                this.$http.get(`${item.tablename}/info/${item.goodid}`).then(res => {
                    // Order Number
                    var orderId = this.createOrder();
                    let data = res.data.data;
                    data.alllimittimes = data.alllimittimes - item.buynumber;
                    // Updatestock信息
                    this.$http.post(`${item.tablename}/update`, data).then(res => {
                        // AddOrder信息
                        let order = {
                            orderid: orderId,
                            tablename: item.tablename,
                            userid: this.user.id,
                            goodid: item.goodid,
                            goodname: item.goodname,
                            maijiaxuehao: item.maijiaxuehao,
                            picture: item.picture,
                            buynumber: item.buynumber,
                            discountprice: item.price,
                            price: item.price,
                            total: item.price * item.buynumber,
                            discounttotal: item.price * item.buynumber,
                            type: this.type?this.type:1,
                            //total: this.totalPrice,
                            address: this.addressList[this.radio].address,
                            tel: this.addressList[this.radio].phone,
                            consignee: this.addressList[this.radio].name,
                            remark: this.remark,
                            status: 'Unpaid'
                        }
                        this.$http.post('orders/add', order).then(res => {
                            // 减少balance，UpdateOrderStatus
                            // 判断balance是否充足
                            if (this.user.money < Number(item.price * item.buynumber)) {
                                this.$message({
                                    message: 'Insufficient balance, please recharge first',
                                    type: 'error',
                                    duration: 1500
                                });
                                return
                            }
                            // 如果该porduct存在integral
                            if (data.jf) {
                                this.user.jf = Number(this.user.jf) + Number(item.price * item.buynumber);
                            }
                            this.user.money = this.user.money - item.price * item.buynumber;
                            // Updateuserbalance
                            this.$http.post(`${this.userTableName}/update`, this.user).then(res => {
                                order.status = 'Paid'
                                var params = {
                                    orderid: orderId,
                                    page: 1,
                                    limit: 1,
                                }
                                this.$http.get('orders/list', {params: params}).then(res => {
                                    order.id = res.data.data.list[0].id;
                                    this.$http.post(`orders/update`, order).then(res => {
                                        // RemoveShop Cart数据(如果YesShop Cart下单)
                                        if (item.id) {
                                            this.$http.post('cart/delete', [item.id]).then(res => {});
                                        }
                                        this.$message({
                                              message: 'Purchase succeeded',
                                              type: 'success',
                                              duration: 1500,
                                              onClose: () => {
                                                this.$router.push('/index/shop-order/order');
                                              }
                                        });
                                    });
                                });
                            });
                        });
                    });
                });
            });
        },

        // integralexchange，生成Order，减少userintegral，减少stock
        jfClick() {
            if (this.radio == -1) {
              this.$message({
                message: 'Please select the receiving address',
                type: 'error',
                duration: 1500
              });
              return;
            }

            // 生成Order
            this.tableData.forEach(item => {
                // Order Number
                var orderId = this.createOrder();
                this.$http.get(`${item.tablename}/info/${item.goodid}`).then(res => {
                    let data = res.data.data;
                    // 减少stock
                    data.alllimittimes = data.alllimittimes - item.buynumber;
                    // Updatestock信息
                    this.$http.post(`${item.tablename}/update`, data).then(res => {
                        // 判断integral是否充足
                        if (this.user.jf < this.totalPrice) {
                            this.$message({
                                message: 'Insufficient integer, exchange failed',
                                type: 'error',
                                duration: 1500
                            });
                            return
                        }
                        // AddOrder信息
                        let order = {
                            orderid: orderId,
                            tablename: item.tablename,
                            userid: this.user.id,
                            goodid: item.goodid,
                            goodname: item.goodname,
                            maijiaxuehao: item.maijiaxuehao,
                            picture: item.picture,
                            buynumber: item.buynumber,
                            discountprice: item.price,
                            price: item.price,
                            total: item.price * item.buynumber,
                            discounttotal: item.price * item.buynumber,
                            type: 2,
                            total: this.totalPrice,
                            address: this.addressList[this.radio].address,
                            tel: this.addressList[this.radio].phone,
                            consignee: this.addressList[this.radio].name,
                            status: 'Paid'
                        }
                        this.$http.post('orders/add', order).then(res => {
                            this.user.jf = this.user.jf - item.price * item.buynumber;
                            // Updateuserbalance
                            this.$http.post(`${this.userTableName}/update`, this.user).then(res => {
                                this.$message({
                                      message: 'Exchange succeeded',
                                      type: 'success',
                                      duration: 1500,
                                      onClose: () => {
                                        this.$router.push('/index/shop-order/order');
                                      }
                                });
                            });
                        });
                    });
                });
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
            totalPrice += item.price * item.buynumber;
        });

        return totalPrice.toFixed(2);
      },
      totalJifen() {
        let totalJifen = 0;
        this.tableData.forEach(item => {
          totalJifen += item.jf * this.buynumber;
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
