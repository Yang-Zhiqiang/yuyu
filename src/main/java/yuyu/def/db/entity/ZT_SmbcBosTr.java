package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.sinkeiyaku.skcommon.BosTrParam;
import yuyu.def.db.id.PKZT_SmbcBosTr;
import yuyu.def.db.mapping.GenZT_SmbcBosTr;
import yuyu.def.db.meta.GenQZT_SmbcBosTr;
import yuyu.def.db.meta.QZT_SmbcBosTr;

/**
 * ＳＭＢＣ募集テーブル（取） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SmbcBosTr} の JavaDoc を参照してください。
 * @see     GenZT_SmbcBosTr
 * @see     PKZT_SmbcBosTr
 * @see     QZT_SmbcBosTr
 * @see     GenQZT_SmbcBosTr
 */
@Entity
public class ZT_SmbcBosTr extends GenZT_SmbcBosTr implements BosTrParam {

    private static final long serialVersionUID = 1L;

    public ZT_SmbcBosTr() {
    }

    public ZT_SmbcBosTr(
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
