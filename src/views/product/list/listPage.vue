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
            <!-- 查询 -->
            <div class="form">
                <el-form :inline="true" :model="formInline" class="demo-form-inline">
                    <el-form-item label="产品名称:">
                        <el-input v-model="formInline.name" placeholder="产品名称" size="small" style="width: 220px"></el-input>
                    </el-form-item>
                    <el-form-item label="添加时间:">
                        <el-date-picker v-model="formInline.date" type="date" placeholder="选择日期"
                            size="small"></el-date-picker>
                    </el-form-item>
                    <el-button @click="onSubmit" type="primary" size="small">查询</el-button>
                </el-form>
            </div>
            <!-- 按钮 -->
            <div class="header_content_color">
                <el-button type="warning" size="small" icon="el-icon-plus">添加商品</el-button>
                <el-button type="danger" size="small" icon="el-icon-delete">批量删除</el-button>
            </div>
        </div>

        <div class="product_content">
            <el-table :data="tableData" border style="width: 100%" header-cell-class-name="active-header"
                cell-class-name="table-center">
                <el-table-column type="selection" width="55">
                </el-table-column>
                <el-table-column prop="id" label="商品编号">
                </el-table-column>
                <el-table-column prop="title" label="商品名称">
                </el-table-column>
                <el-table-column prop="price" label="商品价格">
                </el-table-column>
                <el-table-column prop="caregory" label="商品类目">
                </el-table-column>
                <el-table-column prop="create_tiem" label="添加时间">
                </el-table-column>
                <el-table-column prop="sellPoint" label="商品卖点" show-overflow-tooltip>
                </el-table-column>
                <el-table-column label="商品描述" show-overflow-tooltip>
                    <template slot-scope="scope">
                        <span>{{ removeHtmlTag(scope.row.descs) }}</span>
                    </template>
                </el-table-column>
                <el-table-column label="操作" width="200">
                    <template slot-scope="scope">
                        <el-button type="primary" icon="el-icon-edit" size="mini"
                            @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                        <el-button size="mini" icon="el-icon-delete" type="danger"
                            @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <!-- 分页组件 -->
            <div class="pagination">
                <ThePagination :total="total" :pageSize="pageSize" @CurrentChange="CurrentChange"></ThePagination>
            </div>
        </div>
    </div>
</template>
  
<script>
import ThePagination from '@/components/ThePagination/ThePagination.vue';
import { removeHtmlTag } from '@/utils/common.js';

export default {
    components: {
        ThePagination
    },
    data() {
        return {
            formInline: {
                name: '',
                date: '',
            },
            tableData: [],
            total: 9,
            pageSize: 2,
        }
    },
    methods: {
        removeHtmlTag,
        onSubmit() {
            console.log(this.formInline);
        },
        handleEdit(index, row) {
            console.log(index, row);
        },
        handleDelete(index, row) {
            console.log(index, row);
        },
        CurrentChange(val) {
            this.projectList(val)
        },
        async projectList(id) {
            let res = await this.$api.projectList(id);
            this.tableData = res.data;
        },
    },
    created() {
        this.projectList();
    },
}
</script>
  
<style scoped>
.product_breadcrumb {
    margin: 10px;
    padding: 10px;
}

.product_header .el-form-item {
    margin-bottom: 8px;
}

.header_content_color {
    background-color: #F2F6FC;
    border: 1px solid #EBEEF5;
    padding: 10px;
}

.product_header {
    margin: 10px;
    padding: 10px;
    background-color: #FFFFFF;
}

.product_content {
    padding: 10px;
}

/deep/ .product_content .active-header {
    color: #333;
    text-align: center;
}

/deep/ .product_content .table-center {
    text-align: center;
}

.pagination {
    padding: 10px;
    background-color: #FFFFFF;
}
</style>