package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKZT_RatevRn;
import yuyu.def.db.mapping.GenZT_RatevRn;
import yuyu.def.db.meta.GenQZT_RatevRn;
import yuyu.def.db.meta.QZT_RatevRn;

/**
 * Ｖレートテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_RatevRn} の JavaDoc を参照してください。
 * @see     GenZT_RatevRn
 * @see     PKZT_RatevRn
 * @see     QZT_RatevRn
 * @see     GenQZT_RatevRn
 */
@Entity
public class ZT_RatevRn extends GenZT_RatevRn {

    private static final long serialVersionUID = 1L;

    public ZT_RatevRn() {
    }

    public ZT_RatevRn(
        String pZrnhknsyukigou,
        String pZrnhknsyuruikigousedaikbn,
        String pZrnyoteiriritu,
        String pZrnpmenkbn,
        String pZrnhrkkaisuukbn,
        String pZrnhhknsei,
        String pZrnkeiyakujihhknnen,
        String pZrnsaimnkkykhyj,
        String pZrnhknkkn,
        String pZrnphrkkikn
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
            pZrnphrkkikn
        );
    }

}
