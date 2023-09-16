package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_EgsyokuinSysRendouRn;
import yuyu.def.db.mapping.GenZT_EgsyokuinSysRendouRn;
import yuyu.def.db.meta.GenQZT_EgsyokuinSysRendouRn;
import yuyu.def.db.meta.QZT_EgsyokuinSysRendouRn;

/**
 * 営業職員システム連動Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_EgsyokuinSysRendouRn} の JavaDoc を参照してください。
 * @see     GenZT_EgsyokuinSysRendouRn
 * @see     PKZT_EgsyokuinSysRendouRn
 * @see     QZT_EgsyokuinSysRendouRn
 * @see     GenQZT_EgsyokuinSysRendouRn
 */
@Entity
public class ZT_EgsyokuinSysRendouRn extends GenZT_EgsyokuinSysRendouRn {

    private static final long serialVersionUID = 1L;

    public ZT_EgsyokuinSysRendouRn() {
    }

    public ZT_EgsyokuinSysRendouRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
