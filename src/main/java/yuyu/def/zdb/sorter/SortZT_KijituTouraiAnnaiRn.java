package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KijituTouraiAnnaiRn;
import yuyu.def.db.meta.QZT_KijituTouraiAnnaiRn;
import yuyu.def.zdb.comparator.OrderZT_KijituTouraiAnnaiRn;

public class SortZT_KijituTouraiAnnaiRn {

    
    public List<ZT_KijituTouraiAnnaiRn> OrderZT_KijituTouraiAnnaiRnByPkAsc(List<ZT_KijituTouraiAnnaiRn> pEntity) {
        List<SortCondition<ZT_KijituTouraiAnnaiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KijituTouraiAnnaiRn()).zrntyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KijituTouraiAnnaiRn()).zrnsyono, SortOrder.ASC));
        List<ZT_KijituTouraiAnnaiRn> copyList = new ArrayList<ZT_KijituTouraiAnnaiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KijituTouraiAnnaiRn(orders));
        return copyList;
    }

    
    public List<ZT_KijituTouraiAnnaiRn> OrderZT_KijituTouraiAnnaiRnByPkDesc(List<ZT_KijituTouraiAnnaiRn> pEntity) {
        List<SortCondition<ZT_KijituTouraiAnnaiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KijituTouraiAnnaiRn()).zrntyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KijituTouraiAnnaiRn()).zrnsyono, SortOrder.DESC));
        List<ZT_KijituTouraiAnnaiRn> copyList = new ArrayList<ZT_KijituTouraiAnnaiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KijituTouraiAnnaiRn(orders));
        return copyList;
    }
}
