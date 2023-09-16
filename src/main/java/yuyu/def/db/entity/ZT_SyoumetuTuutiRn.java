package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SyoumetuTuutiRn;
import yuyu.def.db.mapping.GenZT_SyoumetuTuutiRn;
import yuyu.def.db.meta.GenQZT_SyoumetuTuutiRn;
import yuyu.def.db.meta.QZT_SyoumetuTuutiRn;

/**
 * 消滅通知Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SyoumetuTuutiRn} の JavaDoc を参照してください。
 * @see     GenZT_SyoumetuTuutiRn
 * @see     PKZT_SyoumetuTuutiRn
 * @see     QZT_SyoumetuTuutiRn
 * @see     GenQZT_SyoumetuTuutiRn
 */
@Entity
public class ZT_SyoumetuTuutiRn extends GenZT_SyoumetuTuutiRn {

    private static final long serialVersionUID = 1L;

    public ZT_SyoumetuTuutiRn() {
    }

    public ZT_SyoumetuTuutiRn(
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
