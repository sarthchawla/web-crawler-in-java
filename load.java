import java.util.Scanner;

class load {
    int fno = 0;
    check my_check;
    doc my_doc;
    hashable h;
    hash[] my_hash;

    load() {
        my_check = new check();
        my_doc = new doc();
        h = new hashable();
        my_hash = new hash[100];
        for (int i = 0; i < my_hash.length; i++) {
            my_hash[i] = new hash();
        }
    }

    void work(String url, String dir, int depth) {
        int flag = 0;
        flag += my_check.check_url(url);
        flag += my_check.check_dir(dir);
        flag += my_check.check_depth(depth);
        if (flag == 3) {
            do {
                String html = new String();
                html = my_doc.get_in_string(url);
                // System.out.println(html);
                fno = my_doc.write_to_file(html, dir, fno);
                my_hash = h.set(my_hash, my_doc.get_in_array(html, url));
                my_hash[0].print();
                while (flag != 1) {
                    url = new String(h.get_next_url(my_hash, depth));
                    System.out.println(url);
                    if (url.equals("-1"))
                        return;
                    flag = my_check.check_url(url);
                }
                flag = 0;
            } while (fno < 1000);
        }

    }

    public static void main(String[] args) {
        load ld = new load();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter url, directory and depth");
        // String url = sc.next();
        // String dir = sc.next();
        // int depth = sc.nextInt();

        ld.work("https://www.chitkara.edu.in/", "/home/sarthak/out", 2);
        sc.close();
    }
}