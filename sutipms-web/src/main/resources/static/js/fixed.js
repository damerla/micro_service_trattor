 //Script to left column border.
//Script to left column border.
$(document).ready(function(){setDynamicHeight();});
$(window).resize(function() {
    setDynamicHeight();
});
function setDynamicHeight(){
    $(".ppro-right").css('height', "auto");
    $("#sideFixedDiv").css('height', "auto");
    setDivLineToBottom();
}
function setDivLineToBottom(){
    if($("#sideFixedDiv").length > 0){
        var sideFixedDiv = $("#sideFixedDiv");
        var proRightObj = $(".ppro-right");
        var windowHeight = $(window).height();
        var contentDivHight = (sideFixedDiv.height() > proRightObj.height()) ? sideFixedDiv.height() : proRightObj.height() ;
        var contentDivTop = sideFixedDiv.position().top
        var totalDivHeight = contentDivHight + contentDivTop;
        if(totalDivHeight < windowHeight){
            var divHeight = (contentDivHight + (windowHeight - totalDivHeight - 30));
            sideFixedDiv.css('height', divHeight + "px");
            proRightObj.css('height', divHeight + "px");
            $(window).scroll();
        }else{
            sideFixedDiv.css('height', contentDivHight + "px");
            proRightObj.css('height', contentDivHight + "px");
            $(window).scroll();
        }
    }
    setDivScrollable();
}
function setDivScrollable(){
	$(window).scroll(function() {
		var sideFixedDiv = $("#sideFixedDiv");
		var proRightObj = $(".ppro-right");
		var sideFixedDivOffset = sideFixedDiv.offset();
    	var proRightObjOffset = proRightObj.offset();
		var summaryContentDivTop = proRightObjOffset.top;
        if(sideFixedDivOffset.left == proRightObjOffset.left){
			sideFixedDiv.css({
               'top': 'auto',
			   'height': 'auto',
               'position': 'relative'
            });
			return;
		}
		sideFixedDiv.css({'position': 'absolute'});
		var contentDivHight = (sideFixedDiv.height() > proRightObj.height()) ? sideFixedDiv.height() : proRightObj.height() ;
        var receiptRowDiv = sideFixedDiv.height();
        if(contentDivHight >= receiptRowDiv){
            var scrollYpos = $(document).scrollTop();
			if ((scrollYpos > summaryContentDivTop)) {
				var windowHeight = $(window).height();
                sideFixedDiv.css({
                    'top': '0px',
					'height': windowHeight+"px",
                    'position': 'fixed'
                });
            } else {
                sideFixedDiv.css({
                    'top': 'auto',
					'height': windowHeight+"px",
                    'position': 'absolute'
                });
            }
        }else{
             $(window).off("scroll", function(){});
        }
    });
}




