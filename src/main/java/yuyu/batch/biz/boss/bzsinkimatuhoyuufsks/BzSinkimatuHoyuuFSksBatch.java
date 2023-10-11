package yuyu.batch.biz.boss.bzsinkimatuhoyuufsks;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.resource.ResourceUtil;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.biz.boss.bzsinkimatuhoyuufsks.dba.BzSinkimatuHoyuuFSksDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.KbnInfoBean;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KeisanIkkatuNyuukinGkBean;
import yuyu.common.hozen.khcommon.KeisanIkkatuNyuukinGkSyouhnBean;
import yuyu.common.hozen.khcommon.KeisanTukiIkkatuNyuukinGk;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_TrkKzk;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.db.entity.ZT_SinkimatuHoyuuFTy;
import yuyu.def.hozen.detacher.IT_AnsyuKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.Ztrhuho2SinkiMatuHoyuuFTaisyouDataBean;
import yuyu.def.hozen.sorter.SortIT_NyknJissekiRireki;
import yuyu.def.hozen.sorter.SortIT_Zennou;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 業務共通 ＢＯＳＳ 普保Ⅱ新期末保有Ｆ作成
 */
public class BzSinkimatuHoyuuFSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BzSinkimatuHoyuuFSksDao bzSinkimatuHoyuuFSksDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        String message = MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            bzBatchParam.getSyoriYmd().toString());
        batchLogger.info(message);

        int syoriKensuu = 0;

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        SortIT_NyknJissekiRireki nyknJissekiRireki = SWAKInjector.getInstance(SortIT_NyknJissekiRireki.class);

        CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);

        BizNumber nyuukinyouRateLastmonthUSD = BizNumber.valueOf(0);
        BizNumber nyuukinyouRateLastmonthAUD = BizNumber.valueOf(0);
        BizNumber nyuukinyouRateLastmonth = BizNumber.valueOf(0);

        nyuukinyouRateLastmonthUSD = getKawaserate(syoriYmd.getBizDateYM().getPreviousMonth().getLastDay(),
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE, C_Tuukasyu.USD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.NYUKINRATE, C_EigyoubiHoseiKbn.ZENEIGYOUBI, C_YouhiKbn.HUYOU);

        nyuukinyouRateLastmonthAUD = getKawaserate(syoriYmd.getBizDateYM().getPreviousMonth().getLastDay(),
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE, C_Tuukasyu.AUD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.NYUKINRATE, C_EigyoubiHoseiKbn.ZENEIGYOUBI, C_YouhiKbn.HUYOU);

        try (EntityInserter<ZT_SinkimatuHoyuuFTy> sinkimatuHoyuuFTyEtyInsert = new EntityInserter<>();
            ExDBResults<Ztrhuho2SinkiMatuHoyuuFTaisyouDataBean> ztrhuho2SinkiMatuHoyuuFTaisyouDataBeanLst =
                hozenDomManager.getZtrhuho2SinkiMatuHoyuuFTaisyouDataBean();) {

            Iterator<Ztrhuho2SinkiMatuHoyuuFTaisyouDataBean> iterator = ztrhuho2SinkiMatuHoyuuFTaisyouDataBeanLst
                .iterator();

            while (iterator.hasNext()) {

                Ztrhuho2SinkiMatuHoyuuFTaisyouDataBean ztrhuho2SinkiMatuHoyuuFTaisyouDataBean = iterator.next();

                ZT_SinkimatuHoyuuFTy sinkimatuHoyuuFTy = new ZT_SinkimatuHoyuuFTy();

                IT_KykDairiten kykDairiten = ztrhuho2SinkiMatuHoyuuFTaisyouDataBean.getIT_KykDairiten();
                IT_KykKihon kykKihon = ztrhuho2SinkiMatuHoyuuFTaisyouDataBean.getIT_KykKihon();
                IT_KykSyouhn kykSyouhn = ztrhuho2SinkiMatuHoyuuFTaisyouDataBean.getIT_KykSyouhn();
                IT_HhknSya hhknSya = ztrhuho2SinkiMatuHoyuuFTaisyouDataBean.getIT_HhknSya();
                IT_KykSya kykSya = ztrhuho2SinkiMatuHoyuuFTaisyouDataBean.getIT_KykSya();
                IT_KykSonotaTkyk kykSonotaTkyk = ztrhuho2SinkiMatuHoyuuFTaisyouDataBean.getIT_KykSonotaTkyk();
                List<IT_NyknJissekiRireki> nyknJissekiRirekiList =
                    kykKihon.getNyknJissekiRirekisByNykkeiro(C_Nykkeiro.SKEI);
                nyknJissekiRirekiList = nyknJissekiRireki.OrderIT_NyknJissekiRirekiByPkAsc(nyknJissekiRirekiList);
                IT_AnsyuKihon ansyuKihon = ztrhuho2SinkiMatuHoyuuFTaisyouDataBean.getIT_AnsyuKihon();

                sinkimatuHoyuuFTy.setZtysequenceno(syoriKensuu + 1);
                sinkimatuHoyuuFTy.setZtytantoukojincd(kykDairiten.getDaibosyuucd());
                sinkimatuHoyuuFTy.setZtytantousyasetteiym(kykKihon.getBosyuuym().toString());
                sinkimatuHoyuuFTy.setZtykeijyousakikbn("0");

                if (!BizUtil.isBlank(kykDairiten.getDrtenkanrisosikicd())) {
                    sinkimatuHoyuuFTy.setZtykeijyousakisosiki(kykDairiten.getDrtenkanrisosikicd());
                }
                else {
                    BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

                    List<BzGetAgInfoBean> bzGetAgInfoBeanLst = bzGetAgInfo.exec(kykDairiten.getDrtencd());

                    if (bzGetAgInfoBeanLst.size() == 0) {
                        sinkimatuHoyuuFTy.setZtykeijyousakisosiki("0000000");
                    }
                    else {
                        sinkimatuHoyuuFTy.setZtykeijyousakisosiki(bzGetAgInfoBeanLst.get(0).getDrtKanrisosikiCd1());
                    }

                }

                sinkimatuHoyuuFTy.setZtyutiwakekbn("A");

                sinkimatuHoyuuFTy.setZtydenymd(syoriYmd.toString());

                sinkimatuHoyuuFTy.setZtykeijyouym(syoriYmd.getBizDateYM().toString());

                sinkimatuHoyuuFTy.setZtytantoukeiyakukbn("1");

                if (C_UmuKbn.NONE.eq(kykDairiten.getDrtenbunumu())) {
                    sinkimatuHoyuuFTy.setZtykydatkikbn("0");
                }
                else if (C_UmuKbn.ARI.eq(kykDairiten.getDrtenbunumu())) {

                    if (kykDairiten.getDrtenrenno() == 1) {
                        sinkimatuHoyuuFTy.setZtykydatkikbn("1");
                    }
                    else {
                        sinkimatuHoyuuFTy.setZtykydatkikbn("2");
                    }
                }

                sinkimatuHoyuuFTy.setZtysyono(kykKihon.getSyono());
                sinkimatuHoyuuFTy.setZtybsyym(sinkimatuHoyuuFTy.getZtytantousyasetteiym());
                if (kykSyouhn.getKykymd() != null) {
                    sinkimatuHoyuuFTy.setZtykykymd(kykSyouhn.getKykymd().toString());
                }
                else {
                    sinkimatuHoyuuFTy.setZtykykymd("00000000");
                }

                sinkimatuHoyuuFTy.setZtysaisinbsyym(sinkimatuHoyuuFTy.getZtytantousyasetteiym());
                sinkimatuHoyuuFTy.setZtyhknsyukigou(kykSyouhn.getSyouhncd().substring(0, 2));

                sinkimatuHoyuuFTy.setZtymaruteisyuruikigou("");
                sinkimatuHoyuuFTy.setZtyyobin3(0);
                sinkimatuHoyuuFTy.setZtyyobiv1("0");
                sinkimatuHoyuuFTy.setZtyyobiv1x2("0");
                sinkimatuHoyuuFTy.setZtykykniyutksytioukbn("0");
                sinkimatuHoyuuFTy.setZtyyobiv1x3("0");
                sinkimatuHoyuuFTy.setZtyteisyuuhyj("0");
                sinkimatuHoyuuFTy.setZtyitijibryourouhyj("0");
                sinkimatuHoyuuFTy.setZtymrtihukahyj("0");
                sinkimatuHoyuuFTy.setZtyseizonmrtihukahyj("0");
                sinkimatuHoyuuFTy.setZtyteigenmrtihukahyj("0");
                sinkimatuHoyuuFTy.setZtysynymrtihukahyj("0");
                sinkimatuHoyuuFTy.setZtylivingneedstkykarihyj("0");
                sinkimatuHoyuuFTy.setZtyreguardmrtihukahyj("0");
                sinkimatuHoyuuFTy.setZtyreguardmrsyuhukahyj("0");
                sinkimatuHoyuuFTy.setZtyvguardmrtihukahyj("0");
                sinkimatuHoyuuFTy.setZtykaigonktkykhukahyj("0");
                sinkimatuHoyuuFTy.setZtygoukeisisttkyktkknsnp(0L);
                BizCurrency ztyhsys = BizCurrency.valueOf(0);
                BizNumber kawaseRate = BizNumber.ZERO;
                KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);


                int syohinHanteiKbn = SyouhinUtil.hantei(kykSyouhn.getSyouhncd());

                if (syohinHanteiKbn == (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN)) {
                    ztyhsys = kykSyouhn.getPharaikomisougaku();
                }
                else if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                    syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
                    syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

                    ztyhsys = kykSyouhn.getKihons();
                }
                else {

                    BizDate wkCalckijyunYmd = syoriYmd;

                    if (kykSyouhn.getYendthnkymd() != null) {
                        if (BizDateUtil.compareYmd(syoriYmd, kykSyouhn.getYendthnkymd()) == BizDateUtil.COMPARE_LESSER) {
                            wkCalckijyunYmd = kykSyouhn.getYendthnkymd();
                        }
                    }

                    C_ErrorKbn calcHkErrorKbn = calcHkShrKngk.execByKeisanWExt(kykKihon.getSyono(), wkCalckijyunYmd,
                        C_SiinKbn.SP, C_HokenkinsyuruiKbn.SBHOKENKIN, kykKihon.getSdpdkbn(), kykKihon.getHrkkeiro());

                    if (!C_ErrorKbn.OK.eq(calcHkErrorKbn)) {
                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1048,
                            ResourceUtil.getApplicationResources().getString("hokenkngk"),kykKihon.getSyono()));
                    }
                    ztyhsys = calcHkShrKngk.getCalcHkShrKngkBean().getSibousGk();
                }
                if(syohinHanteiKbn != SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN){
                    if (!(C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu()))) {

                        BizDate kwsratekjymd = null;

                        if (syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

                            kwsratekjymd = syoriYmd;
                        }
                        else {

                            kwsratekjymd = nyknJissekiRirekiList.get(0).getRyosyuymd();
                        }

                        kawaseRate = getKawaserate(kwsratekjymd,
                            C_KawaserateSyuruiKbn.PM17JIKAWASERATE, kykSyouhn.getKyktuukasyu(), C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
                            C_KawasetsryKbn.JISSEIRATE, C_EigyoubiHoseiKbn.YOKUEIGYOUBI, C_YouhiKbn.HUYOU);

                        ztyhsys = keisanGaikakanzan.exec(
                            C_Tuukasyu.JPY,
                            ztyhsys,
                            kawaseRate,
                            C_HasuusyoriKbn.SUTE);

                    }
                }
                sinkimatuHoyuuFTy.setZtyhsys(new BigDecimal(ztyhsys.toString()).longValue());

                sinkimatuHoyuuFTy.setZtykensuun3(BizNumber.valueOf(1));
                sinkimatuHoyuuFTy.setZtyhenkougohosyous(0L);
                sinkimatuHoyuuFTy.setZtyhtns(0L);

                IT_KykSyouhnHnkmae kykSyouhnHnkmae = new IT_KykSyouhnHnkmae();
                if(C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())){
                    if (kykSyouhn.getYendthnkymd() != null) {

                        kykSyouhnHnkmae = bzSinkimatuHoyuuFSksDao.getKykSyouhnHnkmaeBySyono(kykKihon.getSyono());
                        if (C_Tuukasyu.JPY.eq(kykSyouhnHnkmae.getKyktuukasyu())) {

                            sinkimatuHoyuuFTy.setZtyharaikomip(new BigDecimal(kykSyouhnHnkmae.getHokenryou()
                                .toString()).longValue());
                        }
                        else {
                            if (C_Tuukasyu.JPY.eq(nyknJissekiRirekiList.get(0).getRstuukasyu())) {

                                sinkimatuHoyuuFTy.setZtyharaikomip(new BigDecimal(nyknJissekiRirekiList.get(0).getRsgaku()
                                    .toString()).longValue());
                            }
                            else {
                                BizDate kwsratekjymd = nyknJissekiRirekiList.get(0).getRyosyuymd();
                                kawaseRate = getKawaserate(kwsratekjymd,
                                    C_KawaserateSyuruiKbn.PM17JIKAWASERATE, kykSyouhnHnkmae.getKyktuukasyu(), C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
                                    C_KawasetsryKbn.JISSEIRATE, C_EigyoubiHoseiKbn.YOKUEIGYOUBI, C_YouhiKbn.HUYOU);

                                BizCurrency hKansanGaku = keisanGaikakanzan.exec(
                                    C_Tuukasyu.JPY,
                                    kykSyouhnHnkmae.getHokenryou(),
                                    kawaseRate,
                                    C_HasuusyoriKbn.SUTE);

                                sinkimatuHoyuuFTy.setZtyharaikomip(new BigDecimal(hKansanGaku.toString())
                                .longValue());
                            }
                        }
                    }
                    else {
                        if (C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {

                            sinkimatuHoyuuFTy.setZtyharaikomip(new BigDecimal(kykSyouhn.getHokenryou().toString())
                            .longValue());
                        }
                        else {
                            if (C_Tuukasyu.JPY.eq(nyknJissekiRirekiList.get(0).getRstuukasyu())) {

                                sinkimatuHoyuuFTy.setZtyharaikomip(new BigDecimal(nyknJissekiRirekiList.get(0).getRsgaku()
                                    .toString()).longValue());
                            }
                            else {
                                sinkimatuHoyuuFTy.setZtyharaikomip(new BigDecimal(keisanGaikakanzan.exec(
                                    C_Tuukasyu.JPY,
                                    kykSyouhn.getHokenryou(),
                                    kawaseRate,
                                    C_HasuusyoriKbn.SUTE).toString()).longValue());
                            }
                        }
                    }
                }
                else if(C_Kykjyoutai.ZENNOU.eq(kykSyouhn.getKykjyoutai())){
                    IT_AnsyuKihon itansyuKihon = hozenDomManager.getAnsyuKihon(kykKihon.getSyono());
                    itansyuKihon = IT_AnsyuKihonDetacher.detachZennoustouched(itansyuKihon);

                    List<IT_Zennou> itzennouLst = itansyuKihon.getZennous();

                    if (itzennouLst.size() == 0) {
                        throw new CommonBizAppException(
                            MessageUtil.getMessage(MessageId.EIA1048,
                                IT_Zennou.TABLE_NAME,
                                kykKihon.getSyono()));
                    }

                    SortIT_Zennou sortIT_Zennou = SWAKInjector.getInstance(SortIT_Zennou.class);
                    itzennouLst = sortIT_Zennou.OrderIT_ZennouByPkDesc(itzennouLst);
                    IT_Zennou itzennou = itzennouLst.get(0);

                    if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
                        BizCurrency zennoup = itzennou.getZennounyuukinkgk().add(itzennou.getZennoujihrkp()) ;
                        sinkimatuHoyuuFTy.setZtyharaikomip(new BigDecimal(zennoup.toAdsoluteString()).longValue());
                    }
                    else if (syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
                        if (C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {
                            BizCurrency zennoup = itzennou.getZennounyuukinkgk().add(itzennou.getZennoujihrkp());
                            sinkimatuHoyuuFTy.setZtyharaikomip(new BigDecimal(zennoup.toAdsoluteString()).longValue());
                        }
                        else {
                            List<IT_KhTtdkRireki> ttdkRirekiList =
                                kykKihon.getKhTtdkRirekisByGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_GENGAKU);

                            if (ttdkRirekiList.size() == 0 && C_Tuukasyu.JPY.eq(nyknJissekiRirekiList.get(0).getRstuukasyu())){
                                BizCurrency zennoup = itzennou.getZennounyuukinkgkrstk().add(nyknJissekiRirekiList.get(0).getRsgaku()) ;
                                sinkimatuHoyuuFTy.setZtyharaikomip(new BigDecimal(zennoup.toAdsoluteString()).longValue());
                            }
                            else {
                                BizDate kwsratekjymd = nyknJissekiRirekiList.get(0).getRyosyuymd();

                                kawaseRate = getKawaserate(kwsratekjymd,
                                    C_KawaserateSyuruiKbn.PM17JIKAWASERATE, kykSyouhn.getKyktuukasyu(), C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
                                    C_KawasetsryKbn.JISSEIRATE, C_EigyoubiHoseiKbn.YOKUEIGYOUBI, C_YouhiKbn.HUYOU);

                                BizCurrency zennoujihrkpyen = keisanGaikakanzan.exec(
                                    C_Tuukasyu.JPY,
                                    itzennou.getZennoujihrkp(),
                                    kawaseRate,
                                    C_HasuusyoriKbn.AGE);

                                BizCurrency zennounyuukinkgk = keisanGaikakanzan.exec(
                                    C_Tuukasyu.JPY,
                                    itzennou.getZennounyuukinkgk(),
                                    kawaseRate,
                                    C_HasuusyoriKbn.AGE);

                                sinkimatuHoyuuFTy.setZtyharaikomip(new BigDecimal(zennoujihrkpyen.add(zennounyuukinkgk).toAdsoluteString()).longValue());
                            }
                        }
                    }
                }
                else {
                    if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
                        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNkgSyouhnBean = SWAKInjector.getInstance(KeisanIkkatuNyuukinGkSyouhnBean.class);
                        List<KeisanIkkatuNyuukinGkSyouhnBean> keisanIkkatuNkgSyouhnBeanList = new ArrayList<>();
                        KeisanIkkatuNyuukinGkBean keisanIkkatuNkgBean = SWAKInjector.getInstance(KeisanIkkatuNyuukinGkBean.class);
                        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

                        keisanIkkatuNkgSyouhnBean.setSyouhnCd(kykSyouhn.getSyouhncd());
                        keisanIkkatuNkgSyouhnBean.setSyouhnsdNo(kykSyouhn.getSyouhnsdno());
                        keisanIkkatuNkgSyouhnBean.setRyouritusdNo(kykSyouhn.getRyouritusdno());
                        keisanIkkatuNkgSyouhnBean.setYoteiRiritu(BizNumber.valueOf(0));
                        keisanIkkatuNkgSyouhnBean.setHokenryou(kykSyouhn.getHokenryou());

                        keisanIkkatuNkgSyouhnBeanList.add(keisanIkkatuNkgSyouhnBean);

                        keisanIkkatuNkgBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(keisanIkkatuNkgSyouhnBeanList);
                        keisanIkkatuNkgBean.setJyuutoutuKisuu(Integer.valueOf(kykKihon.getTikiktbrisyuruikbn().getValue()));
                        keisanIkkatuNkgBean.setTkiktbrisyuruiKbn(kykKihon.getTikiktbrisyuruikbn());
                        keisanIkkatuNkgBean.setRstuukasyu(C_Tuukasyu.JPY);
                        keisanIkkatuNkgBean.setNyknaiyouKbn(C_NyknaiyouKbn.BLNK);
                        keisanIkkatuNkgBean.setNykkeiro(C_Nykkeiro.BLNK);
                        keisanIkkatuNkgBean.setSyokaiprsYmd(null);
                        keisanIkkatuNkgBean.setJyutoustartYm(null);

                        C_ErrorKbn errorKbn = keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNkgBean, false);

                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                            throw new CommonBizAppException(
                                MessageUtil.getMessage(MessageId.EIA1010,
                                    "月払一括入金額計算",
                                    kykKihon.getSyono()));
                        }

                        sinkimatuHoyuuFTy.setZtyharaikomip(new BigDecimal(keisanTukiIkkatuNyuukinGk.getIktnyknkgk().toAdsoluteString()).longValue());
                    }
                    else if (syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

                        List<IT_KhTtdkRireki> ttdkRirekiList =
                            kykKihon.getKhTtdkRirekisByGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_GENGAKU);

                        if (ttdkRirekiList.size() == 0) {
                            List<IT_NyknJissekiRireki> nyknJissekiRirekiListTukisiteiLst = kykKihon.getNyknJissekiRirekisByNyktrksflg(C_Nyktrksflg.TORIKESI);

                            if (nyknJissekiRirekiListTukisiteiLst.size() > 0) {
                                BizCurrency sumRsgaku = BizCurrency.valueOf(0);
                                BizDateYM jkipjytym = ansyuKihon.getJkipjytym();
                                BizDateYM jkipjytsumiym = jkipjytym.getPreviousMonth();

                                for (IT_NyknJissekiRireki nyknJissekiRirekiSaki : nyknJissekiRirekiListTukisiteiLst) {
                                    if (jkipjytym.compareTo(nyknJissekiRirekiSaki.getJyutoustartym()) > 0 &&
                                        jkipjytsumiym.compareTo(nyknJissekiRirekiSaki.getJyutouendym()) <= 0) {
                                        sumRsgaku = sumRsgaku.add(nyknJissekiRirekiSaki.getRsgaku());
                                    }
                                }

                                sinkimatuHoyuuFTy.setZtyharaikomip(new BigDecimal(sumRsgaku.toAdsoluteString()).longValue());

                            }

                        }
                        else {
                            if (C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {

                                sinkimatuHoyuuFTy.setZtyharaikomip(new BigDecimal(kykSyouhn.getHokenryou().toAdsoluteString())
                                .longValue());
                            }
                            else {
                                if (C_Tuukasyu.USD.eq(kykSyouhn.getKyktuukasyu())) {
                                    nyuukinyouRateLastmonth = nyuukinyouRateLastmonthUSD;
                                }
                                else {
                                    nyuukinyouRateLastmonth = nyuukinyouRateLastmonthAUD;
                                }

                                sinkimatuHoyuuFTy.setZtyharaikomip(
                                    new BigDecimal(keisanGaikakanzan.exec(
                                        C_Tuukasyu.JPY,
                                        kykSyouhn.getHokenryou(),
                                        nyuukinyouRateLastmonth,
                                        C_HasuusyoriKbn.AGE).toAdsoluteString()).longValue());
                            }
                        }
                    }
                }

                sinkimatuHoyuuFTy.setZtykaiyakusiharaikngk(0L);
                if(C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())){
                    sinkimatuHoyuuFTy.setZtyhrkkaisuukbn("0");

                }
                else if (C_Kykjyoutai.ZENNOU.eq(kykSyouhn.getKykjyoutai())){
                    sinkimatuHoyuuFTy.setZtyhrkkaisuukbn("1");

                }
                else {
                    if(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(kykKihon.getTikiktbrisyuruikbn()) ||
                        C_Hrkkaisuu.HALFY.eq(kykKihon.getHrkkaisuu())){
                        sinkimatuHoyuuFTy.setZtyhrkkaisuukbn("2");

                    }
                    else if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(kykKihon.getTikiktbrisyuruikbn()) ||
                        C_Hrkkaisuu.NEN.eq(kykKihon.getHrkkaisuu())){
                        sinkimatuHoyuuFTy.setZtyhrkkaisuukbn("1");

                    }
                    else{
                        sinkimatuHoyuuFTy.setZtyhrkkaisuukbn("3");
                    }

                }


                KbnInfoBean kbnInfoBean = SWAKInjector.getInstance(BzKbnHenkanUtil.class).convKbn(
                    kykKihon.getHrkkeiro().toString(),
                    C_Hrkkeiro.class,
                    C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);
                if(kbnInfoBean.isHenkanFlg()){
                    sinkimatuHoyuuFTy.setZtyhrkkeirokbn(kbnInfoBean.getKbnData());
                }
                else {
                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1046,
                        ResourceUtil.getApplicationResources().getString("hrkkeiro"), kykKihon.getHrkkeiro().getValue()));
                }


                if (C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())) {
                    sinkimatuHoyuuFTy.setZtyannaifuyouriyuukbn("01");
                }
                else {
                    if(C_Kykjyoutai.ZENNOU.eq(kykSyouhn.getKykjyoutai())){
                        sinkimatuHoyuuFTy.setZtyannaifuyouriyuukbn("07");
                    }
                    else {
                        sinkimatuHoyuuFTy.setZtyannaifuyouriyuukbn("00");
                    }
                }


                sinkimatuHoyuuFTy.setZtyanniskcd("00000000");
                sinkimatuHoyuuFTy.setZtytenkankaisuu("0");
                sinkimatuHoyuuFTy.setZtysikkounyknkaisuu("00");
                sinkimatuHoyuuFTy.setZtyyobiv2("00");
                if (10 > kykSyouhn.getHhknnen()) {
                    sinkimatuHoyuuFTy.setZtyhhknnen2keta(Strings.padStart(kykSyouhn.getHhknnen().toString(), 2, '0'));
                }
                else if (100 > kykSyouhn.getHhknnen()) {
                    sinkimatuHoyuuFTy.setZtyhhknnen2keta(kykSyouhn.getHhknnen().toString());
                }
                else {
                    sinkimatuHoyuuFTy.setZtyhhknnen2keta("99");
                }

                sinkimatuHoyuuFTy.setZtyhhknseikbn(hhknSya.getHhknsei().getValue());
                sinkimatuHoyuuFTy.setZtykjkyknm(kykSya.getKyknmkj());
                sinkimatuHoyuuFTy.setZtytsinkihontikucd("");
                sinkimatuHoyuuFTy.setZtyhjnkykhyj("0");
                sinkimatuHoyuuFTy.setZtyhjncd("000000000");
                sinkimatuHoyuuFTy.setZtyhjnjigyosyocd("");
                sinkimatuHoyuuFTy.setZtysyorisosikicd("0000000");
                sinkimatuHoyuuFTy.setZtytikusyokansisyakijyhyj("0");
                sinkimatuHoyuuFTy.setZtykeizokutyuuihyouji("0");
                sinkimatuHoyuuFTy.setZtytyohkkeiyakutyuuikbn("0");
                sinkimatuHoyuuFTy.setZtyyobiv1x4("0");
                sinkimatuHoyuuFTy.setZtydantaisyozokucd("");
                sinkimatuHoyuuFTy.setZtysuperknkuseikatupackhyj("0");
                sinkimatuHoyuuFTy.setZtyjikokykhyj("0");
                sinkimatuHoyuuFTy.setZtykikeiyakutyuuihyouji("0");
                sinkimatuHoyuuFTy.setZtysyuuseis(0L);
                sinkimatuHoyuuFTy.setZtyclubsumiseikaiinkykkbn("0");
                sinkimatuHoyuuFTy.setZtygatkihmkknrkmaekykhyj("0");
                sinkimatuHoyuuFTy.setZtygatkisetteikouhokykhyj("0");
                if (BizDateUtil.compareYm(BizDateYM.valueOf(sinkimatuHoyuuFTy.getZtybsyym()).addMonths(25),
                    syoriYmd.getBizDateYM()) == BizDateUtil.COMPARE_GREATER) {
                    sinkimatuHoyuuFTy.setZtybosyuu25keikahyj("0");
                }
                else {
                    sinkimatuHoyuuFTy.setZtybosyuu25keikahyj("1");
                }

                sinkimatuHoyuuFTy.setZtytokuteidaisyokudanhyj("0");
                sinkimatuHoyuuFTy.setZtyhoyuuikantsgkykhyj("0");
                sinkimatuHoyuuFTy.setZtytokubeturuletikuhyj("0");
                sinkimatuHoyuuFTy.setZtyfieldtantousyaarihyj("0");
                sinkimatuHoyuuFTy.setZtyyobiv1x5("0");
                sinkimatuHoyuuFTy.setZtycatkihmkknrkmaekykhyj("0");
                sinkimatuHoyuuFTy.setZtycatkisetteikouhokykhyj("0");
                sinkimatuHoyuuFTy.setZtyseppankeijyoukbn(sinkimatuHoyuuFTy.getZtykydatkikbn());
                sinkimatuHoyuuFTy.setZtyyobiv6("000000");
                sinkimatuHoyuuFTy.setZtyfollowtantousyakbn("00");
                sinkimatuHoyuuFTy.setZtyyobiv7("0000000");
                sinkimatuHoyuuFTy.setZtyhosyouminaosikaisuuv2("00");
                sinkimatuHoyuuFTy.setZtybnkttnknkbn("0");
                sinkimatuHoyuuFTy.setZtytenkangosyono("00000000000");
                sinkimatuHoyuuFTy.setZtyqpackhyj("0");
                sinkimatuHoyuuFTy.setZtytenkangoqpackhyj("0");
                sinkimatuHoyuuFTy.setZtysyuruihnkutkbttrtkhyj("0");
                sinkimatuHoyuuFTy.setZtytnkngsyuhnkutkbttrtkhyj("0");
                sinkimatuHoyuuFTy.setZtyyobin11(0L);
                sinkimatuHoyuuFTy.setZtykibanhikitugikbn("0");
                sinkimatuHoyuuFTy.setZtyyobiv1x6("0");
                sinkimatuHoyuuFTy.setZtysyoumetucd("0000");
                sinkimatuHoyuuFTy.setZtyjikaipjyuutouym(ansyuKihon.getJkipjytym().toString());
                sinkimatuHoyuuFTy.setZtykaigomarusyuuhukahyj("0");
                sinkimatuHoyuuFTy.setZtyyobiv1x7("0");
                sinkimatuHoyuuFTy.setZtysyoritorikesihyj("0");
                sinkimatuHoyuuFTy.setZtymrtikousinkatakbn("");
                sinkimatuHoyuuFTy.setZtypmenkbnv1("");
                sinkimatuHoyuuFTy.setZtysyukeiyakutkknsnp(0L);
                sinkimatuHoyuuFTy.setZtynenkansanp(0L);
                sinkimatuHoyuuFTy.setZtydai3bunyanenkansanp(0L);
                sinkimatuHoyuuFTy.setZtynyuuintkykhukahyj("0");
                sinkimatuHoyuuFTy.setZtynyuuintkykhukahyj20ijyou("0");
                sinkimatuHoyuuFTy.setZtynyuuintkykhukahyj5ijyou("0");
                sinkimatuHoyuuFTy.setZtymarusyotkykhukahyj("0");
                sinkimatuHoyuuFTy.setZtymarujyuutkykhukahyj("0");
                sinkimatuHoyuuFTy.setZtykakudaimaruitkykhukahyj("0");
                sinkimatuHoyuuFTy.setZtykakunyuutkykhukahyj("0");
                sinkimatuHoyuuFTy.setZtymaruitkykhukahyj("0");
                sinkimatuHoyuuFTy.setZtystdairiseikyuutkykarihyj(kykSonotaTkyk.getStdrsktkyhkumu().getValue());
                sinkimatuHoyuuFTy.setZtykensuuyuuguukbn("0");
                sinkimatuHoyuuFTy.setZtykaigosynyteikikbn("0");
                sinkimatuHoyuuFTy.setZtykaigosynyteikishrkskbn("0");
                sinkimatuHoyuuFTy.setZtygyousekibosyujisikakucd("");
                sinkimatuHoyuuFTy.setZtygyskboshtnsineiyksnkbn("");
                sinkimatuHoyuuFTy.setZtysiktsynymrtihukahyj("0");
                sinkimatuHoyuuFTy.setZtysiktsynyteikikbn("0");
                sinkimatuHoyuuFTy.setZtyseikatusyuunyuumrtis(0L);
                sinkimatuHoyuuFTy.setZtylivguardhukahyj("0");
                sinkimatuHoyuuFTy.setZtylivguards(0L);
                sinkimatuHoyuuFTy.setZtyknkuzusnzyrttekitkarihyj("0");
                sinkimatuHoyuuFTy.setZtybluekzjtkaisiymd("00000000");
                sinkimatuHoyuuFTy.setZtyknkuzusnzyrtstkbn("");
                sinkimatuHoyuuFTy.setZtykykdrtkykarihyj(kykSonotaTkyk.getKykdrtkykhukaumu().getValue());
                sinkimatuHoyuuFTy.setZtykzktourokuservicearihyj("0");
                List<IT_TrkKzk> itTrkKzkList = kykKihon.getTrkKzks();
                if (itTrkKzkList.size() > 0){
                    sinkimatuHoyuuFTy.setZtykzktourokuservicearihyj ("1");
                }

                sinkimatuHoyuuFTy.setZtysiteituukakbn("0");
                if (kykSyouhn.getYendthnkymd() != null) {
                    if (C_Tuukasyu.USD.eq(kykSyouhnHnkmae.getKyktuukasyu())) {
                        sinkimatuHoyuuFTy.setZtysiteituukakbn("1");
                    }
                    else if (C_Tuukasyu.AUD.eq(kykSyouhnHnkmae.getKyktuukasyu())) {
                        sinkimatuHoyuuFTy.setZtysiteituukakbn("2");
                    }
                }
                else {
                    if (C_Tuukasyu.USD.eq(kykSyouhn.getKyktuukasyu())) {
                        sinkimatuHoyuuFTy.setZtysiteituukakbn("1");
                    }
                    else if (C_Tuukasyu.AUD.eq(kykSyouhn.getKyktuukasyu())) {
                        sinkimatuHoyuuFTy.setZtysiteituukakbn("2");
                    }
                }

                BizPropertyInitializer.initialize(sinkimatuHoyuuFTy);

                BzSinkimatuHoyuuFSksConverter.convertPadding(sinkimatuHoyuuFTy);

                sinkimatuHoyuuFTyEtyInsert.add(sinkimatuHoyuuFTy);

                syoriKensuu = syoriKensuu + 1;
            }

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), "普保Ⅱ新期末保有Ｆ作成"));
        }
    }

    private BizNumber getKawaserate(BizDate pKwsrateKjYmd, C_KawaserateSyuruiKbn pKawaserateSyuruiKbn,
        C_Tuukasyu pMototuuka, C_Tuukasyu pKanzantuuka, C_KawasetekiyoKbn pKawaseteKiyoKbn,
        C_KawasetsryKbn pKawasetsryKbn, C_EigyoubiHoseiKbn pEigyoubiHoseiKbn, C_YouhiKbn pZenEigyoubiKsSyutokuYouhi) {

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        C_ErrorKbn errorKbn = getKawaseRate.exec(
            pKwsrateKjYmd,
            pKawaserateSyuruiKbn,
            pMototuuka,
            pKanzantuuka,
            pKawaseteKiyoKbn,
            pKawasetsryKbn,
            pEigyoubiHoseiKbn,
            pZenEigyoubiKsSyutokuYouhi);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1047, pKwsrateKjYmd.toString(),
                pKawaserateSyuruiKbn.getValue(), pMototuuka.getValue(), pKanzantuuka.getValue(),
                pKawaseteKiyoKbn.getValue(), pKawasetsryKbn.getValue(), pEigyoubiHoseiKbn.getValue(),
                pZenEigyoubiKsSyutokuYouhi.getValue()));
        }
        return getKawaseRate.getKawaserate();
    }

}