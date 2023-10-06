<template>
    <div class="home">
        <!-- 日销售额 -->
        <div class="header">
            <div class="item">
                总销售额
                <div class="num">{{ test.saleTotal | num }}</div>
                <div class="bottom">今日销售额:{{ test.sale | num }}</div>
            </div>
            <div class="item">
                总访问量
                <div class="num">{{ test.viewTotal | num }}</div>
                <div class="bottom">今日访问量:{{ test.views | num }}</div>
            </div>
            <div class="item">
                总收藏量
                <div class="num">{{ test.collectTotal | num }}</div>
                <div class="bottom">今日收藏:{{ test.collect | num }}</div>
            </div>
            <div class="item">
                总支付量
                <div class="num">{{ test.payTotal | num }}</div>
                <div class="bottom">今日支付量:{{ test.pay | num }}</div>
            </div>
        </div>
        <!-- 月销售额 -->
        <div class="content">
            <div class="time-info">
                <div class="title">月销售额</div>
                <div id="charts" style="width: 100%; height: 300px;"></div>
            </div>
            <!-- 饼状图 -->
            <div class="area">
                <div class="title">产品销售比例</div>
                <div id="pie" style="width: 100%; height: 300px;"></div>
            </div>
        </div>
        <!-- 订单 -->
        <div class="home-footer">
            <!-- 今日订单 -->
            <el-card class="box-card">
                <div slot="header" class="clerfix">
                    今日订单
                </div>
                <div class="text item">
                    <el-row>
                        <el-col :span="8">
                            <div class="title">今日订单数</div>
                            <div>{{ orderData.curOrderCount }}</div>
                        </el-col>
                        <el-col :span="8">
                            <div class="title">汇总确认订单</div>
                            <div>{{ orderData.curCollect }}</div>
                        </el-col>
                        <el-col :span="8">
                            <div class="title">今日金额</div>
                            <div>{{ orderData.curMoney }}</div>
                        </el-col>
                    </el-row>
                </div>
            </el-card>
            <!-- 本月订单 -->
            <el-card class="box-card">
                <div slot="header" class="clerfix">
                    本月订单
                </div>
                <div class="text item">
                    <el-row>
                        <el-col :span="8">
                            <div class="title">本月订单数</div>
                            <div>{{ orderData.orderCount }}</div>
                        </el-col>
                        <el-col :span="8">
                            <div class="title">汇总确认订单</div>
                            <div>{{ orderData.collect }}</div>
                        </el-col>
                        <el-col :span="8">
                            <div class="title">累计金额</div>
                            <div>{{ orderData.money }}</div>
                        </el-col>
                    </el-row>
                </div>
            </el-card>
            <!-- 快捷入口 -->
            <el-card class="box-card">
                <div slot="header" class="clerfix">
                    快捷入口
                </div>
                <div class="text item">
                    <el-row>
                        <el-col :span="8">
                            <div>
                                <el-button type="primary" size="small"><a href="/product/list">产品管理</a></el-button>
                            </div>
                        </el-col>
                        <el-col :span="8">
                            <div>
                                <el-button size="small">消息管理</el-button>
                            </div>
                        </el-col>
                        <el-col :span="8">
                            <div>
                                <el-button size="small">内容管理</el-button>
                            </div>
                        </el-col>
                    </el-row>
                </div>
            </el-card>
        </div>
    </div>
</template>
  
