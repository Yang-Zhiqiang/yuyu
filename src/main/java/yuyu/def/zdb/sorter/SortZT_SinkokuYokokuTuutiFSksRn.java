package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SinkokuYokokuTuutiFSksRn;
import yuyu.def.db.meta.QZT_SinkokuYokokuTuutiFSksRn;
import yuyu.def.zdb.comparator.OrderZT_SinkokuYokokuTuutiFSksRn;

public class SortZT_SinkokuYokokuTuutiFSksRn {

    
    public List<ZT_SinkokuYokokuTuutiFSksRn> OrderZT_SinkokuYokokuTuutiFSksRnByPkAsc(List<ZT_SinkokuYokokuTuutiFSksRn> pEntity) {
        List<SortCondition<ZT_SinkokuYokokuTuutiFSksRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SinkokuYokokuTuutiFSksRn()).zrntyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SinkokuYokokuTuutiFSksRn()).zrnsyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SinkokuYokokuTuutiFSksRn()).zrnsinkokunenkj, SortOrder.ASC));
        List<ZT_SinkokuYokokuTuutiFSksRn> copyList = new ArrayList<ZT_SinkokuYokokuTuutiFSksRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SinkokuYokokuTuutiFSksRn(orders));
        return copyList;
    }

    
    public List<ZT_SinkokuYokokuTuutiFSksRn> OrderZT_SinkokuYokokuTuutiFSksRnByPkDesc(List<ZT_SinkokuYokokuTuutiFSksRn> pEntity) {
        List<SortCondition<ZT_SinkokuYokokuTuutiFSksRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SinkokuYokokuTuutiFSksRn()).zrntyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SinkokuYokokuTuutiFSksRn()).zrnsyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SinkokuYokokuTuutiFSksRn()).zrnsinkokunenkj, SortOrder.DESC));
        List<ZT_SinkokuYokokuTuutiFSksRn> copyList = new ArrayList<ZT_SinkokuYokokuTuutiFSksRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SinkokuYokokuTuutiFSksRn(orders));
        return copyList;
    }
}
