package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IW_KhYendtHnkHrShrWk;
import yuyu.def.db.meta.QIW_KhYendtHnkHrShrWk;
import yuyu.def.hozen.comparator.OrderIW_KhYendtHnkHrShrWk;

public class SortIW_KhYendtHnkHrShrWk {

    public List<IW_KhYendtHnkHrShrWk> OrderIW_KhYendtHnkHrShrWkByPkAsc(List<IW_KhYendtHnkHrShrWk> pEntity) {
        List<SortCondition<IW_KhYendtHnkHrShrWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhYendtHnkHrShrWk()).kouteikanriid, SortOrder.ASC));
        List<IW_KhYendtHnkHrShrWk> copyList = new ArrayList<IW_KhYendtHnkHrShrWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhYendtHnkHrShrWk(orders));
        return copyList;
    }

    public List<IW_KhYendtHnkHrShrWk> OrderIW_KhYendtHnkHrShrWkByPkDesc(List<IW_KhYendtHnkHrShrWk> pEntity) {
        List<SortCondition<IW_KhYendtHnkHrShrWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhYendtHnkHrShrWk()).kouteikanriid, SortOrder.DESC));
        List<IW_KhYendtHnkHrShrWk> copyList = new ArrayList<IW_KhYendtHnkHrShrWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhYendtHnkHrShrWk(orders));
        return copyList;
    }
}
