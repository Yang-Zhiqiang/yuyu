package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkTkykHukaSeigen;
import yuyu.def.db.entity.BM_ChkTkykHukaSeigen;
import yuyu.def.db.meta.QBM_ChkTkykHukaSeigen;

public class SortBM_ChkTkykHukaSeigen {

    public List<BM_ChkTkykHukaSeigen> OrderBM_ChkTkykHukaSeigenByPkAsc(List<BM_ChkTkykHukaSeigen> pEntity) {
        List<SortCondition<BM_ChkTkykHukaSeigen>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkTkykHukaSeigen()).syusyouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkTkykHukaSeigen()).syusyouhnsdnofrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkTkykHukaSeigen()).syusyouhnsdnoto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkTkykHukaSeigen()).sntkhoukbnfrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkTkykHukaSeigen()).sntkhoukbnto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkTkykHukaSeigen()).hhknfromnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkTkykHukaSeigen()).hhkntonen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkTkykHukaSeigen()).tksyouhncd, SortOrder.ASC));
        List<BM_ChkTkykHukaSeigen> copyList = new ArrayList<BM_ChkTkykHukaSeigen>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkTkykHukaSeigen(orders));
        return copyList;
    }

    public List<BM_ChkTkykHukaSeigen> OrderBM_ChkTkykHukaSeigenByPkDesc(List<BM_ChkTkykHukaSeigen> pEntity) {
        List<SortCondition<BM_ChkTkykHukaSeigen>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkTkykHukaSeigen()).syusyouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkTkykHukaSeigen()).syusyouhnsdnofrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkTkykHukaSeigen()).syusyouhnsdnoto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkTkykHukaSeigen()).sntkhoukbnfrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkTkykHukaSeigen()).sntkhoukbnto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkTkykHukaSeigen()).hhknfromnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkTkykHukaSeigen()).hhkntonen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkTkykHukaSeigen()).tksyouhncd, SortOrder.DESC));
        List<BM_ChkTkykHukaSeigen> copyList = new ArrayList<BM_ChkTkykHukaSeigen>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkTkykHukaSeigen(orders));
        return copyList;
    }

}

