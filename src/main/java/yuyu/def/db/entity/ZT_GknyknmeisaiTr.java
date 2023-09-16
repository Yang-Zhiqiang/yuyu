package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKZT_GknyknmeisaiTr;
import yuyu.def.db.mapping.GenZT_GknyknmeisaiTr;
import yuyu.def.db.meta.GenQZT_GknyknmeisaiTr;
import yuyu.def.db.meta.QZT_GknyknmeisaiTr;

/**
 * 外貨入出金明細テーブル（取） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_GknyknmeisaiTr} の JavaDoc を参照してください。
 * @see     GenZT_GknyknmeisaiTr
 * @see     PKZT_GknyknmeisaiTr
 * @see     QZT_GknyknmeisaiTr
 * @see     GenQZT_GknyknmeisaiTr
 */
@Entity
public class ZT_GknyknmeisaiTr extends GenZT_GknyknmeisaiTr {

    private static final long serialVersionUID = 1L;

    public ZT_GknyknmeisaiTr() {
    }

    public ZT_GknyknmeisaiTr(
        String pZtrsakuseiymd,
        String pZtrrenrakuymd,
        String pZtrrenrakukaisuu,
        String pZtrbankcd,
        String pZtrshitencd,
        String pZtryokinkbn,
        String pZtrkouzano,
        String pZtrzndktuukasyu,
        String pZtrsyorino1
    ) {
        super(
            pZtrsakuseiymd,
            pZtrrenrakuymd,
            pZtrrenrakukaisuu,
            pZtrbankcd,
            pZtrshitencd,
            pZtryokinkbn,
            pZtrkouzano,
            pZtrzndktuukasyu,
            pZtrsyorino1
        );
    }

}
