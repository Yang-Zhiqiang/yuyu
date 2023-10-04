package yuyu.batch.sinkeiyaku.sknyuukin.skcredittourokuerrorlistsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.meta.QHW_CreditTrkHaneierrList;
import yuyu.def.db.meta.QHW_CreditTrkNgList;

/**
 * 新契約 入金 クレジットカード登録エラーリスト作成の機能DAOクラスです。
 */
public class SkCreditTourokuErrorlistSksDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public ExDBResults<SkCreditTrkHaneierrListBean> getCreditTrkHaneierrListBeans () {

        QHW_CreditTrkHaneierrList qHW_CreditTrkHaneierrList =
            new QHW_CreditTrkHaneierrList("qHW_CreditTrkHaneierrList");

        String strSql = $SELECT + $NEW(SkCreditTrkHaneierrListBean.class,
            qHW_CreditTrkHaneierrList.tyouhyouymd,
            qHW_CreditTrkHaneierrList.datarenno,
            qHW_CreditTrkHaneierrList.mosno,
            qHW_CreditTrkHaneierrList.credittrkhoukbn,
            qHW_CreditTrkHaneierrList.sosikicd,
            qHW_CreditTrkHaneierrList.creditkessaiyouno,
            qHW_CreditTrkHaneierrList.credittrkhaneierrriyuu
            ) +
            $FROM(qHW_CreditTrkHaneierrList) +
            $ORDER_BY(qHW_CreditTrkHaneierrList.credittrkhoukbn.asc(),
                qHW_CreditTrkHaneierrList.sosikicd.asc(),
                qHW_CreditTrkHaneierrList.mosno.asc());

        ExDBResults<SkCreditTrkHaneierrListBean> exDBResults = exDBEntityManager.createJPQL(strSql,
            SkCreditTrkHaneierrListBean.class).bind(qHW_CreditTrkHaneierrList).getResults();

        return exDBResults;
    }

    public ExDBResults<SkCreditTrkNgListBean> getCreditTrkNgListBeans () {

        QHW_CreditTrkNgList qHW_CreditTrkNgList = new QHW_CreditTrkNgList("qHW_CreditTrkNgList");

        String strSql = $SELECT + $NEW(SkCreditTrkNgListBean.class,
            qHW_CreditTrkNgList.tyouhyouymd,
            qHW_CreditTrkNgList.datarenno,
            qHW_CreditTrkNgList.mosno,
            qHW_CreditTrkNgList.creditkessaiyouno,
            qHW_CreditTrkNgList.creditqrerrorcd,
            qHW_CreditTrkNgList.bluegateerrorcd,
            qHW_CreditTrkNgList.dbhaneikbn,
            qHW_CreditTrkNgList.credittrkhaneierrriyuu
            ) +
            $FROM(qHW_CreditTrkNgList) +
            $ORDER_BY(qHW_CreditTrkNgList.mosno.asc());

        ExDBResults<SkCreditTrkNgListBean> exDBResults = exDBEntityManager.createJPQL(strSql,
            SkCreditTrkNgListBean.class).bind(qHW_CreditTrkNgList).getResults();

        return exDBResults;
    }
}
