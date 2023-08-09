package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SkCreditTourokukekkaQrRn;
import yuyu.def.db.meta.QZT_SkCreditTourokukekkaQrRn;
import yuyu.def.zdb.comparator.OrderZT_SkCreditTourokukekkaQrRn;

public class SortZT_SkCreditTourokukekkaQrRn {

    
    public List<ZT_SkCreditTourokukekkaQrRn> OrderZT_SkCreditTourokukekkaQrRnByPkAsc(List<ZT_SkCreditTourokukekkaQrRn> pEntity) {
        List<SortCondition<ZT_SkCreditTourokukekkaQrRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkCreditTourokukekkaQrRn()).zrnsystemjyusinymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkCreditTourokukekkaQrRn()).zrnsystemjyusintime, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkCreditTourokukekkaQrRn()).zrncreditkessaiyouno, SortOrder.ASC));
        List<ZT_SkCreditTourokukekkaQrRn> copyList = new ArrayList<ZT_SkCreditTourokukekkaQrRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SkCreditTourokukekkaQrRn(orders));
        return copyList;
    }

    
    public List<ZT_SkCreditTourokukekkaQrRn> OrderZT_SkCreditTourokukekkaQrRnByPkDesc(List<ZT_SkCreditTourokukekkaQrRn> pEntity) {
        List<SortCondition<ZT_SkCreditTourokukekkaQrRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkCreditTourokukekkaQrRn()).zrnsystemjyusinymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkCreditTourokukekkaQrRn()).zrnsystemjyusintime, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkCreditTourokukekkaQrRn()).zrncreditkessaiyouno, SortOrder.DESC));
        List<ZT_SkCreditTourokukekkaQrRn> copyList = new ArrayList<ZT_SkCreditTourokukekkaQrRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SkCreditTourokukekkaQrRn(orders));
        return copyList;
    }
}
