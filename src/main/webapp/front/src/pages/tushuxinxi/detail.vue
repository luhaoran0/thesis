<template>
  <div>
    <div
      :style="{
        width: '1200px',
        padding: '20px',
        margin: '10px auto',
        background:
          'linear-gradient(90deg, rgba(168,69,67,0.2) 0%, #6D3737 55%, rgba(247,196,195,0.2) 100%)',
      }"
      class="breadcrumb-preview"
    >
      <el-breadcrumb
        :separator="'/'"
        :style="{ fontSize: '14px', lineHeight: '14px' }"
      >
        <el-breadcrumb-item>Home</el-breadcrumb-item>
        <el-breadcrumb-item
          v-for="(item, index) in breadcrumbItem"
          :key="index"
          >{{ item.name }}</el-breadcrumb-item
        >
      </el-breadcrumb>
    </div>

    <div
      class="detail-preview"
      :style="{ width: '1200px', margin: '10px auto', position: 'relative' }"
    >
      <div
        class="attr"
        :style="{
          padding: '20px',
          position: 'relative',
          background: '#fff',
          display: 'flex',
        }"
      >
        <el-carousel
          :style="{
            border: '1px solid #707070',
            width: '346px',
            margin: '0 10px 0 0',
            borderRadius: '219px',
            height: '650px',
          }"
          trigger="click"
          indicator-position="inside"
          arrow="always"
          type="default"
          direction="horizontal"
          height="400px"
          autoplay="true"
          interval="3000"
          loop="true"
        >
          <el-carousel-item
            :style="{ borderRadius: '10px', width: '346px', height: '648px' }"
            v-for="item in tupian.split(',')"
            :key="item.id"
          >
            <el-image
              :style="{ objectFit: 'cover', width: '100%', height: '100%' }"
              v-if="item.substr(0, 7) == 'http://'"
              :src="item"
              fit="cover"
              class="image"
            ></el-image>
            <el-image
              :style="{ objectFit: 'cover', width: '100%', height: '100%' }"
              v-else
              :src="baseUrl + '/' + item"
              fit="cover"
              class="image"
            ></el-image>
          </el-carousel-item>
        </el-carousel>

        <div
          class="info"
          :style="{
            width: '640px',
            padding: '10px',
            margin: '0 0 0 10px',
            background: 'rgba(245, 245, 245, 1)',
          }"
        >
          <div
            class="item"
            :style="{
              padding: '10px 20px',
              margin: '0 0 10px 0',
              alignItems: 'center',
              background: '#f5f5f5',
              justifyContent: 'space-between',
              display: 'flex',
            }"
          >
            <div :style="{ color: 'rgba(0, 0, 0, 1)', fontSize: '16px' }">
              {{ title }}
            </div>
            <div
              @click="storeup(1)"
              v-show="!isStoreup"
              :style="{
                border: '1px solid #703b3b',
                width: '105px',
                padding: '10px',
                borderRadius: '20px',
                background: '#fff',
              }"
            >
              <i
                v-if="true"
                :style="{ color: '#703b3b', fontSize: '14px' }"
                class="el-icon-star-off"
              ></i
              ><span
                :style="{
                  color: '#703b3b',
                  margin: '0 0 0 10px',
                  fontSize: '14px',
                }"
                >Click Collection</span
              >
            </div>
            <div
              @click="storeup(-1)"
              v-show="isStoreup"
              :style="{
                border: '1px solid #703b3b',
                width: '105px',
                padding: '10px',
                borderRadius: '20px',
                background: '#fff',
              }"
            >
              <i
                v-if="true"
                :style="{ color: '#703b3b', fontSize: '14px' }"
                class="el-icon-star-on"
              ></i
              ><span
                :style="{
                  color: '#703b3b',
                  margin: '0 0 0 10px',
                  fontSize: '14px',
                }"
                >Cancel Collection</span
              >
            </div>
          </div>

          <div
            class="item"
            :style="{
              padding: '10px',
              margin: '0 0 10px 0',
              background: '#f5f5f5',
              justifyContent: 'spaceBetween',
              display: 'flex',
            }"
            v-if="detail.price"
          >
            <div
              class="lable"
              :style="{
                padding: '0 10px',
                color: '#000',
                textAlign: 'right',
                width: '102px',
                fontSize: '14px',
                lineHeight: '40px',
                height: '40px',
              }"
            >
              Price
            </div>
            <div
              style="font-weight: bold"
              :style="{
                padding: '0 10px',
                color: '#666',
                background: 'rgba(255, 255, 255, 1)',
                width: '480px',
                fontSize: '14px',
                lineHeight: '40px',
                height: '40px',
              }"
            >
              <span :style="{ fontSize: '12px' }">￥</span>{{ detail.price }}
            </div>
          </div>
          <div
            class="item"
            :style="{
              padding: '10px',
              margin: '0 0 10px 0',
              background: '#f5f5f5',
              justifyContent: 'spaceBetween',
              display: 'flex',
            }"
            v-if="detail.jf"
          >
            <div
              class="lable"
              :style="{
                padding: '0 10px',
                color: '#000',
                textAlign: 'right',
                width: '102px',
                fontSize: '14px',
                lineHeight: '40px',
                height: '40px',
              }"
            >
              integral
            </div>
            <div
              style="color: red; font-weight: bold"
              :style="{
                padding: '0 10px',
                color: '#666',
                background: 'rgba(255, 255, 255, 1)',
                width: '480px',
                fontSize: '14px',
                lineHeight: '40px',
                height: '40px',
              }"
            >
              {{ detail.jf }}
            </div>
          </div>
          <div
            class="item"
            :style="{
              padding: '10px',
              margin: '0 0 10px 0',
              background: '#f5f5f5',
              justifyContent: 'spaceBetween',
              display: 'flex',
            }"
          >
            <div
              class="lable"
              :style="{
                padding: '0 10px',
                color: '#000',
                textAlign: 'right',
                width: '102px',
                fontSize: '14px',
                lineHeight: '40px',
                height: '40px',
              }"
            >
              Single purchase
            </div>
            <div
              :style="{
                padding: '0 10px',
                color: '#666',
                background: 'rgba(255, 255, 255, 1)',
                width: '480px',
                fontSize: '14px',
                lineHeight: '40px',
                height: '40px',
              }"
            >
              {{ detail.onelimittimes }}
            </div>
          </div>
          <div
            class="item"
            :style="{
              padding: '10px',
              margin: '0 0 10px 0',
              background: '#f5f5f5',
              justifyContent: 'spaceBetween',
              display: 'flex',
            }"
          >
            <div
              class="lable"
              :style="{
                padding: '0 10px',
                color: '#000',
                textAlign: 'right',
                width: '102px',
                fontSize: '14px',
                lineHeight: '40px',
                height: '40px',
              }"
            >
              stock
            </div>
            <div
              :style="{
                padding: '0 10px',
                color: '#666',
                background: 'rgba(255, 255, 255, 1)',
                width: '480px',
                fontSize: '14px',
                lineHeight: '40px',
                height: '40px',
              }"
            >
              {{ detail.alllimittimes }}
            </div>
          </div>
          <div
            class="item"
            :style="{
              padding: '10px',
              margin: '0 0 10px 0',
              background: '#f5f5f5',
              justifyContent: 'spaceBetween',
              display: 'flex',
            }"
          >
            <div
              class="lable"
              :style="{
                padding: '0 10px',
                color: '#000',
                textAlign: 'right',
                width: '102px',
                fontSize: '14px',
                lineHeight: '40px',
                height: '40px',
              }"
            >
              Book Name
            </div>
            <div
              :style="{
                padding: '0 10px',
                color: '#666',
                background: 'rgba(255, 255, 255, 1)',
                width: '480px',
                fontSize: '14px',
                lineHeight: '40px',
                height: '40px',
              }"
            >
              {{ detail.tushumingcheng }}
            </div>
          </div>
          <div
            class="item"
            :style="{
              padding: '10px',
              margin: '0 0 10px 0',
              background: '#f5f5f5',
              justifyContent: 'spaceBetween',
              display: 'flex',
            }"
          >
            <div
              class="lable"
              :style="{
                padding: '0 10px',
                color: '#000',
                textAlign: 'right',
                width: '102px',
                fontSize: '14px',
                lineHeight: '40px',
                height: '40px',
              }"
            >
              Book classification
            </div>
            <div
              :style="{
                padding: '0 10px',
                color: '#666',
                background: 'rgba(255, 255, 255, 1)',
                width: '480px',
                fontSize: '14px',
                lineHeight: '40px',
                height: '40px',
              }"
            >
              {{ detail.tushufenlei }}
            </div>
          </div>
          <div
            class="item"
            :style="{
              padding: '10px',
              margin: '0 0 10px 0',
              background: '#f5f5f5',
              justifyContent: 'spaceBetween',
              display: 'flex',
            }"
          >
            <div
              class="lable"
              :style="{
                padding: '0 10px',
                color: '#000',
                textAlign: 'right',
                width: '102px',
                fontSize: '14px',
                lineHeight: '40px',
                height: '40px',
              }"
            >
              Book Author
            </div>
            <div
              :style="{
                padding: '0 10px',
                color: '#666',
                background: 'rgba(255, 255, 255, 1)',
                width: '480px',
                fontSize: '14px',
                lineHeight: '40px',
                height: '40px',
              }"
            >
              {{ detail.tushuzuozhe }}
            </div>
          </div>
          <div
            class="item"
            :style="{
              padding: '10px',
              margin: '0 0 10px 0',
              background: '#f5f5f5',
              justifyContent: 'spaceBetween',
              display: 'flex',
            }"
          >
            <div
              class="lable"
              :style="{
                padding: '0 10px',
                color: '#000',
                textAlign: 'right',
                width: '102px',
                fontSize: '14px',
                lineHeight: '40px',
                height: '40px',
              }"
            >
              Book quality
            </div>
            <div
              :style="{
                padding: '0 10px',
                color: '#666',
                background: 'rgba(255, 255, 255, 1)',
                width: '480px',
                fontSize: '14px',
                lineHeight: '40px',
                height: '40px',
              }"
            >
              {{ detail.tushuchengse }}
            </div>
          </div>
          <div
            class="item"
            :style="{
              padding: '10px',
              margin: '0 0 10px 0',
              background: '#f5f5f5',
              justifyContent: 'spaceBetween',
              display: 'flex',
            }"
          >
            <div
              class="lable"
              :style="{
                padding: '0 10px',
                color: '#000',
                textAlign: 'right',
                width: '102px',
                fontSize: '14px',
                lineHeight: '40px',
                height: '40px',
              }"
            >
              Seller Number
            </div>
            <div
              :style="{
                padding: '0 10px',
                color: '#666',
                background: 'rgba(255, 255, 255, 1)',
                width: '480px',
                fontSize: '14px',
                lineHeight: '40px',
                height: '40px',
              }"
            >
              {{ detail.maijiaxuehao }}
            </div>
          </div>
          <div
            class="item"
            :style="{
              padding: '10px',
              margin: '0 0 10px 0',
              background: '#f5f5f5',
              justifyContent: 'spaceBetween',
              display: 'flex',
            }"
          >
            <div
              class="lable"
              :style="{
                padding: '0 10px',
                color: '#000',
                textAlign: 'right',
                width: '102px',
                fontSize: '14px',
                lineHeight: '40px',
                height: '40px',
              }"
            >
              Seller Name
            </div>
            <div
              :style="{
                padding: '0 10px',
                color: '#666',
                background: 'rgba(255, 255, 255, 1)',
                width: '480px',
                fontSize: '14px',
                lineHeight: '40px',
                height: '40px',
              }"
            >
              {{ detail.maijiaxingming }}
            </div>
          </div>
          <div
            class="item"
            :style="{
              padding: '10px',
              margin: '0 0 10px 0',
              background: '#f5f5f5',
              justifyContent: 'spaceBetween',
              display: 'flex',
            }"
          >
            <div
              class="lable"
              :style="{
                padding: '0 10px',
                color: '#000',
                textAlign: 'right',
                width: '102px',
                fontSize: '14px',
                lineHeight: '40px',
                height: '40px',
              }"
            >
              Contact Telephone
            </div>
            <div
              :style="{
                padding: '0 10px',
                color: '#666',
                background: 'rgba(255, 255, 255, 1)',
                width: '480px',
                fontSize: '14px',
                lineHeight: '40px',
                height: '40px',
              }"
            >
              {{ detail.lianxidianhua }}
            </div>
          </div>
          <div
            class="btn"
            :style="{
              padding: '10px 0',
              position: 'relative',
              flexWrap: 'wrap',
              display: 'flex',
            }"
          >
            <el-input-number
              :style="{
                margin: '0 5px 0 0',
                top: '0',
                left: '70px',
                display: 'inline-block',
                width: '180px',
                lineHeight: '38px',
                position: 'absolute',
              }"
              v-if="detail.alllimittimes"
              v-model="buynumber"
            ></el-input-number>
            <el-button
              :style="{
                border: '0',
                cursor: 'pointer',
                padding: '0 10px',
                margin: '60px 5px 0 70px',
                outline: 'none',
                color: '#fff',
                borderRadius: '4px',
                background: 'rgba(197, 19, 19, 1)',
                width: 'auto',
                lineHeight: '40px',
                fontSize: '14px',
                height: '40px',
              }"
              v-if="detail.alllimittimes"
              type="warning"
              size="small"
              @click="addCart"
              >Add to Cart</el-button
            >
            <el-button
              :style="{
                border: '0',
                cursor: 'pointer',
                padding: '0 10px',
                margin: '60px 5px 0 0',
                outline: 'none',
                color: '#fff',
                borderRadius: '4px',
                background: 'rgba(245, 213, 85, 1)',
                width: 'auto',
                lineHeight: '40px',
                fontSize: '14px',
                height: '40px',
              }"
              v-if="detail.alllimittimes"
              type="warning"
              size="small"
              @click="buyNow"
              >Buy Now</el-button
            >
          </div>
          <div
            class="btn"
            :style="{
              padding: '10px 0',
              position: 'relative',
              flexWrap: 'wrap',
              display: 'flex',
            }"
          >
            <el-button
              :style="{
                border: '0',
                cursor: 'pointer',
                padding: '0 10px',
                margin: '60px 5px 0 70px',
                outline: 'none',
                color: '#fff',
                borderRadius: '4px',
                background: 'rgba(197, 19, 19, 1)',
                width: 'auto',
                lineHeight: '40px',
                fontSize: '14px',
                height: '40px',
              }"
              v-if="isAuth('tushuxinxi', 'Consultation chat')"
              @click="onAcross('liaotianjilu', '', '', '')"
              type="warning"
              >Consultation chat</el-button
            >
          </div>
        </div>
      </div>

      <el-tabs
        class="detail"
        :style="{
          border: '1px solid #DCDFE6',
          boxShadow: '0 1px 6px 0 rgba(0, 0, 0, .1)',
          background: '#FFF',
        }"
        v-model="activeName"
        type="border-card"
      >
        <el-tab-pane label="Book Details" name="first">
          <div v-html="detail.tushuxiangqing"></div>
        </el-tab-pane>
        <el-tab-pane label="comment" name="second">
          <el-form
            class="add comment"
            :style="{
              boxShadow: '0 1px 6px 0 rgba(0, 0, 0, .1)',
              padding: '15px',
              margin: '0 0 20px',
            }"
            :model="form"
            :rules="rules"
            ref="form"
          >
            <el-form-item
              class="item"
              :style="{ width: '100%', display: 'flex', height: 'auto' }"
              label="comment"
              prop="content"
            >
              <el-input
                type="textarea"
                :rows="5"
                v-model="form.content"
                placeholder="Please enter the content"
              ></el-input>
            </el-form-item>
            <el-form-item
              class="btn"
              :style="{
                width: '100%',
                padding: '0 0 0 80px',
                margin: '10px 0 0',
                height: 'auto',
              }"
            >
              <el-button
                :style="{
                  border: '0',
                  cursor: 'pointer',
                  padding: '0',
                  margin: '0 20px 0 0',
                  outline: 'none',
                  color: 'rgba(255, 255, 255, 1)',
                  borderRadius: '4px',
                  background: 'rgba(209, 10, 10, 1)',
                  width: '128px',
                  lineHeight: '40px',
                  fontSize: '14px',
                  height: '40px',
                }"
                type="primary"
                @click="submitForm('form')"
                >Submit Now</el-button
              >
              <el-button
                :style="{
                  border: '1px solid rgba(209, 10, 10, 1)',
                  cursor: 'pointer',
                  padding: '0',
                  margin: '0 20px 0 0',
                  outline: 'none',
                  color: 'rgba(209, 10, 10, 1)',
                  borderRadius: '4px',
                  background: '#fff',
                  width: '128px',
                  lineHeight: '40px',
                  fontSize: '14px',
                  height: '40px',
                }"
                @click="resetForm('form')"
                >Reset</el-button
              >
            </el-form-item>
          </el-form>

          <div
            v-if="infoList.length"
            :style="{
              boxShadow: '0 1px 6px 0 rgba(0, 0, 0, .1)',
              padding: '15px',
            }"
            class="comment"
          >
            <div
              :style="{
                padding: '8px 0',
                margin: '0 0 20px',
                borderColor: '#999',
                alignItems: 'center',
                borderWidth: '0 0 1px 0',
                width: '100%',
                borderStyle: 'solid',
                height: 'auto',
              }"
              v-for="item in infoList"
              :key="item.id"
            >
              <div
                class="user"
                :style="{
                  width: '100%',
                  alignItems: 'center',
                  display: 'flex',
                  height: 'auto',
                }"
              >
                <el-image
                  :style="{
                    width: '40px',
                    margin: '0 10px 0 0',
                    borderRadius: '100%',
                    objectFit: 'cover',
                    height: '40px',
                  }"
                  :size="50"
                  :src="require('@/assets/touxiang.png')"
                ></el-image>
                <div :style="{ color: '#333', fontSize: '16px' }" class="name">
                  User: {{ item.nickname }}
                </div>
              </div>
              <div
                :style="{
                  padding: '8px',
                  boxShadow: 'rgb(209  10 10 / 30%) 0px 0px 6px',
                  margin: '10px 0px 0px',
                  color: '#333',
                  borderRadius: '4px',
                  background: 'rgba(209, 10, 10, .11)',
                  lineHeight: '30px',
                  fontSize: '14px',
                }"
                class="content-block-ask"
              >
                {{ item.content }}
              </div>
              <div
                :style="{
                  padding: '8px',
                  boxShadow: 'rgb(209  10 10 / 30%) 0px 0px 6px',
                  margin: '10px 0px 0px',
                  color: '#333',
                  borderRadius: '4px',
                  background: 'rgba(209, 10, 10, .11)',
                  lineHeight: '30px',
                  fontSize: '14px',
                }"
                class="content-block-reply"
                v-if="item.reply"
              >
                Reply：{{ item.reply }}
              </div>
            </div>
          </div>

          <el-pagination
            background
            class="pagination"
            :pager-count="7"
            :page-size="pageSize"
            :page-sizes="[10, 20, 30, 50]"
            prev-text="<"
            next-text=">"
            :hide-on-single-page="true"
            :layout="['pager'].join()"
            :total="total"
            :style="{
              padding: '0',
              margin: '25px auto',
              whiteSpace: 'nowrap',
              color: '#333',
              textAlign: 'center',
              width: '1200px',
              fontWeight: '500',
            }"
            @current-change="curChange"
            @prev-click="prevClick"
            @next-click="nextClick"
          ></el-pagination>
        </el-tab-pane>
      </el-tabs>
    </div>
  </div>
