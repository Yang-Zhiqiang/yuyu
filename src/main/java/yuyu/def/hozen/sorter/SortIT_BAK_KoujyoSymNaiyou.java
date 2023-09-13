package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KoujyoSymNaiyou;
import yuyu.def.db.meta.QIT_BAK_KoujyoSymNaiyou;
import yuyu.def.hozen.comparator.OrderIT_BAK_KoujyoSymNaiyou;

public class SortIT_BAK_KoujyoSymNaiyou {

    public List<IT_BAK_KoujyoSymNaiyou> OrderIT_BAK_KoujyoSymNaiyouByPkAsc(List<IT_BAK_KoujyoSymNaiyou> pEntity) {
        List<SortCondition<IT_BAK_KoujyoSymNaiyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSymNaiyou()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSymNaiyou()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSymNaiyou()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSymNaiyou()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSymNaiyou()).renno3keta, SortOrder.ASC));
        List<IT_BAK_KoujyoSymNaiyou> copyList = new ArrayList<IT_BAK_KoujyoSymNaiyou>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KoujyoSymNaiyou(orders));
        return copyList;
    }

    public List<IT_BAK_KoujyoSymNaiyou> OrderIT_BAK_KoujyoSymNaiyouByPkDesc(List<IT_BAK_KoujyoSymNaiyou> pEntity) {
        List<SortCondition<IT_BAK_KoujyoSymNaiyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSymNaiyou()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSymNaiyou()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSymNaiyou()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSymNaiyou()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSymNaiyou()).renno3keta, SortOrder.DESC));
        List<IT_BAK_KoujyoSymNaiyou> copyList = new ArrayList<IT_BAK_KoujyoSymNaiyou>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KoujyoSymNaiyou(orders));
        return copyList;
    }

}

