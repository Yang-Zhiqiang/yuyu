package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_SiTyousyo;
import yuyu.def.db.meta.QJT_SiTyousyo;
import yuyu.def.siharai.comparator.OrderJT_SiTyousyo;

public class SortJT_SiTyousyo {

    
    public List<JT_SiTyousyo> OrderJT_SiTyousyoByPkAsc(List<JT_SiTyousyo> pEntity) {
        List<SortCondition<JT_SiTyousyo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiTyousyo()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiTyousyo()).tyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiTyousyo()).shrtysyrenno, SortOrder.ASC));
        List<JT_SiTyousyo> copyList = new ArrayList<JT_SiTyousyo>(pEntity);
        Collections.sort(copyList, new OrderJT_SiTyousyo(orders));
        return copyList;
    }

    
    public List<JT_SiTyousyo> OrderJT_SiTyousyoByPkDesc(List<JT_SiTyousyo> pEntity) {
        List<SortCondition<JT_SiTyousyo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiTyousyo()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiTyousyo()).tyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiTyousyo()).shrtysyrenno, SortOrder.DESC));
        List<JT_SiTyousyo> copyList = new ArrayList<JT_SiTyousyo>(pEntity);
        Collections.sort(copyList, new OrderJT_SiTyousyo(orders));
        return copyList;
    }

}

