<template>
  <div class="main-content">
    <!-- listpage -->
    <template v-if="showFlag">
      <el-form
        class="center-form-pv"
        :style="{ margin: '0 0 20px' }"
        :inline="true"
        :model="searchForm"
      >
        <el-row :style="{ textAlign: 'right', display: 'block' }">
          <div :style="{ margin: '0 20px 0 0', display: 'inline-block' }">
            <label
              :style="{
                margin: '0 10px 0 0',
                color: '#000',
                display: 'inline-block',
                lineHeight: '40px',
                fontSize: '14px',
                fontWeight: '500',
                height: '40px',
              }"
              class="item-label"
              >Book Name</label
            >
            <el-input
              v-model="searchForm.tushumingcheng"
              placeholder="Book Name"
              clearable
            ></el-input>
          </div>
          <div :style="{ margin: '0 20px 0 0', display: 'inline-block' }">
            <label
              :style="{
                margin: '0 10px 0 0',
                color: '#000',
                display: 'inline-block',
                lineHeight: '40px',
                fontSize: '14px',
                fontWeight: '500',
                height: '40px',
              }"
              class="item-label"
              >Book Author</label
            >
            <el-input
              v-model="searchForm.tushuzuozhe"
              placeholder="Book Author"
              clearable
            ></el-input>
          </div>
          <div
            :style="{ margin: '0 20px 0 0', display: 'inline-block' }"
            class="select"
            label="Book quality"
            prop="tushuchengse"
          >
            <label
              :style="{
                margin: '0 10px 0 0',
                color: '#000',
                display: 'inline-block',
                lineHeight: '40px',
                fontSize: '14px',
                fontWeight: '500',
                height: '40px',
              }"
              class="item-label"
              >Book quality</label
            >
            <el-select
              @change="tushuchengseChange"
              clearable
              v-model="searchForm.tushuchengse"
              placeholder="Please select Book quality"
            >
              <el-option
                v-for="(item, index) in tushuchengseOptions"
                v-bind:key="index"
                :label="item"
                :value="item"
              ></el-option>
            </el-select>
          </div>
          <el-button
            :style="{
              border: '0',
              cursor: 'pointer',
              padding: '0 24px',
              backgroundColor: '#fff',
              color: '#333',
              backgroundImage:
                'url(http://codegen.caihongy.cn/20220727/d7a250a4599f4e7d9b11846454a93c80.png)',
              outline: 'none',
              borderRadius: '4px',
              width: '100px',
              fontSize: '14px',
              backgroundSize: '100% 100%',
              lineHeight: '60px',
              height: '60px',
            }"
            type="success"
            @click="search()"
            >Search</el-button
          >
        </el-row>

        <el-row :style="{ margin: '20px 0', display: 'flex' }">
          <el-button
            :style="{
              border: '0',
              cursor: 'pointer',
              padding: '0 24px',
              margin: '0 10px 0 0',
              backgroundColor: '#fff',
              color: '#333',
              backgroundImage:
                'url(http://codegen.caihongy.cn/20220727/d7a250a4599f4e7d9b11846454a93c80.png)',
              outline: 'none',
              borderRadius: '4px',
              width: '120px',
              fontSize: '14px',
              backgroundSize: 'cover',
              height: '55px',
            }"
            v-if="isAuth('tushuxinxi', 'Add')"
            type="success"
            @click="addOrUpdateHandler()"
            >Add</el-button
          >
          <el-button
            :style="{
              border: '0',
              cursor: 'pointer',
              padding: '0 24px',
              margin: '0 10px 0 0',
              backgroundColor: '#fff',
              color: '#333',
              backgroundImage:
                'url(http://codegen.caihongy.cn/20220727/d7a250a4599f4e7d9b11846454a93c80.png)',
              outline: 'none',
              borderRadius: '4px',
              width: '120px',
              fontSize: '14px',
              backgroundSize: 'cover',
              height: '55px',
            }"
            v-if="isAuth('tushuxinxi', 'Remove')"
            :disabled="dataListSelections.length <= 0"
            type="danger"
            @click="deleteHandler()"
            >Remove</el-button
          >
        </el-row>
      </el-form>

      <!-- <div> -->
      <el-table
        class="tables"
        :stripe="false"
        :style="{
          padding: '0',
          borderColor: 'rgba(227, 241, 245, 1)',
          borderRadius: '30px',
          borderWidth: '10px',
          background: '#fff',
          width: '100%',
          borderStyle: 'solid',
        }"
        v-if="isAuth('tushuxinxi', 'View')"
        :data="dataList"
        v-loading="dataListLoading"
        @selection-change="selectionChangeHandler"
      >
        <el-table-column
          :resizable="true"
          type="selection"
          align="center"
          width="50"
        ></el-table-column>
        <el-table-column
          :resizable="true"
          :sortable="false"
          label="Indexes"
          type="index"
          width="50"
        />
        <el-table-column
          :resizable="true"
          :sortable="false"
          prop="tushumingcheng"
          label="Book Name"
        >
          <template slot-scope="scope">
            {{ scope.row.tushumingcheng }}
          </template>
        </el-table-column>
        <el-table-column
          :resizable="true"
          :sortable="false"
          prop="tushufenlei"
          label="Book classification"
        >
          <template slot-scope="scope">
            {{ scope.row.tushufenlei }}
          </template>
        </el-table-column>
        <el-table-column
          :resizable="true"
          :sortable="false"
          prop="tushufengmian"
          width="200"
          label="Book Cover"
        >
          <template slot-scope="scope">
            <div v-if="scope.row.tushufengmian">
              <img
                :src="$base.url + scope.row.tushufengmian.split(',')[0]"
                width="100"
                height="100"
              />
            </div>
            <div v-else>No picture</div>
          </template>
        </el-table-column>
        <el-table-column
          :resizable="true"
          :sortable="false"
          prop="tushuzuozhe"
          label="Book Author"
        >
          <template slot-scope="scope">
            {{ scope.row.tushuzuozhe }}
          </template>
        </el-table-column>
        <el-table-column
          :resizable="true"
          :sortable="false"
          prop="tushuchengse"
          label="Book quality"
        >
          <template slot-scope="scope">
            {{ scope.row.tushuchengse }}
          </template>
        </el-table-column>
        <el-table-column
          :resizable="true"
          :sortable="false"
          prop="maijiaxuehao"
          label="Seller Number"
        >
          <template slot-scope="scope">
            {{ scope.row.maijiaxuehao }}
          </template>
        </el-table-column>
        <el-table-column
          :resizable="true"
          :sortable="false"
          prop="maijiaxingming"
          label="Seller Name"
        >
          <template slot-scope="scope">
            {{ scope.row.maijiaxingming }}
          </template>
        </el-table-column>
        <el-table-column
          :resizable="true"
          :sortable="false"
          prop="lianxidianhua"
          label="Contact Telephone"
        >
          <template slot-scope="scope">
            {{ scope.row.lianxidianhua }}
          </template>
        </el-table-column>
        <el-table-column
          :resizable="true"
          :sortable="false"
          prop="onelimittimes"
          label="Single limit"
        >
          <template slot-scope="scope">
            {{ scope.row.onelimittimes }}
          </template>
        </el-table-column>
        <el-table-column
          :resizable="true"
          :sortable="false"
          prop="alllimittimes"
          label="stock"
        >
          <template slot-scope="scope">
            {{ scope.row.alllimittimes }}
          </template>
        </el-table-column>
        <el-table-column
          :resizable="true"
          :sortable="false"
          prop="price"
          label="Price"
        >
          <template slot-scope="scope">
            {{ scope.row.price }}
          </template>
        </el-table-column>
        <el-table-column width="300" label=" operation">
          <template slot-scope="scope">
            <el-button
              :style="{
                border: '0',
                cursor: 'pointer',
                padding: '0 30px',
                margin: '0 10px 0 0',
                backgroundColor: '#fff',
                color: '#333',
                backgroundImage:
                  'url(http://codegen.caihongy.cn/20220727/d7a250a4599f4e7d9b11846454a93c80.png)',
                outline: 'none',
                borderRadius: '4px',
                width: 'auto',
                fontSize: '14px',
                backgroundSize: 'cover',
                height: '40px',
              }"
              v-if="isAuth('tushuxinxi', 'View')"
              type="success"
              size="mini"
              @click="addOrUpdateHandler(scope.row.id, 'info')"
              >Details</el-button
            >
            <el-button
              :style="{
                border: '0',
                cursor: 'pointer',
                padding: '0 30px',
                margin: '0 10px 0 0',
                backgroundColor: '#fff',
                color: '#333',
                backgroundImage:
                  'url(http://codegen.caihongy.cn/20220727/d7a250a4599f4e7d9b11846454a93c80.png)',
                outline: 'none',
                borderRadius: '4px',
                width: 'auto',
                fontSize: '14px',
                backgroundSize: 'cover',
                height: '40px',
              }"
              v-if="isAuth('tushuxinxi', 'Consultation chat')"
              type="success"
              size="mini"
              @click="
                liaotianjiluCrossAddOrUpdateHandler(
                  scope.row,
                  'cross',
                  '',
                  '',
                  ''
                )
              "
              >Consultation chat</el-button
            >
            <el-button
              :style="{
                border: '0',
                cursor: 'pointer',
                padding: '0 30px',
                margin: '0 10px 0 0',
                backgroundColor: '#fff',
                color: '#333',
                backgroundImage:
                  'url(http://codegen.caihongy.cn/20220727/d7a250a4599f4e7d9b11846454a93c80.png)',
                outline: 'none',
                borderRadius: '4px',
                width: 'auto',
                fontSize: '14px',
                backgroundSize: 'cover',
                height: '40px',
              }"
              v-if="isAuth('tushuxinxi', 'Update')"
              type="primary"
              size="mini"
              @click="addOrUpdateHandler(scope.row.id)"
              >Update</el-button
            >

            <el-button
              :style="{
                border: '0',
                cursor: 'pointer',
                padding: '0 30px',
                margin: '0 10px 0 0',
                backgroundColor: '#fff',
                color: '#333',
                backgroundImage:
                  'url(http://codegen.caihongy.cn/20220727/d7a250a4599f4e7d9b11846454a93c80.png)',
                outline: 'none',
                borderRadius: '4px',
                width: 'auto',
                fontSize: '14px',
                backgroundSize: 'cover',
                height: '40px',
              }"
              v-if="isAuth('tushuxinxi', 'View Comments')"
              type="primary"
              size="mini"
              @click="disscussListHandler(scope.row.id)"
              >View Comments</el-button
            >

            <el-button
              :style="{
                border: '0',
                cursor: 'pointer',
                padding: '0 30px',
                margin: '0 10px 0 0',
                backgroundColor: '#fff',
                color: '#333',
                backgroundImage:
                  'url(http://codegen.caihongy.cn/20220727/d7a250a4599f4e7d9b11846454a93c80.png)',
                outline: 'none',
                borderRadius: '4px',
                width: 'auto',
                fontSize: '14px',
                backgroundSize: 'cover',
                height: '40px',
              }"
              v-if="isAuth('tushuxinxi', 'Remove')"
              type="danger"
              size="mini"
              @click="deleteHandler(scope.row.id)"
              >Remove</el-button
            >
          </template>
        </el-table-column>
      </el-table>
      <el-pagination
        @size-change="sizeChangeHandle"
        @current-change="currentChangeHandle"
        :current-page="pageIndex"
        background
        :page-sizes="[10, 20, 30, 50]"
        :page-size="pageSize"
        :layout="layouts.join()"
        :total="totalPage"
        prev-text="<"
        next-text=">"
        :hide-on-single-page="false"
        :style="{
          padding: '0',
          margin: '20px 0 0',
          whiteSpace: 'nowrap',
          color: '#333',
          textAlign: 'center',
          width: '100%',
          fontWeight: '500',
        }"
      ></el-pagination>
      <!-- </div> -->
    </template>

    <!-- Add/Updatepage???  ???????????????search????????????????????????-->
    <add-or-update
      v-if="addOrUpdateFlag"
      :parent="this"
      ref="addOrUpdate"
    ></add-or-update>

    <liaotianjilu-cross-add-or-update
      v-if="liaotianjiluCrossAddOrUpdateFlag"
      :parent="this"
      ref="liaotianjiluCrossaddOrUpdate"
    ></liaotianjilu-cross-add-or-update>
  </div>
