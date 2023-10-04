package yuyu.batch.hozen.khansyuu.khsinkokuyokokutuutisks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_SinkokuyokokuTuuti;
import yuyu.def.db.meta.QIT_AnsyuKihon;
import yuyu.def.db.meta.QIT_HhknSya;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSya;
import yuyu.def.db.meta.QIT_KykSyouhn;

/**
 * 契約保全 案内収納 申告予告通知作成機能DAOクラス
 */
public class KhSinkokuYokokuTuutiSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<SinkokuYokokuTuutiSksBean> getSinkokuYokokuTuutiSks(String pSyoumeinnd, String pKakutyouJobCd, String pKbnKey) {
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_AnsyuKihon qIT_AnsyuKihon = new QIT_AnsyuKihon("qIT_AnsyuKihon");
        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");
        QIT_HhknSya qIT_HhknSya = new QIT_HhknSya("qIT_HhknSya");
        String kskJyouken = "";

        if (!BizUtil.isBlank(pKbnKey)) {

            kskJyouken = $AND + qIT_AnsyuKihon.kbnkey.eq(pKbnKey);
        }

        String queryStr = $SELECT + $NEW(SinkokuYokokuTuutiSksBean.class,
            qIT_KykKihon.syono,
            qIT_KykKihon.kbnkey,
            qIT_KykKihon.hrkkaisuu,
            qIT_AnsyuKihon.jkipjytym,
            qIT_KykSyouhn.kykjyoutai,
            qIT_KykKihon.haitoukinuketorihoukbn,
            qIT_KykSya.tsinyno,
            qIT_KykSya.tsinadr1kj,
            qIT_KykSya.tsinadr2kj,
            qIT_KykSya.tsinadr3kj,
            qIT_KykSya.kyknmkj,
            // 未実装
            //qIT_KykSya.kykseiymd,
            qIT_HhknSya.hhknnmkj
            // 未実装
            //, qIT_HhknSya.hhknseiymd
            ) +
            $FROM(qIT_KykSyouhn,
                qIT_KykKihon,
                qIT_AnsyuKihon,
                qIT_KykSya,
                qIT_HhknSya) +
                $WHERE + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
                $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $AND + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_AnsyuKihon.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_KykSya.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_HhknSya.syono)+
                kskJyouken +
                $AND + $(
                    $(qIT_KykSyouhn.kykjyoutai.eq(C_Kykjyoutai.HRKMTYUU) +
                        $AND + qIT_AnsyuKihon.jkipjytym.substring(1, 4).eq(pSyoumeinnd) +
                        $AND + qIT_KykSyouhn.kyktuukasyu.eq(C_Tuukasyu.JPY) +
                        $AND + $(qIT_KykKihon.hrkkaisuu.eq(C_Hrkkaisuu.HALFY) +
                            $OR + qIT_KykKihon.hrkkaisuu.eq(C_Hrkkaisuu.NEN)
                            )
                        ) +
                        $OR + $(qIT_KykSyouhn.kykjyoutai.eq(C_Kykjyoutai.ZENNOU) +
                            $AND + qIT_AnsyuKihon.jkipjytym.eq(BizDateYM.valueOf(pSyoumeinnd + "12")) +
                            $AND + qIT_KykKihon.hrkkaisuu.eq(C_Hrkkaisuu.NEN)
                            )
                    );

        ExDBResults<SinkokuYokokuTuutiSksBean> exDBResults = exDBEntityManager.createJPQL(queryStr, SinkokuYokokuTuutiSksBean.class)
            .bind(qIT_KykSyouhn, qIT_KykKihon, qIT_AnsyuKihon, qIT_KykSya, qIT_HhknSya).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }

    public List<IT_KykUkt> getUketorinin(IT_KykKihon pKykKihon, C_UktsyuKbn pUktsyuKbn) {
        return pKykKihon.getKykUktsByUktsyukbn(pUktsyuKbn);
    }

    public void addInserterEntity(EntityInserter<IT_SinkokuyokokuTuuti> pEntityInserter, IT_SinkokuyokokuTuuti
        pSinkokuyokokuTuuti) {
        pEntityInserter.add(pSinkokuyokokuTuuti);
    }
}
