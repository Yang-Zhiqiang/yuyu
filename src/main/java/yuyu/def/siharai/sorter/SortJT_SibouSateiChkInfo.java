package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_SibouSateiChkInfo;
import yuyu.def.db.meta.QJT_SibouSateiChkInfo;
import yuyu.def.siharai.comparator.OrderJT_SibouSateiChkInfo;

public class SortJT_SibouSateiChkInfo {

    
    public List<JT_SibouSateiChkInfo> OrderJT_SibouSateiChkInfoByPkAsc(List<JT_SibouSateiChkInfo> pEntity) {
        List<SortCondition<JT_SibouSateiChkInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SibouSateiChkInfo()).skno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SibouSateiChkInfo()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SibouSateiChkInfo()).seikyuurirekino, SortOrder.ASC));
        List<JT_SibouSateiChkInfo> copyList = new ArrayList<JT_SibouSateiChkInfo>(pEntity);
        Collections.sort(copyList, new OrderJT_SibouSateiChkInfo(orders));
        return copyList;
    }

    
    public List<JT_SibouSateiChkInfo> OrderJT_SibouSateiChkInfoByPkDesc(List<JT_SibouSateiChkInfo> pEntity) {
        List<SortCondition<JT_SibouSateiChkInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SibouSateiChkInfo()).skno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SibouSateiChkInfo()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SibouSateiChkInfo()).seikyuurirekino, SortOrder.DESC));
        List<JT_SibouSateiChkInfo> copyList = new ArrayList<JT_SibouSateiChkInfo>(pEntity);
        Collections.sort(copyList, new OrderJT_SibouSateiChkInfo(orders));
        return copyList;
    }

}

