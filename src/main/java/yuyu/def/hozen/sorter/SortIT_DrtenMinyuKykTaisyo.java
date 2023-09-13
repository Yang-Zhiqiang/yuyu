package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_DrtenMinyuKykTaisyo;
import yuyu.def.db.meta.QIT_DrtenMinyuKykTaisyo;
import yuyu.def.hozen.comparator.OrderIT_DrtenMinyuKykTaisyo;

public class SortIT_DrtenMinyuKykTaisyo {

    public List<IT_DrtenMinyuKykTaisyo> OrderIT_DrtenMinyuKykTaisyoByPkAsc(List<IT_DrtenMinyuKykTaisyo> pEntity) {
        List<SortCondition<IT_DrtenMinyuKykTaisyo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_DrtenMinyuKykTaisyo()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_DrtenMinyuKykTaisyo()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_DrtenMinyuKykTaisyo()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_DrtenMinyuKykTaisyo()).minyuutrrenno, SortOrder.ASC));
        List<IT_DrtenMinyuKykTaisyo> copyList = new ArrayList<IT_DrtenMinyuKykTaisyo>(pEntity);
        Collections.sort(copyList, new OrderIT_DrtenMinyuKykTaisyo(orders));
        return copyList;
    }

    public List<IT_DrtenMinyuKykTaisyo> OrderIT_DrtenMinyuKykTaisyoByPkDesc(List<IT_DrtenMinyuKykTaisyo> pEntity) {
        List<SortCondition<IT_DrtenMinyuKykTaisyo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_DrtenMinyuKykTaisyo()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_DrtenMinyuKykTaisyo()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_DrtenMinyuKykTaisyo()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_DrtenMinyuKykTaisyo()).minyuutrrenno, SortOrder.DESC));
        List<IT_DrtenMinyuKykTaisyo> copyList = new ArrayList<IT_DrtenMinyuKykTaisyo>(pEntity);
        Collections.sort(copyList, new OrderIT_DrtenMinyuKykTaisyo(orders));
        return copyList;
    }
}
