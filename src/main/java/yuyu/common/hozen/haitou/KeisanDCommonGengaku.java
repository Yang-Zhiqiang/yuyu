package yuyu.common.hozen.haitou;

import java.math.RoundingMode;

import javax.inject.Inject;

import org.slf4j.Logger;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import lombok.Getter;
import lombok.Setter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.hozen.khcommon.SetKessanNensibi;
import yuyu.common.suuri.srcommon.EditDshrTukiDKoumokuBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 配当 配当共通計算（減額）
 */
public class KeisanDCommonGengaku extends KeisanDCommon {

    public static final BizNumber GENGAKUSIHARAIWARIAI = BizNumber.valueOf(0.75);

    @Inject
    private static Logger logger;

    private BizCurrency kariwariatedruigk;

    private BizCurrency kariwariatedgngkkngk;

    private BizCurrency kariwariatedshrgk;

    private NrkKmkGengakuNaibuBean nrkKmkGengakuNaibuBean;

    public C_ErrorKbn calcDShrgk(String pSyono, BizDate pCalckijyunymd, BizDate pSyoruiukeYmd, BizDate pSyoriYmd, BizNumber pGengakuWariai) {

        logger.debug("▽ 配当共通計算（減額） 配当支払金計算 開始");

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        setNrkKmk(pSyono, pCalckijyunymd, pSyoruiukeYmd, pSyoriYmd, pGengakuWariai);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        if (C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())) {

            C_ErrorKbn errorKbn = calcDShrgkForItijibarai(pSyono, pCalckijyunymd, pSyoriYmd, pGengakuWariai);

            logger.debug("△ 配当共通計算（減額） 配当支払金計算 終了");

            return errorKbn;
        }

        C_ErrorKbn errorKbn = calcDShrgkForHeijyunbarai(pSyono, pCalckijyunymd, pSyoruiukeYmd, pSyoriYmd, pGengakuWariai);

        logger.debug("△ 配当共通計算（減額） 配当支払金計算 終了");

