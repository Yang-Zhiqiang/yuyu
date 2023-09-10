package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_MosMikakuteiJyouhouKanri;
import yuyu.def.db.meta.QHT_MosMikakuteiJyouhouKanri;
import yuyu.def.sinkeiyaku.comparator.OrderHT_MosMikakuteiJyouhouKanri;

public class SortHT_MosMikakuteiJyouhouKanri {

    
    public List<HT_MosMikakuteiJyouhouKanri> OrderHT_MosMikakuteiJyouhouKanriByPkAsc(List<HT_MosMikakuteiJyouhouKanri> pEntity) {
        List<SortCondition<HT_MosMikakuteiJyouhouKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_MosMikakuteiJyouhouKanri()).mosno, SortOrder.ASC));
        List<HT_MosMikakuteiJyouhouKanri> copyList = new ArrayList<HT_MosMikakuteiJyouhouKanri>(pEntity);
        Collections.sort(copyList, new OrderHT_MosMikakuteiJyouhouKanri(orders));
        return copyList;
    }

    
    public List<HT_MosMikakuteiJyouhouKanri> OrderHT_MosMikakuteiJyouhouKanriByPkDesc(List<HT_MosMikakuteiJyouhouKanri> pEntity) {
        List<SortCondition<HT_MosMikakuteiJyouhouKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_MosMikakuteiJyouhouKanri()).mosno, SortOrder.DESC));
        List<HT_MosMikakuteiJyouhouKanri> copyList = new ArrayList<HT_MosMikakuteiJyouhouKanri>(pEntity);
        Collections.sort(copyList, new OrderHT_MosMikakuteiJyouhouKanri(orders));
        return copyList;
    }

}

