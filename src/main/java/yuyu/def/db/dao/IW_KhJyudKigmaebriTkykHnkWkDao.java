package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IW_KhJyudKigmaebriTkykHnkWk;

/**
 * 重度介護前払特約変更ワークテーブル(IW_KhJyudKigmaebriTkykHnkWkDao) アクセス用の DAO クラスです。<br />
 */
public class IW_KhJyudKigmaebriTkykHnkWkDao extends AbstractDao<IW_KhJyudKigmaebriTkykHnkWk> {

    public IW_KhJyudKigmaebriTkykHnkWkDao() {
        super(IW_KhJyudKigmaebriTkykHnkWk.class);
    }

    public IW_KhJyudKigmaebriTkykHnkWk getKhJyudKigmaebriTkykHnkWk(String pKouteikanriid) {
        IW_KhJyudKigmaebriTkykHnkWk iW_KhJyudKigmaebriTkykHnkWk =  new IW_KhJyudKigmaebriTkykHnkWk();
        iW_KhJyudKigmaebriTkykHnkWk.setKouteikanriid(pKouteikanriid);
        return this.selectOne(iW_KhJyudKigmaebriTkykHnkWk);
    }
}
