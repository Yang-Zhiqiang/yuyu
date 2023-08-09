package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SkIpJissekiTy;
import yuyu.def.db.meta.QZT_SkIpJissekiTy;
import yuyu.def.zdb.comparator.OrderZT_SkIpJissekiTy;

public class SortZT_SkIpJissekiTy {

    
    public List<ZT_SkIpJissekiTy> OrderZT_SkIpJissekiTyByPkAsc(List<ZT_SkIpJissekiTy> pEntity) {
        List<SortCondition<ZT_SkIpJissekiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkIpJissekiTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_SkIpJissekiTy> copyList = new ArrayList<ZT_SkIpJissekiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SkIpJissekiTy(orders));
        return copyList;
    }

    
    public List<ZT_SkIpJissekiTy> OrderZT_SkIpJissekiTyByPkDesc(List<ZT_SkIpJissekiTy> pEntity) {
        List<SortCondition<ZT_SkIpJissekiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkIpJissekiTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_SkIpJissekiTy> copyList = new ArrayList<ZT_SkIpJissekiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SkIpJissekiTy(orders));
        return copyList;
    }
}
