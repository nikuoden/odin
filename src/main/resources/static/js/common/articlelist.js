$(document).on('click','.article-list li',function(){
	$(".article-list li.active").removeClass("active");
	this.className = "active";

	$("selection[class^=preview]").hide();

	var $this = $(this);
	var articleId = $this.children("a").children(".article").data("articleid");
	$(".preview" + articleId).show();
});

$(document).on('dblclick','.article-list li',function(){
	var $this = $(this);
	var articleId = $this.children("a").children(".article").data("articleid");
	window.location.href = 'edit/' + articleId;
});

$.ajax({
	  type: 'GET',
	  url: '/odin/api/article/',
	  data: "force=true",
	  dataType: 'json',
	  jsonCallback: 'callback',
	  success: function(json){
		  var len = json.length;
		  if(len != 0){
			  createArticleList(json, len);
		  }else {
			  // nothing
		  }
	  }
});

function createArticleList(json , len) {
	  $(".articles").empty();
	  var section = $("<section/>").addClass("article-list");
	  var ol = $("<ol/>");
	  for(var i=0; i < len; i++){
		  var li =  $("<li/>")
		  var a =  $("<a href=\"javascript: void(0)\" />")
		  if(i==0){
			  li.addClass("active");
		  }
		  var div = $("<div data-articleId=" + json[i].articleId + "/>").addClass("article");
		  var h3 = $("<h3/>").addClass("article-title");
		  h3.append(json[i].title);
		  div.append(h3);
		  a.append(div);
		  li.append(a);
		  ol.append(li);

		  createArticlePreview(json, i);
	  }
	  section.append(ol);
	  $(".articles").append(section);
}

function createArticlePreview(json, i) {
	var formatted;
	if(json[i].body != null){
		formatted = marked(json[i].body);
	}

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
