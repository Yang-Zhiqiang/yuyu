package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_HhknNenKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SjkkkTyouseiyouRiritu;
import yuyu.def.db.meta.QBM_SjkkkTyouseiyouRiritu;

/**
 * 市場価格調整用利率マスタ(BM_SjkkkTyouseiyouRirituDao) アクセス用の DAO クラスです。<br />
 */
public class BM_SjkkkTyouseiyouRirituDao extends AbstractDao<BM_SjkkkTyouseiyouRiritu> {

    public BM_SjkkkTyouseiyouRirituDao() {
        super(BM_SjkkkTyouseiyouRiritu.class);
    }

    public BM_SjkkkTyouseiyouRiritu getSjkkkTyouseiyouRiritu(String pSyouhncd,
        C_Tuukasyu pTuukasyu,
        C_HhknNenKbn pHhknnenkbn,
        BizDate pKykfromymd,
        BizDate pKyktoymd){
        BM_SjkkkTyouseiyouRiritu bM_SjkkkTyouseiyouRiritu =  new BM_SjkkkTyouseiyouRiritu();
        bM_SjkkkTyouseiyouRiritu.setSyouhncd(pSyouhncd);
        bM_SjkkkTyouseiyouRiritu.setTuukasyu(pTuukasyu);
        bM_SjkkkTyouseiyouRiritu.setHhknnenkbn(pHhknnenkbn);
        bM_SjkkkTyouseiyouRiritu.setKykfromymd(pKykfromymd);
        bM_SjkkkTyouseiyouRiritu.setKyktoymd(pKyktoymd);
        return this.selectOne(bM_SjkkkTyouseiyouRiritu);
    }

    public List<BM_SjkkkTyouseiyouRiritu> getSjkkkTyouseiyouRiritusByPK(
        String pSyouhncd, C_Tuukasyu pTuukasyu, C_HhknNenKbn pHhknnenkbn,
        BizDate pKykfromymd, BizDate pKyktoymd) {

        QBM_SjkkkTyouseiyouRiritu qBM_SjkkkTyouseiyouRiritu = new QBM_SjkkkTyouseiyouRiritu();


        String strSql = $SELECT + qBM_SjkkkTyouseiyouRiritu +
            $FROM + qBM_SjkkkTyouseiyouRiritu.BM_SjkkkTyouseiyouRiritu() +
            $WHERE + qBM_SjkkkTyouseiyouRiritu.syouhncd.eq(pSyouhncd) +
            $AND + qBM_SjkkkTyouseiyouRiritu.tuukasyu.eq(pTuukasyu) +
            $AND + qBM_SjkkkTyouseiyouRiritu.hhknnenkbn.eq(pHhknnenkbn) +
            $AND + qBM_SjkkkTyouseiyouRiritu.kykfromymd.le(pKykfromymd) +
            $AND + qBM_SjkkkTyouseiyouRiritu.kyktoymd.ge(pKyktoymd);

        return em.createJPQL(strSql).bind(qBM_SjkkkTyouseiyouRiritu).getResultList();
    }

    public List<BM_SjkkkTyouseiyouRiritu> getSjkkkTyouseiyouRiritusBy3PKMaxKyktoymd(String pSyouhncd, C_Tuukasyu pTuukasyu, C_HhknNenKbn pHhknnenkbn) {


        QBM_SjkkkTyouseiyouRiritu qBM_SjkkkTyouseiyouRiritu = new QBM_SjkkkTyouseiyouRiritu();


        String subQuerry = $SELECT + $MAX(qBM_SjkkkTyouseiyouRiritu.kyktoymd) +
            $FROM + qBM_SjkkkTyouseiyouRiritu.BM_SjkkkTyouseiyouRiritu() +
            $WHERE + qBM_SjkkkTyouseiyouRiritu.syouhncd.eq(pSyouhncd) +
            $AND + qBM_SjkkkTyouseiyouRiritu.tuukasyu.eq(pTuukasyu) +
            $AND + qBM_SjkkkTyouseiyouRiritu.hhknnenkbn.eq(pHhknnenkbn);


        String strSql = $SELECT + qBM_SjkkkTyouseiyouRiritu +
            $FROM + qBM_SjkkkTyouseiyouRiritu.BM_SjkkkTyouseiyouRiritu() +
            $WHERE + qBM_SjkkkTyouseiyouRiritu.syouhncd.eq(pSyouhncd) +
            $AND + qBM_SjkkkTyouseiyouRiritu.tuukasyu.eq(pTuukasyu) +
            $AND + qBM_SjkkkTyouseiyouRiritu.hhknnenkbn.eq(pHhknnenkbn) +
            $AND + qBM_SjkkkTyouseiyouRiritu.kyktoymd + $EQ + "(" + subQuerry + ")";

        return em.createJPQL(strSql).bind(qBM_SjkkkTyouseiyouRiritu).getResultList();
    }

