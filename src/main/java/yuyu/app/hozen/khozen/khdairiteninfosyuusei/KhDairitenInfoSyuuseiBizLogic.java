package yuyu.app.hozen.khozen.khdairiteninfosyuusei;

import static yuyu.app.hozen.khozen.khdairiteninfosyuusei.GenKhDairitenInfoSyuuseiConstants.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUiBeanBackupUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetAdrData;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzdairiten.BzChkAgYuukou;
import yuyu.common.biz.bzdairiten.BzChkBsYuukou;
import yuyu.common.biz.bzdairiten.BzChkBsYuukouHengaku;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzdairiten.BzGetAgInfoJimusyo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoKinyuuKikan;
import yuyu.common.biz.bzdairiten.BzGetBsInfo;
import yuyu.common.biz.bzdairiten.BzGetBsInfoBean;
import yuyu.common.biz.bzdairiten.BzGetBsInfoBstrkno;
import yuyu.common.biz.bzdairiten.BzGetBsInfoKouin;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.PALKykNaiyouKousin;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.common.hozen.setuibean.SetKihon;
import yuyu.common.hozen.setuibean.SetTetudukityuui;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuui;
import yuyu.common.sinkeiyaku.skcommon.GetDairitenKobetuJyouhou;
import yuyu.common.sinkeiyaku.skcommon.GetDairitenKobetuJyouhouBean;
import yuyu.def.MessageId;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_DairitenInfoSyoriKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_SosikiYuuksHantKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IW_CifcdIktHnkWk;
import yuyu.def.hozen.manager.HozenDomManager;

import com.google.common.base.Strings;

/**
 * 代理店情報修正 のビジネスロジックです
 */
public class KhDairitenInfoSyuuseiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhDairitenInfoSyuuseiUiBean uiBean;

    @Inject
    private InputContentsCopyBean inputContentsCopyBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private MessageManager messageManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    private List<String> messageManagerLst = new ArrayList<>();

    void init() {
        clear();
    }

    void clear() {
    }

    String pushNyuuryokuBL() {
        BizPropertyInitializer.initialize(uiBean);

        uiBean.setSyono(uiBean.getVkihnsyono());

        isExist();

        chkJyoutai();

        chkCIFCd();

        SetToriatukaiTyuui setToriatukaiTyuui = SWAKInjector.getInstance(SetToriatukaiTyuui.class);
        setToriatukaiTyuui.exec(khozenCommonParam, uiBean);

        if (C_DairitenInfoSyoriKbn.ALL.eq(uiBean.getDrteninfosyuuseitaisyou())) {
            SetKihon.exec(khozenCommonParam, uiBean);

            SetTetudukityuui.exec(khozenCommonParam, uiBean);

            uiBean.setCifcd1(uiBean.getKykKihon().getCifcd());
            uiBean.setUktkid1(uiBean.getKykKihon().getSmbckanriid());
            List<IT_KykDairiten> kykDairitenList = uiBean.getKykKihon().getKykDairitens();

            String gyousekikeijyousakisosikicd1 = "";
            String gyousekikeijyousakisosikicd2 = "";

            for (IT_KykDairiten itKykDairiten : kykDairitenList) {

                if (itKykDairiten.getDrtenrenno() == 1) {
                    gyousekikeijyousakisosikicd1 = itKykDairiten.getGyousekikeijyousakisosikicd();
                }
                else if (itKykDairiten.getDrtenrenno() == 2) {
                    gyousekikeijyousakisosikicd2 = itKykDairiten.getGyousekikeijyousakisosikicd();
                }
            }

            List<BzGetAgInfoBean> bzGetAgInfoBean = getDairitenInfo(kykDairitenList.get(0).getDrtencd());

            BzGetBsInfoBean bzGetBsInfoBean = getBsInfo(kykDairitenList.get(0).getBosyuucd());

            if (!BizUtil.isBlank(gyousekikeijyousakisosikicd1)) {

                BzGetSosikiDataBean bzGetSosikiDataBean = getSosikData(gyousekikeijyousakisosikicd1);

                uiBean.setGyskkjsakisosikicd1(gyousekikeijyousakisosikicd1);
                uiBean.setGyskkjsakisosikinmkj1(bzGetSosikiDataBean.getKanjisosikinm20());
            }


            if (bzGetAgInfoBean.size() > 0) {
                uiBean.setDrtenjimcd1(bzGetAgInfoBean.get(0).getDrtenJimCd());
                uiBean.setDairitenkinyuukikancd1(bzGetAgInfoBean.get(0).getKinyuuCd());
                uiBean.setDairitenkinyuukikansitencd1(bzGetAgInfoBean.get(0).getKinyuuSitenCd());
                uiBean.setKanjitoriatukaidairitennm1(bzGetAgInfoBean.get(0).getKanjiDairitenNm());
                uiBean.setKanjioyadrtennm1(bzGetAgInfoBean.get(1).getKanjiDairitenNm());
            }

            if (bzGetBsInfoBean != null) {
                uiBean.setBosyuunintourokuno1(bzGetBsInfoBean.getBosyuuTrkNo());
                uiBean.setDairitentoriatukaikouincd1(bzGetBsInfoBean.getKouinCd());
                uiBean.setBosyuuninnm1(bzGetBsInfoBean.getKanjiBosyuuninNm());
            }

            uiBean.setToriatukaidairitencd1(kykDairitenList.get(0).getDrtencd());
            uiBean.setOyadairitencd1(kykDairitenList.get(0).getOyadrtencd());
            uiBean.setBosyuucd1(kykDairitenList.get(0).getBosyuucd());
            uiBean.setBunwari1(kykDairitenList.get(0).getBunwari());

            if (kykDairitenList.size() > 1) {

                bzGetAgInfoBean = getDairitenInfo(kykDairitenList.get(1).getDrtencd());

                bzGetBsInfoBean = getBsInfo(kykDairitenList.get(1).getBosyuucd());

                if (!BizUtil.isBlank(gyousekikeijyousakisosikicd2)) {

                    BzGetSosikiDataBean bzGetSosikiDataBean = getSosikData(gyousekikeijyousakisosikicd2);

                    uiBean.setGyskkjsakisosikicd2(gyousekikeijyousakisosikicd2);
                    uiBean.setGyskkjsakisosikinmkj2(bzGetSosikiDataBean.getKanjisosikinm20());
                }


                if (bzGetAgInfoBean.size() > 0) {
                    uiBean.setDrtenjimcd2(bzGetAgInfoBean.get(0).getDrtenJimCd());
                    uiBean.setDairitenkinyuukikancd2(bzGetAgInfoBean.get(0).getKinyuuCd());
                    uiBean.setDairitenkinyuukikansitencd2(bzGetAgInfoBean.get(0).getKinyuuSitenCd());
                    uiBean.setKanjitoriatukaidairitennm2(bzGetAgInfoBean.get(0).getKanjiDairitenNm());
                    uiBean.setKanjioyadrtennm2(bzGetAgInfoBean.get(1).getKanjiDairitenNm());
                }

                if (bzGetBsInfoBean != null) {
                    uiBean.setBosyuunintourokuno2(bzGetBsInfoBean.getBosyuuTrkNo());
                    uiBean.setDairitentoriatukaikouincd2(bzGetBsInfoBean.getKouinCd());
                    uiBean.setBosyuuninnm2(bzGetBsInfoBean.getKanjiBosyuuninNm());
                }

                uiBean.setBosyuucd2(kykDairitenList.get(1).getBosyuucd());
                uiBean.setToriatukaidairitencd2(kykDairitenList.get(1).getDrtencd());
                uiBean.setOyadairitencd2(kykDairitenList.get(1).getOyadrtencd());
                uiBean.setBunwari2(kykDairitenList.get(1).getBunwari());
            }
        }
        else {

            uiBean.setCifcd1(uiBean.getKykKihon().getCifcd());
            uiBean.setDispsyono(uiBean.getSyono());

            List<IT_KykDairiten> kykDairitenList = uiBean.getKykKihon().getKykDairitens();

            List<BzGetAgInfoBean> bzGetAgInfoBean = getDairitenInfo(kykDairitenList.get(0).getDrtencd());

            if (bzGetAgInfoBean.size() > 0) {

                uiBean.setDispoyadrtennm1(bzGetAgInfoBean.get(3).getKanjiDairitenNm());
                uiBean.setDispoyadrtencd1(bzGetAgInfoBean.get(3).getDrtenCd());
            }
        }

        String forwardName = "";

        if (C_DairitenInfoSyoriKbn.ALL.eq(uiBean.getDrteninfosyuuseitaisyou())) {

            forwardName = FORWARDNAME_INPUTCONTENTS;
        }
        else {

            forwardName = FORWARDNAME_CIFCDINPUTCONTENTS;
        }

        return forwardName;
    }

    String pushUpdBL() {

        BizUiBeanBackupUtil.backup(uiBean, inputContentsCopyBean);

        if (C_DairitenInfoSyoriKbn.ALL.eq(uiBean.getDrteninfosyuuseitaisyou())) {
            if (!BizUtil.isBlank(uiBean.getBosyuucd3())) {
                uiBean.setBosyuucd3(uiBean.getBosyuucd3().substring(0, 6));
            }

            if (!BizUtil.isBlank(uiBean.getBosyuucd4())) {
                uiBean.setBosyuucd4(uiBean.getBosyuucd4().substring(0, 6));
            }

            if (!BizUtil.isBlank(uiBean.getDairitenkinyuukikansitencd3())
                && uiBean.getDairitenkinyuukikansitencd3().length() < KhDairitenInfoSyuuseiConstants.SITENCODEKETASU) {

                uiBean.setDairitenkinyuukikansitencd3(Strings.padStart(uiBean.getDairitenkinyuukikansitencd3(),
                    KhDairitenInfoSyuuseiConstants.SITENCODEKETASU, '0'));
            }

            if (!BizUtil.isBlank(uiBean.getDairitenkinyuukikansitencd4())
                && uiBean.getDairitenkinyuukikansitencd4().length() < KhDairitenInfoSyuuseiConstants.SITENCODEKETASU) {

                uiBean.setDairitenkinyuukikansitencd4(Strings.padStart(uiBean.getDairitenkinyuukikansitencd4(),
                    KhDairitenInfoSyuuseiConstants.SITENCODEKETASU, '0'));
            }

            if (uiBean.getCifcd1().equals(uiBean.getCifcd2()) &&
                uiBean.getUktkid1().equals(uiBean.getUktkid2()) &&
                uiBean.getDrtenjimcd1().equals(uiBean.getDrtenjimcd3()) &&
                uiBean.getBosyuunintourokuno1().equals(uiBean.getBosyuunintourokuno3()) &&
                uiBean.getDairitenkinyuukikancd1().equals(uiBean.getDairitenkinyuukikancd3()) &&
                uiBean.getDairitenkinyuukikansitencd1().equals(uiBean.getDairitenkinyuukikansitencd3()) &&
                uiBean.getDairitentoriatukaikouincd1().equals(uiBean.getDairitentoriatukaikouincd3()) &&
                uiBean.getBosyuucd1().equals(uiBean.getBosyuucd3()) &&
                uiBean.getBunwari1().equals(uiBean.getBunwari3()) &&
                uiBean.getDrtenjimcd2().equals(uiBean.getDrtenjimcd4()) &&
                uiBean.getBosyuunintourokuno2().equals(uiBean.getBosyuunintourokuno4()) &&
                uiBean.getDairitenkinyuukikancd2().equals(uiBean.getDairitenkinyuukikancd4()) &&
                uiBean.getDairitenkinyuukikansitencd2().equals(uiBean.getDairitenkinyuukikansitencd4()) &&
                uiBean.getDairitentoriatukaikouincd2().equals(uiBean.getDairitentoriatukaikouincd4()) &&
                uiBean.getBosyuucd2().equals(uiBean.getBosyuucd4())) {
                throw new BizLogicException(MessageId.EIA0044,
                    KhDairitenInfoSyuuseiConstants.DAIRITENJYOUHOU);
            }

            C_UmuKbn drtenbunumu = null;
            if (BizUtil.isBlank(uiBean.getDrtenjimcd4())
                && BizUtil.isBlank(uiBean.getBosyuunintourokuno4())
                && BizUtil.isBlank(uiBean.getDairitenkinyuukikancd4())
                && BizUtil.isBlank(uiBean.getDairitenkinyuukikansitencd4())
                && BizUtil.isBlank(uiBean.getDairitentoriatukaikouincd4())
                && BizUtil.isBlank(uiBean.getBosyuucd4())) {

                drtenbunumu = C_UmuKbn.NONE;
            }
            else {

                drtenbunumu = C_UmuKbn.ARI;
            }

            uiBean.setDrtenbunumu(drtenbunumu);

            if (BizUtil.isBlank(uiBean.getDairitenkinyuukikancd3()) && BizUtil.isBlank(uiBean.getDrtenjimcd3())) {

                throw new BizLogicException(MessageId.EIF1064);
            }

            if (!BizUtil.isBlank(uiBean.getDairitenkinyuukikancd3()) && !BizUtil.isBlank(uiBean.getDrtenjimcd3())) {

                throw new BizLogicException(MessageId.EIF1065);
            }

            if (C_UmuKbn.ARI.eq(drtenbunumu)) {

                if (BizUtil.isBlank(uiBean.getDairitenkinyuukikancd4()) && BizUtil.isBlank(uiBean.getDrtenjimcd4())) {

                    throw new BizLogicException(MessageId.EIF1064);
                }

                if (!BizUtil.isBlank(uiBean.getDairitenkinyuukikancd4()) && !BizUtil.isBlank(uiBean.getDrtenjimcd4())) {

                    throw new BizLogicException(MessageId.EIF1065);
                }
            }
            if (!((BizUtil.isBlank(uiBean.getDrtenjimcd3())
                && BizUtil.isBlank(uiBean.getBosyuunintourokuno3())
                && !BizUtil.isBlank(uiBean.getDairitenkinyuukikancd3())
                && !BizUtil.isBlank(uiBean.getDairitenkinyuukikansitencd3())
                && !BizUtil.isBlank(uiBean.getDairitentoriatukaikouincd3())
                && BizUtil.isBlank(uiBean.getBosyuucd3()))
                || (BizUtil.isBlank(uiBean.getDrtenjimcd3())
                    && BizUtil.isBlank(uiBean.getBosyuunintourokuno3())
                    && !BizUtil.isBlank(uiBean.getDairitenkinyuukikancd3())
                    && !BizUtil.isBlank(uiBean.getDairitenkinyuukikansitencd3())
                    && BizUtil.isBlank(uiBean.getDairitentoriatukaikouincd3())
                    && !BizUtil.isBlank(uiBean.getBosyuucd3()))
                    || (BizUtil.isBlank(uiBean.getDrtenjimcd3())
                        && !BizUtil.isBlank(uiBean.getBosyuunintourokuno3())
                        && !BizUtil.isBlank(uiBean.getDairitenkinyuukikancd3())
                        && !BizUtil.isBlank(uiBean.getDairitenkinyuukikansitencd3())
                        && BizUtil.isBlank(uiBean.getDairitentoriatukaikouincd3())
                        && BizUtil.isBlank(uiBean.getBosyuucd3()))
                        || (!BizUtil.isBlank(uiBean.getDrtenjimcd3())
                            && !BizUtil.isBlank(uiBean.getBosyuunintourokuno3())
                            && BizUtil.isBlank(uiBean.getDairitenkinyuukikancd3())
                            && BizUtil.isBlank(uiBean.getDairitenkinyuukikansitencd3())
                            && BizUtil.isBlank(uiBean.getDairitentoriatukaikouincd3())
                            && BizUtil.isBlank(uiBean.getBosyuucd3()))
                            || (!BizUtil.isBlank(uiBean.getDrtenjimcd3())
                                && BizUtil.isBlank(uiBean.getBosyuunintourokuno3())
                                && BizUtil.isBlank(uiBean.getDairitenkinyuukikancd3())
                                && BizUtil.isBlank(uiBean.getDairitenkinyuukikansitencd3())
                                && BizUtil.isBlank(uiBean.getDairitentoriatukaikouincd3())
                                && !BizUtil.isBlank(uiBean.getBosyuucd3())))) {

                throw new BizLogicException(MessageId.EIF1042);
            }

            if (C_UmuKbn.ARI.eq(drtenbunumu)) {

                if (!((BizUtil.isBlank(uiBean.getDrtenjimcd4())
                    && BizUtil.isBlank(uiBean.getBosyuunintourokuno4())
                    && !BizUtil.isBlank(uiBean.getDairitenkinyuukikancd4())
                    && !BizUtil.isBlank(uiBean.getDairitenkinyuukikansitencd4())
                    && !BizUtil.isBlank(uiBean.getDairitentoriatukaikouincd4())
                    && BizUtil.isBlank(uiBean.getBosyuucd4()))
                    || (BizUtil.isBlank(uiBean.getDrtenjimcd4())
                        && BizUtil.isBlank(uiBean.getBosyuunintourokuno4())
                        && !BizUtil.isBlank(uiBean.getDairitenkinyuukikancd4())
                        && !BizUtil.isBlank(uiBean.getDairitenkinyuukikansitencd4())
                        && BizUtil.isBlank(uiBean.getDairitentoriatukaikouincd4())
                        && !BizUtil.isBlank(uiBean.getBosyuucd4()))
                        || (BizUtil.isBlank(uiBean.getDrtenjimcd4())
                            && !BizUtil.isBlank(uiBean.getBosyuunintourokuno4())
                            && !BizUtil.isBlank(uiBean.getDairitenkinyuukikancd4())
                            && !BizUtil.isBlank(uiBean.getDairitenkinyuukikansitencd4())
                            && BizUtil.isBlank(uiBean.getDairitentoriatukaikouincd4())
                            && BizUtil.isBlank(uiBean.getBosyuucd4()))
                            || (!BizUtil.isBlank(uiBean.getDrtenjimcd4())
                                && !BizUtil.isBlank(uiBean.getBosyuunintourokuno4())
                                && BizUtil.isBlank(uiBean.getDairitenkinyuukikancd4())
                                && BizUtil.isBlank(uiBean.getDairitenkinyuukikansitencd4())
                                && BizUtil.isBlank(uiBean.getDairitentoriatukaikouincd4())
                                && BizUtil.isBlank(uiBean.getBosyuucd4()))
                                || (!BizUtil.isBlank(uiBean.getDrtenjimcd4())
                                    && BizUtil.isBlank(uiBean.getBosyuunintourokuno4())
                                    && BizUtil.isBlank(uiBean.getDairitenkinyuukikancd4())
                                    && BizUtil.isBlank(uiBean.getDairitenkinyuukikansitencd4())
                                    && BizUtil.isBlank(uiBean.getDairitentoriatukaikouincd4())
                                    && !BizUtil.isBlank(uiBean.getBosyuucd4())))) {

                    throw new BizLogicException(MessageId.EIF1042);
                }
            }

            if (C_UmuKbn.NONE.eq(drtenbunumu)) {
                if (!uiBean.getBunwari3().isOptional()
                    && KhDairitenInfoSyuuseiConstants.BUNWAR100.compareTo(uiBean.getBunwari3()) != 0) {

                    throw new BizLogicException(MessageId.EIF1055);
                }
            }
            else {


                if (!uiBean.getBunwari3().isOptional()
                    && uiBean.getBunwari3().compareTo(KhDairitenInfoSyuuseiConstants.BUNWAR100) == 0) {

                    throw new BizLogicException(MessageId.EIF1055);
                }
            }

            if (!BizUtil.isBlank(uiBean.getGyskkjsakisosikicd3())) {
                if (!("2".equals(uiBean.getGyskkjsakisosikicd3().substring(3, 4))
                    && ("936".equals(uiBean.getGyskkjsakisosikicd3().substring(4))
                        || ("939".equals(uiBean.getGyskkjsakisosikicd3().substring(4)))
                        || ("981".equals(uiBean.getGyskkjsakisosikicd3().substring(4)))
                        || ("982".equals(uiBean.getGyskkjsakisosikicd3().substring(4)))
                        || ("983".equals(uiBean.getGyskkjsakisosikicd3().substring(4)))
                        || "984".equals(uiBean.getGyskkjsakisosikicd3().substring(4))))) {

                    throw new BizLogicException(MessageId.EBA1031, KhDairitenInfoSyuuseiConstants.GYSKKJSAKISOSIKICD);
                }
            }

            if (!BizUtil.isBlank(uiBean.getGyskkjsakisosikicd4())) {
                if (!("2".equals(uiBean.getGyskkjsakisosikicd4().substring(3, 4))
                    && ("936".equals(uiBean.getGyskkjsakisosikicd4().substring(4))
                        || "939".equals(uiBean.getGyskkjsakisosikicd4().substring(4))
                        || "981".equals(uiBean.getGyskkjsakisosikicd4().substring(4))
                        || "982".equals(uiBean.getGyskkjsakisosikicd4().substring(4))
                        || "983".equals(uiBean.getGyskkjsakisosikicd4().substring(4))
                        || "984".equals(uiBean.getGyskkjsakisosikicd4().substring(4))))) {

                    throw new BizLogicException(MessageId.EBA1031, KhDairitenInfoSyuuseiConstants.GYSKKJSAKISOSIKICD);
                }
            }

            if (C_UmuKbn.ARI.eq(drtenbunumu)) {

                if (!BizUtil.isBlank(uiBean.getDairitenkinyuukikancd3())
                    && !BizUtil.isBlank(uiBean.getDairitenkinyuukikancd4())) {

                    if (!BizUtil.isBlank(uiBean.getBosyuunintourokuno3())
                        && !BizUtil.isBlank(uiBean.getBosyuunintourokuno4())) {

                        if (uiBean.getDairitenkinyuukikancd3().equals(uiBean.getDairitenkinyuukikancd4())
                            && uiBean.getDairitenkinyuukikansitencd3().equals(uiBean.getDairitenkinyuukikansitencd4())
                            && uiBean.getBosyuunintourokuno3().equals(uiBean.getBosyuunintourokuno4())) {

                            throw new BizLogicException(MessageId.EIF1022);
                        }
                    }

                    if (!BizUtil.isBlank(uiBean.getBosyuucd3()) && !BizUtil.isBlank(uiBean.getBosyuucd4())) {

                        if (uiBean.getDairitenkinyuukikancd3().equals(uiBean.getDairitenkinyuukikancd4())
                            && uiBean.getDairitenkinyuukikansitencd3().equals(uiBean.getDairitenkinyuukikansitencd4())
                            && uiBean.getBosyuucd3().equals(uiBean.getBosyuucd4())) {

                            throw new BizLogicException(MessageId.EIF1020);
                        }
                    }

                    if (!BizUtil.isBlank(uiBean.getDairitentoriatukaikouincd3())
                        && !BizUtil.isBlank(uiBean.getDairitentoriatukaikouincd4())) {

                        if (uiBean.getDairitenkinyuukikancd3().equals(uiBean.getDairitenkinyuukikancd4())
                            && uiBean.getDairitenkinyuukikansitencd3().equals(uiBean.getDairitenkinyuukikansitencd4())
                            && uiBean.getDairitentoriatukaikouincd3().equals(uiBean.getDairitentoriatukaikouincd4())) {

                            throw new BizLogicException(MessageId.EIF1021);
                        }
                    }

                }

                if (!BizUtil.isBlank(uiBean.getDrtenjimcd3())
                    && !BizUtil.isBlank(uiBean.getDrtenjimcd4())) {

                    if (!BizUtil.isBlank(uiBean.getBosyuunintourokuno3())
                        && !BizUtil.isBlank(uiBean.getBosyuunintourokuno4())) {

                        if (uiBean.getDrtenjimcd3().equals(uiBean.getDrtenjimcd4())
                            && uiBean.getBosyuunintourokuno3().equals(uiBean.getBosyuunintourokuno4())) {

                            throw new BizLogicException(MessageId.EIF1026);
                        }
                    }
                    if (!BizUtil.isBlank(uiBean.getBosyuucd3())
                        && !BizUtil.isBlank(uiBean.getBosyuucd4())) {

                        if (uiBean.getDrtenjimcd3().equals(uiBean.getDrtenjimcd4())
                            && uiBean.getBosyuucd3().equals(uiBean.getBosyuucd4())) {

                            throw new BizLogicException(MessageId.EIF1011);
                        }
                    }
                }

                if (!BizUtil.isBlank(uiBean.getGyskkjsakisosikicd3())
                    && !BizUtil.isBlank(uiBean.getGyskkjsakisosikicd4())) {

                    if (uiBean.getGyskkjsakisosikicd3().equals(uiBean.getGyskkjsakisosikicd4())) {

                        throw new BizLogicException(MessageId.EIF1063);
                    }
                }
            }

            if (!BizUtil.isBlank(uiBean.getDairitenkinyuukikancd3())) {

                chkBsInfoBsYuukou(
                    uiBean.getBosyuunintourokuno3(),
                    uiBean.getBosyuucd3(),
                    uiBean.getDairitentoriatukaikouincd3(),
                    uiBean.getDairitenkinyuukikancd3(),
                    true,
                    KhDairitenInfoSyuuseiConstants.DAIRITEN_A);

                chkDairitenInfo(
                    true,
                    KhDairitenInfoSyuuseiConstants.DAIRITEN_A,
                    uiBean.getKodrtencdA());

                if (!uiBean.getOyadrtencdA().equals(uiBean.getBosyuuOyadrtCd())) {

                    throw new BizLogicException(MessageId.EIF1060,
                        uiBean.getDairitenkinyuukikancd3(),
                        uiBean.getDairitenkinyuukikansitencd3());
                }

                chkAgYuukou(uiBean.getDrtencdA());
            }

            if (!BizUtil.isBlank(uiBean.getDrtenjimcd3())) {

                chkBsInfoBsYuukou(
                    uiBean.getBosyuunintourokuno3(),
                    uiBean.getBosyuucd3(),
                    uiBean.getDairitentoriatukaikouincd3(),
                    uiBean.getDairitenkinyuukikancd3(),
                    false,
                    KhDairitenInfoSyuuseiConstants.DAIRITEN_A);

                chkDairitenInfo(
                    false,
                    KhDairitenInfoSyuuseiConstants.DAIRITEN_A,
                    uiBean.getKodrtencdA());

                chkAgYuukou(uiBean.getDrtencdA());
            }

            if (C_UmuKbn.ARI.eq(drtenbunumu)) {
                if (!BizUtil.isBlank(uiBean.getDairitenkinyuukikancd4())) {

                    chkBsInfoBsYuukou(
                        uiBean.getBosyuunintourokuno4(),
                        uiBean.getBosyuucd4(),
                        uiBean.getDairitentoriatukaikouincd4(),
                        uiBean.getDairitenkinyuukikancd4(),
                        true,
                        KhDairitenInfoSyuuseiConstants.DAIRITEN_B);

                    chkDairitenInfo(
                        true,
                        KhDairitenInfoSyuuseiConstants.DAIRITEN_B,
                        uiBean.getKodrtencdB());

                    if (!uiBean.getOyadrtencdB().equals(uiBean.getBosyuuOyadrtCd())) {

                        throw new BizLogicException(MessageId.EIF1060,
                            uiBean.getDairitenkinyuukikancd4(),
                            uiBean.getDairitenkinyuukikansitencd4());
                    }

                    chkAgYuukou(uiBean.getDrtencdB());
                }
            }

            if (C_UmuKbn.ARI.eq(drtenbunumu)) {
                if (!BizUtil.isBlank(uiBean.getDrtenjimcd4())) {

                    chkBsInfoBsYuukou(
                        uiBean.getBosyuunintourokuno4(),
                        uiBean.getBosyuucd4(),
                        uiBean.getDairitentoriatukaikouincd4(),
                        uiBean.getDairitenkinyuukikancd4(),
                        false,
                        KhDairitenInfoSyuuseiConstants.DAIRITEN_B);

                    chkDairitenInfo(
                        false,
                        KhDairitenInfoSyuuseiConstants.DAIRITEN_B,
                        uiBean.getKodrtencdB());

                    chkAgYuukou(uiBean.getDrtencdB());
                }
            }

            if (C_UmuKbn.ARI.eq(drtenbunumu)) {

                if (uiBean.getBosyuucdA().equals(uiBean.getBosyuucdB())) {

                    throw new BizLogicException(MessageId.EIF1062, uiBean.getBosyuucdA());
                }
            }

            if (!YuyuBizConfig.getInstance().getSmbcOyadrtencd().equals(uiBean.getOyadrtencdA())) {

                if (!BizUtil.isBlank(uiBean.getUktkid2())) {

                    throw new BizLogicException(MessageId.EBC0012, KhDairitenInfoSyuuseiConstants.UKETUKEKANRIID);
                }
            }
            else {

                if (BizUtil.isBlank(uiBean.getUktkid2())) {

                    throw new BizLogicException(MessageId.EBC0045, KhDairitenInfoSyuuseiConstants.UKETUKEKANRIID);
                }

                String uktKId6 = uiBean.getUktkid2().substring(0, 6);
                String taikeiChkStr = "20" + uktKId6;

                try {
                    Integer.parseInt(uktKId6);
                } catch (Exception eExp) {
                    throw new BizLogicException(MessageId.EBC0046, KhDairitenInfoSyuuseiConstants.UKETUKEKANRIID);
                }

                if (!BizDate.valueOf(taikeiChkStr).isRekijyou()) {
                    throw new BizLogicException(MessageId.EBC0046, KhDairitenInfoSyuuseiConstants.UKETUKEKANRIID);
                }
            }


            GetDairitenKobetuJyouhou getDairitenKobetuJyouhou = SWAKInjector.getInstance(GetDairitenKobetuJyouhou.class);

            GetDairitenKobetuJyouhouBean dairitenKobetuJyouhouBean = getDairitenKobetuJyouhou.exec(
                uiBean.getOyadrtencdA(),
                uiBean.getKykKihon().getMosuketukekbn()
                );

            if (C_ErrorKbn.OK.eq(dairitenKobetuJyouhouBean.getErrorKbn())) {

                if (C_YouhiKbn.YOU.eq(dairitenKobetuJyouhouBean.getCifCdCheckYouhi())) {

                    if (BizUtil.isBlank(uiBean.getCifcd2())) {
                        throw new BizLogicException(MessageId.EBC0045, KhDairitenInfoSyuuseiConstants.CIFCODE);
                    }

                    if (C_YouhiblnkKbn.YOU.eq(dairitenKobetuJyouhouBean.getCifCdMaezeroumeYouhi())) {
                        uiBean.setCifcd2(Strings.padStart(uiBean.getCifcd2(),
                            dairitenKobetuJyouhouBean.getCifCdSiteiKetasuu(), '0'));
                    }

                    if (uiBean.getCifcd2().length() != dairitenKobetuJyouhouBean.getCifCdSiteiKetasuu()) {
                        throw new BizLogicException(MessageId.EBC0046, KhDairitenInfoSyuuseiConstants.CIFCODE);

                    }
                }
            }

            IT_KykSyouhn itKykSyouhn = uiBean.getKykKihon().getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

            BM_SyouhnZokusei bmSyouhnZokusei = itKykSyouhn.getSyouhnZokusei();

            C_UmuKbn hengakuumu = bmSyouhnZokusei.getHengakuumu();

            if (C_UmuKbn.ARI.eq(drtenbunumu)) {

                if (uiBean.getBunwari3().isOptional()) {

                    uiBean.setBunwari3(BizNumber.ZERO);
                    uiBean.setBunwari4(BizNumber.ZERO);
                }
                else {

                    uiBean.setBunwari4(KhDairitenInfoSyuuseiConstants.BUNWAR100.subtract((uiBean.getBunwari3())));
                }
            }
            else {

                if (uiBean.getBunwari3().isOptional()) {

                    uiBean.setBunwari3(KhDairitenInfoSyuuseiConstants.BUNWAR100);
                }
            }

            String gyskkjsakisosikinmkj3 = "";
            String gyskkjsakisosikinmkj4 = "";

            if (!BizUtil.isBlank(uiBean.getGyskkjsakisosikicd3())) {

                BzGetSosikiDataBean bzGetSosikiDataBean = getSosik(
                    uiBean.getGyskkjsakisosikicd3(),
                    BizDate.getSysDate());

                if (!C_SosikiYuuksHantKbn.OK.eq(bzGetSosikiDataBean.getSosikiyuukshantkbn())) {

                    throw new BizLogicException(MessageId.EBA0030, KhDairitenInfoSyuuseiConstants.GYSKKJSAKISOSIKICD);
                }

                gyskkjsakisosikinmkj3 = bzGetSosikiDataBean.getKanjisosikinm20();
            }

            if (!BizUtil.isBlank(uiBean.getGyskkjsakisosikicd4())) {

                BzGetSosikiDataBean bzGetSosikiDataBean = getSosik(
                    uiBean.getGyskkjsakisosikicd4(),
                    BizDate.getSysDate());

                if (!C_SosikiYuuksHantKbn.OK.eq(bzGetSosikiDataBean.getSosikiyuukshantkbn())) {

                    throw new BizLogicException(MessageId.EBA0030, KhDairitenInfoSyuuseiConstants.GYSKKJSAKISOSIKICD);
                }

                gyskkjsakisosikinmkj4 = bzGetSosikiDataBean.getKanjisosikinm20();
            }

            BzChkBsYuukouHengaku bzChkBsYuukouHengaku = SWAKInjector.getInstance(BzChkBsYuukouHengaku.class);

            if (!BizUtil.isBlank(uiBean.getBosyuucdA())) {

                if (C_UmuKbn.ARI.eq(hengakuumu)) {

                    boolean yuukouhanteikekka = bzChkBsYuukouHengaku.exec(
                        uiBean.getBosyuucdA(),
                        BizDate.getSysDate());

                    if (!yuukouhanteikekka) {

                        messageManagerLst.add(MessageUtil.getMessage(MessageId.WIF1011, uiBean.getBosyuucdA()));
                    }
                }
            }

            if (C_UmuKbn.ARI.eq(drtenbunumu)) {

                if (!BizUtil.isBlank(uiBean.getBosyuucdB())) {

                    if (C_UmuKbn.ARI.eq(hengakuumu)) {

                        boolean yuukouhanteikekka = bzChkBsYuukouHengaku.exec(
                            uiBean.getBosyuucdB(),
                            BizDate.getSysDate());

                        if (!yuukouhanteikekka) {

                            messageManagerLst.add(MessageUtil.getMessage(MessageId.WIF1011, uiBean.getBosyuucdB()));
                        }
                    }
                }
            }

            for (String warningMessage : messageManagerLst) {

                messageManager.addConversationMessageId(KhDairitenInfoSyuuseiConstants.NAIYOUNYUURYOK_GROUP_MESSAGE,
                    MessageId.WBC0001, warningMessage);
            }
            uiBean.setToriatukaidairitencd3(uiBean.getDrtencdA());
            uiBean.setKanjitoriatukaidairitennm3(uiBean.getKodrtennmA());
            uiBean.setOyadairitencd3(uiBean.getOyadrtencdA());
            uiBean.setKanjioyadrtennm3(uiBean.getOyadrtennmA());
            uiBean.setBosyuucd3(uiBean.getBosyuucdA());
            uiBean.setBosyuuninnm3(uiBean.getBosyuunmA());
            uiBean.setGyskkjsakisosikinmkj3(gyskkjsakisosikinmkj3);
            uiBean.setToriatukaidairitencd4(uiBean.getDrtencdB());
            uiBean.setKanjitoriatukaidairitennm4(uiBean.getKodrtennmB());
            uiBean.setOyadairitencd4(uiBean.getOyadrtencdB());
            uiBean.setKanjioyadrtennm4(uiBean.getOyadrtennmB());
            uiBean.setBosyuucd4(uiBean.getBosyuucdB());
            uiBean.setBosyuuninnm4(uiBean.getBosyuunmB());
            uiBean.setGyskkjsakisosikinmkj4(gyskkjsakisosikinmkj4);
        }
        else {

            if (uiBean.getCifcd1().equals(uiBean.getCifcd2())) {

                throw new BizLogicException(MessageId.EIA0044,
                    KhDairitenInfoSyuuseiConstants.DAIRITENJYOUHOU);
            }

            GetDairitenKobetuJyouhou getDairitenKobetuJyouhou = SWAKInjector.getInstance(GetDairitenKobetuJyouhou.class);

            GetDairitenKobetuJyouhouBean dairitenKobetuJyouhouBean = getDairitenKobetuJyouhou.exec(
                uiBean.getDispoyadrtencd1(), uiBean.getKykKihon().getMosuketukekbn());

            if (C_ErrorKbn.OK.eq(dairitenKobetuJyouhouBean.getErrorKbn())) {

                if (C_YouhiKbn.YOU.eq(dairitenKobetuJyouhouBean.getCifCdCheckYouhi())) {

                    if (BizUtil.isBlank(uiBean.getCifcd2())) {
                        throw new BizLogicException(MessageId.EBC0045, KhDairitenInfoSyuuseiConstants.CIFCODE);
                    }

                    if (C_YouhiblnkKbn.YOU.eq(dairitenKobetuJyouhouBean.getCifCdMaezeroumeYouhi())) {
                        uiBean.setCifcd2(Strings.padStart(uiBean.getCifcd2(),
                            dairitenKobetuJyouhouBean.getCifCdSiteiKetasuu(), '0'));
                    }

                    if (uiBean.getCifcd2().length() != dairitenKobetuJyouhouBean.getCifCdSiteiKetasuu()) {
                        throw new BizLogicException(MessageId.EBC0046, KhDairitenInfoSyuuseiConstants.CIFCODE);

                    }
                }
            }
        }

        messageManager.addMessageId(MessageId.QBA0001);

        String forwardName = "";

        if (C_DairitenInfoSyoriKbn.ALL.eq(uiBean.getDrteninfosyuuseitaisyou())) {

            forwardName = FORWARDNAME_CONFIRM;
        }
        else {

            forwardName = FORWARDNAME_CIFCDCONFIRM;
        }

        return forwardName;

    }

    String pushmodoruBL() {

        BizUiBeanBackupUtil.restore(uiBean, inputContentsCopyBean);

        messageManager.removeConversationMessage(KhDairitenInfoSyuuseiConstants.NAIYOUNYUURYOK_GROUP_MESSAGE);

        String forwardName = "";

        if (C_DairitenInfoSyoriKbn.ALL.eq(uiBean.getDrteninfosyuuseitaisyou())) {

            forwardName = FORWARDNAME_INPUTCONTENTS;
        }
        else {

            forwardName = FORWARDNAME_CIFCDINPUTCONTENTS;
        }

        return forwardName;
    }

    @Transactional
    String pushKakuteiBL() {

        TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);

        String henkousikibetukeyrenno = khozenCommonParam.getSikibetuKey(uiBean.getSyono());

        tableMaintenanceUtil.backUp(uiBean.getSyono(), henkousikibetukeyrenno);

        BizDate sysDate = BizDate.getSysDate();
        String sysTime = BizDate.getSysDateTimeMilli();
        String kinouID = kinou.getKinouId();
        String userID = baseUserInfo.getUserId();

        if (C_DairitenInfoSyoriKbn.ALL.eq(uiBean.getDrteninfosyuuseitaisyou())) {
            BzGetSosikiDataBean bzGetSosikiDataBean = SWAKInjector.getInstance(BzGetSosikiDataBean.class);
            String sosikicd = "";
            if (BizUtil.isBlank(uiBean.getGyskkjsakisosikicd3())) {

                sosikicd = uiBean.getDairitenkanrisosikicdA();
            }
            else {

                sosikicd = uiBean.getGyskkjsakisosikicd3();
            }

            sosikicd = sosikicd.substring(0, 3) + "0000";
            bzGetSosikiDataBean = getSosikData(sosikicd);

            String sosikikihontikucd = bzGetSosikiDataBean.getSosikikihontikucd();

            String todouhukencd = "";

            if (!BizUtil.isBlank(sosikikihontikucd)) {

                todouhukencd = getAdrData(sosikikihontikucd.substring(0, 7));
            }
            else {
                todouhukencd = "0";
            }

            uiBean.getKykKihon().setDrtenkanritodoufukencd(todouhukencd);
            uiBean.getKykKihon().setCifcd(uiBean.getCifcd2());
            uiBean.getKykKihon().setSmbckanriid(uiBean.getUktkid2());
            uiBean.getKykKihon().setSyhenkouymd(sysDate);
            uiBean.getKykKihon().setGyoumuKousinKinou(kinouID);
            uiBean.getKykKihon().setGyoumuKousinsyaId(userID);
            uiBean.getKykKihon().setGyoumuKousinTime(sysTime);

            IT_KhTtdkRireki khTtdkRireki = uiBean.getKykKihon().createKhTtdkRireki();
            khTtdkRireki.setHenkousikibetukey(henkousikibetukeyrenno);
            BizPropertyInitializer.initialize(khTtdkRireki);

            uiBean.getKykKihon().getKykDairitens().clear();
            hozenDomManager.flush();
            IT_KykDairiten kykDairitenA = uiBean.getKykKihon().createKykDairiten();
            kykDairitenA.setDrtenrenno(1);
            kykDairitenA.setDrtencd(uiBean.getToriatukaidairitencd3());
            kykDairitenA.setDrtenkanrisosikicd(uiBean.getDairitenkanrisosikicdA());
            kykDairitenA.setGyousekikeijyousakisosikicd(uiBean.getGyskkjsakisosikicd3());
            kykDairitenA.setOyadrtencd(uiBean.getOyadairitencd3());
            kykDairitenA.setBosyuucd(uiBean.getBosyuucdA());
            kykDairitenA.setDaibosyuucd(uiBean.getDaibosyuucdA());
            kykDairitenA.setDrtenbunumu(uiBean.getDrtenbunumu());
            kykDairitenA.setBunwari(uiBean.getBunwari3());
            kykDairitenA.setBsyujoyadrtencd(uiBean.getOyadairitencd3());
            kykDairitenA.setBsyujdrtencd(uiBean.getToriatukaidairitencd3());
            kykDairitenA.setGyoumuKousinKinou(kinouID);
            kykDairitenA.setGyoumuKousinsyaId(userID);
            kykDairitenA.setGyoumuKousinTime(sysTime);

            BizPropertyInitializer.initialize(kykDairitenA);

            if (C_UmuKbn.ARI.eq(uiBean.getDrtenbunumu())) {
                IT_KykDairiten kykDairitenB = uiBean.getKykKihon().createKykDairiten();

                kykDairitenB.setDrtenrenno(2);
                kykDairitenB.setDrtencd(uiBean.getToriatukaidairitencd4());
                kykDairitenB.setDrtenkanrisosikicd(uiBean.getDairitenkanrisosikicdB());
                kykDairitenB.setGyousekikeijyousakisosikicd(uiBean.getGyskkjsakisosikicd4());
                kykDairitenB.setOyadrtencd(uiBean.getOyadairitencd4());
                kykDairitenB.setBosyuucd(uiBean.getBosyuucdB());
                kykDairitenB.setDaibosyuucd(uiBean.getDaibosyuucdB());
                kykDairitenB.setDrtenbunumu(uiBean.getDrtenbunumu());
                kykDairitenB.setBunwari(uiBean.getBunwari4());
                kykDairitenB.setBsyujoyadrtencd(uiBean.getOyadairitencd4());
                kykDairitenB.setBsyujdrtencd(uiBean.getToriatukaidairitencd4());
                kykDairitenB.setGyoumuKousinKinou(kinouID);
                kykDairitenB.setGyoumuKousinsyaId(userID);
                kykDairitenB.setGyoumuKousinTime(sysTime);

                BizPropertyInitializer.initialize(kykDairitenB);

            }

            PALKykNaiyouKousin palKykNaiyouKousin = SWAKInjector.getInstance(PALKykNaiyouKousin.class);
            palKykNaiyouKousin.exec(uiBean.getKykKihon());
            EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);
            EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);
            editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
            editTtdkRirekiTblParam.setSyoNo(uiBean.getSyono());
            editTtdkRirekiTblParam.setSyoriYmd(sysDate);
            editTtdkRirekiTblParam.setSysTime(sysTime);
            editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
            editTtdkRirekiTblParam.setSmbcKanriId(uiBean.getUktkid2());
            editTtdkRirekiTblParam.setYoukyuuNo(palKykNaiyouKousin.getYoukyuuno());

            editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);

            hozenDomManager.update(uiBean.getKykKihon());
        }
        else {

            uiBean.getKykKihon().setCifcd(uiBean.getCifcd2());
            uiBean.getKykKihon().setSyhenkouymd(sysDate);
            uiBean.getKykKihon().setGyoumuKousinKinou(kinouID);
            uiBean.getKykKihon().setGyoumuKousinsyaId(userID);
            uiBean.getKykKihon().setGyoumuKousinTime(sysTime);

            IT_KhTtdkRireki khTtdkRireki = uiBean.getKykKihon().createKhTtdkRireki();
            khTtdkRireki.setHenkousikibetukey(henkousikibetukeyrenno);
            BizPropertyInitializer.initialize(khTtdkRireki);

            EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);
            EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);
            editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
            editTtdkRirekiTblParam.setSyoNo(uiBean.getSyono());
            editTtdkRirekiTblParam.setSyoriYmd(sysDate);
            editTtdkRirekiTblParam.setSysTime(sysTime);
            editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);

            editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);

            hozenDomManager.update(uiBean.getKykKihon());
        }

        messageManager.addMessageId(MessageId.IAC0009);

        String forwardName = "";

        if (C_DairitenInfoSyoriKbn.ALL.eq(uiBean.getDrteninfosyuuseitaisyou())) {

            forwardName = FORWARDNAME_RESULT;
        }
        else {

            forwardName = FORWARDNAME_CIFCDRESULT;
        }

        return forwardName;
    }

    private void isExist() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(uiBean.getSyono());

        if (kykKihon == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }
        uiBean.setKykKihon(kykKihon);
    }

    private void chkJyoutai() {
        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam, uiBean);

        if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {
            throw new BizLogicException(MessageId.EIA0035, checkYuukouJyoutai.getErrorMessage());
        }
        if (C_YuukoujyotaichkKbn.TYUUITRATKIKA.eq(yuukoujyotaichkKbn)) {
            addConversationMessageId(checkYuukouJyoutai.getWarningMessageIDList(),
                checkYuukouJyoutai.getWarningMessageList());
        }
    }

    private List<BzGetAgInfoBean> getDairitenInfo(String dairitencode) {

        BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

        List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(dairitencode);

        return bzGetAgInfoBeanList;
    }

    private List<BzGetAgInfoBean> getDairitenInfoKinyuuKikan(String daititenkinyuukikancd, String daititenkinyuukikansitencd) {

        BzGetAgInfoKinyuuKikan bzGetAgInfoKinyuuKikan = SWAKInjector.getInstance(BzGetAgInfoKinyuuKikan.class);

        List<BzGetAgInfoBean> bzGetAgInfoKinyuuKikanBeanList = bzGetAgInfoKinyuuKikan.exec(daititenkinyuukikancd, daititenkinyuukikansitencd);

        return bzGetAgInfoKinyuuKikanBeanList;
    }

    private List<BzGetAgInfoBean> getDairitenInfoJimusyo(String oyadairitencode, String drtenjimcd) {

        BzGetAgInfoJimusyo bzGetAgInfoJimusyo = SWAKInjector.getInstance(BzGetAgInfoJimusyo.class);

        List<BzGetAgInfoBean> bzGetAgInfoJimusyoBeanList = bzGetAgInfoJimusyo.exec(oyadairitencode, drtenjimcd);

        return bzGetAgInfoJimusyoBeanList;
    }

    private BzGetBsInfoBean getBsInfo(String bosyuucd) {
        BzGetBsInfo bzGetBsInfo = SWAKInjector.getInstance(BzGetBsInfo.class);

        BzGetBsInfoBean bzGetBsInfoBean = bzGetBsInfo.exec(bosyuucd);

        return bzGetBsInfoBean;

    }

    void addConversationMessageId(List<String> warningMessageIDList,
        List<String> warningMessageList) {
        if (warningMessageIDList.size() != 0) {
            for (int i = 0; i < warningMessageIDList.size(); i++) {
                String messageID = BizUtil.getGeneralMessageId(warningMessageIDList.get(i));
                messageManager.addConversationMessageId(KhDairitenInfoSyuuseiConstants.KEY_GROUP_MESSAGE,
                    messageID,
                    warningMessageList.get(i));
            }
        }

    }

    private BzGetSosikiDataBean getSosikData(String pSosikicd) {

        BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(pSosikicd);

        return bzGetSosikiDataBean;

    }

    private BzGetSosikiDataBean getSosik(String pSosikicd, BizDate pKijyunymd) {

        BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(pSosikicd, pKijyunymd);

        return bzGetSosikiDataBean;

    }

    private String getAdrData(String pPostalCd) {

        BzGetAdrData bzGetAdrData = SWAKInjector.getInstance(BzGetAdrData.class);

        bzGetAdrData.execTodouhukenCdByPostalcd(pPostalCd);

        String todouhukencd = bzGetAdrData.getTodouhukenCd().getValue();

        return todouhukencd;

    }

    private void chkBsInfoBsYuukou(String pBosyuunintourokuno,
        String pBosyuucd,
        String pKouincd,
        String pDairitenkinyuukikancd,
        boolean pSyoriflg,
        String pDairitenABkbn) {

        BzChkBsYuukou bzChkBsYuukou = SWAKInjector.getInstance(BzChkBsYuukou.class);

        if (!BizUtil.isBlank(pBosyuunintourokuno)) {

            BzGetBsInfoBstrkno bzGetBsInfoBstrkno = SWAKInjector.getInstance(BzGetBsInfoBstrkno.class);

            BzGetBsInfoBean bzGetBsInfoBean = bzGetBsInfoBstrkno.exec(pBosyuunintourokuno);

            if (bzGetBsInfoBean == null) {

                throw new BizLogicException(MessageId.EIF1049, pBosyuunintourokuno);
            }

            boolean yuukouhanteikekka = bzChkBsYuukou.exec(
                bzGetBsInfoBean.getBosyuuCd(),
                BizDate.getSysDate());

            if (!yuukouhanteikekka) {

                messageManagerLst.add(MessageUtil.getMessage(MessageId.WIF1006, pBosyuunintourokuno));
            }

            if (KhDairitenInfoSyuuseiConstants.DAIRITEN_A.equals(pDairitenABkbn)) {

                uiBean.setBosyuucdA(bzGetBsInfoBean.getBosyuuCd());
                uiBean.setKodrtencdA(bzGetBsInfoBean.getDairiten1Cd());
                uiBean.setBosyuunmA(bzGetBsInfoBean.getKanjiBosyuuninNm());
            }
            else {

                uiBean.setBosyuucdB(bzGetBsInfoBean.getBosyuuCd());
                uiBean.setKodrtencdB(bzGetBsInfoBean.getDairiten1Cd());
                uiBean.setBosyuunmB(bzGetBsInfoBean.getKanjiBosyuuninNm());
            }
        }

        if (!BizUtil.isBlank(pBosyuucd)) {

            BzGetBsInfoBean bzGetBsInfoBean = getBsInfo(pBosyuucd);

            if (bzGetBsInfoBean == null) {

                throw new BizLogicException(MessageId.EIF1052, pBosyuucd);
            }

            boolean yuukouhanteikekka = bzChkBsYuukou.exec(
                pBosyuucd,
                BizDate.getSysDate());

            if (!yuukouhanteikekka) {

                messageManagerLst.add(MessageUtil.getMessage(MessageId.WIF1009, pBosyuucd));

            }

            if (KhDairitenInfoSyuuseiConstants.DAIRITEN_A.equals(pDairitenABkbn)) {

                uiBean.setBosyuucdA(pBosyuucd);
                uiBean.setKodrtencdA(bzGetBsInfoBean.getDairiten1Cd());
                uiBean.setBosyuunmA(bzGetBsInfoBean.getKanjiBosyuuninNm());

            }
            else {

                uiBean.setBosyuucdB(pBosyuucd);
                uiBean.setKodrtencdB(bzGetBsInfoBean.getDairiten1Cd());
                uiBean.setBosyuunmB(bzGetBsInfoBean.getKanjiBosyuuninNm());

            }
        }

        if (pSyoriflg) {

            if (!BizUtil.isBlank(pKouincd)) {

                BzGetBsInfoKouin bzGetBsInfoKouin = SWAKInjector.getInstance(BzGetBsInfoKouin.class);

                BzGetBsInfoBean bzGetBsInfoBean = bzGetBsInfoKouin.exec(
                    pDairitenkinyuukikancd,
                    pKouincd);

                if (bzGetBsInfoBean == null) {

                    throw new BizLogicException(MessageId.EIF1051, pKouincd);
                }

                boolean yuukouhanteikekka = bzChkBsYuukou.exec(
                    bzGetBsInfoBean.getBosyuuCd(),
                    BizDate.getSysDate());

                if (!yuukouhanteikekka) {

                    messageManagerLst.add(MessageUtil.getMessage(MessageId.WIF1008, pKouincd));

                }

                if (KhDairitenInfoSyuuseiConstants.DAIRITEN_A.equals(pDairitenABkbn)) {

                    uiBean.setBosyuucdA(bzGetBsInfoBean.getBosyuuCd());
                    uiBean.setKodrtencdA(bzGetBsInfoBean.getDairiten1Cd());
                    uiBean.setBosyuunmA(bzGetBsInfoBean.getKanjiBosyuuninNm());

                }
                else {

                    uiBean.setBosyuucdB(bzGetBsInfoBean.getBosyuuCd());
                    uiBean.setKodrtencdB(bzGetBsInfoBean.getDairiten1Cd());
                    uiBean.setBosyuunmB(bzGetBsInfoBean.getKanjiBosyuuninNm());

                }
            }
        }
    }

    private void chkDairitenInfo(boolean pSyoriflg, String pDairitenABkbn, String pKodrtencd) {

        String tratkidrtCd = "";
        String tratkidrtNm = "";
        String oyadrtCd = "";
        String oyadrtNm = "";
        String bosyuuOyadrtCd = "";
        String kinyuukikancd = "";
        String kikansitencd = "";
        String jimcd = "";
        String drtkanrisosikicd = "";
        String daibosyuucd = "";

        List<BzGetAgInfoBean> bzGetAgInfoBeanList = getDairitenInfo(pKodrtencd);

        if (bzGetAgInfoBeanList == null || bzGetAgInfoBeanList.size() == 0) {
            throw new BizLogicException(MessageId.EIF1053, pKodrtencd);
        }
        bosyuuOyadrtCd = bzGetAgInfoBeanList.get(3).getDrtenCd();

        if (KhDairitenInfoSyuuseiConstants.DAIRITEN_A.equals(pDairitenABkbn)) {
            kinyuukikancd = uiBean.getDairitenkinyuukikancd3();
            kikansitencd = uiBean.getDairitenkinyuukikansitencd3();
            jimcd = uiBean.getDrtenjimcd3();
        } else {
            kinyuukikancd = uiBean.getDairitenkinyuukikancd4();
            kikansitencd = uiBean.getDairitenkinyuukikansitencd4();
            jimcd = uiBean.getDrtenjimcd4();
        }

        if (pSyoriflg) {
            List<BzGetAgInfoBean> bzGetAgInfoKinyuuKikanList = getDairitenInfoKinyuuKikan(kinyuukikancd, kikansitencd);

            if (bzGetAgInfoKinyuuKikanList == null || bzGetAgInfoKinyuuKikanList.size() == 0) {
                throw new BizLogicException(MessageId.EIF1050, kinyuukikancd, kikansitencd);

            }
            tratkidrtCd = bzGetAgInfoKinyuuKikanList.get(2).getDrtenCd();

            tratkidrtNm = bzGetAgInfoKinyuuKikanList.get(2).getKanjiDairitenNm();

            oyadrtCd = bzGetAgInfoKinyuuKikanList.get(3).getDrtenCd();

            oyadrtNm = bzGetAgInfoKinyuuKikanList.get(3).getKanjiDairitenNm();

            drtkanrisosikicd = bzGetAgInfoKinyuuKikanList.get(2).getDrtKanrisosikiCd1();

            daibosyuucd = bzGetAgInfoKinyuuKikanList.get(2).getDaiBosyuuCd();

        }
        else {
            List<BzGetAgInfoBean> bzGetAgInfoJimusyoList = getDairitenInfoJimusyo(bosyuuOyadrtCd, jimcd);

            if (bzGetAgInfoJimusyoList == null || bzGetAgInfoJimusyoList.size() == 0) {
                throw new BizLogicException(MessageId.EIF1061, jimcd);
            }

            tratkidrtCd = bzGetAgInfoJimusyoList.get(2).getDrtenCd();

            tratkidrtNm = bzGetAgInfoJimusyoList.get(2).getKanjiDairitenNm();

            oyadrtCd = bzGetAgInfoJimusyoList.get(3).getDrtenCd();

            oyadrtNm = bzGetAgInfoJimusyoList.get(3).getKanjiDairitenNm();

            drtkanrisosikicd = bzGetAgInfoJimusyoList.get(2).getDrtKanrisosikiCd1();

            daibosyuucd = bzGetAgInfoJimusyoList.get(2).getDaiBosyuuCd();

        }

        if (KhDairitenInfoSyuuseiConstants.DAIRITEN_A.equals(pDairitenABkbn)) {

            uiBean.setOyadrtencdA(oyadrtCd);
            uiBean.setOyadrtennmA(oyadrtNm);
            uiBean.setDrtencdA(tratkidrtCd);
            uiBean.setKodrtennmA(tratkidrtNm);
            uiBean.setDairitenkanrisosikicdA(drtkanrisosikicd);
            uiBean.setDaibosyuucdA(daibosyuucd);

            if (pSyoriflg) {

                uiBean.setKinyuucdA(kinyuukikancd);
                uiBean.setKinyuusitencdA(kikansitencd);

            }
            else {

                uiBean.setDrtenjimcdA(jimcd);
            }
        }
        else {

            uiBean.setOyadrtencdB(oyadrtCd);
            uiBean.setOyadrtennmB(oyadrtNm);
            uiBean.setDrtencdB(tratkidrtCd);
            uiBean.setKodrtennmB(tratkidrtNm);
            uiBean.setDairitenkanrisosikicdB(drtkanrisosikicd);
            uiBean.setDaibosyuucdB(daibosyuucd);

            if (pSyoriflg) {

                uiBean.setKinyuucdB(kinyuukikancd);
                uiBean.setKinyuusitencdB(kikansitencd);

            }
            else {

                uiBean.setDrtenjimcdB(jimcd);
            }
        }

        uiBean.setBosyuuOyadrtCd(bosyuuOyadrtCd);
    }

    private void chkAgYuukou(String pdrtencd) {

        BzChkAgYuukou bzChkAgYuukou = SWAKInjector.getInstance(BzChkAgYuukou.class);

        boolean yuukouhanteikekka = bzChkAgYuukou.exec(
            pdrtencd,
            BizDate.getSysDate());

        if (!yuukouhanteikekka) {

            messageManagerLst.add(MessageUtil.getMessage(MessageId.WIF1013, pdrtencd));
        }
    }

    private void chkCIFCd() {

        IW_CifcdIktHnkWk cifcdIktHnkWk = hozenDomManager.getCifcdIktHnkWk(uiBean.getSyono());

        if (cifcdIktHnkWk != null) {

            String messageID = BizUtil.getGeneralMessageId(MessageId.WIF1037);

            String message = MessageUtil.getMessage(MessageId.WIF1037);

            messageManager.addConversationMessageId(KhDairitenInfoSyuuseiConstants.KEY_GROUP_MESSAGE,
                messageID, message);
        }
    }

}
