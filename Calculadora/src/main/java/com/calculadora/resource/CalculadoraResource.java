/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.calculadora.resource;

import com.calculadora.Dtos.DetalleCotizacionDto;
import com.calculadora.Dtos.TotalDosi;
import com.calculadora.entityManager.EMF;
import com.calculadora.filtroDTO.FiltroDTO;
import com.calculadora.manager.CalculadoraManager;
import com.calculadora.persitence.Cliente;
import com.calculadora.persitence.Color;
import com.calculadora.persitence.DetalleCotizacion;
import com.calculadora.persitence.FacturaCotizar;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.persistence.EntityManager;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import static org.apache.poi.hssf.usermodel.HeaderFooter.date;

/**
 * REST Web Service
 *
 * @author Yeisson alvarez
 */
@Path("Calculadora")
public class CalculadoraResource {

    EntityManager em = EMF.createEntityManager();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CalculadoraResource
     */
    public CalculadoraResource() {
    }

    @GET
    @Path("ConsultaClientes")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Cliente> consultarClientes() {
        CalculadoraManager manager = new CalculadoraManager();
        List<Cliente> user = manager.consultarClientes(em);
        return user;
    }

    @GET
    @Path("consultarColores")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Color> consultarColores() {
        CalculadoraManager manager = new CalculadoraManager();
        List<Color> user = manager.consultarColores(em);
        return user;
    }
    @POST
    @Path("registrarCliente")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Integer registrarCliente(Cliente cliente)throws 
            Exception{
        CalculadoraManager manager = new CalculadoraManager();
        Integer user = manager.registrarCliente(cliente,em);
        return user;
    }

