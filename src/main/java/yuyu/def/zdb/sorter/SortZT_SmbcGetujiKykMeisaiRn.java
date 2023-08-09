package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SmbcGetujiKykMeisaiRn;
import yuyu.def.db.meta.QZT_SmbcGetujiKykMeisaiRn;
import yuyu.def.zdb.comparator.OrderZT_SmbcGetujiKykMeisaiRn;

public class SortZT_SmbcGetujiKykMeisaiRn {

    
    public List<ZT_SmbcGetujiKykMeisaiRn> OrderZT_SmbcGetujiKykMeisaiRnByPkAsc(List<ZT_SmbcGetujiKykMeisaiRn> pEntity) {
        List<SortCondition<ZT_SmbcGetujiKykMeisaiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SmbcGetujiKykMeisaiRn()).zrndatakijyunymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SmbcGetujiKykMeisaiRn()).zrndatakijyunym, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SmbcGetujiKykMeisaiRn()).zrnsyono, SortOrder.ASC));
        List<ZT_SmbcGetujiKykMeisaiRn> copyList = new ArrayList<ZT_SmbcGetujiKykMeisaiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SmbcGetujiKykMeisaiRn(orders));
        return copyList;
    }

    
    public List<ZT_SmbcGetujiKykMeisaiRn> OrderZT_SmbcGetujiKykMeisaiRnByPkDesc(List<ZT_SmbcGetujiKykMeisaiRn> pEntity) {
        List<SortCondition<ZT_SmbcGetujiKykMeisaiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SmbcGetujiKykMeisaiRn()).zrndatakijyunymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SmbcGetujiKykMeisaiRn()).zrndatakijyunym, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SmbcGetujiKykMeisaiRn()).zrnsyono, SortOrder.DESC));
        List<ZT_SmbcGetujiKykMeisaiRn> copyList = new ArrayList<ZT_SmbcGetujiKykMeisaiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SmbcGetujiKykMeisaiRn(orders));
        return copyList;
    }
}
