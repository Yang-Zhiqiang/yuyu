package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IW_KhSiharaiKouzaHenkouWk;
import yuyu.def.db.meta.QIW_KhSiharaiKouzaHenkouWk;
import yuyu.def.hozen.comparator.OrderIW_KhSiharaiKouzaHenkouWk;

public class SortIW_KhSiharaiKouzaHenkouWk {

    public List<IW_KhSiharaiKouzaHenkouWk> OrderIW_KhSiharaiKouzaHenkouWkByPkAsc(List<IW_KhSiharaiKouzaHenkouWk> pEntity) {
        List<SortCondition<IW_KhSiharaiKouzaHenkouWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhSiharaiKouzaHenkouWk()).kouteikanriid, SortOrder.ASC));
        List<IW_KhSiharaiKouzaHenkouWk> copyList = new ArrayList<IW_KhSiharaiKouzaHenkouWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhSiharaiKouzaHenkouWk(orders));
        return copyList;
    }

    public List<IW_KhSiharaiKouzaHenkouWk> OrderIW_KhSiharaiKouzaHenkouWkByPkDesc(List<IW_KhSiharaiKouzaHenkouWk> pEntity) {
        List<SortCondition<IW_KhSiharaiKouzaHenkouWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhSiharaiKouzaHenkouWk()).kouteikanriid, SortOrder.DESC));
        List<IW_KhSiharaiKouzaHenkouWk> copyList = new ArrayList<IW_KhSiharaiKouzaHenkouWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhSiharaiKouzaHenkouWk(orders));
        return copyList;
    }

}

