package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.BM_SjkkkTyouseiyouRiritu2;
import yuyu.def.db.meta.QBM_SjkkkTyouseiyouRiritu2;

import java.util.List;

/**
 * 市場価格調整用利率マスタ２(BM_SjkkkTyouseiyouRiritu2Dao) アクセス用の DAO クラスです。<br />
 */
public class BM_SjkkkTyouseiyouRiritu2Dao extends AbstractDao<BM_SjkkkTyouseiyouRiritu2> {

    public BM_SjkkkTyouseiyouRiritu2Dao() {
        super(BM_SjkkkTyouseiyouRiritu2.class);
    }

    @Deprecated
    public BM_SjkkkTyouseiyouRiritu2 getSjkkkTyouseiyouRiritu2(String pSyouhncd, String pSjkkktyouseiriritutkybr1, String pSjkkktyouseiriritutkybr2, BizDate pKijyunfromymd, BizDate pKijyuntoymd) {
        BM_SjkkkTyouseiyouRiritu2 bM_SjkkkTyouseiyouRiritu2 =  new BM_SjkkkTyouseiyouRiritu2();
        bM_SjkkkTyouseiyouRiritu2.setSyouhncd(pSyouhncd);
        bM_SjkkkTyouseiyouRiritu2.setSjkkktyouseiriritutkybr1(pSjkkktyouseiriritutkybr1);
        bM_SjkkkTyouseiyouRiritu2.setSjkkktyouseiriritutkybr2(pSjkkktyouseiriritutkybr2);
        bM_SjkkkTyouseiyouRiritu2.setKijyunfromymd(pKijyunfromymd);
        bM_SjkkkTyouseiyouRiritu2.setKijyuntoymd(pKijyuntoymd);
        return this.selectOne(bM_SjkkkTyouseiyouRiritu2);
    }

    @Override
    @Deprecated
    public List<BM_SjkkkTyouseiyouRiritu2> selectAll() {
        return super.selectAll();
    }

    public List<BM_SjkkkTyouseiyouRiritu2> getSjkkkTyouseiyouRiritu2sByKijyuntoymdMax() {


        QBM_SjkkkTyouseiyouRiritu2 qBM_SjkkkTyouseiyouRiritu2 = new QBM_SjkkkTyouseiyouRiritu2();


        String subquery = $SELECT + $MAX(qBM_SjkkkTyouseiyouRiritu2.kijyuntoymd) +
            $FROM + qBM_SjkkkTyouseiyouRiritu2.BM_SjkkkTyouseiyouRiritu2();


        String mainQuery = $SELECT + qBM_SjkkkTyouseiyouRiritu2 +
            $FROM + qBM_SjkkkTyouseiyouRiritu2.BM_SjkkkTyouseiyouRiritu2() +
            $WHERE + qBM_SjkkkTyouseiyouRiritu2.kijyuntoymd + $EQ + "(" + subquery + ")" +
            $ORDER_BY(qBM_SjkkkTyouseiyouRiritu2.syouhncd.asc(),
                qBM_SjkkkTyouseiyouRiritu2.sjkkktyouseiriritutkybr1.asc(),
                qBM_SjkkkTyouseiyouRiritu2.sjkkktyouseiriritutkybr2.asc(),
                qBM_SjkkkTyouseiyouRiritu2.kijyunfromymd.asc(),
                qBM_SjkkkTyouseiyouRiritu2.kijyuntoymd.asc());

        return em.createJPQL(mainQuery).bind(qBM_SjkkkTyouseiyouRiritu2).getResultList();
    }

}
