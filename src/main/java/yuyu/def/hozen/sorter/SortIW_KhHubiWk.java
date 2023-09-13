package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IW_KhHubiWk;
import yuyu.def.db.meta.QIW_KhHubiWk;
import yuyu.def.hozen.comparator.OrderIW_KhHubiWk;

public class SortIW_KhHubiWk {

    public List<IW_KhHubiWk> OrderIW_KhHubiWkByPkAsc(List<IW_KhHubiWk> pEntity) {
        List<SortCondition<IW_KhHubiWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhHubiWk()).kouteikanriid, SortOrder.ASC));
        List<IW_KhHubiWk> copyList = new ArrayList<IW_KhHubiWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhHubiWk(orders));
        return copyList;
    }

    public List<IW_KhHubiWk> OrderIW_KhHubiWkByPkDesc(List<IW_KhHubiWk> pEntity) {
        List<SortCondition<IW_KhHubiWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhHubiWk()).kouteikanriid, SortOrder.DESC));
        List<IW_KhHubiWk> copyList = new ArrayList<IW_KhHubiWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhHubiWk(orders));
        return copyList;
    }

}

