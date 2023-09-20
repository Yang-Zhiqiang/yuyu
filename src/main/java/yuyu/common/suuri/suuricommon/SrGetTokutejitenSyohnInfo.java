package yuyu.common.suuri.suuricommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyouhinJyouhouGetKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_TokutejitenSyoriKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.SV_KiykSyuhnData;

/**
 * 数理統計 数理共通 特定時点商品情報取得
 */
public class SrGetTokutejitenSyohnInfo {

    @Inject
    private static Logger logger;

    public SrGetTokutejitenSyohnInfo() {
        super();
    }

    public TkJitenKeiyakuSyouhinBean exec(C_TokutejitenSyoriKbn pTokutejitenSyoriKbn, String pTokutejitenSyono,
        BizDate pTokutejitenKijyunYmd, String pTokutejitenKey, List<SV_KiykSyuhnData> pKiykSyuhnDataLst) {

        logger.debug("▽ 特定時点商品情報取得 開始");

        TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBeanMae = null;
        TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBeanAto = null;
        TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean = SWAKInjector.getInstance(TkJitenKeiyakuSyouhinBean.class);
        Boolean umuFlg = false;
        C_SyouhinJyouhouGetKbn syouhinJyouhouGetKbnAto = null;
        C_SyouhinJyouhouGetKbn syouhinJyouhouGetKbnMae = null;

        if (C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO.eq(pTokutejitenSyoriKbn)) {

            for (int i = 0; i < pKiykSyuhnDataLst.size(); i++) {

                if (i > 0) {

                    if (umuFlg) {

                        break;
                    }
                }

                BizDate targetDate = setTaiSyouHiDuke(pKiykSyuhnDataLst.get(i));

                if (targetDate == null) {

                    umuFlg = false;

                    continue;
                }

                if (BizDateUtil.compareYmd(targetDate, pTokutejitenKijyunYmd) != BizDateUtil.COMPARE_GREATER) {

                    umuFlg = true;
                    tkJitenKeiyakuSyouhinKijyunBeanAto = setTkJitenKeiyakuSyouhinKijyunBean(pKiykSyuhnDataLst.get(i));
                }
                else {

                    umuFlg = false;
                }
            }

            if (!umuFlg) {

                syouhinJyouhouGetKbnAto = C_SyouhinJyouhouGetKbn.SYOUHININFONASI;
                syouhinJyouhouGetKbnMae = C_SyouhinJyouhouGetKbn.SYOUHININFONASI;
            }
            else {

                syouhinJyouhouGetKbnAto = C_SyouhinJyouhouGetKbn.SYOUHININFOARI;
                syouhinJyouhouGetKbnMae = C_SyouhinJyouhouGetKbn.SYOUHININFONASI;
            }
        }
        else {

            for (int j = 0; j < pKiykSyuhnDataLst.size(); j++) {

                if (j > 0) {

                    if (umuFlg) {

                        break;
                    }
                }

                if (pTokutejitenKey.equals(pKiykSyuhnDataLst.get(j).getHenkousikibetukey())) {

                    umuFlg = true;
                    tkJitenKeiyakuSyouhinKijyunBeanAto = setTkJitenKeiyakuSyouhinKijyunBean(pKiykSyuhnDataLst.get(j));

                    if (j + 1 < pKiykSyuhnDataLst.size()) {

                        tkJitenKeiyakuSyouhinKijyunBeanMae = setTkJitenKeiyakuSyouhinKijyunBean(pKiykSyuhnDataLst
                            .get(j + 1));
                        syouhinJyouhouGetKbnMae = C_SyouhinJyouhouGetKbn.SYOUHININFOARI;
                    }
                    else {

                        syouhinJyouhouGetKbnMae = C_SyouhinJyouhouGetKbn.SYOUHININFONASI;
                    }
                }
                else {

                    umuFlg = false;
                }
            }

            if (!umuFlg) {

                syouhinJyouhouGetKbnAto = C_SyouhinJyouhouGetKbn.SYOUHININFONASI;
                syouhinJyouhouGetKbnMae = C_SyouhinJyouhouGetKbn.SYOUHININFONASI;
            }
            else {

                syouhinJyouhouGetKbnAto = C_SyouhinJyouhouGetKbn.SYOUHININFOARI;
            }
        }

        tkJitenKeiyakuSyouhinBean.setSyouhinJyouhouGetKbnAto(syouhinJyouhouGetKbnAto);
        tkJitenKeiyakuSyouhinBean.setTkJitenKeiyakuSyouhinKijyunBeanAto(tkJitenKeiyakuSyouhinKijyunBeanAto);
        tkJitenKeiyakuSyouhinBean.setSyouhinJyouhouGetKbnMae(syouhinJyouhouGetKbnMae);
        tkJitenKeiyakuSyouhinBean.setTkJitenKeiyakuSyouhinKijyunBeanMae(tkJitenKeiyakuSyouhinKijyunBeanMae);

        logger.debug("△ 特定時点商品情報取得 終了");

        return tkJitenKeiyakuSyouhinBean;
    }

