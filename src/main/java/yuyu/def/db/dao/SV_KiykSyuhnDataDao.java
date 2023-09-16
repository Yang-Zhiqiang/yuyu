package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.meta.QSV_KiykSyuhnData;

/**
 * 契約商品情報ビュー(SV_KiykSyuhnDataDao) アクセス用の DAO クラスです。<br />
 */
public class SV_KiykSyuhnDataDao extends AbstractDao<SV_KiykSyuhnData> {

    public SV_KiykSyuhnDataDao() {
        super(SV_KiykSyuhnData.class);
    }

    public SV_KiykSyuhnData getKiykSyuhnData(String pSyono, C_SyutkKbn pSyutkkbn, String pSyouhncd, Integer pSyouhnsdno, Integer pKyksyouhnrenno, String pHenkousikibetukey) {
        SV_KiykSyuhnData sV_KiykSyuhnData =  new SV_KiykSyuhnData();
        sV_KiykSyuhnData.setSyono(pSyono);
        sV_KiykSyuhnData.setSyutkkbn(pSyutkkbn);
        sV_KiykSyuhnData.setSyouhncd(pSyouhncd);
        sV_KiykSyuhnData.setSyouhnsdno(pSyouhnsdno);
        sV_KiykSyuhnData.setKyksyouhnrenno(pKyksyouhnrenno);
        sV_KiykSyuhnData.setHenkousikibetukey(pHenkousikibetukey);
        return this.selectOne(sV_KiykSyuhnData);
    }

    public List<SV_KiykSyuhnData> getKiykSyuhnDatasBySyonoSyutkkbn(String pSyono, C_SyutkKbn pSyutkkbn) {


        SV_KiykSyuhnData sV_KiykSyuhnData =  new SV_KiykSyuhnData();
        sV_KiykSyuhnData.setSyono(pSyono);
        sV_KiykSyuhnData.setSyutkkbn(pSyutkkbn);
        return select(sV_KiykSyuhnData);
    }

    public List<BizDate> getKiykSyuhnDataKouryokuhasseiymdsBySyonoHenkousikibetukey(String pSyono, String pHenkousikibetukey) {


        QSV_KiykSyuhnData qSV_KiykSyuhnData = new QSV_KiykSyuhnData("qSV_KiykSyuhnData");


        String strSql = $SELECT + qSV_KiykSyuhnData.kouryokuhasseiymd +
            $FROM + qSV_KiykSyuhnData.SV_KiykSyuhnData() +
            $WHERE + qSV_KiykSyuhnData.syono.eq(pSyono) +
            $AND + qSV_KiykSyuhnData.henkousikibetukey.eq(pHenkousikibetukey);


        return em.createJPQL(strSql).bind(qSV_KiykSyuhnData).getResultList();
    }

}
