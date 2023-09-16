package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_HnsyScrMeigiRn;
import yuyu.def.db.mapping.GenZT_HnsyScrMeigiRn;
import yuyu.def.db.meta.GenQZT_HnsyScrMeigiRn;
import yuyu.def.db.meta.QZT_HnsyScrMeigiRn;

/**
 * 反社スクリーニング用名義データテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_HnsyScrMeigiRn} の JavaDoc を参照してください。
 * @see     GenZT_HnsyScrMeigiRn
 * @see     PKZT_HnsyScrMeigiRn
 * @see     QZT_HnsyScrMeigiRn
 * @see     GenQZT_HnsyScrMeigiRn
 */
@Entity
public class ZT_HnsyScrMeigiRn extends GenZT_HnsyScrMeigiRn {

    private static final long serialVersionUID = 1L;

    public ZT_HnsyScrMeigiRn() {
    }

    public ZT_HnsyScrMeigiRn(
        String pZrntaisyounmkn,
        String pZrntaisyounmkj,
        String pZrntaisyouseiymd,
        String pZrnnayosetaisyousegkbn,
        String pZrnsyono
    ) {
        super(
            pZrntaisyounmkn,
            pZrntaisyounmkj,
            pZrntaisyouseiymd,
            pZrnnayosetaisyousegkbn,
            pZrnsyono
        );
    }

}
