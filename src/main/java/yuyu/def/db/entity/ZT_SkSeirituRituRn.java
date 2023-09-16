package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SkSeirituRituRn;
import yuyu.def.db.mapping.GenZT_SkSeirituRituRn;
import yuyu.def.db.meta.GenQZT_SkSeirituRituRn;
import yuyu.def.db.meta.QZT_SkSeirituRituRn;

/**
 * 新契約成立率Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SkSeirituRituRn} の JavaDoc を参照してください。
 * @see     GenZT_SkSeirituRituRn
 * @see     PKZT_SkSeirituRituRn
 * @see     QZT_SkSeirituRituRn
 * @see     GenQZT_SkSeirituRituRn
 */
@Entity
public class ZT_SkSeirituRituRn extends GenZT_SkSeirituRituRn {

    private static final long serialVersionUID = 1L;

    public ZT_SkSeirituRituRn() {
    }

    public ZT_SkSeirituRituRn(
        String pZrneigyouhonbusisyacd,
        String pZrnsosikicd,
        String pZrnatukaikojincd,
        String pZrnmosno
    ) {
        super(
            pZrneigyouhonbusisyacd,
            pZrnsosikicd,
            pZrnatukaikojincd,
            pZrnmosno
        );
    }

}
