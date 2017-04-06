/***************
 * *****头部***********
 ******************/

/*****消息通知显示*********/
/** 异步轮询执行查询函数*/
function getnewsAdvice (url) {
	$.getJSON(url, function (data) {
		if (data.status) {
		   news({
				"total" : data.total,
				"type" : data.type
			});
		}
		setTimeout(function () {
			get_msg(url);
		}, 5000);
	});
}
/*查询消息通知表解析函数*/
/**
 * 推送的新消息
 * @param  {[type]} json {total:新消息的条数,type:（1：评论，2：私信，3：@我）}
 * @return {[type]}      [description]
 */
var flags = true;
function newsAdviceFun(json) {
	switch (json.type) {
		case 1:
			$('#head_li_news ul .news_comment').show().find('a').html(json.total + '条新评论');
			break;
		case 2:
			$('#head_li_news ul .news_letter').show().find('a').html(json.total + '条新私信');
			break;
		case 3:
			$('#head_li_news ul .news_atme').show().find('a').html(json.total + '条@提到我');
			break;
	}
	var obj = $('#head_li_news');
	var icon = obj.find('i');
	obj.show().find('li').hover(function () {  //下拉项添加效果
		$(this).css('background', '#DCDCDC');
	}, function () {
		$(this).css('background', 'none');
	}).click(function () {
		clearInterval(newsGlint);
	});
	if (flags) {
		flags = false;
		var newsGlint= setInterval(function () {
			icon.toggleClass("icon-news");
		}, 500);
	}
}