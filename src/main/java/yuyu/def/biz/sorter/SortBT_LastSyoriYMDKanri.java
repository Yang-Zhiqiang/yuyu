package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_LastSyoriYMDKanri;
import yuyu.def.db.entity.BT_LastSyoriYMDKanri;
import yuyu.def.db.meta.QBT_LastSyoriYMDKanri;

public class SortBT_LastSyoriYMDKanri {

    public List<BT_LastSyoriYMDKanri> OrderBT_LastSyoriYMDKanriByPkAsc(List<BT_LastSyoriYMDKanri> pEntity) {
        List<SortCondition<BT_LastSyoriYMDKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_LastSyoriYMDKanri()).lastsyoriymdkanrikbn, SortOrder.ASC));
        List<BT_LastSyoriYMDKanri> copyList = new ArrayList<BT_LastSyoriYMDKanri>(pEntity);
        Collections.sort(copyList, new OrderBT_LastSyoriYMDKanri(orders));
        return copyList;
    }

    public List<BT_LastSyoriYMDKanri> OrderBT_LastSyoriYMDKanriByPkDesc(List<BT_LastSyoriYMDKanri> pEntity) {
        List<SortCondition<BT_LastSyoriYMDKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_LastSyoriYMDKanri()).lastsyoriymdkanrikbn, SortOrder.DESC));
        List<BT_LastSyoriYMDKanri> copyList = new ArrayList<BT_LastSyoriYMDKanri>(pEntity);
        Collections.sort(copyList, new OrderBT_LastSyoriYMDKanri(orders));
        return copyList;
    }

}

