class node {
    String url;
    int depth;
    int isvisited;

    node next;
}

class hash {

    node head, end;

    public hash() {
        head = null;
        end = null;
    }

    public void insert(String url, int d, int v) {
        node n = new node();
        n.url = new String(url);
        n.next = null;
        n.depth = d;
        n.isvisited = v;
        if (head == null) {
            head = n;
            end = n;
        } else {
            n.next = head;
            head = n;
        }
    }

    public void print() {
        node ptr = head;
        int i = 0;
        while (ptr != null) {
            System.out.println(i + " d=" + ptr.depth + " v=" + ptr.isvisited + " " + ptr.url);
            ptr = ptr.next;
            i++;
        }
        System.out.println("\n");
    }

    public int check(String str) {
        if (head == null)
            return 0;
        node ptr = head;
        while (ptr != end) {
            if (ptr.url.equals(str)) {
                return 1;
            }
            ptr = ptr.next;
        }
        if (end.url.equals(str))
            return 1;
        return 0;
    }
}

class hashable {
    int d = 0;

    hash[] link(hash[] arr) {
        int i, j;
        for (i = 0; i < arr.length - 1; i++) {
            if (arr[i].end != null) {
                for (j = i + 1; j < arr.length; j++) {
                    if (arr[j].head != null) {
                        break;
                    }
                }
                arr[i].end.next = arr[j].head;
            }
        }
        return arr;
    }

    public String get_next_url(hash[] arr, int dp) {
        node ptr = arr[0].head;
        while (ptr != null) {
            if (ptr.isvisited == 0 && ptr.depth <= dp) {
                ptr.isvisited = 1;
                return ptr.url;
            }
            ptr = ptr.next;
        }
        return "-1";
    }

    public hash[] set(hash[] arr, String[] list) {
        int index = list[0].length() % 100;
        if (arr[index].check(list[0]) == 0) {
            arr[index].insert(list[0], d, 1);
        }
        for (int i = 1; i < list.length; i++) {
            index = list[i].length() % 100;
            // System.out.println(list[i] + " " + arr[index].check(list[i]));
            if (arr[index].check(list[i]) == 0) {
                arr[index].insert(list[i], d + 1, 0);
            }
        }
        arr = link(arr);
        return arr;
    }
}