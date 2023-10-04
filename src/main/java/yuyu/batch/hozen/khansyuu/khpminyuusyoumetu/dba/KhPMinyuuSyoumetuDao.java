package yuyu.batch.hozen.khansyuu.khpminyuusyoumetu.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.meta.QIT_AnsyuKihon;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSyouhn;

/**
 * 契約保全 案内収納 P未入消滅処理 の機能DAOクラス
 */
public class KhPMinyuuSyoumetuDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<PMinyuuSyoumetuTaisyouDataBean> getPMinyuuSyoumetuTaisyouDataBean(String pKakutyoujobcd,
        BizDateYM pSyoriYm) {

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QIT_AnsyuKihon qIT_AnsyuKihon = new QIT_AnsyuKihon("qIT_AnsyuKihon");

        String strSql = $SELECT + $NEW(PMinyuuSyoumetuTaisyouDataBean.class ,
            qIT_KykKihon.kbnkey,
            qIT_KykKihon.syono,
            qIT_AnsyuKihon.jkipjytym) +
            $FROM(qIT_KykKihon, qIT_KykSyouhn, qIT_AnsyuKihon) +
            $WHERE + qIT_KykSyouhn.syono.eq(qIT_KykKihon.syono) +
            $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
            $AND + $(qIT_KykSyouhn.kykjyoutai.eq(C_Kykjyoutai.HRKMTYUU) +
                $OR + qIT_KykSyouhn.kykjyoutai.eq(C_Kykjyoutai.IKKATUNK)) +
                $AND  + qIT_AnsyuKihon.syono.eq(qIT_KykKihon.syono) +
                $AND + qIT_AnsyuKihon.jkipjytym.lt(pSyoriYm.addMonths(-2)) +
                $AND + qIT_KykKihon.hrkkaisuu.ne(C_Hrkkaisuu.ITIJI);

        ExDBResults<PMinyuuSyoumetuTaisyouDataBean> exDBResults = exDBEntityManager.createJPQL(strSql, PMinyuuSyoumetuTaisyouDataBean.class).
            bind(qIT_KykKihon, qIT_KykSyouhn, qIT_AnsyuKihon).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}
