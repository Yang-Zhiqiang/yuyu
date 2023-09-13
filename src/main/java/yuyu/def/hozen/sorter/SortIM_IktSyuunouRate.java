package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IM_IktSyuunouRate;
import yuyu.def.db.meta.QIM_IktSyuunouRate;
import yuyu.def.hozen.comparator.OrderIM_IktSyuunouRate;

public class SortIM_IktSyuunouRate {

    public List<IM_IktSyuunouRate> OrderIM_IktSyuunouRateByPkAsc(List<IM_IktSyuunouRate> pEntity) {
        List<SortCondition<IM_IktSyuunouRate>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIM_IktSyuunouRate()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIM_IktSyuunouRate()).syouhnsdno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIM_IktSyuunouRate()).iktkaisuu, SortOrder.ASC));
        List<IM_IktSyuunouRate> copyList = new ArrayList<IM_IktSyuunouRate>(pEntity);
        Collections.sort(copyList, new OrderIM_IktSyuunouRate(orders));
        return copyList;
    }

    public List<IM_IktSyuunouRate> OrderIM_IktSyuunouRateByPkDesc(List<IM_IktSyuunouRate> pEntity) {
        List<SortCondition<IM_IktSyuunouRate>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIM_IktSyuunouRate()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIM_IktSyuunouRate()).syouhnsdno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIM_IktSyuunouRate()).iktkaisuu, SortOrder.DESC));
        List<IM_IktSyuunouRate> copyList = new ArrayList<IM_IktSyuunouRate>(pEntity);
        Collections.sort(copyList, new OrderIM_IktSyuunouRate(orders));
        return copyList;
    }

}

