package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IW_TmttkinYskWk;
import yuyu.def.db.meta.QIW_TmttkinYskWk;
import yuyu.def.hozen.comparator.OrderIW_TmttkinYskWk;

public class SortIW_TmttkinYskWk {

    public List<IW_TmttkinYskWk> OrderIW_TmttkinYskWkByPkAsc(List<IW_TmttkinYskWk> pEntity) {
        List<SortCondition<IW_TmttkinYskWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_TmttkinYskWk()).syono, SortOrder.ASC));
        List<IW_TmttkinYskWk> copyList = new ArrayList<IW_TmttkinYskWk>(pEntity);
        Collections.sort(copyList, new OrderIW_TmttkinYskWk(orders));
        return copyList;
    }

    public List<IW_TmttkinYskWk> OrderIW_TmttkinYskWkByPkDesc(List<IW_TmttkinYskWk> pEntity) {
        List<SortCondition<IW_TmttkinYskWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_TmttkinYskWk()).syono, SortOrder.DESC));
        List<IW_TmttkinYskWk> copyList = new ArrayList<IW_TmttkinYskWk>(pEntity);
        Collections.sort(copyList, new OrderIW_TmttkinYskWk(orders));
        return copyList;
    }
}
