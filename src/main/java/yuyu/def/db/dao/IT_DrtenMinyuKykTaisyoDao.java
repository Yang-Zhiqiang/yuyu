package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_DrtenMinyuKykTaisyo;

/**
 * 代理店未入契約明細対象テーブル(IT_DrtenMinyuKykTaisyoDao) アクセス用の DAO クラスです。<br />
 */
public class IT_DrtenMinyuKykTaisyoDao extends AbstractDao<IT_DrtenMinyuKykTaisyo> {

    public IT_DrtenMinyuKykTaisyoDao() {
        super(IT_DrtenMinyuKykTaisyo.class);
    }

    public IT_DrtenMinyuKykTaisyo getDrtenMinyuKykTaisyo(String pSyono, BizDate pSyoriYmd, String pMinyuutrrenno) {
        IT_DrtenMinyuKykTaisyo iT_DrtenMinyuKykTaisyo =  new IT_DrtenMinyuKykTaisyo( pSyono,  pSyoriYmd,  pMinyuutrrenno);
        return this.selectOne(iT_DrtenMinyuKykTaisyo);
    }
}
