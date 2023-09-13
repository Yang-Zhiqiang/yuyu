package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IM_Syorijtkahi;
import yuyu.def.db.meta.QIM_Syorijtkahi;
import yuyu.def.hozen.comparator.OrderIM_Syorijtkahi;

public class SortIM_Syorijtkahi {

    public List<IM_Syorijtkahi> OrderIM_SyorijtkahiByPkAsc(List<IM_Syorijtkahi> pEntity) {
        List<SortCondition<IM_Syorijtkahi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIM_Syorijtkahi()).kinouId, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIM_Syorijtkahi()).syorijimuttdkcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIM_Syorijtkahi()).syoritaskid, SortOrder.ASC));
        List<IM_Syorijtkahi> copyList = new ArrayList<IM_Syorijtkahi>(pEntity);
        Collections.sort(copyList, new OrderIM_Syorijtkahi(orders));
        return copyList;
    }

    public List<IM_Syorijtkahi> OrderIM_SyorijtkahiByPkDesc(List<IM_Syorijtkahi> pEntity) {
        List<SortCondition<IM_Syorijtkahi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIM_Syorijtkahi()).kinouId, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIM_Syorijtkahi()).syorijimuttdkcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIM_Syorijtkahi()).syoritaskid, SortOrder.DESC));
        List<IM_Syorijtkahi> copyList = new ArrayList<IM_Syorijtkahi>(pEntity);
        Collections.sort(copyList, new OrderIM_Syorijtkahi(orders));
        return copyList;
    }

}

