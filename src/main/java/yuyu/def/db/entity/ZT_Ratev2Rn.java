package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_Ratev2Rn;
import yuyu.def.db.mapping.GenZT_Ratev2Rn;
import yuyu.def.db.meta.GenQZT_Ratev2Rn;
import yuyu.def.db.meta.QZT_Ratev2Rn;

/**
 * Ｖレートテーブル２（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_Ratev2Rn} の JavaDoc を参照してください。
 * @see     GenZT_Ratev2Rn
 * @see     PKZT_Ratev2Rn
 * @see     QZT_Ratev2Rn
 * @see     GenQZT_Ratev2Rn
 */
@Entity
public class ZT_Ratev2Rn extends GenZT_Ratev2Rn {

    private static final long serialVersionUID = 1L;

    public ZT_Ratev2Rn() {
    }

    public ZT_Ratev2Rn(
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
