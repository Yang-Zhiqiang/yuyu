package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IW_KhYendtHnkHrShrWk;

/**
 * 円建変更時返戻金支払ワークテーブル(IW_KhYendtHnkHrShrWkDao) アクセス用の DAO クラスです。<br />
 */
public class IW_KhYendtHnkHrShrWkDao extends AbstractDao<IW_KhYendtHnkHrShrWk> {

    public IW_KhYendtHnkHrShrWkDao() {
        super(IW_KhYendtHnkHrShrWk.class);
    }

    public IW_KhYendtHnkHrShrWk getKhYendtHnkHrShrWk(String pKouteikanriid) {
        IW_KhYendtHnkHrShrWk iW_KhYendtHnkHrShrWk =  new IW_KhYendtHnkHrShrWk();
        iW_KhYendtHnkHrShrWk.setKouteikanriid(pKouteikanriid);
        return this.selectOne(iW_KhYendtHnkHrShrWk);
    }

}
