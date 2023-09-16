package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KaiykHrSoutougakuRn;
import yuyu.def.db.mapping.GenZT_KaiykHrSoutougakuRn;
import yuyu.def.db.meta.GenQZT_KaiykHrSoutougakuRn;
import yuyu.def.db.meta.QZT_KaiykHrSoutougakuRn;

/**
 * 解約返戻金相当額Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KaiykHrSoutougakuRn} の JavaDoc を参照してください。
 * @see     GenZT_KaiykHrSoutougakuRn
 * @see     PKZT_KaiykHrSoutougakuRn
 * @see     QZT_KaiykHrSoutougakuRn
 * @see     GenQZT_KaiykHrSoutougakuRn
 */
@Entity
public class ZT_KaiykHrSoutougakuRn extends GenZT_KaiykHrSoutougakuRn {

    private static final long serialVersionUID = 1L;

    public ZT_KaiykHrSoutougakuRn() {
    }

    public ZT_KaiykHrSoutougakuRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
