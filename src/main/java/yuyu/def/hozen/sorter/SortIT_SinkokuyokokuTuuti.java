package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_SinkokuyokokuTuuti;
import yuyu.def.db.meta.QIT_SinkokuyokokuTuuti;
import yuyu.def.hozen.comparator.OrderIT_SinkokuyokokuTuuti;

public class SortIT_SinkokuyokokuTuuti {

    public List<IT_SinkokuyokokuTuuti> OrderIT_SinkokuyokokuTuutiByPkAsc(List<IT_SinkokuyokokuTuuti> pEntity) {
        List<SortCondition<IT_SinkokuyokokuTuuti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_SinkokuyokokuTuuti()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_SinkokuyokokuTuuti()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_SinkokuyokokuTuuti()).nendo, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_SinkokuyokokuTuuti()).tyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_SinkokuyokokuTuuti()).renno, SortOrder.ASC));
        List<IT_SinkokuyokokuTuuti> copyList = new ArrayList<IT_SinkokuyokokuTuuti>(pEntity);
        Collections.sort(copyList, new OrderIT_SinkokuyokokuTuuti(orders));
        return copyList;
    }

    public List<IT_SinkokuyokokuTuuti> OrderIT_SinkokuyokokuTuutiByPkDesc(List<IT_SinkokuyokokuTuuti> pEntity) {
        List<SortCondition<IT_SinkokuyokokuTuuti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_SinkokuyokokuTuuti()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_SinkokuyokokuTuuti()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_SinkokuyokokuTuuti()).nendo, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_SinkokuyokokuTuuti()).tyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_SinkokuyokokuTuuti()).renno, SortOrder.DESC));
        List<IT_SinkokuyokokuTuuti> copyList = new ArrayList<IT_SinkokuyokokuTuuti>(pEntity);
        Collections.sort(copyList, new OrderIT_SinkokuyokokuTuuti(orders));
        return copyList;
    }

}

