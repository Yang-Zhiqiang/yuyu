package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_ZennouHoyuuIdouKykDtlTy;
import yuyu.def.db.meta.QZT_ZennouHoyuuIdouKykDtlTy;
import yuyu.def.zdb.comparator.OrderZT_ZennouHoyuuIdouKykDtlTy;

public class SortZT_ZennouHoyuuIdouKykDtlTy {

    
    public List<ZT_ZennouHoyuuIdouKykDtlTy> OrderZT_ZennouHoyuuIdouKykDtlTyByPkAsc(List<ZT_ZennouHoyuuIdouKykDtlTy> pEntity) {
        List<SortCondition<ZT_ZennouHoyuuIdouKykDtlTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_ZennouHoyuuIdouKykDtlTy()).ztydatakanrino, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_ZennouHoyuuIdouKykDtlTy()).ztysyoricd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_ZennouHoyuuIdouKykDtlTy()).ztykykmfksnctr, SortOrder.ASC));
        List<ZT_ZennouHoyuuIdouKykDtlTy> copyList = new ArrayList<ZT_ZennouHoyuuIdouKykDtlTy>(pEntity);
        Collections.sort(copyList, new OrderZT_ZennouHoyuuIdouKykDtlTy(orders));
        return copyList;
    }

    
    public List<ZT_ZennouHoyuuIdouKykDtlTy> OrderZT_ZennouHoyuuIdouKykDtlTyByPkDesc(List<ZT_ZennouHoyuuIdouKykDtlTy> pEntity) {
        List<SortCondition<ZT_ZennouHoyuuIdouKykDtlTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_ZennouHoyuuIdouKykDtlTy()).ztydatakanrino, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_ZennouHoyuuIdouKykDtlTy()).ztysyoricd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_ZennouHoyuuIdouKykDtlTy()).ztykykmfksnctr, SortOrder.DESC));
        List<ZT_ZennouHoyuuIdouKykDtlTy> copyList = new ArrayList<ZT_ZennouHoyuuIdouKykDtlTy>(pEntity);
        Collections.sort(copyList, new OrderZT_ZennouHoyuuIdouKykDtlTy(orders));
        return copyList;
    }
}
