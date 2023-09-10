package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JM_Syujyutu;
import yuyu.def.db.meta.QJM_Syujyutu;
import yuyu.def.siharai.comparator.OrderJM_Syujyutu;

public class SortJM_Syujyutu {

    
    public List<JM_Syujyutu> OrderJM_SyujyutuByPkAsc(List<JM_Syujyutu> pEntity) {
        List<SortCondition<JM_Syujyutu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJM_Syujyutu()).syujyututourokuno, SortOrder.ASC));
        List<JM_Syujyutu> copyList = new ArrayList<JM_Syujyutu>(pEntity);
        Collections.sort(copyList, new OrderJM_Syujyutu(orders));
        return copyList;
    }

    
    public List<JM_Syujyutu> OrderJM_SyujyutuByPkDesc(List<JM_Syujyutu> pEntity) {
        List<SortCondition<JM_Syujyutu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJM_Syujyutu()).syujyututourokuno, SortOrder.DESC));
        List<JM_Syujyutu> copyList = new ArrayList<JM_Syujyutu>(pEntity);
        Collections.sort(copyList, new OrderJM_Syujyutu(orders));
        return copyList;
    }

}

