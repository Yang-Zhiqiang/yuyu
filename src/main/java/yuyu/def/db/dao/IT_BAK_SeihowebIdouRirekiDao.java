package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_SeihowebIdouRireki;
import java.util.List;

/**
 * 生保Ｗｅｂ用異動履歴バックアップテーブル(IT_BAK_SeihowebIdouRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_SeihowebIdouRirekiDao extends AbstractDao<IT_BAK_SeihowebIdouRireki> {

    public IT_BAK_SeihowebIdouRirekiDao() {
        super(IT_BAK_SeihowebIdouRireki.class);
    }

    @Deprecated
    public IT_BAK_SeihowebIdouRireki getBAKSeihowebIdouRireki(String pSyono, String pTrkssikibetukey, String pHenkousikibetukey) {
        IT_BAK_SeihowebIdouRireki iT_BAK_SeihowebIdouRireki =  new IT_BAK_SeihowebIdouRireki( pSyono,  pTrkssikibetukey,  pHenkousikibetukey);
        return this.selectOne(iT_BAK_SeihowebIdouRireki);
    }

    @Override
    @Deprecated
    public List<IT_BAK_SeihowebIdouRireki> selectAll() {
        return super.selectAll();
    }
}
