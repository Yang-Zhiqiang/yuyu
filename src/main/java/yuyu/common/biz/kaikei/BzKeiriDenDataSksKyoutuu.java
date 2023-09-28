package yuyu.common.biz.kaikei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.DenpyouDataParam;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KwsrendouKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_KawaseRate;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.def.db.entity.HT_SkDenpyoData;

/**
 * 業務共通 経理・会計 経理伝票データ作成共通処理
 */
public class BzKeiriDenDataSksKyoutuu {

    private BizDate syoriYmd;

    private BaseUserInfo baseUserInfo;

    private Map<String, BzTaisyakuFuittiKakuninInfoBean> taisyakuFuittiKakuninInfoMap;

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomManager;

    public BzKeiriDenDataSksKyoutuu() {
        super();
    }

    public void init(BizDate pSyoriYmd, BaseUserInfo pBaseUserInfo) {

        logger.debug("▽ 経理伝票データ作成共通処理 初期化処理 開始");

        syoriYmd = pSyoriYmd;

        baseUserInfo = pBaseUserInfo;

        taisyakuFuittiKakuninInfoMap = new HashMap<>();

        logger.debug("△ 経理伝票データ作成共通処理 初期化処理 終了");
    }

    public BT_DenpyoData setSkKeiriDenpyoData(HT_SkDenpyoData pHT_SkDenpyoData) {

        logger.debug("▽ 経理伝票データ作成共通処理 経理伝票データテーブルエンティティ設定（新契約） 開始");

        BT_DenpyoData denpyoData = new BT_DenpyoData();

        String keirisyoNo = null;

        C_KawasetekiyoKbn kawasetekiyokbn;

        if (!BizUtil.isBlank(pHT_SkDenpyoData.getMosno())) {
            keirisyoNo = pHT_SkDenpyoData.getMosno();
        }
        else {
            keirisyoNo = pHT_SkDenpyoData.getSyono();
        }

        if (C_Tuukasyu.JPY.equals(pHT_SkDenpyoData.getTuukasyu())) {
            kawasetekiyokbn = C_KawasetekiyoKbn.BLNK;
        }
        else {
            kawasetekiyokbn = C_KawasetekiyoKbn.TTM;
        }

        denpyoData.setDensyskbn(pHT_SkDenpyoData.getDensyskbn());

        denpyoData.setDenrenno(pHT_SkDenpyoData.getDenrenno());

        denpyoData.setEdano(pHT_SkDenpyoData.getEdano());

        denpyoData.setKeirisyono(keirisyoNo);

        denpyoData.setHuridenatesakicd(pHT_SkDenpyoData.getHuridenatesakicd());

        denpyoData.setTantocd(pHT_SkDenpyoData.getTantocd());

        denpyoData.setDenymd(pHT_SkDenpyoData.getDenymd());

        denpyoData.setTaisyakukbn(pHT_SkDenpyoData.getTaisyakukbn());

        denpyoData.setKanjyoukmkcd(pHT_SkDenpyoData.getKanjyoukmkcd());

        denpyoData.setSuitoubumoncd(pHT_SkDenpyoData.getSuitoubumoncd());

        denpyoData.setTuukasyu(pHT_SkDenpyoData.getTuukasyu());

        denpyoData.setDengaikagk(pHT_SkDenpyoData.getDengaikagk());

        denpyoData.setDenkawaserate(pHT_SkDenpyoData.getDenkawaserate());

        denpyoData.setDenyenkagk(pHT_SkDenpyoData.getDenyenkagk());

        denpyoData.setSyoriYmd(pHT_SkDenpyoData.getSyoriYmd());

        denpyoData.setSyoricd(pHT_SkDenpyoData.getSyoricd());

        denpyoData.setSyorisosikicd(pHT_SkDenpyoData.getSyorisosikicd());

        denpyoData.setSeg1cd(pHT_SkDenpyoData.getSeg1cd());

        denpyoData.setSeg2cd(pHT_SkDenpyoData.getSeg2cd());

        denpyoData.setKessantyouseikbn(pHT_SkDenpyoData.getKessantyouseikbn());

        denpyoData.setNaibukeiyakukbn(pHT_SkDenpyoData.getNaibukeiyakukbn());

        denpyoData.setTekiyoukbn(pHT_SkDenpyoData.getTekiyoukbn());

        denpyoData.setDensyorikbn(pHT_SkDenpyoData.getDensyorikbn());

        denpyoData.setAatsukaishasuitososhikicd(pHT_SkDenpyoData.getAatsukaishasuitososhikicd());

        denpyoData.setKykymd(pHT_SkDenpyoData.getKykymd());

        denpyoData.setBosyuuym(pHT_SkDenpyoData.getBosyuuym());

        denpyoData.setAatsukaishasoshikicd(pHT_SkDenpyoData.getAatsukaishasoshikicd());

        denpyoData.setAatkisyadaibosyuucd(pHT_SkDenpyoData.getAatkisyadaibosyuucd());

        denpyoData.setSyusyouhncd(pHT_SkDenpyoData.getSyusyouhncd());

        denpyoData.setSyouhnsdno(pHT_SkDenpyoData.getSyouhnsdno());

        denpyoData.setSdpdkbn(pHT_SkDenpyoData.getSdpdkbn());

        denpyoData.setHrkkaisuu(pHT_SkDenpyoData.getHrkkaisuu());

        denpyoData.setHrkkeiro(pHT_SkDenpyoData.getHrkkeiro());

        denpyoData.setSknnkaisiymd(pHT_SkDenpyoData.getSknnkaisiymd());

        denpyoData.setMosymd(pHT_SkDenpyoData.getMosymd());

        denpyoData.setHnknriyuukbn(pHT_SkDenpyoData.getHnknriyuukbn());

        denpyoData.setFstpryosyuymd(pHT_SkDenpyoData.getFstpryosyuymd());

        denpyoData.setAatkisyabosyuucd(pHT_SkDenpyoData.getAatkisyabosyuucd());

        denpyoData.setRyouritusdno(pHT_SkDenpyoData.getRyouritusdno());

        denpyoData.setKakokawaserateshiteiflg(pHT_SkDenpyoData.getKakokawaserateshiteiflg());

        denpyoData.setKakokawaserateshiteiymd(pHT_SkDenpyoData.getKakokawaserateshiteiymd());

        denpyoData.setKyktuukasyu(pHT_SkDenpyoData.getKyktuukasyu());

        denpyoData.setKeiyakutuukagk(pHT_SkDenpyoData.getKeiyakutuukagk());

        denpyoData.setDengyoumucd(pHT_SkDenpyoData.getDengyoumucd());

        denpyoData.setKawasetekiyokbn(kawasetekiyokbn);

        denpyoData.setDenkarikanjyono(pHT_SkDenpyoData.getDenkarikanjyono());

        denpyoData.setTaisyakutyouseiflg(pHT_SkDenpyoData.getTaisyakutyouseiflg());

        denpyoData.setGyoumuKousinsyaId(baseUserInfo.getUserId());

        denpyoData.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        BizPropertyInitializer.initialize(denpyoData);

        logger.debug("△ 経理伝票データ作成共通処理 経理伝票データテーブルエンティティ設定（新契約） 終了");

        return denpyoData;
    }

