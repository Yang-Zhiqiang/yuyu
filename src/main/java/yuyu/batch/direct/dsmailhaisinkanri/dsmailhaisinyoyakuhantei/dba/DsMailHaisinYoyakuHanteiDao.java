package yuyu.batch.direct.dsmailhaisinkanri.dsmailhaisinyoyakuhantei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_DsHaisinYoyakuStatusKbn;
import yuyu.def.classification.C_DsMailSousinJyoutaiKbn;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.MT_DsMailHaisinYoyaku;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QJT_SibouKariuketsuke;
import yuyu.def.db.meta.QMT_DsKokyakuKeiyaku;
import yuyu.def.db.meta.QMT_DsMailAddress;
import yuyu.def.db.meta.QMT_DsMailHaisin;
import yuyu.def.db.meta.QMT_DsMailHaisinRireki;
import yuyu.def.db.meta.QMT_DsMailHaisinYoyaku;

/**
 * ダイレクトサービス ＤＳメール配信管理 ＤＳメール配信予約判定DAOクラス<br />
 * ＤＳメール配信予約の機能DAOクラスです。<br />
 */
public class DsMailHaisinYoyakuHanteiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public void deleteDsMailHaisinByHaisinYmd(BizDate pHaisinYmd) {

        QMT_DsMailHaisin qMT_DsMailHaisin = new QMT_DsMailHaisin("qMT_DsMailHaisin");

        String strSql = $DELETE_FROM(qMT_DsMailHaisin)          +
            $WHERE + qMT_DsMailHaisin.sousinymd.lt(pHaisinYmd)  +
            $AND   + qMT_DsMailHaisin.dssousinmailsyubetukbn.eq(C_DsSousinMailSyubetuKbn.CLEANINGMAIL);

