package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_DsHanyouKokyakuateTuuti2;
import yuyu.def.db.meta.QMT_DsHanyouKokyakuateTuuti2;
import yuyu.def.direct.comparator.OrderMT_DsHanyouKokyakuateTuuti2;

public class SortMT_DsHanyouKokyakuateTuuti2 {

    public List<MT_DsHanyouKokyakuateTuuti2> OrderMT_DsHanyouKokyakuateTuuti2ByPkAsc(List<MT_DsHanyouKokyakuateTuuti2> pEntity) {
        List<SortCondition<MT_DsHanyouKokyakuateTuuti2>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsHanyouKokyakuateTuuti2()).dsdatasakuseiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_DsHanyouKokyakuateTuuti2()).dskoktuutirenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_DsHanyouKokyakuateTuuti2()).dskokno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_DsHanyouKokyakuateTuuti2()).dshanyoukokyakuatetuutikbn, SortOrder.ASC));
        List<MT_DsHanyouKokyakuateTuuti2> copyList = new ArrayList<MT_DsHanyouKokyakuateTuuti2>(pEntity);
        Collections.sort(copyList, new OrderMT_DsHanyouKokyakuateTuuti2(orders));
        return copyList;
    }

    public List<MT_DsHanyouKokyakuateTuuti2> OrderMT_DsHanyouKokyakuateTuuti2ByPkDesc(List<MT_DsHanyouKokyakuateTuuti2> pEntity) {
        List<SortCondition<MT_DsHanyouKokyakuateTuuti2>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsHanyouKokyakuateTuuti2()).dsdatasakuseiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_DsHanyouKokyakuateTuuti2()).dskoktuutirenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_DsHanyouKokyakuateTuuti2()).dskokno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_DsHanyouKokyakuateTuuti2()).dshanyoukokyakuatetuutikbn, SortOrder.DESC));
        List<MT_DsHanyouKokyakuateTuuti2> copyList = new ArrayList<MT_DsHanyouKokyakuateTuuti2>(pEntity);
        Collections.sort(copyList, new OrderMT_DsHanyouKokyakuateTuuti2(orders));
        return copyList;
    }
}
