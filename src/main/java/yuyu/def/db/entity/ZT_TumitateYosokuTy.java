package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_TumitateYosokuTy;
import yuyu.def.db.mapping.GenZT_TumitateYosokuTy;
import yuyu.def.db.meta.GenQZT_TumitateYosokuTy;
import yuyu.def.db.meta.QZT_TumitateYosokuTy;

/**
 * 積立金額予測ファイルテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_TumitateYosokuTy} の JavaDoc を参照してください。
 * @see     GenZT_TumitateYosokuTy
 * @see     PKZT_TumitateYosokuTy
 * @see     QZT_TumitateYosokuTy
 * @see     GenQZT_TumitateYosokuTy
 */
@Entity
public class ZT_TumitateYosokuTy extends GenZT_TumitateYosokuTy {

    private static final long serialVersionUID = 1L;

    public ZT_TumitateYosokuTy() {
    }

    public ZT_TumitateYosokuTy(
        String pZtyhknsyukigou,
        String pZtykeiyakuymd,
        String pZtytysytymd,
        String pZtykyktuukasyu,
        String pZtyhknkkn,
        String pZtytmttknsyuruikbn,
        String pZtysisuukbn
    ) {
        super(
            pZtyhknsyukigou,
            pZtykeiyakuymd,
            pZtytysytymd,
            pZtykyktuukasyu,
            pZtyhknkkn,
            pZtytmttknsyuruikbn,
            pZtysisuukbn
        );
    }

}
