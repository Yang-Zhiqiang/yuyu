package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKZT_RatedRn;
import yuyu.def.db.mapping.GenZT_RatedRn;
import yuyu.def.db.meta.GenQZT_RatedRn;
import yuyu.def.db.meta.QZT_RatedRn;

/**
 * Dレートテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_RatedRn} の JavaDoc を参照してください。
 * @see     GenZT_RatedRn
 * @see     PKZT_RatedRn
 * @see     QZT_RatedRn
 * @see     GenQZT_RatedRn
 */
@Entity
public class ZT_RatedRn extends GenZT_RatedRn {

    private static final long serialVersionUID = 1L;

    public ZT_RatedRn() {
    }

    public ZT_RatedRn(
        String pZrnhknsyukigou,
        String pZrnhknsyuruikigousedaikbn,
        String pZrnyoteiriritu,
        String pZrnpmenkbn,
        String pZrnhrkkaisuukbn,
        String pZrnhhknsei,
        String pZrnkeiyakujihhknnen,
        String pZrnsaimnkkykhyj,
        String pZrnhknkkn,
        String pZrnphrkkikn,
        String pZrndnendo,
        String pZrnnaiteikakuteikbn
    ) {
        super(
            pZrnhknsyukigou,
            pZrnhknsyuruikigousedaikbn,
            pZrnyoteiriritu,
            pZrnpmenkbn,
            pZrnhrkkaisuukbn,
            pZrnhhknsei,
            pZrnkeiyakujihhknnen,
            pZrnsaimnkkykhyj,
            pZrnhknkkn,
            pZrnphrkkikn,
            pZrndnendo,
            pZrnnaiteikakuteikbn
        );
    }

}
