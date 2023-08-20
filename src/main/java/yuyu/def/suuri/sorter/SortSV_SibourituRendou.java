package yuyu.def.suuri.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.SV_SibourituRendou;
import yuyu.def.db.meta.QSV_SibourituRendou;
import yuyu.def.suuri.comparator.OrderSV_SibourituRendou;

public class SortSV_SibourituRendou {

    
    public List<SV_SibourituRendou> OrderSV_SibourituRendouByPkAsc(List<SV_SibourituRendou> pEntity) {
        List<SortCondition<SV_SibourituRendou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QSV_SibourituRendou()).mosno, SortOrder.ASC));
        List<SV_SibourituRendou> copyList = new ArrayList<SV_SibourituRendou>(pEntity);
        Collections.sort(copyList, new OrderSV_SibourituRendou(orders));
        return copyList;
    }

    
    public List<SV_SibourituRendou> OrderSV_SibourituRendouByPkDesc(List<SV_SibourituRendou> pEntity) {
        List<SortCondition<SV_SibourituRendou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QSV_SibourituRendou()).mosno, SortOrder.DESC));
        List<SV_SibourituRendou> copyList = new ArrayList<SV_SibourituRendou>(pEntity);
        Collections.sort(copyList, new OrderSV_SibourituRendou(orders));
        return copyList;
    }
}
