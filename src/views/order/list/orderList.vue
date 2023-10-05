<template>
    <div>
        <div class="order_breadcrumb">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
                <el-breadcrumb-item><a href="/order/orderList">订单管理</a></el-breadcrumb-item>
                <el-breadcrumb-item>订单列表</el-breadcrumb-item>
            </el-breadcrumb>
        </div>

        <div class="order_breadcrumb">
            <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <!-- 订单编号 -->
            <el-form-item label="订单编号" prop="name">
                <el-input v-model="ruleForm.name" size="small" style="width: 220px;"
                placeholder="请输入品牌名称"></el-input>
            </el-form-item>

            <!-- 预定时间 -->
            <el-form-item label="预定时间" required>
                <el-col :span="6">
                <el-form-item prop="date1" size="small">
                    <el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.date1" style="width: 100%;"></el-date-picker>
                </el-form-item>
                </el-col>
                <el-col class="line" :span="1">
                &nbsp;&nbsp;
                至
                </el-col>
                <el-col :span="6">
                <el-form-item prop="date2" size="small">
                    <el-time-picker placeholder="选择时间" v-model="ruleForm.date2" style="width: 100%;"></el-time-picker>
                </el-form-item>
                </el-col>
            </el-form-item>

            <!-- 下单人,所属单位 -->
            <div>
                <el-form-item label="下单人" prop="name" style="display: inline-block;">
                    <el-input v-model="ruleForm.name" size="small" style="width: 220px;"
                    placeholder="请输入品牌名称"></el-input>
                </el-form-item>
                <el-form-item label="所属单位" prop="name" style="display: inline-block;">
                    <el-input v-model="ruleForm.name" size="small" style="width: 220px;"
                    placeholder="请输入品牌名称"></el-input>
                </el-form-item>
            </div>


            <!-- 汇总状态 -->
            <el-form-item label="汇总状态" prop="region" size="small">
                <el-select v-model="ruleForm.region" placeholder="全部">
                <el-option label="汇总一" value="shanghai"></el-option>
                <el-option label="汇总二" value="beijing"></el-option>
                </el-select>
            </el-form-item>
            
            <!-- 汇总按钮 -->
            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')" size="small">订单汇总</el-button>
                <el-button type="primary" @click="submitForm('ruleForm')" size="small">导出</el-button>
            </el-form-item>
            </el-form>
        </div>
        
        <div class="order_breadcrumb">
            <el-table
                :data="tableData"
                border
                style="width: 100%">
                <el-table-column
                prop=""
                label="产品编号"
                width="180">
                </el-table-column>
                <el-table-column
                prop=""
                label="产品名称"
                width="180">
                </el-table-column>
                <el-table-column
                prop=""
                label="产品价格">
                </el-table-column>
                <el-table-column
                prop=""
                label="产品类目">
                </el-table-column>
                <el-table-column
                prop=""
                label="添加时间">
                </el-table-column> 
                <el-table-column
                prop=""
                label="视频卖点">
                </el-table-column> 
                <el-table-column
                prop=""
                label="商品描述">
                </el-table-column>
                <el-table-column
                prop=""
                label="操作">
                </el-table-column>                 
            </el-table>
        </div>
    </div>
</template>

<script>
  export default {
    data() {
      return {
        ruleForm: {
          name: '',
          region: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        },
        rules: {
          name: [
            { required: true, message: '请输入活动名称', trigger: 'blur' },
            { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
          ],
          region: [
            { required: true, message: '请选择活动区域', trigger: 'change' }
          ],
          date1: [
            { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
          ],
          date2: [
            { type: 'date', required: true, message: '请选择时间', trigger: 'change' }
          ],
          type: [
            { type: 'array', required: true, message: '请至少选择一个活动性质', trigger: 'change' }
          ],
          resource: [
            { required: true, message: '请选择活动资源', trigger: 'change' }
          ],
          desc: [
            { required: true, message: '请填写活动形式', trigger: 'blur' }
          ]
        }
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style scoped>
.order_breadcrumb{
    margin: 10px;
    padding: 10px;
}
</style>