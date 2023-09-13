package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IM_YykIdouUktksyorikahi;
import yuyu.def.db.meta.QIM_YykIdouUktksyorikahi;
import yuyu.def.hozen.comparator.OrderIM_YykIdouUktksyorikahi;

public class SortIM_YykIdouUktksyorikahi {

    public List<IM_YykIdouUktksyorikahi> OrderIM_YykIdouUktksyorikahiByPkAsc(List<IM_YykIdouUktksyorikahi> pEntity) {
        List<SortCondition<IM_YykIdouUktksyorikahi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIM_YykIdouUktksyorikahi()).kinouId, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIM_YykIdouUktksyorikahi()).yykuktkkinouid, SortOrder.ASC));
        List<IM_YykIdouUktksyorikahi> copyList = new ArrayList<IM_YykIdouUktksyorikahi>(pEntity);
        Collections.sort(copyList, new OrderIM_YykIdouUktksyorikahi(orders));
        return copyList;
    }

    public List<IM_YykIdouUktksyorikahi> OrderIM_YykIdouUktksyorikahiByPkDesc(List<IM_YykIdouUktksyorikahi> pEntity) {
        List<SortCondition<IM_YykIdouUktksyorikahi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIM_YykIdouUktksyorikahi()).kinouId, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIM_YykIdouUktksyorikahi()).yykuktkkinouid, SortOrder.DESC));
        List<IM_YykIdouUktksyorikahi> copyList = new ArrayList<IM_YykIdouUktksyorikahi>(pEntity);
        Collections.sort(copyList, new OrderIM_YykIdouUktksyorikahi(orders));
        return copyList;
    }

}

