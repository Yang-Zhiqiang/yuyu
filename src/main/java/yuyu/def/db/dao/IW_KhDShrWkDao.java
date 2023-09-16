package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IW_KhDShrWk;

/**
 * 配当金支払ワークテーブル(IW_KhDShrWkDao) アクセス用の DAO クラスです。<br />
 */
public class IW_KhDShrWkDao extends AbstractDao<IW_KhDShrWk> {

    public IW_KhDShrWkDao() {
        super(IW_KhDShrWk.class);
    }

    public IW_KhDShrWk getKhDShrWk(String pKouteikanriid) {
        IW_KhDShrWk iW_KhDShrWk =  new IW_KhDShrWk();
        iW_KhDShrWk.setKouteikanriid(pKouteikanriid);
        return this.selectOne(iW_KhDShrWk);
    }

}
