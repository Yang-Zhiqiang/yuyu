package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_NkHitKsnRn;
import yuyu.def.db.mapping.GenZT_NkHitKsnRn;
import yuyu.def.db.meta.GenQZT_NkHitKsnRn;
import yuyu.def.db.meta.QZT_NkHitKsnRn;

/**
 * 年金配当所要額Ｆ決算報告用テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_NkHitKsnRn} の JavaDoc を参照してください。
 * @see     GenZT_NkHitKsnRn
 * @see     PKZT_NkHitKsnRn
 * @see     QZT_NkHitKsnRn
 * @see     GenQZT_NkHitKsnRn
 */
@Entity
public class ZT_NkHitKsnRn extends GenZT_NkHitKsnRn {

    private static final long serialVersionUID = 1L;

    public ZT_NkHitKsnRn() {
    }

    public ZT_NkHitKsnRn(String pZrnnksyousyono) {
        super(pZrnnksyousyono);
    }

}
