var app={
  inicio: function(){
   this.iniciarMovimientos();
   this.iniciarSaldo();
   this.iniciarTransferencias();
  },

  iniciarSaldo: function() {
    var zona = document.getElementById('zona-saldo');
    var hammertime = new Hammer(zona);
    zona.addEventListener('webkitAnimationEnd',function(e){
      zona.className='';
    });
     // Cambio de clase de zona-gestos para que se muestre el amarillo
    hammertime.on('tap', function(ev){
		
                 $("#cargar").load('Saldo.xhtml');
	});
  },
  
  iniciarMovimientos: function() {
    var zona = document.getElementById('zona-consultar');
    var hammertime = new Hammer(zona);
    zona.addEventListener('webkitAnimationEnd',function(e){
      zona.className='';
    });
     // Cambio de clase de zona-gestos para que se muestre el amarillo
    hammertime.on('tap', function(ev){
		
                 $("#cargar").load('../cuenta/List.xhtml');
	});
  },
  
    iniciarTransferencias: function() {
    var zona = document.getElementById('zona-transferencias');
    var hammertime = new Hammer(zona);
    zona.addEventListener('webkitAnimationEnd',function(e){
      zona.className='';
    });
     // Cambio de clase de zona-gestos para que se muestre el amarillo
    hammertime.on('tap', function(ev){
		
                 $("#cargar").load('Transferencias.xhtml');
	});
  },

};

if ('addEventListener' in document) {
    document.addEventListener('DOMContentLoaded', function() {
        app.inicio();
    }, false);
}

