package Modelo;


import Controlador.crtllogin;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.List;

import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.layout.properties.VerticalAlignment;
import vista.*;

import javax.swing.*;

public class FacturaPDF {
    public static void GenerateFacture(int idPeople, List<Object[]> medicineListInvoice, int idFacture) throws SQLException {


        JFileChooser chooser = new JFileChooser(); // se crea el gestor de arhivos

        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);// se hace que solo seleccione carpetas y no archivos

        int resultado = chooser.showOpenDialog(null);//muestra como tal el gestor de archivos y guarda en caso de que se seleccione algo

        String destinoPrev = "";
        if (resultado == JFileChooser.APPROVE_OPTION) {//verifica en caso de que el usuario haya seleccionado algo
            // Obtener la carpeta seleccionada
            File carpetaSeleccionada = chooser.getSelectedFile(); //obtiene la ruta del directorio seleccionado

            destinoPrev=carpetaSeleccionada.getAbsolutePath(); //se obtiene la ruta absoluta en forfato string
        }

        Persona owner=PersonaDAO.SearchPeopleById(idPeople);
        int total=0;
        String destino = destinoPrev+ "./factura"+idFacture+".pdf";  // ruta de donde quire que se guarde y le pone el nombre del archivo
        try {
            // Crear un documento PDF
            PdfWriter writer = new PdfWriter(destino);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            //Se crea el título
            Paragraph fact=new Paragraph("Factura Electrónica")
                    .setBold()
                    .setFontSize(18);


            //Se crea la imagen de la espresa
            ImageData imageData= ImageDataFactory.create("src/main/resources/IMG/happy_feet.png");
            Image img=new Image(imageData);
            //se le da medidas a la imagen
            img.setWidth(70);
            img.setHeight(70);

            // Se crea la tabla para poder poner el titulo y la imagen al lado
            Table tableHead=new Table(2);
            //Se le da una medida de 100% para que ocupe todo el pdf
            tableHead.setWidth(UnitValue.createPercentValue(100));
            //se quitan bordes a la celda y se centra verticalmente el texto
            tableHead.addCell(new Cell().add(fact)
                    .setBorder(null)
                    .setVerticalAlignment(VerticalAlignment.MIDDLE));

            tableHead.addCell(new Cell().add(img).setBorder(null));


            //se añade la tabla con el titulo y la imagen
            document.add(tableHead);

            //Se iserta un separador de secciones
            document.add(new Paragraph("--------------------------------------------------"));

            // Agregar información de la empresa
            document.add(new Paragraph("Empresa: Veterinaria Happy Feets\nDirección: Calle 123, Tibú, Norte de Santander\nTeléfono: 3001234567\n"));

            //agregar numero de fatura
            document.add(new Paragraph("Numero de factura: "+idFacture));

            //Se iserta un separador de secciones
            document.add(new Paragraph("--------------------------------------------------"));

            // Agregar datos del cliente
            document.add(new Paragraph("Cliente: "+owner.getAllName()+"\nDocumento: "+owner.getId_number()+"\nDireccion: "+owner.getAddress()));

            // Agregar detalles de la factura
            Table table = new Table(4);
            table.addCell("Medicamento");
            table.addCell("Cantidad");
            table.addCell("Precio");
            table.addCell("Total");
            for (Object[] o:medicineListInvoice){
                table.addCell(o[1]+"");
                table.addCell(o[2]+"");
                table.addCell(o[3]+"");
                table.addCell(o[4]+"");
                total+=(int)o[4];
            }

            // Agregar tabla al documento
            document.add(table);

            // Agregar total
            document.add(new Paragraph("\nTotal a pagar: "+total).setBold());

            // Cerrar documento
            document.close();
            System.out.println("Factura generada correctamente: " + destino);
        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

    }
}
