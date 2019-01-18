var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "100",
        "ok": "100",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "338",
        "ok": "338",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1871",
        "ok": "1871",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "894",
        "ok": "894",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "459",
        "ok": "459",
        "ko": "-"
    },
    "percentiles1": {
        "total": "637",
        "ok": "637",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1345",
        "ok": "1345",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1751",
        "ok": "1751",
        "ko": "-"
    },
    "percentiles4": {
        "total": "1780",
        "ok": "1780",
        "ko": "-"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 53,
        "percentage": 53
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 11,
        "percentage": 11
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 36,
        "percentage": 36
    },
    "group4": {
        "name": "failed",
        "count": 0,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "50",
        "ok": "50",
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
        "total": "100",
        "ok": "100",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "338",
        "ok": "338",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1871",
        "ok": "1871",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "894",
        "ok": "894",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "459",
        "ok": "459",
        "ko": "-"
    },
    "percentiles1": {
        "total": "637",
        "ok": "637",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1345",
        "ok": "1345",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1751",
        "ok": "1751",
        "ko": "-"
    },
    "percentiles4": {
        "total": "1780",
        "ok": "1780",
        "ko": "-"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 53,
        "percentage": 53
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 11,
        "percentage": 11
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 36,
        "percentage": 36
    },
    "group4": {
        "name": "failed",
        "count": 0,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "50",
        "ok": "50",
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
