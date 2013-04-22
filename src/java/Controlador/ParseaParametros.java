/* HOLA */
/*
 * To change this template, choose Tools | Templates
 * and open the templato in the editor.
 */

package Controlador;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author juanjo
 */
public class ParseaParametros {
    public static final int MAXIMO_TAMANO_IMAGEN = 20971520;
    public static HashMap<String,String> parsea(HttpServletRequest request, ServletContext servletContext){
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        HashMap<String,String> mapaParametros = new HashMap<String, String>();
        if(isMultipart){
            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
            int sizeThreshold = 0;
            FileItemFactory factory = new DiskFileItemFactory(sizeThreshold, repository);
            ServletFileUpload upload = new ServletFileUpload(factory);
            try{
                List<FileItem> items = upload.parseRequest(request);
                Iterator<FileItem> iter = items.iterator();
            
                while(iter.hasNext()){
                    FileItem item = iter.next();
                    if(item.isFormField()){
                        mapaParametros.put(item.getFieldName(), item.getString());
                    }else{
                        String contentType = item.getContentType();
                        long sizeInBytes = item.getSize();
                        if(validContentType(contentType) && sizeInBytes <= MAXIMO_TAMANO_IMAGEN){
                            String path = servletContext.getRealPath("ImagenServidor");
                            String fileName = String.valueOf(new Date().getTime());
                            fileName += getExtension(item.getName());
                            
                            File uploadedFile = new File(path,fileName);
                            item.write(uploadedFile);
                            mapaParametros.put(item.getFieldName(),fileName);
                        }else{
                            mapaParametros.put(item.getFieldName(), "");
                        }
                    } 
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
        return mapaParametros;
    }
    
    public static boolean validContentType(String contentType){
        String acceptedTypes[] = {"image/jpeg", "image/gif", "image/png"};
        boolean valid = false;
        for(int i=0; i<acceptedTypes.length;i++){
            if (acceptedTypes[i].equalsIgnoreCase(contentType)){
                return true;
            }
        }
        return valid;
    }
    
    public static String getExtension(String fileName){
        int dotIndex = fileName.lastIndexOf(".");
        if(dotIndex==-1){
            return "";
        }else{
            return fileName.substring(dotIndex);
        }
    }
}
