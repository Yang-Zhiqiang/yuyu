package yuyu.app.hozen.khozen.khseinengappiseiteisei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.meta.QIT_Kariukekin;

/**
 * 契約保全 契約保全 被保険者生年月日・性訂正機能DAOクラス
 */
public class KhSeinengappiseiteiseiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<IT_Kariukekin> getKariukekinsBySyonoKrkriyuukbnNyknaiyoukbnKrkseisanzumiflg(
        String pSyono, C_KrkriyuuKbn pKrkriyuuKbn, C_NyknaiyouKbn pNyknaiyouKbn, C_Krkseisanzumiflg pKrkseisanzumiflg) {

        QIT_Kariukekin qIT_Kariukekin = new QIT_Kariukekin("qIT_Kariukekin");

        String strSql = $SELECT + qIT_Kariukekin +
            $FROM(qIT_Kariukekin) +
            $WHERE + qIT_Kariukekin.syono.eq(pSyono) +
            $AND + qIT_Kariukekin.krkriyuukbn.eq(pKrkriyuuKbn) +
            $AND + qIT_Kariukekin.nyknaiyoukbn.eq(pNyknaiyouKbn) +
            $AND + qIT_Kariukekin.krkseisanzumiflg.eq(pKrkseisanzumiflg) +
            $ORDER_BY (qIT_Kariukekin.ryosyuymd.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_Kariukekin).getResultList();
    }

    public BizCurrency getKariukekinSumBySyonoKrkriyuukbnNyknaiyoukbnKrkseisanzumiflg(
        String pSyono, C_KrkriyuuKbn pKrkriyuuKbn, C_NyknaiyouKbn pNyknaiyouKbn, C_Krkseisanzumiflg pKrkseisanzumiflg) {

        QIT_Kariukekin qIT_Kariukekin = new QIT_Kariukekin("qIT_Kariukekin");

        String strSql = $SELECT + $NEW(BizCurrencySum.class,
            qIT_Kariukekin.krkgk.getTypeFieldName(),
            $SUM + $(qIT_Kariukekin.krkgk.getValueFieldName())) +
            $FROM(qIT_Kariukekin) +
            $WHERE + qIT_Kariukekin.syono.eq(pSyono) +
            $AND + qIT_Kariukekin.krkriyuukbn.eq(pKrkriyuuKbn) +
            $AND + qIT_Kariukekin.nyknaiyoukbn.eq(pNyknaiyouKbn) +
            $AND + qIT_Kariukekin.krkseisanzumiflg.eq(pKrkseisanzumiflg) +
            $GROUP_BY + qIT_Kariukekin.krkgk.getTypeFieldName();

        BizCurrencySum bs = exDBEntityManager.createJPQL(
            strSql, BizCurrencySum.class).bind(qIT_Kariukekin).getSingleResult();

        if (bs == null) {
            return BizCurrency.valueOf(0);
        }

        return bs.toBizCurrency();
    }

    public Integer getKariukekinMaxKrknoBySyono(String pSyono) {

        QIT_Kariukekin qIT_Kariukekin = new QIT_Kariukekin("qIT_Kariukekin");

        String strSql = $SELECT + $MAX(qIT_Kariukekin.krkno) +
            $FROM(qIT_Kariukekin) +
            $WHERE + qIT_Kariukekin.syono.eq(pSyono);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_Kariukekin).getSingleResult();
    }

}
