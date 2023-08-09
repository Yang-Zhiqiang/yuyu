package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KouzahuriStartAnnaiRn;
import yuyu.def.db.meta.QZT_KouzahuriStartAnnaiRn;
import yuyu.def.zdb.comparator.OrderZT_KouzahuriStartAnnaiRn;

public class SortZT_KouzahuriStartAnnaiRn {

    
    public List<ZT_KouzahuriStartAnnaiRn> OrderZT_KouzahuriStartAnnaiRnByPkAsc(List<ZT_KouzahuriStartAnnaiRn> pEntity) {
        List<SortCondition<ZT_KouzahuriStartAnnaiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KouzahuriStartAnnaiRn()).zrntyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KouzahuriStartAnnaiRn()).zrnsyono, SortOrder.ASC));
        List<ZT_KouzahuriStartAnnaiRn> copyList = new ArrayList<ZT_KouzahuriStartAnnaiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KouzahuriStartAnnaiRn(orders));
        return copyList;
    }

    
    public List<ZT_KouzahuriStartAnnaiRn> OrderZT_KouzahuriStartAnnaiRnByPkDesc(List<ZT_KouzahuriStartAnnaiRn> pEntity) {
        List<SortCondition<ZT_KouzahuriStartAnnaiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KouzahuriStartAnnaiRn()).zrntyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KouzahuriStartAnnaiRn()).zrnsyono, SortOrder.DESC));
        List<ZT_KouzahuriStartAnnaiRn> copyList = new ArrayList<ZT_KouzahuriStartAnnaiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KouzahuriStartAnnaiRn(orders));
        return copyList;
    }
}
