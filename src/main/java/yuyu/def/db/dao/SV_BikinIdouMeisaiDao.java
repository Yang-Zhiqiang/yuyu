package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.SV_BikinIdouMeisai;

/**
 * 備金異動明細情報ビュー(SV_BikinIdouMeisaiDao) アクセス用の DAO クラスです。<br />
 */
public class SV_BikinIdouMeisaiDao extends AbstractDao<SV_BikinIdouMeisai> {

    public SV_BikinIdouMeisaiDao() {
        super(SV_BikinIdouMeisai.class);
    }

    public SV_BikinIdouMeisai getBikinIdouMeisai(String pSyono, String pGyoumuKousinKinou, String pGyoumuKousinTime) {
        SV_BikinIdouMeisai sV_BikinIdouMeisai =  new SV_BikinIdouMeisai();
        sV_BikinIdouMeisai.setSyono(pSyono);
        sV_BikinIdouMeisai.setGyoumuKousinKinou(pGyoumuKousinKinou);
        sV_BikinIdouMeisai.setGyoumuKousinTime(pGyoumuKousinTime);
        return this.selectOne(sV_BikinIdouMeisai);
    }
}
