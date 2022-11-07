<template>
<div class="center-preview" :style='{"width":"1200px","margin":"10px auto","position":"relative","background":"#fff"}'>
	<div class="title" :style='{"border":"4px solid rgba(197, 19, 19, 1)","margin":"10px 0","fontSize":"20px","lineHeight":"54px","color":"#333","textAlign":"center"}'>{{ title }}</div>

    <el-tabs tab-position="left" :style='{"boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.302)","margin":"30px 0 30px","background":"#f5f5f5"}' @tab-click="handleClick">
      <el-tab-pane label="PersonCenter">
        <el-form class="center-preview-pv" ref="sessionForm" :model="sessionForm" :rules="rules" label-width="80px">
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' v-if="userTableName=='maijia'" label="Seller Number" prop="maijiaxuehao">
            <el-input v-model="sessionForm.maijiaxuehao" placeholder="Seller Number" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' v-if="userTableName=='maijia'" label="password" prop="mima">
            <el-input type="password" v-model="sessionForm.mima" placeholder="password"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' v-if="userTableName=='maijia'" label="Seller Name" prop="maijiaxingming">
            <el-input v-model="sessionForm.maijiaxingming" placeholder="Seller Name" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' v-if="userTableName=='maijia'" label="Gender">
            <el-select v-model="sessionForm.xingbie" placeholder="Please select gender" >
              <el-option v-for="(item, index) in dynamicProp.xingbie" :key="index" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' v-if="userTableName=='maijia'" label="Picture">
            <el-upload
              class="avatar-uploader"
              :action="uploadUrl"
              :headers="headers"
              :show-file-list="false"
              :on-success="zhaopianHandleAvatarSuccess">
              <img :style='{"border":"1px dashed rgba(197, 19, 19, 1)","cursor":"pointer","color":"#000","borderRadius":"6px","textAlign":"center","width":"100px","fontSize":"32px","lineHeight":"100px","height":"100px"}' v-if="sessionForm.zhaopian" :src="baseUrl + '/' + sessionForm.zhaopian" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' v-if="userTableName=='maijia'" label="Contact Telephone" prop="lianxidianhua">
            <el-input v-model="sessionForm.lianxidianhua" placeholder="Contact Telephone" ></el-input>
          </el-form-item>
          <el-form-item class="balance" :style='{"padding":"10px","margin":"0 0 10px"}' v-if="userTableName=='maijia'" label="balance">
            <div :style='{"flexWrap":"wrap","display":"flex"}'>
				<el-input v-model="sessionForm.money" placeholder="balance" readonly></el-input>
				<div @click="dialogFormVisibleMoney = true" :style='{"border":"0","cursor":"pointer","padding":"0 15px","margin":"0 20px 0 0","color":"rgba(255, 255, 255, 1)","display":"inline-block","outline":"none","borderRadius":"0","background":"rgba(197, 19, 19, 1)","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}'>recharge value</div>
			</div>
		  </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' v-if="userTableName=='yonghu'" label="Student ID" prop="xuehao">
            <el-input v-model="sessionForm.xuehao" placeholder="Student ID" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' v-if="userTableName=='yonghu'" label="password" prop="mima">
            <el-input type="password" v-model="sessionForm.mima" placeholder="password"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' v-if="userTableName=='yonghu'" label="Name" prop="xingming">
            <el-input v-model="sessionForm.xingming" placeholder="Name" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' v-if="userTableName=='yonghu'" label="Gender">
            <el-select v-model="sessionForm.xingbie" placeholder="Please select gender" >
              <el-option v-for="(item, index) in dynamicProp.xingbie" :key="index" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' v-if="userTableName=='yonghu'" label="head portrait">
            <el-upload
              class="avatar-uploader"
              :action="uploadUrl"
              :headers="headers"
              :show-file-list="false"
              :on-success="touxiangHandleAvatarSuccess">
              <img :style='{"border":"1px dashed rgba(197, 19, 19, 1)","cursor":"pointer","color":"#000","borderRadius":"6px","textAlign":"center","width":"100px","fontSize":"32px","lineHeight":"100px","height":"100px"}' v-if="sessionForm.touxiang" :src="baseUrl + '/' + sessionForm.touxiang" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' v-if="userTableName=='yonghu'" label="mobile phone" prop="shouji">
            <el-input v-model="sessionForm.shouji" placeholder="mobile phone" ></el-input>
          </el-form-item>
          <el-form-item class="balance" :style='{"padding":"10px","margin":"0 0 10px"}' v-if="userTableName=='yonghu'" label="balance">
            <div :style='{"flexWrap":"wrap","display":"flex"}'>
				<el-input v-model="sessionForm.money" placeholder="balance" readonly></el-input>
				<div @click="dialogFormVisibleMoney = true" :style='{"border":"0","cursor":"pointer","padding":"0 15px","margin":"0 20px 0 0","color":"rgba(255, 255, 255, 1)","display":"inline-block","outline":"none","borderRadius":"0","background":"rgba(197, 19, 19, 1)","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}'>recharge value</div>
			</div>
		  </el-form-item>
          <el-form-item :style='{"padding":"0","margin":"0"}'>
            <el-button :style='{"cursor":"pointer","padding":"0","margin":"0 20px 0 0","borderColor":"#c51313","color":"#c51313","outline":"none","borderRadius":"4px","background":"#fff","borderWidth":"7px 0","width":"128px","lineHeight":"40px","fontSize":"14px","borderStyle":"solid","height":"60px"}' type="primary" @click="onSubmit('sessionForm')">UpdateInfo</el-button>
            <el-button :style='{"cursor":"pointer","padding":"0","margin":"0","borderColor":"rgba(131, 131, 131, 1)","color":"#838383","outline":"none","borderRadius":"4px","background":"rgba(255, 255, 255, 1)","borderWidth":"7px 0","width":"128px","lineHeight":"40px","fontSize":"14px","borderStyle":"solid","height":"60px"}' type="danger" @click="logout">Log out</el-button>
          </el-form-item>
        </el-form>
		
        <el-dialog title="User recharge" :visible.sync="dialogFormVisibleMoney" width="726px" center>
          <el-form :model="chongzhiForm">
            <el-form-item label="Recharge amount" label-width="120px">
              <el-input type="number" v-model="chongzhiForm.money" autocomplete="off" placeholder="Recharge amount"></el-input>
            </el-form-item>
            <el-form-item label-width="120px">
              <el-radio-group v-model="chongzhiForm.radio">
                <el-radio style="margin-bottom: 30px" label="WeChat payment">
                  <el-image
                    style="width: 60px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/weixin.png')"
                    fit="fill"></el-image>
                    <span style="display: inline-block;margin-left: 10px">WeChat payment</span>
                </el-radio>
                <el-radio label="Alipay payment">
                  <el-image
                    style="width: 60px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/zhifubao.png')"
                    fit="fill"></el-image>
                    <span style="display: inline-block;margin-left: 10px">Alipay payment</span>
                </el-radio>
                <el-radio label="Economic construction payment in China">
                  <el-image
                    style="width: 120px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/jianshe.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="China Agricultural bank Payment">
                  <el-image
                    style="width: 126px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/nongye.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="Bank of China Payment">
                  <el-image
                    style="width: 140px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/zhongguo.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="Bank of Communications Payment">
                  <el-image
                    style="width: 120px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/jiaotong.png')"
                    fit="fill"></el-image>
                </el-radio>
              </el-radio-group>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisibleMoney = false">Cancel</el-button>
            <el-button type="primary" @click="chongzhi">Confirm recharge</el-button>
          </div>
        </el-dialog>
        <el-dialog title="Member purchase" :visible.sync="dialogFormVisibleVip" width="726px" center>
          <el-form :model="chongzhiForm">
            <el-form-item label="membership card" label-width="120px">
              <el-input readonly autocomplete="off" value="￥199/year"></el-input>
            </el-form-item>
            <el-form-item label-width="120px">
              <el-radio-group v-model="chongzhiForm.radio">
                <el-radio style="margin-bottom: 30px" label="WeChat payment">
                  <el-image
                    style="width: 60px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/weixin.png')"
                    fit="fill"></el-image>
                    <span style="display: inline-block;margin-left: 10px">WeChat payment</span>
                </el-radio>
                <el-radio label="Alipay payment">
                  <el-image
                    style="width: 60px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/zhifubao.png')"
                    fit="fill"></el-image>
                    <span style="display: inline-block;margin-left: 10px">Alipay payment</span>
                </el-radio>
                <el-radio label="Economic construction payment in China">
                  <el-image
                    style="width: 120px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/jianshe.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="China Agricultural bank Payment">
                  <el-image
                    style="width: 126px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/nongye.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="Bank of China">
                  <el-image
                    style="width: 140px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/zhongguo.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="Bank of Communications支付">
                  <el-image
                    style="width: 120px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/jiaotong.png')"
                    fit="fill"></el-image>
                </el-radio>
              </el-radio-group>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisibleVip = false">Cancel</el-button>
            <el-button type="primary" @click="chongzhivip">Confirm payment</el-button>
          </div>
        </el-dialog>
      </el-tab-pane>
      <el-tab-pane label="My Order"></el-tab-pane>
      <el-tab-pane label="My Address" name="MyAddress">
        <router-view></router-view>
      </el-tab-pane>
      <el-tab-pane label="My Collection"></el-tab-pane>
    </el-tabs>
