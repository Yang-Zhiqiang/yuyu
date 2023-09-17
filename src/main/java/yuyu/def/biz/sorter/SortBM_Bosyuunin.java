package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_Bosyuunin;
import yuyu.def.db.entity.BM_Bosyuunin;
import yuyu.def.db.meta.QBM_Bosyuunin;

public class SortBM_Bosyuunin {

    public List<BM_Bosyuunin> OrderBM_BosyuuninByPkAsc(List<BM_Bosyuunin> pEntity) {
        List<SortCondition<BM_Bosyuunin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_Bosyuunin()).bosyuucd, SortOrder.ASC));
        List<BM_Bosyuunin> copyList = new ArrayList<BM_Bosyuunin>(pEntity);
        Collections.sort(copyList, new OrderBM_Bosyuunin(orders));
        return copyList;
    }

    public List<BM_Bosyuunin> OrderBM_BosyuuninByPkDesc(List<BM_Bosyuunin> pEntity) {
        List<SortCondition<BM_Bosyuunin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_Bosyuunin()).bosyuucd, SortOrder.DESC));
        List<BM_Bosyuunin> copyList = new ArrayList<BM_Bosyuunin>(pEntity);
        Collections.sort(copyList, new OrderBM_Bosyuunin(orders));
        return copyList;
    }

}

