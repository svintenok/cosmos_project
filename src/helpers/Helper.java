package helpers;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import singletons.ConfigSingleton;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

/**
 * Author: Svintenok Kate
 * Date: 30.10.2016
 * Group: 11-501
 * Task: semester project
 */
public class Helper {
    public static void render(HttpServletResponse response,
                              HttpServletRequest request,
                              String template,
                              HashMap<String, Object> root) throws IOException {

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; Charset=utf-8");

        Template tmpl = ConfigSingleton.getConfig(
                request.getServletContext()
        ).getTemplate(template);

        try {
            tmpl.process(root, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    public static String getHash(String password){
        String passwordHash = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            passwordHash = sb.toString();
            return passwordHash;
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return passwordHash;
    }

    public static void downloadPhoto(Part filePart, String fileName) throws IOException {
        File file = new File("D:/repositories/cosmos_project_files/" + fileName + ".jpg");
        file.createNewFile();
        FileOutputStream out = new FileOutputStream(file);
        InputStream filecontent = filePart.getInputStream();

        int read = 0;
        final byte[] bytes = new byte[1024];

        while ((read = filecontent.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }

        out.close();
        filecontent.close();
    }

}
