package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_TtdkKan;
import yuyu.def.db.meta.QIT_BAK_TtdkKan;
import yuyu.def.hozen.comparator.OrderIT_BAK_TtdkKan;

public class SortIT_BAK_TtdkKan {

    public List<IT_BAK_TtdkKan> OrderIT_BAK_TtdkKanByPkAsc(List<IT_BAK_TtdkKan> pEntity) {
        List<SortCondition<IT_BAK_TtdkKan>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_TtdkKan()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_TtdkKan()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_TtdkKan()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_TtdkKan()).henkousikibetukey, SortOrder.ASC));
        List<IT_BAK_TtdkKan> copyList = new ArrayList<IT_BAK_TtdkKan>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_TtdkKan(orders));
        return copyList;
    }

    public List<IT_BAK_TtdkKan> OrderIT_BAK_TtdkKanByPkDesc(List<IT_BAK_TtdkKan> pEntity) {
        List<SortCondition<IT_BAK_TtdkKan>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_TtdkKan()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_TtdkKan()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_TtdkKan()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_TtdkKan()).henkousikibetukey, SortOrder.DESC));
        List<IT_BAK_TtdkKan> copyList = new ArrayList<IT_BAK_TtdkKan>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_TtdkKan(orders));
        return copyList;
    }

}

