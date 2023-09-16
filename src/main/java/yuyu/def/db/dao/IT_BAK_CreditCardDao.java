package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_CreditCard;

/**
 * クレジットカードバックアップテーブル(IT_BAK_CreditCardDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_CreditCardDao extends AbstractDao<IT_BAK_CreditCard> {

    public IT_BAK_CreditCardDao() {
        super(IT_BAK_CreditCard.class);
    }

    @Deprecated
    public IT_BAK_CreditCard getBAKCreditCard(String pSyono,
         String pTrkssikibetukey){
        IT_BAK_CreditCard iT_BAK_CreditCard =  new IT_BAK_CreditCard();
        iT_BAK_CreditCard.setSyono(pSyono);
        iT_BAK_CreditCard.setTrkssikibetukey(pTrkssikibetukey);
        return this.selectOne(iT_BAK_CreditCard);
    }

    @Override
    @Deprecated
    public List<IT_BAK_CreditCard> selectAll() {
        return super.selectAll();
    }
}
