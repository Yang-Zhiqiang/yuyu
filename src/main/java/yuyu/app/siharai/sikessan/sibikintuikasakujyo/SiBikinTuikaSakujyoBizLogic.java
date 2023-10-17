package yuyu.app.siharai.sikessan.sibikintuikasakujyo;

import static yuyu.app.siharai.sikessan.sibikintuikasakujyo.GenSiBikinTuikaSakujyoConstants.*;
import static yuyu.app.siharai.sikessan.sibikintuikasakujyo.SiBikinTuikaSakujyoConstants.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.SaibanBiz;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
import yuyu.common.hozen.ascommon.KeisanZennouSeisanGk2;
import yuyu.common.hozen.khcommon.KeisanMsyMkeiP;
import yuyu.common.hozen.khcommon.SetDenSimebi;
import yuyu.common.hozen.khcommon.SetKessanNensibi;
import yuyu.common.hozen.khcommon.SetOutoubi;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuPrm;
import yuyu.common.siharai.sicommon.SiKinouModeSettei;
import yuyu.common.suuri.srcommon.SrDateUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BknTyousaFSyoriKbn;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_BknsyoriKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HubiJyoukyouKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_MisyuptsKbn;
import yuyu.def.classification.C_NayoseYouhi;
import yuyu.def.classification.C_NoinitUmuKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SeisankinKanritukaKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SyouhnsyuruiKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.sorter.SortIT_Zennou;
import yuyu.def.siharai.manager.SiharaiDomManager;

/**
 * 保険金給付金備金追加削除 のビジネスロジックです。
 */
public class SiBikinTuikaSakujyoBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SiBikinTuikaSakujyoUiBean uiBean;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private MessageManager messageManager;

    void init() {
    }

    void clear() {
    }


    String pushKetteiBL() {

        SiKinouModeSettei siKinouModeSettei = SWAKInjector.getInstance(SiKinouModeSettei.class);

        siKinouModeSettei.exec();

        BizPropertyInitializer.initialize(uiBean);

        BizDate sysDate = BizDate.getSysDate();


        boolean  checkKessanTukiYokugetuFlg = SrDateUtil.isKessanTukiYokugetu(sysDate);

        if (!checkKessanTukiYokugetuFlg) {
            throw new BizLogicException(MessageId.EBA1032);
        }

        SetDenSimebi setDenSimebi = SWAKInjector.getInstance(SetDenSimebi.class);

        BizDate denSimebiDate = setDenSimebi.exec(sysDate);

        if (denSimebiDate == null ) {
            throw new BizAppException(MessageId.EBS1007, MESSAGE_KIJYUN_YMD);
        }

        if (BizDateUtil.compareYmd(sysDate, denSimebiDate) == BizDateUtil.COMPARE_GREATER) {
            throw new BizLogicException(MessageId.EBA1032);
        }

        if (C_BkncdKbn.SIBOUUKETUKE.eq(uiBean.getBkncdkbn()) || C_BkncdKbn.SIBOUKARIUKETUKE.eq(uiBean.getBkncdkbn())) {
            if (C_BknsyoriKbn.TUIKA.eq(uiBean.getBknsyorikbn())) {
                throw new BizLogicException(MessageId.EBA0042, uiBean.getBknsyorikbn().getContent());
            }
        }

        if (C_BkncdKbn.SIBOUKAIJYO.eq(uiBean.getBkncdkbn()) || C_BkncdKbn.MENSEKI.eq(uiBean.getBkncdkbn())) {
            if (C_BknsyoriKbn.SAKUJYO.eq(uiBean.getBknsyorikbn())) {
                throw new BizLogicException(MessageId.EBA0042, uiBean.getBknsyorikbn().getContent());
            }
        }

        KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);

        KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);

        keiyakuPrm.setSyono(uiBean.getSyono());
        keiyakuPrm.setINayoseyh(C_NayoseYouhi.HUYOU);

        keiyakuInfoSyutoku.getInfos(keiyakuPrm);

        List<JT_SiKykKihon> siKykKihonLst = keiyakuInfoSyutoku.getKykKihons();

        if (siKykKihonLst.get(0) == null) {
            throw new BizLogicException(MessageId.EBA0024, MessageUtil.getMessage(MessageId.IJW1001));
        }

        uiBean.setSiKykKihon(siKykKihonLst.get(0));

        BizDate kessankijyunymd = sysDate;
        int kessankijyunM = sysDate.getMonth();

        if (kessankijyunM == 1) {
            kessankijyunymd = BizDate.valueOf(sysDate.getBizDateY().addYears(-1), 12, 31);
        }
        if (kessankijyunM == 4) {
            kessankijyunymd = BizDate.valueOf(sysDate.getBizDateY(), 3, 31);
        }
        if (kessankijyunM == 7) {
            kessankijyunymd = BizDate.valueOf(sysDate.getBizDateY(), 6, 30);
        }
        if (kessankijyunM == 10) {
            kessankijyunymd = BizDate.valueOf(sysDate.getBizDateY(), 9, 30);
        }

        uiBean.setKessankijyunymd(kessankijyunymd);

        if (C_BknsyoriKbn.SAKUJYO.eq(uiBean.getBknsyorikbn())) {
            List<JT_SiBikinkanri> siBikinkanriLst =siharaiDomManager.getSiBikinkanrisBySyonoKessankijyunymdBkncdkbns(
                uiBean.getSyono(), uiBean.getKessankijyunymd(), uiBean.getBkncdkbn());

            if (siBikinkanriLst.size() == 0) {
                throw new BizLogicException(MessageId.EBA0030, MessageUtil.getMessage(MessageId.IBC1021));
            }

            if (!C_BknrigiKbn.BLNK.eq(siBikinkanriLst.get(0).getBknrigikbn())) {
                throw new BizLogicException(MessageId.EJA0087, MessageUtil.getMessage(MessageId.IBC1022));
            }

            uiBean.setSiBikinkanri(siBikinkanriLst.get(0));
        }

        if (C_BknsyoriKbn.TUIKA.eq(uiBean.getBknsyorikbn())) {
            List<JT_SiBikinkanri> siBikinkanriAddLst = siharaiDomManager.getSiBikinkanrisBySyonoKessankijyunymdBkncdkbns(
                uiBean.getSyono(), uiBean.getKessankijyunymd(), uiBean.getBkncdkbn());

            if (siBikinkanriAddLst.size() != 0) {
                throw new BizLogicException(MessageId.EJA0087, MessageUtil.getMessage(MessageId.IBC1024));
            }

            List<JT_SiBikinkanri> siBikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyonoKessankijyunymdBkncdkbns(
                uiBean.getSyono(), uiBean.getKessankijyunymd(),
                new C_BkncdKbn [] {C_BkncdKbn.SIBOUUKETUKE, C_BkncdKbn.SIBOUKARIUKETUKE});

            if (siBikinkanriLst.size() != 0) {
                for (JT_SiBikinkanri siBikinkanri : siBikinkanriLst) {
                    if (!C_BknrigiKbn.DEL.eq(siBikinkanri.getBknrigikbn())) {
                        throw new BizLogicException(MessageId.EJA1039);
                    }
                }
            }
        }

        if (C_BknsyoriKbn.TORIKESI.eq(uiBean.getBknsyorikbn())) {
            List<JT_SiBikinkanri> siBikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyonoKessankijyunymdBkncdkbns(
                uiBean.getSyono(), uiBean.getKessankijyunymd(), uiBean.getBkncdkbn());

            if (siBikinkanriLst.size() != 0) {
                uiBean.setSiBikinkanri(siBikinkanriLst.get(0));
            }
            else {
                uiBean.setSiBikinkanri(null);
            }

            if (uiBean.getSiBikinkanri() == null || C_BknrigiKbn.BLNK.eq(uiBean.getSiBikinkanri().getBknrigikbn())) {
                throw new BizLogicException(MessageId.EBA1034);
            }
        }

        if (C_BknsyoriKbn.TUIKA.eq(uiBean.getBknsyorikbn())) {
            uiBean.setSkno("");
        }

        if (C_BknsyoriKbn.SAKUJYO.eq(uiBean.getBknsyorikbn()) || C_BknsyoriKbn.TORIKESI.eq(uiBean.getBknsyorikbn())) {
            uiBean.setBknrigikbn(uiBean.getSiBikinkanri().getBknrigikbn());
            uiBean.setBkngk(uiBean.getSiBikinkanri().getBkngk());
            uiBean.setBknkktymd(uiBean.getSiBikinkanri().getBknkktymd());
            uiBean.setCalckijyunymd(uiBean.getSiBikinkanri().getCalckijyunymd());
            uiBean.setShrumu(uiBean.getSiBikinkanri().getShrumu());
            uiBean.setSoukiumukbn(uiBean.getSiBikinkanri().getSoukiumukbn());
            uiBean.setShrsyoriymd(uiBean.getSiBikinkanri().getShrsyoriymd());
            uiBean.setTyakkinymd(uiBean.getSiBikinkanri().getTyakkinymd());
            uiBean.setShrtuukasyu(uiBean.getSiBikinkanri().getShrtuukasyu());
            uiBean.setSyoruiukeymd(uiBean.getSiBikinkanri().getSyoruiukeymd());
            uiBean.setSkno(uiBean.getSiBikinkanri().getSkno());
        }

        return FORWARDNAME_INPUTCONTENTS;
    }

    String pushKakuninBL() {

        BizDate sysDate = BizDate.getSysDate();

        BizDate calcsysYmd = BizDate.valueOf(sysDate.getBizDateYM(), 1);
        if (BizDateUtil.compareYmd(uiBean.getBknkktymd(), calcsysYmd) == BizDateUtil.COMPARE_EQUAL ||
            BizDateUtil.compareYmd(uiBean.getBknkktymd(), calcsysYmd) == BizDateUtil.COMPARE_GREATER) {
            throw new BizLogicException(MessageId.EBA0028,
                MessageUtil.getMessage(DDID_BIKOUINFO_BKNKKTYMD.getErrorResourceKey()));
        }

        if (C_BknsyoriKbn.TUIKA.eq(uiBean.getBknsyorikbn())){
            BizDate bknkktinndYmd;
            BizDate calcYmd = BizDate.valueOf(sysDate.getBizDateY(), 3, 31);
            BizDate calcLYmd = BizDate.valueOf(sysDate.getBizDateY().addYears(-1), 3, 31);

            if ((sysDate.getMonth() > 4 &&
                (BizDateUtil.compareYmd(uiBean.getBknkktymd(), calcYmd) == BizDateUtil.COMPARE_EQUAL ||
                BizDateUtil.compareYmd(uiBean.getBknkktymd(), calcYmd) == BizDateUtil.COMPARE_LESSER)) ||
                (sysDate.getMonth() <= 4 &&
                (BizDateUtil.compareYmd(uiBean.getBknkktymd(), calcLYmd) == BizDateUtil.COMPARE_EQUAL ||
                BizDateUtil.compareYmd(uiBean.getBknkktymd(), calcLYmd) == BizDateUtil.COMPARE_LESSER))) {

                if (uiBean.getBknkktymd().getMonth() >= 4) {
                    bknkktinndYmd = BizDate.valueOf(uiBean.getBknkktymd().getBizDateY().addYears(1), 3, 31);
                }
                else {
                    bknkktinndYmd = BizDate.valueOf(uiBean.getBknkktymd().getBizDateY(), 3, 31);
                }

                List<JT_SiBikinkanri> siBikinkanriAddLst = siharaiDomManager.getSiBikinkanrisBySyonoKessankijyunymdBkncdkbns(
                    uiBean.getSyono(), bknkktinndYmd, C_BkncdKbn.SIBOUUKETUKE, C_BkncdKbn.SIBOUKARIUKETUKE);

                if (siBikinkanriAddLst.size() == 0) {
                    throw new BizLogicException(MessageId.EJA1060);
                }
                if (!C_BknJkuKbn.SINBI.eq(siBikinkanriAddLst.get(0).getBknjkukbn())) {
                    throw new BizLogicException(MessageId.EJA1060);
                }
            }

            if (BizDateUtil.compareYmd(uiBean.getCalckijyunymd(),uiBean.getBknkktymd()) ==
                BizDateUtil.COMPARE_GREATER) {
                throw new BizLogicException(MessageId.EBA1029,
                    MessageUtil.getMessage(DDID_BIKOUINFO_CALCKIJYUNYMD.getErrorResourceKey()),
                    MessageUtil.getMessage(DDID_BIKOUINFO_BKNKKTYMD.getErrorResourceKey()));
            }
            if (uiBean.getSyoruiukeymd() != null) {
                if (BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(),sysDate) ==
                    BizDateUtil.COMPARE_GREATER) {
                    throw new BizLogicException(MessageId.EBA0026,
                        MessageUtil.getMessage(DDID_BIKOUINFO_SYORUIUKEYMD.getErrorResourceKey()));
                }
                if (BizDateUtil.compareYmd(uiBean.getBknkktymd(),uiBean.getSyoruiukeymd()) ==
                    BizDateUtil.COMPARE_GREATER) {
                    throw new BizLogicException(MessageId.EBA1029,
                        MessageUtil.getMessage(DDID_BIKOUINFO_BKNKKTYMD.getErrorResourceKey()),
                        MessageUtil.getMessage(DDID_BIKOUINFO_SYORUIUKEYMD.getErrorResourceKey()));
                }
            }
        }

        if (C_BknsyoriKbn.TUIKA.eq(uiBean.getBknsyorikbn()) && C_UmuKbn.ARI.eq(uiBean.getShrumu())) {
            if (uiBean.getShrsyoriymd() == null) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_BIKOUINFO_SHRSYORIYMD.getErrorResourceKey()));
            }
            if (uiBean.getTyakkinymd() == null) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_BIKOUINFO_TYAKKINYMD.getErrorResourceKey()));
            }
            if (C_Tuukasyu.BLNK.eq(uiBean.getShrtuukasyu())) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_BIKOUINFO_SHRTUUKASYU.getErrorResourceKey()));
            }
            if (uiBean.getSyoruiukeymd() == null) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_BIKOUINFO_SYORUIUKEYMD.getErrorResourceKey()));
            }
            if (!C_Tuukasyu.JPY.eq(uiBean.getShrtuukasyu()) && !getSyukeiyakuKyktuukasyu().eq(uiBean.getShrtuukasyu())) {
                throw new BizLogicException(MessageId.EBC0046,
                    MessageUtil.getMessage(DDID_BIKOUINFO_SHRTUUKASYU.getErrorResourceKey()));
            }
            if (BizDateUtil.compareYmd(uiBean.getShrsyoriymd(), sysDate) == BizDateUtil.COMPARE_GREATER) {
                throw new BizLogicException(MessageId.EBA0026,
                    MessageUtil.getMessage(DDID_BIKOUINFO_SHRSYORIYMD.getErrorResourceKey()));
            }
            if (BizDateUtil.compareYmd(uiBean.getBknkktymd(),uiBean.getShrsyoriymd()) ==
                BizDateUtil.COMPARE_GREATER) {
                throw new BizLogicException(MessageId.EBA1029,
                    MessageUtil.getMessage(DDID_BIKOUINFO_BKNKKTYMD.getErrorResourceKey()),
                    MessageUtil.getMessage(DDID_BIKOUINFO_SHRSYORIYMD.getErrorResourceKey()));
            }
            if (BizDateUtil.compareYmd(uiBean.getShrsyoriymd(),uiBean.getTyakkinymd()) ==
                BizDateUtil.COMPARE_GREATER) {
                throw new BizLogicException(MessageId.EBA1029,
                    MessageUtil.getMessage(DDID_BIKOUINFO_SHRSYORIYMD.getErrorResourceKey()),
                    MessageUtil.getMessage(DDID_BIKOUINFO_TYAKKINYMD.getErrorResourceKey()));
            }
            if (BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(),uiBean.getShrsyoriymd()) ==
                BizDateUtil.COMPARE_GREATER) {
                throw new BizLogicException(MessageId.EBA1029,
                    MessageUtil.getMessage(DDID_BIKOUINFO_SYORUIUKEYMD.getErrorResourceKey()),
                    MessageUtil.getMessage(DDID_BIKOUINFO_SHRSYORIYMD.getErrorResourceKey()));
            }
        }
        else if (C_BknsyoriKbn.TUIKA.eq(uiBean.getBknsyorikbn()) && C_UmuKbn.NONE.eq(uiBean.getShrumu())) {
            if (uiBean.getShrsyoriymd() != null) {
                throw new BizLogicException(MessageId.EBA0108,
                    MessageUtil.getMessage(DDID_BIKOUINFO_SHRSYORIYMD.getErrorResourceKey()));
            }
            if (uiBean.getTyakkinymd() != null) {
                throw new BizLogicException(MessageId.EBA0108,
                    MessageUtil.getMessage(DDID_BIKOUINFO_TYAKKINYMD.getErrorResourceKey()));
            }
            if (!C_Tuukasyu.BLNK.eq(uiBean.getShrtuukasyu())) {
                throw new BizLogicException(MessageId.EBA0108,
                    MessageUtil.getMessage(DDID_BIKOUINFO_SHRTUUKASYU.getErrorResourceKey()));
            }
        }

        messageManager.addMessageId(MessageId.QBA0001);

        return FORWARDNAME_CONFIRM;
    }

    @Transactional
    String pushKakuteiBL() {

        String sysDateTime = BizDate.getSysDateTimeMilli();

        if (C_BknsyoriKbn.SAKUJYO.eq(uiBean.getBknsyorikbn())) {

            uiBean.getSiBikinkanri().setBknrigikbn(C_BknrigiKbn.DEL);
            uiBean.getSiBikinkanri().setGyoumuKousinKinou(kinou.getKinouId());
            uiBean.getSiBikinkanri().setGyoumuKousinsyaId(baseUserInfo.getUserId());
            uiBean.getSiBikinkanri().setGyoumuKousinTime(sysDateTime);

            siharaiDomManager.update(uiBean.getSiBikinkanri());
        }

        if (C_BknsyoriKbn.TUIKA.eq(uiBean.getBknsyorikbn())) {
            List<JT_SiBikinkanri> siBikinkanriAddLst = siharaiDomManager.getSiBikinkanrisBySyonoKessankijyunymdBkncdkbns(
                uiBean.getSyono(), uiBean.getKessankijyunymd(), uiBean.getBkncdkbn());

            if (siBikinkanriAddLst.size() != 0) {
                throw new BizLogicException(MessageId.EJA0087, MessageUtil.getMessage(MessageId.IBC1024));
            }
            String skNo= SaibanBiz.getSeikyuBangou();

            JT_SiKykSyouhn newSiKykSyouhn = new JT_SiKykSyouhn();

            for (JT_SiKykSyouhn siKykSyouhn : uiBean.getSiKykKihon().getSiKykSyouhns()) {
                if (C_SyutkKbn.SYU.eq(siKykSyouhn.getSyutkkbn())) {
                    BeanUtil.copyProperties(newSiKykSyouhn, siKykSyouhn);
                    break;
                }
            }

            BM_SyouhnZokusei syouhnZokusei =  bizDomManager.getSyouhnZokusei(newSiKykSyouhn.getSyouhncd(),
                newSiKykSyouhn.getSyouhnsdno());

            JM_SiSyouhnZokusei siSyouhnZokusei =
                siharaiDomManager.getSiSyouhnZokuseisBySyouhncd(newSiKykSyouhn.getSyouhncd());

            BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
            SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(
                newSiKykSyouhn.getSyouhncd(), newSiKykSyouhn.getKyktuukasyu());

            SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);

            BizDate kessanYmd = setKessanNensibi.exec(uiBean.getBknkktymd());

            String bknkktY = kessanYmd.getBizDateY().toString();

            C_BknJkuKbn bknJkuKbn = bknJikouKbnSettei(uiBean.getKessankijyunymd(), uiBean.getBknkktymd());

            BizDate syoruiukeYmd = uiBean.getSyoruiukeymd();
            BizDate kessankijyunYmd = uiBean.getKessankijyunymd();
            BizDate shrkwsratekjnYmd = null;
            if (syoruiukeYmd != null && syoruiukeYmd.isHoliday()) {
                syoruiukeYmd = syoruiukeYmd.getBusinessDay(CHolidayAdjustingMode.NEXT);
            }
            if (kessankijyunYmd.isHoliday()) {
                kessankijyunYmd = kessankijyunYmd.getBusinessDay(CHolidayAdjustingMode.PREVIOUS);
            }

            if (!C_Tuukasyu.JPY.eq(newSiKykSyouhn.getKyktuukasyu())) {
                if (C_Tuukasyu.JPY.eq(uiBean.getShrtuukasyu())) {
                    if (syoruiukeYmd == null ||
                        BizDateUtil.compareYmd(syoruiukeYmd, kessankijyunYmd) == BizDateUtil.COMPARE_GREATER) {
                        shrkwsratekjnYmd = kessankijyunYmd;
                    } else {
                        shrkwsratekjnYmd = syoruiukeYmd;
                    }
                } else {
                    shrkwsratekjnYmd = kessankijyunYmd;
                }
            }

            C_KawaserateSyuruiKbn kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.BLNK;
            C_KawasetsryKbn kawasetsryKbn = C_KawasetsryKbn.BLNK;
            BizNumber shrkwsrate = BizNumber.ZERO;

            if (!C_Tuukasyu.JPY.eq(newSiKykSyouhn.getKyktuukasyu())) {
                if (C_Tuukasyu.JPY.eq(uiBean.getShrtuukasyu())
                    && syoruiukeYmd != null
                    && (BizDateUtil.compareYmd(syoruiukeYmd, kessankijyunYmd) == BizDateUtil.COMPARE_LESSER ||
                    BizDateUtil.compareYmd(syoruiukeYmd, kessankijyunYmd) == BizDateUtil.COMPARE_EQUAL)) {
                    kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.KOUJIKAWASERATE;
                    kawasetsryKbn = C_KawasetsryKbn.SYUKKINRATE;
                } else {
                    kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.PM17JIKAWASERATE;
                    kawasetsryKbn = C_KawasetsryKbn.JISSEIRATE;
                }

                GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
                getKawaseRate.exec(shrkwsratekjnYmd, kawaserateSyuruiKbn, newSiKykSyouhn.getKyktuukasyu(), C_Tuukasyu.JPY,
                    C_KawasetekiyoKbn.TTM, kawasetsryKbn, C_EigyoubiHoseiKbn.BLNK, C_YouhiKbn.HUYOU);
                shrkwsrate = getKawaseRate.getKawaserate();
            }

            BizNumber gaikaknsnKwsrate = BizNumber.ZERO;

            if (!C_Tuukasyu.JPY.eq(newSiKykSyouhn.getKyktuukasyu())) {
                GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

                getKawaseRate.exec(shrkwsratekjnYmd, C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                    newSiKykSyouhn.getKyktuukasyu(), C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.NYUKINRATE,
                    C_EigyoubiHoseiKbn.BLNK, C_YouhiKbn.HUYOU);

                gaikaknsnKwsrate = getKawaseRate.getKawaserate();

            }

            C_SyouhnsyuruiKbn syouhnsyuruiKbn = C_SyouhnsyuruiKbn.BLNK;

            if (C_UmuKbn.NONE.eq(syouhnZokusei.getNkhknumu())) {

                syouhnsyuruiKbn = C_SyouhnsyuruiKbn.KOJINHOKEN;
            }
            else if (C_UmuKbn.ARI.eq(syouhnZokusei.getNkhknumu())) {

                syouhnsyuruiKbn = C_SyouhnsyuruiKbn.KOJINNENKIN;
            }

            BizDate seisanCalcKijyunYmd = null;

            if (BizDateUtil.compareYmd(uiBean.getCalckijyunymd(), newSiKykSyouhn.getKykymd()) == BizDateUtil.COMPARE_LESSER) {
                seisanCalcKijyunYmd = newSiKykSyouhn.getKykymd();
            }
            else {
                seisanCalcKijyunYmd = uiBean.getCalckijyunymd();
            }

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
            CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(newSiKykSyouhn.getKyktuukasyu());

            C_UmuKbn zennouseisankinumuKbn = C_UmuKbn.NONE;
            BizCurrency zennouSeisanKgk = BizCurrency.valueOf(0, currencyType);
            BizCurrency yenkaZennouSeisanKgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            KeisanZennouSeisanGk2 keisanZennouSeisanGk2 = SWAKInjector.getInstance(KeisanZennouSeisanGk2.class);
            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

            if (C_UmuKbn.ARI.eq(syouhnZokusei.getZennouumu())) {
                if (C_Kykjyoutai.ZENNOU.eq(uiBean.getSiKykKihon().getKykjyoutai())) {
                    IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(uiBean.getSyono());

                    SortIT_Zennou sortZennou = new SortIT_Zennou();

                    List<IT_Zennou> zennouList = sortZennou.OrderIT_ZennouByPkDesc(ansyuKihon.getZennous());

                    IT_Zennou zennou = zennouList.get(0);

                    keisanZennouSeisanGk2.exec(seisanCalcKijyunYmd, newSiKykSyouhn.getKykymd(),
                        zennou.getZennoujihrkp(), zennou.getZennoukaisiymd(), zennou.getRyosyuymd(),
                        zennou.getZennounyuukinkgk());

                    if (keisanZennouSeisanGk2.getZennouSeisanGk().compareTo(
                        BizCurrency.valueOf(0, keisanZennouSeisanGk2.getZennouSeisanGk().getType())) > 0) {
                        zennouseisankinumuKbn = C_UmuKbn.ARI;

                        if (C_Tuukasyu.JPY.eq(newSiKykSyouhn.getKyktuukasyu())) {
                            zennouSeisanKgk = keisanZennouSeisanGk2.getZennouSeisanGk();
                        }
                        else {
                            if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {
                                zennouSeisanKgk = keisanZennouSeisanGk2.getZennouSeisanGk();
                            }
                            else if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {
                                keisanGaikakanzan.execDivide(newSiKykSyouhn.getKyktuukasyu(),
                                    keisanZennouSeisanGk2.getZennouSeisanGk(), gaikaknsnKwsrate, C_HasuusyoriKbn.AGE);

                                zennouSeisanKgk = keisanGaikakanzan.getKanzanGaku();
                            }

                            keisanGaikakanzan.exec(C_Tuukasyu.JPY, zennouSeisanKgk, shrkwsrate,
                                C_HasuusyoriKbn.AGE);

                            BizCurrency kanzanGaku = keisanGaikakanzan.getKanzanGaku();

                            if (C_UmuKbn.ARI.eq(uiBean.getShrumu())) {
                                if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn()) &&
                                    C_Tuukasyu.JPY.eq(uiBean.getShrtuukasyu())) {
                                    yenkaZennouSeisanKgk = keisanZennouSeisanGk2.getZennouSeisanGk();
                                }
                                else {
                                    yenkaZennouSeisanKgk = kanzanGaku;
                                }
                            }
                            else {
                                if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {
                                    yenkaZennouSeisanKgk = keisanZennouSeisanGk2.getZennouSeisanGk();
                                }
                                else {
                                    yenkaZennouSeisanKgk = kanzanGaku;
                                }
                            }
                        }
                    }
                }
            }

            C_UmuKbn mikeikapumuKbn = C_UmuKbn.NONE;
            BizCurrency mikeikaP = BizCurrency.valueOf(0, currencyType);
            BizCurrency yenkaMikeikaP = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            KeisanMsyMkeiP keisanMsyMkeiP = SWAKInjector.getInstance(KeisanMsyMkeiP.class);
            BizDateYM jkipjytYm = null;

            if (C_UmuKbn.ARI.eq(syouhnZokusei.getHeijyunbaraiumu())) {
                if (C_Kykjyoutai.ZENNOU.eq(uiBean.getSiKykKihon().getKykjyoutai())) {
                    SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);

                    BizDate hanteiYmd = BizDate.valueOf(keisanZennouSeisanGk2.getLastPJyuutouYm(), newSiKykSyouhn
                        .getKykymd().getDay());
                    if (!hanteiYmd.isRekijyou()) {
                        hanteiYmd = hanteiYmd.getRekijyou();
                    }

                    jkipjytYm = setOutoubi.exec(C_TykzentykgoKbn.TYKGO, newSiKykSyouhn.getKykymd(),
                        C_Hrkkaisuu.NEN, hanteiYmd).getBizDateYM();
                }
                else {
                    jkipjytYm = uiBean.getSiKykKihon().getNexthrkym();
                }

                keisanMsyMkeiP.exec(uiBean.getSyono(), seisanCalcKijyunYmd, jkipjytYm, newSiKykSyouhn.getHokenryou(),
                    C_MisyuptsKbn.TS);

                if (keisanMsyMkeiP.getMikeikaP().compareTo(
                    BizCurrency.valueOf(0, keisanMsyMkeiP.getMikeikaP().getType())) > 0) {
                    mikeikapumuKbn = C_UmuKbn.ARI;

                    if (C_Tuukasyu.JPY.eq(newSiKykSyouhn.getKyktuukasyu())) {
                        mikeikaP = keisanMsyMkeiP.getMikeikaP();
                    }
                    else {
                        if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn())) {
                            mikeikaP = keisanMsyMkeiP.getMikeikaP();
                        }
                        else if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn())) {
                            keisanGaikakanzan.execDivide(newSiKykSyouhn.getKyktuukasyu(), keisanMsyMkeiP.getMikeikaP(),
                                gaikaknsnKwsrate, C_HasuusyoriKbn.AGE);

                            mikeikaP = keisanGaikakanzan.getKanzanGaku();
                        }

                        keisanGaikakanzan.exec(C_Tuukasyu.JPY, mikeikaP, shrkwsrate, C_HasuusyoriKbn.AGE);

                        BizCurrency kanzanGaku = keisanGaikakanzan.getKanzanGaku();

                        if (C_UmuKbn.ARI.eq(uiBean.getShrumu())) {
                            if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn()) &&
                                C_Tuukasyu.JPY.eq(uiBean.getShrtuukasyu())) {
                                yenkaMikeikaP = keisanMsyMkeiP.getMikeikaP();
                            }
                            else {
                                yenkaMikeikaP = kanzanGaku;
                            }
                        }
                        else {
                            if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn())) {
                                yenkaMikeikaP = keisanMsyMkeiP.getMikeikaP();
                            }
                            else {
                                yenkaMikeikaP = kanzanGaku;
                            }
                        }
                    }
                }
            }

            JT_SiBikinkanri siBikinkanri = new JT_SiBikinkanri();
            siBikinkanri.setSkno(skNo);
            siBikinkanri.setSyono(uiBean.getSyono());
            siBikinkanri.setKessankijyunymd(uiBean.getKessankijyunymd());
            siBikinkanri.setBkncdkbn(uiBean.getBkncdkbn());
            siBikinkanri.setBknkktymd(uiBean.getBknkktymd());
            siBikinkanri.setKyuuhucd("9999");
            siBikinkanri.setBknrigikbn(C_BknrigiKbn.ADD);
            siBikinkanri.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
            siBikinkanri.setCalckijyunymd(uiBean.getCalckijyunymd());
            siBikinkanri.setSyoruiukeymd(uiBean.getSyoruiukeymd());
            siBikinkanri.setSyouhnsyuruikbn(syouhnsyuruiKbn);
            siBikinkanri.setSyutkkbn(C_SyutkKbn.SYU);
            siBikinkanri.setSisyacd(baseUserInfo.getTmSosikiCd().substring(0, 3));
            siBikinkanri.setKbnkeirisegcd(syouhinbetuSegmentBean.getSegcd1());
            siBikinkanri.setSyouhncd(newSiKykSyouhn.getSyouhncd());
            siBikinkanri.setBkngk(uiBean.getBkngk());
            siBikinkanri.setKihons(newSiKykSyouhn.getKihons());
            siBikinkanri.setShrumu(uiBean.getShrumu());
            siBikinkanri.setSoukiumukbn(uiBean.getSoukiumukbn());
            siBikinkanri.setSyoumetuumukbn(C_UmuKbn.NONE);
            siBikinkanri.setHubijyoukyoukbn(C_HubiJyoukyouKbn.BLNK);
            siBikinkanri.setBknjkukbn(bknJkuKbn);
            siBikinkanri.setShrsyoriymd(uiBean.getShrsyoriymd());
            siBikinkanri.setTyakkinymd(uiBean.getTyakkinymd());
            siBikinkanri.setKyktuukasyu(newSiKykSyouhn.getKyktuukasyu());
            siBikinkanri.setShrtuukasyu(uiBean.getShrtuukasyu());
            siBikinkanri.setShrkwsratekjnymd(shrkwsratekjnYmd);
            siBikinkanri.setShrkwsrate(shrkwsrate);
            siBikinkanri.setSyuukeiyoubkncdkbn(uiBean.getBkncdkbn());
            siBikinkanri.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.BLNK);
            siBikinkanri.setBkntyousafsyorikbn(C_BknTyousaFSyoriKbn.BLNK);
            siBikinkanri.setBknkktinnd(bknkktY);
            siBikinkanri.setBknkktiym(uiBean.getBknkktymd().getBizDateYM());
            siBikinkanri.setKykymd(newSiKykSyouhn.getKykymd());
            siBikinkanri.setZennouseisankinumukbn(zennouseisankinumuKbn);
            siBikinkanri.setZennouseisankgk(zennouSeisanKgk);
            siBikinkanri.setYenkazennouseisankgk(yenkaZennouSeisanKgk);
            siBikinkanri.setMikeikapumukbn(mikeikapumuKbn);
            siBikinkanri.setMikeikap(mikeikaP);
            siBikinkanri.setYenkamikeikap(yenkaMikeikaP);
            siBikinkanri.setMisyuupumukbn(C_UmuKbn.NONE);
            siBikinkanri.setMisyuupjyuutouym(null);
            siBikinkanri.setHrkp(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            siBikinkanri.setMisyuup(BizCurrency.valueOf(0, currencyType));
            siBikinkanri.setYenkamisyuup(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            siBikinkanri.setHrkkaisuu(C_Hrkkaisuu.BLNK);
            siBikinkanri.setSyonendojikaiikoup(BizCurrency.valueOf(0, currencyType));
            siBikinkanri.setYenkasyonendojikaiikoup(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            siBikinkanri.setJinendoikoup(BizCurrency.valueOf(0, currencyType));
            siBikinkanri.setYenkajinendoikoup(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            siBikinkanri.setMsyupknrtuukakbn(siSyouhnZokusei.getMsyupknrtuukakbn());
            siBikinkanri.setMikeikapknrtuukakbn(siSyouhnZokusei.getMikeikapknrtuukakbn());
            siBikinkanri.setZnnusisnkinknrtuukakbn(siSyouhnZokusei.getZnnusisnkinknrtuukakbn());
            siBikinkanri.setGyoumuKousinKinou(kinou.getKinouId());
            siBikinkanri.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            siBikinkanri.setGyoumuKousinTime(sysDateTime);

            if (C_SntkhouKbn.HJY.eq(uiBean.getSiKykKihon().getSntkhoukbn())) {
                siBikinkanri.setSinsaumukbn(C_UmuKbn.ARI);
            }
            else {
                siBikinkanri.setSinsaumukbn(C_UmuKbn.NONE);
            }

            BizDate wkgengkymd = null;
            wkgengkymd = uiBean.getSiKykKihon().getSykyknyhenkouymd();
            if(wkgengkymd == null){
                siBikinkanri.setGengkumukbn(C_NoinitUmuKbn.NONE);
            }
            else{
                siBikinkanri.setGengkumukbn(C_NoinitUmuKbn.ARI);
            }
            siBikinkanri.setGengkymd(wkgengkymd);

            BizPropertyInitializer.initialize(siBikinkanri);

            siharaiDomManager.insert(siBikinkanri);
        }

        if (C_BknsyoriKbn.TORIKESI.eq(uiBean.getBknsyorikbn())) {

            if (C_BknrigiKbn.DEL.eq(uiBean.getSiBikinkanri().getBknrigikbn())) {

                uiBean.getSiBikinkanri().setBknrigikbn(C_BknrigiKbn.BLNK);
                uiBean.getSiBikinkanri().setGyoumuKousinKinou(kinou.getKinouId());
                uiBean.getSiBikinkanri().setGyoumuKousinsyaId(baseUserInfo.getUserId());
                uiBean.getSiBikinkanri().setGyoumuKousinTime(sysDateTime);

                siharaiDomManager.update(uiBean.getSiBikinkanri());
            }

            if (C_BknrigiKbn.ADD.eq(uiBean.getSiBikinkanri().getBknrigikbn())) {
                siharaiDomManager.delete(uiBean.getSiBikinkanri());
            }
        }

        messageManager.addMessageId(MessageId.IAC0009);

        return FORWARDNAME_RESULT;
    }

    private C_Tuukasyu getSyukeiyakuKyktuukasyu() {
        C_Tuukasyu kyktuukasyu = C_Tuukasyu.BLNK;
        for (JT_SiKykSyouhn siKykSyouhn : uiBean.getSiKykKihon().getSiKykSyouhns()) {
            if (C_SyutkKbn.SYU.eq(siKykSyouhn.getSyutkkbn())) {
                kyktuukasyu = siKykSyouhn.getKyktuukasyu();
                break;
            }
        }
        return kyktuukasyu;
    }

    private C_BknJkuKbn bknJikouKbnSettei(BizDate pKessanKijyunYmd, BizDate pBknkktymd) {

        if (pKessanKijyunYmd == null) {

            return C_BknJkuKbn.BLNK;
        }

        if (pBknkktymd == null) {

            return C_BknJkuKbn.BLNK;
        }

        SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);

        int kessankijyunnd = setKessanNensibi.exec(pKessanKijyunYmd).getYear();

        int bknkktinnd = setKessanNensibi.exec(pBknkktymd).getYear();

        C_BknJkuKbn bknJkuKbn;

        if (kessankijyunnd - bknkktinnd == 0) {

            bknJkuKbn = C_BknJkuKbn.SINBI;
        }

        else if (kessankijyunnd - bknkktinnd == 1) {

            bknJkuKbn = C_BknJkuKbn.SAIBI;
        }

        else if (kessankijyunnd - bknkktinnd == 2) {

            bknJkuKbn = C_BknJkuKbn.SAISAIBI;
        }

        else if (kessankijyunnd - bknkktinnd == 3) {

            if (HONKESSAN_KIJUNBI.compareTo(pKessanKijyunYmd.getBizDateMD()) == 0) {

                bknJkuKbn = C_BknJkuKbn.JIKOU;
            } else {

                bknJkuKbn = C_BknJkuKbn.SAISAISAIBI;
            }
        }
        else {

            bknJkuKbn = C_BknJkuKbn.JIKOU;
        }

        return bknJkuKbn;
    }
}
