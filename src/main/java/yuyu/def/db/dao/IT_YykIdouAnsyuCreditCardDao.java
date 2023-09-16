package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_YykIdouAnsyuCreditCard;

/**
 * 予約異動案内収納用クレジット払テーブル(IT_YykIdouAnsyuCreditCardDao) アクセス用の DAO クラスです。<br />
 */
public class IT_YykIdouAnsyuCreditCardDao extends AbstractDao<IT_YykIdouAnsyuCreditCard> {

    public IT_YykIdouAnsyuCreditCardDao() {
        super(IT_YykIdouAnsyuCreditCard.class);
    }

    @Deprecated
    public IT_YykIdouAnsyuCreditCard getYykIdouAnsyuCreditCard(String pSyono,
         String pHenkousikibetukey){
        IT_YykIdouAnsyuCreditCard iT_YykIdouAnsyuCreditCard =  new IT_YykIdouAnsyuCreditCard();
        iT_YykIdouAnsyuCreditCard.setSyono(pSyono);
        iT_YykIdouAnsyuCreditCard.setHenkousikibetukey(pHenkousikibetukey);
        return this.selectOne(iT_YykIdouAnsyuCreditCard);
    }

    @Override
    @Deprecated
    public List<IT_YykIdouAnsyuCreditCard> selectAll() {
        return super.selectAll();
    }
}
