package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IM_IktSyuunouRate;

/**
 * 一括収納率マスタ(IM_IktSyuunouRateDao) アクセス用の DAO クラスです。<br />
 */
public class IM_IktSyuunouRateDao extends AbstractDao<IM_IktSyuunouRate> {

    public IM_IktSyuunouRateDao() {
        super(IM_IktSyuunouRate.class);
    }

    public IM_IktSyuunouRate getIktSyuunouRate(String pSyouhncd,
         Integer pSyouhnsdno,
         Integer pIktkaisuu){
        IM_IktSyuunouRate iM_IktSyuunouRate =  new IM_IktSyuunouRate();
        iM_IktSyuunouRate.setSyouhncd(pSyouhncd);
        iM_IktSyuunouRate.setSyouhnsdno(pSyouhnsdno);
        iM_IktSyuunouRate.setIktkaisuu(pIktkaisuu);
        return this.selectOne(iM_IktSyuunouRate);
    }
}
