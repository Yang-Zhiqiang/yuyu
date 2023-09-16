package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.sinkeiyaku.skcommon.BosTrParam;
import yuyu.def.db.id.PKZT_TiginSinkinBosTr;
import yuyu.def.db.mapping.GenZT_TiginSinkinBosTr;
import yuyu.def.db.meta.GenQZT_TiginSinkinBosTr;
import yuyu.def.db.meta.QZT_TiginSinkinBosTr;

/**
 * 地銀信金募集テーブル（取） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_TiginSinkinBosTr} の JavaDoc を参照してください。
 * @see     GenZT_TiginSinkinBosTr
 * @see     PKZT_TiginSinkinBosTr
 * @see     QZT_TiginSinkinBosTr
 * @see     GenQZT_TiginSinkinBosTr
 */
@Entity
public class ZT_TiginSinkinBosTr extends GenZT_TiginSinkinBosTr implements BosTrParam {

    private static final long serialVersionUID = 1L;

    public ZT_TiginSinkinBosTr() {
    }

    public ZT_TiginSinkinBosTr(
        String pZtrseihowebidkbn,
        String pZtrseihowebkojincd,
        String pZtrseihowebitijihozonhyouji,
        Integer pZtrseihowebsekno
        ) {
        super(
            pZtrseihowebidkbn,
            pZtrseihowebkojincd,
            pZtrseihowebitijihozonhyouji,
            pZtrseihowebsekno
            );
    }

}
