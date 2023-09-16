package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_OuNnknShrRn;
import yuyu.def.db.mapping.GenZT_OuNnknShrRn;
import yuyu.def.db.meta.GenQZT_OuNnknShrRn;
import yuyu.def.db.meta.QZT_OuNnknShrRn;

/**
 * ＯＵ用年金支払テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_OuNnknShrRn} の JavaDoc を参照してください。
 * @see     GenZT_OuNnknShrRn
 * @see     PKZT_OuNnknShrRn
 * @see     QZT_OuNnknShrRn
 * @see     GenQZT_OuNnknShrRn
 */
@Entity
public class ZT_OuNnknShrRn extends GenZT_OuNnknShrRn {

    private static final long serialVersionUID = 1L;

    public ZT_OuNnknShrRn() {
    }

    public ZT_OuNnknShrRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
