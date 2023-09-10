package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JM_SiHubiNaiyou;
import yuyu.def.db.meta.QJM_SiHubiNaiyou;
import yuyu.def.siharai.comparator.OrderJM_SiHubiNaiyou;

public class SortJM_SiHubiNaiyou {

    
    public List<JM_SiHubiNaiyou> OrderJM_SiHubiNaiyouByPkAsc(List<JM_SiHubiNaiyou> pEntity) {
        List<SortCondition<JM_SiHubiNaiyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJM_SiHubiNaiyou()).jimutetuzukicd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJM_SiHubiNaiyou()).syoruiCd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJM_SiHubiNaiyou()).hubinaiyoucd, SortOrder.ASC));
        List<JM_SiHubiNaiyou> copyList = new ArrayList<JM_SiHubiNaiyou>(pEntity);
        Collections.sort(copyList, new OrderJM_SiHubiNaiyou(orders));
        return copyList;
    }

    
    public List<JM_SiHubiNaiyou> OrderJM_SiHubiNaiyouByPkDesc(List<JM_SiHubiNaiyou> pEntity) {
        List<SortCondition<JM_SiHubiNaiyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJM_SiHubiNaiyou()).jimutetuzukicd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJM_SiHubiNaiyou()).syoruiCd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJM_SiHubiNaiyou()).hubinaiyoucd, SortOrder.DESC));
        List<JM_SiHubiNaiyou> copyList = new ArrayList<JM_SiHubiNaiyou>(pEntity);
        Collections.sort(copyList, new OrderJM_SiHubiNaiyou(orders));
        return copyList;
    }
    
    public List<JM_SiHubiNaiyou> OrderJM_SiHubiNaiyouByHubinaiyoucdAsc(List<JM_SiHubiNaiyou> pEntity) {
        List<SortCondition<JM_SiHubiNaiyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJM_SiHubiNaiyou()).hubinaiyoucd, SortOrder.ASC));
        List<JM_SiHubiNaiyou> copyList = new ArrayList<JM_SiHubiNaiyou>(pEntity);
        Collections.sort(copyList, new OrderJM_SiHubiNaiyou(orders));
        return copyList;
    }


}

