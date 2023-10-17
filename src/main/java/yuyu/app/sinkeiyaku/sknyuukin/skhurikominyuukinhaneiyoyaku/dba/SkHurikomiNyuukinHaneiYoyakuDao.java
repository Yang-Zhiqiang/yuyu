package yuyu.app.sinkeiyaku.sknyuukin.skhurikominyuukinhaneiyoyaku.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.meta.QHT_GrossNykn;

/**
 * 新契約 入金 振込入金反映予約の機能DAOクラスです。
 */
public class SkHurikomiNyuukinHaneiYoyakuDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public Integer getGrossNyknMaxRennoByRyosyuymdOyadrtencd(BizDate pRyosyuymd, String pOyadrtencd) {

        QHT_GrossNykn qHT_GrossNykn = new QHT_GrossNykn("qHT_GrossNykn");

        String strSql = $SELECT + $MAX(qHT_GrossNykn.renno) +
            $FROM(qHT_GrossNykn) +
            $WHERE + qHT_GrossNykn.ryosyuymd.eq(pRyosyuymd) +
            $AND + qHT_GrossNykn.oyadrtencd.eq(pOyadrtencd);

        return exDBEntityManager.createJPQL(strSql).bind(qHT_GrossNykn).getSingleResult();
    }
}
