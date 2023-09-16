package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_CreditCardKaisya;

/**
 * クレジットカード会社マスタ(BM_CreditCardKaisyaDao) アクセス用の DAO クラスです。<br />
 */
public class BM_CreditCardKaisyaDao extends AbstractDao<BM_CreditCardKaisya> {

    public BM_CreditCardKaisyaDao() {
        super(BM_CreditCardKaisya.class);
    }

    public BM_CreditCardKaisya getCreditCardKaisya(String pCardkaisyacd) {
        BM_CreditCardKaisya bM_CreditCardKaisya =  new BM_CreditCardKaisya();
        bM_CreditCardKaisya.setCardkaisyacd(pCardkaisyacd);
        return this.selectOne(bM_CreditCardKaisya);
    }

}
