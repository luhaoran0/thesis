<template>
<div class="home-preview" :style='{"width":"100%","padding":"10px 0 0","margin":"0px auto 10px"}'>
	<el-row type="flex" :gutter="5" justify="center">
		<el-col :span="3" v-if="queryList.length>1">
			<el-select v-model="queryIndex">
				<el-option
				  v-for="(item,index) in queryList"
				  :key="index"
				  :label="item.queryName"
				  :value="index"
				></el-option>
			</el-select>
		</el-col>
		<el-col :span="3" v-if="queryIndex==0">
			<el-input v-model="tushuxinxitushumingcheng" placeholder="Book Name"></el-input>
		</el-col>
		<el-col :span="3" v-if="queryIndex==0">
			<el-button type="primary" @click="search('tushuxinxi')">Search</el-button>
		</el-col>
	</el-row>


<div class="news" :style='{"padding":"55px 360px 0","margin":"80px 0 0","backgroundSize":"100% 100%","background":"url(http://codegen.caihongy.cn/20220831/ba318e235bf745dea88c7b45b4556312.png)","height":"820px"}'>
	<div v-if="false" class="idea newsIdea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	<div class="title" :style='{"width":"200px","margin":"10px 0 20px 0px","lineHeight":"54px","textAlign":"center"}'>
		<span :style='{"color":"#fff","fontSize":"30px"}'>Notice information</span>
	</div>
	
	
	
	
	
	
	<!-- 样式五 -->
	<div v-if="newsList.length" class="list list5 index-pv1" :style='{"width":"100%","padding":"10px","position":"relative","height":"auto"}'>
	  <div @click="toDetail('newsDetail', newsList[0])" v-if="newsList.length>0" class="list-item animation-box" :style='{"width":"460px","margin":"0 50px 20px","position":"absolute","right":"0","height":"275px"}'>
	    <img :style='{"width":"100%","margin":"0 0 15px","objectFit":"cover","borderRadius":"10px","float":"left","height":"355px"}' :src="baseUrl + '/' + newsList[0].picture" alt="">
	    <div :style='{"width":"460px","padding":"10px","borderRadius":"10px","background":"#fff","display":"inline-block","height":"170px"}'>
	      <div :style='{"padding":"5px 10px","lineHeight":"30px","fontSize":"16px","color":"#333"}' class="new5-one-info-title line1">{{newsList[0].title}}</div>
	      <div :style='{"padding":"10px","lineHeight":"24px","fontSize":"14px","overflow":"hidden","color":"#666","height":"80px"}' class="new5-one-info-descript line3">{{newsList[0].introduction}}</div>
	      <div :style='{"padding":"10px","lineHeight":"32px","fontSize":"12px","color":"#999"}' class="new5-one-info-time">{{newsList[0].addtime}}</div>
	    </div>
	  </div>
	  <div :style='{"width":"500px","flexDirection":"column","display":"flex","height":"600px"}' class="list-body">
	    <div @click="toDetail('newsDetail', newsList[1])" v-if="newsList.length>1" class="new5-item animation-box" :style='{"padding":"10px","margin":"0 0 15px","overflow":"hidden","borderRadius":"10px","background":"#f5f5f5","width":"100%","position":"relative","height":"170px"}'>
	      <div :style='{"padding":"10px","color":"#fff","background":"rgba(197, 19, 19, 1)","bottom":"0","display":"inline-block","lineHeight":"20px","fontSize":"12px","position":"absolute","right":"50px"}' class="new5-item-time">{{newsList[1].addtime.split(" ")[0]}}1</div>
	      <div :style='{"padding":"10px","lineHeight":"32px","fontSize":"16px","color":"#333"}' class="new5-item-title line1">{{newsList[1].title}}</div>
	      <div :style='{"padding":"4px 10px","lineHeight":"32px","fontSize":"14px","overflow":"hidden","color":"#666","height":"60px"}' class="new5-item-descript line3">{{newsList[1].introduction}}</div>
	    </div>
		<div @click="toDetail('newsDetail', newsList[2])" v-if="newsList.length>2" class="new5-item animation-box" :style='{"padding":"10px","margin":"0 0 15px","overflow":"hidden","borderRadius":"10px","background":"#f5f5f5","width":"100%","position":"relative","height":"170px"}'>
		  <div :style='{"padding":"10px","color":"#fff","background":"rgba(197, 19, 19, 1)","bottom":"0","display":"inline-block","lineHeight":"20px","fontSize":"12px","position":"absolute","right":"50px"}' class="new5-item-time">{{newsList[2].addtime.split(" ")[0]}}</div>
		  <div :style='{"padding":"10px","lineHeight":"32px","fontSize":"16px","color":"#333"}' class="new5-item-title line1">{{newsList[2].title}}</div>
		  <div :style='{"padding":"4px 10px","lineHeight":"32px","fontSize":"14px","overflow":"hidden","color":"#666","height":"60px"}' class="new5-item-descript line3">{{newsList[2].introduction}}</div>
		</div>
		<div @click="toDetail('newsDetail', newsList[3])" v-if="newsList.length>3" class="new5-item animation-box" :style='{"padding":"10px","margin":"0 0 15px","overflow":"hidden","borderRadius":"10px","background":"#f5f5f5","width":"100%","position":"relative","height":"170px"}'>
		  <div :style='{"padding":"10px","color":"#fff","background":"rgba(197, 19, 19, 1)","bottom":"0","display":"inline-block","lineHeight":"20px","fontSize":"12px","position":"absolute","right":"50px"}' class="new5-item-time">{{newsList[3].addtime.split(" ")[0]}}</div>
		  <div :style='{"padding":"10px","lineHeight":"32px","fontSize":"16px","color":"#333"}' class="new5-item-title line1">{{newsList[3].title}}</div>
		  <div :style='{"padding":"4px 10px","lineHeight":"32px","fontSize":"14px","overflow":"hidden","color":"#666","height":"60px"}' class="new5-item-descript line3">{{newsList[3].introduction}}</div>
		</div>
	  </div>
	</div>
	
	
	
	
	
	
	<div @click="moreBtn('news')" :style='{"cursor":"pointer","margin":"0px auto 0","borderColor":"rgba(255, 255, 255, 1)","borderRadius":"5px","textAlign":"center","borderWidth":"0 3px","display":"block","width":"100px","lineHeight":"32px","borderStyle":"solid","zIndex":"10000"}'>
		<span :style='{"color":"#f5f5f5","fontSize":"16px"}'>View more</span>
		<i v-if="true" :style='{"color":"#f5f5f5","fontSize":"12px"}' class="el-icon-d-arrow-right"></i>
	</div>
	
