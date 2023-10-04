package yuyu.batch.siharai.sisatei.sihigaitouichiransakusei;

import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuPrm;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.siharai.sicommon.CalcHkShrKngkBean;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_MeihenYuukouMukouKbn;
import yuyu.def.classification.C_NayoseYouhi;
import yuyu.def.classification.C_NoinitUmuKbn;
import yuyu.def.classification.C_SaigaiHigaitouKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_SikinouModeIdKbn;
import yuyu.def.classification.C_SyoriJyoutaiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.JT_SateiMeigihenkouInfo;
import yuyu.def.db.entity.JT_SateiSyouninRireki;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.db.entity.JT_SibouSateiChkInfo;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkByoumei;
import yuyu.def.db.entity.JT_SkJiyuu;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.JT_Toriatukaifuryouinfo;
import yuyu.def.db.entity.JT_TtdkRireki;
import yuyu.def.siharai.file.csv.SiHigaitouItiranLayoutFile;
import yuyu.def.siharai.file.csv.SiMktKnrRendouLayoutFile;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.siharai.sorter.SortJT_SateiSyouninRireki;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

/**
 * 保険金給付金支払 査定 非該当一覧作成
 */
public class SiHigaitouIchiranSakuseiBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BizDomManager bizDomManager;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));

        long toujitsuKensuu = 0;
        long torikomiKensuu = 0;
        long nisyuukanKensuu = 0;

        List<SiHigaitouIchiranTyuusyutuSyoriKekkaBean> sateiSyouninRirekiToujitsuLst = getSiHigaitouIchiran(
            C_SyorikekkaKbn.HUSIHARAI,
            new String[] { C_SikinouModeIdKbn.SATEI3.getValue(), C_SikinouModeIdKbn.SATEI4.getValue() },
            bzBatchParam.getSyoriYmd(), bzBatchParam.getSyoriYmd(), C_SyoriJyoutaiKbn.KANRYOU, C_ShrKekkaKbn.HSHR);

        String syoNoToujitsu = "";
        String skNoToujitsu = "";
        try (ExDBResults<JT_SateiSyouninRireki> saishigaitouToujitsuLst = siharaiDomManager
            .getSaishigaitoulistsBySyorikekkakbnItems(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU,
                new String[] { C_SikinouModeIdKbn.SATEI3.getValue(), C_SikinouModeIdKbn.SATEI4.getValue() },
                bzBatchParam.getSyoriYmd(), bzBatchParam.getSyoriYmd(), C_SaigaiHigaitouKbn.SAIGAIHIGAITOU)) {

            for (JT_SateiSyouninRireki saishigaitouToujitsu : saishigaitouToujitsuLst) {

                if (saishigaitouToujitsu.getSyono().equals(syoNoToujitsu) &&
                    saishigaitouToujitsu.getSkno().equals(skNoToujitsu)) {
                    continue;
                }

                syoNoToujitsu = saishigaitouToujitsu.getSyono();
                skNoToujitsu = saishigaitouToujitsu.getSkno();

                SiHigaitouIchiranTyuusyutuSyoriKekkaBean siHigaitouKekkaBean = SWAKInjector
                    .getInstance(SiHigaitouIchiranTyuusyutuSyoriKekkaBean.class);

                siHigaitouKekkaBean.setSyoNo(saishigaitouToujitsu.getSyono());
                siHigaitouKekkaBean.setSkNo(saishigaitouToujitsu.getSkno());

                sateiSyouninRirekiToujitsuLst.add(siHigaitouKekkaBean);
            }
        }

        Comparator<SiHigaitouIchiranTyuusyutuSyoriKekkaBean> comparator =
            new Comparator<SiHigaitouIchiranTyuusyutuSyoriKekkaBean>() {
            @Override
            public int compare(SiHigaitouIchiranTyuusyutuSyoriKekkaBean pTarget1,
                SiHigaitouIchiranTyuusyutuSyoriKekkaBean pTarget2) {
                String syoNo1 = pTarget1.getSyoNo();
                String syoNo2 = pTarget2.getSyoNo();
                String skNo1 = pTarget1.getSkNo();
                String skNo2 = pTarget2.getSkNo();
                int result = 0;

                result = syoNo2.compareTo(syoNo1);
                if (result != 0) {
                    return result;
                }
                result = skNo2.compareTo(skNo1);
                return result;
            }
        };

        Ordering<SiHigaitouIchiranTyuusyutuSyoriKekkaBean> ordering = Ordering.from(comparator);
        sateiSyouninRirekiToujitsuLst = ordering.sortedCopy(sateiSyouninRirekiToujitsuLst);

        List<SiHigaitouItiranLayoutFile> toujitsuFileLst = Lists.newArrayList();
        List<SiMktKnrRendouLayoutFile> siMktKnrRendouLayoutFileLst = Lists.newArrayList();

        if (sateiSyouninRirekiToujitsuLst.size() != 0) {
            for (SiHigaitouIchiranTyuusyutuSyoriKekkaBean tempToujitsuBean : sateiSyouninRirekiToujitsuLst) {
                SiHigaitouIchiranHensyuSyoriKekkaBean toujitsuHensyuSyoriKekkaBean = editSiHigaitouIchiran(
                    tempToujitsuBean.getSkNo(), tempToujitsuBean.getSyoNo());
                SiHigaitouItiranLayoutFile toujitsuFile = SWAKInjector
                    .getInstance(SiHigaitouItiranLayoutFile.class);

                toujitsuFile.setIfcSeikyuukbn(toujitsuHensyuSyoriKekkaBean.getHokenknSeikyuuKbn());
                toujitsuFile.setIfcSateikekka(toujitsuHensyuSyoriKekkaBean.getSyorikekkakbn());
                toujitsuFile.setIfcHigaitougenin(toujitsuHensyuSyoriKekkaBean.getHushrGeninKbn());
                toujitsuFile.setIfcSyono(tempToujitsuBean.getSyoNo());
                toujitsuFile.setIfcKessaiymd(toujitsuHensyuSyoriKekkaBean.getKessaiymd());
                toujitsuFile.setIfcHknnm(toujitsuHensyuSyoriKekkaBean.getHknnm());
                toujitsuFile.setIfcHhknnmkn(toujitsuHensyuSyoriKekkaBean.getHhknmeiKn());
                toujitsuFile.setIfcToritugisisya("");
                toujitsuFile.setIfcKykymd(toujitsuHensyuSyoriKekkaBean.getKykymd());
                toujitsuFile.setIfcSbs(toujitsuHensyuSyoriKekkaBean.getSbs());
                toujitsuFile.setIfcSaigaisbs(toujitsuHensyuSyoriKekkaBean.getSaigaisbs());
                toujitsuFile.setIfcSbymd(toujitsuHensyuSyoriKekkaBean.getSbymd());
                toujitsuFile.setIfcSiin(toujitsuHensyuSyoriKekkaBean.getSiin());
                toujitsuFile.setIfcTyokusetusiin(toujitsuHensyuSyoriKekkaBean.getSeikyuuByoumei());
                toujitsuFile.setIfcItijikessainm(toujitsuHensyuSyoriKekkaBean.getItijiKessainm());
                toujitsuFile.setIfcKakninumukbn(toujitsuHensyuSyoriKekkaBean.getKakninUmu());
                toujitsuFile.setIfcSinsagendokknkbn(toujitsuHensyuSyoriKekkaBean.getEnsinkbn());
                toujitsuFile.setIfcTdnnissuu(toujitsuHensyuSyoriKekkaBean.getTdnnissuu());
                toujitsuFile.setIfcSaigaimousideumu(toujitsuHensyuSyoriKekkaBean.getSaigaimousideumu());
                toujitsuFile.setIfcKaiketuymd(toujitsuHensyuSyoriKekkaBean.getKaiketuymd());
                toujitsuFile.setIfcSyoruiukeymd(toujitsuHensyuSyoriKekkaBean.getSyoruiUkeymd());
                toujitsuFile.setIfcSessyouumu(toujitsuHensyuSyoriKekkaBean.getSessyouYhKbn());
                toujitsuFile.setIfcSessyousisyacd(toujitsuHensyuSyoriKekkaBean.getSessyouSisyaCd());
                toujitsuFile.setIfcSessyousisyanm(toujitsuHensyuSyoriKekkaBean.getSessyousisyanm());
                toujitsuFile.setIfcMeigihnk(toujitsuHensyuSyoriKekkaBean.getMeigihnk());
                toujitsuFile.setIfcTratkihuryouumu(toujitsuHensyuSyoriKekkaBean.getTratkihuryouumu());
                toujitsuFile.setIfcBengosikenkaiumu(toujitsuHensyuSyoriKekkaBean.getBengosikenkaiumu());
                toujitsuFile.setIfcKujyouumukbn(toujitsuHensyuSyoriKekkaBean.getKujyouUmu());
                toujitsuFile.setIfcJimumissumu(toujitsuHensyuSyoriKekkaBean.getJimumissumu());
                toujitsuFile.setIfcSindansyoryoushryouhi(toujitsuHensyuSyoriKekkaBean.getSindansyoryoushryouhi());
                toujitsuFile.setIfcSaiesuhigaitoukbn(toujitsuHensyuSyoriKekkaBean.getSaiesuhigaitoukbn());

                toujitsuFileLst.add(toujitsuFile);
                toujitsuKensuu = toujitsuKensuu + 1;

                if (C_YouhiblnkKbn.YOU.getValue().equals(toujitsuHensyuSyoriKekkaBean.getSessyouYhKbn())) {
                    SiMktKnrRendouLayoutFile siMktKnrRendouLayoutFile = SWAKInjector
                        .getInstance(SiMktKnrRendouLayoutFile.class);
                    siMktKnrRendouLayoutFile.setIfcAnkenkanrino("");
                    siMktKnrRendouLayoutFile.setIfcSyono(tempToujitsuBean.getSyoNo());
                    siMktKnrRendouLayoutFile.setIfcIraiymd(bzBatchParam.getSyoriYmd());
                    siMktKnrRendouLayoutFile.setIfcIraimotokbn(TeisuuSiharai.IRAIMOTOKBNMKTKNR_YUYU);
                    siMktKnrRendouLayoutFile.setIfcHubisyubetu(TeisuuSiharai.HBSYBTMKTKNR_SIHARAIHIGAITOU);
                    siMktKnrRendouLayoutFile.setIfcKakuninsakikbn(TeisuuSiharai.KAKSAKIKBNMKTKNR_SISYA);
                    siMktKnrRendouLayoutFile.setIfcKakuninkbn("");
                    siMktKnrRendouLayoutFile.setIfcKyuuhukbn(TeisuuSiharai.KYUUHUKBNMKTKNR_SB);
                    siMktKnrRendouLayoutFile.setIfcHonninsaisikbn("");
                    siMktKnrRendouLayoutFile.setIfcTaisyousyakbn(TeisuuSiharai.TAISYOUKBNMKTKNR_HONNIN);
                    siMktKnrRendouLayoutFile.setIfcSeikyuukbn(toujitsuHensyuSyoriKekkaBean.getHokenknSeikyuuKbn());
                    siMktKnrRendouLayoutFile.setIfcSyoubyousyakn("");
                    siMktKnrRendouLayoutFile.setIfcSyoubyousyakj("");
                    siMktKnrRendouLayoutFile.setIfcSyoubyousyaseiymd(null);
                    siMktKnrRendouLayoutFile.setIfcHhknkbn(TeisuuSiharai.HHKNKBNMKTKNR_1HI);
                    siMktKnrRendouLayoutFile.setIfcHhknmeikn(ConvertUtil.toHanAll(toujitsuHensyuSyoriKekkaBean.getHhknmeiKn(), 0, 0));
                    siMktKnrRendouLayoutFile.setIfcHhknmeikj(toujitsuHensyuSyoriKekkaBean.getHhknmeiKj());
                    siMktKnrRendouLayoutFile.setIfcHihokensyaseiymd(toujitsuHensyuSyoriKekkaBean.getHhknSeiymd());
                    siMktKnrRendouLayoutFile.setIfcDai2hhknmeikn("");
                    siMktKnrRendouLayoutFile.setIfcDai2hhknmeikj("");
                    siMktKnrRendouLayoutFile.setIfcDai2hhknseiymd(null);
                    siMktKnrRendouLayoutFile.setIfcKijyunymd(toujitsuHensyuSyoriKekkaBean.getSyoruiUkeymd());
                    siMktKnrRendouLayoutFile.setIfcSyoruiukeymd(toujitsuHensyuSyoriKekkaBean.getSyoruiUkeymd());
                    siMktKnrRendouLayoutFile.setIfcIraimotocomment("");
                    siMktKnrRendouLayoutFile.setIfcHubidojikakuninumu("");
                    siMktKnrRendouLayoutFile.setIfcKyksyameikn(ConvertUtil.toHanAll(toujitsuHensyuSyoriKekkaBean.getKyksyameiKn(), 0, 0));
                    siMktKnrRendouLayoutFile.setIfcKyksyameikj(toujitsuHensyuSyoriKekkaBean.getKyksyameiKj());
                    siMktKnrRendouLayoutFile.setIfcKeiyakuseiymd(toujitsuHensyuSyoriKekkaBean.getKyksyaSeiymd());
                    siMktKnrRendouLayoutFile.setIfcKykadr(toujitsuHensyuSyoriKekkaBean.getKykAdr());
                    siMktKnrRendouLayoutFile.setIfcSiteidairimeikn(ConvertUtil.toHanAll(toujitsuHensyuSyoriKekkaBean.getSiteiDairimeiKn(), 0, 0));
                    siMktKnrRendouLayoutFile.setIfcSiteidairimeikj(toujitsuHensyuSyoriKekkaBean.getSiteiDairimeiKj());
                    siMktKnrRendouLayoutFile.setIfcShadr(toujitsuHensyuSyoriKekkaBean.getTsinAdr());
                    siMktKnrRendouLayoutFile.setIfcYno(toujitsuHensyuSyoriKekkaBean.getTsinYno());
                    siMktKnrRendouLayoutFile.setIfcKihontikucd("");
                    siMktKnrRendouLayoutFile.setIfcJyouiadr("");
                    siMktKnrRendouLayoutFile.setIfcKaiadr(toujitsuHensyuSyoriKekkaBean.getTsinAdr());
                    siMktKnrRendouLayoutFile.setIfcSsyiriskissycd(toujitsuHensyuSyoriKekkaBean.getSessyouSisyaCd());
                    siMktKnrRendouLayoutFile.setIfcMdhansybetukbn("");
                    siMktKnrRendouLayoutFile.setIfcHjntkskhyj("");
                    siMktKnrRendouLayoutFile.setIfcKykhknhyj("");

                    siMktKnrRendouLayoutFileLst.add(siMktKnrRendouLayoutFile);
                    torikomiKensuu = torikomiKensuu + 1;
                }
            }
        }

        BzFileUploadUtil bzFileUploadUtilToujitsu = SWAKInjector.getInstance(BzFileUploadUtil.class);
        C_ErrorKbn toujitsuErrorKbn = bzFileUploadUtilToujitsu.exec(C_FileSyuruiCdKbn.SI_HIGAITOUITIRANTJT,
            toujitsuFileLst, true);
        if (C_ErrorKbn.ERROR.eq(toujitsuErrorKbn)) {
            throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
        }

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);
        C_ErrorKbn toriErrorKbn = bzFileUploadUtil.exec(C_FileSyuruiCdKbn.SI_HIGAITOUITIRANTORIKOMI,
            siMktKnrRendouLayoutFileLst, true);
        if (C_ErrorKbn.ERROR.eq(toriErrorKbn)) {
            throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
        }

        BizDate syoriYmdFrom = null;
        if (bzBatchParam.getSyoriYmd().getPreviousDay().isBusinessDay()) {
            syoriYmdFrom = bzBatchParam.getSyoriYmd().addDays(-14);
        }
        else {
            syoriYmdFrom = bzBatchParam.getSyoriYmd().addBusinessDays(-1).addDays(-13);
        }
        BizDate syoriYmdTo = bzBatchParam.getSyoriYmd().addDays(-14);

        List<SiHigaitouIchiranTyuusyutuSyoriKekkaBean> twoWeekLst = getSiHigaitouIchiran(
            C_SyorikekkaKbn.HUSIHARAI,
            new String[] { C_SikinouModeIdKbn.SATEI3.getValue(), C_SikinouModeIdKbn.SATEI4.getValue() },
            syoriYmdFrom, syoriYmdTo, C_SyoriJyoutaiKbn.KANRYOU, C_ShrKekkaKbn.HSHR);

        String syoNo = "";
        String skNo = "";

        try (ExDBResults<JT_SateiSyouninRireki> saishigaitouLst = siharaiDomManager
            .getSaishigaitoulistsBySyorikekkakbnItems(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU,
                new String[] { C_SikinouModeIdKbn.SATEI3.getValue(), C_SikinouModeIdKbn.SATEI4.getValue() },
                syoriYmdFrom, syoriYmdTo, C_SaigaiHigaitouKbn.SAIGAIHIGAITOU)) {

            for (JT_SateiSyouninRireki saishigai : saishigaitouLst) {

                if (saishigai.getSyono().equals(syoNo) &&
                    saishigai.getSkno().equals(skNo)) {
                    continue;
                }

                syoNo = saishigai.getSyono();
                skNo = saishigai.getSkno();

                SiHigaitouIchiranTyuusyutuSyoriKekkaBean siHigaitouKekkaBean = SWAKInjector
                    .getInstance(SiHigaitouIchiranTyuusyutuSyoriKekkaBean.class);

                siHigaitouKekkaBean.setSyoNo(saishigai.getSyono());
                siHigaitouKekkaBean.setSkNo(saishigai.getSkno());

                twoWeekLst.add(siHigaitouKekkaBean);
            }
        }

        Comparator<SiHigaitouIchiranTyuusyutuSyoriKekkaBean> comparatortwoWeek =
            new Comparator<SiHigaitouIchiranTyuusyutuSyoriKekkaBean>() {
            @Override
            public int compare(SiHigaitouIchiranTyuusyutuSyoriKekkaBean pTarget1,
                SiHigaitouIchiranTyuusyutuSyoriKekkaBean pTarget2) {
                String syoNo1 = pTarget1.getSyoNo();
                String syoNo2 = pTarget2.getSyoNo();
                String skNo1 = pTarget1.getSkNo();
                String skNo2 = pTarget2.getSkNo();
                int result = 0;

                result = syoNo2.compareTo(syoNo1);
                if (result != 0) {
                    return result;
                }

                result = skNo2.compareTo(skNo1);
                return result;
            }
        };

        Ordering<SiHigaitouIchiranTyuusyutuSyoriKekkaBean> orderingtwoWeek = Ordering.from(comparatortwoWeek);
        twoWeekLst = orderingtwoWeek.sortedCopy(twoWeekLst);

        List<SiHigaitouItiranLayoutFile> twoWeekFileLst = Lists.newArrayList();

        if (twoWeekLst.size() != 0) {
            for (SiHigaitouIchiranTyuusyutuSyoriKekkaBean tempTwoWeekBean : twoWeekLst) {
                SiHigaitouIchiranHensyuSyoriKekkaBean twoWeekHensyuSyoriKekkaBean = editSiHigaitouIchiran(
                    tempTwoWeekBean.getSkNo(), tempTwoWeekBean.getSyoNo());
                if (C_YouhiblnkKbn.YOU.getValue().equals(twoWeekHensyuSyoriKekkaBean.getSessyouYhKbn())) {
                    SiHigaitouItiranLayoutFile twoWeekFile = SWAKInjector.getInstance(SiHigaitouItiranLayoutFile.class);
                    twoWeekFile.setIfcSeikyuukbn(twoWeekHensyuSyoriKekkaBean.getHokenknSeikyuuKbn());
                    twoWeekFile.setIfcSateikekka(twoWeekHensyuSyoriKekkaBean.getSyorikekkakbn());
                    twoWeekFile.setIfcHigaitougenin(twoWeekHensyuSyoriKekkaBean.getHushrGeninKbn());
                    twoWeekFile.setIfcSyono(tempTwoWeekBean.getSyoNo());
                    twoWeekFile.setIfcKessaiymd(twoWeekHensyuSyoriKekkaBean.getKessaiymd());
                    twoWeekFile.setIfcHknnm(twoWeekHensyuSyoriKekkaBean.getHknnm());
                    twoWeekFile.setIfcHhknnmkn(twoWeekHensyuSyoriKekkaBean.getHhknmeiKn());
                    twoWeekFile.setIfcToritugisisya("");
                    twoWeekFile.setIfcKykymd(twoWeekHensyuSyoriKekkaBean.getKykymd());
                    twoWeekFile.setIfcSbs(twoWeekHensyuSyoriKekkaBean.getSbs());
                    twoWeekFile.setIfcSaigaisbs(twoWeekHensyuSyoriKekkaBean.getSaigaisbs());
                    twoWeekFile.setIfcSbymd(twoWeekHensyuSyoriKekkaBean.getSbymd());
                    twoWeekFile.setIfcSiin(twoWeekHensyuSyoriKekkaBean.getSiin());
                    twoWeekFile.setIfcTyokusetusiin(twoWeekHensyuSyoriKekkaBean.getSeikyuuByoumei());
                    twoWeekFile.setIfcItijikessainm(twoWeekHensyuSyoriKekkaBean.getItijiKessainm());
                    twoWeekFile.setIfcKakninumukbn(twoWeekHensyuSyoriKekkaBean.getKakninUmu());
                    twoWeekFile.setIfcSinsagendokknkbn(twoWeekHensyuSyoriKekkaBean.getEnsinkbn());
                    twoWeekFile.setIfcTdnnissuu(twoWeekHensyuSyoriKekkaBean.getTdnnissuu());
                    twoWeekFile.setIfcSaigaimousideumu(twoWeekHensyuSyoriKekkaBean.getSaigaimousideumu());
                    twoWeekFile.setIfcKaiketuymd(twoWeekHensyuSyoriKekkaBean.getKaiketuymd());
                    twoWeekFile.setIfcSyoruiukeymd(twoWeekHensyuSyoriKekkaBean.getSyoruiUkeymd());
                    twoWeekFile.setIfcSessyouumu(twoWeekHensyuSyoriKekkaBean.getSessyouYhKbn());
                    twoWeekFile.setIfcSessyousisyacd(twoWeekHensyuSyoriKekkaBean.getSessyouSisyaCd());
                    twoWeekFile.setIfcSessyousisyanm(twoWeekHensyuSyoriKekkaBean.getSessyousisyanm());
                    twoWeekFile.setIfcMeigihnk(twoWeekHensyuSyoriKekkaBean.getMeigihnk());
                    twoWeekFile.setIfcTratkihuryouumu(twoWeekHensyuSyoriKekkaBean.getTratkihuryouumu());
                    twoWeekFile.setIfcBengosikenkaiumu(twoWeekHensyuSyoriKekkaBean.getBengosikenkaiumu());
                    twoWeekFile.setIfcKujyouumukbn(twoWeekHensyuSyoriKekkaBean.getKujyouUmu());
                    twoWeekFile.setIfcJimumissumu(twoWeekHensyuSyoriKekkaBean.getJimumissumu());
                    twoWeekFile.setIfcSindansyoryoushryouhi(twoWeekHensyuSyoriKekkaBean.getSindansyoryoushryouhi());
                    twoWeekFile.setIfcSaiesuhigaitoukbn(twoWeekHensyuSyoriKekkaBean.getSaiesuhigaitoukbn());

                    twoWeekFileLst.add(twoWeekFile);
                    nisyuukanKensuu = nisyuukanKensuu + 1;
                }
            }
        }

        BzFileUploadUtil bzFileUploadUtilTwoWeek = SWAKInjector.getInstance(BzFileUploadUtil.class);
        C_ErrorKbn toriErrorKbnTwoWeek = bzFileUploadUtilTwoWeek.exec(C_FileSyuruiCdKbn.SI_HIGAITOUITIRAN2WEEK,
            twoWeekFileLst, true);
        if (C_ErrorKbn.ERROR.eq(toriErrorKbnTwoWeek)) {
            throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(toujitsuKensuu),
            MessageUtil.getMessage(MessageId.IJW1053)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(torikomiKensuu),
            MessageUtil.getMessage(MessageId.IJW1054)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(nisyuukanKensuu),
            MessageUtil.getMessage(MessageId.IJW1055)));
    }

    private List<SiHigaitouIchiranTyuusyutuSyoriKekkaBean> getSiHigaitouIchiran(C_SyorikekkaKbn pSyorikekkaKbn,
        String[] pSikinouModeIdKbns, BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo,
        C_SyoriJyoutaiKbn pSyoriJyoutaiKbn, C_ShrKekkaKbn pShrKekkaKbn) {
        List<SiHigaitouIchiranTyuusyutuSyoriKekkaBean> siHigaitouKekkaBeanLst = Lists.newArrayList();
        String syoNo = "";
        String skNo = "";

        try (ExDBResults<JT_SateiSyouninRireki> sateiSyouninRirekiLst = siharaiDomManager
            .getSateiSyouninRirekisBySyorikekkakbnSyoriYmdKossyorisscds(pSyorikekkaKbn, pSyoriYmdFrom, pSyoriYmdTo,
                pSikinouModeIdKbns)) {
            for (JT_SateiSyouninRireki sateiSyouninRireki : sateiSyouninRirekiLst) {
                if (sateiSyouninRireki.getSyono().equals(syoNo) && sateiSyouninRireki.getSkno().equals(skNo)) {
                    continue;
                }
                syoNo = sateiSyouninRireki.getSyono();
                skNo = sateiSyouninRireki.getSkno();

                JT_SkKihon skKihon = siharaiDomManager.getSkKihon(skNo, syoNo);

                BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
                BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryInBean.class);
                bzGetProcessSummaryInBean.setJimuTetuzukiCd(TeisuuSiharai.JIMUTETUZUKICD_SISIBOU);
                bzGetProcessSummaryInBean.setTaskIds(TeisuuSiharai.TASKID_HIGAITOUITIRANS);
                bzGetProcessSummaryInBean.setSyoNo(syoNo);
                bzGetProcessSummaryInBean.setSkNos(new String[] { skNo });
                bzGetProcessSummaryInBean.setSyukouteiSiborikomiUmu(C_UmuKbn.ARI);

                List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary
                    .exec(bzGetProcessSummaryInBean);

                if (bzGetProcessSummaryOutBeanLst.size() != 0) {
                    if ((C_SyoriJyoutaiKbn.SYORITYUU.eq(skKihon.getSyorijyoutaikbn()))
                        && (C_ShrKekkaKbn.SHR.eq(skKihon.getShrkekkakbn()))) {
                        continue;
                    }
                    SiHigaitouIchiranTyuusyutuSyoriKekkaBean siHigaitouKekkaBean = SWAKInjector
                        .getInstance(SiHigaitouIchiranTyuusyutuSyoriKekkaBean.class);
                    siHigaitouKekkaBean.setSyoNo(syoNo);
                    siHigaitouKekkaBean.setSkNo(skNo);
                    siHigaitouKekkaBeanLst.add(siHigaitouKekkaBean);
                }
                else {
                    if (pSyoriJyoutaiKbn.eq(skKihon.getSyorijyoutaikbn())
                        && pShrKekkaKbn.eq(skKihon.getShrkekkakbn())) {
                        SiHigaitouIchiranTyuusyutuSyoriKekkaBean siHigaitouKekkaBean = SWAKInjector
                            .getInstance(SiHigaitouIchiranTyuusyutuSyoriKekkaBean.class);
                        siHigaitouKekkaBean.setSyoNo(syoNo);
                        siHigaitouKekkaBean.setSkNo(skNo);
                        siHigaitouKekkaBeanLst.add(siHigaitouKekkaBean);
                    }
                }
            }
        }
        return siHigaitouKekkaBeanLst;
    }

    private SiHigaitouIchiranHensyuSyoriKekkaBean editSiHigaitouIchiran(String pSkNo, String pSyoNo) {
        SiHigaitouIchiranHensyuSyoriKekkaBean hensyuSyoriKekkaBean = SWAKInjector
            .getInstance(SiHigaitouIchiranHensyuSyoriKekkaBean.class);

        KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);
        KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);

        keiyakuPrm.setSyono(pSyoNo);
        keiyakuPrm.setINayoseyh(C_NayoseYouhi.HUYOU);

        keiyakuInfoSyutoku.getInfos(keiyakuPrm);
        List<JT_SiKykKihon> siKykKihonLst = keiyakuInfoSyutoku.getKykKihons();

        if (siKykKihonLst.get(0) != null) {
            hensyuSyoriKekkaBean.setKyksyameiKn(siKykKihonLst.get(0).getKyknmkn());
            hensyuSyoriKekkaBean.setKyksyameiKj(siKykKihonLst.get(0).getKyknmkj());
            hensyuSyoriKekkaBean.setKyksyaSeiymd(siKykKihonLst.get(0).getKykseiymd());
            hensyuSyoriKekkaBean.setKykAdr(siKykKihonLst.get(0).getTsinadr1kj()
                + siKykKihonLst.get(0).getTsinadr2kj() + siKykKihonLst.get(0).getTsinadr3kj());
            hensyuSyoriKekkaBean.setSiteiDairimeiKn(siKykKihonLst.get(0).getSiteidruktnmkn());
            hensyuSyoriKekkaBean.setSiteiDairimeiKj(siKykKihonLst.get(0).getSiteidruktnmkj());
            hensyuSyoriKekkaBean.setHhknmeiKn(siKykKihonLst.get(0).getHhknnmkn());
            hensyuSyoriKekkaBean.setHhknmeiKj(siKykKihonLst.get(0).getHhknnmkj());
            hensyuSyoriKekkaBean.setHhknSeiymd(siKykKihonLst.get(0).getHhknseiymd());
            hensyuSyoriKekkaBean.setKykymd(siKykKihonLst.get(0).getSiKykSyouhns().get(0).getKykymd());

            setSeikyuuInfo(pSkNo, pSyoNo, siKykKihonLst, hensyuSyoriKekkaBean);
        }
        return hensyuSyoriKekkaBean;
    }

    private void setSeikyuuInfo(String pSkNo, String pSyoNo,
        List<JT_SiKykKihon> pSiKykKihonLst, SiHigaitouIchiranHensyuSyoriKekkaBean pHensyuSyoriKekkaBean) {
        Integer maxSeikyuurirekino = null;
        JT_SkKihon skKihon = siharaiDomManager.getSkKihon(pSkNo, pSyoNo);
        if (skKihon != null) {
            if (C_SeikyuuSyubetu.SB.eq(skKihon.getSeikyuusyubetu())) {
                pHensyuSyoriKekkaBean.setHokenknSeikyuuKbn("1");
            }
            maxSeikyuurirekino = siharaiDomManager.getSkMaxSeikyuurirekinoBySknoSyono(pSkNo, pSyoNo);
            if (maxSeikyuurirekino != null) {
                JT_Sk sk = skKihon.getSkBySeikyuurirekino(maxSeikyuurirekino);
                if (sk != null) {
                    pHensyuSyoriKekkaBean.setSyoruiUkeymd(sk.getSyoruiukeymd());
                    pHensyuSyoriKekkaBean.setTsinYno(sk.getTsinyno());
                    pHensyuSyoriKekkaBean.setTsinAdr(sk.getTsinadr1kj() + sk.getTsinadr2kj() + sk.getTsinadr3kj());
                    pHensyuSyoriKekkaBean.setEnsinkbn(sk.getSinsagendokknkbn().getValue());
                    pHensyuSyoriKekkaBean.setTdnnissuu(sk.getRikoukityuutuudannissuu());
                    pHensyuSyoriKekkaBean.setSaigaimousideumu(sk.getSaigaimousideumukbn().getValue());
                    pHensyuSyoriKekkaBean.setSindansyoryoushryouhi(sk.getSindansyoryoushryouhikbn().getValue());
                    pHensyuSyoriKekkaBean.setSiin(sk.getSiinkbn().getContent());

                    setSeikyuuJiyuuAndSeikyuuByoumei(sk, pHensyuSyoriKekkaBean);

                    JT_SibouSateiChkInfo sibouSateiChkInfo = sk.getSibouSateiChkInfo();
                    if (sibouSateiChkInfo != null) {
                        if (C_NoinitUmuKbn.ARI.eq(sibouSateiChkInfo.getKujyouumukbn())) {
                            pHensyuSyoriKekkaBean.setKujyouUmu("1");
                        }

                        if (C_NoinitUmuKbn.ARI.eq(sibouSateiChkInfo.getBengosikenkaiumukbn())) {
                            pHensyuSyoriKekkaBean.setBengosikenkaiumu("1");
                        }

                        if (C_NoinitUmuKbn.ARI.eq(sibouSateiChkInfo.getJimumissumukbn())) {
                            pHensyuSyoriKekkaBean.setJimumissumu("1");
                        }
                    }

                    setSateiMeigiHenkouInfo(sk, pHensyuSyoriKekkaBean);

                    setToriatukaiFuryouInfo(sk, pHensyuSyoriKekkaBean);

                    setSateiSyouninRirekiInfo(skKihon, sk, pHensyuSyoriKekkaBean);

                    JT_TtdkRireki ttdkRireki = siharaiDomManager.getTtdkRirekisBySknoSyonoSyorikekkakbnsKossyorisscds(
                        pSkNo, pSyoNo, new String[] { C_SikinouModeIdKbn.SATEI3.getValue(),
                            C_SikinouModeIdKbn.SATEI4.getValue() },
                            new C_SyorikekkaKbn[] { C_SyorikekkaKbn.HUSIHARAI, C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU });
                    if (ttdkRireki != null) {
                        pHensyuSyoriKekkaBean.setKessaiymd(ttdkRireki.getSyoriYmd());
                    }

                    JT_SiKykSyouhn siKykSyouhnSyu = new JT_SiKykSyouhn();

                    List<JT_SiKykSyouhn> siKykSyouhnLst = pSiKykKihonLst.get(0).getSiKykSyouhns();

                    for (JT_SiKykSyouhn siKykSyouhn : siKykSyouhnLst) {
                        if (C_SyutkKbn.SYU.eq(siKykSyouhn.getSyutkkbn())) {
                            siKykSyouhnSyu = siKykSyouhn;
                            break;
                        }
                    }

                    BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(siKykSyouhnSyu.getSyouhncd(),
                        siKykSyouhnSyu.getSyouhnsdno());
                    if (syouhnZokusei != null) {
                        pHensyuSyoriKekkaBean.setHknnm(syouhnZokusei.getSyouhnnmsyouken());
                    }

                    CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);

                    C_ErrorKbn errorKbn = calcHkShrKngk.execByKeisanWExt(
                        pSyoNo, pHensyuSyoriKekkaBean.getSbymd(), sk.getSiinkbn(), C_HokenkinsyuruiKbn.SBHOKENKIN,
                        pSiKykKihonLst.get(0).getSdpdkbn(), pSiKykKihonLst.get(0).getHrkkeiro());

                    if (C_ErrorKbn.OK.eq(errorKbn)) {
                        CalcHkShrKngkBean calcHkShrKngkBean = calcHkShrKngk.getCalcHkShrKngkBean();
                        pHensyuSyoriKekkaBean.setSbs(calcHkShrKngkBean.getSibousGk().toFormatStringWithUnit());
                        pHensyuSyoriKekkaBean.setSaigaisbs(calcHkShrKngkBean.getSaigaisGk().toFormatStringWithUnit());
                    }

                }

            }

        }
    }

    private void setSeikyuuJiyuuAndSeikyuuByoumei(JT_Sk pSk,
        SiHigaitouIchiranHensyuSyoriKekkaBean pHensyuSyoriKekkaBean) {

        List<JT_SkJiyuu> skJiyuuLst = pSk.getSkJiyuus();

        if (skJiyuuLst.size() != 0) {
            List<JT_SkByoumei> skByoumeiLst = skJiyuuLst.get(0).getSkByoumeis();

            if (skByoumeiLst.size() != 0) {
                pHensyuSyoriKekkaBean.setSeikyuuByoumei(skByoumeiLst.get(0).getByoumeikj());
            }

            pHensyuSyoriKekkaBean.setSbymd(skJiyuuLst.get(0).getSibouymd());

        }
    }

    private void setSateiMeigiHenkouInfo(JT_Sk pSk, SiHigaitouIchiranHensyuSyoriKekkaBean pHensyuSyoriKekkaBean) {

        JT_SateiMeigihenkouInfo sateiMeigihenkouInfo = pSk.getSateiMeigihenkouInfo();

        if (sateiMeigihenkouInfo != null) {

            pHensyuSyoriKekkaBean.setMeigihnk(sateiMeigihenkouInfo.getMeihenyuukoumukoukbn().getValue());
        } else{
            pHensyuSyoriKekkaBean.setMeigihnk(C_MeihenYuukouMukouKbn.BLNK.getValue());
        }
    }

    private void setToriatukaiFuryouInfo(JT_Sk pSk, SiHigaitouIchiranHensyuSyoriKekkaBean pHensyuSyoriKekkaBean) {

        JT_Toriatukaifuryouinfo toriatukaifuryouinfo = pSk.getToriatukaifuryouinfo();

        if (toriatukaifuryouinfo != null &&
            C_NoinitUmuKbn.ARI.eq(toriatukaifuryouinfo.getTratkihuryouumukbn())) {

            pHensyuSyoriKekkaBean.setTratkihuryouumu("1");
        }
    }

    private void setSateiSyouninRirekiInfo(JT_SkKihon pSkKihon, JT_Sk pSk,
        SiHigaitouIchiranHensyuSyoriKekkaBean pHensyuSyoriKekkaBean) {
        List<JT_SateiSyouninRireki> sateiSyouninRirekiLst = pSkKihon.getSateiSyouninRirekis();
        if (sateiSyouninRirekiLst.size() != 0) {
            SortJT_SateiSyouninRireki sateiSyouninRirekiSort = SWAKInjector
                .getInstance(SortJT_SateiSyouninRireki.class);
            List<JT_SateiSyouninRireki> sateiSyouninRirekiSortLst = sateiSyouninRirekiSort
                .OrderJT_SateiSyouninRirekiByGyoumuKousinTimeDesc(sateiSyouninRirekiLst);

            pHensyuSyoriKekkaBean.setSessyouSisyaCd(sateiSyouninRirekiSortLst.get(0).getSessyousisyacd());
            if (C_YouhiblnkKbn.YOU.eq(sateiSyouninRirekiSortLst.get(0).getSessyouyhkbn())) {
                pHensyuSyoriKekkaBean.setSessyouYhKbn(C_YouhiblnkKbn.YOU.getValue());
            }
            pHensyuSyoriKekkaBean.setHushrGeninKbn(sateiSyouninRirekiSortLst.get(0).getHushrgeninkbn().getContent());

            if (C_YouhiblnkKbn.YOU.eq(sateiSyouninRirekiSortLst.get(0).getSessyouyhkbn())) {
                if (C_BlnktkumuKbn.ARI.eq(pSk.getSaigaimousideumukbn())) {
                    pHensyuSyoriKekkaBean.setSaiesuhigaitoukbn("A");
                }
                else if (C_BlnktkumuKbn.NONE.eq(pSk.getSaigaimousideumukbn())) {
                    pHensyuSyoriKekkaBean.setSaiesuhigaitoukbn("B");
                }
            }
            else if (C_YouhiblnkKbn.HUYOU.eq(sateiSyouninRirekiSortLst.get(0).getSessyouyhkbn())) {
                if (C_BlnktkumuKbn.NONE.eq(pSk.getSaigaimousideumukbn())) {
                    pHensyuSyoriKekkaBean.setSaiesuhigaitoukbn("C");
                }
            }

            if (!BizUtil.isBlank(pHensyuSyoriKekkaBean.getSessyouSisyaCd())) {

                BzGetSosikiData sosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);
                BzGetSosikiDataBean getSosikiDataBean = sosikiData.exec(sateiSyouninRirekiSortLst.get(0)
                    .getSessyousisyacd() + "0000", null);

                if (getSosikiDataBean != null) {
                    pHensyuSyoriKekkaBean.setSessyousisyanm(getSosikiDataBean.getKanjisosikinm20());
                }
            }

            List<JT_SateiSyouninRireki> itijiKessainmLst = pSkKihon.getSateiSyouninRirekisByKossyorisscdSyorikekkakbns(
                C_SikinouModeIdKbn.SATEI1.getValue(),
                new C_SyorikekkaKbn[] { C_SyorikekkaKbn.HUSIHARAI, C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU });

            if (itijiKessainmLst.size() != 0) {
                List<JT_SateiSyouninRireki> itijiKessainmSortLst = sateiSyouninRirekiSort
                    .OrderJT_SateiSyouninRirekiByGyoumuKousinTimeDesc(itijiKessainmLst);

                pHensyuSyoriKekkaBean.setGyoumuKousinsyaId(itijiKessainmSortLst.get(0).getGyoumuKousinsyaId());

                AM_User userInfo = baseDomManager.getUser(pHensyuSyoriKekkaBean.getGyoumuKousinsyaId());
                if (userInfo != null) {
                    pHensyuSyoriKekkaBean.setItijiKessainm(userInfo.getUserNm());
                }

                pHensyuSyoriKekkaBean.setSyorikekkakbn(itijiKessainmSortLst.get(0).getSyorikekkakbn().getContent());
            }

            List<JT_SateiSyouninRireki> kakninUmuLst = pSkKihon.getSateiSyouninRirekisByKossyorisscdSyorikekkakbns(
                C_SikinouModeIdKbn.SATEI2.getValue(),
                new C_SyorikekkaKbn[] { C_SyorikekkaKbn.KAKUNIN, C_SyorikekkaKbn.TYUUKANKAKUNIN,C_SyorikekkaKbn.TUIKAKAKUNIN } );
            if (kakninUmuLst.size() != 0) {
                pHensyuSyoriKekkaBean.setKakninUmu("1");
            }

            List<JT_SateiSyouninRireki> kaiketuymdLst = pSkKihon.getSateiSyouninRirekisBySyorikekkakbnKossyorisscds(
                C_SyorikekkaKbn.KANRYOU, new String[] { C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue(),
                    C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue() });
            if (kaiketuymdLst.size() != 0) {
                List<JT_SateiSyouninRireki> kaiketuymdSortLst = sateiSyouninRirekiSort
                    .OrderJT_SateiSyouninRirekiByGyoumuKousinTimeDesc(kaiketuymdLst);
                pHensyuSyoriKekkaBean.setKaiketuymd(kaiketuymdSortLst.get(0).getKaiketuymd());
            }
        }
    }
}