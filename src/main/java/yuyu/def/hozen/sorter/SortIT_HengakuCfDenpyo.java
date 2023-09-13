package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_HengakuCfDenpyo;
import yuyu.def.db.meta.QIT_HengakuCfDenpyo;
import yuyu.def.hozen.comparator.OrderIT_HengakuCfDenpyo;

public class SortIT_HengakuCfDenpyo {

    public List<IT_HengakuCfDenpyo> OrderIT_HengakuCfDenpyoByPkAsc(List<IT_HengakuCfDenpyo> pEntity) {
        List<SortCondition<IT_HengakuCfDenpyo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_HengakuCfDenpyo()).denrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_HengakuCfDenpyo()).edano, SortOrder.ASC));
        List<IT_HengakuCfDenpyo> copyList = new ArrayList<IT_HengakuCfDenpyo>(pEntity);
        Collections.sort(copyList, new OrderIT_HengakuCfDenpyo(orders));
        return copyList;
    }

    public List<IT_HengakuCfDenpyo> OrderIT_HengakuCfDenpyoByPkDesc(List<IT_HengakuCfDenpyo> pEntity) {
        List<SortCondition<IT_HengakuCfDenpyo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_HengakuCfDenpyo()).denrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_HengakuCfDenpyo()).edano, SortOrder.DESC));
        List<IT_HengakuCfDenpyo> copyList = new ArrayList<IT_HengakuCfDenpyo>(pEntity);
        Collections.sort(copyList, new OrderIT_HengakuCfDenpyo(orders));
        return copyList;
    }

}

