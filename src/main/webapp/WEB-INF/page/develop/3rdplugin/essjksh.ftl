<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>地图数据可视化</title>
    <link rel="stylesheet" href="${Server}/assets/lib/essjksh/css/index.css">
    <link rel="stylesheet" href="${Server}/assets/lib/essjksh/fonts/icomoon.css">
</head>

<body>
    <div class="viewport">
        <div class="column">
            <!--概览-->
            <div class="overview panel">
                <div class="inner">
                    <div class="item">
                        <h4>2,190</h4>
                        <span>
                            <i class="icon-dot" style="color: #006cff"></i>
                            设备总数
                        </span>
                    </div>
                    <div class="item">
                        <h4>190</h4>
                        <span>
                            <i class="icon-dot" style="color: #6acca3"></i>
                            季度新增
                        </span>
                    </div>
                    <div class="item">
                        <h4>3,001</h4>
                        <span>
                            <i class="icon-dot" style="color: #6acca3"></i>
                            运营设备
                        </span>
                    </div>
                    <div class="item">
                        <h4>108</h4>
                        <span>
                            <i class="icon-dot" style="color: #ed3f35"></i>
                            异常设备
                        </span>
                    </div>
                </div>
            </div>
            <!--监控-->
            <div class="monitor panel">
                <div class="inner">
                    <div class="tabs">
                        <a href="javascript:;" data-index="0" class="active">故障设备监控</a>
                        <a href="javascript:;" data-index="1">异常设备监控</a>
                    </div>
                    <div class="content" style="display: block;">
                        <div class="head">
                            <span class="col">故障时间</span>
                            <span class="col">设备地址</span>
                            <span class="col">异常代码</span>
                        </div>
                        <div class="marquee-view">
                            <div class="marquee">
                                <div class="row">
                                    <span class="col">20180701</span>
                                    <span class="col">11北京市昌平西路金燕龙写字楼</span>
                                    <span class="col">1000001</span>
                                    <span class="icon-dot"></span>
                                </div>
                                <div class="row">
                                    <span class="col">20190601</span>
                                    <span class="col">北京市昌平区城西路金燕龙写字楼</span>
                                    <span class="col">1000002</span>
                                    <span class="icon-dot"></span>
                                </div>
                                <div class="row">
                                    <span class="col">20190704</span>
                                    <span class="col">北京市昌平区建材城西路金燕龙写字楼</span>
                                    <span class="col">1000003</span>
                                    <span class="icon-dot"></span>
                                </div>
                                <div class="row">
                                    <span class="col">20180701</span>
                                    <span class="col">北京市昌平区建路金燕龙写字楼</span>
                                    <span class="col">1000004</span>
                                    <span class="icon-dot"></span>
                                </div>
                                <div class="row">
                                    <span class="col">20190701</span>
                                    <span class="col">北京市昌平区建材城西路金燕龙写字楼</span>
                                    <span class="col">1000005</span>
                                    <span class="icon-dot"></span>
                                </div>
                                <div class="row">
                                    <span class="col">20190701</span>
                                    <span class="col">北京市昌平区建材城西路金燕龙写字楼</span>
                                    <span class="col">1000006</span>
                                    <span class="icon-dot"></span>
                                </div>
                                <div class="row">
                                    <span class="col">20190701</span>
                                    <span class="col">北京市昌平区建西路金燕龙写字楼</span>
                                    <span class="col">1000007</span>
                                    <span class="icon-dot"></span>
                                </div>
                                <div class="row">
                                    <span class="col">20190701</span>
                                    <span class="col">北京市昌平区建材城西路金燕龙写字楼</span>
                                    <span class="col">1000008</span>
                                    <span class="icon-dot"></span>
                                </div>
                                <div class="row">
                                    <span class="col">20190701</span>
                                    <span class="col">北京市昌平区建材城西路金燕龙写字楼</span>
                                    <span class="col">1000009</span>
                                    <span class="icon-dot"></span>
                                </div>
                                <div class="row">
                                    <span class="col">20190710</span>
                                    <span class="col">北京市昌平区建材城西路金燕龙写字楼</span>
                                    <span class="col">1000010</span>
                                    <span class="icon-dot"></span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="content">
                        <div class="head">
                            <span class="col">异常时间</span>
                            <span class="col">设备地址</span>
                            <span class="col">异常代码</span>
                        </div>
                        <div class="marquee-view">
                            <div class="marquee">
                                <div class="row">
                                    <span class="col">20190701</span>
                                    <span class="col">北京市昌平区建材城西路金燕龙写字楼</span>
                                    <span class="col">1000001</span>
                                    <span class="icon-dot"></span>
                                </div>
                                <div class="row">
                                    <span class="col">20190701</span>
                                    <span class="col">北京市昌平区建材城西路金燕龙写字楼</span>
                                    <span class="col">1000002</span>
                                    <span class="icon-dot"></span>
                                </div>
                                <div class="row">
                                    <span class="col">20190703</span>
                                    <span class="col">北京市昌平区建材城西路金燕龙写字楼</span>
                                    <span class="col">1000002</span>
                                    <span class="icon-dot"></span>
                                </div>
                                <div class="row">
                                    <span class="col">20190704</span>
                                    <span class="col">北京市昌平区建材城西路金燕龙写字楼</span>
                                    <span class="col">1000002</span>
                                    <span class="icon-dot"></span>
                                </div>
                                <div class="row">
                                    <span class="col">20190705</span>
                                    <span class="col">北京市昌平区建材城西路金燕龙写字楼</span>
                                    <span class="col">1000002</span>
                                    <span class="icon-dot"></span>
                                </div>
                                <div class="row">
                                    <span class="col">20190706</span>
                                    <span class="col">北京市昌平区建材城西路金燕龙写字楼</span>
                                    <span class="col">1000002</span>
                                    <span class="icon-dot"></span>
                                </div>
                                <div class="row">
                                    <span class="col">20190707</span>
                                    <span class="col">北京市昌平区建材城西路金燕龙写字楼</span>
                                    <span class="col">1000002</span>
                                    <span class="icon-dot"></span>
                                </div>
                                <div class="row">
                                    <span class="col">20190708</span>
                                    <span class="col">北京市昌平区建材城西路金燕龙写字楼</span>
                                    <span class="col">1000002</span>
                                    <span class="icon-dot"></span>
                                </div>
                                <div class="row">
                                    <span class="col">20190709</span>
                                    <span class="col">北京市昌平区建材城西路金燕龙写字楼</span>
                                    <span class="col">1000002</span>
                                    <span class="icon-dot"></span>
                                </div>
                                <div class="row">
                                    <span class="col">20190710</span>
                                    <span class="col">北京市昌平区建材城西路金燕龙写字楼</span>
                                    <span class="col">1000002</span>
                                    <span class="icon-dot"></span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--点位-->
            <div class="point panel">
                <div class="inner">
                    <h3>点位分布统计</h3>
                    <div class="chart">
                        <div class="pie"></div>
                        <div class="data">
                            <div class="item">
                                <h4>320,11</h4>
                                <span>
                                    <i class="icon-dot" style="color: #ed3f35"></i>
                                    点位总数
                                </span>
                            </div>
                            <div class="item">
                                <h4>418</h4>
                                <span>
                                    <i class="icon-dot" style="color: #eacf19"></i>
                                    本月新增
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="column">
            <!-- 地图 -->
            <div class="map">
                <h3>
                    <span class="icon-cube"></span>
                    设备数据统计
                </h3>
                <div class="chart">
                    <div class="geo"></div>
                </div>
            </div>
            <!-- 用户 -->
            <div class="users panel">
                <div class="inner">
                    <h3>全国用户总量统计</h3>
                    <div class="chart">
                        <div class="bar"></div>
                        <div class="data">
                            <div class="item">
                                <h4>120,899</h4>
                                <span>
                                    <i class="icon-dot" style="color: #ed3f35"></i>
                                    用户总量
                                </span>
                            </div>
                            <div class="item">
                                <h4>248</h4>
                                <span>
                                    <i class="icon-dot" style="color: #eacf19"></i>
                                    本月新增
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="column">
            <!-- 订单 -->
            <div class="order panel">
                <div class="inner">
                    <!-- 筛选 -->
                    <div class="filter">
                        <a href="javascript:;" data-key="day365" class="active">365天</a>
                        <a href="javascript:;" data-key="day90">90天</a>
                        <a href="javascript:;" data-key="day30">30天</a>
                        <a href="javascript:;" data-key="day1">24小时</a>
                    </div>
                    <!-- 数据 -->
                    <div class="data">
                        <div class="item">
                            <h4>20,301,987</h4>
                            <span>
                                <i class="icon-dot" style="color: #ed3f35;"></i>
                                订单量
                            </span>
                        </div>
                        <div class="item">
                            <h4>99834</h4>
                            <span>
                                <i class="icon-dot" style="color: #eacf19;"></i>
                                销售额(万元)
                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 销售额 -->
            <div class="sales panel">
                <div class="inner">
                    <div class="caption">
                        <h3>销售额统计</h3>
                        <a href="javascript:;" class="active" data-type="year">年</a>
                        <a href="javascript:;" data-type="quarter">季</a>
                        <a href="javascript:;" data-type="month">月</a>
                        <a href="javascript:;" data-type="week">周</a>
                    </div>
                    <div class="chart">
                        <div class="label">单位:万</div>
                        <div class="line"></div>
                    </div>
                </div>
            </div>
            <!-- 渠道 季度 -->
            <div class="wrap">
                <div class="channel panel">
                    <div class="inner">
                        <h3>渠道分布</h3>
                        <div class="data">
                            <div class="item">
                                <h4>39 <small>%</small></h4>
                                <span>
                                    <i class="icon-plane"></i>
                                    机场
                                </span>
                            </div>
                            <div class="item">
                                <h4>28 <small>%</small></h4>
                                <span>
                                    <i class="icon-bag"></i>
                                    商场
                                </span>
                            </div>
                        </div>
                        <div class="data">
                            <div class="item">
                                <h4>20 <small>%</small></h4>
                                <span>
                                    <i class="icon-train"></i>
                                    地铁
                                </span>
                            </div>
                            <div class="item">
                                <h4>13 <small>%</small></h4>
                                <span>
                                    <i class="icon-bus"></i>
                                    火车站
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="quarter panel">
                    <div class="inner">
                        <h3>一季度销售进度</h3>
                        <div class="chart">
                            <div class="box">
                                <div class="gauge"></div>
                                <div class="label">75<small> %</small></div>
                            </div>
                            <div class="data">
                                <div class="item">
                                    <h4>1,321</h4>
                                    <span>
                                        <i class="icon-dot" style="color: #6acca3"></i>
                                        销售额(万元)
                                    </span>
                                </div>
                                <div class="item">
                                    <h4>150%</h4>
                                    <span>
                                        <i class="icon-dot" style="color: #ed3f35"></i>
                                        同比增长
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 排行榜 -->
            <div class="top panel">
                <div class="inner">
                    <div class="all">
                        <h3>全国热榜</h3>
                        <ul>
                            <li>
                                <i class="icon-cup1" style="color: #d93f36;"></i>
                                可爱多
                            </li>
                            <li>
                                <i class="icon-cup2" style="color: #68d8fe;"></i>
                                娃哈啥
                            </li>
                            <li>
                                <i class="icon-cup3" style="color: #4c9bfd;"></i>
                                喜之郎
                            </li>
                        </ul>
                    </div>
                    <div class="province">
                        <h3>各省热销 <i class="date">// 近30日 //</i></h3>
                        <div class="data">
                            <ul class="sup">
                                <li>
                                    <span>北京</span>
                                    <span>25,179 <s class="icon-up"></s></span>
                                </li>
                                <li>
                                    <span>河北</span>
                                    <span>23,252 <s class="icon-down"></s></span>
                                </li>
                                <li>
                                    <span>上海</span>
                                    <span>20,760 <s class="icon-up"></s></span>
                                </li>
                                <li>
                                    <span>江苏</span>
                                    <span>23,252 <s class="icon-down"></s></span>
                                </li>
                                <li>
                                    <span>山东</span>
                                    <span>20,760 <s class="icon-up"></s></span>
                                </li>
                            </ul>
                            <ul class="sub">
                                <!-- <li><span>数据</span><span> 数据<s class="icon-up"></s></span></li> -->
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<script src="${Server}/assets/lib/jquery/1.12.4/jquery.${dev_min_mode}js"></script>
<script src="https://www.jq22.com/jquery/echarts-4.2.1.min.js"></script>
<script src="${Server}/assets/lib/essjksh/js/index.js"></script>

<script src="${Server}/assets/lib/essjksh/js/china.js"></script>
<script src="${Server}/assets/lib/essjksh/js/mymap.js"></script>

</html>