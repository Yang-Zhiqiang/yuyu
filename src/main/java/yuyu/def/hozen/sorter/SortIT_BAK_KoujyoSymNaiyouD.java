package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KoujyoSymNaiyouD;
import yuyu.def.db.meta.QIT_BAK_KoujyoSymNaiyouD;
import yuyu.def.hozen.comparator.OrderIT_BAK_KoujyoSymNaiyouD;

public class SortIT_BAK_KoujyoSymNaiyouD {

    public List<IT_BAK_KoujyoSymNaiyouD> OrderIT_BAK_KoujyoSymNaiyouDByPkAsc(List<IT_BAK_KoujyoSymNaiyouD> pEntity) {
        List<SortCondition<IT_BAK_KoujyoSymNaiyouD>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSymNaiyouD()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSymNaiyouD()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSymNaiyouD()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSymNaiyouD()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSymNaiyouD()).renno3keta, SortOrder.ASC));
        List<IT_BAK_KoujyoSymNaiyouD> copyList = new ArrayList<IT_BAK_KoujyoSymNaiyouD>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KoujyoSymNaiyouD(orders));
        return copyList;
    }

    public List<IT_BAK_KoujyoSymNaiyouD> OrderIT_BAK_KoujyoSymNaiyouDByPkDesc(List<IT_BAK_KoujyoSymNaiyouD> pEntity) {
        List<SortCondition<IT_BAK_KoujyoSymNaiyouD>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSymNaiyouD()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSymNaiyouD()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSymNaiyouD()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSymNaiyouD()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KoujyoSymNaiyouD()).renno3keta, SortOrder.DESC));
        List<IT_BAK_KoujyoSymNaiyouD> copyList = new ArrayList<IT_BAK_KoujyoSymNaiyouD>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KoujyoSymNaiyouD(orders));
        return copyList;
    }
}
