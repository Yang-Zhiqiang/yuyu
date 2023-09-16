package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_KijyungkHanteiKawaseRate;

/**
 * 基準額判定用為替レートマスタ(BM_KijyungkHanteiKawaseRateDao) アクセス用の DAO クラスです。<br />
 */
public class BM_KijyungkHanteiKawaseRateDao extends AbstractDao<BM_KijyungkHanteiKawaseRate> {

    public BM_KijyungkHanteiKawaseRateDao() {
        super(BM_KijyungkHanteiKawaseRate.class);
    }

    public BM_KijyungkHanteiKawaseRate getKijyungkHanteiKawaseRate(String pKijunnendo, C_Tuukasyu pKyktuukasyu) {
        BM_KijyungkHanteiKawaseRate bM_KijyungkHanteiKawaseRate =  new BM_KijyungkHanteiKawaseRate();
        bM_KijyungkHanteiKawaseRate.setKijunnendo(pKijunnendo);
        bM_KijyungkHanteiKawaseRate.setKyktuukasyu(pKyktuukasyu);
        return this.selectOne(bM_KijyungkHanteiKawaseRate);
    }
}
