var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "100",
        "ok": "30",
        "ko": "70"
    },
    "minResponseTime": {
        "total": "52",
        "ok": "90",
        "ko": "52"
    },
    "maxResponseTime": {
        "total": "535",
        "ok": "530",
        "ko": "535"
    },
    "meanResponseTime": {
        "total": "119",
        "ok": "149",
        "ko": "106"
    },
    "standardDeviation": {
        "total": "122",
        "ok": "114",
        "ko": "123"
    },
    "percentiles1": {
        "total": "71",
        "ok": "110",
        "ko": "65"
    },
    "percentiles2": {
        "total": "107",
        "ok": "125",
        "ko": "73"
    },
    "percentiles3": {
        "total": "466",
        "ok": "467",
        "ko": "464"
    },
    "percentiles4": {
        "total": "530",
        "ok": "512",
        "ko": "489"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 30,
        "percentage": 30
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group4": {
        "name": "failed",
        "count": 70,
        "percentage": 70
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "50",
        "ok": "15",
        "ko": "35"
    }
},
contents: {
"req_manager-login-0d467": {
        type: "REQUEST",
        name: "manager-login",
path: "manager-login",
pathFormatted: "req_manager-login-0d467",
stats: {
    "name": "manager-login",
    "numberOfRequests": {
        "total": "100",
        "ok": "30",
        "ko": "70"
    },
    "minResponseTime": {
        "total": "52",
        "ok": "90",
        "ko": "52"
    },
    "maxResponseTime": {
        "total": "535",
        "ok": "530",
        "ko": "535"
    },
    "meanResponseTime": {
        "total": "119",
        "ok": "149",
        "ko": "106"
    },
    "standardDeviation": {
        "total": "122",
        "ok": "114",
        "ko": "123"
    },
    "percentiles1": {
        "total": "71",
        "ok": "110",
        "ko": "65"
    },
    "percentiles2": {
        "total": "107",
        "ok": "125",
        "ko": "73"
    },
    "percentiles3": {
        "total": "466",
        "ok": "467",
        "ko": "464"
    },
    "percentiles4": {
        "total": "530",
        "ok": "512",
        "ko": "489"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 30,
        "percentage": 30
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group4": {
        "name": "failed",
        "count": 70,
        "percentage": 70
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "50",
        "ok": "15",
        "ko": "35"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
