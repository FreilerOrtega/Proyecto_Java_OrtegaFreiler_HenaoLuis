package Modelo;


import Controlador.crtllogin;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

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

            // Agregar título
            document.add(new Paragraph("Factura Electrónica")
                    .setBold()
                    .setFontSize(18));

            // Agregar información de la empresa
            document.add(new Paragraph("Empresa: Veterinaria Happy Feets\nDirección: Calle 123, Tibú, Norte de Santander\nTeléfono: 3001234567\n"));

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
            e.printStackTrace();
        }
    }
}
