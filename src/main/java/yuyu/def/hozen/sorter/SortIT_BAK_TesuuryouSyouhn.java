package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_TesuuryouSyouhn;
import yuyu.def.db.meta.QIT_BAK_TesuuryouSyouhn;
import yuyu.def.hozen.comparator.OrderIT_BAK_TesuuryouSyouhn;

public class SortIT_BAK_TesuuryouSyouhn {

    public List<IT_BAK_TesuuryouSyouhn> OrderIT_BAK_TesuuryouSyouhnByPkAsc(List<IT_BAK_TesuuryouSyouhn> pEntity) {
        List<SortCondition<IT_BAK_TesuuryouSyouhn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhn()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhn()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhn()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhn()).tsrysyorikbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhn()).renno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhn()).syutkkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhn()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhn()).syouhnsdno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhn()).kyksyouhnrenno, SortOrder.ASC));
        List<IT_BAK_TesuuryouSyouhn> copyList = new ArrayList<IT_BAK_TesuuryouSyouhn>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_TesuuryouSyouhn(orders));
        return copyList;
    }

    public List<IT_BAK_TesuuryouSyouhn> OrderIT_BAK_TesuuryouSyouhnByPkDesc(List<IT_BAK_TesuuryouSyouhn> pEntity) {
        List<SortCondition<IT_BAK_TesuuryouSyouhn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhn()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhn()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhn()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhn()).tsrysyorikbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhn()).renno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhn()).syutkkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhn()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhn()).syouhnsdno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhn()).kyksyouhnrenno, SortOrder.DESC));
        List<IT_BAK_TesuuryouSyouhn> copyList = new ArrayList<IT_BAK_TesuuryouSyouhn>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_TesuuryouSyouhn(orders));
        return copyList;
    }

}

