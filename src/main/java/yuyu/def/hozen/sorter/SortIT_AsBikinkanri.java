package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_AsBikinkanri;
import yuyu.def.db.meta.QIT_AsBikinkanri;
import yuyu.def.hozen.comparator.OrderIT_AsBikinkanri;

public class SortIT_AsBikinkanri {

    public List<IT_AsBikinkanri> OrderIT_AsBikinkanriByPkAsc(List<IT_AsBikinkanri> pEntity) {
        List<SortCondition<IT_AsBikinkanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_AsBikinkanri()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_AsBikinkanri()).kessankijyunymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_AsBikinkanri()).bkncdkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_AsBikinkanri()).bknkktymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_AsBikinkanri()).renno, SortOrder.ASC));
        List<IT_AsBikinkanri> copyList = new ArrayList<IT_AsBikinkanri>(pEntity);
        Collections.sort(copyList, new OrderIT_AsBikinkanri(orders));
        return copyList;
    }

    public List<IT_AsBikinkanri> OrderIT_AsBikinkanriByPkDesc(List<IT_AsBikinkanri> pEntity) {
        List<SortCondition<IT_AsBikinkanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_AsBikinkanri()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_AsBikinkanri()).kessankijyunymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_AsBikinkanri()).bkncdkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_AsBikinkanri()).bknkktymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_AsBikinkanri()).renno, SortOrder.DESC));
        List<IT_AsBikinkanri> copyList = new ArrayList<IT_AsBikinkanri>(pEntity);
        Collections.sort(copyList, new OrderIT_AsBikinkanri(orders));
        return copyList;
    }
}