</div>

<div class="lists" :style='{"padding":"40px 380px","margin":"-10px 0 0","backgroundSize":"100% 100%","background":"url(http://codegen.caihongy.cn/20220831/d508b525fc2f420cbad7c82457648ab0.png)","height":"750px"}'>
	<div v-if="false" class="idea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	<div class="title" :style='{"width":"200px","margin":"10px auto 30px","lineHeight":"54px","textAlign":"center"}'>
	  <span :style='{"color":"#fff","fontSize":"30px"}'>Book information display</span>
	</div>
	
	
	
	
	
	
	
	
	<!-- 样式七 -->
	<div class="list list7 index-pv1" :style='{"width":"100%","padding":"10px","display":"flex","height":"auto"}'>
		<div v-if="tushuxinxiList.length>0" class="list-4-item animation-box item-1" @click="toDetail('tushuxinxiDetail', tushuxinxiList[0])" :style='{"boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.302)","margin":"0 10px","overflow":"hidden","borderRadius":"10px","width":"240px","position":"relative","height":"440px"}'>
			<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"350px"}' :src="baseUrl + '/' + (tushuxinxiList[0].tushufengmian?tushuxinxiList[0].tushufengmian.split(',')[0]:'')" alt="" />
			<div class="list-4-item-title line1" :style='{"padding":"0 15px","color":"rgba(158, 158, 158, 1)","left":"0","textAlign":"center","bottom":"0","background":"#fff","width":"100%","lineHeight":"90px","fontSize":"18px","position":"absolute","height":"90px"}'>{{tushuxinxiList[0].tushumingcheng}}</div>
		</div>
		<div :style='{"width":"240px","margin":"0 10px","height":"275px"}' class="list-4-body">
			<div v-if="tushuxinxiList.length>1" @click="toDetail('tushuxinxiDetail', tushuxinxiList[1])" class="list-4-item animation-box item-2" :style='{"width":"240px","margin":"0 0 20px","overflow":"hidden","position":"relative","borderRadius":"10px","height":"210px"}'>
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"140px"}' :src="baseUrl + '/' + (tushuxinxiList[1].tushufengmian?tushuxinxiList[1].tushufengmian.split(',')[0]:'')" alt="" />
				<div class="list-4-item-title line1" :style='{"padding":"0 15px","color":"rgba(158, 158, 158, 1)","left":"0","textAlign":"center","bottom":"0","background":"#fff","width":"100%","lineHeight":"70px","fontSize":"18px","position":"absolute"}'>{{tushuxinxiList[1].tushumingcheng}}</div>
			</div>
			<div v-if="tushuxinxiList.length>2" @click="toDetail('tushuxinxiDetail', tushuxinxiList[2])" class="list-4-item animation-box item-3" :style='{"margin":"20px 0 0","overflow":"hidden","borderRadius":"57px","background":"#fff","width":"240px","position":"relative","height":"210px"}'>
				<img :style='{"width":"100%","objectFit":"cover","borderRadius":"105px","float":"left","height":"120px"}' :src="baseUrl + '/' + (tushuxinxiList[2].tushufengmian?tushuxinxiList[2].tushufengmian.split(',')[0]:'')" alt="" />
				<div class="list-4-item-title line1" :style='{"padding":"0 15px","color":"rgba(158, 158, 158, 1)","left":"0","textAlign":"center","bottom":"0","background":"#fff","width":"100%","lineHeight":"90px","fontSize":"18px","position":"absolute"}'>{{tushuxinxiList[2].tushumingcheng}}</div>
			</div>
		</div>
		<div v-if="tushuxinxiList.length>3" class="list-4-item animation-box item-1" @click="toDetail('tushuxinxiDetail', tushuxinxiList[3])" :style='{"boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.302)","margin":"0 10px","overflow":"hidden","borderRadius":"10px","width":"240px","position":"relative","height":"440px"}'>
			<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"350px"}' :src="baseUrl + '/' + (tushuxinxiList[3].tushufengmian?tushuxinxiList[3].tushufengmian.split(',')[0]:'')" alt="" />
			<div class="list-4-item-title line1" :style='{"padding":"0 15px","color":"rgba(158, 158, 158, 1)","left":"0","textAlign":"center","bottom":"0","background":"#fff","width":"100%","lineHeight":"90px","fontSize":"18px","position":"absolute"}'>{{tushuxinxiList[3].tushumingcheng}}</div>
		</div>
		<div :style='{"width":"240px","margin":"0 10px","height":"275px"}' class="list-4-body">
			<div v-if="tushuxinxiList.length>4" @click="toDetail('tushuxinxiDetail', tushuxinxiList[4])" class="list-4-item animation-box item-4" :style='{"boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.302)","margin":"0 0 20px","overflow":"hidden","borderRadius":"57px","background":"#fff","width":"240px","position":"relative","height":"210px"}'>
				<img :style='{"width":"100%","objectFit":"cover","borderRadius":"105px","float":"left","height":"120px"}' :src="baseUrl + '/' + (tushuxinxiList[4].tushufengmian?tushuxinxiList[4].tushufengmian.split(',')[0]:'')" alt="" />
				<div class="list-4-item-title line1" :style='{"padding":"0 10px","color":"rgba(158, 158, 158, 1)","left":"0","textAlign":"center","bottom":"0","background":"#fff","width":"100%","lineHeight":"90px","fontSize":"18px","position":"absolute"}'>{{tushuxinxiList[4].tushumingcheng}}</div>
			</div>
			<div v-if="tushuxinxiList.length>5" @click="toDetail('tushuxinxiDetail', tushuxinxiList[5])" class="list-4-item animation-box item-5" :style='{"boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.302)","margin":"20px 0 0","overflow":"hidden","borderRadius":"10px","width":"240px","position":"relative","height":"210px"}'>
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"140px"}' :src="baseUrl + '/' + (tushuxinxiList[5].tushufengmian?tushuxinxiList[5].tushufengmian.split(',')[0]:'')" alt="" />
				<div class="list-4-item-title line1" :style='{"padding":"0 10px","color":"rgba(0, 0, 0, 0.3020)","left":"0","textAlign":"center","bottom":"0","background":"#fff","width":"100%","lineHeight":"70px","fontSize":"18px","position":"absolute"}'>{{tushuxinxiList[5].tushumingcheng}}</div>
			</div>
		</div>
	</div>
	
	
	
	<div @click="moreBtn('tushuxinxi')" :style='{"cursor":"pointer","margin":"50px 0 0 450px","borderColor":"rgba(255, 255, 255, 1)","borderRadius":"5px","textAlign":"center","borderWidth":"0 3px","display":"block","width":"100px","lineHeight":"32px","borderStyle":"solid"}'>
		<span :style='{"color":"rgba(255, 255, 255, 1)","fontSize":"16px"}'>View more</span>
		<i v-if="true" :style='{"color":"#f5f5f5","fontSize":"12px"}' class="el-icon-d-arrow-right"></i>
	</div>
	
