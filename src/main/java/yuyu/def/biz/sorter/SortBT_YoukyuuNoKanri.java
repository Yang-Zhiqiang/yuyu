package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_YoukyuuNoKanri;
import yuyu.def.db.entity.BT_YoukyuuNoKanri;
import yuyu.def.db.meta.QBT_YoukyuuNoKanri;

public class SortBT_YoukyuuNoKanri {

    public List<BT_YoukyuuNoKanri> OrderBT_YoukyuuNoKanriByPkAsc(List<BT_YoukyuuNoKanri> pEntity) {
        List<SortCondition<BT_YoukyuuNoKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_YoukyuuNoKanri()).youkyuuno, SortOrder.ASC));
        List<BT_YoukyuuNoKanri> copyList = new ArrayList<BT_YoukyuuNoKanri>(pEntity);
        Collections.sort(copyList, new OrderBT_YoukyuuNoKanri(orders));
        return copyList;
    }

    public List<BT_YoukyuuNoKanri> OrderBT_YoukyuuNoKanriByPkDesc(List<BT_YoukyuuNoKanri> pEntity) {
        List<SortCondition<BT_YoukyuuNoKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_YoukyuuNoKanri()).youkyuuno, SortOrder.DESC));
        List<BT_YoukyuuNoKanri> copyList = new ArrayList<BT_YoukyuuNoKanri>(pEntity);
        Collections.sort(copyList, new OrderBT_YoukyuuNoKanri(orders));
        return copyList;
    }

}

