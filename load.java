import java.util.Scanner;

class load {
    int fno = 0;

    public static void main(String[] args) {
        load ld = new load();
        hashable h = new hashable();
        hash[] my_hash = new hash[100];
        for (int i = 0; i < my_hash.length; i++) {
            my_hash[i] = new hash();
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter url, directory and depth");
        String url = sc.next();
        check my_check = new check();
        doc my_doc = new doc();
        int url_flag = my_check.check_url(url);
        String dir = sc.next();
        int dir_flag = my_check.check_dir(dir);
        int depth = sc.nextInt();
        int depth_flag = my_check.check_depth(depth);
        System.out.println(url_flag + " " + dir_flag + " " + depth_flag);
        String html = new String();
        if (url_flag == 1 && dir_flag == 1 && depth_flag == 1) {
            html = my_doc.get_in_string(url);
        }
        // System.out.println(html);
        ld.fno = my_doc.write_to_file(html, dir, ld.fno);
        String arr[] = my_doc.get_in_array(html, url);
        my_hash = h.set(my_hash, arr, 1);
        for (int i = 0; i < my_hash.length; i++) {
            System.out.println(i);
            my_hash[i].print();
        }
        sc.close();
    }
}