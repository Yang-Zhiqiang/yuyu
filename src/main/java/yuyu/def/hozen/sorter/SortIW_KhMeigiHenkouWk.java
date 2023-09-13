package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IW_KhMeigiHenkouWk;
import yuyu.def.db.meta.QIW_KhMeigiHenkouWk;
import yuyu.def.hozen.comparator.OrderIW_KhMeigiHenkouWk;

public class SortIW_KhMeigiHenkouWk {

    public List<IW_KhMeigiHenkouWk> OrderIW_KhMeigiHenkouWkByPkAsc(List<IW_KhMeigiHenkouWk> pEntity) {
        List<SortCondition<IW_KhMeigiHenkouWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhMeigiHenkouWk()).kouteikanriid, SortOrder.ASC));
        List<IW_KhMeigiHenkouWk> copyList = new ArrayList<IW_KhMeigiHenkouWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhMeigiHenkouWk(orders));
        return copyList;
    }

    public List<IW_KhMeigiHenkouWk> OrderIW_KhMeigiHenkouWkByPkDesc(List<IW_KhMeigiHenkouWk> pEntity) {
        List<SortCondition<IW_KhMeigiHenkouWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhMeigiHenkouWk()).kouteikanriid, SortOrder.DESC));
        List<IW_KhMeigiHenkouWk> copyList = new ArrayList<IW_KhMeigiHenkouWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhMeigiHenkouWk(orders));
        return copyList;
    }

}

