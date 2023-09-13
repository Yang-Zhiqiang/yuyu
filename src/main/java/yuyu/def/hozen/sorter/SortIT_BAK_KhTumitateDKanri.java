package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KhTumitateDKanri;
import yuyu.def.db.meta.QIT_BAK_KhTumitateDKanri;
import yuyu.def.hozen.comparator.OrderIT_BAK_KhTumitateDKanri;

public class SortIT_BAK_KhTumitateDKanri {

    public List<IT_BAK_KhTumitateDKanri> OrderIT_BAK_KhTumitateDKanriByPkAsc(List<IT_BAK_KhTumitateDKanri> pEntity) {
        List<SortCondition<IT_BAK_KhTumitateDKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhTumitateDKanri()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhTumitateDKanri()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhTumitateDKanri()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhTumitateDKanri()).tumitatedtumitateymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhTumitateDKanri()).renno, SortOrder.ASC));
        List<IT_BAK_KhTumitateDKanri> copyList = new ArrayList<IT_BAK_KhTumitateDKanri>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhTumitateDKanri(orders));
        return copyList;
    }

    public List<IT_BAK_KhTumitateDKanri> OrderIT_BAK_KhTumitateDKanriByPkDesc(List<IT_BAK_KhTumitateDKanri> pEntity) {
        List<SortCondition<IT_BAK_KhTumitateDKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhTumitateDKanri()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhTumitateDKanri()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhTumitateDKanri()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhTumitateDKanri()).tumitatedtumitateymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhTumitateDKanri()).renno, SortOrder.DESC));
        List<IT_BAK_KhTumitateDKanri> copyList = new ArrayList<IT_BAK_KhTumitateDKanri>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhTumitateDKanri(orders));
        return copyList;
    }
}