<script>
import * as echarts from 'echarts';
export default {
    data() {
        return {
            // 获取到的数据
            test: {},
            orderData: {},
            sales: {},
        }
    },
    created() {
        this.totalInfo();
        this.salesInfo();
        this.orderInfo();
        this.formatInfo();
    },
    methods: {
        // 总销售额
        async totalInfo() {
            let res = await this.$api.totalInfo();
            this.test = res.data[0];
            // console.log(res.data);
        },
        // 月销售额
        async salesInfo() {
            let res = await this.$api.salesInfo();
            let arr = res.data;
            let arrx = [], yarr1 = [], yarr2 = [];
            arr.forEach(ele => {
                arrx.push(ele.clothing);
                yarr1.push(ele.quantity);
                yarr2.push(ele.clothingsale);
            });
            this.line(arrx, yarr1, yarr2);
            // console.log(res.data);
        },
        // 饼图
        async formatInfo() {
            let res = await this.$api.formatInfo();
            let arr = res.data;
            let arrx = [], money = [], total = [], pieData = [];
            arr.forEach(ele => {
                arrx.push(ele.id);
                money.push(ele.product);
                total.push(ele.quantity);
                let obj = {};
                obj.name = ele.product;
                obj.value = ele.quantity;
                pieData.push(obj);
            })
            this.pie(pieData);
            // console.log(res.data);
        },
        // 今日订单
        async orderInfo() {
            let res = await this.$api.orderInfo();
            this.orderData = res.data[0];
            // console.log(res.data);
        },
        // 柱形图
        line(arrx, yarr1, yarr2) {
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('charts'));
            // 绘制图表
            myChart.setOption({
                tooltip: {
                    trigger: 'axis',
                },
                legend: {},
                toolbox: {
                    feature: {
                        saveAsImage: {},
                    }
                },
                xAxis: {
                    data: arrx,
                    axisLine: {
                        lineStyle: {
                            color: 'skyblue'
                        }
                    }
                },
                yAxis: {},
                series: [
                    {
                        name: '销售量',
                        type: 'bar',
                        data: yarr1,
                    },
                    {
                        name: '销售额',
                        type: 'line',
                        data: yarr2,
                        smooth: true,
                    }
                ]
            });
        },
        // 饼图
        pie(pieData) {
            var pie = echarts.init(document.getElementById('pie'));
            // 圆形图表
            pie.setOption({
                tooltip: {
                    trigger: 'item',
                    formatter: '{a}<br/>{b}:{d}%'
                },
                legend: {
                    orient: 'vertical',
                    left: 'left'
                },
                series: [
                    {
                        name: '产品销售',
                        type: 'pie',
                        radius: '40%',
                        data: pieData,
                        emphasis: {
                            itemStyle: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]
            });
        }
    },
    // 过滤器
    filters: {
        num(value) {
            if (!value) return;
            return value.toLocaleString();
        }
    }
}
</script>
  
<style scoped>
.home {
    margin: 10px;
}

.header {
    display: flex;
    padding: 30px;
}

.header .item {
    flex: 1;
    height: 100px;
    padding: 10px;
    background-color: #fff;
    border-radius: 10px;
    margin-left: 20px;
    margin-right: 20px;
    font-weight: bold;
    color: #fff;
    position: relative;
}

.header .item .el-col {
    border-right: 1px solid #eee;
}

.header .item .el-col:last-child {
    border-right: none;
}

.header .item .title {
    margin-bottom: 10px;
    font-size: 14px;
}

.header .item .num {
    font-size: 22px;
    margin: 10px;
    color: #fff;
}

.header .item .bottom {
    position: absolute;
    border: 1px solid rgb(246, 245, 245);
    padding: 10px 20px;
    bottom: 0;
    right: 0;
    left: 0;
    color: #fff;
    font-weight: normal;
}

.header .item:nth-child(1) {
    background-image: linear-gradient(#df887d, #88554d);
}

.header .item:nth-child(2) {
    background-image: linear-gradient(#409eff, #2e556e);
}

.header .item:nth-child(3) {
    background-image: linear-gradient(#b54fa8, #713c7a);
}

.header .item:nth-child(4) {
    background-image: linear-gradient(#1cd2f1, #39717a);
}

.content {
    margin: 20px;
    display: flex;
    height: 320px;
}

.content .time-info {
    flex: 2;
    background: #fff;
    margin-right: 20px;
    padding: 10px;
}

.content .area {
    flex: 1;
    background: #fff;
    padding: 10px;
}

.home-footer {
    display: flex;
    padding: 20px;
    margin-bottom: 20px;
}

.home-footer .box-card {
    flex: 1;
    margin-right: 30px;
}

.home-footer .box-card span {
    font-weight: 600;
}
</style>