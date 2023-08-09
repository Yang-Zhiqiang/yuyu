package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SinkokuYokokuTuutiFSksTy;
import yuyu.def.db.meta.QZT_SinkokuYokokuTuutiFSksTy;
import yuyu.def.zdb.comparator.OrderZT_SinkokuYokokuTuutiFSksTy;

public class SortZT_SinkokuYokokuTuutiFSksTy {

    
    public List<ZT_SinkokuYokokuTuutiFSksTy> OrderZT_SinkokuYokokuTuutiFSksTyByPkAsc(List<ZT_SinkokuYokokuTuutiFSksTy> pEntity) {
        List<SortCondition<ZT_SinkokuYokokuTuutiFSksTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SinkokuYokokuTuutiFSksTy()).ztytyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SinkokuYokokuTuutiFSksTy()).ztysyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SinkokuYokokuTuutiFSksTy()).ztysinkokunenkj, SortOrder.ASC));
        List<ZT_SinkokuYokokuTuutiFSksTy> copyList = new ArrayList<ZT_SinkokuYokokuTuutiFSksTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SinkokuYokokuTuutiFSksTy(orders));
        return copyList;
    }

    
    public List<ZT_SinkokuYokokuTuutiFSksTy> OrderZT_SinkokuYokokuTuutiFSksTyByPkDesc(List<ZT_SinkokuYokokuTuutiFSksTy> pEntity) {
        List<SortCondition<ZT_SinkokuYokokuTuutiFSksTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SinkokuYokokuTuutiFSksTy()).ztytyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SinkokuYokokuTuutiFSksTy()).ztysyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SinkokuYokokuTuutiFSksTy()).ztysinkokunenkj, SortOrder.DESC));
        List<ZT_SinkokuYokokuTuutiFSksTy> copyList = new ArrayList<ZT_SinkokuYokokuTuutiFSksTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SinkokuYokokuTuutiFSksTy(orders));
        return copyList;
    }
}