    public BT_DenpyoData setKeiriDenpyoData(DenpyouDataParam pDenpyouDataParam) {

        logger.debug("▽ 経理伝票データ作成共通処理 経理伝票データテーブルエンティティ設定 開始");

        C_KawasetekiyoKbn kawasetekiyokbn;

        if (C_Tuukasyu.JPY.equals(pDenpyouDataParam.getTuukasyu())) {
            kawasetekiyokbn = C_KawasetekiyoKbn.BLNK;
        }
        else if (C_KawasetekiyoKbn.BLNK.equals(pDenpyouDataParam.getKawasetekiyokbn())) {
            kawasetekiyokbn = C_KawasetekiyoKbn.TTM;
        }
        else {
            kawasetekiyokbn = pDenpyouDataParam.getKawasetekiyokbn();
        }

        BT_DenpyoData denpyoData = new BT_DenpyoData();

        denpyoData.setDensyskbn(pDenpyouDataParam.getDensyskbn());

        denpyoData.setDenrenno(pDenpyouDataParam.getDenrenno());

        denpyoData.setEdano(pDenpyouDataParam.getEdano());

        denpyoData.setKeirisyono(pDenpyouDataParam.getSyono());

        denpyoData.setHuridenatesakicd(pDenpyouDataParam.getHuridenatesakicd());

        denpyoData.setTantocd(pDenpyouDataParam.getTantocd());

        denpyoData.setDenymd(pDenpyouDataParam.getDenymd());

        denpyoData.setTaisyakukbn(pDenpyouDataParam.getTaisyakukbn());

        denpyoData.setKanjyoukmkcd(pDenpyouDataParam.getKanjyoukmkcd());

        denpyoData.setSuitoubumoncd(pDenpyouDataParam.getSuitoubumoncd());

        denpyoData.setTuukasyu(pDenpyouDataParam.getTuukasyu());

        denpyoData.setDengaikagk(pDenpyouDataParam.getDengaikagk());

        denpyoData.setDenkawaserate(pDenpyouDataParam.getDenkawaserate());

        denpyoData.setDenyenkagk(pDenpyouDataParam.getDenyenkagk());

        denpyoData.setHuridenskskbn(pDenpyouDataParam.getHuridenskskbn());

        denpyoData.setDenhnknhoukbn(pDenpyouDataParam.getDenhnknhoukbn());

        denpyoData.setDenshrhoukbn(pDenpyouDataParam.getDenshrhoukbn());

        denpyoData.setSyoriYmd(pDenpyouDataParam.getSyoriYmd());

        denpyoData.setSyoricd(pDenpyouDataParam.getSyoricd());

        denpyoData.setSyorisosikicd(pDenpyouDataParam.getSyorisosikicd());

        denpyoData.setSeg1cd(pDenpyouDataParam.getSeg1cd());

        denpyoData.setSeg2cd(pDenpyouDataParam.getSeg2cd());

        denpyoData.setSyusyouhncd(pDenpyouDataParam.getSyusyouhncd());

        denpyoData.setSyouhnsdno(pDenpyouDataParam.getSyouhnsdno());

        denpyoData.setKakokawaserateshiteiflg(pDenpyouDataParam.getKakokawaserateshiteiflg());

        denpyoData.setKakokawaserateshiteiymd(pDenpyouDataParam.getKakokawaserateshiteiymd());

        denpyoData.setKyktuukasyu(pDenpyouDataParam.getKyktuukasyu());

        denpyoData.setKeiyakutuukagk(pDenpyouDataParam.getKeiyakutuukagk());

        denpyoData.setDengyoumucd(pDenpyouDataParam.getDengyoumucd());

        denpyoData.setKawasetekiyokbn(kawasetekiyokbn);

        denpyoData.setDenkarikanjyono(pDenpyouDataParam.getDenkarikanjyono());

        denpyoData.setTaisyakutyouseiflg(pDenpyouDataParam.getTaisyakutyouseiflg());

        denpyoData.setDensyorisyousaikbn(pDenpyouDataParam.getDensyorisyousaikbn());

        denpyoData.setGyoumuKousinsyaId(baseUserInfo.getUserId());

        denpyoData.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        BizPropertyInitializer.initialize(denpyoData);

        logger.debug("△ 経理伝票データ作成共通処理 経理伝票データテーブルエンティティ設定 終了");

        return denpyoData;
    }

