package yuyu.common.direct.renkei.dba4dsgetsyanaiwebkeiyakuinfo;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_MukouHyj;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsSoukinyouKouza;
import yuyu.def.db.meta.QMT_DsKokyakuKanri;
import yuyu.def.db.meta.QMT_DsKokyakuKeiyaku;
import yuyu.def.db.meta.QMT_DsSoukinyouKouza;

/**
 * ダイレクトサービス ダイレクトサービス共通 社内Web用DS契約内容情報取得DAOクラス<br />
 */
public class DsGetSyanaiWebKeiyakuInfoDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public MT_DsKokyakuKanri getYuukouKeiyakuDskokyakuInfoBySyono (String pSyono) {

        QMT_DsKokyakuKanri qMT_DsKokyakuKanri = new QMT_DsKokyakuKanri("qMT_DsKokyakuKanri");

        QMT_DsKokyakuKeiyaku qMT_DsKokyakuKeiyaku = new QMT_DsKokyakuKeiyaku("qMT_DsKokyakuKeiyaku");

        String strSql = $SELECT + qMT_DsKokyakuKanri +
            $FROM (qMT_DsKokyakuKanri, qMT_DsKokyakuKeiyaku) +
            $WHERE + qMT_DsKokyakuKanri.dskokno.eq(qMT_DsKokyakuKeiyaku.dskokno) +
            $AND + qMT_DsKokyakuKeiyaku.syono.eq(pSyono) +
            $AND + qMT_DsKokyakuKeiyaku.dskykmukouhyj.eq(C_MukouHyj.BLANK);

        return exDBEntityManager.createJPQL(strSql).bind(qMT_DsKokyakuKanri, qMT_DsKokyakuKeiyaku).getSingleResult();
    }

    public MT_DsSoukinyouKouza getDsSoukinyouKouzaByDskoknoSyonoKouzaSyuruiKbn(String pDsKokNo, String pSyoNo, C_KouzasyuruiKbn pKouzasyuruiKbn) {

        QMT_DsSoukinyouKouza qMT_DsSoukinyouKouza = new QMT_DsSoukinyouKouza("qMT_DsSoukinyouKouza");

        String strSql = $SELECT + qMT_DsSoukinyouKouza           +
            $FROM (qMT_DsSoukinyouKouza) +
            $WHERE + qMT_DsSoukinyouKouza.dskokno.eq(pDsKokNo) +
            $AND + qMT_DsSoukinyouKouza.syono.eq(pSyoNo) +
            $AND + qMT_DsSoukinyouKouza.kzsyuruikbn.eq(pKouzasyuruiKbn);

        return exDBEntityManager.createJPQL(strSql).bind(qMT_DsSoukinyouKouza).getSingleResult();
    }
}
