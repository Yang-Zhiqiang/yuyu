package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IW_KhJyuusyoHenkouWk;

/**
 * 住所変更ワークテーブル(IW_KhJyuusyoHenkouWkDao) アクセス用の DAO クラスです。<br />
 */
public class IW_KhJyuusyoHenkouWkDao extends AbstractDao<IW_KhJyuusyoHenkouWk> {

    public IW_KhJyuusyoHenkouWkDao() {
        super(IW_KhJyuusyoHenkouWk.class);
    }

    public IW_KhJyuusyoHenkouWk getKhJyuusyoHenkouWk(String pKouteikanriid){
        IW_KhJyuusyoHenkouWk iW_KhJyuusyoHenkouWk =  new IW_KhJyuusyoHenkouWk();
        iW_KhJyuusyoHenkouWk.setKouteikanriid(pKouteikanriid);
        return this.selectOne(iW_KhJyuusyoHenkouWk);
    }
}
