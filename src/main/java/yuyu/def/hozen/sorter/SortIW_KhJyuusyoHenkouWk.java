package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IW_KhJyuusyoHenkouWk;
import yuyu.def.db.meta.QIW_KhJyuusyoHenkouWk;
import yuyu.def.hozen.comparator.OrderIW_KhJyuusyoHenkouWk;

public class SortIW_KhJyuusyoHenkouWk {

    public List<IW_KhJyuusyoHenkouWk> OrderIW_KhJyuusyoHenkouWkByPkAsc(List<IW_KhJyuusyoHenkouWk> pEntity) {
        List<SortCondition<IW_KhJyuusyoHenkouWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhJyuusyoHenkouWk()).kouteikanriid, SortOrder.ASC));
        List<IW_KhJyuusyoHenkouWk> copyList = new ArrayList<IW_KhJyuusyoHenkouWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhJyuusyoHenkouWk(orders));
        return copyList;
    }

    public List<IW_KhJyuusyoHenkouWk> OrderIW_KhJyuusyoHenkouWkByPkDesc(List<IW_KhJyuusyoHenkouWk> pEntity) {
        List<SortCondition<IW_KhJyuusyoHenkouWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhJyuusyoHenkouWk()).kouteikanriid, SortOrder.DESC));
        List<IW_KhJyuusyoHenkouWk> copyList = new ArrayList<IW_KhJyuusyoHenkouWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhJyuusyoHenkouWk(orders));
        return copyList;
    }

}

