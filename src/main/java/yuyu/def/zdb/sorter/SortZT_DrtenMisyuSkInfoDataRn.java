package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_DrtenMisyuSkInfoDataRn;
import yuyu.def.db.meta.QZT_DrtenMisyuSkInfoDataRn;
import yuyu.def.zdb.comparator.OrderZT_DrtenMisyuSkInfoDataRn;

public class SortZT_DrtenMisyuSkInfoDataRn {

    
    public List<ZT_DrtenMisyuSkInfoDataRn> OrderZT_DrtenMisyuSkInfoDataRnByPkAsc(List<ZT_DrtenMisyuSkInfoDataRn> pEntity) {
        List<SortCondition<ZT_DrtenMisyuSkInfoDataRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DrtenMisyuSkInfoDataRn()).zrnsyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenMisyuSkInfoDataRn()).zrnbsydrtencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenMisyuSkInfoDataRn()).zrnhanteiymd, SortOrder.ASC));
        List<ZT_DrtenMisyuSkInfoDataRn> copyList = new ArrayList<ZT_DrtenMisyuSkInfoDataRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DrtenMisyuSkInfoDataRn(orders));
        return copyList;
    }

    
    public List<ZT_DrtenMisyuSkInfoDataRn> OrderZT_DrtenMisyuSkInfoDataRnByPkDesc(List<ZT_DrtenMisyuSkInfoDataRn> pEntity) {
        List<SortCondition<ZT_DrtenMisyuSkInfoDataRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DrtenMisyuSkInfoDataRn()).zrnsyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenMisyuSkInfoDataRn()).zrnbsydrtencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenMisyuSkInfoDataRn()).zrnhanteiymd, SortOrder.DESC));
        List<ZT_DrtenMisyuSkInfoDataRn> copyList = new ArrayList<ZT_DrtenMisyuSkInfoDataRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DrtenMisyuSkInfoDataRn(orders));
        return copyList;
    }
}
