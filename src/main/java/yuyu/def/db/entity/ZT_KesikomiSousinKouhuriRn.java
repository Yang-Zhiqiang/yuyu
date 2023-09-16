package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KesikomiSousinKouhuriRn;
import yuyu.def.db.mapping.GenZT_KesikomiSousinKouhuriRn;
import yuyu.def.db.meta.GenQZT_KesikomiSousinKouhuriRn;
import yuyu.def.db.meta.QZT_KesikomiSousinKouhuriRn;

/**
 * 消込送信Ｆ（口振）テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KesikomiSousinKouhuriRn} の JavaDoc を参照してください。
 * @see     GenZT_KesikomiSousinKouhuriRn
 * @see     PKZT_KesikomiSousinKouhuriRn
 * @see     QZT_KesikomiSousinKouhuriRn
 * @see     GenQZT_KesikomiSousinKouhuriRn
 */
@Entity
public class ZT_KesikomiSousinKouhuriRn extends GenZT_KesikomiSousinKouhuriRn {

    private static final long serialVersionUID = 1L;

    public ZT_KesikomiSousinKouhuriRn() {
    }

    public ZT_KesikomiSousinKouhuriRn(String pZrnkskmsousinrenno, String pZrnkskmfsyoriymd) {
        super(pZrnkskmsousinrenno, pZrnkskmfsyoriymd);
    }

}
