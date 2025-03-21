package factura;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.UnitValue;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import vista.*;

public class FacturaPDF {
    public static void main(String[] args) {

    

        viewInvoice vista1= new viewInvoice();
        vista1.setVisible(true);

        viewOwnerHome vistaDueñosPrincipal = new viewOwnerHome();
        vistaDueñosPrincipal.setVisible(true);  

        String destino = "./factura.pdf";  // Nombre del archivo
        try {
            // Crear un documento PDF
            PdfWriter writer = new PdfWriter(destino);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Agregar título
            document.add(new Paragraph("Factura Electrónica")
                    .setBold()
                    .setFontSize(18));

            // Agregar información de la empresa
            document.add(new Paragraph("Empresa: Pizzería Pizza Fiesta\nDirección: Calle 123, Tibú, Norte de Santander\nTeléfono: 3001234567\n"));

            // Agregar datos del cliente
            document.add(new Paragraph("Cliente: Luis Orlando Henao Bermon\nDocumento: 123456789\n"));

            // Agregar detalles de la factura
            Table table = new Table(4);
            table.addCell("Producto");
            table.addCell("Cantidad");
            table.addCell("Precio Unitario");
            table.addCell("Total");

            // Agregar productos a la tabla
            table.addCell("Pizza Hawaiana");
            table.addCell("2");
            table.addCell("$10.000");
            table.addCell("$20.000");

            table.addCell("Gaseosa 1.5L");
            table.addCell("1");
            table.addCell("$5.000");
            table.addCell("$5.000");

            // Agregar tabla al documento
            document.add(table);

            // Agregar total
            document.add(new Paragraph("\nTotal a pagar: $45.000").setBold());

            // Cerrar documento
            document.close();
            System.out.println("Factura generada correctamente: " + destino);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
