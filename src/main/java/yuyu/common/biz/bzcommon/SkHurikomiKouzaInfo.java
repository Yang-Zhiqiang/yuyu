package yuyu.common.biz.bzcommon;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import jp.co.slcs.swak.util.string.StringUtil;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import yuyu.def.classification.C_HrkmirninEditPtnKbn;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.classification.C_TaisyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HM_HurikomiKouza;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 業務共通 共通 新契約振込口座情報取得
 */
public class SkHurikomiKouzaInfo {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private static Logger logger;

    private static final String HANKAKUSPACE = " ";

    private static final String ZENKAKUSPACE  = "　";

    private static final String BLANK  = "";

    public SkHurikomiKouzaInfo() {
        super();
    }

    public SkHurikomiKouzaInfoBean getHurikomiInfoYen(SkHurikomiKouzaInfoBean pSkHurikomiKouzaInfoBean) {

        logger.debug("▽ 振込情報取得（円貨） 開始");

        List<HM_HurikomiKouza> hurikomiKouzaList =
            sinkeiyakuDomManager.getHurikomiKouzasByBankcdSitencdKouzanoTuukasyuYokinkbn(
                pSkHurikomiKouzaInfoBean.getBankCd(),
                pSkHurikomiKouzaInfoBean.getSitenCd(),
                pSkHurikomiKouzaInfoBean.getKouzaNo(),
                C_Tuukasyu.JPY,
                pSkHurikomiKouzaInfoBean.getYokinKbn());

        HM_HurikomiKouza hurikomiKouza = null;

        if (hurikomiKouzaList.size() == 1) {
            hurikomiKouza = hurikomiKouzaList.get(0);

        }
        else if (hurikomiKouzaList.size() > 1) {
            for (int i = 0; i < hurikomiKouzaList.size(); i++) {
                if (pSkHurikomiKouzaInfoBean.getHrkmirninCd().equals(hurikomiKouzaList.get(i).getHrkmirnincd())) {

                    hurikomiKouza = hurikomiKouzaList.get(i);
                    break;
                }
            }

        }

        if (hurikomiKouza == null) {
            pSkHurikomiKouzaInfoBean.setMosno("");
            pSkHurikomiKouzaInfoBean.setSyouhnNo("");
            pSkHurikomiKouzaInfoBean.setHrkmirninNmKana(StringUtil.lrTrim(pSkHurikomiKouzaInfoBean.getHrkmirninNm()));
            pSkHurikomiKouzaInfoBean.setOyadrtenCd("");
            pSkHurikomiKouzaInfoBean.setNyuukinOyadrtenNm("");
            pSkHurikomiKouzaInfoBean.setJidonyknTargetHyouji(C_TaisyouKbn.TAISYOU);
            pSkHurikomiKouzaInfoBean.setOyadrtenSyoriTarget(C_TaisyouKbn.HITAISYOU);
            pSkHurikomiKouzaInfoBean.setSiteiTuuka(C_Tuukasyu.BLNK);
            pSkHurikomiKouzaInfoBean.setHonkouzaCd("");
            pSkHurikomiKouzaInfoBean.setNyktyhyoutKbn(C_NyktyhyoutKbn.NONE);
        }
        else {
            pSkHurikomiKouzaInfoBean.setOyadrtenCd(hurikomiKouza.getOyadrtencd());
            pSkHurikomiKouzaInfoBean.setNyuukinOyadrtenNm(hurikomiKouza.getNyuukinoyadrtennm());
            pSkHurikomiKouzaInfoBean.setJidonyknTargetHyouji(hurikomiKouza.getJidonykntargethyouji());
            pSkHurikomiKouzaInfoBean.setOyadrtenSyoriTarget(hurikomiKouza.getOyadrtensyoritarget());
            pSkHurikomiKouzaInfoBean.setSiteiTuuka(hurikomiKouza.getSiteituuka());
            pSkHurikomiKouzaInfoBean.setHonkouzaCd(hurikomiKouza.getHonkouzacd());
            pSkHurikomiKouzaInfoBean.setNyktyhyoutKbn(hurikomiKouza.getNyktyhyoutkbn());

            String hrkmirninnm = pSkHurikomiKouzaInfoBean.getHrkmirninNm();
            String hrkmirninnm1_9 = editString(hrkmirninnm, 1, 9);
            String hrkmirninnm10 = editString(hrkmirninnm, 10, 10);

            if (StringUtils.isNumeric(hrkmirninnm1_9) && hrkmirninnm1_9.length() == 9
                && ((hrkmirninnm.length() >= 10 && (BizUtil.isBlank(hrkmirninnm10) || !StringUtils.isNumeric(hrkmirninnm10)))
                    || hrkmirninnm.length() < 10)) {

                String hrkmirninnmKana = getHrkmirninnmKn(hrkmirninnm);

                pSkHurikomiKouzaInfoBean.setSyouhnNo("");
                pSkHurikomiKouzaInfoBean.setMosno(hrkmirninnm1_9);
                pSkHurikomiKouzaInfoBean.setHrkmirninNmKana(hrkmirninnmKana);

            }
            else if (C_HrkmirninEditPtnKbn.HYOUJYUN.eq(hurikomiKouza.getHrkmirnineditptnkbn())) {

                String syouhnno = editString(hrkmirninnm, 1, 2);
                String mosno = getMosnoByHrkmirninnm(hrkmirninnm);
                String hrkmirninnmKana = getHrkmirninnmKn(hrkmirninnm);

                pSkHurikomiKouzaInfoBean.setMosno(mosno);
                pSkHurikomiKouzaInfoBean.setSyouhnNo(syouhnno);
                pSkHurikomiKouzaInfoBean.setHrkmirninNmKana(hrkmirninnmKana);

            }
            else if (C_HrkmirninEditPtnKbn.HRKMIRNINKETUGOU.eq(hurikomiKouza.getHrkmirnineditptnkbn())) {

                String hrkmirnincd = pSkHurikomiKouzaInfoBean.getHrkmirninCd();

                String syouhnno = editString(hrkmirnincd, 1, 2);
                String mosno = getMosnoByHrkmirninnm(hrkmirninnm);

                if(StringUtil.isNullOrBlank(mosno)){
                    String hrkmirninnm1 = editString(hrkmirninnm, 1, 1);
                    if(!StringUtil.isNullOrBlank(hrkmirninnm1) && StringUtils.isNumeric(hrkmirninnm1)){
                        String hrkmirnincd3_10 = editString(hrkmirnincd,3,10);
                        if(hrkmirnincd3_10.length() == 8 && StringUtils.isNumeric(hrkmirnincd3_10)){
                            mosno = hrkmirnincd3_10 + hrkmirninnm1;
                        }
                    }else{
                        String hrkmirnincdBlank = kuuhakuJyokyo(hrkmirnincd);
                        if(hrkmirnincdBlank.length() - 9 >= 0){
                            String hrkmirnincd9 = editString(hrkmirnincd,hrkmirnincdBlank.length() - 8, hrkmirnincdBlank.length());
                            if(StringUtils.isNumeric(hrkmirnincd9)){
                                mosno = hrkmirnincd9;
                            }
                        }
                    }
                }

                String hrkmirninnmKana = getHrkmirninnmKn(hrkmirninnm);

                pSkHurikomiKouzaInfoBean.setMosno(mosno);
                pSkHurikomiKouzaInfoBean.setSyouhnNo(syouhnno);
                pSkHurikomiKouzaInfoBean.setHrkmirninNmKana(hrkmirninnmKana);

            }
            else {

                pSkHurikomiKouzaInfoBean.setMosno("");
                pSkHurikomiKouzaInfoBean.setSyouhnNo("");
                pSkHurikomiKouzaInfoBean.setHrkmirninNmKana(StringUtil.lrTrim(pSkHurikomiKouzaInfoBean.getHrkmirninNm()));

            }
        }

        logger.debug("△ 振込情報取得（円貨） 終了");

        return pSkHurikomiKouzaInfoBean;
    }

