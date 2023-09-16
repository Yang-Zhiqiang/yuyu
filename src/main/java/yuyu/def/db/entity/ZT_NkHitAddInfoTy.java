package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_NkHitAddInfoTy;
import yuyu.def.db.mapping.GenZT_NkHitAddInfoTy;
import yuyu.def.db.meta.GenQZT_NkHitAddInfoTy;
import yuyu.def.db.meta.QZT_NkHitAddInfoTy;

/**
 * 年金配当所要額追加情報反映テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_NkHitAddInfoTy} の JavaDoc を参照してください。
 * @see     GenZT_NkHitAddInfoTy
 * @see     PKZT_NkHitAddInfoTy
 * @see     QZT_NkHitAddInfoTy
 * @see     GenQZT_NkHitAddInfoTy
 */
@Entity
public class ZT_NkHitAddInfoTy extends GenZT_NkHitAddInfoTy {

    private static final long serialVersionUID = 1L;

    public ZT_NkHitAddInfoTy() {
    }

    public ZT_NkHitAddInfoTy(String pZtynksyousyono) {
        super(pZtynksyousyono);
    }

}
