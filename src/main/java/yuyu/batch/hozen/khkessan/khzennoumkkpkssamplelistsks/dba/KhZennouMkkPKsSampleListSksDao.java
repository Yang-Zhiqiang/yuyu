package yuyu.batch.hozen.khkessan.khzennoumkkpkssamplelistsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_ZennouKbn;
import yuyu.def.classification.C_ZennouToukeiListKbn;
import yuyu.def.db.meta.QIM_ZennouMkkpSampleList;
import yuyu.def.db.meta.QIT_ZennouKessan;

/**
 * 契約保全 決算 前納未経過Ｐ検証サンプルリスト作成機能DAOクラス
 */
public class KhZennouMkkPKsSampleListSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<ZennouMkkPKsSampleListPtnInfoBean> getZennouMkkPKsSampleListPtnInfoBeans() {

        QIM_ZennouMkkpSampleList qIM_ZennouMkkpSampleList = new QIM_ZennouMkkpSampleList("qIM_ZennouMkkpSampleList");

        String strSql = $SELECT + $NEW(ZennouMkkPKsSampleListPtnInfoBean.class,
            qIM_ZennouMkkpSampleList.zennoutoukeilistkbn,
            qIM_ZennouMkkpSampleList.zennoukbn,
            qIM_ZennouMkkpSampleList.kbnkeirisegcd,
            qIM_ZennouMkkpSampleList.znnmkkpkssamplekslsttitle) +
            $FROM(qIM_ZennouMkkpSampleList) +
            $ORDER_BY(qIM_ZennouMkkpSampleList.zennoutoukeilistkbn.asc(),
                qIM_ZennouMkkpSampleList.zennoukbn.asc(),
                qIM_ZennouMkkpSampleList.kbnkeirisegcd.asc());

        return exDBEntityManager.createJPQL(strSql, ZennouMkkPKsSampleListPtnInfoBean.class).bind(qIM_ZennouMkkpSampleList).getResultList();
    }

    public List<ZennouMkkPKsSampleListInfoBean> getZennouMkkPKsSampleListInfoBeans(
        BizDate pSakuseiymd, C_ZennouToukeiListKbn pZennoutoukeilistkbn, C_ZennouKbn pZennoukbn, C_Segcd pKbnkeirisegcd) {

        QIT_ZennouKessan qIT_ZennouKessan = new QIT_ZennouKessan("qIT_ZennouKessan");

        String strSql = $SELECT + $NEW(ZennouMkkPKsSampleListInfoBean.class,
            qIT_ZennouKessan.syono,
            qIT_ZennouKessan.zennoutoukeilistkbn,
            qIT_ZennouKessan.zennoukbn,
            qIT_ZennouKessan.kbnkeirisegcd,
            qIT_ZennouKessan.zennoustartym,
            qIT_ZennouKessan.keiyakuymd,
            qIT_ZennouKessan.zennounyuukinymd,
            qIT_ZennouKessan.zennouwrbkrt,
            qIT_ZennouKessan.zennoukaisijizndk.getTypeFieldName(),
            qIT_ZennouKessan.zennoukaisijizndk.getValueFieldName(),
            qIT_ZennouKessan.tndmatutkyrt,
            qIT_ZennouKessan.tndmatuzndk.getTypeFieldName(),
            qIT_ZennouKessan.tndmatuzndk.getValueFieldName(),
            qIT_ZennouKessan.zennoukaisijizndktkmatu.getTypeFieldName(),
            qIT_ZennouKessan.zennoukaisijizndktkmatu.getValueFieldName(),
            qIT_ZennouKessan.tndmatuzndktkmatu.getTypeFieldName(),
            qIT_ZennouKessan.tndmatuzndktkmatu.getValueFieldName()) +
            $FROM(qIT_ZennouKessan) +
            $WHERE + qIT_ZennouKessan.sakuseiymd.eq(pSakuseiymd) +
            $AND + qIT_ZennouKessan.zennoutoukeilistkbn.eq(pZennoutoukeilistkbn) +
            $AND + qIT_ZennouKessan.zennoukbn.eq(pZennoukbn) +
            $AND + qIT_ZennouKessan.kbnkeirisegcd.eq(pKbnkeirisegcd) +
            $ORDER_BY(qIT_ZennouKessan.syono.asc());
        return exDBEntityManager.createJPQL(strSql, ZennouMkkPKsSampleListInfoBean.class).setFirstResult(0)
            .setMaxResults(20).bind(qIT_ZennouKessan).getResultList();
    }
}
