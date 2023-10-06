<template>
    <div>
        <!-- 分页 -->
        <div class="block">
            <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage"
                :page-sizes="[100, 200, 300, 400]" :page-size="pageSize" layout="total, prev, pager, next, jumper"
                :total="total">
            </el-pagination>
        </div>
    </div>
</template>

<script>
export default {
    props: {
        total: {
            type: Number,
            default: 100
        },
        pageSize: {
            type: Number,
            default: 10
        }
    },
    data() {
        return {
            currentPage: 1
        };
    },
    methods: {
        handleSizeChange(val) {
            console.log('-', val);
        },
        handleCurrentChange(val) {
            this.$emit('CurrentChange', val);
        }
    }
};
</script>

<style scoped></style>