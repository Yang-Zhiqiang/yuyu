package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_TtdkKanRn;
import yuyu.def.db.mapping.GenZT_TtdkKanRn;
import yuyu.def.db.meta.GenQZT_TtdkKanRn;
import yuyu.def.db.meta.QZT_TtdkKanRn;

/**
 * 手続完了Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_TtdkKanRn} の JavaDoc を参照してください。
 * @see     GenZT_TtdkKanRn
 * @see     PKZT_TtdkKanRn
 * @see     QZT_TtdkKanRn
 * @see     GenQZT_TtdkKanRn
 */
@Entity
public class ZT_TtdkKanRn extends GenZT_TtdkKanRn {

    private static final long serialVersionUID = 1L;

    public ZT_TtdkKanRn() {
    }

    public ZT_TtdkKanRn(
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
