package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.sinkeiyaku.skcommon.SmbcPaperlessMosTrParam;
import yuyu.def.db.id.PKZT_HanyouPaperlessMos2Tr;
import yuyu.def.db.mapping.GenZT_HanyouPaperlessMos2Tr;
import yuyu.def.db.meta.GenQZT_HanyouPaperlessMos2Tr;
import yuyu.def.db.meta.QZT_HanyouPaperlessMos2Tr;

/**
 * 汎用ペーパーレス申込情報２テーブル（取） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_HanyouPaperlessMos2Tr} の JavaDoc を参照してください。
 * @see     GenZT_HanyouPaperlessMos2Tr
 * @see     PKZT_HanyouPaperlessMos2Tr
 * @see     QZT_HanyouPaperlessMos2Tr
 * @see     GenQZT_HanyouPaperlessMos2Tr
 */
@Entity
public class ZT_HanyouPaperlessMos2Tr extends GenZT_HanyouPaperlessMos2Tr implements SmbcPaperlessMosTrParam {

    private static final long serialVersionUID = 1L;

    public ZT_HanyouPaperlessMos2Tr() {
    }

    public ZT_HanyouPaperlessMos2Tr(
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
