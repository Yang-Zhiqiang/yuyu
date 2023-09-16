package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_NkHitKtyTy;
import yuyu.def.db.mapping.GenZT_NkHitKtyTy;
import yuyu.def.db.meta.GenQZT_NkHitKtyTy;
import yuyu.def.db.meta.QZT_NkHitKtyTy;

/**
 * 年金配当所要額Ｆ期中報告用テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_NkHitKtyTy} の JavaDoc を参照してください。
 * @see     GenZT_NkHitKtyTy
 * @see     PKZT_NkHitKtyTy
 * @see     QZT_NkHitKtyTy
 * @see     GenQZT_NkHitKtyTy
 */
@Entity
public class ZT_NkHitKtyTy extends GenZT_NkHitKtyTy {

    private static final long serialVersionUID = 1L;

    public ZT_NkHitKtyTy() {
    }

    public ZT_NkHitKtyTy(String pZtynksyousyono) {
        super(pZtynksyousyono);
    }

}
