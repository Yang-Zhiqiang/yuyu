package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.SV_HoyuuMeisai;

/**
 * 保有明細情報ビュー(SV_HoyuuMeisaiDao) アクセス用の DAO クラスです。<br />
 */
public class SV_HoyuuMeisaiDao extends AbstractDao<SV_HoyuuMeisai> {

    public SV_HoyuuMeisaiDao() {
        super(SV_HoyuuMeisai.class);
    }

    public SV_HoyuuMeisai getHoyuuMeisai(String pSyono) {
        SV_HoyuuMeisai sV_HoyuuMeisai =  new SV_HoyuuMeisai();
        sV_HoyuuMeisai.setSyono(pSyono);
        return this.selectOne(sV_HoyuuMeisai);
    }
}
