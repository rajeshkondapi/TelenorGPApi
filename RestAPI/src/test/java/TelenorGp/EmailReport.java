package TelenorGp;





import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.xhtmlrenderer.pdf.ITextRenderer;

import com.itextpdf.text.DocumentException;
import com.relevantcodes.extentreports.ExtentReports;
import com.sun.mail.smtp.SMTPTransport;





public class EmailReport extends DbConn {
	
    private static final String SMTP_SERVER = "203.199.178.220";
    private static final String USERNAME = "alerts";
    private static final String PASSWORD = "alert@123";

    private static final String EMAIL_FROM = "alerts@imimobile.com";
    private static final String EMAIL_TO = "rajesh.k@imimobile.com,srikanth.borugulla@imimobile.com";
    private static final String EMAIL_TO_CC = "";

    private static final String EMAIL_SUBJECT = "Ooredoo Mynmar Test Report";
    private static final String EMAIL_TEXT = "FYI.. Please find report";
    
    
    public static String generatePDF(String inputHtmlPath, String outputPdfPath) throws IOException, DocumentException
    {
        try {
            String url = new File(inputHtmlPath).toURI().toURL().toString();
            System.out.println("URL: " + url);

            OutputStream out = new FileOutputStream(outputPdfPath);

            //Flying Saucer part
            ITextRenderer renderer = new ITextRenderer();

            renderer.setDocument(url);
            renderer.layout();
            try {
				renderer.createPDF(out);
			} catch (com.lowagie.text.DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            out.close();
        } catch ( IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return outputPdfPath;
    }
    
    
    
    
    
    public static void emailgen(String extentdate) throws MessagingException, DocumentException, Exception {
    	Properties prop = System.getProperties();
        prop.put("smtp-mail.outlook.com", SMTP_SERVER); //optional, defined in SMTPTransport
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.port", "25"); // default port 25

        Session session = Session.getInstance(prop, null);
        
        BodyPart messageBodyPart = new MimeBodyPart();
        
        Multipart multipart = new MimeMultipart();
        
        MimeMessage msg = new MimeMessage(session);
        
        messageBodyPart = new MimeBodyPart();
    	//extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/"+now+".html", true);
    	
        String htlmename=extentdate;
       // String htlmename  = System.getProperty("user.dir") +"\\test-output\\20200117104122.html";
       // String outputFile = "C:\\Users\\rajesh.k\\Downloads\\Selenium\\Selenium\\RestAPI\\test-output\\TestPdf.pdf";
       //String filename= generatePDF(htlmename,outputFile);
        DataSource source = new FileDataSource(htlmename);
        
       messageBodyPart.setDataHandler(new DataHandler(source));
        
        messageBodyPart.setFileName(htlmename);
        
        multipart.addBodyPart(messageBodyPart);

        try {
		
			// from
            msg.setFrom(new InternetAddress(EMAIL_FROM));

			// to 
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(EMAIL_TO, false));

			// cc
            msg.setRecipients(Message.RecipientType.CC,
                    InternetAddress.parse(EMAIL_TO_CC, false));

			// subject
            msg.setSubject(EMAIL_SUBJECT);
			
			// content 
            msg.setText(EMAIL_TEXT);
			
            msg.setSentDate(new Date());

			// Get SMTPTransport
           SMTPTransport t = (SMTPTransport) session.getTransport("smtp");
			
			// connect
            t.connect(SMTP_SERVER, USERNAME, PASSWORD);
            
            // attach
            msg.setContent(multipart);
			
			// send
            t.sendMessage(msg, msg.getAllRecipients());
            
           
System.out.println("response"+t.getLastServerResponse());

           

            t.close();
            

        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }
    
}