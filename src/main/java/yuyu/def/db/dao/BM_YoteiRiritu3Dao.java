package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_YoteiRiritu3;
import yuyu.def.db.meta.QBM_YoteiRiritu3;

/**
 * 予定利率マスタ３(BM_YoteiRiritu3Dao) アクセス用の DAO クラスです。<br />
 */
public class BM_YoteiRiritu3Dao extends AbstractDao<BM_YoteiRiritu3> {

    public BM_YoteiRiritu3Dao() {
        super(BM_YoteiRiritu3.class);
    }

    public BM_YoteiRiritu3 getYoteiRiritu3(String pSyouhncd, C_Tuukasyu pTuukasyu, String pYoteiriritutkybr1, String pYoteiriritutkybr2, BizDate pKijyunfromymd, BizDate pKijyuntoymd) {
        BM_YoteiRiritu3 bM_YoteiRiritu3 =  new BM_YoteiRiritu3();
        bM_YoteiRiritu3.setSyouhncd(pSyouhncd);
        bM_YoteiRiritu3.setTuukasyu(pTuukasyu);
        bM_YoteiRiritu3.setYoteiriritutkybr1(pYoteiriritutkybr1);
        bM_YoteiRiritu3.setYoteiriritutkybr2(pYoteiriritutkybr2);
        bM_YoteiRiritu3.setKijyunfromymd(pKijyunfromymd);
        bM_YoteiRiritu3.setKijyuntoymd(pKijyuntoymd);
        return this.selectOne(bM_YoteiRiritu3);
    }

    public List<BM_YoteiRiritu3> getYoteiRiritu3sBySyouhncdKijyuntoymdMax(String pSyouhncd) {


        QBM_YoteiRiritu3 qBM_YoteiRiritu3 = new QBM_YoteiRiritu3("qBM_YoteiRiritu3");


        String subquery = $SELECT + $MAX(qBM_YoteiRiritu3.kijyuntoymd) +
            $FROM(qBM_YoteiRiritu3) +
            $WHERE + qBM_YoteiRiritu3.syouhncd.eq(pSyouhncd);


        String mainQuery = $SELECT + qBM_YoteiRiritu3 +
            $FROM(qBM_YoteiRiritu3) +
            $WHERE + qBM_YoteiRiritu3.kijyuntoymd + $EQ + $(subquery) +
            $AND + qBM_YoteiRiritu3.syouhncd.eq(pSyouhncd) +
            $ORDER_BY(qBM_YoteiRiritu3.syouhncd.asc(),
                qBM_YoteiRiritu3.tuukasyu.asc(),
                qBM_YoteiRiritu3.yoteiriritutkybr1.asc(),
                qBM_YoteiRiritu3.yoteiriritutkybr2.asc(),
                qBM_YoteiRiritu3.kijyunfromymd.asc(),
                qBM_YoteiRiritu3.kijyuntoymd.asc());

        return em.createJPQL(mainQuery).bind(qBM_YoteiRiritu3).getResultList();
    }
}
