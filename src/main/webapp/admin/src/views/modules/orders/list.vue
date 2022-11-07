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
              >Order Number</label
            >
            <el-input
              v-model="searchForm.orderid"
              placeholder="Order Number"
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
              >Product Name</label
            >
            <el-input
              v-model="searchForm.goodname"
              placeholder="Product Name"
              clearable
            ></el-input>
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
            v-if="isAuth('orders' + '/' + orderStatus, 'Add')"
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
            v-if="isAuth('orders' + '/' + orderStatus, 'Remove')"
            :disabled="dataListSelections.length <= 0"
            type="danger"
            @click="deleteHandler()"
            >Remove</el-button
          >

          <download-excel
            v-if="isAuth('orders' + '/' + orderStatus, '导出')"
            class="export-excel-wrapper"
            :data="dataList"
            :fields="json_fields"
            name="Order.xls"
          >
            <!-- 导出excel -->
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
              type="danger"
              >导出</el-button
            >
          </download-excel>

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
            v-if="isAuth('orders' + '/' + orderStatus, 'Daily sales')"
            type="warning"
            @click="dayNumberChartDialog()"
            >Daily sales</el-button
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
            v-if="isAuth('orders' + '/' + orderStatus, 'Monthly sales')"
            type="warning"
            @click="monthNumberChartDialog()"
            >Monthly sales</el-button
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
            v-if="isAuth('orders' + '/' + orderStatus, 'Annual sales')"
            type="warning"
            @click="yearNumberChartDialog()"
            >Annual sales</el-button
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
            v-if="isAuth('orders' + '/' + orderStatus, 'Commodity sales')"
            type="warning"
            @click="goodnameNumberChartDialog()"
            >Commodity sales</el-button
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
            v-if="isAuth('orders' + '/' + orderStatus, 'Type Sales')"
            type="warning"
            @click="goodtypeNumberChartDialog()"
            >Type Sales</el-button
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
            v-if="isAuth('orders' + '/' + orderStatus, 'Daily sales amount')"
            type="warning"
            @click="dayAmountChartDialog()"
            >Daily sales amount</el-button
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
            v-if="isAuth('orders' + '/' + orderStatus, 'Monthly sales amount')"
            type="warning"
            @click="monthAmountChartDialog()"
            >Monthly sales amount</el-button
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
            v-if="isAuth('orders' + '/' + orderStatus, 'Annual sales amount')"
            type="warning"
            @click="yearAmountChartDialog()"
            >Annual sales amount</el-button
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
            v-if="isAuth('orders' + '/' + orderStatus, 'Product sales amount')"
            type="warning"
            @click="goodnameAmountChartDialog()"
            >Product sales amount</el-button
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
            v-if="isAuth('orders' + '/' + orderStatus, 'Type sales amount')"
            type="warning"
            @click="goodtypeAmountChartDialog()"
            >Type sales amount</el-button
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
        v-if="isAuth('orders' + '/' + orderStatus, 'View')"
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
          prop="orderid"
          label="Order Number"
        >
          <template slot-scope="scope">
            {{ scope.row.orderid }}
          </template>
        </el-table-column>
        <el-table-column
          :resizable="true"
          :sortable="false"
          prop="goodname"
          label="Product Name"
        >
          <template slot-scope="scope">
            {{ scope.row.goodname }}
          </template>
        </el-table-column>
        <el-table-column
          :resizable="true"
          :sortable="false"
          prop="picture"
          width="200"
          label="Product Picture"
        >
          <template slot-scope="scope">
            <div v-if="scope.row.picture">
              <img
                :src="$base.url + scope.row.picture.split(',')[0]"
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
          prop="buynumber"
          label="Purchase Quantity"
        >
          <template slot-scope="scope">
            {{ scope.row.buynumber }}
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
        <el-table-column
          :resizable="true"
          :sortable="false"
          prop="discountprice"
          label="Discount Price"
        >
          <template slot-scope="scope">
            {{ scope.row.discountprice }}
          </template>
        </el-table-column>
        <el-table-column
          :resizable="true"
          :sortable="false"
          prop="total"
          label="Total Price"
        >
          <template slot-scope="scope">
            {{ scope.row.total }}
          </template>
        </el-table-column>
        <el-table-column
          :resizable="true"
          :sortable="false"
          prop="discounttotal"
          label="Discount Price"
        >
          <template slot-scope="scope">
            {{ scope.row.discounttotal }}
          </template>
        </el-table-column>
        <el-table-column
          :resizable="true"
          :sortable="false"
          prop="type"
          :formatter="orderStatusFormatter"
          label="Payment Type"
        >
        </el-table-column>
        <el-table-column
          :resizable="true"
          :sortable="false"
          prop="status"
          label="Status"
        >
          <template slot-scope="scope">
            {{ scope.row.status }}
          </template>
        </el-table-column>
        <el-table-column
          :resizable="true"
          :sortable="false"
          prop="address"
          label="Address"
        >
          <template slot-scope="scope">
            {{ scope.row.address }}
          </template>
        </el-table-column>
        <el-table-column
          :resizable="true"
          :sortable="false"
          prop="tel"
          label="Telephone"
        >
          <template slot-scope="scope">
            {{ scope.row.tel }}
          </template>
        </el-table-column>
        <el-table-column
          :resizable="true"
          :sortable="false"
          prop="consignee"
          label="Consignee"
        >
          <template slot-scope="scope">
            {{ scope.row.consignee }}
          </template>
        </el-table-column>
        <el-table-column
          :resizable="true"
          :sortable="false"
          prop="remark"
          label="Remarks"
        >
          <template slot-scope="scope">
            {{ scope.row.remark }}
          </template>
        </el-table-column>
        <el-table-column
          :resizable="true"
          :sortable="false"
          prop="maijiaxuehao"
          label="Merchant Name"
        >
          <template slot-scope="scope">
            {{ scope.row.maijiaxuehao }}
          </template>
        </el-table-column>
        <el-table-column
          :resizable="true"
          :sortable="false"
          prop="tel"
          label="Order time"
        >
          <template slot-scope="scope">
            {{ scope.row.addtime }}
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
              v-if="isAuth('orders' + '/' + orderStatus, 'View')"
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
              v-if="isAuth('orders' + '/' + orderStatus, 'Update')"
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
              v-if="isAuth('orders' + '/' + orderStatus, 'logistics')"
              type="primary"
              size="mini"
              @click="logisticsUpdate(scope.row.id)"
              >logistics</el-button
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
              v-if="isAuth('orders' + '/' + orderStatus, 'Deliver goods')"
              type="primary"
              size="mini"
              @click="updateHandler(scope.row)"
              >Deliver goods</el-button
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
              v-if="isAuth('orders' + '/' + orderStatus, 'Confirm receipt')"
              type="primary"
              size="mini"
              @click="updateHandler2(scope.row)"
              >Confirm receipt</el-button
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
              v-if="isAuth('orders' + '/' + orderStatus, 'Remove')"
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

    <!-- Add/Updatepage面  将父组件的search方法传递给子组件-->
    <add-or-update
      v-if="addOrUpdateFlag"
      :parent="this"
      ref="addOrUpdate"
    ></add-or-update>

    <el-dialog
      title="Daily sales"
      :visible.sync="dayNumberChartVisiable"
      width="800"
    >
      <div id="dayNumberChart" style="width: 100%; height: 600px"></div>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dayNumberChartDialog">Return</el-button>
      </span>
    </el-dialog>

    <el-dialog
      title="Monthly sales"
      :visible.sync="monthNumberChartVisiable"
      width="800"
    >
      <div id="monthNumberChart" style="width: 100%; height: 600px"></div>
      <span slot="footer" class="dialog-footer">
        <el-button @click="monthNumberChartDialog">Return</el-button>
      </span>
    </el-dialog>

    <el-dialog
      title="Annual sales"
      :visible.sync="yearNumberChartVisiable"
      width="800"
    >
      <div id="yearNumberChart" style="width: 100%; height: 600px"></div>
      <span slot="footer" class="dialog-footer">
        <el-button @click="yearNumberChartDialog">Return</el-button>
      </span>
    </el-dialog>

    <el-dialog
      title="Commodity sales"
      :visible.sync="goodnameNumberChartVisiable"
      width="800"
    >
      <div id="goodnameNumberChart" style="width: 100%; height: 600px"></div>
      <span slot="footer" class="dialog-footer">
        <el-button @click="goodnameNumberChartDialog">Return</el-button>
      </span>
    </el-dialog>

    <el-dialog
      title="Type Sales"
      :visible.sync="goodtypeNumberChartVisiable"
      width="800"
    >
      <div id="goodtypeNumberChart" style="width: 100%; height: 600px"></div>
      <span slot="footer" class="dialog-footer">
        <el-button @click="goodtypeNumberChartDialog">Return</el-button>
      </span>
    </el-dialog>

    <el-dialog
      title="Daily sales amount"
      :visible.sync="dayAmountChartVisiable"
      width="800"
    >
      <div id="dayAmountChart" style="width: 100%; height: 600px"></div>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dayAmountChartDialog">Return</el-button>
      </span>
    </el-dialog>

    <el-dialog
      title="Monthly sales amount"
      :visible.sync="monthAmountChartVisiable"
      width="800"
    >
      <div id="monthAmountChart" style="width: 100%; height: 600px"></div>
      <span slot="footer" class="dialog-footer">
        <el-button @click="monthAmountChartDialog">Return</el-button>
      </span>
    </el-dialog>

    <el-dialog
      title="Annual sales amount"
      :visible.sync="yearAmountChartVisiable"
      width="800"
    >
      <div id="yearAmountChart" style="width: 100%; height: 600px"></div>
      <span slot="footer" class="dialog-footer">
        <el-button @click="yearAmountChartDialog">Return</el-button>
      </span>
    </el-dialog>

    <el-dialog
      title="Product sales amount"
      :visible.sync="goodnameAmountChartVisiable"
      width="800"
    >
      <div id="goodnameAmountChart" style="width: 100%; height: 600px"></div>
      <span slot="footer" class="dialog-footer">
        <el-button @click="goodnameAmountChartDialog">Return</el-button>
      </span>
    </el-dialog>

    <el-dialog
      title="Type sales amount"
      :visible.sync="goodtypeAmountChartVisiable"
      width="800"
    >
      <div id="goodtypeAmountChart" style="width: 100%; height: 600px"></div>
      <span slot="footer" class="dialog-footer">
        <el-button @click="goodtypeAmountChartDialog">Return</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import axios from "axios";
