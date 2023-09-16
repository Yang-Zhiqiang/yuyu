package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_PMinyuuSyoumetuInfo;
import java.util.List;

/**
 * Ｐ未入消滅情報バックアップテーブル(IT_BAK_PMinyuuSyoumetuInfoDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_PMinyuuSyoumetuInfoDao extends AbstractDao<IT_BAK_PMinyuuSyoumetuInfo> {

    public IT_BAK_PMinyuuSyoumetuInfoDao() {
        super(IT_BAK_PMinyuuSyoumetuInfo.class);
    }

    @Deprecated
    public IT_BAK_PMinyuuSyoumetuInfo getBAKPMinyuuSyoumetuInfo(String pSyono, String pTrkssikibetukey) {
        IT_BAK_PMinyuuSyoumetuInfo iT_BAK_PMinyuuSyoumetuInfo =  new IT_BAK_PMinyuuSyoumetuInfo( pSyono,  pTrkssikibetukey);
        return this.selectOne(iT_BAK_PMinyuuSyoumetuInfo);
    }

    @Override
    @Deprecated
    public List<IT_BAK_PMinyuuSyoumetuInfo> selectAll() {
        return super.selectAll();
    }
}
