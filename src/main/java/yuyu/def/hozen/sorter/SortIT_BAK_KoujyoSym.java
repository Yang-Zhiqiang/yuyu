package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KoujyoSym;
import yuyu.def.db.meta.QIT_BAK_KoujyoSym;
import yuyu.def.hozen.comparator.OrderIT_BAK_KoujyoSym;

public class SortIT_BAK_KoujyoSym {

    public List<IT_BAK_KoujyoSym> OrderIT_BAK_KoujyoSymByPkAsc(List<IT_BAK_KoujyoSym> pEntity) {
        List<SortCondition<IT_BAK_KoujyoSym>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSym()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSym()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSym()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSym()).nendo, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSym()).tyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSym()).renno, SortOrder.ASC));
        List<IT_BAK_KoujyoSym> copyList = new ArrayList<IT_BAK_KoujyoSym>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KoujyoSym(orders));
        return copyList;
    }

    public List<IT_BAK_KoujyoSym> OrderIT_BAK_KoujyoSymByPkDesc(List<IT_BAK_KoujyoSym> pEntity) {
        List<SortCondition<IT_BAK_KoujyoSym>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSym()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSym()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSym()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSym()).nendo, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSym()).tyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSym()).renno, SortOrder.DESC));
        List<IT_BAK_KoujyoSym> copyList = new ArrayList<IT_BAK_KoujyoSym>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KoujyoSym(orders));
        return copyList;
    }

}

