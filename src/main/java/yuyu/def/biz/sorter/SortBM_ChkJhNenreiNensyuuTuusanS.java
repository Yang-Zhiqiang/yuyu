package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkJhNenreiNensyuuTuusanS;
import yuyu.def.db.entity.BM_ChkJhNenreiNensyuuTuusanS;
import yuyu.def.db.meta.QBM_ChkJhNenreiNensyuuTuusanS;

public class SortBM_ChkJhNenreiNensyuuTuusanS {

    public List<BM_ChkJhNenreiNensyuuTuusanS> OrderBM_ChkJhNenreiNensyuuTuusanSByPkAsc(List<BM_ChkJhNenreiNensyuuTuusanS> pEntity) {
        List<SortCondition<BM_ChkJhNenreiNensyuuTuusanS>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiNensyuuTuusanS()).hhknfromnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiNensyuuTuusanS()).hhkntonen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiNensyuuTuusanS()).hhknfromnensyuu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiNensyuuTuusanS()).hhkntonensyuu, SortOrder.ASC));
        List<BM_ChkJhNenreiNensyuuTuusanS> copyList = new ArrayList<BM_ChkJhNenreiNensyuuTuusanS>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkJhNenreiNensyuuTuusanS(orders));
        return copyList;
    }

    public List<BM_ChkJhNenreiNensyuuTuusanS> OrderBM_ChkJhNenreiNensyuuTuusanSByPkDesc(List<BM_ChkJhNenreiNensyuuTuusanS> pEntity) {
        List<SortCondition<BM_ChkJhNenreiNensyuuTuusanS>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiNensyuuTuusanS()).hhknfromnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiNensyuuTuusanS()).hhkntonen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiNensyuuTuusanS()).hhknfromnensyuu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhNenreiNensyuuTuusanS()).hhkntonensyuu, SortOrder.DESC));
        List<BM_ChkJhNenreiNensyuuTuusanS> copyList = new ArrayList<BM_ChkJhNenreiNensyuuTuusanS>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkJhNenreiNensyuuTuusanS(orders));
        return copyList;
    }

}

