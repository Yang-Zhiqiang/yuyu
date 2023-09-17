package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_KanjyouKamoku;
import yuyu.def.db.entity.BM_KanjyouKamoku;
import yuyu.def.db.meta.QBM_KanjyouKamoku;

public class SortBM_KanjyouKamoku {

    public List<BM_KanjyouKamoku> OrderBM_KanjyouKamokuByPkAsc(List<BM_KanjyouKamoku> pEntity) {
        List<SortCondition<BM_KanjyouKamoku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_KanjyouKamoku()).kanjyoukmkcd, SortOrder.ASC));
        List<BM_KanjyouKamoku> copyList = new ArrayList<BM_KanjyouKamoku>(pEntity);
        Collections.sort(copyList, new OrderBM_KanjyouKamoku(orders));
        return copyList;
    }

    public List<BM_KanjyouKamoku> OrderBM_KanjyouKamokuByPkDesc(List<BM_KanjyouKamoku> pEntity) {
        List<SortCondition<BM_KanjyouKamoku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_KanjyouKamoku()).kanjyoukmkcd, SortOrder.DESC));
        List<BM_KanjyouKamoku> copyList = new ArrayList<BM_KanjyouKamoku>(pEntity);
        Collections.sort(copyList, new OrderBM_KanjyouKamoku(orders));
        return copyList;
    }

}

