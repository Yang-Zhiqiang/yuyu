package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_GinkouMdhnFollowCall;

/**
 * 銀行窓販フォローコール対象テーブル(IT_GinkouMdhnFollowCallDao) アクセス用の DAO クラスです。<br />
 */
public class IT_GinkouMdhnFollowCallDao extends AbstractDao<IT_GinkouMdhnFollowCall> {

    public IT_GinkouMdhnFollowCallDao() {
        super(IT_GinkouMdhnFollowCall.class);
    }

    public IT_GinkouMdhnFollowCall getGinkouMdhnFollowCall(BizDate pSyoriYmd, String pSyono) {
        IT_GinkouMdhnFollowCall iT_GinkouMdhnFollowCall =  new IT_GinkouMdhnFollowCall( pSyoriYmd,  pSyono);
        return this.selectOne(iT_GinkouMdhnFollowCall);
    }

}
