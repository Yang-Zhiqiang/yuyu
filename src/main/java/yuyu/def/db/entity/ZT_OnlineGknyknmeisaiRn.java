package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_OnlineGknyknmeisaiRn;
import yuyu.def.db.mapping.GenZT_OnlineGknyknmeisaiRn;
import yuyu.def.db.meta.GenQZT_OnlineGknyknmeisaiRn;
import yuyu.def.db.meta.QZT_OnlineGknyknmeisaiRn;

/**
 * オンライン外貨入出金明細テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_OnlineGknyknmeisaiRn} の JavaDoc を参照してください。
 * @see     GenZT_OnlineGknyknmeisaiRn
 * @see     PKZT_OnlineGknyknmeisaiRn
 * @see     QZT_OnlineGknyknmeisaiRn
 * @see     GenQZT_OnlineGknyknmeisaiRn
 */
@Entity
public class ZT_OnlineGknyknmeisaiRn extends GenZT_OnlineGknyknmeisaiRn {

    private static final long serialVersionUID = 1L;

    public ZT_OnlineGknyknmeisaiRn() {
    }

    public ZT_OnlineGknyknmeisaiRn(
        String pZrnsakuseiymd,
        String pZrnrenrakuymd,
        String pZrnrenrakukaisuu,
        String pZrnbankcd,
        String pZrnshitencd,
        String pZrnyokinkbn,
        String pZrnkouzano,
        String pZrnzndktuukasyu,
        String pZrnsyorino1
    ) {
        super(
            pZrnsakuseiymd,
            pZrnrenrakuymd,
            pZrnrenrakukaisuu,
            pZrnbankcd,
            pZrnshitencd,
            pZrnyokinkbn,
            pZrnkouzano,
            pZrnzndktuukasyu,
            pZrnsyorino1
        );
    }

}
