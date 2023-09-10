package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_BosUketorinin;
import yuyu.def.db.meta.QHT_BosUketorinin;
import yuyu.def.sinkeiyaku.comparator.OrderHT_BosUketorinin;

public class SortHT_BosUketorinin {

    
    public List<HT_BosUketorinin> OrderHT_BosUketorininByPkAsc(List<HT_BosUketorinin> pEntity) {
        List<SortCondition<HT_BosUketorinin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_BosUketorinin()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_BosUketorinin()).uktsyukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_BosUketorinin()).uktsyurenno, SortOrder.ASC));
        List<HT_BosUketorinin> copyList = new ArrayList<HT_BosUketorinin>(pEntity);
        Collections.sort(copyList, new OrderHT_BosUketorinin(orders));
        return copyList;
    }

    
    public List<HT_BosUketorinin> OrderHT_BosUketorininByPkDesc(List<HT_BosUketorinin> pEntity) {
        List<SortCondition<HT_BosUketorinin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_BosUketorinin()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_BosUketorinin()).uktsyukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_BosUketorinin()).uktsyurenno, SortOrder.DESC));
        List<HT_BosUketorinin> copyList = new ArrayList<HT_BosUketorinin>(pEntity);
        Collections.sort(copyList, new OrderHT_BosUketorinin(orders));
        return copyList;
    }

}

