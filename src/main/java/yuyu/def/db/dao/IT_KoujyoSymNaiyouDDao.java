package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_KoujyoSymNaiyouD;

/**
 * 控除証明内容Ｄテーブル(IT_KoujyoSymNaiyouDDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KoujyoSymNaiyouDDao extends AbstractDao<IT_KoujyoSymNaiyouD> {

    public IT_KoujyoSymNaiyouDDao() {
        super(IT_KoujyoSymNaiyouD.class);
    }

    public IT_KoujyoSymNaiyouD getKoujyoSymNaiyouD(String pSyono, String pSyouhncd, Integer pRenno3keta) {
        IT_KoujyoSymNaiyouD iT_KoujyoSymNaiyouD =  new IT_KoujyoSymNaiyouD( pSyono,  pSyouhncd,  pRenno3keta);
        return this.selectOne(iT_KoujyoSymNaiyouD);
    }
}
