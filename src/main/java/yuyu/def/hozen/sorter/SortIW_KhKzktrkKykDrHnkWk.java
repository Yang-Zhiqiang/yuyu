package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IW_KhKzktrkKykDrHnkWk;
import yuyu.def.db.meta.QIW_KhKzktrkKykDrHnkWk;
import yuyu.def.hozen.comparator.OrderIW_KhKzktrkKykDrHnkWk;

public class SortIW_KhKzktrkKykDrHnkWk {

    public List<IW_KhKzktrkKykDrHnkWk> OrderIW_KhKzktrkKykDrHnkWkByPkAsc(List<IW_KhKzktrkKykDrHnkWk> pEntity) {
        List<SortCondition<IW_KhKzktrkKykDrHnkWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhKzktrkKykDrHnkWk()).kouteikanriid, SortOrder.ASC));
        List<IW_KhKzktrkKykDrHnkWk> copyList = new ArrayList<IW_KhKzktrkKykDrHnkWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhKzktrkKykDrHnkWk(orders));
        return copyList;
    }

    public List<IW_KhKzktrkKykDrHnkWk> OrderIW_KhKzktrkKykDrHnkWkByPkDesc(List<IW_KhKzktrkKykDrHnkWk> pEntity) {
        List<SortCondition<IW_KhKzktrkKykDrHnkWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhKzktrkKykDrHnkWk()).kouteikanriid, SortOrder.DESC));
        List<IW_KhKzktrkKykDrHnkWk> copyList = new ArrayList<IW_KhKzktrkKykDrHnkWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhKzktrkKykDrHnkWk(orders));
        return copyList;
    }
}
