package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkKokutiJougenS;
import yuyu.def.db.entity.BM_ChkKokutiJougenS;
import yuyu.def.db.meta.QBM_ChkKokutiJougenS;

public class SortBM_ChkKokutiJougenS {

    public List<BM_ChkKokutiJougenS> OrderBM_ChkKokutiJougenSByPkAsc(List<BM_ChkKokutiJougenS> pEntity) {
        List<SortCondition<BM_ChkKokutiJougenS>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkKokutiJougenS()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkKokutiJougenS()).syusyouhnsdnofrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkKokutiJougenS()).syusyouhnsdnoto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkKokutiJougenS()).hhknfromnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkKokutiJougenS()).hhkntonen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkKokutiJougenS()).moskbnfrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkKokutiJougenS()).moskbnto, SortOrder.ASC));
        List<BM_ChkKokutiJougenS> copyList = new ArrayList<BM_ChkKokutiJougenS>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkKokutiJougenS(orders));
        return copyList;
    }

    public List<BM_ChkKokutiJougenS> OrderBM_ChkKokutiJougenSByPkDesc(List<BM_ChkKokutiJougenS> pEntity) {
        List<SortCondition<BM_ChkKokutiJougenS>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkKokutiJougenS()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkKokutiJougenS()).syusyouhnsdnofrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkKokutiJougenS()).syusyouhnsdnoto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkKokutiJougenS()).hhknfromnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkKokutiJougenS()).hhkntonen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkKokutiJougenS()).moskbnfrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkKokutiJougenS()).moskbnto, SortOrder.DESC));
        List<BM_ChkKokutiJougenS> copyList = new ArrayList<BM_ChkKokutiJougenS>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkKokutiJougenS(orders));
        return copyList;
    }

}

