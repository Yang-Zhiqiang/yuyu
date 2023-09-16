package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BT_SystemRenkei;

/**
 * システム間連携制御テーブル(BT_SystemRenkeiDao) アクセス用の DAO クラスです。<br />
 */
public class BT_SystemRenkeiDao extends AbstractDao<BT_SystemRenkei> {

    public BT_SystemRenkeiDao() {
        super(BT_SystemRenkei.class);
    }

    public BT_SystemRenkei getSystemRenkei(String pInterfaceid) {
        BT_SystemRenkei bT_SystemRenkei =  new BT_SystemRenkei();
        bT_SystemRenkei.setInterfaceid(pInterfaceid);
        return this.selectOne(bT_SystemRenkei);
    }

}
