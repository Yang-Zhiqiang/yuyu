package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_HrhnTtdkKanRn;
import yuyu.def.db.mapping.GenZT_HrhnTtdkKanRn;
import yuyu.def.db.meta.GenQZT_HrhnTtdkKanRn;
import yuyu.def.db.meta.QZT_HrhnTtdkKanRn;

/**
 * 手続完了（払方変更）テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_HrhnTtdkKanRn} の JavaDoc を参照してください。
 * @see     GenZT_HrhnTtdkKanRn
 * @see     PKZT_HrhnTtdkKanRn
 * @see     QZT_HrhnTtdkKanRn
 * @see     GenQZT_HrhnTtdkKanRn
 */
@Entity
public class ZT_HrhnTtdkKanRn extends GenZT_HrhnTtdkKanRn {

    private static final long serialVersionUID = 1L;

    public ZT_HrhnTtdkKanRn() {
    }

    public ZT_HrhnTtdkKanRn(
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
