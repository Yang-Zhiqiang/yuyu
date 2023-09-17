package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_FundIndexSyokitousi;
import yuyu.def.db.entity.BM_FundIndexSyokitousi;
import yuyu.def.db.meta.QBM_FundIndexSyokitousi;

public class SortBM_FundIndexSyokitousi {

    public List<BM_FundIndexSyokitousi> OrderBM_FundIndexSyokitousiByPkAsc(List<BM_FundIndexSyokitousi> pEntity) {
        List<SortCondition<BM_FundIndexSyokitousi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_FundIndexSyokitousi()).unitfundkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_FundIndexSyokitousi()).fundhyoukaymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_FundIndexSyokitousi()).segkey, SortOrder.ASC));
        List<BM_FundIndexSyokitousi> copyList = new ArrayList<BM_FundIndexSyokitousi>(pEntity);
        Collections.sort(copyList, new OrderBM_FundIndexSyokitousi(orders));
        return copyList;
    }

    public List<BM_FundIndexSyokitousi> OrderBM_FundIndexSyokitousiByPkDesc(List<BM_FundIndexSyokitousi> pEntity) {
        List<SortCondition<BM_FundIndexSyokitousi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_FundIndexSyokitousi()).unitfundkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_FundIndexSyokitousi()).fundhyoukaymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_FundIndexSyokitousi()).segkey, SortOrder.DESC));
        List<BM_FundIndexSyokitousi> copyList = new ArrayList<BM_FundIndexSyokitousi>(pEntity);
        Collections.sort(copyList, new OrderBM_FundIndexSyokitousi(orders));
        return copyList;
    }

}

