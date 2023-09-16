package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKZT_GknyknmeisaiRn;
import yuyu.def.db.mapping.GenZT_GknyknmeisaiRn;
import yuyu.def.db.meta.GenQZT_GknyknmeisaiRn;
import yuyu.def.db.meta.QZT_GknyknmeisaiRn;

/**
 * 外貨入出金明細テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_GknyknmeisaiRn} の JavaDoc を参照してください。
 * @see     GenZT_GknyknmeisaiRn
 * @see     PKZT_GknyknmeisaiRn
 * @see     QZT_GknyknmeisaiRn
 * @see     GenQZT_GknyknmeisaiRn
 */
@Entity
public class ZT_GknyknmeisaiRn extends GenZT_GknyknmeisaiRn {

    private static final long serialVersionUID = 1L;

    public ZT_GknyknmeisaiRn() {
    }

    public ZT_GknyknmeisaiRn(
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