    private BizDate setTaiSyouHiDuke(SV_KiykSyuhnData pSvKiykSyuhnData) {

        BizDate targetDate = null;

        if (IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI.equals(pSvKiykSyuhnData.getGyoumuKousinKinou())) {

            targetDate = pSvKiykSyuhnData.getSknnkaisiymd();
        }
        else if (C_YuukousyoumetuKbn.SYOUMETU.eq(pSvKiykSyuhnData.getYuukousyoumetukbn()) &&
            (C_Syoumetujiyuu.KAIYAKU.eq(pSvKiykSyuhnData.getSyoumetujiyuu()) ||
                C_Syoumetujiyuu.MUKOU.eq(pSvKiykSyuhnData.getSyoumetujiyuu()) ||
                C_Syoumetujiyuu.KYKTORIKESI.eq(pSvKiykSyuhnData.getSyoumetujiyuu()) ||
                C_Syoumetujiyuu.CLGOFF.eq(pSvKiykSyuhnData.getSyoumetujiyuu()) ||
                C_Syoumetujiyuu.SIBOU.eq(pSvKiykSyuhnData.getSyoumetujiyuu()) ||
                C_Syoumetujiyuu.SIBOUSAIGAIMENSEKI.eq(pSvKiykSyuhnData.getSyoumetujiyuu()) ||
                C_Syoumetujiyuu.SIBOUSAIGAIHIGAITOU.eq(pSvKiykSyuhnData.getSyoumetujiyuu()) ||
                C_Syoumetujiyuu.SBKAIJO.eq(pSvKiykSyuhnData.getSyoumetujiyuu()) ||
                C_Syoumetujiyuu.KAIJO.eq(pSvKiykSyuhnData.getSyoumetujiyuu()) ||
                C_Syoumetujiyuu.MENSEKI.eq(pSvKiykSyuhnData.getSyoumetujiyuu()) ||
                C_Syoumetujiyuu.SBMUKOU.eq(pSvKiykSyuhnData.getSyoumetujiyuu()) ||
                C_Syoumetujiyuu.SIBOUKYUUHUKINSHR.eq(pSvKiykSyuhnData.getSyoumetujiyuu()) ||
                C_Syoumetujiyuu.PMNYSYMET_JDSKN_SSNZM.eq(pSvKiykSyuhnData.getSyoumetujiyuu()) ||
                C_Syoumetujiyuu.PMNYSYMET_MSSN.eq(pSvKiykSyuhnData.getSyoumetujiyuu()))) {

            targetDate = pSvKiykSyuhnData.getSyoriYmd();
        }
        else if (IKhozenCommonConstants.KINOUID_SEINENGAPPISEI.equals(pSvKiykSyuhnData.getGyoumuKousinKinou())) {

            targetDate = pSvKiykSyuhnData.getKouryokuhasseiymd();
        }
        else if (C_YuukousyoumetuKbn.YUUKOU.eq(pSvKiykSyuhnData.getYuukousyoumetukbn()) &&
            IKhozenCommonConstants.KINOUID_GENGAKU.equals(pSvKiykSyuhnData.getGyoumuKousinKinou())) {

            targetDate = pSvKiykSyuhnData.getKouryokuhasseiymd();
        }
        else if (IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK.equals(pSvKiykSyuhnData.getGyoumuKousinKinou())) {

            targetDate = pSvKiykSyuhnData.getKouryokuhasseiymd();
        }
        else if (IKhozenCommonConstants.KINOUID_KANIKEIYAKUNAIYOUTEISEI.equals(pSvKiykSyuhnData.getGyoumuKousinKinou()) &&
            (C_SyoriKbn.MKHGKTTTYENDTHNKTORIKESI.eq(pSvKiykSyuhnData.getSyorikbn()) ||
                C_SyoriKbn.TMTTKNHANEI_ITEN_TORIKESI.eq(pSvKiykSyuhnData.getSyorikbn()))) {

            targetDate = pSvKiykSyuhnData.getSyoriYmd();
        }
        else if (IKhozenCommonConstants.KINOUID_KHSISUURENDOTMTTKNHANEI.equals(pSvKiykSyuhnData.getGyoumuKousinKinou()) &&
            C_SyoriKbn.TMTTKNHANEI_ITEN.eq(pSvKiykSyuhnData.getSyorikbn())){

            targetDate = pSvKiykSyuhnData.getKouryokuhasseiymd();
        }
        else if (IKhozenCommonConstants.KINOUID_HARAIKATAHENKOU.equals(pSvKiykSyuhnData.getGyoumuKousinKinou()) &&
            (C_SyoriKbn.TIKIKTSYURUIHENKOU_CRECAHENNYUU.eq(pSvKiykSyuhnData.getSyorikbn()) ||
                C_SyoriKbn.TIKIKTSYURUIHENKOU_YOHURIHENNYUU.eq(pSvKiykSyuhnData.getSyorikbn()) ||
                C_SyoriKbn.CRECAHENNYUU.eq(pSvKiykSyuhnData.getSyorikbn()) ||
                C_SyoriKbn.YOHURIHENNYUU.eq(pSvKiykSyuhnData.getSyorikbn()) ||
                C_SyoriKbn.KAISUUHENKOU.eq(pSvKiykSyuhnData.getSyorikbn()) ||
                C_SyoriKbn.KAISUUHENKOU_KOUZAHENKOU.eq(pSvKiykSyuhnData.getSyorikbn()) ||
                C_SyoriKbn.KAISUUHENKOU_CRECAHENNYUU.eq(pSvKiykSyuhnData.getSyorikbn()) ||
                C_SyoriKbn.KAISUUHENKOU_YOHURIHENNYUU.eq(pSvKiykSyuhnData.getSyorikbn()))) {

            targetDate = pSvKiykSyuhnData.getKouryokuhasseiymd();
        }

        return targetDate;
    }

