package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_BAK_DsSoukinyouKouza;
import yuyu.def.db.meta.QMT_BAK_DsSoukinyouKouza;
import yuyu.def.direct.comparator.OrderMT_BAK_DsSoukinyouKouza;

public class SortMT_BAK_DsSoukinyouKouza {

    public List<MT_BAK_DsSoukinyouKouza> OrderMT_BAK_DsSoukinyouKouzaByPkAsc(List<MT_BAK_DsSoukinyouKouza> pEntity) {
        List<SortCondition<MT_BAK_DsSoukinyouKouza>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_BAK_DsSoukinyouKouza()).dskokno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_BAK_DsSoukinyouKouza()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_BAK_DsSoukinyouKouza()).kzsyuruikbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_BAK_DsSoukinyouKouza()).trkssikibetukey, SortOrder.ASC));
        List<MT_BAK_DsSoukinyouKouza> copyList = new ArrayList<MT_BAK_DsSoukinyouKouza>(pEntity);
        Collections.sort(copyList, new OrderMT_BAK_DsSoukinyouKouza(orders));
        return copyList;
    }

    public List<MT_BAK_DsSoukinyouKouza> OrderMT_BAK_DsSoukinyouKouzaByPkDesc(List<MT_BAK_DsSoukinyouKouza> pEntity) {
        List<SortCondition<MT_BAK_DsSoukinyouKouza>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_BAK_DsSoukinyouKouza()).dskokno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_BAK_DsSoukinyouKouza()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_BAK_DsSoukinyouKouza()).kzsyuruikbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_BAK_DsSoukinyouKouza()).trkssikibetukey, SortOrder.DESC));
        List<MT_BAK_DsSoukinyouKouza> copyList = new ArrayList<MT_BAK_DsSoukinyouKouza>(pEntity);
        Collections.sort(copyList, new OrderMT_BAK_DsSoukinyouKouza(orders));
        return copyList;
    }
}
