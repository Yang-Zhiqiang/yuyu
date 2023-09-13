package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KoujyoSymSougou;
import yuyu.def.db.meta.QIT_KoujyoSymSougou;
import yuyu.def.hozen.comparator.OrderIT_KoujyoSymSougou;

public class SortIT_KoujyoSymSougou {

    public List<IT_KoujyoSymSougou> OrderIT_KoujyoSymSougouByPkAsc(List<IT_KoujyoSymSougou> pEntity) {
        List<SortCondition<IT_KoujyoSymSougou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KoujyoSymSougou()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KoujyoSymSougou()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KoujyoSymSougou()).nendo, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KoujyoSymSougou()).tyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KoujyoSymSougou()).renno, SortOrder.ASC));
        List<IT_KoujyoSymSougou> copyList = new ArrayList<IT_KoujyoSymSougou>(pEntity);
        Collections.sort(copyList, new OrderIT_KoujyoSymSougou(orders));
        return copyList;
    }

    public List<IT_KoujyoSymSougou> OrderIT_KoujyoSymSougouByPkDesc(List<IT_KoujyoSymSougou> pEntity) {
        List<SortCondition<IT_KoujyoSymSougou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KoujyoSymSougou()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KoujyoSymSougou()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KoujyoSymSougou()).nendo, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KoujyoSymSougou()).tyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KoujyoSymSougou()).renno, SortOrder.DESC));
        List<IT_KoujyoSymSougou> copyList = new ArrayList<IT_KoujyoSymSougou>(pEntity);
        Collections.sort(copyList, new OrderIT_KoujyoSymSougou(orders));
        return copyList;
    }

}

