package yuyu.batch.biz.bzmaster.bzdairitenitakutorikomi;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.meta.QBT_DairitenItakuSyouhn;

/**
 * 業務共通 マスタ取込 マスタ取込（代理店委託商品情報テーブル）DAOクラスです。
 */
public class BzDairitenItakuTorikomiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public void deleteDairitenItakuSyouhn() {

        QBT_DairitenItakuSyouhn qBT_DairitenItakuSyouhn = new QBT_DairitenItakuSyouhn("qBT_DairitenItakuSyouhn");

        String strSql = $DELETE_FROM(qBT_DairitenItakuSyouhn);

        exDBEntityManager.createJPQL(strSql).bind(qBT_DairitenItakuSyouhn).executeUpdate();
    }
}
