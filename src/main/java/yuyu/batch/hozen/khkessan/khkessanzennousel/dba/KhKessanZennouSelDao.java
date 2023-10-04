package yuyu.batch.hozen.khkessan.khkessanzennousel.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import com.google.common.collect.Iterables;

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

/**
 * 契約保全 決算 決算用前納データ抽出機能DAOクラス
 */
public class KhKessanZennouSelDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<ZennouInfoBean> getZennouInfos(BizDate pKsnbiymd) {

        QIT_Zennou qIT_Zennou1 = new QIT_Zennou("qIT_Zennou1");
        QIT_Zennou qIT_Zennou2 = new QIT_Zennou("qIT_Zennou2");

        String strSubSql = $SELECT + $MAX(qIT_Zennou1.renno) +
            $FROM(qIT_Zennou1) +
            $WHERE + qIT_Zennou2.syono.eq(qIT_Zennou1.syono);

        String strSql = $SELECT + $NEW(ZennouInfoBean.class,
            qIT_Zennou2.syono,
            qIT_Zennou2.zennoukaisiymd,
            qIT_Zennou2.renno,
            qIT_Zennou2.ryosyuymd) +
            $FROM(qIT_Zennou2) +
            $WHERE + $(qIT_Zennou2.zennouseisankbn.eq(C_ZennouSeisanKbn.MISEISAN) +
                $OR + $(qIT_Zennou2.zennouseisankbn.eq(C_ZennouSeisanKbn.SEISANZUMI) +
                    $AND + $(qIT_Zennou2.zennouseisandenymd.gt(pKsnbiymd) +
                        $OR + $(qIT_Zennou2.zennouseisandenymd.isNull() +
                            $AND + qIT_Zennou2.zennouseisansyoriymd.gt(pKsnbiymd))))) +
            $AND + qIT_Zennou2.renno + $EQ  + $(strSubSql);

        return exDBEntityManager.createJPQL(strSql, ZennouInfoBean.class).bind(qIT_Zennou1, qIT_Zennou2).getResults();
    }

    public List<BM_ZennouRiritu2> getZennouRiritu2(C_Tuukasyu pTuukasyu, BizDate pRyosyutykzenoutouymd) {

        QBM_ZennouRiritu2 qBM_ZennouRiritu2 = new QBM_ZennouRiritu2("qBM_ZennouRiritu2");

        String strSql = $SELECT + qBM_ZennouRiritu2 +
            $FROM(qBM_ZennouRiritu2) +
            $WHERE + qBM_ZennouRiritu2.tuukasyu.eq(pTuukasyu) +
            $AND + qBM_ZennouRiritu2.zennoutkybr1.eq("") +
            $AND + qBM_ZennouRiritu2.zennoutkybr2.eq("") +
            $AND + qBM_ZennouRiritu2.zennoutkybr3.eq("") +
            $AND + qBM_ZennouRiritu2.tekiyoukknfrom.le(pRyosyutykzenoutouymd.toString()) +
            $AND + qBM_ZennouRiritu2.tekiyoukknkto.ge(pRyosyutykzenoutouymd.toString());

        return exDBEntityManager.createJPQL(strSql).bind(qBM_ZennouRiritu2).getResultList();
    }

    public List<BM_ZennouTumitateRitu2> getTumitateRiritu2(C_Tuukasyu pTuukasyu, BizDate pKijyunymd) {

        QBM_ZennouTumitateRitu2 qBM_ZennouTumitateRitu2 = new QBM_ZennouTumitateRitu2("qBM_ZennouTumitateRitu2");

        String strSql = $SELECT + qBM_ZennouTumitateRitu2 +
            $FROM(qBM_ZennouTumitateRitu2) +
            $WHERE + qBM_ZennouTumitateRitu2.tuukasyu.eq(pTuukasyu) +
            $AND + qBM_ZennouTumitateRitu2.zennoutkybr1.eq("") +
            $AND + qBM_ZennouTumitateRitu2.zennoutkybr2.eq("") +
            $AND + qBM_ZennouTumitateRitu2.zennoutkybr3.eq("") +
            $AND + qBM_ZennouTumitateRitu2.tekiyoukknfrom.le(pKijyunymd.toString()) +
            $AND + qBM_ZennouTumitateRitu2.tekiyoukknkto.ge(pKijyunymd.toString());

        return exDBEntityManager.createJPQL(strSql).bind(qBM_ZennouTumitateRitu2).getResultList();
    }

    public IT_Zennou getZennou(IT_AnsyuKihon pAnsyuKihon, BizDate pZennoukaisiymd, Integer pRenno) {

        List<IT_Zennou> zennouLst = pAnsyuKihon.getZennous();

        IT_Zennou zennou = Iterables.getFirst(Iterables.filter(zennouLst,
            new FilterZennou1(pZennoukaisiymd, pRenno)), null);

        return zennou;
    }
}
