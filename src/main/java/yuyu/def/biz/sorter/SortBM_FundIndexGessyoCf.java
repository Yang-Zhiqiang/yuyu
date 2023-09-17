package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_FundIndexGessyoCf;
import yuyu.def.db.entity.BM_FundIndexGessyoCf;
import yuyu.def.db.meta.QBM_FundIndexGessyoCf;

public class SortBM_FundIndexGessyoCf {

    public List<BM_FundIndexGessyoCf> OrderBM_FundIndexGessyoCfByPkAsc(List<BM_FundIndexGessyoCf> pEntity) {
        List<SortCondition<BM_FundIndexGessyoCf>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_FundIndexGessyoCf()).unitfundkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_FundIndexGessyoCf()).fundhyoukaymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_FundIndexGessyoCf()).segkey, SortOrder.ASC));
        List<BM_FundIndexGessyoCf> copyList = new ArrayList<BM_FundIndexGessyoCf>(pEntity);
        Collections.sort(copyList, new OrderBM_FundIndexGessyoCf(orders));
        return copyList;
    }

    public List<BM_FundIndexGessyoCf> OrderBM_FundIndexGessyoCfByPkDesc(List<BM_FundIndexGessyoCf> pEntity) {
        List<SortCondition<BM_FundIndexGessyoCf>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_FundIndexGessyoCf()).unitfundkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_FundIndexGessyoCf()).fundhyoukaymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_FundIndexGessyoCf()).segkey, SortOrder.DESC));
        List<BM_FundIndexGessyoCf> copyList = new ArrayList<BM_FundIndexGessyoCf>(pEntity);
        Collections.sort(copyList, new OrderBM_FundIndexGessyoCf(orders));
        return copyList;
    }

}

