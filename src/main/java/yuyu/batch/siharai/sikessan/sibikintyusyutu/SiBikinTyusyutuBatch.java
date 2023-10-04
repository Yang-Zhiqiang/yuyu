package yuyu.batch.siharai.sikessan.sibikintyusyutu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateMD;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetSousasyaSyozokuSosikiData;
import yuyu.common.biz.bzcommon.BzGetSousasyaSyozokuSosikiDataBean;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.hozen.khcommon.SetKessanNensibi;
import yuyu.common.siharai.edittbl.SiSiDetailParamBean;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuPrm;
import yuyu.common.siharai.sicommon.CalcSeisankgk;
import yuyu.common.siharai.sicommon.JisatuMensekiKikanHantei;
import yuyu.common.siharai.sicommon.SiDetailMisyuupBean;
import yuyu.common.siharai.sicommon.SiSiharaiKingakuKeisan;
import yuyu.common.siharai.sicommon.SiSiharaiKingakuKeisanBean;
import yuyu.common.siharai.sicommon.Siinhantei;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.detacher.BM_SyouhnZokuseiDetacher;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_Bnshrkaisuu;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_HasuukasanUmuKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HubiJyoukyouKbn;
import yuyu.def.classification.C_HushrGeninKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_NayoseYouhi;
import yuyu.def.classification.C_NkHaitoukinuketorihouKbn;
import yuyu.def.classification.C_NoinitUmuKbn;
import yuyu.def.classification.C_Nstknsyu;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SeisankinKanritukaKbn;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_SiHonninKakninKekkaKbn;
import yuyu.def.classification.C_SiharaiTuukaKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SikinouModeIdKbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyouhnsyuruiKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.JM_Kyuuhu;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.def.db.entity.JT_MisyuupMkkpDetail;
import yuyu.def.db.entity.JT_SateiSyouninRireki;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.entity.JT_SiDetail;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.entity.JT_SibouKariuketsuke;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkJiyuu;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.JT_TtdkRireki;
import yuyu.def.siharai.configuration.YuyuSiharaiConfig;
import yuyu.def.siharai.detacher.JM_KyuuhuDetacher;
import yuyu.def.siharai.detacher.JM_SiSyouhnZokuseiDetacher;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

/**
 * 保険金給付金支払 決算 保険金給付金備金抽出
 */
public class SiBikinTyusyutuBatch implements Batch {

    private static final String TABLE_ID = "JT_SkKihon";

    private static final String IB_RECOVERY_FILTER_ID = "Si001";

    private static final Integer UKETUKENO = 1;

    private static final Integer UKTBNWARI = 100;

    private static final String SAIGAI = "SS";

    private static final String BIKINGAITOINFO_SYORISUMI = "1";
    private static final String BIKINGAITOINFO_UKETUKE_HUBI_NASI = "2";
    private static final String BIKINGAITOINFO_UKETUKE_HUBI_ARI = "3";
    private static final String BIKINGAITOINFO_SEIKYUSYOMATI = "4";
    private static final String BIKINGAITOINFO_KARIUKETUKE = "5";
    private static final String BIKINGAITOINFO_KESSANKIMATUYMDGO_SIHARAISUMI = "6";

    private static final C_Syoumetujiyuu[] HOKENKIN_SYOUMETUJIYUU = { C_Syoumetujiyuu.SIBOU,
        C_Syoumetujiyuu.SIBOUSAIGAIHIGAITOU, C_Syoumetujiyuu.SIBOUSAIGAIMENSEKI, C_Syoumetujiyuu.MENSEKI,
        C_Syoumetujiyuu.SBKAIJO, C_Syoumetujiyuu.SBMUKOU, C_Syoumetujiyuu.SIBOUKYUUHUKINSHR, C_Syoumetujiyuu.JIKOU };

    private static final BizDateMD HONKESSAN_KIJUNBI = BizDateMD.valueOf("0331");

    private static final int BIKINTAISHO_KEIKANENDO = 3;

    private String sysTime;

    private BizDate hoseiKessanKimatuYmd;

    private BizCurrency bkngk;

    private BizDate shrkwsratekjnymd;

    private BizNumber shrkwsrate;

    private BizDate ksnbiymd;

    private C_UmuKbn zennouseisankinumukbn;

    private BizCurrency zennouseisankgk;

    private BizCurrency yenkazennouseisankgk;

    private C_UmuKbn mikeikapumukbn;

    private BizCurrency mikeikap;

    private BizCurrency yenkamikeikap;

    private C_UmuKbn misyuupumukbn;

    private BizDateYM misyuupjyuutouym;

    private BizCurrency hrkp;

    private BizCurrency misyuup;

    private BizCurrency yenkamisyuup;

    private C_Hrkkaisuu hrkkaisuu;

    private BizCurrency syonendojikaiikoup;

    private BizCurrency yenkasyonendojikaiikoup;

    private BizCurrency jinendoikoup;

    private BizCurrency yenkajinendoikoup;

    private HashMap<String, JM_Kyuuhu> jmKyuuhuMap;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam batchParam;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = batchParam.getSyoriYmd();

        String kakutyoujobcd = batchParam.getIbKakutyoujobcd();

        long syoriKensuu = 0L;

        List<String> bikinSyuuseiDataLst = Lists.newArrayList();

        List<String> kariuketsukeRegistDataLst = Lists.newArrayList();

        sysTime = BizDate.getSysDateTimeMilli();

        jmKyuuhuMap = new HashMap<String, JM_Kyuuhu>();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        if (syoriYmd.getDay() <= 15) {
            ksnbiymd = syoriYmd.getPreviousMonth().getBizDateYM().getLastDay();
        } else {
            ksnbiymd = syoriYmd.getBizDateYM().getLastDay();
        }

        hoseiKessanKimatuYmd = hoseiKessankimatubi();

        List<JT_SiBikinkanri> siBikinkanriLst = siharaiDomManager.getSiBikinkanrisByKessankijyunymdBknrigikbnNe(
            ksnbiymd, C_BknrigiKbn.BLNK);

        for (JT_SiBikinkanri siBikinkanri : siBikinkanriLst) {

            bikinSyuuseiDataLst.add(editListKey(siBikinkanri.getSkno(), siBikinkanri.getSyono()));
        }

        List<JT_SiBikinkanri> siBikinkanriDelLst = siharaiDomManager.getSiBikinkanrisByKessankijyunymdBknrigikbn(
            ksnbiymd, C_BknrigiKbn.BLNK);

        siharaiDomManager.delete(siBikinkanriDelLst);

        siharaiDomManager.flush();

        try (ExDBResults<JT_SkKihon> skKihonExDBResults = siharaiDomManager
            .getSkKihonsByKakutyoujobcdSeikyuusyubetuItemsSaisateikbn(
                kakutyoujobcd, C_SeikyuuSyubetu.SB, ksnbiymd, C_SaisateiKbn.BLNK, ksnbiymd, ksnbiymd);
            EntityInserter<JT_SiBikinkanri> siBikinkanriEntityInserter = new EntityInserter<>()) {

            for (JT_SkKihon skKihon : skKihonExDBResults) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobcd);

                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(IB_RECOVERY_FILTER_ID);

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(skKihon.getSyono());

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(skKihon.getSkno());

                if (calcBknKeikaNendo(ksnbiymd, skKihon.getSiboukaritrkymd()) > BIKINTAISHO_KEIKANENDO) {
                    continue;
                }

                C_UmuKbn bikinSyuuseiDataUmu = bkSyuuseiDataUmuChk(skKihon.getSkno(), skKihon.getSyono(), bikinSyuuseiDataLst);

                if (C_UmuKbn.ARI.eq(bikinSyuuseiDataUmu)) {

                    continue;
                }

                String maxShrsikibetukey =
                    siharaiDomManager.getSiRirekiMaxShrsikibetukeyBySknoSyono(skKihon.getSkno(), skKihon.getSyono());

