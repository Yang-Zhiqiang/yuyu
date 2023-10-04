package yuyu.batch.direct.dskokyakukanri.dsseiritukokyakusakusei;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.direct.dscommon.DsSaibanSyori;
import yuyu.common.direct.dscommon.DsTetudukiRirekiTableEdit;
import yuyu.common.direct.dscommon.DsTetudukiRirekiTableEditParamImpl;
import yuyu.common.direct.dscommon.HozenKeiyakuIdouJyoutaiSyutoku;
import yuyu.common.direct.dscommon.HozenKeiyakuIdouJyoutaiSyutokuBean;
import yuyu.common.direct.dscommon.TableMaintenanceUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_DirectServiceMosKbn;
import yuyu.def.classification.C_DsKanyuuKeiroKbn;
import yuyu.def.classification.C_DsKokyakuJtKbn;
import yuyu.def.classification.C_DsKrHnnKakCdSetKbn;
import yuyu.def.classification.C_DsKrHnnKakCdTtTydnJyKbn;
import yuyu.def.classification.C_DsKrHnnKakCdTtYhKbn;
import yuyu.def.classification.C_DsKzkJmKknHsJyKbn;
import yuyu.def.classification.C_DsMailDbSyoriKbn;
import yuyu.def.classification.C_DsMailSousinJyoutaiKbn;
import yuyu.def.classification.C_DsMailSousinTeisiRiyuuKbn;
import yuyu.def.classification.C_DsMailTourokuJyoutaiKbn;
import yuyu.def.classification.C_DsRendouTaisyouKbn;
import yuyu.def.classification.C_DsSyoriKbn;
import yuyu.def.classification.C_DsTeisiRiyuuKbn;
import yuyu.def.classification.C_IdoutyuuHanteiKekkaKbn;
import yuyu.def.classification.C_MukouHyj;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.MT_BAK_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsHonninKakuninCd;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.entity.MT_DsKouzokuJimuKakunin;
import yuyu.def.db.entity.MT_DsLoginKanri;
import yuyu.def.db.entity.MT_DsMailAddress;
import yuyu.def.db.entity.MT_DsMailAddressSpiralYyk;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.DSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean;
import yuyu.def.sinkeiyaku.detacher.HT_SyoriCTLDetacher;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * ダイレクトサービス 顧客管理 成立顧客作成クラス
 */
public class DsSeirituKokyakuSakuseiBatch implements Batch{

    private final String TABLE_ID = "IT_KykKihon";

    private final String RECOVERY_FILTER_ID = "Kh001";

    private final String DS_SINKIKYK_TOROKUKENSUU = "ＤＳ新規契約登録件数";

