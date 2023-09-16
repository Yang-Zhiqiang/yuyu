package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_ZougenKbn;
import yuyu.def.db.entity.IT_BAK_HokenKykIdouRireki;

/**
 * 保険契約異動情報履歴バックアップテーブル(IT_BAK_HokenKykIdouRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_HokenKykIdouRirekiDao extends AbstractDao<IT_BAK_HokenKykIdouRireki> {

    public IT_BAK_HokenKykIdouRirekiDao() {
        super(IT_BAK_HokenKykIdouRireki.class);
    }

    public IT_BAK_HokenKykIdouRireki getBAKHokenKykIdouRireki(String pSyono, String pTrkssikibetukey, String pHenkousikibetukey, C_ZougenKbn pZougenkbn) {
        IT_BAK_HokenKykIdouRireki iT_BAK_HokenKykIdouRireki =  new IT_BAK_HokenKykIdouRireki( pSyono,  pTrkssikibetukey,  pHenkousikibetukey,  pZougenkbn);
        return this.selectOne(iT_BAK_HokenKykIdouRireki);
    }
}
