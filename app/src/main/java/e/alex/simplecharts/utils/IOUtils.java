package e.alex.simplecharts.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IOUtils {

    public static String readJsonFromFile(String filePath)
    {
        StringBuilder sb = new StringBuilder();

        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static String convert(InputStream inputStream, Charset charset) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, charset))) {
            return br.lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            return null;
        }
    }

    public static void writeToFile(Bitmap bitmap, Context context){
        String filename = "ScreenShot.PNG";
        Log.i("PATH", "" + context.getFilesDir().toString());

        File root = android.os.Environment.getExternalStorageDirectory();
        File dir = new File (root.getAbsolutePath() + "/Pictures");


        try (FileOutputStream out = new FileOutputStream(dir.toString() + "/" + filename)) {//getFilesDir().toString() + "/" + filename
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out); // bmp is your Bitmap instance
            // PNG is a lossless format, the compression factor (100) is ignored
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
