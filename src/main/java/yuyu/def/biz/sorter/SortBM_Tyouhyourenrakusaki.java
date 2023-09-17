package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_Tyouhyourenrakusaki;
import yuyu.def.db.entity.BM_Tyouhyourenrakusaki;
import yuyu.def.db.meta.QBM_Tyouhyourenrakusaki;

public class SortBM_Tyouhyourenrakusaki {

    public List<BM_Tyouhyourenrakusaki> OrderBM_TyouhyourenrakusakiByPkAsc(List<BM_Tyouhyourenrakusaki> pEntity) {
        List<SortCondition<BM_Tyouhyourenrakusaki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_Tyouhyourenrakusaki()).tyhyrenrakusikibetukbn, SortOrder.ASC));
        List<BM_Tyouhyourenrakusaki> copyList = new ArrayList<BM_Tyouhyourenrakusaki>(pEntity);
        Collections.sort(copyList, new OrderBM_Tyouhyourenrakusaki(orders));
        return copyList;
    }

    public List<BM_Tyouhyourenrakusaki> OrderBM_TyouhyourenrakusakiByPkDesc(List<BM_Tyouhyourenrakusaki> pEntity) {
        List<SortCondition<BM_Tyouhyourenrakusaki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_Tyouhyourenrakusaki()).tyhyrenrakusikibetukbn, SortOrder.DESC));
        List<BM_Tyouhyourenrakusaki> copyList = new ArrayList<BM_Tyouhyourenrakusaki>(pEntity);
        Collections.sort(copyList, new OrderBM_Tyouhyourenrakusaki(orders));
        return copyList;
    }

}

