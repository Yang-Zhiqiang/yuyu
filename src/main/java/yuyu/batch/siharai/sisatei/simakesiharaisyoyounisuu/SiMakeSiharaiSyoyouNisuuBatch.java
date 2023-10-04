package yuyu.batch.siharai.sisatei.simakesiharaisyoyounisuu;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuPrm;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_NayoseYouhi;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_TanmatuSyuruiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.JT_SiJinsokuShrTtdkInfo;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.JT_TtdkRireki;
import yuyu.def.siharai.file.csv.SiShrShyNsLayoutFile;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Lists;

/**
 * 保険金給付金支払 集計 支払所要日数情報作成
 */
public class SiMakeSiharaiSyoyouNisuuBatch implements Batch {

    private final String SYORICD_SBSATEI = "RC05";

    private final int MAX_KEIKAEIGYOUBISUU = 30;

    private final int TYOUKAJI_SYRHUBIKEIKAEGYBISUU = 999;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        String sysDate = BizDate.getSysDateTimeMilli();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        BizDate syoriStartYmd = BizDate.valueOf(syoriYmd.addMonths(-1).getBizDateYM(), 1);
        BizDate syoriEndYmd = syoriYmd.getBizDateYM().getPreviousMonth().getLastDay();

        try (ExDBResults<JT_SiRireki> exDbResults = siharaiDomManager
            .getSiRirekisBySeikyuusyubetuShrsyoriymdShrkekkakbn
            (syoriStartYmd, syoriEndYmd)) {
            long totalCnt = 0;
            List<SiShrShyNsLayoutFile> siShrShyNsLayoutFileLst = Lists.newArrayList();
            Iterator<JT_SiRireki> jTsiRireki = exDbResults.iterator();
            if(jTsiRireki.hasNext()){
                while (jTsiRireki.hasNext()) {
                    JT_SiRireki siRireki = jTsiRireki.next();
                    KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);
                    KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);
                    keiyakuPrm.setSyono(siRireki.getSyono());
                    keiyakuPrm.setINayoseyh(C_NayoseYouhi.HUYOU);
                    keiyakuInfoSyutoku.getInfos(keiyakuPrm);

                    List<JT_SiKykKihon> siKykKihonLst = keiyakuInfoSyutoku.getKykKihons();
                    JT_SiKykKihon siKykKihon = siKykKihonLst.get(0);

                    if (siKykKihon == null) {
                        throw new BizAppException(MessageId.EBS0004, IT_KykKihon.TABLE_NAME, IT_KykKihon.SYONO, siRireki.getSyono());
                    }

                    JT_SkKihon skKihon = siharaiDomManager.getSkKihon(siRireki.getSkno(), siRireki.getSyono());

                    Integer maxNo = siharaiDomManager.getSkMaxSeikyuurirekinoBySknoSyono(skKihon.getSkno(),
                        skKihon.getSyono());

                    JT_Sk sk = skKihon.getSkBySeikyuurirekino(maxNo);

                    String syoriSosikiCd = "";
                    List<JT_TtdkRireki> ttdRirekiLst = skKihon.getTtdkRirekisByShrsikibetukey(siRireki.getShrsikibetukey());
                    syoriSosikiCd = ttdRirekiLst.get(0).getSyorisosikicd();

                    int checkReturn = BizDateUtil.compareYmd(sk.getSyoruiukeymd(), sk.getHubikanryouymd());

                    BizDate syrhubikeikakijyunbiYmd = null;
                    if (checkReturn == BizDateUtil.COMPARE_GREATER) {
                        syrhubikeikakijyunbiYmd = sk.getSyoruiukeymd();
                    }
                    else {
                        syrhubikeikakijyunbiYmd = sk.getHubikanryouymd();
                    }

                    BizDate kijyunYmd = sk.getSyoruiukeymd();
                    int syoruiKeikaeigyoubisuu = 0;
                    int syoriKeikaeigyoubisuu = 0;
                    int syrhubiKeikaegybisuu = 0;

                    while (BizDateUtil.compareYmd(kijyunYmd, siRireki.getTyakkinymd()) < 0) {
                        kijyunYmd = kijyunYmd.addBusinessDays(1);
                        syoruiKeikaeigyoubisuu++;
                    }

                    if(syoruiKeikaeigyoubisuu > MAX_KEIKAEIGYOUBISUU) {
                        syoruiKeikaeigyoubisuu = MAX_KEIKAEIGYOUBISUU;
                    }

                    kijyunYmd = siRireki.getShrsyoriymd();
                    while (BizDateUtil.compareYmd(kijyunYmd, siRireki.getTyakkinymd()) < 0) {
                        kijyunYmd = kijyunYmd.addBusinessDays(1);
                        syoriKeikaeigyoubisuu++;
                    }

                    if(syoriKeikaeigyoubisuu > MAX_KEIKAEIGYOUBISUU) {
                        syoriKeikaeigyoubisuu = MAX_KEIKAEIGYOUBISUU;
                    }

                    kijyunYmd = syrhubikeikakijyunbiYmd;
                    while (BizDateUtil.compareYmd(kijyunYmd, siRireki.getTyakkinymd()) < 0) {
                        kijyunYmd = kijyunYmd.addBusinessDays(1);
                        syrhubiKeikaegybisuu++;
                    }

                    if(syrhubiKeikaegybisuu > MAX_KEIKAEIGYOUBISUU) {
                        syrhubiKeikaegybisuu = TYOUKAJI_SYRHUBIKEIKAEGYBISUU;
                    }

                    String ensinkbn = "";
                    if (C_SinsaGendoKknKbn.BD5.eq(sk.getSinsagendokknkbn())) {
                        ensinkbn = "";
                    }
                    else if (C_SinsaGendoKknKbn.D45.eq(sk.getSinsagendokknkbn())) {
                        ensinkbn = TeisuuSiharai.ENSINKBN_TUUJYOUKAKUNIN45DAY;
                    }
                    else if (C_SinsaGendoKknKbn.D180.eq(sk.getSinsagendokknkbn())) {
                        ensinkbn = TeisuuSiharai.ENSINKBN_TOKUBETUKAKUNIN180DAY;
                    }

                    SiShrShyNsLayoutFile siShrShyNsLayoutFile = SWAKInjector.getInstance(SiShrShyNsLayoutFile.class);

                    siShrShyNsLayoutFile.setIfcSyorisosikicd(syoriSosikiCd);
                    siShrShyNsLayoutFile.setIfcSyoricd(SYORICD_SBSATEI);
                    siShrShyNsLayoutFile.setIfcHknknshrsntkno("");
                    siShrShyNsLayoutFile.setIfcSyoruiukeymd(sk.getSyoruiukeymd());
                    siShrShyNsLayoutFile.setIfcSyoriymd(siRireki.getShrsyoriymd());
                    siShrShyNsLayoutFile.setIfcDenpyouymd(siRireki.getTyakkinymd());
                    siShrShyNsLayoutFile.setIfcSyoruikeikaeigyoubisuu(syoruiKeikaeigyoubisuu);
                    siShrShyNsLayoutFile.setIfcSyorikeikaeigyoubisuu(syoriKeikaeigyoubisuu);
                    siShrShyNsLayoutFile.setIfcToritugisosikicd("");
                    siShrShyNsLayoutFile.setIfcTanmatusyuruikbn(C_TanmatuSyuruiKbn.RAY.getValue());
                    siShrShyNsLayoutFile.setIfcSyono(skKihon.getSyono());
                    siShrShyNsLayoutFile.setIfcKykymd(siKykKihon.getSiKykSyouhns().get(0).getKykymd());
                    siShrShyNsLayoutFile.setIfcKaisyouymd(sk.getHubikanryouymd());
                    siShrShyNsLayoutFile.setIfcEnsinkbn(ensinkbn);
                    siShrShyNsLayoutFile.setIfcTdnnissuu(sk.getRikoukityuutuudannissuu());
                    siShrShyNsLayoutFile.setIfcSyrhubikeikakijyunbi(syrhubikeikakijyunbiYmd);
                    siShrShyNsLayoutFile.setIfcSyrhubikeikaegybisuu(syrhubiKeikaegybisuu);

                    siShrShyNsLayoutFileLst.add(siShrShyNsLayoutFile);

                    totalCnt++;

                    JT_SiJinsokuShrTtdkInfo siJinsokuShrTtdkInfo = new JT_SiJinsokuShrTtdkInfo();

                    siJinsokuShrTtdkInfo.setSyorisosikicd(siShrShyNsLayoutFile.getIfcSyorisosikicd());

                    siJinsokuShrTtdkInfo.setSyoricd(siShrShyNsLayoutFile.getIfcSyoricd());

                    siJinsokuShrTtdkInfo.setHknknshrsntkno(siShrShyNsLayoutFile.getIfcHknknshrsntkno());

                    siJinsokuShrTtdkInfo.setSyoruiukeymd(siShrShyNsLayoutFile.getIfcSyoruiukeymd());

                    siJinsokuShrTtdkInfo.setSyoriYmd(siShrShyNsLayoutFile.getIfcSyoriymd());

                    siJinsokuShrTtdkInfo.setDenymd(siShrShyNsLayoutFile.getIfcDenpyouymd());

                    siJinsokuShrTtdkInfo.setSyoruikeikaeigyoubisuu(siShrShyNsLayoutFile.getIfcSyoruikeikaeigyoubisuu());

                    siJinsokuShrTtdkInfo.setSyorikeikaeigyoubisuu(siShrShyNsLayoutFile.getIfcSyorikeikaeigyoubisuu());

                    siJinsokuShrTtdkInfo.setToritugisosikicd(siShrShyNsLayoutFile.getIfcToritugisosikicd());

                    siJinsokuShrTtdkInfo.setTanmatusyuruikbn(C_TanmatuSyuruiKbn.valueOf(siShrShyNsLayoutFile.getIfcTanmatusyuruikbn()));

                    siJinsokuShrTtdkInfo.setSyono(siShrShyNsLayoutFile.getIfcSyono());

                    siJinsokuShrTtdkInfo.setKykymd(siShrShyNsLayoutFile.getIfcKykymd());

                    siJinsokuShrTtdkInfo.setGyoumuKousinKinou(kinou.getKinouId());

                    siJinsokuShrTtdkInfo.setGyoumuKousinsyaId(baseUserInfo.getUser().getUserId());

                    siJinsokuShrTtdkInfo.setGyoumuKousinTime(sysDate);

                    BizPropertyInitializer.initialize(siJinsokuShrTtdkInfo);

                    siharaiDomManager.insert(siJinsokuShrTtdkInfo);

                }

            }

            BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);
            errorKbn = bzFileUploadUtil.exec(C_FileSyuruiCdKbn.SI_SHRSYOYOUNISSUUCSV, siShrShyNsLayoutFileLst, true);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
            }

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(totalCnt), kinou.getKinouNm()));
        }
    }
}