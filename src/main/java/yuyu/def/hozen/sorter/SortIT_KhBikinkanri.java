package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.db.meta.QIT_KhBikinkanri;
import yuyu.def.hozen.comparator.OrderIT_KhBikinkanri;

public class SortIT_KhBikinkanri {

    public List<IT_KhBikinkanri> OrderIT_KhBikinkanriByPkAsc(List<IT_KhBikinkanri> pEntity) {
        List<SortCondition<IT_KhBikinkanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhBikinkanri()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhBikinkanri()).kessankijyunymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhBikinkanri()).bkncdkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhBikinkanri()).bknkktymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhBikinkanri()).renno, SortOrder.ASC));
        List<IT_KhBikinkanri> copyList = new ArrayList<IT_KhBikinkanri>(pEntity);
        Collections.sort(copyList, new OrderIT_KhBikinkanri(orders));
        return copyList;
    }

    public List<IT_KhBikinkanri> OrderIT_KhBikinkanriByPkDesc(List<IT_KhBikinkanri> pEntity) {
        List<SortCondition<IT_KhBikinkanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhBikinkanri()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhBikinkanri()).kessankijyunymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhBikinkanri()).bkncdkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhBikinkanri()).bknkktymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhBikinkanri()).renno, SortOrder.DESC));
        List<IT_KhBikinkanri> copyList = new ArrayList<IT_KhBikinkanri>(pEntity);
        Collections.sort(copyList, new OrderIT_KhBikinkanri(orders));
        return copyList;
    }
}
