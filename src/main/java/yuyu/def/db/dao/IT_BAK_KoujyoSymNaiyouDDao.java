package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_KoujyoSymNaiyouD;

/**
 * 控除証明内容Ｄバックアップテーブル(IT_BAK_KoujyoSymNaiyouDDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KoujyoSymNaiyouDDao extends AbstractDao<IT_BAK_KoujyoSymNaiyouD> {

    public IT_BAK_KoujyoSymNaiyouDDao() {
        super(IT_BAK_KoujyoSymNaiyouD.class);
    }

    public IT_BAK_KoujyoSymNaiyouD getBAKKoujyoSymNaiyouD(String pSyono, String pTrkssikibetukey, String pSyouhncd, Integer pRenno3keta) {
        IT_BAK_KoujyoSymNaiyouD iT_BAK_KoujyoSymNaiyouD =  new IT_BAK_KoujyoSymNaiyouD( pSyono,  pTrkssikibetukey,  pSyouhncd,  pRenno3keta);
        return this.selectOne(iT_BAK_KoujyoSymNaiyouD);
    }
}
