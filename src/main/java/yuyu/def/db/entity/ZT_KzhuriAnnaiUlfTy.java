package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KzhuriAnnaiUlfTy;
import yuyu.def.db.mapping.GenZT_KzhuriAnnaiUlfTy;
import yuyu.def.db.meta.GenQZT_KzhuriAnnaiUlfTy;
import yuyu.def.db.meta.QZT_KzhuriAnnaiUlfTy;

/**
 * 口座振替案内ＵＬＦテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KzhuriAnnaiUlfTy} の JavaDoc を参照してください。
 * @see     GenZT_KzhuriAnnaiUlfTy
 * @see     PKZT_KzhuriAnnaiUlfTy
 * @see     QZT_KzhuriAnnaiUlfTy
 * @see     GenQZT_KzhuriAnnaiUlfTy
 */
@Entity
public class ZT_KzhuriAnnaiUlfTy extends GenZT_KzhuriAnnaiUlfTy {

    private static final long serialVersionUID = 1L;

    public ZT_KzhuriAnnaiUlfTy() {
    }

    public ZT_KzhuriAnnaiUlfTy(String pZtysyono, String pZtyjyuutouym) {
        super(pZtysyono, pZtyjyuutouym);
    }

}
