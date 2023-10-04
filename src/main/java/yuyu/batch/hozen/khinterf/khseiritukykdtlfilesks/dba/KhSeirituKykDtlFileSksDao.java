package yuyu.batch.hozen.khinterf.khseiritukykdtlfilesks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.meta.QIT_KykDairiten;
import yuyu.def.db.meta.QIT_KykSyouhn;

/**
 * 成立契約明細ファイル作成DAOクラスです。
 */
public class KhSeirituKykDtlFileSksDao {

    @Inject
    ExDBEntityManager em;

    public ExDBResults<SeirituKykDtlBean> getSeirituKykDtl(BizDate pKykymdFrom, BizDate pKykymdTo) {

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QIT_KykDairiten qIT_KykDairiten = new QIT_KykDairiten("qIT_KykDairiten");

        String strSql = $SELECT + $NEW(SeirituKykDtlBean.class,
            qIT_KykSyouhn.syono,
            qIT_KykSyouhn.kykymd,
            qIT_KykSyouhn.hknkkn,
            qIT_KykSyouhn.kykjyoutai,
            qIT_KykDairiten.drtencd,
            qIT_KykDairiten.drtenrenno) +
            $FROM(qIT_KykSyouhn,
                qIT_KykDairiten) +
                $WHERE + qIT_KykSyouhn.syono.eq(qIT_KykDairiten.syono) +
                $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $AND + qIT_KykSyouhn.kykymd.ge(pKykymdFrom) +
                $AND + qIT_KykSyouhn.kykymd.le(pKykymdTo) +
                $ORDER_BY(qIT_KykSyouhn.syono.asc(),
                    qIT_KykDairiten.drtenrenno.asc());

        return em.createJPQL(strSql, SeirituKykDtlBean.class).bind(qIT_KykSyouhn, qIT_KykDairiten).getResults();
    }
}
