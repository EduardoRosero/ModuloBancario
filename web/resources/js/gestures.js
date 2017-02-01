var app={
  inicio: function(){
   this.iniciarConsultaMovimientos();
   this.iniciarConsultaSaldo();
  },

  iniciarConsultaSaldo: function() {
    var zona = document.getElementById('saldo');
    var hammertime = new Hammer(zona);
    zona.addEventListener('webkitAnimationEnd',function(e){
      zona.className='';
    });
     // Cambio de clase de zona-gestos para que se muestre el amarillo
    hammertime.on('tap', function(ev){
		
                 $("#cargar").load('Saldo.xhtml');
	});
  },
  
  iniciarConsultaMovimientos: function() {
    var zona = document.getElementById('consultar');
    var hammertime = new Hammer(zona);
    zona.addEventListener('webkitAnimationEnd',function(e){
      zona.className='';
    });
     // Cambio de clase de zona-gestos para que se muestre el amarillo
    hammertime.on('tap', function(ev){
		
                 $("#cargar").load('../cuenta/List.xhtml');
	});
  },

};

if ('addEventListener' in document) {
    document.addEventListener('DOMContentLoaded', function() {
        app.inicio();
    }, false);
}

