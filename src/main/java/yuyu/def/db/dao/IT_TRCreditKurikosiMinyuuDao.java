package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_TRCreditKurikosiMinyuu;

/**
 * クレカ繰越未入ＴＲテーブル(IT_TRCreditKurikosiMinyuuDao) アクセス用の DAO クラスです。<br />
 */
public class IT_TRCreditKurikosiMinyuuDao extends AbstractDao<IT_TRCreditKurikosiMinyuu> {

    public IT_TRCreditKurikosiMinyuuDao() {
        super(IT_TRCreditKurikosiMinyuu.class);
    }

    public IT_TRCreditKurikosiMinyuu getTRCreditKurikosiMinyuu(String pSyono, BizDate pSyoriYmd, String pMinyuutrrenno) {
        IT_TRCreditKurikosiMinyuu iT_TRCreditKurikosiMinyuu =  new IT_TRCreditKurikosiMinyuu( pSyono,  pSyoriYmd,  pMinyuutrrenno);
        return this.selectOne(iT_TRCreditKurikosiMinyuu);
    }
}
