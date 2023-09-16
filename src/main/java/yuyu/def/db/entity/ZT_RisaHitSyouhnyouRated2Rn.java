package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_RisaHitSyouhnyouRated2Rn;
import yuyu.def.db.mapping.GenZT_RisaHitSyouhnyouRated2Rn;
import yuyu.def.db.meta.GenQZT_RisaHitSyouhnyouRated2Rn;
import yuyu.def.db.meta.QZT_RisaHitSyouhnyouRated2Rn;

/**
 * 利差配当商品用Ｄレートテーブル２（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_RisaHitSyouhnyouRated2Rn} の JavaDoc を参照してください。
 * @see     GenZT_RisaHitSyouhnyouRated2Rn
 * @see     PKZT_RisaHitSyouhnyouRated2Rn
 * @see     QZT_RisaHitSyouhnyouRated2Rn
 * @see     GenQZT_RisaHitSyouhnyouRated2Rn
 */
@Entity
public class ZT_RisaHitSyouhnyouRated2Rn extends GenZT_RisaHitSyouhnyouRated2Rn {

    private static final long serialVersionUID = 1L;

    public ZT_RisaHitSyouhnyouRated2Rn() {
    }

    public ZT_RisaHitSyouhnyouRated2Rn(
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
        String pZrndai1hknkkn,
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
            pZrnannaifuyouriyuukbn,
            pZrntuukasyukbn,
            pZrndai1hknkkn,
            pZrndnendo,
            pZrnnaiteikakuteikbn
        );
    }

}
