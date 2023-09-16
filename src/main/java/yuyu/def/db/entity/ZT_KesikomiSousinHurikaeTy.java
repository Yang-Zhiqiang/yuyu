package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KesikomiSousinHurikaeTy;
import yuyu.def.db.mapping.GenZT_KesikomiSousinHurikaeTy;
import yuyu.def.db.meta.GenQZT_KesikomiSousinHurikaeTy;
import yuyu.def.db.meta.QZT_KesikomiSousinHurikaeTy;

/**
 * 消込送信Ｆ（振替）テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KesikomiSousinHurikaeTy} の JavaDoc を参照してください。
 * @see     GenZT_KesikomiSousinHurikaeTy
 * @see     PKZT_KesikomiSousinHurikaeTy
 * @see     QZT_KesikomiSousinHurikaeTy
 * @see     GenQZT_KesikomiSousinHurikaeTy
 */
@Entity
public class ZT_KesikomiSousinHurikaeTy extends GenZT_KesikomiSousinHurikaeTy {

    private static final long serialVersionUID = 1L;

    public ZT_KesikomiSousinHurikaeTy() {
    }

    public ZT_KesikomiSousinHurikaeTy(String pZtykskmsousinrenno, String pZtykskmfsyoriymd) {
        super(pZtykskmsousinrenno, pZtykskmfsyoriymd);
    }

}
