package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_MyMenu;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_MyMenu;
import yuyu.def.db.meta.QAT_MyMenu;

public class SortAT_MyMenu {

    public List<AT_MyMenu> OrderAT_MyMenuByPkAsc(List<AT_MyMenu> pEntity) {
        List<SortCondition<AT_MyMenu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_MyMenu()).userId, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAT_MyMenu()).kinouId, SortOrder.ASC));
        List<AT_MyMenu> copyList = new ArrayList<AT_MyMenu>(pEntity);
        Collections.sort(copyList, new OrderAT_MyMenu(orders));
        return copyList;
    }

    public List<AT_MyMenu> OrderAT_MyMenuByPkDesc(List<AT_MyMenu> pEntity) {
        List<SortCondition<AT_MyMenu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_MyMenu()).userId, SortOrder.DESC));
        orders.add(new SortCondition<>((new QAT_MyMenu()).kinouId, SortOrder.DESC));
        List<AT_MyMenu> copyList = new ArrayList<AT_MyMenu>(pEntity);
        Collections.sort(copyList, new OrderAT_MyMenu(orders));
        return copyList;
    }
}
