package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_DsHonninKakuninCd;
import yuyu.def.db.meta.QMT_DsHonninKakuninCd;
import yuyu.def.direct.comparator.OrderMT_DsHonninKakuninCd;

public class SortMT_DsHonninKakuninCd {

    public List<MT_DsHonninKakuninCd> OrderMT_DsHonninKakuninCdByPkAsc(List<MT_DsHonninKakuninCd> pEntity) {
        List<SortCondition<MT_DsHonninKakuninCd>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsHonninKakuninCd()).dskokno, SortOrder.ASC));
        List<MT_DsHonninKakuninCd> copyList = new ArrayList<MT_DsHonninKakuninCd>(pEntity);
        Collections.sort(copyList, new OrderMT_DsHonninKakuninCd(orders));
        return copyList;
    }

    public List<MT_DsHonninKakuninCd> OrderMT_DsHonninKakuninCdByPkDesc(List<MT_DsHonninKakuninCd> pEntity) {
        List<SortCondition<MT_DsHonninKakuninCd>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsHonninKakuninCd()).dskokno, SortOrder.DESC));
        List<MT_DsHonninKakuninCd> copyList = new ArrayList<MT_DsHonninKakuninCd>(pEntity);
        Collections.sort(copyList, new OrderMT_DsHonninKakuninCd(orders));
        return copyList;
    }
}
