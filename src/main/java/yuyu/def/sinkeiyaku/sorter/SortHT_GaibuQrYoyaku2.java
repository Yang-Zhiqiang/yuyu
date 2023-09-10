package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_GaibuQrYoyaku2;
import yuyu.def.db.meta.QHT_GaibuQrYoyaku2;
import yuyu.def.sinkeiyaku.comparator.OrderHT_GaibuQrYoyaku2;

public class SortHT_GaibuQrYoyaku2 {

    
    public List<HT_GaibuQrYoyaku2> OrderHT_GaibuQrYoyaku2ByPkAsc(List<HT_GaibuQrYoyaku2> pEntity) {
        List<SortCondition<HT_GaibuQrYoyaku2>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_GaibuQrYoyaku2()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_GaibuQrYoyaku2()).skeijimukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_GaibuQrYoyaku2()).hknsyuruino, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_GaibuQrYoyaku2()).mosnosaibankbn, SortOrder.ASC));
        List<HT_GaibuQrYoyaku2> copyList = new ArrayList<HT_GaibuQrYoyaku2>(pEntity);
        Collections.sort(copyList, new OrderHT_GaibuQrYoyaku2(orders));
        return copyList;
    }

    
    public List<HT_GaibuQrYoyaku2> OrderHT_GaibuQrYoyaku2ByPkDesc(List<HT_GaibuQrYoyaku2> pEntity) {
        List<SortCondition<HT_GaibuQrYoyaku2>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_GaibuQrYoyaku2()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_GaibuQrYoyaku2()).skeijimukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_GaibuQrYoyaku2()).hknsyuruino, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_GaibuQrYoyaku2()).mosnosaibankbn, SortOrder.DESC));
        List<HT_GaibuQrYoyaku2> copyList = new ArrayList<HT_GaibuQrYoyaku2>(pEntity);
        Collections.sort(copyList, new OrderHT_GaibuQrYoyaku2(orders));
        return copyList;
    }
}
