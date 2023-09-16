package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_NkHitKsnTy;
import yuyu.def.db.mapping.GenZT_NkHitKsnTy;
import yuyu.def.db.meta.GenQZT_NkHitKsnTy;
import yuyu.def.db.meta.QZT_NkHitKsnTy;

/**
 * 年金配当所要額Ｆ決算報告用テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_NkHitKsnTy} の JavaDoc を参照してください。
 * @see     GenZT_NkHitKsnTy
 * @see     PKZT_NkHitKsnTy
 * @see     QZT_NkHitKsnTy
 * @see     GenQZT_NkHitKsnTy
 */
@Entity
public class ZT_NkHitKsnTy extends GenZT_NkHitKsnTy {

    private static final long serialVersionUID = 1L;

    public ZT_NkHitKsnTy() {
    }

    public ZT_NkHitKsnTy(String pZtynksyousyono) {
        super(pZtynksyousyono);
    }

}
