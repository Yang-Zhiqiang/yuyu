package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_NkHitAddInfoRn;
import yuyu.def.db.mapping.GenZT_NkHitAddInfoRn;
import yuyu.def.db.meta.GenQZT_NkHitAddInfoRn;
import yuyu.def.db.meta.QZT_NkHitAddInfoRn;

/**
 * 年金配当所要額追加情報反映テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_NkHitAddInfoRn} の JavaDoc を参照してください。
 * @see     GenZT_NkHitAddInfoRn
 * @see     PKZT_NkHitAddInfoRn
 * @see     QZT_NkHitAddInfoRn
 * @see     GenQZT_NkHitAddInfoRn
 */
@Entity
public class ZT_NkHitAddInfoRn extends GenZT_NkHitAddInfoRn {

    private static final long serialVersionUID = 1L;

    public ZT_NkHitAddInfoRn() {
    }

    public ZT_NkHitAddInfoRn(String pZrnnksyousyono) {
        super(pZrnnksyousyono);
    }

}
