package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_OnlineGknyknmeisaiTr;
import yuyu.def.db.mapping.GenZT_OnlineGknyknmeisaiTr;
import yuyu.def.db.meta.GenQZT_OnlineGknyknmeisaiTr;
import yuyu.def.db.meta.QZT_OnlineGknyknmeisaiTr;

/**
 * オンライン外貨入出金明細テーブル（取） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_OnlineGknyknmeisaiTr} の JavaDoc を参照してください。
 * @see     GenZT_OnlineGknyknmeisaiTr
 * @see     PKZT_OnlineGknyknmeisaiTr
 * @see     QZT_OnlineGknyknmeisaiTr
 * @see     GenQZT_OnlineGknyknmeisaiTr
 */
@Entity
public class ZT_OnlineGknyknmeisaiTr extends GenZT_OnlineGknyknmeisaiTr {

    private static final long serialVersionUID = 1L;

    public ZT_OnlineGknyknmeisaiTr() {
    }

    public ZT_OnlineGknyknmeisaiTr(
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
