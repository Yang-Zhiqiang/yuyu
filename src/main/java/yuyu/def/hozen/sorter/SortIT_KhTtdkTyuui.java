package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.meta.QIT_KhTtdkTyuui;
import yuyu.def.hozen.comparator.OrderIT_KhTtdkTyuui;

public class SortIT_KhTtdkTyuui {

    public List<IT_KhTtdkTyuui> OrderIT_KhTtdkTyuuiByPkAsc(List<IT_KhTtdkTyuui> pEntity) {
        List<SortCondition<IT_KhTtdkTyuui>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhTtdkTyuui()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhTtdkTyuui()).syono, SortOrder.ASC));
        List<IT_KhTtdkTyuui> copyList = new ArrayList<IT_KhTtdkTyuui>(pEntity);
        Collections.sort(copyList, new OrderIT_KhTtdkTyuui(orders));
        return copyList;
    }

    public List<IT_KhTtdkTyuui> OrderIT_KhTtdkTyuuiByPkDesc(List<IT_KhTtdkTyuui> pEntity) {
        List<SortCondition<IT_KhTtdkTyuui>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhTtdkTyuui()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhTtdkTyuui()).syono, SortOrder.DESC));
        List<IT_KhTtdkTyuui> copyList = new ArrayList<IT_KhTtdkTyuui>(pEntity);
        Collections.sort(copyList, new OrderIT_KhTtdkTyuui(orders));
        return copyList;
    }

}

