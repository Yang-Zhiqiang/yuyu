package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IW_KhHubiDetailWk;
import yuyu.def.db.meta.QIW_KhHubiDetailWk;
import yuyu.def.hozen.comparator.OrderIW_KhHubiDetailWk;

public class SortIW_KhHubiDetailWk {

    public List<IW_KhHubiDetailWk> OrderIW_KhHubiDetailWkByPkAsc(List<IW_KhHubiDetailWk> pEntity) {
        List<SortCondition<IW_KhHubiDetailWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhHubiDetailWk()).kouteikanriid, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIW_KhHubiDetailWk()).renno3keta, SortOrder.ASC));
        List<IW_KhHubiDetailWk> copyList = new ArrayList<IW_KhHubiDetailWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhHubiDetailWk(orders));
        return copyList;
    }

    public List<IW_KhHubiDetailWk> OrderIW_KhHubiDetailWkByPkDesc(List<IW_KhHubiDetailWk> pEntity) {
        List<SortCondition<IW_KhHubiDetailWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhHubiDetailWk()).kouteikanriid, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIW_KhHubiDetailWk()).renno3keta, SortOrder.DESC));
        List<IW_KhHubiDetailWk> copyList = new ArrayList<IW_KhHubiDetailWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhHubiDetailWk(orders));
        return copyList;
    }

}

