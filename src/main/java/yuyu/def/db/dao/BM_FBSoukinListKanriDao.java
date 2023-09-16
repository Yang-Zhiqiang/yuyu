package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_FBSoukinListKanri;

/**
 * ＦＢ送金リスト管理マスタ(BM_FBSoukinListKanriDao) アクセス用の DAO クラスです。<br />
 */
public class BM_FBSoukinListKanriDao extends AbstractDao<BM_FBSoukinListKanri> {

    public BM_FBSoukinListKanriDao() {
        super(BM_FBSoukinListKanri.class);
    }

    public BM_FBSoukinListKanri getFBSoukinListKanri(String pSyoricd, String pSyorisosikicd) {
        BM_FBSoukinListKanri bM_FBSoukinListKanri =  new BM_FBSoukinListKanri();
        bM_FBSoukinListKanri.setSyoricd(pSyoricd);
        bM_FBSoukinListKanri.setSyorisosikicd(pSyorisosikicd);
        return this.selectOne(bM_FBSoukinListKanri);
    }
}
