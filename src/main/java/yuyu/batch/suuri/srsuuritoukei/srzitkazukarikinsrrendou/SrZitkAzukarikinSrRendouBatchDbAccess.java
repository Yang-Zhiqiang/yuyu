package yuyu.batch.suuri.srsuuritoukei.srzitkazukarikinsrrendou;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.IT_AzukarikinKessankanri;

/**
 * 数理統計 数理統計 税適預り金数理連動情報作成のＤＢアクセスクラス
 */
public class SrZitkAzukarikinSrRendouBatchDbAccess {

    @Inject
    private SrZitkAzukarikinSrRendouDao srZitkAzukarikinSrRendouDao;

    public ExDBResults<IT_AzukarikinKessankanri> getAzukarikinKessankanris(BizDate pKessankijyunymd) {

        ExDBResults<IT_AzukarikinKessankanri> azukarikinKessankanriLst = srZitkAzukarikinSrRendouDao.
            getAzukarikinKessankanris(pKessankijyunymd);

        return azukarikinKessankanriLst;
    }
}