package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.db.entity.HT_MosTrkKzkVrf;

/**
 * 申込登録家族ベリファイテーブル(HT_MosTrkKzkVrfDao) アクセス用の DAO クラスです。<br />
 */
public class HT_MosTrkKzkVrfDao extends AbstractDao<HT_MosTrkKzkVrf> {

    public HT_MosTrkKzkVrfDao() {
        super(HT_MosTrkKzkVrf.class);
    }

    public HT_MosTrkKzkVrf getMosTrkKzkVrf(String pMosno, C_TrkKzkKbn pTrkkzkkbn) {
        HT_MosTrkKzkVrf hT_MosTrkKzkVrf =  new HT_MosTrkKzkVrf();
        hT_MosTrkKzkVrf.setMosno(pMosno);
        hT_MosTrkKzkVrf.setTrkkzkkbn(pTrkkzkkbn);
        return this.selectOne(hT_MosTrkKzkVrf);
    }
}
