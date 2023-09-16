package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.db.entity.BT_SinkeiyakuHurikaeDen;
import yuyu.def.db.meta.QBT_SinkeiyakuHurikaeDen;

/**
 * 新契約振替伝票作成用テーブル(BT_SinkeiyakuHurikaeDenDao) アクセス用の DAO クラスです。<br />
 */
public class BT_SinkeiyakuHurikaeDenDao extends AbstractDao<BT_SinkeiyakuHurikaeDen> {

    public BT_SinkeiyakuHurikaeDenDao() {
        super(BT_SinkeiyakuHurikaeDen.class);
    }

    public BT_SinkeiyakuHurikaeDen getSinkeiyakuHurikaeDen(C_DensysKbn pDensyskbn,
        String pDenrenno,
        Integer pEdano){
        BT_SinkeiyakuHurikaeDen bT_SinkeiyakuHurikaeDen =  new BT_SinkeiyakuHurikaeDen();
        bT_SinkeiyakuHurikaeDen.setDensyskbn(pDensyskbn);
        bT_SinkeiyakuHurikaeDen.setDenrenno(pDenrenno);
        bT_SinkeiyakuHurikaeDen.setEdano(pEdano);
        return this.selectOne(bT_SinkeiyakuHurikaeDen);
    }

    public ExDBResults<BT_SinkeiyakuHurikaeDen> getSinkeiyakuHurikaeDensByKakutyoujobcdSyoriYmd(BizDate pSyoriYmd) {


        QBT_SinkeiyakuHurikaeDen qBT_SinkeiyakuHurikaeDen = new QBT_SinkeiyakuHurikaeDen();

        String queryStr = $SELECT + qBT_SinkeiyakuHurikaeDen +
            $FROM + qBT_SinkeiyakuHurikaeDen.BT_SinkeiyakuHurikaeDen() +
            $WHERE + qBT_SinkeiyakuHurikaeDen.syoriYmd.eq(pSyoriYmd) +
            $ORDER_BY(qBT_SinkeiyakuHurikaeDen.denymd.asc(),
                qBT_SinkeiyakuHurikaeDen.huridenatesakicd.asc(),
                qBT_SinkeiyakuHurikaeDen.taisyakukbn.asc(),
                qBT_SinkeiyakuHurikaeDen.denkanjokamokucd.asc(),
                qBT_SinkeiyakuHurikaeDen.naibukeiyakukbn.asc(),
                qBT_SinkeiyakuHurikaeDen.tekiyoukbn.asc());

        return em.createJPQL(queryStr).bind(qBT_SinkeiyakuHurikaeDen).getResults();
    }

    public ExDBResults<BT_SinkeiyakuHurikaeDen> getSinkeiyakuHurikaeDenHDpyousByKakutyoujobcdSyoriYmd(BizDate pSyoriYmd) {


        QBT_SinkeiyakuHurikaeDen qBT_SinkeiyakuHurikaeDen = new QBT_SinkeiyakuHurikaeDen();


        String strSql = $SELECT + qBT_SinkeiyakuHurikaeDen +
            $FROM + qBT_SinkeiyakuHurikaeDen.BT_SinkeiyakuHurikaeDen() +
            $WHERE + qBT_SinkeiyakuHurikaeDen.syoriYmd.eq(pSyoriYmd) +
            $AND + qBT_SinkeiyakuHurikaeDen.torihikino.ne("") +
            $ORDER_BY(qBT_SinkeiyakuHurikaeDen.torihikino.asc(),
                qBT_SinkeiyakuHurikaeDen.kanjyoukmkgroupkbn.asc(),
                qBT_SinkeiyakuHurikaeDen.denkanjokamokucd.asc(),
                qBT_SinkeiyakuHurikaeDen.taisyakukbn.asc(),
                qBT_SinkeiyakuHurikaeDen.naibukeiyakukbn.asc(),
                qBT_SinkeiyakuHurikaeDen.tekiyoukbn.asc());


        return em.createJPQL(strSql).bind(qBT_SinkeiyakuHurikaeDen).getResults();
    }

    public ExDBResults<BT_SinkeiyakuHurikaeDen> getSinkeiyakuHurikaeDensBySyoriYmd(
        BizDate pSyoriYmd) {


        QBT_SinkeiyakuHurikaeDen qBT_SinkeiyakuHurikaeDen = new QBT_SinkeiyakuHurikaeDen();


        String strsql = $SELECT + qBT_SinkeiyakuHurikaeDen +
            $FROM + qBT_SinkeiyakuHurikaeDen.BT_SinkeiyakuHurikaeDen() +
            $WHERE + qBT_SinkeiyakuHurikaeDen.syoriYmd.eq(pSyoriYmd) +
            $AND + qBT_SinkeiyakuHurikaeDen.torihikino.ne("") +
            $ORDER_BY(qBT_SinkeiyakuHurikaeDen.torihikino.asc(),
                qBT_SinkeiyakuHurikaeDen.taisyakukbn.asc(),
                qBT_SinkeiyakuHurikaeDen.denkanjokamokucd.asc(),
                qBT_SinkeiyakuHurikaeDen.naibukeiyakukbn.asc(),
                qBT_SinkeiyakuHurikaeDen.tekiyoukbn.asc());


        return em.createJPQL(strsql).bind(qBT_SinkeiyakuHurikaeDen).getResults();
    }
}
