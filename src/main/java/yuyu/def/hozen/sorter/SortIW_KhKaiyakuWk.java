package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IW_KhKaiyakuWk;
import yuyu.def.db.meta.QIW_KhKaiyakuWk;
import yuyu.def.hozen.comparator.OrderIW_KhKaiyakuWk;

public class SortIW_KhKaiyakuWk {

    public List<IW_KhKaiyakuWk> OrderIW_KhKaiyakuWkByPkAsc(List<IW_KhKaiyakuWk> pEntity) {
        List<SortCondition<IW_KhKaiyakuWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhKaiyakuWk()).kouteikanriid, SortOrder.ASC));
        List<IW_KhKaiyakuWk> copyList = new ArrayList<IW_KhKaiyakuWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhKaiyakuWk(orders));
        return copyList;
    }

    public List<IW_KhKaiyakuWk> OrderIW_KhKaiyakuWkByPkDesc(List<IW_KhKaiyakuWk> pEntity) {
        List<SortCondition<IW_KhKaiyakuWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhKaiyakuWk()).kouteikanriid, SortOrder.DESC));
        List<IW_KhKaiyakuWk> copyList = new ArrayList<IW_KhKaiyakuWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhKaiyakuWk(orders));
        return copyList;
    }

}

