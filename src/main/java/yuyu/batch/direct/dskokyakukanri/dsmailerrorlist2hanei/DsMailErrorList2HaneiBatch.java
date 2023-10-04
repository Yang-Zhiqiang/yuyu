package yuyu.batch.direct.dskokyakukanri.dsmailerrorlist2hanei;

import java.io.IOException;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.file.FileEntityReader;
import jp.co.slcs.swak.file.FileType;
import jp.co.slcs.swak.file.exception.CvtVdtException;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.StringUtil;
import yuyu.batch.direct.dskokyakukanri.dsmailerrorlist2hanei.dba.DsMailErrorList2HaneiDao;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.direct.dscommon.DsKokyakuYuukouKeiyakuHantei;
import yuyu.common.direct.dscommon.DsKokyakuYuukouKeiyakuHanteiBean;
import yuyu.common.direct.dscommon.DsSaibanSyori;
import yuyu.common.direct.dscommon.DsTetudukiRirekiTableEdit;
import yuyu.common.direct.dscommon.DsTetudukiRirekiTableEditParam;
import yuyu.common.direct.dscommon.DsTetudukiRirekiTableEditParamImpl;
import yuyu.common.direct.dscommon.TableMaintenanceUtil;
import yuyu.def.MessageId;
import yuyu.def.base.configuration.YuyuBaseConfig;
import yuyu.def.classification.C_DsHanyouKokyakuateTuutiKbn;
import yuyu.def.classification.C_DsMailDbSyoriKbn;
import yuyu.def.classification.C_DsMailSousinJyoutaiKbn;
import yuyu.def.classification.C_DsMailSousinTeisiRiyuuKbn;
import yuyu.def.classification.C_DsRendouTaisyouKbn;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;
import yuyu.def.classification.C_DsSyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.MT_BAK_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsHaisinErrorList2;
import yuyu.def.db.entity.MT_DsHanyouKokyakuateTuuti2;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsMailAddress;
import yuyu.def.db.entity.MT_DsMailAddressSpiralYyk;
import yuyu.def.direct.file.csv.DsMailHaisinErrorListFile;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.file.FileControlManager;

import com.google.common.base.Strings;

/**
 * ダイレクトサービス 顧客管理 メールエラーリストＦ２反映クラス
 */
public class DsMailErrorList2HaneiBatch implements Batch {

    private final String FILE_NAME = "SpiralMailHaisinErrorList_";

    private final String EXTENSOPM_TSV = ".tsv";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private DirectDomManager directDomManager;

