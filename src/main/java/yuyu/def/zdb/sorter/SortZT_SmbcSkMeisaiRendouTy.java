package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SmbcSkMeisaiRendouTy;
import yuyu.def.db.meta.QZT_SmbcSkMeisaiRendouTy;
import yuyu.def.zdb.comparator.OrderZT_SmbcSkMeisaiRendouTy;

public class SortZT_SmbcSkMeisaiRendouTy {

    
    public List<ZT_SmbcSkMeisaiRendouTy> OrderZT_SmbcSkMeisaiRendouTyByPkAsc(List<ZT_SmbcSkMeisaiRendouTy> pEntity) {
        List<SortCondition<ZT_SmbcSkMeisaiRendouTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SmbcSkMeisaiRendouTy()).ztysmbcdatakbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SmbcSkMeisaiRendouTy()).ztysmbcdatasakuseiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SmbcSkMeisaiRendouTy()).ztysmbchknkaisyacd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SmbcSkMeisaiRendouTy()).ztysmbcuktkkanriid, SortOrder.ASC));
        List<ZT_SmbcSkMeisaiRendouTy> copyList = new ArrayList<ZT_SmbcSkMeisaiRendouTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SmbcSkMeisaiRendouTy(orders));
        return copyList;
    }

    
    public List<ZT_SmbcSkMeisaiRendouTy> OrderZT_SmbcSkMeisaiRendouTyByPkDesc(List<ZT_SmbcSkMeisaiRendouTy> pEntity) {
        List<SortCondition<ZT_SmbcSkMeisaiRendouTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SmbcSkMeisaiRendouTy()).ztysmbcdatakbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SmbcSkMeisaiRendouTy()).ztysmbcdatasakuseiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SmbcSkMeisaiRendouTy()).ztysmbchknkaisyacd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SmbcSkMeisaiRendouTy()).ztysmbcuktkkanriid, SortOrder.DESC));
        List<ZT_SmbcSkMeisaiRendouTy> copyList = new ArrayList<ZT_SmbcSkMeisaiRendouTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SmbcSkMeisaiRendouTy(orders));
        return copyList;
    }
}
