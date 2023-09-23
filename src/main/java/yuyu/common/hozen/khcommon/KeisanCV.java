package yuyu.common.hozen.khcommon;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FiSiyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_FundIndexKihon;
import yuyu.def.db.entity.IT_HengakuUnit;
import yuyu.def.db.entity.IT_HengakuUnitRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 契約保全共通 変額積立金計算クラス
 */
public class KeisanCV {

    private BizCurrency keiyakuTaniCv = null;

    private C_FiSiyouKbn fiSiyouKbn = null;

    private List<CVBean> cvBeanList = null;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    public KeisanCV() {
        super();
    }

    public BizCurrency getCV() {
        return keiyakuTaniCv;
    }

    public C_FiSiyouKbn getFiSiyouKbn() {
        return fiSiyouKbn;
    }

    public List<CVBean> getCVBeanList() {
        return cvBeanList;
    }

    public C_ErrorKbn exec(String pSyoukenNo, BizDate pCalcKijyunYmd, C_Tuukasyu pKeiyakuTuukasyu) {

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pKeiyakuTuukasyu);

        C_ErrorKbn resultKbn = C_ErrorKbn.OK;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyoukenNo);

        List<IT_HengakuUnit> hengakuUnitList = kykKihon.getHengakuUnits();

        if (hengakuUnitList.size() == 0) {

            resultKbn = C_ErrorKbn.ERROR;

            return resultKbn;
        }

        List<CVBean> wkCvBeanList = new ArrayList<>();

        for (IT_HengakuUnit hengakuUnit : hengakuUnitList) {

            C_UmuKbn wkHistoryFlag = null;

            CVBean wkCvBean = SWAKInjector.getInstance(CVBean.class);

            if (BizDateUtil.compareYmd(hengakuUnit.getUnitkouryokuhasseiymd(), pCalcKijyunYmd)
                == BizDateUtil.COMPARE_GREATER) {

                wkHistoryFlag = C_UmuKbn.ARI;
            }
            else {

                wkHistoryFlag = C_UmuKbn.NONE;
            }

            wkCvBean.setUnitFundKbn(hengakuUnit.getUnitfundkbn());

            wkCvBean.setUnitSuu(hengakuUnit.getUnitsuu());

            wkCvBean.setWariAi(hengakuUnit.getFundhaibunwariai());

            wkCvBean.setUnitKouryokuhasseiYmd(hengakuUnit.getUnitkouryokuhasseiymd());

            wkCvBean.setHistoryFlag(wkHistoryFlag);

            wkCvBeanList.add(wkCvBean);
        }

        for (CVBean cvBean : wkCvBeanList) {

            if (C_UmuKbn.ARI.eq(cvBean.getHistoryFlag())) {

                List<IT_HengakuUnitRireki> hengakuUnitRirekiList = hozenDomManager
                    .getHengakuUnitRirekisBySyonoUnitfundkbnCalckijyunymd(pSyoukenNo, cvBean.getUnitFundKbn(),
                        pCalcKijyunYmd);

                if (hengakuUnitRirekiList == null || hengakuUnitRirekiList.size() == 0) {

                    resultKbn = C_ErrorKbn.ERROR;

                    return resultKbn;
                }

                cvBean.setUnitSuu(hengakuUnitRirekiList.get(0).getUnitsuu());

                cvBean.setWariAi(hengakuUnitRirekiList.get(0).getFundhaibunwariai());

                cvBean.setUnitKouryokuhasseiYmd(hengakuUnitRirekiList.get(0).getUnitkouryokuhasseiymd());
            }
        }

        BizCurrency wkKeiyakuTaniCv = BizCurrency.valueOf(0, currencyType);

        C_FiSiyouKbn wkFiSiyouKbn = C_FiSiyouKbn.TJTMATU;

        for (CVBean cvBean : wkCvBeanList) {

            BM_FundIndexKihon fundIndexKihon = bizDomManager.getFundIndexKihon(cvBean.getUnitFundKbn(), pCalcKijyunYmd);

            double fundIndex = 0;

            if (fundIndexKihon != null) {

                fundIndex = fundIndexKihon.getFundindex();
            }
            else {

                BM_FundIndexKihon fundIndexKihonSaisinInfo = bizDomManager.getFundIndexKihon(cvBean.getUnitFundKbn(),
                    pCalcKijyunYmd.getPreviousDay());

                if (fundIndexKihonSaisinInfo != null) {

                    fundIndex = fundIndexKihonSaisinInfo.getFundindex();

                    wkFiSiyouKbn = C_FiSiyouKbn.TJTSI;
                }
                else {

                    resultKbn = C_ErrorKbn.ERROR;

                    return resultKbn;
                }
            }

            BizNumber wkFundBetuTumitatekin = BizNumber.valueOf(fundIndex).multiply(cvBean.getUnitSuu())
                .round(0, RoundingMode.UP);

            BizCurrency fundBetuTumitatekin = BizCurrency.valueOf(new BigDecimal(wkFundBetuTumitatekin.toString()),
                currencyType);

            wkKeiyakuTaniCv = wkKeiyakuTaniCv.add(fundBetuTumitatekin);

            cvBean.setFundIndex(BizNumber.valueOf(fundIndex));

            cvBean.setFundHyoukaYmd(pCalcKijyunYmd);

            cvBean.setFundBetuTumitatekin(fundBetuTumitatekin);
        }

        keiyakuTaniCv = wkKeiyakuTaniCv;

        fiSiyouKbn = wkFiSiyouKbn;

        cvBeanList = wkCvBeanList;

        resultKbn = C_ErrorKbn.OK;

        return resultKbn;
    }
}
