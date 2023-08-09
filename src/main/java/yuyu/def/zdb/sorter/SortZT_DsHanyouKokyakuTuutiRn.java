package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_DsHanyouKokyakuTuutiRn;
import yuyu.def.db.meta.QZT_DsHanyouKokyakuTuutiRn;
import yuyu.def.zdb.comparator.OrderZT_DsHanyouKokyakuTuutiRn;

public class SortZT_DsHanyouKokyakuTuutiRn {

    
    public List<ZT_DsHanyouKokyakuTuutiRn> OrderZT_DsHanyouKokyakuTuutiRnByPkAsc(List<ZT_DsHanyouKokyakuTuutiRn> pEntity) {
        List<SortCondition<ZT_DsHanyouKokyakuTuutiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DsHanyouKokyakuTuutiRn()).zrndshanyoukokatetuutikey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DsHanyouKokyakuTuutiRn()).zrndskokno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DsHanyouKokyakuTuutiRn()).zrndstuutikbn, SortOrder.ASC));
        List<ZT_DsHanyouKokyakuTuutiRn> copyList = new ArrayList<ZT_DsHanyouKokyakuTuutiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DsHanyouKokyakuTuutiRn(orders));
        return copyList;
    }

    
    public List<ZT_DsHanyouKokyakuTuutiRn> OrderZT_DsHanyouKokyakuTuutiRnByPkDesc(List<ZT_DsHanyouKokyakuTuutiRn> pEntity) {
        List<SortCondition<ZT_DsHanyouKokyakuTuutiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DsHanyouKokyakuTuutiRn()).zrndshanyoukokatetuutikey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DsHanyouKokyakuTuutiRn()).zrndskokno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DsHanyouKokyakuTuutiRn()).zrndstuutikbn, SortOrder.DESC));
        List<ZT_DsHanyouKokyakuTuutiRn> copyList = new ArrayList<ZT_DsHanyouKokyakuTuutiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DsHanyouKokyakuTuutiRn(orders));
        return copyList;
    }
}
