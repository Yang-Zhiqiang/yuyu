package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SkCreditTourokukekkaQrTr;
import yuyu.def.db.meta.QZT_SkCreditTourokukekkaQrTr;
import yuyu.def.zdb.comparator.OrderZT_SkCreditTourokukekkaQrTr;

public class SortZT_SkCreditTourokukekkaQrTr {

    
    public List<ZT_SkCreditTourokukekkaQrTr> OrderZT_SkCreditTourokukekkaQrTrByPkAsc(List<ZT_SkCreditTourokukekkaQrTr> pEntity) {
        List<SortCondition<ZT_SkCreditTourokukekkaQrTr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkCreditTourokukekkaQrTr()).ztrsystemjyusinymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkCreditTourokukekkaQrTr()).ztrsystemjyusintime, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkCreditTourokukekkaQrTr()).ztrcreditkessaiyouno, SortOrder.ASC));
        List<ZT_SkCreditTourokukekkaQrTr> copyList = new ArrayList<ZT_SkCreditTourokukekkaQrTr>(pEntity);
        Collections.sort(copyList, new OrderZT_SkCreditTourokukekkaQrTr(orders));
        return copyList;
    }

    
    public List<ZT_SkCreditTourokukekkaQrTr> OrderZT_SkCreditTourokukekkaQrTrByPkDesc(List<ZT_SkCreditTourokukekkaQrTr> pEntity) {
        List<SortCondition<ZT_SkCreditTourokukekkaQrTr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkCreditTourokukekkaQrTr()).ztrsystemjyusinymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkCreditTourokukekkaQrTr()).ztrsystemjyusintime, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkCreditTourokukekkaQrTr()).ztrcreditkessaiyouno, SortOrder.DESC));
        List<ZT_SkCreditTourokukekkaQrTr> copyList = new ArrayList<ZT_SkCreditTourokukekkaQrTr>(pEntity);
        Collections.sort(copyList, new OrderZT_SkCreditTourokukekkaQrTr(orders));
        return copyList;
    }
}
