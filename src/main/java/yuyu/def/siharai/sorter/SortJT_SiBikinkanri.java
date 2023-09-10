package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.meta.QJT_SiBikinkanri;
import yuyu.def.siharai.comparator.OrderJT_SiBikinkanri;

public class SortJT_SiBikinkanri {

    
    public List<JT_SiBikinkanri> OrderJT_SiBikinkanriByPkAsc(List<JT_SiBikinkanri> pEntity) {
        List<SortCondition<JT_SiBikinkanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiBikinkanri()).skno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiBikinkanri()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiBikinkanri()).kessankijyunymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiBikinkanri()).bkncdkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiBikinkanri()).bknkktymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiBikinkanri()).kyuuhucd, SortOrder.ASC));
        List<JT_SiBikinkanri> copyList = new ArrayList<JT_SiBikinkanri>(pEntity);
        Collections.sort(copyList, new OrderJT_SiBikinkanri(orders));
        return copyList;
    }

    
    public List<JT_SiBikinkanri> OrderJT_SiBikinkanriByPkDesc(List<JT_SiBikinkanri> pEntity) {
        List<SortCondition<JT_SiBikinkanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiBikinkanri()).skno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiBikinkanri()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiBikinkanri()).kessankijyunymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiBikinkanri()).bkncdkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiBikinkanri()).bknkktymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiBikinkanri()).kyuuhucd, SortOrder.DESC));
        List<JT_SiBikinkanri> copyList = new ArrayList<JT_SiBikinkanri>(pEntity);
        Collections.sort(copyList, new OrderJT_SiBikinkanri(orders));
        return copyList;
    }
}
