package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_TtdkKanKiykRn;
import yuyu.def.db.mapping.GenZT_TtdkKanKiykRn;
import yuyu.def.db.meta.GenQZT_TtdkKanKiykRn;
import yuyu.def.db.meta.QZT_TtdkKanKiykRn;

/**
 * 手続完了（解約）Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_TtdkKanKiykRn} の JavaDoc を参照してください。
 * @see     GenZT_TtdkKanKiykRn
 * @see     PKZT_TtdkKanKiykRn
 * @see     QZT_TtdkKanKiykRn
 * @see     GenQZT_TtdkKanKiykRn
 */
@Entity
public class ZT_TtdkKanKiykRn extends GenZT_TtdkKanKiykRn {

    private static final long serialVersionUID = 1L;

    public ZT_TtdkKanKiykRn() {
    }

    public ZT_TtdkKanKiykRn(
        String pZrntyouhyouymd,
        String pZrnsyono,
        String pZrnsikibetuno
    ) {
        super(
            pZrntyouhyouymd,
            pZrnsyono,
            pZrnsikibetuno
        );
    }

}
