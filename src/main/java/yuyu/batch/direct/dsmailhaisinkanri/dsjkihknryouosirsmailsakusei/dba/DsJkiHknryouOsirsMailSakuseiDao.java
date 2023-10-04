package yuyu.batch.direct.dsmailhaisinkanri.dsjkihknryouosirsmailsakusei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_DsMailSousinJyoutaiKbn;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;
import yuyu.def.classification.C_MukouHyj;
import yuyu.def.db.meta.QIT_KawaseRateTuutiData;
import yuyu.def.db.meta.QMT_DsKokyakuKanri;
import yuyu.def.db.meta.QMT_DsKokyakuKeiyaku;
import yuyu.def.db.meta.QMT_DsMailAddress;
import yuyu.def.db.meta.QMT_DsMailHaisin;
import yuyu.def.db.meta.QMT_DsMailHaisinRireki;

/**
 * ダイレクトサービス ＤＳメール配信管理 次回保険料お知らせメール作成DAOクラス<br />
 * 次回保険料お知らせメール作成の機能DAOクラスです。<br />
 *
 */
public class DsJkiHknryouOsirsMailSakuseiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public void deleteDsMailHaisin(BizDate pHaisinYmd, C_DsSousinMailSyubetuKbn pDsSousinMailSyubetuKbn) {

        QMT_DsMailHaisin qMT_DsMailHaisin = new QMT_DsMailHaisin("qMT_DsMailHaisin");

        String strSql = $DELETE_FROM(qMT_DsMailHaisin)          +
            $WHERE + qMT_DsMailHaisin.sousinymd.lt(pHaisinYmd)  +
            $AND   + qMT_DsMailHaisin.dssousinmailsyubetukbn.eq(pDsSousinMailSyubetuKbn);

        exDBEntityManager.createJPQL(strSql).bind(qMT_DsMailHaisin).executeUpdate();
    }

    public ExDBResults<DsKawaseRateTuutiDataBean> getDsKawaseRateTuutiTysyt(String pKakutyouJobCd, BizDate pSakuseiymd) {

        QIT_KawaseRateTuutiData qIT_KawaseRateTuutiData = new QIT_KawaseRateTuutiData("qIT_KawaseRateTuutiData");

        String strSql = $SELECT +
            $NEW(DsKawaseRateTuutiDataBean.class,
            qIT_KawaseRateTuutiData.kbnkey,
            qIT_KawaseRateTuutiData.syono,
            qIT_KawaseRateTuutiData.kwsratekjymd,
            qIT_KawaseRateTuutiData.kawaserate,
            qIT_KawaseRateTuutiData.kyktuukasyu,
            qIT_KawaseRateTuutiData.bosyuujiaatukaidrtenkj,
            qIT_KawaseRateTuutiData.aisyoumeikbn,
            qIT_KawaseRateTuutiData.kykymd,
            qIT_KawaseRateTuutiData.hrkp.getTypeFieldName(),
            qIT_KawaseRateTuutiData.hrkp.getValueFieldName(),
            qIT_KawaseRateTuutiData.siteituukap.getTypeFieldName(),
            qIT_KawaseRateTuutiData.siteituukap.getValueFieldName())           +
            $FROM(qIT_KawaseRateTuutiData)                                     +
            $WHERE + qIT_KawaseRateTuutiData.tyouhyouymd.eq(pSakuseiymd);

        ExDBResults<DsKawaseRateTuutiDataBean> exDBResults =
            exDBEntityManager.createJPQL(strSql, DsKawaseRateTuutiDataBean.class).bind(qIT_KawaseRateTuutiData).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }

    public Integer getDsMailHaisinRirekiMaxDsMailHaisinRenNo(BizDate pDsDataSakuseiYmd) {

        QMT_DsMailHaisinRireki qMT_DsMailHaisinRireki = new QMT_DsMailHaisinRireki("qMT_DsMailHaisinRireki");

        String strSql = $SELECT + $MAX(qMT_DsMailHaisinRireki.dsmailhaisinrenban)   +
            $FROM(qMT_DsMailHaisinRireki)                                           +
            $WHERE + qMT_DsMailHaisinRireki.dsdatasakuseiymd.eq(pDsDataSakuseiYmd);

        return exDBEntityManager.createJPQL(strSql).bind(qMT_DsMailHaisinRireki).getSingleResult();
    }

    public List<DsJkiHknryouOsirsMailSakuseiTaisyouBean> getDsJkiHknryouOsirsMailSakuseiTaisyouHantei(String pSyono) {

        QMT_DsKokyakuKeiyaku qMT_DsKokyakuKeiyaku = new QMT_DsKokyakuKeiyaku("qMT_DsKokyakuKeiyaku");
        QMT_DsKokyakuKanri qMT_DsKokyakuKanri = new QMT_DsKokyakuKanri("qMT_DsKokyakuKanri");
        QMT_DsMailAddress  qMT_DsMailAddress  = new QMT_DsMailAddress("qMT_DsMailAddress");

        String strSql = $SELECT +
            $NEW(DsJkiHknryouOsirsMailSakuseiTaisyouBean.class,
                qMT_DsKokyakuKanri.dskokno,
                qMT_DsMailAddress.dsmailaddressrenban,
                qMT_DsMailAddress.dsmailaddress)                                                    +
                $FROM(qMT_DsKokyakuKeiyaku, qMT_DsKokyakuKanri, qMT_DsMailAddress)                  +
                $WHERE + qMT_DsKokyakuKeiyaku.syono.eq(pSyono)                                      +
                $AND   + qMT_DsKokyakuKeiyaku.dskokno.eq(qMT_DsKokyakuKanri.dskokno)                +
                $AND   + qMT_DsKokyakuKanri.dskokno.eq(qMT_DsMailAddress.dskokno)                   +
                $AND   + qMT_DsKokyakuKeiyaku.dskykmukouhyj.eq(C_MukouHyj.BLANK)                    +
                $AND   + qMT_DsMailAddress.dsmailsousinjyoutaikbn.eq(C_DsMailSousinJyoutaiKbn.YUUKOU);

        return exDBEntityManager.createJPQL(strSql, DsJkiHknryouOsirsMailSakuseiTaisyouBean.class)
            .bind(qMT_DsKokyakuKeiyaku, qMT_DsKokyakuKanri, qMT_DsMailAddress).getResultList();
    }
}