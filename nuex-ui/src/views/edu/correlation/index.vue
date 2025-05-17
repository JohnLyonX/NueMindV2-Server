<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="练习 ID" prop="exerciseId">
        <el-input
          v-model="queryParams.exerciseId"
          placeholder="请输入练习 ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="问题 ID" prop="questionId">
        <el-input
          v-model="queryParams.questionId"
          placeholder="请输入问题 ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="题目在练习中的顺序" prop="questionOrder">
        <el-input
          v-model="queryParams.questionOrder"
          placeholder="请输入题目在练习中的顺序"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="本题分值" prop="score">
        <el-input
          v-model="queryParams.score"
          placeholder="请输入本题分值"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['edu:correlation:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['edu:correlation:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['edu:correlation:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['edu:correlation:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="correlationList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="关联 ID" align="center" prop="id" />
      <el-table-column label="练习 ID" align="center" prop="exerciseId" />
      <el-table-column label="问题 ID" align="center" prop="questionId" />
      <el-table-column label="题目在练习中的顺序" align="center" prop="questionOrder" />
      <el-table-column label="本题分值" align="center" prop="score" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['edu:correlation:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['edu:correlation:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改练习题目关联表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="练习 ID" prop="exerciseId">
          <el-input v-model="form.exerciseId" placeholder="请输入练习 ID" :disabled="!!$route.query.exerciseId"/>
        </el-form-item>
        <el-form-item label="问题 ID" prop="questionId">
          <el-input v-model="form.questionId" placeholder="请输入问题 ID" />
        </el-form-item>
        <el-form-item label="题目在练习中的顺序" prop="questionOrder">
          <el-input v-model="form.questionOrder" placeholder="请输入题目在练习中的顺序" />
        </el-form-item>
        <el-form-item label="本题分值" prop="score">
          <el-input v-model="form.score" placeholder="请输入本题分值" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listCorrelation, getCorrelation, delCorrelation, addCorrelation, updateCorrelation } from "@/api/edu/correlation";

export default {
  name: "Correlation",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 练习题目关联表表格数据
      correlationList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        exerciseId: this.$route.query.exerciseId || null,
        questionId: null,
        questionOrder: null,
        score: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        exerciseId: [
          { required: true, message: "练习ID不能为空", trigger: "blur" }
        ],
        questionId: [
          { required: true, message: "问题ID不能为空", trigger: "blur" }
        ],
        questionOrder: [
          { required: true, message: "题目在练习中的顺序不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    // 获取路由参数中的练习ID
    const exerciseId = this.$route.query.exerciseId;

    // 当存在exerciseId且当前没有表单数据时
    if (exerciseId && !this.form.exerciseId) {
      this.handleAdd(); // 自动打开新增对话框
      this.$nextTick(() => {
        this.form.exerciseId = exerciseId; // 自动填充练习ID
      });
    }
    this.getList();
  },
  methods: {
    /** 查询练习题目关联表列表 */
    getList() {
      this.loading = true;
      listCorrelation(this.queryParams).then(response => {
        this.correlationList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        exerciseId: null,
        questionId: null,
        questionOrder: null,
        score: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加练习题目关联表";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getCorrelation(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改练习题目关联表";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCorrelation(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
              this.$router.replace({ query: {} });
            });
          } else {
            addCorrelation(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除练习题目关联表编号为"' + ids + '"的数据项？').then(function() {
        return delCorrelation(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('edu/correlation/export', {
        ...this.queryParams
      }, `correlation_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
