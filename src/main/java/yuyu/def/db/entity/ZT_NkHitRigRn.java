package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_NkHitRigRn;
import yuyu.def.db.mapping.GenZT_NkHitRigRn;
import yuyu.def.db.meta.GenQZT_NkHitRigRn;
import yuyu.def.db.meta.QZT_NkHitRigRn;

/**
 * 年金配当所要額Ｆ例月報告用テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_NkHitRigRn} の JavaDoc を参照してください。
 * @see     GenZT_NkHitRigRn
 * @see     PKZT_NkHitRigRn
 * @see     QZT_NkHitRigRn
 * @see     GenQZT_NkHitRigRn
 */
@Entity
public class ZT_NkHitRigRn extends GenZT_NkHitRigRn {

    private static final long serialVersionUID = 1L;

    public ZT_NkHitRigRn() {
    }

    public ZT_NkHitRigRn(String pZrnnksyousyono) {
        super(pZrnnksyousyono);
    }

}
