package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKZT_SntkInfoHaneiKekkaRn;
import yuyu.def.db.mapping.GenZT_SntkInfoHaneiKekkaRn;
import yuyu.def.db.meta.GenQZT_SntkInfoHaneiKekkaRn;
import yuyu.def.db.meta.QZT_SntkInfoHaneiKekkaRn;

/**
 * 普保Ⅱ選択情報反映結果テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SntkInfoHaneiKekkaRn} の JavaDoc を参照してください。
 * @see     GenZT_SntkInfoHaneiKekkaRn
 * @see     PKZT_SntkInfoHaneiKekkaRn
 * @see     QZT_SntkInfoHaneiKekkaRn
 * @see     GenQZT_SntkInfoHaneiKekkaRn
 */
@Entity
public class ZT_SntkInfoHaneiKekkaRn extends GenZT_SntkInfoHaneiKekkaRn {

    private static final long serialVersionUID = 1L;

    public ZT_SntkInfoHaneiKekkaRn() {
    }

    public ZT_SntkInfoHaneiKekkaRn(
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