    public SkHurikomiKouzaInfoBean getHurikomiInfoGaika(SkHurikomiKouzaInfoBean pSkHurikomiKouzaInfoBean) {

        logger.debug("▽ 振込情報取得（外貨） 開始");

        List<HM_HurikomiKouza> hurikomiKouzaList =
            sinkeiyakuDomManager.getHurikomiKouzasByBankcdSitencdKouzanoTuukasyu(
                pSkHurikomiKouzaInfoBean.getBankCd(),
                pSkHurikomiKouzaInfoBean.getSitenCd(),
                pSkHurikomiKouzaInfoBean.getKouzaNo(),
                pSkHurikomiKouzaInfoBean.getTuukasyu());

        if (hurikomiKouzaList.size() != 1) {

            if(hurikomiKouzaList.size() > 0){
                pSkHurikomiKouzaInfoBean.setKouzaNo(hurikomiKouzaList.get(0).getKouzano());
            }
            pSkHurikomiKouzaInfoBean.setMosno("");
            pSkHurikomiKouzaInfoBean.setSyouhnNo("");
            pSkHurikomiKouzaInfoBean.setHrkmirninNmKana(StringUtil.lrTrim(pSkHurikomiKouzaInfoBean.getHrkmirninNm()));
            pSkHurikomiKouzaInfoBean.setOyadrtenCd("");
            pSkHurikomiKouzaInfoBean.setNyuukinOyadrtenNm("");
            pSkHurikomiKouzaInfoBean.setJidonyknTargetHyouji(C_TaisyouKbn.TAISYOU);
            pSkHurikomiKouzaInfoBean.setOyadrtenSyoriTarget(C_TaisyouKbn.HITAISYOU);
            pSkHurikomiKouzaInfoBean.setSiteiTuuka(C_Tuukasyu.BLNK);
            pSkHurikomiKouzaInfoBean.setHonkouzaCd("");

        }
        else {
            pSkHurikomiKouzaInfoBean.setKouzaNo(hurikomiKouzaList.get(0).getKouzano());
            pSkHurikomiKouzaInfoBean.setOyadrtenCd(hurikomiKouzaList.get(0).getOyadrtencd());
            pSkHurikomiKouzaInfoBean.setNyuukinOyadrtenNm(hurikomiKouzaList.get(0).getNyuukinoyadrtennm());
            pSkHurikomiKouzaInfoBean.setJidonyknTargetHyouji(hurikomiKouzaList.get(0).getJidonykntargethyouji());
            pSkHurikomiKouzaInfoBean.setOyadrtenSyoriTarget(hurikomiKouzaList.get(0).getOyadrtensyoritarget());
            pSkHurikomiKouzaInfoBean.setSiteiTuuka(hurikomiKouzaList.get(0).getSiteituuka());
            pSkHurikomiKouzaInfoBean.setHonkouzaCd(hurikomiKouzaList.get(0).getHonkouzacd());

            String hrkmirninnm = pSkHurikomiKouzaInfoBean.getHrkmirninNm();
            String hrkmirninnm1_9 = editString(hrkmirninnm, 1, 9);
            String hrkmirninnm10 = editString(hrkmirninnm, 10, 10);

            if (StringUtils.isNumeric(hrkmirninnm1_9) && hrkmirninnm1_9.length() == 9
                && ((hrkmirninnm.length() >= 10 && (BizUtil.isBlank(hrkmirninnm10) || !StringUtils.isNumeric(hrkmirninnm10)))
                    || hrkmirninnm.length() < 10)) {

                String hrkmirninNmKana = editString(hrkmirninnm, 10, hrkmirninnm.length());
                pSkHurikomiKouzaInfoBean.setSyouhnNo("");
                pSkHurikomiKouzaInfoBean.setMosno(hrkmirninnm1_9);
                pSkHurikomiKouzaInfoBean.setHrkmirninNmKana(hrkmirninNmKana);

            }
            else if (C_HrkmirninEditPtnKbn.HYOUJYUN.eq(hurikomiKouzaList.get(0).getHrkmirnineditptnkbn())) {

                String syouhnno = editString(hrkmirninnm, 1, 2);
                String mosno = getMosnoByHrkmirninnm(hrkmirninnm);
                String hrkmirninnmKana = editString(hrkmirninnm, 12, hrkmirninnm.length());

                pSkHurikomiKouzaInfoBean.setMosno(mosno);
                pSkHurikomiKouzaInfoBean.setSyouhnNo(syouhnno);
                pSkHurikomiKouzaInfoBean.setHrkmirninNmKana(hrkmirninnmKana);

            }
            else {

                pSkHurikomiKouzaInfoBean.setMosno("");
                pSkHurikomiKouzaInfoBean.setSyouhnNo("");
                pSkHurikomiKouzaInfoBean.setHrkmirninNmKana(StringUtil.lrTrim(pSkHurikomiKouzaInfoBean.getHrkmirninNm()));

            }
        }

        logger.debug("△ 振込情報取得（外貨） 終了");

        return pSkHurikomiKouzaInfoBean;
    }

