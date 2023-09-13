package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IM_Kykjyoutaikahi;
import yuyu.def.db.meta.QIM_Kykjyoutaikahi;
import yuyu.def.hozen.comparator.OrderIM_Kykjyoutaikahi;

public class SortIM_Kykjyoutaikahi {

    public List<IM_Kykjyoutaikahi> OrderIM_KykjyoutaikahiByPkAsc(List<IM_Kykjyoutaikahi> pEntity) {
        List<SortCondition<IM_Kykjyoutaikahi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIM_Kykjyoutaikahi()).kinouId, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIM_Kykjyoutaikahi()).kykjyoutai, SortOrder.ASC));
        List<IM_Kykjyoutaikahi> copyList = new ArrayList<IM_Kykjyoutaikahi>(pEntity);
        Collections.sort(copyList, new OrderIM_Kykjyoutaikahi(orders));
        return copyList;
    }

    public List<IM_Kykjyoutaikahi> OrderIM_KykjyoutaikahiByPkDesc(List<IM_Kykjyoutaikahi> pEntity) {
        List<SortCondition<IM_Kykjyoutaikahi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIM_Kykjyoutaikahi()).kinouId, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIM_Kykjyoutaikahi()).kykjyoutai, SortOrder.DESC));
        List<IM_Kykjyoutaikahi> copyList = new ArrayList<IM_Kykjyoutaikahi>(pEntity);
        Collections.sort(copyList, new OrderIM_Kykjyoutaikahi(orders));
        return copyList;
    }

}

