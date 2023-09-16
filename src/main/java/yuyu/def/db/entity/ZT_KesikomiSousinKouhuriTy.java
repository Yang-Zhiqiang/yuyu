package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KesikomiSousinKouhuriTy;
import yuyu.def.db.mapping.GenZT_KesikomiSousinKouhuriTy;
import yuyu.def.db.meta.GenQZT_KesikomiSousinKouhuriTy;
import yuyu.def.db.meta.QZT_KesikomiSousinKouhuriTy;

/**
 * 消込送信Ｆ（口振）テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KesikomiSousinKouhuriTy} の JavaDoc を参照してください。
 * @see     GenZT_KesikomiSousinKouhuriTy
 * @see     PKZT_KesikomiSousinKouhuriTy
 * @see     QZT_KesikomiSousinKouhuriTy
 * @see     GenQZT_KesikomiSousinKouhuriTy
 */
@Entity
public class ZT_KesikomiSousinKouhuriTy extends GenZT_KesikomiSousinKouhuriTy {

    private static final long serialVersionUID = 1L;

    public ZT_KesikomiSousinKouhuriTy() {
    }

    public ZT_KesikomiSousinKouhuriTy(String pZtykskmsousinrenno, String pZtykskmfsyoriymd) {
        super(pZtykskmsousinrenno, pZtykskmfsyoriymd);
    }

}
