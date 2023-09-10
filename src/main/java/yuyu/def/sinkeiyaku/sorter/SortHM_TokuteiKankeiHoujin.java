package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HM_TokuteiKankeiHoujin;
import yuyu.def.db.meta.QHM_TokuteiKankeiHoujin;
import yuyu.def.sinkeiyaku.comparator.OrderHM_TokuteiKankeiHoujin;

public class SortHM_TokuteiKankeiHoujin {

    
    public List<HM_TokuteiKankeiHoujin> OrderHM_TokuteiKankeiHoujinByPkAsc(List<HM_TokuteiKankeiHoujin> pEntity) {
        List<SortCondition<HM_TokuteiKankeiHoujin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_TokuteiKankeiHoujin()).tkhjnkinyuucd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHM_TokuteiKankeiHoujin()).meisaino, SortOrder.ASC));
        List<HM_TokuteiKankeiHoujin> copyList = new ArrayList<HM_TokuteiKankeiHoujin>(pEntity);
        Collections.sort(copyList, new OrderHM_TokuteiKankeiHoujin(orders));
        return copyList;
    }

    
    public List<HM_TokuteiKankeiHoujin> OrderHM_TokuteiKankeiHoujinByPkDesc(List<HM_TokuteiKankeiHoujin> pEntity) {
        List<SortCondition<HM_TokuteiKankeiHoujin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_TokuteiKankeiHoujin()).tkhjnkinyuucd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHM_TokuteiKankeiHoujin()).meisaino, SortOrder.DESC));
        List<HM_TokuteiKankeiHoujin> copyList = new ArrayList<HM_TokuteiKankeiHoujin>(pEntity);
        Collections.sort(copyList, new OrderHM_TokuteiKankeiHoujin(orders));
        return copyList;
    }

}

