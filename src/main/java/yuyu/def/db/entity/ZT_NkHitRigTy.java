package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_NkHitRigTy;
import yuyu.def.db.mapping.GenZT_NkHitRigTy;
import yuyu.def.db.meta.GenQZT_NkHitRigTy;
import yuyu.def.db.meta.QZT_NkHitRigTy;

/**
 * 年金配当所要額Ｆ例月報告用テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_NkHitRigTy} の JavaDoc を参照してください。
 * @see     GenZT_NkHitRigTy
 * @see     PKZT_NkHitRigTy
 * @see     QZT_NkHitRigTy
 * @see     GenQZT_NkHitRigTy
 */
@Entity
public class ZT_NkHitRigTy extends GenZT_NkHitRigTy {

    private static final long serialVersionUID = 1L;

    public ZT_NkHitRigTy() {
    }

    public ZT_NkHitRigTy(String pZtynksyousyono) {
        super(pZtynksyousyono);
    }

}
