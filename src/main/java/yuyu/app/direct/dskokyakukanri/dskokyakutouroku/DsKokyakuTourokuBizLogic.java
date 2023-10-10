package yuyu.app.direct.dskokyakukanri.dskokyakutouroku;

import static yuyu.app.direct.dskokyakukanri.dskokyakutouroku.DsKokyakuTourokuConstants.*;
import static yuyu.app.direct.dskokyakukanri.dskokyakutouroku.GenDsKokyakuTourokuConstants.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.direct.dscommon.DsKanyuuYoukenCheck;
import yuyu.common.direct.dscommon.DsKanyuuYoukenCheckBean;
import yuyu.common.direct.dscommon.DsSaibanSyori;
import yuyu.common.direct.dscommon.DsTetudukiRirekiTableEdit;
import yuyu.common.direct.dscommon.DsTetudukiRirekiTableEditParam;
import yuyu.common.direct.dscommon.DsTetudukiRirekiTableEditParamImpl;
import yuyu.common.direct.dscommon.HozenKeiyakuIdouJyoutaiSyutoku;
import yuyu.common.direct.dscommon.HozenKeiyakuIdouJyoutaiSyutokuBean;
import yuyu.common.direct.dscommon.TableMaintenanceUtil;
import yuyu.common.hozen.khcommon.CheckYuuyokkngai;
import yuyu.def.MessageId;
import yuyu.def.classification.C_DsKanyuuKeiroKbn;
import yuyu.def.classification.C_DsKokyakuJtKbn;
import yuyu.def.classification.C_DsKrHnnKakCdSetKbn;
import yuyu.def.classification.C_DsKrHnnKakCdTtYhKbn;
import yuyu.def.classification.C_DsMailDbSyoriKbn;
import yuyu.def.classification.C_DsMailSousinJyoutaiKbn;
import yuyu.def.classification.C_DsMailTourokuJyoutaiKbn;
import yuyu.def.classification.C_DsRendouTaisyouKbn;
import yuyu.def.classification.C_DsSyomenTtdkHyouji;
import yuyu.def.classification.C_DsSyoriKbn;
import yuyu.def.classification.C_DsTeisiRiyuuKbn;
import yuyu.def.classification.C_DsTrhkserviceRiyoujkKbn;
import yuyu.def.classification.C_DsTrhkserviceTeisiRiyuuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_IdoutyuuHanteiKekkaKbn;
import yuyu.def.classification.C_MukouHyj;
import yuyu.def.classification.C_SeisaHuyouHyj;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukshantkekKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.MT_BAK_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsHonninKakuninCd;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.entity.MT_DsLoginKanri;
import yuyu.def.db.entity.MT_DsMailAddress;
import yuyu.def.db.entity.MT_DsMailAddressSpiralYyk;
import yuyu.def.db.entity.MT_DsSoukinyouKouza;
import yuyu.def.db.entity.MT_DsTorihikiServiceKanri;
import yuyu.def.db.entity.MT_DsTorihikiyouAnsyono;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.sinkeiyaku.detacher.HT_SyoriCTLDetacher;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 顧客登録 のビジネスロジックです。
 */
public class DsKokyakuTourokuBizLogic {

    @Inject
    private DsKokyakuTourokuUiBean uiBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private DirectDomManager directDomManager;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private MessageManager messageManager;

    private String gyoumuKousinTime;

    void init() {
        clear();
    }

    void clear() {
    }

    void getKokyakuInfo() {
        BizPropertyInitializer.initialize(uiBean);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(uiBean.getSyono());

        kykKihon = IT_KykKihonDetacher.detachKykKihontouched(kykKihon);

        if (kykKihon == null) {
            throw new BizLogicException(MessageId.EBA0090, DDID_BASEINFO_SYONO);
        }

        HozenKeiyakuIdouJyoutaiSyutoku hozenKeiyakuIdouJyoutaiSyutoku = SWAKInjector
            .getInstance(HozenKeiyakuIdouJyoutaiSyutoku.class);
        CheckYuuyokkngai checkYuuyokkngai = SWAKInjector.getInstance(CheckYuuyokkngai.class);

        C_YuukshantkekKbn yuukshantekekkbn = hozenKeiyakuIdouJyoutaiSyutoku
            .keiyakuJyoutaiYuukouseiHantei(uiBean.getSyono());

        boolean checkYuuyokkngaiKekka = checkYuuyokkngai.exec(uiBean.getSyono(), BizDate.getSysDate());

        if (C_YuukshantkekKbn.ERROR.eq(yuukshantekekkbn)) {
            throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
        }

        if (C_YuukshantkekKbn.NG.eq(yuukshantekekkbn) ||
            !checkYuuyokkngaiKekka) {
            throw new BizLogicException(MessageId.EMA1002, DDID_BASEINFO_SYONO);
        }

        List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyakuList = directDomManager
            .getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank(uiBean.getSyono());

        if (dsKokyakuKeiyakuList.size() != 0) {
            uiBean.setDsKokyakuKanri(dsKokyakuKeiyakuList.get(0).getDsKokyakuKanri());
            uiBean.setDsKokyakuKeiyaku(dsKokyakuKeiyakuList.get(0));

            uiBean.setTougoumaedskokno(dsKokyakuKeiyakuList.get(0).getDskokno());
            uiBean.setDskokyakunmkj(uiBean.getDsKokyakuKanri().getDskokyakunmkj());
            uiBean.setDskokyakunmkn(uiBean.getDsKokyakuKanri().getDskokyakunmkn());
            uiBean.setDskokyakuseiymd(uiBean.getDsKokyakuKanri().getDskokyakuseiymd());
            uiBean.setDskokyakuyno(uiBean.getDsKokyakuKanri().getDskokyakuyno());
        }

        IT_KykKihon kykKihon2 = hozenDomManager.getKykKihon(uiBean.getSyono());
        kykKihon2 = IT_KykKihonDetacher.detachKykSyatouched(kykKihon2);
        IT_KykSya kykSya = kykKihon2.getKykSya();
        uiBean.setKyknmkj(kykSya.getKyknmkj());
        uiBean.setKyknmkn(kykSya.getKyknmkn());
        uiBean.setKykseiymd(kykSya.getKykseiymd());
        uiBean.setTsinyno(kykSya.getTsinyno());

        messageManager.addConversationMessageId(KOKYAKU_TORYOKU_NAIYOUNYURYOKU_GAMEN,
            MessageId.IMA1008);

        dsKanyuuYoukenCheck(KOKYAKU_TORYOKU_NAIYOUNYURYOKU_GAMEN, MessageId.IMA1012);

        uiBean.setDssyorikbn(C_DsSyoriKbn.KOKYAKU_TOUROKU);
    }

