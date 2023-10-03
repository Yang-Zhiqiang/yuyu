package yuyu.batch.suuri.srkessan.srskkessankaikeitorihiki;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.srcommon.SrFindTekiyouCategory;
import yuyu.common.suuri.srcommon.SrFindTekiyouCategoryBean;
import yuyu.def.classification.C_HuridenpageKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KeirisysKbn;
import yuyu.def.classification.C_Srkessankbn;
import yuyu.def.db.entity.ST_SkKessanSyukei;

/**
 * 会計取引ファイル情報クラス
 */
public class SrSkKaikeiTorihikiFileInfo {

    private static final String STRZERO4KETA = "0000";

    private BizDate denYMD;

    private String huriDenAtesakiCd;

    private C_HuridenpageKbn huriDenPageKbn;

    private C_KeirisysKbn keiriSysKbn;

    private String torihikiNo;

    private List<SrSkSiwakeKoumokuInfo> srSkSiwakeKoumokuInfoLst = new ArrayList<>();

    public BizDate getDenYMD() {
        return denYMD;
    }

    public void setDenYMD(BizDate pDenYMD) {
        denYMD = pDenYMD;
    }

    public String getHuriDenAtesakiCd() {
        return huriDenAtesakiCd;
    }

    public void setHuriDenAtesakiCd(String pHuriDenAtesakiCd) {
        huriDenAtesakiCd = pHuriDenAtesakiCd;
    }

    public C_HuridenpageKbn getHuriDenPageKbn() {
        return huriDenPageKbn;
    }

    public void setHuriDenPageKbn(C_HuridenpageKbn pHuriDenPageKbn) {
        huriDenPageKbn = pHuriDenPageKbn;
    }

    public C_KeirisysKbn getKeiriSysKbn() {
        return keiriSysKbn;
    }

    public void setKeiriSysKbn(C_KeirisysKbn pKeiriSysKbn) {
        keiriSysKbn = pKeiriSysKbn;
    }

    public String getTorihikiNo() {
        return torihikiNo;
    }

    public void setTorihikiNo(String pTorihikiNo) {
        torihikiNo = pTorihikiNo;
    }

    public List<SrSkSiwakeKoumokuInfo> getSrSkSiwakeKoumokuInfoLst() {
        return srSkSiwakeKoumokuInfoLst;
    }

    public void setSrSkSiwakeKoumokuInfoLst(List<SrSkSiwakeKoumokuInfo> pSrSkSiwakeKoumokuInfoLst) {
        srSkSiwakeKoumokuInfoLst = pSrSkSiwakeKoumokuInfoLst;
    }

    public void getSiwakeMeisaiAdd(ST_SkKessanSyukei pSkKessanSyukei) {

        for (SrSkSiwakeKoumokuInfo srSkSiwakeKoumokuInfo : srSkSiwakeKoumokuInfoLst) {

            if (srSkSiwakeKoumokuInfo.getDenKanjoKamokuCd().equals(pSkKessanSyukei.getDenkanjokamokucd()) &&
                srSkSiwakeKoumokuInfo.getTaisyaKukbn().eq(pSkKessanSyukei.getTaisyakukbn()) &&
                srSkSiwakeKoumokuInfo.getNaibuKeiyakuKbn().eq(pSkKessanSyukei.getNaibukeiyakukbn()) &&
                srSkSiwakeKoumokuInfo.getTekiyouKbn().eq(pSkKessanSyukei.getTekiyoukbn())) {

                srSkSiwakeKoumokuInfo.setGaku(srSkSiwakeKoumokuInfo.getGaku().add(pSkKessanSyukei.getDenyenkagk()));

                return;
            }
        }

        SrSkSiwakeKoumokuInfo srSkSiwakeKoumokuInfo = SWAKInjector.getInstance(SrSkSiwakeKoumokuInfo.class);

        srSkSiwakeKoumokuInfo.setDenKanjoKamokuCd(pSkKessanSyukei.getDenkanjokamokucd());

        srSkSiwakeKoumokuInfo.setTaisyaKukbn(pSkKessanSyukei.getTaisyakukbn());

        srSkSiwakeKoumokuInfo.setNaibuKeiyakuKbn(pSkKessanSyukei.getNaibukeiyakukbn());

        srSkSiwakeKoumokuInfo.setTekiyouKbn(pSkKessanSyukei.getTekiyoukbn());

        srSkSiwakeKoumokuInfo.setGaku(pSkKessanSyukei.getDenyenkagk());

        SrFindTekiyouCategory srFindTekiyouCategory = SWAKInjector.getInstance(SrFindTekiyouCategory.class);

        SrFindTekiyouCategoryBean srFindTekiyouCategoryBean = srFindTekiyouCategory.getAppropriateTekiyouCom(
            C_Kanjyoukmkcd.valueOf(pSkKessanSyukei.getDenkanjokamokucd()), pSkKessanSyukei.getTekiyoukbn(),
            pSkKessanSyukei.getNaibukeiyakukbn());

        srSkSiwakeKoumokuInfo.setTekiyouCd(srFindTekiyouCategoryBean.getTekiyoucd());

        if (SrCommonConstants.MONTH_JULY == pSkKessanSyukei.getSyoriYmd().getMonth()) {

            srSkSiwakeKoumokuInfo.setKessanKbn((C_Srkessankbn.DAI1Q).getValue());
        }
        else if (SrCommonConstants.MONTH_OCTOBER == pSkKessanSyukei.getSyoriYmd().getMonth()) {

            srSkSiwakeKoumokuInfo.setKessanKbn((C_Srkessankbn.TYUUKAN).getValue());
        }
        else if (SrCommonConstants.MONTH_JANUARY == pSkKessanSyukei.getSyoriYmd().getMonth()) {

            srSkSiwakeKoumokuInfo.setKessanKbn((C_Srkessankbn.DAI3Q).getValue());
        }
        else {

            if (SrCommonConstants.MONTH_MARCH == pSkKessanSyukei.getDenymd().getMonth()) {

                srSkSiwakeKoumokuInfo.setKessanKbn((C_Srkessankbn.NENDOMATU).getValue());
            }
            else {

                srSkSiwakeKoumokuInfo.setKessanKbn((C_Srkessankbn.BLNK).getValue());
            }
        }

        srSkSiwakeKoumokuInfo.setSuitouBumon(pSkKessanSyukei.getHuridenatesakicd() + STRZERO4KETA);

        srSkSiwakeKoumokuInfoLst.add(srSkSiwakeKoumokuInfo);
    }
}
