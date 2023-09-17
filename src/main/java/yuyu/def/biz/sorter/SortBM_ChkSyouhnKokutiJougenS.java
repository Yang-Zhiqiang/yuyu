package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkSyouhnKokutiJougenS;
import yuyu.def.db.entity.BM_ChkSyouhnKokutiJougenS;
import yuyu.def.db.meta.QBM_ChkSyouhnKokutiJougenS;

public class SortBM_ChkSyouhnKokutiJougenS {

    public List<BM_ChkSyouhnKokutiJougenS> OrderBM_ChkSyouhnKokutiJougenSByPkAsc(List<BM_ChkSyouhnKokutiJougenS> pEntity) {
        List<SortCondition<BM_ChkSyouhnKokutiJougenS>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkSyouhnKokutiJougenS()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSyouhnKokutiJougenS()).syusyouhnsdnofrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSyouhnKokutiJougenS()).syusyouhnsdnoto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSyouhnKokutiJougenS()).hhknfromnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSyouhnKokutiJougenS()).hhkntonen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSyouhnKokutiJougenS()).moskbnfrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSyouhnKokutiJougenS()).moskbnto, SortOrder.ASC));
        List<BM_ChkSyouhnKokutiJougenS> copyList = new ArrayList<BM_ChkSyouhnKokutiJougenS>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkSyouhnKokutiJougenS(orders));
        return copyList;
    }

    public List<BM_ChkSyouhnKokutiJougenS> OrderBM_ChkSyouhnKokutiJougenSByPkDesc(List<BM_ChkSyouhnKokutiJougenS> pEntity) {
        List<SortCondition<BM_ChkSyouhnKokutiJougenS>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkSyouhnKokutiJougenS()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSyouhnKokutiJougenS()).syusyouhnsdnofrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSyouhnKokutiJougenS()).syusyouhnsdnoto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSyouhnKokutiJougenS()).hhknfromnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSyouhnKokutiJougenS()).hhkntonen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSyouhnKokutiJougenS()).moskbnfrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSyouhnKokutiJougenS()).moskbnto, SortOrder.DESC));
        List<BM_ChkSyouhnKokutiJougenS> copyList = new ArrayList<BM_ChkSyouhnKokutiJougenS>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkSyouhnKokutiJougenS(orders));
        return copyList;
    }

}

