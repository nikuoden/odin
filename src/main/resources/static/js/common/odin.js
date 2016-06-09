<!-- Menu Toggle Script -->
$(".article-setting").click(function(e) {
    e.preventDefault();
    $("#sidebar").toggleClass("toggled");
});

$(".nav navbar-nav top-nav li").click(function(e) {
	$(".navbar-nav li.active").removeClass("active");
	this.className = "active";
});