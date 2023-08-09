package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_MosJkItiranSyoukaiRn;
import yuyu.def.db.meta.QZT_MosJkItiranSyoukaiRn;
import yuyu.def.zdb.comparator.OrderZT_MosJkItiranSyoukaiRn;

public class SortZT_MosJkItiranSyoukaiRn {

    
    public List<ZT_MosJkItiranSyoukaiRn> OrderZT_MosJkItiranSyoukaiRnByPkAsc(List<ZT_MosJkItiranSyoukaiRn> pEntity) {
        List<SortCondition<ZT_MosJkItiranSyoukaiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_MosJkItiranSyoukaiRn()).zrnmosym, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_MosJkItiranSyoukaiRn()).zrnmosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_MosJkItiranSyoukaiRn()).zrnbsydrtencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_MosJkItiranSyoukaiRn()).zrnatukaikojincd, SortOrder.ASC));
        List<ZT_MosJkItiranSyoukaiRn> copyList = new ArrayList<ZT_MosJkItiranSyoukaiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_MosJkItiranSyoukaiRn(orders));
        return copyList;
    }

    
    public List<ZT_MosJkItiranSyoukaiRn> OrderZT_MosJkItiranSyoukaiRnByPkDesc(List<ZT_MosJkItiranSyoukaiRn> pEntity) {
        List<SortCondition<ZT_MosJkItiranSyoukaiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_MosJkItiranSyoukaiRn()).zrnmosym, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_MosJkItiranSyoukaiRn()).zrnmosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_MosJkItiranSyoukaiRn()).zrnbsydrtencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_MosJkItiranSyoukaiRn()).zrnatukaikojincd, SortOrder.DESC));
        List<ZT_MosJkItiranSyoukaiRn> copyList = new ArrayList<ZT_MosJkItiranSyoukaiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_MosJkItiranSyoukaiRn(orders));
        return copyList;
    }
}