</template>

<script>
import axios from "axios";
import AddOrUpdate from "./add-or-update";
import liaotianjiluCrossAddOrUpdate from "../liaotianjilu/add-or-update";
export default {
  data() {
    return {
      searchForm: {
        key: "",
      },
      form: {},
      dataList: [],
      pageIndex: 1,
      pageSize: 10,
      totalPage: 0,
      dataListLoading: false,
      dataListSelections: [],
      showFlag: true,
      sfshVisiable: false,
      shForm: {},
      chartVisiable: false,
      addOrUpdateFlag: false,
      liaotianjiluCrossAddOrUpdateFlag: false,
      layouts: ["total", "prev", "pager", "next", "sizes", "jumper"],
    };
  },
  created() {
    this.init();
    this.getDataList();
    this.contentStyleChange();
  },
  mounted() {},
  filters: {
    htmlfilter: function (val) {
      return val.replace(/<[^>]*>/g).replace(/undefined/g, "");
    },
  },
  components: {
    AddOrUpdate,
    liaotianjiluCrossAddOrUpdate,
  },
  methods: {
    contentStyleChange() {
      this.contentPageStyleChange();
    },
    // ???page
    contentPageStyleChange() {
      let arr = [];

      // if(this.contents.pageTotal) arr.push('total')
      // if(this.contents.pageSizes) arr.push('sizes')
      // if(this.contents.pagePrevNext){
      //   arr.push('prev')
      //   if(this.contents.pagePager) arr.push('pager')
      //   arr.push('next')
      // }
      // if(this.contents.pageJumper) arr.push('jumper')
      // this.layouts = arr.join()
      // this.contents.pageEachNum = 10
    },

    liaotianjiluCrossAddOrUpdateHandler(
      row,
      type,
      crossOptAudit,
      statusColumnName,
      tips,
      statusColumnValue
    ) {
      this.showFlag = false;
      this.addOrUpdateFlag = false;
      this.liaotianjiluCrossAddOrUpdateFlag = true;
      this.$storage.set("crossObj", row);
      this.$storage.set("crossTable", "tushuxinxi");
      this.$storage.set("statusColumnName", statusColumnName);
      this.$storage.set("statusColumnValue", statusColumnValue);
      this.$storage.set("tips", tips);
      if (statusColumnName != "" && !statusColumnName.startsWith("[")) {
        var obj = this.$storage.getObj("crossObj");
        for (var o in obj) {
          if (o == statusColumnName && obj[o] == statusColumnValue) {
            this.$message({
              message: tips,
              type: "success",
              duration: 1500,
              onClose: () => {
                this.getDataList();
              },
            });
            this.showFlag = true;
            this.liaotianjiluCrossAddOrUpdateFlag = false;
            return;
          }
        }
      }
      this.$nextTick(() => {
        this.$refs.liaotianjiluCrossaddOrUpdate.init(row.id, type);
      });
    },
    init() {
      this.tushuchengseOptions = "New,90% new,80% new,70% new and below".split(
        ","
      );
    },
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },

    // ????????????list
    getDataList() {
      this.dataListLoading = true;
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        sort: "id",
        order: "desc",
      };
      if (
        this.searchForm.tushumingcheng != "" &&
        this.searchForm.tushumingcheng != undefined
      ) {
        params["tushumingcheng"] = "%" + this.searchForm.tushumingcheng + "%";
      }
      if (
        this.searchForm.tushuzuozhe != "" &&
        this.searchForm.tushuzuozhe != undefined
      ) {
        params["tushuzuozhe"] = "%" + this.searchForm.tushuzuozhe + "%";
      }
      if (
        this.searchForm.tushuchengse != "" &&
        this.searchForm.tushuchengse != undefined
      ) {
        params["tushuchengse"] = this.searchForm.tushuchengse;
      }
      this.$http({
        url: "tushuxinxi/page",
        method: "get",
        params: params,
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.dataList = data.data.list;
          this.totalPage = data.data.total;
        } else {
          this.dataList = [];
          this.totalPage = 0;
        }
        this.dataListLoading = false;
      });
    },
    // ???page???
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // ??????page
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // ??????
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },
    // Add/Update
    addOrUpdateHandler(id, type) {
      this.showFlag = false;
      this.addOrUpdateFlag = true;
      this.crossAddOrUpdateFlag = false;
      if (type != "info") {
        type = "else";
      }
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id, type);
      });
    },
    // View Comments
    disscussListHandler(id, type) {
      this.$router.push({ path: "/discusstushuxinxi", query: { refid: id } });
    },
    // ??????
    download(file) {
      window.open(`${file}`);
    },
    // Remove
    deleteHandler(id) {
      var ids = id
        ? [Number(id)]
        : this.dataListSelections.map((item) => {
            return Number(item.id);
          });
      this.$confirm(
        `Confirm to [${id ? "Remove" : "Batch Remove"}] operation?`,
        "Tips",
        {
          confirmButtonText: "OK",
          cancelButtonText: "Cancel",
          type: "warning",
        }
      ).then(() => {
        this.$http({
          url: "tushuxinxi/delete",
          method: "post",
          data: ids,
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "Operation succeeded",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.search();
              },
            });
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    },
  },
};
</script>
<style lang="scss" scoped>
.center-form-pv {
  .el-date-editor.el-input {
    width: auto;
  }
}

