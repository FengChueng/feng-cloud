var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "400",
        "ok": "400",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "194",
        "ok": "194",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1643",
        "ok": "1643",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "911",
        "ok": "911",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "438",
        "ok": "438",
        "ko": "-"
    },
    "percentiles1": {
        "total": "872",
        "ok": "872",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1326",
        "ok": "1326",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1566",
        "ok": "1566",
        "ko": "-"
    },
    "percentiles4": {
        "total": "1609",
        "ok": "1609",
        "ko": "-"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 176,
        "percentage": 44
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 94,
        "percentage": 24
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 130,
        "percentage": 33
    },
    "group4": {
        "name": "failed",
        "count": 0,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "200",
        "ok": "200",
        "ko": "-"
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
        "total": "400",
        "ok": "400",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "194",
        "ok": "194",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1643",
        "ok": "1643",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "911",
        "ok": "911",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "438",
        "ok": "438",
        "ko": "-"
    },
    "percentiles1": {
        "total": "872",
        "ok": "872",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1326",
        "ok": "1326",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1566",
        "ok": "1566",
        "ko": "-"
    },
    "percentiles4": {
        "total": "1609",
        "ok": "1609",
        "ko": "-"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 176,
        "percentage": 44
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 94,
        "percentage": 24
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 130,
        "percentage": 33
    },
    "group4": {
        "name": "failed",
        "count": 0,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "200",
        "ok": "200",
        "ko": "-"
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