package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KesikomiSousinHurikaeRn;
import yuyu.def.db.mapping.GenZT_KesikomiSousinHurikaeRn;
import yuyu.def.db.meta.GenQZT_KesikomiSousinHurikaeRn;
import yuyu.def.db.meta.QZT_KesikomiSousinHurikaeRn;

/**
 * 消込送信Ｆ（振替）テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KesikomiSousinHurikaeRn} の JavaDoc を参照してください。
 * @see     GenZT_KesikomiSousinHurikaeRn
 * @see     PKZT_KesikomiSousinHurikaeRn
 * @see     QZT_KesikomiSousinHurikaeRn
 * @see     GenQZT_KesikomiSousinHurikaeRn
 */
@Entity
public class ZT_KesikomiSousinHurikaeRn extends GenZT_KesikomiSousinHurikaeRn {

    private static final long serialVersionUID = 1L;

    public ZT_KesikomiSousinHurikaeRn() {
    }

    public ZT_KesikomiSousinHurikaeRn(String pZrnkskmsousinrenno, String pZrnkskmfsyoriymd) {
        super(pZrnkskmsousinrenno, pZrnkskmfsyoriymd);
    }

}
