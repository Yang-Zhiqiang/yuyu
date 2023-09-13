package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IW_KhDShrWk;
import yuyu.def.db.meta.QIW_KhDShrWk;
import yuyu.def.hozen.comparator.OrderIW_KhDShrWk;

public class SortIW_KhDShrWk {

    public List<IW_KhDShrWk> OrderIW_KhDShrWkByPkAsc(List<IW_KhDShrWk> pEntity) {
        List<SortCondition<IW_KhDShrWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhDShrWk()).kouteikanriid, SortOrder.ASC));
        List<IW_KhDShrWk> copyList = new ArrayList<IW_KhDShrWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhDShrWk(orders));
        return copyList;
    }

    public List<IW_KhDShrWk> OrderIW_KhDShrWkByPkDesc(List<IW_KhDShrWk> pEntity) {
        List<SortCondition<IW_KhDShrWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhDShrWk()).kouteikanriid, SortOrder.DESC));
        List<IW_KhDShrWk> copyList = new ArrayList<IW_KhDShrWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhDShrWk(orders));
        return copyList;
    }
}
