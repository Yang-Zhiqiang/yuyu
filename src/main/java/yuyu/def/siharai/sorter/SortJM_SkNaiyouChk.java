package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JM_SkNaiyouChk;
import yuyu.def.db.meta.QJM_SkNaiyouChk;
import yuyu.def.siharai.comparator.OrderJM_SkNaiyouChk;

public class SortJM_SkNaiyouChk {

    
    public List<JM_SkNaiyouChk> OrderJM_SkNaiyouChkByPkAsc(List<JM_SkNaiyouChk> pEntity) {
        List<SortCondition<JM_SkNaiyouChk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJM_SkNaiyouChk()).sknaiyouchkkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJM_SkNaiyouChk()).yobidasimototaskkbn, SortOrder.ASC));
        List<JM_SkNaiyouChk> copyList = new ArrayList<JM_SkNaiyouChk>(pEntity);
        Collections.sort(copyList, new OrderJM_SkNaiyouChk(orders));
        return copyList;
    }

    
    public List<JM_SkNaiyouChk> OrderJM_SkNaiyouChkByPkDesc(List<JM_SkNaiyouChk> pEntity) {
        List<SortCondition<JM_SkNaiyouChk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJM_SkNaiyouChk()).sknaiyouchkkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJM_SkNaiyouChk()).yobidasimototaskkbn, SortOrder.DESC));
        List<JM_SkNaiyouChk> copyList = new ArrayList<JM_SkNaiyouChk>(pEntity);
        Collections.sort(copyList, new OrderJM_SkNaiyouChk(orders));
        return copyList;
    }

}

