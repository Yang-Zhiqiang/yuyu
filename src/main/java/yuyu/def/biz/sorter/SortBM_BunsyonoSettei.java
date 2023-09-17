package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_BunsyonoSettei;
import yuyu.def.db.entity.BM_BunsyonoSettei;
import yuyu.def.db.meta.QBM_BunsyonoSettei;

public class SortBM_BunsyonoSettei {

    public List<BM_BunsyonoSettei> OrderBM_BunsyonoSetteiByPkAsc(List<BM_BunsyonoSettei> pEntity) {
        List<SortCondition<BM_BunsyonoSettei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_BunsyonoSettei()).bunsyosyubetukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_BunsyonoSettei()).aisyoumeikbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_BunsyonoSettei()).channelcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_BunsyonoSettei()).oyadrtencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_BunsyonoSettei()).renno, SortOrder.ASC));
        List<BM_BunsyonoSettei> copyList = new ArrayList<BM_BunsyonoSettei>(pEntity);
        Collections.sort(copyList, new OrderBM_BunsyonoSettei(orders));
        return copyList;
    }

    public List<BM_BunsyonoSettei> OrderBM_BunsyonoSetteiByPkDesc(List<BM_BunsyonoSettei> pEntity) {
        List<SortCondition<BM_BunsyonoSettei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_BunsyonoSettei()).bunsyosyubetukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_BunsyonoSettei()).aisyoumeikbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_BunsyonoSettei()).channelcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_BunsyonoSettei()).oyadrtencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_BunsyonoSettei()).renno, SortOrder.DESC));
        List<BM_BunsyonoSettei> copyList = new ArrayList<BM_BunsyonoSettei>(pEntity);
        Collections.sort(copyList, new OrderBM_BunsyonoSettei(orders));
        return copyList;
    }
}
