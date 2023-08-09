package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KhDrtenMinyuuKykMeisaiRn;
import yuyu.def.db.meta.QZT_KhDrtenMinyuuKykMeisaiRn;
import yuyu.def.zdb.comparator.OrderZT_KhDrtenMinyuuKykMeisaiRn;

public class SortZT_KhDrtenMinyuuKykMeisaiRn {

    
    public List<ZT_KhDrtenMinyuuKykMeisaiRn> OrderZT_KhDrtenMinyuuKykMeisaiRnByPkAsc(List<ZT_KhDrtenMinyuuKykMeisaiRn> pEntity) {
        List<SortCondition<ZT_KhDrtenMinyuuKykMeisaiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KhDrtenMinyuuKykMeisaiRn()).zrnsyoriymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KhDrtenMinyuuKykMeisaiRn()).zrnbsydrtencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KhDrtenMinyuuKykMeisaiRn()).zrnsyono, SortOrder.ASC));
        List<ZT_KhDrtenMinyuuKykMeisaiRn> copyList = new ArrayList<ZT_KhDrtenMinyuuKykMeisaiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KhDrtenMinyuuKykMeisaiRn(orders));
        return copyList;
    }

    
    public List<ZT_KhDrtenMinyuuKykMeisaiRn> OrderZT_KhDrtenMinyuuKykMeisaiRnByPkDesc(List<ZT_KhDrtenMinyuuKykMeisaiRn> pEntity) {
        List<SortCondition<ZT_KhDrtenMinyuuKykMeisaiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KhDrtenMinyuuKykMeisaiRn()).zrnsyoriymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KhDrtenMinyuuKykMeisaiRn()).zrnbsydrtencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KhDrtenMinyuuKykMeisaiRn()).zrnsyono, SortOrder.DESC));
        List<ZT_KhDrtenMinyuuKykMeisaiRn> copyList = new ArrayList<ZT_KhDrtenMinyuuKykMeisaiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KhDrtenMinyuuKykMeisaiRn(orders));
        return copyList;
    }
}
