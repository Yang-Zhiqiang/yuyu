package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_TRMinyuu;

/**
 * 未入ＴＲテーブル(IT_TRMinyuuDao) アクセス用の DAO クラスです。<br />
 */
public class IT_TRMinyuuDao extends AbstractDao<IT_TRMinyuu> {

    public IT_TRMinyuuDao() {
        super(IT_TRMinyuu.class);
    }

    public IT_TRMinyuu getTRMinyuu(String pSyono,
         BizDate pSyoriYmd,
         String pMinyuutrrenno){
        IT_TRMinyuu iT_TRMinyuu =  new IT_TRMinyuu();
        iT_TRMinyuu.setSyono(pSyono);
        iT_TRMinyuu.setSyoriYmd(pSyoriYmd);
        iT_TRMinyuu.setMinyuutrrenno(pMinyuutrrenno);
        return this.selectOne(iT_TRMinyuu);
    }
}
