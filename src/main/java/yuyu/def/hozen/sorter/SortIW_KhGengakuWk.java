package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IW_KhGengakuWk;
import yuyu.def.db.meta.QIW_KhGengakuWk;
import yuyu.def.hozen.comparator.OrderIW_KhGengakuWk;

public class SortIW_KhGengakuWk {

    public List<IW_KhGengakuWk> OrderIW_KhGengakuWkByPkAsc(List<IW_KhGengakuWk> pEntity) {
        List<SortCondition<IW_KhGengakuWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhGengakuWk()).kouteikanriid, SortOrder.ASC));
        List<IW_KhGengakuWk> copyList = new ArrayList<IW_KhGengakuWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhGengakuWk(orders));
        return copyList;
    }

    public List<IW_KhGengakuWk> OrderIW_KhGengakuWkByPkDesc(List<IW_KhGengakuWk> pEntity) {
        List<SortCondition<IW_KhGengakuWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhGengakuWk()).kouteikanriid, SortOrder.DESC));
        List<IW_KhGengakuWk> copyList = new ArrayList<IW_KhGengakuWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhGengakuWk(orders));
        return copyList;
    }

}

