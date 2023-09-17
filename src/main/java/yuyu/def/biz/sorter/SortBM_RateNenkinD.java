package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_RateNenkinD;
import yuyu.def.db.entity.BM_RateNenkinD;
import yuyu.def.db.meta.QBM_RateNenkinD;

public class SortBM_RateNenkinD {

    public List<BM_RateNenkinD> OrderBM_RateNenkinDByPkAsc(List<BM_RateNenkinD> pEntity) {
        List<SortCondition<BM_RateNenkinD>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_RateNenkinD()).palnenkinsisutemusyurui, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateNenkinD()).palnenkinsyuruikigou, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateNenkinD()).palnenkinkigousedaicode, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateNenkinD()).palnenkinsiharaikikan, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateNenkinD()).palnnknksgyoteiriritucode, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateNenkinD()).palnnknksgjmtesuuryoucode, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateNenkinD()).paldnendo, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateNenkinD()).paldratenaikakucode, SortOrder.ASC));
        List<BM_RateNenkinD> copyList = new ArrayList<BM_RateNenkinD>(pEntity);
        Collections.sort(copyList, new OrderBM_RateNenkinD(orders));
        return copyList;
    }

    public List<BM_RateNenkinD> OrderBM_RateNenkinDByPkDesc(List<BM_RateNenkinD> pEntity) {
        List<SortCondition<BM_RateNenkinD>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_RateNenkinD()).palnenkinsisutemusyurui, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateNenkinD()).palnenkinsyuruikigou, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateNenkinD()).palnenkinkigousedaicode, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateNenkinD()).palnenkinsiharaikikan, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateNenkinD()).palnnknksgyoteiriritucode, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateNenkinD()).palnnknksgjmtesuuryoucode, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateNenkinD()).paldnendo, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateNenkinD()).paldratenaikakucode, SortOrder.DESC));
        List<BM_RateNenkinD> copyList = new ArrayList<BM_RateNenkinD>(pEntity);
        Collections.sort(copyList, new OrderBM_RateNenkinD(orders));
        return copyList;
    }

}

