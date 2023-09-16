package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKZT_RatepRn;
import yuyu.def.db.mapping.GenZT_RatepRn;
import yuyu.def.db.meta.GenQZT_RatepRn;
import yuyu.def.db.meta.QZT_RatepRn;

/**
 * Ｐレートテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_RatepRn} の JavaDoc を参照してください。
 * @see     GenZT_RatepRn
 * @see     PKZT_RatepRn
 * @see     QZT_RatepRn
 * @see     GenQZT_RatepRn
 */
@Entity
public class ZT_RatepRn extends GenZT_RatepRn {

    private static final long serialVersionUID = 1L;

    public ZT_RatepRn() {
    }

    public ZT_RatepRn(
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
