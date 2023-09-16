package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_DairitenMinyuKykMeisai;

/**
 * 代理店未入契約明細テーブル(IT_DairitenMinyuKykMeisaiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_DairitenMinyuKykMeisaiDao extends AbstractDao<IT_DairitenMinyuKykMeisai> {

    public IT_DairitenMinyuKykMeisaiDao() {
        super(IT_DairitenMinyuKykMeisai.class);
    }

    public IT_DairitenMinyuKykMeisai getDairitenMinyuKykMeisai(BizDate pSyoriYmd, String pSyono, Integer pDrtenrenno) {
        IT_DairitenMinyuKykMeisai iT_DairitenMinyuKykMeisai =  new IT_DairitenMinyuKykMeisai( pSyoriYmd,  pSyono,  pDrtenrenno);
        return this.selectOne(iT_DairitenMinyuKykMeisai);
    }

}
