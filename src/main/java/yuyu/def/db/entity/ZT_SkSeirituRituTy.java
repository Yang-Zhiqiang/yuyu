package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SkSeirituRituTy;
import yuyu.def.db.mapping.GenZT_SkSeirituRituTy;
import yuyu.def.db.meta.GenQZT_SkSeirituRituTy;
import yuyu.def.db.meta.QZT_SkSeirituRituTy;

/**
 * 新契約成立率Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SkSeirituRituTy} の JavaDoc を参照してください。
 * @see     GenZT_SkSeirituRituTy
 * @see     PKZT_SkSeirituRituTy
 * @see     QZT_SkSeirituRituTy
 * @see     GenQZT_SkSeirituRituTy
 */
@Entity
public class ZT_SkSeirituRituTy extends GenZT_SkSeirituRituTy {

    private static final long serialVersionUID = 1L;

    public ZT_SkSeirituRituTy() {
    }

    public ZT_SkSeirituRituTy(
        String pZtyeigyouhonbusisyacd,
        String pZtysosikicd,
        String pZtyatukaikojincd,
        String pZtymosno
    ) {
        super(
            pZtyeigyouhonbusisyacd,
            pZtysosikicd,
            pZtyatukaikojincd,
            pZtymosno
        );
    }

}
