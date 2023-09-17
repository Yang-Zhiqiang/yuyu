package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkKeiyakuTaniSaikouS;
import yuyu.def.db.entity.BM_ChkKeiyakuTaniSaikouS;
import yuyu.def.db.meta.QBM_ChkKeiyakuTaniSaikouS;

public class SortBM_ChkKeiyakuTaniSaikouS {

    public List<BM_ChkKeiyakuTaniSaikouS> OrderBM_ChkKeiyakuTaniSaikouSByPkAsc(List<BM_ChkKeiyakuTaniSaikouS> pEntity) {
        List<SortCondition<BM_ChkKeiyakuTaniSaikouS>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkKeiyakuTaniSaikouS()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkKeiyakuTaniSaikouS()).syusyouhnsdnofrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkKeiyakuTaniSaikouS()).syusyouhnsdnoto, SortOrder.ASC));
        List<BM_ChkKeiyakuTaniSaikouS> copyList = new ArrayList<BM_ChkKeiyakuTaniSaikouS>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkKeiyakuTaniSaikouS(orders));
        return copyList;
    }

    public List<BM_ChkKeiyakuTaniSaikouS> OrderBM_ChkKeiyakuTaniSaikouSByPkDesc(List<BM_ChkKeiyakuTaniSaikouS> pEntity) {
        List<SortCondition<BM_ChkKeiyakuTaniSaikouS>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkKeiyakuTaniSaikouS()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkKeiyakuTaniSaikouS()).syusyouhnsdnofrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkKeiyakuTaniSaikouS()).syusyouhnsdnoto, SortOrder.DESC));
        List<BM_ChkKeiyakuTaniSaikouS> copyList = new ArrayList<BM_ChkKeiyakuTaniSaikouS>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkKeiyakuTaniSaikouS(orders));
        return copyList;
    }

}

