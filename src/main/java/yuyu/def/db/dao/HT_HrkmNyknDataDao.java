package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.HT_HrkmNyknData;
import yuyu.def.db.meta.QHT_HrkmNyknData;

/**
 * 振込入金データテーブル(HT_HrkmNyknDataDao) アクセス用の DAO クラスです。<br />
 */
public class HT_HrkmNyknDataDao extends AbstractDao<HT_HrkmNyknData> {

    public HT_HrkmNyknDataDao() {
        super(HT_HrkmNyknData.class);
    }

    public HT_HrkmNyknData getHrkmNyknData(C_DensysKbn pDensyskbn,
        BizDate pSyoriYmd,
        String pItirenno){
        HT_HrkmNyknData hT_HrkmNyknData =  new HT_HrkmNyknData();
        hT_HrkmNyknData.setDensyskbn(pDensyskbn);
        hT_HrkmNyknData.setSyoriYmd(pSyoriYmd);
        hT_HrkmNyknData.setItirenno(pItirenno);
        return this.selectOne(hT_HrkmNyknData);
    }

    public List<HT_HrkmNyknData> getHrkmNyknDatasByMosnoOyadrtencdHrkmirninnmTrhkkgk(String pMosno, String pOyadrtencd,
        String pHrkmirninnm, BizCurrency pTrhkkgk) {


        HT_HrkmNyknData hT_HrkmNyknData = new HT_HrkmNyknData();


        hT_HrkmNyknData.setSyorizumiflg(C_Syorizumiflg.MISYORI);
        hT_HrkmNyknData.setNykmosno(pMosno);
        hT_HrkmNyknData.setOyadrtencd(pOyadrtencd);
        hT_HrkmNyknData.setHrkmirninnm(pHrkmirninnm);
        hT_HrkmNyknData.setTrhkkgk(pTrhkkgk);


        return select(hT_HrkmNyknData);
    }

    public List<HT_HrkmNyknData> getHrkmNyknDatasByBankcdSitencdItems(String pBankcd, String pSitencd,
        C_YokinKbn pYokinkbn, String pKouzano, BizCurrency pTrhkkgk, String pHrkmirninnm140, BizDate pSyoriYmd,
        Integer pIribaraikbn) {


        HT_HrkmNyknData hT_HrkmNyknData = new HT_HrkmNyknData();
        hT_HrkmNyknData.setSyorizumiflg(C_Syorizumiflg.MISYORI);
        hT_HrkmNyknData.setBankcd(pBankcd);
        hT_HrkmNyknData.setSitencd(pSitencd);
        hT_HrkmNyknData.setYokinkbn(pYokinkbn);
        hT_HrkmNyknData.setKouzano(pKouzano);
        hT_HrkmNyknData.setTrhkkgk(pTrhkkgk);
        hT_HrkmNyknData.setHrkmirninnm140(pHrkmirninnm140);
        hT_HrkmNyknData.setSyoriYmd(pSyoriYmd);
        hT_HrkmNyknData.setIribaraikbn(pIribaraikbn);


        return select(hT_HrkmNyknData);
    }

    public ExDBUpdatableResults<HT_HrkmNyknData> getHrkmNyknDatasByKakutyoujobcdSyorizumiflg(
        C_Syorizumiflg pSyorizumiflg) {


        QHT_HrkmNyknData qHT_HrkmNyknData = new QHT_HrkmNyknData();


        String strSql = $SELECT + qHT_HrkmNyknData +
            $FROM + qHT_HrkmNyknData.HT_HrkmNyknData() +
            $WHERE + qHT_HrkmNyknData.syorizumiflg.eq(pSyorizumiflg) +
            $ORDER_BY(qHT_HrkmNyknData.nykmosno,
                qHT_HrkmNyknData.syoriYmd);


        return em.createJPQL(strSql).bind(qHT_HrkmNyknData).getUpdatableResults();
    }

}
