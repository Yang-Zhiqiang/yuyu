package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKZT_SntkInfoHaneiKekkaTr;
import yuyu.def.db.mapping.GenZT_SntkInfoHaneiKekkaTr;
import yuyu.def.db.meta.GenQZT_SntkInfoHaneiKekkaTr;
import yuyu.def.db.meta.QZT_SntkInfoHaneiKekkaTr;

/**
 * 普保Ⅱ選択情報反映結果テーブル（取） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SntkInfoHaneiKekkaTr} の JavaDoc を参照してください。
 * @see     GenZT_SntkInfoHaneiKekkaTr
 * @see     PKZT_SntkInfoHaneiKekkaTr
 * @see     QZT_SntkInfoHaneiKekkaTr
 * @see     GenQZT_SntkInfoHaneiKekkaTr
 */
@Entity
public class ZT_SntkInfoHaneiKekkaTr extends GenZT_SntkInfoHaneiKekkaTr {

    private static final long serialVersionUID = 1L;

    public ZT_SntkInfoHaneiKekkaTr() {
    }

    public ZT_SntkInfoHaneiKekkaTr(
        String pZtrsntkinfono,
        Integer pZtrrenno,
        String pZtrsntkinfotourokusyskbn
    ) {
        super(
            pZtrsntkinfono,
            pZtrrenno,
            pZtrsntkinfotourokusyskbn
        );
    }

}
