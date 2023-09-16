package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_TRAuthoriKekka;

/**
 * オーソリ結果ＴＲテーブル(IT_TRAuthoriKekkaDao) アクセス用の DAO クラスです。<br />
 */
public class IT_TRAuthoriKekkaDao extends AbstractDao<IT_TRAuthoriKekka> {

    public IT_TRAuthoriKekkaDao() {
        super(IT_TRAuthoriKekka.class);
    }

    public IT_TRAuthoriKekka getTRAuthoriKekka(String pSyono,
         BizDate pSyoriYmd,
         String pAuthorikktrrenno){
        IT_TRAuthoriKekka iT_TRAuthoriKekka =  new IT_TRAuthoriKekka();
        iT_TRAuthoriKekka.setSyono(pSyono);
        iT_TRAuthoriKekka.setSyoriYmd(pSyoriYmd);
        iT_TRAuthoriKekka.setAuthorikktrrenno(pAuthorikktrrenno);
        return this.selectOne(iT_TRAuthoriKekka);
    }
}
