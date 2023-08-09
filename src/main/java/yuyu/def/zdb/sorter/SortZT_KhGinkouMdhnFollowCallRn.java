package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KhGinkouMdhnFollowCallRn;
import yuyu.def.db.meta.QZT_KhGinkouMdhnFollowCallRn;
import yuyu.def.zdb.comparator.OrderZT_KhGinkouMdhnFollowCallRn;

public class SortZT_KhGinkouMdhnFollowCallRn {

    
    public List<ZT_KhGinkouMdhnFollowCallRn> OrderZT_KhGinkouMdhnFollowCallRnByPkAsc(List<ZT_KhGinkouMdhnFollowCallRn> pEntity) {
        List<SortCondition<ZT_KhGinkouMdhnFollowCallRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KhGinkouMdhnFollowCallRn()).zrnsyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KhGinkouMdhnFollowCallRn()).zrnminyuuym, SortOrder.ASC));
        List<ZT_KhGinkouMdhnFollowCallRn> copyList = new ArrayList<ZT_KhGinkouMdhnFollowCallRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KhGinkouMdhnFollowCallRn(orders));
        return copyList;
    }

    
    public List<ZT_KhGinkouMdhnFollowCallRn> OrderZT_KhGinkouMdhnFollowCallRnByPkDesc(List<ZT_KhGinkouMdhnFollowCallRn> pEntity) {
        List<SortCondition<ZT_KhGinkouMdhnFollowCallRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KhGinkouMdhnFollowCallRn()).zrnsyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KhGinkouMdhnFollowCallRn()).zrnminyuuym, SortOrder.DESC));
        List<ZT_KhGinkouMdhnFollowCallRn> copyList = new ArrayList<ZT_KhGinkouMdhnFollowCallRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KhGinkouMdhnFollowCallRn(orders));
        return copyList;
    }
}
