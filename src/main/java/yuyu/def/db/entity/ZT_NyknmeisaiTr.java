package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_NyknmeisaiTr;
import yuyu.def.db.mapping.GenZT_NyknmeisaiTr;
import yuyu.def.db.meta.GenQZT_NyknmeisaiTr;
import yuyu.def.db.meta.QZT_NyknmeisaiTr;

/**
 * 入出金明細テーブル（取） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_NyknmeisaiTr} の JavaDoc を参照してください。
 * @see     GenZT_NyknmeisaiTr
 * @see     PKZT_NyknmeisaiTr
 * @see     QZT_NyknmeisaiTr
 * @see     GenQZT_NyknmeisaiTr
 */
@Entity
public class ZT_NyknmeisaiTr extends GenZT_NyknmeisaiTr {

    private static final long serialVersionUID = 1L;

    public ZT_NyknmeisaiTr() {
    }

    public ZT_NyknmeisaiTr(
        String pZtrsakuseiymd6keta,
        String pZtrbankcd,
        String pZtrshitencd,
        String pZtryokinkbn,
        String pZtrkouzano,
        String pZtrsyoukaino,
        String pZtrrenno8
    ) {
        super(
            pZtrsakuseiymd6keta,
            pZtrbankcd,
            pZtrshitencd,
            pZtryokinkbn,
            pZtrkouzano,
            pZtrsyoukaino,
            pZtrrenno8
        );
    }

}
