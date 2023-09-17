package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkJhNkgnsHonken;
import yuyu.def.db.entity.BM_ChkJhNkgnsHonken;
import yuyu.def.db.meta.QBM_ChkJhNkgnsHonken;

public class SortBM_ChkJhNkgnsHonken {

    public List<BM_ChkJhNkgnsHonken> OrderBM_ChkJhNkgnsHonkenByPkAsc(List<BM_ChkJhNkgnsHonken> pEntity) {
        List<SortCondition<BM_ChkJhNkgnsHonken>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkJhNkgnsHonken()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhNkgnsHonken()).syusyouhnsdnofrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhNkgnsHonken()).syusyouhnsdnoto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhNkgnsHonken()).hhknfromnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhNkgnsHonken()).hhkntonen, SortOrder.ASC));
        List<BM_ChkJhNkgnsHonken> copyList = new ArrayList<BM_ChkJhNkgnsHonken>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkJhNkgnsHonken(orders));
        return copyList;
    }

    public List<BM_ChkJhNkgnsHonken> OrderBM_ChkJhNkgnsHonkenByPkDesc(List<BM_ChkJhNkgnsHonken> pEntity) {
        List<SortCondition<BM_ChkJhNkgnsHonken>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkJhNkgnsHonken()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhNkgnsHonken()).syusyouhnsdnofrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhNkgnsHonken()).syusyouhnsdnoto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhNkgnsHonken()).hhknfromnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhNkgnsHonken()).hhkntonen, SortOrder.DESC));
        List<BM_ChkJhNkgnsHonken> copyList = new ArrayList<BM_ChkJhNkgnsHonken>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkJhNkgnsHonken(orders));
        return copyList;
    }
}
