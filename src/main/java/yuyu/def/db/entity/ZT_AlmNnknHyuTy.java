package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_AlmNnknHyuTy;
import yuyu.def.db.mapping.GenZT_AlmNnknHyuTy;
import yuyu.def.db.meta.GenQZT_AlmNnknHyuTy;
import yuyu.def.db.meta.QZT_AlmNnknHyuTy;

/**
 * ＡＬＭ用年金保有明細テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_AlmNnknHyuTy} の JavaDoc を参照してください。
 * @see     GenZT_AlmNnknHyuTy
 * @see     PKZT_AlmNnknHyuTy
 * @see     QZT_AlmNnknHyuTy
 * @see     GenQZT_AlmNnknHyuTy
 */
@Entity
public class ZT_AlmNnknHyuTy extends GenZT_AlmNnknHyuTy {

    private static final long serialVersionUID = 1L;

    public ZT_AlmNnknHyuTy() {
    }

    public ZT_AlmNnknHyuTy(String pZtynksyousyono) {
        super(pZtynksyousyono);
    }

}
