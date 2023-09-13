package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IW_KhKeiyakuTorikesiWk;
import yuyu.def.db.meta.QIW_KhKeiyakuTorikesiWk;
import yuyu.def.hozen.comparator.OrderIW_KhKeiyakuTorikesiWk;

public class SortIW_KhKeiyakuTorikesiWk {

    public List<IW_KhKeiyakuTorikesiWk> OrderIW_KhKeiyakuTorikesiWkByPkAsc(List<IW_KhKeiyakuTorikesiWk> pEntity) {
        List<SortCondition<IW_KhKeiyakuTorikesiWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhKeiyakuTorikesiWk()).kouteikanriid, SortOrder.ASC));
        List<IW_KhKeiyakuTorikesiWk> copyList = new ArrayList<IW_KhKeiyakuTorikesiWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhKeiyakuTorikesiWk(orders));
        return copyList;
    }

    public List<IW_KhKeiyakuTorikesiWk> OrderIW_KhKeiyakuTorikesiWkByPkDesc(List<IW_KhKeiyakuTorikesiWk> pEntity) {
        List<SortCondition<IW_KhKeiyakuTorikesiWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhKeiyakuTorikesiWk()).kouteikanriid, SortOrder.DESC));
        List<IW_KhKeiyakuTorikesiWk> copyList = new ArrayList<IW_KhKeiyakuTorikesiWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhKeiyakuTorikesiWk(orders));
        return copyList;
    }

}