    private TkJitenKeiyakuSyouhinKijyunBean setTkJitenKeiyakuSyouhinKijyunBean(SV_KiykSyuhnData pSvKiykSyuhnData) {

        TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean = SWAKInjector
            .getInstance(TkJitenKeiyakuSyouhinKijyunBean.class);

        tkJitenKeiyakuSyouhinKijyunBean.setSyono(pSvKiykSyuhnData.getSyono());
        tkJitenKeiyakuSyouhinKijyunBean.setSyutkKbn(pSvKiykSyuhnData.getSyutkkbn());
        tkJitenKeiyakuSyouhinKijyunBean.setSyouhncd(pSvKiykSyuhnData.getSyouhncd());
        tkJitenKeiyakuSyouhinKijyunBean.setSyouhnsdno(pSvKiykSyuhnData.getSyouhnsdno());
        tkJitenKeiyakuSyouhinKijyunBean.setKyksyouhnrenno(pSvKiykSyuhnData.getKyksyouhnrenno());
        tkJitenKeiyakuSyouhinKijyunBean.setHenkousikibetukey(pSvKiykSyuhnData.getHenkousikibetukey());
        tkJitenKeiyakuSyouhinKijyunBean.setYuukousyoumetuKbn(pSvKiykSyuhnData.getYuukousyoumetukbn());
        tkJitenKeiyakuSyouhinKijyunBean.setKykjyoutai(pSvKiykSyuhnData.getKykjyoutai());
        tkJitenKeiyakuSyouhinKijyunBean.setSyoumetujiyuu(pSvKiykSyuhnData.getSyoumetujiyuu());
        tkJitenKeiyakuSyouhinKijyunBean.setSyoumetuymd(pSvKiykSyuhnData.getSyoumetuymd());
        tkJitenKeiyakuSyouhinKijyunBean.setKouryokuhasseiymd(pSvKiykSyuhnData.getKouryokuhasseiymd());
        tkJitenKeiyakuSyouhinKijyunBean.setKykymd(pSvKiykSyuhnData.getKykymd());
        tkJitenKeiyakuSyouhinKijyunBean.setKykymdsiteiumuKbn(pSvKiykSyuhnData.getKykymdsiteiumukbn());
        tkJitenKeiyakuSyouhinKijyunBean.setSknnkaisiymd(pSvKiykSyuhnData.getSknnkaisiymd());
        tkJitenKeiyakuSyouhinKijyunBean.setGansknnkaisiymd(pSvKiykSyuhnData.getGansknnkaisiymd());
        tkJitenKeiyakuSyouhinKijyunBean.setHksknnkaisiymd(pSvKiykSyuhnData.getHksknnkaisiymd());
        tkJitenKeiyakuSyouhinKijyunBean.setHkgansknnkaisiymd(pSvKiykSyuhnData.getHkgansknnkaisiymd());
        tkJitenKeiyakuSyouhinKijyunBean.setHknkknsmnKbn(pSvKiykSyuhnData.getHknkknsmnkbn());
        tkJitenKeiyakuSyouhinKijyunBean.setHknkkn(pSvKiykSyuhnData.getHknkkn());
        tkJitenKeiyakuSyouhinKijyunBean.setHrkkknsmnKbn(pSvKiykSyuhnData.getHrkkknsmnkbn());
        tkJitenKeiyakuSyouhinKijyunBean.setHrkkkn(pSvKiykSyuhnData.getHrkkkn());
        tkJitenKeiyakuSyouhinKijyunBean.setKyknen(pSvKiykSyuhnData.getKyknen());
        tkJitenKeiyakuSyouhinKijyunBean.setHhknnen(pSvKiykSyuhnData.getHhknnen());
        tkJitenKeiyakuSyouhinKijyunBean.setHhknseiymd(pSvKiykSyuhnData.getHhknseiymd());
        tkJitenKeiyakuSyouhinKijyunBean.setHhknsei(pSvKiykSyuhnData.getHhknsei());
        tkJitenKeiyakuSyouhinKijyunBean.setHaraimanymd(pSvKiykSyuhnData.getHaraimanymd());
        tkJitenKeiyakuSyouhinKijyunBean.setHknkknmanryouymd(pSvKiykSyuhnData.getHknkknmanryouymd());
        tkJitenKeiyakuSyouhinKijyunBean.setKataKbn(pSvKiykSyuhnData.getKatakbn());
        tkJitenKeiyakuSyouhinKijyunBean.setKyhgndkataKbn(pSvKiykSyuhnData.getKyhgndkatakbn());
        tkJitenKeiyakuSyouhinKijyunBean.setSyukyhkinkataKbn(pSvKiykSyuhnData.getSyukyhkinkatakbn());
        tkJitenKeiyakuSyouhinKijyunBean.setKhnkyhkgbairituKbn(pSvKiykSyuhnData.getKhnkyhkgbairitukbn());
        tkJitenKeiyakuSyouhinKijyunBean.setRokudaildkbn(pSvKiykSyuhnData.getRokudaildkbn());
        tkJitenKeiyakuSyouhinKijyunBean.setPmnjtkKbn(pSvKiykSyuhnData.getPmnjtkkbn());
        tkJitenKeiyakuSyouhinKijyunBean.setKihons(pSvKiykSyuhnData.getKihons());
        tkJitenKeiyakuSyouhinKijyunBean.setHokenryou(pSvKiykSyuhnData.getHokenryou());
        tkJitenKeiyakuSyouhinKijyunBean.setKyktuukasyu(pSvKiykSyuhnData.getKyktuukasyu());
        tkJitenKeiyakuSyouhinKijyunBean.setRyouritusdno(pSvKiykSyuhnData.getRyouritusdno());
        tkJitenKeiyakuSyouhinKijyunBean.setYoteiriritu(pSvKiykSyuhnData.getYoteiriritu());
        tkJitenKeiyakuSyouhinKijyunBean.setYoteirrthendohosyurrt(pSvKiykSyuhnData.getYoteirrthendohosyurrt());
        tkJitenKeiyakuSyouhinKijyunBean.setYtirrthndmnskaisuu(pSvKiykSyuhnData.getYtirrthndmnskaisuu());
        tkJitenKeiyakuSyouhinKijyunBean.setKyksjkkktyouseiriritu(pSvKiykSyuhnData.getKyksjkkktyouseiriritu());
        tkJitenKeiyakuSyouhinKijyunBean.setNksyukbn(pSvKiykSyuhnData.getNksyukbn());
        tkJitenKeiyakuSyouhinKijyunBean.setNenkinkkn(pSvKiykSyuhnData.getNenkinkkn());
        tkJitenKeiyakuSyouhinKijyunBean.setNkgnshosyouritu(pSvKiykSyuhnData.getNkgnshosyouritu());
        tkJitenKeiyakuSyouhinKijyunBean.setNkgnshosyougk(pSvKiykSyuhnData.getNkgnshosyougk());
        tkJitenKeiyakuSyouhinKijyunBean.setGyoumuKousinKinou(pSvKiykSyuhnData.getGyoumuKousinKinou());
        tkJitenKeiyakuSyouhinKijyunBean.setGengakugoyenitijibrpstgk(pSvKiykSyuhnData.getGengakugoyenitijibrpstgk());
        tkJitenKeiyakuSyouhinKijyunBean.setYendthnkymd(pSvKiykSyuhnData.getYendthnkymd());
        tkJitenKeiyakuSyouhinKijyunBean.setSetteibairitu(pSvKiykSyuhnData.getSetteibairitu());
        tkJitenKeiyakuSyouhinKijyunBean.setKykjisisuurendourate(pSvKiykSyuhnData.getKykjisisuurendourate());
        tkJitenKeiyakuSyouhinKijyunBean.setTmttknzoukaritujygn(pSvKiykSyuhnData.getTmttknzoukaritujygn());
        tkJitenKeiyakuSyouhinKijyunBean.setTumitateriritu(pSvKiykSyuhnData.getTumitateriritu());
        tkJitenKeiyakuSyouhinKijyunBean.setTmttknhaibunjyoutai(pSvKiykSyuhnData.getTmttknhaibunjyoutai());
        tkJitenKeiyakuSyouhinKijyunBean.setSisuukbn(pSvKiykSyuhnData.getSisuukbn());
        tkJitenKeiyakuSyouhinKijyunBean.setGsbunrikzkakuninumu(pSvKiykSyuhnData.getGsbunrikzkakuninumu());
        tkJitenKeiyakuSyouhinKijyunBean.setGsbunritaisyou(pSvKiykSyuhnData.getGsbunritaisyou());
        tkJitenKeiyakuSyouhinKijyunBean.setPharaikomisougaku(pSvKiykSyuhnData.getPharaikomisougaku());
        tkJitenKeiyakuSyouhinKijyunBean.setTmttknitenYmd(pSvKiykSyuhnData.getTmttknitenymd());
        tkJitenKeiyakuSyouhinKijyunBean.setLoadinghnkgtumitateriritu(pSvKiykSyuhnData.getLoadinghnkgtumitateriritu());
        tkJitenKeiyakuSyouhinKijyunBean.setRendouritu(pSvKiykSyuhnData.getRendouritu());
        tkJitenKeiyakuSyouhinKijyunBean.setTeikishrritu(pSvKiykSyuhnData.getTeikishrritu());
        tkJitenKeiyakuSyouhinKijyunBean.setDai1hknkkn(pSvKiykSyuhnData.getDai1hknkkn());
        tkJitenKeiyakuSyouhinKijyunBean.setSyoriYmd(pSvKiykSyuhnData.getSyoriYmd());
        tkJitenKeiyakuSyouhinKijyunBean.setSyorikbn(pSvKiykSyuhnData.getSyorikbn());

        return tkJitenKeiyakuSyouhinKijyunBean;
    }
}