</div>
</template>

<script>
  import config from '@/config/config'
  import Vue from 'vue'
  export default {
    //数据集合
    data() {
      return {
        title: 'PersonCenter',
        baseUrl: config.baseUrl,
        sessionForm: {},
        rules: {},
        chongzhiForm: {
          money: '',
          radio: ''
        },
        disabled: false,
        dialogFormVisibleMoney: false,
        dialogFormVisibleVip: false,
        uploadUrl: config.baseUrl + '/file/upload',
        imageUrl: '',
        headers: {Token: localStorage.getItem('Token')},
        userTableName: localStorage.getItem('UserTableName'),
        dynamicProp: {}
      }
    },
    created() {
      if ('maijia' == this.userTableName) {
        this.$set(this.sessionForm, 'maijiaxuehao', null);
      }
      if ('maijia' == this.userTableName) {
        this.$set(this.sessionForm, 'mima', null);
      }
      if ('maijia' == this.userTableName) {
        this.$set(this.sessionForm, 'maijiaxingming', null);
      }
      if ('maijia' == this.userTableName) {
        this.$set(this.sessionForm, 'xingbie', null);
      }
      if ('maijia' == this.userTableName) {
        this.$set(this.sessionForm, 'zhaopian', null);
      }
      if ('maijia' == this.userTableName) {
        this.$set(this.sessionForm, 'lianxidianhua', null);
      }
      if ('maijia' == this.userTableName) {
        this.$set(this.sessionForm, 'money', null);
      }
      if ('yonghu' == this.userTableName) {
        this.$set(this.sessionForm, 'xuehao', null);
      }
      if ('yonghu' == this.userTableName) {
        this.$set(this.sessionForm, 'mima', null);
      }
      if ('yonghu' == this.userTableName) {
        this.$set(this.sessionForm, 'xingming', null);
      }
      if ('yonghu' == this.userTableName) {
        this.$set(this.sessionForm, 'xingbie', null);
      }
      if ('yonghu' == this.userTableName) {
        this.$set(this.sessionForm, 'touxiang', null);
      }
      if ('yonghu' == this.userTableName) {
        this.$set(this.sessionForm, 'shouji', null);
      }
      if ('yonghu' == this.userTableName) {
        this.$set(this.sessionForm, 'money', null);
      }

      if ('maijia' == this.userTableName) {
        this.$set(this.rules, 'maijiaxuehao', [{ required: true, message: 'Please enter the Seller Number', trigger: 'blur' }]);
      }
      if ('maijia' == this.userTableName) {
        this.$set(this.rules, 'mima', [{ required: true, message: 'Please input a password', trigger: 'blur' }]);
      }
      if ('maijia' == this.userTableName) {
        this.$set(this.rules, 'maijiaxingming', [{ required: true, message: 'Please enter Seller Name', trigger: 'blur' }]);
      }
      if ('maijia' == this.userTableName) {
        this.$set(this.rules, 'lianxidianhua', [{ required: true, message: 'Please enter Contact Telephone', trigger: 'blur' }]);
      }
			if ('maijia' == this.userTableName) {
        this.$set(this.rules, 'lianxidianhua', [{ required: false, validator: this.$validate.isMobile, trigger: 'blur' }]);
      }
			if ('maijia' == this.userTableName) {
        this.$set(this.rules, 'money', [{ required: false, validator: this.$validate.isNumber, trigger: 'blur' }]);
      }
      if ('yonghu' == this.userTableName) {
        this.$set(this.rules, 'xuehao', [{ required: true, message: 'Please enter Student ID', trigger: 'blur' }]);
      }
      if ('yonghu' == this.userTableName) {
        this.$set(this.rules, 'mima', [{ required: true, message: 'Please input a password', trigger: 'blur' }]);
      }
      if ('yonghu' == this.userTableName) {
        this.$set(this.rules, 'xingming', [{ required: true, message: 'Please enter your name', trigger: 'blur' }]);
      }
			if ('yonghu' == this.userTableName) {
        this.$set(this.rules, 'shouji', [{ required: false, validator: this.$validate.isMobile, trigger: 'blur' }]);
      }
			if ('yonghu' == this.userTableName) {
        this.$set(this.rules, 'money', [{ required: false, validator: this.$validate.isNumber, trigger: 'blur' }]);
      }

      this.init();
      this.getSession();
    },
    //方法集合
    methods: {
      init() {
        if ('maijia' == this.userTableName) {
          this.dynamicProp.xingbie = 'Male,female'.split(',');
        }
        if ('yonghu' == this.userTableName) {
          this.dynamicProp.xingbie = 'Male,female'.split(',');
        }
      },
      getSession() {
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.sessionForm = res.data.data;
            localStorage.setItem('userid', res.data.data.id);
            if(res.data.data.vip) {
                localStorage.setItem('vip', res.data.data.vip);
            }
          }
        });
      },
      onSubmit(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
              if (res.data.code == 0) {
                this.$message({
                  message: 'Update succeeded',
                  type: 'success',
                  duration: 1500
                });
              }
            });
          } else {
            return false;
          }
        });
      },
      zhaopianHandleAvatarSuccess(res, file) {
        if (res.code == 0) {
          if ('maijia' == this.userTableName) {
            this.sessionForm.zhaopian = 'upload/' + res.file;
          }
        }
      },
      touxiangHandleAvatarSuccess(res, file) {
        if (res.code == 0) {
          if ('yonghu' == this.userTableName) {
            this.sessionForm.touxiang = 'upload/' + res.file;
          }
        }
      },
      chongzhi() {
        if (this.chongzhiForm.money == '') {
          this.$message({
            message: 'Please enter Recharge amount',
            type: 'error',
            duration: 1500
          });
          return;
        }
        if (this.chongzhiForm.radio == '') {
          this.$message({
            message: 'Please select a recharge method',
            type: 'error',
            duration: 1500
          });
          return;
        }
        this.sessionForm.money = parseInt(this.sessionForm.money) + parseInt(this.chongzhiForm.money);
        this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
          if (res.data.code == 0) {
            this.$message({
              message: 'Recharge succeeded',
              type: 'success',
              duration: 1500,
              onClose: () => {
                this.dialogFormVisibleMoney = false;
              }
            });
          }
        });
      },
      chongzhivip() {
        this.chongzhiForm.money == 199;
        if (this.chongzhiForm.radio == '') {
          this.$message({
            message: 'Please select a payment method',
            type: 'error',
            duration: 1500
          });
          return;
        }
        if(this.sessionForm.vip == 'Yes') {
          this.$message({
            message: 'You are already our valued member.',
            type: 'success',
            duration: 1500
          });
          return;
        }
        
        this.sessionForm.vip = "Yes"
        this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
          if (res.data.code == 0) {
            this.$message({
              message: 'Member purchase succeeded',
              type: 'success',
              duration: 1500,
              onClose: () => {
                localStorage.setItem('vip', this.sessionForm.vip);
                this.dialogFormVisibleVip = false;
              }
            });
          }
        });
      },
      handleClick(tab, event) {
        switch(event.target.outerText) {
          case 'PersonCenter':
            tab.$router.push('/index/center');
            break;
          case 'My Address':
            tab.$router.push('/index/shop-address/list');
            break;
          case 'My Post':
            tab.$router.push('/index/myForumList');
            break;
          case 'Examination record':
            tab.$router.push('/index/examList');
            break;
          case 'Wrong title book':
            tab.$router.push('/index/examRecord/0');
            break;
          case 'My Collection':
            tab.$router.push('/index/storeup');
            break;
          case 'My Order':
            tab.$router.push('/index/shop-order/order');
            break;
        }

        this.title = event.target.outerText;
      },
      logout() {
        localStorage.clear();
        Vue.http.headers.common['Token'] = "";
        this.$router.push('/index/home');
        this.activeIndex = '0'
        localStorage.setItem('keyPath', this.activeIndex)
        this.$forceUpdate()
        this.$message({
            message: 'Logout succeeded',
            type: 'success',
            duration: 1500,
        });
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .center-preview {
  
    .el-tabs {
      & /deep/ .el-tabs__header {
        .el-tabs__nav-wrap {
          margin: 0;
  
          &::after {
            content: none;
          }
        }
  
        .el-tabs__active-bar {
          display: none !important;
        }
      }
  
      .center-preview-pv {
        .el-date-editor.el-input {
          width: auto;
        }
  
        .balance {
          .el-input {
            width: auto;
          }
        }
      }
    }
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header {
	padding: 0;
	margin: 0;
	background: #eeeeee;
	width: 180px;
	border-color: #eee;
	border-width: 0 1px 0 0;
	position: relative;
	float: left;
	border-style: solid;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item {
  	padding: 0 10px;
  	margin: 0 0 10px;
  	color: #333;
  	font-weight: 500;
  	font-size: 14px;
  	border-color: rgba(130, 130, 130, 1);
  	line-height: 50px;
  	background: #f5f5f5;
  	border-width: 5px 0;
  	position: relative;
  	border-style: solid;
  	text-align: center;
  	height: 50px;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item:hover {
  	padding: 0 10px;
  	margin: 0 0 10px;
  	color: #000;
  	background: #eeeeee;
  	font-weight: 500;
  	font-size: 14px;
  	line-height: 50px;
  	position: relative;
  	text-align: center;
  	height: 50px;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item.is-active {
  	padding: 0 10px;
  	margin: 0 0 10px;
  	color: rgba(197, 19, 19, 1);
  	font-weight: 500;
  	font-size: 14px;
  	border-color: rgba(197, 19, 19, 1);
  	line-height: 50px;
  	background: #eeeeee;
  	border-width: 5px 0;
  	position: relative;
  	border-style: solid;
  	text-align: center;
  	height: 50px;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__content .el-tab-pane {
  	padding: 20px;
  	background: #fff;
  }
  
  .center-preview-pv .el-form-item /deep/ .el-form-item__label {
  	padding: 0 10px 0 0;
  	color: #666;
  	font-weight: 500;
  	width: 80px;
  	font-size: 14px;
  	line-height: 40px;
  	text-align: right;
  }
  
  .center-preview-pv .el-form-item .el-form-item__content {
    margin-left: 80px;
  }
  
  .center-preview-pv .el-input /deep/ .el-input__inner {
  	border: 1px solid rgba(197, 19, 19, 1);
  	border-radius: 4px;
  	padding: 0 12px;
  	outline: none;
  	color: #000;
  	width: 200px;
  	font-size: 14px;
  	height: 40px;
  }
  
  .center-preview-pv .el-select /deep/ .el-input__inner {
  	border: 1px solid rgba(197, 19, 19, 1);
  	border-radius: 4px;
  	padding: 0 12px;
  	outline: none;
  	color: #000;
  	width: 200px;
  	font-size: 14px;
  	height: 40px;
  }
  
  .center-preview-pv .el-date-editor /deep/ .el-input__inner {
  	border: 1px solid rgba(197, 19, 19, 1);
  	border-radius: 4px;
  	padding: 0 10px 0 30px;
  	outline: none;
  	color: #000;
  	width: 200px;
  	font-size: 14px;
  	height: 40px;
  }
  
  .center-preview-pv /deep/ .avatar-uploader-icon {
  	border: 1px dashed rgba(197, 19, 19, 1);
  	cursor: pointer;
  	border-radius: 6px;
  	color: #000;
  	width: 100px;
  	font-size: 32px;
  	line-height: 100px;
  	text-align: center;
  	height: 100px;
  }
  
  .center-preview-pv .el-form-item.balance /deep/ .el-input__inner {
  	border: 1px solid rgba(197, 19, 19, 1);
  	border-radius: 0;
  	padding: 0 12px;
  	outline: none;
  	color: #000;
  	display: inline-block;
  	width: 200px;
  	font-size: 14px;
  	height: 40px;
  }
</style>
