package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_RateNenkinPkisoV;
import yuyu.def.db.entity.BM_RateNenkinPkisoV;
import yuyu.def.db.meta.QBM_RateNenkinPkisoV;

public class SortBM_RateNenkinPkisoV {

    public List<BM_RateNenkinPkisoV> OrderBM_RateNenkinPkisoVByPkAsc(List<BM_RateNenkinPkisoV> pEntity) {
        List<SortCondition<BM_RateNenkinPkisoV>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_RateNenkinPkisoV()).palnenkinsisutemusyurui, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateNenkinPkisoV()).palnenkinsyuruikigou, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateNenkinPkisoV()).palnenkinkigousedaicode, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateNenkinPkisoV()).palnenkinsiharaikikan, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateNenkinPkisoV()).palnnknksgyoteiriritucode, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateNenkinPkisoV()).palnnknksgjmtesuuryoucode, SortOrder.ASC));
        List<BM_RateNenkinPkisoV> copyList = new ArrayList<BM_RateNenkinPkisoV>(pEntity);
        Collections.sort(copyList, new OrderBM_RateNenkinPkisoV(orders));
        return copyList;
    }

    public List<BM_RateNenkinPkisoV> OrderBM_RateNenkinPkisoVByPkDesc(List<BM_RateNenkinPkisoV> pEntity) {
        List<SortCondition<BM_RateNenkinPkisoV>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_RateNenkinPkisoV()).palnenkinsisutemusyurui, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateNenkinPkisoV()).palnenkinsyuruikigou, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateNenkinPkisoV()).palnenkinkigousedaicode, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateNenkinPkisoV()).palnenkinsiharaikikan, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateNenkinPkisoV()).palnnknksgyoteiriritucode, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateNenkinPkisoV()).palnnknksgjmtesuuryoucode, SortOrder.DESC));
        List<BM_RateNenkinPkisoV> copyList = new ArrayList<BM_RateNenkinPkisoV>(pEntity);
        Collections.sort(copyList, new OrderBM_RateNenkinPkisoV(orders));
        return copyList;
    }

}

