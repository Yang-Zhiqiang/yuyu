package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KessanZennou;
import yuyu.def.db.meta.QIT_KessanZennou;
import yuyu.def.hozen.comparator.OrderIT_KessanZennou;

public class SortIT_KessanZennou {

    public List<IT_KessanZennou> OrderIT_KessanZennouByPkAsc(List<IT_KessanZennou> pEntity) {
        List<SortCondition<IT_KessanZennou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KessanZennou()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KessanZennou()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KessanZennou()).kbnkeirisegcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KessanZennou()).zennoukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KessanZennou()).zennoutoukeilistkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KessanZennou()).zennoustartym, SortOrder.ASC));
        List<IT_KessanZennou> copyList = new ArrayList<IT_KessanZennou>(pEntity);
        Collections.sort(copyList, new OrderIT_KessanZennou(orders));
        return copyList;
    }

    public List<IT_KessanZennou> OrderIT_KessanZennouByPkDesc(List<IT_KessanZennou> pEntity) {
        List<SortCondition<IT_KessanZennou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KessanZennou()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KessanZennou()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KessanZennou()).kbnkeirisegcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KessanZennou()).zennoukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KessanZennou()).zennoutoukeilistkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KessanZennou()).zennoustartym, SortOrder.DESC));
        List<IT_KessanZennou> copyList = new ArrayList<IT_KessanZennou>(pEntity);
        Collections.sort(copyList, new OrderIT_KessanZennou(orders));
        return copyList;
    }
}
