package Game.utils;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utils {

    public static String loadFileAsString(String path){
        StringBuilder builder =new StringBuilder();

        try {
            BufferedReader br= new BufferedReader(new FileReader(path));
            String line;
            while((line=br.readLine())!=null)
                builder.append(line+"\n");

            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static int parseInt(String number){
        try {
            return Integer.parseInt(number);
        }catch (NumberFormatException e){
            // Eroare in cazul in care in fisierul de unde se va citi harta, exista litere
            // Fisierul va contine doar indecsii pentru diferite tile-uri
            e.printStackTrace();
            return 0;// Pentru a nu evita oprirea programului
        }
    }
}
