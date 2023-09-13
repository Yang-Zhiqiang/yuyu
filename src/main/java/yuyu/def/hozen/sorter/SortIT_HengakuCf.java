package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_HengakuCf;
import yuyu.def.db.meta.QIT_HengakuCf;
import yuyu.def.hozen.comparator.OrderIT_HengakuCf;

public class SortIT_HengakuCf {

    public List<IT_HengakuCf> OrderIT_HengakuCfByPkAsc(List<IT_HengakuCf> pEntity) {
        List<SortCondition<IT_HengakuCf>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_HengakuCf()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_HengakuCf()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_HengakuCf()).henkousikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_HengakuCf()).unitfundkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_HengakuCf()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_HengakuCf()).renno, SortOrder.ASC));
        List<IT_HengakuCf> copyList = new ArrayList<IT_HengakuCf>(pEntity);
        Collections.sort(copyList, new OrderIT_HengakuCf(orders));
        return copyList;
    }

    public List<IT_HengakuCf> OrderIT_HengakuCfByPkDesc(List<IT_HengakuCf> pEntity) {
        List<SortCondition<IT_HengakuCf>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_HengakuCf()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_HengakuCf()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_HengakuCf()).henkousikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_HengakuCf()).unitfundkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_HengakuCf()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_HengakuCf()).renno, SortOrder.DESC));
        List<IT_HengakuCf> copyList = new ArrayList<IT_HengakuCf>(pEntity);
        Collections.sort(copyList, new OrderIT_HengakuCf(orders));
        return copyList;
    }

}

