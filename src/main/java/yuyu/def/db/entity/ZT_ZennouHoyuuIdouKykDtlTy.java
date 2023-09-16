package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_ZennouHoyuuIdouKykDtlTy;
import yuyu.def.db.mapping.GenZT_ZennouHoyuuIdouKykDtlTy;
import yuyu.def.db.meta.GenQZT_ZennouHoyuuIdouKykDtlTy;
import yuyu.def.db.meta.QZT_ZennouHoyuuIdouKykDtlTy;

/**
 * 前納保有異動契約明細Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_ZennouHoyuuIdouKykDtlTy} の JavaDoc を参照してください。
 * @see     GenZT_ZennouHoyuuIdouKykDtlTy
 * @see     PKZT_ZennouHoyuuIdouKykDtlTy
 * @see     QZT_ZennouHoyuuIdouKykDtlTy
 * @see     GenQZT_ZennouHoyuuIdouKykDtlTy
 */
@Entity
public class ZT_ZennouHoyuuIdouKykDtlTy extends GenZT_ZennouHoyuuIdouKykDtlTy {

    private static final long serialVersionUID = 1L;

    public ZT_ZennouHoyuuIdouKykDtlTy() {
    }

    public ZT_ZennouHoyuuIdouKykDtlTy(
        String pZtydatakanrino,
        String pZtysyoricd,
        Integer pZtykykmfksnctr
    ) {
        super(
            pZtydatakanrino,
            pZtysyoricd,
            pZtykykmfksnctr
        );
    }

}
