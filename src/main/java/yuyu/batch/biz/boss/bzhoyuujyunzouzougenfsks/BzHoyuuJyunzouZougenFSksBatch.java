package yuyu.batch.biz.boss.bzhoyuujyunzouzougenfsks;

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
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.biz.boss.bzhoyuujyunzouzougenfsks.dba.BzHoyuuJyunzouZougenFSksDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyouriritu;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyourirituBean;
import yuyu.common.biz.bzcommon.HenkanTuuka;
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
import yuyu.def.PartMID_hozen;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
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
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhHenkouRireki;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.entity.IT_KykSyouhnRireki;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_TrkKzk;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.db.entity.ZT_HoyuuJyunzouZougenFTy;
import yuyu.def.hozen.detacher.IT_AnsyuKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean;
import yuyu.def.hozen.sorter.SortIT_KhTtdkRireki;
import yuyu.def.hozen.sorter.SortIT_NyknJissekiRireki;
import yuyu.def.hozen.sorter.SortIT_Zennou;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 業務共通 ＢＯＳＳ 普保Ⅱ保有純増増減Ｆ作成
 */
public class BzHoyuuJyunzouZougenFSksBatch implements Batch {

    private static final String PALUTIWAKEKBN_SEIRITU = "1";

    private static final String PALUTIWAKEKBN_SIBOU = "4";

    private static final String PALUTIWAKEKBN_KAIYAKU = "5";

    private static final String PALUTIWAKEKBN_GENGAKU = "C";

    private static final String PALUTIWAKEKBN_SIKKOU = "6";

    private static final String PALUTIWAKEKBN_SONOTAZOU = "8";

