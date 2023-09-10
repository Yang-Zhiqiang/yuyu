package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_BosSyouhn;
import yuyu.def.db.meta.QHT_BosSyouhn;
import yuyu.def.sinkeiyaku.comparator.OrderHT_BosSyouhn;

public class SortHT_BosSyouhn {

    
    public List<HT_BosSyouhn> OrderHT_BosSyouhnByPkAsc(List<HT_BosSyouhn> pEntity) {
        List<SortCondition<HT_BosSyouhn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_BosSyouhn()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_BosSyouhn()).syouhncd, SortOrder.ASC));
        List<HT_BosSyouhn> copyList = new ArrayList<HT_BosSyouhn>(pEntity);
        Collections.sort(copyList, new OrderHT_BosSyouhn(orders));
        return copyList;
    }

    
    public List<HT_BosSyouhn> OrderHT_BosSyouhnByPkDesc(List<HT_BosSyouhn> pEntity) {
        List<SortCondition<HT_BosSyouhn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_BosSyouhn()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_BosSyouhn()).syouhncd, SortOrder.DESC));
        List<HT_BosSyouhn> copyList = new ArrayList<HT_BosSyouhn>(pEntity);
        Collections.sort(copyList, new OrderHT_BosSyouhn(orders));
        return copyList;
    }

}

