<template>
    <div>
        <!--  -->
        <div class="header">
            <div class="open">
                <span v-if="!isCollapse" class="iconfont icon-right-indent" @click="changMenu"></span>
                <span v-else class="iconfont icon-left-indent" @click="changMenu"></span>
            </div>
        </div>
        <!--  -->
        <router-view></router-view>
    </div>
</template>
  
<script>

export default {
    props: ['isCollapse'],
    methods: {
        changMenu(){
            this.$emit("changeShow")
        }
    },
}
</script>
  
<style>
.header {
    height: 50px;
    background-color: #1e78bf;
    color: #fff;
    line-height: 50px;
}
.header .open .iconfont{
    font-size: 22px;
    cursor: pointer;
}
</style>