        return errorKbn;

    }

    private C_ErrorKbn calcDShrgkForItijibarai(String pSyono, BizDate pCalckijyunymd, BizDate pSyoriYmd, BizNumber pGengakuWariai) {

        logger.debug("▽ 配当共通計算（減額） 配当支払金計算（一時払用） 開始");

        clear();
        kariwariatedruigk = null;
        kariwariatedgngkkngk = null;
        kariwariatedshrgk = null;
        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        if (BizUtil.isBlank(pSyono) || pCalckijyunymd == null || pSyoriYmd == null || pGengakuWariai.isOptional()) {

            errorKbn = C_ErrorKbn.ERROR;

            setErrorInfo(ERRORCODE001);

            logger.debug("△ 配当共通計算（減額） 配当支払金計算（一時払用） 終了");

            return errorKbn;
        }

        SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);
        NaiteiKakuteiRateHantei naiteiKakuteiRateHantei = SWAKInjector.getInstance(NaiteiKakuteiRateHantei.class);

        BizDateY drateNendo = setKessanNensibi.exec(pCalckijyunymd).getBizDateY();
        errorKbn = naiteiKakuteiRateHantei.exec(pSyoriYmd, drateNendo, C_UmuKbn.NONE);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            setErrorLink(naiteiKakuteiRateHantei);

            logger.debug("△ 配当共通計算（減額） 配当支払金計算（一時払用） 終了");

            return errorKbn;
        }

        C_NaiteiKakuteiKbn naiteiKakuteiKbn = naiteiKakuteiRateHantei.getNaiteiKakuteiKbn();

        errorKbn = calcKariwariateDGanrikin(pSyono, pCalckijyunymd);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            logger.debug("△ 配当共通計算（減額） 配当支払金計算（一時払用） 終了");

            return errorKbn;
        }

        if (C_NaiteiKakuteiKbn.KAKUTEI.eq(naiteiKakuteiKbn)) {
            if (getKhHaitouKanriNaiteiKakuteiKbn() != null && C_NaiteiKakuteiKbn.NAITEI.eq(getKhHaitouKanriNaiteiKakuteiKbn())) {

                errorKbn = C_ErrorKbn.ERROR;

                setErrorInfo(ERRORCODE003);

                logger.debug("△ 配当共通計算（減額） 配当支払金計算（一時払用） 終了");

                return errorKbn;
            }
        }

        BizCurrency geengakuKariwariatedruigk = getKariwariateDGanrikin().multiply(pGengakuWariai, 0, RoundingMode.UP);

        kariwariatedgngkkngk = getKariwariateDGanrikin().subtract(geengakuKariwariatedruigk);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        if (BizDateUtil.compareYmd(pCalckijyunymd, kykSyouhn.getKykymd().addYears(2).getRekijyou()) != BizDateUtil.COMPARE_LESSER) {

            BizCurrency kariwariatedShrgk = kariwariatedgngkkngk.multiply(GENGAKUSIHARAIWARIAI, 0, RoundingMode.DOWN);

            if (kariwariatedShrgk.compareTo(BizCurrency.valueOf(0, kariwariatedShrgk.getType())) > 0) {

                kariwariatedshrgk = kariwariatedShrgk;
            }
            else {

                kariwariatedshrgk = BizCurrency.valueOf(0);
            }
        }
        else {

            kariwariatedshrgk = BizCurrency.valueOf(0);
        }

        kariwariatedruigk = calcWrmdsKngk(geengakuKariwariatedruigk, getKariwariateDRirituList());

        logger.debug("△ 配当共通計算（減額） 配当支払金計算（一時払用） 終了");

        return errorKbn;
    }

    private C_ErrorKbn calcDShrgkForHeijyunbarai(String pSyono,
        BizDate pCalckijyunymd, BizDate pSyoruiukeYmd, BizDate pSyoriYmd, BizNumber pGengakuWariai) {

        logger.debug("▽ 配当共通計算（減額） 配当支払金計算（平準払用） 開始");

        clear();
        kariwariatedruigk = null;
        kariwariatedgngkkngk = null;
        kariwariatedshrgk = null;
        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        if (BizUtil.isBlank(pSyono) || pCalckijyunymd == null || pSyoruiukeYmd == null || pSyoriYmd == null || pGengakuWariai.isOptional()) {

            errorKbn = C_ErrorKbn.ERROR;

            setErrorInfo(ERRORCODE001);

            logger.debug("△ 配当共通計算（減額） 配当支払金計算（平準払用） 終了");

            return errorKbn;
        }

        SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);
        NaiteiKakuteiRateHantei naiteiKakuteiRateHantei = SWAKInjector.getInstance(NaiteiKakuteiRateHantei.class);

        BizDateY drateNendo = setKessanNensibi.exec(pCalckijyunymd).getBizDateY();
        errorKbn = naiteiKakuteiRateHantei.exec(pSyoriYmd, drateNendo, C_UmuKbn.NONE);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            setErrorLink(naiteiKakuteiRateHantei);

            logger.debug("△ 配当共通計算（減額） 配当支払金計算（平準払用） 終了");

            return errorKbn;
        }

        C_NaiteiKakuteiKbn naiteiKakuteiKbn = naiteiKakuteiRateHantei.getNaiteiKakuteiKbn();

        errorKbn = calcKariwariateDGanrikin(pSyono, pSyoruiukeYmd, pCalckijyunymd);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            logger.debug("△ 配当共通計算（減額） 配当支払金計算（平準払用） 終了");

            return errorKbn;
        }

        if (C_NaiteiKakuteiKbn.KAKUTEI.eq(naiteiKakuteiKbn)) {
            if (getKhHaitouKanriNaiteiKakuteiKbn() != null && C_NaiteiKakuteiKbn.NAITEI.eq(getKhHaitouKanriNaiteiKakuteiKbn())) {

                errorKbn = C_ErrorKbn.ERROR;

                setErrorInfo(ERRORCODE003);

                logger.debug("△ 配当共通計算（減額） 配当支払金計算（平準払用） 終了");

                return errorKbn;
            }
        }

        BizCurrency geengakuKariwariatedruigk = getKariwariateDGanrikin().multiply(pGengakuWariai, 0, RoundingMode.UP);

        kariwariatedgngkkngk = getKariwariateDGanrikin().subtract(geengakuKariwariatedruigk);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        if (BizDateUtil.compareYmd(pCalckijyunymd, kykSyouhn.getKykymd().addYears(2).getRekijyou()) != BizDateUtil.COMPARE_LESSER) {

            BizCurrency kariwariatedShrgk = kariwariatedgngkkngk.multiply(GENGAKUSIHARAIWARIAI, 0, RoundingMode.DOWN);

            if (kariwariatedShrgk.compareTo(BizCurrency.valueOf(0, kariwariatedShrgk.getType())) > 0) {

                kariwariatedshrgk = kariwariatedShrgk;
            }
            else {

                kariwariatedshrgk = BizCurrency.valueOf(0);
            }
        }
        else {

            kariwariatedshrgk = BizCurrency.valueOf(0);
        }

        kariwariatedruigk = calcWrmdsKngk(geengakuKariwariatedruigk, getKariwariateDRirituList());

        logger.debug("△ 配当共通計算（減額） 配当支払金計算（平準払用） 終了");

        return errorKbn;
    }

    public BizCurrency getKariwariatedruigk() {

        return kariwariatedruigk;
    }

    public BizCurrency getKariwariatedgngkkngk() {

        return kariwariatedgngkkngk;
    }

    public BizCurrency getKariwariatedshrgk() {

        return kariwariatedshrgk;
    }

    public NrkKmkGengakuNaibuBean getNrkKmkGengakuNaibuBean() {

        return nrkKmkGengakuNaibuBean;
    }

    private void setNrkKmk(String pSyono, BizDate pCalckijyunYmd, BizDate pSyoruiukeYmd,
        BizDate pSyoriYmd, BizNumber pGengakuWariai) {

        nrkKmkGengakuNaibuBean = new NrkKmkGengakuNaibuBean();

        nrkKmkGengakuNaibuBean.setSyono(pSyono);
        nrkKmkGengakuNaibuBean.setCalckijyunymd(pCalckijyunYmd);
        nrkKmkGengakuNaibuBean.setSyoruiukeymd(pSyoruiukeYmd);
        nrkKmkGengakuNaibuBean.setSyoriymd(pSyoriYmd);
        nrkKmkGengakuNaibuBean.setGengakuWariai(pGengakuWariai);
    }

    @Override
    public EditDshrTukiDKoumokuBean getEditDshrTukiDKoumokuBean() {

        if (nrkKmkGengakuNaibuBean == null) {

            return null;
        }

        EditDshrTukiDKoumokuBean editDshrTukiDKoumokuBean = super.getEditDshrTukiDKoumokuBean();

        editDshrTukiDKoumokuBean.setCalckijyunYmd(nrkKmkGengakuNaibuBean.getCalckijyunymd());
        editDshrTukiDKoumokuBean.setSyoriYmd2(nrkKmkGengakuNaibuBean.getSyoriymd());
        editDshrTukiDKoumokuBean.setKinoubetukijyunYmd(nrkKmkGengakuNaibuBean.getSyoruiukeymd());
        editDshrTukiDKoumokuBean.setGengkwari(nrkKmkGengakuNaibuBean.getGengakuWariai());
        editDshrTukiDKoumokuBean.setKariwariatedruiGk(kariwariatedruigk);
        editDshrTukiDKoumokuBean.setKariwariatedgngkknGk(kariwariatedgngkkngk);
        editDshrTukiDKoumokuBean.setKariwariatedshrGk(kariwariatedshrgk);

        return editDshrTukiDKoumokuBean;
    }

    class NrkKmkGengakuNaibuBean {

        @Getter@Setter
        private String syono;

        @Getter@Setter
        private BizDate calckijyunymd;

        @Getter@Setter
        private BizDate syoruiukeymd;

        @Getter@Setter
        private BizDate syoriymd;

        @Getter@Setter
        private BizNumber gengakuWariai;

        public NrkKmkGengakuNaibuBean() {
        }
    }
}
