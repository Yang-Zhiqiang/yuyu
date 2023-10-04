package yuyu.batch.hozen.khozen.khlincjyusininfohanei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_LincsoujyusinsysKbn;
import yuyu.def.classification.C_SousinKbn;
import yuyu.def.db.entity.IT_KhLincSousinData;
import yuyu.def.db.meta.QHT_SkLincJyusinData;
import yuyu.def.db.meta.QIT_KhLincSousinData;

/**
 * 契約保全 契約保全 契約保全ＬＩＮＣ受信情報反映の機能DAOクラス
 */
public class KhLincJyusinInfoHaneiDao {

    @Inject
    protected ExDBEntityManager exDBEntityManager;

    public ExDBResults<SkLincJyusinDataBean> getSkLincJyusinDataBySyoriYmdLincsoujyusinsysKbn(String pKakutyoujobcd,
        BizDate pSyoriYmd, C_LincsoujyusinsysKbn pLincsoujyusinsysKbn) {

        QHT_SkLincJyusinData qHT_SkLincJyusinData = new QHT_SkLincJyusinData("qHT_SkLincJyusinData");

        String linchenkoutypetuika = YuyuBizConfig.getInstance().getLinchenkoutypetuika();

        String strSql = $SELECT + $NEW(SkLincJyusinDataBean.class,
            qHT_SkLincJyusinData.syono,
            qHT_SkLincJyusinData.syoriYmd,
            qHT_SkLincJyusinData.linckyknaiykekdatarenno,
            qHT_SkLincJyusinData.linckanyuusyano) +
            $FROM(qHT_SkLincJyusinData) +
            $WHERE + qHT_SkLincJyusinData.lincsoujyusinsyskbn.eq(pLincsoujyusinsysKbn) +
            $AND + qHT_SkLincJyusinData.linchenkoutype.eq(linchenkoutypetuika)+
            $AND + qHT_SkLincJyusinData.syoriYmd.eq(pSyoriYmd);

        ExDBResults<SkLincJyusinDataBean> exDBResults = exDBEntityManager.createJPQL(strSql, SkLincJyusinDataBean.class)
            .bind(qHT_SkLincJyusinData).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public List<IT_KhLincSousinData> getKhLincSousinDataListBySyonoSousinKbn(String pSyono, C_SousinKbn pSousinKbn) {

        QIT_KhLincSousinData qIT_KhLincSousinData = new QIT_KhLincSousinData("qIT_KhLincSousinData");

        String strSql = $SELECT + qIT_KhLincSousinData +
            $FROM(qIT_KhLincSousinData) +
            $WHERE + qIT_KhLincSousinData.syono.eq(pSyono) +
            $AND + qIT_KhLincSousinData.lincsousinkbn.eq(pSousinKbn) +
            $ORDER_BY(qIT_KhLincSousinData.syoriYmd.desc(),
                qIT_KhLincSousinData.renno.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhLincSousinData).getResultList();
    }
}
