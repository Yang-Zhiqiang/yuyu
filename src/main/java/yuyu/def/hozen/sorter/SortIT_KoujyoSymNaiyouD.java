package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KoujyoSymNaiyouD;
import yuyu.def.db.meta.QIT_KoujyoSymNaiyouD;
import yuyu.def.hozen.comparator.OrderIT_KoujyoSymNaiyouD;

public class SortIT_KoujyoSymNaiyouD {

    public List<IT_KoujyoSymNaiyouD> OrderIT_KoujyoSymNaiyouDByPkAsc(List<IT_KoujyoSymNaiyouD> pEntity) {
        List<SortCondition<IT_KoujyoSymNaiyouD>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KoujyoSymNaiyouD()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KoujyoSymNaiyouD()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KoujyoSymNaiyouD()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KoujyoSymNaiyouD()).renno3keta, SortOrder.ASC));
        List<IT_KoujyoSymNaiyouD> copyList = new ArrayList<IT_KoujyoSymNaiyouD>(pEntity);
        Collections.sort(copyList, new OrderIT_KoujyoSymNaiyouD(orders));
        return copyList;
    }

    public List<IT_KoujyoSymNaiyouD> OrderIT_KoujyoSymNaiyouDByPkDesc(List<IT_KoujyoSymNaiyouD> pEntity) {
        List<SortCondition<IT_KoujyoSymNaiyouD>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KoujyoSymNaiyouD()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KoujyoSymNaiyouD()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KoujyoSymNaiyouD()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KoujyoSymNaiyouD()).renno3keta, SortOrder.DESC));
        List<IT_KoujyoSymNaiyouD> copyList = new ArrayList<IT_KoujyoSymNaiyouD>(pEntity);
        Collections.sort(copyList, new OrderIT_KoujyoSymNaiyouD(orders));
        return copyList;
    }
}
