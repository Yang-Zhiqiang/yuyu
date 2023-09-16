package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IW_KhHubiWk;

/**
 * 契約保全不備ワークテーブル(IW_KhHubiWkDao) アクセス用の DAO クラスです。<br />
 */
public class IW_KhHubiWkDao extends AbstractDao<IW_KhHubiWk> {

    public IW_KhHubiWkDao() {
        super(IW_KhHubiWk.class);
    }

    public IW_KhHubiWk getKhHubiWk(String pKouteikanriid){
        IW_KhHubiWk iW_KhHubiWk =  new IW_KhHubiWk();
        iW_KhHubiWk.setKouteikanriid(pKouteikanriid);
        return this.selectOne(iW_KhHubiWk);
    }
}
