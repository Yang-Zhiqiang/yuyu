package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_RatewRn;
import yuyu.def.db.mapping.GenZT_RatewRn;
import yuyu.def.db.meta.GenQZT_RatewRn;
import yuyu.def.db.meta.QZT_RatewRn;

/**
 * Ｗレートテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_RatewRn} の JavaDoc を参照してください。
 * @see     GenZT_RatewRn
 * @see     PKZT_RatewRn
 * @see     QZT_RatewRn
 * @see     GenQZT_RatewRn
 */
@Entity
public class ZT_RatewRn extends GenZT_RatewRn {

    private static final long serialVersionUID = 1L;

    public ZT_RatewRn() {
    }

    public ZT_RatewRn(
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
        String pZrnannaifuyouriyuukbn,
        String pZrntuukasyukbn,
        String pZrndai1hknkkn
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
            pZrnannaifuyouriyuukbn,
            pZrntuukasyukbn,
            pZrndai1hknkkn
        );
    }

}
