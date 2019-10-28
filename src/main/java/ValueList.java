import com.google.common.collect.Lists;

import java.util.List;

public class ValueList {

    private final List<Long> list;

    public ValueList() {
        this.list = Lists.newLinkedList();
    }

    public void add(long n) {
        this.list.add(n);
    }

    public List<Long> getList() {
        return list;
    }
}