<%-- 
    Document   : pruebas
    Created on : 28-ene-2017, 17:54:56
    Author     : eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:p="http://primefaces.org/ui"
      xmlns:f="http://java.sun.com/jsf/core">
    <head>
        <title>Mutualista Central - Administrador</title> 
        <meta charset="utf-8"></meta>
        <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no, width=device-width"></meta>
        <link rel="stylesheet" type="text/css" href="../resources/css/usuarios.css"/>
    </head>
    <body style="text-align: center">

        <div  style="alignment-adjust: auto " >
            <table columns="2" style="margin: 0 auto; width: 100%">
                <tr>
                    <td>
                        <div style="text-align: left; alignment-adjust: auto ">
                            <a href="../index.xhtml" style="color: appworkspace; font-size: 0.5cm;">
                                <img id="home" src="../resources/img/config.jpg" alt="CONFIGURAR CUENTA" height="50" width="50" ><br>CONFIGURAR<br> CUENTA</br></br></img>
                            </a>
                        </div>
                    </td>
                    <td><div style="color: appworkspace; font-size: 1cm;">Bienvenido al panel de Administración</div></td>
                    <td>
                        <div style="text-align: right; alignment-adjust: auto ">
                            <img id="pregunta" src="../resources/img/pregunta.jpg" alt="" height="50" width="50" title=""></img>
                            <img id="contacto" src="../resources/img/contacto.jpg" alt="" height="50" width="50"></img>
                        </div>
                    </td>
                    </div>
                </tr>
            </table>
        </div>
        <div>
            <h:form>
                <p:growl autoUpdate="true"/>

                <p:panelMenu style="width:300px">
                    <p:submenu label="Ajax Menuitems">
                        <p:menuitem value="Save" actionListener="#{menuView.save}" icon="ui-icon-disk" />
                        <p:menuitem value="Update" actionListener="#{menuView.update}"  icon="ui-icon-arrowrefresh-1-w" />
                    </p:submenu>
                    <p:submenu label="Non-Ajax Menuitem">
                        <p:menuitem value="Delete" actionListener="#{menuView.delete}"  ajax="false" icon="ui-icon-close"/>
                    </p:submenu>
                    <p:separator />
                    <p:submenu label="Navigations" >
                        <p:submenu label="Links" icon="ui-icon-extlink">
                            <p:submenu label="PrimeFaces" icon="ui-icon-heart">
                                <p:menuitem value="Home" url="http://www.primefaces.org" icon="ui-icon-home" />
                                <p:menuitem value="Docs" url="http://www.primefaces.org/documentation" icon="ui-icon-document" />
                                <p:menuitem value="Download" url="http://www.primefaces.org/downloads" icon="ui-icon-arrowthick-1-s" />
                                <p:menuitem value="Support" url="http://www.primefaces.org/support" icon="ui-icon-wrench" />
                            </p:submenu>
                        </p:submenu>
                        <p:menuitem value="Mobile" outcome="/mobile/index" icon="ui-icon-signal" />
                    </p:submenu>
                </p:panelMenu>
            </h:form>
        </div>
        <script type="text/javascript" src="../resources/js/fastclick.js"></script>
        <script type="text/javascript" src="../resources/js/hammer.min.js"></script>
        <script type="text/javascript" src="../resources/js/gestures.js"></script>
    </body>
</html>
