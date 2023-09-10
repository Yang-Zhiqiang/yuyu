package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HM_SkHubiRenrakuNaiyou;
import yuyu.def.db.meta.QHM_SkHubiRenrakuNaiyou;
import yuyu.def.sinkeiyaku.comparator.OrderHM_SkHubiRenrakuNaiyou;

public class SortHM_SkHubiRenrakuNaiyou {

    
    public List<HM_SkHubiRenrakuNaiyou> OrderHM_SkHubiRenrakuNaiyouByPkAsc(List<HM_SkHubiRenrakuNaiyou> pEntity) {
        List<SortCondition<HM_SkHubiRenrakuNaiyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_SkHubiRenrakuNaiyou()).skhubirenrakunaiyoucd, SortOrder.ASC));
        List<HM_SkHubiRenrakuNaiyou> copyList = new ArrayList<HM_SkHubiRenrakuNaiyou>(pEntity);
        Collections.sort(copyList, new OrderHM_SkHubiRenrakuNaiyou(orders));
        return copyList;
    }

    
    public List<HM_SkHubiRenrakuNaiyou> OrderHM_SkHubiRenrakuNaiyouByPkDesc(List<HM_SkHubiRenrakuNaiyou> pEntity) {
        List<SortCondition<HM_SkHubiRenrakuNaiyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_SkHubiRenrakuNaiyou()).skhubirenrakunaiyoucd, SortOrder.DESC));
        List<HM_SkHubiRenrakuNaiyou> copyList = new ArrayList<HM_SkHubiRenrakuNaiyou>(pEntity);
        Collections.sort(copyList, new OrderHM_SkHubiRenrakuNaiyou(orders));
        return copyList;
    }
}
