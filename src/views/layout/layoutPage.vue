<template>
    <div class="layout">
        <div class="menu">
            <MenuPage :isCollapse="isCollapse"></MenuPage>
        </div>
        <div class="content" :class="{ small: isCollapse }">
            <ContentPage @changeShow="changeShow" :isCollapse="isCollapse"></ContentPage>
        </div>
    </div>
</template>
  
<script>
import MenuPage from "./menu/menuPage.vue";
import ContentPage from "./content/contentPage.vue";

export default {
    components: {
        MenuPage,
        ContentPage
    },
    data() {
        return {
            isCollapse: false
        }
    },
    methods: {
        changeShow() {
            this.isCollapse = !this.isCollapse;
        }
    }
}
</script>
  
<style scoped>
.layout {
    display: flex;
}

.layout .menu {
    /* width: 200px; */
    background-color: #112f50;
    position: fixed;
    left: 0;
    top: 0;
    bottom: 0;
}

.layout .content {
    flex: 1;
    padding-left: 200px;
}

.layout .small {
    padding-left: 64px;
}
</style>