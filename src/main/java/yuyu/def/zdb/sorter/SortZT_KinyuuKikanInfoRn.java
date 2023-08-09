package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KinyuuKikanInfoRn;
import yuyu.def.db.meta.QZT_KinyuuKikanInfoRn;
import yuyu.def.zdb.comparator.OrderZT_KinyuuKikanInfoRn;

public class SortZT_KinyuuKikanInfoRn {

    
    public List<ZT_KinyuuKikanInfoRn> OrderZT_KinyuuKikanInfoRnByPkAsc(List<ZT_KinyuuKikanInfoRn> pEntity) {
        List<SortCondition<ZT_KinyuuKikanInfoRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KinyuuKikanInfoRn()).zrnkinyuukikancd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KinyuuKikanInfoRn()).zrnsitencd, SortOrder.ASC));
        List<ZT_KinyuuKikanInfoRn> copyList = new ArrayList<ZT_KinyuuKikanInfoRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KinyuuKikanInfoRn(orders));
        return copyList;
    }

    
    public List<ZT_KinyuuKikanInfoRn> OrderZT_KinyuuKikanInfoRnByPkDesc(List<ZT_KinyuuKikanInfoRn> pEntity) {
        List<SortCondition<ZT_KinyuuKikanInfoRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KinyuuKikanInfoRn()).zrnkinyuukikancd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KinyuuKikanInfoRn()).zrnsitencd, SortOrder.DESC));
        List<ZT_KinyuuKikanInfoRn> copyList = new ArrayList<ZT_KinyuuKikanInfoRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KinyuuKikanInfoRn(orders));
        return copyList;
    }
}
