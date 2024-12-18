package chapter02.item09;

import java.io.*;

public class TryWithResourceExample {
     static String firstLineOfFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

      static void copy(String src, String dst) throws IOException {
       try (InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dst)) {
           byte[] buf = new byte[1024];
           int n;
           while ((n = in.read(buf)) >= 0)
               out.write(buf, 0, n);
       }
    }
}
