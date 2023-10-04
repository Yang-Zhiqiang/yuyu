package yuyu.batch.hozen.khinterf.khaeoirekinenhoukoku.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.batch.hozen.khinterf.khaeoirekinenhoukoku.dba.AeoiInfoBean;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_AeoiKekkaKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.meta.QIT_AeoiInfo;
import yuyu.def.db.meta.QIT_AnsyuKihon;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSya;
import yuyu.def.db.meta.QIT_KykSyouhn;

/**
 * 契約保全 インターフェイス ＡＥＯＩ暦年報告抽出機能DAOクラス
 */
public class KhAeoiRekinenHoukokuDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<AeoiInfoBean> getAeoiInfoBeanByKakutyoujobcdAeoikekkakbnAeoikouryokuendymdSyutkkbn(String pKakutyoujobcd,
        C_AeoiKekkaKbn pAeoikekkbn, BizDate pKouryokuendymd, C_SyutkKbn pSyutkkbn) {


        QIT_AeoiInfo qIT_AeoiInfo = new QIT_AeoiInfo("qIT_AeoiInfo");

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");

        QIT_AnsyuKihon qIT_AnsyuKihon = new QIT_AnsyuKihon("qIT_AnsyuKihon");

        String mainStry = $SELECT + qIT_AeoiInfo + "," +
            qIT_KykKihon + "," +
            qIT_KykSyouhn + "," +
            qIT_KykSya + "," +
            qIT_AnsyuKihon +
            $FROM + qIT_AeoiInfo.IT_AeoiInfo() + "," +
            qIT_KykKihon.IT_KykKihon() + "," +
            qIT_KykSyouhn.IT_KykSyouhn() + "," +
            qIT_KykSya.IT_KykSya()  + "," +
            qIT_AnsyuKihon.IT_AnsyuKihon()  +
            $WHERE + qIT_AeoiInfo.aeoikekkakbn.eq(pAeoikekkbn) +
            $AND + "(" + qIT_AeoiInfo.aeoikouryokuendymd.gt(pKouryokuendymd) +
            $OR  +  qIT_AeoiInfo.aeoikouryokuendymd.isNull() + ")" +
            $AND + qIT_AeoiInfo.syono.eq(qIT_KykSyouhn.syono) +
            $AND + qIT_KykSyouhn.syutkkbn.eq(pSyutkkbn) +
            $AND + qIT_AeoiInfo.syono.eq(qIT_KykKihon.syono) +
            $AND + qIT_AeoiInfo.syono.eq(qIT_KykSya.syono) +
            $AND + qIT_AeoiInfo.syono.eq(qIT_AnsyuKihon.syono);
        ExDBResults<AeoiInfoBean> exDBResults =
            exDBEntityManager.createJPQL(mainStry).bind(qIT_AeoiInfo, qIT_KykKihon, qIT_KykSyouhn, qIT_KykSya, qIT_AnsyuKihon)
            .getResults(AeoiInfoBean.class);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}
