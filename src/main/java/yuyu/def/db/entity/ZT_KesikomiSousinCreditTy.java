package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KesikomiSousinCreditTy;
import yuyu.def.db.mapping.GenZT_KesikomiSousinCreditTy;
import yuyu.def.db.meta.GenQZT_KesikomiSousinCreditTy;
import yuyu.def.db.meta.QZT_KesikomiSousinCreditTy;

/**
 * 消込送信Ｆ（クレ払）テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KesikomiSousinCreditTy} の JavaDoc を参照してください。
 * @see     GenZT_KesikomiSousinCreditTy
 * @see     PKZT_KesikomiSousinCreditTy
 * @see     QZT_KesikomiSousinCreditTy
 * @see     GenQZT_KesikomiSousinCreditTy
 */
@Entity
public class ZT_KesikomiSousinCreditTy extends GenZT_KesikomiSousinCreditTy {

    private static final long serialVersionUID = 1L;

    public ZT_KesikomiSousinCreditTy() {
    }

    public ZT_KesikomiSousinCreditTy(String pZtykskmsousinrenno, String pZtykskmfsyoriymd) {
        super(pZtykskmsousinrenno, pZtykskmfsyoriymd);
    }

}
