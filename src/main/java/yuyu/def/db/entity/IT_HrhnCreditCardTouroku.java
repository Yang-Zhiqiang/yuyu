package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKIT_HrhnCreditCardTouroku;
import yuyu.def.db.mapping.GenIT_HrhnCreditCardTouroku;
import yuyu.def.db.meta.GenQIT_HrhnCreditCardTouroku;
import yuyu.def.db.meta.QIT_HrhnCreditCardTouroku;

/**
 * 払変クレカ登録テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_HrhnCreditCardTouroku} の JavaDoc を参照してください。
 * @see     GenIT_HrhnCreditCardTouroku
 * @see     PKIT_HrhnCreditCardTouroku
 * @see     QIT_HrhnCreditCardTouroku
 * @see     GenQIT_HrhnCreditCardTouroku
 */
@Entity
public class IT_HrhnCreditCardTouroku extends GenIT_HrhnCreditCardTouroku {

    private static final long serialVersionUID = 1L;

    public IT_HrhnCreditCardTouroku() {
    }

    public IT_HrhnCreditCardTouroku(String pCreditkessaiyouno) {
        super(pCreditkessaiyouno);
    }

}