        exDBEntityManager.createJPQL(strSql).bind(qMT_DsMailHaisin).executeUpdate();
    }

    public List<DsMailHaisinYoyakuBean> getDsMailHaisinYoyakuByHaisinYoteiYmd(BizDate pHaisinYmd) {

        QMT_DsMailHaisinYoyaku qMT_DsMailHaisinYoyaku = new QMT_DsMailHaisinYoyaku("qMT_DsMailHaisinYoyaku");

        String strSql = $SELECT +
            $NEW(DsMailHaisinYoyakuBean.class,
                qMT_DsMailHaisinYoyaku.dsmailhaisinyoyakuskbtkey,
                qMT_DsMailHaisinYoyaku.dsmailhaisinyoteiymd,
                qMT_DsMailHaisinYoyaku.dssousinmailsyubetukbn,
                qMT_DsMailHaisinYoyaku.dshaisinyoyakustatuskbn,
                qMT_DsMailHaisinYoyaku.dsmailhaisintourokuymd,
                qMT_DsMailHaisinYoyaku.dsmailhaisinsyouninymd,
                qMT_DsMailHaisinYoyaku.dsmailhaisintourokusyaid,
                qMT_DsMailHaisinYoyaku.dsmailhaisinsyouninsyaid,
                qMT_DsMailHaisinYoyaku.gyoumuKousinKinou,
                qMT_DsMailHaisinYoyaku.gyoumuKousinsyaId,
                qMT_DsMailHaisinYoyaku.gyoumuKousinTime) +
                $FROM(qMT_DsMailHaisinYoyaku)            +
                $WHERE + qMT_DsMailHaisinYoyaku.dsmailhaisinyoteiymd.eq(pHaisinYmd)                                  +
                $AND   + $(qMT_DsMailHaisinYoyaku.dshaisinyoyakustatuskbn.eq(C_DsHaisinYoyakuStatusKbn.SYOUNIN_MATI) +
                    $OR    + qMT_DsMailHaisinYoyaku.dshaisinyoyakustatuskbn.eq(C_DsHaisinYoyakuStatusKbn.SYOUNIN_SUMI));

        return exDBEntityManager.
            createJPQL(strSql, DsMailHaisinYoyakuBean.class).bind(qMT_DsMailHaisinYoyaku).getResultList();
    }

    public MT_DsMailHaisinYoyaku getDsMailHaisinYoyakuByDsmailhaisinyoyakuskbtkey(String pDsmailhaisinyoyakuskbtkey) {

        QMT_DsMailHaisinYoyaku qMT_DsMailHaisinYoyaku = new QMT_DsMailHaisinYoyaku("qMT_DsMailHaisinYoyaku");

        String strSql = $SELECT + qMT_DsMailHaisinYoyaku +
            $FROM(qMT_DsMailHaisinYoyaku)                +
            $WHERE + qMT_DsMailHaisinYoyaku.dsmailhaisinyoyakuskbtkey.eq(pDsmailhaisinyoyakuskbtkey);

        return exDBEntityManager.createJPQL(strSql).bind(qMT_DsMailHaisinYoyaku).getSingleResult();
    }

    public ExDBResults<DsYuukouMailAddressBean> getDsMailAddressByKakutyouJobCd(String pKakutyouJobCd) {

        QMT_DsMailAddress  qMT_DsMailAddress  = new QMT_DsMailAddress("qMT_DsMailAddress");
        QMT_DsKokyakuKeiyaku qMT_DsKokyakuKeiyaku = new QMT_DsKokyakuKeiyaku("qMT_DsKokyakuKeiyaku");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QJT_SibouKariuketsuke qJT_SibouKariuketsuke = new QJT_SibouKariuketsuke("qJT_SibouKariuketsuke");

        String strSubSql1 = $SELECT + qMT_DsKokyakuKeiyaku.dskokno                +
            $FROM(qMT_DsKokyakuKeiyaku, qIT_KykSyouhn)                            +
            $WHERE + qMT_DsMailAddress.dskokno.eq(qMT_DsKokyakuKeiyaku.dskokno)   +
            $AND   + qMT_DsKokyakuKeiyaku.syono.eq(qIT_KykSyouhn.syono)           +
            $AND   + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU)                    +
            $AND   + qIT_KykSyouhn.yuukousyoumetukbn.ne(C_YuukousyoumetuKbn.SYOUMETU);

        String strSubSql2 = $SELECT + qMT_DsKokyakuKeiyaku.dskokno                +
            $FROM(qMT_DsKokyakuKeiyaku, qJT_SibouKariuketsuke)                    +
            $WHERE + qMT_DsMailAddress.dskokno.eq(qMT_DsKokyakuKeiyaku.dskokno)   +
            $AND   + qMT_DsKokyakuKeiyaku.syono.eq(qJT_SibouKariuketsuke.syono)   +
            $AND   + qJT_SibouKariuketsuke.torikesiflg.eq(C_UmuKbn.NONE);

        String strSql = $SELECT + $NEW(DsYuukouMailAddressBean.class,
            qMT_DsMailAddress.dskokno,
            qMT_DsMailAddress.dsmailaddressrenban,
            qMT_DsMailAddress.dsmailaddress)                                                      +
            $FROM(qMT_DsMailAddress)                                                              +
            $WHERE + qMT_DsMailAddress.dsmailaddress.ne("")                                       +
            $AND   + qMT_DsMailAddress.dsmailsousinjyoutaikbn.eq(C_DsMailSousinJyoutaiKbn.YUUKOU) +
            $AND   + $EXISTS(strSubSql1)                                                          +
            $AND   + $NOT_EXISTS(strSubSql2);

        ExDBResults<DsYuukouMailAddressBean> exDBResults =
            exDBEntityManager.createJPQL(strSql, DsYuukouMailAddressBean.class).
            bind(qMT_DsMailAddress, qMT_DsKokyakuKeiyaku, qIT_KykSyouhn, qJT_SibouKariuketsuke).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }

    public Integer getDsMailHaisinRirekiMaxDsMailHaisinRenNo(
        BizDate pDsDataSakuseiYmd, C_DsSousinMailSyubetuKbn pDsSousinMailSyubetuKbn) {

        QMT_DsMailHaisinRireki qMT_DsMailHaisinRireki = new QMT_DsMailHaisinRireki("qMT_DsMailHaisinRireki");

        String strSql = $SELECT + $MAX(qMT_DsMailHaisinRireki.dsmailhaisinrenban)   +
            $FROM(qMT_DsMailHaisinRireki)                                           +
            $WHERE + qMT_DsMailHaisinRireki.dsdatasakuseiymd.eq(pDsDataSakuseiYmd)  +
            $AND   + qMT_DsMailHaisinRireki.dssousinmailsyubetukbn.eq(pDsSousinMailSyubetuKbn);

        return exDBEntityManager.createJPQL(strSql).bind(qMT_DsMailHaisinRireki).getSingleResult();
    }
}