package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IW_KhKzktrkKykDrHnkWk;

/**
 * 家族登録契約者代理特約変更ワークテーブル(IW_KhKzktrkKykDrHnkWkDao) アクセス用の DAO クラスです。<br />
 */
public class IW_KhKzktrkKykDrHnkWkDao extends AbstractDao<IW_KhKzktrkKykDrHnkWk> {

    public IW_KhKzktrkKykDrHnkWkDao() {
        super(IW_KhKzktrkKykDrHnkWk.class);
    }

    public IW_KhKzktrkKykDrHnkWk getKhKzktrkKykDrHnkWk(String pKouteikanriid) {
        IW_KhKzktrkKykDrHnkWk iW_KhKzktrkKykDrHnkWk =  new IW_KhKzktrkKykDrHnkWk();
        iW_KhKzktrkKykDrHnkWk.setKouteikanriid(pKouteikanriid);
        return this.selectOne(iW_KhKzktrkKykDrHnkWk);
    }
}
