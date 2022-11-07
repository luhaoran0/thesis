<template>
<div :style='{"width":"1200px","padding":"20px","boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.302)","margin":"10px auto","position":"relative","background":"#fff"}'>
    <div class="section-title" :style='{"border":"4px solid rgba(197, 19, 19, 1)","margin":"10px 0","fontSize":"20px","lineHeight":"54px","color":"#333","textAlign":"center"}'>Shop Cart</div>
    <el-table
      @selection-change="handleSelectionChange"
      :data="tableData"
      style="width: 100%">
      <el-table-column type="selection" width="50" align="center" />
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
          <span :style='{"fontSize":"12px"}'>￥</span>{{ scope.row.price }}
        </template>
      </el-table-column>
      <el-table-column
        label="Quantity">
        <template slot-scope="scope">
          <el-input-number :min="1" v-model="scope.row.buynumber" @change="(value) => handleChange(value, scope.$index, scope.row)" size="small"></el-input-number>
        </template>
      </el-table-column>
      <el-table-column
        label="Total price">
        <template slot-scope="scope">
          <span :style='{"fontSize":"12px"}'>￥</span>{{ (scope.row.price * scope.row.buynumber).toFixed(2) }}
        </template>
      </el-table-column>
      <el-table-column label=" operation" width="150">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)">Remove</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div class="buy" v-if="tableData.length > 0">
      <span style="color: red;margin-right: 10px;font-weight: 700;">Total price：<span :style='{"fontSize":"12px"}'>￥</span>{{totalPrice}}</span>
      <el-button
        type="warning"
        @click="buyClick">buy</el-button>
    </div>
</div>
</template>

<script>
  import config from '@/config/config'
  export default {
    data() {
      return {
        baseUrl: config.baseUrl,
        tableData: [],
        selRows:[]
      }
    },
    created() {
      this.getCartList();
    },
    methods: {
      handleSelectionChange(e){
          this.selRows = e
      },
      getCartList() {
        this.$http.get('cart/list', {params: {page: 1, limit: 1000, userid: localStorage.getItem('userid')}}).then(res => {
          if (res.data.code == 0) {
            this.tableData = res.data.data.list;
          }
        });
      },
      handleChange(value, index, row) {
        this.$http.get(`shangpinxinxi/detail/${row.goodid}`).then(res => {
          if (res.data.code == 0 && value > res.data.data.onelimittimes) {
            this.tableData[index].buynumber = --value;
            this.$message.error(`Each person can only buy  ${res.data.data.onelimittimes} pieces at a time`);
          }
          if (res.data.code == 0 && value <= res.data.data.onelimittimes) {
            row.buynumber = value;
            this.$http.post('cart/update', row).then(res => {});
          }
        });
      },
      handleDelete(index, row) {
        this.$confirm('Confirm Remove?', 'Tips', {
          confirmButtonText: 'Confirm',
          cancelButtonText: 'Cancel',
          type: 'warning'
        }).then(() => {
          let delIds = new Array();
          delIds.push(row.id);
          this.$http.post('cart/delete', delIds).then(res => {
            if (res.data.code == 0) {
              this.$message({
                type: 'success',
                message: 'Remove succeeded!',
                duration: 1500,
                onClose: () => {
                  this.getCartList();
                }
              });
            }
          });
        });
      },
      buyClick() {
        if(this.selRows.length==0) {
            this.$message({
                type: 'warning',
                message: 'Please select a product',
                duration: 1500,
            });
            return
        }
        localStorage.setItem('orderGoods', JSON.stringify(this.selRows));
        this.$router.push('/index/shop-order/orderConfirm');
      }
    },
    computed: {
      totalPrice() {
            let totalPrice = 0;
            for(let x in this.selRows){
                  totalPrice += Number(this.selRows[x].price) * Number(this.selRows[x].buynumber)
            }
            return totalPrice.toFixed(2);
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
