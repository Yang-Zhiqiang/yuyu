package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKZT_SntkInfoTourokuRn;
import yuyu.def.db.mapping.GenZT_SntkInfoTourokuRn;
import yuyu.def.db.meta.GenQZT_SntkInfoTourokuRn;
import yuyu.def.db.meta.QZT_SntkInfoTourokuRn;

/**
 * 選択情報登録テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SntkInfoTourokuRn} の JavaDoc を参照してください。
 * @see     GenZT_SntkInfoTourokuRn
 * @see     PKZT_SntkInfoTourokuRn
 * @see     QZT_SntkInfoTourokuRn
 * @see     GenQZT_SntkInfoTourokuRn
 */
@Entity
public class ZT_SntkInfoTourokuRn extends GenZT_SntkInfoTourokuRn {

    private static final long serialVersionUID = 1L;

    public ZT_SntkInfoTourokuRn() {
    }

    public ZT_SntkInfoTourokuRn(
        String pZrnsntkinfono,
        String pZrnrenno,
        String pZrnsntkinfotourokusyskbn
    ) {
        super(
            pZrnsntkinfono,
            pZrnrenno,
            pZrnsntkinfotourokusyskbn
        );
    }

}
