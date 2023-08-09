package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KouzahuriMinyuTuutiRn;
import yuyu.def.db.meta.QZT_KouzahuriMinyuTuutiRn;
import yuyu.def.zdb.comparator.OrderZT_KouzahuriMinyuTuutiRn;

public class SortZT_KouzahuriMinyuTuutiRn {

    
    public List<ZT_KouzahuriMinyuTuutiRn> OrderZT_KouzahuriMinyuTuutiRnByPkAsc(List<ZT_KouzahuriMinyuTuutiRn> pEntity) {
        List<SortCondition<ZT_KouzahuriMinyuTuutiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KouzahuriMinyuTuutiRn()).zrntyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KouzahuriMinyuTuutiRn()).zrnsyono, SortOrder.ASC));
        List<ZT_KouzahuriMinyuTuutiRn> copyList = new ArrayList<ZT_KouzahuriMinyuTuutiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KouzahuriMinyuTuutiRn(orders));
        return copyList;
    }

    
    public List<ZT_KouzahuriMinyuTuutiRn> OrderZT_KouzahuriMinyuTuutiRnByPkDesc(List<ZT_KouzahuriMinyuTuutiRn> pEntity) {
        List<SortCondition<ZT_KouzahuriMinyuTuutiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KouzahuriMinyuTuutiRn()).zrntyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KouzahuriMinyuTuutiRn()).zrnsyono, SortOrder.DESC));
        List<ZT_KouzahuriMinyuTuutiRn> copyList = new ArrayList<ZT_KouzahuriMinyuTuutiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KouzahuriMinyuTuutiRn(orders));
        return copyList;
    }
}
