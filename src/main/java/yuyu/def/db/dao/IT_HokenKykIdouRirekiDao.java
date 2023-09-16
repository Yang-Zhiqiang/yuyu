package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_ZougenKbn;
import yuyu.def.db.entity.IT_HokenKykIdouRireki;

/**
 * 保険契約異動情報履歴テーブル(IT_HokenKykIdouRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_HokenKykIdouRirekiDao extends AbstractDao<IT_HokenKykIdouRireki> {

    public IT_HokenKykIdouRirekiDao() {
        super(IT_HokenKykIdouRireki.class);
    }

    public IT_HokenKykIdouRireki getHokenKykIdouRireki(String pSyono, String pHenkousikibetukey, C_ZougenKbn pZougenkbn) {
        IT_HokenKykIdouRireki iT_HokenKykIdouRireki =  new IT_HokenKykIdouRireki( pSyono,  pHenkousikibetukey,  pZougenkbn);
        return this.selectOne(iT_HokenKykIdouRireki);
    }
}
