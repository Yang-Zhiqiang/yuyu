package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_TumitateYosokuRn;
import yuyu.def.db.mapping.GenZT_TumitateYosokuRn;
import yuyu.def.db.meta.GenQZT_TumitateYosokuRn;
import yuyu.def.db.meta.QZT_TumitateYosokuRn;

/**
 * 積立金額予測ファイルテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_TumitateYosokuRn} の JavaDoc を参照してください。
 * @see     GenZT_TumitateYosokuRn
 * @see     PKZT_TumitateYosokuRn
 * @see     QZT_TumitateYosokuRn
 * @see     GenQZT_TumitateYosokuRn
 */
@Entity
public class ZT_TumitateYosokuRn extends GenZT_TumitateYosokuRn {

    private static final long serialVersionUID = 1L;

    public ZT_TumitateYosokuRn() {
    }

    public ZT_TumitateYosokuRn(
        String pZrnhknsyukigou,
        String pZrnkeiyakuymd,
        String pZrntysytymd,
        String pZrnkyktuukasyu,
        String pZrnhknkkn,
        String pZrntmttknsyuruikbn,
        String pZrnsisuukbn
    ) {
        super(
            pZrnhknsyukigou,
            pZrnkeiyakuymd,
            pZrntysytymd,
            pZrnkyktuukasyu,
            pZrnhknkkn,
            pZrntmttknsyuruikbn,
            pZrnsisuukbn
        );
    }

}
