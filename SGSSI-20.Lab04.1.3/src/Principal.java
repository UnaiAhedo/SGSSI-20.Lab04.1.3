import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;

public class Principal {

    private static String pathArchivoAComparar = "Prueba.txt"; // El archivo a comparar con el siguiente
    private static String pathEntrada2 = "SGSSI-20.CB.04.txt"; // El archivo al que se le va a añadir el numero en hexadecimal
                                                               // y del que se va a generar el digest
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException{
        boolean res = compararArchivos(pathArchivoAComparar, pathEntrada2);
        System.out.println(res);
    }

    private static boolean compararArchivos(String path1, String path2) throws NoSuchAlgorithmException, IOException{
        MessageDigest md5Digest = MessageDigest.getInstance("MD5");
        String hx = "\n" + hexadecimalAleatorio(8); // El valor hexadecimal a modificar si se quiere hacer "valor + Gxxxx"

        boolean empieza0 = false;

        byte[] fa1 = Files.readAllBytes(Paths.get(path1));
        byte[] fa2 = Files.readAllBytes(Paths.get(path2));
        boolean iguales = Arrays.equals(fa1, fa2);

        if(iguales){
            try {
                Files.write(Paths.get(path2), hx.getBytes(), StandardOpenOption.APPEND);
            }catch (IOException e) {
            }
            File file2 = new File(path2);

            String digest = crearDiget(md5Digest, file2);
            if(digest.charAt(0) == '0'){
                empieza0 = true;
            }
        }
        return iguales & empieza0;
    }

    private static String hexadecimalAleatorio(int pNnumchars){
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while(sb.length() < pNnumchars){
            sb.append(Integer.toHexString(r.nextInt()));
        }
        return sb.toString().substring(0, pNnumchars);
    }

    private static String crearDiget(MessageDigest digest, File file) throws IOException{
        FileInputStream fis = new FileInputStream(file);
        byte[] byteArray = new byte[1024];
        int bytesCount = 0;
        while ((bytesCount = fis.read(byteArray)) != -1) {
            digest.update(byteArray, 0, bytesCount);
        };
        fis.close();
        byte[] bytes = digest.digest();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++)
        {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}
