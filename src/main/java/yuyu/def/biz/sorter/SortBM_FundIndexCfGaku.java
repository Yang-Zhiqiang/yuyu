package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_FundIndexCfGaku;
import yuyu.def.db.entity.BM_FundIndexCfGaku;
import yuyu.def.db.meta.QBM_FundIndexCfGaku;

public class SortBM_FundIndexCfGaku {

    public List<BM_FundIndexCfGaku> OrderBM_FundIndexCfGakuByPkAsc(List<BM_FundIndexCfGaku> pEntity) {
        List<SortCondition<BM_FundIndexCfGaku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_FundIndexCfGaku()).unitfundkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_FundIndexCfGaku()).fundhyoukaymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_FundIndexCfGaku()).segkey, SortOrder.ASC));
        List<BM_FundIndexCfGaku> copyList = new ArrayList<BM_FundIndexCfGaku>(pEntity);
        Collections.sort(copyList, new OrderBM_FundIndexCfGaku(orders));
        return copyList;
    }

    public List<BM_FundIndexCfGaku> OrderBM_FundIndexCfGakuByPkDesc(List<BM_FundIndexCfGaku> pEntity) {
        List<SortCondition<BM_FundIndexCfGaku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_FundIndexCfGaku()).unitfundkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_FundIndexCfGaku()).fundhyoukaymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_FundIndexCfGaku()).segkey, SortOrder.DESC));
        List<BM_FundIndexCfGaku> copyList = new ArrayList<BM_FundIndexCfGaku>(pEntity);
        Collections.sort(copyList, new OrderBM_FundIndexCfGaku(orders));
        return copyList;
    }

}

