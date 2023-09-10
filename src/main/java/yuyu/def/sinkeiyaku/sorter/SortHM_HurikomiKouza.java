package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HM_HurikomiKouza;
import yuyu.def.db.meta.QHM_HurikomiKouza;
import yuyu.def.sinkeiyaku.comparator.OrderHM_HurikomiKouza;

public class SortHM_HurikomiKouza {

    
    public List<HM_HurikomiKouza> OrderHM_HurikomiKouzaByPkAsc(List<HM_HurikomiKouza> pEntity) {
        List<SortCondition<HM_HurikomiKouza>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_HurikomiKouza()).bankcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHM_HurikomiKouza()).sitencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHM_HurikomiKouza()).kouzano, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHM_HurikomiKouza()).tuukasyu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHM_HurikomiKouza()).hrkmirnincd, SortOrder.ASC));
        List<HM_HurikomiKouza> copyList = new ArrayList<HM_HurikomiKouza>(pEntity);
        Collections.sort(copyList, new OrderHM_HurikomiKouza(orders));
        return copyList;
    }

    
    public List<HM_HurikomiKouza> OrderHM_HurikomiKouzaByPkDesc(List<HM_HurikomiKouza> pEntity) {
        List<SortCondition<HM_HurikomiKouza>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_HurikomiKouza()).bankcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHM_HurikomiKouza()).sitencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHM_HurikomiKouza()).kouzano, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHM_HurikomiKouza()).tuukasyu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHM_HurikomiKouza()).hrkmirnincd, SortOrder.DESC));
        List<HM_HurikomiKouza> copyList = new ArrayList<HM_HurikomiKouza>(pEntity);
        Collections.sort(copyList, new OrderHM_HurikomiKouza(orders));
        return copyList;
    }

}

