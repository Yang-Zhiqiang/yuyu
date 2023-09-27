package yuyu.common.direct.dscommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyaku;
import yuyu.common.hozen.khcommon.KeisanKaiyakuBean;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyakuOutBean;
import yuyu.common.direct.dscommon.dba4checkkaiyakuuketuke.CheckKaiyakuUketukeDao;
import yuyu.def.MessageId;
import yuyu.def.classification.C_BankmasterUmuKbn;
import yuyu.def.classification.C_CheckKaiyakuUketukeKekkaKbn;
import yuyu.def.classification.C_ChkkekkaKbn;
import yuyu.def.classification.C_DsKaiyakuchkkekkaKbn;
import yuyu.def.classification.C_DsKokyakuJtKbn;
import yuyu.def.classification.C_DsSyouhnbunruiKbn;
import yuyu.def.classification.C_DsTeisiRiyuuKbn;
import yuyu.def.classification.C_DsTrhkserviceRiyoujkKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_IdoutyuuHanteiKekkaKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_SoukinyoukzchkkekkaKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.entity.MT_DsSoukinyouKouza;
import yuyu.def.db.entity.MT_DsTorihikiServiceKanri;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.dsweb.configuration.YuyuDswebConfig;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * ダイレクトサービス ダイレクトサービス共通  解約受付チェック
 */
public class CheckKaiyakuUketuke {

    private String message;

    private String messageId;

    private String messageParam;

    private C_CheckKaiyakuUketukeKekkaKbn checkKaiyakuUketukeKekkaKbn;

    @Inject
    private static Logger logger;

    @Inject
    private CheckKaiyakuUketukeDao checkKaiyakuUketukeDao;

    @Inject
    private DirectDomManager directDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    public CheckKaiyakuUketuke(){
        super();
    }

    public String getMessage() {
        return message;
    }

    public String getMessageId() {
        return messageId;
    }

    public String getMessageParam() {
        return messageParam;
    }

    public C_CheckKaiyakuUketukeKekkaKbn getCheckKaiyakuUketukeKekkaKbn() {
        return checkKaiyakuUketukeKekkaKbn;
    }

    public C_ErrorKbn kaiyakusyokaiChk(String pSyoNo) {

        logger.debug("▽ 解約照会時チェック 開始");

        if (C_ErrorKbn.ERROR.eq(telkaiyakuKadoutimeChk())) {

            logger.debug("△ 解約照会時チェック 終了");

            return C_ErrorKbn.ERROR;
        }

        if (C_ErrorKbn.ERROR.eq(dskokyakujtChk(pSyoNo))) {

            logger.debug("△ 解約照会時チェック 終了");

            return C_ErrorKbn.ERROR;
        }

        MT_DsKokyakuKanri dsKokyakuKanri = checkKaiyakuUketukeDao.getYuukouKeiyakuDskokyakuInfoBySyono(pSyoNo);

        String dskokno = dsKokyakuKanri.getDskokno();

        if (C_ErrorKbn.ERROR.eq(tokuteitrhkkzYuukoujtChk(pSyoNo, dskokno))) {

            logger.debug("△ 解約照会時チェック 終了");

            return C_ErrorKbn.ERROR;
        }

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyoNo);

        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        C_Tuukasyu kyktuukasyu = kykSyouhn.getKyktuukasyu();

        if (!C_Tuukasyu.JPY.eq(kyktuukasyu)) {

            if (C_ErrorKbn.ERROR.eq(kawaserateExistChk(kyktuukasyu))) {

                logger.debug("△ 解約照会時チェック 終了");

                return C_ErrorKbn.ERROR;
            }
        }

        if (C_ErrorKbn.ERROR.eq(kykymdMaeChk(pSyoNo))) {

            logger.debug("△ 解約照会時チェック 終了");

            return C_ErrorKbn.ERROR;
        }

