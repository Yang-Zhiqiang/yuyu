package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_HrhnCreditCardTouroku;

/**
 * 払変クレカ登録テーブル(IT_HrhnCreditCardTourokuDao) アクセス用の DAO クラスです。<br />
 */
public class IT_HrhnCreditCardTourokuDao extends AbstractDao<IT_HrhnCreditCardTouroku> {

    public IT_HrhnCreditCardTourokuDao() {
        super(IT_HrhnCreditCardTouroku.class);
    }

    public IT_HrhnCreditCardTouroku getHrhnCreditCardTouroku(String pCreditkessaiyouno) {
        IT_HrhnCreditCardTouroku iT_HrhnCreditCardTouroku =  new IT_HrhnCreditCardTouroku();
        iT_HrhnCreditCardTouroku.setCreditkessaiyouno(pCreditkessaiyouno);
        return this.selectOne(iT_HrhnCreditCardTouroku);
    }
}
