package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_IsaToukeiDataRn;
import yuyu.def.db.mapping.GenZT_IsaToukeiDataRn;
import yuyu.def.db.meta.GenQZT_IsaToukeiDataRn;
import yuyu.def.db.meta.QZT_IsaToukeiDataRn;

/**
 * 医査統計データテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_IsaToukeiDataRn} の JavaDoc を参照してください。
 * @see     GenZT_IsaToukeiDataRn
 * @see     PKZT_IsaToukeiDataRn
 * @see     QZT_IsaToukeiDataRn
 * @see     GenQZT_IsaToukeiDataRn
 */
@Entity
public class ZT_IsaToukeiDataRn extends GenZT_IsaToukeiDataRn {

    private static final long serialVersionUID = 1L;

    public ZT_IsaToukeiDataRn() {
    }

    public ZT_IsaToukeiDataRn(String pZrnmosno) {
        super(pZrnmosno);
    }

}
