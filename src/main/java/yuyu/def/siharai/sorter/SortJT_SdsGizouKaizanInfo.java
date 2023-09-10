package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_SdsGizouKaizanInfo;
import yuyu.def.db.meta.QJT_SdsGizouKaizanInfo;
import yuyu.def.siharai.comparator.OrderJT_SdsGizouKaizanInfo;

public class SortJT_SdsGizouKaizanInfo {

    
    public List<JT_SdsGizouKaizanInfo> OrderJT_SdsGizouKaizanInfoByPkAsc(List<JT_SdsGizouKaizanInfo> pEntity) {
        List<SortCondition<JT_SdsGizouKaizanInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SdsGizouKaizanInfo()).skno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SdsGizouKaizanInfo()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SdsGizouKaizanInfo()).seikyuurirekino, SortOrder.ASC));
        List<JT_SdsGizouKaizanInfo> copyList = new ArrayList<JT_SdsGizouKaizanInfo>(pEntity);
        Collections.sort(copyList, new OrderJT_SdsGizouKaizanInfo(orders));
        return copyList;
    }

    
    public List<JT_SdsGizouKaizanInfo> OrderJT_SdsGizouKaizanInfoByPkDesc(List<JT_SdsGizouKaizanInfo> pEntity) {
        List<SortCondition<JT_SdsGizouKaizanInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SdsGizouKaizanInfo()).skno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SdsGizouKaizanInfo()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SdsGizouKaizanInfo()).seikyuurirekino, SortOrder.DESC));
        List<JT_SdsGizouKaizanInfo> copyList = new ArrayList<JT_SdsGizouKaizanInfo>(pEntity);
        Collections.sort(copyList, new OrderJT_SdsGizouKaizanInfo(orders));
        return copyList;
    }

}

