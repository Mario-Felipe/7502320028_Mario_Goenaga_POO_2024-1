/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.mariogoenaga;

import java.util.Date;

import Crud.DocumentoCrud;
import Crud.EmpleadoCrud;
import Crud.EmpresaCrud;
import Crud.PromotorCrud;
import Crud.ProyectoCrud;
import Crud.TareaCrud;
import Crud.VersionCrud;
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

    public static void main(String args[]) {

        Documento documentoUno = new Documento();
        Empresa companiaUno = new Empresa();
        Empleado trabajadorUno = new Empleado();
        FuerzaLaboral manoObraUno = new FuerzaLaboral();
        Promotor liderUno = new Promotor();
        Proyecto proyectoUno = new Proyecto();
        RutaTrabajo planUno = new RutaTrabajo();
        Tarea actividadUno = new Tarea();
        Version versionUno = new Version();

        Documento documentoDos = new Documento();
        Empresa companiaDos = new Empresa();
        Empleado trabajadorDos = new Empleado();
        FuerzaLaboral manoObraDos = new FuerzaLaboral();
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
        trabajadorUno.setDni("DD001");
        trabajadorUno.setNombre("Casimiro");
        trabajadorUno.setApellido("Buenavista");
        trabajadorUno.setDireccion("Cartagena de Indias, Cra 15A # 74 - 75");
        trabajadorUno.setTelefono("3145586936");
        trabajadorUno.setCorreoElectronico("casiniveo@gmail.com");
        trabajadorUno.setFechaContratacion(new Date(15 / 8 / 1991));
        trabajadorUno.setRol("Desarrollador");
        trabajadorUno.setTipoContrato("Indefinido");
        trabajadorUno.setFechaNacimiento(new Date(18 / 12 / 1962));
        trabajadorUno.setEmpresa(companiaUno);

        trabajadorDos.setUsuario("Molesta02");
        trabajadorDos.setContrasena("Unpocomol123");
        trabajadorDos.setEstado("Activo");
        trabajadorDos.setDni("DD002");
        trabajadorDos.setNombre("Unpoco");
        trabajadorDos.setApellido("Molesta");
        trabajadorDos.setDireccion("Cartagena de Indias, Cll 56 # 17 - 130");
        trabajadorDos.setTelefono("3165587699");
        trabajadorDos.setCorreoElectronico("enojaa91@gmail.com");
        trabajadorDos.setFechaContratacion(new Date(22 / 6 / 2020));
        trabajadorDos.setRol("Analista de Datos");
        trabajadorDos.setTipoContrato("Indefinido");
        trabajadorDos.setFechaNacimiento(new Date(11 / 2 / 1981));
        trabajadorDos.setEmpresa(companiaDos);

        manoObraUno.setEmpleado(liderUno);
        manoObraUno.setProyecto(proyectoUno);

        manoObraDos.setEmpleado(liderDos);
        manoObraDos.setProyecto(proyectoDos);

        liderUno.setArea("Aplicativos Medio Ambiente");
        liderUno.setUsuario("MariB.PRO.01");
        liderUno.setContrasena("Ambiente123");
        liderUno.setEstado("Activo");
        liderUno.setDni("LL001");
        liderUno.setNombre("Maria");
        liderUno.setApellido("Bocanada");
        liderUno.setDireccion("Bogota D.C., Cll 157 # 6 - 87");
        liderUno.setTelefono("3158456630");
        liderUno.setCorreoElectronico("primervuelo@gmail.com");
        liderUno.setFechaContratacion(new Date(26 / 7 / 2017));
        liderUno.setRol("Promotor");
        liderUno.setTipoContrato("Indefinido");
        liderUno.setFechaNacimiento(new Date(1 / 3 / 1975));

        liderDos.setArea("Diseño de juguetes");
        liderDos.setUsuario("GustavC.PRO.02");
        liderDos.setContrasena("Juguetes123");
        liderDos.setEstado("Activo");
        liderDos.setDni("LL002");
        liderDos.setNombre("Gustavo");
        liderDos.setApellido("Cerati");
        liderDos.setDireccion("Medellin, Cll 96 # 39 - 103");
        liderDos.setTelefono("3118806523");
        liderDos.setCorreoElectronico("opioenlasnubes@gmail.com");
        liderDos.setFechaContratacion(new Date(19 / 10 / 2018));
        liderDos.setRol("Promotor");
        liderDos.setTipoContrato("Indefinido");
        liderDos.setFechaNacimiento(new Date(10 / 4 / 1970));

        proyectoUno.setNombreClave("Ambiental01");
        proyectoUno.setDenomComercial("App Gestion Sistemas de Riego");
        proyectoUno.setFechaInicio(new Date(18 / 3 / 2021));
        proyectoUno.setFechaFinalizacion(new Date(4 / 4 / 2022));
        proyectoUno.setEstado("Finalizado");
        proyectoUno.setCodigoProyecto("AMB001");
        proyectoUno.setPromotor(liderUno);

        proyectoDos.setNombreClave("Diversion101");
        proyectoDos.setDenomComercial("Lanzamiento nuevo juguete");
        proyectoDos.setFechaInicio(new Date(11 / 2 / 2024));
        proyectoDos.setFechaFinalizacion(new Date(30 / 10 / 2024));
        proyectoDos.setEstado("En curso");
        proyectoDos.setCodigoProyecto("DIV001");
        proyectoDos.setPromotor(liderDos);

        actividadUno.setIdentificadorTarea("T1AMB001");
        actividadUno.setDescripcion("Recolección de datos relevantes");
        actividadUno.setTipo("Investigación");
        actividadUno.setFechaInicioEstimada(new Date(20 / 3 / 2021));
        actividadUno.setFechaInicioReal(new Date(28 / 4 / 2021));
        actividadUno.setDuracionEstimada("2 semanas");
        actividadUno.setDuracionReal("3 semanas");
        actividadUno.setEmpleado("Casimiro Buenavista");
        actividadUno.setPrioridad("Alta");
        actividadUno.setProyecto(proyectoUno);

        actividadDos.setIdentificadorTarea("T1DIV001");
        actividadDos.setDescripcion("Diseño de nuevo juguete");
        actividadDos.setTipo("Diseño");
        actividadDos.setFechaInicioEstimada(new Date(11 / 2 / 2024));
        actividadDos.setFechaInicioReal(new Date(13 / 2 / 2024));
        actividadDos.setDuracionEstimada("5 semanas");
        actividadDos.setDuracionReal("En curso");
        actividadDos.setEmpleado("Unpoco Molesta");
        actividadDos.setPrioridad("Alta");
        actividadDos.setProyecto(proyectoDos);

        documentoUno.setProyecto("AMB001");
        documentoUno.setCodigoDocumento("D1AMB001");
        documentoUno.setFechaDocumento(new Date(03 / 13 / 2020));
        documentoUno.setDescripcion("Registro Actividad 1.");
        documentoUno.setTarea(actividadUno);

        documentoDos.setProyecto("DIV001");
        documentoDos.setCodigoDocumento("D1DIV001");
        documentoDos.setFechaDocumento(new Date(27 / 04 / 2021));
        documentoDos.setDescripcion("Registro Actividad 1.");
        documentoDos.setTarea(actividadDos);

        planUno.setEmpleado(liderUno);
        planUno.setTarea(actividadUno);

        planDos.setEmpleado(liderDos);
        planDos.setTarea(actividadDos);

        versionUno.setIdentificacion("V1.AMB001");
        versionUno.setFecha(new Date(10 / 6 / 2021));
        versionUno.setDescripcion("Primera versión del documento");
        versionUno.setEmpleado("Maria Bocanada");
        versionUno.setDocumento(documentoUno);

        versionDos.setIdentificacion("V2.AMB001");
        versionDos.setFecha(new Date(10 / 8 / 2021));
        versionDos.setDescripcion("Segunda versión del documento");
        versionDos.setEmpleado("Maria Bocanada");
        versionDos.setDocumento(documentoDos);

        DocumentoCrud documentoCrud = new DocumentoCrud();
        try {
            documentoCrud.agregar(documentoUno);
            documentoCrud.agregar(documentoDos);
            documentoCrud.buscar("D1AMB001");
            documentoCrud.buscar("D10AMB007");
            documentoCrud.buscar("D1DIV001");
            documentoCrud.editar(documentoUno);
            documentoCrud.editar(documentoDos);
            documentoCrud.eliminar("D1AMB001");
            documentoCrud.eliminar("D10AMB008");
            System.out.println("La lista de documentos es: " + documentoCrud.listarTodo());
            System.out.println("El numero de documentos existentes en la lista es: " + documentoCrud.contar());
            System.out.println("");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        EmpresaCrud empresaCrud = new EmpresaCrud();
        try {
            empresaCrud.agregar(companiaUno);
            empresaCrud.agregar(companiaDos);
            empresaCrud.buscar("1901515128");
            empresaCrud.buscar("1901417850");
            empresaCrud.buscar("1901400050");
            empresaCrud.editar(companiaUno);
            empresaCrud.editar(companiaDos);
            empresaCrud.eliminar("1901515128");
            empresaCrud.eliminar("1901400050");
            System.out.println("La Lista de compañias es: " + empresaCrud.listarTodo());
            System.out.println("El número de empresas existentes en la lista es: " + empresaCrud.contar());
            System.out.println("");            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        EmpleadoCrud empleadoCrud = new EmpleadoCrud();
        try {
            empleadoCrud.agregar(trabajadorUno);
            empleadoCrud.agregar(trabajadorDos);
            empleadoCrud.buscar("DD001");
            empleadoCrud.buscar("DD002");
            empleadoCrud.buscar("DD111");
            empleadoCrud.editar(trabajadorUno);
            empleadoCrud.editar(trabajadorDos);
            empleadoCrud.eliminar("DD001");
            empleadoCrud.eliminar("DD222");
            System.out.println("La lista de empleados es: " + empleadoCrud.listarTodo());
            System.out.println("El número de empleados existentes en la lista es: " + empleadoCrud.contar());
            System.out.println("");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        PromotorCrud promotorCrud = new PromotorCrud();
        try {
            promotorCrud.agregar(liderUno);
            promotorCrud.agregar(liderDos);
            promotorCrud.buscar("LL001");
            promotorCrud.buscar("LL002");
            promotorCrud.buscar("LL003");
            promotorCrud.editar(liderUno);
            promotorCrud.editar(liderDos);
            promotorCrud.eliminar("LL001");
            promotorCrud.eliminar("LL004");
            System.out.println("La lista de promotores es: " + promotorCrud.listarTodo());
            System.out.println("El número de promotores existentes en la lista es: " + promotorCrud.contar());
 ;          System.out.println("");
} catch (Exception e){
            System.out.println(e.getMessage());
         }

         ProyectoCrud proyectoCrud = new ProyectoCrud();
         try {
            proyectoCrud.agregar(proyectoUno);
            proyectoCrud.agregar(proyectoDos);
            proyectoCrud.buscar("AMB001");
            proyectoCrud.buscar("DIV001");
            proyectoCrud.buscar("XXX000");
            proyectoCrud.editar(proyectoUno);
            proyectoCrud.editar(proyectoDos);
            proyectoCrud.eliminar("AMB001");
            proyectoCrud.eliminar("YYY111");
            System.out.println("La lista de proyectos es: " + proyectoCrud.listarTodo());
            System.out.println("El número de proyectos existentes en la lista es: " + proyectoCrud.contar());   
            System.out.println("");
        } catch (Exception e) {
            System.out.println(e.getMessage());
         }

         TareaCrud tareaCrud = new TareaCrud();
         try {
            tareaCrud.agregar(actividadUno);
            tareaCrud.agregar(actividadDos);
            tareaCrud.buscar("T1AMB001");
            tareaCrud.buscar("T1DIV001");
            tareaCrud.buscar("T1.ProyectoXXX");
            tareaCrud.editar(actividadUno);
            tareaCrud.editar(actividadDos);       
            tareaCrud.eliminar("T1AMB001");
            tareaCrud.eliminar("T1.ProyectoYYY");
            System.out.println("La lista de tareas es: " + tareaCrud.listarTodo());
            System.out.println("El número de tareas existentes en la lsta es: " + tareaCrud.contar());
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
         }
       
        VersionCrud versionCrud = new VersionCrud();
        try {
            versionCrud.agregar(versionUno);
            versionCrud.agregar(versionDos);
            versionCrud.buscar("V1.AMB001");
            versionCrud.buscar("V2.AMB001");
            versionCrud.buscar("V10.AMB001");
            versionCrud.editar(versionUno);
            versionCrud.editar(versionDos);
            versionCrud.eliminar("V1.AMB001");
            versionCrud.eliminar("V11.AMB001");
            System.out.println("La lista de versiones es: " + versionCrud.listarTodo());
            System.out.println("El número de vesriones exixtentes en la lista es: " + versionCrud.contar());        
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        

}

}
