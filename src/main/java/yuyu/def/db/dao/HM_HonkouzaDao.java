package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HM_Honkouza;

/**
 * 本口座マスタ(HM_HonkouzaDao) アクセス用の DAO クラスです。<br />
 */
public class HM_HonkouzaDao extends AbstractDao<HM_Honkouza> {

    public HM_HonkouzaDao() {
        super(HM_Honkouza.class);
    }

    public HM_Honkouza getHonkouza(String pHonkouzacd) {
        HM_Honkouza hM_Honkouza =  new HM_Honkouza();
        hM_Honkouza.setHonkouzacd(pHonkouzacd);
        return this.selectOne(hM_Honkouza);
    }
}
