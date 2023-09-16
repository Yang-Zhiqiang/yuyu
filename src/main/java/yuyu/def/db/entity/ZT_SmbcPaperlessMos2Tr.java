package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.sinkeiyaku.skcommon.SmbcPaperlessMosTrParam;
import yuyu.def.db.id.PKZT_SmbcPaperlessMos2Tr;
import yuyu.def.db.mapping.GenZT_SmbcPaperlessMos2Tr;
import yuyu.def.db.meta.GenQZT_SmbcPaperlessMos2Tr;
import yuyu.def.db.meta.QZT_SmbcPaperlessMos2Tr;

/**
 * ＳＭＢＣペーパーレス申込情報２テーブル（取） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SmbcPaperlessMos2Tr} の JavaDoc を参照してください。
 * @see     GenZT_SmbcPaperlessMos2Tr
 * @see     PKZT_SmbcPaperlessMos2Tr
 * @see     QZT_SmbcPaperlessMos2Tr
 * @see     GenQZT_SmbcPaperlessMos2Tr
 */
@Entity
public class ZT_SmbcPaperlessMos2Tr extends GenZT_SmbcPaperlessMos2Tr implements SmbcPaperlessMosTrParam {

    private static final long serialVersionUID = 1L;

    public ZT_SmbcPaperlessMos2Tr() {
    }

    public ZT_SmbcPaperlessMos2Tr(
        String pZtrseihowebidkbn,
        String pZtrseihowebkojincd,
        String pZtrseihowebitijihozonhyouji,
        Integer pZtrseihowebseknoc
        ) {
        super(
            pZtrseihowebidkbn,
            pZtrseihowebkojincd,
            pZtrseihowebitijihozonhyouji,
            pZtrseihowebseknoc
            );
    }

}
