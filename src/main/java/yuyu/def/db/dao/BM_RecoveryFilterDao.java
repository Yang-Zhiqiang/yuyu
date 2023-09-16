package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_RecoveryFilter;

/**
 * リカバリフィルタマスタ(BM_RecoveryFilterDao) アクセス用の DAO クラスです。<br />
 */
public class BM_RecoveryFilterDao extends AbstractDao<BM_RecoveryFilter> {

    public BM_RecoveryFilterDao() {
        super(BM_RecoveryFilter.class);
    }

    public BM_RecoveryFilter getRecoveryFilter(String pRecoveryfilterid){
        BM_RecoveryFilter bM_RecoveryFilter =  new BM_RecoveryFilter();
        bM_RecoveryFilter.setRecoveryfilterid(pRecoveryfilterid);
        return this.selectOne(bM_RecoveryFilter);
    }
}
