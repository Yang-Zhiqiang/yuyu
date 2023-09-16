package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.db.entity.ST_SkOikmSyukeiPDenpyou;
import yuyu.def.db.meta.QBM_KanjyouKamoku;
import yuyu.def.db.meta.QBM_Segment;
import yuyu.def.db.meta.QST_SkOikmSyukeiPDenpyou;
import yuyu.def.suuri.result.bean.SkOikmTyouseiDenpyouHkrDnpsBean;

/**
 * 新契約追込保険料伝票データテーブル(ST_SkOikmSyukeiPDenpyouDao) アクセス用の DAO クラスです。<br />
 */
public class ST_SkOikmSyukeiPDenpyouDao extends AbstractDao<ST_SkOikmSyukeiPDenpyou> {

    public ST_SkOikmSyukeiPDenpyouDao() {
        super(ST_SkOikmSyukeiPDenpyou.class);
    }

    public ST_SkOikmSyukeiPDenpyou getSkOikmSyukeiPDenpyou(C_DensysKbn pDensyskbn, String pDenrenno, Integer pEdano) {
        ST_SkOikmSyukeiPDenpyou sT_SkOikmSyukeiPDenpyou =  new ST_SkOikmSyukeiPDenpyou();
        sT_SkOikmSyukeiPDenpyou.setDensyskbn(pDensyskbn);
        sT_SkOikmSyukeiPDenpyou.setDenrenno(pDenrenno);
        sT_SkOikmSyukeiPDenpyou.setEdano(pEdano);
        return this.selectOne(sT_SkOikmSyukeiPDenpyou);
    }

    public ExDBResults<SkOikmTyouseiDenpyouHkrDnpsBean> getSkOikmTyouseiDenpyouHkrDnps() {


        QST_SkOikmSyukeiPDenpyou qST_SkOikmSyukeiPDenpyou = new QST_SkOikmSyukeiPDenpyou("qST_SkOikmSyukeiPDenpyou");

        QBM_KanjyouKamoku qBM_KanjyouKamoku = new QBM_KanjyouKamoku("qBM_KanjyouKamoku");

        QBM_Segment qBM_Segment = new QBM_Segment("qBM_Segment");


        String queryStr = $SELECT + $NEW(SkOikmTyouseiDenpyouHkrDnpsBean.class,
            qST_SkOikmSyukeiPDenpyou.kanjyoukmkcd,
            qST_SkOikmSyukeiPDenpyou.taisyakukbn,
            qST_SkOikmSyukeiPDenpyou.naibukeiyakukbn,
            qST_SkOikmSyukeiPDenpyou.tekiyoukbn,
            qST_SkOikmSyukeiPDenpyou.seg1cd,
            qST_SkOikmSyukeiPDenpyou.denyenkagk.getTypeFieldName(),
            qST_SkOikmSyukeiPDenpyou.denyenkagk.getValueFieldName(),
            qST_SkOikmSyukeiPDenpyou.huridenatesakicd,
            qST_SkOikmSyukeiPDenpyou.tantocd,
            qST_SkOikmSyukeiPDenpyou.tekiyoucd,
            qBM_KanjyouKamoku.kanjyoukmkgroupkbn,
            qBM_KanjyouKamoku.kanjyoukmknm,
            qBM_Segment.segnm) +
            $FROM + qST_SkOikmSyukeiPDenpyou.ST_SkOikmSyukeiPDenpyou() +
            $LEFT_OUTER_JOIN + qST_SkOikmSyukeiPDenpyou.BM_KanjyouKamoku() +
            $AS + qBM_KanjyouKamoku +
            $LEFT_OUTER_JOIN + qST_SkOikmSyukeiPDenpyou.BM_Segment() +
            $AS + qBM_Segment +
            $ORDER_BY(qST_SkOikmSyukeiPDenpyou.huridenatesakicd.asc(),
                qST_SkOikmSyukeiPDenpyou.tantocd.asc(),
                qBM_KanjyouKamoku.kanjyoukmkgroupkbn.asc(),
                qST_SkOikmSyukeiPDenpyou.kanjyoukmkcd.asc(),
                qST_SkOikmSyukeiPDenpyou.taisyakukbn.asc(),
                qST_SkOikmSyukeiPDenpyou.naibukeiyakukbn.asc(),
                qST_SkOikmSyukeiPDenpyou.tekiyoukbn.asc(),
                qST_SkOikmSyukeiPDenpyou.seg1cd.asc());

        return em.createJPQL(queryStr, SkOikmTyouseiDenpyouHkrDnpsBean.class).bind(qST_SkOikmSyukeiPDenpyou, qBM_KanjyouKamoku, qBM_Segment).getResults();
    }
}
