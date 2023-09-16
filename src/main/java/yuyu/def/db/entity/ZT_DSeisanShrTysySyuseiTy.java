package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_DSeisanShrTysySyuseiTy;
import yuyu.def.db.mapping.GenZT_DSeisanShrTysySyuseiTy;
import yuyu.def.db.meta.GenQZT_DSeisanShrTysySyuseiTy;
import yuyu.def.db.meta.QZT_DSeisanShrTysySyuseiTy;

/**
 * Ｄ精算支払調書修正テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_DSeisanShrTysySyuseiTy} の JavaDoc を参照してください。
 * @see     GenZT_DSeisanShrTysySyuseiTy
 * @see     PKZT_DSeisanShrTysySyuseiTy
 * @see     QZT_DSeisanShrTysySyuseiTy
 * @see     GenQZT_DSeisanShrTysySyuseiTy
 */
@Entity
public class ZT_DSeisanShrTysySyuseiTy extends GenZT_DSeisanShrTysySyuseiTy {

    private static final long serialVersionUID = 1L;

    public ZT_DSeisanShrTysySyuseiTy() {
    }

    public ZT_DSeisanShrTysySyuseiTy(String pZtysyono) {
        super(pZtysyono);
    }

}
