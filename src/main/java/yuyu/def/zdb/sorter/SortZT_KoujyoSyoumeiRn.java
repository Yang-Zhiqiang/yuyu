package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KoujyoSyoumeiRn;
import yuyu.def.db.meta.QZT_KoujyoSyoumeiRn;
import yuyu.def.zdb.comparator.OrderZT_KoujyoSyoumeiRn;

public class SortZT_KoujyoSyoumeiRn {

    
    public List<ZT_KoujyoSyoumeiRn> OrderZT_KoujyoSyoumeiRnByPkAsc(List<ZT_KoujyoSyoumeiRn> pEntity) {
        List<SortCondition<ZT_KoujyoSyoumeiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KoujyoSyoumeiRn()).zrntyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KoujyoSyoumeiRn()).zrnsyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KoujyoSyoumeiRn()).zrnsakunm15keta, SortOrder.ASC));
        List<ZT_KoujyoSyoumeiRn> copyList = new ArrayList<ZT_KoujyoSyoumeiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KoujyoSyoumeiRn(orders));
        return copyList;
    }

    
    public List<ZT_KoujyoSyoumeiRn> OrderZT_KoujyoSyoumeiRnByPkDesc(List<ZT_KoujyoSyoumeiRn> pEntity) {
        List<SortCondition<ZT_KoujyoSyoumeiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KoujyoSyoumeiRn()).zrntyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KoujyoSyoumeiRn()).zrnsyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KoujyoSyoumeiRn()).zrnsakunm15keta, SortOrder.DESC));
        List<ZT_KoujyoSyoumeiRn> copyList = new ArrayList<ZT_KoujyoSyoumeiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KoujyoSyoumeiRn(orders));
        return copyList;
    }
}
