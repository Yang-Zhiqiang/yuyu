package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_PMinyuuSyoumetuInfo;
import java.util.List;

/**
 * Ｐ未入消滅情報テーブル(IT_PMinyuuSyoumetuInfoDao) アクセス用の DAO クラスです。<br />
 */
public class IT_PMinyuuSyoumetuInfoDao extends AbstractDao<IT_PMinyuuSyoumetuInfo> {

    public IT_PMinyuuSyoumetuInfoDao() {
        super(IT_PMinyuuSyoumetuInfo.class);
    }

    @Deprecated
    public IT_PMinyuuSyoumetuInfo getPMinyuuSyoumetuInfo(String pSyono) {
        IT_PMinyuuSyoumetuInfo iT_PMinyuuSyoumetuInfo =  new IT_PMinyuuSyoumetuInfo( pSyono);
        return this.selectOne(iT_PMinyuuSyoumetuInfo);
    }

    @Override
    @Deprecated
    public List<IT_PMinyuuSyoumetuInfo> selectAll() {
        return super.selectAll();
    }
}
