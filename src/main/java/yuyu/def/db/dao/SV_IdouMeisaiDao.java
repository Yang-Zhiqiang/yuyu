package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.SV_IdouMeisai;

/**
 * 異動明細情報ビュー(SV_IdouMeisaiDao) アクセス用の DAO クラスです。<br />
 */
public class SV_IdouMeisaiDao extends AbstractDao<SV_IdouMeisai> {

    public SV_IdouMeisaiDao() {
        super(SV_IdouMeisai.class);
    }

    public SV_IdouMeisai getIdouMeisai(String pSyono, String pGyoumuKousinKinou, String pGyoumuKousinTime) {
        SV_IdouMeisai sV_IdouMeisai =  new SV_IdouMeisai();
        sV_IdouMeisai.setSyono(pSyono);
        sV_IdouMeisai.setGyoumuKousinKinou(pGyoumuKousinKinou);
        sV_IdouMeisai.setGyoumuKousinTime(pGyoumuKousinTime);
        return this.selectOne(sV_IdouMeisai);
    }
}
