package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KoujyoSym;
import yuyu.def.db.meta.QIT_KoujyoSym;
import yuyu.def.hozen.comparator.OrderIT_KoujyoSym;

public class SortIT_KoujyoSym {

    public List<IT_KoujyoSym> OrderIT_KoujyoSymByPkAsc(List<IT_KoujyoSym> pEntity) {
        List<SortCondition<IT_KoujyoSym>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KoujyoSym()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KoujyoSym()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KoujyoSym()).nendo, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KoujyoSym()).tyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KoujyoSym()).renno, SortOrder.ASC));
        List<IT_KoujyoSym> copyList = new ArrayList<IT_KoujyoSym>(pEntity);
        Collections.sort(copyList, new OrderIT_KoujyoSym(orders));
        return copyList;
    }

    public List<IT_KoujyoSym> OrderIT_KoujyoSymByPkDesc(List<IT_KoujyoSym> pEntity) {
        List<SortCondition<IT_KoujyoSym>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KoujyoSym()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KoujyoSym()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KoujyoSym()).nendo, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KoujyoSym()).tyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KoujyoSym()).renno, SortOrder.DESC));
        List<IT_KoujyoSym> copyList = new ArrayList<IT_KoujyoSym>(pEntity);
        Collections.sort(copyList, new OrderIT_KoujyoSym(orders));
        return copyList;
    }

    public List<IT_KoujyoSym> OrderIT_KoujyoSymByTyouhyouymdDesc(List<IT_KoujyoSym> pEntity) {
        List<SortCondition<IT_KoujyoSym>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KoujyoSym()).tyouhyouymd, SortOrder.DESC));
        List<IT_KoujyoSym> copyList = new ArrayList<IT_KoujyoSym>(pEntity);
        Collections.sort(copyList, new OrderIT_KoujyoSym(orders));
        return copyList;
    }
}

