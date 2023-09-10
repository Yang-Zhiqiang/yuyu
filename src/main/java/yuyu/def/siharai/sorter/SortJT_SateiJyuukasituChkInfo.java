package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_SateiJyuukasituChkInfo;
import yuyu.def.db.meta.QJT_SateiJyuukasituChkInfo;
import yuyu.def.siharai.comparator.OrderJT_SateiJyuukasituChkInfo;

public class SortJT_SateiJyuukasituChkInfo {

    
    public List<JT_SateiJyuukasituChkInfo> OrderJT_SateiJyuukasituChkInfoByPkAsc(List<JT_SateiJyuukasituChkInfo> pEntity) {
        List<SortCondition<JT_SateiJyuukasituChkInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SateiJyuukasituChkInfo()).skno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SateiJyuukasituChkInfo()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SateiJyuukasituChkInfo()).seikyuurirekino, SortOrder.ASC));
        List<JT_SateiJyuukasituChkInfo> copyList = new ArrayList<JT_SateiJyuukasituChkInfo>(pEntity);
        Collections.sort(copyList, new OrderJT_SateiJyuukasituChkInfo(orders));
        return copyList;
    }

    
    public List<JT_SateiJyuukasituChkInfo> OrderJT_SateiJyuukasituChkInfoByPkDesc(List<JT_SateiJyuukasituChkInfo> pEntity) {
        List<SortCondition<JT_SateiJyuukasituChkInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SateiJyuukasituChkInfo()).skno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SateiJyuukasituChkInfo()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SateiJyuukasituChkInfo()).seikyuurirekino, SortOrder.DESC));
        List<JT_SateiJyuukasituChkInfo> copyList = new ArrayList<JT_SateiJyuukasituChkInfo>(pEntity);
        Collections.sort(copyList, new OrderJT_SateiJyuukasituChkInfo(orders));
        return copyList;
    }
}
