package yuyu.batch.hozen.khinterf.khtmttkinyskcsvfilesks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.meta.QIW_TmttkinYskWk;

/**
 * 契約保全 インターフェイス 積立金予測ＣＳＶファイル作成機能DAOクラス<br />
 */
public class KhTmttkinYskCsvFileSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<KhTmttkinYskWkBean> getKhTmttkinYskWkBeans() {

        QIW_TmttkinYskWk qIW_TmttkinYskWk = new QIW_TmttkinYskWk("qIW_TmttkinYskWk");

        String strSql = $SELECT + $NEW(KhTmttkinYskWkBean.class,
            qIW_TmttkinYskWk.syouhnbunruitmttkinyskkbn,
            qIW_TmttkinYskWk.kyktuukasyu,
            qIW_TmttkinYskWk.kykymd,
            qIW_TmttkinYskWk.kyksjkkktyouseiriritu,
            qIW_TmttkinYskWk.targettkhkumu,
            qIW_TmttkinYskWk.targettkmokuhyouti,
            qIW_TmttkinYskWk.kyktuukap.getTypeFieldName(),
            $SUM + $(qIW_TmttkinYskWk.kyktuukap.getValueFieldName()),
            qIW_TmttkinYskWk.kyktuukatmttkngk.getTypeFieldName(),
            $SUM + $(qIW_TmttkinYskWk.kyktuukatmttkngk.getValueFieldName()),
            qIW_TmttkinYskWk.kyktuukakaiyakuhrgk.getTypeFieldName(),
            $SUM + $(qIW_TmttkinYskWk.kyktuukakaiyakuhrgk.getValueFieldName())) +
            $FROM(qIW_TmttkinYskWk) +
            $GROUP_BY + qIW_TmttkinYskWk.syouhnbunruitmttkinyskkbn + "," +
            qIW_TmttkinYskWk.kyktuukasyu + "," +
            qIW_TmttkinYskWk.kykymd + "," +
            qIW_TmttkinYskWk.kyksjkkktyouseiriritu + "," +
            qIW_TmttkinYskWk.targettkhkumu + "," +
            qIW_TmttkinYskWk.targettkmokuhyouti + "," +
            qIW_TmttkinYskWk.kyktuukap.getTypeFieldName() + "," +
            qIW_TmttkinYskWk.kyktuukatmttkngk.getTypeFieldName() + "," +
            qIW_TmttkinYskWk.kyktuukakaiyakuhrgk.getTypeFieldName() + " " +
            $ORDER_BY(qIW_TmttkinYskWk.syouhnbunruitmttkinyskkbn.asc(),
                qIW_TmttkinYskWk.kyktuukasyu.desc(),
                qIW_TmttkinYskWk.kykymd.asc(),
                qIW_TmttkinYskWk.kyksjkkktyouseiriritu.asc(),
                qIW_TmttkinYskWk.targettkhkumu.asc(),
                qIW_TmttkinYskWk.targettkmokuhyouti.asc());

        return exDBEntityManager.createJPQL(strSql, KhTmttkinYskWkBean.class).bind(qIW_TmttkinYskWk).getResultList();
    }
}
