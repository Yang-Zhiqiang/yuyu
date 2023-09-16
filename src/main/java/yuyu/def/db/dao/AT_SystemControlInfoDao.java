package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;

import yuyu.def.db.entity.AT_SystemControlInfo;

/**
 * システム制御情報テーブル(AT_SystemControlInfoDao) アクセス用の DAO クラスです。<br />
 */
public class AT_SystemControlInfoDao extends AbstractDao<AT_SystemControlInfo> {

    public AT_SystemControlInfoDao() {
        super(AT_SystemControlInfo.class);
    }

    public AT_SystemControlInfo getSystemControlInfo(String pSystemCtrlInfo) {
        AT_SystemControlInfo aT_SystemControlInfo =  new AT_SystemControlInfo();
        aT_SystemControlInfo.setSystemCtrlInfo(pSystemCtrlInfo);
        return this.selectOne(aT_SystemControlInfo);
    }
}
