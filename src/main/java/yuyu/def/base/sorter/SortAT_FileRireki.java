package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_FileRireki;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_FileRireki;
import yuyu.def.db.meta.QAT_FileRireki;

public class SortAT_FileRireki {

    public List<AT_FileRireki> OrderAT_FileRirekiByPkAsc(List<AT_FileRireki> pEntity) {
        List<SortCondition<AT_FileRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_FileRireki()).uniqueId, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAT_FileRireki()).historyId, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAT_FileRireki()).tourokuTime, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAT_FileRireki()).fileNmSuffix, SortOrder.ASC));
        List<AT_FileRireki> copyList = new ArrayList<AT_FileRireki>(pEntity);
        Collections.sort(copyList, new OrderAT_FileRireki(orders));
        return copyList;
    }

    public List<AT_FileRireki> OrderAT_FileRirekiByPkDesc(List<AT_FileRireki> pEntity) {
        List<SortCondition<AT_FileRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_FileRireki()).uniqueId, SortOrder.DESC));
        orders.add(new SortCondition<>((new QAT_FileRireki()).historyId, SortOrder.DESC));
        orders.add(new SortCondition<>((new QAT_FileRireki()).tourokuTime, SortOrder.DESC));
        orders.add(new SortCondition<>((new QAT_FileRireki()).fileNmSuffix, SortOrder.DESC));
        List<AT_FileRireki> copyList = new ArrayList<AT_FileRireki>(pEntity);
        Collections.sort(copyList, new OrderAT_FileRireki(orders));
        return copyList;
    }
}
