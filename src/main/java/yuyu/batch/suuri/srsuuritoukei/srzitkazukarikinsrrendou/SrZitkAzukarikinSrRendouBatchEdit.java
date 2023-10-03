package yuyu.batch.suuri.srsuuritoukei.srzitkazukarikinsrrendou;

import java.math.BigDecimal;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.def.db.entity.IT_AzukarikinKessankanri;
import yuyu.def.db.entity.ZT_ZitkAzukarikinSrRendouTy;

/**
 * 数理統計 数理統計 税適預り金数理連動情報作成項目編集クラス
 */
public class SrZitkAzukarikinSrRendouBatchEdit {

    private boolean errorFlg;

    public SrZitkAzukarikinSrRendouBatchEdit() {

        errorFlg = false;
    }

    public boolean editKoumoku(SrZitkAzukarikinSrRendouBatchParam pSrZitkAzukarikinSrRendouBatchParam,
        IT_AzukarikinKessankanri pAzukarikinKessankanri,
        ZT_ZitkAzukarikinSrRendouTy pZitkAzukarikinSrRendouTy) {

        editHeaderData(pSrZitkAzukarikinSrRendouBatchParam,
            pZitkAzukarikinSrRendouTy);

        editZitkAzukarikinSrRendouTyData(pAzukarikinKessankanri,
            pZitkAzukarikinSrRendouTy);

        return errorFlg;
    }

    private void editHeaderData(SrZitkAzukarikinSrRendouBatchParam pSrZitkAzukarikinSrRendouBatchParam,
        ZT_ZitkAzukarikinSrRendouTy pZitkAzukarikinSrRendouTy) {

        int keyKoumoku = pSrZitkAzukarikinSrRendouBatchParam.getSyoriKensu();
        pSrZitkAzukarikinSrRendouBatchParam.setSyoriKensu(pSrZitkAzukarikinSrRendouBatchParam.getSyoriKensu() + 1);

        pZitkAzukarikinSrRendouTy.setZtysequenceno(keyKoumoku);

    }

    private void editZitkAzukarikinSrRendouTyData(IT_AzukarikinKessankanri pAzukarikinKessankanri,
        ZT_ZitkAzukarikinSrRendouTy pZitkAzukarikinSrRendouTy) {

        int kykymdJigyounendo = 0;
        if (SrCommonConstants.MONTH_APRIL <= pAzukarikinKessankanri.getKykymd().getMonth()) {
            kykymdJigyounendo = pAzukarikinKessankanri.getKykymd().getYear();
        }
        else {
            kykymdJigyounendo = pAzukarikinKessankanri.getKykymd().getYear() - SrCommonConstants.YEAR_1Y ;
        }

        pZitkAzukarikinSrRendouTy.setZtysyono(pAzukarikinKessankanri.getSyono());
        pZitkAzukarikinSrRendouTy.setZtyjynbknkbn(SrCommonConstants.JYNBKNKBN_ZEITEKIJYNBKN);
        pZitkAzukarikinSrRendouTy.setZtykbnkeiriyousegmentcd(pAzukarikinKessankanri.getKbnkeirisegcd().getValue());
        pZitkAzukarikinSrRendouTy.setZtytndmatuzndk(
            new BigDecimal(pAzukarikinKessankanri.getAzukariganrikin().toAdsoluteString()).longValue());
        pZitkAzukarikinSrRendouTy.setZtykeiyakunendo(String.valueOf(kykymdJigyounendo));
        pZitkAzukarikinSrRendouTy.setZtyraysystemhyj(SrCommonConstants.HYOUJI_ARI);
        pZitkAzukarikinSrRendouTy.setZtytndmatuzndkgaika(
            new BigDecimal(pAzukarikinKessankanri.getGaikaazukariganrikin().toAdsoluteString()).longValue());
    }
}