package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_HengakuCf;
import yuyu.def.db.meta.QIT_BAK_HengakuCf;
import yuyu.def.hozen.comparator.OrderIT_BAK_HengakuCf;

public class SortIT_BAK_HengakuCf {

    public List<IT_BAK_HengakuCf> OrderIT_BAK_HengakuCfByPkAsc(List<IT_BAK_HengakuCf> pEntity) {
        List<SortCondition<IT_BAK_HengakuCf>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_HengakuCf()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HengakuCf()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HengakuCf()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HengakuCf()).henkousikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HengakuCf()).unitfundkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HengakuCf()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HengakuCf()).renno, SortOrder.ASC));
        List<IT_BAK_HengakuCf> copyList = new ArrayList<IT_BAK_HengakuCf>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_HengakuCf(orders));
        return copyList;
    }

    public List<IT_BAK_HengakuCf> OrderIT_BAK_HengakuCfByPkDesc(List<IT_BAK_HengakuCf> pEntity) {
        List<SortCondition<IT_BAK_HengakuCf>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_HengakuCf()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HengakuCf()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HengakuCf()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HengakuCf()).henkousikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HengakuCf()).unitfundkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HengakuCf()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HengakuCf()).renno, SortOrder.DESC));
        List<IT_BAK_HengakuCf> copyList = new ArrayList<IT_BAK_HengakuCf>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_HengakuCf(orders));
        return copyList;
    }

}

