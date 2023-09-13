package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KoujyoSymNaiyou;
import yuyu.def.db.meta.QIT_KoujyoSymNaiyou;
import yuyu.def.hozen.comparator.OrderIT_KoujyoSymNaiyou;

public class SortIT_KoujyoSymNaiyou {

    public List<IT_KoujyoSymNaiyou> OrderIT_KoujyoSymNaiyouByPkAsc(List<IT_KoujyoSymNaiyou> pEntity) {
        List<SortCondition<IT_KoujyoSymNaiyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KoujyoSymNaiyou()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KoujyoSymNaiyou()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KoujyoSymNaiyou()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KoujyoSymNaiyou()).renno3keta, SortOrder.ASC));
        List<IT_KoujyoSymNaiyou> copyList = new ArrayList<IT_KoujyoSymNaiyou>(pEntity);
        Collections.sort(copyList, new OrderIT_KoujyoSymNaiyou(orders));
        return copyList;
    }

    public List<IT_KoujyoSymNaiyou> OrderIT_KoujyoSymNaiyouByPkDesc(List<IT_KoujyoSymNaiyou> pEntity) {
        List<SortCondition<IT_KoujyoSymNaiyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KoujyoSymNaiyou()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KoujyoSymNaiyou()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KoujyoSymNaiyou()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KoujyoSymNaiyou()).renno3keta, SortOrder.DESC));
        List<IT_KoujyoSymNaiyou> copyList = new ArrayList<IT_KoujyoSymNaiyou>(pEntity);
        Collections.sort(copyList, new OrderIT_KoujyoSymNaiyou(orders));
        return copyList;
    }

}

