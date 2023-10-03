package yuyu.batch.suuri.srsuuritoukei.srzitkazukarikinsrrendou;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_AzukarikinKessankanri;
import yuyu.def.db.meta.QIT_AzukarikinKessankanri;

/**
 * 税適預り金数理連動情報作成DAOクラスです。
 */
public class SrZitkAzukarikinSrRendouDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public ExDBResults<IT_AzukarikinKessankanri> getAzukarikinKessankanris(BizDate pKessankijyunymd) {
        QIT_AzukarikinKessankanri qIT_AzukarikinKessankanri = new QIT_AzukarikinKessankanri("qIT_AzukarikinKessankanri");

        String queryStr = $SELECT + qIT_AzukarikinKessankanri +
            $FROM (qIT_AzukarikinKessankanri) +
            $WHERE + qIT_AzukarikinKessankanri.kessankijyunymd.eq(pKessankijyunymd) +
            $AND + qIT_AzukarikinKessankanri.bknjkukbn.eq(C_BknJkuKbn.BLNK) +
            $AND + qIT_AzukarikinKessankanri.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU);

        return exDBEntityManager.createJPQL(queryStr).bind(qIT_AzukarikinKessankanri).getResults();
    }
}