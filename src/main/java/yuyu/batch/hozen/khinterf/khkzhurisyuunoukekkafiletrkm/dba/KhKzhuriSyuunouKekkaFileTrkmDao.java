package yuyu.batch.hozen.khinterf.khkzhurisyuunoukekkafiletrkm.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.entity.IT_KhSyuunouKekkaData;
import yuyu.def.db.meta.QIT_KhSyuunouKekkaData;
import yuyu.def.db.meta.QZT_KzhuriSyuunouKekkaTr;

/**
 * 契約保全 インターフェイス 口座振替収納結果Ｆ取込機能DAO
 */
public class KhKzhuriSyuunouKekkaFileTrkmDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KzhuriSyuunouKekkaDataBean> getKzhuriSyuunouKekkaDataBeans(String pKakutyoujobcd) {

        QZT_KzhuriSyuunouKekkaTr qZT_KzhuriSyuunouKekkaTr = new QZT_KzhuriSyuunouKekkaTr("qZT_KzhuriSyuunouKekkaTr");

        String strSql = $SELECT + $NEW(KzhuriSyuunouKekkaDataBean.class,
            qZT_KzhuriSyuunouKekkaTr.ztrsyono,
            qZT_KzhuriSyuunouKekkaTr.ztrkzhurikaebankcd,
            qZT_KzhuriSyuunouKekkaTr.ztrkzhurikaesitencd,
            qZT_KzhuriSyuunouKekkaTr.ztrkzhurikaeyokinkbn,
            qZT_KzhuriSyuunouKekkaTr.ztrkzhurikaekouzano,
            qZT_KzhuriSyuunouKekkaTr.ztrrsgaku,
            qZT_KzhuriSyuunouKekkaTr.ztrjyuutouym,
            qZT_KzhuriSyuunouKekkaTr.ztrjyuutounensuu,
            qZT_KzhuriSyuunouKekkaTr.ztrjyuutoutukisuu,
            qZT_KzhuriSyuunouKekkaTr.ztrhurikaekekkakbn,
            qZT_KzhuriSyuunouKekkaTr.ztrhurikaeymd,
            qZT_KzhuriSyuunouKekkaTr.ztrdantaikobetukbn,
            qZT_KzhuriSyuunouKekkaTr.ztrnyknaiyoukbn,
            qZT_KzhuriSyuunouKekkaTr.ztrhrkkaisuukbn,
            qZT_KzhuriSyuunouKekkaTr.ztrkzhurikaetkbtannaihyj,
            qZT_KzhuriSyuunouKekkaTr.ztrkzhurisyuudaikokbn) +
            $FROM(qZT_KzhuriSyuunouKekkaTr);

        ExDBResults<KzhuriSyuunouKekkaDataBean> exDBResults = exDBEntityManager
            .createJPQL(strSql, KzhuriSyuunouKekkaDataBean.class)
            .bind(qZT_KzhuriSyuunouKekkaTr).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public void addInsertEntity(EntityInserter<IT_KhSyuunouKekkaData> pEntityInserter,
        IT_KhSyuunouKekkaData pKhSyuunouKekkaData) {

        pEntityInserter.add(pKhSyuunouKekkaData);
    }
    public int deleteKhSyuunouKekkaData() {

        QIT_KhSyuunouKekkaData qIT_KhSyuunouKekkaData = new QIT_KhSyuunouKekkaData("q");

        String strSql = $DELETE_FROM(qIT_KhSyuunouKekkaData);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhSyuunouKekkaData).executeUpdate();
    }

}