    private String editString(String pEditMaeString, int pBeginIndex, int pEndIndex) {

        String editMaeString = pEditMaeString;

        String editAtoString = "";

        if (editMaeString.length() == 0 || editMaeString.length() < pBeginIndex) {

            editAtoString = "";

        }
        else if (editMaeString.length() < pEndIndex){

            editAtoString = StringUtil.lrTrim(editMaeString.substring(pBeginIndex - 1, editMaeString.length()));

        }
        else {

            editAtoString = StringUtil.lrTrim(editMaeString.substring(pBeginIndex - 1, pEndIndex));
        }

        return editAtoString;
    }

    private String getMosnoByHrkmirninnm(String pHrkmirninnm){
        String mosno ="";

        String hrkmirninnm3_11 = editString(pHrkmirninnm, 3, 11);

        if(StringUtils.isNumeric(hrkmirninnm3_11)){
            if(hrkmirninnm3_11.length() == 9){
                String hrkmirninnm12 = editString(pHrkmirninnm, 12, 12);
                if(StringUtil.isNullOrBlank(hrkmirninnm12) || !StringUtils.isNumeric(hrkmirninnm12)){
                    mosno = hrkmirninnm3_11;
                }
            }
        }
        return mosno;
    }

    private String getHrkmirninnmKn (String pHrkmirninnm){
        String hrkmirninnmKn ="";

        Pattern pattern = Pattern.compile("([^0-9]+)$");
        Matcher matcher = pattern.matcher(pHrkmirninnm);

        if(matcher.find()){
            hrkmirninnmKn = StringUtil.lrTrim(matcher.group(1));
        }

        return hrkmirninnmKn;
    }

    private String kuuhakuJyokyo(String pSiteiMojiretu) {
        String henkanKekka = pSiteiMojiretu;
        henkanKekka = henkanKekka.replaceAll(HANKAKUSPACE, BLANK);
        henkanKekka = henkanKekka.replaceAll(ZENKAKUSPACE, BLANK);

        return henkanKekka;
    }
}
