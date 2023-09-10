package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_SateiKaijyoInfo;
import yuyu.def.db.meta.QJT_SateiKaijyoInfo;
import yuyu.def.siharai.comparator.OrderJT_SateiKaijyoInfo;

public class SortJT_SateiKaijyoInfo {

    
    public List<JT_SateiKaijyoInfo> OrderJT_SateiKaijyoInfoByPkAsc(List<JT_SateiKaijyoInfo> pEntity) {
        List<SortCondition<JT_SateiKaijyoInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SateiKaijyoInfo()).skno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SateiKaijyoInfo()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SateiKaijyoInfo()).seikyuurirekino, SortOrder.ASC));
        List<JT_SateiKaijyoInfo> copyList = new ArrayList<JT_SateiKaijyoInfo>(pEntity);
        Collections.sort(copyList, new OrderJT_SateiKaijyoInfo(orders));
        return copyList;
    }

    
    public List<JT_SateiKaijyoInfo> OrderJT_SateiKaijyoInfoByPkDesc(List<JT_SateiKaijyoInfo> pEntity) {
        List<SortCondition<JT_SateiKaijyoInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SateiKaijyoInfo()).skno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SateiKaijyoInfo()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SateiKaijyoInfo()).seikyuurirekino, SortOrder.DESC));
        List<JT_SateiKaijyoInfo> copyList = new ArrayList<JT_SateiKaijyoInfo>(pEntity);
        Collections.sort(copyList, new OrderJT_SateiKaijyoInfo(orders));
        return copyList;
    }

}

