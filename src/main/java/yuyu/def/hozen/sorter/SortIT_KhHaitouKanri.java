package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.meta.QIT_KhHaitouKanri;
import yuyu.def.hozen.comparator.OrderIT_KhHaitouKanri;

public class SortIT_KhHaitouKanri {

    public List<IT_KhHaitouKanri> OrderIT_KhHaitouKanriByPkAsc(List<IT_KhHaitouKanri> pEntity) {
        List<SortCondition<IT_KhHaitouKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhHaitouKanri()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhHaitouKanri()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhHaitouKanri()).haitounendo, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhHaitouKanri()).renno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhHaitouKanri()).haitoukinskskbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhHaitouKanri()).haitoumeisaikbn, SortOrder.ASC));
        List<IT_KhHaitouKanri> copyList = new ArrayList<IT_KhHaitouKanri>(pEntity);
        Collections.sort(copyList, new OrderIT_KhHaitouKanri(orders));
        return copyList;
    }

    public List<IT_KhHaitouKanri> OrderIT_KhHaitouKanriByPkDesc(List<IT_KhHaitouKanri> pEntity) {
        List<SortCondition<IT_KhHaitouKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhHaitouKanri()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhHaitouKanri()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhHaitouKanri()).haitounendo, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhHaitouKanri()).renno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhHaitouKanri()).haitoukinskskbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhHaitouKanri()).haitoumeisaikbn, SortOrder.DESC));
        List<IT_KhHaitouKanri> copyList = new ArrayList<IT_KhHaitouKanri>(pEntity);
        Collections.sort(copyList, new OrderIT_KhHaitouKanri(orders));
        return copyList;
    }
}
