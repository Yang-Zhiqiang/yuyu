package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_FileRirekiKanri;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_FileRirekiKanri;
import yuyu.def.db.meta.QAT_FileRirekiKanri;

public class SortAT_FileRirekiKanri {

    public List<AT_FileRirekiKanri> OrderAT_FileRirekiKanriByPkAsc(List<AT_FileRirekiKanri> pEntity) {
        List<SortCondition<AT_FileRirekiKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_FileRirekiKanri()).historyId, SortOrder.ASC));
        List<AT_FileRirekiKanri> copyList = new ArrayList<AT_FileRirekiKanri>(pEntity);
        Collections.sort(copyList, new OrderAT_FileRirekiKanri(orders));
        return copyList;
    }

    public List<AT_FileRirekiKanri> OrderAT_FileRirekiKanriByPkDesc(List<AT_FileRirekiKanri> pEntity) {
        List<SortCondition<AT_FileRirekiKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_FileRirekiKanri()).historyId, SortOrder.DESC));
        List<AT_FileRirekiKanri> copyList = new ArrayList<AT_FileRirekiKanri>(pEntity);
        Collections.sort(copyList, new OrderAT_FileRirekiKanri(orders));
        return copyList;
    }
}
