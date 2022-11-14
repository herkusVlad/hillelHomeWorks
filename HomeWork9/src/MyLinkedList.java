public class MyLinkedList implements CustomCollection {
    private LinkItem firstLink;
    private LinkItem lastLink;

    @Override
    public boolean add(String str) {
        try {
            LinkItem linkItem;
            if (firstLink == null) {
                linkItem = new LinkItem(str);
                firstLink = linkItem;
                lastLink = firstLink;
                return true;
            }
            LinkItem newLink = new LinkItem(str);
            lastLink.link = newLink;
            lastLink = newLink;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean addAll(CustomCollection strColl) {
        try {
            for (int i = 0; i < strColl.size(); i++) {
                add(strColl.get(i));
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int index) {
        LinkItem item = firstLink;
        LinkItem prev = firstLink;
        LinkItem delItem = firstLink;
        int counter = 0;
        while (!item.first.isEmpty()) {
            if (counter++ == index) {
                if (index == 0) {
                    firstLink = firstLink.link;
                } else {
                    prev.link = delItem.link;
                }
                return true;
            }
            if (item.link != null) {
                prev = item;
                delItem = item.link;
                item = item.link;
            } else {
                break;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String res = "";
        LinkItem item = firstLink;
        while (firstLink!=null && !item.first.isEmpty()) {
            res += item.first +" ";
            if (item.link != null) {
                item = item.link;
            } else {
                break;
            }
        }
        return res;
    }

    @Override
    public boolean delete(String string) {
        LinkItem item = firstLink;
        LinkItem prev = firstLink;
        LinkItem delItem = firstLink;

        while (!item.first.isEmpty()) {
            if (item.first.equals(string)) {
                if (firstLink.first.equals(string)) {
                    firstLink = firstLink.link;
                } else {
                    prev.link = delItem.link;
                }
                return true;
            }
            if (item.link != null) {
                prev = item;
                delItem = item.link;
                item = item.link;
            } else {
                break;
            }
        }
        return false;
    }

    @Override
    public String get(int index) {
        LinkItem item = firstLink;
        int counter = 0;
        while (!item.first.isEmpty()) {
            if (counter++ == index) {
                return item.first;
            }
            if (item.link != null) {
                item = item.link;
            } else {
                break;
            }
        }
        return null;
    }

    @Override
    public boolean contains(String string) {
        LinkItem item = firstLink;
        while (!item.first.isEmpty()) {
            if (string.equals(item.first)) {
                return true;
            }
            if (item.link != null) {
                item = item.link;
            } else {
                break;
            }
        }
        return false;
    }

    @Override
    public boolean clear() {
        try {
            firstLink = null;
            lastLink = null;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public int size() {
        int counter = 0;
        LinkItem item = firstLink;
        while (!item.first.isEmpty()) {
            counter++;
            if (item.link != null) {
                item = item.link;
            } else {
                break;
            }
        }
        return counter;
    }

    @Override
    public boolean trim() {
        return true;
    }

    private static class LinkItem {
        public String first;
        public LinkItem link;

        public LinkItem(String first) {
            this.first = first;
        }

        @Override
        public String toString() {
            return first + " ";
        }
    }
}
