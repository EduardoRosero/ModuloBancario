function woopraReady(tracker) {
	    tracker.setDomain('csslab.cl');
	    tracker.setIdleTimeout(300000);
	    tracker.track();
	    return false;
	}
	(function() {
	    var wsc = document.createElement('script');
	    wsc.src = document.location.protocol+'//static.woopra.com/js/woopra.js';
	    wsc.type = 'text/javascript';
	    wsc.async = true;
	    var ssc = document.getElementsByTagName('script')[0];
	    ssc.parentNode.insertBefore(wsc, ssc);
	})();