package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IW_TmttkinYskWk;

/**
 * 積立金予測ワークテーブル(IW_TmttkinYskWkDao) アクセス用の DAO クラスです。<br />
 */
public class IW_TmttkinYskWkDao extends AbstractDao<IW_TmttkinYskWk> {

    public IW_TmttkinYskWkDao() {
        super(IW_TmttkinYskWk.class);
    }

    public IW_TmttkinYskWk getTmttkinYskWk(String pSyono) {
        IW_TmttkinYskWk iW_TmttkinYskWk =  new IW_TmttkinYskWk();
        iW_TmttkinYskWk.setSyono(pSyono);
        return this.selectOne(iW_TmttkinYskWk);
    }
}
