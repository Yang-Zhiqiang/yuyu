package yuyu.batch.hozen.khinterf.khuriageseikyuukekkafiletrkm.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.meta.QIT_KhUriageSeikyuuKekkaData;
import yuyu.def.db.meta.QZT_UriageKekkaTr;

/**
 * 契約保全 インターフェイス 売上請求結果F取込機能DAOクラスです。
 */
public class KhUriageSeikyuuKekkaFileTrkmDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhUriageKekkaDataBean> getKhUriageKekkaDataBeans(String pKakutyouJobCd) {

        QZT_UriageKekkaTr qZT_UriageKekkaTr = new QZT_UriageKekkaTr("qZT_UriageKekkaTr");

        String sql = $SELECT + $NEW(KhUriageKekkaDataBean.class,
            qZT_UriageKekkaTr.ztrrecordkbn,
            qZT_UriageKekkaTr.ztrauthorikbn,
            qZT_UriageKekkaTr.ztruriageseikyuutorihikicd,
            qZT_UriageKekkaTr.ztruriagetaisyouym,
            qZT_UriageKekkaTr.ztruriageymd6keta,
            qZT_UriageKekkaTr.ztrcreditkigyoucd,
            qZT_UriageKekkaTr.ztrcreditkessaiyouno,
            qZT_UriageKekkaTr.ztrsyono,
            qZT_UriageKekkaTr.ztrrecordno,
            qZT_UriageKekkaTr.ztrcardyuukoukigen,
            qZT_UriageKekkaTr.ztrseikyuukngk,
            qZT_UriageKekkaTr.ztrcreditkaiinnokami6keta,
            qZT_UriageKekkaTr.ztrcreditkaiinnosimo4keta,
            qZT_UriageKekkaTr.ztruriageseikyuuerrorcd,
            qZT_UriageKekkaTr.ztrhurikaekekkacd,
            qZT_UriageKekkaTr.ztrfukusuukameitennokey) +
            $FROM(qZT_UriageKekkaTr) +
            $ORDER_BY(qZT_UriageKekkaTr.ztrsyono.asc(),
                qZT_UriageKekkaTr.ztrcreditkessaiyouno.asc(),
                qZT_UriageKekkaTr.ztruriageymd6keta.asc(),
                qZT_UriageKekkaTr.ztruriagetaisyouym.asc());

        ExDBResults<KhUriageKekkaDataBean> exDBResults = exDBEntityManager.createJPQL(sql,
            KhUriageKekkaDataBean.class).bind(qZT_UriageKekkaTr).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }

    public void deleteKhUriageSeikyuuKekkaData() {

        QIT_KhUriageSeikyuuKekkaData qIT_KhUriageSeikyuuKekkaData = new QIT_KhUriageSeikyuuKekkaData(
            "qIT_KhUriageSeikyuuKekkaData");

        String strSql = $DELETE_FROM(qIT_KhUriageSeikyuuKekkaData);

        exDBEntityManager.createJPQL(strSql).bind(qIT_KhUriageSeikyuuKekkaData).executeUpdate();
    }


}
