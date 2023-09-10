package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HM_SiinBunrui;
import yuyu.def.db.meta.QHM_SiinBunrui;
import yuyu.def.sinkeiyaku.comparator.OrderHM_SiinBunrui;

public class SortHM_SiinBunrui {

    
    public List<HM_SiinBunrui> OrderHM_SiinBunruiByPkAsc(List<HM_SiinBunrui> pEntity) {
        List<SortCondition<HM_SiinBunrui>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_SiinBunrui()).siincd, SortOrder.ASC));
        List<HM_SiinBunrui> copyList = new ArrayList<HM_SiinBunrui>(pEntity);
        Collections.sort(copyList, new OrderHM_SiinBunrui(orders));
        return copyList;
    }

    
    public List<HM_SiinBunrui> OrderHM_SiinBunruiByPkDesc(List<HM_SiinBunrui> pEntity) {
        List<SortCondition<HM_SiinBunrui>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_SiinBunrui()).siincd, SortOrder.DESC));
        List<HM_SiinBunrui> copyList = new ArrayList<HM_SiinBunrui>(pEntity);
        Collections.sort(copyList, new OrderHM_SiinBunrui(orders));
        return copyList;
    }

}

