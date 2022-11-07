<template>
<div :style='{"width":"1200px","padding":"20px","boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.302)","margin":"10px auto","position":"relative","background":"#fff"}'>
    <el-form
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="120px"
    >
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="Book Name" prop="tushumingcheng">
            <el-input v-model="ruleForm.tushumingcheng" 
                placeholder="Book Name" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}'  label="Book classification" prop="tushufenlei">
            <el-select v-model="ruleForm.tushufenlei" placeholder="Please select Book classification" >
              <el-option
                  v-for="(item,index) in tushufenleiOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="Book Cover" prop="tushufengmian">
            <file-upload
            tip="Click to upload the book cover"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.tushufengmian?ruleForm.tushufengmian:''"
            @change="tushufengmianUploadChange"
            ></file-upload>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="Book Author" prop="tushuzuozhe">
            <el-input v-model="ruleForm.tushuzuozhe" 
                placeholder="Book Author" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}'  label="Book quality" prop="tushuchengse">
            <el-select v-model="ruleForm.tushuchengse" placeholder="Please select Book quality" >
              <el-option
                  v-for="(item,index) in tushuchengseOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="Seller Number" prop="maijiaxuehao">
            <el-input v-model="ruleForm.maijiaxuehao" 
                placeholder="Seller Number" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="Seller Name" prop="maijiaxingming">
            <el-input v-model="ruleForm.maijiaxingming" 
                placeholder="Seller Name" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="Contact Telephone" prop="lianxidianhua">
            <el-input v-model="ruleForm.lianxidianhua" 
                placeholder="Contact Telephone" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="Single limit" prop="onelimittimes">
            <el-input v-model="ruleForm.onelimittimes" 
                placeholder="Single limit" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="stock" prop="alllimittimes">
            <el-input v-model="ruleForm.alllimittimes" 
                placeholder="stock" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="Price" prop="price">
            <el-input v-model="ruleForm.price" 
                placeholder="Price" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="Book Details" prop="tushuxiangqing">
            <editor 
                :style='{"padding":"0","margin":"0","borderColor":"1px solid rgba(197, 19, 19, 1)","backgroundColor":"#fff","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}'
                v-model="ruleForm.tushuxiangqing" 
                class="editor" 
                action="file/upload">
            </editor>
          </el-form-item>

      <el-form-item :style='{"padding":"0","margin":"0"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"rgba(197, 19, 19, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'  type="primary" @click="onSubmit">Submit</el-button>
        <el-button :style='{"border":"1px solid rgba(197, 19, 19, 1)","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"rgba(197, 19, 19, 1)","borderRadius":"4px","background":"rgba(255, 255, 255, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' @click="back()">Return</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
      return {
        id: '',
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          tushumingcheng: '',
          tushufenlei: '',
          tushufengmian: '',
          tushuzuozhe: '',
          tushuchengse: '',
          maijiaxuehao: '',
          maijiaxingming: '',
          lianxidianhua: '',
          tushuxiangqing: '',
          onelimittimes: '-1',
          alllimittimes: '-1',
        },
        tushufenleiOptions: [],
        tushuchengseOptions: [],
        rules: {
          tushumingcheng: [
            { required: true, message: 'Book Name cannot be empty', trigger: 'blur' },
          ],
          tushufenlei: [
            { required: true, message: 'Book classification cannot be empty', trigger: 'blur' },
          ],
          tushufengmian: [
            { required: true, message: 'Book Cover cannot be empty', trigger: 'blur' },
          ],
          tushuzuozhe: [
          ],
          tushuchengse: [
            { required: true, message: 'Book quality cannot be empty', trigger: 'blur' },
          ],
          maijiaxuehao: [
          ],
          maijiaxingming: [
          ],
          lianxidianhua: [
            { validator: this.$validate.isMobile, trigger: 'blur' },
          ],
          tushuxiangqing: [
          ],
          onelimittimes: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          alllimittimes: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          price: [
            { validator: this.$validate.isNumber, trigger: 'blur' },
          ],
        },
      };
    },
    computed: {
    },
    created() {
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
          for (var o in obj){
            if(o=='tushumingcheng'){
              this.ruleForm.tushumingcheng = obj[o];
              continue;
            }
            if(o=='tushufenlei'){
              this.ruleForm.tushufenlei = obj[o];
              continue;
            }
            if(o=='tushufengmian'){
              this.ruleForm.tushufengmian = obj[o];
              continue;
            }
            if(o=='tushuzuozhe'){
              this.ruleForm.tushuzuozhe = obj[o];
              continue;
            }
            if(o=='tushuchengse'){
              this.ruleForm.tushuchengse = obj[o];
              continue;
            }
            if(o=='maijiaxuehao'){
              this.ruleForm.maijiaxuehao = obj[o];
              continue;
            }
            if(o=='maijiaxingming'){
              this.ruleForm.maijiaxingming = obj[o];
              continue;
            }
            if(o=='lianxidianhua'){
              this.ruleForm.lianxidianhua = obj[o];
              continue;
            }
            if(o=='tushuxiangqing'){
              this.ruleForm.tushuxiangqing = obj[o];
              continue;
            }
            if(o=='onelimittimes'){
              this.ruleForm.onelimittimes = obj[o];
              continue;
            }
            if(o=='alllimittimes'){
              this.ruleForm.alllimittimes = obj[o];
              continue;
            }
            if(o=='price'){
              this.ruleForm.price = obj[o];
              continue;
            }
          }
        }
        // 获取user信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
            this.ruleForm.maijiaxuehao = json.maijiaxuehao
            this.ruleForm.maijiaxingming = json.maijiaxingming
            this.ruleForm.lianxidianhua = json.lianxidianhua
          }
        });
        this.$http.get('option/tushufenlei/tushufenlei', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.tushufenleiOptions = res.data.data;
          }
        });
        this.tushuchengseOptions = "New,90% new,80% new,70% new and below".split(',')
      },

    // 多级联动参数
      // 多级联动参数
      info(id) {
        this.$http.get('tushuxinxi/detail/${id}', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // Submit
      onSubmit() {

        //Update跨表属性
        var crossuserid;
        var crossrefid;
        var crossoptnum;
        this.$refs["ruleForm"].validate(valid => {
          if(valid) {
            if(this.type=='cross'){
                 var statusColumnName = localStorage.getItem('statusColumnName');
                 var statusColumnValue = localStorage.getItem('statusColumnValue');
                 if(statusColumnName!='') {
                     var obj = JSON.parse(localStorage.getItem('crossObj'));
                     if(!statusColumnName.startsWith("[")) {
                         for (var o in obj){
                             if(o==statusColumnName){
                                 obj[o] = statusColumnValue;
                             }
                         }
                         var table = localStorage.getItem('crossTable');
                         this.$http.post(table+'/update', obj).then(res => {});
                     } else {
                            crossuserid=Number(localStorage.getItem('userid'));
                            crossrefid=obj['id'];
                            crossoptnum=localStorage.getItem('statusColumnName');
                            crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                     }
                 }
            }
            if(crossrefid && crossuserid) {
                 this.ruleForm.crossuserid=crossuserid;
                 this.ruleForm.crossrefid=crossrefid;
                 var params = {
                     page: 1,
                     limit: 10,
                     crossuserid:crossuserid,
                     crossrefid:crossrefid,
                 }
                 this.$http.get('tushuxinxi/list', {
                  params: params
                 }).then(res => {
                     if(res.data.data.total>=crossoptnum) {
                         this.$message({
                          message: localStorage.getItem('tips'),
                          type: 'success',
                          duration: 1500,
                         });
                          return false;
                     } else {
                         // 跨表计算


                          this.$http.post('tushuxinxi/add', this.ruleForm).then(res => {
                              if (res.data.code == 0) {
                                  this.$message({
                                      message: 'Operation succeeded',
                                      type: 'success',
                                      duration: 1500,
                                      onClose: () => {
                                          this.$router.go(-1);
                                      }
                                  });
                              } else {
                                  this.$message({
                                      message: res.data.msg,
                                      type: 'error',
                                      duration: 1500
                                  });
                              }
                          });
                     }
                 });
             } else {


                  this.$http.post('tushuxinxi/add', this.ruleForm).then(res => {
                     if (res.data.code == 0) {
                          this.$message({
                              message: 'Operation succeeded',
                              type: 'success',
                              duration: 1500,
                              onClose: () => {
                                  this.$router.go(-1);
                              }
                          });
                      } else {
                          this.$message({
                              message: res.data.msg,
                              type: 'error',
                              duration: 1500
                          });
                      }
                  });
             }
          }
        });
      },
      // 获取uuid
      getUUID () {
        return new Date().getTime();
      },
      // Return
      back() {
        this.$router.go(-1);
      },
      tushufengmianUploadChange(fileUrls) {
          this.ruleForm.tushufengmian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #000;
	  font-weight: 500;
	  width: 120px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 120px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  border: 1px solid rgba(197, 19, 19, 1);
	  border-radius: 4px;
	  padding: 0 12px;
	  outline: none;
	  color: #333;
	  width: 350px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  border: 1px solid rgba(197, 19, 19, 1);
	  border-radius: 4px;
	  padding: 0 10px;
	  outline: none;
	  color: #333;
	  width: 200px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  border: 1px solid rgba(197, 19, 19, 1);
	  border-radius: 4px;
	  padding: 0 10px 0 30px;
	  outline: none;
	  color: #333;
	  width: 200px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  border: 1px dashed rgba(197, 19, 19, 1);
	  cursor: pointer;
	  border-radius: 6px;
	  color: #333;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  border: 1px dashed rgba(197, 19, 19, 1);
	  cursor: pointer;
	  border-radius: 6px;
	  color: #333;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  border: 1px dashed rgba(197, 19, 19, 1);
	  cursor: pointer;
	  border-radius: 6px;
	  color: #333;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 1px solid rgba(197, 19, 19, 1);
	  border-radius: 4px;
	  padding: 12px;
	  outline: none;
	  color: #333;
	  width: 400px;
	  font-size: 14px;
	  height: 120px;
	}
</style>
