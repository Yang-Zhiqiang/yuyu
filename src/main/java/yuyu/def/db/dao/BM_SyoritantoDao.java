package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_Syoritanto;

/**
 * 処理担当マスタ(BM_SyoritantoDao) アクセス用の DAO クラスです。<br />
 */
public class BM_SyoritantoDao extends AbstractDao<BM_Syoritanto> {

    public BM_SyoritantoDao() {
        super(BM_Syoritanto.class);
    }

    public BM_Syoritanto getSyoritanto(String pSyoricd) {
        BM_Syoritanto bM_Syoritanto =  new BM_Syoritanto();
        bM_Syoritanto.setSyoricd(pSyoricd);
        return this.selectOne(bM_Syoritanto);
    }
}
