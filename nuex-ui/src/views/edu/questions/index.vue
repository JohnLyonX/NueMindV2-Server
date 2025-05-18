<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="问题文本" prop="questionText">
        <el-input
          v-model="queryParams.questionText"
          placeholder="请输入问题文本"
          clearable
          @keyup.enter.native="questionText"
        />
      </el-form-item>
      <el-form-item label="选项 A" prop="optionA">
        <el-input
          v-model="queryParams.optionA"
          placeholder="请输入选项 A"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="选项 B" prop="optionB">
        <el-input
          v-model="queryParams.optionB"
          placeholder="请输入选项 B"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="选项 C" prop="optionC">
        <el-input
          v-model="queryParams.optionC"
          placeholder="请输入选项 C"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="选项 D" prop="optionD">
        <el-input
          v-model="queryParams.optionD"
          placeholder="请输入选项 D"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="正确答案" prop="correctAnswer">
        <el-input
          v-model="queryParams.correctAnswer"
          placeholder="请输入正确答案"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所属科目" prop="coursesName">
        <el-input
          v-model="queryParams.coursesName"
          placeholder="请输入所属科目"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建题目的老师ID" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入创建题目的老师ID"
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
          v-hasPermi="['edu:questions:add']"
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
          v-hasPermi="['edu:questions:edit']"
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
          v-hasPermi="['edu:questions:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['edu:questions:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="questionsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="问题 ID" align="center" prop="questionId" />
      <el-table-column label="问题文本" align="center" prop="questionText" />
      <el-table-column label="选项 A" align="center" prop="optionA" />
      <el-table-column label="选项 B" align="center" prop="optionB" />
      <el-table-column label="选项 C" align="center" prop="optionC" />
      <el-table-column label="选项 D" align="center" prop="optionD" />
      <el-table-column label="正确答案" align="center" prop="correctAnswer" />
      <el-table-column label="题目解析" align="center" prop="explanation" />
      <el-table-column label="所属科目" align="center" prop="coursesName" />
      <el-table-column label="创建题目的老师ID" align="center" prop="userId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['edu:questions:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['edu:questions:remove']"
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

    <!-- 添加或修改练习题目对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="问题文本" prop="questionText">
          <el-input v-model="form.questionText" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="选项 A" prop="optionA">
          <el-input v-model="form.optionA" placeholder="请输入选项 A" />
        </el-form-item>
        <el-form-item label="选项 B" prop="optionB">
          <el-input v-model="form.optionB" placeholder="请输入选项 B" />
        </el-form-item>
        <el-form-item label="选项 C" prop="optionC">
          <el-input v-model="form.optionC" placeholder="请输入选项 C" />
        </el-form-item>
        <el-form-item label="选项 D" prop="optionD">
          <el-input v-model="form.optionD" placeholder="请输入选项 D" />
        </el-form-item>
        <el-form-item label="正确答案" prop="correctAnswer">
          <el-input v-model="form.correctAnswer" placeholder="请输入正确答案" />
        </el-form-item>
        <el-form-item label="题目解析" prop="explanation">
          <el-input v-model="form.explanation" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="所属科目" prop="coursesName">
          <el-input v-model="form.coursesName" placeholder="请输入所属科目" />
        </el-form-item>
        <el-form-item label="创建题目的老师ID" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入创建题目的老师ID" />
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
import { listQuestions, getQuestions, delQuestions, addQuestions, updateQuestions } from "@/api/edu/questions";

export default {
  name: "Questions",
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
      // 练习题目表格数据
      questionsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        questionText: null,
        optionA: null,
        optionB: null,
        optionC: null,
        optionD: null,
        correctAnswer: null,
        explanation: null,
        coursesName: null,
        userId: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        questionText: [
          { required: true, message: "问题文本不能为空", trigger: "blur" }
        ],
        optionA: [
          { required: true, message: "选项 A不能为空", trigger: "blur" }
        ],
        optionB: [
          { required: true, message: "选项 B不能为空", trigger: "blur" }
        ],
        optionC: [
          { required: true, message: "选项 C不能为空", trigger: "blur" }
        ],
        optionD: [
          { required: true, message: "选项 D不能为空", trigger: "blur" }
        ],
        correctAnswer: [
          { required: true, message: "正确答案不能为空", trigger: "blur" }
        ],
        userId: [
          { required: true, message: "创建题目的老师ID不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询练习题目列表 */
    getList() {
      this.loading = true;
      listQuestions(this.queryParams).then(response => {
        this.questionsList = response.rows;
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
        questionId: null,
        questionText: null,
        optionA: null,
        optionB: null,
        optionC: null,
        optionD: null,
        correctAnswer: null,
        explanation: null,
        coursesName: null,
        userId: null
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
      this.ids = selection.map(item => item.questionId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加练习题目";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const questionId = row.questionId || this.ids
      getQuestions(questionId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改练习题目";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.questionId != null) {
            updateQuestions(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addQuestions(this.form).then(response => {
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
      const questionIds = row.questionId || this.ids;
      this.$modal.confirm('是否确认删除练习题目编号为"' + questionIds + '"的数据项？').then(function() {
        return delQuestions(questionIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('edu/questions/export', {
        ...this.queryParams
      }, `questions_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
