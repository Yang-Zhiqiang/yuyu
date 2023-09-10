package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_GaibuQrYoyaku;
import yuyu.def.db.meta.QHT_GaibuQrYoyaku;
import yuyu.def.sinkeiyaku.comparator.OrderHT_GaibuQrYoyaku;

public class SortHT_GaibuQrYoyaku {

    
    public List<HT_GaibuQrYoyaku> OrderHT_GaibuQrYoyakuByPkAsc(List<HT_GaibuQrYoyaku> pEntity) {
        List<SortCondition<HT_GaibuQrYoyaku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_GaibuQrYoyaku()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_GaibuQrYoyaku()).skeijimukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_GaibuQrYoyaku()).hknsyuruino, SortOrder.ASC));
        List<HT_GaibuQrYoyaku> copyList = new ArrayList<HT_GaibuQrYoyaku>(pEntity);
        Collections.sort(copyList, new OrderHT_GaibuQrYoyaku(orders));
        return copyList;
    }

    
    public List<HT_GaibuQrYoyaku> OrderHT_GaibuQrYoyakuByPkDesc(List<HT_GaibuQrYoyaku> pEntity) {
        List<SortCondition<HT_GaibuQrYoyaku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_GaibuQrYoyaku()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_GaibuQrYoyaku()).skeijimukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_GaibuQrYoyaku()).hknsyuruino, SortOrder.DESC));
        List<HT_GaibuQrYoyaku> copyList = new ArrayList<HT_GaibuQrYoyaku>(pEntity);
        Collections.sort(copyList, new OrderHT_GaibuQrYoyaku(orders));
        return copyList;
    }

}

