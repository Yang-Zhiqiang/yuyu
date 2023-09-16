package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_OuNnknShrTy;
import yuyu.def.db.mapping.GenZT_OuNnknShrTy;
import yuyu.def.db.meta.GenQZT_OuNnknShrTy;
import yuyu.def.db.meta.QZT_OuNnknShrTy;

/**
 * ＯＵ用年金支払テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_OuNnknShrTy} の JavaDoc を参照してください。
 * @see     GenZT_OuNnknShrTy
 * @see     PKZT_OuNnknShrTy
 * @see     QZT_OuNnknShrTy
 * @see     GenQZT_OuNnknShrTy
 */
@Entity
public class ZT_OuNnknShrTy extends GenZT_OuNnknShrTy {

    private static final long serialVersionUID = 1L;

    public ZT_OuNnknShrTy() {
    }

    public ZT_OuNnknShrTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
