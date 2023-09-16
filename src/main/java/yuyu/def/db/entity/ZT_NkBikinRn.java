package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_NkBikinRn;
import yuyu.def.db.mapping.GenZT_NkBikinRn;
import yuyu.def.db.meta.GenQZT_NkBikinRn;
import yuyu.def.db.meta.QZT_NkBikinRn;

/**
 * 年金備金テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_NkBikinRn} の JavaDoc を参照してください。
 * @see     GenZT_NkBikinRn
 * @see     PKZT_NkBikinRn
 * @see     QZT_NkBikinRn
 * @see     GenQZT_NkBikinRn
 */
@Entity
public class ZT_NkBikinRn extends GenZT_NkBikinRn {

    private static final long serialVersionUID = 1L;

    public ZT_NkBikinRn() {
    }

    public ZT_NkBikinRn(String pZrnnksyousyono, String pZrnshiharaihasseiymd) {
        super(pZrnnksyousyono, pZrnshiharaihasseiymd);
    }

}
