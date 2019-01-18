var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "150",
        "ok": "50",
        "ko": "100"
    },
    "minResponseTime": {
        "total": "142",
        "ok": "323",
        "ko": "142"
    },
    "maxResponseTime": {
        "total": "9103",
        "ok": "698",
        "ko": "9103"
    },
    "meanResponseTime": {
        "total": "509",
        "ok": "527",
        "ko": "501"
    },
    "standardDeviation": {
        "total": "716",
        "ok": "110",
        "ko": "873"
    },
    "percentiles1": {
        "total": "467",
        "ok": "526",
        "ko": "442"
    },
    "percentiles2": {
        "total": "554",
        "ok": "611",
        "ko": "507"
    },
    "percentiles3": {
        "total": "673",
        "ok": "685",
        "ko": "596"
    },
    "percentiles4": {
        "total": "695",
        "ok": "695",
        "ko": "700"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 50,
        "percentage": 33
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
        "count": 100,
        "percentage": 67
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "15",
        "ok": "5",
        "ko": "10"
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
        "total": "150",
        "ok": "50",
        "ko": "100"
    },
    "minResponseTime": {
        "total": "142",
        "ok": "323",
        "ko": "142"
    },
    "maxResponseTime": {
        "total": "9103",
        "ok": "698",
        "ko": "9103"
    },
    "meanResponseTime": {
        "total": "509",
        "ok": "527",
        "ko": "501"
    },
    "standardDeviation": {
        "total": "716",
        "ok": "110",
        "ko": "873"
    },
    "percentiles1": {
        "total": "467",
        "ok": "526",
        "ko": "442"
    },
    "percentiles2": {
        "total": "554",
        "ok": "611",
        "ko": "507"
    },
    "percentiles3": {
        "total": "673",
        "ok": "685",
        "ko": "596"
    },
    "percentiles4": {
        "total": "695",
        "ok": "695",
        "ko": "700"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 50,
        "percentage": 33
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
        "count": 100,
        "percentage": 67
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "15",
        "ok": "5",
        "ko": "10"
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
