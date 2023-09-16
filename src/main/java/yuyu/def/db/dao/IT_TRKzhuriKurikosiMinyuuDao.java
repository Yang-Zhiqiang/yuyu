package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_TRKzhuriKurikosiMinyuu;

/**
 * 口座振替繰越未入TRテーブル(IT_TRKzhuriKurikosiMinyuuDao) アクセス用の DAO クラスです。<br />
 */
public class IT_TRKzhuriKurikosiMinyuuDao extends AbstractDao<IT_TRKzhuriKurikosiMinyuu> {

    public IT_TRKzhuriKurikosiMinyuuDao() {
        super(IT_TRKzhuriKurikosiMinyuu.class);
    }

    public IT_TRKzhuriKurikosiMinyuu getTRKzhuriKurikosiMinyuu(String pSyono, BizDate pSyoriYmd, String pMinyuutrrenno) {
        IT_TRKzhuriKurikosiMinyuu iT_TRKzhuriKurikosiMinyuu =  new IT_TRKzhuriKurikosiMinyuu( pSyono,  pSyoriYmd,  pMinyuutrrenno);
        return this.selectOne(iT_TRKzhuriKurikosiMinyuu);
    }
}
