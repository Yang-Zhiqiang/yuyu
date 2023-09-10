package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_KoudosgKeizenChkInfo;
import yuyu.def.db.meta.QJT_KoudosgKeizenChkInfo;
import yuyu.def.siharai.comparator.OrderJT_KoudosgKeizenChkInfo;

public class SortJT_KoudosgKeizenChkInfo {

    
    public List<JT_KoudosgKeizenChkInfo> OrderJT_KoudosgKeizenChkInfoByPkAsc(List<JT_KoudosgKeizenChkInfo> pEntity) {
        List<SortCondition<JT_KoudosgKeizenChkInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_KoudosgKeizenChkInfo()).skno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_KoudosgKeizenChkInfo()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_KoudosgKeizenChkInfo()).seikyuurirekino, SortOrder.ASC));
        List<JT_KoudosgKeizenChkInfo> copyList = new ArrayList<JT_KoudosgKeizenChkInfo>(pEntity);
        Collections.sort(copyList, new OrderJT_KoudosgKeizenChkInfo(orders));
        return copyList;
    }

    
    public List<JT_KoudosgKeizenChkInfo> OrderJT_KoudosgKeizenChkInfoByPkDesc(List<JT_KoudosgKeizenChkInfo> pEntity) {
        List<SortCondition<JT_KoudosgKeizenChkInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_KoudosgKeizenChkInfo()).skno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_KoudosgKeizenChkInfo()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_KoudosgKeizenChkInfo()).seikyuurirekino, SortOrder.DESC));
        List<JT_KoudosgKeizenChkInfo> copyList = new ArrayList<JT_KoudosgKeizenChkInfo>(pEntity);
        Collections.sort(copyList, new OrderJT_KoudosgKeizenChkInfo(orders));
        return copyList;
    }

}

