package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_DrtenMinyuKykNaiyou;
import yuyu.def.db.meta.QIT_DrtenMinyuKykNaiyou;
import yuyu.def.hozen.comparator.OrderIT_DrtenMinyuKykNaiyou;

public class SortIT_DrtenMinyuKykNaiyou {

    public List<IT_DrtenMinyuKykNaiyou> OrderIT_DrtenMinyuKykNaiyouByPkAsc(List<IT_DrtenMinyuKykNaiyou> pEntity) {
        List<SortCondition<IT_DrtenMinyuKykNaiyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_DrtenMinyuKykNaiyou()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_DrtenMinyuKykNaiyou()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_DrtenMinyuKykNaiyou()).syoriym, SortOrder.ASC));
        List<IT_DrtenMinyuKykNaiyou> copyList = new ArrayList<IT_DrtenMinyuKykNaiyou>(pEntity);
        Collections.sort(copyList, new OrderIT_DrtenMinyuKykNaiyou(orders));
        return copyList;
    }

    public List<IT_DrtenMinyuKykNaiyou> OrderIT_DrtenMinyuKykNaiyouByPkDesc(List<IT_DrtenMinyuKykNaiyou> pEntity) {
        List<SortCondition<IT_DrtenMinyuKykNaiyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_DrtenMinyuKykNaiyou()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_DrtenMinyuKykNaiyou()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_DrtenMinyuKykNaiyou()).syoriym, SortOrder.DESC));
        List<IT_DrtenMinyuKykNaiyou> copyList = new ArrayList<IT_DrtenMinyuKykNaiyou>(pEntity);
        Collections.sort(copyList, new OrderIT_DrtenMinyuKykNaiyou(orders));
        return copyList;
    }
}
