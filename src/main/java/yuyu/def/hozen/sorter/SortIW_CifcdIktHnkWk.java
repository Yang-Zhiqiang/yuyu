package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IW_CifcdIktHnkWk;
import yuyu.def.db.meta.QIW_CifcdIktHnkWk;
import yuyu.def.hozen.comparator.OrderIW_CifcdIktHnkWk;

public class SortIW_CifcdIktHnkWk {

    public List<IW_CifcdIktHnkWk> OrderIW_CifcdIktHnkWkByPkAsc(List<IW_CifcdIktHnkWk> pEntity) {
        List<SortCondition<IW_CifcdIktHnkWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_CifcdIktHnkWk()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIW_CifcdIktHnkWk()).syono, SortOrder.ASC));
        List<IW_CifcdIktHnkWk> copyList = new ArrayList<IW_CifcdIktHnkWk>(pEntity);
        Collections.sort(copyList, new OrderIW_CifcdIktHnkWk(orders));
        return copyList;
    }

    public List<IW_CifcdIktHnkWk> OrderIW_CifcdIktHnkWkByPkDesc(List<IW_CifcdIktHnkWk> pEntity) {
        List<SortCondition<IW_CifcdIktHnkWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_CifcdIktHnkWk()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIW_CifcdIktHnkWk()).syono, SortOrder.DESC));
        List<IW_CifcdIktHnkWk> copyList = new ArrayList<IW_CifcdIktHnkWk>(pEntity);
        Collections.sort(copyList, new OrderIW_CifcdIktHnkWk(orders));
        return copyList;
    }
}
