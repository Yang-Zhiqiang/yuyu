package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_DsHanyouKokyakuateTuuti;
import yuyu.def.db.meta.QMT_DsHanyouKokyakuateTuuti;
import yuyu.def.direct.comparator.OrderMT_DsHanyouKokyakuateTuuti;

public class SortMT_DsHanyouKokyakuateTuuti {

    public List<MT_DsHanyouKokyakuateTuuti> OrderMT_DsHanyouKokyakuateTuutiByPkAsc(List<MT_DsHanyouKokyakuateTuuti> pEntity) {
        List<SortCondition<MT_DsHanyouKokyakuateTuuti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsHanyouKokyakuateTuuti()).dsdatasakuseiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_DsHanyouKokyakuateTuuti()).dskokno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_DsHanyouKokyakuateTuuti()).dshanyoukokyakuatetuutikbn, SortOrder.ASC));
        List<MT_DsHanyouKokyakuateTuuti> copyList = new ArrayList<MT_DsHanyouKokyakuateTuuti>(pEntity);
        Collections.sort(copyList, new OrderMT_DsHanyouKokyakuateTuuti(orders));
        return copyList;
    }

    public List<MT_DsHanyouKokyakuateTuuti> OrderMT_DsHanyouKokyakuateTuutiByPkDesc(List<MT_DsHanyouKokyakuateTuuti> pEntity) {
        List<SortCondition<MT_DsHanyouKokyakuateTuuti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsHanyouKokyakuateTuuti()).dsdatasakuseiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_DsHanyouKokyakuateTuuti()).dskokno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_DsHanyouKokyakuateTuuti()).dshanyoukokyakuatetuutikbn, SortOrder.DESC));
        List<MT_DsHanyouKokyakuateTuuti> copyList = new ArrayList<MT_DsHanyouKokyakuateTuuti>(pEntity);
        Collections.sort(copyList, new OrderMT_DsHanyouKokyakuateTuuti(orders));
        return copyList;
    }
}
