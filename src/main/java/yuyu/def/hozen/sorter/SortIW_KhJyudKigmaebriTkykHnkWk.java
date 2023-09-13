package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IW_KhJyudKigmaebriTkykHnkWk;
import yuyu.def.db.meta.QIW_KhJyudKigmaebriTkykHnkWk;
import yuyu.def.hozen.comparator.OrderIW_KhJyudKigmaebriTkykHnkWk;

public class SortIW_KhJyudKigmaebriTkykHnkWk {

    public List<IW_KhJyudKigmaebriTkykHnkWk> OrderIW_KhJyudKigmaebriTkykHnkWkByPkAsc(List<IW_KhJyudKigmaebriTkykHnkWk> pEntity) {
        List<SortCondition<IW_KhJyudKigmaebriTkykHnkWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhJyudKigmaebriTkykHnkWk()).kouteikanriid, SortOrder.ASC));
        List<IW_KhJyudKigmaebriTkykHnkWk> copyList = new ArrayList<IW_KhJyudKigmaebriTkykHnkWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhJyudKigmaebriTkykHnkWk(orders));
        return copyList;
    }

    public List<IW_KhJyudKigmaebriTkykHnkWk> OrderIW_KhJyudKigmaebriTkykHnkWkByPkDesc(List<IW_KhJyudKigmaebriTkykHnkWk> pEntity) {
        List<SortCondition<IW_KhJyudKigmaebriTkykHnkWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhJyudKigmaebriTkykHnkWk()).kouteikanriid, SortOrder.DESC));
        List<IW_KhJyudKigmaebriTkykHnkWk> copyList = new ArrayList<IW_KhJyudKigmaebriTkykHnkWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhJyudKigmaebriTkykHnkWk(orders));
        return copyList;
    }
}
