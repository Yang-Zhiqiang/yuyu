package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IW_KhNkShrTokuyakuHenkouWk;

/**
 * 年金支払特約変更ワークテーブル(IW_KhNkShrTokuyakuHenkouWkDao) アクセス用の DAO クラスです。<br />
 */
public class IW_KhNkShrTokuyakuHenkouWkDao extends AbstractDao<IW_KhNkShrTokuyakuHenkouWk> {

    public IW_KhNkShrTokuyakuHenkouWkDao() {
        super(IW_KhNkShrTokuyakuHenkouWk.class);
    }

    public IW_KhNkShrTokuyakuHenkouWk getKhNkShrTokuyakuHenkouWk(String pKouteikanriid){
        IW_KhNkShrTokuyakuHenkouWk iW_KhNkShrTokuyakuHenkouWk =  new IW_KhNkShrTokuyakuHenkouWk();
        iW_KhNkShrTokuyakuHenkouWk.setKouteikanriid(pKouteikanriid);
        return this.selectOne(iW_KhNkShrTokuyakuHenkouWk);
    }
}
