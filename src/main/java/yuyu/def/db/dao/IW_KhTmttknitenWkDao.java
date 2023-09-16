package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IW_KhTmttknitenWk;

/**
 * 積立金移転ワークテーブル(IW_KhTmttknitenWkDao) アクセス用の DAO クラスです。<br />
 */
public class IW_KhTmttknitenWkDao extends AbstractDao<IW_KhTmttknitenWk> {

    public IW_KhTmttknitenWkDao() {
        super(IW_KhTmttknitenWk.class);
    }

    public IW_KhTmttknitenWk getKhTmttknitenWk(String pKouteikanriid) {
        IW_KhTmttknitenWk iW_KhTmttknitenWk =  new IW_KhTmttknitenWk();
        iW_KhTmttknitenWk.setKouteikanriid(pKouteikanriid);
        return this.selectOne(iW_KhTmttknitenWk);
    }

}
