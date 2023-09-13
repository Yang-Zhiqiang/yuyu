package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_SyuunouKanri;
import yuyu.def.db.meta.QIT_SyuunouKanri;
import yuyu.def.hozen.comparator.OrderIT_SyuunouKanri;

public class SortIT_SyuunouKanri {

    public List<IT_SyuunouKanri> OrderIT_SyuunouKanriByPkAsc(List<IT_SyuunouKanri> pEntity) {
        List<SortCondition<IT_SyuunouKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_SyuunouKanri()).syuudaikocd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_SyuunouKanri()).hurikaeymd, SortOrder.ASC));
        List<IT_SyuunouKanri> copyList = new ArrayList<IT_SyuunouKanri>(pEntity);
        Collections.sort(copyList, new OrderIT_SyuunouKanri(orders));
        return copyList;
    }

    public List<IT_SyuunouKanri> OrderIT_SyuunouKanriByPkDesc(List<IT_SyuunouKanri> pEntity) {
        List<SortCondition<IT_SyuunouKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_SyuunouKanri()).syuudaikocd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_SyuunouKanri()).hurikaeymd, SortOrder.DESC));
        List<IT_SyuunouKanri> copyList = new ArrayList<IT_SyuunouKanri>(pEntity);
        Collections.sort(copyList, new OrderIT_SyuunouKanri(orders));
        return copyList;
    }

}

