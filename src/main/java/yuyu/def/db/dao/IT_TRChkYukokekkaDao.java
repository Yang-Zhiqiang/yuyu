package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_TRChkYukokekka;

/**
 * 有効性確認結果ＴＲテーブル(IT_TRChkYukokekkaDao) アクセス用の DAO クラスです。<br />
 */
public class IT_TRChkYukokekkaDao extends AbstractDao<IT_TRChkYukokekka> {

    public IT_TRChkYukokekkaDao() {
        super(IT_TRChkYukokekka.class);
    }

    public IT_TRChkYukokekka getTRChkYukokekka(String pSyono,
         BizDate pSyoriYmd,
         String pYuukoutrrenno){
        IT_TRChkYukokekka iT_TRChkYukokekka =  new IT_TRChkYukokekka();
        iT_TRChkYukokekka.setSyono(pSyono);
        iT_TRChkYukokekka.setSyoriYmd(pSyoriYmd);
        iT_TRChkYukokekka.setYuukoutrrenno(pYuukoutrrenno);
        return this.selectOne(iT_TRChkYukokekka);
    }
}