import AddOrUpdate from "./add-or-update";
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
      dayNumberChartVisiable: false,
      monthNumberChartVisiable: false,
      yearNumberChartVisiable: false,
      goodnameNumberChartVisiable: false,
      goodtypeNumberChartVisiable: false,
      dayAmountChartVisiable: false,
      monthAmountChartVisiable: false,
      yearAmountChartVisiable: false,
      goodnameAmountChartVisiable: false,
      goodtypeAmountChartVisiable: false,
      addOrUpdateFlag: false,
      layouts: ["total", "prev", "pager", "next", "sizes", "jumper"],
      orderStatus: this.$route.params.status,

      //导出excel
      json_fields: {
        "Order Number": "orderid", //常规字段
        Commodity table: "tablename", //常规字段
        userid: "userid", //常规字段
        porductid: "goodid", //常规字段
        "Product Name": "goodname", //常规字段
        "Product Picture": "picture", //常规字段
        "Purchase Quantity": "buynumber", //常规字段
        Price: "price", //常规字段
        "Discount Price": "discountprice", //常规字段
        "Total Price": "total", //常规字段
        "Discount Price": "discounttotal", //常规字段
        "Payment Type": "type", //常规字段
        Status: "status", //常规字段
        Address: "address", //常规字段
        Telephone: "tel", //常规字段
        Consignee: "consignee", //常规字段
        Remarks: "remark", //常规字段
        logistics: "logistics", //常规字段
        "Merchant Name": "maijiaxuehao", //常规字段
      },
      json_meta: [
        [
          {
            " key ": " charset ",
            " value ": " utf- 8 ",
          },
        ],
      ],
    };
  },
  created() {
    this.init();
    this.getDataList();
    this.contentStyleChange();
  },
  mounted() {},
  //监听Order表参数是否变化，从而调取接口
  watch: {
    $route(to, from) {
      //监听路由是否变化
      if (this.$route.params.status) {
        //判断Status是否有value
        //调数据
        this.orderStatus = this.$route.params.status;
        this.getDataList();
        this.contentStyleChange();
      }
    },
  },
  filters: {
    htmlfilter: function (val) {
      return val.replace(/<[^>]*>/g).replace(/undefined/g, "");
    },
  },
  components: {
    AddOrUpdate,
  },
  methods: {
    orderStatusFormatter: function (row, column) {
      var temp = "";
      // 处理逻辑 Save接口 数据，进行匹配 name
      switch (row.type - 0) {
        case 1:
          temp = "cash";
          break;
        case 2:
          temp = "integral";
          break;
        case 3:
          temp = "Scrabble dough";
          break;
      }
      return temp;
    },
    updateHandler(row) {
      this.$confirm(`Confirm to Deliver goods operation?`, "Tips", {
        confirmButtonText: "OK",
        cancelButtonText: "Cancel",
        type: "warning",
      }).then(() => {
        row.status = "Shipped";
        this.$http({
          url: `orders/update`,
          method: "post",
          data: row,
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
    updateHandler2(row) {
      this.$confirm(`Confirm goods received?`, "Tips", {
        confirmButtonText: "OK",
        cancelButtonText: "Cancel",
        type: "warning",
      }).then(() => {
        row.status = "Completed";
        this.$http({
          url: `orders/update`,
          method: "post",
          data: row,
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
    //logistics
    logisticsUpdate(id, type) {
      this.showFlag = false;
      this.addOrUpdateFlag = true;
      this.crossAddOrUpdateFlag = false;
      if (type != "info") {
        type = "logistics";
      }
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id, type);
      });
    },
    contentStyleChange() {
      this.contentPageStyleChange();
    },
    // 分page
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

    dayNumberChartDialog() {
      this.dayNumberChartVisiable = !this.dayNumberChartVisiable;
      this.$nextTick(() => {
        var dayNumberChart = this.$echarts.init(
          document.getElementById("dayNumberChart"),
          "macarons"
        );
        this.$http({
          url: `orders/value/addtime/buynumber/日`,
          method: "get",
        }).then(({ data }) => {
          if (data && data.code === 0) {
            let res = data.data;
            let xAxis = [];
            let yAxis = [];
            let pArray = [];
            for (let i = 0; i < res.length; i++) {
              xAxis.push(res[i].addtime);
              yAxis.push(parseFloat(res[i].total));
              pArray.push({
                value: parseFloat(res[i].total),
                name: res[i].addtime,
              });
              var option = {};
              option = {
                tooltip: {
                  trigger: "item",
                  formatter: "{b} : {c}",
                },
                title: {
                  text: "Daily sales",
                  left: "center",
                },
                xAxis: {
                  type: "category",
                  data: xAxis,
                },
                yAxis: {
                  type: "value",
                },
                series: [
                  {
                    data: yAxis,
                    type: "bar",
                  },
                ],
              };
              // 使用刚指定的配置项和数据显示图表。
              dayNumberChart.setOption(option);
              //根据窗口的大小变动图表
              window.onresize = function () {
                dayNumberChart.resize();
              };
            }
          }
        });
      });
    },

    monthNumberChartDialog() {
      this.monthNumberChartVisiable = !this.monthNumberChartVisiable;
      this.$nextTick(() => {
        var monthNumberChart = this.$echarts.init(
          document.getElementById("monthNumberChart"),
          "macarons"
        );
        this.$http({
          url: `orders/value/addtime/buynumber/月`,
          method: "get",
        }).then(({ data }) => {
          if (data && data.code === 0) {
            let res = data.data;
            let xAxis = [];
            let yAxis = [];
            let pArray = [];
            for (let i = 0; i < res.length; i++) {
              xAxis.push(res[i].addtime);
              yAxis.push(parseFloat(res[i].total));
              pArray.push({
                value: parseFloat(res[i].total),
                name: res[i].addtime,
              });
              var option = {};
              option = {
                tooltip: {
                  trigger: "item",
                  formatter: "{b} : {c}",
                },
                title: {
                  text: "Monthly sales",
                  left: "center",
                },
                xAxis: {
                  type: "category",
                  data: xAxis,
                },
                yAxis: {
                  type: "value",
                },
                series: [
                  {
                    data: yAxis,
                    type: "bar",
                  },
                ],
              };
              // 使用刚指定的配置项和数据显示图表。
              monthNumberChart.setOption(option);
              //根据窗口的大小变动图表
              window.onresize = function () {
                monthNumberChart.resize();
              };
            }
          }
        });
      });
    },

    yearNumberChartDialog() {
      this.yearNumberChartVisiable = !this.yearNumberChartVisiable;
      this.$nextTick(() => {
        var yearNumberChart = this.$echarts.init(
          document.getElementById("yearNumberChart"),
          "macarons"
        );
        this.$http({
          url: `orders/value/addtime/buynumber/年`,
          method: "get",
        }).then(({ data }) => {
          if (data && data.code === 0) {
            let res = data.data;
            let xAxis = [];
            let yAxis = [];
            let pArray = [];
            for (let i = 0; i < res.length; i++) {
              xAxis.push(res[i].addtime);
              yAxis.push(parseFloat(res[i].total));
              pArray.push({
                value: parseFloat(res[i].total),
                name: res[i].addtime,
              });
              var option = {};
              option = {
                tooltip: {
                  trigger: "item",
                  formatter: "{b} : {c}",
                },
                title: {
                  text: "Annual sales",
                  left: "center",
                },
                xAxis: {
                  type: "category",
                  data: xAxis,
                },
                yAxis: {
                  type: "value",
                },
                series: [
                  {
                    data: yAxis,
                    type: "bar",
                  },
                ],
              };
              // 使用刚指定的配置项和数据显示图表。
              yearNumberChart.setOption(option);
              //根据窗口的大小变动图表
              window.onresize = function () {
                yearNumberChart.resize();
              };
            }
          }
        });
      });
    },

    goodnameNumberChartDialog() {
      this.goodnameNumberChartVisiable = !this.goodnameNumberChartVisiable;
      this.$nextTick(() => {
        var goodnameNumberChart = this.$echarts.init(
          document.getElementById("goodnameNumberChart"),
          "macarons"
        );
        this.$http({
          url: `orders/value/goodname/buynumber`,
          method: "get",
        }).then(({ data }) => {
          if (data && data.code === 0) {
            let res = data.data;
            let xAxis = [];
            let yAxis = [];
            let pArray = [];
            for (let i = 0; i < res.length; i++) {
              xAxis.push(res[i].goodname);
              yAxis.push(parseFloat(res[i].total));
              pArray.push({
                value: parseFloat(res[i].total),
                name: res[i].goodname,
              });
              var option = {};
              option = {
                tooltip: {
                  trigger: "item",
                  formatter: "{b} : {c}",
                },
                title: {
                  text: "Commodity sales",
                  left: "center",
                },
                xAxis: {
                  type: "category",
                  data: xAxis,
                },
                yAxis: {
                  type: "value",
                },
                series: [
                  {
                    data: yAxis,
                    type: "bar",
                  },
                ],
              };
              // 使用刚指定的配置项和数据显示图表。
              goodnameNumberChart.setOption(option);
              //根据窗口的大小变动图表
              window.onresize = function () {
                goodnameNumberChart.resize();
              };
            }
          }
        });
      });
    },

    goodtypeNumberChartDialog() {
      this.goodtypeNumberChartVisiable = !this.goodtypeNumberChartVisiable;
      this.$nextTick(() => {
        var goodtypeNumberChart = this.$echarts.init(
          document.getElementById("goodtypeNumberChart"),
          "macarons"
        );
        this.$http({
          url: `orders/value/goodtype/buynumber`,
          method: "get",
        }).then(({ data }) => {
          if (data && data.code === 0) {
            let res = data.data;
            let xAxis = [];
            let yAxis = [];
            let pArray = [];
            for (let i = 0; i < res.length; i++) {
              xAxis.push(res[i].goodtype);
              yAxis.push(parseFloat(res[i].total));
              pArray.push({
                value: parseFloat(res[i].total),
                name: res[i].goodtype,
              });
              var option = {};
              option = {
                tooltip: {
                  trigger: "item",
                  formatter: "{b} : {c}",
                },
                title: {
                  text: "Type Sales",
                  left: "center",
                },
                xAxis: {
                  type: "category",
                  data: xAxis,
                },
                yAxis: {
                  type: "value",
                },
                series: [
                  {
                    data: yAxis,
                    type: "bar",
                  },
                ],
              };
              // 使用刚指定的配置项和数据显示图表。
              goodtypeNumberChart.setOption(option);
              //根据窗口的大小变动图表
              window.onresize = function () {
                goodtypeNumberChart.resize();
              };
            }
          }
        });
      });
    },

    dayAmountChartDialog() {
      this.dayAmountChartVisiable = !this.dayAmountChartVisiable;
      this.$nextTick(() => {
        var dayAmountChart = this.$echarts.init(
          document.getElementById("dayAmountChart"),
          "macarons"
        );
        this.$http({
          url: `orders/value/addtime/total/日`,
          method: "get",
        }).then(({ data }) => {
          if (data && data.code === 0) {
            let res = data.data;
            let xAxis = [];
            let yAxis = [];
            let pArray = [];
            for (let i = 0; i < res.length; i++) {
              xAxis.push(res[i].addtime);
              yAxis.push(parseFloat(res[i].total).toFixed(2));
              pArray.push({
                value: parseFloat(res[i].total),
                name: res[i].addtime,
              });
              var option = {};
              option = {
                tooltip: {
                  trigger: "item",
                  formatter: "{b} : {c}",
                },
                title: {
                  text: "Daily sales amount",
                  left: "center",
                },
                xAxis: {
                  type: "category",
                  data: xAxis,
                },
                yAxis: {
                  type: "value",
                },
                series: [
                  {
                    data: yAxis,
                    type: "bar",
                  },
                ],
              };
              // 使用刚指定的配置项和数据显示图表。
              dayAmountChart.setOption(option);
              //根据窗口的大小变动图表
              window.onresize = function () {
                dayAmountChart.resize();
              };
            }
          }
        });
      });
    },

    monthAmountChartDialog() {
      this.monthAmountChartVisiable = !this.monthAmountChartVisiable;
      this.$nextTick(() => {
        var monthAmountChart = this.$echarts.init(
          document.getElementById("monthAmountChart"),
          "macarons"
        );
        this.$http({
          url: `orders/value/addtime/total/月`,
          method: "get",
        }).then(({ data }) => {
          if (data && data.code === 0) {
            let res = data.data;
            let xAxis = [];
            let yAxis = [];
            let pArray = [];
            for (let i = 0; i < res.length; i++) {
              xAxis.push(res[i].addtime);
              yAxis.push(parseFloat(res[i].total).toFixed(2));
              pArray.push({
                value: parseFloat(res[i].total),
                name: res[i].addtime,
              });
              var option = {};
              option = {
                tooltip: {
                  trigger: "item",
                  formatter: "{b} : {c}",
                },
                title: {
                  text: "Monthly sales amount",
                  left: "center",
                },
                xAxis: {
                  type: "category",
                  data: xAxis,
                },
                yAxis: {
                  type: "value",
                },
                series: [
                  {
                    data: yAxis,
                    type: "bar",
                  },
                ],
              };
              // 使用刚指定的配置项和数据显示图表。
              monthAmountChart.setOption(option);
              //根据窗口的大小变动图表
              window.onresize = function () {
                monthAmountChart.resize();
              };
            }
          }
        });
      });
    },

    yearAmountChartDialog() {
      this.yearAmountChartVisiable = !this.yearAmountChartVisiable;
      this.$nextTick(() => {
        var yearAmountChart = this.$echarts.init(
          document.getElementById("yearAmountChart"),
          "macarons"
        );
        this.$http({
          url: `orders/value/addtime/total/年`,
          method: "get",
        }).then(({ data }) => {
          if (data && data.code === 0) {
            let res = data.data;
            let xAxis = [];
            let yAxis = [];
            let pArray = [];
            for (let i = 0; i < res.length; i++) {
              xAxis.push(res[i].addtime);
              yAxis.push(parseFloat(res[i].total).toFixed(2));
              pArray.push({
                value: parseFloat(res[i].total),
                name: res[i].addtime,
              });
              var option = {};
              option = {
                tooltip: {
                  trigger: "item",
                  formatter: "{b} : {c}",
                },
                title: {
                  text: "Annual sales amount",
                  left: "center",
                },
                xAxis: {
                  type: "category",
                  data: xAxis,
                },
                yAxis: {
                  type: "value",
                },
                series: [
                  {
                    data: yAxis,
                    type: "bar",
                  },
                ],
              };
              // 使用刚指定的配置项和数据显示图表。
              yearAmountChart.setOption(option);
              //根据窗口的大小变动图表
              window.onresize = function () {
                yearAmountChart.resize();
              };
            }
          }
        });
      });
    },

    goodnameAmountChartDialog() {
      this.goodnameAmountChartVisiable = !this.goodnameAmountChartVisiable;
      this.$nextTick(() => {
        var goodnameAmountChart = this.$echarts.init(
          document.getElementById("goodnameAmountChart"),
          "macarons"
        );
        this.$http({
          url: `orders/value/goodname/total`,
          method: "get",
        }).then(({ data }) => {
          if (data && data.code === 0) {
            let res = data.data;
            let xAxis = [];
            let yAxis = [];
            let pArray = [];
            for (let i = 0; i < res.length; i++) {
              xAxis.push(res[i].goodname);
              yAxis.push(parseFloat(res[i].total).toFixed(2));
              pArray.push({
                value: parseFloat(res[i].total),
                name: res[i].goodname,
              });
              var option = {};
              option = {
                tooltip: {
                  trigger: "item",
                  formatter: "{b} : {c}",
                },
                title: {
                  text: "Product sales amount",
                  left: "center",
                },
                xAxis: {
                  type: "category",
                  data: xAxis,
                },
                yAxis: {
                  type: "value",
                },
                series: [
                  {
                    data: yAxis,
                    type: "bar",
                  },
                ],
              };
              // 使用刚指定的配置项和数据显示图表。
              goodnameAmountChart.setOption(option);
              //根据窗口的大小变动图表
              window.onresize = function () {
                goodnameAmountChart.resize();
              };
            }
          }
        });
      });
    },

    goodtypeAmountChartDialog() {
      this.goodtypeAmountChartVisiable = !this.goodtypeAmountChartVisiable;
      this.$nextTick(() => {
        var goodtypeAmountChart = this.$echarts.init(
          document.getElementById("goodtypeAmountChart"),
          "macarons"
        );
        this.$http({
          url: `orders/value/goodtype/total`,
          method: "get",
        }).then(({ data }) => {
          if (data && data.code === 0) {
            let res = data.data;
            let xAxis = [];
            let yAxis = [];
            let pArray = [];
            for (let i = 0; i < res.length; i++) {
              xAxis.push(res[i].goodtype);
              yAxis.push(parseFloat(res[i].total).toFixed(2));
              pArray.push({
                value: parseFloat(res[i].total),
                name: res[i].goodtype,
              });
              var option = {};
              option = {
                tooltip: {
                  trigger: "item",
                  formatter: "{b} : {c}",
                },
                title: {
                  text: "Type sales amount",
                  left: "center",
                },
                xAxis: {
                  type: "category",
                  data: xAxis,
                },
                yAxis: {
                  type: "value",
                },
                series: [
                  {
                    data: yAxis,
                    type: "bar",
                  },
                ],
              };
              // 使用刚指定的配置项和数据显示图表。
              goodtypeAmountChart.setOption(option);
              //根据窗口的大小变动图表
              window.onresize = function () {
                goodtypeAmountChart.resize();
              };
            }
          }
        });
      });
    },
    init() {},
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },

    // 获取数据list
    getDataList() {
      this.dataListLoading = true;
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        sort: "id",
        order: "desc",
        status: this.$route.params.status,
      };
      if (
        this.searchForm.orderid != "" &&
        this.searchForm.orderid != undefined
      ) {
        params["orderid"] = "%" + this.searchForm.orderid + "%";
      }
      if (
        this.searchForm.goodname != "" &&
        this.searchForm.goodname != undefined
      ) {
        params["goodname"] = "%" + this.searchForm.goodname + "%";
      }
      this.$http({
        url: "orders/page",
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
    // 每page数
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // 当前page
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 多选
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
    // 下载
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
          url: "orders/delete",
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
//导出excel
.export-excel-wrapper {
  display: inline-block;
}

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
