package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_TesuuryouSyouhn;
import yuyu.def.db.meta.QIT_TesuuryouSyouhn;
import yuyu.def.hozen.comparator.OrderIT_TesuuryouSyouhn;

public class SortIT_TesuuryouSyouhn {

    public List<IT_TesuuryouSyouhn> OrderIT_TesuuryouSyouhnByPkAsc(List<IT_TesuuryouSyouhn> pEntity) {
        List<SortCondition<IT_TesuuryouSyouhn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_TesuuryouSyouhn()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TesuuryouSyouhn()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TesuuryouSyouhn()).tsrysyorikbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TesuuryouSyouhn()).renno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TesuuryouSyouhn()).syutkkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TesuuryouSyouhn()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TesuuryouSyouhn()).syouhnsdno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TesuuryouSyouhn()).kyksyouhnrenno, SortOrder.ASC));
        List<IT_TesuuryouSyouhn> copyList = new ArrayList<IT_TesuuryouSyouhn>(pEntity);
        Collections.sort(copyList, new OrderIT_TesuuryouSyouhn(orders));
        return copyList;
    }

    public List<IT_TesuuryouSyouhn> OrderIT_TesuuryouSyouhnByPkDesc(List<IT_TesuuryouSyouhn> pEntity) {
        List<SortCondition<IT_TesuuryouSyouhn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_TesuuryouSyouhn()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TesuuryouSyouhn()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TesuuryouSyouhn()).tsrysyorikbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TesuuryouSyouhn()).renno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TesuuryouSyouhn()).syutkkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TesuuryouSyouhn()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TesuuryouSyouhn()).syouhnsdno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TesuuryouSyouhn()).kyksyouhnrenno, SortOrder.DESC));
        List<IT_TesuuryouSyouhn> copyList = new ArrayList<IT_TesuuryouSyouhn>(pEntity);
        Collections.sort(copyList, new OrderIT_TesuuryouSyouhn(orders));
        return copyList;
    }

}