    void checkKokyakuInfo() {
        if (C_DsSyoriKbn.KOKYAKU_TOUROKU.eq(uiBean.getDssyorikbn())) {
            if (C_DsKanyuuKeiroKbn.BLNK.eq(uiBean.getDskanyuukeirokbn())) {
                throw new BizLogicException(MessageId.EAC0042, DDID_DSKOKYAKUJYOUTAI_DSKANYUUKEIROKBN);
            }

            if (!BizUtil.isBlank(uiBean.getTougoumaedskokno())) {
                throw new BizLogicException(MessageId.EMF1024);
            }

            DsKanyuuYoukenCheck dsKanyuuYoukenCheck = SWAKInjector.getInstance(DsKanyuuYoukenCheck.class);

            if (C_ErrorKbn.ERROR.eq(dsKanyuuYoukenCheck.checkDsKanyuuNenrei(uiBean.getKykseiymd()))) {

                String chkkekkaMsg = "";

                chkkekkaMsg = MessageUtil.getMessage(MessageId.WMF1003);

                throw new BizLogicException(MessageId.EMF1054, chkkekkaMsg);

            }
        }

        if (C_DsSyoriKbn.KOKYAKU_TOUGOU.eq(uiBean.getDssyorikbn())) {
            if (BizUtil.isBlank(uiBean.getTougousakidskokno())) {
                throw new BizLogicException(MessageId.EAC0042, DDID_KOKYAKUTOUGOUSAKI_TOUGOUSAKIDSKOKNO);
            }

            if (uiBean.getTougoumaedskokno().equals(uiBean.getTougousakidskokno())) {
                throw new BizLogicException(MessageId.EMF1005, DDID_KOKYAKUTOUGOUSAKI_TOUGOUSAKIDSKOKNO);
            }
        }

        if (C_DsSyoriKbn.KOKYAKU_TOUGOU_KAIJYO.eq(uiBean.getDssyorikbn())) {
            if (BizUtil.isBlank(uiBean.getTougoumaedskokno())) {
                throw new BizLogicException(MessageId.EMA1006);
            }
        }

        if (C_DsSyoriKbn.KOKYAKU_TOUROKU.eq(uiBean.getDssyorikbn()) ||
            C_DsSyoriKbn.KOKYAKU_TOUGOU.eq(uiBean.getDssyorikbn())) {
            HozenKeiyakuIdouJyoutaiSyutoku hozenKeiyakuIdouJyoutaiSyutoku = SWAKInjector
                .getInstance(HozenKeiyakuIdouJyoutaiSyutoku.class);

            HozenKeiyakuIdouJyoutaiSyutokuBean hozenKeiyakuIdouJyoutaiSyutokuBean = hozenKeiyakuIdouJyoutaiSyutoku
                .hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu(uiBean.getSyono());

            if (C_IdoutyuuHanteiKekkaKbn.ERROR.eq(hozenKeiyakuIdouJyoutaiSyutokuBean.getIdoutyuuKbn())) {
                throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
            }

            if (C_IdoutyuuHanteiKekkaKbn.IDOUTYUU.eq(hozenKeiyakuIdouJyoutaiSyutokuBean.getIdoutyuuKbn())) {
                throw new BizLogicException(MessageId.EMF1023, "異動処理中", uiBean.getDssyorikbn().getContent());
            }
        }

        if (C_DsSyoriKbn.KOKYAKU_TOUGOU.eq(uiBean.getDssyorikbn())) {
            MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(uiBean.getTougousakidskokno());

            if (dsKokyakuKanri == null ||
                C_DsKokyakuJtKbn.KAIYAKU.eq(dsKokyakuKanri.getDskokyakujtkbn()) ||
                C_DsKokyakuJtKbn.SEISA_SYOUMETU.eq(dsKokyakuKanri.getDskokyakujtkbn()) ||
                (C_DsKokyakuJtKbn.ITIJI_TEISI.eq(dsKokyakuKanri.getDskokyakujtkbn()) &&
                    !C_DsTeisiRiyuuKbn.PASSWORD_MITOUROKU.eq(dsKokyakuKanri.getDsteisiriyuukbn()))) {
                throw new BizLogicException(MessageId.EMA1005, DDID_KOKYAKUTOUGOUSAKI_TOUGOUSAKIDSKOKNO);

            }

            IT_KykKihon kykKihon = hozenDomManager.getKykKihon(uiBean.getSyono());
            kykKihon = IT_KykKihonDetacher.detachKykSyatouched(kykKihon);
            IT_KykSya kykSya = kykKihon.getKykSya();

            if (!dsKokyakuKanri.getDskokyakunmkn().equals(kykSya.getKyknmkn()) ||
                !dsKokyakuKanri.getDskokyakunmkj().equals(kykSya.getKyknmkj()) ||
                !dsKokyakuKanri.getDskokyakuseiymd().equals(kykSya.getKykseiymd()) ||
                !dsKokyakuKanri.getDskokyakuyno().equals(kykSya.getTsinyno())) {
                throw new BizLogicException(MessageId.EMF1012, DDID_KOKYAKUTOUGOUSAKI_TOUGOUSAKIDSKOKNO);
            }

            uiBean.setTougousakiDsKokyakuKanri(dsKokyakuKanri);
        }

        messageManager.removeConversationMessage(KOKYAKU_TORYOKU_NAIYOUNYURYOKU_GAMEN);

        if (C_DsSyoriKbn.KOKYAKU_TOUROKU.eq(uiBean.getDssyorikbn())) {
            messageManager.addConversationMessageId(KOKYAKU_TORYOKU_KAKUNIN_GAMEN,
                MessageId.QMA1005);
        }
        else if (C_DsSyoriKbn.KOKYAKU_TOUGOU.eq(uiBean.getDssyorikbn())) {
            messageManager.addConversationMessageId(KOKYAKU_TORYOKU_KAKUNIN_GAMEN,
                MessageId.QMA1006);
        }
        else if (C_DsSyoriKbn.KOKYAKU_TOUGOU_KAIJYO.eq(uiBean.getDssyorikbn())) {
            messageManager.addConversationMessageId(KOKYAKU_TORYOKU_KAKUNIN_GAMEN,
                MessageId.QMA1007);
        }

        dsKanyuuYoukenCheck(KOKYAKU_TORYOKU_KAKUNIN_GAMEN, MessageId.QMA1011);

    }

