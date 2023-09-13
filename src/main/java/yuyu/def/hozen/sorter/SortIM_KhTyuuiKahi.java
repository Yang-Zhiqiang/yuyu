package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IM_KhTyuuiKahi;
import yuyu.def.db.meta.QIM_KhTyuuiKahi;
import yuyu.def.hozen.comparator.OrderIM_KhTyuuiKahi;

public class SortIM_KhTyuuiKahi {

    public List<IM_KhTyuuiKahi> OrderIM_KhTyuuiKahiByPkAsc(List<IM_KhTyuuiKahi> pEntity) {
        List<SortCondition<IM_KhTyuuiKahi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIM_KhTyuuiKahi()).kinouId, SortOrder.ASC));
        List<IM_KhTyuuiKahi> copyList = new ArrayList<IM_KhTyuuiKahi>(pEntity);
        Collections.sort(copyList, new OrderIM_KhTyuuiKahi(orders));
        return copyList;
    }

    public List<IM_KhTyuuiKahi> OrderIM_KhTyuuiKahiByPkDesc(List<IM_KhTyuuiKahi> pEntity) {
        List<SortCondition<IM_KhTyuuiKahi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIM_KhTyuuiKahi()).kinouId, SortOrder.DESC));
        List<IM_KhTyuuiKahi> copyList = new ArrayList<IM_KhTyuuiKahi>(pEntity);
        Collections.sort(copyList, new OrderIM_KhTyuuiKahi(orders));
        return copyList;
    }

}

