<template>
    <div>

        <div class="product_breadcrumb">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
                <el-breadcrumb-item><a href="/product/list">产品管理</a></el-breadcrumb-item>
                <el-breadcrumb-item>产品列表</el-breadcrumb-item>
            </el-breadcrumb>
        </div>

        <div class="product_header">
            <div class="">
                <span>产品名称:</span>
                &nbsp;&nbsp;
                <el-input v-model="input" placeholder="请输入内容" size="small" style="width: 220px"></el-input>
                &nbsp;&nbsp;
                <span>添加时间:</span>
                &nbsp;&nbsp;
                <el-date-picker
                v-model="value1"
                type="date"
                placeholder="选择日期"
                size="small">
                </el-date-picker>
                &nbsp;&nbsp;
                <el-button type="primary" size="small">查询</el-button>
            </div>
            <div class="header_content_color">
                <el-button type="warning" size="small"><i class="el-icon-plus"></i>&nbsp;&nbsp;添加商品</el-button>
                <el-button type="danger" size="small"><i class="el-icon-delete"></i>&nbsp;&nbsp;批量删除</el-button>
            </div>
        </div>

        <div class="product_content"> 
            <el-table
                :data="tableData"
                border
                style="width: 100%">
                <el-table-column
                prop=""
                label="商品编号"
                width="180">
                </el-table-column>
                <el-table-column
                prop=""
                label="商品名称"
                width="180">
                </el-table-column>
                <el-table-column
                prop=""
                label="商品价格">
                </el-table-column>
                <el-table-column
                prop=""
                label="商品类目">
                </el-table-column>
                <el-table-column
                prop=""
                label="添加时间">
                </el-table-column> 
                <el-table-column
                prop=""
                label="商品卖点">
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
        // tableData: [{
        //   date: '2016-05-02',
        // }]
      }
    }
}
</script>
  
<style scoped>
.product_breadcrumb{
    margin: 10px;
    padding: 10px;
}
.product_header{
    margin: 10px;
    padding: 10px;
    background-color: #FFFFFF;
}
.header_content_color{
    background-color: #F2F6FC;
    border: 1px solid #EBEEF5;
    margin: 10px;
    padding: 10px;
}
.product_content{
    padding: 10px;
}

</style>