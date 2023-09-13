package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IM_Syoumetukahi;
import yuyu.def.db.meta.QIM_Syoumetukahi;
import yuyu.def.hozen.comparator.OrderIM_Syoumetukahi;

public class SortIM_Syoumetukahi {

    public List<IM_Syoumetukahi> OrderIM_SyoumetukahiByPkAsc(List<IM_Syoumetukahi> pEntity) {
        List<SortCondition<IM_Syoumetukahi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIM_Syoumetukahi()).kinouId, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIM_Syoumetukahi()).syoumetujiyuu, SortOrder.ASC));
        List<IM_Syoumetukahi> copyList = new ArrayList<IM_Syoumetukahi>(pEntity);
        Collections.sort(copyList, new OrderIM_Syoumetukahi(orders));
        return copyList;
    }

    public List<IM_Syoumetukahi> OrderIM_SyoumetukahiByPkDesc(List<IM_Syoumetukahi> pEntity) {
        List<SortCondition<IM_Syoumetukahi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIM_Syoumetukahi()).kinouId, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIM_Syoumetukahi()).syoumetujiyuu, SortOrder.DESC));
        List<IM_Syoumetukahi> copyList = new ArrayList<IM_Syoumetukahi>(pEntity);
        Collections.sort(copyList, new OrderIM_Syoumetukahi(orders));
        return copyList;
    }

}

