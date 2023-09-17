package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_LincKaisyacd;
import yuyu.def.db.entity.BM_LincKaisyacd;
import yuyu.def.db.meta.QBM_LincKaisyacd;

public class SortBM_LincKaisyacd {

    public List<BM_LincKaisyacd> OrderBM_LincKaisyacdByPkAsc(List<BM_LincKaisyacd> pEntity) {
        List<SortCondition<BM_LincKaisyacd>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_LincKaisyacd()).linckaisyacdnum, SortOrder.ASC));
        List<BM_LincKaisyacd> copyList = new ArrayList<BM_LincKaisyacd>(pEntity);
        Collections.sort(copyList, new OrderBM_LincKaisyacd(orders));
        return copyList;
    }

    public List<BM_LincKaisyacd> OrderBM_LincKaisyacdByPkDesc(List<BM_LincKaisyacd> pEntity) {
        List<SortCondition<BM_LincKaisyacd>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_LincKaisyacd()).linckaisyacdnum, SortOrder.DESC));
        List<BM_LincKaisyacd> copyList = new ArrayList<BM_LincKaisyacd>(pEntity);
        Collections.sort(copyList, new OrderBM_LincKaisyacd(orders));
        return copyList;
    }
}
