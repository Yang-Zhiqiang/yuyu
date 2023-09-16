package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IW_KhSiharaiKouzaHenkouWk;

/**
 * 支払口座情報変更ワークテーブル(IW_KhSiharaiKouzaHenkouWkDao) アクセス用の DAO クラスです。<br />
 */
public class IW_KhSiharaiKouzaHenkouWkDao extends AbstractDao<IW_KhSiharaiKouzaHenkouWk> {

    public IW_KhSiharaiKouzaHenkouWkDao() {
        super(IW_KhSiharaiKouzaHenkouWk.class);
    }

    public IW_KhSiharaiKouzaHenkouWk getKhSiharaiKouzaHenkouWk(String pKouteikanriid){
        IW_KhSiharaiKouzaHenkouWk iW_KhSiharaiKouzaHenkouWk =  new IW_KhSiharaiKouzaHenkouWk();
        iW_KhSiharaiKouzaHenkouWk.setKouteikanriid(pKouteikanriid);
        return this.selectOne(iW_KhSiharaiKouzaHenkouWk);
    }
}
