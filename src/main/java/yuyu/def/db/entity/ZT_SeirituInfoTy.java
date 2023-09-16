package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SeirituInfoTy;
import yuyu.def.db.mapping.GenZT_SeirituInfoTy;
import yuyu.def.db.meta.GenQZT_SeirituInfoTy;
import yuyu.def.db.meta.QZT_SeirituInfoTy;

/**
 * 成立情報Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SeirituInfoTy} の JavaDoc を参照してください。
 * @see     GenZT_SeirituInfoTy
 * @see     PKZT_SeirituInfoTy
 * @see     QZT_SeirituInfoTy
 * @see     GenQZT_SeirituInfoTy
 */
@Entity
public class ZT_SeirituInfoTy extends GenZT_SeirituInfoTy {

    private static final long serialVersionUID = 1L;

    public ZT_SeirituInfoTy() {
    }

    public ZT_SeirituInfoTy(String pZtykijyunym, String pZtysyono) {
        super(pZtykijyunym, pZtysyono);
    }

}
