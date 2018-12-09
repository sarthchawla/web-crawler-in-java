import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class doc {
    String get_in_string(String url) {
        String str = new String();
        try {
            Document d = Jsoup.connect(url).get();
            str = d.html();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return str;
    }

    int write_to_file(String str, String dir, int fno) {
        try {
            FileWriter fw = new FileWriter(dir + "/" + fno + ".txt");
            fw.write(str);
            fw.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return fno + 1;
    }

    String[] get_in_array(String str, String b_url) {
        ArrayList<String> br = new ArrayList<>();
        check c = new check();
        int i;
        Document doc = Jsoup.parse(str);
        Elements links = doc.select("a[href]");
        for (Element link : links) {
            String url = new String(link.attr("abs:href"));
            if (url.length() > 1 && url.contains(b_url) && !br.contains(url)) {
                br.add(url);
            }
        }
        return br.toArray(new String[0]);
    }
}