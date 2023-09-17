package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_FundIndexKihon;
import yuyu.def.db.entity.BM_FundIndexKihon;
import yuyu.def.db.meta.QBM_FundIndexKihon;

public class SortBM_FundIndexKihon {

    public List<BM_FundIndexKihon> OrderBM_FundIndexKihonByPkAsc(List<BM_FundIndexKihon> pEntity) {
        List<SortCondition<BM_FundIndexKihon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_FundIndexKihon()).unitfundkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_FundIndexKihon()).fundhyoukaymd, SortOrder.ASC));
        List<BM_FundIndexKihon> copyList = new ArrayList<BM_FundIndexKihon>(pEntity);
        Collections.sort(copyList, new OrderBM_FundIndexKihon(orders));
        return copyList;
    }

    public List<BM_FundIndexKihon> OrderBM_FundIndexKihonByPkDesc(List<BM_FundIndexKihon> pEntity) {
        List<SortCondition<BM_FundIndexKihon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_FundIndexKihon()).unitfundkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_FundIndexKihon()).fundhyoukaymd, SortOrder.DESC));
        List<BM_FundIndexKihon> copyList = new ArrayList<BM_FundIndexKihon>(pEntity);
        Collections.sort(copyList, new OrderBM_FundIndexKihon(orders));
        return copyList;
    }

}

