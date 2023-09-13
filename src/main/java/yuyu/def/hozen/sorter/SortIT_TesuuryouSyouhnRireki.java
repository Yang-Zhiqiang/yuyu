package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_TesuuryouSyouhnRireki;
import yuyu.def.db.meta.QIT_TesuuryouSyouhnRireki;
import yuyu.def.hozen.comparator.OrderIT_TesuuryouSyouhnRireki;

public class SortIT_TesuuryouSyouhnRireki {

    public List<IT_TesuuryouSyouhnRireki> OrderIT_TesuuryouSyouhnRirekiByPkAsc(List<IT_TesuuryouSyouhnRireki> pEntity) {
        List<SortCondition<IT_TesuuryouSyouhnRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_TesuuryouSyouhnRireki()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TesuuryouSyouhnRireki()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TesuuryouSyouhnRireki()).tsrysyorikbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TesuuryouSyouhnRireki()).renno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TesuuryouSyouhnRireki()).syutkkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TesuuryouSyouhnRireki()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TesuuryouSyouhnRireki()).syouhnsdno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TesuuryouSyouhnRireki()).kyksyouhnrenno, SortOrder.ASC));
        List<IT_TesuuryouSyouhnRireki> copyList = new ArrayList<IT_TesuuryouSyouhnRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_TesuuryouSyouhnRireki(orders));
        return copyList;
    }

    public List<IT_TesuuryouSyouhnRireki> OrderIT_TesuuryouSyouhnRirekiByPkDesc(List<IT_TesuuryouSyouhnRireki> pEntity) {
        List<SortCondition<IT_TesuuryouSyouhnRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_TesuuryouSyouhnRireki()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TesuuryouSyouhnRireki()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TesuuryouSyouhnRireki()).tsrysyorikbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TesuuryouSyouhnRireki()).renno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TesuuryouSyouhnRireki()).syutkkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TesuuryouSyouhnRireki()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TesuuryouSyouhnRireki()).syouhnsdno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TesuuryouSyouhnRireki()).kyksyouhnrenno, SortOrder.DESC));
        List<IT_TesuuryouSyouhnRireki> copyList = new ArrayList<IT_TesuuryouSyouhnRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_TesuuryouSyouhnRireki(orders));
        return copyList;
    }

}

