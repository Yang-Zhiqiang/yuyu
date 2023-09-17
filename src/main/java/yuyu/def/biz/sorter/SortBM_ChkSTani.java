package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkSTani;
import yuyu.def.db.entity.BM_ChkSTani;
import yuyu.def.db.meta.QBM_ChkSTani;

public class SortBM_ChkSTani {

    public List<BM_ChkSTani> OrderBM_ChkSTaniByPkAsc(List<BM_ChkSTani> pEntity) {
        List<SortCondition<BM_ChkSTani>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkSTani()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSTani()).syusyouhnsdnofrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSTani()).syusyouhnsdnoto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSTani()).hhknfromnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSTani()).hhkntonen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSTani()).tuukasyu, SortOrder.ASC));
        List<BM_ChkSTani> copyList = new ArrayList<BM_ChkSTani>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkSTani(orders));
        return copyList;
    }

    public List<BM_ChkSTani> OrderBM_ChkSTaniByPkDesc(List<BM_ChkSTani> pEntity) {
        List<SortCondition<BM_ChkSTani>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkSTani()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSTani()).syusyouhnsdnofrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSTani()).syusyouhnsdnoto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSTani()).hhknfromnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSTani()).hhkntonen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSTani()).tuukasyu, SortOrder.DESC));
        List<BM_ChkSTani> copyList = new ArrayList<BM_ChkSTani>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkSTani(orders));
        return copyList;
    }
}
