package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_DsSoukinyouKouza;
import yuyu.def.db.meta.QMT_DsSoukinyouKouza;
import yuyu.def.direct.comparator.OrderMT_DsSoukinyouKouza;

public class SortMT_DsSoukinyouKouza {

    public List<MT_DsSoukinyouKouza> OrderMT_DsSoukinyouKouzaByPkAsc(List<MT_DsSoukinyouKouza> pEntity) {
        List<SortCondition<MT_DsSoukinyouKouza>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsSoukinyouKouza()).dskokno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_DsSoukinyouKouza()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_DsSoukinyouKouza()).kzsyuruikbn, SortOrder.ASC));
        List<MT_DsSoukinyouKouza> copyList = new ArrayList<MT_DsSoukinyouKouza>(pEntity);
        Collections.sort(copyList, new OrderMT_DsSoukinyouKouza(orders));
        return copyList;
    }

    public List<MT_DsSoukinyouKouza> OrderMT_DsSoukinyouKouzaByPkDesc(List<MT_DsSoukinyouKouza> pEntity) {
        List<SortCondition<MT_DsSoukinyouKouza>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsSoukinyouKouza()).dskokno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_DsSoukinyouKouza()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_DsSoukinyouKouza()).kzsyuruikbn, SortOrder.DESC));
        List<MT_DsSoukinyouKouza> copyList = new ArrayList<MT_DsSoukinyouKouza>(pEntity);
        Collections.sort(copyList, new OrderMT_DsSoukinyouKouza(orders));
        return copyList;
    }
}
