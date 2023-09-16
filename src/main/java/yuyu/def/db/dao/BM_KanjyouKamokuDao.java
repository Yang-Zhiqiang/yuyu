package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.db.entity.BM_KanjyouKamoku;

/**
 * 勘定科目マスタ(BM_KanjyouKamokuDao) アクセス用の DAO クラスです。<br />
 */
public class BM_KanjyouKamokuDao extends AbstractDao<BM_KanjyouKamoku> {

    public BM_KanjyouKamokuDao() {
        super(BM_KanjyouKamoku.class);
    }

    public BM_KanjyouKamoku getKanjyouKamoku(C_Kanjyoukmkcd pKanjyoukmkcd){
        BM_KanjyouKamoku bM_KanjyouKamoku =  new BM_KanjyouKamoku();
        bM_KanjyouKamoku.setKanjyoukmkcd(pKanjyoukmkcd);
        return this.selectOne(bM_KanjyouKamoku);
    }
}
