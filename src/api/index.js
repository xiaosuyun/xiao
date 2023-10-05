// 公共请求方法
import base from "./base";
import axios from 'axios';

const api = {
    // 总销售额
    totalInfo() {
        return axios.get(base.totalInfo);
    },
    // 月销售额 
    salesInfo() {
        return axios.get(base.sales);
    },
    // 今日订单
    orderInfo() {
        return axios.get(base.order);
    },
    // 饼图
    formatInfo() {
        return axios.get(base.format);
    }
};

export default api;