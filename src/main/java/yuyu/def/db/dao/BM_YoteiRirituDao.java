package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_HhknNenKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_YoteiRiritu;
import yuyu.def.db.meta.QBM_YoteiRiritu;
import yuyu.def.db.meta.QHT_MosSyouhn;

/**
 * 予定利率マスタ(BM_YoteiRirituDao) アクセス用の DAO クラスです。<br />
 */
public class BM_YoteiRirituDao extends AbstractDao<BM_YoteiRiritu> {

    public BM_YoteiRirituDao() {
        super(BM_YoteiRiritu.class);
    }

    public BM_YoteiRiritu getYoteiRiritu(String pSyouhncd, C_Tuukasyu pTuukasyu, C_HhknNenKbn pHhknnenkbn, BizDate pKykfromymd, BizDate pKyktoymd) {
        BM_YoteiRiritu bM_YoteiRiritu =  new BM_YoteiRiritu();
        bM_YoteiRiritu.setSyouhncd(pSyouhncd);
        bM_YoteiRiritu.setTuukasyu(pTuukasyu);
        bM_YoteiRiritu.setHhknnenkbn(pHhknnenkbn);
        bM_YoteiRiritu.setKykfromymd(pKykfromymd);
        bM_YoteiRiritu.setKyktoymd(pKyktoymd);
        return this.selectOne(bM_YoteiRiritu);
    }

    public List<BM_YoteiRiritu> getYoteiRiritusBySyouhncdTuukasyuCalckijyunymd(String pSyouhncd, C_Tuukasyu pTuukasyu,
        BizDate pCalckijyunymd) {


        QBM_YoteiRiritu qBM_YoteiRiritu = new QBM_YoteiRiritu();

        String querySql = $SELECT + qBM_YoteiRiritu +
            $FROM + qBM_YoteiRiritu.BM_YoteiRiritu() +
            $WHERE + qBM_YoteiRiritu.syouhncd.eq(pSyouhncd) +
            $AND + qBM_YoteiRiritu.tuukasyu.eq(pTuukasyu) +
            $AND + qBM_YoteiRiritu.kykfromymd.le(pCalckijyunymd) +
            $AND + qBM_YoteiRiritu.kyktoymd.ge(pCalckijyunymd);

        return em.createJPQL(querySql).bind(qBM_YoteiRiritu).getResultList();
    }

    public List<BM_YoteiRiritu> getYoteiRiritusByMosnoSyutkkbnTuukasyuKykymd(String pMosno, C_SyutkKbn pSyutkkbn, C_Tuukasyu pTuukasyu, BizDate pKykymd) {


        QBM_YoteiRiritu qBM_YoteiRiritu = new QBM_YoteiRiritu();

        QHT_MosSyouhn qHT_MosSyouhn = new QHT_MosSyouhn();

        String strSql = $SELECT + qBM_YoteiRiritu +
            $FROM + qBM_YoteiRiritu.BM_YoteiRiritu() + "," +
            qHT_MosSyouhn.HT_MosSyouhn() +
            $WHERE + qHT_MosSyouhn.syouhncd.eq(qBM_YoteiRiritu.syouhncd) +
            $AND + qHT_MosSyouhn.mosno.eq(pMosno) +
            $AND + qHT_MosSyouhn.syutkkbn.eq(pSyutkkbn) +
            $AND + qBM_YoteiRiritu.tuukasyu.eq(pTuukasyu) +
            $AND + qBM_YoteiRiritu.kykfromymd.le(pKykymd) +
            $AND + qBM_YoteiRiritu.kyktoymd.ge(pKykymd);


        return em.createJPQL(strSql).bind(qBM_YoteiRiritu, qHT_MosSyouhn).getResultList();
    }

    public List<BM_YoteiRiritu> getYoteiRiritusByMosnoSyutkkbnTuukasyu(String pMosno, C_SyutkKbn pSyutkkbn, C_Tuukasyu pTuukasyu) {


        QBM_YoteiRiritu qBM_YoteiRiritu = new QBM_YoteiRiritu();

        QHT_MosSyouhn qHT_MosSyouhn = new QHT_MosSyouhn();


        String strSql = $SELECT + qBM_YoteiRiritu +
            $FROM + qBM_YoteiRiritu.BM_YoteiRiritu() +"," +
            qHT_MosSyouhn.HT_MosSyouhn() +
            $WHERE + qHT_MosSyouhn.syouhncd.eq(qBM_YoteiRiritu.syouhncd) +
            $AND + qHT_MosSyouhn.mosno.eq(pMosno) +
            $AND + qHT_MosSyouhn.syutkkbn.eq(pSyutkkbn) +
            $AND + qBM_YoteiRiritu.tuukasyu.eq(pTuukasyu) +
            $ORDER_BY(qBM_YoteiRiritu.kykfromymd.desc());


        return em.createJPQL(strSql).bind(qBM_YoteiRiritu, qHT_MosSyouhn).getResultList();
    }

