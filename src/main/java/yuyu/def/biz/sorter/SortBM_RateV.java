package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_RateV;
import yuyu.def.db.entity.BM_RateV;
import yuyu.def.db.meta.QBM_RateV;

public class SortBM_RateV {

    public List<BM_RateV> OrderBM_RateVByPkAsc(List<BM_RateV> pEntity) {
        List<SortCondition<BM_RateV>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_RateV()).palhokensyuruikigou, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateV()).palhokensyuruikigousdicode, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateV()).palyoteiriritu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateV()).palpmencode, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateV()).palharaikomikaisuu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateV()).palhhknsei, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateV()).palkeiyakujihhknnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateV()).palsaimankihyouji, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateV()).palhokenkikan, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RateV()).palpharaikomikikan, SortOrder.ASC));
        List<BM_RateV> copyList = new ArrayList<BM_RateV>(pEntity);
        Collections.sort(copyList, new OrderBM_RateV(orders));
        return copyList;
    }

    public List<BM_RateV> OrderBM_RateVByPkDesc(List<BM_RateV> pEntity) {
        List<SortCondition<BM_RateV>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_RateV()).palhokensyuruikigou, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateV()).palhokensyuruikigousdicode, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateV()).palyoteiriritu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateV()).palpmencode, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateV()).palharaikomikaisuu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateV()).palhhknsei, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateV()).palkeiyakujihhknnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateV()).palsaimankihyouji, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateV()).palhokenkikan, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RateV()).palpharaikomikikan, SortOrder.DESC));
        List<BM_RateV> copyList = new ArrayList<BM_RateV>(pEntity);
        Collections.sort(copyList, new OrderBM_RateV(orders));
        return copyList;
    }

}