</div>
</div>
</template>

<script>
  export default {
    //数据集合
    data() {
      return {
        baseUrl: '',
        queryList:[
          {
              queryName:"Book Name",
          },
        ],
        queryIndex: 0,
        tushuxinxitushumingcheng: '',
        newsList: [],

        tushuxinxiList: [],
      }
    },
    created() {
      this.baseUrl = this.$config.baseUrl;
      this.getNewsList();
      this.getList();
    },
    //方法集合
    methods: {
      search(tablename) {
        if (this.queryIndex == 0 && this.tushuxinxitushumingcheng) {
          this.$router.push({path: '/index/' + tablename, query: {indexQueryCondition: this.tushuxinxitushumingcheng}});
        }
      },
		getNewsList() {
			this.$http.get('news/list', {params: {
				page: 1,
				limit: 6,
			order: 'desc'}}).then(res => {
				if (res.data.code == 0) {
					this.newsList = res.data.data.list;
					
					
				}
			});
		},
		getList() {
          let autoSortUrl = "";
			
			this.$http.get('tushuxinxi/list', {params: {
				page: 1,
				limit: 6,
			}}).then(res => {
				if (res.data.code == 0) {
					this.tushuxinxiList = res.data.data.list;
					
					// porductlist样式五
					
				}
			});
		},
		toDetail(path, item) {
			this.$router.push({path: '/index/' + path, query: {detailObj: JSON.stringify(item)}});
		},
		moreBtn(path) {
			this.$router.push({path: '/index/' + path});
		}
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.home-preview {
	
		.recommend {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
        }
        
        .list5 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
		
		.news {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list6 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list6 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
	
		.lists {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
        }
        
        .list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-next {
            left: auto;
            right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
	}
</style>
