package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IW_CifcdIktHnkWk;

/**
 * ＣＩＦコード一括変更ワークテーブル(IW_CifcdIktHnkWkDao) アクセス用の DAO クラスです。<br />
 */
public class IW_CifcdIktHnkWkDao extends AbstractDao<IW_CifcdIktHnkWk> {

    public IW_CifcdIktHnkWkDao() {
        super(IW_CifcdIktHnkWk.class);
    }

    public IW_CifcdIktHnkWk getCifcdIktHnkWk(String pSyono) {
        IW_CifcdIktHnkWk iW_CifcdIktHnkWk =  new IW_CifcdIktHnkWk( pSyono);
        return this.selectOne(iW_CifcdIktHnkWk);
    }
}
