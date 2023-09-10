package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_KoudosgSateiChkInfo;
import yuyu.def.db.meta.QJT_KoudosgSateiChkInfo;
import yuyu.def.siharai.comparator.OrderJT_KoudosgSateiChkInfo;

public class SortJT_KoudosgSateiChkInfo {

    
    public List<JT_KoudosgSateiChkInfo> OrderJT_KoudosgSateiChkInfoByPkAsc(List<JT_KoudosgSateiChkInfo> pEntity) {
        List<SortCondition<JT_KoudosgSateiChkInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_KoudosgSateiChkInfo()).skno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_KoudosgSateiChkInfo()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_KoudosgSateiChkInfo()).seikyuurirekino, SortOrder.ASC));
        List<JT_KoudosgSateiChkInfo> copyList = new ArrayList<JT_KoudosgSateiChkInfo>(pEntity);
        Collections.sort(copyList, new OrderJT_KoudosgSateiChkInfo(orders));
        return copyList;
    }

    
    public List<JT_KoudosgSateiChkInfo> OrderJT_KoudosgSateiChkInfoByPkDesc(List<JT_KoudosgSateiChkInfo> pEntity) {
        List<SortCondition<JT_KoudosgSateiChkInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_KoudosgSateiChkInfo()).skno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_KoudosgSateiChkInfo()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_KoudosgSateiChkInfo()).seikyuurirekino, SortOrder.DESC));
        List<JT_KoudosgSateiChkInfo> copyList = new ArrayList<JT_KoudosgSateiChkInfo>(pEntity);
        Collections.sort(copyList, new OrderJT_KoudosgSateiChkInfo(orders));
        return copyList;
    }

}

