class hash {
    class node {
        String url;
        int depth;
        int isvisited;

        node next;
    }

    node head, last;

    public hash() {
        head = null;
        last = null;
    }

    public void insert(String url, int d) {
        node n = new node();
        n.url = new String(url);
        n.next = null;
        n.depth = d;
        n.isvisited = 0;
        if (head == null) {
            head = n;
            end = n;
        } else {
            n.next = head;
            head = n;
        }
    }
}

class hashable {
    public hash[] set(hash[] arr, String[] list, int d) {
        for (int i = 0; i < list.length; i++) {
            int index = getkey(list[i]);
            if (arr[index].check(list[i]) == 0) {
                arr[index].insert(list[i], d);
            }
        }
        return arr;
    }
}