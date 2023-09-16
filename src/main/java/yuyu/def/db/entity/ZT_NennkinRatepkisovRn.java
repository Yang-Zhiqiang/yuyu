package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKZT_NennkinRatepkisovRn;
import yuyu.def.db.mapping.GenZT_NennkinRatepkisovRn;
import yuyu.def.db.meta.GenQZT_NennkinRatepkisovRn;
import yuyu.def.db.meta.QZT_NennkinRatepkisovRn;

/**
 * 年金開始後Ｐ基礎Ｖレートテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_NennkinRatepkisovRn} の JavaDoc を参照してください。
 * @see     GenZT_NennkinRatepkisovRn
 * @see     PKZT_NennkinRatepkisovRn
 * @see     QZT_NennkinRatepkisovRn
 * @see     GenQZT_NennkinRatepkisovRn
 */
@Entity
public class ZT_NennkinRatepkisovRn extends GenZT_NennkinRatepkisovRn {

    private static final long serialVersionUID = 1L;

    public ZT_NennkinRatepkisovRn() {
    }

    public ZT_NennkinRatepkisovRn(
        String pZrnnenkinkbn,
        String pZrnnenkinsyu,
        String pZrnnenkinkigousedaikbn,
        String pZrnnknshry,
        String pZrnnkkaisigoyoteiriritukbn,
        String pZrnnenkinjimutesuuryoukbn
    ) {
        super(
            pZrnnenkinkbn,
            pZrnnenkinsyu,
            pZrnnenkinkigousedaikbn,
            pZrnnknshry,
            pZrnnkkaisigoyoteiriritukbn,
            pZrnnenkinjimutesuuryoukbn
        );
    }

}
