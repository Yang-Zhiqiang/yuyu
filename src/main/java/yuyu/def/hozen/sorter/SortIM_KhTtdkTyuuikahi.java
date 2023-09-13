package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IM_KhTtdkTyuuikahi;
import yuyu.def.db.meta.QIM_KhTtdkTyuuikahi;
import yuyu.def.hozen.comparator.OrderIM_KhTtdkTyuuikahi;

public class SortIM_KhTtdkTyuuikahi {

    public List<IM_KhTtdkTyuuikahi> OrderIM_KhTtdkTyuuikahiByPkAsc(List<IM_KhTtdkTyuuikahi> pEntity) {
        List<SortCondition<IM_KhTtdkTyuuikahi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIM_KhTtdkTyuuikahi()).kinouId, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIM_KhTtdkTyuuikahi()).ttdktyuuikbn, SortOrder.ASC));
        List<IM_KhTtdkTyuuikahi> copyList = new ArrayList<IM_KhTtdkTyuuikahi>(pEntity);
        Collections.sort(copyList, new OrderIM_KhTtdkTyuuikahi(orders));
        return copyList;
    }

    public List<IM_KhTtdkTyuuikahi> OrderIM_KhTtdkTyuuikahiByPkDesc(List<IM_KhTtdkTyuuikahi> pEntity) {
        List<SortCondition<IM_KhTtdkTyuuikahi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIM_KhTtdkTyuuikahi()).kinouId, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIM_KhTtdkTyuuikahi()).ttdktyuuikbn, SortOrder.DESC));
        List<IM_KhTtdkTyuuikahi> copyList = new ArrayList<IM_KhTtdkTyuuikahi>(pEntity);
        Collections.sort(copyList, new OrderIM_KhTtdkTyuuikahi(orders));
        return copyList;
    }

}

