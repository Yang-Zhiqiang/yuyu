package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_YuukouseiNgTuutiRn;
import yuyu.def.db.mapping.GenZT_YuukouseiNgTuutiRn;
import yuyu.def.db.meta.GenQZT_YuukouseiNgTuutiRn;
import yuyu.def.db.meta.QZT_YuukouseiNgTuutiRn;

/**
 * 有効性確認ＮＧ通知テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_YuukouseiNgTuutiRn} の JavaDoc を参照してください。
 * @see     GenZT_YuukouseiNgTuutiRn
 * @see     PKZT_YuukouseiNgTuutiRn
 * @see     QZT_YuukouseiNgTuutiRn
 * @see     GenQZT_YuukouseiNgTuutiRn
 */
@Entity
public class ZT_YuukouseiNgTuutiRn extends GenZT_YuukouseiNgTuutiRn {

    private static final long serialVersionUID = 1L;

    public ZT_YuukouseiNgTuutiRn() {
    }

    public ZT_YuukouseiNgTuutiRn(String pZrntyouhyouymd, String pZrnsyono) {
        super(pZrntyouhyouymd, pZrnsyono);
    }

}
