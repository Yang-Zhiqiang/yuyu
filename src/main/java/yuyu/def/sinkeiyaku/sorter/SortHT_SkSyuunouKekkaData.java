package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_SkSyuunouKekkaData;
import yuyu.def.db.meta.QHT_SkSyuunouKekkaData;
import yuyu.def.sinkeiyaku.comparator.OrderHT_SkSyuunouKekkaData;

public class SortHT_SkSyuunouKekkaData {

    
    public List<HT_SkSyuunouKekkaData> OrderHT_SkSyuunouKekkaDataByPkAsc(List<HT_SkSyuunouKekkaData> pEntity) {
        List<SortCondition<HT_SkSyuunouKekkaData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkSyuunouKekkaData()).ansyuusyskbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkSyuunouKekkaData()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkSyuunouKekkaData()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkSyuunouKekkaData()).jyuutouym, SortOrder.ASC));
        List<HT_SkSyuunouKekkaData> copyList = new ArrayList<HT_SkSyuunouKekkaData>(pEntity);
        Collections.sort(copyList, new OrderHT_SkSyuunouKekkaData(orders));
        return copyList;
    }

    
    public List<HT_SkSyuunouKekkaData> OrderHT_SkSyuunouKekkaDataByPkDesc(List<HT_SkSyuunouKekkaData> pEntity) {
        List<SortCondition<HT_SkSyuunouKekkaData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkSyuunouKekkaData()).ansyuusyskbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkSyuunouKekkaData()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkSyuunouKekkaData()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkSyuunouKekkaData()).jyuutouym, SortOrder.DESC));
        List<HT_SkSyuunouKekkaData> copyList = new ArrayList<HT_SkSyuunouKekkaData>(pEntity);
        Collections.sort(copyList, new OrderHT_SkSyuunouKekkaData(orders));
        return copyList;
    }

}

