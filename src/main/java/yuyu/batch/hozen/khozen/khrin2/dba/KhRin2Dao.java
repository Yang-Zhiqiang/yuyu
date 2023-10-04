package yuyu.batch.hozen.khozen.khrin2.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSonotaTkyk;
import yuyu.def.db.meta.QIT_KykSyouhn;

/**
 * 契約保全 契約保全 契約保全臨時処理２ 機能DAOクラス
 */
public class KhRin2Dao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<IT_KykKihon> getKhTusanIdouTaisyous() {

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        QIT_KykSonotaTkyk qIT_KykSonotaTkyk = new QIT_KykSonotaTkyk("qIT_KykSonotaTkyk");

        String mainSql =
            $SELECT + qIT_KykKihon +
            $FROM(qIT_KykKihon ,
                qIT_KykSyouhn ,
                qIT_KykSonotaTkyk) +
                $WHERE + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_KykSonotaTkyk.syono) +
                $AND + qIT_KykKihon.seirituymd.lt(BizDate.valueOf("20190325")) +
                $AND + qIT_KykSyouhn.syouhncd.in("ﾕｹ", "ﾕｺ", "ﾕｻ", "ﾕｼ", "ﾕｽ", "ﾕｾ", "ﾕｿ", "ﾕﾀ") +
                $AND + qIT_KykSonotaTkyk.yennykntkhkumu.eq(C_UmuKbn.ARI);

        ExDBResults<IT_KykKihon> exDBResults =
            exDBEntityManager.createJPQL(mainSql).bind(qIT_KykKihon,qIT_KykSyouhn,qIT_KykSonotaTkyk).getResults();

        return exDBResults;
    }
}
