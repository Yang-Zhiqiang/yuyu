package yuyu.app.dsweb.dwhozentetuduki.dwkaiyakuuketuke.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_DsKokyakuJtKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsSoukinyouKouza;
import yuyu.def.db.meta.QMT_DsKokyakuKanri;
import yuyu.def.db.meta.QMT_DsSoukinyouKouza;

/**
 * ＤＳ解約受付DAOクラスです。
 */
public class DwKaiyakuUketukeDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public MT_DsKokyakuKanri getDsKokyakuKanriByDskoknoYuukoutorihikityuu(String pDskokno) {

        QMT_DsKokyakuKanri qMT_DsKokyakuKanri = new QMT_DsKokyakuKanri("qMT_DsKokyakuKanri");

        String strSql = $SELECT + qMT_DsKokyakuKanri +
            $FROM(qMT_DsKokyakuKanri) +
            $WHERE + qMT_DsKokyakuKanri.dskokno.eq(pDskokno) +
            $AND + qMT_DsKokyakuKanri.dskokyakujtkbn.eq(C_DsKokyakuJtKbn.YUUKOU);

        return exDBEntityManager.createJPQL(strSql).bind(qMT_DsKokyakuKanri).getSingleResult();
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
}
