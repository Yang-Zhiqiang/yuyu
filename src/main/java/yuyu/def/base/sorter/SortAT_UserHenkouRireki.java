package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_UserHenkouRireki;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_UserHenkouRireki;
import yuyu.def.db.meta.QAT_UserHenkouRireki;

public class SortAT_UserHenkouRireki {

    public List<AT_UserHenkouRireki> OrderAT_UserHenkouRirekiByPkAsc(List<AT_UserHenkouRireki> pEntity) {
        List<SortCondition<AT_UserHenkouRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_UserHenkouRireki()).uniqueId, SortOrder.ASC));
        List<AT_UserHenkouRireki> copyList = new ArrayList<AT_UserHenkouRireki>(pEntity);
        Collections.sort(copyList, new OrderAT_UserHenkouRireki(orders));
        return copyList;
    }

    public List<AT_UserHenkouRireki> OrderAT_UserHenkouRirekiByPkDesc(List<AT_UserHenkouRireki> pEntity) {
        List<SortCondition<AT_UserHenkouRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_UserHenkouRireki()).uniqueId, SortOrder.DESC));
        List<AT_UserHenkouRireki> copyList = new ArrayList<AT_UserHenkouRireki>(pEntity);
        Collections.sort(copyList, new OrderAT_UserHenkouRireki(orders));
        return copyList;
    }
}