    @Transactional
    void confirmKokyakuInfo() {
        gyoumuKousinTime = BizDate.getSysDateTimeMilli();

        if (C_DsSyoriKbn.KOKYAKU_TOUROKU.eq(uiBean.getDssyorikbn()) ||
            C_DsSyoriKbn.KOKYAKU_TOUGOU.eq(uiBean.getDssyorikbn())) {
            if (BizUtil.isBlank(uiBean.getTougoumaedskokno())) {
                List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyakuList = directDomManager
                    .getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank(uiBean.getSyono());

                if (dsKokyakuKeiyakuList.size() != 0) {
                    throw new BizLogicException(MessageId.EMF1006);
                }
            }
        }

        if (C_DsSyoriKbn.KOKYAKU_TOUGOU.eq(uiBean.getDssyorikbn())) {
            IT_KykKihon kykKihon = hozenDomManager.getKykKihon(uiBean.getSyono());
            kykKihon = IT_KykKihonDetacher.detachKykSyatouched(kykKihon);
            IT_KykSya kykSya = kykKihon.getKykSya();

            if (!uiBean.getTougousakiDsKokyakuKanri().getDskokyakunmkn().equals(kykSya.getKyknmkn()) ||
                !uiBean.getTougousakiDsKokyakuKanri().getDskokyakunmkj().equals(kykSya.getKyknmkj()) ||
                !uiBean.getTougousakiDsKokyakuKanri().getDskokyakuseiymd().equals(kykSya.getKykseiymd()) ||
                !uiBean.getTougousakiDsKokyakuKanri().getDskokyakuyno().equals(kykSya.getTsinyno())) {
                throw new BizLogicException(MessageId.EMF1012);
            }
        }

        DsSaibanSyori dsSaibanSyori = SWAKInjector.getInstance(DsSaibanSyori.class);
        String henkouSikibetukey = dsSaibanSyori.saibanDsHenkouSikibetukey();

        TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);

        if (!BizUtil.isBlank(uiBean.getTougoumaedskokno())) {
            MT_BAK_DsKokyakuKanri bakDsKokyakuKanri = tableMaintenanceUtil.exec(uiBean.getTougoumaedskokno(),
                henkouSikibetukey);
            directDomManager.insert(bakDsKokyakuKanri);
        }

        if (!BizUtil.isBlank(uiBean.getTougousakidskokno())) {
            MT_BAK_DsKokyakuKanri bakDsKokyakuKanri = tableMaintenanceUtil.exec(uiBean.getTougousakidskokno(),
                henkouSikibetukey);
            directDomManager.insert(bakDsKokyakuKanri);
        }

