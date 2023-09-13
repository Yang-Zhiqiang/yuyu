package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.def.db.meta.QIT_KhTumitateDKanri;
import yuyu.def.hozen.comparator.OrderIT_KhTumitateDKanri;

public class SortIT_KhTumitateDKanri {

    public List<IT_KhTumitateDKanri> OrderIT_KhTumitateDKanriByPkAsc(List<IT_KhTumitateDKanri> pEntity) {
        List<SortCondition<IT_KhTumitateDKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhTumitateDKanri()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhTumitateDKanri()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhTumitateDKanri()).tumitatedtumitateymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhTumitateDKanri()).renno, SortOrder.ASC));
        List<IT_KhTumitateDKanri> copyList = new ArrayList<IT_KhTumitateDKanri>(pEntity);
        Collections.sort(copyList, new OrderIT_KhTumitateDKanri(orders));
        return copyList;
    }

    public List<IT_KhTumitateDKanri> OrderIT_KhTumitateDKanriByPkDesc(List<IT_KhTumitateDKanri> pEntity) {
        List<SortCondition<IT_KhTumitateDKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhTumitateDKanri()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhTumitateDKanri()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhTumitateDKanri()).tumitatedtumitateymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhTumitateDKanri()).renno, SortOrder.DESC));
        List<IT_KhTumitateDKanri> copyList = new ArrayList<IT_KhTumitateDKanri>(pEntity);
        Collections.sort(copyList, new OrderIT_KhTumitateDKanri(orders));
        return copyList;
    }
}
