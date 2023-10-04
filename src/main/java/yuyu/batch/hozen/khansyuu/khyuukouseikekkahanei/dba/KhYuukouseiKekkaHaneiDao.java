package yuyu.batch.hozen.khansyuu.khyuukouseikekkahanei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Yuukoukakkekka;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.meta.QIT_AnsyuKihon;
import yuyu.def.db.meta.QIT_CreditCardInfo;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSyouhn;

/**
 * 契約保全 案内収納 有効性確認結果反映の機能DAOクラス
 */
public class KhYuukouseiKekkaHaneiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<YuukouseiKekkaHaneiDataBean> getYuukouseiKekkaHaneiDataBean(String pKakutyoujobcd,
        String pKbnkey) {
        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QIT_AnsyuKihon qIT_AnsyuKihon = new QIT_AnsyuKihon("qIT_AnsyuKihon");
        QIT_CreditCardInfo qIT_CreditCardInfo = new QIT_CreditCardInfo("qIT_CreditCardInfo");

        String where = "";

        if (!BizUtil.isBlank(pKbnkey)) {
            where = $WHERE + qIT_KykKihon.kbnkey.eq(pKbnkey) +
                $AND + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono);
        }
        else {
            where = $WHERE + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono);
        }
        where += $AND + qIT_KykKihon.syono.eq(qIT_AnsyuKihon.syono) +
            $AND + qIT_KykKihon.syono.eq(qIT_CreditCardInfo.syono) +
            $AND + qIT_KykKihon.hrkkeiro.eq(C_Hrkkeiro.CREDIT) +
            $AND + qIT_KykKihon.hrkkaisuu.eq(C_Hrkkaisuu.TUKI) +
            $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
            $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
            $AND + qIT_KykSyouhn.kykjyoutai.eq(C_Kykjyoutai.HRKMTYUU) +
            $AND + qIT_AnsyuKihon.jkipjytym.substring(1, 6).lt(qIT_AnsyuKihon.syuharaimanymd.substring(1, 6)) +
            $AND + qIT_CreditCardInfo.credityuukoukakkekka.eq(C_Yuukoukakkekka.YUUKOUKAK_OK);

        String sql = $SELECT + $NEW(YuukouseiKekkaHaneiDataBean.class,
            qIT_KykKihon.syono,
            qIT_KykKihon.kbnkey,
            qIT_KykKihon.tikiktbrisyuruikbn,
            qIT_CreditCardInfo.creditkessaiyouno) +
            $FROM (qIT_KykKihon, qIT_KykSyouhn, qIT_AnsyuKihon, qIT_CreditCardInfo) +
            where;

        ExDBResults<YuukouseiKekkaHaneiDataBean> exDBResults = exDBEntityManager.createJPQL(
            sql, YuukouseiKekkaHaneiDataBean.class).bind(qIT_KykKihon, qIT_KykSyouhn, qIT_AnsyuKihon, qIT_CreditCardInfo).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}
