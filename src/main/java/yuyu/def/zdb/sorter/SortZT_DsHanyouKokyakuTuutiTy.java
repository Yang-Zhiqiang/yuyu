package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_DsHanyouKokyakuTuutiTy;
import yuyu.def.db.meta.QZT_DsHanyouKokyakuTuutiTy;
import yuyu.def.zdb.comparator.OrderZT_DsHanyouKokyakuTuutiTy;

public class SortZT_DsHanyouKokyakuTuutiTy {

    
    public List<ZT_DsHanyouKokyakuTuutiTy> OrderZT_DsHanyouKokyakuTuutiTyByPkAsc(List<ZT_DsHanyouKokyakuTuutiTy> pEntity) {
        List<SortCondition<ZT_DsHanyouKokyakuTuutiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DsHanyouKokyakuTuutiTy()).ztydshanyoukokatetuutikey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DsHanyouKokyakuTuutiTy()).ztydskokno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DsHanyouKokyakuTuutiTy()).ztydstuutikbn, SortOrder.ASC));
        List<ZT_DsHanyouKokyakuTuutiTy> copyList = new ArrayList<ZT_DsHanyouKokyakuTuutiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_DsHanyouKokyakuTuutiTy(orders));
        return copyList;
    }

    
    public List<ZT_DsHanyouKokyakuTuutiTy> OrderZT_DsHanyouKokyakuTuutiTyByPkDesc(List<ZT_DsHanyouKokyakuTuutiTy> pEntity) {
        List<SortCondition<ZT_DsHanyouKokyakuTuutiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DsHanyouKokyakuTuutiTy()).ztydshanyoukokatetuutikey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DsHanyouKokyakuTuutiTy()).ztydskokno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DsHanyouKokyakuTuutiTy()).ztydstuutikbn, SortOrder.DESC));
        List<ZT_DsHanyouKokyakuTuutiTy> copyList = new ArrayList<ZT_DsHanyouKokyakuTuutiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_DsHanyouKokyakuTuutiTy(orders));
        return copyList;
    }
}
