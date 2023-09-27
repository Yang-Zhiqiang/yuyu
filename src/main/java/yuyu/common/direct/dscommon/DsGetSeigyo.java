package yuyu.common.direct.dscommon;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.direct.dscommon.dba4dsgetseigyo.DsGetSeigyoDao;
import yuyu.def.classification.C_DsPhrkhouhenkouKahiSeigyoKbn;
import yuyu.def.classification.C_DsSyouhnbunruiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * ダイレクトサービス ダイレクトサービス共通 ＤＳ制御情報取得
 */
public class DsGetSeigyo {

    @Inject
    private static Logger logger;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private DsGetSeigyoDao dsGetSeigyoDao;

    public DsGetSeigyo() {
        super();
    }

    public GamenSeigyoBean getGamenSeigyo(DsSyouhinBean pDsSyouhinBean) {
        logger.debug("▽ 画面制御情報取得 開始");

        GamenSeigyoBean gamenSeigyoBean = SWAKInjector.getInstance(GamenSeigyoBean.class);

        gamenSeigyoBean.setErrorKbn(C_ErrorKbn.ERROR);

        if (C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN.eq(pDsSyouhinBean.getDsSyouhnbunruiKbn())) {

            gamenSeigyoBean.setErrorKbn(C_ErrorKbn.OK);

            gamenSeigyoBean.setTutakinUmukbn(C_UmuKbn.ARI);

            gamenSeigyoBean.setKaiyakuHrsuiiUmuKbn(C_UmuKbn.NONE);
        }
        else if (C_DsSyouhnbunruiKbn.GKDTITIJIBRNK.eq(pDsSyouhinBean.getDsSyouhnbunruiKbn())) {

            gamenSeigyoBean.setErrorKbn(C_ErrorKbn.OK);

            gamenSeigyoBean.setTutakinUmukbn(C_UmuKbn.ARI);

            gamenSeigyoBean.setKaiyakuHrsuiiUmuKbn(C_UmuKbn.NONE);
        }
        else if (C_DsSyouhnbunruiKbn.GKDTHIJYNBRNK.eq(pDsSyouhinBean.getDsSyouhnbunruiKbn())) {

            gamenSeigyoBean.setErrorKbn(C_ErrorKbn.OK);

            gamenSeigyoBean.setTutakinUmukbn(C_UmuKbn.ARI);

            gamenSeigyoBean.setKaiyakuHrsuiiUmuKbn(C_UmuKbn.NONE);
        }
        else if (C_DsSyouhnbunruiKbn.YENDTITIJIBRNK.eq(pDsSyouhinBean.getDsSyouhnbunruiKbn())) {

            gamenSeigyoBean.setErrorKbn(C_ErrorKbn.OK);

            gamenSeigyoBean.setTutakinUmukbn(C_UmuKbn.ARI);

            gamenSeigyoBean.setKaiyakuHrsuiiUmuKbn(C_UmuKbn.NONE);
        }
        else if (C_DsSyouhnbunruiKbn.SNTKDTHIJYNBRSYSN.eq(pDsSyouhinBean.getDsSyouhnbunruiKbn())) {

            gamenSeigyoBean.setErrorKbn(C_ErrorKbn.OK);

            gamenSeigyoBean.setTutakinUmukbn(C_UmuKbn.ARI);

            gamenSeigyoBean.setKaiyakuHrsuiiUmuKbn(C_UmuKbn.NONE);
        }

        logger.debug("△ 画面制御情報取得 終了");

        return gamenSeigyoBean;
    }

