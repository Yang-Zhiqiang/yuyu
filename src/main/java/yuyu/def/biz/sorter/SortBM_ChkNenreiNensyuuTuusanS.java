package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkNenreiNensyuuTuusanS;
import yuyu.def.db.entity.BM_ChkNenreiNensyuuTuusanS;
import yuyu.def.db.meta.QBM_ChkNenreiNensyuuTuusanS;

public class SortBM_ChkNenreiNensyuuTuusanS {

    public List<BM_ChkNenreiNensyuuTuusanS> OrderBM_ChkNenreiNensyuuTuusanSByPkAsc(List<BM_ChkNenreiNensyuuTuusanS> pEntity) {
        List<SortCondition<BM_ChkNenreiNensyuuTuusanS>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkNenreiNensyuuTuusanS()).hhknfromnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiNensyuuTuusanS()).hhkntonen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiNensyuuTuusanS()).hhknfromnensyuu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiNensyuuTuusanS()).hhkntonensyuu, SortOrder.ASC));
        List<BM_ChkNenreiNensyuuTuusanS> copyList = new ArrayList<BM_ChkNenreiNensyuuTuusanS>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkNenreiNensyuuTuusanS(orders));
        return copyList;
    }

    public List<BM_ChkNenreiNensyuuTuusanS> OrderBM_ChkNenreiNensyuuTuusanSByPkDesc(List<BM_ChkNenreiNensyuuTuusanS> pEntity) {
        List<SortCondition<BM_ChkNenreiNensyuuTuusanS>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkNenreiNensyuuTuusanS()).hhknfromnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiNensyuuTuusanS()).hhkntonen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiNensyuuTuusanS()).hhknfromnensyuu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkNenreiNensyuuTuusanS()).hhkntonensyuu, SortOrder.DESC));
        List<BM_ChkNenreiNensyuuTuusanS> copyList = new ArrayList<BM_ChkNenreiNensyuuTuusanS>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkNenreiNensyuuTuusanS(orders));
        return copyList;
    }

}

