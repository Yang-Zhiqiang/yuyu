package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_NyknmeisaiRn;
import yuyu.def.db.mapping.GenZT_NyknmeisaiRn;
import yuyu.def.db.meta.GenQZT_NyknmeisaiRn;
import yuyu.def.db.meta.QZT_NyknmeisaiRn;

/**
 * 入出金明細テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_NyknmeisaiRn} の JavaDoc を参照してください。
 * @see     GenZT_NyknmeisaiRn
 * @see     PKZT_NyknmeisaiRn
 * @see     QZT_NyknmeisaiRn
 * @see     GenQZT_NyknmeisaiRn
 */
@Entity
public class ZT_NyknmeisaiRn extends GenZT_NyknmeisaiRn {

    private static final long serialVersionUID = 1L;

    public ZT_NyknmeisaiRn() {
    }

    public ZT_NyknmeisaiRn(
        String pZrnsakuseiymd6keta,
        String pZrnbankcd,
        String pZrnshitencd,
        String pZrnyokinkbn,
        String pZrnkouzano,
        String pZrnsyoukaino,
        String pZrnrenno8
    ) {
        super(
            pZrnsakuseiymd6keta,
            pZrnbankcd,
            pZrnshitencd,
            pZrnyokinkbn,
            pZrnkouzano,
            pZrnsyoukaino,
            pZrnrenno8
        );
    }

}
