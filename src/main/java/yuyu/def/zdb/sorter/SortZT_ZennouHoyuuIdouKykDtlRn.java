package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_ZennouHoyuuIdouKykDtlRn;
import yuyu.def.db.meta.QZT_ZennouHoyuuIdouKykDtlRn;
import yuyu.def.zdb.comparator.OrderZT_ZennouHoyuuIdouKykDtlRn;

public class SortZT_ZennouHoyuuIdouKykDtlRn {

    
    public List<ZT_ZennouHoyuuIdouKykDtlRn> OrderZT_ZennouHoyuuIdouKykDtlRnByPkAsc(List<ZT_ZennouHoyuuIdouKykDtlRn> pEntity) {
        List<SortCondition<ZT_ZennouHoyuuIdouKykDtlRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_ZennouHoyuuIdouKykDtlRn()).zrndatakanrino, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_ZennouHoyuuIdouKykDtlRn()).zrnsyoricd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_ZennouHoyuuIdouKykDtlRn()).zrnkykmfksnctr, SortOrder.ASC));
        List<ZT_ZennouHoyuuIdouKykDtlRn> copyList = new ArrayList<ZT_ZennouHoyuuIdouKykDtlRn>(pEntity);
        Collections.sort(copyList, new OrderZT_ZennouHoyuuIdouKykDtlRn(orders));
        return copyList;
    }

    
    public List<ZT_ZennouHoyuuIdouKykDtlRn> OrderZT_ZennouHoyuuIdouKykDtlRnByPkDesc(List<ZT_ZennouHoyuuIdouKykDtlRn> pEntity) {
        List<SortCondition<ZT_ZennouHoyuuIdouKykDtlRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_ZennouHoyuuIdouKykDtlRn()).zrndatakanrino, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_ZennouHoyuuIdouKykDtlRn()).zrnsyoricd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_ZennouHoyuuIdouKykDtlRn()).zrnkykmfksnctr, SortOrder.DESC));
        List<ZT_ZennouHoyuuIdouKykDtlRn> copyList = new ArrayList<ZT_ZennouHoyuuIdouKykDtlRn>(pEntity);
        Collections.sort(copyList, new OrderZT_ZennouHoyuuIdouKykDtlRn(orders));
        return copyList;
    }
}
