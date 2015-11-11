/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bitacora.servicio;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Administrador
 */
public class Funcion {

    public static int StringToInt(String o) {
        try {
            if (o.length() == 0) {
                return 0;
            }
            return Integer.parseInt(o);
        } catch (NumberFormatException e) {
            System.err.print("\nAl convertir a INT (" + o + "): " + e.toString());
            return 0;
        }
    }

    public static double StringToDouble(String o) {
        try {
            if (o.length() == 0) {
                return 0;
            }
            return Double.parseDouble(o);
        } catch (Exception e) {
            System.err.print("\nAl convertir a DOB (" + o + "): " + e.toString());
            return 0;
        }
    }

    public static short StringToShort(String o) {
        try {
            if (o.length() == 0) {
                return 0;
            }
            return Short.parseShort(o);
        } catch (Exception e) {
            return 0;
        }
    }

    public static char StringToChar(String o) {
        try {
            if (o.length() == 0) {
                return '0';
            }
            return o.charAt(0);
        } catch (Exception e) {
            return 0;
        }
    }

    public static Float doubleToFloat(double o) {
        try {
            Float f = new Float(o);
            return f;
        } catch (Exception e) {
            return new Float(0);
        }
    }

    public static Date StringToDate(String o) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.parse(o);


        } catch (ParseException ex) {
            Logger.getLogger(Funcion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static Date StringToHora(String o) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            return sdf.parse(o);


        } catch (ParseException ex) {
            Logger.getLogger(Funcion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static String DateFormat(Date o) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.format(o);

        } catch (Exception e) {
            return null;
        }
    }

    public static String DateTimeFormatJS(Date o) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            return sdf.format(o);

        } catch (Exception e) {
            return null;
        }
    }

    public static String DateTimeFormatJS2(Date o) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(o);

        } catch (Exception e) {
            return null;
        }
    }
    
    public static String DateTimeToString(Date o) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            return sdf.format(o);

        } catch (Exception e) {
            return null;
        }
    }

    public static String DateTimeToString3(Date o) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            return sdf.format(o);

        } catch (Exception e) {
            return null;
        }
    }

    public static String DateTimeToString4(Date o) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(o);

        } catch (Exception e) {
            return null;
        }
    }
    
    public static String DateTimeToString4day(Date o) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd");
            return sdf.format(o);

        } catch (Exception e) {
            return null;
        }
    }
    
    public static String DateTimeToString4mount(Date o) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM");
            return sdf.format(o);

        } catch (Exception e) {
            return null;
        }
    }
    
    public static String DateTimeToString4dayofweek(Date o) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("EEEEEEEEE");
            return sdf.format(o);

        } catch (Exception e) {
            return null;
        }
    }
    
    public static String DateTimeToString4year(Date o) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            return sdf.format(o);

        } catch (Exception e) {
            return null;
        }
    }
    
    public static String DateTimeToString4Hour(Date o) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH");
            return sdf.format(o);

        } catch (Exception e) {
            return null;
        }
    }
    
    public static String DateTimeToString4minutes(Date o) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("mm");
            return sdf.format(o);

        } catch (Exception e) {
            return null;
        }
    }
    
    public static String DateTimeToString4seconds(Date o) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("ss");
            return sdf.format(o);

        } catch (Exception e) {
            return null;
        }
    }

    public static String DateFormatSql(Date o) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(o);

        } catch (Exception e) {
            return null;
        }
    }

    public static String completarConCeros(String num, int cant) {
        String numAumenta = num;
        if (num.length() < cant) {
            for (int i = 0; i < (cant - num.length()); i++) {
                numAumenta = "0" + numAumenta;
            }
        }
        return numAumenta;
    }

    public static int convertirFecha365() {
        Date fecha = new Date();
        String fechaStr = Funcion.DateFormat(fecha);
        Date fechaActual = Funcion.StringToDate(fechaStr);
        String anioActual = fechaStr.substring(6, 10);
        long time1 = fechaActual.getTime();
        long time2 = Funcion.StringToDate("01/01/" + anioActual).getTime();
        Long Dia;
        if (time1 == time2) {
            return 1;
        } else {
            Dia = (time1 - time2) / 86400000;
            return Dia.intValue() + 1;
        }
    }

    public static String convertirFechaFormatoBase(Date f) {
        String hora = f.toString().substring(11, 19);
        //String fecha = DateFormat.getDateInstance(DateFormat.MEDIUM).format(f);
        String fecha = DateFormatSql(f);
        return (fecha + " " + hora);
    }

    public static Date getDateByFechaHora(Date fecha, Date hora) {
        try {
            String o = DateFormat(fecha) + " " + TimeFormat(hora);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            return sdf.parse(o);


        } catch (ParseException ex) {
            Logger.getLogger(Funcion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static Date getDateByFechaHoraString(String fecha, String hora) {
        try {
            String o = fecha + " " + hora;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            return sdf.parse(o);


        } catch (ParseException ex) {
            Logger.getLogger(Funcion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static String getStringByFechaHora(Date fecha, Date hora) {
        String o = DateFormat(fecha) + " " + TimeFormat(hora);
        return o;
    }

    public static String TimeFormat(Date o) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            return sdf.format(o);

        } catch (Exception e) {
            return null;
        }
    }

    public static String TimeFormat2(Date o) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            return sdf.format(o);

        } catch (Exception e) {
            return null;
        }
    }

    public static String DecimalFormat(String o) {
        try {

            NumberFormat nf = NumberFormat.getInstance(Locale.US);
            DecimalFormat df = (DecimalFormat) nf;
            df.applyPattern("#,##0.00");

            return df.format(StringToDouble(o));

        } catch (Exception ex) {
            Logger.getLogger(Funcion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static String DecimalFormatByDouble(double o) {
        try {

            NumberFormat nf = NumberFormat.getInstance(Locale.US);
            DecimalFormat df = (DecimalFormat) nf;
            df.applyPattern("#,##0.00");

            return df.format(o);

        } catch (Exception ex) {
            Logger.getLogger(Funcion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static String DecimalFormat(double o) {
        try {
            DecimalFormat df = (new DecimalFormat("#0.00"));
            return df.format(o);

        } catch (Exception ex) {
            Logger.getLogger(Funcion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static String DateTimeToString2(Date o) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
            return sdf.format(o);

        } catch (Exception e) {
            return null;
        }
    }

    public static String toMD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }

   
}
