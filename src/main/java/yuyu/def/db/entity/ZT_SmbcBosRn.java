package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SmbcBosRn;
import yuyu.def.db.mapping.GenZT_SmbcBosRn;
import yuyu.def.db.meta.GenQZT_SmbcBosRn;
import yuyu.def.db.meta.QZT_SmbcBosRn;

/**
 * ＳＭＢＣ募集テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SmbcBosRn} の JavaDoc を参照してください。
 * @see     GenZT_SmbcBosRn
 * @see     PKZT_SmbcBosRn
 * @see     QZT_SmbcBosRn
 * @see     GenQZT_SmbcBosRn
 */
@Entity
public class ZT_SmbcBosRn extends GenZT_SmbcBosRn {

    private static final long serialVersionUID = 1L;

    public ZT_SmbcBosRn() {
    }

    public ZT_SmbcBosRn(
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