    @Inject
    private DsMailErrorList2HaneiDao dsMailErrorList2HaneiDao;

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

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));
        try (
            EntityInserter<MT_BAK_DsKokyakuKanri> bakDsKokyakuKanriInserter = new EntityInserter<>();

            EntityInserter<MT_DsKokyakuKanri> dsKokyakuKanriEntityUpdater = new EntityInserter<>();) {

            BizDate syoriYmd = bzBatchParam.getSyoriYmd();
            long dsMailRenban = 0;
            String sysTime = BizDate.getSysDateTimeMilli();
            long syoriTaisyouKensuu = 0;
            long syoriTaisyouGaiKensuu = 0;
            long tuutiRenno = 0;
            DsTetudukiRirekiTableEditParam dsTetudukiRirekiTableEditParam = SWAKInjector.getInstance(
                DsTetudukiRirekiTableEditParamImpl.class);
            DsKokyakuYuukouKeiyakuHantei dsKokyakuYuukouKeiyakuHantei =
                SWAKInjector.getInstance(DsKokyakuYuukouKeiyakuHantei.class);

            FileControlManager fileControlManager = SWAKInjector.getInstance(FileControlManager.class);

            DsSaibanSyori dsSaibanSyori = SWAKInjector.getInstance(DsSaibanSyori.class);

            TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);

            DsTetudukiRirekiTableEdit editDSTtdkRirekiTbl = SWAKInjector.getInstance(DsTetudukiRirekiTableEdit.class);

            YuyuBaseConfig config = YuyuBaseConfig.getInstance();

            String batchInputDir = config.getBatchInputDir();

            String fileName = FILE_NAME + syoriYmd + EXTENSOPM_TSV;

            String filePath = batchInputDir + "/" + fileName;

            boolean fileExistFlag = false;
            fileExistFlag = fileControlManager.isExistFile(filePath);

            if (!fileExistFlag) {
                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0001, fileName));
            }

            try (FileEntityReader<DsMailHaisinErrorListFile> dsMailHaisinErrorListFile =
                fileControlManager.getFileEntityReader(filePath, DsMailHaisinErrorListFile.class, FileType.CSV)) {

                while (dsMailHaisinErrorListFile.hasNext()) {
                    DsMailHaisinErrorListFile dsMailHaisinErrorFile = dsMailHaisinErrorListFile.next();

                    if (BizUtil.isBlank(dsMailHaisinErrorFile.getIfcDskokmailaddressskbtkey())
                        || BizUtil.isBlank(dsMailHaisinErrorFile.getIfcDssousinmailsyubetukbn())
                        || BizUtil.isBlank(dsMailHaisinErrorFile.getIfcDssousinno())
                        || BizUtil.isBlank(dsMailHaisinErrorFile.getIfcDsmailaddress())
                        || BizUtil.isBlank(dsMailHaisinErrorFile.getIfcHaisinerrorcount())) {
                        syoriTaisyouGaiKensuu++;
                        continue;
                    }

                    String dsKokyakuNo = dsMailHaisinErrorFile.getIfcDskokmailaddressskbtkey().substring(0, 10);
                    Integer dsMailAddressRenban = Integer.valueOf(
                        dsMailHaisinErrorFile.getIfcDskokmailaddressskbtkey().substring(10, 19));
                    MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(dsKokyakuNo);

                    MT_DsMailAddress dsMailAddress = dsKokyakuKanri.getDsMailAddressByDsmailaddressrenban(
                        dsMailAddressRenban);

                    MT_DsMailAddressSpiralYyk dsMailAddressSpiralYyk =
                        dsKokyakuKanri.getDsMailAddressSpiralYykByDsdatasakuseiymdDsmailaddressrenban(
                            syoriYmd, dsMailAddressRenban);

                    if (tuutiRenno == 0) {
                        String dsKokTuutiRennoMax =
                            dsMailErrorList2HaneiDao.getDsHanyouKokyakuateTuuti2MaxDskoktuutirennoByDsdatasakuseiymd(
                                syoriYmd);

                        if (BizUtil.isBlank(dsKokTuutiRennoMax)) {
                            tuutiRenno = 1;
                        }
                        else {
                            tuutiRenno = Long.valueOf(dsKokTuutiRennoMax.substring(dsKokTuutiRennoMax.length() - 7,
                                dsKokTuutiRennoMax.length())) + 1;
                        }
                    }

                    dsMailRenban++;

                    DsKokyakuYuukouKeiyakuHanteiBean dsKokyakuYuukouKeiyakuHanteiBean = dsKokyakuYuukouKeiyakuHantei.exec(dsKokyakuNo);

                    if (C_UmuKbn.ARI.eq(dsKokyakuYuukouKeiyakuHanteiBean.getYuukouKeiyakuUmuKbn())) {
                        MT_DsHanyouKokyakuateTuuti2 mT_DsHanyouKokyakuateTuuti2 = dsKokyakuKanri
                            .createDsHanyouKokyakuateTuuti2();
                        mT_DsHanyouKokyakuateTuuti2.setDsdatasakuseiymd(syoriYmd);
                        mT_DsHanyouKokyakuateTuuti2.setDskoktuutirenno(syoriYmd.toString()
                            + Strings.padStart(String.valueOf(tuutiRenno), 7, '0'));
                        mT_DsHanyouKokyakuateTuuti2.setDskokno(dsKokyakuNo);
                        mT_DsHanyouKokyakuateTuuti2
                        .setDshanyoukokyakuatetuutikbn(C_DsHanyouKokyakuateTuutiKbn.EMAILSOUSINERRORTUUTI);
                        mT_DsHanyouKokyakuateTuuti2.setSyono(dsMailHaisinErrorFile.getIfcSyono());
                        mT_DsHanyouKokyakuateTuuti2.setDssousinno(dsMailHaisinErrorFile.getIfcDssousinno());
                        mT_DsHanyouKokyakuateTuuti2.setGyoumuKousinKinou(kinou.getKinouId());
                        mT_DsHanyouKokyakuateTuuti2.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        mT_DsHanyouKokyakuateTuuti2.setGyoumuKousinTime(sysTime);
                        BizPropertyInitializer.initialize(mT_DsHanyouKokyakuateTuuti2);

                        tuutiRenno++;
                    }

                    MT_DsHaisinErrorList2 mT_DsHaisinErrorList2 = dsKokyakuKanri.createDsHaisinErrorList2();
                    mT_DsHaisinErrorList2.setDsdatasakuseiymd(syoriYmd);
                    mT_DsHaisinErrorList2.setDsmailhaisinrenban(Integer.valueOf(String.valueOf(dsMailRenban)));
                    mT_DsHaisinErrorList2.setDskokno(dsMailHaisinErrorFile.getIfcDskokmailaddressskbtkey().substring(0,
                        10));
                    mT_DsHaisinErrorList2.setDsmailaddressrenban(Integer.valueOf(dsMailHaisinErrorFile
                        .getIfcDskokmailaddressskbtkey().substring(10, 19)));
                    mT_DsHaisinErrorList2.setDssousinmailsyubetukbn(
                        C_DsSousinMailSyubetuKbn.valueOf(dsMailHaisinErrorFile.getIfcDssousinmailsyubetukbn()));
                    mT_DsHaisinErrorList2.setDssousinno(dsMailHaisinErrorFile.getIfcDssousinno());
                    mT_DsHaisinErrorList2.setSyono(dsMailHaisinErrorFile.getIfcSyono());
                    mT_DsHaisinErrorList2.setHaisinjidsmailaddress(dsMailHaisinErrorFile.getIfcDsmailaddress());

                    mT_DsHaisinErrorList2.setDsmailsousinymd(convertDateFormat(dsMailHaisinErrorFile.getIfcSousinymd()));
                    mT_DsHaisinErrorList2.setDsmailsakujyoymd(convertDateFormat(dsMailHaisinErrorFile.getIfcSakujyoymd()));

                    mT_DsHaisinErrorList2.setHaisinerrorcount(dsMailHaisinErrorFile.getIfcHaisinerrorcount());
                    mT_DsHaisinErrorList2.setHaisinerrorcount2(dsMailHaisinErrorFile.getIfcHaisinerrorcount2());

                    mT_DsHaisinErrorList2.setGyoumuKousinKinou(kinou.getKinouId());
                    mT_DsHaisinErrorList2.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    mT_DsHaisinErrorList2.setGyoumuKousinTime(sysTime);
                    BizPropertyInitializer.initialize(mT_DsHaisinErrorList2);

                    if ((dsMailAddressSpiralYyk != null &&
                        C_DsRendouTaisyouKbn.RENDOUTAISYOU.eq(dsMailAddressSpiralYyk.getDsrendoutaisyoukbn())) ||
                        (dsMailAddress != null &&
                        !dsMailHaisinErrorFile.getIfcDsmailaddress().equals(dsMailAddress.getDsmailaddress()))) {
                        syoriTaisyouGaiKensuu++;
                    }
                    else {
                        syoriTaisyouKensuu++;

                        String dsHenkouSikibetukey = dsSaibanSyori.saibanDsHenkouSikibetukey();

                        MT_BAK_DsKokyakuKanri bakDsKokyakuKanri =
                            tableMaintenanceUtil.exec(dsKokyakuNo, dsHenkouSikibetukey);

                        if (bakDsKokyakuKanri == null) {

                            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EMA1009, dsKokyakuNo));
                        }

                        dsMailAddress.setDsmailsousinjyoutaikbn(C_DsMailSousinJyoutaiKbn.TEISI);
                        dsMailAddress.setDsmailsousintisrykbn(C_DsMailSousinTeisiRiyuuKbn.MAILHAISINERROR);
                        dsMailAddress.setDskousinymdtime(sysTime);
                        dsMailAddress.setGyoumuKousinKinou(kinou.getKinouId());
                        dsMailAddress.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        dsMailAddress.setGyoumuKousinTime(sysTime);

                        if (dsMailAddressSpiralYyk == null) {
                            dsMailAddressSpiralYyk = dsKokyakuKanri.createDsMailAddressSpiralYyk();
                            dsMailAddressSpiralYyk.setDsdatasakuseiymd(syoriYmd);
                            dsMailAddressSpiralYyk.setDskokno(dsKokyakuNo);
                            dsMailAddressSpiralYyk.setDsmailaddressrenban(dsMailAddressRenban);
                            dsMailAddressSpiralYyk.setDsmailaddress(dsMailHaisinErrorFile.getIfcDsmailaddress());
                            dsMailAddressSpiralYyk.setDsrendoutaisyoukbn(C_DsRendouTaisyouKbn.RENDOUTAISYOU);
                            dsMailAddressSpiralYyk.setDsmaildbsyorikbn(C_DsMailDbSyoriKbn.SAKUJYO);
                            dsMailAddressSpiralYyk.setGyoumuKousinKinou(kinou.getKinouId());
                            dsMailAddressSpiralYyk.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                            dsMailAddressSpiralYyk.setGyoumuKousinTime(sysTime);
                            BizPropertyInitializer.initialize(dsMailAddressSpiralYyk);
                        }
                        else {
                            dsMailAddressSpiralYyk.setDsrendoutaisyoukbn(C_DsRendouTaisyouKbn.RENDOUTAISYOU);
                            dsMailAddressSpiralYyk.setDsmaildbsyorikbn(C_DsMailDbSyoriKbn.SAKUJYO);
                            dsMailAddressSpiralYyk.setGyoumuKousinKinou(kinou.getKinouId());
                            dsMailAddressSpiralYyk.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                            dsMailAddressSpiralYyk.setGyoumuKousinTime(sysTime);
                        }

                        dsTetudukiRirekiTableEditParam.setDskokno(dsKokyakuNo);
                        dsTetudukiRirekiTableEditParam.setDsKokyakuKanri(dsKokyakuKanri);
                        dsTetudukiRirekiTableEditParam.setBakDsKokyakuKanri(bakDsKokyakuKanri);
                        dsTetudukiRirekiTableEditParam.setHenkousikibetukey(dsHenkouSikibetukey);
                        dsTetudukiRirekiTableEditParam.setSyoriYmd(syoriYmd);
                        dsTetudukiRirekiTableEditParam.setDssyorikbn(C_DsSyoriKbn.MAIL_ERRORLIST_F2_HANEI);
                        dsTetudukiRirekiTableEditParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);

                        editDSTtdkRirekiTbl.editDSTtdkRirekiTblBatch(dsTetudukiRirekiTableEditParam);

                        bakDsKokyakuKanriInserter.add(bakDsKokyakuKanri);

                        dsKokyakuKanriEntityUpdater.add(dsKokyakuKanri);

                    }

                }

            } catch (IOException e) {
                throw new CommonBizAppException(e, MessageUtil.getMessage(MessageId.EAS0027));

            } catch (CvtVdtException e) {
                throw new CommonBizAppException(e, MessageUtil.getMessage(MessageId.EAS0027));
            }

            fileControlManager.remove(filePath);
            batchLogger.info(MessageUtil.getMessage(MessageId.IAC0020, String.valueOf(syoriTaisyouKensuu)));
            batchLogger.info(MessageUtil.getMessage(MessageId.IMA1009, String.valueOf(syoriTaisyouGaiKensuu)));
        }
    }

    private BizDate convertDateFormat(String pHenkanmaeYmd) {

        BizDate henkanGoYmd = null;

        if (!StringUtil.isNullOrBlank(pHenkanmaeYmd)) {
            henkanGoYmd = BizDate.valueOf(pHenkanmaeYmd.replaceAll("-", ""));
        }

        return henkanGoYmd;
    }

}