.el-input {
  width: auto;
}

// form
.center-form-pv .el-input /deep/ .el-input__inner {
  border: 0;
  border-radius: 4px;
  padding: 0 12px;
  outline: none;
  background-size: 100% 100%;
  color: #333;
  width: 180px;
  font-size: 14px;
  line-height: 60px;
  background-image: url(http://codegen.caihongy.cn/20220729/9223ea93d61544b1879f881a4f61285e.png);
  text-align: center;
  height: 60px;
}

.center-form-pv .el-select /deep/ .el-input__inner {
  border: 0;
  border-radius: 4px;
  padding: 0 10px;
  background-size: 100% 100%;
  color: #333;
  width: 180px;
  font-size: 14px;
  line-height: 60px;
  background-image: url(http://codegen.caihongy.cn/20220729/9223ea93d61544b1879f881a4f61285e.png);
  text-align: center;
  height: 60px;
}

.center-form-pv .el-date-editor /deep/ .el-input__inner {
  border: 0;
  padding: 0 10px;
  background-size: 100% 100%;
  color: #333;
  font-size: 14px;
  line-height: 60px;
  background-color: #fff;
  border-radius: 4px;
  outline: none;
  width: 180px;
  background-image: url(http://codegen.caihongy.cn/20220729/9223ea93d61544b1879f881a4f61285e.png);
  text-align: center;
  height: 60px;
}

// table
.el-table /deep/ .el-table__header-wrapper thead {
  color: #333;
  font-weight: 500;
  width: 100%;
}

.el-table /deep/ .el-table__header-wrapper thead tr {
  background: #fff;
}

.el-table /deep/ .el-table__header-wrapper thead tr th {
  padding: 12px 0;
  background: rgba(160, 180, 200, 1);
  border-color: #eee;
  border-width: 0 1px 1px 0;
  border-style: solid;
  text-align: center;
}

.el-table /deep/ .el-table__header-wrapper thead tr th .cell {
  padding: 0 10px;
  word-wrap: normal;
  word-break: break-all;
  white-space: normal;
  font-weight: bold;
  display: inline-block;
  vertical-align: middle;
  width: 100%;
  line-height: 24px;
  position: relative;
  text-overflow: ellipsis;
}

.el-table /deep/ .el-table__body-wrapper tbody {
  width: 100%;
}

.el-table /deep/ .el-table__body-wrapper tbody tr {
  background: #fff;
}

.el-table /deep/ .el-table__body-wrapper tbody tr td {
  padding: 12px 0;
  color: #999;
  background: #fff;
  border-color: #eee;
  border-width: 0 1px 1px 0;
  border-style: solid;
  text-align: center;
}

.el-table /deep/ .el-table__body-wrapper tbody tr:hover td {
  padding: 12px 0;
  color: #333;
  border-color: #ddd;
  border-width: 0 1px 1px 0;
  border-style: solid;
  text-align: center;
}

.el-table /deep/ .el-table__body-wrapper tbody tr td {
  padding: 12px 0;
  color: #999;
  background: #fff;
  border-color: #eee;
  border-width: 0 1px 1px 0;
  border-style: solid;
  text-align: center;
}

.el-table /deep/ .el-table__body-wrapper tbody tr td .cell {
  padding: 0 10px;
  overflow: hidden;
  word-break: break-all;
  white-space: normal;
  line-height: 24px;
  text-overflow: ellipsis;
}

// pagination
.main-content .el-pagination /deep/ .el-pagination__total {
  margin: 0 10px 0 0;
  color: #666;
  font-weight: 400;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  height: 28px;
}

.main-content .el-pagination /deep/ .btn-prev {
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

.main-content .el-pagination /deep/ .btn-next {
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

.main-content .el-pagination /deep/ .btn-prev:disabled {
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

.main-content .el-pagination /deep/ .btn-next:disabled {
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

.main-content .el-pagination /deep/ .el-pager {
  padding: 0;
  margin: 0;
  display: inline-block;
  vertical-align: top;
}

.main-content .el-pagination /deep/ .el-pager .number {
  cursor: pointer;
  padding: 0 4px;
  margin: 0 5px;
  color: #666;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  border-radius: 2px;
  background: #f4f4f5;
  text-align: center;
  min-width: 30px;
  height: 28px;
}

.main-content .el-pagination /deep/ .el-pager .number:hover {
  cursor: pointer;
  padding: 0 4px;
  margin: 0 5px;
  color: #a0b4c8;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  border-radius: 2px;
  background: #f4f4f5;
  text-align: center;
  min-width: 30px;
  height: 28px;
}

.main-content .el-pagination /deep/ .el-pager .number.active {
  cursor: default;
  padding: 0 4px;
  margin: 0 5px;
  color: #fff;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  border-radius: 2px;
  background: #a0b4c8;
  text-align: center;
  min-width: 30px;
  height: 28px;
}

.main-content .el-pagination /deep/ .el-pagination__sizes {
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  height: 28px;
}

.main-content .el-pagination /deep/ .el-pagination__sizes .el-input {
  margin: 0 5px;
  width: 100px;
  position: relative;
}

.main-content
  .el-pagination
  /deep/
  .el-pagination__sizes
  .el-input
  .el-input__inner {
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

.main-content
  .el-pagination
  /deep/
  .el-pagination__sizes
  .el-input
  span.el-input__suffix {
  top: 0;
  position: absolute;
  right: 0;
  height: 100%;
}

.main-content
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

.main-content .el-pagination /deep/ .el-pagination__jump {
  margin: 0 0 0 24px;
  color: #606266;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  height: 28px;
}

.main-content .el-pagination /deep/ .el-pagination__jump .el-input {
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

.main-content
  .el-pagination
  /deep/
  .el-pagination__jump
  .el-input
  .el-input__inner {
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
