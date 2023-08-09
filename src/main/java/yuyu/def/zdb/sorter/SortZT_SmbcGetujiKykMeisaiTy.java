package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SmbcGetujiKykMeisaiTy;
import yuyu.def.db.meta.QZT_SmbcGetujiKykMeisaiTy;
import yuyu.def.zdb.comparator.OrderZT_SmbcGetujiKykMeisaiTy;

public class SortZT_SmbcGetujiKykMeisaiTy {

    
    public List<ZT_SmbcGetujiKykMeisaiTy> OrderZT_SmbcGetujiKykMeisaiTyByPkAsc(List<ZT_SmbcGetujiKykMeisaiTy> pEntity) {
        List<SortCondition<ZT_SmbcGetujiKykMeisaiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SmbcGetujiKykMeisaiTy()).ztydatakijyunymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SmbcGetujiKykMeisaiTy()).ztydatakijyunym, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SmbcGetujiKykMeisaiTy()).ztysyono, SortOrder.ASC));
        List<ZT_SmbcGetujiKykMeisaiTy> copyList = new ArrayList<ZT_SmbcGetujiKykMeisaiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SmbcGetujiKykMeisaiTy(orders));
        return copyList;
    }

    
    public List<ZT_SmbcGetujiKykMeisaiTy> OrderZT_SmbcGetujiKykMeisaiTyByPkDesc(List<ZT_SmbcGetujiKykMeisaiTy> pEntity) {
        List<SortCondition<ZT_SmbcGetujiKykMeisaiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SmbcGetujiKykMeisaiTy()).ztydatakijyunymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SmbcGetujiKykMeisaiTy()).ztydatakijyunym, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SmbcGetujiKykMeisaiTy()).ztysyono, SortOrder.DESC));
        List<ZT_SmbcGetujiKykMeisaiTy> copyList = new ArrayList<ZT_SmbcGetujiKykMeisaiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SmbcGetujiKykMeisaiTy(orders));
        return copyList;
    }
}
