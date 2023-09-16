package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_SeihowebIdouRireki;

/**
 * 生保Ｗｅｂ用異動履歴テーブル(IT_SeihowebIdouRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_SeihowebIdouRirekiDao extends AbstractDao<IT_SeihowebIdouRireki> {

    public IT_SeihowebIdouRirekiDao() {
        super(IT_SeihowebIdouRireki.class);
    }

    public IT_SeihowebIdouRireki getSeihowebIdouRireki(String pSyono, String pHenkousikibetukey) {
        IT_SeihowebIdouRireki iT_SeihowebIdouRireki =  new IT_SeihowebIdouRireki( pSyono,  pHenkousikibetukey);
        return this.selectOne(iT_SeihowebIdouRireki);
    }
}
