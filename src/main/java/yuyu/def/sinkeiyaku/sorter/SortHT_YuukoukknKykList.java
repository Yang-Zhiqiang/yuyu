package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_YuukoukknKykList;
import yuyu.def.db.meta.QHT_YuukoukknKykList;
import yuyu.def.sinkeiyaku.comparator.OrderHT_YuukoukknKykList;

public class SortHT_YuukoukknKykList {

    
    public List<HT_YuukoukknKykList> OrderHT_YuukoukknKykListByPkAsc(List<HT_YuukoukknKykList> pEntity) {
        List<SortCondition<HT_YuukoukknKykList>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_YuukoukknKykList()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_YuukoukknKykList()).tyouhyouymd, SortOrder.ASC));
        List<HT_YuukoukknKykList> copyList = new ArrayList<HT_YuukoukknKykList>(pEntity);
        Collections.sort(copyList, new OrderHT_YuukoukknKykList(orders));
        return copyList;
    }

    
    public List<HT_YuukoukknKykList> OrderHT_YuukoukknKykListByPkDesc(List<HT_YuukoukknKykList> pEntity) {
        List<SortCondition<HT_YuukoukknKykList>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_YuukoukknKykList()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_YuukoukknKykList()).tyouhyouymd, SortOrder.DESC));
        List<HT_YuukoukknKykList> copyList = new ArrayList<HT_YuukoukknKykList>(pEntity);
        Collections.sort(copyList, new OrderHT_YuukoukknKykList(orders));
        return copyList;
    }

}

