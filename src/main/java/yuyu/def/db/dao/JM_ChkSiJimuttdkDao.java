package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JM_ChkSiJimuttdk;

/**
 * 支払事務手続チェックマスタ(JM_ChkSiJimuttdkDao) アクセス用の DAO クラスです。<br />
 */
public class JM_ChkSiJimuttdkDao extends AbstractDao<JM_ChkSiJimuttdk> {

    public JM_ChkSiJimuttdkDao() {
        super(JM_ChkSiJimuttdk.class);
    }

    public JM_ChkSiJimuttdk getChkSiJimuttdk(String pKinouId, String pSyorijimuttdkcd) {
        JM_ChkSiJimuttdk jM_ChkSiJimuttdk =  new JM_ChkSiJimuttdk();
        jM_ChkSiJimuttdk.setKinouId(pKinouId);
        jM_ChkSiJimuttdk.setSyorijimuttdkcd(pSyorijimuttdkcd);
        return this.selectOne(jM_ChkSiJimuttdk);
    }
}
