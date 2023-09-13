package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KhTtdkTyuui;
import yuyu.def.db.meta.QIT_BAK_KhTtdkTyuui;
import yuyu.def.hozen.comparator.OrderIT_BAK_KhTtdkTyuui;

public class SortIT_BAK_KhTtdkTyuui {

    public List<IT_BAK_KhTtdkTyuui> OrderIT_BAK_KhTtdkTyuuiByPkAsc(List<IT_BAK_KhTtdkTyuui> pEntity) {
        List<SortCondition<IT_BAK_KhTtdkTyuui>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhTtdkTyuui()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhTtdkTyuui()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhTtdkTyuui()).trkssikibetukey, SortOrder.ASC));
        List<IT_BAK_KhTtdkTyuui> copyList = new ArrayList<IT_BAK_KhTtdkTyuui>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhTtdkTyuui(orders));
        return copyList;
    }

    public List<IT_BAK_KhTtdkTyuui> OrderIT_BAK_KhTtdkTyuuiByPkDesc(List<IT_BAK_KhTtdkTyuui> pEntity) {
        List<SortCondition<IT_BAK_KhTtdkTyuui>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhTtdkTyuui()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhTtdkTyuui()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhTtdkTyuui()).trkssikibetukey, SortOrder.DESC));
        List<IT_BAK_KhTtdkTyuui> copyList = new ArrayList<IT_BAK_KhTtdkTyuui>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhTtdkTyuui(orders));
        return copyList;
    }

}

