package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_Tuuka;

/**
 * 通貨マスタ(BM_TuukaDao) アクセス用の DAO クラスです。<br />
 */
public class BM_TuukaDao extends AbstractDao<BM_Tuuka> {

    public BM_TuukaDao() {
        super(BM_Tuuka.class);
    }

    public BM_Tuuka getTuuka(C_Tuukasyu pTuukasyu){
        BM_Tuuka bM_Tuuka =  new BM_Tuuka();
        bM_Tuuka.setTuukasyu(pTuukasyu);
        return this.selectOne(bM_Tuuka);
    }
}
