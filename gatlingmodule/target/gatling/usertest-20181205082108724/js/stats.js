var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "1001",
        "ok": "982",
        "ko": "19"
    },
    "minResponseTime": {
        "total": "320",
        "ok": "320",
        "ko": "661"
    },
    "maxResponseTime": {
        "total": "60001",
        "ok": "41654",
        "ko": "60001"
    },
    "meanResponseTime": {
        "total": "16488",
        "ok": "16296",
        "ko": "26449"
    },
    "standardDeviation": {
        "total": "9907",
        "ok": "9068",
        "ko": "28634"
    },
    "percentiles1": {
        "total": "17140",
        "ok": "17148",
        "ko": "3428"
    },
    "percentiles2": {
        "total": "23319",
        "ok": "23283",
        "ko": "60000"
    },
    "percentiles3": {
        "total": "30078",
        "ok": "29488",
        "ko": "60001"
    },
    "percentiles4": {
        "total": "39928",
        "ok": "38474",
        "ko": "60001"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 36,
        "percentage": 4
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 2,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 944,
        "percentage": 94
    },
    "group4": {
        "name": "failed",
        "count": 19,
        "percentage": 2
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "16.41",
        "ok": "16.098",
        "ko": "0.311"
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
        "total": "1001",
        "ok": "982",
        "ko": "19"
    },
    "minResponseTime": {
        "total": "320",
        "ok": "320",
        "ko": "661"
    },
    "maxResponseTime": {
        "total": "60001",
        "ok": "41654",
        "ko": "60001"
    },
    "meanResponseTime": {
        "total": "16488",
        "ok": "16296",
        "ko": "26449"
    },
    "standardDeviation": {
        "total": "9907",
        "ok": "9068",
        "ko": "28634"
    },
    "percentiles1": {
        "total": "17140",
        "ok": "17148",
        "ko": "3428"
    },
    "percentiles2": {
        "total": "23319",
        "ok": "23283",
        "ko": "60000"
    },
    "percentiles3": {
        "total": "30078",
        "ok": "29488",
        "ko": "60001"
    },
    "percentiles4": {
        "total": "39928",
        "ok": "38474",
        "ko": "60001"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 36,
        "percentage": 4
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 2,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 944,
        "percentage": 94
    },
    "group4": {
        "name": "failed",
        "count": 19,
        "percentage": 2
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "16.41",
        "ok": "16.098",
        "ko": "0.311"
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
