package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_YuukouKakKekkaFTr;
import yuyu.def.db.meta.QZT_YuukouKakKekkaFTr;
import yuyu.def.zdb.comparator.OrderZT_YuukouKakKekkaFTr;

public class SortZT_YuukouKakKekkaFTr {

    
    public List<ZT_YuukouKakKekkaFTr> OrderZT_YuukouKakKekkaFTrByPkAsc(List<ZT_YuukouKakKekkaFTr> pEntity) {
        List<SortCondition<ZT_YuukouKakKekkaFTr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_YuukouKakKekkaFTr()).ztrcreditkessaiyouno, SortOrder.ASC));
        List<ZT_YuukouKakKekkaFTr> copyList = new ArrayList<ZT_YuukouKakKekkaFTr>(pEntity);
        Collections.sort(copyList, new OrderZT_YuukouKakKekkaFTr(orders));
        return copyList;
    }

    
    public List<ZT_YuukouKakKekkaFTr> OrderZT_YuukouKakKekkaFTrByPkDesc(List<ZT_YuukouKakKekkaFTr> pEntity) {
        List<SortCondition<ZT_YuukouKakKekkaFTr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_YuukouKakKekkaFTr()).ztrcreditkessaiyouno, SortOrder.DESC));
        List<ZT_YuukouKakKekkaFTr> copyList = new ArrayList<ZT_YuukouKakKekkaFTr>(pEntity);
        Collections.sort(copyList, new OrderZT_YuukouKakKekkaFTr(orders));
        return copyList;
    }
}
