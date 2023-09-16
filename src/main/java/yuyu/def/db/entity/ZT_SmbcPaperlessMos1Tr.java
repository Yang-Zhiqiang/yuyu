package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.sinkeiyaku.skcommon.SmbcPaperlessMosTrParam;
import yuyu.def.db.id.PKZT_SmbcPaperlessMos1Tr;
import yuyu.def.db.mapping.GenZT_SmbcPaperlessMos1Tr;
import yuyu.def.db.meta.GenQZT_SmbcPaperlessMos1Tr;
import yuyu.def.db.meta.QZT_SmbcPaperlessMos1Tr;

/**
 * ＳＭＢＣペーパーレス申込情報１テーブル（取） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SmbcPaperlessMos1Tr} の JavaDoc を参照してください。
 * @see     GenZT_SmbcPaperlessMos1Tr
 * @see     PKZT_SmbcPaperlessMos1Tr
 * @see     QZT_SmbcPaperlessMos1Tr
 * @see     GenQZT_SmbcPaperlessMos1Tr
 */
@Entity
public class ZT_SmbcPaperlessMos1Tr extends GenZT_SmbcPaperlessMos1Tr implements SmbcPaperlessMosTrParam {

    private static final long serialVersionUID = 1L;

    public ZT_SmbcPaperlessMos1Tr() {
    }

    public ZT_SmbcPaperlessMos1Tr(
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
