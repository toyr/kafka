/**
 * 通用的上传数据到后端的方法
 * @param mainData 上报的主数据
 * @param metaDate 上报的附加数据
 * @param url   根据上报信息的类型采用不同的URL
 */
function r_reportUserActivity(mainData, metaDate, url) {
    var reportJson = {};
    reportJson["creatTime"] = (new date()).toLocaleString();
    $.extend(reportJson, mainData);
    if (metaDate) {
        reportJson["metaDate"] = metaDate;
    }

    $.ajax({
       type: "post",
       url: url,
        async: true,
        data: JSON.stringify(reportJson),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data) {
            console.log(data);
        }
    });
}

/**
 * 上报页面浏览数据
 * @param mainData 上报的主数据，必填
 * @param metaDate 上报的附加数据，选填
 */
function r_reportPage(mainData, metaDate) {
    r_reportUserActivity(mainData, metaDate, "/report/pc/pageView");
}

/**
 * 上报用户点击数据
 * @param mainData 上报的主数据，必填
 * @param metaData 上报的附加数据，选填
 */
function r_reportClick(mainData, metaData) {
    $(document).on("click", function (event) {
        var $target = $(event.target);
        // 判断是否是需要上报的元素
        var rua = $target.closest("[report_click]");
        if (rua) {
            var reportClickId = rua.attr("report_click");
            if (reportClickId) {
                var reportClickDataArr = $("[report_click_data'" + reportClickId +"']");
                var clickData = [];
                // 查找相关联元素的数据信息
                if (reportClickDataArr) {
                    reportClickDataArr.each(function () {
                        var elementData = {
                            "tagType": $(this).get(0).tagName,
                            'content': $(this).val()
                        };
                        clickData.push(elementData);
                    });
                }
                mainData["operate"] = reportClickId;
                metaData["clickData"] = clickData;

                r_reportUserActivity(mainData, metaData, "report/pc/click");
            }
        }
    });
}