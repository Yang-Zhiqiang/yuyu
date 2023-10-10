package yuyu.app.dsweb.dwhozentetuduki.dwdenwakaiyakuuketuke.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_DsSyoriNaiyouKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_MukouHyj;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsSoukinyouKouza;
import yuyu.def.db.meta.QMT_DsKokyakuKanri;
import yuyu.def.db.meta.QMT_DsKokyakuKeiyaku;
import yuyu.def.db.meta.QMT_DsSoukinyouKouza;
import yuyu.def.db.meta.QMT_SousaRirekiSyousai;

/**
 * 電話解約受付DAOクラスです。
 */
public class DwDenwaKaiyakuUketukeDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public Long getSousaRirekiSyousaiInhoKensuuByTtdksikibetuidSyorinaiyoukbn(String pTtdksikibetuId,
        C_DsSyoriNaiyouKbn pSyorinaiyouKbn) {

        QMT_SousaRirekiSyousai qMT_SousaRirekiSyousai = new QMT_SousaRirekiSyousai("qMT_SousaRirekiSyousai");

        String strSql = $SELECT + $COUNT(qMT_SousaRirekiSyousai.ttdksikibetuid) +
            $FROM(qMT_SousaRirekiSyousai) +
            $WHERE + qMT_SousaRirekiSyousai.ttdksikibetuid.eq(pTtdksikibetuId) +
            $AND + qMT_SousaRirekiSyousai.syorinaiyoukbn.eq(pSyorinaiyouKbn);

        Long kensuu = exDBEntityManager.createJPQL(strSql).bind(qMT_SousaRirekiSyousai).getSingleResult();

        return kensuu;
    }

    public MT_DsSoukinyouKouza getDsSoukinyouKouzaByDskoknoSyonoKouzaSyuruiKbn(String pDskokno, String pSyono,
        C_KouzasyuruiKbn pKzsyuruikbn) {

        QMT_DsSoukinyouKouza qMT_DsSoukinyouKouza = new QMT_DsSoukinyouKouza("qMT_DsSoukinyouKouza");

        String strSql = $SELECT + qMT_DsSoukinyouKouza +
            $FROM(qMT_DsSoukinyouKouza) +
            $WHERE + qMT_DsSoukinyouKouza.dskokno.eq(pDskokno) +
            $AND + qMT_DsSoukinyouKouza.syono.eq(pSyono) +
            $AND + qMT_DsSoukinyouKouza.kzsyuruikbn.eq(pKzsyuruikbn);

        return exDBEntityManager.createJPQL(strSql).bind(qMT_DsSoukinyouKouza).getSingleResult();
    }

    public Integer getSousaRirekiRenbanMaxByTtdksikibetuid(String pTtdksikibetuId) {

        QMT_SousaRirekiSyousai qMT_SousaRirekiSyousai = new QMT_SousaRirekiSyousai("qMT_SousaRirekiSyousai");

        String strSql = $SELECT + $MAX(qMT_SousaRirekiSyousai.sousarirekirenno) +
            $FROM(qMT_SousaRirekiSyousai) +
            $WHERE + qMT_SousaRirekiSyousai.ttdksikibetuid.eq(pTtdksikibetuId);

        Integer maxRenNo = exDBEntityManager.createJPQL(strSql).bind(qMT_SousaRirekiSyousai).getSingleResult();

        return maxRenNo;
    }

    public MT_DsKokyakuKanri getYuukouKeiyakuDskokyakuInfoBySyono(String pSyono) {

        QMT_DsKokyakuKanri qMT_DsKokyakuKanri = new QMT_DsKokyakuKanri("qMT_DsKokyakuKanri");
        QMT_DsKokyakuKeiyaku qMT_DsKokyakuKeiyaku = new QMT_DsKokyakuKeiyaku("qMT_DsKokyakuKeiyaku");

        String strSql = $SELECT + qMT_DsKokyakuKanri +
            $FROM(qMT_DsKokyakuKanri,
                qMT_DsKokyakuKeiyaku) +
                $WHERE + qMT_DsKokyakuKanri.dskokno.eq(qMT_DsKokyakuKeiyaku.dskokno) +
                $AND + qMT_DsKokyakuKeiyaku.syono.eq(pSyono) +
                $AND + qMT_DsKokyakuKeiyaku.dskykmukouhyj.eq(C_MukouHyj.BLANK);

        return exDBEntityManager.createJPQL(strSql).bind(qMT_DsKokyakuKanri, qMT_DsKokyakuKeiyaku).getSingleResult();
    }
}
