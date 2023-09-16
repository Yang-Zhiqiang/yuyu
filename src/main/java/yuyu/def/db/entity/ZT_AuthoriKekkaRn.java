package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_AuthoriKekkaRn;
import yuyu.def.db.mapping.GenZT_AuthoriKekkaRn;
import yuyu.def.db.meta.GenQZT_AuthoriKekkaRn;
import yuyu.def.db.meta.QZT_AuthoriKekkaRn;

/**
 * オーソリ結果Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_AuthoriKekkaRn} の JavaDoc を参照してください。
 * @see     GenZT_AuthoriKekkaRn
 * @see     PKZT_AuthoriKekkaRn
 * @see     QZT_AuthoriKekkaRn
 * @see     GenQZT_AuthoriKekkaRn
 */
@Entity
public class ZT_AuthoriKekkaRn extends GenZT_AuthoriKekkaRn {

    private static final long serialVersionUID = 1L;

    public ZT_AuthoriKekkaRn() {
    }

    public ZT_AuthoriKekkaRn(
        String pZrnrenno7,
        String pZrncreditkessaiyouno,
        String pZrndatajyusinymd
    ) {
        super(
            pZrnrenno7,
            pZrncreditkessaiyouno,
            pZrndatajyusinymd
        );
    }

}
