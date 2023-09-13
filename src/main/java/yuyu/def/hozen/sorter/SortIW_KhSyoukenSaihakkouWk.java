package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IW_KhSyoukenSaihakkouWk;
import yuyu.def.db.meta.QIW_KhSyoukenSaihakkouWk;
import yuyu.def.hozen.comparator.OrderIW_KhSyoukenSaihakkouWk;

public class SortIW_KhSyoukenSaihakkouWk {

    public List<IW_KhSyoukenSaihakkouWk> OrderIW_KhSyoukenSaihakkouWkByPkAsc(List<IW_KhSyoukenSaihakkouWk> pEntity) {
        List<SortCondition<IW_KhSyoukenSaihakkouWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhSyoukenSaihakkouWk()).kouteikanriid, SortOrder.ASC));
        List<IW_KhSyoukenSaihakkouWk> copyList = new ArrayList<IW_KhSyoukenSaihakkouWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhSyoukenSaihakkouWk(orders));
        return copyList;
    }

    public List<IW_KhSyoukenSaihakkouWk> OrderIW_KhSyoukenSaihakkouWkByPkDesc(List<IW_KhSyoukenSaihakkouWk> pEntity) {
        List<SortCondition<IW_KhSyoukenSaihakkouWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhSyoukenSaihakkouWk()).kouteikanriid, SortOrder.DESC));
        List<IW_KhSyoukenSaihakkouWk> copyList = new ArrayList<IW_KhSyoukenSaihakkouWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhSyoukenSaihakkouWk(orders));
        return copyList;
    }

}

