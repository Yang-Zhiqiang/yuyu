package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.db.entity.ST_SkKessanSyukei;
import yuyu.def.db.meta.QBM_KanjyouKamoku;
import yuyu.def.db.meta.QBM_TantouCd;
import yuyu.def.db.meta.QST_SkKessanSyukei;

/**
 * 新契約決算用集計元データテーブル(ST_SkKessanSyukeiDao) アクセス用の DAO クラスです。<br />
 */
public class ST_SkKessanSyukeiDao extends AbstractDao<ST_SkKessanSyukei> {

    public ST_SkKessanSyukeiDao() {
        super(ST_SkKessanSyukei.class);
    }

    public ST_SkKessanSyukei getSkKessanSyukei(String pMosno, BizDate pDenymd, C_Kanjyoukmkcd pKanjyoukmkcd, C_TaisyakuKbn pTaisyakukbn, C_NaibuKeiyakuKbn pNaibukeiyakukbn, C_TekiyouKbn pTekiyoukbn, C_Segcd pSeg1cd) {
        ST_SkKessanSyukei sT_SkKessanSyukei =  new ST_SkKessanSyukei();
        sT_SkKessanSyukei.setMosno(pMosno);
        sT_SkKessanSyukei.setDenymd(pDenymd);
        sT_SkKessanSyukei.setKanjyoukmkcd(pKanjyoukmkcd);
        sT_SkKessanSyukei.setTaisyakukbn(pTaisyakukbn);
        sT_SkKessanSyukei.setNaibukeiyakukbn(pNaibukeiyakukbn);
        sT_SkKessanSyukei.setTekiyoukbn(pTekiyoukbn);
        sT_SkKessanSyukei.setSeg1cd(pSeg1cd);
        return this.selectOne(sT_SkKessanSyukei);
    }

    public List<ST_SkKessanSyukei> getSkKessanSyukeisByDenymd(BizDate pDenymd) {


        QST_SkKessanSyukei qST_SkKessanSyukei = new QST_SkKessanSyukei();

        String queryStr = $SELECT + qST_SkKessanSyukei+
                $FROM(qST_SkKessanSyukei) +
            $WHERE + qST_SkKessanSyukei.denymd.ge(pDenymd) +
                $ORDER_BY (qST_SkKessanSyukei.denymd.asc(),
                        qST_SkKessanSyukei.huridenpagekbn.asc(),
                        qST_SkKessanSyukei.huridenatesakicd.asc(),
                        qST_SkKessanSyukei.denkanjokamokucd.asc(),
                        qST_SkKessanSyukei.taisyakukbn.asc(),
                        qST_SkKessanSyukei.naibukeiyakukbn.asc(),
                        qST_SkKessanSyukei.tekiyoukbn.asc());

        return em.createJPQL(queryStr).bind(qST_SkKessanSyukei).getResultList();
    }

    public List<ST_SkKessanSyukei> getSkKessanSyukeisBySeg1cdDenymd(BizDate pDenymd) {


        QST_SkKessanSyukei qST_SkKessanSyukei = new QST_SkKessanSyukei();

        String strSql = $SELECT + qST_SkKessanSyukei +
            $FROM(qST_SkKessanSyukei) +
            $WHERE + $(qST_SkKessanSyukei.seg1cd.ne(C_Segcd.BLNK) +
                $AND + qST_SkKessanSyukei.seg1cd.isNotNull()) +
                $AND + qST_SkKessanSyukei.denymd.ge(pDenymd) +
                $ORDER_BY (qST_SkKessanSyukei.denymd.asc(),
                    qST_SkKessanSyukei.huridenpagekbn.asc(),
                    qST_SkKessanSyukei.huridenatesakicd.asc(),
                    qST_SkKessanSyukei.denkanjokamokucd.asc(),
                    qST_SkKessanSyukei.taisyakukbn.asc(),
                    qST_SkKessanSyukei.naibukeiyakukbn.asc(),
                    qST_SkKessanSyukei.tekiyoukbn.asc(),
                    qST_SkKessanSyukei.seg1cd.asc());

        return em.createJPQL(strSql).bind(qST_SkKessanSyukei).getResultList();
    }

    public List<ST_SkKessanSyukei> getSkKessanSyukeisKanjyouKamokuTantouCdByDenymd(BizDate pDenymd) {


        QST_SkKessanSyukei qST_SkKessanSyukei = new QST_SkKessanSyukei("qST_SkKessanSyukei");


        QBM_KanjyouKamoku qBM_KanjyouKamoku = new QBM_KanjyouKamoku("qBM_KanjyouKamoku");


        QBM_TantouCd qBM_TantouCd = new QBM_TantouCd("qBM_TantouCd");

        String strSql = $SELECT + qST_SkKessanSyukei +
                $FROM(qST_SkKessanSyukei) +
            $LEFT_OUTER_JOIN + qST_SkKessanSyukei.BM_KanjyouKamoku() +
            $AS + qBM_KanjyouKamoku +
            $LEFT_OUTER_JOIN + qST_SkKessanSyukei.BM_TantouCd() +
            $AS + qBM_TantouCd +
            $WHERE + qST_SkKessanSyukei.denymd.ge(pDenymd) +
                $ORDER_BY (qST_SkKessanSyukei.denymd.asc(),
                qST_SkKessanSyukei.huridenpagekbn.asc(),
                        qST_SkKessanSyukei.huridenatesakicd.asc(),
                        qST_SkKessanSyukei.tantocd.asc(),
                qBM_KanjyouKamoku.kanjyoukmkgroupkbn.asc(),
                qST_SkKessanSyukei.denkanjokamokucd.asc(),
                        qST_SkKessanSyukei.taisyakukbn.asc(),
                qST_SkKessanSyukei.naibukeiyakukbn.asc(),
                        qST_SkKessanSyukei.tekiyoukbn.asc());

        return em.createJPQL(strSql).bind(qST_SkKessanSyukei, qBM_KanjyouKamoku, qBM_TantouCd).getResultList();
    }
}
