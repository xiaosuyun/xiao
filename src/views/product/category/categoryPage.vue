<template>
    <div>
        <div class="product_breadcrumb">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
                <el-breadcrumb-item><a href="/product/list">产品管理</a></el-breadcrumb-item>
                <el-breadcrumb-item>产品分类</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        
        <div class="product_breadcrumb">
            <el-tree
            :data="data"
            show-checkbox
            node-key="id"
            :default-expanded-keys="[2, 3]"
            :default-checked-keys="[5]">
                <span class="custom-tree-node" slot-scope="{ node, data }">
                <span>{{ node.label }}</span>
                <span>
                <el-button
                    type="text"
                    size="mini"
                    @click="() => remove(node, data)">
                    删除
                </el-button>
                </span>
            </span>
            </el-tree>
        </div>
    </div>
</template>
  
<script>

export default {
    data() {
      return {
        data: [
            {
                id: 1,
                label: '新鲜水果',
                children: [{
                    id: 2,
                    label: '热销水果',
                }, {
                    id: 3,
                    label: '时令水果',
                }, {
                    id: 4,
                    label: '热带水果',
                }]
            },
            {
                id: 11,
                label: '海鲜水产',
                children: [{
                    id: 12,
                    label: '鱼类',
                }, {
                    id: 13,
                    label: '虾类',
                }, {
                    id: 14,
                    label: '蟹类',
                }]
            }
        ],
        defaultProps: {
          children: 'children',
          label: 'label'
        }
      };
    }
}
</script>
  
<style scoped>
.product_breadcrumb{
    margin: 10px;
    padding: 10px;
}

.custom-tree-node {
    flex: 1;
    display: flex;
    align-items: center;
    justify-content: space-between;
    font-size: 14px;
    padding-right: 8px;
}
</style>