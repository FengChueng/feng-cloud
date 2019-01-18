var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "600",
        "ok": "598",
        "ko": "2"
    },
    "minResponseTime": {
        "total": "344",
        "ok": "344",
        "ko": "10000"
    },
    "maxResponseTime": {
        "total": "10001",
        "ok": "3639",
        "ko": "10001"
    },
    "meanResponseTime": {
        "total": "1310",
        "ok": "1281",
        "ko": "10001"
    },
    "standardDeviation": {
        "total": "834",
        "ok": "667",
        "ko": "1"
    },
    "percentiles1": {
        "total": "1209",
        "ok": "1208",
        "ko": "10001"
    },
    "percentiles2": {
        "total": "1694",
        "ok": "1690",
        "ko": "10001"
    },
    "percentiles3": {
        "total": "2241",
        "ok": "2235",
        "ko": "10001"
    },
    "percentiles4": {
        "total": "3167",
        "ok": "3164",
        "ko": "10001"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 175,
        "percentage": 29
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 121,
        "percentage": 20
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 302,
        "percentage": 50
    },
    "group4": {
        "name": "failed",
        "count": 2,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "54.545",
        "ok": "54.364",
        "ko": "0.182"
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
        "total": "600",
        "ok": "598",
        "ko": "2"
    },
    "minResponseTime": {
        "total": "344",
        "ok": "344",
        "ko": "10000"
    },
    "maxResponseTime": {
        "total": "10001",
        "ok": "3639",
        "ko": "10001"
    },
    "meanResponseTime": {
        "total": "1310",
        "ok": "1281",
        "ko": "10001"
    },
    "standardDeviation": {
        "total": "834",
        "ok": "667",
        "ko": "1"
    },
    "percentiles1": {
        "total": "1209",
        "ok": "1208",
        "ko": "10001"
    },
    "percentiles2": {
        "total": "1694",
        "ok": "1690",
        "ko": "10001"
    },
    "percentiles3": {
        "total": "2241",
        "ok": "2235",
        "ko": "10001"
    },
    "percentiles4": {
        "total": "3167",
        "ok": "3164",
        "ko": "10001"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 175,
        "percentage": 29
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 121,
        "percentage": 20
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 302,
        "percentage": 50
    },
    "group4": {
        "name": "failed",
        "count": 2,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "54.545",
        "ok": "54.364",
        "ko": "0.182"
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
