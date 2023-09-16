package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IW_KhSyoukenSaihakkouWk;

/**
 * 証券再発行ワークテーブル(IW_KhSyoukenSaihakkouWkDao) アクセス用の DAO クラスです。<br />
 */
public class IW_KhSyoukenSaihakkouWkDao extends AbstractDao<IW_KhSyoukenSaihakkouWk> {

    public IW_KhSyoukenSaihakkouWkDao() {
        super(IW_KhSyoukenSaihakkouWk.class);
    }

    public IW_KhSyoukenSaihakkouWk getKhSyoukenSaihakkouWk(String pKouteikanriid){
        IW_KhSyoukenSaihakkouWk iW_KhSyoukenSaihakkouWk =  new IW_KhSyoukenSaihakkouWk();
        iW_KhSyoukenSaihakkouWk.setKouteikanriid(pKouteikanriid);
        return this.selectOne(iW_KhSyoukenSaihakkouWk);
    }
}