        if (C_ErrorKbn.ERROR.eq(dsDataMaintenanceChk(pSyoNo))){

            logger.debug("△ 解約照会時チェック 終了");

            return C_ErrorKbn.ERROR;
        }

        if (C_ErrorKbn.ERROR.eq(tokuteitrhkkzMstExistChk(pSyoNo, dskokno, C_KouzasyuruiKbn.YENKOUZA))) {

            logger.debug("△ 解約照会時チェック 終了");

            return C_ErrorKbn.ERROR;
        }

        if (C_ErrorKbn.ERROR.eq(dskaiyakuChk(pSyoNo))) {

            logger.debug("△ 解約照会時チェック 終了");

            return C_ErrorKbn.ERROR;
        }

        if (C_ErrorKbn.ERROR.eq(tokuteitrhkkzChk(pSyoNo, dskokno, C_KouzasyuruiKbn.YENKOUZA))) {

            logger.debug("△ 解約照会時チェック 終了");

            return C_ErrorKbn.ERROR;
        }

        if (C_ErrorKbn.ERROR.eq(dskaiyakuukeumuChk(pSyoNo))) {

            logger.debug("△ 解約照会時チェック 終了");

            return C_ErrorKbn.ERROR;
        }

        logger.debug("△ 解約照会時チェック 終了");

