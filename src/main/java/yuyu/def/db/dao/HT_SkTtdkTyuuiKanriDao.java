package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_SkTtdkTyuuiKanri;

/**
 * 新契約手続注意管理テーブル(HT_SkTtdkTyuuiKanriDao) アクセス用の DAO クラスです。<br />
 */
public class HT_SkTtdkTyuuiKanriDao extends AbstractDao<HT_SkTtdkTyuuiKanri> {

    public HT_SkTtdkTyuuiKanriDao() {
        super(HT_SkTtdkTyuuiKanri.class);
    }

    @Deprecated
    public HT_SkTtdkTyuuiKanri getSkTtdkTyuuiKanri(String pMosno){
        HT_SkTtdkTyuuiKanri hT_SkTtdkTyuuiKanri =  new HT_SkTtdkTyuuiKanri();
        hT_SkTtdkTyuuiKanri.setMosno(pMosno);
        return this.selectOne(hT_SkTtdkTyuuiKanri);
    }

    @Override
    @Deprecated
    public List<HT_SkTtdkTyuuiKanri> selectAll() {
        return super.selectAll();
    }
}
