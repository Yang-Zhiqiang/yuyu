package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KoujyoSymKanri;
import yuyu.def.db.meta.QIT_BAK_KoujyoSymKanri;
import yuyu.def.hozen.comparator.OrderIT_BAK_KoujyoSymKanri;

public class SortIT_BAK_KoujyoSymKanri {

    public List<IT_BAK_KoujyoSymKanri> OrderIT_BAK_KoujyoSymKanriByPkAsc(List<IT_BAK_KoujyoSymKanri> pEntity) {
        List<SortCondition<IT_BAK_KoujyoSymKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSymKanri()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSymKanri()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSymKanri()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSymKanri()).nendo, SortOrder.ASC));
        List<IT_BAK_KoujyoSymKanri> copyList = new ArrayList<IT_BAK_KoujyoSymKanri>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KoujyoSymKanri(orders));
        return copyList;
    }

    public List<IT_BAK_KoujyoSymKanri> OrderIT_BAK_KoujyoSymKanriByPkDesc(List<IT_BAK_KoujyoSymKanri> pEntity) {
        List<SortCondition<IT_BAK_KoujyoSymKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSymKanri()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSymKanri()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSymKanri()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSymKanri()).nendo, SortOrder.DESC));
        List<IT_BAK_KoujyoSymKanri> copyList = new ArrayList<IT_BAK_KoujyoSymKanri>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KoujyoSymKanri(orders));
        return copyList;
    }

}

