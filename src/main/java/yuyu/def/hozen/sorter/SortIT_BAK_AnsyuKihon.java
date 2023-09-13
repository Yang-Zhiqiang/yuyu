package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_AnsyuKihon;
import yuyu.def.db.meta.QIT_BAK_AnsyuKihon;
import yuyu.def.hozen.comparator.OrderIT_BAK_AnsyuKihon;

public class SortIT_BAK_AnsyuKihon {

    public List<IT_BAK_AnsyuKihon> OrderIT_BAK_AnsyuKihonByPkAsc(List<IT_BAK_AnsyuKihon> pEntity) {
        List<SortCondition<IT_BAK_AnsyuKihon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_AnsyuKihon()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_AnsyuKihon()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_AnsyuKihon()).trkssikibetukey, SortOrder.ASC));
        List<IT_BAK_AnsyuKihon> copyList = new ArrayList<IT_BAK_AnsyuKihon>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_AnsyuKihon(orders));
        return copyList;
    }

    public List<IT_BAK_AnsyuKihon> OrderIT_BAK_AnsyuKihonByPkDesc(List<IT_BAK_AnsyuKihon> pEntity) {
        List<SortCondition<IT_BAK_AnsyuKihon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_AnsyuKihon()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_AnsyuKihon()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_AnsyuKihon()).trkssikibetukey, SortOrder.DESC));
        List<IT_BAK_AnsyuKihon> copyList = new ArrayList<IT_BAK_AnsyuKihon>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_AnsyuKihon(orders));
        return copyList;
    }

}

