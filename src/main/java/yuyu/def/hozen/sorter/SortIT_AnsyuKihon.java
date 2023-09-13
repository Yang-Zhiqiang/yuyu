package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.meta.QIT_AnsyuKihon;
import yuyu.def.hozen.comparator.OrderIT_AnsyuKihon;

public class SortIT_AnsyuKihon {

    public List<IT_AnsyuKihon> OrderIT_AnsyuKihonByPkAsc(List<IT_AnsyuKihon> pEntity) {
        List<SortCondition<IT_AnsyuKihon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_AnsyuKihon()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_AnsyuKihon()).syono, SortOrder.ASC));
        List<IT_AnsyuKihon> copyList = new ArrayList<IT_AnsyuKihon>(pEntity);
        Collections.sort(copyList, new OrderIT_AnsyuKihon(orders));
        return copyList;
    }

    public List<IT_AnsyuKihon> OrderIT_AnsyuKihonByPkDesc(List<IT_AnsyuKihon> pEntity) {
        List<SortCondition<IT_AnsyuKihon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_AnsyuKihon()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_AnsyuKihon()).syono, SortOrder.DESC));
        List<IT_AnsyuKihon> copyList = new ArrayList<IT_AnsyuKihon>(pEntity);
        Collections.sort(copyList, new OrderIT_AnsyuKihon(orders));
        return copyList;
    }

}

