package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_NkIktHriTy;
import yuyu.def.db.mapping.GenZT_NkIktHriTy;
import yuyu.def.db.meta.GenQZT_NkIktHriTy;
import yuyu.def.db.meta.QZT_NkIktHriTy;

/**
 * 年金一括払テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_NkIktHriTy} の JavaDoc を参照してください。
 * @see     GenZT_NkIktHriTy
 * @see     PKZT_NkIktHriTy
 * @see     QZT_NkIktHriTy
 * @see     GenQZT_NkIktHriTy
 */
@Entity
public class ZT_NkIktHriTy extends GenZT_NkIktHriTy {

    private static final long serialVersionUID = 1L;

    public ZT_NkIktHriTy() {
    }

    public ZT_NkIktHriTy(String pZtydatakanrino) {
        super(pZtydatakanrino);
    }

}