    private static final String PALUTIWAKEKBN_SONOTAGEN = "9";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BzHoyuuJyunzouZougenFSksDao bzHoyuuJyunzouZougenFSksDao;


    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        int syoriKensu = 0;
        BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);
        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
        SortIT_NyknJissekiRireki nyknJissekiRireki = SWAKInjector.getInstance(SortIT_NyknJissekiRireki.class);
        CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);
        BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);
        String kinouidKeiyakuInfoTorikomi = IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI;
        String kinouidSiharaiKekkaTorikomi = IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI;
        String kinouidKaiyaku = IKhozenCommonConstants.KINOUID_KAIYAKU;
        String kinouidGengaku = IKhozenCommonConstants.KINOUID_GENGAKU;
        String kinouidKeiyakuTorikesi = IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI;
        String kinouidBatchKaiyaku = IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU;
        String kinouidKhpminyuusyoumetu = IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU;
        String kinouidSeinengappisei = IKhozenCommonConstants.KINOUID_SEINENGAPPISEI;
        String[] gyoumuKousinKinou = { kinouidKeiyakuInfoTorikomi, kinouidSiharaiKekkaTorikomi, kinouidKaiyaku,
            kinouidGengaku, kinouidBatchKaiyaku, kinouidKhpminyuusyoumetu, kinouidSeinengappisei };

        BizNumber nyuukinyouRateLastmonthUSD = BizNumber.valueOf(0);
        BizNumber nyuukinyouRateLastmonthAUD = BizNumber.valueOf(0);
        BizNumber nyuukinyouRateLastmonth = BizNumber.valueOf(0);

        nyuukinyouRateLastmonthUSD = getKawaserate(syoriYmd.getBizDateYM().getPreviousMonth().getLastDay(),
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE, C_Tuukasyu.USD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.NYUKINRATE, C_EigyoubiHoseiKbn.ZENEIGYOUBI, C_YouhiKbn.HUYOU);

        nyuukinyouRateLastmonthAUD = getKawaserate(syoriYmd.getBizDateYM().getPreviousMonth().getLastDay(),
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE, C_Tuukasyu.AUD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.NYUKINRATE, C_EigyoubiHoseiKbn.ZENEIGYOUBI, C_YouhiKbn.HUYOU);

        try (
            ExDBResults<HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean>
            hyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBeanTairyo = hozenDomManager.
            getHyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinou(syoriYmd, gyoumuKousinKinou, kinouidKeiyakuTorikesi);
            EntityInserter<ZT_HoyuuJyunzouZougenFTy> hoyuuJyunzouZougenFTyInserter = new EntityInserter<>()) {

            Iterator<HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean> iterator =
                hyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBeanTairyo.iterator();
            while (iterator.hasNext()) {
                HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean
                hyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean = iterator.next();

                ZT_HoyuuJyunzouZougenFTy hoyuuJyunzouZougenFTy = new ZT_HoyuuJyunzouZougenFTy();
                IT_KhShrRireki khShrRireki = new IT_KhShrRireki();

                IT_KykDairiten kykDairiten = hyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean.
                    getIT_KykDairiten();
                IT_KykKihon kykKihon = hyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean.getIT_KykKihon();
                IT_KykSyouhn kykSyouhn = hyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean.getIT_KykSyouhn();
                IT_KhTtdkRireki khTtdkRireki = hyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean.
                    getIT_KhTtdkRireki();
                IT_HhknSya hhknSya = hyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean.getIT_HhknSya();
                IT_KykSonotaTkyk kykSonotaTkyk = hyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean.
                    getIT_KykSonotaTkyk();
                IT_KykSya kykSya = hyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean.getIT_KykSya();
                IT_AnsyuKihon ansyuKihon = hyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean.getIT_AnsyuKihon();

                int syohinHanteiKbn = SyouhinUtil.hantei(kykSyouhn.getSyouhncd());

                if (kinouidKaiyaku.equals(khTtdkRireki.getGyoumuKousinKinou()) && C_Syoumetujiyuu.PMNYSYMET_JDSKNGAI_SSNZM.eq(kykSyouhn.getSyoumetujiyuu())) {
                    continue;
                }

                Boolean shenkouari = false;
                HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                CurrencyType tuukaType = henkanTuuka.henkanTuukaKbnToType(kykSyouhn.getKyktuukasyu());
                BizCurrency henkoumaekihonS = BizCurrency.valueOf(0, tuukaType);
                BizCurrency henkouatokihonS = BizCurrency.valueOf(0, tuukaType);
                if (kinouidSeinengappisei.equals(khTtdkRireki.getGyoumuKousinKinou())) {
                    if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN  == syohinHanteiKbn) {
                        List<IT_KhHenkouRireki> khHenkouRirekiList =
                            bzHoyuuJyunzouZougenFSksDao.getKhHenkouRirekisBySyonoHenkousikibetukeyGyoumuKousinKinouTableidHenkoukoumokuid(
                                khTtdkRireki.getSyono(),
                                khTtdkRireki.getHenkousikibetukey(),
                                IKhozenCommonConstants.KINOUID_SEINENGAPPISEI,
                                IT_KykSyouhn.TABLE_NAME,
                                IT_KykSyouhn.KIHONS);

                        if (khHenkouRirekiList.size() == 0) {
                            continue;
                        }

                        shenkouari = true;
                        henkoumaekihonS = BizCurrency.valueOf(new BigDecimal(khHenkouRirekiList.get(0).getBfrnaiyouoriginal()), tuukaType);
                        henkouatokihonS = BizCurrency.valueOf(new BigDecimal(khHenkouRirekiList.get(0).getNewnaiyouoriginal()), tuukaType);
                    }
                    else {
                        continue;
                    }
                }

                List<IT_NyknJissekiRireki> nyknJissekiRirekiLst =
                    kykKihon.getNyknJissekiRirekisByNykkeiro(C_Nykkeiro.SKEI);
                nyknJissekiRirekiLst = nyknJissekiRireki.OrderIT_NyknJissekiRirekiByPkAsc(nyknJissekiRirekiLst);

                String ztykeijyousakisosiki = "";
                if (!BizUtil.isBlank(kykDairiten.getDrtenkanrisosikicd())) {
                    ztykeijyousakisosiki = kykDairiten.getDrtenkanrisosikicd();
                }
                else {
                    List<BzGetAgInfoBean> bzGetAgInfoBeanLst = bzGetAgInfo.exec(kykDairiten.getDrtencd());
                    if (bzGetAgInfoBeanLst.size() == 0) {
                        ztykeijyousakisosiki = "0000000";
                    }
                    else {
                        ztykeijyousakisosiki = bzGetAgInfoBeanLst.get(0).getDrtKanrisosikiCd1();
                    }
                }
                String ztyutiwakekbn = "";
                if (kinouidKeiyakuInfoTorikomi.equals(khTtdkRireki.getGyoumuKousinKinou())) {
                    ztyutiwakekbn = PALUTIWAKEKBN_SEIRITU;
                }
                else if (kinouidKeiyakuTorikesi.equals(khTtdkRireki.getGyoumuKousinKinou())) {
                    ztyutiwakekbn = PALUTIWAKEKBN_SIBOU;
                }
                else if (kinouidKaiyaku.equals(khTtdkRireki.getGyoumuKousinKinou())
                    || kinouidBatchKaiyaku.equals(khTtdkRireki.getGyoumuKousinKinou())) {
                    ztyutiwakekbn = PALUTIWAKEKBN_KAIYAKU;
                }
                else if (kinouidKhpminyuusyoumetu.equals(khTtdkRireki.getGyoumuKousinKinou())) {
                    ztyutiwakekbn = PALUTIWAKEKBN_SIKKOU;
                }
                else if (kinouidGengaku.equals(khTtdkRireki.getGyoumuKousinKinou())) {
                    ztyutiwakekbn = PALUTIWAKEKBN_GENGAKU;
                }
                else if(kinouidSiharaiKekkaTorikomi.equals(khTtdkRireki.getGyoumuKousinKinou())){
                    if(C_Syoumetujiyuu.JIKOU.eq(kykSyouhn.getSyoumetujiyuu())){
                        ztyutiwakekbn = PALUTIWAKEKBN_SONOTAGEN;
                    }else{
                        ztyutiwakekbn = PALUTIWAKEKBN_SIBOU;
                    }
                }
                else if (shenkouari) {
                    if (henkouatokihonS.compareTo(henkoumaekihonS) > 0) {
                        ztyutiwakekbn = PALUTIWAKEKBN_SONOTAZOU;
                    }
                    else {
                        ztyutiwakekbn = PALUTIWAKEKBN_SONOTAGEN;
                    }
                }

                String syouhncd = kykSyouhn.getSyouhncd();
                int syouhnsdno = kykSyouhn.getSyouhnsdno();
                C_Tuukasyu motokyktuukasyu = kykSyouhn.getKyktuukasyu();
                C_UmuKbn gengakudoujiyendate = C_UmuKbn.NONE;

                if(PALUTIWAKEKBN_GENGAKU.equals(ztyutiwakekbn) && kykSyouhn.getYendthnkymd() != null){
                    List<IT_KhTtdkRireki> itKhTtdkRirekis = kykKihon.getKhTtdkRirekisByGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK);

                    if (itKhTtdkRirekis.size() == 0){
                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1048, ResourceUtil.getApplicationResources().getString(IT_KhTtdkRireki.TABLE_NAME) ,khTtdkRireki.getSyono()));
                    }

                    SortIT_KhTtdkRireki sortIT_KhTtdkRireki = SWAKInjector.getInstance(SortIT_KhTtdkRireki.class);

                    itKhTtdkRirekis = sortIT_KhTtdkRireki.OrderIT_KhTtdkRirekiBySyoriYmdDesc(itKhTtdkRirekis);

                    if(BizDateUtil.compareYmd(itKhTtdkRirekis.get(0).getSyoriYmd(), syoriYmd) == BizDateUtil.COMPARE_EQUAL){
                        gengakudoujiyendate = C_UmuKbn.ARI;

                        IT_KykSyouhnHnkmae kykSyouhnHnkmaeForRireki = bzHoyuuJyunzouZougenFSksDao.getKykSyouhnHnkmaeBySyono(khTtdkRireki.getSyono());

                        syouhncd = kykSyouhnHnkmaeForRireki.getSyouhncd();
                        syouhnsdno = kykSyouhnHnkmaeForRireki.getSyouhnsdno();
                        motokyktuukasyu = kykSyouhnHnkmaeForRireki.getKyktuukasyu();
                    }
                }

                String ztydenymd = "";
                String ztykeijyouym = "";
                if (PALUTIWAKEKBN_KAIYAKU.equals(ztyutiwakekbn) || PALUTIWAKEKBN_GENGAKU.equals(ztyutiwakekbn) ||
                    PALUTIWAKEKBN_SIKKOU.equals(ztyutiwakekbn) || shenkouari) {
                    khShrRireki = khTtdkRireki.getKhShrRireki();

                    if (khShrRireki == null) {
                        ztydenymd = String.valueOf(syoriYmd);
                        ztykeijyouym = String.valueOf(syoriYmd.getBizDateYM());
                    }
                    else {
                        if (khShrRireki.getShrymd() == null) {
                            ztydenymd = String.valueOf(syoriYmd);
                            ztykeijyouym = String.valueOf(syoriYmd.getBizDateYM());
                        }
                        else {
                            ztydenymd = String.valueOf(khShrRireki.getShrymd());
                            ztykeijyouym = String.valueOf(khShrRireki.getShrymd().getBizDateYM());

                        }
                    }
                }
                else {
                    ztydenymd = String.valueOf(syoriYmd);
                    if (PALUTIWAKEKBN_SEIRITU.equals(ztyutiwakekbn)) {
                        ztykeijyouym = String.valueOf(kykKihon.getBosyuuym());
                    }
                    else if (PALUTIWAKEKBN_SIBOU.equals(ztyutiwakekbn) || PALUTIWAKEKBN_SONOTAGEN.equals(ztyutiwakekbn)) {
                        ztykeijyouym = String.valueOf(syoriYmd.getBizDateYM());
                    }
                }
                String ztykydatkikbn = "";

                if (C_UmuKbn.NONE.eq(kykDairiten.getDrtenbunumu())) {
                    ztykydatkikbn = "0";
                }
                else if(C_UmuKbn.ARI.eq(kykDairiten.getDrtenbunumu())){

                    if (kykDairiten.getDrtenrenno() == 1) {
                        ztykydatkikbn = "1";
                    }
                    else {
                        ztykydatkikbn = "2";
                    }

                }
                String ztykykymd = "";
                if (kykSyouhn.getKykymd() == null) {
                    ztykykymd = "00000000";
                }
                else {
                    ztykykymd = String.valueOf(kykSyouhn.getKykymd());
                }

                CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(kykSyouhn.getKyktuukasyu());

                long ztyhsys = 0;
                BizNumber kawaseRate = null;
                BizCurrency kousinZenS = BizCurrency.valueOf(0, currencyType);
                BizCurrency kousinAtoS = BizCurrency.valueOf(0, currencyType);
                BizCurrency kousinZenHokenryou = BizCurrency.valueOf(0, currencyType);
                BizCurrency kousinAtoHokenryou = BizCurrency.valueOf(0, currencyType);
                BizCurrency enkansanAtoKousinZenS = BizCurrency.valueOf(0);
                BizCurrency enkansanAtoKousinAtoS = BizCurrency.valueOf(0);
                List<IT_KykSyouhnRireki> kykSyouhnRirekiLst = new ArrayList<IT_KykSyouhnRireki>();
                String kousinZenSyouhncd = "";
                String kousinAtoSyouhncd = "";
                Integer kousinZenSyouhnsdno = 0;
                Integer kousinAtoSyouhnsdno = 0;
                String kousinZenRyouritusdno = "";
                String kousinAtoRyouritusdno = "";
                BizNumber kousinZenYoteiriritu = null;
                BizNumber kousinAtoYoteiriritu = null;
                C_HknkknsmnKbn kousinZenHknkknsmnkbn = C_HknkknsmnKbn.BLNK;
                C_HknkknsmnKbn kousinAtoHknkknsmnkbn = C_HknkknsmnKbn.BLNK;
                Integer kousinZenHknkkn = 0;
                Integer kousinAtoHknkkn = 0;
                Integer kousinZenHrkkkn = 0;
                Integer kousinAtoHrkkkn = 0;
                Integer kousinZenHhknnen = 0;
                Integer kousinAtoHhknnen = 0;
                C_Hhknsei kousinZenHhknsei = C_Hhknsei.BLNK;
                C_Hhknsei kousinAtoHhknsei = C_Hhknsei.BLNK;
                BizDate kousinZenKykymd = null;
                BizDate kousinAtoKykymd = null;
                C_Tuukasyu kousinZentuukasyu = C_Tuukasyu.BLNK;
                C_Tuukasyu kousinAtotuukasyu = C_Tuukasyu.BLNK;
                BizNumber kousinZenKyksjkkktyouseiriritu = null;
                BizNumber kousinAtoKyksjkkktyouseiriritu = null;
                BizDate kousinZenyendthnkymd = null;
                BizDate kousinAtoyendthnkymd = null;
                BizNumber kousinZenTumitateriritu = null;
                BizNumber kousinAtoTumitateriritu = null;
                Integer kousinZendai1hknkkn = 0;
                Integer kousinAtodai1hknkkn = 0;

                if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN  == syohinHanteiKbn) {

                    if(PALUTIWAKEKBN_GENGAKU.equals(ztyutiwakekbn)){

                        kykSyouhnRirekiLst = hozenDomManager.getKykSyouhnRirekisByPk(
                            khTtdkRireki.getSyono(),
                            C_SyutkKbn.SYU,
                            kykSyouhn.getSyouhncd(),
                            kykSyouhn.getSyouhnsdno(),
                            kykSyouhn.getKyksyouhnrenno());

                        if(khTtdkRireki.getHenkousikibetukey().equals(kykSyouhn.getHenkousikibetukey())){

                            kousinZenS = kykSyouhnRirekiLst.get(0).getPharaikomisougaku();
                            kousinAtoS = kykSyouhn.getPharaikomisougaku();

                        }else{

                            for(int i=0; i < kykSyouhnRirekiLst.size(); i++){

                                if(khTtdkRireki.getHenkousikibetukey().equals(kykSyouhnRirekiLst.get(i).getHenkousikibetukey())){
                                    kousinZenS = kykSyouhnRirekiLst.get(i+1).getPharaikomisougaku();
                                    kousinAtoS = kykSyouhnRirekiLst.get(i).getPharaikomisougaku();
                                    break;
                                }
                            }
                        }

                        ztyhsys = new BigDecimal(kousinZenS.subtract(kousinAtoS).toAdsoluteString()).longValue();

                    }else{

                        kousinAtoS = kykSyouhn.getPharaikomisougaku();
                        ztyhsys = new BigDecimal(kousinAtoS.toAdsoluteString()).longValue();

                    }
                }


                else if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == syohinHanteiKbn ||
                    SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == syohinHanteiKbn ||
                    SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == syohinHanteiKbn) {

                    if (PALUTIWAKEKBN_GENGAKU.equals(ztyutiwakekbn)) {

                        kykSyouhnRirekiLst = hozenDomManager.getKykSyouhnRirekisByPk(
                            khTtdkRireki.getSyono(),
                            C_SyutkKbn.SYU,
                            syouhncd,
                            syouhnsdno,
                            kykSyouhn.getKyksyouhnrenno());

                        if (khTtdkRireki.getHenkousikibetukey().equals(kykSyouhn.getHenkousikibetukey())) {

                            kousinZenS = kykSyouhnRirekiLst.get(0).getKihons();
                            kousinAtoS = kykSyouhn.getKihons();
                        }
                        else {
                            for (int i = 0; i < kykSyouhnRirekiLst.size(); i++) {

                                if (khTtdkRireki.getHenkousikibetukey().equals(
                                    kykSyouhnRirekiLst.get(i).getHenkousikibetukey())) {

                                    kousinZenS = kykSyouhnRirekiLst.get(i + 1).getKihons();
                                    kousinAtoS = kykSyouhnRirekiLst.get(i).getKihons();
                                    break;
                                }
                            }
                        }
                    }
                    else if (shenkouari) {
                        kousinZenS = henkoumaekihonS;
                        kousinAtoS = henkouatokihonS;
                    }
                    else {
                        kousinAtoS = kykSyouhn.getKihons();
                    }
                }
                else {

                    if (PALUTIWAKEKBN_GENGAKU.equals(ztyutiwakekbn)) {
                        kykSyouhnRirekiLst = hozenDomManager.getKykSyouhnRirekisByPk(khTtdkRireki.getSyono(),
                            C_SyutkKbn.SYU,
                            syouhncd, syouhnsdno, kykSyouhn.getKyksyouhnrenno());

                        if (khTtdkRireki.getHenkousikibetukey().equals(kykSyouhn.getHenkousikibetukey())) {
                            kousinZenS = kykSyouhnRirekiLst.get(0).getKihons();
                            kousinAtoS = kykSyouhn.getKihons();
                            kousinZenHokenryou = kykSyouhnRirekiLst.get(0).getHokenryou();
                            kousinAtoHokenryou = kykSyouhn.getHokenryou();
                            kousinZenSyouhncd = kykSyouhnRirekiLst.get(0).getSyouhncd();
                            kousinAtoSyouhncd = kykSyouhn.getSyouhncd();
                            kousinZenSyouhnsdno = kykSyouhnRirekiLst.get(0).getSyouhnsdno();
                            kousinAtoSyouhnsdno = kykSyouhn.getSyouhnsdno();
                            kousinZenRyouritusdno = kykSyouhnRirekiLst.get(0).getRyouritusdno();
                            kousinAtoRyouritusdno = kykSyouhn.getRyouritusdno();
                            kousinZenYoteiriritu = kykSyouhnRirekiLst.get(0).getYoteiriritu();
                            kousinAtoYoteiriritu = kykSyouhn.getYoteiriritu();
                            kousinZenHknkknsmnkbn = kykSyouhnRirekiLst.get(0).getHknkknsmnkbn();
                            kousinAtoHknkknsmnkbn = kykSyouhn.getHknkknsmnkbn();
                            kousinZenHknkkn = kykSyouhnRirekiLst.get(0).getHknkkn();
                            kousinAtoHknkkn = kykSyouhn.getHknkkn();
                            kousinZenHrkkkn = kykSyouhnRirekiLst.get(0).getHrkkkn();
                            kousinAtoHrkkkn = kykSyouhn.getHrkkkn();
                            kousinZenHhknnen = kykSyouhnRirekiLst.get(0).getHhknnen();
                            kousinAtoHhknnen = kykSyouhn.getHhknnen();
                            kousinZenHhknsei = kykSyouhnRirekiLst.get(0).getHhknsei();
                            kousinAtoHhknsei = kykSyouhn.getHhknsei();
                            kousinZenKykymd = kykSyouhnRirekiLst.get(0).getKykymd();
                            kousinAtoKykymd = kykSyouhn.getKykymd();
                            kousinZentuukasyu = kykSyouhnRirekiLst.get(0).getKyktuukasyu();
                            kousinAtotuukasyu = kykSyouhn.getKyktuukasyu();
                            kousinZenKyksjkkktyouseiriritu = kykSyouhnRirekiLst.get(0).getKyksjkkktyouseiriritu();
                            kousinAtoKyksjkkktyouseiriritu = kykSyouhn.getKyksjkkktyouseiriritu();
                            kousinZenyendthnkymd = kykSyouhnRirekiLst.get(0).getYendthnkymd();
                            kousinAtoyendthnkymd = kykSyouhn.getYendthnkymd();
                            kousinZenTumitateriritu = kykSyouhnRirekiLst.get(0).getTumitateriritu();
                            kousinAtoTumitateriritu = kykSyouhn.getTumitateriritu();
                            kousinZendai1hknkkn = kykSyouhnRirekiLst.get(0).getDai1hknkkn();
                            kousinAtodai1hknkkn = kykSyouhn.getDai1hknkkn();
                        }
                        else {
                            for (int i = 0; i < kykSyouhnRirekiLst.size(); i++) {
                                if (khTtdkRireki.getHenkousikibetukey().equals(
                                    kykSyouhnRirekiLst.get(i).getHenkousikibetukey())) {
                                    kousinZenS = kykSyouhnRirekiLst.get(i + 1).getKihons();
                                    kousinAtoS = kykSyouhnRirekiLst.get(i).getKihons();
                                    kousinZenHokenryou = kykSyouhnRirekiLst.get(i+1).getHokenryou();
                                    kousinAtoHokenryou = kykSyouhnRirekiLst.get(i).getHokenryou();
                                    kousinZenSyouhncd = kykSyouhnRirekiLst.get(i+1).getSyouhncd();
                                    kousinAtoSyouhncd = kykSyouhnRirekiLst.get(i).getSyouhncd();
                                    kousinZenSyouhnsdno = kykSyouhnRirekiLst.get(i+1).getSyouhnsdno();
                                    kousinAtoSyouhnsdno = kykSyouhnRirekiLst.get(i).getSyouhnsdno();
                                    kousinZenRyouritusdno = kykSyouhnRirekiLst.get(i+1).getRyouritusdno();
                                    kousinAtoRyouritusdno = kykSyouhnRirekiLst.get(i).getRyouritusdno();
                                    kousinZenYoteiriritu = kykSyouhnRirekiLst.get(i+1).getYoteiriritu();
                                    kousinAtoYoteiriritu = kykSyouhnRirekiLst.get(i).getYoteiriritu();
                                    kousinZenHknkknsmnkbn = kykSyouhnRirekiLst.get(i+1).getHknkknsmnkbn();
                                    kousinAtoHknkknsmnkbn = kykSyouhnRirekiLst.get(i).getHknkknsmnkbn();
                                    kousinZenHknkkn = kykSyouhnRirekiLst.get(i+1).getHknkkn();
                                    kousinAtoHknkkn = kykSyouhnRirekiLst.get(i).getHknkkn();
                                    kousinZenHrkkkn = kykSyouhnRirekiLst.get(i+1).getHrkkkn();
                                    kousinAtoHrkkkn = kykSyouhnRirekiLst.get(i).getHrkkkn();
                                    kousinZenHhknnen = kykSyouhnRirekiLst.get(i+1).getHhknnen();
                                    kousinAtoHhknnen = kykSyouhnRirekiLst.get(i).getHhknnen();
                                    kousinZenHhknsei = kykSyouhnRirekiLst.get(i+1).getHhknsei();
                                    kousinAtoHhknsei = kykSyouhnRirekiLst.get(i).getHhknsei();
                                    kousinZenKykymd = kykSyouhnRirekiLst.get(i+1).getKykymd();
                                    kousinAtoKykymd = kykSyouhnRirekiLst.get(i).getKykymd();
                                    kousinZentuukasyu = kykSyouhnRirekiLst.get(i+1).getKyktuukasyu();
                                    kousinAtotuukasyu = kykSyouhnRirekiLst.get(i).getKyktuukasyu();
                                    kousinZenKyksjkkktyouseiriritu = kykSyouhnRirekiLst.get(i + 1)
                                        .getKyksjkkktyouseiriritu();
                                    kousinAtoKyksjkkktyouseiriritu = kykSyouhnRirekiLst.get(i)
                                        .getKyksjkkktyouseiriritu();
                                    kousinZenyendthnkymd = kykSyouhnRirekiLst.get(i+1).getYendthnkymd();
                                    kousinAtoyendthnkymd = kykSyouhnRirekiLst.get(i).getYendthnkymd();
                                    kousinZenTumitateriritu = kykSyouhnRirekiLst.get(i+1).getTumitateriritu();
                                    kousinAtoTumitateriritu = kykSyouhnRirekiLst.get(i).getTumitateriritu();
                                    kousinZendai1hknkkn = kykSyouhnRirekiLst.get(i+1).getDai1hknkkn();
                                    kousinAtodai1hknkkn = kykSyouhnRirekiLst.get(i).getDai1hknkkn();

                                    break;
                                }
                            }
                        }

                        BizNumber sjkkkTyouseiyouRiritu = null;
                        if (kykSyouhn.getYendthnkymd() != null && C_UmuKbn.NONE.eq(gengakudoujiyendate)) {

                        }
                        else {

                            GetSjkkktyouseiyouriritu getSjkkktyouseiyouriritu = SWAKInjector
                                .getInstance(GetSjkkktyouseiyouriritu.class);
                            GetSjkkktyouseiyourirituBean getSjkkktyouseiyourirituBean = SWAKInjector
                                .getInstance(GetSjkkktyouseiyourirituBean.class);

                            getSjkkktyouseiyourirituBean.setSyouhncd(kousinZenSyouhncd);
                            getSjkkktyouseiyourirituBean.setKijyunymd(syoriYmd);
                            getSjkkktyouseiyourirituBean.setHknkkn(kousinZenHknkkn);

                            C_ErrorKbn errorKbn = getSjkkktyouseiyouriritu.exec(getSjkkktyouseiyourirituBean);

                            if (!C_ErrorKbn.OK.eq(errorKbn)) {

                                throw new CommonBizAppException(MessageUtil.getMessage(
                                    PartMID_hozen.EIA1048,
                                    ResourceUtil.getApplicationResources().getString("sjkkktyouseiyouriritu"),
                                    kykKihon.getSyono()));
                            }

                            sjkkkTyouseiyouRiritu = getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu();
                        }

                        C_ErrorKbn errorKbnkousinZenS = calcHkShrKngk.exec(
                            kousinZenSyouhncd,
                            kousinZenSyouhnsdno,
                            kousinZenRyouritusdno,
                            kousinZenYoteiriritu,
                            kykKihon.getHrkkaisuu(),
                            kousinZenHknkknsmnkbn,
                            kousinZenHknkkn,
                            kousinZenHrkkkn,
                            kousinZenHhknnen,
                            kousinZenHhknsei,
                            kousinZenS,
                            kousinZenKykymd,
                            syoriYmd,
                            kykKihon.getSyono(),
                            kousinZentuukasyu,
                            kousinZendai1hknkkn,
                            C_SiinKbn.SP,
                            C_HokenkinsyuruiKbn.SBHOKENKIN,
                            kousinZenHokenryou,
                            sjkkkTyouseiyouRiritu,
                            kousinZenKyksjkkktyouseiriritu,
                            null,
                            null,
                            null,
                            kousinZenTumitateriritu,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            kykSyouhn.getKykjyoutai(),
                            kousinZenyendthnkymd,
                            kykKihon.getSdpdkbn(),
                            kykKihon.getHrkkeiro());

                        if (!C_ErrorKbn.OK.eq(errorKbnkousinZenS)) {
                            throw new CommonBizAppException(MessageUtil.getMessage(
                                PartMID_hozen.EIA1048,
                                ResourceUtil.getApplicationResources().getString("hokenkngk"),
                                kykKihon.getSyono()));
                        }

                        kousinZenS = calcHkShrKngk.getCalcHkShrKngkBean().getSibousGk();

                        C_ErrorKbn errorKbnkousinAtoS = calcHkShrKngk.exec(kousinAtoSyouhncd,
                            kousinAtoSyouhnsdno,
                            kousinAtoRyouritusdno,
                            kousinAtoYoteiriritu,
                            kykKihon.getHrkkaisuu(),
                            kousinAtoHknkknsmnkbn,
                            kousinAtoHknkkn,
                            kousinAtoHrkkkn,
                            kousinAtoHhknnen,
                            kousinAtoHhknsei,
                            kousinAtoS,
                            kousinAtoKykymd,
                            syoriYmd,
                            kykKihon.getSyono(),
                            kousinAtotuukasyu,
                            kousinAtodai1hknkkn,
                            C_SiinKbn.SP,
                            C_HokenkinsyuruiKbn.SBHOKENKIN,
                            kousinAtoHokenryou,
                            sjkkkTyouseiyouRiritu,
                            kousinAtoKyksjkkktyouseiriritu,
                            null,
                            null,
                            null,
                            kousinAtoTumitateriritu,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            kykSyouhn.getKykjyoutai(),
                            kousinAtoyendthnkymd,
                            kykKihon.getSdpdkbn(),
                            kykKihon.getHrkkeiro());

                        if (!C_ErrorKbn.OK.eq(errorKbnkousinAtoS)) {
                            throw new CommonBizAppException(MessageUtil.getMessage(
                                PartMID_hozen.EIA1048,
                                ResourceUtil.getApplicationResources().getString("hokenkngk"),
                                kykKihon.getSyono()));
                        }

                        kousinAtoS = calcHkShrKngk.getCalcHkShrKngkBean().getSibousGk();

                    }
                    else {

                        C_ErrorKbn errorKbn = calcHkShrKngk.execByKeisanWExt(
                            kykKihon.getSyono(),
                            syoriYmd,
                            C_SiinKbn.SP,
                            C_HokenkinsyuruiKbn.SBHOKENKIN,
                            kykKihon.getSdpdkbn(),
                            kykKihon.getHrkkeiro());

                        if (!C_ErrorKbn.OK.eq(errorKbn)) {
                            throw new CommonBizAppException(MessageUtil.getMessage(
                                PartMID_hozen.EIA1048,
                                ResourceUtil.getApplicationResources().getString("hokenkngk"),
                                kykKihon.getSyono()));
                        }

                        kousinAtoS = calcHkShrKngk.getCalcHkShrKngkBean().getSibousGk();
                    }
                }

                if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN  != syohinHanteiKbn) {
                    if (C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu()) && C_UmuKbn.NONE.eq(gengakudoujiyendate)) {
                        if (PALUTIWAKEKBN_GENGAKU.equals(ztyutiwakekbn) || shenkouari) {
                            if (PALUTIWAKEKBN_GENGAKU.equals(ztyutiwakekbn)) {
                                ztyhsys = new BigDecimal(kousinZenS.subtract(kousinAtoS).toAdsoluteString()).longValue();
                            }
                            else {
                                ztyhsys = new BigDecimal(kousinZenS.toAdsoluteString()).longValue();
                            }
                        }
                        else {
                            ztyhsys = new BigDecimal(kousinAtoS.toAdsoluteString()).longValue();
                        }
                    }
                    else {
                        BizDate kwsratekjymd = null;
                        if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == syohinHanteiKbn) {
                            kwsratekjymd = syoriYmd;
                        }
                        else {
                            kwsratekjymd = nyknJissekiRirekiLst.get(0).getRyosyuymd();
                        }

                        kawaseRate = getKawaserate(kwsratekjymd,
                            C_KawaserateSyuruiKbn.PM17JIKAWASERATE, motokyktuukasyu, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
                            C_KawasetsryKbn.JISSEIRATE, C_EigyoubiHoseiKbn.YOKUEIGYOUBI, C_YouhiKbn.HUYOU);

                        enkansanAtoKousinAtoS = keisanGaikakanzan.exec(
                            C_Tuukasyu.JPY,
                            kousinAtoS,
                            kawaseRate,
                            C_HasuusyoriKbn.SUTE);

                        if (PALUTIWAKEKBN_GENGAKU.equals(ztyutiwakekbn) || shenkouari) {
                            enkansanAtoKousinZenS = keisanGaikakanzan.exec(
                                C_Tuukasyu.JPY,
                                kousinZenS,
                                kawaseRate,
                                C_HasuusyoriKbn.SUTE);
                            if (PALUTIWAKEKBN_GENGAKU.equals(ztyutiwakekbn)) {
                                ztyhsys = new BigDecimal(enkansanAtoKousinZenS.subtract(enkansanAtoKousinAtoS).
                                    toAdsoluteString()).longValue();
                            }
                            else {
                                ztyhsys = new BigDecimal(enkansanAtoKousinZenS.toAdsoluteString()).longValue();
                            }
                        }
                        else {
                            ztyhsys = new BigDecimal(enkansanAtoKousinAtoS.toAdsoluteString()).longValue();
                        }
                    }
                }

                BizCurrency ztyhenkougohosyous = BizCurrency.valueOf(0);
                if (PALUTIWAKEKBN_GENGAKU.equals(ztyutiwakekbn) || shenkouari) {

                    ztyhenkougohosyous = kousinAtoS;
                    if (C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu()) && C_UmuKbn.NONE.eq(gengakudoujiyendate)) {

                    }
                    else {
                        ztyhenkougohosyous = keisanGaikakanzan.exec(
                            C_Tuukasyu.JPY,
                            ztyhenkougohosyous,
                            kawaseRate,
                            C_HasuusyoriKbn.SUTE);

                    }
                }
                else {
                    ztyhenkougohosyous = BizCurrency.valueOf(0);
                }

                long ztyharaikomip = 0;
                IT_KykSyouhnHnkmae kykSyouhnHnkmae = new IT_KykSyouhnHnkmae();

                if (C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())){
                    if (kykSyouhn.getYendthnkymd() != null) {

                        kykSyouhnHnkmae = bzHoyuuJyunzouZougenFSksDao.getKykSyouhnHnkmaeBySyono(kykKihon.getSyono());

                        if (C_Tuukasyu.JPY.eq(kykSyouhnHnkmae.getKyktuukasyu())) {

                            ztyharaikomip = new BigDecimal(kykSyouhnHnkmae.getHokenryou()
                                .toAdsoluteString()).longValue();

                        }
                        else {
                            if (C_Tuukasyu.JPY.eq(nyknJissekiRirekiLst.get(0).getRstuukasyu())) {

                                ztyharaikomip = new BigDecimal(nyknJissekiRirekiLst.get(0).getRsgaku()
                                    .toAdsoluteString()).longValue();
                            }
                            else {
                                BizDate kwsratekjymd = nyknJissekiRirekiLst.get(0).getRyosyuymd();

                                kawaseRate = getKawaserate(kwsratekjymd,
                                    C_KawaserateSyuruiKbn.PM17JIKAWASERATE, kykSyouhnHnkmae.getKyktuukasyu(), C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
                                    C_KawasetsryKbn.JISSEIRATE, C_EigyoubiHoseiKbn.YOKUEIGYOUBI, C_YouhiKbn.HUYOU);

                                ztyharaikomip = new BigDecimal(keisanGaikakanzan.exec(
                                    C_Tuukasyu.JPY,
                                    kykSyouhnHnkmae.getHokenryou(),
                                    kawaseRate,
                                    C_HasuusyoriKbn.SUTE).toAdsoluteString()).longValue();
                            }
                        }
                    }
                    else {
                        if (C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {

                            ztyharaikomip = new BigDecimal(kykSyouhn.getHokenryou()
                                .toAdsoluteString()).longValue();

                        }
                        else {
                            if (C_Tuukasyu.JPY.eq(nyknJissekiRirekiLst.get(0).getRstuukasyu())) {

                                ztyharaikomip = new BigDecimal(nyknJissekiRirekiLst.get(0).getRsgaku()
                                    .toAdsoluteString()).longValue();
                            }
                            else {
                                ztyharaikomip = new BigDecimal(keisanGaikakanzan.exec(
                                    C_Tuukasyu.JPY,
                                    kykSyouhn.getHokenryou(),
                                    kawaseRate,
                                    C_HasuusyoriKbn.SUTE).toAdsoluteString()).longValue();

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
                        ztyharaikomip = new BigDecimal(zennoup.toAdsoluteString()).longValue();
                    }
                    else if (syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
                        if (C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {
                            BizCurrency zennoup = itzennou.getZennounyuukinkgk().add(itzennou.getZennoujihrkp());
                            ztyharaikomip = new BigDecimal(zennoup.toAdsoluteString()).longValue();
                        }
                        else {
                            List<IT_KhTtdkRireki> ttdkRirekiList =
                                kykKihon.getKhTtdkRirekisByGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_GENGAKU);

                            if (ttdkRirekiList.size() == 0 && C_Tuukasyu.JPY.eq(nyknJissekiRirekiLst.get(0).getRstuukasyu())){
                                BizCurrency zennoup = itzennou.getZennounyuukinkgkrstk().add(nyknJissekiRirekiLst.get(0).getRsgaku()) ;
                                ztyharaikomip = new BigDecimal(zennoup.toAdsoluteString()).longValue();
                            }
                            else {
                                BizDate kwsratekjymd = nyknJissekiRirekiLst.get(0).getRyosyuymd();

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

                                ztyharaikomip = new BigDecimal(zennoujihrkpyen.add(zennounyuukinkgk).toAdsoluteString()).longValue();
                            }
                        }
                    }
                }
                else {
                    if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == syohinHanteiKbn) {
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
                        keisanIkkatuNkgBean.setJyuutoutuKisuu(Integer.valueOf(kykKihon.getTikiktbrisyuruikbn().toString()));
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

                        ztyharaikomip = new BigDecimal(keisanTukiIkkatuNyuukinGk.getIktnyknkgk().toAdsoluteString()).longValue();
                    }
                    else if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == syohinHanteiKbn) {
                        List<IT_KhTtdkRireki> ttdkRirekiList =
                            kykKihon.getKhTtdkRirekisByGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_GENGAKU);

                        if (ttdkRirekiList.size() == 0 && !kinouidSiharaiKekkaTorikomi.equals(khTtdkRireki.getGyoumuKousinKinou())) {
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

                                ztyharaikomip = new BigDecimal(sumRsgaku.toAdsoluteString()).longValue();

                            }

                        }
                        else {
                            if (C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {

                                ztyharaikomip = new BigDecimal(kykSyouhn.getHokenryou().toAdsoluteString()).longValue();
                            }
                            else {
                                if (C_Tuukasyu.USD.eq(kykSyouhn.getKyktuukasyu())) {
                                    nyuukinyouRateLastmonth = nyuukinyouRateLastmonthUSD;
                                }
                                else {
                                    nyuukinyouRateLastmonth = nyuukinyouRateLastmonthAUD;
                                }

                                ztyharaikomip = new BigDecimal(keisanGaikakanzan.exec(
                                    C_Tuukasyu.JPY,
                                    kykSyouhn.getHokenryou(),
                                    nyuukinyouRateLastmonth,
                                    C_HasuusyoriKbn.AGE).toAdsoluteString()).longValue();
                            }
                        }
                    }
                }

                long ztykaiyakusiharaikngk = 0;
                if (PALUTIWAKEKBN_KAIYAKU.equals(ztyutiwakekbn)) {
                    if (khShrRireki == null) {
                        ztykaiyakusiharaikngk = 0;
                    }
                    else {
                        if (C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {
                            ztykaiyakusiharaikngk = new BigDecimal(
                                khShrRireki.getShrtuukashrgkgoukei().toAdsoluteString()).longValue();
                        }
                        else {
                            BizDate kwsratekjymd = null;
                            if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == syohinHanteiKbn) {
                                kwsratekjymd = syoriYmd;
                            }
                            else {
                                kwsratekjymd = nyknJissekiRirekiLst.get(0).getRyosyuymd();
                            }

                            kawaseRate = getKawaserate(kwsratekjymd,
                                C_KawaserateSyuruiKbn.PM17JIKAWASERATE, kykSyouhn.getKyktuukasyu(), C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
                                C_KawasetsryKbn.JISSEIRATE, C_EigyoubiHoseiKbn.YOKUEIGYOUBI, C_YouhiKbn.HUYOU);

                            ztykaiyakusiharaikngk = new BigDecimal(keisanGaikakanzan.exec(
                                C_Tuukasyu.JPY,
                                khShrRireki.getShrtuukashrgkgoukei(),
                                kawaseRate,
                                C_HasuusyoriKbn.SUTE).toAdsoluteString()).longValue();
                        }
                    }
                }
                else {
                    ztykaiyakusiharaikngk = 0;
                }

                String ztyhrkkaisuukbn = "";
                if(C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())){
                    ztyhrkkaisuukbn = "0";
                }

                else if(C_Kykjyoutai.ZENNOU.eq(kykSyouhn.getKykjyoutai())){
                    ztyhrkkaisuukbn = "1";
                }
                else {
                    if(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(kykKihon.getTikiktbrisyuruikbn()) ||
                        C_Hrkkaisuu.HALFY.eq(kykKihon.getHrkkaisuu())){
                        ztyhrkkaisuukbn = "2";
                    }
                    else if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(kykKihon.getTikiktbrisyuruikbn()) ||
                        C_Hrkkaisuu.NEN.eq(kykKihon.getHrkkaisuu())){
                        ztyhrkkaisuukbn = "1";
                    }else{
                        ztyhrkkaisuukbn = "3";
                    }
                }


                String ztyhrkkeirokbn = "";
                KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(
                    kykKihon.getHrkkeiro().toString(),
                    C_Hrkkeiro.class,
                    C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

                if(kbnInfoBean.isHenkanFlg()){

                    ztyhrkkeirokbn = kbnInfoBean.getKbnData();

                }else{
                    throw new CommonBizAppException(MessageUtil.getMessage(
                        PartMID_hozen.EIA1046,
                        ResourceUtil.getApplicationResources().getString("hrkkeiro"),
                        kykKihon.getHrkkeiro().toString()));
                }


                String ztyannaifuyouriyuukbn = "";
                if(C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())){

                    ztyannaifuyouriyuukbn = "01";
                }
                else if(C_Kykjyoutai.ZENNOU.eq(kykSyouhn.getKykjyoutai())){

                    ztyannaifuyouriyuukbn = "07";
                }
                else{

                    ztyannaifuyouriyuukbn = "00";
                }

                String jkipjytYmd = ansyuKihon.getJkipjytym().toString();

                String ztysikkounyknkaisuu = "00";
                int hrkkaisuu = 0;
                if (PALUTIWAKEKBN_SIKKOU.equals(ztyutiwakekbn)) {

                    int keikatukisuu = BizDateUtil.calcDifferenceMonths(
                        kykSyouhn.getKykymd().getBizDateYM(), ansyuKihon.getJkipjytym());

                    if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == syohinHanteiKbn) {
                        hrkkaisuu = Integer.valueOf(kykKihon.getTikiktbrisyuruikbn().getValue());
                    }
                    else {
                        hrkkaisuu = Integer.valueOf(kykKihon.getHrkkaisuu().getValue());
                    }

                    ztysikkounyknkaisuu = String.valueOf(keikatukisuu / hrkkaisuu);
                }

                String ztykzktourokuservicearihyj = "0";
                List<IT_TrkKzk> itTrkKzkList = kykKihon.getTrkKzks();
                if (itTrkKzkList.size() > 0){
                    ztykzktourokuservicearihyj = "1";
                }

                String siteituukakbn = "0";
                if (kykSyouhn.getYendthnkymd() != null) {
                    if (C_Tuukasyu.USD.eq(kykSyouhnHnkmae.getKyktuukasyu())) {
                        siteituukakbn = "1";
                    }
                    else if (C_Tuukasyu.AUD.eq(kykSyouhnHnkmae.getKyktuukasyu())) {
                        siteituukakbn = "2";
                    }
                }
                else {
                    if (C_Tuukasyu.USD.eq(kykSyouhn.getKyktuukasyu())) {
                        siteituukakbn = "1";
                    }
                    else if (C_Tuukasyu.AUD.eq(kykSyouhn.getKyktuukasyu())) {
                        siteituukakbn = "2";
                    }
                }


                hoyuuJyunzouZougenFTy.setZtysequenceno(syoriKensu + 1);
                hoyuuJyunzouZougenFTy.setZtytantoukojincd(kykDairiten.getDaibosyuucd());
                hoyuuJyunzouZougenFTy.setZtytantousyasetteiym(String.valueOf(kykKihon.getBosyuuym()));
                hoyuuJyunzouZougenFTy.setZtykeijyousakikbn("0");
                hoyuuJyunzouZougenFTy.setZtykeijyousakisosiki(ztykeijyousakisosiki);
                hoyuuJyunzouZougenFTy.setZtykeijyouym(ztykeijyouym);
                hoyuuJyunzouZougenFTy.setZtydenymd(ztydenymd);
                hoyuuJyunzouZougenFTy.setZtyutiwakekbn(ztyutiwakekbn);
                hoyuuJyunzouZougenFTy.setZtytantoukeiyakukbn("1");
                hoyuuJyunzouZougenFTy.setZtykydatkikbn(ztykydatkikbn);
                hoyuuJyunzouZougenFTy.setZtysyono(kykKihon.getSyono());
                hoyuuJyunzouZougenFTy.setZtybsyym(String.valueOf(kykKihon.getBosyuuym()));
                hoyuuJyunzouZougenFTy.setZtykykymd(ztykykymd);
                hoyuuJyunzouZougenFTy.setZtysaisinbsyym(String.valueOf(kykKihon.getBosyuuym()));
                hoyuuJyunzouZougenFTy.setZtyhknsyukigou(syouhncd.substring(0, 2));
                hoyuuJyunzouZougenFTy.setZtymaruteisyuruikigou("");
                hoyuuJyunzouZougenFTy.setZtyyobin3(0);
                hoyuuJyunzouZougenFTy.setZtyyobiv1("0");
                hoyuuJyunzouZougenFTy.setZtyyobiv1x2("0");
                hoyuuJyunzouZougenFTy.setZtykykniyutksytioukbn("0");
                hoyuuJyunzouZougenFTy.setZtyyobiv1x3("0");
                hoyuuJyunzouZougenFTy.setZtyteisyuuhyj("0");
                hoyuuJyunzouZougenFTy.setZtyitijibryourouhyj("0");
                hoyuuJyunzouZougenFTy.setZtymrtihukahyj("0");
                hoyuuJyunzouZougenFTy.setZtyseizonmrtihukahyj("0");
                hoyuuJyunzouZougenFTy.setZtyteigenmrtihukahyj("0");
                hoyuuJyunzouZougenFTy.setZtysynymrtihukahyj("0");
                hoyuuJyunzouZougenFTy.setZtylivingneedstkykarihyj("0");
                hoyuuJyunzouZougenFTy.setZtyreguardmrtihukahyj("0");
                hoyuuJyunzouZougenFTy.setZtyreguardmrsyuhukahyj("0");
                hoyuuJyunzouZougenFTy.setZtyvguardmrtihukahyj("0");
                hoyuuJyunzouZougenFTy.setZtykaigonktkykhukahyj("0");
                hoyuuJyunzouZougenFTy.setZtygoukeisisttkyktkknsnp(0L);
                hoyuuJyunzouZougenFTy.setZtyhsys(ztyhsys);
                hoyuuJyunzouZougenFTy.setZtykensuun3(BizNumber.ONE);
                hoyuuJyunzouZougenFTy.setZtyhenkougohosyous(new BigDecimal(ztyhenkougohosyous.toAdsoluteString())
                .longValue());
                hoyuuJyunzouZougenFTy.setZtyhtns(0L);
                hoyuuJyunzouZougenFTy.setZtyharaikomip(ztyharaikomip);
                hoyuuJyunzouZougenFTy.setZtykaiyakusiharaikngk(ztykaiyakusiharaikngk);
                hoyuuJyunzouZougenFTy.setZtyhrkkaisuukbn(ztyhrkkaisuukbn);
                hoyuuJyunzouZougenFTy.setZtyhrkkeirokbn(ztyhrkkeirokbn);
                hoyuuJyunzouZougenFTy.setZtyannaifuyouriyuukbn(ztyannaifuyouriyuukbn);
                hoyuuJyunzouZougenFTy.setZtyanniskcd("00000000");
                hoyuuJyunzouZougenFTy.setZtytenkankaisuu("0");
                hoyuuJyunzouZougenFTy.setZtysikkounyknkaisuu(ztysikkounyknkaisuu);
                hoyuuJyunzouZougenFTy.setZtyyobiv2("00");
                if (kykSyouhn.getHhknnen() < 100) {
                    if (kykSyouhn.getHhknnen() < 10) {
                        hoyuuJyunzouZougenFTy.setZtyhhknnen2keta(Strings.padStart(
                            String.valueOf(kykSyouhn.getHhknnen()),
                            2, '0'));
                    }
                    else {
                        hoyuuJyunzouZougenFTy.setZtyhhknnen2keta(String.valueOf(kykSyouhn.getHhknnen()));
                    }
                }
                else {
                    hoyuuJyunzouZougenFTy.setZtyhhknnen2keta("99");
                }
                hoyuuJyunzouZougenFTy.setZtyhhknseikbn(hhknSya.getHhknsei().getValue());
                hoyuuJyunzouZougenFTy.setZtykjkyknm(kykSya.getKyknmkj());
                hoyuuJyunzouZougenFTy.setZtytsinkihontikucd("");
                hoyuuJyunzouZougenFTy.setZtyhjnkykhyj("0");
                hoyuuJyunzouZougenFTy.setZtyhjncd("000000000");
                hoyuuJyunzouZougenFTy.setZtyhjnjigyosyocd("");
                hoyuuJyunzouZougenFTy.setZtysyorisosikicd("0000000");
                hoyuuJyunzouZougenFTy.setZtytikusyokansisyakijyhyj("0");
                hoyuuJyunzouZougenFTy.setZtykeizokutyuuihyouji("0");
                hoyuuJyunzouZougenFTy.setZtytyohkkeiyakutyuuikbn("0");
                hoyuuJyunzouZougenFTy.setZtyyobiv1x4("0");
                hoyuuJyunzouZougenFTy.setZtydantaisyozokucd("");
                hoyuuJyunzouZougenFTy.setZtysuperknkuseikatupackhyj("0");
                hoyuuJyunzouZougenFTy.setZtyjikokykhyj("0");
                hoyuuJyunzouZougenFTy.setZtykikeiyakutyuuihyouji("0");
                hoyuuJyunzouZougenFTy.setZtysyuuseis(0L);
                hoyuuJyunzouZougenFTy.setZtyclubsumiseikaiinkykkbn("0");
                hoyuuJyunzouZougenFTy.setZtygatkihmkknrkmaekykhyj("0");
                hoyuuJyunzouZougenFTy.setZtygatkisetteikouhokykhyj("0");
                if (BizDateUtil.compareYm(BizDateYM.valueOf(hoyuuJyunzouZougenFTy.getZtybsyym()).addMonths(25),
                    syoriYmd.getBizDateYM()) == BizDateUtil.COMPARE_LESSER ||
                    BizDateUtil.compareYm(BizDateYM.valueOf(hoyuuJyunzouZougenFTy.getZtybsyym()).addMonths(25),
                        syoriYmd.getBizDateYM()) == BizDateUtil.COMPARE_EQUAL) {
                    hoyuuJyunzouZougenFTy.setZtybosyuu25keikahyj("1");
                }
                else {
                    hoyuuJyunzouZougenFTy.setZtybosyuu25keikahyj("0");
                }
                hoyuuJyunzouZougenFTy.setZtytokuteidaisyokudanhyj("0");
                hoyuuJyunzouZougenFTy.setZtyhoyuuikantsgkykhyj("0");
                hoyuuJyunzouZougenFTy.setZtytokubeturuletikuhyj("0");
                hoyuuJyunzouZougenFTy.setZtyfieldtantousyaarihyj("0");
                hoyuuJyunzouZougenFTy.setZtyyobiv1x5("0");
                hoyuuJyunzouZougenFTy.setZtycatkihmkknrkmaekykhyj("0");
                hoyuuJyunzouZougenFTy.setZtycatkisetteikouhokykhyj("0");
                hoyuuJyunzouZougenFTy.setZtyseppankeijyoukbn(ztykydatkikbn);
                hoyuuJyunzouZougenFTy.setZtyyobiv6("000000");
                hoyuuJyunzouZougenFTy.setZtyfollowtantousyakbn("00");
                hoyuuJyunzouZougenFTy.setZtyyobiv7("0000000");
                hoyuuJyunzouZougenFTy.setZtyhosyouminaosikaisuuv2("00");
                hoyuuJyunzouZougenFTy.setZtybnkttnknkbn("0");
                hoyuuJyunzouZougenFTy.setZtytenkangosyono("00000000000");
                hoyuuJyunzouZougenFTy.setZtyqpackhyj("0");
                hoyuuJyunzouZougenFTy.setZtytenkangoqpackhyj("0");
                hoyuuJyunzouZougenFTy.setZtysyuruihnkutkbttrtkhyj("0");
                hoyuuJyunzouZougenFTy.setZtytnkngsyuhnkutkbttrtkhyj("0");
                hoyuuJyunzouZougenFTy.setZtyyobin11(0L);
                hoyuuJyunzouZougenFTy.setZtykibanhikitugikbn("0");
                hoyuuJyunzouZougenFTy.setZtyyobiv1x6("0");
                hoyuuJyunzouZougenFTy.setZtysyoumetucd("0000");
                hoyuuJyunzouZougenFTy.setZtyjikaipjyuutouym(jkipjytYmd);
                hoyuuJyunzouZougenFTy.setZtykaigomarusyuuhukahyj("0");
                hoyuuJyunzouZougenFTy.setZtyyobiv1x7("0");
                hoyuuJyunzouZougenFTy.setZtysyoritorikesihyj("0");
                hoyuuJyunzouZougenFTy.setZtymrtikousinkatakbn("");
                hoyuuJyunzouZougenFTy.setZtypmenkbnv1("");
                hoyuuJyunzouZougenFTy.setZtysyukeiyakutkknsnp(0L);
                hoyuuJyunzouZougenFTy.setZtynenkansanp(0L);
                hoyuuJyunzouZougenFTy.setZtydai3bunyanenkansanp(0L);
                hoyuuJyunzouZougenFTy.setZtynyuuintkykhukahyj("0");
                hoyuuJyunzouZougenFTy.setZtynyuuintkykhukahyj20ijyou("0");
                hoyuuJyunzouZougenFTy.setZtynyuuintkykhukahyj5ijyou("0");
                hoyuuJyunzouZougenFTy.setZtymarusyotkykhukahyj("0");
                hoyuuJyunzouZougenFTy.setZtymarujyuutkykhukahyj("0");
                hoyuuJyunzouZougenFTy.setZtykakudaimaruitkykhukahyj("0");
                hoyuuJyunzouZougenFTy.setZtykakunyuutkykhukahyj("0");
                hoyuuJyunzouZougenFTy.setZtymaruitkykhukahyj("0");
                hoyuuJyunzouZougenFTy.setZtystdairiseikyuutkykarihyj(kykSonotaTkyk.getStdrsktkyhkumu().getValue());
                hoyuuJyunzouZougenFTy.setZtykensuuyuuguukbn("0");
                hoyuuJyunzouZougenFTy.setZtykaigosynyteikikbn("0");
                hoyuuJyunzouZougenFTy.setZtykaigosynyteikishrkskbn("0");
                hoyuuJyunzouZougenFTy.setZtygyousekibosyujisikakucd("");
                hoyuuJyunzouZougenFTy.setZtygyskboshtnsineiyksnkbn("");
                hoyuuJyunzouZougenFTy.setZtysiktsynymrtihukahyj("0");
                hoyuuJyunzouZougenFTy.setZtysiktsynyteikikbn("0");
                hoyuuJyunzouZougenFTy.setZtyseikatusyuunyuumrtis(0L);
                hoyuuJyunzouZougenFTy.setZtylivguardhukahyj("0");
                hoyuuJyunzouZougenFTy.setZtylivguards(0L);
                hoyuuJyunzouZougenFTy.setZtyknkuzusnzyrttekitkarihyj("0");
                hoyuuJyunzouZougenFTy.setZtybluekzjtkaisiymd("00000000");
                hoyuuJyunzouZougenFTy.setZtyknkuzusnzyrtstkbn("");
                hoyuuJyunzouZougenFTy.setZtykykdrtkykarihyj(kykSonotaTkyk.getKykdrtkykhukaumu().getValue());
                hoyuuJyunzouZougenFTy.setZtykzktourokuservicearihyj(ztykzktourokuservicearihyj);
                hoyuuJyunzouZougenFTy.setZtysiteituukakbn(siteituukakbn);

                BizPropertyInitializer.initialize(hoyuuJyunzouZougenFTy);

                BzHoyuuJyunzouZougenFSksConverter.convertPadding(hoyuuJyunzouZougenFTy);

                hoyuuJyunzouZougenFTyInserter.add(hoyuuJyunzouZougenFTy);

                syoriKensu = syoriKensu + 1;
            }
        }
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensu), kinou.getKinouNm()));
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
