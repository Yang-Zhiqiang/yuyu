package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.db.entity.IT_SeihowebMizuhoMinyuuDtl;

/**
 * 生保Ｗｅｂ・みずほ用未入明細テーブル(IT_SeihowebMizuhoMinyuuDtlDao) アクセス用の DAO クラスです。<br />
 */
public class IT_SeihowebMizuhoMinyuuDtlDao extends AbstractDao<IT_SeihowebMizuhoMinyuuDtl> {

    public IT_SeihowebMizuhoMinyuuDtlDao() {
        super(IT_SeihowebMizuhoMinyuuDtl.class);
    }

    public IT_SeihowebMizuhoMinyuuDtl getSeihowebMizuhoMinyuuDtl(String pSyono, String pDrtencd, String pBosyuucd, BizDateYM pSyoriym) {
        IT_SeihowebMizuhoMinyuuDtl iT_SeihowebMizuhoMinyuuDtl =  new IT_SeihowebMizuhoMinyuuDtl( pSyono,  pDrtencd,  pBosyuucd,  pSyoriym);
        return this.selectOne(iT_SeihowebMizuhoMinyuuDtl);
    }
}
