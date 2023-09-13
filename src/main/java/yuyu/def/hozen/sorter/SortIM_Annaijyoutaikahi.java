package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IM_Annaijyoutaikahi;
import yuyu.def.db.meta.QIM_Annaijyoutaikahi;
import yuyu.def.hozen.comparator.OrderIM_Annaijyoutaikahi;

public class SortIM_Annaijyoutaikahi {

    public List<IM_Annaijyoutaikahi> OrderIM_AnnaijyoutaikahiByPkAsc(List<IM_Annaijyoutaikahi> pEntity) {
        List<SortCondition<IM_Annaijyoutaikahi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIM_Annaijyoutaikahi()).kinouId, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIM_Annaijyoutaikahi()).annaijyoutaikbn, SortOrder.ASC));
        List<IM_Annaijyoutaikahi> copyList = new ArrayList<IM_Annaijyoutaikahi>(pEntity);
        Collections.sort(copyList, new OrderIM_Annaijyoutaikahi(orders));
        return copyList;
    }

    public List<IM_Annaijyoutaikahi> OrderIM_AnnaijyoutaikahiByPkDesc(List<IM_Annaijyoutaikahi> pEntity) {
        List<SortCondition<IM_Annaijyoutaikahi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIM_Annaijyoutaikahi()).kinouId, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIM_Annaijyoutaikahi()).annaijyoutaikbn, SortOrder.DESC));
        List<IM_Annaijyoutaikahi> copyList = new ArrayList<IM_Annaijyoutaikahi>(pEntity);
        Collections.sort(copyList, new OrderIM_Annaijyoutaikahi(orders));
        return copyList;
    }

}

