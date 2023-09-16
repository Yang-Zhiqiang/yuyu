package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.sinkeiyaku.skcommon.SmbcPaperlessMosTrParam;
import yuyu.def.db.id.PKZT_HanyouPaperlessMos1Tr;
import yuyu.def.db.mapping.GenZT_HanyouPaperlessMos1Tr;
import yuyu.def.db.meta.GenQZT_HanyouPaperlessMos1Tr;
import yuyu.def.db.meta.QZT_HanyouPaperlessMos1Tr;

/**
 * 汎用ペーパーレス申込情報１テーブル（取） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_HanyouPaperlessMos1Tr} の JavaDoc を参照してください。
 * @see     GenZT_HanyouPaperlessMos1Tr
 * @see     PKZT_HanyouPaperlessMos1Tr
 * @see     QZT_HanyouPaperlessMos1Tr
 * @see     GenQZT_HanyouPaperlessMos1Tr
 */
@Entity
public class ZT_HanyouPaperlessMos1Tr extends GenZT_HanyouPaperlessMos1Tr implements SmbcPaperlessMosTrParam {

    private static final long serialVersionUID = 1L;

    public ZT_HanyouPaperlessMos1Tr() {
    }

    public ZT_HanyouPaperlessMos1Tr(
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
