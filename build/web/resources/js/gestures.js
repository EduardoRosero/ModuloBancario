var app = {
    inicio: function () {
        this.iniciarMovimientos();
        this.iniciarSaldo();
        this.iniciarTransferencias();
    },
    iniciarSaldo: function () {
        var zona = document.getElementById('zona-saldo');
        var hammertime = new Hammer(zona);
        zona.addEventListener('webkitAnimationEnd', function (e) {
            zona.className = '';
        });
        // Cambio de clase de zona-gestos para que se muestre el amarillo
        hammertime.on('tap', function (ev) {

            $("#cargar").load('Saldo.xhtml');
        });
    },
    iniciarMovimientos: function () {
        var zona = document.getElementById('zona-consultar');
        var hammertime = new Hammer(zona);
        zona.addEventListener('webkitAnimationEnd', function (e) {
            zona.className = '';
        });
        // Cambio de clase de zona-gestos para que se muestre el amarillo
        hammertime.on('tap', function (ev) {

            $("#cargar").load('../cuenta/List.xhtml');
        });
    },
    iniciarTransferencias: function () {
        var zona = document.getElementById('zona-transferencias');
        var hammertime = new Hammer(zona);
        zona.addEventListener('webkitAnimationEnd', function (e) {
            zona.className = '';
        });
        // Cambio de clase de zona-gestos para que se muestre el amarillo
        hammertime.on('tap', function (ev) {

            window.open('Transferencias.xhtml', "", "algun parametro que desees");
            //$("#cargar").load('Transferencias.xhtml');
        });
  },
    iniciarTransferenciaExitosa: function () {
        var zona = document.getElementById('btnIngresar');
        var hammertime = new Hammer(zona);
        zona.addEventListener('webkitAnimationEnd', function (e) {
            zona.className = '';
        });
        // Cambio de clase de zona-gestos para que se muestre el amarillo
        hammertime.on('tap', function (ev) {

            $("#cargar").unload('Transferencias.xhtml');
            $("#cargar").load('TransferenciaExitosa.xhtml');
        });
    },
    
    ventana: function newPage(url) {
        window.open(url, "", "algun parametro que desees");
    }
};

if ('addEventListener' in document) {
    document.addEventListener('DOMContentLoaded', function () {
        app.inicio();
    }, false);
}

function alertaTransferencia() {
    var x = document.getElementsByTagName("comparador")[0];
    
    if (x.value) { 
        alert("Transferencia éxitosa");
    }
    else
    {
        alert("No se pudo realizar la transferencia");
    }
}