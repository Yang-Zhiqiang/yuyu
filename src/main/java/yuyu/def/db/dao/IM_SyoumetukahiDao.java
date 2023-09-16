package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.db.entity.IM_Syoumetukahi;

/**
 * 消滅状態処理可否マスタ(IM_SyoumetukahiDao) アクセス用の DAO クラスです。<br />
 */
public class IM_SyoumetukahiDao extends AbstractDao<IM_Syoumetukahi> {

    public IM_SyoumetukahiDao() {
        super(IM_Syoumetukahi.class);
    }

    public IM_Syoumetukahi getSyoumetukahi(String pKinouId,
         C_Syoumetujiyuu pSyoumetujiyuu){
        IM_Syoumetukahi iM_Syoumetukahi =  new IM_Syoumetukahi();
        iM_Syoumetukahi.setKinouId(pKinouId);
        iM_Syoumetukahi.setSyoumetujiyuu(pSyoumetujiyuu);
        return this.selectOne(iM_Syoumetukahi);
    }
}
