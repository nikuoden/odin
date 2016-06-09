var articleId = $(".contents").data("articleid");

if(typeof articleId !== "undefined"){
	$.ajax({
		  type: 'GET',
		  url: '/odin/api/article/'+ articleId,
		  dataType: 'json',
		  jsonCallback: 'callback',
		  success: function(json){
			  var len = Object.keys(json).length;
			  if(len != 0){
				  createEditArticle(json, len);
				  $('.edit-body').autosize();
			  }else {
				  // nothing
			  }
		  }
	});
}

function createEditArticle(json , len) {
	  $(".edit-title").attr("value", json.title);
	  $(".edit-body").text(json.body);
	  $(".article-preview div").append(marked(json.body));
	  $(".articleImage").prop("value", json.articleImage);
	  $(".articleUrl").prop("value", json.articleUrl);
	  $(".category").prop("value", json.category);
	  $(".tag").prop("value", json.category);
	  $(".keyword").prop("value", json.category);
	  $(".publicFlag").prop("checked", json.publicFlag);
}

function createArticlePreview(json, i) {
	var formatted = marked(json[i].body);
	var selection = $("<selection/>").addClass("preview"+json[i].articleId);
	selection.append(formatted);
	if(i == 0) {
		selection.show();
	} else {
		selection.hide();
	}

	$(".article-preview").append(selection);
	$(".article-preview");
}

$('.edit-body').each(function(){
	$(this).bind('keyup', change(this));
});

function change(elm){
	var v, old = elm.value;
	return function(){
		if(old != (v=elm.value)){
			old = v;
			str = $(this).val();
			$(".article-preview div").empty();
			$(".article-preview div").append(marked(str));
		}
	}
}

$(document).on('click','.save-article',function(){
	createParams();
	if(typeof articleId !== "undefined"){
		$('.articleEditForm').attr("action", "/odin/management/edit/" + articleId);
		$('.articleEditForm').submit();
	} else{
		$('.articleEditForm').attr("action", "/odin/management/edit/");
		$('.articleEditForm').submit();
	}
});

function createParams() {
	$('<input>').attr({type: 'hidden',
		name: 'title',
	    value: $(".edit-title").prop("value")
	}).appendTo('.articleEditForm');

	$('<input>').attr({type: 'hidden',
		name: 'body',
	    value: $(".edit-body").prop("value")
	}).appendTo('.articleEditForm');

	$('<input>').attr({type: 'hidden',
		name: 'articleImage',
	    value: $(".articleImage").val()
	}).appendTo('.articleEditForm');

	$('<input>').attr({type: 'hidden',
		name: 'articleUrl',
	    value: $(".articleUrl").val()
	}).appendTo('.articleEditForm');

	$('<input>').attr({type: 'hidden',
		name: 'category',
	    value: $(".category").val()
	}).appendTo('.articleEditForm');

	$('<input>').attr({type: 'hidden',
		name: 'tag',
	    value: $(".tag").val()
	}).appendTo('.articleEditForm');

	$('<input>').attr({type: 'hidden',
		name: 'keyword',
	    value: $(".keyword").val()
	}).appendTo('.articleEditForm');

	$('<input>').attr({type: 'hidden',
		name: 'publicFlag',
	    value: $('.publicFlag').prop("checked")
	}).appendTo('.articleEditForm');
}