                if (maxShrsikibetukey != null) {

                    JT_SiRireki siRireki = skKihon.getSiRirekiByShrsikibetukey(maxShrsikibetukey);
                    JT_Sk sk = skKihon.getSkBySeikyuurirekino(siRireki.getSeikyuurirekino());

                    if (isAfterKessanKimatuYmd(sk.getSyoruiukeymd(), sk.getHubikanryouymd())) {

                        List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyonoSibouKariuketsuke(skKihon
                            .getSyono());
                        if (skKihonLst.size() > 0) {
                            syoriKensuu = syoriKensuu
                                + preSkUktkBkkanriTouroku(skKihon, skKihonLst.get(0).getSibouKariuketsuke(),
                                    BIKINGAITOINFO_KESSANKIMATUYMDGO_SIHARAISUMI, sk, maxShrsikibetukey, siBikinkanriEntityInserter);
                        }

                    } else {
                        syoriKensuu = syoriKensuu
                            + afterBkkanriTouroku(skKihon, maxShrsikibetukey, siBikinkanriEntityInserter);
                    }

                }
                else {

                    Integer seikyuuRirekiNo =
                        siharaiDomManager.getSkMaxSeikyuurirekinoBySknoSyono(skKihon.getSkno(), skKihon.getSyono());

                    if (seikyuuRirekiNo != null) {
                        JT_Sk sk = skKihon.getSkBySeikyuurirekino(seikyuuRirekiNo);

                        if (isAfterKessanKimatuYmd(sk.getSyoruiukeymd(), sk.getHubikanryouymd())) {

                            List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyonoSibouKariuketsuke(skKihon
                                .getSyono());
                            if (skKihonLst.size() > 0) {
                                syoriKensuu = syoriKensuu
                                    + preSkUktkBkkanriTouroku(skKihon, skKihonLst.get(0).getSibouKariuketsuke(),
                                        BIKINGAITOINFO_SEIKYUSYOMATI, sk, siBikinkanriEntityInserter);
                            }

                        } else {

                            if (!C_HubiJyoukyouKbn.HUBI.eq(skKihon.getHubijyoukyoukbn())) {

                                syoriKensuu = syoriKensuu
                                    + afterSkUktkBkkanriTouroku(skKihon, seikyuuRirekiNo, siBikinkanriEntityInserter);
                            } else {
                                List<JT_SkKihon> skKihonLst = siharaiDomManager
                                    .getSkKihonsBySyonoSibouKariuketsuke(skKihon.getSyono());
                                if (skKihonLst.size() > 0) {
                                    syoriKensuu = syoriKensuu
                                        + preSkUktkBkkanriTouroku(skKihon, skKihonLst.get(0).getSibouKariuketsuke(),
                                            BIKINGAITOINFO_UKETUKE_HUBI_ARI, sk, siBikinkanriEntityInserter);
                                }
                            }

                        }

                    } else {
                        List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyonoSibouKariuketsuke(skKihon
                            .getSyono());

                        if (isSyorityuu(skKihon.getSkno(), skKihon.getSyono())) {
                            syoriKensuu = syoriKensuu
                                + preSkUktkBkkanriTouroku(skKihon, skKihonLst.get(0).getSibouKariuketsuke(),
                                    BIKINGAITOINFO_SEIKYUSYOMATI, siBikinkanriEntityInserter);
                        } else {

                            if (!isExistSyorityuuOrKanryou(skKihon.getSyono()) && skKihonLst.size() > 0) {

                                JT_SkKihon skKihonForKariuketsuke = skKihonLst.get(0);
                                String keyInfo = editListKey(skKihonForKariuketsuke.getSkno(),
                                    skKihonForKariuketsuke.getSyono());

                                if (!kariuketsukeRegistDataLst.contains(keyInfo)) {
                                    syoriKensuu = syoriKensuu
                                        + preSkUktkBkkanriTouroku(skKihonForKariuketsuke,
                                            skKihonForKariuketsuke.getSibouKariuketsuke(),
                                            BIKINGAITOINFO_KARIUKETUKE, siBikinkanriEntityInserter);
                                    kariuketsukeRegistDataLst.add(keyInfo);
                                }
                            }
                        }
                    }
                }
            }
            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        try (ExDBResults<JT_SkKihon> skKihonExDBResults = siharaiDomManager.getSkKihonsByKakutyoujobcdSeikyuusyubetusItem(
            kakutyoujobcd, C_SeikyuuSyubetu.SBKRUKTK, C_SeikyuuSyubetu.SB, ksnbiymd);
            EntityInserter<JT_SiBikinkanri> siBikinkanriEntityInserter = new EntityInserter<>()) {

            for (JT_SkKihon skKihon : skKihonExDBResults) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobcd);

                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(IB_RECOVERY_FILTER_ID);

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(skKihon.getSyono());

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(skKihon.getSkno());

                C_UmuKbn bikinSyuuseiDataUmu = bkSyuuseiDataUmuChk(skKihon.getSkno(), skKihon.getSyono(), bikinSyuuseiDataLst);

                if (calcBknKeikaNendo(ksnbiymd, skKihon.getSiboukaritrkymd()) > BIKINTAISHO_KEIKANENDO) {
                    continue;
                }

                if (C_UmuKbn.ARI.eq(bikinSyuuseiDataUmu)) {

                    continue;
                }

                if (C_UmuKbn.NONE.eq(skKihon.getSibouKariuketsuke().getTorikesiflg())) {
                    syoriKensuu = syoriKensuu
                        + preSkUktkBkkanriTouroku(skKihon, skKihon.getSibouKariuketsuke(),
                            BIKINGAITOINFO_KARIUKETUKE, siBikinkanriEntityInserter);
                }
            }
            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), kinou.getKinouNm()));
    }

    private Long afterBkkanriTouroku(JT_SkKihon pSkKihon, String pSiharaisikibetuki,
        EntityInserter<JT_SiBikinkanri> pSiBikinkanriEntityInserter) {

        Long kousinKensuu = 0L;

        JT_SiRireki siRireki = pSkKihon.getSiRirekiByShrsikibetukey(pSiharaisikibetuki);

        JT_Sk sk = pSkKihon.getSkBySeikyuurirekino(siRireki.getSeikyuurirekino());

        JT_SkJiyuu skJiyuu = sk.getSkJiyuuByUketukeno(UKETUKENO);

        List<JT_SiDetail> siDetailLst = skJiyuu.getSiDetails();

        List<JT_SateiSyouninRireki> sateiSyouninRirekilst = pSkKihon.getSateiSyouninRirekisBySeikyuurirekino(siRireki
            .getSeikyuurirekino());

        List<JT_MisyuupMkkpDetail> misyuupMkkpDetailLst = sk.getMisyuupMkkpDetails();

        KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);

        KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);

        keiyakuPrm.setSyono(pSkKihon.getSyono());

        keiyakuPrm.setINayoseyh(C_NayoseYouhi.HUYOU);

        keiyakuInfoSyutoku.getInfos(keiyakuPrm);

        JT_SiKykKihon siKykKihon = keiyakuInfoSyutoku.getKykKihons().get(0);

        SiSiharaiKingakuKeisanBean siSiharaiKingakuKeisanBean = SWAKInjector.getInstance(SiSiharaiKingakuKeisanBean.class);

        SiSiharaiKingakuKeisan siSiharaiKingakuKeisan = SWAKInjector.getInstance(SiSiharaiKingakuKeisan.class);

        siSiharaiKingakuKeisanBean.setSyoNo(pSkKihon.getSyono());

        siSiharaiKingakuKeisanBean.setSeikyuuSyubetu(pSkKihon.getSeikyuusyubetu());

        siSiharaiKingakuKeisanBean.setCalcKijyunYmd(skJiyuu.getSibouymd());

        siSiharaiKingakuKeisanBean.setKnsnKijyunYmd(sk.getShrkwsratekjnymd());

        siSiharaiKingakuKeisanBean.setUktBnWari(BizNumber.valueOf(UKTBNWARI));

        siSiharaiKingakuKeisanBean.setHasuuKasanHyouji(C_HasuukasanUmuKbn.HASUUKASANNASI);

        siSiharaiKingakuKeisanBean.setInputShrhouSiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);

        siSiharaiKingakuKeisanBean.setSyoruiUkeYmd(sk.getSyoruiukeymd());

        siSiharaiKingakuKeisanBean.setHubiKanryouYmd(sk.getHubikanryouymd());

        siSiharaiKingakuKeisanBean.setRikoukiTyuutuudanNissuu(sk.getRikoukityuutuudannissuu());

        siSiharaiKingakuKeisanBean.setSinsaGendoKknKbn(sk.getSinsagendokknkbn());

        siSiharaiKingakuKeisanBean.setSUketoriHouhouKbn(sk.getSuketorihouhoukbn());

        siSiharaiKingakuKeisanBean.setSiharaiTuukaKbn(sk.getSiharaituukakbn());

        siSiharaiKingakuKeisanBean.setNkShrTkykNksyuKbn(C_Nstknsyu.BLNK);

        siSiharaiKingakuKeisanBean.setNkShrTkykNksyuKkn(0);

        siSiharaiKingakuKeisanBean.setBnShrKaisuu(C_Bnshrkaisuu.BLNK);

        siSiharaiKingakuKeisanBean.setNkKknJyutouGk(BizCurrency.valueOf(0));

        siSiharaiKingakuKeisanBean.setNkHaitoukinuketorihouKbn(C_NkHaitoukinuketorihouKbn.NONE);

        siSiharaiKingakuKeisanBean.setSiKykKihon(siKykKihon);

        siSiharaiKingakuKeisanBean.setSiHonninKakninKbn(sk.getSihonninkakninkbn());

        siSiharaiKingakuKeisanBean.setKeisanKahiKbn(C_KahiKbn.KA);

        siSiharaiKingakuKeisanBean.setYobidasimotoKinouId(kinou.getKinouId());

        siSiharaiKingakuKeisanBean.setSikinouModeIdKbn(C_SikinouModeIdKbn.DEFAULT);

        siSiharaiKingakuKeisanBean.setSiinKbn(sk.getSiinkbn());

        siSiharaiKingakuKeisanBean.setSaisateiKbn(C_SaisateiKbn.BLNK);

        siSiharaiKingakuKeisanBean.setUktMnmeigiBangou("");

        siSiharaiKingakuKeisanBean.setKykMnmeigiBango("");

        siSiharaiKingakuKeisanBean.setBankCd("");

        siSiharaiKingakuKeisanBean.setSyoriYmd(batchParam.getSyoriYmd());

        C_ErrorKbn errorKbn = siSiharaiKingakuKeisan.exec(siSiharaiKingakuKeisanBean);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            throw new BizAppException(MessageId.EJA1004, kinou.getKinouNm(), JT_SkKihon.SYONO, pSkKihon.getSyono());
        }

        boolean afterKessanKimatuYmd = isAfterKessanKimatuYmd(sk.getSyoruiukeymd(), sk.getHubikanryouymd());

        BizCurrency initsbjiyenkasaiteihsygk = getInitsbjiyenkasaiteihsygk(siKykKihon, siSiharaiKingakuKeisan
            .getSiHkkingakuSisanParamBean().getHknKknKbn());

        C_UmuKbn syoumetuumukbn = getSyoumetuumukbn(siKykKihon);

        for (JT_SiDetail siDetail : siDetailLst) {

            if (BizUtil.isZero(siDetail.getKyhkg())) {
                continue;
            }

            JT_SiKykSyouhn siKykSyouhn = siKykKihon.getSiKykSyouhnBySyutkkbnSyouhncdItems(
                siDetail.getSyutkkbn(), siDetail.getSyouhncd(), siDetail.getKyhgndkatakbn(),
                siDetail.getSyouhnsdno(), siDetail.getKyksyouhnrenno());

            BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(siDetail.getSyouhncd(), siDetail.getSyouhnsdno());

            syouhnZokusei = BM_SyouhnZokuseiDetacher.detachSyouhnZokuseitouched(syouhnZokusei);

            JM_SiSyouhnZokusei siSyouhnZokusei = siharaiDomManager.getSiSyouhnZokusei(
                siDetail.getSyouhncd(), siDetail.getKyhgndkatakbn(), siDetail.getSyouhnsdno(), siDetail.getKyuuhucd());

            siSyouhnZokusei = JM_SiSyouhnZokuseiDetacher.detachSiSyouhnZokuseitouched(siSyouhnZokusei);

            JM_Kyuuhu kyuuhu = getJM_Kyuuhu(siDetail.getKyuuhucd());

            BzGetSousasyaSyozokuSosikiData bzGetSousasyaSyozokuSosikiData =
                SWAKInjector.getInstance(BzGetSousasyaSyozokuSosikiData.class);

            BzGetSousasyaSyozokuSosikiDataBean bzGetSousasyaSyozokuSosikiDataBean =
                bzGetSousasyaSyozokuSosikiData.exec(siRireki.getGyoumuKousinsyaId());

            String syouhncd = syouhncdSettei(siDetail.getSyouhncd(), siDetail.getHokenkinsyuruikbn());

            C_UmuKbn siharaiUmuKbn = siharaiUmuKbnSettei(siRireki.getShrkekkakbn());

            C_UmuKbn sinsaUmuKbn = sinsaUmuKbnSettei(siKykKihon.getSntkhoukbn());

            C_UmuKbn soukiUmuKbn = soukiUmuKbnSettei(skJiyuu.getSibouymd(), siKykSyouhn.getSknnkaisiymd(),
                siKykKihon.getHksknnkaisiymd());

            C_BknJkuKbn bknJkuKbn = bknJikouKbnSettei(ksnbiymd, pSkKihon.getSiboukaritrkymd());

            BizDate shrSyoriYmd = shrsyoriymdSettei(siRireki.getShrkekkakbn(), siRireki.getShrsyoriymd());

            C_NoinitUmuKbn gengkUmuKbn = gengakuUmuKbnSettei(siKykKihon.getSykyknyhenkouymd());

            C_UmuKbn jisatuMensekiUmuKbn = jisatumensekiUmuKbnSettei(sk.getSiinkbn(), skJiyuu.getSibouymd(),
                siKykKihon.getHksknnkaisiymd(), siKykSyouhn, siSyouhnZokusei);

            BkngkSetteiInnerClass bkngkSetteiInnerClass = new BkngkSetteiInnerClass();
            bkngkSetteiInnerClass.setBikinGaitoInfo(BIKINGAITOINFO_SYORISUMI);
            bkngkSetteiInnerClass.setJisatuMensekiUmuKbn(C_UmuKbn.NONE);
            bkngkSetteiInnerClass.setShrKekkaKbn(siRireki.getShrkekkakbn());
            bkngkSetteiInnerClass.setSyoumetuumukbn(syoumetuumukbn);
            bkngkSetteiInnerClass.setKyktuukasyu(siKykSyouhn.getKyktuukasyu());
            bkngkSetteiInnerClass.setShrtuukasyu(sk.getShrtuukasyu());
            bkngkSetteiInnerClass.setKyhkg(siDetail.getKyhkg());
            bkngkSetteiInnerClass.setYenkyhgk(siDetail.getYenkyhgk());
            bkngkSetteiInnerClass.setShrkwsratekjnymd(sk.getShrkwsratekjnymd());
            bkngkSetteiInnerClass.setShrkwsrate(sk.getShrkwsrate());
            bkngkSetteiInnerClass.setSyoruiukeymd(sk.getSyoruiukeymd());
            bkngkSetteiInnerClass.setHubikanryouymd(sk.getHubikanryouymd());

            bKngkSettei(bkngkSetteiInnerClass);

            C_SyouhnsyuruiKbn syouhnsyuruiKbn = syouhnsyuruiKbnSettei(syouhnZokusei.getNkhknumu());

            zennouSeisanKgkSettei(BIKINGAITOINFO_SYORISUMI, siRireki.getShrkekkakbn(), siKykSyouhn.getKyktuukasyu(),
                sk.getShrtuukasyu(), sk.getZennouseisankgk(), sk.getYenkazennouseisankgk(),
                siSyouhnZokusei.getZnnusisnkinknrtuukakbn());

            mikeikaPSettei(BIKINGAITOINFO_SYORISUMI, siRireki.getShrkekkakbn(), siKykSyouhn.getKyktuukasyu(),
                sk.getShrtuukasyu(), sk.getMikeikap(), sk.getYenkamikeikap(), siSyouhnZokusei.getMikeikapknrtuukakbn());

            List<SiDetailMisyuupBean> siDetailMisyuupBeanLst = siDetailMisyuupBeanListHenkan(misyuupMkkpDetailLst);

            misyuuPSettei(BIKINGAITOINFO_SYORISUMI, siKykSyouhn.getKykymd(), siRireki.getShrkekkakbn(),
                siKykSyouhn.getKyktuukasyu(), sk.getShrtuukasyu(), sk.getMisyuupjyuutouym(), sk.getMisyuup(),
                siKykKihon.getKeip(), siKykKihon.getHrkkaisuu(), sk.getMisyuusyonendojikaiikoup(),
                sk.getMisyuujinendoikoup(), siDetailMisyuupBeanLst);

            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

            keisanGaikakanzan.exec(C_Tuukasyu.JPY, siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean()
                .getSbymdTmttKnGk(), shrkwsrate, C_HasuusyoriKbn.AGE);

            BizCurrency yenSbymdTmttKnGk = keisanGaikakanzan.getKanzanGaku();

            keisanGaikakanzan.exec(C_Tuukasyu.JPY, siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean()
                .getSbymdKaiyakuhenreiknGk(), shrkwsrate, C_HasuusyoriKbn.AGE);

            BizCurrency yenSbymdKaiyakuhenreiknGk = keisanGaikakanzan.getKanzanGaku();

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

            CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(siKykSyouhn.getKyktuukasyu());

            BizCurrency seisankgk = BizCurrency.valueOf(0, currencyType);
            BizCurrency yenkaseisankgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

            if (C_UmuKbn.ARI.eq(jisatuMensekiUmuKbn)) {
                CalcSeisankgk calcSeisankgk = SWAKInjector.getInstance(CalcSeisankgk.class);
                calcSeisankgk.exec(siDetail.getSyouhncd(), siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean());
                seisankgk = calcSeisankgk.getSbymdSeisankGk();

                if (!C_Tuukasyu.JPY.eq(siKykSyouhn.getKyktuukasyu())) {
                    keisanGaikakanzan.exec(C_Tuukasyu.JPY, seisankgk, shrkwsrate, C_HasuusyoriKbn.AGE);

                    yenkaseisankgk = keisanGaikakanzan.getKanzanGaku();
                }
            }

            BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
            SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(siDetail.getSyouhncd(),
                siKykSyouhn.getKyktuukasyu());

            JT_SiBikinkanri siBikinkanri = new JT_SiBikinkanri();

            siBikinkanri.setSkno(pSkKihon.getSkno());

            siBikinkanri.setSyono(pSkKihon.getSyono());

            siBikinkanri.setKessankijyunymd(ksnbiymd);

            siBikinkanri.setBkncdkbn(C_BkncdKbn.SIBOUUKETUKE);

            siBikinkanri.setBknkktymd(pSkKihon.getSiboukaritrkymd());

            siBikinkanri.setKyuuhucd(siDetail.getKyuuhucd());

            siBikinkanri.setBknrigikbn(C_BknrigiKbn.BLNK);

            siBikinkanri.setSeikyuusyubetu(pSkKihon.getSeikyuusyubetu());

            siBikinkanri.setCalckijyunymd(skJiyuu.getSibouymd());

            siBikinkanri.setSyoruiukeymd(sk.getSyoruiukeymd());

            siBikinkanri.setHubikanryouymd(sk.getHubikanryouymd());

            siBikinkanri.setSyouhnsyuruikbn(syouhnsyuruiKbn);

            siBikinkanri.setSyutkkbn(siDetail.getSyutkkbn());

            siBikinkanri.setSisyacd(bzGetSousasyaSyozokuSosikiDataBean.getSosikicd().substring(0,3));

            siBikinkanri.setKbnkeirisegcd(syouhinbetuSegmentBean.getSegcd1());

            siBikinkanri.setSyouhncd(syouhncd);

            siBikinkanri.setKyuuhuname(kyuuhu.getKyuuhunamereport());

            siBikinkanri.setBkngk(bkngk);

            siBikinkanri.setKihons(siKykSyouhn.getKihons());

            siBikinkanri.setShrumu(siharaiUmuKbn);

            siBikinkanri.setSinsaumukbn(sinsaUmuKbn);

            siBikinkanri.setSoukiumukbn(soukiUmuKbn);

            siBikinkanri.setSyoumetuumukbn(syoumetuumukbn);

            siBikinkanri.setHubijyoukyoukbn(pSkKihon.getHubijyoukyoukbn());

            siBikinkanri.setBknjkukbn(bknJkuKbn);

            siBikinkanri.setShrsyoriymd(shrSyoriYmd);

            siBikinkanri.setTyakkinymd(siRireki.getTyakkinymd());

            siBikinkanri.setKyktuukasyu(siKykSyouhn.getKyktuukasyu());

            siBikinkanri.setShrtuukasyu(sk.getShrtuukasyu());

            siBikinkanri.setShrgk(siDetail.getKyhkg());

            siBikinkanri.setShrkwsratekjnymd(shrkwsratekjnymd);

            siBikinkanri.setShrkwsrate(shrkwsrate);

            if (C_Tuukasyu.JPY.eq(sk.getShrtuukasyu())) {
                if (afterKessanKimatuYmd) {
                    siBikinkanri.setSitihsyutkyumaeyenhknkngk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                } else {
                    siBikinkanri.setSitihsyutkyumaeyenhknkngk(siDetail.getSitihsyutkyumaeyenhknkngk());
                }
            } else {
                siBikinkanri.setSitihsyutkyumaeyenhknkngk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            }

            siBikinkanri.setInitsbjiyenkasaiteihsygk(initsbjiyenkasaiteihsygk);

            siBikinkanri.setSiboukaritrkymd(pSkKihon.getSiboukaritrkymd());

            siBikinkanri.setShrkekkakbn(siRireki.getShrkekkakbn());

            siBikinkanri.setHushrgeninkbn(sateiSyouninRirekilst.get(0).getHushrgeninkbn());

            siBikinkanri.setSiinkbn(sk.getSiinkbn());

            siBikinkanri.setKinoussnm("");

            siBikinkanri.setSuketorihouhoukbn(sk.getSuketorihouhoukbn());

            siBikinkanri.setTutakngk(siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean().getSbymdTmttKnGk());

            siBikinkanri.setYentutakngk(yenSbymdTmttKnGk);

            siBikinkanri.setKaiyakuhr(siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean().getSbymdKaiyakuhenreiknGk());

            siBikinkanri.setYenkaiyakuhr(yenSbymdKaiyakuhenreiknGk);

            siBikinkanri.setGengkumukbn(gengkUmuKbn);

            siBikinkanri.setGengkymd(siKykKihon.getSykyknyhenkouymd());

            siBikinkanri.setJisatumensekiumukbn(jisatuMensekiUmuKbn);

            siBikinkanri.setHokenkinsyuruikbn(kyuuhu.getHokenkinsyuruikbn());

            siBikinkanri.setBkntyousafsyorikbn(kyuuhu.getBkntyousafsyorikbn());

            SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);

            BizDate kessanNensibi = setKessanNensibi.exec(pSkKihon.getSiboukaritrkymd());

            siBikinkanri.setBknkktinnd(String.valueOf(kessanNensibi).substring(0,4));

            siBikinkanri.setBknkktiym(pSkKihon.getSiboukaritrkymd().getBizDateYM());

            siBikinkanri.setKykymd(siKykSyouhn.getKykymd());

            siBikinkanri.setZennouseisankinumukbn(zennouseisankinumukbn);

            siBikinkanri.setZennouseisankgk(zennouseisankgk);

            siBikinkanri.setYenkazennouseisankgk(yenkazennouseisankgk);

            siBikinkanri.setMikeikapumukbn(mikeikapumukbn);

            siBikinkanri.setMikeikap(mikeikap);

            siBikinkanri.setYenkamikeikap(yenkamikeikap);

            siBikinkanri.setMisyuupumukbn(misyuupumukbn);

            siBikinkanri.setMisyuupjyuutouym(misyuupjyuutouym);

            siBikinkanri.setHrkp(hrkp);

            siBikinkanri.setMisyuup(misyuup);

            siBikinkanri.setYenkamisyuup(yenkamisyuup);

            siBikinkanri.setHrkkaisuu(hrkkaisuu);

            siBikinkanri.setSyonendojikaiikoup(syonendojikaiikoup);

            siBikinkanri.setYenkasyonendojikaiikoup(yenkasyonendojikaiikoup);

            siBikinkanri.setJinendoikoup(jinendoikoup);

            siBikinkanri.setYenkajinendoikoup(yenkajinendoikoup);

            siBikinkanri.setSeisankgk(seisankgk);

            siBikinkanri.setYenkaseisankgk(yenkaseisankgk);

            siBikinkanri.setMsyupknrtuukakbn(siSyouhnZokusei.getMsyupknrtuukakbn());

            siBikinkanri.setMikeikapknrtuukakbn(siSyouhnZokusei.getMikeikapknrtuukakbn());

            siBikinkanri.setZnnusisnkinknrtuukakbn(siSyouhnZokusei.getZnnusisnkinknrtuukakbn());

            siBikinkanri.setGyoumuKousinKinou(kinou.getKinouId());

            siBikinkanri.setGyoumuKousinsyaId(baseUserInfo.getUserId());

            siBikinkanri.setGyoumuKousinTime(sysTime);

            siBikinkanri.setSyuukeiyoubkncdkbn(getSyuukeiyoubkncdkbn(C_BkncdKbn.SIBOUUKETUKE));

            BizPropertyInitializer.initialize(siBikinkanri);

            pSiBikinkanriEntityInserter.add(siBikinkanri);

            kousinKensuu = kousinKensuu + 1;
        }

        return kousinKensuu;
    }

    private Long afterSkUktkBkkanriTouroku(JT_SkKihon pSkKihon,
        Integer pSeikyuurirekino, EntityInserter<JT_SiBikinkanri> pSiBikinkanriEntityInserter) {

        Long kousinKensuu = 0L;

        JT_Sk sk = pSkKihon.getSkBySeikyuurirekino(pSeikyuurirekino);

        JT_SkJiyuu skJiyuu = sk.getSkJiyuuByUketukeno(UKETUKENO);

        String maxTtdkRrkSkbtKey =
            siharaiDomManager.getTtdkRirekiMaxTtdkrrkskbtkeyBySknoSyono(pSkKihon.getSkno(), pSkKihon.getSyono());

        JT_TtdkRireki ttdkRireki = pSkKihon.getTtdkRirekiByTtdkrrkskbtkey(maxTtdkRrkSkbtKey);

        BizDate calcKijyunYmd;

        BizDate sibouymd;

        BizDate skJiyuuSibouYmd = skJiyuu.getSibouymd();

        if (skJiyuuSibouYmd != null) {

            calcKijyunYmd = skJiyuuSibouYmd;

            sibouymd = skJiyuuSibouYmd;
        }
        else {

            List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyonoSibouKariuketsuke(pSkKihon.getSyono());

            sibouymd = skKihonLst.get(0).getSibouKariuketsuke().getSibouymd();

            calcKijyunYmd = pSkKihon.getSiboukaritrkymd();
        }

        BizDate syoruiUkeYmd;

        if (sk.getHubikanryouymd() != null) {

            syoruiUkeYmd = sk.getHubikanryouymd();
        }
        else {

            syoruiUkeYmd = sk.getSyoruiukeymd();
        }

        KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);

        KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);

        keiyakuPrm.setSyono(pSkKihon.getSyono());

        keiyakuPrm.setINayoseyh(C_NayoseYouhi.HUYOU);

        keiyakuInfoSyutoku.getInfos(keiyakuPrm);

        JT_SiKykKihon siKykKihon = keiyakuInfoSyutoku.getKykKihons().get(0);

        SiSiharaiKingakuKeisanBean siSiharaiKingakuKeisanBean = SWAKInjector.getInstance(SiSiharaiKingakuKeisanBean.class);

        SiSiharaiKingakuKeisan siSiharaiKingakuKeisan = SWAKInjector.getInstance(SiSiharaiKingakuKeisan.class);

        siSiharaiKingakuKeisanBean.setSyoNo(pSkKihon.getSyono());

        siSiharaiKingakuKeisanBean.setSeikyuuSyubetu(pSkKihon.getSeikyuusyubetu());

        siSiharaiKingakuKeisanBean.setCalcKijyunYmd(sibouymd);

        siSiharaiKingakuKeisanBean.setKnsnKijyunYmd(syoruiUkeYmd);

        siSiharaiKingakuKeisanBean.setUktBnWari(BizNumber.valueOf(UKTBNWARI));

        siSiharaiKingakuKeisanBean.setHasuuKasanHyouji(C_HasuukasanUmuKbn.HASUUKASANNASI);

        siSiharaiKingakuKeisanBean.setInputShrhouSiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);

        siSiharaiKingakuKeisanBean.setSyoruiUkeYmd(sk.getSyoruiukeymd());

        siSiharaiKingakuKeisanBean.setHubiKanryouYmd(sk.getHubikanryouymd());

        siSiharaiKingakuKeisanBean.setRikoukiTyuutuudanNissuu(sk.getRikoukityuutuudannissuu());

        siSiharaiKingakuKeisanBean.setSinsaGendoKknKbn(sk.getSinsagendokknkbn());

        siSiharaiKingakuKeisanBean.setSUketoriHouhouKbn(C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN);

        siSiharaiKingakuKeisanBean.setSiharaiTuukaKbn(sk.getSiharaituukakbn());

        siSiharaiKingakuKeisanBean.setNkShrTkykNksyuKbn(C_Nstknsyu.BLNK);

        siSiharaiKingakuKeisanBean.setNkShrTkykNksyuKkn(0);

        siSiharaiKingakuKeisanBean.setBnShrKaisuu(C_Bnshrkaisuu.BLNK);

        siSiharaiKingakuKeisanBean.setNkKknJyutouGk(BizCurrency.valueOf(0));

        siSiharaiKingakuKeisanBean.setNkHaitoukinuketorihouKbn(C_NkHaitoukinuketorihouKbn.NONE);

        siSiharaiKingakuKeisanBean.setSiKykKihon(siKykKihon);

        siSiharaiKingakuKeisanBean.setSiHonninKakninKbn(sk.getSihonninkakninkbn());

        siSiharaiKingakuKeisanBean.setKeisanKahiKbn(C_KahiKbn.KA);

        siSiharaiKingakuKeisanBean.setYobidasimotoKinouId(kinou.getKinouId());

        siSiharaiKingakuKeisanBean.setSikinouModeIdKbn(C_SikinouModeIdKbn.DEFAULT);

        siSiharaiKingakuKeisanBean.setSiinKbn(sk.getSiinkbn());

        siSiharaiKingakuKeisanBean.setSaisateiKbn(C_SaisateiKbn.BLNK);

        siSiharaiKingakuKeisanBean.setUktMnmeigiBangou("");

        siSiharaiKingakuKeisanBean.setKykMnmeigiBango("");

        siSiharaiKingakuKeisanBean.setBankCd("");

        siSiharaiKingakuKeisanBean.setSyoriYmd(batchParam.getSyoriYmd());

        C_ErrorKbn errorKbn = siSiharaiKingakuKeisan.exec(siSiharaiKingakuKeisanBean);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            throw new BizAppException(MessageId.EJA1004, kinou.getKinouNm(), JT_SkKihon.SYONO, pSkKihon.getSyono());
        }

        boolean afterKessanKimatuYmd = isAfterKessanKimatuYmd(sk.getSyoruiukeymd(), sk.getHubikanryouymd());

        BizCurrency initsbjiyenkasaiteihsygk = getInitsbjiyenkasaiteihsygk(siKykKihon, siSiharaiKingakuKeisan
            .getSiHkkingakuSisanParamBean().getHknKknKbn());

        C_UmuKbn syoumetuumukbn = getSyoumetuumukbn(siKykKihon);

        List<SiSiDetailParamBean> siSiDetailParamBeanList = siSiharaiKingakuKeisan.getSiSiDetailParamBean();

        for (SiSiDetailParamBean siSiDetailParamBean : siSiDetailParamBeanList) {

            if (BizUtil.isZero(siSiDetailParamBean.getKyhkg())) {

                continue;
            }

            JT_SiKykSyouhn siKykSyouhn = siKykKihon.getSiKykSyouhnBySyutkkbnSyouhncdItems(
                siSiDetailParamBean.getSyutkkbn(), siSiDetailParamBean.getSyouhncd(), siSiDetailParamBean.getKyhgndkatakbn(),
                siSiDetailParamBean.getSyouhnsdno(), siSiDetailParamBean.getKyksyouhnrenno());

            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(siSiDetailParamBean.getSyouhncd(), siSiDetailParamBean.getSyouhnsdno());

            syouhnZokusei = BM_SyouhnZokuseiDetacher.detachSyouhnZokuseitouched(syouhnZokusei);

            JM_SiSyouhnZokusei siSyouhnZokusei = siharaiDomManager.getSiSyouhnZokusei(
                siSiDetailParamBean.getSyouhncd(), siSiDetailParamBean.getKyhgndkatakbn(),
                siSiDetailParamBean.getSyouhnsdno(), siSiDetailParamBean.getKyuuhucd());

            siSyouhnZokusei = JM_SiSyouhnZokuseiDetacher.detachSiSyouhnZokuseitouched(siSyouhnZokusei);

            JM_Kyuuhu kyuuhu = getJM_Kyuuhu(siSiDetailParamBean.getKyuuhucd());

            String syouhncd = syouhncdSettei(siSiDetailParamBean.getSyouhncd(), siSiDetailParamBean.getHokenkinsyuruikbn());

            C_UmuKbn sinsaUmuKbn = sinsaUmuKbnSettei(siKykKihon.getSntkhoukbn());

            C_UmuKbn soukiUmuKbn = soukiUmuKbnSettei(sibouymd, siKykSyouhn.getSknnkaisiymd(), siKykKihon.getHksknnkaisiymd());

            C_BknJkuKbn bknJkuKbn = bknJikouKbnSettei(ksnbiymd, pSkKihon.getSiboukaritrkymd());

            List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = getProcessSummaryOutBeanLst(
                skJiyuu.getSkno(), pSkKihon.getSyono());

            String kinoussnm = bzGetProcessSummaryOutBeanLst.get(0).getNowNodoNm();

            C_NoinitUmuKbn gengkUmuKbn = gengakuUmuKbnSettei(siKykKihon.getSykyknyhenkouymd());

            C_UmuKbn jisatuMensekiUmuKbn = jisatumensekiUmuKbnSettei(sk.getSiinkbn(), sibouymd,
                siKykKihon.getHksknnkaisiymd(), siKykSyouhn, siSyouhnZokusei);

            C_ShrKekkaKbn shrKekkaKbn = C_ShrKekkaKbn.SHR;
            C_HushrGeninKbn hushrGeninKbn = C_HushrGeninKbn.BLNK;

            String nowNodeId = bzGetProcessSummaryOutBeanLst.get(0).getNowNodoId();
            if (TeisuuSiharai.NODEID_SESSYOU1.equals(nowNodeId)
                || TeisuuSiharai.NODEID_SESSYOU2.equals(nowNodeId)
                || TeisuuSiharai.NODEID_KAIKETU_SESSYOUYOU.equals(nowNodeId)
                || TeisuuSiharai.NODEID_KAIKETU_SESSYOUHUYOU.equals(nowNodeId)) {

                List<JT_SateiSyouninRireki> sateiSyouninRirekiList = pSkKihon.getSateiSyouninRirekis();

                C_SyorikekkaKbn syorikekkaKbn = C_SyorikekkaKbn.BLNK;

                for (int i = sateiSyouninRirekiList.size() - 1; i > 0; i--) {
                    JT_SateiSyouninRireki sateiSyouninRireki = sateiSyouninRirekiList.get(i);
                    if (C_SikinouModeIdKbn.SATEI4.getValue().equals(sateiSyouninRireki.getKossyorisscd())
                        || C_SikinouModeIdKbn.SATEI3.getValue().equals(sateiSyouninRireki.getKossyorisscd())) {
                        syorikekkaKbn = sateiSyouninRireki.getSyorikekkakbn();
                        hushrGeninKbn = sateiSyouninRireki.getHushrgeninkbn();
                        break;
                    }
                }

                if (C_SyorikekkaKbn.HUSIHARAI.eq(syorikekkaKbn)) {
                    shrKekkaKbn = C_ShrKekkaKbn.HSHR;
                }
            }

            BkngkSetteiInnerClass bkngkSetteiInnerClass = new BkngkSetteiInnerClass();
            bkngkSetteiInnerClass.setBikinGaitoInfo(BIKINGAITOINFO_UKETUKE_HUBI_NASI);
            bkngkSetteiInnerClass.setJisatuMensekiUmuKbn(jisatuMensekiUmuKbn);
            bkngkSetteiInnerClass.setShrKekkaKbn(shrKekkaKbn);
            bkngkSetteiInnerClass.setSyoumetuumukbn(syoumetuumukbn);
            bkngkSetteiInnerClass.setKyktuukasyu(siKykSyouhn.getKyktuukasyu());
            bkngkSetteiInnerClass.setShrtuukasyu(sk.getShrtuukasyu());
            bkngkSetteiInnerClass.setKyhkg(siSiDetailParamBean.getKyhkg());
            bkngkSetteiInnerClass.setYenkyhgk(siSiDetailParamBean.getYenkyhgk());
            bkngkSetteiInnerClass.setShrkwsratekjnymd(siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean().getKnsnKijyunYmd());
            bkngkSetteiInnerClass.setShrkwsrate(siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean().getKawaseRate());
            bkngkSetteiInnerClass.setSyoruiukeymd(sk.getSyoruiukeymd());
            bkngkSetteiInnerClass.setHubikanryouymd(sk.getHubikanryouymd());

            bKngkSettei(bkngkSetteiInnerClass);

            C_SyouhnsyuruiKbn syouhnsyuruiKbn = syouhnsyuruiKbnSettei(syouhnZokusei.getNkhknumu());

            zennouSeisanKgkSettei(BIKINGAITOINFO_UKETUKE_HUBI_NASI, shrKekkaKbn, siKykSyouhn.getKyktuukasyu(),
                sk.getShrtuukasyu(), sk.getZennouseisankgk(), sk.getYenkazennouseisankgk(),
                siSyouhnZokusei.getZnnusisnkinknrtuukakbn());

            mikeikaPSettei(BIKINGAITOINFO_UKETUKE_HUBI_NASI, shrKekkaKbn, siKykSyouhn.getKyktuukasyu(),
                sk.getShrtuukasyu(), sk.getMikeikap(), sk.getYenkamikeikap(), siSyouhnZokusei.getMikeikapknrtuukakbn());

            misyuuPSettei(BIKINGAITOINFO_UKETUKE_HUBI_NASI, siKykSyouhn.getKykymd(), shrKekkaKbn,
                siKykSyouhn.getKyktuukasyu(), sk.getShrtuukasyu(), sk.getMisyuupjyuutouym(), sk.getMisyuup(),
                siKykKihon.getKeip(), siKykKihon.getHrkkaisuu(), sk.getMisyuusyonendojikaiikoup(),
                sk.getMisyuujinendoikoup(), siSiharaiKingakuKeisan.getSiDetailMisyuupBeans());

            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

            keisanGaikakanzan.exec(C_Tuukasyu.JPY, siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean()
                .getSbymdTmttKnGk(), shrkwsrate, C_HasuusyoriKbn.AGE);

            BizCurrency yenSbymdTmttKnGk = keisanGaikakanzan.getKanzanGaku();

            keisanGaikakanzan.exec(C_Tuukasyu.JPY, siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean()
                .getSbymdKaiyakuhenreiknGk(), shrkwsrate, C_HasuusyoriKbn.AGE);

            BizCurrency yenSbymdKaiyakuhenreiknGk = keisanGaikakanzan.getKanzanGaku();

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

            CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(siKykSyouhn.getKyktuukasyu());

            BizCurrency seisankgk = BizCurrency.valueOf(0, currencyType);
            BizCurrency yenkaseisankgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

            if (C_UmuKbn.ARI.eq(jisatuMensekiUmuKbn)) {
                CalcSeisankgk calcSeisankgk = SWAKInjector.getInstance(CalcSeisankgk.class);
                calcSeisankgk.exec(siSiDetailParamBean.getSyouhncd(),
                    siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean());
                seisankgk = calcSeisankgk.getSbymdSeisankGk();

                if (!C_Tuukasyu.JPY.eq(siKykSyouhn.getKyktuukasyu())) {
                    keisanGaikakanzan.exec(C_Tuukasyu.JPY, seisankgk, shrkwsrate, C_HasuusyoriKbn.AGE);

                    yenkaseisankgk = keisanGaikakanzan.getKanzanGaku();
                }
            }

            BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
            SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(siSiDetailParamBean.getSyouhncd(),
                siKykSyouhn.getKyktuukasyu());

            JT_SiBikinkanri siBikinkanri = new JT_SiBikinkanri();

            siBikinkanri.setSkno(pSkKihon.getSkno());

            siBikinkanri.setSyono(pSkKihon.getSyono());

            siBikinkanri.setKessankijyunymd(ksnbiymd);

            siBikinkanri.setBkncdkbn(C_BkncdKbn.SIBOUUKETUKE);

            siBikinkanri.setBknkktymd(pSkKihon.getSiboukaritrkymd());

            siBikinkanri.setKyuuhucd(siSiDetailParamBean.getKyuuhucd());

            siBikinkanri.setBknrigikbn(C_BknrigiKbn.BLNK);

            siBikinkanri.setSeikyuusyubetu(pSkKihon.getSeikyuusyubetu());

            siBikinkanri.setCalckijyunymd(calcKijyunYmd);

            siBikinkanri.setSyoruiukeymd(sk.getSyoruiukeymd());

            siBikinkanri.setHubikanryouymd(sk.getHubikanryouymd());

            siBikinkanri.setSyouhnsyuruikbn(syouhnsyuruiKbn);

            siBikinkanri.setSyutkkbn(siSiDetailParamBean.getSyutkkbn());

            siBikinkanri.setSisyacd(ttdkRireki.getSyorisosikicd().substring(0,3));

            siBikinkanri.setKbnkeirisegcd(syouhinbetuSegmentBean.getSegcd1());

            siBikinkanri.setSyouhncd(syouhncd);

            siBikinkanri.setKyuuhuname(siSiDetailParamBean.getKyuuhunamereport());

            siBikinkanri.setBkngk(bkngk);

            siBikinkanri.setKihons(siKykSyouhn.getKihons());

            siBikinkanri.setShrumu(C_UmuKbn.NONE);

            siBikinkanri.setSinsaumukbn(sinsaUmuKbn);

            siBikinkanri.setSoukiumukbn(soukiUmuKbn);

            siBikinkanri.setSyoumetuumukbn(syoumetuumukbn);

            siBikinkanri.setHubijyoukyoukbn(pSkKihon.getHubijyoukyoukbn());

            siBikinkanri.setBknjkukbn(bknJkuKbn);

            siBikinkanri.setShrsyoriymd(null);

            siBikinkanri.setTyakkinymd(null);

            siBikinkanri.setKyktuukasyu(siKykSyouhn.getKyktuukasyu());

            siBikinkanri.setShrtuukasyu(sk.getShrtuukasyu());

            siBikinkanri.setShrgk(siSiDetailParamBean.getKyhkg());

            siBikinkanri.setShrkwsratekjnymd(shrkwsratekjnymd);

            siBikinkanri.setShrkwsrate(shrkwsrate);

            if (C_Tuukasyu.JPY.eq(sk.getShrtuukasyu())) {
                if (afterKessanKimatuYmd) {
                    siBikinkanri.setSitihsyutkyumaeyenhknkngk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                } else {
                    siBikinkanri.setSitihsyutkyumaeyenhknkngk(siSiDetailParamBean.getSitihsyutkyumaeyenhknkngk());
                }
            } else {
                siBikinkanri.setSitihsyutkyumaeyenhknkngk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            }

            siBikinkanri.setInitsbjiyenkasaiteihsygk(initsbjiyenkasaiteihsygk);

            siBikinkanri.setSiboukaritrkymd(pSkKihon.getSiboukaritrkymd());

            if (C_ShrKekkaKbn.HSHR.eq(shrKekkaKbn)) {
                siBikinkanri.setShrkekkakbn(C_ShrKekkaKbn.HSHR);
            } else {
                siBikinkanri.setShrkekkakbn(C_ShrKekkaKbn.BLNK);
            }

            if (C_ShrKekkaKbn.HSHR.eq(shrKekkaKbn)) {
                siBikinkanri.setHushrgeninkbn(hushrGeninKbn);
            } else {
                siBikinkanri.setHushrgeninkbn(C_HushrGeninKbn.BLNK);
            }

            siBikinkanri.setSiinkbn(sk.getSiinkbn());

            siBikinkanri.setKinoussnm(kinoussnm);

            siBikinkanri.setSuketorihouhoukbn(sk.getSuketorihouhoukbn());

            siBikinkanri.setTutakngk(siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean().getSbymdTmttKnGk());

            siBikinkanri.setYentutakngk(yenSbymdTmttKnGk);

            siBikinkanri.setKaiyakuhr(siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean().getSbymdKaiyakuhenreiknGk());

            siBikinkanri.setYenkaiyakuhr(yenSbymdKaiyakuhenreiknGk);

            siBikinkanri.setGengkumukbn(gengkUmuKbn);

            siBikinkanri.setGengkymd(siKykKihon.getSykyknyhenkouymd());

            siBikinkanri.setJisatumensekiumukbn(jisatuMensekiUmuKbn);

            siBikinkanri.setHokenkinsyuruikbn(kyuuhu.getHokenkinsyuruikbn());

            siBikinkanri.setBkntyousafsyorikbn(kyuuhu.getBkntyousafsyorikbn());

            SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);

            BizDate kessannensibi = setKessanNensibi.exec(pSkKihon.getSiboukaritrkymd());

            siBikinkanri.setBknkktinnd(String.valueOf(kessannensibi).substring(0,4));

            siBikinkanri.setBknkktiym(pSkKihon.getSiboukaritrkymd().getBizDateYM());

            siBikinkanri.setKykymd(siKykSyouhn.getKykymd());

            siBikinkanri.setZennouseisankinumukbn(zennouseisankinumukbn);

            siBikinkanri.setZennouseisankgk(zennouseisankgk);

            siBikinkanri.setYenkazennouseisankgk(yenkazennouseisankgk);

            siBikinkanri.setMikeikapumukbn(mikeikapumukbn);

            siBikinkanri.setMikeikap(mikeikap);

            siBikinkanri.setYenkamikeikap(yenkamikeikap);

            siBikinkanri.setMisyuupumukbn(misyuupumukbn);

            siBikinkanri.setMisyuupjyuutouym(misyuupjyuutouym);

            siBikinkanri.setHrkp(hrkp);

            siBikinkanri.setMisyuup(misyuup);

            siBikinkanri.setYenkamisyuup(yenkamisyuup);

            siBikinkanri.setHrkkaisuu(hrkkaisuu);

            siBikinkanri.setSyonendojikaiikoup(syonendojikaiikoup);

            siBikinkanri.setYenkasyonendojikaiikoup(yenkasyonendojikaiikoup);

            siBikinkanri.setJinendoikoup(jinendoikoup);

            siBikinkanri.setYenkajinendoikoup(yenkajinendoikoup);

            siBikinkanri.setSeisankgk(seisankgk);

            siBikinkanri.setYenkaseisankgk(yenkaseisankgk);

            siBikinkanri.setMsyupknrtuukakbn(siSyouhnZokusei.getMsyupknrtuukakbn());

            siBikinkanri.setMikeikapknrtuukakbn(siSyouhnZokusei.getMikeikapknrtuukakbn());

            siBikinkanri.setZnnusisnkinknrtuukakbn(siSyouhnZokusei.getZnnusisnkinknrtuukakbn());

            siBikinkanri.setGyoumuKousinKinou(kinou.getKinouId());

            siBikinkanri.setGyoumuKousinsyaId(baseUserInfo.getUserId());

            siBikinkanri.setGyoumuKousinTime(sysTime);

            siBikinkanri.setSyuukeiyoubkncdkbn(getSyuukeiyoubkncdkbn(C_BkncdKbn.SIBOUUKETUKE));

            BizPropertyInitializer.initialize(siBikinkanri);

            pSiBikinkanriEntityInserter.add(siBikinkanri);

            kousinKensuu = kousinKensuu + 1;

        }

        return kousinKensuu;
    }

    private Long preSkUktkBkkanriTouroku(JT_SkKihon pSkKihon, JT_SibouKariuketsuke pSibouKariuketsuke,
        String pBikinGaitoInfo, EntityInserter<JT_SiBikinkanri> pSiBikinkanriEntityInserter) {
        return preSkUktkBkkanriTouroku(pSkKihon, pSibouKariuketsuke, pBikinGaitoInfo, null, pSiBikinkanriEntityInserter);
    }

    private Long preSkUktkBkkanriTouroku(JT_SkKihon pSkKihon, JT_SibouKariuketsuke pSibouKariuketsuke,
        String pBikinGaitoInfo,JT_Sk pSk,  EntityInserter<JT_SiBikinkanri> pSiBikinkanriEntityInserter) {
        return preSkUktkBkkanriTouroku(pSkKihon, pSibouKariuketsuke, pBikinGaitoInfo, pSk, null, pSiBikinkanriEntityInserter);
    }

    private Long preSkUktkBkkanriTouroku(JT_SkKihon pSkKihon, JT_SibouKariuketsuke pSibouKariuketsuke,
        String pBikinGaitoInfo, JT_Sk pSk, String pSiharaisikibetuki, EntityInserter<JT_SiBikinkanri> pSiBikinkanriEntityInserter) {

        Long kousinKensuu = 0L;

        C_GeninKbn geninKbn = pSibouKariuketsuke.getGeninkbn();
        BizDate sibouymd = pSibouKariuketsuke.getSibouymd();

        String maxTtdkRrkSkbtKey =
            siharaiDomManager.getTtdkRirekiMaxTtdkrrkskbtkeyBySknoSyono(pSkKihon.getSkno(), pSkKihon.getSyono());

        JT_TtdkRireki ttdkRireki = pSkKihon.getTtdkRirekiByTtdkrrkskbtkey(maxTtdkRrkSkbtKey);

        JT_TtdkRireki sibouKariuketsukeTtdkRireki = pSibouKariuketsuke.getSkKihon().getTtdkRirekis().get(0);

        JT_SiRireki siRireki = new JT_SiRireki();
        JT_SkJiyuu skJiyuu = new JT_SkJiyuu();

        if (BIKINGAITOINFO_KESSANKIMATUYMDGO_SIHARAISUMI.equals(pBikinGaitoInfo)) {
            siRireki = pSkKihon.getSiRirekiByShrsikibetukey(pSiharaisikibetuki);

            skJiyuu = pSk.getSkJiyuuByUketukeno(UKETUKENO);

            sibouymd = skJiyuu.getSibouymd();
        }

        if (BIKINGAITOINFO_UKETUKE_HUBI_ARI.equals(pBikinGaitoInfo)) {
            skJiyuu = pSk.getSkJiyuuByUketukeno(UKETUKENO);
            if (skJiyuu.getSibouymd() != null) {
                sibouymd = skJiyuu.getSibouymd();
            }
        }

        KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);

        KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);

        keiyakuPrm.setSyono(pSkKihon.getSyono());

        keiyakuPrm.setINayoseyh(C_NayoseYouhi.HUYOU);

        keiyakuInfoSyutoku.getInfos(keiyakuPrm);

        JT_SiKykKihon siKykKihon = keiyakuInfoSyutoku.getKykKihons().get(0);

        C_SiinKbn siinKbn = C_SiinKbn.BLNK;

        if (BIKINGAITOINFO_KESSANKIMATUYMDGO_SIHARAISUMI.equals(pBikinGaitoInfo) ||
            BIKINGAITOINFO_UKETUKE_HUBI_ARI.equals(pBikinGaitoInfo)) {
            siinKbn = pSk.getSiinkbn();
        }
        else {
            Siinhantei siinhantei = SWAKInjector.getInstance(Siinhantei.class);

            siinKbn = siinhantei.hanteiGeninKbn(geninKbn);
        }

        SiSiharaiKingakuKeisanBean siSiharaiKingakuKeisanBean = SWAKInjector.getInstance(SiSiharaiKingakuKeisanBean.class);

        SiSiharaiKingakuKeisan siSiharaiKingakuKeisan = SWAKInjector.getInstance(SiSiharaiKingakuKeisan.class);

        siSiharaiKingakuKeisanBean.setSyoNo(pSkKihon.getSyono());

        siSiharaiKingakuKeisanBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);

        siSiharaiKingakuKeisanBean.setCalcKijyunYmd(sibouymd);

        siSiharaiKingakuKeisanBean.setKnsnKijyunYmd(hoseiKessanKimatuYmd);

        siSiharaiKingakuKeisanBean.setUktBnWari(BizNumber.valueOf(UKTBNWARI));

        siSiharaiKingakuKeisanBean.setHasuuKasanHyouji(C_HasuukasanUmuKbn.HASUUKASANNASI);

        siSiharaiKingakuKeisanBean.setInputShrhouSiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);

        siSiharaiKingakuKeisanBean.setSyoruiUkeYmd(hoseiKessanKimatuYmd);

        siSiharaiKingakuKeisanBean.setHubiKanryouYmd(null);

        siSiharaiKingakuKeisanBean.setRikoukiTyuutuudanNissuu(0);

        siSiharaiKingakuKeisanBean.setSinsaGendoKknKbn(C_SinsaGendoKknKbn.BLNK);

        siSiharaiKingakuKeisanBean.setSUketoriHouhouKbn(C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN);

        siSiharaiKingakuKeisanBean.setSiharaiTuukaKbn(C_SiharaiTuukaKbn.GAIKASIHARAI);

        siSiharaiKingakuKeisanBean.setNkShrTkykNksyuKbn(C_Nstknsyu.BLNK);

        siSiharaiKingakuKeisanBean.setNkShrTkykNksyuKkn(0);

        siSiharaiKingakuKeisanBean.setBnShrKaisuu(C_Bnshrkaisuu.BLNK);

        siSiharaiKingakuKeisanBean.setNkKknJyutouGk(BizCurrency.valueOf(0));

        siSiharaiKingakuKeisanBean.setNkHaitoukinuketorihouKbn(C_NkHaitoukinuketorihouKbn.NONE);

        siSiharaiKingakuKeisanBean.setSiKykKihon(siKykKihon);

        siSiharaiKingakuKeisanBean.setSiHonninKakninKbn(C_SiHonninKakninKekkaKbn.KOUZA);

        siSiharaiKingakuKeisanBean.setKeisanKahiKbn(C_KahiKbn.KA);

        siSiharaiKingakuKeisanBean.setYobidasimotoKinouId(kinou.getKinouId());

        siSiharaiKingakuKeisanBean.setSikinouModeIdKbn(C_SikinouModeIdKbn.DEFAULT);

        siSiharaiKingakuKeisanBean.setSiinKbn(siinKbn);

        siSiharaiKingakuKeisanBean.setSaisateiKbn(C_SaisateiKbn.BLNK);

        siSiharaiKingakuKeisanBean.setUktMnmeigiBangou("");

        siSiharaiKingakuKeisanBean.setKykMnmeigiBango("");

        siSiharaiKingakuKeisanBean.setBankCd("");

        siSiharaiKingakuKeisanBean.setSyoriYmd(batchParam.getSyoriYmd());

        C_ErrorKbn errorKbn = siSiharaiKingakuKeisan.exec(siSiharaiKingakuKeisanBean);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            throw new BizAppException(MessageId.EJA1004, kinou.getKinouNm(), JT_SkKihon.SYONO, pSkKihon.getSyono());
        }

        C_BkncdKbn bkncdkbn = C_BkncdKbn.SIBOUKARIUKETUKE;
        if (BIKINGAITOINFO_UKETUKE_HUBI_ARI.equals(pBikinGaitoInfo)) {
            bkncdkbn = C_BkncdKbn.SIBOUUKETUKE;
        }

        BizDate syoruiukeymd = null;
        BizDate hubikanryouymd = null;
        if (pSk != null) {
            syoruiukeymd = pSk.getSyoruiukeymd();
            hubikanryouymd = pSk.getHubikanryouymd();
        }

        BizCurrency initsbjiyenkasaiteihsygk = getInitsbjiyenkasaiteihsygk(siKykKihon, siSiharaiKingakuKeisan
            .getSiHkkingakuSisanParamBean().getHknKknKbn());

        C_UmuKbn syoumetuumukbn = getSyoumetuumukbn(siKykKihon);

        List<SiSiDetailParamBean> siSiDetailParamBeanList = siSiharaiKingakuKeisan.getSiSiDetailParamBean();

        for (SiSiDetailParamBean siSiDetailParamBean : siSiDetailParamBeanList) {

            if (BizUtil.isZero(siSiDetailParamBean.getKyhkg())) {

                continue;
            }

            JT_SiKykSyouhn siKykSyouhn = siKykKihon.getSiKykSyouhnBySyutkkbnSyouhncdItems(
                siSiDetailParamBean.getSyutkkbn(), siSiDetailParamBean.getSyouhncd(),
                siSiDetailParamBean.getKyhgndkatakbn(), siSiDetailParamBean.getSyouhnsdno(),
                siSiDetailParamBean.getKyksyouhnrenno());

            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(siSiDetailParamBean.getSyouhncd(), siSiDetailParamBean.getSyouhnsdno());

            syouhnZokusei = BM_SyouhnZokuseiDetacher.detachSyouhnZokuseitouched(syouhnZokusei);

            JM_SiSyouhnZokusei siSyouhnZokusei = siharaiDomManager.getSiSyouhnZokusei(
                siSiDetailParamBean.getSyouhncd(), siSiDetailParamBean.getKyhgndkatakbn(),
                siSiDetailParamBean.getSyouhnsdno(), siSiDetailParamBean.getKyuuhucd());

            siSyouhnZokusei = JM_SiSyouhnZokuseiDetacher.detachSiSyouhnZokuseitouched(siSyouhnZokusei);

            JM_Kyuuhu kyuuhu = getJM_Kyuuhu(siSiDetailParamBean.getKyuuhucd());

            BzGetSousasyaSyozokuSosikiData bzGetSousasyaSyozokuSosikiData = SWAKInjector
                .getInstance(BzGetSousasyaSyozokuSosikiData.class);

            BzGetSousasyaSyozokuSosikiDataBean bzGetSousasyaSyozokuSosikiDataBean = SWAKInjector
                .getInstance(BzGetSousasyaSyozokuSosikiDataBean.class);

            if (BIKINGAITOINFO_KESSANKIMATUYMDGO_SIHARAISUMI.equals(pBikinGaitoInfo)) {
                bzGetSousasyaSyozokuSosikiData =
                    SWAKInjector.getInstance(BzGetSousasyaSyozokuSosikiData.class);

                bzGetSousasyaSyozokuSosikiDataBean =
                    bzGetSousasyaSyozokuSosikiData.exec(siRireki.getGyoumuKousinsyaId());
            }

            String syouhncd = syouhncdSettei(siSiDetailParamBean.getSyouhncd(), siSiDetailParamBean.getHokenkinsyuruikbn());

            C_UmuKbn sinsaUmuKbn = sinsaUmuKbnSettei(siKykKihon.getSntkhoukbn());

            C_UmuKbn soukiUmuKbn = soukiUmuKbnSettei(sibouymd, siKykSyouhn.getSknnkaisiymd(), siKykKihon.getHksknnkaisiymd());

            C_BknJkuKbn bknJkuKbn = bknJikouKbnSettei(ksnbiymd, pSkKihon.getSiboukaritrkymd());

            C_NoinitUmuKbn gengkUmuKbn = gengakuUmuKbnSettei(siKykKihon.getSykyknyhenkouymd());

            C_UmuKbn jisatuMensekiUmuKbn = jisatumensekiUmuKbnSettei(siinKbn, sibouymd, siKykKihon.getHksknnkaisiymd(),
                siKykSyouhn, siSyouhnZokusei);

            BkngkSetteiInnerClass bkngkSetteiInnerClass = new BkngkSetteiInnerClass();
            bkngkSetteiInnerClass.setBikinGaitoInfo(pBikinGaitoInfo);
            bkngkSetteiInnerClass.setJisatuMensekiUmuKbn(jisatuMensekiUmuKbn);
            bkngkSetteiInnerClass.setShrKekkaKbn(C_ShrKekkaKbn.SHR);
            bkngkSetteiInnerClass.setSyoumetuumukbn(syoumetuumukbn);
            bkngkSetteiInnerClass.setKyktuukasyu(siKykSyouhn.getKyktuukasyu());
            bkngkSetteiInnerClass.setShrtuukasyu(siKykSyouhn.getKyktuukasyu());
            bkngkSetteiInnerClass.setKyhkg(siSiDetailParamBean.getKyhkg());
            bkngkSetteiInnerClass.setYenkyhgk(siSiDetailParamBean.getYenkyhgk());
            bkngkSetteiInnerClass.setShrkwsratekjnymd(null);
            bkngkSetteiInnerClass.setShrkwsrate(null);
            bkngkSetteiInnerClass.setSyoruiukeymd(null);
            bkngkSetteiInnerClass.setHubikanryouymd(null);

            bKngkSettei(bkngkSetteiInnerClass);

            C_SyouhnsyuruiKbn syouhnsyuruiKbn = syouhnsyuruiKbnSettei(syouhnZokusei.getNkhknumu());

            if (BIKINGAITOINFO_KESSANKIMATUYMDGO_SIHARAISUMI.equals(pBikinGaitoInfo) && pSk != null) {
                zennouSeisanKgkSettei(pBikinGaitoInfo, siRireki.getShrkekkakbn(), pSk.getKyktuukasyu(),
                    pSk.getKyktuukasyu(), pSk.getZennouseisankgk(), pSk.getYenkazennouseisankgk(),
                    siSyouhnZokusei.getZnnusisnkinknrtuukakbn());

                mikeikaPSettei(pBikinGaitoInfo, siRireki.getShrkekkakbn(), pSk.getKyktuukasyu(),
                    pSk.getKyktuukasyu(), pSk.getMikeikap(), pSk.getYenkamikeikap(),
                    siSyouhnZokusei.getMikeikapknrtuukakbn());

                List<JT_MisyuupMkkpDetail> misyuupMkkpDetailLst = pSk.getMisyuupMkkpDetails();

                List<SiDetailMisyuupBean> siDetailMisyuupBeanLst = siDetailMisyuupBeanListHenkan(misyuupMkkpDetailLst);

                misyuuPSettei(pBikinGaitoInfo, siKykSyouhn.getKykymd(), siRireki.getShrkekkakbn(),
                    pSk.getKyktuukasyu(), pSk.getKyktuukasyu(), pSk.getMisyuupjyuutouym(), pSk.getMisyuup(),
                    siKykKihon.getKeip(), siKykKihon.getHrkkaisuu(), pSk.getMisyuusyonendojikaiikoup(),
                    pSk.getMisyuujinendoikoup(), siDetailMisyuupBeanLst);
            }
            else {
                zennouSeisanKgkSettei(pBikinGaitoInfo, C_ShrKekkaKbn.SHR, siKykSyouhn.getKyktuukasyu(),
                    siKykSyouhn.getKyktuukasyu(), siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean()
                    .getZennouseisank(), siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean()
                    .getYenkazennouseisank(), siSyouhnZokusei.getZnnusisnkinknrtuukakbn());

                mikeikaPSettei(pBikinGaitoInfo, C_ShrKekkaKbn.SHR, siKykSyouhn.getKyktuukasyu(),
                    siKykSyouhn.getKyktuukasyu(), siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean().getMikeikap(),
                    siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean().getYenkamikeikap(),
                    siSyouhnZokusei.getMikeikapknrtuukakbn());

                misyuuPSettei(pBikinGaitoInfo, siKykSyouhn.getKykymd(), C_ShrKekkaKbn.SHR,
                    siKykSyouhn.getKyktuukasyu(), siKykSyouhn.getKyktuukasyu(), siSiharaiKingakuKeisan
                    .getSiHkkingakuSisanParamBean().getMisyuupjyuutouym(), siSiharaiKingakuKeisan
                    .getSiHkkingakuSisanParamBean().getMisyuup(), siKykKihon.getKeip(), siKykKihon.getHrkkaisuu(),
                    siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean().getMisyuusyonendojikaiikoup(),
                    siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean().getMisyuujinendoikoup(),
                    siSiharaiKingakuKeisan.getSiDetailMisyuupBeans());
            }

            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

            keisanGaikakanzan.exec(C_Tuukasyu.JPY, siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean()
                .getSbymdTmttKnGk(), shrkwsrate, C_HasuusyoriKbn.AGE);

            BizCurrency yenSbymdTmttKnGk = keisanGaikakanzan.getKanzanGaku();

            keisanGaikakanzan.exec(C_Tuukasyu.JPY, siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean()
                .getSbymdKaiyakuhenreiknGk(), shrkwsrate, C_HasuusyoriKbn.AGE);

            BizCurrency yenSbymdKaiyakuhenreiknGk = keisanGaikakanzan.getKanzanGaku();

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

            CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(siKykSyouhn.getKyktuukasyu());

            BizCurrency seisankgk = BizCurrency.valueOf(0, currencyType);
            BizCurrency yenkaseisankgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

            if (C_UmuKbn.ARI.eq(jisatuMensekiUmuKbn)) {
                CalcSeisankgk calcSeisankgk = SWAKInjector.getInstance(CalcSeisankgk.class);
                calcSeisankgk.exec(siSiDetailParamBean.getSyouhncd(),
                    siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean());
                seisankgk = calcSeisankgk.getSbymdSeisankGk();

                if (!C_Tuukasyu.JPY.eq(siKykSyouhn.getKyktuukasyu())) {
                    keisanGaikakanzan.exec(C_Tuukasyu.JPY, seisankgk, shrkwsrate, C_HasuusyoriKbn.AGE);

                    yenkaseisankgk = keisanGaikakanzan.getKanzanGaku();
                }
            }

            BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
            SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(siSiDetailParamBean.getSyouhncd(),
                siKykSyouhn.getKyktuukasyu());

            JT_SiBikinkanri siBikinkanri = new JT_SiBikinkanri();

            siBikinkanri.setSkno(pSkKihon.getSkno());

            siBikinkanri.setSyono(pSkKihon.getSyono());

            siBikinkanri.setKessankijyunymd(ksnbiymd);

            siBikinkanri.setBkncdkbn(bkncdkbn);

            siBikinkanri.setBknkktymd(pSkKihon.getSiboukaritrkymd());

            siBikinkanri.setKyuuhucd(siSiDetailParamBean.getKyuuhucd());

            siBikinkanri.setBknrigikbn(C_BknrigiKbn.BLNK);

            siBikinkanri.setSeikyuusyubetu(pSkKihon.getSeikyuusyubetu());

            siBikinkanri.setCalckijyunymd(sibouymd);

            siBikinkanri.setSyoruiukeymd(syoruiukeymd);

            siBikinkanri.setHubikanryouymd(hubikanryouymd);

            siBikinkanri.setSyouhnsyuruikbn(syouhnsyuruiKbn);

            siBikinkanri.setSyutkkbn(siSiDetailParamBean.getSyutkkbn());

            if (BIKINGAITOINFO_UKETUKE_HUBI_ARI.equals(pBikinGaitoInfo)) {
                siBikinkanri.setSisyacd(ttdkRireki.getSyorisosikicd().substring(0, 3));
            } else if (BIKINGAITOINFO_SEIKYUSYOMATI.equals(pBikinGaitoInfo)
                || BIKINGAITOINFO_KARIUKETUKE.equals(pBikinGaitoInfo)) {
                siBikinkanri.setSisyacd(sibouKariuketsukeTtdkRireki.getSyorisosikicd().substring(0, 3));
            } else if (BIKINGAITOINFO_KESSANKIMATUYMDGO_SIHARAISUMI.equals(pBikinGaitoInfo)) {
                siBikinkanri.setSisyacd(bzGetSousasyaSyozokuSosikiDataBean.getSosikicd().substring(0,3));
            }

            siBikinkanri.setKbnkeirisegcd(syouhinbetuSegmentBean.getSegcd1());

            siBikinkanri.setSyouhncd(syouhncd);

            siBikinkanri.setKyuuhuname(siSiDetailParamBean.getKyuuhunamereport());

            siBikinkanri.setBkngk(bkngk);

            siBikinkanri.setKihons(siKykSyouhn.getKihons());

            siBikinkanri.setShrumu(C_UmuKbn.NONE);

            siBikinkanri.setSinsaumukbn(sinsaUmuKbn);

            siBikinkanri.setSoukiumukbn(soukiUmuKbn);

            siBikinkanri.setSyoumetuumukbn(syoumetuumukbn);

            siBikinkanri.setHubijyoukyoukbn(pSkKihon.getHubijyoukyoukbn());

            siBikinkanri.setBknjkukbn(bknJkuKbn);

            siBikinkanri.setShrsyoriymd(null);

            siBikinkanri.setTyakkinymd(null);

            siBikinkanri.setKyktuukasyu(siKykSyouhn.getKyktuukasyu());

            siBikinkanri.setShrtuukasyu(C_Tuukasyu.BLNK);

            siBikinkanri.setShrgk(siSiDetailParamBean.getKyhkg());

            siBikinkanri.setShrkwsratekjnymd(shrkwsratekjnymd);

            siBikinkanri.setShrkwsrate(shrkwsrate);

            siBikinkanri.setSitihsyutkyumaeyenhknkngk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

            siBikinkanri.setInitsbjiyenkasaiteihsygk(initsbjiyenkasaiteihsygk);

            siBikinkanri.setSiboukaritrkymd(pSkKihon.getSiboukaritrkymd());

            siBikinkanri.setShrkekkakbn(C_ShrKekkaKbn.BLNK);

            siBikinkanri.setHushrgeninkbn(C_HushrGeninKbn.BLNK);

            siBikinkanri.setSiinkbn(siinKbn);

            siBikinkanri.setKinoussnm("");

            siBikinkanri.setSuketorihouhoukbn(C_SUketoriHouhouKbn.BLNK);

            siBikinkanri.setTutakngk(siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean().getSbymdTmttKnGk());

            siBikinkanri.setYentutakngk(yenSbymdTmttKnGk);

            siBikinkanri.setKaiyakuhr(siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean().getSbymdKaiyakuhenreiknGk());

            siBikinkanri.setYenkaiyakuhr(yenSbymdKaiyakuhenreiknGk);

            siBikinkanri.setGengkumukbn(gengkUmuKbn);

            siBikinkanri.setGengkymd(siKykKihon.getSykyknyhenkouymd());

            siBikinkanri.setJisatumensekiumukbn(jisatuMensekiUmuKbn);

            siBikinkanri.setHokenkinsyuruikbn(kyuuhu.getHokenkinsyuruikbn());

            siBikinkanri.setBkntyousafsyorikbn(kyuuhu.getBkntyousafsyorikbn());

            SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);

            BizDate kessannensibi = setKessanNensibi.exec(pSkKihon.getSiboukaritrkymd());

            siBikinkanri.setBknkktinnd(String.valueOf(kessannensibi).substring(0,4));

            siBikinkanri.setBknkktiym(pSkKihon.getSiboukaritrkymd().getBizDateYM());

            siBikinkanri.setKykymd(siKykSyouhn.getKykymd());

            siBikinkanri.setZennouseisankinumukbn(zennouseisankinumukbn);

            siBikinkanri.setZennouseisankgk(zennouseisankgk);

            siBikinkanri.setYenkazennouseisankgk(yenkazennouseisankgk);

            siBikinkanri.setMikeikapumukbn(mikeikapumukbn);

            siBikinkanri.setMikeikap(mikeikap);

            siBikinkanri.setYenkamikeikap(yenkamikeikap);

            siBikinkanri.setMisyuupumukbn(misyuupumukbn);

            siBikinkanri.setMisyuupjyuutouym(misyuupjyuutouym);

            siBikinkanri.setHrkp(hrkp);

            siBikinkanri.setMisyuup(misyuup);

            siBikinkanri.setYenkamisyuup(yenkamisyuup);

            siBikinkanri.setHrkkaisuu(hrkkaisuu);

            siBikinkanri.setSyonendojikaiikoup(syonendojikaiikoup);

            siBikinkanri.setYenkasyonendojikaiikoup(yenkasyonendojikaiikoup);

            siBikinkanri.setJinendoikoup(jinendoikoup);

            siBikinkanri.setYenkajinendoikoup(yenkajinendoikoup);

            siBikinkanri.setSeisankgk(seisankgk);

            siBikinkanri.setYenkaseisankgk(yenkaseisankgk);

            siBikinkanri.setMsyupknrtuukakbn(siSyouhnZokusei.getMsyupknrtuukakbn());

            siBikinkanri.setMikeikapknrtuukakbn(siSyouhnZokusei.getMikeikapknrtuukakbn());

            siBikinkanri.setZnnusisnkinknrtuukakbn(siSyouhnZokusei.getZnnusisnkinknrtuukakbn());

            siBikinkanri.setGyoumuKousinKinou(kinou.getKinouId());

            siBikinkanri.setGyoumuKousinsyaId(baseUserInfo.getUserId());

            siBikinkanri.setGyoumuKousinTime(sysTime);

            siBikinkanri.setSyuukeiyoubkncdkbn(getSyuukeiyoubkncdkbn(bkncdkbn));

            BizPropertyInitializer.initialize(siBikinkanri);

            pSiBikinkanriEntityInserter.add(siBikinkanri);

            kousinKensuu = kousinKensuu + 1;

        }

        return kousinKensuu;
    }

    private C_UmuKbn bkSyuuseiDataUmuChk(String pSkno, String pSyono, List<String> pBikinSyuuseiDataLst) {

        C_UmuKbn umuKbn;

        if (pBikinSyuuseiDataLst.size() == 0) {

            umuKbn = C_UmuKbn.NONE;
        }
        else {

            String keyInfo = editListKey(pSkno, pSyono);

            if (pBikinSyuuseiDataLst.contains(keyInfo)) {

                umuKbn = C_UmuKbn.ARI;
            }
            else {

                umuKbn = C_UmuKbn.NONE;
            }
        }

        return umuKbn;
    }

    private String syouhncdSettei(String pSyouhncd, C_HokenkinsyuruiKbn pHokenkinsyuruiKbn) {

        String syouhncd;

        if (C_HokenkinsyuruiKbn.SAIGAIHOKENKIN.eq(pHokenkinsyuruiKbn)) {

            syouhncd = SAIGAI;
        }
        else {

            syouhncd = pSyouhncd;
        }

        return syouhncd;
    }

    private C_UmuKbn siharaiUmuKbnSettei(C_ShrKekkaKbn pShrKekkaKbn) {

        C_UmuKbn siharaiumukbn;

        if (C_ShrKekkaKbn.SHR.eq(pShrKekkaKbn)) {

            siharaiumukbn = C_UmuKbn.ARI;
        }
        else {

            siharaiumukbn = C_UmuKbn.NONE;
        }

        return siharaiumukbn;
    }

    private C_UmuKbn sinsaUmuKbnSettei(C_SntkhouKbn pSntkhouKbn) {

        C_UmuKbn sinsaUmuKbn;

        if (C_SntkhouKbn.HJY.eq(pSntkhouKbn)) {

            sinsaUmuKbn = C_UmuKbn.ARI;
        }
        else {

            sinsaUmuKbn = C_UmuKbn.NONE;
        }

        return sinsaUmuKbn;
    }

    private C_UmuKbn soukiUmuKbnSettei(BizDate pSibouymd, BizDate pSknnkaisiymd, BizDate pHksknnkaisiymd) {

        BizDate sknnkaisiymd;

        if (pHksknnkaisiymd != null) {

            if (pSknnkaisiymd.compareTo(pHksknnkaisiymd) > 0) {

                sknnkaisiymd = pSknnkaisiymd;
            }
            else {

                sknnkaisiymd = pHksknnkaisiymd;
            }
        }
        else {

            sknnkaisiymd = pSknnkaisiymd;
        }


        C_UmuKbn soukiumukbn;

        if (pSibouymd.compareTo(sknnkaisiymd.addYears(YuyuSiharaiConfig.getInstance().getSoukiKyhNensuu())) < 0) {

            soukiumukbn = C_UmuKbn.ARI;
        }
        else {
            soukiumukbn = C_UmuKbn.NONE;
        }

        return soukiumukbn;
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

            if (HONKESSAN_KIJUNBI.compareTo(ksnbiymd.getBizDateMD()) == 0) {

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

    private BizDate shrsyoriymdSettei(C_ShrKekkaKbn pShrKekkaKbn, BizDate pShrsyoriymd) {

        BizDate shrsyoriymd;

        if (C_ShrKekkaKbn.SHR.eq(pShrKekkaKbn)) {

            shrsyoriymd = pShrsyoriymd;
        }
        else {

            shrsyoriymd = null;
        }

        return shrsyoriymd;
    }

    private C_NoinitUmuKbn gengakuUmuKbnSettei(BizDate pSykyknyhenkouymd) {

        C_NoinitUmuKbn noinitUmuKbn;

        if (pSykyknyhenkouymd != null) {

            noinitUmuKbn = C_NoinitUmuKbn.ARI;
        }
        else {

            noinitUmuKbn = C_NoinitUmuKbn.NONE;
        }

        return noinitUmuKbn;
    }

    private C_UmuKbn jisatumensekiUmuKbnSettei(C_SiinKbn pSiinKbn, BizDate pSibouymd, BizDate pHksknnkaisiymd,
        JT_SiKykSyouhn pSiKykSyouhn, JM_SiSyouhnZokusei pSiSyouhnZokusei) {
        C_UmuKbn jisatumensekiumukbn;

        if (C_SiinKbn.JS.eq(pSiinKbn)) {
            JisatuMensekiKikanHantei jisatuMensekiKikanHantei = SWAKInjector
                .getInstance(JisatuMensekiKikanHantei.class);
            if (jisatuMensekiKikanHantei.exec(pSibouymd, pHksknnkaisiymd, pSiKykSyouhn, pSiSyouhnZokusei)) {
                jisatumensekiumukbn = C_UmuKbn.ARI;
            } else {
                jisatumensekiumukbn = C_UmuKbn.NONE;
            }
        } else {
            jisatumensekiumukbn = C_UmuKbn.NONE;
        }
        return jisatumensekiumukbn;
    }

    private void bKngkSettei(BkngkSetteiInnerClass pBkngkSetteiInnerClass) {

        if (C_Tuukasyu.JPY.eq(pBkngkSetteiInnerClass.getKyktuukasyu())) {
            if (isBkngkZero(pBkngkSetteiInnerClass)) {
                bkngk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            } else {
                bkngk = pBkngkSetteiInnerClass.getKyhkg();
            }
            shrkwsratekjnymd = null;
            shrkwsrate = BizNumber.ZERO;
            return;
        }

        if (BIKINGAITOINFO_SYORISUMI.equals(pBkngkSetteiInnerClass.getBikinGaitoInfo())
            || BIKINGAITOINFO_UKETUKE_HUBI_NASI.equals(pBkngkSetteiInnerClass.getBikinGaitoInfo())) {
            BizDate syoruiukeymd = shiftSyoruiukeymd(pBkngkSetteiInnerClass.getSyoruiukeymd(),
                pBkngkSetteiInnerClass.getHubikanryouymd());

            if (C_Tuukasyu.JPY.eq(pBkngkSetteiInnerClass.getShrtuukasyu())) {
                if (syoruiukeymd.compareTo(ksnbiymd) <= 0) {
                    if (isBkngkZero(pBkngkSetteiInnerClass)) {
                        bkngk = BizCurrency.valueOf(0);
                    } else {
                        bkngk = pBkngkSetteiInnerClass.getYenkyhgk();
                    }
                    shrkwsratekjnymd = pBkngkSetteiInnerClass.getShrkwsratekjnymd();
                    shrkwsrate = pBkngkSetteiInnerClass.getShrkwsrate();
                    return;
                }
                shrkwsratekjnymd = hoseiKessanKimatuYmd;
            } else {
                shrkwsratekjnymd = hoseiKessanKimatuYmd;
            }
        } else {
            shrkwsratekjnymd = hoseiKessanKimatuYmd;
        }

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
        getKawaseRate.exec(shrkwsratekjnymd, C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
            pBkngkSetteiInnerClass.getKyktuukasyu(), C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.JISSEIRATE,
            C_EigyoubiHoseiKbn.BLNK, C_YouhiKbn.HUYOU);
        shrkwsrate = getKawaseRate.getKawaserate();

        if (isBkngkZero(pBkngkSetteiInnerClass)) {
            bkngk = BizCurrency.valueOf(0);
        } else {
            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
            bkngk = keisanGaikakanzan.exec(C_Tuukasyu.JPY, pBkngkSetteiInnerClass.getKyhkg(), shrkwsrate,
                C_HasuusyoriKbn.AGE);
        }
    }

    private boolean isBkngkZero(BkngkSetteiInnerClass pBkngkSetteiInnerClass) {
        return C_UmuKbn.ARI.eq(pBkngkSetteiInnerClass.getJisatuMensekiUmuKbn())
            || C_ShrKekkaKbn.HSHR.eq(pBkngkSetteiInnerClass.getShrKekkaKbn())
            || C_UmuKbn.ARI.eq(pBkngkSetteiInnerClass.getSyoumetuumukbn());
    }

    private BizDate hoseiKessankimatubi() {

        BizDate kessanBusinessDay = getKessanBusinessDay();
        return batchParam.getSyoriYmd().compareTo(kessanBusinessDay) < 0 ? batchParam.getSyoriYmd() : kessanBusinessDay;
    }

    private BizDate shiftSyoruiukeymd(BizDate pSyoruiukeymd, BizDate pHubikanryouymd) {

        BizDate syoruiukeymd = pSyoruiukeymd;
        if (pHubikanryouymd != null) {
            syoruiukeymd = pHubikanryouymd;
        }
        if (syoruiukeymd.isHoliday()) {
            syoruiukeymd = syoruiukeymd.getBusinessDay(CHolidayAdjustingMode.NEXT);
        }

        return syoruiukeymd;
    }

    private BizDate getKessanBusinessDay() {

        if (ksnbiymd.isHoliday()) {
            return ksnbiymd.getBusinessDay(CHolidayAdjustingMode.PREVIOUS);
        }
        return ksnbiymd;
    }

    private List<BzGetProcessSummaryOutBean> getProcessSummaryOutBeanLst(String pSkno, String pSyono,
        C_Kouteikanristatus pKouteikanristatus) {
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(TeisuuSiharai.JIMUTETUZUKICD_SISIBOU);
        bzGetProcessSummaryInBean.setSyoNo(pSyono);
        if (pSkno != null) {
            bzGetProcessSummaryInBean.setSkNos(new String[] { pSkno });
        }
        if (pKouteikanristatus != null) {
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(pKouteikanristatus);
        }
        bzGetProcessSummaryInBean.setSyukouteiSiborikomiUmu(C_UmuKbn.ARI);

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        return bzGetProcessSummary.exec(bzGetProcessSummaryInBean);
    }

    private List<BzGetProcessSummaryOutBean> getProcessSummaryOutBeanLst(String pSkno, String pSyono) {

        return getProcessSummaryOutBeanLst(pSkno, pSyono, null);
    }

    private boolean isSyorityuu(String pSkno, String pSyono) {

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBean = getProcessSummaryOutBeanLst(pSkno, pSyono,
            C_Kouteikanristatus.SYORITYUU);
        if (bzGetProcessSummaryOutBean.size() > 0) {
            return true;
        }
        return false;
    }

    private boolean isExistSyorityuuOrKanryou(String pSyono) {

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(TeisuuSiharai.JIMUTETUZUKICD_SISIBOU);
        bzGetProcessSummaryInBean.setSyoNo(pSyono);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU, C_Kouteikanristatus.KANRYOU);
        bzGetProcessSummaryInBean.setSyukouteiSiborikomiUmu(C_UmuKbn.ARI);

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBean = bzGetProcessSummary
            .exec(bzGetProcessSummaryInBean);

        if (bzGetProcessSummaryOutBean.size() > 0) {
            return true;
        }
        return false;
    }

    private String editListKey(String pSkno, String pSyono) {
        return Strings.padStart(pSkno, 18, '0') + ";" + Strings.padStart(pSyono, 11, '0');
    }

    private boolean isAfterKessanKimatuYmd(BizDate pSyoruiukeymd, BizDate pHubikanryouymd) {
        BizDate syoruiukeymd = shiftSyoruiukeymd(pSyoruiukeymd, pHubikanryouymd);
        return syoruiukeymd.compareTo(ksnbiymd) > 0;
    }

    private C_BkncdKbn getSyuukeiyoubkncdkbn(C_BkncdKbn pBkncdKbn) {
        C_BkncdKbn syuukeiyoubkncdkbn = C_BkncdKbn.BLNK;
        if (C_BkncdKbn.SIBOUUKETUKE.eq(pBkncdKbn) || C_BkncdKbn.SIBOUKARIUKETUKE.eq(pBkncdKbn)) {
            syuukeiyoubkncdkbn = C_BkncdKbn.SIBOUUKETUKE;
        }
        return syuukeiyoubkncdkbn;
    }

    private BizCurrency getInitsbjiyenkasaiteihsygk(JT_SiKykKihon pSiKykKihon, C_HknKknKbn pHknKknKbn) {
        BizCurrency Initsbjiyenkasaiteihsygk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        if (C_UmuKbn.ARI.eq(pSiKykKihon.getInitsbjiyensitihsytkhukaumu()) && C_HknKknKbn.DAI1HKNKKN.eq(pHknKknKbn)) {
            Initsbjiyenkasaiteihsygk = pSiKykKihon.getInitsbjiyenkasaiteihsygk();
        }
        return Initsbjiyenkasaiteihsygk;
    }

    private C_UmuKbn getSyoumetuumukbn(JT_SiKykKihon pSiKykKihon) {
        C_UmuKbn syoumetuumukbn;
        if (C_YuukousyoumetuKbn.SYOUMETU.eq(pSiKykKihon.getYuukousyoumetukbn())) {
            if (Arrays.asList(HOKENKIN_SYOUMETUJIYUU).contains(pSiKykKihon.getSyoumetujiyuu())) {
                syoumetuumukbn = C_UmuKbn.NONE;
            } else {
                syoumetuumukbn = C_UmuKbn.ARI;
            }
        } else {
            syoumetuumukbn = C_UmuKbn.NONE;
        }
        return syoumetuumukbn;
    }


    private C_SyouhnsyuruiKbn syouhnsyuruiKbnSettei(C_UmuKbn pNkhknumu){

        C_SyouhnsyuruiKbn syouhnsyuruiKbn = null;

        if (C_UmuKbn.NONE.eq(pNkhknumu)) {

            syouhnsyuruiKbn = C_SyouhnsyuruiKbn.KOJINHOKEN;
        }
        else if (C_UmuKbn.ARI.eq(pNkhknumu)) {

            syouhnsyuruiKbn = C_SyouhnsyuruiKbn.KOJINNENKIN;
        }
        return syouhnsyuruiKbn;
    }

    private void zennouSeisanKgkSettei(String pBikinGaitoInfo, C_ShrKekkaKbn pShrKekkaKbn, C_Tuukasyu pKyktuukasyu,
        C_Tuukasyu pShrtuukasyu, BizCurrency pZennouseisank, BizCurrency pYenkazennouseisank,
        C_SeisankinKanritukaKbn pZnnusisnkinknrtuukakbn) {

        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pKyktuukasyu);

        if (C_ShrKekkaKbn.HSHR.eq(pShrKekkaKbn)
            || pZennouseisank.equalsValue(BizCurrency.valueOf(0, pZennouseisank.getType()))) {
            zennouseisankinumukbn = C_UmuKbn.NONE;
            zennouseisankgk = BizCurrency.valueOf(0, currencyType);
            yenkazennouseisankgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        }
        else {
            zennouseisankinumukbn = C_UmuKbn.ARI;
            zennouseisankgk = pZennouseisank;

            if (C_Tuukasyu.JPY.eq(pKyktuukasyu)) {
                yenkazennouseisankgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            }
            else {
                if (BIKINGAITOINFO_SYORISUMI.equals(pBikinGaitoInfo)
                    || BIKINGAITOINFO_UKETUKE_HUBI_NASI.equals(pBikinGaitoInfo)) {
                    if (C_SeisankinKanritukaKbn.YENKA.eq(pZnnusisnkinknrtuukakbn) && C_Tuukasyu.JPY.eq(pShrtuukasyu)) {
                        yenkazennouseisankgk = pYenkazennouseisank;
                    }
                    else {
                        keisanGaikakanzan.exec(C_Tuukasyu.JPY, pZennouseisank, shrkwsrate, C_HasuusyoriKbn.AGE);

                        yenkazennouseisankgk = keisanGaikakanzan.getKanzanGaku();
                    }
                }
                else {
                    if (C_SeisankinKanritukaKbn.YENKA.eq(pZnnusisnkinknrtuukakbn)) {
                        yenkazennouseisankgk = pYenkazennouseisank;
                    }
                    else {
                        keisanGaikakanzan.exec(C_Tuukasyu.JPY, pZennouseisank, shrkwsrate, C_HasuusyoriKbn.AGE);

                        yenkazennouseisankgk = keisanGaikakanzan.getKanzanGaku();
                    }
                }
            }
        }
    }

    private void mikeikaPSettei(String pBikinGaitoInfo, C_ShrKekkaKbn pShrKekkaKbn, C_Tuukasyu pKyktuukasyu,
        C_Tuukasyu pShrtuukasyu, BizCurrency pMikeikap, BizCurrency pYenkamikeikap,
        C_SeisankinKanritukaKbn pMikeikapknrtuukakbn) {

        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pKyktuukasyu);

        if (C_ShrKekkaKbn.HSHR.eq(pShrKekkaKbn)
            || pMikeikap.equalsValue(BizCurrency.valueOf(0, pMikeikap.getType()))) {
            mikeikapumukbn = C_UmuKbn.NONE;
            mikeikap = BizCurrency.valueOf(0, currencyType);
            yenkamikeikap = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        }
        else {
            mikeikapumukbn = C_UmuKbn.ARI;
            mikeikap = pMikeikap;

            if (C_Tuukasyu.JPY.eq(pKyktuukasyu)) {
                yenkamikeikap = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            }
            else {
                if (BIKINGAITOINFO_SYORISUMI.equals(pBikinGaitoInfo)
                    || BIKINGAITOINFO_UKETUKE_HUBI_NASI.equals(pBikinGaitoInfo)) {
                    if (C_SeisankinKanritukaKbn.YENKA.eq(pMikeikapknrtuukakbn) && C_Tuukasyu.JPY.eq(pShrtuukasyu)) {
                        yenkamikeikap = pYenkamikeikap;
                    }
                    else {
                        keisanGaikakanzan.exec(C_Tuukasyu.JPY, pMikeikap, shrkwsrate, C_HasuusyoriKbn.AGE);

                        yenkamikeikap = keisanGaikakanzan.getKanzanGaku();
                    }
                }
                else {
                    if (C_SeisankinKanritukaKbn.YENKA.eq(pMikeikapknrtuukakbn)) {
                        yenkamikeikap = pYenkamikeikap;
                    }
                    else {
                        keisanGaikakanzan.exec(C_Tuukasyu.JPY, pMikeikap, shrkwsrate, C_HasuusyoriKbn.AGE);

                        yenkamikeikap = keisanGaikakanzan.getKanzanGaku();
                    }
                }
            }
        }
    }

    private void misyuuPSettei(String pBikinGaitoInfo, BizDate pKykymd, C_ShrKekkaKbn pShrKekkaKbn,
        C_Tuukasyu pKyktuukasyu, C_Tuukasyu pShrtuukasyu, BizDateYM pMisyuupjyuutouym, BizCurrency pMisyuup,
        BizCurrency pKeip, C_Hrkkaisuu pHrkkaisuu, BizCurrency pSyonendojikaiikoup, BizCurrency pJinendoikoup,
        List<SiDetailMisyuupBean> pSiDetailMisyuupBeanLst) {

        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pKyktuukasyu);

        if (C_ShrKekkaKbn.HSHR.eq(pShrKekkaKbn)
            || pMisyuup.equalsValue(BizCurrency.valueOf(0, pMisyuup.getType()))) {
            misyuupumukbn = C_UmuKbn.NONE;
            misyuupjyuutouym = null;
            hrkp = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            misyuup = BizCurrency.valueOf(0, currencyType);
            hrkkaisuu = C_Hrkkaisuu.BLNK;
            syonendojikaiikoup = BizCurrency.valueOf(0, currencyType);
            jinendoikoup = BizCurrency.valueOf(0, currencyType);
            yenkamisyuup = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            yenkasyonendojikaiikoup = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            yenkajinendoikoup = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        }
        else {
            misyuupumukbn = C_UmuKbn.ARI;
            misyuupjyuutouym = pMisyuupjyuutouym;
            hrkp = pKeip;
            misyuup = pMisyuup;
            hrkkaisuu = pHrkkaisuu;
            syonendojikaiikoup = pSyonendojikaiikoup;
            jinendoikoup = pJinendoikoup;

            if (C_Tuukasyu.JPY.eq(pKyktuukasyu)) {
                yenkamisyuup = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                yenkasyonendojikaiikoup = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                yenkajinendoikoup = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            }
            else {
                if ((BIKINGAITOINFO_SYORISUMI.equals(pBikinGaitoInfo) || BIKINGAITOINFO_UKETUKE_HUBI_NASI
                    .equals(pBikinGaitoInfo)) && C_Tuukasyu.JPY.eq(pShrtuukasyu)) {

                    BizCurrency wkYenkasyonendojikaiikoup = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    BizCurrency wkYenkajinendoikoup = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                    if (pSiDetailMisyuupBeanLst != null) {
                        for (SiDetailMisyuupBean siDetailMisyuupBean : pSiDetailMisyuupBeanLst) {
                            keisanGaikakanzan.exec(C_Tuukasyu.JPY, siDetailMisyuupBean.getDtlmisyuupgaika(),
                                shrkwsrate, C_HasuusyoriKbn.AGE);

                            BizCurrency kanzanGaku = keisanGaikakanzan.getKanzanGaku();

                            if (BizDateUtil.compareYm(siDetailMisyuupBean.getDtlmisyuupjyuutouym(), pKykymd.getNextYear()
                                .getBizDateYM()) == BizDateUtil.COMPARE_LESSER) {
                                wkYenkasyonendojikaiikoup = wkYenkasyonendojikaiikoup.add(kanzanGaku);
                            }
                            else {
                                wkYenkajinendoikoup = wkYenkajinendoikoup.add(kanzanGaku);
                            }
                        }
                    }
                    yenkamisyuup = wkYenkasyonendojikaiikoup.add(wkYenkajinendoikoup);
                    yenkasyonendojikaiikoup = wkYenkasyonendojikaiikoup;
                    yenkajinendoikoup = wkYenkajinendoikoup;
                }
                else {
                    keisanGaikakanzan.exec(C_Tuukasyu.JPY, pSyonendojikaiikoup, shrkwsrate, C_HasuusyoriKbn.SUTE);

                    yenkasyonendojikaiikoup = keisanGaikakanzan.getKanzanGaku();

                    keisanGaikakanzan.exec(C_Tuukasyu.JPY, pJinendoikoup, shrkwsrate, C_HasuusyoriKbn.SUTE);

                    yenkajinendoikoup = keisanGaikakanzan.getKanzanGaku();

                    yenkamisyuup = yenkasyonendojikaiikoup.add(yenkajinendoikoup);
                }
            }
        }
    }

    private List<SiDetailMisyuupBean> siDetailMisyuupBeanListHenkan(List<JT_MisyuupMkkpDetail> pMisyuupMkkpDetailLst) {

        List<SiDetailMisyuupBean> siDetailMisyuupBeanLstTemp = new ArrayList<>();

        if (pMisyuupMkkpDetailLst != null) {
            for (JT_MisyuupMkkpDetail misyuupMkkpDetail : pMisyuupMkkpDetailLst) {
                SiDetailMisyuupBean siDetailMisyuupBean = new SiDetailMisyuupBean();

                siDetailMisyuupBean.setDtlmisyuup(misyuupMkkpDetail.getDtlmisyuup());
                siDetailMisyuupBean.setDtlmisyuupgaika(misyuupMkkpDetail.getDtlmisyuupgaika());
                siDetailMisyuupBean.setDtlmisyuupgaikayenkingk(misyuupMkkpDetail.getDtlmisyuupgaikayenknsnkngk());
                siDetailMisyuupBean.setDtlmisyuupiktnyuukinnumu(misyuupMkkpDetail.getDtlmisyuupiktnkumu());
                siDetailMisyuupBean.setDtlmisyuuphrkkaisuu(misyuupMkkpDetail.getDtlmisyuuphrkkaisuu());
                siDetailMisyuupBean.setDtlmisyuupjyutoukaisuuy(misyuupMkkpDetail.getDtlmisyuupjtkaisuum());
                siDetailMisyuupBean.setDtlmisyuupjyutoukaisuum(misyuupMkkpDetail.getDtlmisyuupjtkaisuuy());
                siDetailMisyuupBean.setDtlmisyuupjyuutouym(misyuupMkkpDetail.getDtlmisyuupjytym());

                siDetailMisyuupBeanLstTemp.add(siDetailMisyuupBean);
            }
        }
        return siDetailMisyuupBeanLstTemp;
    }

    private int calcBknKeikaNendo(BizDate pKessanKijyunYmd, BizDate pBknkktymd) {
        SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);

        int kessankijyunnd = setKessanNensibi.exec(pKessanKijyunYmd).getYear();
        int bknkktinnd = setKessanNensibi.exec(pBknkktymd).getYear();

        int bknKeikaNendo = kessankijyunnd - bknkktinnd;

        return bknKeikaNendo;
    }

    private JM_Kyuuhu getJM_Kyuuhu(String pKyuuhucd) {
        if (jmKyuuhuMap.containsKey(pKyuuhucd)) {
            return jmKyuuhuMap.get(pKyuuhucd);
        }

        JM_Kyuuhu kyuuhu = siharaiDomManager.getKyuuhu(pKyuuhucd);
        kyuuhu = JM_KyuuhuDetacher.detachKyuuhutouched(kyuuhu);
        jmKyuuhuMap.put(pKyuuhucd, kyuuhu);
        return kyuuhu;
    }

    static class BkngkSetteiInnerClass {

        private String bikinGaitoInfo;
        private C_UmuKbn jisatuMensekiUmuKbn;
        private C_ShrKekkaKbn shrKekkaKbn;
        private C_UmuKbn syoumetuumukbn;
        private C_Tuukasyu kyktuukasyu;
        private C_Tuukasyu shrtuukasyu;
        private BizCurrency kyhkg;
        private BizCurrency yenkyhgk;
        private BizDate shrkwsratekjnymd;
        private BizNumber shrkwsrate;
        private BizDate syoruiukeymd;
        private BizDate hubikanryouymd;

        String getBikinGaitoInfo() {
            return bikinGaitoInfo;
        }

        void setBikinGaitoInfo(String bikinGaitoInfo) {
            this.bikinGaitoInfo = bikinGaitoInfo;
        }
        C_UmuKbn getJisatuMensekiUmuKbn() {
            return jisatuMensekiUmuKbn;
        }

        void setJisatuMensekiUmuKbn(C_UmuKbn jisatuMensekiUmuKbn) {
            this.jisatuMensekiUmuKbn = jisatuMensekiUmuKbn;
        }

        C_ShrKekkaKbn getShrKekkaKbn() {
            return shrKekkaKbn;
        }

        void setShrKekkaKbn(C_ShrKekkaKbn shrKekkaKbn) {
            this.shrKekkaKbn = shrKekkaKbn;
        }

        C_UmuKbn getSyoumetuumukbn() {
            return syoumetuumukbn;
        }

        void setSyoumetuumukbn(C_UmuKbn syoumetuumukbn) {
            this.syoumetuumukbn = syoumetuumukbn;
        }

        C_Tuukasyu getKyktuukasyu() {
            return kyktuukasyu;
        }

        void setKyktuukasyu(C_Tuukasyu kyktuukasyu) {
            this.kyktuukasyu = kyktuukasyu;
        }

        C_Tuukasyu getShrtuukasyu() {
            return shrtuukasyu;
        }

        void setShrtuukasyu(C_Tuukasyu shrtuukasyu) {
            this.shrtuukasyu = shrtuukasyu;
        }

        BizCurrency getKyhkg() {
            return kyhkg;
        }

        void setKyhkg(BizCurrency kyhkg) {
            this.kyhkg = kyhkg;
        }

        BizCurrency getYenkyhgk() {
            return yenkyhgk;
        }

        void setYenkyhgk(BizCurrency yenkyhgk) {
            this.yenkyhgk = yenkyhgk;
        }

        BizDate getShrkwsratekjnymd() {
            return shrkwsratekjnymd;
        }

        void setShrkwsratekjnymd(BizDate shrkwsratekjnymd) {
            this.shrkwsratekjnymd = shrkwsratekjnymd;
        }

        BizNumber getShrkwsrate() {
            return shrkwsrate;
        }

        void setShrkwsrate(BizNumber shrkwsrate) {
            this.shrkwsrate = shrkwsrate;
        }

        BizDate getSyoruiukeymd() {
            return syoruiukeymd;
        }

        void setSyoruiukeymd(BizDate syoruiukeymd) {
            this.syoruiukeymd = syoruiukeymd;
        }

        BizDate getHubikanryouymd() {
            return hubikanryouymd;
        }

        void setHubikanryouymd(BizDate hubikanryouymd) {
            this.hubikanryouymd = hubikanryouymd;
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

}