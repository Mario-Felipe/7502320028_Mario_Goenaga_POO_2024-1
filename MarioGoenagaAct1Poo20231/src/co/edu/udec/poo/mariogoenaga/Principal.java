/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.mariogoenaga;

import java.util.Date;

import Dominio.Documento;
import Dominio.Empleado;
import Dominio.Empresa;
import Dominio.FuerzaLaboral;
import Dominio.Promotor;
import Dominio.Proyecto;
import Dominio.RutaTrabajo;
import Dominio.Tarea;
import Dominio.Version;

/**
 *
 * @author Mario Felipe
 */
public class Principal {
    
    public static void main (String args[]){

        Documento personaUno = new Documento();
        Empleado trabajadorUno = new Empleado();
        Empresa companiaUno = new Empresa();
        FuerzaLaboral manoObraUno = new FuerzaLaboral();//Pendiente
        Promotor liderUno = new Promotor();
        Proyecto proyectoUno = new Proyecto();
        RutaTrabajo planUno = new RutaTrabajo();
        Tarea actividadUno = new Tarea();
        Version versionUno = new Version();

        Documento personaDos = new Documento();
        Empleado trabajadorDos = new Empleado();
        Empresa companiaDos = new Empresa();
        FuerzaLaboral manoObraDos = new FuerzaLaboral();//Pendiente
        Promotor liderDos = new Promotor();
        Proyecto proyectoDos = new Proyecto();
        RutaTrabajo planDos = new RutaTrabajo();
        Tarea actividadDos = new Tarea();
        Version versionDos = new Version();

        companiaUno.setNit("1901515128");
        companiaUno.setNombre("Grupo GoGelis S.A.S");
        companiaUno.setTelefono("3107495857");
        companiaUno.setCorreoElectronico("grupogg2020@gmail.com");

        companiaDos.setNit("1901417850");
        companiaDos.setNombre("Avocado Team S.A.S");
        companiaDos.setTelefono("3168586963");
        companiaDos.setCorreoElectronico("ateamsas@gmail.com");
                
        trabajadorUno.setUsuario("CasimiBue01");
        trabajadorUno.setContrasena("Casimi123");
        trabajadorUno.setEstado("Activo");
        trabajadorUno.setNombre("Casimiro");
        trabajadorUno.setApellido("Buenavista");
        trabajadorUno.setDireccion("Cartagena de Indias, Cra 15A # 74 - 75");
        trabajadorUno.setTelefono("3145586936");
        trabajadorUno.setCorreoElectronico("casiniveo@gmail.com");
        trabajadorUno.setFechaContratacion(new Date(15/8/1991));
        trabajadorUno.setRol("Desarrollador");
        trabajadorUno.setTipoContrato("Indefinido");
        trabajadorUno.setFechaNacimiento(new Date(18/12/1962));
        trabajadorUno.setEmpresa(companiaUno);

        trabajadorDos.setUsuario("Molesta02");
        trabajadorDos.setContrasena("Unpocomol123");
        trabajadorDos.setEstado("Activo");
        trabajadorDos.setNombre("Unpoco");
        trabajadorDos.setApellido("Molesta");
        trabajadorDos.setDireccion("Cartagena de Indias, Cll 56 # 17 - 130");
        trabajadorDos.setTelefono("3165587699");
        trabajadorDos.setCorreoElectronico("enojaa91@gmail.com");
        trabajadorDos.setFechaContratacion(new Date(22/6/2020));
        trabajadorDos.setRol("Analista de Datos");
        trabajadorDos.setTipoContrato("Indefinido");
        trabajadorDos.setFechaNacimiento(new Date(11/2/1981));
        trabajadorDos.setEmpresa(companiaDos);

        manoObraUno.setEmpleado(liderUno);
        manoObraUno.setProyecto(proyectoUno);

        manoObraDos.setEmpleado(liderDos);
        manoObraDos.setProyecto(proyectoDos);

        
        liderUno.setArea("Aplicativos Medio Ambiente");
        liderUno.setUsuario("MariB.PRO.01");
        liderUno.setContrasena("Ambiente123");
        liderUno.setEstado("Activo");
        liderUno.setNombre("Maria");
        liderUno.setApellido("Bocanada");
        liderUno.setDireccion("Bogota D.C., Cll 157 # 6 - 87");
        liderUno.setTelefono("3158456630");
        liderUno.setCorreoElectronico("primervuelo@gmail.com");
        liderUno.setFechaContratacion(new Date(26/7/2017));
        liderUno.setRol("Promotor");
        liderUno.setTipoContrato("Indefinido");
        liderUno.setFechaNacimiento(new Date(1/3/1975));

        liderDos.setArea("Diseño de juguetes");
        liderDos.setUsuario("GustavC.PRO.02");
        liderDos.setContrasena("Juguetes123");
        liderDos.setEstado("Activo");
        liderDos.setNombre("Gustavo");
        liderDos.setApellido("Cerati");
        liderDos.setDireccion("Medellin, Cll 96 # 39 - 103");
        liderDos.setTelefono("3118806523");
        liderDos.setCorreoElectronico("opioenlasnubes@gmail.com");
        liderDos.setFechaContratacion(new Date(19/10/2018));
        liderDos.setRol("Promotor");
        liderDos.setTipoContrato("Indefinido");
        liderDos.setFechaNacimiento(new Date(10/4/1970));

        proyectoUno.setNombreClave("Ambiental01");
        proyectoUno.setDenomComercial("App Gestion Sistemas de Riego");
        proyectoUno.setFechaInicio(new Date(18/3/2021)); 
        proyectoUno.setFechaFinalizacion(new Date(4/4/2022)); 
        proyectoUno.setEstado("Finalizado");
        proyectoUno.setCodigoProyecto("AMB001");
        proyectoUno.setPromotor(liderUno);   

        proyectoDos.setNombreClave("Diversion101");
        proyectoDos.setDenomComercial("Lanzamiento nuevo juguete");
        proyectoDos.setFechaInicio(new Date(11/2/2024)); 
        proyectoDos.setFechaFinalizacion(new Date(30/10/2024)); 
        proyectoDos.setEstado("En curso");
        proyectoDos.setCodigoProyecto("DIV001");
        proyectoDos.setPromotor(liderDos);

        actividadUno.setDescripcion("Obtención de datos relevantes");
        actividadUno.setTipo("Investigación");
        actividadUno.setFechaInicioEstimada(new Date(20/3/2021));
        actividadUno.setFechaInicioReal(new Date(28/4/2021));
        actividadUno.setDuracionEstimada("2 semanas");
        actividadUno.setDuracionReal("3 semanas");
        actividadUno.setEmpleado("Casimiro Buenavista");
        actividadUno.setPrioridad("Alta");
        actividadUno.setProyecto(proyectoUno);

        actividadDos.setDescripcion("Diseño de nuevo juguete");
        actividadDos.setTipo("Diseño");
        actividadDos.setFechaInicioEstimada(new Date(11/2/2024));
        actividadDos.setFechaInicioReal(new Date(13/2/2024));
        actividadDos.setDuracionEstimada("5 semanas");
        actividadDos.setDuracionReal("En curso");
        actividadDos.setEmpleado("Unpoco Molesta");
        actividadDos.setPrioridad("Alta");
        actividadDos.setProyecto(proyectoDos);

        personaUno.setProyecto("Propyecto A");
        personaUno.setCodigoDocumento("001");
        personaUno.setFechaDocumento(new Date(03/13/2020));
        personaUno.setDescripcion("Registro Actividad 1.");      
        personaUno.setTarea(actividadUno);

        personaDos.setProyecto("Proyecto B");
        personaDos.setCodigoDocumento("002");
        personaDos.setFechaDocumento(new Date(27/04/2021));
        personaDos.setDescripcion("Registro Actividad 2.");
        personaDos.setTarea(actividadDos);

        planUno.setEmpleado(liderUno);
        planUno.setTarea(actividadUno);

        planDos.setEmpleado(liderDos);
        planDos.setTarea(actividadDos);      

        versionUno.setIdentificacion("V1.AMB001");
        versionUno.setFecha(new Date(10/6/2021)); 
        versionUno.setDescripcion("Primera versión del documento");
        versionUno.setEmpleado("Maria Bocanada");
        versionUno.setDocumento(personaUno);

        versionDos.setIdentificacion("V2.AMB001");
        versionDos.setFecha(new Date(10/8/2021)); 
        versionDos.setDescripcion("Segunda versión del documento");
        versionDos.setEmpleado("Maria Bocanada");
        versionDos.setDocumento(personaDos);
       
    }
        
}