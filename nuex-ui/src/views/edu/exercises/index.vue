<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="标题" prop="title">
        <el-input
          v-model="queryParams.title"
          placeholder="请输入标题"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建练习的老师ID" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入创建练习的老师ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建时间" prop="createdAt">
        <el-date-picker clearable
          v-model="queryParams.createdAt"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择创建时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="练习提交时间" prop="submissionTime">
        <el-date-picker clearable
          v-model="queryParams.submissionTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择练习提交时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="时间限制(分钟)" prop="timeLimit">
        <el-input
          v-model="queryParams.timeLimit"
          placeholder="请输入时间限制(分钟)"
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
          v-hasPermi="['edu:exercises:add']"
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
          v-hasPermi="['edu:exercises:edit']"
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
          v-hasPermi="['edu:exercises:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['edu:exercises:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="exercisesList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="练习 ID" align="center" prop="exerciseId" />
      <el-table-column label="标题" align="center" prop="title" />
      <el-table-column label="描述" align="center" prop="description" />
      <el-table-column label="创建练习的老师ID" align="center" prop="userId" />
      <el-table-column label="创建时间" align="center" prop="createdAt" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createdAt, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="练习提交时间" align="center" prop="submissionTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.submissionTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="时间限制(分钟)" align="center" prop="timeLimit" />
      <el-table-column label="是否已发布" align="center" prop="status" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-plus"
            @click="handleAddQuestion(scope.row)"
            v-hasPermi="['edu:correlation:add']"
          >添加练习题</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['edu:exercises:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['edu:exercises:remove']"
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

    <!-- 添加或修改练习集合对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="标题" prop="title">
          <el-input v-model="form.title" placeholder="请输入标题" />
        </el-form-item>
        <el-form-item label="描述内容" prop="description">
          <el-input v-model="form.description" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="创建练习的老师ID" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入创建练习的老师ID" />
        </el-form-item>
        <el-form-item label="创建时间" prop="createdAt">
          <el-date-picker clearable
            v-model="form.createdAt"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择创建时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="练习提交时间" prop="submissionTime">
          <el-date-picker clearable
            v-model="form.submissionTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择练习提交时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="时间限制(分钟)" prop="timeLimit">
          <el-input v-model="form.timeLimit" placeholder="请输入时间限制(分钟)" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
    <!-- 添加题目关联对话框 -->
    <el-dialog :title="titleQuestion" :visible.sync="openQuestion" width="500px" append-to-body>
      <el-form ref="questionForm" :model="questionForm" :rules="questionRules" label-width="120px">
        <el-form-item label="练习 ID" prop="exerciseId">
          <el-input
            v-model="questionForm.exerciseId"
            placeholder="自动获取练习ID"
            :disabled="true"/>
        </el-form-item>
        <el-form-item label="问题 ID" prop="questionId">
          <el-input
            v-model="questionForm.questionId"
            placeholder="请输入问题ID"
            clearable/>
        </el-form-item>
        <el-form-item label="题目顺序" prop="questionOrder">
          <el-input-number
            v-model="questionForm.questionOrder"
            :min="1"
            controls-position="right"/>
        </el-form-item>
        <el-form-item label="本题分值" prop="score">
          <el-input-number
            v-model="questionForm.score"
            :min="0"
            :precision="1"
            :step="0.5"
            controls-position="right"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitQuestionForm">确 定</el-button>
        <el-button @click="openQuestion = false">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listExercises, getExercises, delExercises, addExercises, updateExercises } from "@/api/edu/exercises"
import { listCorrelation, getCorrelation, delCorrelation, addCorrelation, updateCorrelation } from "@/api/edu/correlation";
import { listQuestions, getQuestions, delQuestions, addQuestions, updateQuestions } from "@/api/edu/questions";

export default {
  name: 'Exercises',
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
      // 练习集合表格数据
      exercisesList: [],
      // 弹出层标题
      title: '',
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        title: null,
        description: null,
        userId: null,
        createdAt: null,
        submissionTime: null,
        timeLimit: null,
        status: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        title: [
          { required: true, message: '标题不能为空', trigger: 'blur' }
        ],
        userId: [
          { required: true, message: '创建练习的老师ID不能为空', trigger: 'blur' }
        ]
      },
        // 题目弹出层标题
      titleQuestion: '',
      // 题目弹出层状态
      openQuestion: false,
      // 题目表单参数
      questionForm: {},
      // 题目表单校验
      questionRules: {
        exerciseId: [
          { required: true, message: '练习ID不能为空', trigger: 'blur' }
        ],
        questionId: [
          { required: true, message: '问题ID不能为空', trigger: 'blur' }
        ],
        questionOrder: [
          { required: true, message: '题目顺序不能为空', trigger: 'blur' },
          { pattern: /^[0-9]+$/, message: '请输入有效数字' }
        ],
        score: [
          { required: true, message: '分值不能为空', trigger: 'blur' },
          { pattern: /^[0-9]+$/, message: '请输入有效数字' }
        ]
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    // 添加练习题操作
    handleAddQuestion(row) {
      this.resetQuestionForm();
      this.openQuestion = true;
      this.title = '添加练习题';
      this.questionForm.exerciseId = row.exerciseId;  // 自动携带当前练习ID
    },

    // 题目表单重置
    resetQuestionForm() {
      this.questionForm = {
        ...this.questionForm,
        questionId: null,
        questionOrder: null,
        score: null
      }
    },
        // 题目提交按钮
    submitQuestionForm() {
      this.$refs['questionForm'].validate(valid => {
        if (valid) {
          addCorrelation(this.questionForm).then(response => {
            this.$modal.msgSuccess('添加成功');
            this.openQuestion = false;
          })
        }
      })
    },
    /** 查询练习集合列表 */
    getList() {
      this.loading = true
      listExercises(this.queryParams).then(response => {
        this.exercisesList = response.rows
        this.total = response.total
        this.loading = false
      })
    },
    // 取消按钮
    cancel() {
      this.open = false
      this.reset()
    },
    // 表单重置
    reset() {
      this.form = {
        exerciseId: null,
        title: null,
        description: null,
        userId: null,
        createdAt: null,
        submissionTime: null,
        timeLimit: null,
        status: null
      }
      this.resetForm('form')
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm('queryForm')
      this.handleQuery()
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.exerciseId)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = '添加练习集合'
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const exerciseId = row.exerciseId || this.ids
      getExercises(exerciseId).then(response => {
        this.form = response.data
        this.open = true
        this.title = '修改练习集合'
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs['form'].validate(valid => {
        if (valid) {
          if (this.form.exerciseId != null) {
            updateExercises(this.form).then(response => {
              this.$modal.msgSuccess('修改成功')
              this.open = false
              this.getList()
            })
          } else {
            addExercises(this.form).then(response => {
              this.$modal.msgSuccess('新增成功')
              this.open = false
              this.getList()
            })
          }
        }
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const exerciseIds = row.exerciseId || this.ids
      this.$modal.confirm('是否确认删除练习集合编号为"' + exerciseIds + '"的数据项？').then(function() {
        return delExercises(exerciseIds)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess('删除成功')
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('edu/exercises/export', {
        ...this.queryParams
      }, `exercises_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
