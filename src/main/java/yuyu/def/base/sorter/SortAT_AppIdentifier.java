package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_AppIdentifier;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_AppIdentifier;
import yuyu.def.db.meta.QAT_AppIdentifier;

public class SortAT_AppIdentifier {

    public List<AT_AppIdentifier> OrderAT_AppIdentifierByPkAsc(List<AT_AppIdentifier> pEntity) {
        List<SortCondition<AT_AppIdentifier>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_AppIdentifier()).identifier, SortOrder.ASC));
        List<AT_AppIdentifier> copyList = new ArrayList<AT_AppIdentifier>(pEntity);
        Collections.sort(copyList, new OrderAT_AppIdentifier(orders));
        return copyList;
    }

    public List<AT_AppIdentifier> OrderAT_AppIdentifierByPkDesc(List<AT_AppIdentifier> pEntity) {
        List<SortCondition<AT_AppIdentifier>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_AppIdentifier()).identifier, SortOrder.DESC));
        List<AT_AppIdentifier> copyList = new ArrayList<AT_AppIdentifier>(pEntity);
        Collections.sort(copyList, new OrderAT_AppIdentifier(orders));
        return copyList;
    }
}
