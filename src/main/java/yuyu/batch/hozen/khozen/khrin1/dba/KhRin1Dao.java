package yuyu.batch.hozen.khozen.khrin1.dba;

//import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

//import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
//import jp.co.slcs.swak.db.ExDBResults;
//import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
//import yuyu.def.classification.C_SyutkKbn;
//import yuyu.def.classification.C_YuukousyoumetuKbn;
//import yuyu.def.db.entity.IT_KykKihon;
//import yuyu.def.db.meta.QIT_KykDairiten;
//import yuyu.def.db.meta.QIT_KykKihon;
//import yuyu.def.db.meta.QIT_KykSyouhn;

/**
 * 一時払保有契約情報ファイル作成DAOクラスです。
 */
public class KhRin1Dao {

    @Inject
    ExDBEntityManager em;

    //    public ExDBResults<IT_KykKihon> getItijibrHyukykInfo(String pKakutyoujobcd, BizDate pTyusyutuYmd) {
    //
    //        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
    //        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
    //        QIT_KykDairiten qIT_KykDairiten = new QIT_KykDairiten("qIT_KykDairiten");
    //
    //        String strSql = $SELECT + qIT_KykKihon +
    //            $FROM(qIT_KykKihon,
    //                qIT_KykSyouhn,
    //                qIT_KykDairiten) +
    //                $WHERE + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
    //                $AND + qIT_KykSyouhn.syono.eq(qIT_KykDairiten.syono) +
    //                $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
    //                $AND + qIT_KykSyouhn.kykymd.le(pTyusyutuYmd) +
    //                $AND +
    //                $(qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
    //                    $OR +
    //                    $(qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.SYOUMETU) +
    //                        $AND + qIT_KykSyouhn.syoumetuymd.gt(pTyusyutuYmd)
    //                        )
    //                    ) +
    //                    $AND + qIT_KykDairiten.oyadrtencd.eq("5100001") +
    //                    $AND + qIT_KykDairiten.drtenrenno.eq(1) +
    //                    $ORDER_BY(qIT_KykKihon.syono.asc());
    //
    //        ExDBResults<IT_KykKihon> exDBResults = em.createJPQL(strSql).bind(qIT_KykKihon, qIT_KykSyouhn, qIT_KykDairiten).getResults();
    //
    //        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));
    //
    //        return exDBResults;
    //    }
}
