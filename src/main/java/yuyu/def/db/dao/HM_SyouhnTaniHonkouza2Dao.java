package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HM_SyouhnTaniHonkouza2;

/**
 * 商品単位本口座マスタ２(HM_SyouhnTaniHonkouza2Dao) アクセス用の DAO クラスです。<br />
 */
public class HM_SyouhnTaniHonkouza2Dao extends AbstractDao<HM_SyouhnTaniHonkouza2> {

    public HM_SyouhnTaniHonkouza2Dao() {
        super(HM_SyouhnTaniHonkouza2.class);
    }

    public HM_SyouhnTaniHonkouza2 getSyouhnTaniHonkouza2(String pSyouhncd, C_Tuukasyu pKyktuukasyu) {
        HM_SyouhnTaniHonkouza2 hM_SyouhnTaniHonkouza2 =  new HM_SyouhnTaniHonkouza2();
        hM_SyouhnTaniHonkouza2.setSyouhncd(pSyouhncd);
        hM_SyouhnTaniHonkouza2.setKyktuukasyu(pKyktuukasyu);
        return this.selectOne(hM_SyouhnTaniHonkouza2);
    }
}
