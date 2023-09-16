package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_AlmNnknHyuRn;
import yuyu.def.db.mapping.GenZT_AlmNnknHyuRn;
import yuyu.def.db.meta.GenQZT_AlmNnknHyuRn;
import yuyu.def.db.meta.QZT_AlmNnknHyuRn;

/**
 * ＡＬＭ用年金保有明細テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_AlmNnknHyuRn} の JavaDoc を参照してください。
 * @see     GenZT_AlmNnknHyuRn
 * @see     PKZT_AlmNnknHyuRn
 * @see     QZT_AlmNnknHyuRn
 * @see     GenQZT_AlmNnknHyuRn
 */
@Entity
public class ZT_AlmNnknHyuRn extends GenZT_AlmNnknHyuRn {

    private static final long serialVersionUID = 1L;

    public ZT_AlmNnknHyuRn() {
    }

    public ZT_AlmNnknHyuRn(String pZrnnksyousyono) {
        super(pZrnnksyousyono);
    }

}
