package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.db.entity.BM_Simekiribi;

/**
 * 締切日マスタ(BM_SimekiribiDao) アクセス用の DAO クラスです。<br />
 */
public class BM_SimekiribiDao extends AbstractDao<BM_Simekiribi> {

    public BM_SimekiribiDao() {
        super(BM_Simekiribi.class);
    }

    public BM_Simekiribi getSimekiribi(BizDateYM pBosyuuym){
        BM_Simekiribi bM_Simekiribi =  new BM_Simekiribi();
        bM_Simekiribi.setBosyuuym(pBosyuuym);
        return this.selectOne(bM_Simekiribi);
    }
}
