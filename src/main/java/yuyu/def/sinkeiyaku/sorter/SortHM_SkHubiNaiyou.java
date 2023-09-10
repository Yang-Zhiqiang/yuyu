package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HM_SkHubiNaiyou;
import yuyu.def.db.meta.QHM_SkHubiNaiyou;
import yuyu.def.sinkeiyaku.comparator.OrderHM_SkHubiNaiyou;

public class SortHM_SkHubiNaiyou {

    
    public List<HM_SkHubiNaiyou> OrderHM_SkHubiNaiyouByPkAsc(List<HM_SkHubiNaiyou> pEntity) {
        List<SortCondition<HM_SkHubiNaiyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_SkHubiNaiyou()).skhubikoumokucd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHM_SkHubiNaiyou()).skhubinaiyoucd, SortOrder.ASC));
        List<HM_SkHubiNaiyou> copyList = new ArrayList<HM_SkHubiNaiyou>(pEntity);
        Collections.sort(copyList, new OrderHM_SkHubiNaiyou(orders));
        return copyList;
    }

    
    public List<HM_SkHubiNaiyou> OrderHM_SkHubiNaiyouByPkDesc(List<HM_SkHubiNaiyou> pEntity) {
        List<SortCondition<HM_SkHubiNaiyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_SkHubiNaiyou()).skhubikoumokucd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHM_SkHubiNaiyou()).skhubinaiyoucd, SortOrder.DESC));
        List<HM_SkHubiNaiyou> copyList = new ArrayList<HM_SkHubiNaiyou>(pEntity);
        Collections.sort(copyList, new OrderHM_SkHubiNaiyou(orders));
        return copyList;
    }
    
    public List<HM_SkHubiNaiyou> OrderHM_SkHubiNaiyouByHyoujijyunAsc(List<HM_SkHubiNaiyou> pEntity) {
        List<SortCondition<HM_SkHubiNaiyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_SkHubiNaiyou()).hyoujijyun, SortOrder.ASC));
        List<HM_SkHubiNaiyou> copyList = new ArrayList<HM_SkHubiNaiyou>(pEntity);
        Collections.sort(copyList, new OrderHM_SkHubiNaiyou(orders));
        return copyList;
    }


}

