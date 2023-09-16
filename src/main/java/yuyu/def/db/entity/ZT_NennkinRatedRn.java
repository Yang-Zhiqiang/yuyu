package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKZT_NennkinRatedRn;
import yuyu.def.db.mapping.GenZT_NennkinRatedRn;
import yuyu.def.db.meta.GenQZT_NennkinRatedRn;
import yuyu.def.db.meta.QZT_NennkinRatedRn;

/**
 * 年金開始後Ｄレートテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_NennkinRatedRn} の JavaDoc を参照してください。
 * @see     GenZT_NennkinRatedRn
 * @see     PKZT_NennkinRatedRn
 * @see     QZT_NennkinRatedRn
 * @see     GenQZT_NennkinRatedRn
 */
@Entity
public class ZT_NennkinRatedRn extends GenZT_NennkinRatedRn {

    private static final long serialVersionUID = 1L;

    public ZT_NennkinRatedRn() {
    }

    public ZT_NennkinRatedRn(
        String pZrnnenkinkbn,
        String pZrnnenkinsyu,
        String pZrnnenkinkigousedaikbn,
        String pZrnnknshry,
        String pZrnnkkaisigoyoteiriritukbn,
        String pZrnnenkinjimutesuuryoukbn,
        String pZrndnendo,
        String pZrnnaiteikakuteikbn
    ) {
        super(
            pZrnnenkinkbn,
            pZrnnenkinsyu,
            pZrnnenkinkigousedaikbn,
            pZrnnknshry,
            pZrnnkkaisigoyoteiriritukbn,
            pZrnnenkinjimutesuuryoukbn,
            pZrndnendo,
            pZrnnaiteikakuteikbn
        );
    }

}
