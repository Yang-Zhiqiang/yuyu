package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KessanYokukiP;
import yuyu.def.db.meta.QIT_KessanYokukiP;
import yuyu.def.hozen.comparator.OrderIT_KessanYokukiP;

public class SortIT_KessanYokukiP {

    public List<IT_KessanYokukiP> OrderIT_KessanYokukiPByPkAsc(List<IT_KessanYokukiP> pEntity) {
        List<SortCondition<IT_KessanYokukiP>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KessanYokukiP()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KessanYokukiP()).keijyouym, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KessanYokukiP()).syono, SortOrder.ASC));
        List<IT_KessanYokukiP> copyList = new ArrayList<IT_KessanYokukiP>(pEntity);
        Collections.sort(copyList, new OrderIT_KessanYokukiP(orders));
        return copyList;
    }

    public List<IT_KessanYokukiP> OrderIT_KessanYokukiPByPkDesc(List<IT_KessanYokukiP> pEntity) {
        List<SortCondition<IT_KessanYokukiP>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KessanYokukiP()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KessanYokukiP()).keijyouym, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KessanYokukiP()).syono, SortOrder.DESC));
        List<IT_KessanYokukiP> copyList = new ArrayList<IT_KessanYokukiP>(pEntity);
        Collections.sort(copyList, new OrderIT_KessanYokukiP(orders));
        return copyList;
    }
}
