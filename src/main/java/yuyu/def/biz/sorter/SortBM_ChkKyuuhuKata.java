package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkKyuuhuKata;
import yuyu.def.db.entity.BM_ChkKyuuhuKata;
import yuyu.def.db.meta.QBM_ChkKyuuhuKata;

public class SortBM_ChkKyuuhuKata {

    public List<BM_ChkKyuuhuKata> OrderBM_ChkKyuuhuKataByPkAsc(List<BM_ChkKyuuhuKata> pEntity) {
        List<SortCondition<BM_ChkKyuuhuKata>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkKyuuhuKata()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkKyuuhuKata()).syusyouhnsdnofrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkKyuuhuKata()).syusyouhnsdnoto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkKyuuhuKata()).kyhkatakbn, SortOrder.ASC));
        List<BM_ChkKyuuhuKata> copyList = new ArrayList<BM_ChkKyuuhuKata>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkKyuuhuKata(orders));
        return copyList;
    }

    public List<BM_ChkKyuuhuKata> OrderBM_ChkKyuuhuKataByPkDesc(List<BM_ChkKyuuhuKata> pEntity) {
        List<SortCondition<BM_ChkKyuuhuKata>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkKyuuhuKata()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkKyuuhuKata()).syusyouhnsdnofrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkKyuuhuKata()).syusyouhnsdnoto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkKyuuhuKata()).kyhkatakbn, SortOrder.DESC));
        List<BM_ChkKyuuhuKata> copyList = new ArrayList<BM_ChkKyuuhuKata>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkKyuuhuKata(orders));
        return copyList;
    }

}

