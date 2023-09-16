package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_CreditCardKaisya;
import yuyu.def.db.mapping.GenBM_CreditCardKaisya;
import yuyu.def.db.meta.GenQBM_CreditCardKaisya;
import yuyu.def.db.meta.QBM_CreditCardKaisya;

/**
 * クレジットカード会社マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_CreditCardKaisya} の JavaDoc を参照してください。
 * @see     GenBM_CreditCardKaisya
 * @see     PKBM_CreditCardKaisya
 * @see     QBM_CreditCardKaisya
 * @see     GenQBM_CreditCardKaisya
 */
@Entity
public class BM_CreditCardKaisya extends GenBM_CreditCardKaisya {

    private static final long serialVersionUID = 1L;

    public BM_CreditCardKaisya() {
    }

    public BM_CreditCardKaisya(String pCardkaisyacd) {
        super(pCardkaisyacd);
    }

}
