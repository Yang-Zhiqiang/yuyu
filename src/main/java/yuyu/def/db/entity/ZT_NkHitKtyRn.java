package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_NkHitKtyRn;
import yuyu.def.db.mapping.GenZT_NkHitKtyRn;
import yuyu.def.db.meta.GenQZT_NkHitKtyRn;
import yuyu.def.db.meta.QZT_NkHitKtyRn;

/**
 * 年金配当所要額Ｆ期中報告用テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_NkHitKtyRn} の JavaDoc を参照してください。
 * @see     GenZT_NkHitKtyRn
 * @see     PKZT_NkHitKtyRn
 * @see     QZT_NkHitKtyRn
 * @see     GenQZT_NkHitKtyRn
 */
@Entity
public class ZT_NkHitKtyRn extends GenZT_NkHitKtyRn {

    private static final long serialVersionUID = 1L;

    public ZT_NkHitKtyRn() {
    }

    public ZT_NkHitKtyRn(String pZrnnksyousyono) {
        super(pZrnnksyousyono);
    }

}
