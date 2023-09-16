package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_RisaHitSyouhnyouRatedRn;
import yuyu.def.db.mapping.GenZT_RisaHitSyouhnyouRatedRn;
import yuyu.def.db.meta.GenQZT_RisaHitSyouhnyouRatedRn;
import yuyu.def.db.meta.QZT_RisaHitSyouhnyouRatedRn;

/**
 * 利差配当商品用Ｄレートテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_RisaHitSyouhnyouRatedRn} の JavaDoc を参照してください。
 * @see     GenZT_RisaHitSyouhnyouRatedRn
 * @see     PKZT_RisaHitSyouhnyouRatedRn
 * @see     QZT_RisaHitSyouhnyouRatedRn
 * @see     GenQZT_RisaHitSyouhnyouRatedRn
 */
@Entity
public class ZT_RisaHitSyouhnyouRatedRn extends GenZT_RisaHitSyouhnyouRatedRn {

    private static final long serialVersionUID = 1L;

    public ZT_RisaHitSyouhnyouRatedRn() {
    }

    public ZT_RisaHitSyouhnyouRatedRn(
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
