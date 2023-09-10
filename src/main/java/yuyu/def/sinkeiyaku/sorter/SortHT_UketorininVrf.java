package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_UketorininVrf;
import yuyu.def.db.meta.QHT_UketorininVrf;
import yuyu.def.sinkeiyaku.comparator.OrderHT_UketorininVrf;

public class SortHT_UketorininVrf {

    
    public List<HT_UketorininVrf> OrderHT_UketorininVrfByPkAsc(List<HT_UketorininVrf> pEntity) {
        List<SortCondition<HT_UketorininVrf>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_UketorininVrf()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_UketorininVrf()).uktsyukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_UketorininVrf()).uktsyurenno, SortOrder.ASC));
        List<HT_UketorininVrf> copyList = new ArrayList<HT_UketorininVrf>(pEntity);
        Collections.sort(copyList, new OrderHT_UketorininVrf(orders));
        return copyList;
    }

    
    public List<HT_UketorininVrf> OrderHT_UketorininVrfByPkDesc(List<HT_UketorininVrf> pEntity) {
        List<SortCondition<HT_UketorininVrf>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_UketorininVrf()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_UketorininVrf()).uktsyukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_UketorininVrf()).uktsyurenno, SortOrder.DESC));
        List<HT_UketorininVrf> copyList = new ArrayList<HT_UketorininVrf>(pEntity);
        Collections.sort(copyList, new OrderHT_UketorininVrf(orders));
        return copyList;
    }

}

