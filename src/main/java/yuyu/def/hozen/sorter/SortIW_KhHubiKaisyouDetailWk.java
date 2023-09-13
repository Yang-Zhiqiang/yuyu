package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IW_KhHubiKaisyouDetailWk;
import yuyu.def.db.meta.QIW_KhHubiKaisyouDetailWk;
import yuyu.def.hozen.comparator.OrderIW_KhHubiKaisyouDetailWk;

public class SortIW_KhHubiKaisyouDetailWk {

    public List<IW_KhHubiKaisyouDetailWk> OrderIW_KhHubiKaisyouDetailWkByPkAsc(List<IW_KhHubiKaisyouDetailWk> pEntity) {
        List<SortCondition<IW_KhHubiKaisyouDetailWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhHubiKaisyouDetailWk()).kouteikanriid, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIW_KhHubiKaisyouDetailWk()).renno3keta, SortOrder.ASC));
        List<IW_KhHubiKaisyouDetailWk> copyList = new ArrayList<IW_KhHubiKaisyouDetailWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhHubiKaisyouDetailWk(orders));
        return copyList;
    }

    public List<IW_KhHubiKaisyouDetailWk> OrderIW_KhHubiKaisyouDetailWkByPkDesc(List<IW_KhHubiKaisyouDetailWk> pEntity) {
        List<SortCondition<IW_KhHubiKaisyouDetailWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhHubiKaisyouDetailWk()).kouteikanriid, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIW_KhHubiKaisyouDetailWk()).renno3keta, SortOrder.DESC));
        List<IW_KhHubiKaisyouDetailWk> copyList = new ArrayList<IW_KhHubiKaisyouDetailWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhHubiKaisyouDetailWk(orders));
        return copyList;
    }

}

