package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_HrkmNyknSakujyo;
import yuyu.def.db.meta.QHT_HrkmNyknSakujyo;

/**
 * 振込入金削除テーブル(HT_HrkmNyknSakujyoDao) アクセス用の DAO クラスです。<br />
 */
public class HT_HrkmNyknSakujyoDao extends AbstractDao<HT_HrkmNyknSakujyo> {

    public HT_HrkmNyknSakujyoDao() {
        super(HT_HrkmNyknSakujyo.class);
    }

    public HT_HrkmNyknSakujyo getHrkmNyknSakujyo(String pHrkmdeldataskbtkey){
        HT_HrkmNyknSakujyo hT_HrkmNyknSakujyo =  new HT_HrkmNyknSakujyo();
        hT_HrkmNyknSakujyo.setHrkmdeldataskbtkey(pHrkmdeldataskbtkey);
        return this.selectOne(hT_HrkmNyknSakujyo);
    }

    public List<HT_HrkmNyknSakujyo> getHrkmNyknSakujyosBySyorizumiflg(C_Syorizumiflg pSyorizumiflg) {
        HT_HrkmNyknSakujyo hT_HrkmNyknSakujyo =  new HT_HrkmNyknSakujyo();
        hT_HrkmNyknSakujyo.setSyorizumiflg(pSyorizumiflg);
        return this.select(hT_HrkmNyknSakujyo);
    }

    public List<HT_HrkmNyknSakujyo> getHrkmNyknSakujyosByOyadrtencdMosnoHrkmirninnmTrhkkgkRstuukasyuSyorizumiflg(String pOyadrtencd, String pMosno, String pHrkmirninnm, BizCurrency pTrhkkgk, C_Tuukasyu pRstuukasyu, C_Syorizumiflg pSyorizumiflg) {
        HT_HrkmNyknSakujyo hT_HrkmNyknSakujyo = new HT_HrkmNyknSakujyo();

        hT_HrkmNyknSakujyo.setOyadrtencd(pOyadrtencd);
        hT_HrkmNyknSakujyo.setNykmosno(pMosno);
        hT_HrkmNyknSakujyo.setHrkmirninnm(pHrkmirninnm);
        hT_HrkmNyknSakujyo.setTrhkkgk(pTrhkkgk);
        hT_HrkmNyknSakujyo.setRstuukasyu(pRstuukasyu);
        hT_HrkmNyknSakujyo.setSyorizumiflg(pSyorizumiflg);

        return this.select(hT_HrkmNyknSakujyo);
    }

    public ExDBUpdatableResults<HT_HrkmNyknSakujyo> getHrkmNyknSakujyosByKakutyoujobcdSyorizumiflg(C_Syorizumiflg pSyorizumiflg) {


        QHT_HrkmNyknSakujyo qHT_HrkmNyknSakujyo = new QHT_HrkmNyknSakujyo("qHT_HrkmNyknSakujyo");


        String strSql = $SELECT + qHT_HrkmNyknSakujyo +
            $FROM(qHT_HrkmNyknSakujyo) +
            $WHERE + qHT_HrkmNyknSakujyo.syorizumiflg.eq(pSyorizumiflg) +
            $ORDER_BY(qHT_HrkmNyknSakujyo.gyoumuKousinTime.desc());


        return em.createJPQL(strSql).bind(qHT_HrkmNyknSakujyo).getUpdatableResults();
    }
}
