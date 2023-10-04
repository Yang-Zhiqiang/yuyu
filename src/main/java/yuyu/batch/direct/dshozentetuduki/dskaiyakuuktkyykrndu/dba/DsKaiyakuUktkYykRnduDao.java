package yuyu.batch.direct.dshozentetuduki.dskaiyakuuktkyykrndu.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.db.entity.MT_KhHenkouUktkYyk;
import yuyu.def.db.meta.QMT_KhHenkouUktkKaiyakuYyk;
import yuyu.def.db.meta.QMT_KhHenkouUktkYyk;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBUpdatableResults;

/**
 * ダイレクトサービス 保全手続 ＤＳ解約受付予約連動機能DAOクラス
 */
public class DsKaiyakuUktkYykRnduDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBUpdatableResults<MT_KhHenkouUktkYyk> getKhHenkouUktkYykInfosByKakutyoujobcd(String pIbKakutyoujobcd) {

        QMT_KhHenkouUktkYyk qMT_KhHenkouUktkYyk = new QMT_KhHenkouUktkYyk("qMT_KhHenkouUktkYyk");

        QMT_KhHenkouUktkKaiyakuYyk qMT_KhHenkouUktkKaiyakuYyk = new QMT_KhHenkouUktkKaiyakuYyk("qMT_KhHenkouUktkKaiyakuYyk");

        String strSql = $SELECT + qMT_KhHenkouUktkYyk +
            $FROM(qMT_KhHenkouUktkYyk,
                qMT_KhHenkouUktkKaiyakuYyk)         +

                $WHERE + qMT_KhHenkouUktkYyk.uktksyorikbn.eq(C_UktkSyoriKbn.KAIYAKU) +
                $AND   + qMT_KhHenkouUktkYyk.syono.eq(qMT_KhHenkouUktkKaiyakuYyk.syono) +
                $AND   + qMT_KhHenkouUktkYyk.hozenhenkouuktkrenno.eq(qMT_KhHenkouUktkKaiyakuYyk.hozenhenkouuktkrenno);

        ExDBUpdatableResults<MT_KhHenkouUktkYyk> exDBResults = exDBEntityManager
            .createJPQL(strSql).bind(qMT_KhHenkouUktkYyk, qMT_KhHenkouUktkKaiyakuYyk).getUpdatableResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pIbKakutyoujobcd));

        return exDBResults;
    }
}