    public void changeGaikaData(BT_DenpyoData pBT_DenpyoData) {

        logger.debug("▽ 経理伝票データ作成共通処理 外貨データ円変換処理 開始");

        if(pBT_DenpyoData.getDenyenkagk() == null || pBT_DenpyoData.getDenyenkagk().isZeroOrOptional()) {

            BizNumber denpyouRate = getDenpyoKawaseRate(pBT_DenpyoData);

            BizCurrency denyenKagk = changeGaika(pBT_DenpyoData.getDengaikagk(), denpyouRate);

            pBT_DenpyoData.setDenyenkagk(denyenKagk);

            pBT_DenpyoData.setDenkawaserate(denpyouRate);
        }

        BzTaisyakuFuittiKakuninInfoBean bzTFKInfoBean;

        if (taisyakuFuittiKakuninInfoMap.containsKey(pBT_DenpyoData.getDenrenno())) {
            bzTFKInfoBean = taisyakuFuittiKakuninInfoMap.get(pBT_DenpyoData.getDenrenno());
        }
        else {
            bzTFKInfoBean = SWAKInjector.getInstance(BzTaisyakuFuittiKakuninInfoBean.class);
            bzTFKInfoBean.setDensysKbn(pBT_DenpyoData.getDensyskbn());
            bzTFKInfoBean.setDenrenNo(pBT_DenpyoData.getDenrenno());
            bzTFKInfoBean.setKariGoukeiKagk(BizCurrency.valueOf(0));
            bzTFKInfoBean.setKariMaxKagk(BizCurrency.valueOf(0));
            bzTFKInfoBean.setKasiGoukeiKagk(BizCurrency.valueOf(0));
            bzTFKInfoBean.setKasiMaxKagk(BizCurrency.valueOf(0));
            bzTFKInfoBean.setKariTyouseiFlg(false);
            bzTFKInfoBean.setKasiTyouseiFlg(false);
            bzTFKInfoBean.setSyono(pBT_DenpyoData.getKeirisyono());
            taisyakuFuittiKakuninInfoMap.put(pBT_DenpyoData.getDenrenno(), bzTFKInfoBean);
        }

        if (C_TaisyakuKbn.KARIKATA.eq(pBT_DenpyoData.getTaisyakukbn())) {
            bzTFKInfoBean.setKariGoukeiKagk(bzTFKInfoBean.getKariGoukeiKagk().add(pBT_DenpyoData.getDenyenkagk()));

            if ((bzTFKInfoBean.getKariTyouseiFlg() == true && pBT_DenpyoData.getTaisyakutyouseiflg() == true)
                || (bzTFKInfoBean.getKariTyouseiFlg() == false && pBT_DenpyoData.getTaisyakutyouseiflg() == false)) {

                if (bzTFKInfoBean.getKariMaxKagk().compareTo(pBT_DenpyoData.getDenyenkagk()) < 0) {

                    bzTFKInfoBean.setKariMaxKagk(pBT_DenpyoData.getDenyenkagk());
                    bzTFKInfoBean.setKariMaxKagkEdano(pBT_DenpyoData.getEdano());
                }
            }
            else if (bzTFKInfoBean.getKariTyouseiFlg() == false
                && pBT_DenpyoData.getTaisyakutyouseiflg() == true) {

                bzTFKInfoBean.setKariMaxKagk(pBT_DenpyoData.getDenyenkagk());
                bzTFKInfoBean.setKariMaxKagkEdano(pBT_DenpyoData.getEdano());
                bzTFKInfoBean.setKariTyouseiFlg(true);
            }
        }
        else if (C_TaisyakuKbn.KASIKATA.eq(pBT_DenpyoData.getTaisyakukbn())) {
            bzTFKInfoBean.setKasiGoukeiKagk(bzTFKInfoBean.getKasiGoukeiKagk().add(pBT_DenpyoData.getDenyenkagk()));

            if ((bzTFKInfoBean.getKasiTyouseiFlg() == true && pBT_DenpyoData.getTaisyakutyouseiflg() == true)
                || (bzTFKInfoBean.getKasiTyouseiFlg() == false && pBT_DenpyoData.getTaisyakutyouseiflg() == false)) {

                if (bzTFKInfoBean.getKasiMaxKagk().compareTo(pBT_DenpyoData.getDenyenkagk()) < 0) {

                    bzTFKInfoBean.setKasiMaxKagk(pBT_DenpyoData.getDenyenkagk());
                    bzTFKInfoBean.setKasiMaxKagkEdano(pBT_DenpyoData.getEdano());
                }
            }
            else if (bzTFKInfoBean.getKasiTyouseiFlg() == false && (pBT_DenpyoData.getTaisyakutyouseiflg() == true)) {

                bzTFKInfoBean.setKasiMaxKagk(pBT_DenpyoData.getDenyenkagk());
                bzTFKInfoBean.setKasiMaxKagkEdano(pBT_DenpyoData.getEdano());
                bzTFKInfoBean.setKasiTyouseiFlg(true);
            }
        }

        logger.debug("△ 経理伝票データ作成共通処理 外貨データ円変換処理 終了");
    }

