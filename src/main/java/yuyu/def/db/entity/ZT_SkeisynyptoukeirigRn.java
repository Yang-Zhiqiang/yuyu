package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SkeisynyptoukeirigRn;
import yuyu.def.db.mapping.GenZT_SkeisynyptoukeirigRn;
import yuyu.def.db.meta.GenQZT_SkeisynyptoukeirigRn;
import yuyu.def.db.meta.QZT_SkeisynyptoukeirigRn;

/**
 * 新契約収入Ｐ統計例月Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SkeisynyptoukeirigRn} の JavaDoc を参照してください。
 * @see     GenZT_SkeisynyptoukeirigRn
 * @see     PKZT_SkeisynyptoukeirigRn
 * @see     QZT_SkeisynyptoukeirigRn
 * @see     GenQZT_SkeisynyptoukeirigRn
 */
@Entity
public class ZT_SkeisynyptoukeirigRn extends GenZT_SkeisynyptoukeirigRn {

    private static final long serialVersionUID = 1L;

    public ZT_SkeisynyptoukeirigRn() {
    }

    public ZT_SkeisynyptoukeirigRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
