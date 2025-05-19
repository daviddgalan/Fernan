package FuncionesDeCorreo;

import Inversión.Inversion;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Properties;

public class FuncionesDeCorreo implements Serializable {

    private static String correoRemitente = "andrevelezg42@gmail.com";
    private static String correoDestinatario;
    private static String codigoDeCorreo;
    private static String asuntoCorreo = "codigo de verificacion" ;

    public FuncionesDeCorreo() {

    }
    public FuncionesDeCorreo(String correoDestinatario) {
        FuncionesDeCorreo.correoDestinatario = correoDestinatario;
        codigoDeCorreo = String.valueOf((int)(Math.random()*9000)+1000);
        asuntoCorreo = "Codigo de verificacion";
        enviarConGMail(correoDestinatario,asuntoCorreo,codigoDeCorreo);
    }
    public static void enviarConGMailArchivo(String correoDestinatario) {
        String remitente = correoRemitente;
        String clave = "wkii txds uoza kdkq";  // Contraseña de aplicación de Gmail
        String mensaje = "Archivo Adjunto";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Este Authenticator es necesario para pasar correctamente el remitente y la clave
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remitente, clave);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remitente));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correoDestinatario));
            message.setSubject(mensaje);

            BodyPart texto = new MimeBodyPart();
            texto.setText(mensaje);

            MimeBodyPart adjunto = new MimeBodyPart();
            adjunto.attachFile(new File("RegistrosDeApp/usuarios.csv"));

            Multipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            multiParte.addBodyPart(adjunto);

            message.setContent(multiParte);

            // Enviar mensaje (no hace falta usar connect/manual transport)
            Transport.send(message);

            System.out.println("Correo enviado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void enviarConGMail(String correoDestinatario, String asuntoCorreo, String codigoDeCorreo) {
        String remitente = correoRemitente;
        String clave = "wkii txds uoza kdkq";
        // Propiedades de la conexión que se va a establecer con el servidor de correo SMTP
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com"); // Servidor SMTP de Google
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", clave);
        props.put("mail.smtp.auth", "true"); // Usar autenticación mediante usuario y clave
        props.put("mail.smtp.starttls.enable", "true"); // Conectar de manera segura
        props.put("mail.smtp.port", "587"); // Puerto SMTP seguro de Google
        // Se obtiene la sesión en el servidor de correo
        Session session = Session.getDefaultInstance(props);
        try {
            // Creación del mensaje a enviar
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remitente));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(correoDestinatario));
            message.setSubject(asuntoCorreo);
            //message.setText(cuerpo); // Para enviar texto plano
            message.setContent(codigoDeCorreo, "text/html; charset=utf-8"); // Para enviar html
            // Definición de los parámetros del protocolo de transporte
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (Exception me) {
            me.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String destinatario = correoDestinatario; // Destinatario del mensaje
        String asunto = asuntoCorreo;
        String cuerpo = String.valueOf(codigoDeCorreo);
        enviarConGMail(destinatario, asunto, cuerpo);
    }
    public void exportarInversionesExcel(ArrayList<Inversion> inversiones, String nombreInversor){
        try (FileWriter file = new FileWriter("RegistrosDeApp/usuarios.csv")) {

            file.write("Proyecto,Cantidad Invertida,Cantidad Necesaria, Nombre Inversor\n");
            //pensar si hacer que ponga el nombreInversor y que el admin lo reciba completo

            for (Inversion i : inversiones) {
                if (nombreInversor.equalsIgnoreCase(i.getInversor().getNombre())) {
                    file.write(i.getProyecto1().getNombre() + "," + i.getCantidadInvertida() + "," + i.getProyecto1().getCantidadNecesaria() + "," + i.getInversor().getNombre() + "\n");
                }
            }
            file.close();
            enviarConGMailArchivo("davidgalan001@gmail.com");
            System.out.println("CSV generado con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getCodigoDeCorreo() {
        return codigoDeCorreo;
    }
}




