package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HM_SyouhnTaniHonkouza;

/**
 * 商品単位本口座マスタ(HM_SyouhnTaniHonkouzaDao) アクセス用の DAO クラスです。<br />
 */
public class HM_SyouhnTaniHonkouzaDao extends AbstractDao<HM_SyouhnTaniHonkouza> {

    public HM_SyouhnTaniHonkouzaDao() {
        super(HM_SyouhnTaniHonkouza.class);
    }

    public HM_SyouhnTaniHonkouza getSyouhnTaniHonkouza(String pSyouhncd) {
        HM_SyouhnTaniHonkouza hM_SyouhnTaniHonkouza =  new HM_SyouhnTaniHonkouza();
        hM_SyouhnTaniHonkouza.setSyouhncd(pSyouhncd);
        return this.selectOne(hM_SyouhnTaniHonkouza);
    }
}
