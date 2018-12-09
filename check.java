
import java.net.*;
import java.io.*;

class check {
    int check_depth(int d) {
        if (d >= 0)
            return 1;
        return 0;
    }

    int check_dir(String dir) {
        File f = new File(dir);
        if (f.exists() && f.canRead() && f.canWrite() && f.canExecute())
            return 1;
        return 0;
    }

    int check_url(String url) {
        try {
            URL url1 = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            String url_type = new String(conn.getContentType());
            String[] url_content = url_type.split("\\s");
            System.out.println(url_content[0]);
            if (url_content[0].contains("text/html")) {
                return 1;
            }
        } catch (MalformedURLException e) {
            System.out.println(e.toString());
        } catch (ProtocolException e) {
            System.out.println(e.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return 0;
    }
}