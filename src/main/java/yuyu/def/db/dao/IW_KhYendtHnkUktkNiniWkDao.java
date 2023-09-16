package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IW_KhYendtHnkUktkNiniWk;

/**
 * 円建変更受付（任意請求）ワークテーブル(IW_KhYendtHnkUktkNiniWkDao) アクセス用の DAO クラスです。<br />
 */
public class IW_KhYendtHnkUktkNiniWkDao extends AbstractDao<IW_KhYendtHnkUktkNiniWk> {

    public IW_KhYendtHnkUktkNiniWkDao() {
        super(IW_KhYendtHnkUktkNiniWk.class);
    }

    public IW_KhYendtHnkUktkNiniWk getKhYendtHnkUktkNiniWk(String pKouteikanriid) {
        IW_KhYendtHnkUktkNiniWk iW_KhYendtHnkUktkNiniWk =  new IW_KhYendtHnkUktkNiniWk();
        iW_KhYendtHnkUktkNiniWk.setKouteikanriid(pKouteikanriid);
        return this.selectOne(iW_KhYendtHnkUktkNiniWk);
    }
}
