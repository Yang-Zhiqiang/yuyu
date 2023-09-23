package yuyu.common.hozen.haitou;

import javax.inject.Inject;

import org.slf4j.Logger;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.number.BizCurrency;
import lombok.Getter;
import lombok.Setter;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.suuri.srcommon.EditDshrTukiDKoumokuBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 配当 配当共通計算（円建変更）
 */
public class KeisanDCommonYendtHnk extends KeisanDCommon {

    private BizCurrency kariwariatedruigk;

    private BizCurrency tumitated;

    private BizDateY haitouNendo;

    @Inject
    private static Logger logger;

    private NrkKmkYendtHnkNaibuBean nrkKmkYendtHnkNaibuBean;

    public C_ErrorKbn calcDkngk(String pSyono, BizDate pCalckijyunymd, BizDate pDratekjymd, BizDate pSyoriYmd) {

        logger.debug("▽ 配当共通計算（円建変更） 配当金額計算 開始");

        clear();
        kariwariatedruigk = null;
        tumitated = null;
        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        final boolean collectEntityFlg = getCollectEntityFlg();

        setNrkKmk(pSyono, pCalckijyunymd, pDratekjymd, pSyoriYmd);

        try {
            if (BizUtil.isBlank(pSyono) || pCalckijyunymd == null || pDratekjymd == null || pSyoriYmd == null) {

                errorKbn = C_ErrorKbn.ERROR;

                setErrorInfo(ERRORCODE001);

                logger.debug("△ 配当共通計算（円建変更） 配当金額計算 終了");

                return errorKbn;
            }

            errorKbn = calcD(pSyono, pDratekjymd, pCalckijyunymd, pSyoriYmd, C_UmuKbn.NONE);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                logger.debug("△ 配当共通計算（円建変更） 配当金額計算 終了");

                return errorKbn;
            }

            errorKbn = calcKariwariateDGanrikin(pSyono, pCalckijyunymd);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                logger.debug("△ 配当共通計算（円建変更） 配当金額計算 終了");

                return errorKbn;
            }
            if (C_NaiteiKakuteiKbn.KAKUTEI.eq(getDNaiteiKakuteiKbn())) {
                if (getKhHaitouKanriNaiteiKakuteiKbn() != null && C_NaiteiKakuteiKbn.NAITEI.eq(getKhHaitouKanriNaiteiKakuteiKbn())) {

                    errorKbn = C_ErrorKbn.ERROR;

                    setErrorInfo(ERRORCODE003);

                    logger.debug("△ 配当共通計算（円建変更） 配当金額計算 終了");

                    return errorKbn;
                }
            }

            errorKbn = calcTumitateDGanrikin(pSyono, pCalckijyunymd);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                logger.debug("△ 配当共通計算（円建変更） 配当金額計算 終了");

                return errorKbn;
            }
            if (C_NaiteiKakuteiKbn.KAKUTEI.eq(getDNaiteiKakuteiKbn())) {
                if (getKhTumitateDKanriNaiteiKakuteiKbn() != null && C_NaiteiKakuteiKbn.NAITEI.eq(getKhTumitateDKanriNaiteiKakuteiKbn())) {

                    errorKbn = C_ErrorKbn.ERROR;

                    setErrorInfo(ERRORCODE003);

                    logger.debug("△ 配当共通計算（円建変更） 配当金額計算 終了");

                    return errorKbn;
                }
            }

            kariwariatedruigk = getD().add(getKariwariateDGanrikin());

            if (C_NaiteiKakuteiKbn.NAITEI.eq(getDNaiteiKakuteiKbn())) {

                tumitated = getTumitateDGanrikin();
            }
            else {
                if (kariwariatedruigk.compareTo(BizCurrency.valueOf(0, kariwariatedruigk.getType())) < 0) {
                    tumitated = getTumitateDGanrikin();
                }
                else {
                    tumitated = getTumitateDGanrikin().add(kariwariatedruigk);
                }
            }

            SetHokenNnd setHokenNnd = getInjectInstance(SetHokenNnd.class);

            haitouNendo = setHokenNnd.exec(pDratekjymd, pDratekjymd).getHokenNnd();

            logger.debug("△ 配当共通計算（円建変更） 配当金額計算 終了");

            return errorKbn;
        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }

    public BizCurrency getKariwariatedruigk() {

        return kariwariatedruigk;
    }

    public BizCurrency getTumitated() {

        return tumitated;
    }

    public BizDateY getHaitouNendo() {

        return haitouNendo;
    }

    public NrkKmkYendtHnkNaibuBean getNrkKmkYendtHnkNaibuBean() {

        return nrkKmkYendtHnkNaibuBean;
    }

    private void setNrkKmk(String pSyono, BizDate pCalckijyunYmd, BizDate pDratekjymd, BizDate pSyoriYmd) {

        nrkKmkYendtHnkNaibuBean = new NrkKmkYendtHnkNaibuBean();

        nrkKmkYendtHnkNaibuBean.setSyono(pSyono);
        nrkKmkYendtHnkNaibuBean.setCalckijyunymd(pCalckijyunYmd);
        nrkKmkYendtHnkNaibuBean.setDratekjymd(pDratekjymd);
        nrkKmkYendtHnkNaibuBean.setSyoriymd(pSyoriYmd);
    }

    @Override
    public EditDshrTukiDKoumokuBean getEditDshrTukiDKoumokuBean() {

        if (nrkKmkYendtHnkNaibuBean == null) {

            return null;
        }

        EditDshrTukiDKoumokuBean editDshrTukiDKoumokuBean = super.getEditDshrTukiDKoumokuBean();

        editDshrTukiDKoumokuBean.setCalckijyunYmd(nrkKmkYendtHnkNaibuBean.getCalckijyunymd());
        editDshrTukiDKoumokuBean.setSyoriYmd2(nrkKmkYendtHnkNaibuBean.getSyoriymd());
        editDshrTukiDKoumokuBean.setKinoubetukijyunYmd(nrkKmkYendtHnkNaibuBean.getDratekjymd());
        editDshrTukiDKoumokuBean.setKariwariatedruiGk(kariwariatedruigk);
        editDshrTukiDKoumokuBean.setHaitounendo(haitouNendo);
        editDshrTukiDKoumokuBean.setTumitated(tumitated);

        return editDshrTukiDKoumokuBean;
    }

    class NrkKmkYendtHnkNaibuBean {

        @Getter@Setter
        private String syono;

        @Getter@Setter
        private BizDate calckijyunymd;

        @Getter@Setter
        private BizDate dratekjymd;

        @Getter@Setter
        private BizDate syoriymd;

        public NrkKmkYendtHnkNaibuBean() {
        }
    }
}
