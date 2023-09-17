package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_SosikiMadoguti;
import yuyu.def.db.entity.BM_SosikiMadoguti;
import yuyu.def.db.meta.QBM_SosikiMadoguti;

public class SortBM_SosikiMadoguti {

    public List<BM_SosikiMadoguti> OrderBM_SosikiMadogutiByPkAsc(List<BM_SosikiMadoguti> pEntity) {
        List<SortCondition<BM_SosikiMadoguti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_SosikiMadoguti()).sskmdsosikicd, SortOrder.ASC));
        List<BM_SosikiMadoguti> copyList = new ArrayList<BM_SosikiMadoguti>(pEntity);
        Collections.sort(copyList, new OrderBM_SosikiMadoguti(orders));
        return copyList;
    }

    public List<BM_SosikiMadoguti> OrderBM_SosikiMadogutiByPkDesc(List<BM_SosikiMadoguti> pEntity) {
        List<SortCondition<BM_SosikiMadoguti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_SosikiMadoguti()).sskmdsosikicd, SortOrder.DESC));
        List<BM_SosikiMadoguti> copyList = new ArrayList<BM_SosikiMadoguti>(pEntity);
        Collections.sort(copyList, new OrderBM_SosikiMadoguti(orders));
        return copyList;
    }
}
