package yuyu.batch.direct.dskokyakukanri.dsmailerrorlisthanei;

import java.io.IOException;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.file.FileEntityReader;
import jp.co.slcs.swak.file.FileType;
import jp.co.slcs.swak.file.exception.CvtVdtException;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.direct.dskokyakukanri.dsmailerrorlisthanei.dba.DsMailErrorListHaneiDao;
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
import yuyu.def.classification.C_DsSyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.MT_BAK_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsHaisinErrorList;
import yuyu.def.db.entity.MT_DsHanyouKokyakuateTuuti2;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsMailAddress;
import yuyu.def.db.entity.MT_DsMailAddressSpiralYyk;
import yuyu.def.direct.file.csv.DsMailErrorListFile;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.file.FileControlManager;

import com.google.common.base.Strings;

/**
 * ダイレクトサービス 顧客管理 メールエラーリストＦ反映クラス
 */
public class DsMailErrorListHaneiBatch implements Batch {

    private final String FILE_NAME = "SpiralMailErrorList_";

    private final String EXTENSOPM_TSV = ".tsv";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private DirectDomManager directDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private DsMailErrorListHaneiDao dsMailErrorListHaneiDao;
    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(bzBatchParam.getSyoriYmd())));

        try (EntityInserter<MT_BAK_DsKokyakuKanri> bakDsKokyakuKanriInserter = new EntityInserter<>();
            EntityUpdater<MT_DsKokyakuKanri> dsKokyakuKanriEntityUpdater = new EntityUpdater<>()) {

            BizDate syoriYmd = bzBatchParam.getSyoriYmd();
            String sysTime = BizDate.getSysDateTimeMilli();
            FileControlManager fileControlManager = SWAKInjector.getInstance(FileControlManager.class);
            long syoriTaisyouKensu = 0;
            long syoriTaisyouGaiKensu = 0;
            long tuutiRenno = 0;
            DsSaibanSyori dsSaibanSyori = SWAKInjector.getInstance(DsSaibanSyori.class);
            TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);
            DsTetudukiRirekiTableEdit editDSTtdkRirekiTbl = SWAKInjector.getInstance(DsTetudukiRirekiTableEdit.class);
            DsTetudukiRirekiTableEditParam dsTetudukiRirekiTableEditParam =
                SWAKInjector.getInstance(DsTetudukiRirekiTableEditParamImpl.class);
            DsKokyakuYuukouKeiyakuHantei dsKokyakuYuukouKeiyakuHantei =
                SWAKInjector.getInstance(DsKokyakuYuukouKeiyakuHantei.class);

            String batchInputDir = YuyuBaseConfig.getInstance().getBatchInputDir();
            String fileName = FILE_NAME + syoriYmd.toString() + EXTENSOPM_TSV;
            String filePathTsv = batchInputDir + "/" + fileName;

            boolean existFlg = false;
            existFlg = fileControlManager.isExistFile(filePathTsv);

            if (!existFlg) {
                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0001, fileName));
            }

            try (FileEntityReader<DsMailErrorListFile> dsMailErrorListFile = fileControlManager.getFileEntityReader(
                filePathTsv, DsMailErrorListFile.class, FileType.CSV)) {

                while (dsMailErrorListFile.hasNext()) {
                    DsMailErrorListFile dsMailErrorFile = dsMailErrorListFile.next();

                    if (BizUtil.isBlank(dsMailErrorFile.getIfcDskokmailaddressskbtkey())
                        || BizUtil.isBlank(dsMailErrorFile.getIfcDsmailaddress())
                        || BizUtil.isBlank(dsMailErrorFile.getIfcHaisinerrorcount())){
                        syoriTaisyouGaiKensu++;
                        continue;
                    }

                    String dsKokyakuNo = dsMailErrorFile.getIfcDskokmailaddressskbtkey().substring(0, 10);
                    Integer dsMailAddressRenban =
                        Integer.valueOf(dsMailErrorFile.getIfcDskokmailaddressskbtkey().substring(10, 19));

                    MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(dsKokyakuNo);
                    MT_DsMailAddress dsMailAddress =
                        dsKokyakuKanri.getDsMailAddressByDsmailaddressrenban(dsMailAddressRenban);
                    MT_DsMailAddressSpiralYyk dsMailAddressSpiralYyk = dsKokyakuKanri.
                        getDsMailAddressSpiralYykByDsdatasakuseiymdDsmailaddressrenban(syoriYmd, dsMailAddressRenban);

                    if (tuutiRenno == 0) {
                        String dsKokTuutiRennoMax =
                            dsMailErrorListHaneiDao.getDsHanyouKokyakuateTuuti2MaxDskoktuutirennoByDsdatasakuseiymd(
                                syoriYmd);
                        if (BizUtil.isBlank(dsKokTuutiRennoMax)) {
                            tuutiRenno = 1;
                        }
                        else {
                            tuutiRenno = Long.valueOf(dsKokTuutiRennoMax.substring(dsKokTuutiRennoMax.length() - 7,
                                dsKokTuutiRennoMax.length())) + 1;
                        }
                    }
                    if (dsMailAddressSpiralYyk != null &&
                        C_DsRendouTaisyouKbn.RENDOUTAISYOU.eq(dsMailAddressSpiralYyk.getDsrendoutaisyoukbn())) {
                        syoriTaisyouGaiKensu++;
                    }
                    else {
                        syoriTaisyouKensu++;

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
                            dsMailAddressSpiralYyk.setDsmailaddress(dsMailErrorFile.getIfcDsmailaddress());
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

                        DsKokyakuYuukouKeiyakuHanteiBean dsKokyakuYuukouKeiyakuHanteiBean = dsKokyakuYuukouKeiyakuHantei.exec(dsKokyakuNo);

                        if (C_UmuKbn.ARI.eq(dsKokyakuYuukouKeiyakuHanteiBean.getYuukouKeiyakuUmuKbn())) {

                            MT_DsHanyouKokyakuateTuuti2 dsHanyouKokyakuateTuuti2 = dsKokyakuKanri.createDsHanyouKokyakuateTuuti2();
                            dsHanyouKokyakuateTuuti2.setDsdatasakuseiymd(syoriYmd);
                            dsHanyouKokyakuateTuuti2.setDskoktuutirenno(syoriYmd.toString()
                                + Strings.padStart(String.valueOf(tuutiRenno), 7, '0'));
                            dsHanyouKokyakuateTuuti2.setDskokno(dsKokyakuNo);
                            dsHanyouKokyakuateTuuti2.setDshanyoukokyakuatetuutikbn(
                                C_DsHanyouKokyakuateTuutiKbn.EMAILSOUSINERRORTUUTI);
                            dsHanyouKokyakuateTuuti2.setSyono("");
                            dsHanyouKokyakuateTuuti2.setDssousinno(dsMailErrorFile.getIfcThanksmailsousinno());
                            dsHanyouKokyakuateTuuti2.setGyoumuKousinKinou(kinou.getKinouId());
                            dsHanyouKokyakuateTuuti2.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                            dsHanyouKokyakuateTuuti2.setGyoumuKousinTime(sysTime);

                            BizPropertyInitializer.initialize(dsHanyouKokyakuateTuuti2);

                            tuutiRenno = tuutiRenno + 1;
                        }

                        MT_DsHaisinErrorList dsHaisinErrorList = dsKokyakuKanri.createDsHaisinErrorList();

                        dsHaisinErrorList.setDsdatasakuseiymd(syoriYmd);
                        dsHaisinErrorList.setDskokno(dsKokyakuNo);
                        dsHaisinErrorList.setDsmailaddressrenban(dsMailAddressRenban);
                        dsHaisinErrorList.setHaisinjidsmailaddress(dsMailErrorFile.getIfcDsmailaddress());
                        dsHaisinErrorList.setHaisinerrorcount(dsMailErrorFile.getIfcHaisinerrorcount());
                        dsHaisinErrorList.setDssousinno(dsMailErrorFile.getIfcThanksmailsousinno());
                        dsHaisinErrorList.setGyoumuKousinKinou(kinou.getKinouId());
                        dsHaisinErrorList.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        dsHaisinErrorList.setGyoumuKousinTime(sysTime);

                        BizPropertyInitializer.initialize(dsHaisinErrorList);


                        dsTetudukiRirekiTableEditParam.setDskokno(dsKokyakuNo);
                        dsTetudukiRirekiTableEditParam.setDsKokyakuKanri(dsKokyakuKanri);
                        dsTetudukiRirekiTableEditParam.setBakDsKokyakuKanri(bakDsKokyakuKanri);
                        dsTetudukiRirekiTableEditParam.setHenkousikibetukey(dsHenkouSikibetukey);
                        dsTetudukiRirekiTableEditParam.setSyoriYmd(syoriYmd);
                        dsTetudukiRirekiTableEditParam.setDssyorikbn(C_DsSyoriKbn.MAIL_ERRORLIST_F_HANEI);
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
            fileControlManager.remove(filePathTsv);
            batchLogger.info(MessageUtil.getMessage(MessageId.IAC0020, String.valueOf(syoriTaisyouKensu)));
            batchLogger.info(MessageUtil.getMessage(MessageId.IMA1009, String.valueOf(syoriTaisyouGaiKensu)));
        }
    }
}
