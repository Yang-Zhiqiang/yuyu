package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IM_KhHenkouUktksyorikahi;
import yuyu.def.db.meta.QIM_KhHenkouUktksyorikahi;
import yuyu.def.hozen.comparator.OrderIM_KhHenkouUktksyorikahi;

public class SortIM_KhHenkouUktksyorikahi {

    public List<IM_KhHenkouUktksyorikahi> OrderIM_KhHenkouUktksyorikahiByPkAsc(List<IM_KhHenkouUktksyorikahi> pEntity) {
        List<SortCondition<IM_KhHenkouUktksyorikahi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIM_KhHenkouUktksyorikahi()).kinouId, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIM_KhHenkouUktksyorikahi()).uktksyorikbn, SortOrder.ASC));
        List<IM_KhHenkouUktksyorikahi> copyList = new ArrayList<IM_KhHenkouUktksyorikahi>(pEntity);
        Collections.sort(copyList, new OrderIM_KhHenkouUktksyorikahi(orders));
        return copyList;
    }

    public List<IM_KhHenkouUktksyorikahi> OrderIM_KhHenkouUktksyorikahiByPkDesc(List<IM_KhHenkouUktksyorikahi> pEntity) {
        List<SortCondition<IM_KhHenkouUktksyorikahi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIM_KhHenkouUktksyorikahi()).kinouId, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIM_KhHenkouUktksyorikahi()).uktksyorikbn, SortOrder.DESC));
        List<IM_KhHenkouUktksyorikahi> copyList = new ArrayList<IM_KhHenkouUktksyorikahi>(pEntity);
        Collections.sort(copyList, new OrderIM_KhHenkouUktksyorikahi(orders));
        return copyList;
    }
}
