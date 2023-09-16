package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.db.entity.HT_BosTrkKzk;

/**
 * 募集登録家族テーブル(HT_BosTrkKzkDao) アクセス用の DAO クラスです。<br />
 */
public class HT_BosTrkKzkDao extends AbstractDao<HT_BosTrkKzk> {

    public HT_BosTrkKzkDao() {
        super(HT_BosTrkKzk.class);
    }

    public HT_BosTrkKzk getBosTrkKzk(String pMosno, C_TrkKzkKbn pTrkkzkkbn) {
        HT_BosTrkKzk hT_BosTrkKzk =  new HT_BosTrkKzk();
        hT_BosTrkKzk.setMosno(pMosno);
        hT_BosTrkKzk.setTrkkzkkbn(pTrkkzkkbn);
        return this.selectOne(hT_BosTrkKzk);
    }
}
