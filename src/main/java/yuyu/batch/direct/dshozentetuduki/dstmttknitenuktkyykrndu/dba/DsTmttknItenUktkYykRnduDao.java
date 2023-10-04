package yuyu.batch.direct.dshozentetuduki.dstmttknitenuktkyykrndu.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.db.entity.MT_KhHenkouUktkYyk;
import yuyu.def.db.meta.QMT_KhHenkouUktkYyk;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBUpdatableResults;

/**
 * ダイレクトサービス 保全手続 ＤＳ積立金移転受付予約連動機能DAOクラス
 */
public class DsTmttknItenUktkYykRnduDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBUpdatableResults<MT_KhHenkouUktkYyk> getKhHenkouUktkYykInfosByKakutyoujobcd(String pIbKakutyoujobcd) {

        QMT_KhHenkouUktkYyk qMT_KhHenkouUktkYyk = new QMT_KhHenkouUktkYyk("QMT_KhHenkouUktkYyk");

        String strSql = $SELECT + qMT_KhHenkouUktkYyk +
            $FROM(qMT_KhHenkouUktkYyk)                +
            $WHERE + qMT_KhHenkouUktkYyk.uktksyorikbn.eq(C_UktkSyoriKbn.TMTTKNITEN);

        ExDBUpdatableResults<MT_KhHenkouUktkYyk> exDBUpdatableResults = exDBEntityManager
            .createJPQL(strSql).bind(qMT_KhHenkouUktkYyk).getUpdatableResults();

        exDBUpdatableResults.setFilter(new ExDBSkippedResultsFilter(pIbKakutyoujobcd));

        return exDBUpdatableResults;
    }
}
