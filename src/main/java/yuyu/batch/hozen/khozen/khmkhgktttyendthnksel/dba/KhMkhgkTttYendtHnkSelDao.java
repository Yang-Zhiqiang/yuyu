package yuyu.batch.hozen.khozen.khmkhgktttyendthnksel.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.BM_YoteiRiritu3;
import yuyu.def.db.meta.QBM_SyouhnZokusei;
import yuyu.def.db.meta.QBM_YoteiRiritu3;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSonotaTkyk;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QMT_KhHenkouUktkYyk;

/**
 * 契約保全 契約保全 目標額到達時円建変更対象抽出DAOクラス
 */
public class KhMkhgkTttYendtHnkSelDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhTttHntiKykBean> getKhTttHntiKykBySyoriYmd(String pKakutyouJobCd, BizDate pSyoriYmdPreviousYear) {

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QIT_KykSonotaTkyk qIT_KykSonotaTkyk = new QIT_KykSonotaTkyk("qIT_KykSonotaTkyk");
        QBM_SyouhnZokusei qBM_SyouhnZokusei = new QBM_SyouhnZokusei("qBM_SyouhnZokusei");

        String strSql = $SELECT + $NEW(KhTttHntiKykBean.class,
            qIT_KykKihon.kbnkey,
            qIT_KykKihon.syono,
            qIT_KykKihon.hrkkaisuu,
            qIT_KykKihon.haitounendo,
            qIT_KykKihon.sdpdkbn,
            qIT_KykKihon.hrkkeiro,
            qIT_KykSyouhn.syouhncd,
            qIT_KykSyouhn.syouhnsdno,
            qIT_KykSyouhn.ryouritusdno,
            qIT_KykSyouhn.yoteiriritu,
            qIT_KykSyouhn.hknkknsmnkbn,
            qIT_KykSyouhn.hknkkn,
            qIT_KykSyouhn.hrkkkn,
            qIT_KykSyouhn.hhknnen,
            qIT_KykSyouhn.hhknsei,
            qIT_KykSyouhn.kihons.getTypeFieldName(),
            qIT_KykSyouhn.kihons.getValueFieldName(),
            qIT_KykSyouhn.hokenryou.getTypeFieldName(),
            qIT_KykSyouhn.hokenryou.getValueFieldName(),
            qIT_KykSyouhn.kykymd,
            qIT_KykSyouhn.kyksjkkktyouseiriritu,
            qIT_KykSyouhn.kyktuukasyu,
            qIT_KykSyouhn.yuukousyoumetukbn,
            qIT_KykSyouhn.gengakugoyenitijibrpstgk.getTypeFieldName(),
            qIT_KykSyouhn.gengakugoyenitijibrpstgk.getValueFieldName(),
            qIT_KykSyouhn.kykjyoutai,
            qIT_KykSyouhn.dai1hknkkn,
            qIT_KykSonotaTkyk.targettkhkumu,
            qIT_KykSonotaTkyk.targettkykkijyungk.getTypeFieldName(),
            qIT_KykSonotaTkyk.targettkykkijyungk.getValueFieldName(),
            qIT_KykSonotaTkyk.targettkmokuhyouti,
            qBM_SyouhnZokusei.mvatekikkn,
            qBM_SyouhnZokusei.yendthnksyouhncd,
            qBM_SyouhnZokusei.kaiyakukoujyoritutekiumu) +
            $FROM(qIT_KykKihon,
                qIT_KykSyouhn,
                qIT_KykSonotaTkyk,
                qBM_SyouhnZokusei) +
                $WHERE + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_KykSonotaTkyk.syono) +
                $AND + qIT_KykSyouhn.syouhncd.eq(qBM_SyouhnZokusei.syouhncd) +
                $AND + qIT_KykSyouhn.syouhnsdno.eq(qBM_SyouhnZokusei.syouhnsdno) +
                $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
                $AND + qIT_KykSonotaTkyk.targettkhkumu.eq(C_UmuKbn.ARI) +
                $AND + qIT_KykSonotaTkyk.targettkmokuhyouti.gt(100) +
                $AND + qIT_KykSyouhn.kykymd.le(pSyoriYmdPreviousYear) +
                $ORDER_BY(qIT_KykKihon.syono.asc());

        ExDBResults<KhTttHntiKykBean> exDBResults = exDBEntityManager.createJPQL(strSql, KhTttHntiKykBean.class)
            .bind(qIT_KykKihon, qIT_KykSyouhn, qIT_KykSonotaTkyk, qBM_SyouhnZokusei).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }

    public List<KhHenkouUktkYykBean> getKhHenkouUktkYykBeansByUktkSyoriKbn(C_UktkSyoriKbn[] pUktkSyoriKbn) {

        QMT_KhHenkouUktkYyk qMT_KhHenkouUktkYyk = new QMT_KhHenkouUktkYyk("qMT_KhHenkouUktkYyk");

        String strSql = $SELECT + $NEW(KhHenkouUktkYykBean.class,
            qMT_KhHenkouUktkYyk.syono,
            qMT_KhHenkouUktkYyk.uktksyorikbn) +
            $FROM(qMT_KhHenkouUktkYyk) +
            $WHERE + qMT_KhHenkouUktkYyk.uktkjyoutaikbn.eq(C_UktkJyoutaiKbn.MISYORI) +
            $AND + qMT_KhHenkouUktkYyk.uktksyorikbn.in(pUktkSyoriKbn);

        return exDBEntityManager.createJPQL(strSql, KhHenkouUktkYykBean.class).bind(qMT_KhHenkouUktkYyk).getResultList();
    }

    public List<BM_YoteiRiritu3> getYoteiRiritus3ByKijyunYmd(BizDate pKijyunYmd) {

        QBM_YoteiRiritu3 qBM_YoteiRiritu3 = new QBM_YoteiRiritu3("qBM_YoteiRiritu3");

        String strSql = $SELECT + qBM_YoteiRiritu3 +
            $FROM(qBM_YoteiRiritu3) +
            $WHERE + qBM_YoteiRiritu3.tuukasyu.eq(C_Tuukasyu.JPY) +
            $AND + qBM_YoteiRiritu3.kijyunfromymd.le(pKijyunYmd) +
            $AND + qBM_YoteiRiritu3.kijyuntoymd.ge(pKijyunYmd);

        return exDBEntityManager.createJPQL(strSql).bind(qBM_YoteiRiritu3).getResultList();
    }
}
