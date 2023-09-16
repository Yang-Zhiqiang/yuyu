package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KaiykHrSoutougakuTy;
import yuyu.def.db.mapping.GenZT_KaiykHrSoutougakuTy;
import yuyu.def.db.meta.GenQZT_KaiykHrSoutougakuTy;
import yuyu.def.db.meta.QZT_KaiykHrSoutougakuTy;

/**
 * 解約返戻金相当額Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KaiykHrSoutougakuTy} の JavaDoc を参照してください。
 * @see     GenZT_KaiykHrSoutougakuTy
 * @see     PKZT_KaiykHrSoutougakuTy
 * @see     QZT_KaiykHrSoutougakuTy
 * @see     GenQZT_KaiykHrSoutougakuTy
 */
@Entity
public class ZT_KaiykHrSoutougakuTy extends GenZT_KaiykHrSoutougakuTy {

    private static final long serialVersionUID = 1L;

    public ZT_KaiykHrSoutougakuTy() {
    }

    public ZT_KaiykHrSoutougakuTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
