<template>
    <div>
        <!-- 面包屑导航 -->
        <div class="product_breadcrumb">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
                <el-breadcrumb-item><a href="/product/list">产品管理</a></el-breadcrumb-item>
                <el-breadcrumb-item>产品列表</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <!-- 查询,添加,删除按钮 -->
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
            <!-- 添加,删除按钮 -->
            <div class="header_content_color">
                <el-button type="warning" size="small" icon="el-icon-plus">添加商品</el-button>
                <el-button type="danger" size="small" icon="el-icon-delete">批量删除</el-button>
            </div>
        </div>
        <!-- 表数据 -->
        <div class="product_content">
            <el-table :data="tableData" border style="width: 100%" header-cell-class-name="active-header"
                cell-class-name="table-center">
                <el-table-column type="selection" width="55">
                </el-table-column>
                <el-table-column prop="id" label="商品编号">
                </el-table-column>
                <el-table-column prop="title" label="商品名称" show-overflow-tooltip>
                </el-table-column>
                <el-table-column prop="price" label="商品价格" show-overflow-tooltip>
                </el-table-column>
                <el-table-column prop="caregory" label="商品类目" show-overflow-tooltip>
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
                        <el-button size="mini" icon="el-icon-edit" type="primary"
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
            pageID: 1,
        }
    },
    methods: {
        removeHtmlTag,
        onSubmit() {
            this.search(this.formInline.name);
        },
        handleEdit(index, row) {
            console.log(index, row);
        },
        handleDelete(index, row) {
            console.log(index, row);
            this.$confirm('你确定要删除吗?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                this.deleteItemById(row.id);
                this.$message({
                    type: 'success',
                    message: '删除成功!'
                });
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消删除'
                });
            });
        },
        CurrentChange(val) {
            this.projectList(val);
            this.pageID = val;
        },
        // 
        async projectList(id) {
            if (id == null) id = 1;
            let res = await this.$api.projectList(id);
            this.tableData = res.data;
        },
        // 搜索
        async search(search) {
            let res = await this.$api.search(search);
            // 需要进行修改 --- ！！！
            if (this.formInline.name != '') {
                this.tableData = res.data;
            } else {
                this.tableData = [];
            }
        },
        // 删除
        async deleteItemById(id) {
            let res = await this.$api.deleteItemById(id);
            console.log(res);
            this.projectList(this.pageID);
        }
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