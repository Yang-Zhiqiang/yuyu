package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.meta.QHT_DakuhiKettei;
import yuyu.def.sinkeiyaku.comparator.OrderHT_DakuhiKettei;

public class SortHT_DakuhiKettei {

    
    public List<HT_DakuhiKettei> OrderHT_DakuhiKetteiByPkAsc(List<HT_DakuhiKettei> pEntity) {
        List<SortCondition<HT_DakuhiKettei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_DakuhiKettei()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_DakuhiKettei()).dakuhiktrenno, SortOrder.ASC));
        List<HT_DakuhiKettei> copyList = new ArrayList<HT_DakuhiKettei>(pEntity);
        Collections.sort(copyList, new OrderHT_DakuhiKettei(orders));
        return copyList;
    }

    
    public List<HT_DakuhiKettei> OrderHT_DakuhiKetteiByPkDesc(List<HT_DakuhiKettei> pEntity) {
        List<SortCondition<HT_DakuhiKettei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_DakuhiKettei()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_DakuhiKettei()).dakuhiktrenno, SortOrder.DESC));
        List<HT_DakuhiKettei> copyList = new ArrayList<HT_DakuhiKettei>(pEntity);
        Collections.sort(copyList, new OrderHT_DakuhiKettei(orders));
        return copyList;
    }


}