    private final String DS_JIMU_KAKUNINKENSUU = "ＤＳ後続事務確認件数";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private DirectDomManager directDomManager;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }
    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(bzBatchParam.getSyoriYmd())));

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String sysTime = BizDate.getSysDateTimeMilli();
        DsSaibanSyori dsSaibanSyori = SWAKInjector.getInstance(DsSaibanSyori.class);
        DsTetudukiRirekiTableEditParamImpl dsTetudukiRirekiTableEditParamImpl=
            SWAKInjector.getInstance(DsTetudukiRirekiTableEditParamImpl.class);
        DsTetudukiRirekiTableEdit editDSTtdkRirekiTbl = SWAKInjector.getInstance(DsTetudukiRirekiTableEdit.class);


        try (ExDBResults<DSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean> dStourokusByjobcdDrctservicemoskbnLst =
            hozenDomManager.getDSmossinkitourokusByKakutyoujobcdDrctservicemoskbn(bzBatchParam.getIbKakutyoujobcd());
            EntityInserter<MT_DsKokyakuKanri> dsKokyakuKanriEntityInserter = new EntityInserter<>();
            EntityInserter<MT_BAK_DsKokyakuKanri> bakDsKokyakuKanriInserter = new EntityInserter<>();
            EntityInserter<MT_DsKouzokuJimuKakunin> dsKouzokuJimuKakuninEntityInserter = new EntityInserter<>();
            EntityUpdater<MT_DsKokyakuKanri> dsKokyakuKanriEntityUpdater = new EntityUpdater<>();) {

            long tyusyutuKensuu = 0;

            long syoriKensuu = 0;

            for (DSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean
                dSmossinByjobcdDcemoskbnBean :dStourokusByjobcdDrctservicemoskbnLst) {

                tyusyutuKensuu = tyusyutuKensuu + 1;
                IT_KykKihon kykKihon = dSmossinByjobcdDcemoskbnBean.getIT_KykKihon();

                if (kykKihon == null) {

                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBA0012,
                        IT_KykKihon.TABLE_NAME));
                }

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(kykKihon.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(kykKihon.getSyono());

                IT_KykSya kykSya = dSmossinByjobcdDcemoskbnBean.getIT_KykSya();

                if (kykSya == null) {

                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBS0004,
                        IT_KykSya.TABLE_NAME, IT_KykSya.SYONO, kykKihon.getSyono()));
                }

                List<MT_DsKokyakuKanri> dsKokyakuKanriLst =
                    directDomManager.getDsKokyakuKanrisByDskokyakujtkbnNe(kykSya.getKyknmkn(),
                        kykSya.getKyknmkj(), kykSya.getKykseiymd(), kykSya.getTsinyno());

                int nayoseKensuu = dsKokyakuKanriLst.size();

                List<HT_SyoriCTL> syoriCTLLst = sinkeiyakuDomManager.getSyoriCTLsBySyono(kykKihon.getSyono());

                syoriCTLLst = HT_SyoriCTLDetacher.detachMosKihontouched(syoriCTLLst);

                HT_MosKihon mosKihon = null;

                if (!syoriCTLLst.isEmpty()) {
                    HT_SyoriCTL syoriCTL = syoriCTLLst.get(0);
                    mosKihon = syoriCTL.getMosKihon();
                }

                if (C_DirectServiceMosKbn.CHECK.eq(kykKihon.getDrctservicemoskbn())) {

                    MT_DsKouzokuJimuKakunin dsKouzokuJimuKakunin = new MT_DsKouzokuJimuKakunin();

                    dsKouzokuJimuKakunin.setHasseiymd(syoriYmd);
                    dsKouzokuJimuKakunin.setDskzkjmkknhsjykbn(C_DsKzkJmKknHsJyKbn.ONLINE);
                    dsKouzokuJimuKakunin.setSyono(kykKihon.getSyono());
                    dsKouzokuJimuKakunin.setGyoumuKousinKinou(kinou.getKinouId());
                    dsKouzokuJimuKakunin.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    dsKouzokuJimuKakunin.setGyoumuKousinTime(sysTime);
                    BizPropertyInitializer.initialize(dsKouzokuJimuKakunin);

                    dsKouzokuJimuKakuninEntityInserter.add(dsKouzokuJimuKakunin);
                }

                MT_DsKokyakuKanri dsKokyakuKanri = null;
                MT_BAK_DsKokyakuKanri bakDsKokyakuKanri = null;
                String dsHenkouSikibetukey = null;
                String dsKokno = null;

                if (nayoseKensuu >= 2) {

                    MT_DsKouzokuJimuKakunin dsKouzokuJimuKakunin = new MT_DsKouzokuJimuKakunin();

                    dsKouzokuJimuKakunin.setHasseiymd(syoriYmd);
                    dsKouzokuJimuKakunin.setDskzkjmkknhsjykbn(C_DsKzkJmKknHsJyKbn.NAYOSESAKIHUMEI);
                    dsKouzokuJimuKakunin.setSyono(kykKihon.getSyono());
                    dsKouzokuJimuKakunin.setGyoumuKousinKinou(kinou.getKinouId());
                    dsKouzokuJimuKakunin.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    dsKouzokuJimuKakunin.setGyoumuKousinTime(sysTime);
                    BizPropertyInitializer.initialize(dsKouzokuJimuKakunin);

                    dsKouzokuJimuKakuninEntityInserter.add(dsKouzokuJimuKakunin);

                    continue;
                }

                if (nayoseKensuu == 0) {

                    if (!C_DirectServiceMosKbn.CHECK.eq(kykKihon.getDrctservicemoskbn())) {

                        dsKokno = dsSaibanSyori.saibanDsKokno();
                        dsHenkouSikibetukey = dsSaibanSyori.saibanDsHenkouSikibetukey();

                        dsKokyakuKanri = new MT_DsKokyakuKanri();

                        dsKokyakuKanri.setDskokno(dsKokno);
                        dsKokyakuKanri.setDskokyakujtkbn(C_DsKokyakuJtKbn.ITIJI_TEISI);
                        dsKokyakuKanri.setDskokyakusakuseiymd(syoriYmd);
                        dsKokyakuKanri.setDsteisiriyuukbn(C_DsTeisiRiyuuKbn.PASSWORD_MITOUROKU);
                        dsKokyakuKanri.setDskokyakunmkn(kykSya.getKyknmkn());
                        dsKokyakuKanri.setDskokyakunmkj(kykSya.getKyknmkj());
                        dsKokyakuKanri.setDskokyakuseiymd(kykSya.getKykseiymd());
                        dsKokyakuKanri.setDskokyakuyno(kykSya.getTsinyno());
                        dsKokyakuKanri.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.SINKEIYAKUDOUJI);
                        dsKokyakuKanri.setGyoumuKousinKinou(kinou.getKinouId());
                        dsKokyakuKanri.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        dsKokyakuKanri.setGyoumuKousinTime(sysTime);
                        BizPropertyInitializer.initialize(dsKokyakuKanri);

                        MT_DsHonninKakuninCd dsHonninKakuninCd = dsKokyakuKanri.createDsHonninKakuninCd();
                        dsHonninKakuninCd.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SINKI);
                        dsHonninKakuninCd.setDskrhnnkakcdttshjyhsymd(syoriYmd);
                        dsHonninKakuninCd.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.YOU);
                        dsHonninKakuninCd.setDskrhnnkakcdtttydnjykbn(C_DsKrHnnKakCdTtTydnJyKbn.BLNK);
                        dsHonninKakuninCd.setGyoumuKousinKinou(kinou.getKinouId());
                        dsHonninKakuninCd.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        dsHonninKakuninCd.setGyoumuKousinTime(sysTime);
                        BizPropertyInitializer.initialize(dsHonninKakuninCd);

                        MT_DsLoginKanri dsLoginKanri = dsKokyakuKanri.createDsLoginKanri();
                        dsLoginKanri.setGyoumuKousinKinou(kinou.getKinouId());
                        dsLoginKanri.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        dsLoginKanri.setGyoumuKousinTime(sysTime);
                        BizPropertyInitializer.initialize(dsLoginKanri);

                        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku = dsKokyakuKanri.createDsKokyakuKeiyaku();
                        dsKokyakuKeiyaku.setSyono(kykKihon.getSyono());
                        dsKokyakuKeiyaku.setDskykkanyuuymd(syoriYmd);
                        dsKokyakuKeiyaku.setGyoumuKousinKinou(kinou.getKinouId());
                        dsKokyakuKeiyaku.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        dsKokyakuKeiyaku.setGyoumuKousinTime(sysTime);
                        BizPropertyInitializer.initialize(dsKokyakuKeiyaku);

                        if (mosKihon != null && !BizUtil.isBlank(mosKihon.getDsmailaddress())){

                            MT_DsMailAddress dsMailAddress = dsKokyakuKanri.createDsMailAddress();

                            dsMailAddress.setDsmailaddressrenban(1);
                            dsMailAddress.setDsmailtourokujyoutaikbn(C_DsMailTourokuJyoutaiKbn.TOUROKU);
                            dsMailAddress.setDsmailaddress(mosKihon.getDsmailaddress());
                            dsMailAddress.setDsmailsousinjyoutaikbn(C_DsMailSousinJyoutaiKbn.YUUKOU);
                            dsMailAddress.setDstourokuymdtime(sysTime);
                            dsMailAddress.setDskousinymdtime(sysTime);
                            dsMailAddress.setGyoumuKousinKinou(kinou.getKinouId());
                            dsMailAddress.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                            dsMailAddress.setGyoumuKousinTime(sysTime);
                            BizPropertyInitializer.initialize(dsMailAddress);

                            MT_DsMailAddressSpiralYyk dsMailAddressSpiralYyk =
                                dsKokyakuKanri.createDsMailAddressSpiralYyk();

                            dsMailAddressSpiralYyk.setDsdatasakuseiymd(syoriYmd);
                            dsMailAddressSpiralYyk.setDsmailaddressrenban(1);
                            dsMailAddressSpiralYyk.setDsmailaddress(mosKihon.getDsmailaddress());
                            dsMailAddressSpiralYyk.setDsrendoutaisyoukbn(C_DsRendouTaisyouKbn.RENDOUTAISYOU);
                            dsMailAddressSpiralYyk.setDsmaildbsyorikbn(C_DsMailDbSyoriKbn.TOUROKU);
                            dsMailAddressSpiralYyk.setGyoumuKousinKinou(kinou.getKinouId());
                            dsMailAddressSpiralYyk.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                            dsMailAddressSpiralYyk.setGyoumuKousinTime(sysTime);
                            BizPropertyInitializer.initialize(dsMailAddressSpiralYyk);
                        }
                        else {
                            MT_DsMailAddress dsMailAddress = dsKokyakuKanri.createDsMailAddress();

                            dsMailAddress.setDsmailaddressrenban(1);
                            dsMailAddress.setDsmailtourokujyoutaikbn(C_DsMailTourokuJyoutaiKbn.MITOUROKU);
                            dsMailAddress.setDstourokuymdtime(sysTime);
                            dsMailAddress.setDskousinymdtime(sysTime);
                            dsMailAddress.setGyoumuKousinKinou(kinou.getKinouId());
                            dsMailAddress.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                            dsMailAddress.setGyoumuKousinTime(sysTime);
                            BizPropertyInitializer.initialize(dsMailAddress);
                        }

                        dsKokyakuKanriEntityInserter.add(dsKokyakuKanri);
                    }
                }

                if (nayoseKensuu == 1) {

                    boolean kouzokuKakuninflg = false;

                    dsKokyakuKanri = dsKokyakuKanriLst.get(0);
                    dsKokno = dsKokyakuKanri.getDskokno();

                    List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyakuLst = dsKokyakuKanri.getDsKokyakuKeiyakus();

                    for (MT_DsKokyakuKeiyaku dsKokykKeiyaku : dsKokyakuKeiyakuLst) {

                        if (C_MukouHyj.MUKOU.eq(dsKokykKeiyaku.getDskykmukouhyj())) {

                            continue;
                        }

                        HozenKeiyakuIdouJyoutaiSyutoku hzkykIdoujyoutai =
                            SWAKInjector.getInstance(HozenKeiyakuIdouJyoutaiSyutoku.class);

                        HozenKeiyakuIdouJyoutaiSyutokuBean hzKykIdouJyoutaiBean =
                            hzkykIdoujyoutai.hozenKeiyakuIdouJyoutaiSyutoku(dsKokykKeiyaku.getSyono());

                        if (C_IdoutyuuHanteiKekkaKbn.ERROR.eq(hzKykIdouJyoutaiBean.getIdoutyuuKbn())) {

                            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0129,
                                MessageUtil.getMessage(MessageId.EMW1008)));
                        }

                        if (C_IdoutyuuHanteiKekkaKbn.IDOUTYUU.eq(hzKykIdouJyoutaiBean.getIdoutyuuKbn())) {

                            MT_DsKouzokuJimuKakunin dsKouzokuJimuKakunin = new MT_DsKouzokuJimuKakunin();

                            dsKouzokuJimuKakunin.setHasseiymd(syoriYmd);
                            dsKouzokuJimuKakunin.setDskzkjmkknhsjykbn(C_DsKzkJmKknHsJyKbn.NAYOSESAKIKEIYAKUIDOUTYUU);
                            dsKouzokuJimuKakunin.setSyono(kykKihon.getSyono());
                            dsKouzokuJimuKakunin.setGyoumuKousinKinou(kinou.getKinouId());
                            dsKouzokuJimuKakunin.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                            dsKouzokuJimuKakunin.setGyoumuKousinTime(sysTime);

                            BizPropertyInitializer.initialize(dsKouzokuJimuKakunin);

                            dsKouzokuJimuKakuninEntityInserter.add(dsKouzokuJimuKakunin);

                            kouzokuKakuninflg = true;

                            break;
                        }
                    }

                    if (!C_DirectServiceMosKbn.CHECK.eq(kykKihon.getDrctservicemoskbn()) && !kouzokuKakuninflg) {

                        dsHenkouSikibetukey = dsSaibanSyori.saibanDsHenkouSikibetukey();

                        TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);

                        bakDsKokyakuKanri =
                            tableMaintenanceUtil.exec(dsKokno, dsHenkouSikibetukey);

                        if (bakDsKokyakuKanri == null) {

                            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EMA1009,
                                dsKokno));
                        }

                        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku = dsKokyakuKanri.createDsKokyakuKeiyaku();

                        dsKokyakuKeiyaku.setSyono(kykKihon.getSyono());
                        dsKokyakuKeiyaku.setDskykkanyuuymd(syoriYmd);
                        dsKokyakuKeiyaku.setGyoumuKousinKinou(kinou.getKinouId());
                        dsKokyakuKeiyaku.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        dsKokyakuKeiyaku.setGyoumuKousinTime(sysTime);

                        BizPropertyInitializer.initialize(dsKokyakuKeiyaku);

                        List<MT_DsMailAddress> dsMailAddressLst =dsKokyakuKanri.getDsMailAddresss();
                        String dsMailAddress = dsMailAddressLst.get(0).getDsmailaddress();
                        C_DsMailSousinJyoutaiKbn dsMailSousinjyoutaiKbn = dsMailAddressLst.get(0).getDsmailsousinjyoutaikbn();

                        MT_DsMailAddress dsMailAddressEntity = dsKokyakuKanri.getDsMailAddressByDsmailaddressrenban(1);

                        MT_DsMailAddressSpiralYyk dsMailAddressSpiralYyk =
                            dsKokyakuKanri.getDsMailAddressSpiralYykByDsdatasakuseiymdDsmailaddressrenban(syoriYmd, 1);

                        if(mosKihon != null && !BizUtil.isBlank(mosKihon.getDsmailaddress())
                            && !mosKihon.getDsmailaddress().equals(dsMailAddress)){

                            if(C_DsKokyakuJtKbn.ITIJI_TEISI.eq(dsKokyakuKanri.getDskokyakujtkbn()) &&
                                (C_DsTeisiRiyuuKbn.OMOUSIDE.eq(dsKokyakuKanri.getDsteisiriyuukbn())||
                                    C_DsTeisiRiyuuKbn.SONOTA.eq(dsKokyakuKanri.getDsteisiriyuukbn()))){
                                if (C_DsMailSousinJyoutaiKbn.TEISI.eq(dsMailSousinjyoutaiKbn)){

                                    dsMailAddressEntity.setDsmailaddress(mosKihon.getDsmailaddress());
                                    dsMailAddressEntity.setDskousinymdtime(sysTime);
                                    dsMailAddressEntity.setGyoumuKousinKinou(kinou.getKinouId());
                                    dsMailAddressEntity.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                                    dsMailAddressEntity.setGyoumuKousinTime(sysTime);

                                }else{

                                    dsMailAddressEntity.setDsmailtourokujyoutaikbn(C_DsMailTourokuJyoutaiKbn.TOUROKU);
                                    dsMailAddressEntity.setDsmailaddress(mosKihon.getDsmailaddress());
                                    dsMailAddressEntity.setDsmailsousinjyoutaikbn(C_DsMailSousinJyoutaiKbn.TEISI);
                                    dsMailAddressEntity.setDsmailsousintisrykbn(C_DsMailSousinTeisiRiyuuKbn.SERVICETEISI);
                                    dsMailAddressEntity.setDskousinymdtime(sysTime);
                                    dsMailAddressEntity.setGyoumuKousinKinou(kinou.getKinouId());
                                    dsMailAddressEntity.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                                    dsMailAddressEntity.setGyoumuKousinTime(sysTime);
                                }
                            }else{

                                dsMailAddressEntity.setDsmailtourokujyoutaikbn(C_DsMailTourokuJyoutaiKbn.TOUROKU);
                                dsMailAddressEntity.setDsmailaddress(mosKihon.getDsmailaddress());
                                dsMailAddressEntity.setDsmailsousinjyoutaikbn(C_DsMailSousinJyoutaiKbn.YUUKOU);
                                dsMailAddressEntity.setDsmailsousintisrykbn(C_DsMailSousinTeisiRiyuuKbn.BLNK);
                                dsMailAddressEntity.setDskousinymdtime(sysTime);
                                dsMailAddressEntity.setGyoumuKousinKinou(kinou.getKinouId());
                                dsMailAddressEntity.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                                dsMailAddressEntity.setGyoumuKousinTime(sysTime);

                                if (dsMailAddressSpiralYyk == null) {

                                    dsMailAddressSpiralYyk = dsKokyakuKanri.createDsMailAddressSpiralYyk();

                                    dsMailAddressSpiralYyk.setDsdatasakuseiymd(syoriYmd);
                                    dsMailAddressSpiralYyk.setDsmailaddressrenban(1);
                                    dsMailAddressSpiralYyk.setDsmailaddress(mosKihon.getDsmailaddress());
                                    dsMailAddressSpiralYyk.setDsrendoutaisyoukbn(C_DsRendouTaisyouKbn.RENDOUTAISYOU);
                                    dsMailAddressSpiralYyk.setGyoumuKousinKinou(kinou.getKinouId());
                                    dsMailAddressSpiralYyk.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                                    dsMailAddressSpiralYyk.setGyoumuKousinTime(sysTime);

                                    if (BizUtil.isBlank(dsMailAddress)) {

                                        dsMailAddressSpiralYyk.setDsmaildbsyorikbn(C_DsMailDbSyoriKbn.TOUROKU);
                                    }
                                    else {

                                        dsMailAddressSpiralYyk.setDsmaildbsyorikbn(C_DsMailDbSyoriKbn.KOUSIN);
                                    }

                                    BizPropertyInitializer.initialize(dsMailAddressSpiralYyk);
                                }
                                else {

                                    dsMailAddressSpiralYyk.setDsmailaddress(mosKihon.getDsmailaddress());
                                    dsMailAddressSpiralYyk.setDsrendoutaisyoukbn(C_DsRendouTaisyouKbn.RENDOUTAISYOU);
                                    dsMailAddressSpiralYyk.setGyoumuKousinKinou(kinou.getKinouId());
                                    dsMailAddressSpiralYyk.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                                    dsMailAddressSpiralYyk.setGyoumuKousinTime(sysTime);

                                    if (C_DsMailDbSyoriKbn.SAKUJYO.eq(dsMailAddressSpiralYyk.getDsmaildbsyorikbn())) {

                                        dsMailAddressSpiralYyk.setDsmaildbsyorikbn(C_DsMailDbSyoriKbn.KOUSIN);
                                    }
                                }
                            }
                        }
                    }
                }

                if (!BizUtil.isBlank(dsHenkouSikibetukey)) {

                    dsTetudukiRirekiTableEditParamImpl.setDskokno(dsKokno);
                    dsTetudukiRirekiTableEditParamImpl.setDsKokyakuKanri(dsKokyakuKanri);
                    dsTetudukiRirekiTableEditParamImpl.setBakDsKokyakuKanri(bakDsKokyakuKanri);
                    dsTetudukiRirekiTableEditParamImpl.setHenkousikibetukey(dsHenkouSikibetukey);
                    dsTetudukiRirekiTableEditParamImpl.setSyoriYmd(syoriYmd);
                    dsTetudukiRirekiTableEditParamImpl.setDssyorikbn(C_DsSyoriKbn.SEIRITU_KOKYAKU_SAKUSEI);
                    dsTetudukiRirekiTableEditParamImpl.setHenkouRrkYouhi(C_YouhiKbn.YOU);
                    editDSTtdkRirekiTbl.editDSTtdkRirekiTblBatch(dsTetudukiRirekiTableEditParamImpl);

                    syoriKensuu++;

                    if (nayoseKensuu == 1) {

                        dsKokyakuKanriEntityUpdater.add(dsKokyakuKanri);
                        bakDsKokyakuKanriInserter.add(bakDsKokyakuKanri);
                    }
                }
                directDomManager.flush();
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                String.valueOf(syoriKensuu), DS_SINKIKYK_TOROKUKENSUU));

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                String.valueOf(tyusyutuKensuu - syoriKensuu), DS_JIMU_KAKUNINKENSUU));
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
