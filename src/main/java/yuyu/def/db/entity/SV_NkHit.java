package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKSV_NkHit;
import yuyu.def.db.mapping.GenSV_NkHit;
import yuyu.def.db.meta.GenQSV_NkHit;
import yuyu.def.db.meta.QSV_NkHit;

/**
 * 年金配当所要額ビュー エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenSV_NkHit} の JavaDoc を参照してください。
 * @see     GenSV_NkHit
 * @see     PKSV_NkHit
 * @see     QSV_NkHit
 * @see     GenQSV_NkHit
 */
@Entity
public class SV_NkHit extends GenSV_NkHit {

    private static final long serialVersionUID = 1L;

    public SV_NkHit() {
    }

    public SV_NkHit(Integer pRenno8keta) {
        super(pRenno8keta);
    }

}
