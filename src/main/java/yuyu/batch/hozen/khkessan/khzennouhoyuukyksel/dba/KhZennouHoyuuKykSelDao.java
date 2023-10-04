package yuyu.batch.hozen.khkessan.khzennouhoyuukyksel.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_ZennouSeisanKbn;
import yuyu.def.db.entity.BM_ZennouRiritu2;
import yuyu.def.db.entity.BM_ZennouTumitateRitu2;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.db.meta.QBM_ZennouRiritu2;
import yuyu.def.db.meta.QBM_ZennouTumitateRitu2;
import yuyu.def.db.meta.QIT_Zennou;

import com.google.common.collect.Iterables;

/**
 * 契約保全 決算 前納保有契約データ抽出機能DAOクラス
 */
public class KhZennouHoyuuKykSelDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<ZennouHyuKykInfoBean> getZennouHyuKykInfoBeans(BizDate pKsnbiymd) {


        QIT_Zennou qIT_Zennou1 = new QIT_Zennou("qIT_Zennou1");

        QIT_Zennou qIT_Zennou2 = new QIT_Zennou("qIT_Zennou2");

        String strSubSql = $SELECT + $MAX(qIT_Zennou2.renno) +
            $FROM(qIT_Zennou2) +
            $WHERE + qIT_Zennou1.syono.eq(qIT_Zennou2.syono);

        String strSql = $SELECT + $NEW(ZennouHyuKykInfoBean.class,
            qIT_Zennou1.kbnkey,
            qIT_Zennou1.syono,
            qIT_Zennou1.zennoukaisiymd,
            qIT_Zennou1.renno,
            qIT_Zennou1.zennounyuukinsyoriymd,
            qIT_Zennou1.zennounyuukindenno,
            qIT_Zennou1.zennounyuukindenymd,
            qIT_Zennou1.ryosyuymd,
            qIT_Zennou1.zennoukikan,
            qIT_Zennou1.zennounyuukinkgk.getTypeFieldName(),
            qIT_Zennou1.zennounyuukinkgk.getValueFieldName(),
            qIT_Zennou1.zennoujihrkp.getTypeFieldName(),
            qIT_Zennou1.zennoujihrkp.getValueFieldName(),
            qIT_Zennou1.zennouseisankbn,
            qIT_Zennou1.zennouseisansyoriymd,
            qIT_Zennou1.zennouseisankgk.getTypeFieldName(),
            qIT_Zennou1.zennouseisankgk.getValueFieldName(),
            qIT_Zennou1.zennouseisankijyunymd,
            qIT_Zennou1.zennouseisandenymd,
            qIT_Zennou1.annaisaikaiym,
            qIT_Zennou1.kjsmyouzennoukaisiymd,
            qIT_Zennou1.kjsmyouzennoukikanm,
            qIT_Zennou1.kjsmyouzennounyuukinkgk.getTypeFieldName(),
            qIT_Zennou1.kjsmyouzennounyuukinkgk.getValueFieldName(),
            qIT_Zennou1.gyoumuKousinKinou) +
            $FROM(qIT_Zennou1) +
            $WHERE + $(qIT_Zennou1.zennouseisankbn.eq(C_ZennouSeisanKbn.MISEISAN) +
                $OR + $(qIT_Zennou1.zennouseisankbn.eq(C_ZennouSeisanKbn.SEISANZUMI) +
                    $AND  + $(
                        $(qIT_Zennou1.zennouseisandenymd.isNotNull() +
                            $AND + qIT_Zennou1.zennouseisandenymd.gt(pKsnbiymd)
                            )  +
                            $OR  + $(qIT_Zennou1.zennouseisandenymd.isNull() +
                                $AND + qIT_Zennou1.zennouseisansyoriymd.gt(pKsnbiymd)
                                )
                        )
                    )
                ) +
                $AND + qIT_Zennou1.renno + $EQ  + "(" + strSubSql + ")";

        ExDBResults<ZennouHyuKykInfoBean> exDBResults = exDBEntityManager.createJPQL(strSql, ZennouHyuKykInfoBean.class)
            .bind(qIT_Zennou1, qIT_Zennou2).getResults();

        return exDBResults;
    }

    public BM_ZennouRiritu2 getZennouRiritu2(C_Tuukasyu pTuukasyu, BizDate pRyosyuTykzenoutouYmd) {

        QBM_ZennouRiritu2 qBM_ZennouRiritu2 = new QBM_ZennouRiritu2("qBM_ZennouRiritu2");

        String strSql = $SELECT + qBM_ZennouRiritu2 +
            $FROM (qBM_ZennouRiritu2) +
            $WHERE + qBM_ZennouRiritu2.tuukasyu.eq(pTuukasyu) +
            $AND + qBM_ZennouRiritu2.tekiyoukknfrom.le(String.valueOf(pRyosyuTykzenoutouYmd)) +
            $AND + qBM_ZennouRiritu2.tekiyoukknkto.ge(String.valueOf(pRyosyuTykzenoutouYmd));

        return exDBEntityManager.createJPQL(strSql).setFirstResult(0).setMaxResults(1).bind(qBM_ZennouRiritu2).getSingleResult();
    }

    public List<BM_ZennouTumitateRitu2> getTumitateRitu2(C_Tuukasyu pTuukasyu, BizDate pStartYmd, BizDate pEndYmd) {

        QBM_ZennouTumitateRitu2 qBM_ZennouTumitateRitu2 = new QBM_ZennouTumitateRitu2("qBM_ZennouTumitateRitu");

        String strSql = $SELECT + qBM_ZennouTumitateRitu2 +
            $FROM (qBM_ZennouTumitateRitu2) +
            $WHERE + qBM_ZennouTumitateRitu2.tuukasyu.eq(pTuukasyu) +
            $AND +$((qBM_ZennouTumitateRitu2.tekiyoukknfrom.le(String.valueOf(pStartYmd)) +
                $AND + qBM_ZennouTumitateRitu2.tekiyoukknkto.ge(String.valueOf(pStartYmd))) +
                $OR + $(qBM_ZennouTumitateRitu2.tekiyoukknfrom.ge(String.valueOf(pStartYmd)) +
                    $AND + qBM_ZennouTumitateRitu2.tekiyoukknfrom.le(String.valueOf(pEndYmd)))) +
                    $ORDER_BY(qBM_ZennouTumitateRitu2.tekiyoukknfrom.asc());
        return exDBEntityManager.createJPQL(strSql).bind(qBM_ZennouTumitateRitu2).getResultList();
    }

    public IT_Zennou getZennou(IT_AnsyuKihon pAnsyuKihon,
        BizDate pZennouKaisiYmd,
        Integer pRenno) {

        List<IT_Zennou> zennouLst = pAnsyuKihon.getZennous();

        IT_Zennou zennou = Iterables.getFirst(Iterables.filter(zennouLst,
            new FilterZennou1(pZennouKaisiYmd, pRenno)), null);

        return zennou;
    }

}
