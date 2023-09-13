package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IW_KhHaraikataHenkouWk;
import yuyu.def.db.meta.QIW_KhHaraikataHenkouWk;
import yuyu.def.hozen.comparator.OrderIW_KhHaraikataHenkouWk;

public class SortIW_KhHaraikataHenkouWk {

    public List<IW_KhHaraikataHenkouWk> OrderIW_KhHaraikataHenkouWkByPkAsc(List<IW_KhHaraikataHenkouWk> pEntity) {
        List<SortCondition<IW_KhHaraikataHenkouWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhHaraikataHenkouWk()).kouteikanriid, SortOrder.ASC));
        List<IW_KhHaraikataHenkouWk> copyList = new ArrayList<IW_KhHaraikataHenkouWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhHaraikataHenkouWk(orders));
        return copyList;
    }

    public List<IW_KhHaraikataHenkouWk> OrderIW_KhHaraikataHenkouWkByPkDesc(List<IW_KhHaraikataHenkouWk> pEntity) {
        List<SortCondition<IW_KhHaraikataHenkouWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhHaraikataHenkouWk()).kouteikanriid, SortOrder.DESC));
        List<IW_KhHaraikataHenkouWk> copyList = new ArrayList<IW_KhHaraikataHenkouWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhHaraikataHenkouWk(orders));
        return copyList;
    }
}