        String newDsKokyakuBangou = "";
        if (C_DsSyoriKbn.KOKYAKU_TOUROKU.eq(uiBean.getDssyorikbn())) {
            newDsKokyakuBangou = dsSaibanSyori.saibanDsKokno();

            IT_KykKihon kykKihon = hozenDomManager.getKykKihon(uiBean.getSyono());

            kykKihon = IT_KykKihonDetacher.detachKykSyatouched(kykKihon);

            IT_KykSya kykSya = kykKihon.getKykSya();

            MT_DsKokyakuKanri dsKokyakuKanri = new MT_DsKokyakuKanri();

            dsKokyakuKanri.setDskokno(newDsKokyakuBangou);
            dsKokyakuKanri.setDskokyakujtkbn(C_DsKokyakuJtKbn.ITIJI_TEISI);
            dsKokyakuKanri.setDskokyakusakuseiymd(BizDate.getSysDate());
            dsKokyakuKanri.setDsteisiriyuukbn(C_DsTeisiRiyuuKbn.PASSWORD_MITOUROKU);
            dsKokyakuKanri.setSeisahuyouhyj(C_SeisaHuyouHyj.BLANK);
            dsKokyakuKanri.setDskokyakunmkn(kykSya.getKyknmkn());
            dsKokyakuKanri.setDskokyakunmkj(kykSya.getKyknmkj());
            dsKokyakuKanri.setDskokyakuseiymd(kykSya.getKykseiymd());
            dsKokyakuKanri.setDskokyakuyno(kykSya.getTsinyno());
            dsKokyakuKanri.setDskanyuukeirokbn(uiBean.getDskanyuukeirokbn());
            dsKokyakuKanri.setGyoumuKousinKinou(kinou.getKinouId());
            dsKokyakuKanri.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            dsKokyakuKanri.setGyoumuKousinTime(gyoumuKousinTime);
            BizPropertyInitializer.initialize(dsKokyakuKanri);

            MT_DsHonninKakuninCd dsHonninKakuninCd = dsKokyakuKanri.createDsHonninKakuninCd();
            dsHonninKakuninCd.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SINKI);
            dsHonninKakuninCd.setDskrhnnkakcdttshjyhsymd(BizDate.getSysDate());
            dsHonninKakuninCd.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.YOU);
            dsHonninKakuninCd.setGyoumuKousinKinou(kinou.getKinouId());
            dsHonninKakuninCd.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            dsHonninKakuninCd.setGyoumuKousinTime(gyoumuKousinTime);
            BizPropertyInitializer.initialize(dsHonninKakuninCd);

            MT_DsLoginKanri dsLoginKanri = dsKokyakuKanri.createDsLoginKanri();
            dsLoginKanri.setGyoumuKousinKinou(kinou.getKinouId());
            dsLoginKanri.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            dsLoginKanri.setGyoumuKousinTime(gyoumuKousinTime);
            BizPropertyInitializer.initialize(dsLoginKanri);

            HT_MosKihon mosKihon = getMosKihonInfo(uiBean.getSyono());

            C_DsSyomenTtdkHyouji dsSymenTtdkHyj = null;

            if (mosKihon != null) {

                dsSymenTtdkHyj = mosKihon.getPplessrenjidssymenttdkhyj();
            }

            insertNewDSKyKeiyakukokyaku(dsKokyakuKanri, dsSymenTtdkHyj);

            C_DsMailTourokuJyoutaiKbn dsMailTourokuJyoutaiKbn;
            C_DsMailSousinJyoutaiKbn dsMailSousinJyoutaiKbn;

            if (mosKihon != null && !BizUtil.isBlank(mosKihon.getDsmailaddress())) {
                dsMailTourokuJyoutaiKbn = C_DsMailTourokuJyoutaiKbn.TOUROKU;
                dsMailSousinJyoutaiKbn = C_DsMailSousinJyoutaiKbn.YUUKOU;

                MT_DsMailAddress dsMailAddress = dsKokyakuKanri.createDsMailAddress();

                dsMailAddress.setDskokno(newDsKokyakuBangou);
                dsMailAddress.setDsmailaddressrenban(1);
                dsMailAddress.setDsmailtourokujyoutaikbn(dsMailTourokuJyoutaiKbn);
                dsMailAddress.setDsmailaddress(mosKihon.getDsmailaddress());
                dsMailAddress.setDsmailsousinjyoutaikbn(dsMailSousinJyoutaiKbn);
                dsMailAddress.setDstourokuymdtime(gyoumuKousinTime);
                dsMailAddress.setDskousinymdtime(gyoumuKousinTime);
                dsMailAddress.setGyoumuKousinKinou(kinou.getKinouId());
                dsMailAddress.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                dsMailAddress.setGyoumuKousinTime(gyoumuKousinTime);

                BizPropertyInitializer.initialize(dsMailAddress);

                MT_DsMailAddressSpiralYyk dsMailAddressSpiralYyk = dsKokyakuKanri.createDsMailAddressSpiralYyk();

                dsMailAddressSpiralYyk.setDsdatasakuseiymd(BizDate.getSysDate());
                dsMailAddressSpiralYyk.setDskokno(newDsKokyakuBangou);
                dsMailAddressSpiralYyk.setDsmailaddressrenban(1);
                dsMailAddressSpiralYyk.setDsmailaddress(mosKihon.getDsmailaddress());
                dsMailAddressSpiralYyk.setDsrendoutaisyoukbn(C_DsRendouTaisyouKbn.RENDOUTAISYOU);
                dsMailAddressSpiralYyk.setDsmaildbsyorikbn(C_DsMailDbSyoriKbn.TOUROKU);
                dsMailAddressSpiralYyk.setGyoumuKousinKinou(kinou.getKinouId());
                dsMailAddressSpiralYyk.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                dsMailAddressSpiralYyk.setGyoumuKousinTime(gyoumuKousinTime);

                BizPropertyInitializer.initialize(dsMailAddressSpiralYyk);
            }
            else {
                dsMailTourokuJyoutaiKbn = C_DsMailTourokuJyoutaiKbn.MITOUROKU;
                dsMailSousinJyoutaiKbn = C_DsMailSousinJyoutaiKbn.BLNK;

                MT_DsMailAddress dsMailAddress = dsKokyakuKanri.createDsMailAddress();

                dsMailAddress.setDskokno(newDsKokyakuBangou);
                dsMailAddress.setDsmailaddressrenban(1);
                dsMailAddress.setDsmailtourokujyoutaikbn(dsMailTourokuJyoutaiKbn);
                dsMailAddress.setDsmailaddress("");
                dsMailAddress.setDsmailsousinjyoutaikbn(dsMailSousinJyoutaiKbn);
                dsMailAddress.setDstourokuymdtime(gyoumuKousinTime);
                dsMailAddress.setDskousinymdtime(gyoumuKousinTime);
                dsMailAddress.setGyoumuKousinKinou(kinou.getKinouId());
                dsMailAddress.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                dsMailAddress.setGyoumuKousinTime(gyoumuKousinTime);

                BizPropertyInitializer.initialize(dsMailAddress);
            }
            directDomManager.insert(dsKokyakuKanri);
        }
        else if (C_DsSyoriKbn.KOKYAKU_TOUGOU.eq(uiBean.getDssyorikbn())) {
            MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(uiBean.getTougousakidskokno());
            MT_DsKokyakuKeiyaku dsKokyakuKeiyaku = dsKokyakuKanri.getDsKokyakuKeiyakuBySyono(uiBean.getSyono());

            MT_DsTorihikiServiceKanri tougoumaeDsTorihikiServiceKanri = uiBean.getDsKokyakuKeiyaku()
                .getDsTorihikiServiceKanri();

            if (dsKokyakuKeiyaku != null) {
                dsKokyakuKeiyaku.setDskykkanyuuymd(BizDate.getSysDate());
                dsKokyakuKeiyaku.setDskykhenkouymd(null);
                dsKokyakuKeiyaku.setDskykmukouhyj(C_MukouHyj.BLANK);
                dsKokyakuKeiyaku.setDskykmukouymd(null);
                dsKokyakuKeiyaku.setGyoumuKousinKinou(kinou.getKinouId());
                dsKokyakuKeiyaku.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                dsKokyakuKeiyaku.setGyoumuKousinTime(gyoumuKousinTime);

                MT_DsTorihikiServiceKanri tougousakiDsTorihikiServiceKanri = dsKokyakuKeiyaku
                    .getDsTorihikiServiceKanri();

                if (!BizUtil.isBlank(uiBean.getTougoumaedskokno())) {
                    if (tougoumaeDsTorihikiServiceKanri != null && tougousakiDsTorihikiServiceKanri != null) {

                        tougousakiDsTorihikiServiceKanri.setDstrhkserviceriyoujkkbn(tougoumaeDsTorihikiServiceKanri
                            .getDstrhkserviceriyoujkkbn());
                        tougousakiDsTorihikiServiceKanri.setDstrhkserviceteisiriyuukbn(tougoumaeDsTorihikiServiceKanri
                            .getDstrhkserviceteisiriyuukbn());
                        tougousakiDsTorihikiServiceKanri.setDstrhkservicetourokuymd(tougoumaeDsTorihikiServiceKanri
                            .getDstrhkservicetourokuymd());
                        tougousakiDsTorihikiServiceKanri.setDstrhkservicemukouymd(tougoumaeDsTorihikiServiceKanri
                            .getDstrhkservicemukouymd());
                        tougousakiDsTorihikiServiceKanri.setDstrhkservicekanyukeirokbn(tougoumaeDsTorihikiServiceKanri
                            .getDstrhkservicekanyukeirokbn());
                        tougousakiDsTorihikiServiceKanri.setGyoumuKousinKinou(kinou.getKinouId());
                        tougousakiDsTorihikiServiceKanri.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        tougousakiDsTorihikiServiceKanri.setGyoumuKousinTime(gyoumuKousinTime);

                        MT_DsSoukinyouKouza tougoumaeDsSoukinyouKouza = tougoumaeDsTorihikiServiceKanri
                            .getDsSoukinyouKouzas().get(0);
                        MT_DsSoukinyouKouza tougousakiDsSoukinyouKouza = tougousakiDsTorihikiServiceKanri
                            .getDsSoukinyouKouzas().get(0);

                        tougousakiDsSoukinyouKouza.setKzsyuruikbn(tougoumaeDsSoukinyouKouza.getKzsyuruikbn());
                        tougousakiDsSoukinyouKouza.setBankcd(tougoumaeDsSoukinyouKouza.getBankcd());
                        tougousakiDsSoukinyouKouza.setSitencd(tougoumaeDsSoukinyouKouza.getSitencd());
                        tougousakiDsSoukinyouKouza.setYokinkbn(tougoumaeDsSoukinyouKouza.getYokinkbn());
                        tougousakiDsSoukinyouKouza.setKouzano(tougoumaeDsSoukinyouKouza.getKouzano());
                        tougousakiDsSoukinyouKouza.setKzdoukbn(tougoumaeDsSoukinyouKouza.getKzdoukbn());
                        tougousakiDsSoukinyouKouza.setKzmeiginmkn(tougoumaeDsSoukinyouKouza.getKzmeiginmkn());
                        tougousakiDsSoukinyouKouza.setGyoumuKousinKinou(kinou.getKinouId());
                        tougousakiDsSoukinyouKouza.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        tougousakiDsSoukinyouKouza.setGyoumuKousinTime(gyoumuKousinTime);

                        MT_DsTorihikiyouAnsyono tougoumaeDsTorihikiyouAnsyono = tougoumaeDsTorihikiServiceKanri
                            .getDsTorihikiyouAnsyono();
                        MT_DsTorihikiyouAnsyono tougousakiDsTorihikiyouAnsyono = tougousakiDsTorihikiServiceKanri
                            .getDsTorihikiyouAnsyono();

                        tougousakiDsTorihikiyouAnsyono.setTokuteitrhkansyono(tougoumaeDsTorihikiyouAnsyono
                            .getTokuteitrhkansyono());
                        tougousakiDsTorihikiyouAnsyono.setTktrhkansyonoerrorkaisuu(tougoumaeDsTorihikiyouAnsyono
                            .getTktrhkansyonoerrorkaisuu());
                        tougousakiDsTorihikiyouAnsyono.setSetymd(tougoumaeDsTorihikiyouAnsyono.getSetymd());
                        tougousakiDsTorihikiyouAnsyono.setGyoumuKousinKinou(kinou.getKinouId());
                        tougousakiDsTorihikiyouAnsyono.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        tougousakiDsTorihikiyouAnsyono.setGyoumuKousinTime(gyoumuKousinTime);
                    }
                    else if (tougoumaeDsTorihikiServiceKanri != null && tougousakiDsTorihikiServiceKanri == null) {

                        tougousakiDsTorihikiServiceKanri = dsKokyakuKeiyaku.createDsTorihikiServiceKanri();

                        tougousakiDsTorihikiServiceKanri.setDstrhkserviceriyoujkkbn(tougoumaeDsTorihikiServiceKanri
                            .getDstrhkserviceriyoujkkbn());
                        tougousakiDsTorihikiServiceKanri.setDstrhkserviceteisiriyuukbn(tougoumaeDsTorihikiServiceKanri
                            .getDstrhkserviceteisiriyuukbn());
                        tougousakiDsTorihikiServiceKanri.setDstrhkservicetourokuymd(tougoumaeDsTorihikiServiceKanri
                            .getDstrhkservicetourokuymd());
                        tougousakiDsTorihikiServiceKanri.setDstrhkservicemukouymd(tougoumaeDsTorihikiServiceKanri
                            .getDstrhkservicemukouymd());
                        tougousakiDsTorihikiServiceKanri.setDstrhkservicekanyukeirokbn(tougoumaeDsTorihikiServiceKanri
                            .getDstrhkservicekanyukeirokbn());
                        tougousakiDsTorihikiServiceKanri.setGyoumuKousinKinou(kinou.getKinouId());
                        tougousakiDsTorihikiServiceKanri.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        tougousakiDsTorihikiServiceKanri.setGyoumuKousinTime(gyoumuKousinTime);

                        BizPropertyInitializer.initialize(tougousakiDsTorihikiServiceKanri);

                        MT_DsSoukinyouKouza tougoumaeDsSoukinyouKouza = tougoumaeDsTorihikiServiceKanri
                            .getDsSoukinyouKouzas().get(0);
                        MT_DsSoukinyouKouza dsSoukinyouKouza = tougousakiDsTorihikiServiceKanri
                            .createDsSoukinyouKouza();

                        dsSoukinyouKouza.setKzsyuruikbn(tougoumaeDsSoukinyouKouza.getKzsyuruikbn());
                        dsSoukinyouKouza.setBankcd(tougoumaeDsSoukinyouKouza.getBankcd());
                        dsSoukinyouKouza.setSitencd(tougoumaeDsSoukinyouKouza.getSitencd());
                        dsSoukinyouKouza.setYokinkbn(tougoumaeDsSoukinyouKouza.getYokinkbn());
                        dsSoukinyouKouza.setKouzano(tougoumaeDsSoukinyouKouza.getKouzano());
                        dsSoukinyouKouza.setKzdoukbn(tougoumaeDsSoukinyouKouza.getKzdoukbn());
                        dsSoukinyouKouza.setKzmeiginmkn(tougoumaeDsSoukinyouKouza.getKzmeiginmkn());
                        dsSoukinyouKouza.setGyoumuKousinKinou(kinou.getKinouId());
                        dsSoukinyouKouza.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        dsSoukinyouKouza.setGyoumuKousinTime(gyoumuKousinTime);

                        BizPropertyInitializer.initialize(dsSoukinyouKouza);

                        MT_DsTorihikiyouAnsyono tougoumaeDsTorihikiyouAnsyono = tougoumaeDsTorihikiServiceKanri
                            .getDsTorihikiyouAnsyono();
                        MT_DsTorihikiyouAnsyono dsTorihikiyouAnsyono = tougousakiDsTorihikiServiceKanri
                            .createDsTorihikiyouAnsyono();

                        dsTorihikiyouAnsyono.setTokuteitrhkansyono(tougoumaeDsTorihikiyouAnsyono
                            .getTokuteitrhkansyono());
                        dsTorihikiyouAnsyono.setTktrhkansyonoerrorkaisuu(tougoumaeDsTorihikiyouAnsyono
                            .getTktrhkansyonoerrorkaisuu());
                        dsTorihikiyouAnsyono.setSetymd(tougoumaeDsTorihikiyouAnsyono.getSetymd());
                        dsTorihikiyouAnsyono.setGyoumuKousinKinou(kinou.getKinouId());
                        dsTorihikiyouAnsyono.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        dsTorihikiyouAnsyono.setGyoumuKousinTime(gyoumuKousinTime);

                        BizPropertyInitializer.initialize(dsTorihikiyouAnsyono);
                    }
                }
                directDomManager.update(dsKokyakuKanri);
            }
            else {

                C_DsSyomenTtdkHyouji dsSymenTtdkHyj = null;

                if (!BizUtil.isBlank(uiBean.getTougoumaedskokno())) {

                    dsSymenTtdkHyj = uiBean.getDsKokyakuKeiyaku().getPplessrenjidssymenttdkhyj();
                }
                else {

                    HT_MosKihon mosKihon = getMosKihonInfo(uiBean.getSyono());

                    if (mosKihon != null) {
                        dsSymenTtdkHyj = mosKihon.getPplessrenjidssymenttdkhyj();
                    }
                }

                MT_DsKokyakuKanri tougousakiDsKokyakuKanri = uiBean.getTougousakiDsKokyakuKanri();

                insertNewDSKyKeiyakukokyaku(tougousakiDsKokyakuKanri, dsSymenTtdkHyj);

                MT_DsKokyakuKeiyaku newDsKokyakuKanri = tougousakiDsKokyakuKanri.getDsKokyakuKeiyakuBySyono(uiBean
                    .getSyono());

                if (tougoumaeDsTorihikiServiceKanri != null) {

                    MT_DsTorihikiServiceKanri dsTorihikiServiceKanri = newDsKokyakuKanri.createDsTorihikiServiceKanri();

                    dsTorihikiServiceKanri.setDstrhkserviceriyoujkkbn(tougoumaeDsTorihikiServiceKanri
                        .getDstrhkserviceriyoujkkbn());
                    dsTorihikiServiceKanri.setDstrhkserviceteisiriyuukbn(tougoumaeDsTorihikiServiceKanri
                        .getDstrhkserviceteisiriyuukbn());
                    dsTorihikiServiceKanri.setDstrhkservicetourokuymd(tougoumaeDsTorihikiServiceKanri
                        .getDstrhkservicetourokuymd());
                    dsTorihikiServiceKanri.setDstrhkservicemukouymd(tougoumaeDsTorihikiServiceKanri
                        .getDstrhkservicemukouymd());
                    dsTorihikiServiceKanri.setDstrhkservicekanyukeirokbn(tougoumaeDsTorihikiServiceKanri
                        .getDstrhkservicekanyukeirokbn());
                    dsTorihikiServiceKanri.setGyoumuKousinKinou(kinou.getKinouId());
                    dsTorihikiServiceKanri.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    dsTorihikiServiceKanri.setGyoumuKousinTime(gyoumuKousinTime);

                    BizPropertyInitializer.initialize(dsTorihikiServiceKanri);

                    MT_DsSoukinyouKouza tougoumaeDsSoukinyouKouza = tougoumaeDsTorihikiServiceKanri
                        .getDsSoukinyouKouzas().get(0);

                    MT_DsSoukinyouKouza dsSoukinyouKouza = dsTorihikiServiceKanri.createDsSoukinyouKouza();

                    dsSoukinyouKouza.setKzsyuruikbn(tougoumaeDsSoukinyouKouza.getKzsyuruikbn());
                    dsSoukinyouKouza.setBankcd(tougoumaeDsSoukinyouKouza.getBankcd());
                    dsSoukinyouKouza.setSitencd(tougoumaeDsSoukinyouKouza.getSitencd());
                    dsSoukinyouKouza.setYokinkbn(tougoumaeDsSoukinyouKouza.getYokinkbn());
                    dsSoukinyouKouza.setKouzano(tougoumaeDsSoukinyouKouza.getKouzano());
                    dsSoukinyouKouza.setKzdoukbn(tougoumaeDsSoukinyouKouza.getKzdoukbn());
                    dsSoukinyouKouza.setKzmeiginmkn(tougoumaeDsSoukinyouKouza.getKzmeiginmkn());
                    dsSoukinyouKouza.setGyoumuKousinKinou(kinou.getKinouId());
                    dsSoukinyouKouza.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    dsSoukinyouKouza.setGyoumuKousinTime(gyoumuKousinTime);

                    BizPropertyInitializer.initialize(dsSoukinyouKouza);

                    MT_DsTorihikiyouAnsyono tougoumaeDsTorihikiyouAnsyono = tougoumaeDsTorihikiServiceKanri
                        .getDsTorihikiyouAnsyono();

                    MT_DsTorihikiyouAnsyono dsTorihikiyouAnsyono = dsTorihikiServiceKanri.createDsTorihikiyouAnsyono();

                    dsTorihikiyouAnsyono.setTokuteitrhkansyono(tougoumaeDsTorihikiyouAnsyono.getTokuteitrhkansyono());
                    dsTorihikiyouAnsyono.setTktrhkansyonoerrorkaisuu(tougoumaeDsTorihikiyouAnsyono
                        .getTktrhkansyonoerrorkaisuu());
                    dsTorihikiyouAnsyono.setSetymd(tougoumaeDsTorihikiyouAnsyono.getSetymd());
                    dsTorihikiyouAnsyono.setGyoumuKousinKinou(kinou.getKinouId());
                    dsTorihikiyouAnsyono.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    dsTorihikiyouAnsyono.setGyoumuKousinTime(gyoumuKousinTime);

                    BizPropertyInitializer.initialize(dsTorihikiyouAnsyono);
                }
                directDomManager.update(tougousakiDsKokyakuKanri);
            }
            if (!BizUtil.isBlank(uiBean.getTougoumaedskokno())) {
                updateDSKyKeiyakumukou();

                if (tougoumaeDsTorihikiServiceKanri != null &&
                    tougoumaeDsTorihikiServiceKanri.getDstrhkserviceriyoujkkbn().eq(C_DsTrhkserviceRiyoujkKbn.RIYOU_KA)) {

                    tougoumaeDsTorihikiServiceKanri.setDstrhkserviceriyoujkkbn(C_DsTrhkserviceRiyoujkKbn.RIYOU_HUKA);
                    tougoumaeDsTorihikiServiceKanri
                    .setDstrhkserviceteisiriyuukbn(C_DsTrhkserviceTeisiRiyuuKbn.SYOUMETU);
                    tougoumaeDsTorihikiServiceKanri.setDstrhkservicemukouymd(BizDate.getSysDate());
                    tougoumaeDsTorihikiServiceKanri.setGyoumuKousinKinou(kinou.getKinouId());
                    tougoumaeDsTorihikiServiceKanri.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    tougoumaeDsTorihikiServiceKanri.setGyoumuKousinTime(gyoumuKousinTime);
                }
                directDomManager.update(uiBean.getDsKokyakuKanri());
            }
        }
        else if (C_DsSyoriKbn.KOKYAKU_TOUGOU_KAIJYO.eq(uiBean.getDssyorikbn())) {

            MT_DsTorihikiServiceKanri tougoumaeDsTorihikiServiceKanri = uiBean.getDsKokyakuKeiyaku()
                .getDsTorihikiServiceKanri();

            updateDSKyKeiyakumukou();

            if (tougoumaeDsTorihikiServiceKanri != null &&
                tougoumaeDsTorihikiServiceKanri.getDstrhkserviceriyoujkkbn().eq(C_DsTrhkserviceRiyoujkKbn.RIYOU_KA)) {

                tougoumaeDsTorihikiServiceKanri.setDstrhkserviceriyoujkkbn(C_DsTrhkserviceRiyoujkKbn.RIYOU_HUKA);
                tougoumaeDsTorihikiServiceKanri.setDstrhkserviceteisiriyuukbn(C_DsTrhkserviceTeisiRiyuuKbn.SYOUMETU);
                tougoumaeDsTorihikiServiceKanri.setDstrhkservicemukouymd(BizDate.getSysDate());
                tougoumaeDsTorihikiServiceKanri.setGyoumuKousinKinou(kinou.getKinouId());
                tougoumaeDsTorihikiServiceKanri.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                tougoumaeDsTorihikiServiceKanri.setGyoumuKousinTime(gyoumuKousinTime);
            }
            directDomManager.update(uiBean.getDsKokyakuKanri());
        }
        DsTetudukiRirekiTableEdit dsTetudukiRirekiTableEdit = SWAKInjector.getInstance(DsTetudukiRirekiTableEdit.class);
        DsTetudukiRirekiTableEditParam dsTetudukiRirekiTableEditParam =
            SWAKInjector.getInstance(DsTetudukiRirekiTableEditParamImpl.class);

        if (!BizUtil.isBlank(uiBean.getTougoumaedskokno())) {
            dsTetudukiRirekiTableEditParam.setDskokno(uiBean.getTougoumaedskokno());
            dsTetudukiRirekiTableEditParam.setHenkousikibetukey(henkouSikibetukey);
            dsTetudukiRirekiTableEditParam.setSyoriYmd(BizDate.getSysDate());
            dsTetudukiRirekiTableEditParam.setDssyorikbn(uiBean.getDssyorikbn());
            dsTetudukiRirekiTableEditParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);

            dsTetudukiRirekiTableEdit.editDSTtdkRirekiTblOnline(dsTetudukiRirekiTableEditParam);
        }

        if (C_DsSyoriKbn.KOKYAKU_TOUROKU.eq(uiBean.getDssyorikbn())) {
            dsTetudukiRirekiTableEditParam.setDskokno(newDsKokyakuBangou);
            dsTetudukiRirekiTableEditParam.setHenkousikibetukey(henkouSikibetukey);
            dsTetudukiRirekiTableEditParam.setSyoriYmd(BizDate.getSysDate());
            dsTetudukiRirekiTableEditParam.setDssyorikbn(uiBean.getDssyorikbn());
            dsTetudukiRirekiTableEditParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);

            dsTetudukiRirekiTableEdit.editDSTtdkRirekiTblOnline(dsTetudukiRirekiTableEditParam);
        }

        if (!BizUtil.isBlank(uiBean.getTougousakidskokno())) {
            dsTetudukiRirekiTableEditParam.setDskokno(uiBean.getTougousakidskokno());
            dsTetudukiRirekiTableEditParam.setHenkousikibetukey(henkouSikibetukey);
            dsTetudukiRirekiTableEditParam.setSyoriYmd(BizDate.getSysDate());
            dsTetudukiRirekiTableEditParam.setDssyorikbn(uiBean.getDssyorikbn());
            dsTetudukiRirekiTableEditParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);

            dsTetudukiRirekiTableEdit.editDSTtdkRirekiTblOnline(dsTetudukiRirekiTableEditParam);
        }

        messageManager.removeConversationMessage(KOKYAKU_TORYOKU_KAKUNIN_GAMEN);

        if (C_DsSyoriKbn.KOKYAKU_TOUROKU.eq(uiBean.getDssyorikbn())) {
            messageManager.addConversationMessageId(KOKYAKU_TORYOKU_KEKKA_GAMEN,
                MessageId.IMA1005);
        }
        else if (C_DsSyoriKbn.KOKYAKU_TOUGOU.eq(uiBean.getDssyorikbn())) {
            messageManager.addConversationMessageId(KOKYAKU_TORYOKU_KEKKA_GAMEN,
                MessageId.IMA1006);
        }
        else if (C_DsSyoriKbn.KOKYAKU_TOUGOU_KAIJYO.eq(uiBean.getDssyorikbn())) {
            messageManager.addConversationMessageId(KOKYAKU_TORYOKU_KEKKA_GAMEN,
                MessageId.IMA1007);
        }

    }

    void recoverMessage() {
        messageManager.removeConversationMessage(KOKYAKU_TORYOKU_KAKUNIN_GAMEN);

        messageManager.addConversationMessageId(KOKYAKU_TORYOKU_NAIYOUNYURYOKU_GAMEN,
            MessageId.IMA1008);

        dsKanyuuYoukenCheck(KOKYAKU_TORYOKU_NAIYOUNYURYOKU_GAMEN, MessageId.IMA1012);

    }

    private void dsKanyuuYoukenCheck(int pGroupId, String pMessageId) {
        DsKanyuuYoukenCheck dsKanyuuYoukenCheck = SWAKInjector.getInstance(DsKanyuuYoukenCheck.class);
        DsKanyuuYoukenCheckBean dsKanyuuYoukenCheckBean = dsKanyuuYoukenCheck.exec(uiBean.getSyono());
        if (C_ErrorKbn.ERROR.eq(dsKanyuuYoukenCheckBean.getDsKanyuuYoukenCheckKbn())) {
            messageManager.addConversationMessageId(pGroupId, pMessageId);
        }
    }

    private void updateDSKyKeiyakumukou() {
        uiBean.getDsKokyakuKeiyaku().setDskykmukouhyj(C_MukouHyj.MUKOU);
        uiBean.getDsKokyakuKeiyaku().setDskykmukouymd(BizDate.getSysDate());
        uiBean.getDsKokyakuKeiyaku().setGyoumuKousinKinou(kinou.getKinouId());
        uiBean.getDsKokyakuKeiyaku().setGyoumuKousinsyaId(baseUserInfo.getUserId());
        uiBean.getDsKokyakuKeiyaku().setGyoumuKousinTime(gyoumuKousinTime);

    }

    private void insertNewDSKyKeiyakukokyaku(MT_DsKokyakuKanri pDsKokyakuKanri,
        C_DsSyomenTtdkHyouji pPplessRenjiDsSymenTtdkHyj) {
        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku = pDsKokyakuKanri.createDsKokyakuKeiyaku();

        dsKokyakuKeiyaku.setSyono(uiBean.getSyono());
        dsKokyakuKeiyaku.setDskykkanyuuymd(BizDate.getSysDate());
        dsKokyakuKeiyaku.setGyoumuKousinKinou(kinou.getKinouId());
        dsKokyakuKeiyaku.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        dsKokyakuKeiyaku.setGyoumuKousinTime(gyoumuKousinTime);
        dsKokyakuKeiyaku.setPplessrenjidssymenttdkhyj(pPplessRenjiDsSymenTtdkHyj);

        BizPropertyInitializer.initialize(dsKokyakuKeiyaku);
    }

    private HT_MosKihon getMosKihonInfo(String pSyono) {

        HT_MosKihon mosKihon = null;

        List<HT_SyoriCTL> syoriCTLList = sinkeiyakuDomManager.getSyoriCTLsBySyono(pSyono);

        if (!syoriCTLList.isEmpty()) {
            HT_SyoriCTL syoriCTL = HT_SyoriCTLDetacher.detachMosKihontouched(syoriCTLList.get(0));

            mosKihon = syoriCTL.getMosKihon();
        }
        return mosKihon;

    }
}