package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IW_KhYendtHnkUktkNiniWk;
import yuyu.def.db.meta.QIW_KhYendtHnkUktkNiniWk;
import yuyu.def.hozen.comparator.OrderIW_KhYendtHnkUktkNiniWk;

public class SortIW_KhYendtHnkUktkNiniWk {

    public List<IW_KhYendtHnkUktkNiniWk> OrderIW_KhYendtHnkUktkNiniWkByPkAsc(List<IW_KhYendtHnkUktkNiniWk> pEntity) {
        List<SortCondition<IW_KhYendtHnkUktkNiniWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhYendtHnkUktkNiniWk()).kouteikanriid, SortOrder.ASC));
        List<IW_KhYendtHnkUktkNiniWk> copyList = new ArrayList<IW_KhYendtHnkUktkNiniWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhYendtHnkUktkNiniWk(orders));
        return copyList;
    }

    public List<IW_KhYendtHnkUktkNiniWk> OrderIW_KhYendtHnkUktkNiniWkByPkDesc(List<IW_KhYendtHnkUktkNiniWk> pEntity) {
        List<SortCondition<IW_KhYendtHnkUktkNiniWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhYendtHnkUktkNiniWk()).kouteikanriid, SortOrder.DESC));
        List<IW_KhYendtHnkUktkNiniWk> copyList = new ArrayList<IW_KhYendtHnkUktkNiniWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhYendtHnkUktkNiniWk(orders));
        return copyList;
    }
}
