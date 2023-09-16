package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IW_KhTargetTokuyakuHenkouWk;

/**
 * ターゲット特約変更ワークテーブル(IW_KhTargetTokuyakuHenkouWkDao) アクセス用の DAO クラスです。<br />
 */
public class IW_KhTargetTokuyakuHenkouWkDao extends AbstractDao<IW_KhTargetTokuyakuHenkouWk> {

    public IW_KhTargetTokuyakuHenkouWkDao() {
        super(IW_KhTargetTokuyakuHenkouWk.class);
    }

    public IW_KhTargetTokuyakuHenkouWk getKhTargetTokuyakuHenkouWk(String pKouteikanriid){
        IW_KhTargetTokuyakuHenkouWk iW_KhTargetTokuyakuHenkouWk =  new IW_KhTargetTokuyakuHenkouWk();
        iW_KhTargetTokuyakuHenkouWk.setKouteikanriid(pKouteikanriid);
        return this.selectOne(iW_KhTargetTokuyakuHenkouWk);
    }
}
