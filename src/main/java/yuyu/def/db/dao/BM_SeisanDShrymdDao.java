package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDateY;
import yuyu.def.db.entity.BM_SeisanDShrymd;

/**
 * 精算Ｄ支払年月日管理マスタ(BM_SeisanDShrymdDao) アクセス用の DAO クラスです。<br />
 */
public class BM_SeisanDShrymdDao extends AbstractDao<BM_SeisanDShrymd> {

    public BM_SeisanDShrymdDao() {
        super(BM_SeisanDShrymd.class);
    }

    public BM_SeisanDShrymd getSeisanDShrymd(BizDateY pSyorinendo) {
        BM_SeisanDShrymd bM_SeisanDShrymd =  new BM_SeisanDShrymd();
        bM_SeisanDShrymd.setSyorinendo(pSyorinendo);
        return this.selectOne(bM_SeisanDShrymd);
    }

}
