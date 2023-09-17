package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_CreditCardKaisya;
import yuyu.def.db.entity.BM_CreditCardKaisya;
import yuyu.def.db.meta.QBM_CreditCardKaisya;

public class SortBM_CreditCardKaisya {

    public List<BM_CreditCardKaisya> OrderBM_CreditCardKaisyaByPkAsc(List<BM_CreditCardKaisya> pEntity) {
        List<SortCondition<BM_CreditCardKaisya>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_CreditCardKaisya()).cardkaisyacd, SortOrder.ASC));
        List<BM_CreditCardKaisya> copyList = new ArrayList<BM_CreditCardKaisya>(pEntity);
        Collections.sort(copyList, new OrderBM_CreditCardKaisya(orders));
        return copyList;
    }

    public List<BM_CreditCardKaisya> OrderBM_CreditCardKaisyaByPkDesc(List<BM_CreditCardKaisya> pEntity) {
        List<SortCondition<BM_CreditCardKaisya>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_CreditCardKaisya()).cardkaisyacd, SortOrder.DESC));
        List<BM_CreditCardKaisya> copyList = new ArrayList<BM_CreditCardKaisya>(pEntity);
        Collections.sort(copyList, new OrderBM_CreditCardKaisya(orders));
        return copyList;
    }
}
