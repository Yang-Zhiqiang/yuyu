package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_SosikiMadoguti;

/**
 * 組織窓口情報マスタ(BM_SosikiMadogutiDao) アクセス用の DAO クラスです。<br />
 */
public class BM_SosikiMadogutiDao extends AbstractDao<BM_SosikiMadoguti> {

    public BM_SosikiMadogutiDao() {
        super(BM_SosikiMadoguti.class);
    }

    public BM_SosikiMadoguti getSosikiMadoguti(String pSskmdsosikicd){
        BM_SosikiMadoguti bM_SosikiMadoguti =  new BM_SosikiMadoguti();
        bM_SosikiMadoguti.setSskmdsosikicd(pSskmdsosikicd);
        return this.selectOne(bM_SosikiMadoguti);
    }
}
