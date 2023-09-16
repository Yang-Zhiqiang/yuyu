package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_KykSyaHenkouRireki;
import java.util.List;

/**
 * 契約者変更履歴バックアップテーブル(IT_BAK_KykSyaHenkouRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KykSyaHenkouRirekiDao extends AbstractDao<IT_BAK_KykSyaHenkouRireki> {

    public IT_BAK_KykSyaHenkouRirekiDao() {
        super(IT_BAK_KykSyaHenkouRireki.class);
    }

    @Deprecated
    public IT_BAK_KykSyaHenkouRireki getBAKKykSyaHenkouRireki(String pSyono, String pTrkssikibetukey, String pHenkousikibetukey) {
        IT_BAK_KykSyaHenkouRireki iT_BAK_KykSyaHenkouRireki =  new IT_BAK_KykSyaHenkouRireki( pSyono,  pTrkssikibetukey,  pHenkousikibetukey);
        return this.selectOne(iT_BAK_KykSyaHenkouRireki);
    }

    @Override
    @Deprecated
    public List<IT_BAK_KykSyaHenkouRireki> selectAll() {
        return super.selectAll();
    }
}
