package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkNkgnsHonken;
import yuyu.def.db.entity.BM_ChkNkgnsHonken;
import yuyu.def.db.meta.QBM_ChkNkgnsHonken;

public class SortBM_ChkNkgnsHonken {

    public List<BM_ChkNkgnsHonken> OrderBM_ChkNkgnsHonkenByPkAsc(List<BM_ChkNkgnsHonken> pEntity) {
        List<SortCondition<BM_ChkNkgnsHonken>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkNkgnsHonken()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNkgnsHonken()).syusyouhnsdnofrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNkgnsHonken()).syusyouhnsdnoto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNkgnsHonken()).hhknfromnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNkgnsHonken()).hhkntonen, SortOrder.ASC));
        List<BM_ChkNkgnsHonken> copyList = new ArrayList<BM_ChkNkgnsHonken>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkNkgnsHonken(orders));
        return copyList;
    }

    public List<BM_ChkNkgnsHonken> OrderBM_ChkNkgnsHonkenByPkDesc(List<BM_ChkNkgnsHonken> pEntity) {
        List<SortCondition<BM_ChkNkgnsHonken>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkNkgnsHonken()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNkgnsHonken()).syusyouhnsdnofrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNkgnsHonken()).syusyouhnsdnoto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNkgnsHonken()).hhknfromnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNkgnsHonken()).hhkntonen, SortOrder.DESC));
        List<BM_ChkNkgnsHonken> copyList = new ArrayList<BM_ChkNkgnsHonken>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkNkgnsHonken(orders));
        return copyList;
    }
}
