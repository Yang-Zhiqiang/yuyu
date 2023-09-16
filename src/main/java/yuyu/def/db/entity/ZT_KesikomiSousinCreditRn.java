package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KesikomiSousinCreditRn;
import yuyu.def.db.mapping.GenZT_KesikomiSousinCreditRn;
import yuyu.def.db.meta.GenQZT_KesikomiSousinCreditRn;
import yuyu.def.db.meta.QZT_KesikomiSousinCreditRn;

/**
 * 消込送信Ｆ（クレ払）テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KesikomiSousinCreditRn} の JavaDoc を参照してください。
 * @see     GenZT_KesikomiSousinCreditRn
 * @see     PKZT_KesikomiSousinCreditRn
 * @see     QZT_KesikomiSousinCreditRn
 * @see     GenQZT_KesikomiSousinCreditRn
 */
@Entity
public class ZT_KesikomiSousinCreditRn extends GenZT_KesikomiSousinCreditRn {

    private static final long serialVersionUID = 1L;

    public ZT_KesikomiSousinCreditRn() {
    }

    public ZT_KesikomiSousinCreditRn(String pZrnkskmsousinrenno, String pZrnkskmfsyoriymd) {
        super(pZrnkskmsousinrenno, pZrnkskmfsyoriymd);
    }

}
