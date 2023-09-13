package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_TesuuryouSyouhnRireki;
import yuyu.def.db.meta.QIT_BAK_TesuuryouSyouhnRireki;
import yuyu.def.hozen.comparator.OrderIT_BAK_TesuuryouSyouhnRireki;

public class SortIT_BAK_TesuuryouSyouhnRireki {

    public List<IT_BAK_TesuuryouSyouhnRireki> OrderIT_BAK_TesuuryouSyouhnRirekiByPkAsc(List<IT_BAK_TesuuryouSyouhnRireki> pEntity) {
        List<SortCondition<IT_BAK_TesuuryouSyouhnRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhnRireki()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhnRireki()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhnRireki()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhnRireki()).tsrysyorikbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhnRireki()).renno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhnRireki()).syutkkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhnRireki()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhnRireki()).syouhnsdno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhnRireki()).kyksyouhnrenno, SortOrder.ASC));
        List<IT_BAK_TesuuryouSyouhnRireki> copyList = new ArrayList<IT_BAK_TesuuryouSyouhnRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_TesuuryouSyouhnRireki(orders));
        return copyList;
    }

    public List<IT_BAK_TesuuryouSyouhnRireki> OrderIT_BAK_TesuuryouSyouhnRirekiByPkDesc(List<IT_BAK_TesuuryouSyouhnRireki> pEntity) {
        List<SortCondition<IT_BAK_TesuuryouSyouhnRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhnRireki()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhnRireki()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhnRireki()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhnRireki()).tsrysyorikbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhnRireki()).renno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhnRireki()).syutkkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhnRireki()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhnRireki()).syouhnsdno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_TesuuryouSyouhnRireki()).kyksyouhnrenno, SortOrder.DESC));
        List<IT_BAK_TesuuryouSyouhnRireki> copyList = new ArrayList<IT_BAK_TesuuryouSyouhnRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_TesuuryouSyouhnRireki(orders));
        return copyList;
    }

}

