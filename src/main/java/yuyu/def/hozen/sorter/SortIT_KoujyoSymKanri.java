package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KoujyoSymKanri;
import yuyu.def.db.meta.QIT_KoujyoSymKanri;
import yuyu.def.hozen.comparator.OrderIT_KoujyoSymKanri;

public class SortIT_KoujyoSymKanri {

    public List<IT_KoujyoSymKanri> OrderIT_KoujyoSymKanriByPkAsc(List<IT_KoujyoSymKanri> pEntity) {
        List<SortCondition<IT_KoujyoSymKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KoujyoSymKanri()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KoujyoSymKanri()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KoujyoSymKanri()).nendo, SortOrder.ASC));
        List<IT_KoujyoSymKanri> copyList = new ArrayList<IT_KoujyoSymKanri>(pEntity);
        Collections.sort(copyList, new OrderIT_KoujyoSymKanri(orders));
        return copyList;
    }

    public List<IT_KoujyoSymKanri> OrderIT_KoujyoSymKanriByPkDesc(List<IT_KoujyoSymKanri> pEntity) {
        List<SortCondition<IT_KoujyoSymKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KoujyoSymKanri()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KoujyoSymKanri()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KoujyoSymKanri()).nendo, SortOrder.DESC));
        List<IT_KoujyoSymKanri> copyList = new ArrayList<IT_KoujyoSymKanri>(pEntity);
        Collections.sort(copyList, new OrderIT_KoujyoSymKanri(orders));
        return copyList;
    }

}

