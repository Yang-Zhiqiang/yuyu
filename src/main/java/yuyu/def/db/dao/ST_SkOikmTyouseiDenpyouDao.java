package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.db.entity.ST_SkOikmTyouseiDenpyou;
import yuyu.def.db.meta.QBM_KanjyouKamoku;
import yuyu.def.db.meta.QBM_Segment;
import yuyu.def.db.meta.QBM_TantouCd;
import yuyu.def.db.meta.QST_SkOikmTyouseiDenpyou;
import yuyu.def.suuri.result.bean.SkOikmTyouseiDenpyouInfosBean;

/**
 * 新契約追込調整伝票データテーブル(ST_SkOikmTyouseiDenpyouDao) アクセス用の DAO クラスです。<br />
 */
public class ST_SkOikmTyouseiDenpyouDao extends AbstractDao<ST_SkOikmTyouseiDenpyou> {

    public ST_SkOikmTyouseiDenpyouDao() {
        super(ST_SkOikmTyouseiDenpyou.class);
    }

    public ST_SkOikmTyouseiDenpyou getSkOikmTyouseiDenpyou(String pMosno, C_Kanjyoukmkcd pKanjyoukmkcd, C_TaisyakuKbn pTaisyakukbn, C_NaibuKeiyakuKbn pNaibukeiyakukbn, C_TekiyouKbn pTekiyoukbn, C_Segcd pSeg1cd) {
        ST_SkOikmTyouseiDenpyou sT_SkOikmTyouseiDenpyou =  new ST_SkOikmTyouseiDenpyou();
        sT_SkOikmTyouseiDenpyou.setMosno(pMosno);
        sT_SkOikmTyouseiDenpyou.setKanjyoukmkcd(pKanjyoukmkcd);
        sT_SkOikmTyouseiDenpyou.setTaisyakukbn(pTaisyakukbn);
        sT_SkOikmTyouseiDenpyou.setNaibukeiyakukbn(pNaibukeiyakukbn);
        sT_SkOikmTyouseiDenpyou.setTekiyoukbn(pTekiyoukbn);
        sT_SkOikmTyouseiDenpyou.setSeg1cd(pSeg1cd);
        return this.selectOne(sT_SkOikmTyouseiDenpyou);
    }

    public ExDBResults<ST_SkOikmTyouseiDenpyou> getSkOikmTyouseiDenpyous() {


        QST_SkOikmTyouseiDenpyou qST_SkOikmTyouseiDenpyou = new QST_SkOikmTyouseiDenpyou();

        String strSql = $SELECT + qST_SkOikmTyouseiDenpyou +
            $FROM + qST_SkOikmTyouseiDenpyou.ST_SkOikmTyouseiDenpyou() ;

        return em.createJPQL(strSql).bind(qST_SkOikmTyouseiDenpyou).getResults();
    }

    public ExDBResults<SkOikmTyouseiDenpyouInfosBean> getSkOikmTyouseiDenpyouInfos() {


        QST_SkOikmTyouseiDenpyou qST_SkOikmTyouseiDenpyou = new QST_SkOikmTyouseiDenpyou("qST_SkOikmTyouseiDenpyou");

        QBM_KanjyouKamoku qBM_KanjyouKamoku = new QBM_KanjyouKamoku("qBM_KanjyouKamoku");

        QBM_Segment qBM_Segment = new QBM_Segment("qBM_Segment");

        QBM_TantouCd qBM_TantouCd = new QBM_TantouCd("qBM_TantouCd");

        String querySql = $SELECT + $NEW(SkOikmTyouseiDenpyouInfosBean.class,
            qST_SkOikmTyouseiDenpyou.kanjyoukmkcd,
            qST_SkOikmTyouseiDenpyou.taisyakukbn,
            qST_SkOikmTyouseiDenpyou.naibukeiyakukbn,
            qST_SkOikmTyouseiDenpyou.tekiyoukbn,
            qST_SkOikmTyouseiDenpyou.seg1cd,
            qST_SkOikmTyouseiDenpyou.denyenkagk.getTypeFieldName(),
            qST_SkOikmTyouseiDenpyou.denyenkagk.getValueFieldName(),
            qST_SkOikmTyouseiDenpyou.huridenatesakicd,
            qST_SkOikmTyouseiDenpyou.tantocd,
            qST_SkOikmTyouseiDenpyou.tekiyoucd,
            qBM_KanjyouKamoku.kanjyoukmkgroupkbn,
            qBM_KanjyouKamoku.kanjyoukmknm,
            qBM_Segment.segnm,
            qBM_TantouCd.busitunm) +
            $FROM (qST_SkOikmTyouseiDenpyou) +
            $LEFT_OUTER_JOIN + qST_SkOikmTyouseiDenpyou.BM_KanjyouKamoku() +
            $AS + qBM_KanjyouKamoku +
            $LEFT_OUTER_JOIN + qST_SkOikmTyouseiDenpyou.BM_Segment() +
            $AS + qBM_Segment +
            $LEFT_OUTER_JOIN + qST_SkOikmTyouseiDenpyou.BM_TantouCd() +
            $AS + qBM_TantouCd +
            $ORDER_BY(qST_SkOikmTyouseiDenpyou.huridenatesakicd.asc(),
                qST_SkOikmTyouseiDenpyou.tantocd.asc(),
                qBM_KanjyouKamoku.kanjyoukmkgroupkbn.asc(),
                qST_SkOikmTyouseiDenpyou.kanjyoukmkcd.asc(),
                qST_SkOikmTyouseiDenpyou.taisyakukbn.asc(),
                qST_SkOikmTyouseiDenpyou.naibukeiyakukbn.asc(),
                qST_SkOikmTyouseiDenpyou.tekiyoukbn.asc(),
                qST_SkOikmTyouseiDenpyou.seg1cd.asc());

        return em.createJPQL(querySql, SkOikmTyouseiDenpyouInfosBean.class).bind(qST_SkOikmTyouseiDenpyou, qBM_KanjyouKamoku, qBM_Segment, qBM_TantouCd).getResults();
    }
}
