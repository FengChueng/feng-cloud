var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "100",
        "ok": "29",
        "ko": "71"
    },
    "minResponseTime": {
        "total": "334",
        "ok": "533",
        "ko": "334"
    },
    "maxResponseTime": {
        "total": "1090",
        "ok": "1090",
        "ko": "752"
    },
    "meanResponseTime": {
        "total": "607",
        "ok": "782",
        "ko": "536"
    },
    "standardDeviation": {
        "total": "169",
        "ok": "144",
        "ko": "119"
    },
    "percentiles1": {
        "total": "644",
        "ok": "767",
        "ko": "501"
    },
    "percentiles2": {
        "total": "709",
        "ok": "784",
        "ko": "653"
    },
    "percentiles3": {
        "total": "815",
        "ok": "1081",
        "ko": "726"
    },
    "percentiles4": {
        "total": "1086",
        "ok": "1089",
        "ko": "748"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 23,
        "percentage": 23
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 6,
        "percentage": 6
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group4": {
        "name": "failed",
        "count": 71,
        "percentage": 71
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "50",
        "ok": "14.5",
        "ko": "35.5"
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
        "ok": "29",
        "ko": "71"
    },
    "minResponseTime": {
        "total": "334",
        "ok": "533",
        "ko": "334"
    },
    "maxResponseTime": {
        "total": "1090",
        "ok": "1090",
        "ko": "752"
    },
    "meanResponseTime": {
        "total": "607",
        "ok": "782",
        "ko": "536"
    },
    "standardDeviation": {
        "total": "169",
        "ok": "144",
        "ko": "119"
    },
    "percentiles1": {
        "total": "644",
        "ok": "767",
        "ko": "501"
    },
    "percentiles2": {
        "total": "709",
        "ok": "784",
        "ko": "653"
    },
    "percentiles3": {
        "total": "815",
        "ok": "1081",
        "ko": "726"
    },
    "percentiles4": {
        "total": "1086",
        "ok": "1089",
        "ko": "748"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 23,
        "percentage": 23
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 6,
        "percentage": 6
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group4": {
        "name": "failed",
        "count": 71,
        "percentage": 71
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "50",
        "ok": "14.5",
        "ko": "35.5"
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