        return C_ErrorKbn.OK;

    }

    public C_ErrorKbn telkaiyakuKadoutimeChk() {

        logger.debug("▽ 電話解約稼働時間チェック 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        BizDate sysDate = BizDate.getSysDate();

        String sysDateTime = BizDate.getSysDateTimeMilli();

        String kaiyakuServiceKadouKaisiTime = YuyuDswebConfig.getInstance().getKaiyakuServiceKadouKaisiTime();

        String denwakaiyakuKadouSyuuryouTime = YuyuDswebConfig.getInstance().getDenwakaiyakuKadouSyuuryouTime();

        if (Integer.parseInt(kaiyakuServiceKadouKaisiTime) <= Integer.parseInt(sysDateTime.substring(8, sysDateTime.length()))
            && Integer.parseInt(sysDateTime.substring(8, sysDateTime.length())) < Integer.parseInt(denwakaiyakuKadouSyuuryouTime)) {


        }

        else {
            message = MessageUtil.getMessage(MessageId.EMF1027);

            messageId = MessageId.EMF1027;

            checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.KADOUZIKANGAI;

            errorKbn = C_ErrorKbn.ERROR;
        }

        if (sysDate.isHoliday()) {
            message = MessageUtil.getMessage(MessageId.EMF1027);

            messageId = MessageId.EMF1027;

            checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.KADOUZIKANGAI;

            errorKbn = C_ErrorKbn.ERROR;
        }

        logger.debug("△ 電話解約稼働時間チェック 終了");

        return errorKbn;

    }

    public C_ErrorKbn dskokyakujtChk(String pSyoNo) {

        logger.debug("▽ ＤＳ顧客状態チェック 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        MT_DsKokyakuKanri mtDsKokyakuKanri = checkKaiyakuUketukeDao.getYuukouKeiyakuDskokyakuInfoBySyono(pSyoNo);

        if (mtDsKokyakuKanri == null) {

            message = MessageUtil.getMessage(MessageId.EMF1033);

            messageId = MessageId.EMF1033;

            checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.DSMIKANYUUKEIYAKU;

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△ ＤＳ顧客状態チェック 終了");

            return errorKbn;
        }

        C_DsKokyakuJtKbn dskokyakujtkbn = mtDsKokyakuKanri.getDskokyakujtkbn();

        if (C_DsKokyakuJtKbn.ITIJI_TEISI.eq(dskokyakujtkbn)) {

            if (C_DsTeisiRiyuuKbn.OMOUSIDE.eq(mtDsKokyakuKanri.getDsteisiriyuukbn()) ||
                C_DsTeisiRiyuuKbn.SONOTA.eq(mtDsKokyakuKanri.getDsteisiriyuukbn())) {

                message = MessageUtil.getMessage(MessageId.EMF1041);

                messageId = MessageId.EMF1041;

                checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.DSITIZITEISITYUU;

                errorKbn = C_ErrorKbn.ERROR;

                logger.debug("△ ＤＳ顧客状態チェック 終了");

                return errorKbn;
            }
        }

        else if (C_DsKokyakuJtKbn.YUUKOU.eq(dskokyakujtkbn)) {


        }

        else {

            message = MessageUtil.getMessage(MessageId.EMF1043, String.valueOf(dskokyakujtkbn));

            messageId = MessageId.EMF1043;

            messageParam = String.valueOf(dskokyakujtkbn);

            checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.SYSTEMERROR;

            logger.error(message);

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△ ＤＳ顧客状態チェック 終了");

            return errorKbn;
        }

        HozenKeiyakuIdouJyoutaiSyutoku hozenKeiyakuIdouJyoutaiSyutoku = SWAKInjector.getInstance(HozenKeiyakuIdouJyoutaiSyutoku.class);

        hozenKeiyakuIdouJyoutaiSyutoku.setDetachYouhiKbn(C_YouhiKbn.HUYOU);

        HozenKeiyakuIdouJyoutaiSyutokuBean hkijsBean = hozenKeiyakuIdouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutoku(pSyoNo);

        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = hkijsBean.getIdoutyuuKbn();

        if (C_IdoutyuuHanteiKekkaKbn.IDOUTYUU.eq(idoutyuuKbn)) {

            message = MessageUtil.getMessage(MessageId.EMF1042);

            messageId = MessageId.EMF1042;

            checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.DSIDOUTYUU;

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△ ＤＳ顧客状態チェック 終了");

            return errorKbn;
        }

        else if (C_IdoutyuuHanteiKekkaKbn.ERROR.eq(idoutyuuKbn)) {

            String msgParam = "保全契約異動状態取得（証券番号：" + pSyoNo + "）";

            message = MessageUtil.getMessage(MessageId.EBF0129, msgParam);

            messageId = MessageId.EBF0129;

            messageParam = msgParam;

            checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.SYSTEMERROR;

            logger.error(message);

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△ ＤＳ顧客状態チェック 終了");

            return errorKbn;
        }

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(mtDsKokyakuKanri.getDskokno());

        MT_DsKokyakuKeiyaku dsKokyakuKeiyakuBySyono = dsKokyakuKanri.getDsKokyakuKeiyakuBySyono(pSyoNo);

        MT_DsTorihikiServiceKanri dsTorihikiServiceKanri = dsKokyakuKeiyakuBySyono.getDsTorihikiServiceKanri();

        if (dsTorihikiServiceKanri == null) {

            message = MessageUtil.getMessage(MessageId.EMF1031);

            messageId = MessageId.EMF1031;

            checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.TOKUTEIKOUZAMITOUROKU;

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△ ＤＳ顧客状態チェック 終了");

            return errorKbn;
        }

        logger.debug("△ ＤＳ顧客状態チェック 終了");

        return errorKbn;

    }

    public C_ErrorKbn tokuteitrhkkzYuukoujtChk(String pSyoNo, String pDskokNo) {

        logger.debug("▽ 特定取引用口座有効状態チェック 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(pDskokNo);

        MT_DsKokyakuKeiyaku dsKokyakuKeiyakuBySyono = dsKokyakuKanri.getDsKokyakuKeiyakuBySyono(pSyoNo);

        MT_DsTorihikiServiceKanri dsTorihikiServiceKanri = dsKokyakuKeiyakuBySyono.getDsTorihikiServiceKanri();

        if (C_DsTrhkserviceRiyoujkKbn.RIYOU_HUKA.eq(dsTorihikiServiceKanri.getDstrhkserviceriyoujkkbn())) {

            message = MessageUtil.getMessage(MessageId.EMF1029);

            messageId = MessageId.EMF1029;

            checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.TOKUTEIKOUZAMUKOU;

            errorKbn = C_ErrorKbn.ERROR;
        }

        logger.debug("△ 特定取引用口座有効状態チェック 終了");

        return errorKbn;

    }

    public C_ErrorKbn kawaserateExistChk(C_Tuukasyu pTuukasyu) {

        logger.debug("▽ 為替レート存在チェック 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        C_ErrorKbn kawaseErrorKbn = getKawaseRate.exec(
            BizDate.getSysDate(),
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            pTuukasyu,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.SYUKKINRATE,
            C_EigyoubiHoseiKbn.BLNK,
            C_YouhiKbn.HUYOU);

        if (C_ErrorKbn.ERROR.eq(kawaseErrorKbn)) {

            message = MessageUtil.getMessage(MessageId.EMF1040);

            messageId = MessageId.EMF1040;

            checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.KAWASERATEMITOUTYAKU;

            errorKbn = C_ErrorKbn.ERROR;
        }

        logger.debug("△ 為替レート存在チェック 終了");

        return errorKbn;

    }

    public C_ErrorKbn kykymdMaeChk(String pSyoNo) {

        logger.debug("▽ 契約日前チェック 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyoNo);

        IT_KykSyouhn KykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        if (BizDateUtil.compareYmd(BizDate.getSysDate(), KykSyouhn.getKykymd()) == BizDateUtil.COMPARE_LESSER) {

            message = MessageUtil.getMessage(MessageId.EIA0070, "手続日");

            messageId = MessageId.EIA0070;

            messageParam = "手続日";

            checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.KEIYAKUYMDMAE;

            errorKbn = C_ErrorKbn.ERROR;
        }

        logger.debug("△ 契約日前チェック 終了");

        return errorKbn;

    }


    public C_ErrorKbn dsDataMaintenanceChk(String pSyoNo) {

        logger.debug("▽ ＤＳデータメンテナンス中チェック 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        DsDataMaintenanceHantei dsDataMaintenanceHantei = SWAKInjector.getInstance(DsDataMaintenanceHantei.class);

        DsDataMaintenanceHanteiBean dsDataMaintenanceHanteiBean = dsDataMaintenanceHantei.exec(pSyoNo);

        if (C_UmuKbn.ARI.eq(dsDataMaintenanceHanteiBean.getDsDataMaintenanceUmuKbn())) {

            message = MessageUtil.getMessage(MessageId.EMF1053);

            messageId = MessageId.EMF1053;

            checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.DSDATAMAINTENANCE;

            errorKbn = C_ErrorKbn.ERROR;
        }

        logger.debug("△ ＤＳデータメンテナンス中チェック 終了");

        return errorKbn;

    }

    public C_ErrorKbn tokuteitrhkkzMstExistChk(String pSyoNo, String pDskokNo, C_KouzasyuruiKbn pKouzasyuruiKbn) {

        logger.debug("▽ 特定取引用口座マスタ存在チェック 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        MT_DsSoukinyouKouza mtDsSoukinyouKouza =
            checkKaiyakuUketukeDao.getDsSoukinyouKouzaByDskoknoSyonoKouzaSyuruiKbn(pDskokNo, pSyoNo, pKouzasyuruiKbn);

        BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(mtDsSoukinyouKouza.getBankcd(), mtDsSoukinyouKouza.getSitencd());

        if (C_BankmasterUmuKbn.NONE.eq(bzGetBankDataBean.getBankmasterUmuKbn())) {

            message = MessageUtil.getMessage(MessageId.EMF1032);

            messageId = MessageId.EMF1032;

            checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.GINKOUMASTERSONZAI;

            errorKbn = C_ErrorKbn.ERROR;
        }

        logger.debug("△ 特定取引用口座マスタ存在チェック 終了");

        return errorKbn;

    }

    public C_ErrorKbn dskaiyakuChk(String pSyoNo) {

        logger.debug("▽ ＤＳ解約共通チェック 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyoNo);

        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        KeisanCommonKaiyaku keisanCommonKaiyaku = SWAKInjector.getInstance(KeisanCommonKaiyaku.class);

        KeisanKaiyakuBean keisanKaiyakuBean = new KeisanKaiyakuBean();

        KeisanCommonKaiyakuOutBean keisanCommonKaiyakuOutBean = new KeisanCommonKaiyakuOutBean();

        C_ErrorKbn kawaseErrorKbn = getKawaseRate.exec(
            BizDate.getSysDate(),
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            kykSyouhn.getKyktuukasyu(),
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.SYUKKINRATE,
            C_EigyoubiHoseiKbn.BLNK,
            C_YouhiKbn.HUYOU);

        keisanKaiyakuBean.setSyoruiukeymd(BizDate.getSysDate());
        keisanKaiyakuBean.setKaiykymd(BizDate.getSysDate());
        keisanKaiyakuBean.setYenshrkwsrate(getKawaseRate.getKawaserate());

        C_ErrorKbn keisanCommonKaiyakuErrorKbn = keisanCommonKaiyaku.keisanKaiyakuseisankin(
            KeisanCommonKaiyaku.KINOUBUNRUI_DRCTSERVICE,
            kykKihon,
            BizDate.getSysDate(),
            keisanKaiyakuBean);

        keisanCommonKaiyakuOutBean = keisanCommonKaiyaku.getKeisanCommonKaiyakuOutBean();

        BizCurrency shrgkkeiyen = BizCurrency.valueOf(0);

        if (C_ErrorKbn.ERROR.eq(keisanCommonKaiyakuErrorKbn)) {

            String msgParam = "解約共通計算（証券番号：" + pSyoNo + "、処理年月日：" + BizDate.getSysDate() +"）";

            message = MessageUtil.getMessage(MessageId.EBF0129, msgParam);

            messageId = MessageId.EBF0129;

            messageParam = msgParam;

            checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.SYSTEMERROR;

            logger.error(message);

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△ ＤＳ解約共通チェック 終了");

            return errorKbn;
        }

        shrgkkeiyen = keisanCommonKaiyakuOutBean.getShrgkkeiYen();

        CheckDsKaiyaku checkDsKaiyaku = SWAKInjector.getInstance(CheckDsKaiyaku.class);

        CheckDsKaiyakuResultBean checkDsKaiyakuResultBean = checkDsKaiyaku.kaiyakukytChk(pSyoNo, BizDate.getSysDate(),
            shrgkkeiyen, C_DsSyouhnbunruiKbn.BLNK);

        C_DsKaiyakuchkkekkaKbn dsKaiyakuchkkekkaKbn = checkDsKaiyakuResultBean.getDsKaiyakuchkkekkaKbn();

        String msgPam = checkDsKaiyakuResultBean.getMsgPam();

        if (C_ErrorKbn.ERROR.eq(checkDsKaiyakuResultBean.getErrorKbn())) {

            if (C_DsKaiyakuchkkekkaKbn.HOZENJYOUTAI.eq(dsKaiyakuchkkekkaKbn)) {

                message = MessageUtil.getMessage(MessageId.EIA0035, msgPam);

                messageId = MessageId.EIA0035;

                messageParam = msgPam;

                checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.HOZENYUUKOUJYOUTAI;

                errorKbn = C_ErrorKbn.ERROR;

                logger.debug("△ ＤＳ解約共通チェック 終了");

                return errorKbn;
            }

            else if (C_DsKaiyakuchkkekkaKbn.TETUDUKITYUUI.eq(dsKaiyakuchkkekkaKbn)) {

                message = MessageUtil.getMessage(MessageId.EIA1006, msgPam);

                messageId = MessageId.EIA1006;

                messageParam = msgPam;

                checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.TETUDUKITYUUI;

                errorKbn = C_ErrorKbn.ERROR;

                logger.debug("△ ＤＳ解約共通チェック 終了");

                return errorKbn;

            }

            else if (C_DsKaiyakuchkkekkaKbn.SITIKENSETTEI.eq(dsKaiyakuchkkekkaKbn)) {

                message = MessageUtil.getMessage(MessageId.EIF1027);

                messageId = MessageId.EIF1027;

                checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.SITIKENSETTEI;

                errorKbn = C_ErrorKbn.ERROR;

                logger.debug("△ ＤＳ解約共通チェック 終了");

                return errorKbn;

            }

            else if (C_DsKaiyakuchkkekkaKbn.YENDATEHENKOUMAE.eq(dsKaiyakuchkkekkaKbn)) {

                message = MessageUtil.getMessage(MessageId.EMF1034);

                messageId = MessageId.EMF1034;

                checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.YENDATEHENKOUMAE;

                errorKbn = C_ErrorKbn.ERROR;

                logger.debug("△ ＤＳ解約共通チェック 終了");

                return errorKbn;

            }

            else if (C_DsKaiyakuchkkekkaKbn.SAKIYMDHENKOU.eq(dsKaiyakuchkkekkaKbn)) {

                message = MessageUtil.getMessage(MessageId.EIA0106);

                messageId = MessageId.EIA0106;

                checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.SAKIYMDHENKOU;

                errorKbn = C_ErrorKbn.ERROR;

                logger.debug("△ ＤＳ解約共通チェック 終了");

                return errorKbn;

            }

            else if (C_DsKaiyakuchkkekkaKbn.KYKYMDMAE.eq(dsKaiyakuchkkekkaKbn)) {

                message = MessageUtil.getMessage(MessageId.EIA0070, "手続日");

                messageId = MessageId.EIA0070;

                messageParam = "手続日";

                checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.KEIYAKUYMDMAE;

                errorKbn = C_ErrorKbn.ERROR;

                logger.debug("△ ＤＳ解約共通チェック 終了");

                return errorKbn;

            }

            else if (C_DsKaiyakuchkkekkaKbn.HAITOUKIN.eq(dsKaiyakuchkkekkaKbn)) {

                message = MessageUtil.getMessage(MessageId.EIF1107);

                messageId = MessageId.EIF1107;

                checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.HAITOUKIN;

                errorKbn = C_ErrorKbn.ERROR;

                logger.debug("△ ＤＳ解約共通チェック 終了");

                return errorKbn;

            }

            else if (C_DsKaiyakuchkkekkaKbn.MFHUSEIGOU.eq(dsKaiyakuchkkekkaKbn)) {

                message = MessageUtil.getMessage(MessageId.EMF1047);

                messageId = MessageId.EMF1047;

                checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.MFHUSEIGOU;

                errorKbn = C_ErrorKbn.ERROR;

                logger.debug("△ ＤＳ解約共通チェック 終了");

                return errorKbn;

            }

            else if (C_DsKaiyakuchkkekkaKbn.MIHANEIHAITOUKIN.eq(dsKaiyakuchkkekkaKbn)) {

                message = MessageUtil.getMessage(MessageId.EMF1048);

                messageId = MessageId.EMF1048;

                checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.MIHANEIHAITOUKIN;

                errorKbn = C_ErrorKbn.ERROR;

                logger.debug("△ ＤＳ解約共通チェック 終了");

                return errorKbn;

            }

            else if (C_DsKaiyakuchkkekkaKbn.HAITOUKINHANEIYMDSONZAI.eq(dsKaiyakuchkkekkaKbn)) {

                message = MessageUtil.getMessage(MessageId.EMF1049);

                messageId = MessageId.EMF1049;

                checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.HAITOUKINHANEIYMDSONZAI;

                errorKbn = C_ErrorKbn.ERROR;

                logger.debug("△ ＤＳ解約共通チェック 終了");

                return errorKbn;

            }

            else if (C_DsKaiyakuchkkekkaKbn.MIHANEITUMITATEKIN.eq(dsKaiyakuchkkekkaKbn)) {

                message = MessageUtil.getMessage(MessageId.EMF1051);

                messageId = MessageId.EMF1051;

                checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.MIHANEITUMITATEKIN;

                errorKbn = C_ErrorKbn.ERROR;

                logger.debug("△ ＤＳ解約共通チェック 終了");

                return errorKbn;

            }

            else if (C_DsKaiyakuchkkekkaKbn.ZENNOUMIJYUUTOU.eq(dsKaiyakuchkkekkaKbn)) {

                message = MessageUtil.getMessage(MessageId.EMF1052);

                messageId = MessageId.EMF1052;

                checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.ZENNOUMIJYUUTOU;

                errorKbn = C_ErrorKbn.ERROR;

                logger.debug("△ ＤＳ解約共通チェック 終了");

                return errorKbn;

            }

            else if (C_DsKaiyakuchkkekkaKbn.SOUKINJYOUGEN.eq(dsKaiyakuchkkekkaKbn)) {

                message = MessageUtil.getMessage(MessageId.EMF1035);

                messageId = MessageId.EMF1035;

                checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.SOUKINJYOUGEN;

                errorKbn = C_ErrorKbn.ERROR;

                logger.debug("△ ＤＳ解約共通チェック 終了");

                return errorKbn;

            }

            else if (C_DsKaiyakuchkkekkaKbn.HARAIKOMIYUYOKIKAN.eq(dsKaiyakuchkkekkaKbn)) {

                message = MessageUtil.getMessage(MessageId.EMF1050);

                messageId = MessageId.EMF1050;

                checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.HARAIKOMIYUYOKIKAN;

                errorKbn = C_ErrorKbn.ERROR;

                logger.debug("△ ＤＳ解約共通チェック 終了");

                return errorKbn;

            }

            else {

                message = MessageUtil.getMessage(MessageId.EMF1045, String.valueOf(dsKaiyakuchkkekkaKbn));

                messageId = MessageId.EMF1045;

                messageParam = String.valueOf(dsKaiyakuchkkekkaKbn);

                checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.SYSTEMERROR;

                logger.error(message);

                errorKbn = C_ErrorKbn.ERROR;

                logger.debug("△ ＤＳ解約共通チェック 終了");

                return errorKbn;
            }

        }

        logger.debug("△ ＤＳ解約共通チェック 終了");

        return errorKbn;

    }

    public C_ErrorKbn tokuteitrhkkzChk(String pSyoNo, String pDskokNo, C_KouzasyuruiKbn pKouzasyuruiKbn) {

        logger.debug("▽ 特定取引用口座情報チェック 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        MT_DsSoukinyouKouza mtDsSoukinyouKouza =
            checkKaiyakuUketukeDao.getDsSoukinyouKouzaByDskoknoSyonoKouzaSyuruiKbn(pDskokNo, pSyoNo, pKouzasyuruiKbn);

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(pDskokNo);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyoNo);

        IT_KykSya kykSya = kykKihon.getKykSya();

        CheckDsTorihikiService checkDsTorihikiService = SWAKInjector.getInstance(CheckDsTorihikiService.class);

        CheckSoukinyoukzResultBean checkSoukinyoukzResultBean = checkDsTorihikiService.checkSoukinyoukz(
            C_Tuukasyu.JPY,
            mtDsSoukinyouKouza.getBankcd(),
            mtDsSoukinyouKouza.getSitencd(),
            dsKokyakuKanri.getDskokyakunmkn(),
            mtDsSoukinyouKouza.getKzdoukbn(),
            kykSya.getKyknmkn());

        if (C_ChkkekkaKbn.ERROR.eq(checkSoukinyoukzResultBean.getChkkekkaKbn())) {

            C_SoukinyoukzchkkekkaKbn soukinyoukzchkkekkaKbn = checkSoukinyoukzResultBean.getSoukinyoukzchkkekkaKbn();

            if (C_SoukinyoukzchkkekkaKbn.GINKOUMASTERSONZAI.eq(soukinyoukzchkkekkaKbn)) {

                message = MessageUtil.getMessage(MessageId.EMF1032);

                messageId = MessageId.EMF1032;

                checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.GINKOUMASTERSONZAI;

                errorKbn = C_ErrorKbn.ERROR;

                logger.debug("△ 特定取引用口座情報チェック 終了");

                return errorKbn;
            }

            else if (C_SoukinyoukzchkkekkaKbn.GINKOUYUUKOUHANTEI.eq(soukinyoukzchkkekkaKbn)) {

                message = MessageUtil.getMessage(MessageId.EMF1036);

                messageId = MessageId.EMF1036;

                checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.GINKOUYUUKOUSEIHANTEI;

                errorKbn = C_ErrorKbn.ERROR;

                logger.debug("△ 特定取引用口座情報チェック 終了");

                return errorKbn;
            }

            else if (C_SoukinyoukzchkkekkaKbn.YUUTYOGINKOUSOUKINKAHI.eq(soukinyoukzchkkekkaKbn)) {

                message = MessageUtil.getMessage(MessageId.EBC1009);

                messageId = MessageId.EBC1009;

                checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.YUUTYOGINKOUSOUKINKAHI;

                errorKbn = C_ErrorKbn.ERROR;

                logger.debug("△ 特定取引用口座情報チェック 終了");

                return errorKbn;
            }

            else if (C_SoukinyoukzchkkekkaKbn.GAIKAKOUZASOUKINKAHI.eq(soukinyoukzchkkekkaKbn)) {

                message = MessageUtil.getMessage(MessageId.EBC1010);

                messageId = MessageId.EBC1010;

                checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.GAIKAKOUZASOUKINKAHI;

                errorKbn = C_ErrorKbn.ERROR;

                logger.debug("△ 特定取引用口座情報チェック 終了");

                return errorKbn;
            }

            else if (C_SoukinyoukzchkkekkaKbn.KOUZAMEIGININ.eq(soukinyoukzchkkekkaKbn)) {

                message = MessageUtil.getMessage(MessageId.EMF1037);

                messageId = MessageId.EMF1037;

                checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.KOUZAMEIGININMEI;

                errorKbn = C_ErrorKbn.ERROR;

                logger.debug("△ 特定取引用口座情報チェック 終了");

                return errorKbn;
            }

            else {

                message = MessageUtil.getMessage(MessageId.EMF1046, String.valueOf(soukinyoukzchkkekkaKbn));

                messageId = MessageId.EMF1046;

                messageParam = String.valueOf(soukinyoukzchkkekkaKbn);

                checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.SYSTEMERROR;

                logger.error(message);

                errorKbn = C_ErrorKbn.ERROR;

                logger.debug("△ 特定取引用口座情報チェック 終了");

                return errorKbn;
            }

        }

        logger.debug("△ 特定取引用口座情報チェック 終了");

        return errorKbn;

    }

    public C_ErrorKbn dskaiyakuukeumuChk(String pSyoNo) {

        logger.debug("▽ ＤＳ解約受付有無チェック 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        CheckDsKaiyaku checkDsKaiyaku = SWAKInjector.getInstance(CheckDsKaiyaku.class);

        C_UmuKbn umuKbn = checkDsKaiyaku.kaiyakuUkeUmuChk(pSyoNo);

        if (C_UmuKbn.ARI.eq(umuKbn)) {

            message = MessageUtil.getMessage(MessageId.EMF1038);

            messageId = MessageId.EMF1038;

            checkKaiyakuUketukeKekkaKbn = C_CheckKaiyakuUketukeKekkaKbn.KAIYAKUUKETUKEZUMI;

            errorKbn = C_ErrorKbn.ERROR;
        }

        logger.debug("△ ＤＳ解約受付有無チェック 終了");

        return errorKbn;

    }

}
