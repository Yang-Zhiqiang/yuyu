package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_TiginSinkinBosRn;
import yuyu.def.db.mapping.GenZT_TiginSinkinBosRn;
import yuyu.def.db.meta.GenQZT_TiginSinkinBosRn;
import yuyu.def.db.meta.QZT_TiginSinkinBosRn;

/**
 * 地銀信金募集テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_TiginSinkinBosRn} の JavaDoc を参照してください。
 * @see     GenZT_TiginSinkinBosRn
 * @see     PKZT_TiginSinkinBosRn
 * @see     QZT_TiginSinkinBosRn
 * @see     GenQZT_TiginSinkinBosRn
 */
@Entity
public class ZT_TiginSinkinBosRn extends GenZT_TiginSinkinBosRn {

    private static final long serialVersionUID = 1L;

    public ZT_TiginSinkinBosRn() {
    }

    public ZT_TiginSinkinBosRn(
        String pZrnseihowebidkbn,
        String pZrnseihowebkojincd,
        String pZrnseihowebitijihozonhyouji,
        Integer pZrnseihowebsekno
    ) {
        super(
            pZrnseihowebidkbn,
            pZrnseihowebkojincd,
            pZrnseihowebitijihozonhyouji,
            pZrnseihowebsekno
        );
    }

}
