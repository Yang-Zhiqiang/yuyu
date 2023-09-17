package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_TantouCd;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.db.meta.QBM_TantouCd;

public class SortBM_TantouCd {

    public List<BM_TantouCd> OrderBM_TantouCdByPkAsc(List<BM_TantouCd> pEntity) {
        List<SortCondition<BM_TantouCd>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_TantouCd()).tantocd, SortOrder.ASC));
        List<BM_TantouCd> copyList = new ArrayList<BM_TantouCd>(pEntity);
        Collections.sort(copyList, new OrderBM_TantouCd(orders));
        return copyList;
    }

    public List<BM_TantouCd> OrderBM_TantouCdByPkDesc(List<BM_TantouCd> pEntity) {
        List<SortCondition<BM_TantouCd>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_TantouCd()).tantocd, SortOrder.DESC));
        List<BM_TantouCd> copyList = new ArrayList<BM_TantouCd>(pEntity);
        Collections.sort(copyList, new OrderBM_TantouCd(orders));
        return copyList;
    }

}

