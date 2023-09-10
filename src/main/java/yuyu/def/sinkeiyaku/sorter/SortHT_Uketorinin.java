package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_Uketorinin;
import yuyu.def.db.meta.QHT_Uketorinin;
import yuyu.def.sinkeiyaku.comparator.OrderHT_Uketorinin;

public class SortHT_Uketorinin {

    
    public List<HT_Uketorinin> OrderHT_UketorininByPkAsc(List<HT_Uketorinin> pEntity) {
        List<SortCondition<HT_Uketorinin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_Uketorinin()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_Uketorinin()).uktsyukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_Uketorinin()).uktsyurenno, SortOrder.ASC));
        List<HT_Uketorinin> copyList = new ArrayList<HT_Uketorinin>(pEntity);
        Collections.sort(copyList, new OrderHT_Uketorinin(orders));
        return copyList;
    }

    
    public List<HT_Uketorinin> OrderHT_UketorininByPkDesc(List<HT_Uketorinin> pEntity) {
        List<SortCondition<HT_Uketorinin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_Uketorinin()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_Uketorinin()).uktsyukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_Uketorinin()).uktsyurenno, SortOrder.DESC));
        List<HT_Uketorinin> copyList = new ArrayList<HT_Uketorinin>(pEntity);
        Collections.sort(copyList, new OrderHT_Uketorinin(orders));
        return copyList;
    }
    
    public List<HT_Uketorinin> OrderHT_UketorininByUktbnwariDescUktsyurennoAsc(List<HT_Uketorinin> pEntity) {
        List<SortCondition<HT_Uketorinin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_Uketorinin()).uktbnwari, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_Uketorinin()).uktsyurenno, SortOrder.ASC));
        List<HT_Uketorinin> copyList = new ArrayList<HT_Uketorinin>(pEntity);
        Collections.sort(copyList, new OrderHT_Uketorinin(orders));
        return copyList;
    }


}

