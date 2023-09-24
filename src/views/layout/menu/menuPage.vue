<template>
    <div>
        <el-menu :default-active="$route.path" class="el-menu-vertical-demo" background-color="#112f50" text-color="#fff"
            active-text-color="#ffd04b" router :collapse="isCollapse">
            <el-menu-item>
                <span slot="title">首客生鲜采购管理系统</span>
            </el-menu-item>

            <el-menu-item index="/">
                <span slot="title">首页</span>
            </el-menu-item>

            <el-submenu index="/product">
                <template slot="title">
                    <span>产品管理</span>
                </template>
                <el-menu-item-group>
                    <el-menu-item index="/product/list">产品列表</el-menu-item>
                    <el-menu-item index="/product/category">产品分类</el-menu-item>
                </el-menu-item-group>
            </el-submenu>

            <el-submenu index="/order">
                <template slot="title">
                    <span>订单管理</span>
                </template>
                <el-menu-item-group>
                    <el-menu-item index="/order/orderList">订单列表</el-menu-item>
                    <el-menu-item index="/order/orderCollect">订单汇总</el-menu-item>
                </el-menu-item-group>
            </el-submenu>

            <el-submenu index="/advertPage">
                <template slot="title">
                    <span>广告管理</span>
                </template>
                <el-menu-item-group>
                    <el-menu-item index="/advertPage/advertList">广告列表</el-menu-item>
                </el-menu-item-group>
            </el-submenu>

            <el-menu-item index="/">
                <span slot="title">导航四</span>
            </el-menu-item>

        </el-menu>
    </div>
</template>
  
<script>

export default {
    props: ['isCollapse']
}
</script>
  
<style scoped>
.el-menu {
    border-right: 0;
}

.is-active {
    background-color: #1e78bf !important;
    color: #fff !important;
}

.el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 200px;
    min-height: 400px;
}
</style>