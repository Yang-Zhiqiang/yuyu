package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_DsKrHnnKakCdTtYhKbn;
import yuyu.def.db.entity.MT_DsHonninKakuninCd;
import yuyu.def.db.meta.QMT_DsHonninKakuninCd;
import yuyu.def.db.meta.QMT_DsKokyakuKanri;
import yuyu.def.direct.result.bean.DsKokKnrInfosByDskrhnnkakcdttyhkbnSyoriYmdBean;
import yuyu.def.hozen.result.bean.KokyakuYuyukykMeisaiFTaisyouDataBean;

import java.util.List;

/**
 * ＤＳ本人確認コードテーブル(MT_DsHonninKakuninCdDao) アクセス用の DAO クラスです。<br />
 */
public class MT_DsHonninKakuninCdDao extends AbstractDao<MT_DsHonninKakuninCd> {

    public MT_DsHonninKakuninCdDao() {
        super(MT_DsHonninKakuninCd.class);
    }

    @Deprecated
    public MT_DsHonninKakuninCd getDsHonninKakuninCd(String pDskokno) {
        MT_DsHonninKakuninCd mT_DsHonninKakuninCd =  new MT_DsHonninKakuninCd();
        mT_DsHonninKakuninCd.setDskokno(pDskokno);
        return this.selectOne(mT_DsHonninKakuninCd);
    }

    @Override
    @Deprecated
    public List<MT_DsHonninKakuninCd> selectAll() {
        return super.selectAll();
    }
    public ExDBResults<MT_DsHonninKakuninCd> getDsHonninKakuninCdsByDskrhnnkakcdttshjyhsymd(
        BizDate pDskrhnnkakcdttshjyhsymd) {


        QMT_DsHonninKakuninCd qMT_DsHonninKakuninCd = new QMT_DsHonninKakuninCd();


        String queryStr = $SELECT + qMT_DsHonninKakuninCd +
            $FROM + qMT_DsHonninKakuninCd.MT_DsHonninKakuninCd() +
            $WHERE + qMT_DsHonninKakuninCd.dskrhnnkakcdttyhkbn.eq(C_DsKrHnnKakCdTtYhKbn.TYUUDAN) +
            $AND + qMT_DsHonninKakuninCd.dskrhnnkakcdttshjyhsymd.eq(pDskrhnnkakcdttshjyhsymd);


        return em.createJPQL(queryStr).bind(qMT_DsHonninKakuninCd).getResults();
    }

    public ExDBResults<DsKokKnrInfosByDskrhnnkakcdttyhkbnSyoriYmdBean> getDsKokKnrInfosByDskrhnnkakcdttyhkbnSyoriYmd(
        BizDate pSyoriYmd) {


        QMT_DsHonninKakuninCd qMT_DsHonninKakuninCd = new QMT_DsHonninKakuninCd();

        QMT_DsKokyakuKanri qMT_DsKokyakuKanri = new QMT_DsKokyakuKanri();


        String strSql = $SELECT +
            qMT_DsKokyakuKanri+ "," +
            qMT_DsHonninKakuninCd +
            $FROM  (qMT_DsKokyakuKanri,
                qMT_DsHonninKakuninCd) +
                $WHERE + qMT_DsHonninKakuninCd.dskrhnnkakcdttyhkbn.eq(C_DsKrHnnKakCdTtYhKbn.TYUUDAN) +
                $AND + qMT_DsHonninKakuninCd.dskrhnnkakcdttshjyhsymd.eq(pSyoriYmd) +
                $AND + qMT_DsKokyakuKanri.dskokno.eq(qMT_DsHonninKakuninCd.dskokno) +
                $ORDER_BY(qMT_DsKokyakuKanri.dskokno.asc());


        return em.createJPQL(strSql).bind(qMT_DsHonninKakuninCd, qMT_DsKokyakuKanri).getResults(DsKokKnrInfosByDskrhnnkakcdttyhkbnSyoriYmdBean.class);
    }
}
