package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_MosMikakuteiSyorui;
import yuyu.def.db.meta.QHT_MosMikakuteiSyorui;
import yuyu.def.sinkeiyaku.comparator.OrderHT_MosMikakuteiSyorui;

public class SortHT_MosMikakuteiSyorui {

    
    public List<HT_MosMikakuteiSyorui> OrderHT_MosMikakuteiSyoruiByPkAsc(List<HT_MosMikakuteiSyorui> pEntity) {
        List<SortCondition<HT_MosMikakuteiSyorui>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_MosMikakuteiSyorui()).documentid, SortOrder.ASC));
        List<HT_MosMikakuteiSyorui> copyList = new ArrayList<HT_MosMikakuteiSyorui>(pEntity);
        Collections.sort(copyList, new OrderHT_MosMikakuteiSyorui(orders));
        return copyList;
    }

    
    public List<HT_MosMikakuteiSyorui> OrderHT_MosMikakuteiSyoruiByPkDesc(List<HT_MosMikakuteiSyorui> pEntity) {
        List<SortCondition<HT_MosMikakuteiSyorui>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_MosMikakuteiSyorui()).documentid, SortOrder.DESC));
        List<HT_MosMikakuteiSyorui> copyList = new ArrayList<HT_MosMikakuteiSyorui>(pEntity);
        Collections.sort(copyList, new OrderHT_MosMikakuteiSyorui(orders));
        return copyList;
    }

}

