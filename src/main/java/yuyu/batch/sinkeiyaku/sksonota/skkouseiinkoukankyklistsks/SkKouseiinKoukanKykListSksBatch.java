package yuyu.batch.sinkeiyaku.sksonota.skkouseiinkoukankyklistsks;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzdairiten.BzGetBsInfo;
import yuyu.common.biz.bzdairiten.BzGetBsInfoBean;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.biz.report.ViewReport;
import yuyu.def.MessageId;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.sinkeiyaku.file.csv.SkKoukankeiyakuLayoutFile;
import yuyu.def.sinkeiyaku.file.csv.SkKouseiinkeiyakuLayoutFile;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Lists;

/**
 * 新契約 その他 構成員交換契約リスト作成処理
 */
public class SkKouseiinKoukanKykListSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BatchParam batchParam;

    private final String LEFTKAGGOU = "（";

    private final String RIGHTKAGGOU = "）";

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDateYM cyuusyutsuYm = batchParam.getSyoriYmd().getBizDateYM();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003)
            , String.valueOf(batchParam.getSyoriYmd())));

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        long kouseiCount = 0;

        List<SkKouseiinkeiyakuLayoutFile> skKouseiinkeiyakuLayoutFileLst = Lists.newArrayList();

        List<HT_MosDairiten> mosDairitenLst =
            sinkeiyakuDomManager.getKoseiinKeiyakuGaitouKeiyakusBySyoriym(cyuusyutsuYm);

        BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

        BzGetBsInfo bzGetBsInfo = SWAKInjector.getInstance(BzGetBsInfo.class);

        for (HT_MosDairiten mosDairiten : mosDairitenLst) {

            if (mosDairiten.getRenno() != 1) {

                continue;
            }

            SkKouseiinkeiyakuLayoutFile skKouseiinkeiyakuLayoutFile = new SkKouseiinkeiyakuLayoutFile();
            String dairitenNm = "";
            String muNm = "";

            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = bzGetAgInfo.exec(mosDairiten.getTratkiagcd());

            if (bzGetAgInfoBeanLst.size() > 0) {
                dairitenNm = bzGetAgInfoBeanLst.get(0).getKanjiDairitenNm();
            }

            BzGetBsInfoBean bzGetBsInfoBean = bzGetBsInfo.exec(mosDairiten.getBosyuucd());

            if (bzGetBsInfoBean != null) {
                muNm = bzGetBsInfoBean.getKanjiBosyuuninNm();
            }

            String keiyakuKubunNm = null;

            if (C_KykKbn.KEIHI_DOUITU.eq(mosDairiten.getSyoriCTL().getMosKihon().getKykkbn())) {
                keiyakuKubunNm = mosDairiten.getSyoriCTL().getMosKihon().getHhknnmkj();
            }
            else if (C_KykKbn.KEIHI_BETU.eq(mosDairiten.getSyoriCTL().getMosKihon().getKykkbn())) {
                keiyakuKubunNm = mosDairiten.getSyoriCTL().getMosKihon().getKyknmkj()
                    + LEFTKAGGOU
                    + mosDairiten.getSyoriCTL().getMosKihon().getHhknnmkj()
                    + RIGHTKAGGOU;
            }
            else {
                keiyakuKubunNm = "";
            }

            skKouseiinkeiyakuLayoutFile.setIfcDrtennmkj(dairitenNm);

            skKouseiinkeiyakuLayoutFile.setIfcDrtencd(mosDairiten.getTratkiagcd());

            skKouseiinkeiyakuLayoutFile.setIfcBosyuutantounm(muNm);

            skKouseiinkeiyakuLayoutFile.setIfcMosno(mosDairiten.getSyoriCTL().getMosno());

            skKouseiinkeiyakuLayoutFile.setIfcMosymd(
                String.valueOf(mosDairiten.getSyoriCTL().getMosKihon().getMosymd()));

            skKouseiinkeiyakuLayoutFile.setIfcKyknmkj(keiyakuKubunNm);

            skKouseiinkeiyakuLayoutFile.setIfcHokenryou(
                ViewReport.editCommaTuuka(mosDairiten.getSyoriCTL().getMosKihon().getMosfstpkei(), BizUtil.ZERO_FILL));

            skKouseiinkeiyakuLayoutFile.setIfcKouseiinnkykpattern(
                mosDairiten.getSyoriCTL().getKouseiinkykkbn().getValue());

            skKouseiinkeiyakuLayoutFile.setIfcTokkijikou(
                C_BlnktkumuKbn.getContentByValue(
                    C_BlnktkumuKbn.PATTERN_KANJI,
                    String.valueOf(mosDairiten.getSyoriCTL().getMosKihon().getKouseiinkyktkjkumukbn())
                    )
                );

            skKouseiinkeiyakuLayoutFile.setIfcHrkkaisuunaiyou(
                C_Hrkkaisuu.getContentByValue(
                    C_Hrkkaisuu.PATTERN_DEFAULT,
                    String.valueOf(mosDairiten.getSyoriCTL().getMosKihon().getHrkkaisuu())
                    )
                );

            skKouseiinkeiyakuLayoutFileLst.add(skKouseiinkeiyakuLayoutFile);

            kouseiCount = kouseiCount + 1;
        }

        bzFileUploadUtil.exec(C_FileSyuruiCdKbn.SK_KOUSEIINKYKLST, skKouseiinkeiyakuLayoutFileLst, true);

        long koukanCount = 0;

        List<SkKoukankeiyakuLayoutFile> skKoukankeiyakuLayoutFileLst = Lists.newArrayList();

        List<HT_MosDairiten> mosDairitenLst1 =
            sinkeiyakuDomManager.getKokanKeiyakuGaitouKeiyakusBySyoriym(cyuusyutsuYm);

        for (HT_MosDairiten mosDairiten : mosDairitenLst1) {

            if (mosDairiten.getRenno() != 1) {

                continue;
            }

            SkKoukankeiyakuLayoutFile skKoukankeiyakuLayoutFile = new SkKoukankeiyakuLayoutFile();

            List<BzGetAgInfoBean> bzGetAgInfoBeanLst= bzGetAgInfo.exec(mosDairiten.getTratkiagcd());

            String dairitenNm = "";

            if (bzGetAgInfoBeanLst.size() > 0) {
                dairitenNm = bzGetAgInfoBeanLst.get(0).getKanjiDairitenNm();
            }

            BzGetBsInfoBean bzGetBsInfoBean = bzGetBsInfo.exec(mosDairiten.getBosyuucd());

            String muNm = "";

            if (bzGetBsInfoBean != null) {
                muNm = bzGetBsInfoBean.getKanjiBosyuuninNm();
            }

            String keiyakuNm = null;

            if (C_KykKbn.KEIHI_DOUITU.eq(mosDairiten.getSyoriCTL().getMosKihon().getKykkbn())) {

                keiyakuNm = mosDairiten.getSyoriCTL().getMosKihon().getHhknnmkj();
            }

            else if (C_KykKbn.KEIHI_BETU.eq(mosDairiten.getSyoriCTL().getMosKihon().getKykkbn())) {
                keiyakuNm = mosDairiten.getSyoriCTL().getMosKihon().getKyknmkj()
                    + LEFTKAGGOU
                    + mosDairiten.getSyoriCTL().getMosKihon().getHhknnmkj()
                    + RIGHTKAGGOU;
            }

            else {
                keiyakuNm = "";
            }

            skKoukankeiyakuLayoutFile.setIfcDrtennmkj(dairitenNm);

            skKoukankeiyakuLayoutFile.setIfcDrtencd(mosDairiten.getTratkiagcd());

            skKoukankeiyakuLayoutFile.setIfcBosyuutantounm(muNm);

            skKoukankeiyakuLayoutFile.setIfcMosno(mosDairiten.getSyoriCTL().getMosno());

            skKoukankeiyakuLayoutFile.setIfcMosymd(String.valueOf(mosDairiten.getSyoriCTL().getMosKihon().
                getMosymd()));

            skKoukankeiyakuLayoutFile.setIfcKyknmkj(keiyakuNm);

            skKoukankeiyakuLayoutFile.setIfcHokenryou(
                ViewReport.editCommaTuuka(
                    mosDairiten.getSyoriCTL().getMosKihon().getMosfstpkei(),
                    BizUtil.ZERO_FILL
                    )
                );

            skKoukankeiyakuLayoutFile.setIfcKinmusakinm(
                mosDairiten.getSyoriCTL().getMosKihon().getKoukankykkinmusakinm());

            skKoukankeiyakuLayoutFile.setIfcSyokumunaiyou(
                mosDairiten.getSyoriCTL().getMosKihon().getKoukankyksyokumunaiyou());

            skKoukankeiyakuLayoutFile.setIfcTokkijikou(
                C_BlnktkumuKbn.getContentByValue(
                    C_BlnktkumuKbn.PATTERN_KANJI,
                    String.valueOf(mosDairiten.getSyoriCTL().getMosKihon().getKoukankyktkjkumukbn())
                    )
                );

            skKoukankeiyakuLayoutFile.setIfcHrkkaisuunaiyou(C_Hrkkaisuu.getContentByValue(
                C_Hrkkaisuu.PATTERN_DEFAULT,
                String.valueOf(mosDairiten.getSyoriCTL().getMosKihon().getHrkkaisuu())));

            skKoukankeiyakuLayoutFileLst.add(skKoukankeiyakuLayoutFile);

            koukanCount = koukanCount + 1;
        }

        bzFileUploadUtil.exec(C_FileSyuruiCdKbn.SK_KOUKANKYKLST, skKoukankeiyakuLayoutFileLst, true);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(kouseiCount), "構成員契約リスト"));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(koukanCount), "交換契約リスト"));
    }

}