    public List<BM_YoteiRiritu> getYoteiRiritusBySyouhncdTuukasyuKykfromymdKyktoymd(String pSyouhncd,
        C_Tuukasyu pTuukasyu, BizDate pKykymd) {


        QBM_YoteiRiritu qBM_YoteiRiritu = new QBM_YoteiRiritu();


        String strSql = $SELECT + qBM_YoteiRiritu +
            $FROM + qBM_YoteiRiritu.BM_YoteiRiritu() +
            $WHERE + qBM_YoteiRiritu.syouhncd.eq(pSyouhncd) +
            $AND + qBM_YoteiRiritu.tuukasyu.eq(pTuukasyu) +
            $AND + qBM_YoteiRiritu.kykfromymd.le(pKykymd) +
            $AND + qBM_YoteiRiritu.kyktoymd.ge(pKykymd);


        return em.createJPQL(strSql).bind(qBM_YoteiRiritu).getResultList();
    }

    public List<BM_YoteiRiritu> getYoteiRiritusBySyouhncdKykfromymdKyktoymd(String pSyouhncd, BizDate pKykymd) {


        QBM_YoteiRiritu qBM_YoteiRiritu = new QBM_YoteiRiritu();


        String strSql = $SELECT + qBM_YoteiRiritu +
            $FROM + qBM_YoteiRiritu.BM_YoteiRiritu() +
            $WHERE + qBM_YoteiRiritu.syouhncd.eq(pSyouhncd) +
            $AND + qBM_YoteiRiritu.kykfromymd.le(pKykymd) +
            $AND + qBM_YoteiRiritu.kyktoymd.ge(pKykymd);

        return em.createJPQL(strSql).bind(qBM_YoteiRiritu).getResultList();
    }

    public List<BM_YoteiRiritu> getYoteiRiritusByPK(String pSyouhncd, C_Tuukasyu pTuukasyu, C_HhknNenKbn pHhknnenkbn,
        BizDate pKykfromymd, BizDate pKyktoymd) {


        QBM_YoteiRiritu qBM_YoteiRiritu = new QBM_YoteiRiritu();


        String strSql = $SELECT + qBM_YoteiRiritu +
            $FROM + qBM_YoteiRiritu.BM_YoteiRiritu() +
            $WHERE + qBM_YoteiRiritu.syouhncd.eq(pSyouhncd) +
            $AND + qBM_YoteiRiritu.tuukasyu.eq(pTuukasyu) +
            $AND + qBM_YoteiRiritu.hhknnenkbn.eq(pHhknnenkbn) +
            $AND + qBM_YoteiRiritu.kykfromymd.le(pKykfromymd) +
            $AND + qBM_YoteiRiritu.kyktoymd.ge(pKyktoymd);

        return em.createJPQL(strSql).bind(qBM_YoteiRiritu).getResultList();
    }


    public List<BM_YoteiRiritu> getYoteiRiritusBySyouhncdTuukasyu(String pSyouhncd, C_Tuukasyu pTuukasyu) {
        BM_YoteiRiritu bM_YoteiRiritu =  new BM_YoteiRiritu();
        bM_YoteiRiritu.setSyouhncd(pSyouhncd);
        bM_YoteiRiritu.setTuukasyu(pTuukasyu);
        return this.select(bM_YoteiRiritu);
    }

    public List<BM_YoteiRiritu> getYoteiRiritusByKyktoymdMax() {


        QBM_YoteiRiritu qBM_YoteiRiritu = new QBM_YoteiRiritu();


        String subquery = $SELECT + $MAX(qBM_YoteiRiritu.kyktoymd) +
            $FROM + qBM_YoteiRiritu.BM_YoteiRiritu();


        String mainQuery = $SELECT + qBM_YoteiRiritu +
            $FROM + qBM_YoteiRiritu.BM_YoteiRiritu() +
            $WHERE + qBM_YoteiRiritu.kyktoymd + $EQ + "(" + subquery + ")" +
            $ORDER_BY(qBM_YoteiRiritu.syouhncd.asc(),
                qBM_YoteiRiritu.tuukasyu.asc(),
                qBM_YoteiRiritu.hhknnenkbn.asc(),
                qBM_YoteiRiritu.kykfromymd.asc(),
                qBM_YoteiRiritu.kyktoymd.asc());

        return em.createJPQL(mainQuery).bind(qBM_YoteiRiritu).getResultList();
    }

}
