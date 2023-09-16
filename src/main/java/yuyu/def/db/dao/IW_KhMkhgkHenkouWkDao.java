package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IW_KhMkhgkHenkouWk;

/**
 * 目標額変更ワークテーブル(IW_KhMkhgkHenkouWkDao) アクセス用の DAO クラスです。<br />
 */
public class IW_KhMkhgkHenkouWkDao extends AbstractDao<IW_KhMkhgkHenkouWk> {

    public IW_KhMkhgkHenkouWkDao() {
        super(IW_KhMkhgkHenkouWk.class);
    }

    public IW_KhMkhgkHenkouWk getKhMkhgkHenkouWk(String pKouteikanriid) {
        IW_KhMkhgkHenkouWk iW_KhMkhgkHenkouWk =  new IW_KhMkhgkHenkouWk();
        iW_KhMkhgkHenkouWk.setKouteikanriid(pKouteikanriid);
        return this.selectOne(iW_KhMkhgkHenkouWk);
    }
}
