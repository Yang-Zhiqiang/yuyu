package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HW_CreditTrkHaneierrList;
import yuyu.def.db.meta.QHW_CreditTrkHaneierrList;
import yuyu.def.sinkeiyaku.comparator.OrderHW_CreditTrkHaneierrList;

public class SortHW_CreditTrkHaneierrList {

    
    public List<HW_CreditTrkHaneierrList> OrderHW_CreditTrkHaneierrListByPkAsc(List<HW_CreditTrkHaneierrList> pEntity) {
        List<SortCondition<HW_CreditTrkHaneierrList>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHW_CreditTrkHaneierrList()).tyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHW_CreditTrkHaneierrList()).datarenno, SortOrder.ASC));
        List<HW_CreditTrkHaneierrList> copyList = new ArrayList<HW_CreditTrkHaneierrList>(pEntity);
        Collections.sort(copyList, new OrderHW_CreditTrkHaneierrList(orders));
        return copyList;
    }

    
    public List<HW_CreditTrkHaneierrList> OrderHW_CreditTrkHaneierrListByPkDesc(List<HW_CreditTrkHaneierrList> pEntity) {
        List<SortCondition<HW_CreditTrkHaneierrList>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHW_CreditTrkHaneierrList()).tyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHW_CreditTrkHaneierrList()).datarenno, SortOrder.DESC));
        List<HW_CreditTrkHaneierrList> copyList = new ArrayList<HW_CreditTrkHaneierrList>(pEntity);
        Collections.sort(copyList, new OrderHW_CreditTrkHaneierrList(orders));
        return copyList;
    }
}
