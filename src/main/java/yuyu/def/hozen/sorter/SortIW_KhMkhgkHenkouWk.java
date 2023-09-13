package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IW_KhMkhgkHenkouWk;
import yuyu.def.db.meta.QIW_KhMkhgkHenkouWk;
import yuyu.def.hozen.comparator.OrderIW_KhMkhgkHenkouWk;

public class SortIW_KhMkhgkHenkouWk {

    public List<IW_KhMkhgkHenkouWk> OrderIW_KhMkhgkHenkouWkByPkAsc(List<IW_KhMkhgkHenkouWk> pEntity) {
        List<SortCondition<IW_KhMkhgkHenkouWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhMkhgkHenkouWk()).kouteikanriid, SortOrder.ASC));
        List<IW_KhMkhgkHenkouWk> copyList = new ArrayList<IW_KhMkhgkHenkouWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhMkhgkHenkouWk(orders));
        return copyList;
    }

    public List<IW_KhMkhgkHenkouWk> OrderIW_KhMkhgkHenkouWkByPkDesc(List<IW_KhMkhgkHenkouWk> pEntity) {
        List<SortCondition<IW_KhMkhgkHenkouWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhMkhgkHenkouWk()).kouteikanriid, SortOrder.DESC));
        List<IW_KhMkhgkHenkouWk> copyList = new ArrayList<IW_KhMkhgkHenkouWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhMkhgkHenkouWk(orders));
        return copyList;
    }
}
