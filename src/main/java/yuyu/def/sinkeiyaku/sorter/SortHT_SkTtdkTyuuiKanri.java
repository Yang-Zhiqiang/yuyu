package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_SkTtdkTyuuiKanri;
import yuyu.def.db.meta.QHT_SkTtdkTyuuiKanri;
import yuyu.def.sinkeiyaku.comparator.OrderHT_SkTtdkTyuuiKanri;

public class SortHT_SkTtdkTyuuiKanri {

    
    public List<HT_SkTtdkTyuuiKanri> OrderHT_SkTtdkTyuuiKanriByPkAsc(List<HT_SkTtdkTyuuiKanri> pEntity) {
        List<SortCondition<HT_SkTtdkTyuuiKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkTtdkTyuuiKanri()).mosno, SortOrder.ASC));
        List<HT_SkTtdkTyuuiKanri> copyList = new ArrayList<HT_SkTtdkTyuuiKanri>(pEntity);
        Collections.sort(copyList, new OrderHT_SkTtdkTyuuiKanri(orders));
        return copyList;
    }

    
    public List<HT_SkTtdkTyuuiKanri> OrderHT_SkTtdkTyuuiKanriByPkDesc(List<HT_SkTtdkTyuuiKanri> pEntity) {
        List<SortCondition<HT_SkTtdkTyuuiKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkTtdkTyuuiKanri()).mosno, SortOrder.DESC));
        List<HT_SkTtdkTyuuiKanri> copyList = new ArrayList<HT_SkTtdkTyuuiKanri>(pEntity);
        Collections.sort(copyList, new OrderHT_SkTtdkTyuuiKanri(orders));
        return copyList;
    }

}

