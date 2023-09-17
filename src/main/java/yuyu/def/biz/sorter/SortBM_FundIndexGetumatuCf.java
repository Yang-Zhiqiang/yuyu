package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_FundIndexGetumatuCf;
import yuyu.def.db.entity.BM_FundIndexGetumatuCf;
import yuyu.def.db.meta.QBM_FundIndexGetumatuCf;

public class SortBM_FundIndexGetumatuCf {

    public List<BM_FundIndexGetumatuCf> OrderBM_FundIndexGetumatuCfByPkAsc(List<BM_FundIndexGetumatuCf> pEntity) {
        List<SortCondition<BM_FundIndexGetumatuCf>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_FundIndexGetumatuCf()).unitfundkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_FundIndexGetumatuCf()).fundhyoukaymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_FundIndexGetumatuCf()).segkey, SortOrder.ASC));
        List<BM_FundIndexGetumatuCf> copyList = new ArrayList<BM_FundIndexGetumatuCf>(pEntity);
        Collections.sort(copyList, new OrderBM_FundIndexGetumatuCf(orders));
        return copyList;
    }

    public List<BM_FundIndexGetumatuCf> OrderBM_FundIndexGetumatuCfByPkDesc(List<BM_FundIndexGetumatuCf> pEntity) {
        List<SortCondition<BM_FundIndexGetumatuCf>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_FundIndexGetumatuCf()).unitfundkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_FundIndexGetumatuCf()).fundhyoukaymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_FundIndexGetumatuCf()).segkey, SortOrder.DESC));
        List<BM_FundIndexGetumatuCf> copyList = new ArrayList<BM_FundIndexGetumatuCf>(pEntity);
        Collections.sort(copyList, new OrderBM_FundIndexGetumatuCf(orders));
        return copyList;
    }

}

