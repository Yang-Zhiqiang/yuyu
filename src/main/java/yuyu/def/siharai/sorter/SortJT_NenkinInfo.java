package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_NenkinInfo;
import yuyu.def.db.meta.QJT_NenkinInfo;
import yuyu.def.siharai.comparator.OrderJT_NenkinInfo;

public class SortJT_NenkinInfo {

    
    public List<JT_NenkinInfo> OrderJT_NenkinInfoByPkAsc(List<JT_NenkinInfo> pEntity) {
        List<SortCondition<JT_NenkinInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_NenkinInfo()).skno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_NenkinInfo()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_NenkinInfo()).seikyuurirekino, SortOrder.ASC));
        List<JT_NenkinInfo> copyList = new ArrayList<JT_NenkinInfo>(pEntity);
        Collections.sort(copyList, new OrderJT_NenkinInfo(orders));
        return copyList;
    }

    
    public List<JT_NenkinInfo> OrderJT_NenkinInfoByPkDesc(List<JT_NenkinInfo> pEntity) {
        List<SortCondition<JT_NenkinInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_NenkinInfo()).skno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_NenkinInfo()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_NenkinInfo()).seikyuurirekino, SortOrder.DESC));
        List<JT_NenkinInfo> copyList = new ArrayList<JT_NenkinInfo>(pEntity);
        Collections.sort(copyList, new OrderJT_NenkinInfo(orders));
        return copyList;
    }

}

