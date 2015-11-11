/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login.ventas;

import java.util.Scanner;

/**
 *
 * @author rcoello
 */
public class FormularioBI {
    /*
        static Estudiante estudiantes[]=new Estudiante[10];
        ?? nos tocara conversar un poco... no es muy recomendable hacer eso pero buee.
    */
    static Estudiante estudiantes[]=new Estudiante[10];
    private static Scanner s=new Scanner(System.in);
    int total_estudiantes=0;// IVAN agrego
  
    public static void main(String[] args) {
        int N_estu=0; // numero de estudiantes ingresados.
        System.out.println("Formulario de Inscripción BI COPOL");
        /*
            System.out.println(" Y ¿Qué desea hacer?: 1 Si desea ingresar información, 2 Si desea consultar, 3 Salir ");
            int op=s.nextInt();
            Lo pide 2 veces??? basta con 1
        */
        System.out.println(" Y ¿Qué desea hacer?: 1 Si desea Acceder al Modulo, 0 Salir ");
        int op=s.nextInt();
        /*
            while(op!=0)
            Esta bien hecho el While con el switch.
        */
        while(op!=0)
        {
            System.out.println(" Y ¿Aquí desea hacer?: 1 Si desea ingresar información, 2 Si desea consultar, 3 Salir ");
            op=s.nextInt();
         
            switch(op)
            {
                case 1: N_estu=ingreso(N_estu);
                    break;
                case 2: consulta(N_estu);
                    break;             
                default:break;
            }
        }
    }
    private static int ingreso(int numero)
    {
        System.out.println("Ingrese la información requerida:");
        System.out.println("Nombre: ");
        String n=s.next();
        System.out.println("Apellido: ");
        String a=s.next();
        System.out.println("Opcion: Ingrese 'd' para Diploma o 'c' para Certificado");
        char o=s.next().charAt(0);
        boolean diploma=false;        
        boolean certificado=false;        
        if(o=='d') {
            diploma=true;
        }
        else if(o=='c') {
            certificado=true;
  
             }
        
        System.out.println("Paralelo: ");
        String p=s.next();
        System.out.println("Fecha de Nacimiento (dd/mm/aaaa): ");
        String fn=s.next();
       
        
        System.out.println("Ingrese los números que corresponden a las materias de nivel superior del estudiante, separados por comas (hasta 4 materias): ");
        System.out.println("1: Español A1 - 2: English B - 3: Empresa y Gestión - 4: Física - 5: Biología");
        String cadMaterias=s.next();
        String arrMaterias [];
        arrMaterias = new String[100];
        /*
              {
                System.exit(100);
              }
              eso cierra el programa sin dejarlo continuar, el numero 100 solo es un valor no tiene importancia.
        */
        //{ IVAN quito esta parte del codigo
          //System.exit(100);
        //}
        arrMaterias=cadMaterias.split(",");
        Materia [] m;
        m = new Materia[4];
        for(int i=0;i<4;i++)
        {            
            m[i]=new Materia(nombreMateria(arrMaterias[i]),'s');
        }
        Estudiante e= new Estudiante(n, a, o, p, fn, diploma, certificado);
        e.setMaterias(m);
        estudiantes[numero]=e;
        System.out.println("Ingreso exitoso!!! =) ");
        numero++;
        return numero;
    }
    
    private static void consulta(int numero)
    {
        System.out.println("Estudiantes Ingresados!!! =) ");
        for(int i=0; i<numero;i++){
            System.out.println("Nombre: "+estudiantes[i].getNombre()+"\n"+"Apellido: "+estudiantes[i].getApellido()+"\n"+"Paralelo: "+estudiantes[i].getParalelo()+"\n"+"Fecha Nacimiento: "+estudiantes[i].getfNac()+"\n");
            if(estudiantes[i].getCertificado()){
                System.out.println("Tiene Certificado \n");
            }else{
                System.out.println("Tiene Diploma \n");
            }
            System.out.println("Materias Registradas: \n");
            for(Materia j: estudiantes[i].getMaterias()){
                System.out.println("\t"+j.getNombre()+" \n");
            }
        }
    }
    private static String nombreMateria(String nMateria)
    {
        switch (nMateria) {
            case "1":
                return "Español A1";
            case "2":
                return "English B";
            case "3":
                return "Empresa y Gestión";
            case "4":
                return "Física";
            case "5":
                return "Biología";
        }
        return "";
    }
}
class Estudiante
{
    private String nombre;
    private String apellido;
    private char opcion;
    private String paralelo;
    private String fNac;
    private boolean diploma;
    private boolean certificado;
    private Materia materias [];

    public Estudiante(String nombre, String apellido, char opcion, String paralelo, String fNac, boolean diploma, boolean certificado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.opcion = opcion;
        this.paralelo = paralelo;
        this.fNac = fNac;
        this.diploma = diploma;
        this.certificado = certificado;
        materias=new Materia[6];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public char getOpcion() {
        return opcion;
    }

    public void setOpcion(char opcion) {
        this.opcion = opcion;
    }

    public String getParalelo() {
        return paralelo;
    }

    public void setParalelo(String paralelo) {
        this.paralelo = paralelo;
    }

    public String getfNac() {
        return fNac;
    }

    public void setfNac(String fNac) {
        this.fNac = fNac;
    }

    public boolean getDiploma() {
        return diploma;
    }

    public void setDiploma(boolean diploma) {
        this.diploma = diploma;
    }

    public boolean getCertificado() {
        return certificado;
    }

    public void setCertificado(boolean certificado) {
        this.certificado = certificado;
    }

    public Materia[] getMaterias() {
        return materias;
    }

    public void setMaterias(Materia[] materias) {
        this.materias = materias;
    }
    
    
}
class Materia
{
    private String nombre;
    private char nivel;

    public Materia(String nombre, char nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getNivel() {
        return nivel;
    }

    public void setNivel(char nivel) {
        this.nivel = nivel;
    }
    
}
