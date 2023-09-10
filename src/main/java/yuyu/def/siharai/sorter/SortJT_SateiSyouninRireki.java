package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_SateiSyouninRireki;
import yuyu.def.db.meta.QJT_SateiSyouninRireki;
import yuyu.def.siharai.comparator.OrderJT_SateiSyouninRireki;

public class SortJT_SateiSyouninRireki {

    
    public List<JT_SateiSyouninRireki> OrderJT_SateiSyouninRirekiByPkAsc(List<JT_SateiSyouninRireki> pEntity) {
        List<SortCondition<JT_SateiSyouninRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SateiSyouninRireki()).skno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SateiSyouninRireki()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SateiSyouninRireki()).sateisyouninskbtkey, SortOrder.ASC));
        List<JT_SateiSyouninRireki> copyList = new ArrayList<JT_SateiSyouninRireki>(pEntity);
        Collections.sort(copyList, new OrderJT_SateiSyouninRireki(orders));
        return copyList;
    }

    
    public List<JT_SateiSyouninRireki> OrderJT_SateiSyouninRirekiByPkDesc(List<JT_SateiSyouninRireki> pEntity) {
        List<SortCondition<JT_SateiSyouninRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SateiSyouninRireki()).skno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SateiSyouninRireki()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SateiSyouninRireki()).sateisyouninskbtkey, SortOrder.DESC));
        List<JT_SateiSyouninRireki> copyList = new ArrayList<JT_SateiSyouninRireki>(pEntity);
        Collections.sort(copyList, new OrderJT_SateiSyouninRireki(orders));
        return copyList;
    }
    
    public List<JT_SateiSyouninRireki> OrderJT_SateiSyouninRirekiByGyoumuKousinTimeDesc(List<JT_SateiSyouninRireki> pEntity) {
        List<SortCondition<JT_SateiSyouninRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SateiSyouninRireki()).gyoumuKousinTime, SortOrder.DESC));
        List<JT_SateiSyouninRireki> copyList = new ArrayList<JT_SateiSyouninRireki>(pEntity);
        Collections.sort(copyList, new OrderJT_SateiSyouninRireki(orders));
        return copyList;
    }


}

