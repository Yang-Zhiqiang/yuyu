package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_TyhyrenrakusikibetuKbn;
import yuyu.def.db.entity.BM_Tyouhyourenrakusaki;

/**
 * 帳票連絡先マスタ(BM_TyouhyourenrakusakiDao) アクセス用の DAO クラスです。<br />
 */
public class BM_TyouhyourenrakusakiDao extends AbstractDao<BM_Tyouhyourenrakusaki> {

    public BM_TyouhyourenrakusakiDao() {
        super(BM_Tyouhyourenrakusaki.class);
    }

    public BM_Tyouhyourenrakusaki getTyouhyourenrakusaki(C_TyhyrenrakusikibetuKbn pTyhyrenrakusikibetukbn){
        BM_Tyouhyourenrakusaki bM_Tyouhyourenrakusaki =  new BM_Tyouhyourenrakusaki();
        bM_Tyouhyourenrakusaki.setTyhyrenrakusikibetukbn(pTyhyrenrakusikibetukbn);
        return this.selectOne(bM_Tyouhyourenrakusaki);
    }
}