</template>

<script>
import CountDown from "@/components/CountDown";
export default {
  //数据集合
  data() {
    return {
      tablename: "tushuxinxi",
      baseUrl: "",
      breadcrumbItem: [
        {
          name: "Details info",
        },
      ],
      title: "",
      tupian: "",
      endTime: 0,
      detail: {},
      activeName: "first",
      form: {
        content: "",
        userid: localStorage.getItem("userid"),
        nickname: localStorage.getItem("username"),
      },
      infoList: [],
      total: 1,
      pageSize: 5,
      totalPage: 1,
      rules: {
        content: [
          {
            required: true,
            message: "Please enter the content",
            trigger: "blur",
          },
        ],
      },
      storeupParams: {
        name: "",
        picture: "",
        refid: 0,
        tablename: "tushuxinxi",
        userid: localStorage.getItem("userid"),
      },
      isStoreup: false,
      storeupInfo: {},
      buynumber: 1,
      cart: {
        buynumber: 0,
        discountprice: 0,
        goodid: 0,
        goodname: "",
        picture: "",
        price: 0,
        userid: localStorage.getItem("userid"),
      },
      isInCart: false,
    };
  },
  created() {
    this.baseUrl = this.$config.baseUrl;
    this.detail = JSON.parse(this.$route.query.detailObj);
    this.isStoreup = this.$route.query.isStoreup == "Yes" ? true : false;
    if (this.$route.query.isStoreup == "Yes")
      this.detail.id = this.detail.refid;
    if (this.$route.query.orderDiscuss == "Yes")
      this.detail.id = this.detail.goodid;
    this.$http
      .get(this.tablename + "/detail/" + this.detail.id, {})
      .then((res) => {
        if (res.data.code == 0) {
          this.detail = res.data.data;
        }
      });
    if (this.detail.refid > 0) {
      this.$http
        .get(this.detail.tablename + "/detail/" + this.detail.refid, {})
        .then((res) => {
          if (res.data.code == 0) {
            this.detail = res.data.data;
            this.title = this.detail.tushumingcheng;
            this.tupian = this.detail.tushufengmian
              ? this.detail.tushufengmian.split(",")[0]
              : "";
          }
        });
    } else {
      this.title = this.detail.tushumingcheng;
      this.tupian = this.detail.tushufengmian
        ? this.detail.tushufengmian.split(",")[0]
        : "";
    }
    if (this.detail.goodid > 0) {
      this.$http
        .get(this.detail.tablename + "/detail/" + this.detail.goodid, {})
        .then((res) => {
          if (res.data.code == 0) {
            this.detail = res.data.data;
            this.title = this.detail.tushumingcheng;
            this.tupian = this.detail.tushufengmian
              ? this.detail.tushufengmian.split(",")[0]
              : "";
          }
        });
    }

    this.startTime = new Date().getTime();
    this.endTime = new Date(this.detail.reversetime).getTime();
    this.getDiscussList(1);
    this.getStoreupStatus();
    this.getCartList();
  },
  //方法集合
  methods: {
    onAcross(
      acrossTable,
      crossOptAudit,
      statusColumnName,
      tips,
      statusColumnValue
    ) {
      localStorage.setItem("crossTable", `tushuxinxi`);
      localStorage.setItem("crossObj", JSON.stringify(this.detail));
      localStorage.setItem("statusColumnName", statusColumnName);
      localStorage.setItem("statusColumnValue", statusColumnValue);
      localStorage.setItem("tips", tips);
      if (statusColumnName != "" && !statusColumnName.startsWith("[")) {
        var obj = JSON.parse(localStorage.getItem("crossObj"));
        for (var o in obj) {
          if (o == statusColumnName && obj[o] == statusColumnValue) {
            this.$message({
              type: "success",
              message: tips,
              duration: 1500,
            });
            return;
          }
        }
      }
      this.$router.push({
        path: "/index/" + acrossTable + "Add",
        query: { type: "cross" },
      });
    },
    storeup(type) {
      if (type == 1 && !this.isStoreup) {
        this.storeupParams.name = this.title;
        this.storeupParams.picture = this.tupian;
        this.storeupParams.refid = this.detail.id;
        this.storeupParams.type = type;
        this.$http.post("storeup/add", this.storeupParams).then((res) => {
          if (res.data.code == 0) {
            this.isStoreup = true;
            this.$message({
              type: "success",
              message: "Collection succeeded!",
              duration: 1500,
            });
          }
        });
      }
      if (type == -1 && this.isStoreup) {
        let delIds = new Array();
        delIds.push(this.storeupInfo.id);
        this.$http.post("storeup/delete", delIds).then((res) => {
          if (res.data.code == 0) {
            this.isStoreup = false;
            this.$message({
              type: "success",
              message: "Cancel succeeded!",
              duration: 1500,
            });
          }
        });
      }
    },
    getStoreupStatus() {
      if (localStorage.getItem("Token")) {
        this.$http
          .get("storeup/list", {
            params: {
              page: 1,
              limit: 1,
              type: 1,
              refid: this.detail.id,
              tablename: "tushuxinxi",
              userid: localStorage.getItem("userid"),
            },
          })
          .then((res) => {
            if (res.data.code == 0 && res.data.data.list.length > 0) {
              this.isStoreup = true;
              this.storeupInfo = res.data.data.list[0];
            }
          });
      }
    },
    curChange(page) {
      this.getInfo(page);
    },
    prevClick(page) {
      this.getInfo(page);
    },
    nextClick(page) {
      this.getInfo(page);
    },
    getDiscussList(page) {
      this.$http
        .get("discusstushuxinxi/list", {
          params: { page, limit: this.pageSize, refid: this.detail.id },
        })
        .then((res) => {
          if (res.data.code == 0) {
            this.infoList = res.data.data.list;
            this.total = res.data.data.total;
            this.pageSize = res.data.data.pageSize;
            this.totalPage = res.data.data.totalPage;
          }
        });
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$http
            .get("orders/list", {
              params: {
                page: 1,
                limit: 1,
                status: "Completed",
                goodid: this.detail.id,
                userid: localStorage.getItem("userid"),
              },
            })
            .then((res) => {
              if (res.data.code == 0 && res.data.data.list.length == 0) {
                this.$message({
                  type: "success",
                  message: "Please comment after completing the order!",
                  duration: 1500,
                });
                return false;
              } else {
                this.form.refid = this.detail.id;
                this.$http
                  .post("discusstushuxinxi/add", this.form)
                  .then((res) => {
                    if (res.data.code == 0) {
                      this.form.content = "";
                      this.getDiscussList(1);
                      this.$message({
                        type: "success",
                        message: "Comment succeeded!",
                        duration: 1500,
                      });
                    }
                  });
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
    getCartList() {
      this.$http
        .get("cart/list", {
          params: {
            userid: localStorage.getItem("userid"),
            tablename: "tushuxinxi",
            goodid: this.detail.id,
          },
        })
        .then((res) => {
          if (res.data.code == 0) {
            if (res.data.data.list.length > 0) {
              this.isInCart = true;
            } else {
              this.isInCart = false;
            }
          }
        });
    },
    addCart() {
      if (this.buynumber > this.detail.onelimittimes) {
        this.$message.error(
          `Each person can only buy ${this.detail.onelimittimes} pieces at a time `
        );
        return;
      }
      if (this.isInCart) {
        this.$message.error("This product has been added to Cart");
        return;
      }

      this.cart.buynumber = this.buynumber;
      this.cart.goodid = this.detail.id;
      this.cart.goodname = this.title;
      this.cart.picture = this.tupian;
      this.cart.price = this.detail.price;
      this.$http.post("cart/save", this.cart).then((res) => {
        if (res.data.code === 0) {
          this.getCartList();
          this.$message({
            message: "Add succeeded",
            type: "success",
            duration: 1500,
          });
        } else {
          this.$message.error(res.data.msg);
        }
      });
    },
    //Buy Now
    buyNow() {
      // Single purchase限制
      if (
        this.detail.onelimittimes > 0 &&
        this.detail.onelimittimes < this.buynumber
      ) {
        this.$message.error(
          `Each person can only buy one time ${this.detail.onelimittimes}件`
        );
        return;
      }
      // stock不够
      if (this.detail.alllimittimes <= 0) {
        this.$message.error(`Product sold out`);
        return;
      }
      // stock限制
      if (
        this.detail.alllimittimes > 0 &&
        this.detail.alllimittimes < this.buynumber
      ) {
        this.$message.error(`Insufficient stock`);
        return;
      }
      // Save到storage中，在Confirm orderpage面中获取要购买的porduct
      localStorage.setItem(
        "orderGoods",
        JSON.stringify([
          {
            tablename: this.tablename,
            goodid: this.detail.id,
            goodname: this.title,
            maijiaxuehao: this.detail.maijiaxuehao,

            picture: this.tupian.split(",")[0],
            buynumber: this.buynumber,
            userid: localStorage.getItem("userid"),
            price: this.detail.price,
            discountprice: this.detail.vipprice ? this.detail.vipprice : 0,
          },
        ])
      );
      // 跳转到Confirm orderpage面
      let query = {
        type: 1,
      };
      this.$router.push({
        path: "/index/shop-order/orderConfirm",
        query: query,
      });
    },
  },
  components: {
    CountDown,
  },
};
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.detail-preview {
  .attr {
    .el-carousel /deep/ .el-carousel__indicator button {
      width: 0;
      height: 0;
      display: none;
    }

    .el-input-number__decrease:hover:not(.is-disabled)
      ~ .el-input
      .el-input__inner:not(.is-disabled),
    .el-input-number__increase:hover:not(.is-disabled)
      ~ .el-input
      .el-input__inner:not(.is-disabled) {
      border-color: none;
    }
  }

  .detail {
    & /deep/ .el-tabs__header .el-tabs__nav-wrap {
      margin-bottom: 0;
    }

    & .add .el-textarea {
      width: auto;
    }
  }
}

.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left {
  width: 36px;
  font-size: 12px;
  height: 36px;
}

.attr
  .el-carousel
  /deep/
  .el-carousel__container
  .el-carousel__arrow--left:hover {
  background: red;
}

.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right {
  width: 36px;
  font-size: 12px;
  height: 36px;
}

.attr
  .el-carousel
  /deep/
  .el-carousel__container
  .el-carousel__arrow--right:hover {
  background: red;
}

.attr .el-carousel /deep/ .el-carousel__indicators {
  padding: 0;
  z-index: 2;
  bottom: 25px;
  position: absolute;
  list-style: none;
}

.attr .el-carousel /deep/ .el-carousel__indicators li {
  border-radius: 5px;
  padding: 0;
  margin: 0 4px;
  background: #fff;
  display: inline-block;
  width: 12px;
  opacity: 0.4;
  transition: 0.3s;
  height: 12px;
}

.attr .el-carousel /deep/ .el-carousel__indicators li:hover {
  padding: 0;
  margin: 0 4px;
  background: #fff;
  display: inline-block;
  width: 24px;
  opacity: 0.7;
  height: 12px;
}

.attr .el-carousel /deep/ .el-carousel__indicators li.is-active {
  padding: 0;
  margin: 0 4px;
  background: #fff;
  display: inline-block;
  width: 24px;
  opacity: 1;
  height: 12px;
}

.attr .el-input-number /deep/ .el-input-number__decrease {
  cursor: pointer;
  z-index: 1;
  display: flex;
  border-color: #dcdfe6;
  border-radius: 4px 0 0 4px;
  top: 1px;
  left: 1px;
  background: #f5f5f5;
  width: 40px;
  justify-content: center;
  border-width: 0 1px 0 0;
  align-items: center;
  position: absolute;
  border-style: solid;
  text-align: center;
  height: 38px;
}

.attr .el-input-number /deep/ .el-input-number__decrease i {
  color: #666;
  font-size: 14px;
}

.attr .el-input-number /deep/ .el-input-number__increase {
  cursor: pointer;
  z-index: 1;
  display: flex;
  border-color: #dcdfe6;
  right: 1px;
  border-radius: 0 4px 4px 0;
  top: 1px;
  background: #f5f5f5;
  width: 40px;
  justify-content: center;
  border-width: 0 0 0 1px;
  align-items: center;
  position: absolute;
  border-style: solid;
  text-align: center;
  height: 38px;
}

.attr .el-input-number /deep/ .el-input-number__increase i {
  color: #666;
  font-size: 14px;
}

.attr .el-input-number /deep/ .el-input .el-input__inner {
  border: 1px solid #dcdfe6;
  border-radius: 4px;
  padding: 0 40px;
  outline: none;
  color: #666;
  background: #fff;
  display: inline-block;
  width: 100%;
  font-size: 14px;
  line-height: 40px;
  text-align: center;
  height: 40px;
}

.detail-preview .detail.el-tabs /deep/ .el-tabs__header {
  margin: 0;
  background: #dcdfe6;
  border-color: #e4e7ed;
  border-width: 0 0 1px 0;
  border-style: solid;
}

.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item {
  border: 0;
  padding: 0 20px;
  margin: 0;
  color: #666;
  background: transparent;
  font-weight: 500;
  display: inline-block;
  font-size: 14px;
  line-height: 40px;
  position: relative;
  list-style: none;
  height: 40px;
}

.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item:hover {
  border: 0;
  color: rgba(209, 10, 10, 1);
  background: #fff;
}

.detail-preview
  .detail.el-tabs
  /deep/
  .el-tabs__header
  .el-tabs__item.is-active {
  border: 0;
  color: #fff;
  background: rgba(209, 10, 10, 1);
}

.detail-preview .detail.el-tabs /deep/ .el-tabs__content {
  padding: 15px;
}

.detail-preview .detail.el-tabs .add /deep/ .el-form-item__label {
  padding: 0 10px 0 0;
  color: #666;
  width: 80px;
  font-size: 14px;
  line-height: 40px;
  text-align: right;
}

.detail-preview .detail.el-tabs .add /deep/ .el-textarea__inner {
  border: 0;
  border-radius: 4px;
  padding: 0 12px;
  box-shadow: 0 0 6px rgba(209, 10, 10, 0.5);
  outline: none;
  color: #333;
  width: 1058px;
  font-size: 14px;
  line-height: 32px;
  height: 120px;
}

.breadcrumb-preview .el-breadcrumb /deep/ .el-breadcrumb__separator {
  margin: 0 9px;
  color: #000;
  font-weight: 500;
}

.breadcrumb-preview .el-breadcrumb /deep/ .el-breadcrumb__inner a {
  color: #000;
  display: inline-block;
}

.breadcrumb-preview .el-breadcrumb /deep/ .el-breadcrumb__inner {
  color: #000;
  display: inline-block;
}

.el-pagination /deep/ .el-pagination__total {
  margin: 0 10px 0 0;
  color: #666;
  font-weight: 400;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  height: 28px;
}

.el-pagination /deep/ .btn-prev {
  border: none;
  border-radius: 2px;
  padding: 0;
  margin: 0 5px;
  color: #666;
  background: #f4f4f5;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  min-width: 35px;
  height: 28px;
}

.el-pagination /deep/ .btn-next {
  border: none;
  border-radius: 2px;
  padding: 0;
  margin: 0 5px;
  color: #666;
  background: #f4f4f5;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  min-width: 35px;
  height: 28px;
}

.el-pagination /deep/ .btn-prev:disabled {
  border: none;
  cursor: not-allowed;
  border-radius: 2px;
  padding: 0;
  margin: 0 5px;
  color: #c0c4cc;
  background: #f4f4f5;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  height: 28px;
}

.el-pagination /deep/ .btn-next:disabled {
  border: none;
  cursor: not-allowed;
  border-radius: 2px;
  padding: 0;
  margin: 0 5px;
  color: #c0c4cc;
  background: #f4f4f5;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  height: 28px;
}

.el-pagination /deep/ .el-pager {
  padding: 0;
  margin: 0;
  display: inline-block;
  vertical-align: top;
}

.el-pagination /deep/ .el-pager .number {
  cursor: pointer;
  border: 0;
  padding: 0 4px;
  margin: 0 5px;
  color: #666;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 35px;
  border-radius: 0px 0px 10px 10px;
  background: rgba(216, 216, 216, 1);
  text-align: center;
  min-width: 35px;
  height: 35px;
}

.el-pagination /deep/ .el-pager .number:hover {
  cursor: pointer;
  padding: 0 4px;
  margin: 0 5px;
  color: rgba(197, 19, 19, 1);
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 35px;
  border-radius: 0px 0px 10px 10px;
  background: rgba(216, 216, 216, 1);
  text-align: center;
  min-width: 35px;
  height: 35px;
}

.el-pagination /deep/ .el-pager .number.active {
  cursor: default;
  border: 1px solid rgba(197, 19, 19, 1);
  padding: 0 4px;
  margin: 0 5px;
  color: rgba(197, 19, 19, 1);
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 35px;
  border-radius: 0px 0px 10px 10px;
  background: #fff;
  text-align: center;
  min-width: 35px;
  height: 35px;
}

.el-pagination /deep/ .el-pagination__sizes {
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  height: 28px;
}

.el-pagination /deep/ .el-pagination__sizes .el-input {
  margin: 0 5px;
  width: 100px;
  position: relative;
}

.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
  border: 1px solid #dcdfe6;
  cursor: pointer;
  padding: 0 25px 0 8px;
  color: #606266;
  display: inline-block;
  font-size: 13px;
  line-height: 28px;
  border-radius: 3px;
  outline: 0;
  background: #fff;
  width: 100%;
  text-align: center;
  height: 28px;
}

.el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
  top: 0;
  position: absolute;
  right: 0;
  height: 100%;
}

.el-pagination
  /deep/
  .el-pagination__sizes
  .el-input
  .el-input__suffix
  .el-select__caret {
  cursor: pointer;
  color: #c0c4cc;
  width: 25px;
  font-size: 14px;
  line-height: 28px;
  text-align: center;
}

.el-pagination /deep/ .el-pagination__jump {
  margin: 0 0 0 24px;
  color: #606266;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  height: 28px;
}

.el-pagination /deep/ .el-pagination__jump .el-input {
  border-radius: 3px;
  padding: 0 2px;
  margin: 0 2px;
  display: inline-block;
  width: 50px;
  font-size: 14px;
  line-height: 18px;
  position: relative;
  text-align: center;
  height: 28px;
}

.el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
  border: 1px solid #dcdfe6;
  cursor: pointer;
  padding: 0 3px;
  color: #606266;
  display: inline-block;
  font-size: 14px;
  line-height: 28px;
  border-radius: 3px;
  outline: 0;
  background: #fff;
  width: 100%;
  text-align: center;
  height: 28px;
}
</style>
