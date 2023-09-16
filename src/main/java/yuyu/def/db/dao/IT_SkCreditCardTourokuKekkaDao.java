package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_SkCreditCardTourokuKekka;

/**
 * 新契約クレジットカード登録結果テーブル(IT_SkCreditCardTourokuKekkaDao) アクセス用の DAO クラスです。<br />
 */
public class IT_SkCreditCardTourokuKekkaDao extends AbstractDao<IT_SkCreditCardTourokuKekka> {

    public IT_SkCreditCardTourokuKekkaDao() {
        super(IT_SkCreditCardTourokuKekka.class);
    }

    public IT_SkCreditCardTourokuKekka getSkCreditCardTourokuKekka(String pCreditkessaiyouno, String pDatajyusinymd) {
        IT_SkCreditCardTourokuKekka iT_SkCreditCardTourokuKekka =  new IT_SkCreditCardTourokuKekka();
        iT_SkCreditCardTourokuKekka.setCreditkessaiyouno(pCreditkessaiyouno);
        iT_SkCreditCardTourokuKekka.setDatajyusinymd(pDatajyusinymd);
        return this.selectOne(iT_SkCreditCardTourokuKekka);
    }
}