    public List<BM_SjkkkTyouseiyouRiritu> getSjkkkTyouseiyouRiritusByPKKykymd(String pSyouhncd, C_Tuukasyu pTuukasyu,
        C_HhknNenKbn pHhknnenkbn, BizDate pKykymd) {


        QBM_SjkkkTyouseiyouRiritu qBM_SjkkkTyouseiyouRiritu = new QBM_SjkkkTyouseiyouRiritu();


        String strSql = $SELECT + qBM_SjkkkTyouseiyouRiritu +
            $FROM + qBM_SjkkkTyouseiyouRiritu.BM_SjkkkTyouseiyouRiritu() +
            $WHERE + qBM_SjkkkTyouseiyouRiritu.syouhncd.eq(pSyouhncd) +
            $AND + qBM_SjkkkTyouseiyouRiritu.tuukasyu.eq(pTuukasyu) +
            $AND + qBM_SjkkkTyouseiyouRiritu.hhknnenkbn.eq(pHhknnenkbn) +
            $AND + qBM_SjkkkTyouseiyouRiritu.kykfromymd.le(pKykymd) +
            $AND + qBM_SjkkkTyouseiyouRiritu.kyktoymd.ge(pKykymd);

        return em.createJPQL(strSql).bind(qBM_SjkkkTyouseiyouRiritu).getResultList();
    }

    public List<BM_SjkkkTyouseiyouRiritu> getSjkkkTyouseiyouRiritusByKyktoymdMax() {


        QBM_SjkkkTyouseiyouRiritu qBM_SjkkkTyouseiyouRiritu = new QBM_SjkkkTyouseiyouRiritu();


        String subquery = $SELECT + $MAX(qBM_SjkkkTyouseiyouRiritu.kyktoymd) +
            $FROM + qBM_SjkkkTyouseiyouRiritu.BM_SjkkkTyouseiyouRiritu();


        String mainQuery = $SELECT + qBM_SjkkkTyouseiyouRiritu +
            $FROM + qBM_SjkkkTyouseiyouRiritu.BM_SjkkkTyouseiyouRiritu() +
            $WHERE + qBM_SjkkkTyouseiyouRiritu.kyktoymd + $EQ + "(" + subquery + ")" +
            $ORDER_BY(qBM_SjkkkTyouseiyouRiritu.syouhncd.asc(),
                qBM_SjkkkTyouseiyouRiritu.tuukasyu.asc(),
                qBM_SjkkkTyouseiyouRiritu.hhknnenkbn.asc(),
                qBM_SjkkkTyouseiyouRiritu.kykfromymd.asc(),
                qBM_SjkkkTyouseiyouRiritu.kyktoymd.asc());

        return em.createJPQL(mainQuery).bind(qBM_SjkkkTyouseiyouRiritu).getResultList();
    }

    public List<BM_SjkkkTyouseiyouRiritu> getSjkkkTyouseiyouRiritusByPk(String pSyouhncd, C_Tuukasyu pTuukasyu,
        C_HhknNenKbn pHhknnenkbn, BizDate pKykymd) {

        QBM_SjkkkTyouseiyouRiritu qBM_SjkkkTyouseiyouRiritu = new QBM_SjkkkTyouseiyouRiritu();


        String strSql = $SELECT + qBM_SjkkkTyouseiyouRiritu +
            $FROM + qBM_SjkkkTyouseiyouRiritu.BM_SjkkkTyouseiyouRiritu() +
            $WHERE + qBM_SjkkkTyouseiyouRiritu.syouhncd.eq(pSyouhncd) +
            $AND + qBM_SjkkkTyouseiyouRiritu.tuukasyu.eq(pTuukasyu) +
            $AND + qBM_SjkkkTyouseiyouRiritu.hhknnenkbn.eq(pHhknnenkbn) +
            $AND + qBM_SjkkkTyouseiyouRiritu.kykfromymd.le(pKykymd) +
            $AND + qBM_SjkkkTyouseiyouRiritu.kyktoymd.ge(pKykymd);

        return em.createJPQL(strSql).bind(qBM_SjkkkTyouseiyouRiritu).getResultList();
    }
}
