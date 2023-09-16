package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.db.entity.HT_MosTrkKzk;

/**
 * 申込登録家族テーブル(HT_MosTrkKzkDao) アクセス用の DAO クラスです。<br />
 */
public class HT_MosTrkKzkDao extends AbstractDao<HT_MosTrkKzk> {

    public HT_MosTrkKzkDao() {
        super(HT_MosTrkKzk.class);
    }

    public HT_MosTrkKzk getMosTrkKzk(String pMosno, C_TrkKzkKbn pTrkkzkkbn) {
        HT_MosTrkKzk hT_MosTrkKzk =  new HT_MosTrkKzk();
        hT_MosTrkKzk.setMosno(pMosno);
        hT_MosTrkKzk.setTrkkzkkbn(pTrkkzkkbn);
        return this.selectOne(hT_MosTrkKzk);
    }
}
