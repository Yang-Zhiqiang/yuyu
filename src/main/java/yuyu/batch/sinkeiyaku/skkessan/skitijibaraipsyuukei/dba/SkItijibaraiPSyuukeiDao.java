package yuyu.batch.sinkeiyaku.skkessan.skitijibaraipsyuukei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_SegbunruiKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.meta.QBM_SyouhnbetuSegment;
import yuyu.def.db.meta.QHT_MosKihon;
import yuyu.def.db.meta.QHT_MosSyouhn;
import yuyu.def.db.meta.QHT_Nyuukin;
import yuyu.def.db.meta.QHT_SkDenpyoData;
import yuyu.def.db.meta.QHT_SyoriCTL;
import yuyu.def.sinkeiyaku.result.bean.ItijibaraiNkInfosByKakutyoujobcdStartymdFromSyoriYmdBean;

/**
 * 新契約 決算 一時払契約増額特約付契約Ｐ集計の機能DAOクラスです。
 */
public class SkItijibaraiPSyuukeiDao {

    @Inject
    ExDBEntityManager em;

    public ExDBResults<ItijibaraiNkInfosByKakutyoujobcdStartymdFromSyoriYmdBean> getItijibaraiNkInfosByKakutyoujobcdStartymdFromSyoriYmd(
        String pKakutyoujobcd, BizDate pStartymdfrom, BizDate pSyoriYmd) {

        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL("qHT_SyoriCTL");
        QHT_SkDenpyoData qHT_SkDenpyoData = new QHT_SkDenpyoData("qHT_SkDenpyoData");
        QHT_Nyuukin qHT_Nyuukin = new QHT_Nyuukin("qHT_Nyuukin");
        QHT_MosSyouhn qHT_MosSyouhn = new QHT_MosSyouhn("qHT_MosSyouhn");
        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon("qHT_MosKihon");
        QBM_SyouhnbetuSegment qBM_SyouhnbetuSegment = new QBM_SyouhnbetuSegment("qBM_SyouhnbetuSegment");

        String strSubSql = "CASE " +
            "WHEN" + qHT_SyoriCTL.mosnrkymd.lt(qHT_Nyuukin.nyksyoriymd) +
            "THEN" + qHT_Nyuukin.nyksyoriymd +
            "ELSE" + qHT_SyoriCTL.mosnrkymd +
            "END" + $AS + "inputymd";

        String strSql = $SELECT + $NEW(ItijibaraiNkInfosByKakutyoujobcdStartymdFromSyoriYmdBean.class,
            strSubSql,
            qHT_SyoriCTL.mosno,
            qHT_SyoriCTL.mosnrkymd,
            qHT_Nyuukin.nyksyoriymd,
            qHT_Nyuukin.rstuukasyu,
            qHT_Nyuukin.rsgaku.getTypeFieldName(),
            qHT_Nyuukin.rsgaku.getValueFieldName(),
            qHT_SkDenpyoData.denyenkagk.getTypeFieldName(),
            qHT_SkDenpyoData.denyenkagk.getValueFieldName(),
            qBM_SyouhnbetuSegment.segcd + $AS + "seg1cd" ,
            qHT_SkDenpyoData.denkawaserate) +
            $FROM (qHT_SyoriCTL,
                qHT_SkDenpyoData,
                qHT_Nyuukin,
                qHT_MosSyouhn,
                qHT_MosKihon,
                qBM_SyouhnbetuSegment) +
                $WHERE + qHT_SyoriCTL.mosno.eq(qHT_Nyuukin.mosno) +
                $AND + qHT_Nyuukin.denrenno.eq(qHT_SkDenpyoData.denrenno) +
                $AND + qHT_Nyuukin.edano.eq(qHT_SkDenpyoData.edano) +
                $AND + qHT_SyoriCTL.mosno.eq(qHT_MosSyouhn.mosno) +
                $AND + qHT_SyoriCTL.mosno.eq(qHT_MosKihon.mosno) +
                $AND + qBM_SyouhnbetuSegment.syouhncd.eq(qHT_MosSyouhn.syouhncd) +
                $AND + qBM_SyouhnbetuSegment.kyktuukasyu.eq(qHT_MosKihon.kyktuukasyu) +
                $AND + qBM_SyouhnbetuSegment.segbunrui1.eq(C_SegbunruiKbn.BLNK) +
                $AND + qBM_SyouhnbetuSegment.segbunrui2.eq(C_SegbunruiKbn.BLNK) +
                $AND + qHT_SkDenpyoData.hrkkaisuu.eq(C_Hrkkaisuu.ITIJI) +
                $AND + qHT_Nyuukin.nyksyoriymd.ge(pStartymdfrom) +
                $AND + qHT_Nyuukin.nyksyoriymd.le(pSyoriYmd) +
                $AND + qHT_MosSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $ORDER_BY(" inputymd ASC ",
                    qBM_SyouhnbetuSegment.segcd.asc(),
                    qHT_Nyuukin.rstuukasyu.asc(),
                    qHT_SkDenpyoData.denkawaserate.asc());

        ExDBResults<ItijibaraiNkInfosByKakutyoujobcdStartymdFromSyoriYmdBean> exDBResults =  em.createJPQL(strSql, ItijibaraiNkInfosByKakutyoujobcdStartymdFromSyoriYmdBean.class)
            .bind(qHT_SyoriCTL, qHT_SkDenpyoData, qHT_Nyuukin, qHT_MosSyouhn, qHT_MosKihon, qBM_SyouhnbetuSegment).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}
