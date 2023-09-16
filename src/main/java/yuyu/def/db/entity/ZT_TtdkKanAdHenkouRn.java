package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_TtdkKanAdHenkouRn;
import yuyu.def.db.mapping.GenZT_TtdkKanAdHenkouRn;
import yuyu.def.db.meta.GenQZT_TtdkKanAdHenkouRn;
import yuyu.def.db.meta.QZT_TtdkKanAdHenkouRn;

/**
 * 手続完了（住所変更）Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_TtdkKanAdHenkouRn} の JavaDoc を参照してください。
 * @see     GenZT_TtdkKanAdHenkouRn
 * @see     PKZT_TtdkKanAdHenkouRn
 * @see     QZT_TtdkKanAdHenkouRn
 * @see     GenQZT_TtdkKanAdHenkouRn
 */
@Entity
public class ZT_TtdkKanAdHenkouRn extends GenZT_TtdkKanAdHenkouRn {

    private static final long serialVersionUID = 1L;

    public ZT_TtdkKanAdHenkouRn() {
    }

    public ZT_TtdkKanAdHenkouRn(
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
