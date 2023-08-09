package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SmbcSkMeisaiRendouRn;
import yuyu.def.db.meta.QZT_SmbcSkMeisaiRendouRn;
import yuyu.def.zdb.comparator.OrderZT_SmbcSkMeisaiRendouRn;

public class SortZT_SmbcSkMeisaiRendouRn {

    
    public List<ZT_SmbcSkMeisaiRendouRn> OrderZT_SmbcSkMeisaiRendouRnByPkAsc(List<ZT_SmbcSkMeisaiRendouRn> pEntity) {
        List<SortCondition<ZT_SmbcSkMeisaiRendouRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SmbcSkMeisaiRendouRn()).zrnsmbcdatakbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SmbcSkMeisaiRendouRn()).zrnsmbcdatasakuseiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SmbcSkMeisaiRendouRn()).zrnsmbchknkaisyacd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SmbcSkMeisaiRendouRn()).zrnsmbcuktkkanriid, SortOrder.ASC));
        List<ZT_SmbcSkMeisaiRendouRn> copyList = new ArrayList<ZT_SmbcSkMeisaiRendouRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SmbcSkMeisaiRendouRn(orders));
        return copyList;
    }

    
    public List<ZT_SmbcSkMeisaiRendouRn> OrderZT_SmbcSkMeisaiRendouRnByPkDesc(List<ZT_SmbcSkMeisaiRendouRn> pEntity) {
        List<SortCondition<ZT_SmbcSkMeisaiRendouRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SmbcSkMeisaiRendouRn()).zrnsmbcdatakbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SmbcSkMeisaiRendouRn()).zrnsmbcdatasakuseiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SmbcSkMeisaiRendouRn()).zrnsmbchknkaisyacd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SmbcSkMeisaiRendouRn()).zrnsmbcuktkkanriid, SortOrder.DESC));
        List<ZT_SmbcSkMeisaiRendouRn> copyList = new ArrayList<ZT_SmbcSkMeisaiRendouRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SmbcSkMeisaiRendouRn(orders));
        return copyList;
    }
}
