package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_Ratep2Rn;
import yuyu.def.db.mapping.GenZT_Ratep2Rn;
import yuyu.def.db.meta.GenQZT_Ratep2Rn;
import yuyu.def.db.meta.QZT_Ratep2Rn;

/**
 * Ｐレートテーブル２（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_Ratep2Rn} の JavaDoc を参照してください。
 * @see     GenZT_Ratep2Rn
 * @see     PKZT_Ratep2Rn
 * @see     QZT_Ratep2Rn
 * @see     GenQZT_Ratep2Rn
 */
@Entity
public class ZT_Ratep2Rn extends GenZT_Ratep2Rn {

    private static final long serialVersionUID = 1L;

    public ZT_Ratep2Rn() {
    }

    public ZT_Ratep2Rn(
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
        String pZrnryouritukbn
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
            pZrnryouritukbn
        );
    }

}
