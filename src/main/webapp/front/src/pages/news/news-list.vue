<template>
<div>
	<div :style='{"width":"1200px","padding":"20px","margin":"10px auto","background":"linear-gradient(90deg, rgba(168,69,67,0.2) 0%, #6D3737 55%, rgba(247,196,195,0.2) 100%)"}' class="breadcrumb-preview">
		<el-breadcrumb :separator="'/'" :style='{"fontSize":"14px","lineHeight":"14px"}'>
			<el-breadcrumb-item>Home</el-breadcrumb-item>
			<el-breadcrumb-item v-for="(item, index) in breadcrumbItem" :key="index">{{item.name}}</el-breadcrumb-item>
		</el-breadcrumb>
	</div>
	<div :style='{"width":"1200px","padding":"20px","margin":"10px auto","background":"linear-gradient(90deg, rgba(168,69,67,0.2) 0%, #6D3737 55%, rgba(247,196,195,0.2) 100%)"}' class="breadcrumb-preview">
        <el-form :inline="true" :model="formSearch" class="list-form-pv">
            <div class="section-btn">
                <el-form-item>
                  <el-input v-model="title" placeholder="Title"></el-input>
                </el-form-item>
              <el-button type="primary" @click="getNewsList(1)"><i class="el-icon-search"></i>Search</el-button>
            </div>
        </el-form>
	</div>
	
	<div class="news-preview" :style='{"width":"1200px","margin":"10px auto","position":"relative","background":"#fff"}'>
				
				
				
				
				
				
				<!-- 样式七 -->
		<div class="list7 index-pv1" :style='{"width":"100%","flexWrap":"wrap","display":"flex","height":"auto"}'>
			<div :style='{"padding":"10px","boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.302)","margin":"10px","borderRadius":"10px","background":"#fff","width":"570px","position":"relative","height":"150px"}' v-for="item in newsList" :key="item.id" @click="toNewsDetail(item)" class="list-item animation-box">
				<div :style='{"color":"rgba(158, 158, 158, 1)","lineHeight":"32px","fontSize":"14px"}' class="title ">{{item.title}}</div>
				<div :style='{"lineHeight":"21px","fontSize":"14px","overflow":"hidden","color":"rgba(158, 158, 158, 1)","height":"65px"}' class="introduction ">{{item.introduction}}</div>
				<div :style='{"padding":"0 10px","color":"#fff","bottom":"0","background":"rgba(197, 19, 19, 1)","lineHeight":"32px","fontSize":"12px","position":"absolute","right":"20px"}' class="time ">{{item.addtime}}</div>
				<div :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"32px","color":"#fff","background":"#333","display":"inline-block"}' class="tags"></div>
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
		  :layout='["pager"].join()'
		  :total="total"
		  :style='{"padding":"0","margin":"25px auto","whiteSpace":"nowrap","color":"#333","textAlign":"center","width":"1200px","fontWeight":"500"}'
		  @current-change="curChange"
		  @prev-click="prevClick"
		  @next-click="nextClick"
		></el-pagination>
	</div>
</div>
</template>

<script>
  export default {
    //数据集合
    data() {
      return {
        baseUrl: this.$config.baseUrl,
        breadcrumbItem: [
          {
            name: 'Notice information'
          }
        ],
        newsList: [],
        total: 1,
        pageSize: 10,
        totalPage: 1,
		layouts: '',
        title: '',
      }
    },
    created() {
		this.getNewsList(1);
    },
    //方法集合
    methods: {
      getNewsList(page) {
        let params = {page, limit: this.pageSize};
        let searchWhere = {};
        if(this.title != '') searchWhere.title = '%' + this.title + '%';
        this.$http.get('news/list', {params: Object.assign(params, searchWhere)}).then(res => {
          if (res.data.code == 0) {
            this.newsList = res.data.data.list;
            this.total = res.data.data.total;
            this.pageSize = res.data.data.pageSize;
            this.totalPage = res.data.data.totalPage;
          }
        });
      },
      curChange(page) {
        this.getNewsList(page);
      },
      prevClick(page) {
        this.getNewsList(page);
      },
      nextClick(page) {
        this.getNewsList(page);
      },
      toNewsDetail(item) {
        this.$router.push({path: '/index/newsDetail', query: {detailObj: JSON.stringify(item)}});
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.news-wrap {
	  width: 1000px;
	  margin: 0 auto;
	}
	.news-item {
	  height: 200px;
	  width: auto;
	  margin-bottom: 30px;
	  cursor: pointer;
	}
	.news-item-text {
	  width: calc(100% - 215px);
	  display: inline-block;
	  vertical-align: top;
	  margin-left: 15px;
	}
	.news-item-text-title {
	  font-size: 16px;
	  margin-bottom: 15px;
	}
	.news-item-text-intro {
	  font-size: 14px;
	  color: #666;
	}
	
	.hide1 {
		text-overflow: ellipsis;
		display: -webkit-box;
		-webkit-line-clamp: 1;
		-webkit-box-orient: vertical;
		overflow:hidden;
		text-overflow:ellipsis;
	}
	.hide2 {
		text-overflow: ellipsis;
		display: -webkit-box;
		-webkit-line-clamp: 2;
		-webkit-box-orient: vertical;
		overflow:hidden;
		text-overflow:ellipsis;
	}
	.hide3 {
		text-overflow: ellipsis;
		display: -webkit-box;
		-webkit-line-clamp: 3;
		-webkit-box-orient: vertical;
		overflow:hidden;
		text-overflow:ellipsis;
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
				color: #C0C4CC;
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
				color: #C0C4CC;
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
				border: 1px solid #DCDFE6;
				cursor: pointer;
				padding: 0 25px 0 8px;
				color: #606266;
				display: inline-block;
				font-size: 13px;
				line-height: 28px;
				border-radius: 3px;
				outline: 0;
				background: #FFF;
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
	
	.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
				cursor: pointer;
				color: #C0C4CC;
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
				border: 1px solid #DCDFE6;
				cursor: pointer;
				padding: 0 3px;
				color: #606266;
				display: inline-block;
				font-size: 14px;
				line-height: 28px;
				border-radius: 3px;
				outline: 0;
				background: #FFF;
				width: 100%;
				text-align: center;
				height: 28px;
			}
</style>
