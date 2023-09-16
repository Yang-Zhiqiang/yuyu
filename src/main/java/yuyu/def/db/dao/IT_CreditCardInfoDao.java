package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_CreditCardInfo;

/**
 * クレカ情報テーブル(IT_CreditCardInfoDao) アクセス用の DAO クラスです。<br />
 */
public class IT_CreditCardInfoDao extends AbstractDao<IT_CreditCardInfo> {

    public IT_CreditCardInfoDao() {
        super(IT_CreditCardInfo.class);
    }

    public IT_CreditCardInfo getCreditCardInfo(String pSyono) {
        IT_CreditCardInfo iT_CreditCardInfo =  new IT_CreditCardInfo( pSyono);
        return this.selectOne(iT_CreditCardInfo);
    }
}
