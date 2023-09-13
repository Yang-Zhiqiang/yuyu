package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IM_KhHituyouSyorui;
import yuyu.def.db.meta.QIM_KhHituyouSyorui;
import yuyu.def.hozen.comparator.OrderIM_KhHituyouSyorui;

public class SortIM_KhHituyouSyorui {

    public List<IM_KhHituyouSyorui> OrderIM_KhHituyouSyoruiByPkAsc(List<IM_KhHituyouSyorui> pEntity) {
        List<SortCondition<IM_KhHituyouSyorui>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIM_KhHituyouSyorui()).kinouId, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIM_KhHituyouSyorui()).hanteikbn1, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIM_KhHituyouSyorui()).hanteikbn2, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIM_KhHituyouSyorui()).hanteikbn3, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIM_KhHituyouSyorui()).htysrirenno, SortOrder.ASC));
        List<IM_KhHituyouSyorui> copyList = new ArrayList<IM_KhHituyouSyorui>(pEntity);
        Collections.sort(copyList, new OrderIM_KhHituyouSyorui(orders));
        return copyList;
    }

    public List<IM_KhHituyouSyorui> OrderIM_KhHituyouSyoruiByPkDesc(List<IM_KhHituyouSyorui> pEntity) {
        List<SortCondition<IM_KhHituyouSyorui>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIM_KhHituyouSyorui()).kinouId, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIM_KhHituyouSyorui()).hanteikbn1, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIM_KhHituyouSyorui()).hanteikbn2, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIM_KhHituyouSyorui()).hanteikbn3, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIM_KhHituyouSyorui()).htysrirenno, SortOrder.DESC));
        List<IM_KhHituyouSyorui> copyList = new ArrayList<IM_KhHituyouSyorui>(pEntity);
        Collections.sort(copyList, new OrderIM_KhHituyouSyorui(orders));
        return copyList;
    }

}