    @POST
    @Path("registrarFacturaCotizar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Integer registrarFacturaCotizar(FacturaCotizar facturaCotizar)throws 
            Exception{
        CalculadoraManager manager = new CalculadoraManager();
        Integer user = manager.registrarFacturaCotizar(facturaCotizar,em);
        return user;
    }
    
    @POST
    @Path("registrarDetalle")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Boolean registrarDetalle(List<DetalleCotizacion> detalleCotizacion)throws 
            Exception{
        CalculadoraManager manager = new CalculadoraManager();
        Boolean user = manager.registrarDetalle(detalleCotizacion,em);
        return user;
    }
    
    @POST
    @Path("consulatarCliente")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Cliente consulatarCliente(Cliente cliente)throws 
            Exception{
        CalculadoraManager manager = new CalculadoraManager();
        Cliente user = manager.consulatarCliente(cliente,em);
        return user;
    }
    @GET
    @Path("consultarColoresDesmol")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Color> consultarColoresDesmol() {
        CalculadoraManager manager = new CalculadoraManager();
        List<Color> user = manager.consultarColoresDesmol(em);
        return user;
    }

    @GET
    @Path("ochentaColores")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Color> ochentaColores()
            throws Exception {
        List<Color> color = new ArrayList<>();
        CalculadoraManager manager = new CalculadoraManager();
        color = manager.ochentaColores(em);

        return color;
    }
    @GET
    @Path("ochoUltimos")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Color> ochoUltimos()
            throws Exception {
        List<Color> color = new ArrayList<>();
        CalculadoraManager manager = new CalculadoraManager();
        color = manager.ochoUltimos(em);

        return color;
    }

    @POST
    @Path("calcularInsumo")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public TotalDosi calcularInsumo(FiltroDTO filtro)
            throws Exception {
        TotalDosi totaldosi = new TotalDosi();
        Double total;
        Integer totalRetornar = 0;
        String valor;

        total = filtro.getFiltroSeis() * filtro.getCantidad() / 25;
        String[] arr = String.valueOf(total).split("\\.");
        int[] intArr = new int[2];
        intArr[0] = Integer.parseInt(arr[0]); // 1
        String[] arr1 = String.valueOf(arr[1]).split("");
        if (arr1[0].equals("0")) {
            intArr[1] = 1;
        } else {
            intArr[1] = Integer.parseInt(arr[1]); // 9
        }
        valor = "" + intArr[1];
        String[] array;
        array = valor.split("");
        Integer comparar = Integer.parseInt(array[0]);
        if (comparar >= 5) {
            totalRetornar = intArr[0] + 1;
            String fin = "" + totalRetornar;
            totaldosi.setTotal(fin);
        } else {
            totaldosi.setTotal("" + intArr[0]);
        }

        return totaldosi;
    }

    @POST
    @Path("enviarCorreo")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Boolean enviarCorreo(FiltroDTO filtro)
            throws Exception {
            Cliente clientereturn = new Cliente();
            try {
            String filename = "home/diseno/Cotizacion.xls";
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("FirstSheet");
            Date date = Calendar.getInstance().getTime();

        // Display a date in day, month, year format
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String today = formatter.format(date);
            //Consultar factura 
            CalculadoraManager manager = new CalculadoraManager();
            FacturaCotizar factura = new FacturaCotizar();
            Cliente cliente = new Cliente();
            cliente.setIdcliente(filtro.getFiltroId());
            clientereturn = manager.consulatarCliente(cliente, em);
            factura = manager.calcularFacturaCoti(filtro, em);
           
            HSSFRow fecha = sheet.createRow((short) 0);
            fecha.createCell(0).setCellValue("Fecha: " + today);
            
            HSSFRow rowhead = sheet.createRow((short) 1);

            HSSFRow rowhead2 = sheet.createRow((short) 2);
            rowhead2.createCell(0).setCellValue("Nombre");
            rowhead2.createCell(1).setCellValue("Correo");
            rowhead2.createCell(2).setCellValue("Dirección Domicilio");
            rowhead2.createCell(3).setCellValue("Teléfono");
            HSSFRow rowhead23 = sheet.createRow((short) 3);
            rowhead23.createCell(0).setCellValue(clientereturn.getNombre()+" "+clientereturn.getApellido());
            rowhead23.createCell(1).setCellValue(clientereturn.getCorreo());
            rowhead23.createCell(2).setCellValue(clientereturn.getDireccion());
            rowhead23.createCell(3).setCellValue(clientereturn.getTelefono());
            
            HSSFRow row = sheet.createRow((short) 4);
            row.createCell(0).setCellValue("Especificación");
            row.createCell(1).setCellValue("Cantidad");
            row.createCell(2).setCellValue("Valor");
            int contador = 5;
            if(factura.getIdfacturaCotizar() != null && !factura.getDetalleCotizacionList().isEmpty()){
                for (int i = 0; i < factura.getDetalleCotizacionList().size(); i++) {
                    HSSFRow campos = sheet.createRow((short) contador);
                    if (factura.getDetalleCotizacionList().get(i).getConcepto()!= null) {
                            campos.createCell(0).setCellValue(factura.getDetalleCotizacionList().get(i).getConcepto());
                            if(factura.getDetalleCotizacionList().get(i).getValorkilos() != null){
                              campos.createCell(1).setCellValue(factura.getDetalleCotizacionList().get(i).getValorkilos());
                            }
                            if(factura.getDetalleCotizacionList().get(i).getValorlitro() != null){
                              campos.createCell(1).setCellValue(factura.getDetalleCotizacionList().get(i).getValorlitro());
                            }
                            if(factura.getDetalleCotizacionList().get(i) != null){
                              campos.createCell(1).setCellValue(factura.getDetalleCotizacionList().get(i).getValorunidad());
                            }
                            campos.createCell(2).setCellValue("");

                    }
                  contador++;      
            }
            }
            try (FileOutputStream fileOut = new FileOutputStream(filename)) {
                workbook.write(fileOut);
            }
            System.out.println("Your excel file has been generated!");

        } catch (IOException ex) {
            System.out.println(ex);
        }

        // Envio correo elctronico
        final String username = "yeison6340@gmail.com";
        final String password = "03216549877894561230";

        Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "25");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(clientereturn.getCorreo()));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(clientereturn.getCorreo()));
            message.setSubject("Cotización factura");

            MimeBodyPart messageBodyPart = new MimeBodyPart();

            Multipart multipart = new MimeMultipart();

            messageBodyPart = new MimeBodyPart();
            String file = "home/diseno/Cotizacion.xls";
            String fileName = "Cotizacion.xls";
            DataSource source = new FileDataSource(file);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(fileName);
            messageBodyPart.setText("hola");
            multipart.addBodyPart(messageBodyPart);

            message.setText("Esta es una prueba para enviar un archivo");
            message.setContent(multipart);

            System.out.println("Sending");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return true;
    }
}
