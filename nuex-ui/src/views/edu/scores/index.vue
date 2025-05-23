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
      <el-form-item label="得分" prop="totalScore">
        <el-input
          v-model="queryParams.totalScore"
          placeholder="请输入得分"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最高分数" prop="maxScore">
        <el-input
          v-model="queryParams.maxScore"
          placeholder="请输入最高分数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="完成时间" prop="completionTime">
        <el-date-picker clearable
          v-model="queryParams.completionTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择完成时间">
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
          v-hasPermi="['edu:scores:add']"
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
          v-hasPermi="['edu:scores:edit']"
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
          v-hasPermi="['edu:scores:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['edu:scores:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="scoresList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="得分表 ID" align="center" prop="scoreId" />
      <el-table-column label="学生 ID" align="center" prop="studentId" />
      <el-table-column label="练习 ID" align="center" prop="exerciseId" />
      <el-table-column label="得分" align="center" prop="totalScore" />
      <el-table-column label="最高分数" align="center" prop="maxScore" />
      <el-table-column label="完成时间" align="center" prop="completionTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.completionTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['edu:scores:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['edu:scores:remove']"
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

    <!-- 添加或修改成绩表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="学生 ID" prop="studentId">
          <el-input v-model="form.studentId" placeholder="请输入学生 ID" />
        </el-form-item>
        <el-form-item label="练习 ID" prop="exerciseId">
          <el-input v-model="form.exerciseId" placeholder="请输入练习 ID" />
        </el-form-item>
        <el-form-item label="得分" prop="totalScore">
          <el-input v-model="form.totalScore" placeholder="请输入得分" />
        </el-form-item>
        <el-form-item label="最高分数" prop="maxScore">
          <el-input v-model="form.maxScore" placeholder="请输入最高分数" />
        </el-form-item>
        <el-form-item label="完成时间" prop="completionTime">
          <el-date-picker clearable
            v-model="form.completionTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择完成时间">
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
import { listScores, getScores, delScores, addScores, updateScores } from "@/api/edu/scores";

export default {
  name: "Scores",
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
      // 成绩表表格数据
      scoresList: [],
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
        totalScore: null,
        maxScore: null,
        completionTime: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        studentId: [
          { required: true, message: "$comment不能为空", trigger: "blur" }
        ],
        exerciseId: [
          { required: true, message: "$comment不能为空", trigger: "blur" }
        ],
        totalScore: [
          { required: true, message: "$comment不能为空", trigger: "blur" }
        ],
        maxScore: [
          { required: true, message: "$comment不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询成绩表列表 */
    getList() {
      this.loading = true;
      listScores(this.queryParams).then(response => {
        this.scoresList = response.rows;
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
        scoreId: null,
        studentId: null,
        exerciseId: null,
        totalScore: null,
        maxScore: null,
        completionTime: null
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
      this.ids = selection.map(item => item.scoreId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加成绩表";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const scoreId = row.scoreId || this.ids
      getScores(scoreId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改成绩表";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.scoreId != null) {
            updateScores(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addScores(this.form).then(response => {
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
      const scoreIds = row.scoreId || this.ids;
      this.$modal.confirm('是否确认删除成绩表编号为"' + scoreIds + '"的数据项？').then(function() {
        return delScores(scoreIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('edu/scores/export', {
        ...this.queryParams
      }, `scores_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
