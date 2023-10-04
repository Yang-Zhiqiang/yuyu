package yuyu.batch.hozen.khinterf.khtmttkinyskcsvfilesel.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_TargetTkHukaKanouKbn;
import yuyu.def.db.meta.QBM_SyouhnZokusei;
import yuyu.def.db.meta.QIT_KykSonotaTkyk;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QZT_SinBosyuuDrtenHoyuuKykRn;

/**
 * 契約保全 インターフェイス 積立金予測ＣＳＶファイル抽出機能DAOクラス
 */
public class KhTmttkinYskCsvFileSelDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhTmttkinYskCsvFileSelBean> getTmttkinYskKykBeans(String pKakutyoujobcd, BizDate pSyoriYmd) {

        QZT_SinBosyuuDrtenHoyuuKykRn qZT_SinBosyuuDrtenHoyuuKykRn = new QZT_SinBosyuuDrtenHoyuuKykRn("qZT_SinBosyuuDrtenHoyuuKykRn");

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        QIT_KykSonotaTkyk qIT_KykSonotaTkyk = new QIT_KykSonotaTkyk("qIT_KykSonotaTkyk");

        QBM_SyouhnZokusei qBM_SyouhnZokusei = new QBM_SyouhnZokusei("qBM_SyouhnZokusei");

        String strSql = $SELECT + $NEW(KhTmttkinYskCsvFileSelBean.class,
            qZT_SinBosyuuDrtenHoyuuKykRn.zrnsyono,
            qZT_SinBosyuuDrtenHoyuuKykRn.zrnkykymd,
            qZT_SinBosyuuDrtenHoyuuKykRn.zrnitijibrpgaika,
            qZT_SinBosyuuDrtenHoyuuKykRn.zrntmttkngaika,
            qZT_SinBosyuuDrtenHoyuuKykRn.zrnkaiyakuhrkngaika,
            qIT_KykSyouhn.syouhncd,
            qIT_KykSyouhn.kyktuukasyu,
            qIT_KykSyouhn.kyksjkkktyouseiriritu,
            qIT_KykSyouhn.tmttknhaibunjyoutai,
            qIT_KykSonotaTkyk.targettkhkumu,
            qIT_KykSonotaTkyk.targettkmokuhyouti,
            qIT_KykSonotaTkyk.teikishrtkykhukaumu) +
            $FROM(qZT_SinBosyuuDrtenHoyuuKykRn,
                qIT_KykSyouhn,
                qIT_KykSonotaTkyk,
                qBM_SyouhnZokusei) +
                $WHERE + qZT_SinBosyuuDrtenHoyuuKykRn.zrnsymtymd.eq("00000000") +
                $AND +  qZT_SinBosyuuDrtenHoyuuKykRn.zrnkykymd.le(pSyoriYmd.toString()) +
                $AND + qZT_SinBosyuuDrtenHoyuuKykRn.zrnsyono.eq(qIT_KykSyouhn.syono) +
                $AND + qZT_SinBosyuuDrtenHoyuuKykRn.zrnsyono.eq(qIT_KykSonotaTkyk.syono) +
                $AND + qIT_KykSyouhn.syouhncd.eq(qBM_SyouhnZokusei.syouhncd) +
                $AND + qIT_KykSyouhn.syouhnsdno.eq(qBM_SyouhnZokusei.syouhnsdno) +
                $AND + qBM_SyouhnZokusei.targettkhukakanoukbn.ne(C_TargetTkHukaKanouKbn.NONE) +
                $ORDER_BY(qZT_SinBosyuuDrtenHoyuuKykRn.zrnsyono.asc());

        ExDBResults<KhTmttkinYskCsvFileSelBean> exDBResults = exDBEntityManager.createJPQL(
            strSql, KhTmttkinYskCsvFileSelBean.class).bind(
                qZT_SinBosyuuDrtenHoyuuKykRn,
                qIT_KykSyouhn,
                qIT_KykSonotaTkyk,
                qBM_SyouhnZokusei).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}
