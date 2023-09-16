package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_DSeisanShrTysySyuseiRn;
import yuyu.def.db.mapping.GenZT_DSeisanShrTysySyuseiRn;
import yuyu.def.db.meta.GenQZT_DSeisanShrTysySyuseiRn;
import yuyu.def.db.meta.QZT_DSeisanShrTysySyuseiRn;

/**
 * Ｄ精算支払調書修正テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_DSeisanShrTysySyuseiRn} の JavaDoc を参照してください。
 * @see     GenZT_DSeisanShrTysySyuseiRn
 * @see     PKZT_DSeisanShrTysySyuseiRn
 * @see     QZT_DSeisanShrTysySyuseiRn
 * @see     GenQZT_DSeisanShrTysySyuseiRn
 */
@Entity
public class ZT_DSeisanShrTysySyuseiRn extends GenZT_DSeisanShrTysySyuseiRn {

    private static final long serialVersionUID = 1L;

    public ZT_DSeisanShrTysySyuseiRn() {
    }

    public ZT_DSeisanShrTysySyuseiRn(String pZrnsyono) {
        super(pZrnsyono);
    }

}