    public HosyouBean getHosyou(DsSyouhinBean pDsSyouhinBean) {
        logger.debug("▽ 保障情報取得 開始");

        HosyouBean hosyouBean = SWAKInjector.getInstance(HosyouBean.class);

        IT_KykSonotaTkyk kykSonotaTkyk = null;

        hosyouBean.setErrorKbn(C_ErrorKbn.OK);

        if (C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN.eq(pDsSyouhinBean.getDsSyouhnbunruiKbn()) ||
            C_DsSyouhnbunruiKbn.SNTKDTHIJYNBRSYSN.eq(pDsSyouhinBean.getDsSyouhnbunruiKbn())) {

            IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pDsSyouhinBean.getSyoNo());

            if (kykKihon == null) {
                hosyouBean.setErrorKbn(C_ErrorKbn.ERROR);
                logger.debug("△ 保障情報取得 終了");
                return hosyouBean;
            }


            try{
                kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
            }
            catch (EntityNotFoundException e) {
            }
            if (kykSonotaTkyk == null) {
                hosyouBean.setErrorKbn(C_ErrorKbn.ERROR);
                logger.debug("△ 保障情報取得 終了");
                return hosyouBean;
            }
        }

        if (C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN.eq(pDsSyouhinBean.getDsSyouhnbunruiKbn())) {

            if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getJyudkaigomeharaitkhukaumu())) {
                hosyouBean.setKgHsyUmukbn(C_UmuKbn.ARI);
            }
            else {
                hosyouBean.setKgHsyUmukbn(C_UmuKbn.NONE);
            }

            hosyouBean.setSbHsyUmuKbn(C_UmuKbn.ARI);
            hosyouBean.setIryHsyUmukbn(C_UmuKbn.NONE);
            hosyouBean.setRougoHsyUmukbn(C_UmuKbn.NONE);
        }
        else if (C_DsSyouhnbunruiKbn.GKDTITIJIBRNK.eq(pDsSyouhinBean.getDsSyouhnbunruiKbn())) {

            hosyouBean.setSbHsyUmuKbn(C_UmuKbn.ARI);
            hosyouBean.setKgHsyUmukbn(C_UmuKbn.NONE);
            hosyouBean.setIryHsyUmukbn(C_UmuKbn.NONE);
            hosyouBean.setRougoHsyUmukbn(C_UmuKbn.ARI);
        }
        else if (C_DsSyouhnbunruiKbn.GKDTHIJYNBRNK.eq(pDsSyouhinBean.getDsSyouhnbunruiKbn())) {

            hosyouBean.setSbHsyUmuKbn(C_UmuKbn.ARI);
            hosyouBean.setKgHsyUmukbn(C_UmuKbn.NONE);
            hosyouBean.setIryHsyUmukbn(C_UmuKbn.NONE);
            hosyouBean.setRougoHsyUmukbn(C_UmuKbn.ARI);
        }
        else if (C_DsSyouhnbunruiKbn.YENDTITIJIBRNK.eq(pDsSyouhinBean.getDsSyouhnbunruiKbn())) {

            hosyouBean.setSbHsyUmuKbn(C_UmuKbn.ARI);
            hosyouBean.setKgHsyUmukbn(C_UmuKbn.NONE);
            hosyouBean.setIryHsyUmukbn(C_UmuKbn.NONE);
            hosyouBean.setRougoHsyUmukbn(C_UmuKbn.ARI);
        }
        else if (C_DsSyouhnbunruiKbn.SNTKDTHIJYNBRSYSN.eq(pDsSyouhinBean.getDsSyouhnbunruiKbn())) {

            hosyouBean.setSbHsyUmuKbn(C_UmuKbn.ARI);
            hosyouBean.setKgHsyUmukbn(kykSonotaTkyk.getJyudkaigomeharaitkhukaumu());
            hosyouBean.setIryHsyUmukbn(C_UmuKbn.NONE);
            hosyouBean.setRougoHsyUmukbn(C_UmuKbn.NONE);
        }

        logger.debug("△ 保障情報取得 終了");

        return hosyouBean;
    }

    public TokuyakuBean getTokuyaku(DsSyouhinBean pDsSyouhinBean) {
        logger.debug("▽ 特約情報取得 開始");

        TokuyakuBean tokuyakuBean = SWAKInjector.getInstance(TokuyakuBean.class);

        tokuyakuBean.setErrorKbn(C_ErrorKbn.OK);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pDsSyouhinBean.getSyoNo());

        if (kykKihon == null) {
            tokuyakuBean.setErrorKbn(C_ErrorKbn.ERROR);
            logger.debug("△ 特約情報取得 終了");

            return tokuyakuBean;
        }

        IT_KykSonotaTkyk kykSonotaTkyk = null;
        try{
            kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        }
        catch (EntityNotFoundException e) {
        }
        if (kykSonotaTkyk == null) {
            tokuyakuBean.setErrorKbn(C_ErrorKbn.ERROR);
            logger.debug("△ 特約情報取得 終了");

            return tokuyakuBean;
        }
        tokuyakuBean.setKykdrTkykhukaumu(kykSonotaTkyk.getKykdrtkykhukaumu());
        tokuyakuBean.setStdrskTkyhkumu(kykSonotaTkyk.getStdrsktkyhkumu());
        tokuyakuBean.setYenNyknThkumu(kykSonotaTkyk.getYennykntkhkumu());
        tokuyakuBean.setGaikaNyknTkhkumu(kykSonotaTkyk.getGaikanykntkhkumu());
        tokuyakuBean.setTargetTkhkumu(kykSonotaTkyk.getTargettkhkumu());
        tokuyakuBean.setInitSbjiYenSitiHsyTkhukaumu(kykSonotaTkyk.getInitsbjiyensitihsytkhukaumu());
        tokuyakuBean.setJyudKaigoMeharaiTkhukaumu(kykSonotaTkyk.getJyudkaigomeharaitkhukaumu());
        tokuyakuBean.setZeiseiTkkkTkykhukaumu(kykSonotaTkyk.getZeiseitkkktkykhukaumu());
        tokuyakuBean.setTeikiShrTkykhukaumu(kykSonotaTkyk.getTeikishrtkykhukaumu());

        logger.debug("△ 特約情報取得 終了");

        return tokuyakuBean;
    }

    public SyoriKahiBean getSyoriKahi(DsSyouhinBean pDsSyouhinBean) {
        logger.debug("▽ 処理可否情報取得 開始");

        SyoriKahiBean syoriKahiBean = SWAKInjector.getInstance(SyoriKahiBean.class);

        syoriKahiBean.setErrorKbn(C_ErrorKbn.OK);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pDsSyouhinBean.getSyoNo());

        if (kykKihon == null) {
            syoriKahiBean.setErrorKbn(C_ErrorKbn.ERROR);
            logger.debug("△ 処理可否情報取得 終了");

            return syoriKahiBean;
        }

        IT_KykSonotaTkyk kykSonotaTkyk = null;
        try{
            kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        }
        catch (EntityNotFoundException e) {
        }
        List<IT_KykSyouhn> kykSyouhnList = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        BM_SyouhnZokusei syouhnZokusei = null;
        IT_KykSyouhn kykSyouhn = null;
        if (kykSyouhnList != null && kykSyouhnList.size() > 0) {
            kykSyouhn = kykSyouhnList.get(0);
            syouhnZokusei = kykSyouhn.getSyouhnZokusei();
        }

        if (kykSonotaTkyk == null || kykSyouhn == null || syouhnZokusei == null) {
            syoriKahiBean.setErrorKbn(C_ErrorKbn.ERROR);
            logger.debug("△ 処理可否情報取得 終了");

            return syoriKahiBean;
        }

        long khkykHenkouUktkJyouhouKensuu = 0;
        long khkykHenkouUktkYoyakuJyouhouKensuu = 0;
        if (C_DsSyouhnbunruiKbn.GKDTITIJIBRNK.eq(pDsSyouhinBean.getDsSyouhnbunruiKbn())) {
            khkykHenkouUktkJyouhouKensuu =
                dsGetSeigyoDao.getKhHenkouUktkCountBySyonoUktksyorikbnUktkjyoutaikbn(pDsSyouhinBean.getSyoNo());
            khkykHenkouUktkYoyakuJyouhouKensuu =
                dsGetSeigyoDao.getKhHenkouUktkYykCountBySyonoUktksyorikbnUktkjyoutaikbn(pDsSyouhinBean.getSyoNo());
        }

        DsDataMaintenanceHantei dsDataMaintenanceHantei = SWAKInjector.getInstance(DsDataMaintenanceHantei.class);

        DsDataMaintenanceHanteiBean dsDataMaintenanceHanteiBean = dsDataMaintenanceHantei.exec(pDsSyouhinBean.getSyoNo());

        if (C_ErrorKbn.ERROR.eq(dsDataMaintenanceHanteiBean.getKekkaKbn())) {

            syoriKahiBean.setErrorKbn(C_ErrorKbn.ERROR);
            logger.debug("△ 処理可否情報取得 終了");

            return syoriKahiBean;
        }

        if (BizDateUtil.compareYmd(kykSyouhn.getKykymd(), BizDate.getSysDate()) == BizDateUtil.COMPARE_GREATER) {

            syoriKahiBean.setKjsmSaihakkouKahiKbn(C_KahiKbn.HUKA);
            syoriKahiBean.setKykMeigihnkKahiKbn(C_KahiKbn.HUKA);
            syoriKahiBean.setSyoukenSaihkKahiKbn(C_KahiKbn.HUKA);
            syoriKahiBean.setStdrskTkyTthkKahiKbn(C_KahiKbn.HUKA);
            syoriKahiBean.setTargetTkhkKahiKbn(C_KahiKbn.HUKA);
            syoriKahiBean.setKykNiyuSyoukaiKahiKbn(C_KahiKbn.HUKA);
            syoriKahiBean.setTumitatekinItenKahiKbn(C_KahiKbn.HUKA);
            syoriKahiBean.setDsKaiyakuKahiKbn(C_KahiKbn.HUKA);
            syoriKahiBean.setAdrHenkouKahiKbn(C_KahiKbn.HUKA);
            syoriKahiBean.setPhrkhouHenkouKahiKbn(C_DsPhrkhouhenkouKahiSeigyoKbn.HUKA);

            logger.debug("△ 処理可否情報取得 終了");

            return syoriKahiBean;
        }
        else if (C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN.eq(pDsSyouhinBean.getDsSyouhnbunruiKbn())) {

            syoriKahiBean.setKjsmSaihakkouKahiKbn(C_KahiKbn.KA);
            syoriKahiBean.setKykMeigihnkKahiKbn(C_KahiKbn.KA);
            syoriKahiBean.setSyoukenSaihkKahiKbn(C_KahiKbn.KA);
            syoriKahiBean.setTargetTkhkKahiKbn(C_KahiKbn.HUKA);
            syoriKahiBean.setKykNiyuSyoukaiKahiKbn(C_KahiKbn.KA);
            syoriKahiBean.setTumitatekinItenKahiKbn(C_KahiKbn.HUKA);
            syoriKahiBean.setDsKaiyakuKahiKbn(C_KahiKbn.KA);
            syoriKahiBean.setAdrHenkouKahiKbn(C_KahiKbn.KA);

            if (C_UmuKbn.ARI.eq(syouhnZokusei.getStdrsktkumu())) {
                if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getStdrsktkyhkumu())) {
                    syoriKahiBean.setStdrskTkyTthkKahiKbn(C_KahiKbn.HUKA);
                }
                else {
                    syoriKahiBean.setStdrskTkyTthkKahiKbn(C_KahiKbn.KA);
                }
            }
            else {
                syoriKahiBean.setStdrskTkyTthkKahiKbn(C_KahiKbn.HUKA);
            }
        }
        else if (C_DsSyouhnbunruiKbn.GKDTITIJIBRNK.eq(pDsSyouhinBean.getDsSyouhnbunruiKbn())) {
            syoriKahiBean.setKjsmSaihakkouKahiKbn(C_KahiKbn.KA);
            syoriKahiBean.setKykMeigihnkKahiKbn(C_KahiKbn.KA);
            syoriKahiBean.setSyoukenSaihkKahiKbn(C_KahiKbn.KA);
            syoriKahiBean.setTargetTkhkKahiKbn(C_KahiKbn.HUKA);
            syoriKahiBean.setKykNiyuSyoukaiKahiKbn(C_KahiKbn.KA);
            syoriKahiBean.setDsKaiyakuKahiKbn(C_KahiKbn.KA);
            syoriKahiBean.setAdrHenkouKahiKbn(C_KahiKbn.KA);

            if (C_UmuKbn.ARI.eq(syouhnZokusei.getStdrsktkumu())) {
                if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getStdrsktkyhkumu())) {
                    syoriKahiBean.setStdrskTkyTthkKahiKbn(C_KahiKbn.HUKA);
                }
                else {
                    syoriKahiBean.setStdrskTkyTthkKahiKbn(C_KahiKbn.KA);
                }
            }
            else {
                syoriKahiBean.setStdrskTkyTthkKahiKbn(C_KahiKbn.HUKA);
            }
            if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(kykSyouhn.getTmttknhaibunjyoutai())) {
                syoriKahiBean.setTumitatekinItenKahiKbn(C_KahiKbn.HUKA);
            }
            else if (khkykHenkouUktkJyouhouKensuu > 0 || khkykHenkouUktkYoyakuJyouhouKensuu > 0) {
                syoriKahiBean.setTumitatekinItenKahiKbn(C_KahiKbn.HUKA);
            }
            else {
                syoriKahiBean.setTumitatekinItenKahiKbn(C_KahiKbn.KA);
            }
        }
        else if (C_DsSyouhnbunruiKbn.GKDTHIJYNBRNK.eq(pDsSyouhinBean.getDsSyouhnbunruiKbn())) {

            syoriKahiBean.setKjsmSaihakkouKahiKbn(C_KahiKbn.KA);
            syoriKahiBean.setKykMeigihnkKahiKbn(C_KahiKbn.KA);
            syoriKahiBean.setSyoukenSaihkKahiKbn(C_KahiKbn.KA);
            syoriKahiBean.setTargetTkhkKahiKbn(C_KahiKbn.HUKA);
            syoriKahiBean.setKykNiyuSyoukaiKahiKbn(C_KahiKbn.KA);
            syoriKahiBean.setTumitatekinItenKahiKbn(C_KahiKbn.HUKA);
            syoriKahiBean.setDsKaiyakuKahiKbn(C_KahiKbn.KA);
            syoriKahiBean.setAdrHenkouKahiKbn(C_KahiKbn.KA);

            if (C_UmuKbn.ARI.eq(syouhnZokusei.getStdrsktkumu())) {
                if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getStdrsktkyhkumu())) {
                    syoriKahiBean.setStdrskTkyTthkKahiKbn(C_KahiKbn.HUKA);
                }
                else {
                    syoriKahiBean.setStdrskTkyTthkKahiKbn(C_KahiKbn.KA);
                }
            }
            else {
                syoriKahiBean.setStdrskTkyTthkKahiKbn(C_KahiKbn.HUKA);
            }
        }
        else if (C_DsSyouhnbunruiKbn.YENDTITIJIBRNK.eq(pDsSyouhinBean.getDsSyouhnbunruiKbn())) {

            syoriKahiBean.setKjsmSaihakkouKahiKbn(C_KahiKbn.KA);
            syoriKahiBean.setKykMeigihnkKahiKbn(C_KahiKbn.KA);
            syoriKahiBean.setSyoukenSaihkKahiKbn(C_KahiKbn.KA);
            syoriKahiBean.setTargetTkhkKahiKbn(C_KahiKbn.HUKA);
            syoriKahiBean.setKykNiyuSyoukaiKahiKbn(C_KahiKbn.KA);
            syoriKahiBean.setTumitatekinItenKahiKbn(C_KahiKbn.HUKA);
            syoriKahiBean.setDsKaiyakuKahiKbn(C_KahiKbn.KA);
            syoriKahiBean.setAdrHenkouKahiKbn(C_KahiKbn.KA);

            if (C_UmuKbn.ARI.eq(syouhnZokusei.getStdrsktkumu())) {
                if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getStdrsktkyhkumu())) {
                    syoriKahiBean.setStdrskTkyTthkKahiKbn(C_KahiKbn.HUKA);
                }
                else {
                    syoriKahiBean.setStdrskTkyTthkKahiKbn(C_KahiKbn.KA);
                }
            }
            else {
                syoriKahiBean.setStdrskTkyTthkKahiKbn(C_KahiKbn.HUKA);
            }
        }
        else if (C_DsSyouhnbunruiKbn.SNTKDTHIJYNBRSYSN.eq(pDsSyouhinBean.getDsSyouhnbunruiKbn())) {

            syoriKahiBean.setKjsmSaihakkouKahiKbn(C_KahiKbn.KA);
            syoriKahiBean.setKykMeigihnkKahiKbn(C_KahiKbn.KA);
            syoriKahiBean.setSyoukenSaihkKahiKbn(C_KahiKbn.KA);
            syoriKahiBean.setTargetTkhkKahiKbn(C_KahiKbn.HUKA);
            syoriKahiBean.setKykNiyuSyoukaiKahiKbn(C_KahiKbn.KA);
            syoriKahiBean.setTumitatekinItenKahiKbn(C_KahiKbn.HUKA);
            syoriKahiBean.setDsKaiyakuKahiKbn(C_KahiKbn.KA);
            syoriKahiBean.setAdrHenkouKahiKbn(C_KahiKbn.KA);

            if (C_UmuKbn.ARI.eq(syouhnZokusei.getStdrsktkumu())) {
                if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getStdrsktkyhkumu())) {
                    syoriKahiBean.setStdrskTkyTthkKahiKbn(C_KahiKbn.HUKA);
                }
                else {
                    syoriKahiBean.setStdrskTkyTthkKahiKbn(C_KahiKbn.KA);
                }
            }
            else {
                syoriKahiBean.setStdrskTkyTthkKahiKbn(C_KahiKbn.HUKA);
            }
        }

        if (!C_Kykjyoutai.ZENNOU.eq(kykSyouhn.getKykjyoutai())) {

            if (C_UmuKbn.ARI.eq(syouhnZokusei.getKouzahurikaebaraitekiumu()) &&
                C_UmuKbn.ARI.eq(syouhnZokusei.getCreditcardhrtekiumu())) {

                syoriKahiBean.setPhrkhouHenkouKahiKbn(C_DsPhrkhouhenkouKahiSeigyoKbn.KA);
            }
            else if (C_UmuKbn.ARI.eq(syouhnZokusei.getKouzahurikaebaraitekiumu()) &&
                C_UmuKbn.NONE.eq(syouhnZokusei.getCreditcardhrtekiumu())) {

                syoriKahiBean.setPhrkhouHenkouKahiKbn(C_DsPhrkhouhenkouKahiSeigyoKbn.KOUHURIHENKOUNOMIKA);
            }
            else {

                syoriKahiBean.setPhrkhouHenkouKahiKbn(C_DsPhrkhouhenkouKahiSeigyoKbn.HUKA);
            }
        }
        else {

            syoriKahiBean.setPhrkhouHenkouKahiKbn(C_DsPhrkhouhenkouKahiSeigyoKbn.HUKA);
        }

        if (C_UmuKbn.ARI.eq(dsDataMaintenanceHanteiBean.getDsDataMaintenanceUmuKbn())) {

            syoriKahiBean.setTargetTkhkKahiKbn(C_KahiKbn.HUKA);
            syoriKahiBean.setKykNiyuSyoukaiKahiKbn(C_KahiKbn.HUKA);
            syoriKahiBean.setTumitatekinItenKahiKbn(C_KahiKbn.HUKA);
            syoriKahiBean.setDsKaiyakuKahiKbn(C_KahiKbn.HUKA);
        }

        logger.debug("△ 処理可否情報取得 終了");

        return syoriKahiBean;
    }
}
