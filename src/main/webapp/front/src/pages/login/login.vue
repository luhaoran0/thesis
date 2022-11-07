<template>
  <div>
    <div
      class="container"
      :style="{
        minHeight: '100vh',
        alignItems: 'center',
        background:
          'url(http://codegen.caihongy.cn/20220831/6f3cdb13342d476e8d5bfcef84f31c4d.png)',
        display: 'flex',
        width: '100%',
        backgroundSize: 'cover',
        backgroundPosition: '100% 100%',
        backgroundRepeat: 'no-repeat',
        justifyContent: 'center',
      }"
    >
      <el-form
        ref="loginForm"
        :model="loginForm"
        :style="{
          padding: '40px 20px 20px',
          margin: '0',
          borderRadius: '50px',
          background: '#fff',
          width: '640px',
          position: 'relative',
          height: '477px',
        }"
        :rules="rules"
      >
        <div
          v-if="false"
          :style="{
            margin: '0 0 10px 0',
            color: 'rgba(64, 158, 255, 1)',
            textAlign: 'center',
            width: '100%',
            lineHeight: '44px',
            fontSize: '20px',
            textShadow: '4px 4px 2px rgba(64, 158, 255, .5)',
          }"
        >
          USER / LOGIN
        </div>
        <div
          v-if="true"
          :style="{
            margin: '0 0 10px 0',
            color: 'rgba(0, 0, 0, 1)',
            textAlign: 'center',
            width: '100%',
            lineHeight: '44px',
            fontSize: '20px',
            fontWeight: '600',
          }"
        >
          Campus second-hand book trading system Sign in
        </div>
        <el-form-item
          class="list-item"
          :style="{ width: '40%', margin: '0 auto 10px' }"
          prop="username"
        >
          <div
            v-if="false"
            :style="{
              width: '64px',
              lineHeight: '44px',
              fontSize: '14px',
              color: 'rgba(64, 158, 255, 1)',
            }"
          >
            account :
          </div>
          <input
            :style="{
              border: '1px solid rgba(216, 216, 216, 1)',
              padding: '0 10px',
              color: '#000',
              outlineOffset: '4px',
              background: 'rgba(249, 249, 249, 1)',
              width: '100%',
              fontSize: '14px',
              height: '44px',
            }"
            v-model="loginForm.username"
            placeholder="Please enter the account"
          />
        </el-form-item>
        <el-form-item
          class="list-item"
          :style="{ width: '40%', margin: '0 auto 10px' }"
          prop="password"
        >
          <div
            v-if="false"
            :style="{
              width: '64px',
              lineHeight: '44px',
              fontSize: '14px',
              color: 'rgba(64, 158, 255, 1)',
            }"
          >
            password：
          </div>
          <input
            :style="{
              border: '1px solid rgba(216, 216, 216, 1)',
              padding: '0 10px',
              color: '#000',
              outlineOffset: '4px',
              background: 'rgba(249, 249, 249, 1)',
              width: '100%',
              fontSize: '14px',
              height: '44px',
            }"
            v-model="loginForm.password"
            placeholder="Please input a password"
            type="password"
          />
        </el-form-item>
        <el-form-item
          v-if="roles.length > 1"
          class="list-type"
          :style="{ width: '80%', textAlign: 'center', margin: '20px auto' }"
          prop="role"
        >
          <el-radio
            v-model="loginForm.tableName"
            :label="item.tableName"
            v-for="(item, index) in roles"
            :key="index"
            @change.native="getCurrentRow(item)"
            >{{ item.roleName }}</el-radio
          >
        </el-form-item>
        <el-form-item
          :style="{ width: '80%', padding: '0px 0 0 0', margin: '0 auto' }"
        >
          <el-button
            :style="{
              border: '0',
              cursor: 'pointer',
              padding: '0 24px',
              margin: '0 auto',
              color: '#fff',
              display: 'block',
              outline: 'none',
              borderRadius: '30px 30px 0px 0px',
              top: '83px',
              left: '90px',
              background: 'rgba(197, 19, 19, 1)',
              width: '300px',
              fontSize: '20px',
              position: 'absolute',
              height: '59px',
            }"
            @click="submitForm('loginForm')"
            >Sign in</el-button
          >
          <el-button
            :style="{
              border: '0',
              cursor: 'pointer',
              padding: '0 24px',
              margin: '0 5px',
              color: '#fff',
              display: 'none',
              right: '0',
              outline: 'none',
              borderRadius: '20px 20px 0px 0px',
              top: '97px',
              background: 'rgba(197, 19, 19, 1)',
              width: 'auto',
              fontSize: '14px',
              position: 'absolute',
              height: '44px',
            }"
            @click="resetForm('loginForm')"
            >Reset</el-button
          >
        </el-form-item>
        <div :style="{ width: '100%', textAlign: 'center', margin: '0 auto' }">
          <router-link
            :style="{
              cursor: 'pointer',
              padding: '4px 10px',
              margin: '0 2px',
              color: 'rgba(255, 255, 255, 1)',
              textAlign: 'center',
              background: 'rgba(130, 130, 130, 1)',
              width: '90px',
              fontSize: '14px',
              lineHeight: '20px',
            }"
            :to="{
              path: '/register',
              query: { role: item.tableName, pageFlag: 'register' },
            }"
            v-for="(item, index) in roles"
            :key="index"
            >register{{ item.roleName.replace("register", "") }}</router-link
          >
        </div>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  //数据集合
  data() {
    return {
      roleMenus: [
        {
          backMenu: [
            {
              child: [
                {
                  appFrontIcon: "cuIcon-copy",
                  buttons: ["Add", "View", "Update", "Remove"],
                  menu: "seller",
                  menuJump: "list",
                  tableName: "maijia",
                },
              ],
              menu: "Seller management",
            },
            {
              child: [
                {
                  appFrontIcon: "cuIcon-similar",
                  buttons: ["Add", "View", "Update", "Remove"],
                  menu: "user",
                  menuJump: "list",
                  tableName: "yonghu",
                },
              ],
              menu: "User management",
            },
            {
              child: [
                {
                  appFrontIcon: "cuIcon-skin",
                  buttons: ["Add", "View", "Update", "Remove"],
                  menu: "Book classification",
                  menuJump: "list",
                  tableName: "tushufenlei",
                },
              ],
              menu: "BookType manage",
            },
            {
              child: [
                {
                  appFrontIcon: "cuIcon-cardboard",
                  buttons: ["View", "Update", "Remove"],
                  menu: "Book information",
                  menuJump: "list",
                  tableName: "tushuxinxi",
                },
              ],
              menu: "BookInfo manage",
            },
            {
              child: [
                {
                  appFrontIcon: "cuIcon-discover",
                  buttons: ["View", "Update", "Remove"],
                  menu: "Chat record",
                  menuJump: "list",
                  tableName: "liaotianjilu",
                },
              ],
              menu: "Chat record manage",
            },
            {
              child: [
                {
                  appFrontIcon: "cuIcon-pay",
                  buttons: ["View", "Update"],
                  menu: "Rotation chart",
                  tableName: "config",
                },
                {
                  appFrontIcon: "cuIcon-news",
                  buttons: ["Add", "View", "Update", "Remove"],
                  menu: "Notice information",
                  tableName: "news",
                },
              ],
              menu: "System manage",
            },
          ],
          frontMenu: [
            {
              child: [
                {
                  appFrontIcon: "cuIcon-pay",
                  buttons: ["View", "Consultation chat"],
                  menu: "Book informationlist",
                  menuJump: "list",
                  tableName: "tushuxinxi",
                },
              ],
              menu: "Book information模块",
            },
          ],
          hasBackLogin: "Yes",
          hasBackRegister: "No",
          hasFrontLogin: "No",
          hasFrontRegister: "No",
          roleName: "administrators",
          tableName: "users",
        },
        {
          backMenu: [
            {
              child: [
                {
                  appFrontIcon: "cuIcon-cardboard",
                  buttons: ["Add", "View", "Update", "Remove", "View Comments"],
                  menu: "Book information",
                  menuJump: "list",
                  tableName: "tushuxinxi",
                },
              ],
              menu: "BookInfo manage",
            },
            {
              child: [
                {
                  appFrontIcon: "cuIcon-discover",
                  buttons: ["View", "Examined"],
                  menu: "Chat record",
                  menuJump: "list",
                  tableName: "liaotianjilu",
                },
              ],
              menu: "Chat record manage",
            },
            {
              child: [
                {
                  appFrontIcon: "cuIcon-goods",
                  buttons: ["View"],
                  menu: "ShippedOrder",
                  tableName: "orders/Shipped",
                },
                {
                  appFrontIcon: "cuIcon-qrcode",
                  buttons: ["View"],
                  menu: "UnpaidOrder",
                  tableName: "orders/Unpaid",
                },
                {
                  appFrontIcon: "cuIcon-phone",
                  buttons: ["View", "Deliver goods"],
                  menu: "PaidOrder",
                  tableName: "orders/Paid",
                },
                {
                  appFrontIcon: "cuIcon-list",
                  buttons: ["View", "品销额"],
                  menu: "Completed Order",
                  tableName: "orders/Completed",
                },
                {
                  appFrontIcon: "cuIcon-form",
                  buttons: ["View"],
                  menu: "Canceled Order",
                  tableName: "orders/Canceled",
                },
                {
                  appFrontIcon: "cuIcon-vipcard",
                  buttons: ["View"],
                  menu: "RefundedOrder",
                  tableName: "orders/Refunded",
                },
              ],
              menu: "Order management",
            },
          ],
          frontMenu: [
            {
              child: [
                {
                  appFrontIcon: "cuIcon-pay",
                  buttons: ["View", "Consultation chat"],
                  menu: "Book informationlist",
                  menuJump: "list",
                  tableName: "tushuxinxi",
                },
              ],
              menu: "Book information模块",
            },
          ],
          hasBackLogin: "Yes",
          hasBackRegister: "Yes",
          hasFrontLogin: "No",
          hasFrontRegister: "No",
          roleName: "seller",
          tableName: "maijia",
        },
        {
          backMenu: [
            {
              child: [
                {
                  appFrontIcon: "cuIcon-discover",
                  buttons: ["View"],
                  menu: "Chat record",
                  menuJump: "list",
                  tableName: "liaotianjilu",
                },
              ],
              menu: "Chat record manage",
            },
            {
              child: [
                {
                  appFrontIcon: "cuIcon-favor",
                  buttons: ["View"],
                  menu: "My Collection manage",
                  tableName: "storeup",
                },
              ],
              menu: "My Collection manage",
            },
          ],
          frontMenu: [
            {
              child: [
                {
                  appFrontIcon: "cuIcon-pay",
                  buttons: ["View", "Consultation chat"],
                  menu: "Book informationlist",
                  menuJump: "list",
                  tableName: "tushuxinxi",
                },
              ],
              menu: "Book information模块",
            },
          ],
          hasBackLogin: "Yes",
          hasBackRegister: "No",
          hasFrontLogin: "Yes",
          hasFrontRegister: "Yes",
          roleName: "user",
          tableName: "yonghu",
        },
      ],
      loginForm: {
        username: "",
        password: "",
        tableName: "",
        code: "",
      },
      role: "",
      roles: [],
      rules: {
        username: [
          {
            required: true,
            message: "Please enter the account",
            trigger: "blur",
          },
        ],
        password: [
          {
            required: true,
            message: "Please input a password",
            trigger: "blur",
          },
        ],
      },
      codes: [
        {
          num: 1,
          color: "#000",
          rotate: "10deg",
          size: "16px",
        },
        {
          num: 2,
          color: "#000",
          rotate: "10deg",
          size: "16px",
        },
        {
          num: 3,
          color: "#000",
          rotate: "10deg",
          size: "16px",
        },
        {
          num: 4,
          color: "#000",
          rotate: "10deg",
          size: "16px",
        },
      ],
    };
  },
  created() {
    for (let item in this.roleMenus) {
      if (this.roleMenus[item].hasFrontLogin == "Yes") {
        this.roles.push(this.roleMenus[item]);
      }
    }
  },
  mounted() {},
  //方法集合
  methods: {
    randomString() {
      var len = 4;
      var chars = [
        "a",
        "b",
        "c",
        "d",
        "e",
        "f",
        "g",
        "h",
        "i",
        "j",
        "k",
        "l",
        "m",
        "n",
        "o",
        "p",
        "q",
        "r",
        "s",
        "t",
        "u",
        "v",
        "w",
        "x",
        "y",
        "z",
        "A",
        "B",
        "C",
        "D",
        "E",
        "F",
        "G",
        "H",
        "I",
        "J",
        "K",
        "L",
        "M",
        "N",
        "O",
        "P",
        "Q",
        "R",
        "S",
        "T",
        "U",
        "V",
        "W",
        "X",
        "Y",
        "Z",
        "0",
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
      ];
      var colors = [
        "0",
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "a",
        "b",
        "c",
        "d",
        "e",
        "f",
      ];
      var sizes = ["14", "15", "16", "17", "18"];

      var output = [];
      for (var i = 0; i < len; i++) {
        // 随机验证码
        var key = Math.floor(Math.random() * chars.length);
        this.codes[i].num = chars[key];
        // 随机验证码颜色
        var code = "#";
        for (var j = 0; j < 6; j++) {
          var key = Math.floor(Math.random() * colors.length);
          code += colors[key];
        }
        this.codes[i].color = code;
        // 随机验证码方向
        var rotate = Math.floor(Math.random() * 45);
        var plus = Math.floor(Math.random() * 2);
        if (plus == 1) rotate = "-" + rotate;
        this.codes[i].rotate = "rotate(" + rotate + "deg)";
        // 随机验证码字体大小
        var size = Math.floor(Math.random() * sizes.length);
        this.codes[i].size = sizes[size] + "px";
      }
    },
    getCurrentRow(row) {
      this.role = row.roleName;
    },
    submitForm(formName) {
      if (this.roles.length != 1) {
        if (!this.role) {
          this.$message.error("Please select Sign in user type");
          return false;
        }
      } else {
        this.role = this.roles[0].roleName;
        this.loginForm.tableName = this.roles[0].tableName;
      }
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$http
            .get(`${this.loginForm.tableName}/login`, {
              params: this.loginForm,
            })
            .then((res) => {
              if (res.data.code === 0) {
                localStorage.setItem("Token", res.data.token);
                localStorage.setItem("UserTableName", this.loginForm.tableName);
                localStorage.setItem("username", this.loginForm.username);
                localStorage.setItem("adminName", this.loginForm.username);
                localStorage.setItem("sessionTable", this.loginForm.tableName);
                localStorage.setItem("role", this.role);
                localStorage.setItem(
                  "keyPath",
                  this.$config.indexNav.length + 2
                );
                this.$router.push("/index/center");
                this.$message({
                  message: "Sign in succeeded",
                  type: "success",
                  duration: 1500,
                });
              } else {
                this.$message.error(res.data.msg);
              }
            });
        } else {
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
  },
};
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.container {
  position: relative;
  background: url(http://codegen.caihongy.cn/20220831/6f3cdb13342d476e8d5bfcef84f31c4d.png);

  .el-form-item {
    & /deep/ .el-form-item__content {
      width: 100%;
    }
  }

  .list-item /deep/ .el-input .el-input__inner {
    border: 1px solid rgba(216, 216, 216, 1);
    padding: 0 10px;
    color: #000;
    background: rgba(249, 249, 249, 1);
    width: 100%;
    font-size: 14px;
    outline-offset: 4px;
    height: 44px;
  }

  .list-code /deep/ .el-input .el-input__inner {
    border: 1px solid rgba(216, 216, 216, 1);
    padding: 0 10px;
    outline: none;
    color: #000;
    display: inline-block;
    vertical-align: middle;
    width: calc(100% - 80px);
    font-size: 14px;
    height: 44px;
  }

  .list-type /deep/ .el-radio__input .el-radio__inner {
    background: rgba(53, 53, 53, 0);
    border-color: #666666;
  }
  .list-type /deep/ .el-radio__input.is-checked .el-radio__inner {
    background: rgba(197, 19, 19, 1);
    border-color: rgba(197, 19, 19, 1);
  }
  .list-type /deep/ .el-radio__label {
    color: #666666;
    font-size: 14px;
  }
  .list-type /deep/ .el-radio__input.is-checked + .el-radio__label {
    color: rgba(197, 19, 19, 1);
    font-size: 14px;
  }
}
</style>
