package yuyu.batch.hozen.khinterf.khkzkpyokujyuutouyoteicsvsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.meta.QIW_KhKzkPYokuJyuutouYoteiWk;

/**
 * 契約保全 インターフェイス 継続Ｐ翌月充当予定ＣＳＶ作成DAOクラス
 */
public class KhKzkPYokuJyuutouYoteiCsvSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhKzkPYokuJyuutouYoteiWkBean> getKhKzkPYokuJyuutouYoteiCsvSksWkOrderByKykTuukaSyuKykYmHknKkn() {

        QIW_KhKzkPYokuJyuutouYoteiWk qIW_KhKzkPYokuJyuutouYoteiWk = new QIW_KhKzkPYokuJyuutouYoteiWk("qIW_KhKzkPYokuJyuutouYoteiWk");

        String strSql = $SELECT + $NEW(KhKzkPYokuJyuutouYoteiWkBean.class,
            qIW_KhKzkPYokuJyuutouYoteiWk.kyktuukasyu,
            qIW_KhKzkPYokuJyuutouYoteiWk.kykym,
            qIW_KhKzkPYokuJyuutouYoteiWk.jyuutouym,
            qIW_KhKzkPYokuJyuutouYoteiWk.hknkkn,
            qIW_KhKzkPYokuJyuutouYoteiWk.hokenryou.getTypeFieldName(),
            $SUM + $(qIW_KhKzkPYokuJyuutouYoteiWk.hokenryou.getValueFieldName()))
            +
            $FROM(qIW_KhKzkPYokuJyuutouYoteiWk) +
            $GROUP_BY + qIW_KhKzkPYokuJyuutouYoteiWk.kyktuukasyu + "," +
            qIW_KhKzkPYokuJyuutouYoteiWk.kykym + "," +
            qIW_KhKzkPYokuJyuutouYoteiWk.jyuutouym + "," +
            qIW_KhKzkPYokuJyuutouYoteiWk.hknkkn + "," +
            qIW_KhKzkPYokuJyuutouYoteiWk.hokenryou.getTypeFieldName()  +
            $ORDER_BY(qIW_KhKzkPYokuJyuutouYoteiWk.kyktuukasyu.asc(),
                qIW_KhKzkPYokuJyuutouYoteiWk.kykym.asc(),
                qIW_KhKzkPYokuJyuutouYoteiWk.hknkkn.asc());

        ExDBResults<KhKzkPYokuJyuutouYoteiWkBean> exDBResults = exDBEntityManager.createJPQL(strSql, KhKzkPYokuJyuutouYoteiWkBean.class)
            .bind(qIW_KhKzkPYokuJyuutouYoteiWk).getResults();

        return exDBResults;
    }
}