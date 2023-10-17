package yuyu.app.dsweb.dwhozentetuduki.dwdenwakaiyakuuketuke;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import jp.co.slcs.swak.util.string.IDataConvert;
import net.arnx.jsonic.JSON;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;

import com.google.common.collect.Lists;

import yuyu.app.dsweb.dwhozentetuduki.dwdenwakaiyakuuketuke.dba.DwDenwaKaiyakuUketukeDao;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.SaibanBiz;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyaku;
import yuyu.common.hozen.khcommon.KeisanKaiyakuBean;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyakuOutBean;
import yuyu.common.direct.dscommon.CheckKaiyakuUketuke;
import yuyu.common.direct.dscommon.DsSaibanSyori;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_DsGyoumuCdKbn;
import yuyu.def.classification.C_DsKinouidKbn;
import yuyu.def.classification.C_DsSyoriNaiyouKbn;
import yuyu.def.classification.C_DsTrhkserviceRiyoujkKbn;
import yuyu.def.classification.C_DsTrhkserviceTeisiRiyuuKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_NextSyoriCdKbn;
import yuyu.def.classification.C_SetudanKasyoKbn;
import yuyu.def.classification.C_SetudanRiyuuKbn;
import yuyu.def.classification.C_SousaRirekiJkKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TourokuRouteKbn;
import yuyu.def.classification.C_TtdkIsihyouziKbn;
import yuyu.def.classification.C_TtdkKekkaKbn;
import yuyu.def.classification.C_TtdkKinouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.IT_KhHenkouUktk;
import yuyu.def.db.entity.IT_KhHenkouUktkKaiyaku;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.entity.MT_DsSoukinyouKouza;
import yuyu.def.db.entity.MT_DsTorihikiServiceKanri;
import yuyu.def.db.entity.MT_DsTorihikiyouAnsyono;
import yuyu.def.db.entity.MT_SousaRireki;
import yuyu.def.db.entity.MT_SousaRirekiIvrInfo;
import yuyu.def.db.entity.MT_SousaRirekiSyousai;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.dsweb.bean.webservice.WsDwDenwaKaiyakuUketukeInputBean;
import yuyu.def.dsweb.bean.webservice.WsDwDenwaKaiyakuUketukeOutputBean;
import yuyu.def.dsweb.configuration.YuyuDswebConfig;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 電話解約受付サービスの実装クラスです。<br />
 */
public class DwDenwaKaiyakuUketukeImpl implements DwDenwaKaiyakuUketuke {

    private static final String NYRKNAIYOUKAIS = "　（入力内容：";

    private static final String SYTRKNAIYOUKAIS = "　（出力内容：";

    private static final String NYSYTNAIYOUSYUURYOU = "）";

    private static final String KOUMOKUNM_TTDKSIKIBETUID = "手続識別ＩＤ＝";

    private static final String KOUMOKUNM_SYONO = "証券番号＝";

    private static final String KOUMOKUNM_TOKUTEITRHKANSYONO = "特定取引用暗証番号＝";

    private static final String KOUMOKUNM_SHRGKGOUKEI = "支払額合計＝";

    private static final String KOUMOKUNM_SOUKINSAKI = "送金先＝";

    private static final String KOUMOKUNM_KZMEIGINM = "口座名義人＝";

    private static final String KOUMOKUNM_TTDKISIHYOUZI = "手続意思表示＝";

    private static final String ASUTARISUKU = "＊＊＊＊";

    private static final String TEN = "、";

    private static final List<String> CHKTASYLIST_EXECSYORI = Lists.newArrayList("iwsGyoumucd", "iwsSyorinaiyou");

    private static final List<String> CHKTASYLIST_SYONOINPUT = Lists.newArrayList("iwsTtdkskbt");

    private static final List<String> CHKTASYLIST_TKTANSYNINPUT = Lists.newArrayList("iwsTtdkskbt", "iwsSyono", "iwsDskokno");

    private static final List<String> CHKTASYLIST_KYKINFOSYTK = Lists.newArrayList("iwsTtdkskbt", "iwsSyono", "iwsDskokno");

    private static final List<String> CHKTASYLIST_KYKSASYKAKN = Lists.newArrayList("iwsTtdkskbt", "iwsSyono", "iwsDskokno",
        "iwsTtdkis", "iwsKouzaVersion");

    private static final List<String> CHKTASYLIST_SYRYSYORI = Lists.newArrayList("iwsTtdkskbt", "iwsTtdkis",
        "iwsTyakusintime", "iwsCallid", "iwsSyorikekka", "iwsStdnkasyo", "iwsStdnriyuu", "iwsTuuwatime");

    @Inject
    private static Logger logger;

