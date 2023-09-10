package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HW_CreditTrkNgList;
import yuyu.def.db.meta.QHW_CreditTrkNgList;
import yuyu.def.sinkeiyaku.comparator.OrderHW_CreditTrkNgList;

public class SortHW_CreditTrkNgList {

    
    public List<HW_CreditTrkNgList> OrderHW_CreditTrkNgListByPkAsc(List<HW_CreditTrkNgList> pEntity) {
        List<SortCondition<HW_CreditTrkNgList>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHW_CreditTrkNgList()).tyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHW_CreditTrkNgList()).datarenno, SortOrder.ASC));
        List<HW_CreditTrkNgList> copyList = new ArrayList<HW_CreditTrkNgList>(pEntity);
        Collections.sort(copyList, new OrderHW_CreditTrkNgList(orders));
        return copyList;
    }

    
    public List<HW_CreditTrkNgList> OrderHW_CreditTrkNgListByPkDesc(List<HW_CreditTrkNgList> pEntity) {
        List<SortCondition<HW_CreditTrkNgList>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHW_CreditTrkNgList()).tyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHW_CreditTrkNgList()).datarenno, SortOrder.DESC));
        List<HW_CreditTrkNgList> copyList = new ArrayList<HW_CreditTrkNgList>(pEntity);
        Collections.sort(copyList, new OrderHW_CreditTrkNgList(orders));
        return copyList;
    }
}
