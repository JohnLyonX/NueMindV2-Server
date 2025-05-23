<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="学生 ID" prop="studentId">
        <el-input
          v-model="queryParams.studentId"
          placeholder="请输入学生 ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
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
      <el-form-item label="所选答案" prop="selectedAnswer">
        <el-input
          v-model="queryParams.selectedAnswer"
          placeholder="请输入所选答案"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否答对" prop="isCorrect">
        <el-input
          v-model="queryParams.isCorrect"
          placeholder="请输入是否答对"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="回答时间" prop="answerTime">
        <el-date-picker clearable
          v-model="queryParams.answerTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择回答时间">
        </el-date-picker>
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
          v-hasPermi="['edu:answers:add']"
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
          v-hasPermi="['edu:answers:edit']"
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
          v-hasPermi="['edu:answers:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['edu:answers:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="answersList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="答案编号" align="center" prop="answerId" />
      <el-table-column label="学生 ID" align="center" prop="studentId" />
      <el-table-column label="练习 ID" align="center" prop="exerciseId" />
      <el-table-column label="问题 ID" align="center" prop="questionId" />
      <el-table-column label="所选答案" align="center" prop="selectedAnswer" />
      <el-table-column label="是否答对" align="center" prop="isCorrect" />
      <el-table-column label="回答时间" align="center" prop="answerTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.answerTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['edu:answers:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['edu:answers:remove']"
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

    <!-- 添加或修改学生提交答案表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="学生 ID" prop="studentId">
          <el-input v-model="form.studentId" placeholder="请输入学生 ID" />
        </el-form-item>
        <el-form-item label="练习 ID" prop="exerciseId">
          <el-input v-model="form.exerciseId" placeholder="请输入练习 ID" />
        </el-form-item>
        <el-form-item label="问题 ID" prop="questionId">
          <el-input v-model="form.questionId" placeholder="请输入问题 ID" />
        </el-form-item>
        <el-form-item label="所选答案" prop="selectedAnswer">
          <el-input v-model="form.selectedAnswer" placeholder="请输入所选答案" />
        </el-form-item>
        <el-form-item label="是否答对" prop="isCorrect">
          <el-input v-model="form.isCorrect" placeholder="请输入是否答对" />
        </el-form-item>
        <el-form-item label="回答时间" prop="answerTime">
          <el-date-picker clearable
            v-model="form.answerTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择回答时间">
          </el-date-picker>
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
import { listAnswers, getAnswers, delAnswers, addAnswers, updateAnswers } from "@/api/edu/answers";

export default {
  name: "Answers",
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
      // 学生提交答案表表格数据
      answersList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        studentId: null,
        exerciseId: null,
        questionId: null,
        selectedAnswer: null,
        isCorrect: null,
        answerTime: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        studentId: [
          { required: true, message: "学生 ID不能为空", trigger: "blur" }
        ],
        exerciseId: [
          { required: true, message: "练习 ID不能为空", trigger: "blur" }
        ],
        questionId: [
          { required: true, message: "问题 ID不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询学生提交答案表列表 */
    getList() {
      this.loading = true;
      listAnswers(this.queryParams).then(response => {
        this.answersList = response.rows;
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
        answerId: null,
        studentId: null,
        exerciseId: null,
        questionId: null,
        selectedAnswer: null,
        isCorrect: null,
        answerTime: null
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
      this.ids = selection.map(item => item.answerId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加学生提交答案表";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const answerId = row.answerId || this.ids
      getAnswers(answerId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改学生提交答案表";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.answerId != null) {
            updateAnswers(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addAnswers(this.form).then(response => {
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
      const answerIds = row.answerId || this.ids;
      this.$modal.confirm('是否确认删除学生提交答案表编号为"' + answerIds + '"的数据项？').then(function() {
        return delAnswers(answerIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('edu/answers/export', {
        ...this.queryParams
      }, `answers_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
