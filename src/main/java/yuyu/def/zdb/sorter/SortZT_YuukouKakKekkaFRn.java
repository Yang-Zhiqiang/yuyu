package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_YuukouKakKekkaFRn;
import yuyu.def.db.meta.QZT_YuukouKakKekkaFRn;
import yuyu.def.zdb.comparator.OrderZT_YuukouKakKekkaFRn;

public class SortZT_YuukouKakKekkaFRn {

    
    public List<ZT_YuukouKakKekkaFRn> OrderZT_YuukouKakKekkaFRnByPkAsc(List<ZT_YuukouKakKekkaFRn> pEntity) {
        List<SortCondition<ZT_YuukouKakKekkaFRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_YuukouKakKekkaFRn()).zrncreditkessaiyouno, SortOrder.ASC));
        List<ZT_YuukouKakKekkaFRn> copyList = new ArrayList<ZT_YuukouKakKekkaFRn>(pEntity);
        Collections.sort(copyList, new OrderZT_YuukouKakKekkaFRn(orders));
        return copyList;
    }

    
    public List<ZT_YuukouKakKekkaFRn> OrderZT_YuukouKakKekkaFRnByPkDesc(List<ZT_YuukouKakKekkaFRn> pEntity) {
        List<SortCondition<ZT_YuukouKakKekkaFRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_YuukouKakKekkaFRn()).zrncreditkessaiyouno, SortOrder.DESC));
        List<ZT_YuukouKakKekkaFRn> copyList = new ArrayList<ZT_YuukouKakKekkaFRn>(pEntity);
        Collections.sort(copyList, new OrderZT_YuukouKakKekkaFRn(orders));
        return copyList;
    }
}
