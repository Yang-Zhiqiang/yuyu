package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKIT_SkCreditCardTourokuKekka;
import yuyu.def.db.mapping.GenIT_SkCreditCardTourokuKekka;
import yuyu.def.db.meta.GenQIT_SkCreditCardTourokuKekka;
import yuyu.def.db.meta.QIT_SkCreditCardTourokuKekka;

/**
 * 新契約クレジットカード登録結果テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_SkCreditCardTourokuKekka} の JavaDoc を参照してください。
 * @see     GenIT_SkCreditCardTourokuKekka
 * @see     PKIT_SkCreditCardTourokuKekka
 * @see     QIT_SkCreditCardTourokuKekka
 * @see     GenQIT_SkCreditCardTourokuKekka
 */
@Entity
public class IT_SkCreditCardTourokuKekka extends GenIT_SkCreditCardTourokuKekka {

    private static final long serialVersionUID = 1L;

    public IT_SkCreditCardTourokuKekka() {
    }

    public IT_SkCreditCardTourokuKekka(String pCreditkessaiyouno, String pDatajyusinymd) {
        super(pCreditkessaiyouno, pDatajyusinymd);
    }

}