    public BizNumber getDenpyoKawaseRate(BT_DenpyoData pBT_DenpyoData) {

        logger.debug("▽ 経理伝票データ作成共通処理 伝票用為替レート取得 開始");

        BizDate kawaseKijyunymd = null;

        if (pBT_DenpyoData.getKakokawaserateshiteiflg() == true) {

            kawaseKijyunymd = pBT_DenpyoData.getKakokawaserateshiteiymd();
        }
        else {

            kawaseKijyunymd = syoriYmd;
        }

        BM_KawaseRate kawaseRate = bizDomManager.getKawaseRate(kawaseKijyunymd, C_KwsrendouKbn.PM17JIKAWASERATE,
            pBT_DenpyoData.getTuukasyu(), C_Tuukasyu.JPY, pBT_DenpyoData.getKawasetekiyokbn(), C_KawasetsryKbn.JISSEIRATE);

        logger.debug("△ 経理伝票データ作成共通処理 伝票用為替レート取得 終了");

        return kawaseRate.getKawaserate();
    }

    public BizCurrency changeGaika(BizCurrency pDengaikagk, BizNumber pKawaserate) {

        logger.debug("▽ 経理伝票データ作成共通処理 外貨円換算処理 開始");

        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

        BizCurrency kannsann = keisanGaikakanzan.exec(C_Tuukasyu.JPY, pDengaikagk, pKawaserate, C_HasuusyoriKbn.SUTE);

        logger.debug("△ 経理伝票データ作成共通処理 外貨円換算処理 終了");

        return kannsann;
    }

