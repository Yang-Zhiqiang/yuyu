package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_CreditCardInfo;

/**
 * クレカ情報バックアップテーブル(IT_BAK_CreditCardInfoDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_CreditCardInfoDao extends AbstractDao<IT_BAK_CreditCardInfo> {

    public IT_BAK_CreditCardInfoDao() {
        super(IT_BAK_CreditCardInfo.class);
    }

    public IT_BAK_CreditCardInfo getBAKCreditCardInfo(String pSyono, String pTrkssikibetukey) {
        IT_BAK_CreditCardInfo iT_BAK_CreditCardInfo =  new IT_BAK_CreditCardInfo( pSyono,  pTrkssikibetukey);
        return this.selectOne(iT_BAK_CreditCardInfo);
    }
}
