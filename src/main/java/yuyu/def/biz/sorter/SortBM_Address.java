package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_Address;
import yuyu.def.db.entity.BM_Address;
import yuyu.def.db.meta.QBM_Address;

public class SortBM_Address {

    public List<BM_Address> OrderBM_AddressByPkAsc(List<BM_Address> pEntity) {
        List<SortCondition<BM_Address>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_Address()).postalCd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_Address()).kihontikucdsimo1, SortOrder.ASC));
        List<BM_Address> copyList = new ArrayList<BM_Address>(pEntity);
        Collections.sort(copyList, new OrderBM_Address(orders));
        return copyList;
    }

    public List<BM_Address> OrderBM_AddressByPkDesc(List<BM_Address> pEntity) {
        List<SortCondition<BM_Address>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_Address()).postalCd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_Address()).kihontikucdsimo1, SortOrder.DESC));
        List<BM_Address> copyList = new ArrayList<BM_Address>(pEntity);
        Collections.sort(copyList, new OrderBM_Address(orders));
        return copyList;
    }

}

