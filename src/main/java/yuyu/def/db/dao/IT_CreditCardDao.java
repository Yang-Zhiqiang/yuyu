package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_CreditCard;

/**
 * クレジットカードテーブル(IT_CreditCardDao) アクセス用の DAO クラスです。<br />
 */
public class IT_CreditCardDao extends AbstractDao<IT_CreditCard> {

    public IT_CreditCardDao() {
        super(IT_CreditCard.class);
    }

    @Deprecated
    public IT_CreditCard getCreditCard(String pSyono){
        IT_CreditCard iT_CreditCard =  new IT_CreditCard();
        iT_CreditCard.setSyono(pSyono);
        return this.selectOne(iT_CreditCard);
    }

    @Override
    @Deprecated
    public List<IT_CreditCard> selectAll() {
        return super.selectAll();
    }
}
