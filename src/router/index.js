import Vue from 'vue'
import VueRouter from 'vue-router'
import layoutPage from '@/views/layout/layoutPage.vue'
import loginPage from '@/views/login/loginPage.vue'
import HomePage from '@/views/home/HomePage.vue'

const Product = ()=>import('@/views/product/productPage.vue');
const List = ()=>import('@/views/product/list/listPage.vue');
const Category = ()=>import('@/views/product/category/categoryPage.vue');

const Order = ()=>import('@/views/order/orderPage.vue');
const OrderCollect = ()=>import('@/views/order/collect/orderCollect.vue');
const OrderList = ()=>import('@/views/order/list/orderList.vue');

const AdvertPage = ()=>import('@/views/advert/advertPage.vue');
const AdvertList = ()=>import('@/views/advert/list/advertList.vue');


Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        component: layoutPage,
        children: [
            {
                path: '/',
                name: 'home',
                component: HomePage
            },
            {
                path: '/product',
                name: 'product',
                component: Product,
                children: [
                    {
                        path: 'list',
                        name: 'list',
                        component: List, 
                    },
                    {
                        path: 'category',
                        name: 'category',
                        component: Category, 
                    },
                ]
            },
            {
                path: '/order',
                name: 'order',
                component: Order,
                children: [
                    {
                        path: 'orderCollect',
                        name: 'orderCollect',
                        component: OrderCollect, 
                    },
                    {
                        path: 'orderList',
                        name: 'orderList',
                        component: OrderList, 
                    },
                ]
            },
            {
                path: '/advertPage',
                name: 'advertPage',
                component: AdvertPage,
                children: [
                    {
                        path: 'advertList',
                        name: 'advertList',
                        component: AdvertList, 
                    },
                ]
            }
        ]
    },
    {
        path: '/login',
        name: 'login',
        component: loginPage
    }

]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router