    @Inject
    private DwDenwaKaiyakuUketukeDao dwDenwaKaiyakuUketukeDao;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private DirectDomManager directDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Override
    @Transactional
    public WsBzWebserviceResParamBean execPostForm(MultivaluedMap<String, String> pMap) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1017)));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean;

        try {
            WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);
            wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

            try {
                BeanUtils.populate(wsBzWebserviceReqParamBean, pMap);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);

            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }

            String gyoumuData = wsBzWebserviceReqParamBean.getGyoumuData();

            WsDwDenwaKaiyakuUketukeInputBean dwDenwaKaiyakuUketukeInputBean =
                JSON.decode(gyoumuData, WsDwDenwaKaiyakuUketukeInputBean.class);

            WebServiceAccesslogOutput webServiceAccesslogOutput =
                SWAKInjector.getInstance(WebServiceAccesslogOutput.class);

            webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN,
                wsBzWebserviceReqParamBean,
                dwDenwaKaiyakuUketukeInputBean);

            WsDwDenwaKaiyakuUketukeOutputBean dwDenwaKaiyakuUketukeOutputBean =
                SWAKInjector.getInstance(WsDwDenwaKaiyakuUketukeOutputBean.class);

            boolean hissuMChkKekka = dwDenwaKaiyakuUketukeInputBean.chkHissuMInput();

            if (!hissuMChkKekka) {
                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EMF1026));
            }


            boolean jkKekka = validationChk(dwDenwaKaiyakuUketukeInputBean, CHKTASYLIST_EXECSYORI);

            if (!jkKekka) {
                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EMF1026));
            }

            CheckKaiyakuUketuke checkKaiyakuUketuke = SWAKInjector.getInstance(CheckKaiyakuUketuke.class);
            C_ErrorKbn hanteiKekka = C_ErrorKbn.OK;
            C_DsSyoriNaiyouKbn syourinaiyou = C_DsSyoriNaiyouKbn.valueOf(dwDenwaKaiyakuUketukeInputBean.getIwsSyorinaiyou());

            if (!C_DsSyoriNaiyouKbn.SYUURYOUSYORI.eq(syourinaiyou) && !C_DsSyoriNaiyouKbn.TESTCALL.eq(syourinaiyou)) {

                hanteiKekka = checkKaiyakuUketuke.telkaiyakuKadoutimeChk();
            }

            if (C_ErrorKbn.OK.eq(hanteiKekka)) {

                if (C_DsSyoriNaiyouKbn.SYOKITOUROKU.eq(syourinaiyou)) {

                    dwDenwaKaiyakuUketukeOutputBean = syokiTouroku();
                }
                else if (C_DsSyoriNaiyouKbn.SYONOINPUT.eq(syourinaiyou)) {

                    dwDenwaKaiyakuUketukeOutputBean = syonoInput(dwDenwaKaiyakuUketukeInputBean);
                }
                else if (C_DsSyoriNaiyouKbn.TOKUTEIANSYONOINPUT.eq(syourinaiyou)) {

                    dwDenwaKaiyakuUketukeOutputBean = tokuteiAnsyonoInput(dwDenwaKaiyakuUketukeInputBean);
                }
                else if (C_DsSyoriNaiyouKbn.KAIYAKUINFOSYUTOKU.eq(syourinaiyou)) {

                    dwDenwaKaiyakuUketukeOutputBean = kaiyakuInfoSyutoku(dwDenwaKaiyakuUketukeInputBean);
                }
                else if (C_DsSyoriNaiyouKbn.KAIYAKUSAISYUUKAKUNIN.eq(syourinaiyou)) {

                    dwDenwaKaiyakuUketukeOutputBean = kaiyakuSaisyuuKakunin(dwDenwaKaiyakuUketukeInputBean);
                }
                else if (C_DsSyoriNaiyouKbn.SYUURYOUSYORI.eq(syourinaiyou)) {

                    dwDenwaKaiyakuUketukeOutputBean = syuuryouSyori(dwDenwaKaiyakuUketukeInputBean);
                }
                else if (C_DsSyoriNaiyouKbn.TESTCALL.eq(syourinaiyou)) {

                    dwDenwaKaiyakuUketukeOutputBean = SWAKInjector.getInstance(WsDwDenwaKaiyakuUketukeOutputBean.class);

                    dwDenwaKaiyakuUketukeOutputBean.setIwsNextsyoricd(C_NextSyoriCdKbn.TESTCALL.getValue());
                }
                else {
                    throw new CommonBizAppException("ＤＳ処理内容区分が想定外の値です。（ＤＳ処理内容区分：" + syourinaiyou + "）");
                }
            }
            else {

                if (!C_DsSyoriNaiyouKbn.SYOKITOUROKU.eq(syourinaiyou)) {

                    MT_SousaRireki sousaRireki = directDomManager.getSousaRireki(dwDenwaKaiyakuUketukeInputBean.getIwsTtdkskbt());

                    sousaRirekiSyousai(
                        sousaRireki,
                        syourinaiyou,
                        checkKaiyakuUketuke.getMessage());

                    directDomManager.update(sousaRireki);
                }
                dwDenwaKaiyakuUketukeOutputBean.setIwsNextsyoricd(C_NextSyoriCdKbn.ZIKANGAIERROR.getValue());
            }

            dwDenwaKaiyakuUketukeOutputBean.setIwsGyoumucd(C_DsGyoumuCdKbn.KAIYAKU.getValue());
            dwDenwaKaiyakuUketukeOutputBean.setIwsSyorinaiyou(dwDenwaKaiyakuUketukeInputBean.getIwsSyorinaiyou());
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dwDenwaKaiyakuUketukeOutputBean));

        } finally {
            logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1017)));
        }
        return wsBzWebserviceResParamBean;
    }

    private WsDwDenwaKaiyakuUketukeOutputBean syokiTouroku() {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1018)));

        WsDwDenwaKaiyakuUketukeOutputBean dwDenwaKaiyakuUketukeOutputBean;

        try {
            dwDenwaKaiyakuUketukeOutputBean = SWAKInjector.getInstance(WsDwDenwaKaiyakuUketukeOutputBean.class);
            BizDate ttdkstartymd = BizDate.getSysDate();
            String ttdkstarttime = BizDate.getSysDateTime().substring(8, 14);

            DsSaibanSyori dsSaibanSyori = SWAKInjector.getInstance(DsSaibanSyori.class);

            String dsTetudukiSikibetuId = dsSaibanSyori.saibanDsTetuzukiSikibetuId(ttdkstartymd);

            dwDenwaKaiyakuUketukeOutputBean.setIwsTtdkskbt(dsTetudukiSikibetuId);

            dwDenwaKaiyakuUketukeOutputBean.setIwsNextsyoricd(C_NextSyoriCdKbn.SYONOINPUT.getValue());

            String msg = MessageUtil.getMessage(MessageId.IMF1024);

            String syoriSys = msg + SYTRKNAIYOUKAIS + KOUMOKUNM_TTDKSIKIBETUID + dwDenwaKaiyakuUketukeOutputBean.getIwsTtdkskbt() +
                NYSYTNAIYOUSYUURYOU;

            MT_SousaRireki sousaRireki = new MT_SousaRireki(dwDenwaKaiyakuUketukeOutputBean.getIwsTtdkskbt());

            sousaRireki.setTtdkstartymd(ttdkstartymd);
            sousaRireki.setTtdkstarttime(ttdkstarttime);
            sousaRireki.setTtdkkinoukbn(C_TtdkKinouKbn.DENWAKAIYAKUUKETUKE);
            sousaRireki.setSousarirekijkkbn(C_SousaRirekiJkKbn.TETUZUKITYUU);
            sousaRireki.setSousarirekikekkakbn(C_TtdkKekkaKbn.BLNK);
            sousaRireki.setGyoumuKousinKinou(C_DsKinouidKbn.DENWAKAIYAKUUKETUKE.getValue());
            sousaRireki.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            sousaRireki.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            BizPropertyInitializer.initialize(sousaRireki);

            sousaRirekiSyousai(sousaRireki, C_DsSyoriNaiyouKbn.SYOKITOUROKU, syoriSys);

            directDomManager.insert(sousaRireki);

        } finally {
            logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1018)));
        }

        return dwDenwaKaiyakuUketukeOutputBean;
    }

    private WsDwDenwaKaiyakuUketukeOutputBean syonoInput(WsDwDenwaKaiyakuUketukeInputBean pInputBean) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1019)));

        WsDwDenwaKaiyakuUketukeOutputBean dwDenwaKaiyakuUketukeOutputBean;

        try {
            boolean hissuChkKekka = pInputBean.chkHissuInput();

            if (!hissuChkKekka) {
                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EMF1026));
            }


            boolean jkKekka = validationChk(pInputBean, CHKTASYLIST_SYONOINPUT);

            if (!jkKekka) {
                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EMF1026));
            }

            dwDenwaKaiyakuUketukeOutputBean = SWAKInjector.getInstance(WsDwDenwaKaiyakuUketukeOutputBean.class);
            String syoNo = pInputBean.getIwsSyono();
            String ttdkskbtId = pInputBean.getIwsTtdkskbt();
            dwDenwaKaiyakuUketukeOutputBean.setIwsTtdkskbt(ttdkskbtId);

            MT_SousaRireki sousaRireki = directDomManager.getSousaRireki(ttdkskbtId);

            IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);

            if (kykKihon == null) {
                int lockoutKiteiKaisuu = YuyuDswebConfig.getInstance().getLockoutKiteiKaisuu();
                String msg = "";
                String syoriSys = "";

                long syonoNinsspKaisuu = dwDenwaKaiyakuUketukeDao.getSousaRirekiSyousaiInhoKensuuByTtdksikibetuidSyorinaiyoukbn(
                    ttdkskbtId,
                    C_DsSyoriNaiyouKbn.SYONOINPUT);

                if (syonoNinsspKaisuu + 1 >= lockoutKiteiKaisuu) {

                    msg = MessageUtil.getMessage(MessageId.EMF1028, "証券番号");

                    syoriSys = msg + NYRKNAIYOUKAIS + KOUMOKUNM_SYONO + syoNo + NYSYTNAIYOUSYUURYOU;

                    dwDenwaKaiyakuUketukeOutputBean.setIwsNextsyoricd(C_NextSyoriCdKbn.SYONOTYOUKAERROR.getValue());
                }
                else {
                    msg = MessageUtil.getMessage(MessageId.IAF0003, "証券番号");

                    syoriSys = msg + NYRKNAIYOUKAIS + KOUMOKUNM_SYONO + syoNo + NYSYTNAIYOUSYUURYOU;

                    dwDenwaKaiyakuUketukeOutputBean.setIwsNextsyoricd(C_NextSyoriCdKbn.SYONONINSYOUERROR.getValue());
                }

                sousaRirekiSyousai(sousaRireki, C_DsSyoriNaiyouKbn.SYONOINPUT, syoriSys);

                directDomManager.update(sousaRireki);

                return dwDenwaKaiyakuUketukeOutputBean;
            }

            sousaRireki.setSyono(syoNo);
            sousaRireki.setGyoumuKousinKinou(C_DsKinouidKbn.DENWAKAIYAKUUKETUKE.getValue());
            sousaRireki.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            sousaRireki.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            MT_DsKokyakuKanri dsKokyakuKanri = dwDenwaKaiyakuUketukeDao.getYuukouKeiyakuDskokyakuInfoBySyono(syoNo);
            String dskokno = "";

            if (dsKokyakuKanri != null) {

                dskokno = dsKokyakuKanri.getDskokno();

                sousaRireki.setDskokno(dskokno);
            }

            CheckKaiyakuUketuke checkKaiyakuUketuke = SWAKInjector.getInstance(CheckKaiyakuUketuke.class);
            String syoriSyousai = "";

            C_ErrorKbn errorKbn = checkKaiyakuUketuke.dskokyakujtChk(syoNo);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                syoriSyousai = checkKaiyakuUketuke.getMessage() + NYRKNAIYOUKAIS + KOUMOKUNM_SYONO + syoNo + NYSYTNAIYOUSYUURYOU;
                dwDenwaKaiyakuUketukeOutputBean.setIwsNextsyoricd(C_NextSyoriCdKbn.SYORITYUUDANGUIDANCE.getValue());

                sousaRirekiSyousai(sousaRireki, C_DsSyoriNaiyouKbn.SYONOINPUT, syoriSyousai);

                directDomManager.update(sousaRireki);

                return dwDenwaKaiyakuUketukeOutputBean;
            }

            dwDenwaKaiyakuUketukeOutputBean.setIwsNextsyoricd(C_NextSyoriCdKbn.TOKUTEIINPUT.getValue());
            dwDenwaKaiyakuUketukeOutputBean.setIwsSyono(syoNo);
            dwDenwaKaiyakuUketukeOutputBean.setIwsDskokno(dskokno);

            String message = MessageUtil.getMessage(MessageId.IMF1024);

            syoriSyousai = message + NYRKNAIYOUKAIS + KOUMOKUNM_SYONO + syoNo + NYSYTNAIYOUSYUURYOU;

            sousaRirekiSyousai(sousaRireki, C_DsSyoriNaiyouKbn.SYONOINPUT, syoriSyousai);

            directDomManager.update(sousaRireki);

        } finally {
            logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1019)));
        }

        return dwDenwaKaiyakuUketukeOutputBean;
    }

    private WsDwDenwaKaiyakuUketukeOutputBean tokuteiAnsyonoInput(WsDwDenwaKaiyakuUketukeInputBean pInputBean) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1020)));

        WsDwDenwaKaiyakuUketukeOutputBean dwDenwaKaiyakuUketukeOutputBean;

        try {
            boolean hissuChkKekka = pInputBean.chkHissuInput();

            if (!hissuChkKekka) {
                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EMF1026));
            }


            boolean jkKekka = validationChk(pInputBean, CHKTASYLIST_TKTANSYNINPUT);

            if (!jkKekka) {
                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EMF1026));
            }

            dwDenwaKaiyakuUketukeOutputBean = SWAKInjector.getInstance(WsDwDenwaKaiyakuUketukeOutputBean.class);
            String ttdkskbtId = pInputBean.getIwsTtdkskbt();
            dwDenwaKaiyakuUketukeOutputBean.setIwsTtdkskbt(ttdkskbtId);

            MT_SousaRireki sousaRireki = directDomManager.getSousaRireki(ttdkskbtId);

            boolean ninsskFlg = false;
            boolean lockoutFlg = false;

            CheckKaiyakuUketuke checkKaiyakuUketuke = SWAKInjector.getInstance(CheckKaiyakuUketuke.class);
            String syoriSyousai = "";

            C_ErrorKbn errorKbn = checkKaiyakuUketuke.tokuteitrhkkzYuukoujtChk(pInputBean.getIwsSyono(), pInputBean.getIwsDskokno());

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                syoriSyousai = checkKaiyakuUketuke.getMessage() + NYRKNAIYOUKAIS + KOUMOKUNM_TOKUTEITRHKANSYONO +
                    ASUTARISUKU + NYSYTNAIYOUSYUURYOU;
                dwDenwaKaiyakuUketukeOutputBean.setIwsNextsyoricd(C_NextSyoriCdKbn.SYORITYUUDANGUIDANCE.getValue());

                sousaRirekiSyousai(sousaRireki, C_DsSyoriNaiyouKbn.TOKUTEIANSYONOINPUT, syoriSyousai);

                directDomManager.update(sousaRireki);

                return dwDenwaKaiyakuUketukeOutputBean;
            }

            MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(pInputBean.getIwsDskokno());
            MT_DsKokyakuKeiyaku dsKokyakuKeiyaku = dsKokyakuKanri.getDsKokyakuKeiyakuBySyono(pInputBean.getIwsSyono());
            MT_DsTorihikiServiceKanri dsTorihikiServiceKanri = dsKokyakuKeiyaku.getDsTorihikiServiceKanri();
            MT_DsTorihikiyouAnsyono dsTorihikiyouAnsyono = dsTorihikiServiceKanri.getDsTorihikiyouAnsyono();

            if (pInputBean.getIwsTokuteitrhkansyono().equals(dsTorihikiyouAnsyono.getTokuteitrhkansyono())) {

                ninsskFlg = true;
            }

            if (!ninsskFlg) {

                int lockoutKiteiKaisuu = YuyuDswebConfig.getInstance().getLockoutKiteiKaisuu();

                dsTorihikiyouAnsyono.setTktrhkansyonoerrorkaisuu(dsTorihikiyouAnsyono.getTktrhkansyonoerrorkaisuu() + 1);

                if (dsTorihikiyouAnsyono.getTktrhkansyonoerrorkaisuu() >= lockoutKiteiKaisuu) {

                    lockoutFlg = true;
                }
            }

            if (lockoutFlg) {

                dsTorihikiServiceKanri.setDstrhkserviceriyoujkkbn(C_DsTrhkserviceRiyoujkKbn.RIYOU_HUKA);
                dsTorihikiServiceKanri.setDstrhkserviceteisiriyuukbn(C_DsTrhkserviceTeisiRiyuuKbn.LOCK_OUT);
                dsTorihikiServiceKanri.setDstrhkservicemukouymd(BizDate.getSysDate());
                dsTorihikiServiceKanri.setGyoumuKousinKinou(C_DsKinouidKbn.DENWAKAIYAKUUKETUKE.getValue());
                dsTorihikiServiceKanri.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                dsTorihikiServiceKanri.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            }

            if (ninsskFlg) {

                dsTorihikiyouAnsyono.setTktrhkansyonoerrorkaisuu(0);
            }

            dsTorihikiyouAnsyono.setTktrhkansyonoerrorkaisuu(dsTorihikiyouAnsyono.getTktrhkansyonoerrorkaisuu());
            dsTorihikiyouAnsyono.setGyoumuKousinKinou(C_DsKinouidKbn.DENWAKAIYAKUUKETUKE.getValue());
            dsTorihikiyouAnsyono.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            dsTorihikiyouAnsyono.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            directDomManager.update(dsKokyakuKanri);

            String kekkaMsg = "";

            if (lockoutFlg) {

                kekkaMsg = MessageUtil.getMessage(MessageId.EMF1028, "特定取引用暗証番号");
                dwDenwaKaiyakuUketukeOutputBean.setIwsNextsyoricd(C_NextSyoriCdKbn.TOKUTEIANSYONOTYOUKAERROR.getValue());
            }

            else if (!ninsskFlg) {

                kekkaMsg = MessageUtil.getMessage(MessageId.EMF1030);
                dwDenwaKaiyakuUketukeOutputBean.setIwsNextsyoricd(C_NextSyoriCdKbn.TOKUTEIANSYONONINSYOUERROR.getValue());
            }
            else {

                kekkaMsg = MessageUtil.getMessage(MessageId.IMF1024);
                dwDenwaKaiyakuUketukeOutputBean.setIwsNextsyoricd(C_NextSyoriCdKbn.KAIYAKUINFOSYUTOKU.getValue());
            }

            syoriSyousai = kekkaMsg + NYRKNAIYOUKAIS + KOUMOKUNM_TOKUTEITRHKANSYONO + ASUTARISUKU + NYSYTNAIYOUSYUURYOU;

            sousaRirekiSyousai(sousaRireki, C_DsSyoriNaiyouKbn.TOKUTEIANSYONOINPUT, syoriSyousai);

            directDomManager.update(sousaRireki);
        } finally {
            logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1020)));
        }
        return dwDenwaKaiyakuUketukeOutputBean;
    }

    private WsDwDenwaKaiyakuUketukeOutputBean kaiyakuInfoSyutoku (WsDwDenwaKaiyakuUketukeInputBean pInputBean) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1021)));

        WsDwDenwaKaiyakuUketukeOutputBean dwDenwaKaiyakuUketukeOutputBean;

        try {
            boolean hissuChkKekka = pInputBean.chkHissuInput();

            if (!hissuChkKekka) {
                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EMF1026));
            }


            boolean jkKekka = validationChk(pInputBean, CHKTASYLIST_KYKINFOSYTK);

            if (!jkKekka) {
                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EMF1026));
            }

            dwDenwaKaiyakuUketukeOutputBean = SWAKInjector.getInstance(WsDwDenwaKaiyakuUketukeOutputBean.class);
            String ttdkskbtId = pInputBean.getIwsTtdkskbt();
            String syoNo = pInputBean.getIwsSyono();
            dwDenwaKaiyakuUketukeOutputBean.setIwsTtdkskbt(ttdkskbtId);

            MT_SousaRireki sousaRireki = directDomManager.getSousaRireki(ttdkskbtId);

            IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);
            IT_KykSya kykSya = kykKihon.getKykSya();
            List<IT_KykSyouhn> kykSyouhnList = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
            IT_KykSyouhn kykSyouhn = kykSyouhnList.get(0);

            CheckKaiyakuUketuke checkKaiyakuUketuke = SWAKInjector.getInstance(CheckKaiyakuUketuke.class);
            String syoriSyousai = "";
            C_ErrorKbn errorKbn = C_ErrorKbn.OK;

            if (!C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {

                errorKbn = checkKaiyakuUketuke.kawaserateExistChk(kykSyouhn.getKyktuukasyu());

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                    syoriSyousai = checkKaiyakuUketuke.getMessage();
                    dwDenwaKaiyakuUketukeOutputBean.setIwsNextsyoricd(C_NextSyoriCdKbn.SYORITYUUDANGUIDANCE.getValue());

                    sousaRirekiSyousai(sousaRireki, C_DsSyoriNaiyouKbn.KAIYAKUINFOSYUTOKU, syoriSyousai);

                    directDomManager.update(sousaRireki);

                    return dwDenwaKaiyakuUketukeOutputBean;
                }
            }

            errorKbn = checkKaiyakuUketuke.kykymdMaeChk(kykSyouhn.getSyono());

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                syoriSyousai = checkKaiyakuUketuke.getMessage();
                dwDenwaKaiyakuUketukeOutputBean.setIwsNextsyoricd(C_NextSyoriCdKbn.SYORITYUUDANGUIDANCE.getValue());

                sousaRirekiSyousai(sousaRireki, C_DsSyoriNaiyouKbn.KAIYAKUINFOSYUTOKU, syoriSyousai);

                directDomManager.update(sousaRireki);

                return dwDenwaKaiyakuUketukeOutputBean;
            }

            errorKbn = checkKaiyakuUketuke.dsDataMaintenanceChk(kykSyouhn.getSyono());

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                syoriSyousai = checkKaiyakuUketuke.getMessage();

                dwDenwaKaiyakuUketukeOutputBean.setIwsNextsyoricd(C_NextSyoriCdKbn.SYORITYUUDANGUIDANCE.getValue());

                sousaRirekiSyousai(sousaRireki, C_DsSyoriNaiyouKbn.KAIYAKUINFOSYUTOKU, syoriSyousai);

                directDomManager.update(sousaRireki);

                return dwDenwaKaiyakuUketukeOutputBean;
            }

            GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
            KeisanCommonKaiyaku keisanCommonKaiyaku = SWAKInjector.getInstance(KeisanCommonKaiyaku.class);
            KeisanKaiyakuBean keisanKaiyakuBean = new KeisanKaiyakuBean();
            KeisanCommonKaiyakuOutBean keisanCommonKaiyakuOutBean = new KeisanCommonKaiyakuOutBean();

            errorKbn = getKawaseRate.exec(
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

            errorKbn = keisanCommonKaiyaku.keisanKaiyakuseisankin(
            keisanCommonKaiyaku.KINOUBUNRUI_DRCTSERVICE,
            kykKihon,
            BizDate.getSysDate(),
            keisanKaiyakuBean);

            keisanCommonKaiyakuOutBean = keisanCommonKaiyaku.getKeisanCommonKaiyakuOutBean();

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0129,
                    "解約共通計算（証券番号：" + syoNo + "、処理年月日：" + BizDate.getSysDate() + "）"));
            }

            errorKbn = checkKaiyakuUketuke.tokuteitrhkkzMstExistChk(syoNo, pInputBean.getIwsDskokno(), C_KouzasyuruiKbn.YENKOUZA);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                syoriSyousai = checkKaiyakuUketuke.getMessage();
                dwDenwaKaiyakuUketukeOutputBean.setIwsNextsyoricd(C_NextSyoriCdKbn.SYORITYUUDANGUIDANCE.getValue());

                sousaRirekiSyousai(sousaRireki, C_DsSyoriNaiyouKbn.KAIYAKUINFOSYUTOKU, syoriSyousai);

                directDomManager.update(sousaRireki);

                return dwDenwaKaiyakuUketukeOutputBean;
            }

            MT_DsSoukinyouKouza dsSoukinyouKouza = dwDenwaKaiyakuUketukeDao.getDsSoukinyouKouzaByDskoknoSyonoKouzaSyuruiKbn(
                pInputBean.getIwsDskokno(),
                syoNo,
                C_KouzasyuruiKbn.YENKOUZA);

            BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);
            BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(dsSoukinyouKouza.getBankcd(), dsSoukinyouKouza.getSitencd());

            dwDenwaKaiyakuUketukeOutputBean.setIwsNextsyoricd(C_NextSyoriCdKbn.KAIYAKUSAISYUUKAKUNIIN.getValue());
            dwDenwaKaiyakuUketukeOutputBean.setIwsShrgkkei(keisanCommonKaiyakuOutBean.getShrgkkeiYen().toAdsoluteString());
            dwDenwaKaiyakuUketukeOutputBean.setIwsBankcd(dsSoukinyouKouza.getBankcd());
            dwDenwaKaiyakuUketukeOutputBean.setIwsBanknmkn(bzGetBankDataBean.getBankNmKn());
            dwDenwaKaiyakuUketukeOutputBean.setIwsKouzaVersion(String.valueOf(dsSoukinyouKouza.getVersion()));

            if (C_Kzdou.DOUITU.eq(dsSoukinyouKouza.getKzdoukbn())) {

                dwDenwaKaiyakuUketukeOutputBean.setIwsKzmeiginmkn(kykSya.getKyknmkn());
            }
            else {

                dwDenwaKaiyakuUketukeOutputBean.setIwsKzmeiginmkn(dsSoukinyouKouza.getKzmeiginmkn());
            }

            String kekkaMsg = MessageUtil.getMessage(MessageId.IMF1024);
            String iwsShrgkgk = keisanCommonKaiyakuOutBean.getShrgkkeiYen().toFormatStringWithUnit();

            syoriSyousai = kekkaMsg + SYTRKNAIYOUKAIS + KOUMOKUNM_SHRGKGOUKEI + iwsShrgkgk + TEN + KOUMOKUNM_SOUKINSAKI +
                dwDenwaKaiyakuUketukeOutputBean.getIwsBanknmkn() + TEN +  KOUMOKUNM_KZMEIGINM +
                dwDenwaKaiyakuUketukeOutputBean.getIwsKzmeiginmkn() + NYSYTNAIYOUSYUURYOU;

            sousaRirekiSyousai(sousaRireki, C_DsSyoriNaiyouKbn.KAIYAKUINFOSYUTOKU, syoriSyousai);

            directDomManager.update(sousaRireki);
        } finally {
            logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1021)));
        }
        return dwDenwaKaiyakuUketukeOutputBean;
    }

    private WsDwDenwaKaiyakuUketukeOutputBean  kaiyakuSaisyuuKakunin(WsDwDenwaKaiyakuUketukeInputBean pInputBean) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1022)));

        WsDwDenwaKaiyakuUketukeOutputBean dwDenwaKaiyakuUketukeOutputBean;

        try {
            boolean hissuChkKekka = pInputBean.chkHissuInput();

            if (!hissuChkKekka) {
                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EMF1026));
            }


            boolean jkKekka = validationChk(pInputBean, CHKTASYLIST_KYKSASYKAKN);

            if (!jkKekka) {
                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EMF1026));
            }

            dwDenwaKaiyakuUketukeOutputBean = SWAKInjector.getInstance(WsDwDenwaKaiyakuUketukeOutputBean.class);
            String ttdkskbtId = pInputBean.getIwsTtdkskbt();
            String syoNo = pInputBean.getIwsSyono();
            dwDenwaKaiyakuUketukeOutputBean.setIwsTtdkskbt(ttdkskbtId);

            MT_SousaRireki sousaRireki = directDomManager.getSousaRireki(ttdkskbtId);

            String syoriSyousai = "";
            if (C_TtdkIsihyouziKbn.TETUZUKIZISSI.eq(C_TtdkIsihyouziKbn.valueOf(pInputBean.getIwsTtdkis()))) {

                syoriSyousai = hanteiDenwaKaiyakuUketukeKahi(pInputBean);

                if (!BizUtil.isBlank(syoriSyousai)) {

                    dwDenwaKaiyakuUketukeOutputBean.setIwsNextsyoricd(C_NextSyoriCdKbn.SYORITYUUDANGUIDANCE.getValue());
                }
                else {

                    IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);
                    List<IT_KykSyouhn> kykSyouhnList = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

                    MT_DsSoukinyouKouza dsSoukinyouKouza = dwDenwaKaiyakuUketukeDao.getDsSoukinyouKouzaByDskoknoSyonoKouzaSyuruiKbn(
                        pInputBean.getIwsDskokno(),
                        syoNo,
                        C_KouzasyuruiKbn.YENKOUZA);

                    String hozenHenkouUktkrenNo = SaibanBiz.getHozenHenkouUktkrenNo(syoNo);
                    IT_KhHenkouUktk khHenkouUktk = new IT_KhHenkouUktk(syoNo, Integer.valueOf(hozenHenkouUktkrenNo));

                    khHenkouUktk.setUktkymd(BizDate.getSysDate());
                    khHenkouUktk.setTourokuroute(C_TourokuRouteKbn.TEL);
                    khHenkouUktk.setUktksyorikbn(C_UktkSyoriKbn.KAIYAKU);
                    khHenkouUktk.setKouryokuhasseiymd(BizDate.getSysDate());
                    khHenkouUktk.setSyoriyoteiymd(BizDate.getSysDate());
                    khHenkouUktk.setUktkjyoutaikbn(C_UktkJyoutaiKbn.MISYORI);
                    khHenkouUktk.setGyoumuKousinKinou(C_DsKinouidKbn.DENWAKAIYAKUUKETUKE.getValue());
                    khHenkouUktk.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    khHenkouUktk.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                    BizPropertyInitializer.initialize(khHenkouUktk);

                    IT_KhHenkouUktkKaiyaku khHenkouUktkKaiyaku = khHenkouUktk.createKhHenkouUktkKaiyaku();
                    khHenkouUktkKaiyaku.setInputshrhousiteikbn(C_InputShrhousiteiKbn.FBSOUKIN);

                    if (C_UmuKbn.ARI.eq(kykSyouhnList.get(0).getSyouhnZokusei().getYenshrtktekiumu())) {

                        khHenkouUktkKaiyaku.setYenshrtkhkumu(C_UmuKbn.ARI);
                    }
                    else {

                        khHenkouUktkKaiyaku.setYenshrtkhkumu(C_UmuKbn.NONE);
                    }
                    khHenkouUktkKaiyaku.setBankcd(dsSoukinyouKouza.getBankcd());
                    khHenkouUktkKaiyaku.setSitencd(dsSoukinyouKouza.getSitencd());
                    khHenkouUktkKaiyaku.setYokinkbn(dsSoukinyouKouza.getYokinkbn());
                    khHenkouUktkKaiyaku.setKouzano(dsSoukinyouKouza.getKouzano());
                    khHenkouUktkKaiyaku.setKzdoukbn(dsSoukinyouKouza.getKzdoukbn());

                    if (C_Kzdou.DOUITU.eq(dsSoukinyouKouza.getKzdoukbn())) {

                        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(pInputBean.getIwsDskokno());

                        khHenkouUktkKaiyaku.setKzmeiginmkn(dsKokyakuKanri.getDskokyakunmkn());
                    }
                    else {

                        khHenkouUktkKaiyaku.setKzmeiginmkn(dsSoukinyouKouza.getKzmeiginmkn());
                    }
                    khHenkouUktkKaiyaku.setGyoumuKousinKinou(C_DsKinouidKbn.DENWAKAIYAKUUKETUKE.getValue());
                    khHenkouUktkKaiyaku.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    khHenkouUktkKaiyaku.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                    BizPropertyInitializer.initialize(khHenkouUktkKaiyaku);
                    hozenDomManager.insert(khHenkouUktk);

                    syoriSyousai = MessageUtil.getMessage(MessageId.IMF1024);

                    dwDenwaKaiyakuUketukeOutputBean.setIwsNextsyoricd(C_NextSyoriCdKbn.KAIYAKUKANRYOU.getValue());
                }
            }
            else {

                syoriSyousai = MessageUtil.getMessage(MessageId.IMF1021);

                dwDenwaKaiyakuUketukeOutputBean.setIwsNextsyoricd(C_NextSyoriCdKbn.KAIYAKUTYUUSI.getValue());
            }

            syoriSyousai = syoriSyousai + NYRKNAIYOUKAIS + KOUMOKUNM_TTDKISIHYOUZI + pInputBean.getIwsTtdkis() +
                NYSYTNAIYOUSYUURYOU;

            sousaRirekiSyousai(sousaRireki, C_DsSyoriNaiyouKbn.KAIYAKUSAISYUUKAKUNIN, syoriSyousai);

            directDomManager.update(sousaRireki);
        } finally {
            logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1022)));
        }
        return dwDenwaKaiyakuUketukeOutputBean;
    }

    private WsDwDenwaKaiyakuUketukeOutputBean syuuryouSyori(WsDwDenwaKaiyakuUketukeInputBean pInputBean) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1023)));

        WsDwDenwaKaiyakuUketukeOutputBean dwDenwaKaiyakuUketukeOutputBean;

        try {
            boolean hissuChkKekka = pInputBean.chkHissuInput();

            if (!hissuChkKekka) {
                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EMF1026));
            }


            boolean jkKekka = validationChk(pInputBean, CHKTASYLIST_SYRYSYORI);

            if (!jkKekka) {
                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EMF1026));
            }

            dwDenwaKaiyakuUketukeOutputBean = SWAKInjector.getInstance(WsDwDenwaKaiyakuUketukeOutputBean.class);

            MT_SousaRireki sousaRireki = directDomManager.getSousaRireki(pInputBean.getIwsTtdkskbt());

            String syoriSyousai = "";
            if (C_TtdkKekkaKbn.TETUDUKIKANRYOU.eq(C_TtdkKekkaKbn.valueOf(pInputBean.getIwsSyorikekka()))) {

                syoriSyousai = MessageUtil.getMessage(MessageId.IMF1024);
            }
            else {

                syoriSyousai = MessageUtil.getMessage(MessageId.IMF1021);
            }

            sousaRireki.setTtdkendymd(BizDate.getSysDate());
            sousaRireki.setTtdkendtime(BizDate.getSysDateTime().substring(8, 14));
            sousaRireki.setSousarirekijkkbn(C_SousaRirekiJkKbn.END);
            sousaRireki.setSousarirekikekkakbn(C_TtdkKekkaKbn.valueOf(pInputBean.getIwsSyorikekka()));
            sousaRireki.setGyoumuKousinKinou(C_DsKinouidKbn.DENWAKAIYAKUUKETUKE.getValue());
            sousaRireki.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            sousaRireki.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            MT_SousaRirekiIvrInfo sousaRirekiIvrInfo = sousaRireki.createSousaRirekiIvrInfo();

            sousaRirekiIvrInfo.setTyakusinymd(pInputBean.getIwsTyakusintime());
            sousaRirekiIvrInfo.setDsgyoumucd(C_DsGyoumuCdKbn.valueOf(pInputBean.getIwsGyoumucd()));
            sousaRirekiIvrInfo.setSyorinaiyoukbn(C_DsSyoriNaiyouKbn.valueOf(pInputBean.getIwsSyorinaiyou()));
            sousaRirekiIvrInfo.setCallid(pInputBean.getIwsCallid());
            sousaRirekiIvrInfo.setDssyorikekkakbn(C_TtdkKekkaKbn.valueOf(pInputBean.getIwsSyorikekka()));
            sousaRirekiIvrInfo.setSetudankasyokbn(C_SetudanKasyoKbn.valueOf(pInputBean.getIwsStdnkasyo()));
            sousaRirekiIvrInfo.setSetudanriyuukbn(C_SetudanRiyuuKbn.valueOf(pInputBean.getIwsStdnriyuu()));
            sousaRirekiIvrInfo.setTuuwatime(pInputBean.getIwsTuuwatime());
            if (BizUtil.isBlank(pInputBean.getIwsTtdkis())) {

                sousaRirekiIvrInfo.setTtdkisihyouzikbn(C_TtdkIsihyouziKbn.BLNK);
            }
            else {

                sousaRirekiIvrInfo.setTtdkisihyouzikbn(C_TtdkIsihyouziKbn.valueOf(pInputBean.getIwsTtdkis()));
            }

            sousaRirekiIvrInfo.setGyoumuKousinKinou(C_DsKinouidKbn.DENWAKAIYAKUUKETUKE.getValue());
            sousaRirekiIvrInfo.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            sousaRirekiIvrInfo.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            BizPropertyInitializer.initialize(sousaRirekiIvrInfo);

            sousaRirekiSyousai(sousaRireki, C_DsSyoriNaiyouKbn.SYUURYOUSYORI, syoriSyousai);

            directDomManager.update(sousaRireki);
        } finally {
            logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1023)));
        }
        return dwDenwaKaiyakuUketukeOutputBean;
    }

    private boolean validationChk(WsDwDenwaKaiyakuUketukeInputBean pInputBean, List<String> pChkTasyList) {

        for (String chkTaisyou : pChkTasyList) {

            Validator validator = SWAKInjector.getInstance(Validator.class);

            Set<ConstraintViolation<WsDwDenwaKaiyakuUketukeInputBean>> validatorChkKekkaSet =
                validator.validateProperty(pInputBean, chkTaisyou);

            if (validatorChkKekkaSet.size() > 0) {
                return false;
            }
        }
        return true;
    }

    private void sousaRirekiSyousai(MT_SousaRireki pSousaRireki, C_DsSyoriNaiyouKbn pSyoriNaiyouKbn, String pSyoriSyousai) {

        Integer maxRenNo = dwDenwaKaiyakuUketukeDao.getSousaRirekiRenbanMaxByTtdksikibetuid(pSousaRireki.getTtdksikibetuid());

        if(maxRenNo == null){
            maxRenNo = 0;
        }

        MT_SousaRirekiSyousai sousaRirekiSys = pSousaRireki.createSousaRirekiSyousai();

        sousaRirekiSys.setSousarirekirenno(maxRenNo + 1);
        sousaRirekiSys.setSyoriendymd(BizDate.getSysDate());
        sousaRirekiSys.setSyoriendtime(BizDate.getSysDateTime().substring(8, 14));
        sousaRirekiSys.setSyorinaiyoukbn(pSyoriNaiyouKbn);
        sousaRirekiSys.setSyorisyousai(ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, pSyoriSyousai));
        sousaRirekiSys.setGyoumuKousinKinou(C_DsKinouidKbn.DENWAKAIYAKUUKETUKE.getValue());
        sousaRirekiSys.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        sousaRirekiSys.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        BizPropertyInitializer.initialize(sousaRirekiSys);
    }

    private String hanteiDenwaKaiyakuUketukeKahi(WsDwDenwaKaiyakuUketukeInputBean pInputBean) {

        CheckKaiyakuUketuke checkKaiyakuUketuke = SWAKInjector.getInstance(CheckKaiyakuUketuke.class);
        String kekkaMsg = "";
        C_ErrorKbn errorKbn = C_ErrorKbn.OK;
        errorKbn = checkKaiyakuUketuke.dskokyakujtChk(pInputBean.getIwsSyono());

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            kekkaMsg = checkKaiyakuUketuke.getMessage();

            return kekkaMsg;
        }

        errorKbn = checkKaiyakuUketuke.dskaiyakuChk(pInputBean.getIwsSyono());

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            kekkaMsg = checkKaiyakuUketuke.getMessage();

            return kekkaMsg;
        }

        errorKbn = checkKaiyakuUketuke.tokuteitrhkkzYuukoujtChk(pInputBean.getIwsSyono(), pInputBean.getIwsDskokno());

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            kekkaMsg = checkKaiyakuUketuke.getMessage();

            return kekkaMsg;
        }

        errorKbn = checkKaiyakuUketuke.tokuteitrhkkzChk(pInputBean.getIwsSyono(), pInputBean.getIwsDskokno(),
            C_KouzasyuruiKbn.YENKOUZA);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            kekkaMsg = checkKaiyakuUketuke.getMessage();

            return kekkaMsg;
        }

        errorKbn = checkKaiyakuUketuke.dskaiyakuukeumuChk(pInputBean.getIwsSyono());

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            kekkaMsg = checkKaiyakuUketuke.getMessage();

            return kekkaMsg;
        }

        MT_DsSoukinyouKouza dsSoukinyouKouza = dwDenwaKaiyakuUketukeDao.getDsSoukinyouKouzaByDskoknoSyonoKouzaSyuruiKbn(
            pInputBean.getIwsDskokno(),
            pInputBean.getIwsSyono(),
            C_KouzasyuruiKbn.YENKOUZA);

        if (!String.valueOf(dsSoukinyouKouza.getVersion()).equals(pInputBean.getIwsKouzaVersion())) {
            kekkaMsg = MessageUtil.getMessage(MessageId.EMF1039);

            return kekkaMsg;
        }

        return kekkaMsg;
    }
}
