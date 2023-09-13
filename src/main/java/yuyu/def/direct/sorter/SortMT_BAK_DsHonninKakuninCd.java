package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_BAK_DsHonninKakuninCd;
import yuyu.def.db.meta.QMT_BAK_DsHonninKakuninCd;
import yuyu.def.direct.comparator.OrderMT_BAK_DsHonninKakuninCd;

public class SortMT_BAK_DsHonninKakuninCd {

    public List<MT_BAK_DsHonninKakuninCd> OrderMT_BAK_DsHonninKakuninCdByPkAsc(List<MT_BAK_DsHonninKakuninCd> pEntity) {
        List<SortCondition<MT_BAK_DsHonninKakuninCd>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_BAK_DsHonninKakuninCd()).dskokno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_BAK_DsHonninKakuninCd()).trkssikibetukey, SortOrder.ASC));
        List<MT_BAK_DsHonninKakuninCd> copyList = new ArrayList<MT_BAK_DsHonninKakuninCd>(pEntity);
        Collections.sort(copyList, new OrderMT_BAK_DsHonninKakuninCd(orders));
        return copyList;
    }

    public List<MT_BAK_DsHonninKakuninCd> OrderMT_BAK_DsHonninKakuninCdByPkDesc(List<MT_BAK_DsHonninKakuninCd> pEntity) {
        List<SortCondition<MT_BAK_DsHonninKakuninCd>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_BAK_DsHonninKakuninCd()).dskokno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_BAK_DsHonninKakuninCd()).trkssikibetukey, SortOrder.DESC));
        List<MT_BAK_DsHonninKakuninCd> copyList = new ArrayList<MT_BAK_DsHonninKakuninCd>(pEntity);
        Collections.sort(copyList, new OrderMT_BAK_DsHonninKakuninCd(orders));
        return copyList;
    }
}
