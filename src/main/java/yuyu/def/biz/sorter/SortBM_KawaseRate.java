package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_KawaseRate;
import yuyu.def.db.entity.BM_KawaseRate;
import yuyu.def.db.meta.QBM_KawaseRate;

public class SortBM_KawaseRate {

    public List<BM_KawaseRate> OrderBM_KawaseRateByPkAsc(List<BM_KawaseRate> pEntity) {
        List<SortCondition<BM_KawaseRate>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_KawaseRate()).kwsratekjymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_KawaseRate()).kwsrendoukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_KawaseRate()).mototuuka, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_KawaseRate()).kanzantuuka, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_KawaseRate()).kawasetekiyokbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_KawaseRate()).kawasetsrykbn, SortOrder.ASC));
        List<BM_KawaseRate> copyList = new ArrayList<BM_KawaseRate>(pEntity);
        Collections.sort(copyList, new OrderBM_KawaseRate(orders));
        return copyList;
    }

    public List<BM_KawaseRate> OrderBM_KawaseRateByPkDesc(List<BM_KawaseRate> pEntity) {
        List<SortCondition<BM_KawaseRate>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_KawaseRate()).kwsratekjymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_KawaseRate()).kwsrendoukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_KawaseRate()).mototuuka, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_KawaseRate()).kanzantuuka, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_KawaseRate()).kawasetekiyokbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_KawaseRate()).kawasetsrykbn, SortOrder.DESC));
        List<BM_KawaseRate> copyList = new ArrayList<BM_KawaseRate>(pEntity);
        Collections.sort(copyList, new OrderBM_KawaseRate(orders));
        return copyList;
    }

}