    public List<BzTaisyakuFuittiInfoBean> getGaikaTaisyakuFuittiInfo() {

        logger.debug("▽ 経理伝票データ作成共通処理 外貨データ貸借不一致情報取得 開始");

        List<BzTaisyakuFuittiInfoBean> bzTaisyakuFuittiInfoList = new ArrayList<>();

        for (Map.Entry<String, BzTaisyakuFuittiKakuninInfoBean> entry : taisyakuFuittiKakuninInfoMap.entrySet()) {

            BzTaisyakuFuittiKakuninInfoBean bzTFKInfoBean = entry.getValue();

            if (bzTFKInfoBean.getKariGoukeiKagk().compareTo(bzTFKInfoBean.getKasiGoukeiKagk()) == 0) {
                continue;
            }

            BzTaisyakuFuittiInfoBean bzTaisyakuFuittiInfoBean = SWAKInjector
                .getInstance(BzTaisyakuFuittiInfoBean.class);

            bzTaisyakuFuittiInfoBean.setDensysKbn(bzTFKInfoBean.getDensysKbn());
            bzTaisyakuFuittiInfoBean.setDenrenNo(bzTFKInfoBean.getDenrenNo());
            if (bzTFKInfoBean.getKariGoukeiKagk().compareTo(bzTFKInfoBean.getKasiGoukeiKagk()) > 0) {

                BizCurrency sagaku = bzTFKInfoBean.getKariGoukeiKagk().subtract(bzTFKInfoBean.getKasiGoukeiKagk());

                bzTaisyakuFuittiInfoBean.setEdaNo(bzTFKInfoBean.getKasiMaxKagkEdano());

                bzTaisyakuFuittiInfoBean.setKagk(bzTFKInfoBean.getKasiMaxKagk().add(sagaku));

                bzTFKInfoBean.setKasiGoukeiKagk(bzTFKInfoBean.getKasiGoukeiKagk().add(sagaku));
            }

            else if (bzTFKInfoBean.getKariGoukeiKagk().compareTo(bzTFKInfoBean.getKasiGoukeiKagk()) < 0) {

                BizCurrency sagaku = bzTFKInfoBean.getKasiGoukeiKagk().subtract(bzTFKInfoBean.getKariGoukeiKagk());

                bzTaisyakuFuittiInfoBean.setEdaNo(bzTFKInfoBean.getKariMaxKagkEdano());

                bzTaisyakuFuittiInfoBean.setKagk(bzTFKInfoBean.getKariMaxKagk().add(sagaku));

                bzTFKInfoBean.setKariGoukeiKagk(bzTFKInfoBean.getKariGoukeiKagk().add(sagaku));
            }
            bzTaisyakuFuittiInfoList.add(bzTaisyakuFuittiInfoBean);

            if (bzTFKInfoBean.getKariGoukeiKagk().compareTo(bzTFKInfoBean.getKasiGoukeiKagk()) != 0) {
                throw new BizLogicException(MessageId.EBC0001, "貸借合計金額が不一致です。伝票用システム区分="
                    + bzTFKInfoBean.getDensysKbn().getValue() + "、伝票データ連番="
                    + bzTFKInfoBean.getDenrenNo() + "、証券番号=" + bzTFKInfoBean.getSyono());
            }
        }
        logger.debug("△ 経理伝票データ作成共通処理 外貨データ貸借不一致情報取得 終了");

        return bzTaisyakuFuittiInfoList;
    }
}
