package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KhHaitouKanri;
import yuyu.def.db.meta.QIT_BAK_KhHaitouKanri;
import yuyu.def.hozen.comparator.OrderIT_BAK_KhHaitouKanri;

public class SortIT_BAK_KhHaitouKanri {

    public List<IT_BAK_KhHaitouKanri> OrderIT_BAK_KhHaitouKanriByPkAsc(List<IT_BAK_KhHaitouKanri> pEntity) {
        List<SortCondition<IT_BAK_KhHaitouKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhHaitouKanri()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHaitouKanri()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHaitouKanri()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHaitouKanri()).haitounendo, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHaitouKanri()).renno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHaitouKanri()).haitoukinskskbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHaitouKanri()).haitoumeisaikbn, SortOrder.ASC));
        List<IT_BAK_KhHaitouKanri> copyList = new ArrayList<IT_BAK_KhHaitouKanri>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhHaitouKanri(orders));
        return copyList;
    }

    public List<IT_BAK_KhHaitouKanri> OrderIT_BAK_KhHaitouKanriByPkDesc(List<IT_BAK_KhHaitouKanri> pEntity) {
        List<SortCondition<IT_BAK_KhHaitouKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhHaitouKanri()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHaitouKanri()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHaitouKanri()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHaitouKanri()).haitounendo, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHaitouKanri()).renno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHaitouKanri()).haitoukinskskbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHaitouKanri()).haitoumeisaikbn, SortOrder.DESC));
        List<IT_BAK_KhHaitouKanri> copyList = new ArrayList<IT_BAK_KhHaitouKanri>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhHaitouKanri(orders));
        return copyList;
    }
}
