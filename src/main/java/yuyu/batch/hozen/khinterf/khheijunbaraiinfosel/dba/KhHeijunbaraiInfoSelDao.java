package yuyu.batch.hozen.khinterf.khheijunbaraiinfosel.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.meta.QIT_AnsyuKihon;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QIW_KhKzkPYokuJyuutouYoteiWk;

/**
 * 契約保全 インターフェイス 平準払情報抽出DAOクラス
 */
public class KhHeijunbaraiInfoSelDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<HeijunbaraiInfoBean> getHeijunbaraiInfoByKakutyoujobcdTysytkijyunkykymd(String pKakutyoujobcd,
        BizDate pKijyunKykymd) {

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QIT_AnsyuKihon qIT_AnsyuKihon = new QIT_AnsyuKihon("qIT_AnsyuKihon");

        String strSql = $SELECT + qIT_KykKihon + "," + qIT_AnsyuKihon +
            $FROM(qIT_KykKihon, qIT_KykSyouhn, qIT_AnsyuKihon) +
            $WHERE + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
            $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
            $AND + qIT_KykSyouhn.kykymd.le(pKijyunKykymd) +
            $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
            $AND + qIT_KykSyouhn.kykjyoutai.ne(C_Kykjyoutai.ITIJIBARAI) +
            $AND + qIT_KykKihon.syono.eq(qIT_AnsyuKihon.syono);

        ExDBResults<HeijunbaraiInfoBean> exDBResults = exDBEntityManager.createJPQL(strSql).bind(qIT_KykKihon, qIT_KykSyouhn, qIT_AnsyuKihon)
            .getResults(HeijunbaraiInfoBean.class);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public void deleteKhKzkPYokuJyuutouYoteiWk() {

        QIW_KhKzkPYokuJyuutouYoteiWk qIW_KhKzkPYokuJyuutouYoteiWk = new QIW_KhKzkPYokuJyuutouYoteiWk();

        String strSql = $DELETE_FROM(qIW_KhKzkPYokuJyuutouYoteiWk);

        exDBEntityManager.createJPQL(strSql).bind(qIW_KhKzkPYokuJyuutouYoteiWk).executeUpdate();
    }
}
