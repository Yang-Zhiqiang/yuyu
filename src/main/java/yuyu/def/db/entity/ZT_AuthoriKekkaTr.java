package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_AuthoriKekkaTr;
import yuyu.def.db.mapping.GenZT_AuthoriKekkaTr;
import yuyu.def.db.meta.GenQZT_AuthoriKekkaTr;
import yuyu.def.db.meta.QZT_AuthoriKekkaTr;

/**
 * オーソリ結果Ｆテーブル（取） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_AuthoriKekkaTr} の JavaDoc を参照してください。
 * @see     GenZT_AuthoriKekkaTr
 * @see     PKZT_AuthoriKekkaTr
 * @see     QZT_AuthoriKekkaTr
 * @see     GenQZT_AuthoriKekkaTr
 */
@Entity
public class ZT_AuthoriKekkaTr extends GenZT_AuthoriKekkaTr {

    private static final long serialVersionUID = 1L;

    public ZT_AuthoriKekkaTr() {
    }

    public ZT_AuthoriKekkaTr(
        String pZtrrenno7,
        String pZtrcreditkessaiyouno,
        String pZtrdatajyusinymd
    ) {
        super(
            pZtrrenno7,
            pZtrcreditkessaiyouno,
            pZtrdatajyusinymd
        );
    }

}
