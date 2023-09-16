package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IW_KhHaraikataHenkouWk;

/**
 * 払方変更ワークテーブル(IW_KhHaraikataHenkouWkDao) アクセス用の DAO クラスです。<br />
 */
public class IW_KhHaraikataHenkouWkDao extends AbstractDao<IW_KhHaraikataHenkouWk> {

    public IW_KhHaraikataHenkouWkDao() {
        super(IW_KhHaraikataHenkouWk.class);
    }

    public IW_KhHaraikataHenkouWk getKhHaraikataHenkouWk(String pKouteikanriid) {
        IW_KhHaraikataHenkouWk iW_KhHaraikataHenkouWk =  new IW_KhHaraikataHenkouWk();
        iW_KhHaraikataHenkouWk.setKouteikanriid(pKouteikanriid);
        return this.selectOne(iW_KhHaraikataHenkouWk);
    }

}
