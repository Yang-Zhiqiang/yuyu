package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_ChkSyokugyou;

/**
 * 職業制限チェックマスタ(BM_ChkSyokugyouDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkSyokugyouDao extends AbstractDao<BM_ChkSyokugyou> {

    public BM_ChkSyokugyouDao() {
        super(BM_ChkSyokugyou.class);
    }

    public BM_ChkSyokugyou getChkSyokugyou(String pSyokugyoucd) {
        BM_ChkSyokugyou bM_ChkSyokugyou =  new BM_ChkSyokugyou();
        bM_ChkSyokugyou.setSyokugyoucd(pSyokugyoucd);
        return this.selectOne(bM_ChkSyokugyou);
    }

}
