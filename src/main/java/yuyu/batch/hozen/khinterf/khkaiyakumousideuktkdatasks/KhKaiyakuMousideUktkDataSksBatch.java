package yuyu.batch.hozen.khinterf.khkaiyakumousideuktkdatasks;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzdairiten.BzGetBsInfo;
import yuyu.common.biz.bzdairiten.BzGetBsInfoBean;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KeisanKihrkP;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IW_KhKaiyakuWk;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.file.csv.KhKaiyakuMousideUktkDataFile;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 解約申出受付データ作成クラス
 */
public class KhKaiyakuMousideUktkDataSksBatch implements Batch {

    private static final String SPACE_TWO = "  ";

    private static final String TYSYTTAISYOUTABLEID = "IW_KhKaiyakuWk";

    private static final String RECOVERYFILTERID = "Bz003";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        int kensu = 0;
        List<KhKaiyakuMousideUktkDataFile> khKaiyakuMousideUktkDataFiles = new ArrayList<>();
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);
        BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);
        BzGetBsInfo bzGetBsInfo = SWAKInjector.getInstance(BzGetBsInfo.class);
        KeisanKihrkP keisanKihrkP = SWAKInjector.getInstance(KeisanKihrkP.class);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        try (ExDBResults<IW_KhKaiyakuWk> exDBResults =
            hozenDomManager.getKhKaiyakuWksByKakutyoujobcdSkssakuseiymd(
                bzBatchParam.getIbKakutyoujobcd()
                , bzBatchParam.getSyoriYmd())) {

            for (IW_KhKaiyakuWk iwKhKaiyakuWk : exDBResults) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(iwKhKaiyakuWk.getKouteikanriid());

                KhKaiyakuMousideUktkDataFile khKaiyakuMousideUktkDataFile =
                    SWAKInjector.getInstance(KhKaiyakuMousideUktkDataFile.class);
                String ifcKydatkidrtencd = "";
                String gensyojiyukbn = SPACE_TWO;
                String idoKbn = SPACE_TWO;
                BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
                    SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
                String skeibsyknjdrten = "";
                String kanjioyadrtennm = "";
                String oyadrtencd = "";
                String bosyuucd = "";
                String bosyuunm = "";
                String keisyousakidrtencd = "";
                String kanjidairitennm = "";
                String daibuncd = "";
                String dairitencd = "";

                bzGetProcessSummaryInBean.setKouteiKanriId(iwKhKaiyakuWk.getKouteikanriid());
                bzGetProcessSummaryInBean.setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KAIYAKU);
                bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);

                List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeans =
                    bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

                if (bzGetProcessSummaryOutBeans.size() > 0) {
                    IT_KykKihon itKykKihon = hozenDomManager.getKykKihon(iwKhKaiyakuWk.getSyono());

                    itKykKihon = IT_KykKihonDetacher.detachKykSyaHhknSyaKykSyouhntouched(itKykKihon);

                    IT_KykSya itKykSya = itKykKihon.getKykSya();

                    IT_HhknSya itHhknSya = itKykKihon.getHhknSya();

                    List<IT_KykSyouhn> itKykSyouhnList = itKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

                    if (itKykKihon.getKykSya() != null && itKykKihon.getHhknSya() != null &&
                        itKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).size() != 0) {

                        IT_KykKihon itKykKihon1 = hozenDomManager.getKykKihon(iwKhKaiyakuWk.getSyono());

                        itKykKihon1 = IT_KykKihonDetacher.detachKykDairitentouched(itKykKihon1);

                        List<IT_KykDairiten> itKykDairitenLst = itKykKihon1.getKykDairitens();

                        IT_KykSyouhn itKykSyouhn = itKykSyouhnList.get(0);

                        BM_SyouhnZokusei bmSyouhnZokusei = itKykSyouhn.getSyouhnZokusei();

                        if(C_YuukousyoumetuKbn.SYOUMETU.eq(itKykSyouhn.getYuukousyoumetukbn())) {
                            continue;
                        }

                        String zennouHyouji = null;

                        if (C_Kykjyoutai.ZENNOU.eq(itKykSyouhn.getKykjyoutai())) {
                            zennouHyouji = "1";
                        }
                        else {
                            zennouHyouji = "0";
                        }

                        C_Tuukasyu hrkpTuukasyu = henkanTuuka.henkanTuukaTypeToKbn(itKykKihon1.getHrkp().getType());

                        String hrkhouhouk = "";

                        if (C_Hrkkaisuu.TUKI.eq(itKykKihon1.getHrkkaisuu())) {

                            if (C_TkiktbrisyuruiKbn.BLNK.eq(itKykKihon1.getTikiktbrisyuruikbn()) ||
                                C_TkiktbrisyuruiKbn.NONE.eq(itKykKihon1.getTikiktbrisyuruikbn())) {
                                hrkhouhouk = "8";
                            }
                            else if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(itKykKihon1.getTikiktbrisyuruikbn())) {
                                hrkhouhouk = "6";
                            }
                            else if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(itKykKihon1.getTikiktbrisyuruikbn())) {
                                hrkhouhouk = "5";
                            }
                        }
                        else if (C_Hrkkaisuu.HALFY.eq(itKykKihon1.getHrkkaisuu())) {
                            hrkhouhouk = "6";
                        }
                        else if (C_Hrkkaisuu.NEN.eq(itKykKihon1.getHrkkaisuu())) {
                            hrkhouhouk = "5";
                        }
                        else if (C_Hrkkaisuu.ITIJI.eq(itKykKihon1.getHrkkaisuu())) {
                            hrkhouhouk = "1";
                        }
                        else {
                            hrkhouhouk = "0";
                        }

                        for (IT_KykDairiten itKykDairiten : itKykDairitenLst) {
                            if (itKykDairiten.getDrtenrenno() == 1) {
                                dairitencd = itKykDairiten.getDrtencd();
                                bosyuucd = itKykDairiten.getBosyuucd();
                                daibuncd = itKykDairiten.getBunwari().toString();
                            }
                            else if (itKykDairiten.getDrtenrenno() == 2) {
                                ifcKydatkidrtencd = itKykDairiten.getDrtencd();
                            }
                        }

                        List<BzGetAgInfoBean> bzGetAgInfoBeans = bzGetAgInfo.exec(dairitencd);
                        for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeans) {
                            if (C_DiritenjyouhouKbn.SHITEIKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                                skeibsyknjdrten = bzGetAgInfoBean.getKanjiDairitenNm();
                                kanjioyadrtennm = bzGetAgInfoBean.getKanjiHoujinSyougou();
                            }
                            else if (C_DiritenjyouhouKbn.SHITEIOYA.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                                oyadrtencd = bzGetAgInfoBean.getDrtenCd();
                            }
                            else if (C_DiritenjyouhouKbn.KEISYOUKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                                keisyousakidrtencd = bzGetAgInfoBean.getDrtenCd();
                                kanjidairitennm = bzGetAgInfoBean.getKanjiDairitenNm();
                            }
                        }

                        BzGetBsInfoBean bzGetBsInfoBean = bzGetBsInfo.exec(bosyuucd);

                        if (bzGetBsInfoBean != null) {
                            bosyuunm = bzGetBsInfoBean.getKanjiBosyuuninNm();

                        }

                        IT_KykKihon itKykKihon2 = hozenDomManager.getKykKihon(iwKhKaiyakuWk.getSyono());

                        itKykKihon2 = IT_KykKihonDetacher.detachKhTtdkRirekitouched(itKykKihon2);

                        List<IT_KhTtdkRireki> itKhTtdkRirekis = itKykKihon2.getKhTtdkRirekis();

                        for (IT_KhTtdkRireki itKhTtdkRireki : itKhTtdkRirekis) {
                            if (IKhozenCommonConstants.KINOUID_GENGAKU.equals(itKhTtdkRireki.getGyoumuKousinKinou())) {
                                gensyojiyukbn = "6";
                                idoKbn = "42";
                                break;
                            }
                        }

                        int syouhnHanteikbn = SyouhinUtil.hantei(itKykSyouhn.getSyouhncd());

                        BizCurrency sumhokenryou = null;
                        if (C_UmuKbn.ARI.eq(bmSyouhnZokusei.getItijibrumu())) {
                            sumhokenryou = itKykKihon.getHrkp();
                        }
                        else {
                            C_ErrorKbn kekkakbn = keisanKihrkP.exec(itKykKihon.getSyono(), itKykSyouhn.getKyktuukasyu());

                            if (C_ErrorKbn.ERROR.eq(kekkakbn)) {

                                throw new CommonBizAppException("既払込Ｐ計算が実行できませんでした。");
                            }
                            if(SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == syouhnHanteikbn &&
                                !C_Tuukasyu.JPY.eq(itKykSyouhn.getKyktuukasyu())){
                                sumhokenryou = keisanKihrkP.getKihrkP();
                            }
                            else{
                                sumhokenryou = keisanKihrkP.getYenKihrkP();
                            }
                        }

                        khKaiyakuMousideUktkDataFile.setIfcSyonosyuban(itKykKihon.getSyono());
                        khKaiyakuMousideUktkDataFile.setIfcSkeibsyknjdrten(skeibsyknjdrten);
                        khKaiyakuMousideUktkDataFile.setIfcKnjoyadrtennm(kanjioyadrtennm);
                        khKaiyakuMousideUktkDataFile.setIfcKnjkyksyamei(itKykSya.getKyknmkj());
                        khKaiyakuMousideUktkDataFile.setIfcMusymd(itKykKihon.getMosymd().toString());
                        khKaiyakuMousideUktkDataFile.setIfcKnjsyuhsynm(bmSyouhnZokusei.getSyouhnnmsyouken() +
                            "「" + itKykKihon.getAisyoumeikbn().getContent() + "」");
                        khKaiyakuMousideUktkDataFile.setIfcZennouhyouji(zennouHyouji);
                        khKaiyakuMousideUktkDataFile.setIfcHrkp(itKykKihon1.getHrkp().toString());
                        khKaiyakuMousideUktkDataFile.setIfcHrkptuukasyu(hrkpTuukasyu.toString());
                        khKaiyakuMousideUktkDataFile.setIfcOyadrtencd(oyadrtencd);
                        khKaiyakuMousideUktkDataFile.setIfcKeip(sumhokenryou.toString());
                        khKaiyakuMousideUktkDataFile.setIfcHrkhou(hrkhouhouk);
                        khKaiyakuMousideUktkDataFile.setIfcSkeibsyknjdrtencd(dairitencd);
                        khKaiyakuMousideUktkDataFile.setIfcKydatkidrtencd(ifcKydatkidrtencd);
                        khKaiyakuMousideUktkDataFile.setIfcBosyuucd(bosyuucd);
                        khKaiyakuMousideUktkDataFile.setIfcBosyuunm(bosyuunm);
                        khKaiyakuMousideUktkDataFile.setIfcKnjhknmei(itHhknSya.getHhknnmkj());
                        khKaiyakuMousideUktkDataFile.setIfcDrtenhydrtencd(keisyousakidrtencd);
                        khKaiyakuMousideUktkDataFile.setIfcKnjdrtennm(kanjidairitennm);
                        khKaiyakuMousideUktkDataFile.setIfcDaibuncd(daibuncd);
                        khKaiyakuMousideUktkDataFile.setIfcDrtenzksidrtencd(keisyousakidrtencd);
                        khKaiyakuMousideUktkDataFile.setIfcGensyojiyukbn(gensyojiyukbn);
                        khKaiyakuMousideUktkDataFile.setIfcIdoKbn(idoKbn);
                        khKaiyakuMousideUktkDataFile.setIfcKykmfkykjyutikbn("6");
                        khKaiyakuMousideUktkDataFile.setIfcKiykinfoymd(iwKhKaiyakuWk.getSkssakuseiymd().toString());

                        khKaiyakuMousideUktkDataFiles.add(khKaiyakuMousideUktkDataFile);

                        kensu++;
                    }
                }
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            bzFileUploadUtil.exec(C_FileSyuruiCdKbn.KH_KAIYAKUMOUSIDEUKTKDATA, khKaiyakuMousideUktkDataFiles, false);

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(kensu)));
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
