package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_Address;
import yuyu.def.db.mapping.GenBM_Address;
import yuyu.def.db.meta.GenQBM_Address;
import yuyu.def.db.meta.QBM_Address;

/**
 * 住所マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_Address} の JavaDoc を参照してください。
 * @see     GenBM_Address
 * @see     PKBM_Address
 * @see     QBM_Address
 * @see     GenQBM_Address
 */
@Entity
public class BM_Address extends GenBM_Address {

    private static final long serialVersionUID = 1L;

    public BM_Address() {
    }

    public BM_Address(String pPostalCd, String pKihontikucdsimo1) {
        super(pPostalCd, pKihontikucdsimo1);
    }

}
