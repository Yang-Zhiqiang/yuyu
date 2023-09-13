package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.meta.QIT_KykSyouhnHnkmae;
import yuyu.def.hozen.comparator.OrderIT_KykSyouhnHnkmae;

public class SortIT_KykSyouhnHnkmae {

    public List<IT_KykSyouhnHnkmae> OrderIT_KykSyouhnHnkmaeByPkAsc(List<IT_KykSyouhnHnkmae> pEntity) {
        List<SortCondition<IT_KykSyouhnHnkmae>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KykSyouhnHnkmae()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KykSyouhnHnkmae()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KykSyouhnHnkmae()).syutkkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KykSyouhnHnkmae()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KykSyouhnHnkmae()).syouhnsdno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KykSyouhnHnkmae()).kyksyouhnrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KykSyouhnHnkmae()).renno, SortOrder.ASC));
        List<IT_KykSyouhnHnkmae> copyList = new ArrayList<IT_KykSyouhnHnkmae>(pEntity);
        Collections.sort(copyList, new OrderIT_KykSyouhnHnkmae(orders));
        return copyList;
    }

    public List<IT_KykSyouhnHnkmae> OrderIT_KykSyouhnHnkmaeByPkDesc(List<IT_KykSyouhnHnkmae> pEntity) {
        List<SortCondition<IT_KykSyouhnHnkmae>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KykSyouhnHnkmae()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KykSyouhnHnkmae()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KykSyouhnHnkmae()).syutkkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KykSyouhnHnkmae()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KykSyouhnHnkmae()).syouhnsdno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KykSyouhnHnkmae()).kyksyouhnrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KykSyouhnHnkmae()).renno, SortOrder.DESC));
        List<IT_KykSyouhnHnkmae> copyList = new ArrayList<IT_KykSyouhnHnkmae>(pEntity);
        Collections.sort(copyList, new OrderIT_KykSyouhnHnkmae(orders));
        return copyList;
    }
}
