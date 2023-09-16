package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.BM_YoteiRiritu2;
import yuyu.def.db.meta.QBM_YoteiRiritu2;

/**
 * 予定利率マスタ２(BM_YoteiRiritu2Dao) アクセス用の DAO クラスです。<br />
 */
public class BM_YoteiRiritu2Dao extends AbstractDao<BM_YoteiRiritu2> {

    public BM_YoteiRiritu2Dao() {
        super(BM_YoteiRiritu2.class);
    }

    @Deprecated
    public BM_YoteiRiritu2 getYoteiRiritu2(String pSyouhncd, String pYoteiriritutkybr1, String pYoteiriritutkybr2, BizDate pKijyunfromymd, BizDate pKijyuntoymd) {
        BM_YoteiRiritu2 bM_YoteiRiritu2 =  new BM_YoteiRiritu2();
        bM_YoteiRiritu2.setSyouhncd(pSyouhncd);
        bM_YoteiRiritu2.setYoteiriritutkybr1(pYoteiriritutkybr1);
        bM_YoteiRiritu2.setYoteiriritutkybr2(pYoteiriritutkybr2);
        bM_YoteiRiritu2.setKijyunfromymd(pKijyunfromymd);
        bM_YoteiRiritu2.setKijyuntoymd(pKijyuntoymd);
        return this.selectOne(bM_YoteiRiritu2);
    }

    @Override
    @Deprecated
    public List<BM_YoteiRiritu2> selectAll() {
        return super.selectAll();
    }

    public List<BM_YoteiRiritu2> getYoteiRiritu2sByKijyuntoymdMax() {


        QBM_YoteiRiritu2 qBM_YoteiRiritu2 = new QBM_YoteiRiritu2();


        String subquery = $SELECT + $MAX(qBM_YoteiRiritu2.kijyuntoymd) +
                $FROM + qBM_YoteiRiritu2.BM_YoteiRiritu2();


        String mainQuery = $SELECT + qBM_YoteiRiritu2 +
                $FROM + qBM_YoteiRiritu2.BM_YoteiRiritu2() +
                $WHERE + qBM_YoteiRiritu2.kijyuntoymd + $EQ + "(" + subquery + ")" +
                $ORDER_BY(qBM_YoteiRiritu2.syouhncd.asc(),
                        qBM_YoteiRiritu2.yoteiriritutkybr1.asc(),
                        qBM_YoteiRiritu2.yoteiriritutkybr2.asc(),
                        qBM_YoteiRiritu2.kijyunfromymd.asc(),
                        qBM_YoteiRiritu2.kijyuntoymd.asc());

        return em.createJPQL(mainQuery).bind(qBM_YoteiRiritu2).getResultList();
    }

    public List<BM_YoteiRiritu2> getYoteiRiritu2sBySyouhncdKijyuntoymdMax(String pSyouhncd) {


        QBM_YoteiRiritu2 qBM_YoteiRiritu2 = new QBM_YoteiRiritu2();


        String subquery = $SELECT + $MAX(qBM_YoteiRiritu2.kijyuntoymd) +
                $FROM + qBM_YoteiRiritu2.BM_YoteiRiritu2() +
                $WHERE + qBM_YoteiRiritu2.syouhncd.eq(pSyouhncd);


        String mainQuery = $SELECT + qBM_YoteiRiritu2 +
                $FROM + qBM_YoteiRiritu2.BM_YoteiRiritu2() +
                $WHERE + qBM_YoteiRiritu2.kijyuntoymd + $EQ + "(" + subquery + ")" +
                $AND + qBM_YoteiRiritu2.syouhncd.eq(pSyouhncd) +
                $ORDER_BY(qBM_YoteiRiritu2.syouhncd.asc(),
                        qBM_YoteiRiritu2.yoteiriritutkybr1.asc(),
                        qBM_YoteiRiritu2.yoteiriritutkybr2.asc(),
                        qBM_YoteiRiritu2.kijyunfromymd.asc(),
                        qBM_YoteiRiritu2.kijyuntoymd.asc());

        return em.createJPQL(mainQuery).bind(qBM_YoteiRiritu2).getResultList();
    }
}
