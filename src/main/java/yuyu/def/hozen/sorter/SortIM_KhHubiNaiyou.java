package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IM_KhHubiNaiyou;
import yuyu.def.db.meta.QIM_KhHubiNaiyou;
import yuyu.def.hozen.comparator.OrderIM_KhHubiNaiyou;

public class SortIM_KhHubiNaiyou {

    public List<IM_KhHubiNaiyou> OrderIM_KhHubiNaiyouByPkAsc(List<IM_KhHubiNaiyou> pEntity) {
        List<SortCondition<IM_KhHubiNaiyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIM_KhHubiNaiyou()).jimutetuzukicd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIM_KhHubiNaiyou()).syoruiCd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIM_KhHubiNaiyou()).hubinaiyoucd, SortOrder.ASC));
        List<IM_KhHubiNaiyou> copyList = new ArrayList<IM_KhHubiNaiyou>(pEntity);
        Collections.sort(copyList, new OrderIM_KhHubiNaiyou(orders));
        return copyList;
    }

    public List<IM_KhHubiNaiyou> OrderIM_KhHubiNaiyouByPkDesc(List<IM_KhHubiNaiyou> pEntity) {
        List<SortCondition<IM_KhHubiNaiyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIM_KhHubiNaiyou()).jimutetuzukicd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIM_KhHubiNaiyou()).syoruiCd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIM_KhHubiNaiyou()).hubinaiyoucd, SortOrder.DESC));
        List<IM_KhHubiNaiyou> copyList = new ArrayList<IM_KhHubiNaiyou>(pEntity);
        Collections.sort(copyList, new OrderIM_KhHubiNaiyou(orders));
        return copyList;
    }

    public List<IM_KhHubiNaiyou> OrderIM_KhHubiNaiyouBySyoruiCdAsc(List<IM_KhHubiNaiyou> pEntity) {
        List<SortCondition<IM_KhHubiNaiyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIM_KhHubiNaiyou()).syoruiCd, SortOrder.ASC));
        List<IM_KhHubiNaiyou> copyList = new ArrayList<IM_KhHubiNaiyou>(pEntity);
        Collections.sort(copyList, new OrderIM_KhHubiNaiyou(orders));
        return copyList;
    }
}

