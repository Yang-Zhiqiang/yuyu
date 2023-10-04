package yuyu.batch.direct.dskokyakukanri.dstrhkservicetorikomi;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.MultipleEntityUpdater;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.direct.dskokyakukanri.dstrhkservicetorikomi.dba.DsTrhkServiceTorikomiDao;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.direct.dscommon.DsSaibanSyori;
import yuyu.common.direct.dscommon.DsTetudukiRirekiTableEdit;
import yuyu.common.direct.dscommon.DsTetudukiRirekiTableEditParam;
import yuyu.common.direct.dscommon.DsTetudukiRirekiTableEditParamImpl;
import yuyu.common.direct.dscommon.HozenKeiyakuIdouJyoutaiSyutoku;
import yuyu.common.direct.dscommon.HozenKeiyakuIdouJyoutaiSyutokuBean;
import yuyu.common.direct.dscommon.TableMaintenanceUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_DsSyoriKbn;
import yuyu.def.classification.C_DsTrhkserviceKanyukeiroKbn;
import yuyu.def.classification.C_DsTrhkserviceRiyoujkKbn;
import yuyu.def.classification.C_DsTrhkserviceTeisiRiyuuKbn;
import yuyu.def.classification.C_IdoutyuuHanteiKekkaKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_TourokustatusKbn;
import yuyu.def.classification.C_UketorikouzasyubetuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_UketoriKouzaJyouhou;
import yuyu.def.db.entity.MT_BAK_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.entity.MT_DsSoukinyouKouza;
import yuyu.def.db.entity.MT_DsTorihikiServiceKanri;
import yuyu.def.db.entity.MT_DsTorihikiyouAnsyono;
import yuyu.def.db.entity.MT_DsTourokuUkKanri;
import yuyu.def.db.entity.MT_DsTourokuUkKouzaAnsyono;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * ダイレクトサービス 顧客管理 取引サービス取込
 */
public class DsTrhkServiceTorikomiBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private DsTrhkServiceTorikomiDao dsTrhkServiceTorikomiDao;

    @Inject
    private DirectDomManager directDomManager;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {
        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        long paperMosTrkmKensuu = 0;
        long paperLessTrkmKensuu = 0;
        long miTrkmKensuu = 0;

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        String kinouId = kinou.getKinouId();
        String userId = baseUserInfo.getUserId();
        String sysDateTimeMilli = BizDate.getSysDateTimeMilli();
        HozenKeiyakuIdouJyoutaiSyutoku hozenKeiyakuIdouJyoutaiSyutoku = SWAKInjector
            .getInstance(HozenKeiyakuIdouJyoutaiSyutoku.class);
        DsSaibanSyori dsSaibanSyori = SWAKInjector.getInstance(DsSaibanSyori.class);
        TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);
        DsTetudukiRirekiTableEdit dsTetudukiRirekiTableEdit =
            SWAKInjector.getInstance(DsTetudukiRirekiTableEdit.class);
        DsTetudukiRirekiTableEditParam dsTetudukiRirekiTableEditParam =
            SWAKInjector.getInstance(DsTetudukiRirekiTableEditParamImpl.class);

        try (
            MultipleEntityUpdater dataUpd = new MultipleEntityUpdater();
            EntityInserter<MT_BAK_DsKokyakuKanri> bakDsKokyakuKanriInserter = new EntityInserter<>()) {

            List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyakuLst =
                dsTrhkServiceTorikomiDao.getDsKokyakuKeiyakuToujitukanyuuBySyoriYmd(syoriYmd);

            for (MT_DsKokyakuKeiyaku dsKokyakuKeiyaku : dsKokyakuKeiyakuLst) {

                String syoNo = dsKokyakuKeiyaku.getSyono();
                boolean kykInfoUmuFlag = false;
                boolean kykTrhkServiceInfoUmuFlag = false;
                boolean tourokuUktkInfoUmuFlag = false;
                String dsHenkouSikibetukey = null;
                MT_DsKokyakuKanri dsKokyakuKanri = null;
                List<HT_SyoriCTL> syoriCTLList = null;
                HT_MosKihon mosKihon = null;
                HT_UketoriKouzaJyouhou uketoriKouzaJyouhou = null;
                MT_DsTourokuUkKanri dsTourokuUkKanri = null;
                MT_DsTourokuUkKouzaAnsyono dsTourokuUkKouzaAnsyono = null;
                MT_BAK_DsKokyakuKanri bakDsKokyakuKanri = null;

                dsKokyakuKanri = dsKokyakuKeiyaku.getDsKokyakuKanri();

                syoriCTLList = sinkeiyakuDomManager.getSyoriCTLsBySyono(syoNo);
                syoriCTLList = dsTrhkServiceTorikomiDao.detachMosKihonUketoriKouzaJyouhoutouched(syoriCTLList);

                if (syoriCTLList.size() != 0) {
                    mosKihon = syoriCTLList.get(0).getMosKihon();
                    kykInfoUmuFlag = true;

                    if (!BizUtil.isBlank(mosKihon.getTokuteitrhkansyono())) {
                        uketoriKouzaJyouhou = syoriCTLList.get(0).getUketoriKouzaJyouhouByUktkzsyubetukbn(
                            C_UketorikouzasyubetuKbn.DSSOUKINYOUKOUZA);
                        kykTrhkServiceInfoUmuFlag = true;
                    }
                }

                dsTourokuUkKanri = dsTrhkServiceTorikomiDao.getDsTourokuUkKanriBySyono(syoNo);

                if (dsTourokuUkKanri != null) {
                    dsTourokuUkKouzaAnsyono = dsTourokuUkKanri.getDsTourokuUkKouzaAnsyono();
                    tourokuUktkInfoUmuFlag = true;
                }

                if (tourokuUktkInfoUmuFlag) {
                    HozenKeiyakuIdouJyoutaiSyutokuBean hozenKeiyakuIdouJyoutaiSyutokuBean =
                        hozenKeiyakuIdouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutoku(syoNo);

                    if (C_IdoutyuuHanteiKekkaKbn.ERROR.eq(hozenKeiyakuIdouJyoutaiSyutokuBean.getIdoutyuuKbn())) {
                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0129,
                            MessageUtil.getMessage(MessageId.EMW1008)));
                    }

                    if (C_IdoutyuuHanteiKekkaKbn.IDOUTYUU.eq(hozenKeiyakuIdouJyoutaiSyutokuBean.getIdoutyuuKbn())) {
                        dsTourokuUkKanri.setTourokustatus(C_TourokustatusKbn.TORIKOMIERROR);
                        dsTourokuUkKanri.setGyoumuKousinKinou(kinouId);
                        dsTourokuUkKanri.setGyoumuKousinsyaId(userId);
                        dsTourokuUkKanri.setGyoumuKousinTime(sysDateTimeMilli);

                        dataUpd.add(dsTourokuUkKanri);

                        miTrkmKensuu++;

                        continue;
                    }

                    dsHenkouSikibetukey = dsSaibanSyori.saibanDsHenkouSikibetukey();

                    bakDsKokyakuKanri = tableMaintenanceUtil.exec(
                        dsKokyakuKanri.getDskokno(), dsHenkouSikibetukey);

                    if (bakDsKokyakuKanri == null) {
                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EMA1009,
                            dsKokyakuKanri.getDskokno()));
                    }

                    if (kykInfoUmuFlag) {

                        dsKokyakuKeiyaku.setGyoumuKousinKinou(kinouId);
                        dsKokyakuKeiyaku.setGyoumuKousinsyaId(userId);
                        dsKokyakuKeiyaku.setGyoumuKousinTime(sysDateTimeMilli);
                        dsKokyakuKeiyaku.setPplessrenjidssymenttdkhyj(mosKihon.getPplessrenjidssymenttdkhyj());
                    }

                    MT_DsTorihikiServiceKanri dsTorihikiServiceKanri = dsKokyakuKeiyaku.createDsTorihikiServiceKanri();
                    dsTorihikiServiceKanri.setDskokno(dsKokyakuKanri.getDskokno());
                    dsTorihikiServiceKanri.setSyono(dsKokyakuKeiyaku.getSyono());
                    dsTorihikiServiceKanri.setDstrhkserviceriyoujkkbn(C_DsTrhkserviceRiyoujkKbn.RIYOU_KA);
                    dsTorihikiServiceKanri.setDstrhkserviceteisiriyuukbn(C_DsTrhkserviceTeisiRiyuuKbn.BLNK);
                    dsTorihikiServiceKanri.setDstrhkservicetourokuymd(syoriYmd);
                    dsTorihikiServiceKanri.setDstrhkservicekanyukeirokbn(
                        dsTourokuUkKouzaAnsyono.getDstrhkservicekanyukeirokbn());
                    dsTorihikiServiceKanri.setGyoumuKousinKinou(kinouId);
                    dsTorihikiServiceKanri.setGyoumuKousinsyaId(userId);
                    dsTorihikiServiceKanri.setGyoumuKousinTime(sysDateTimeMilli);

                    BizPropertyInitializer.initialize(dsTorihikiServiceKanri);

                    MT_DsSoukinyouKouza dsSoukinyouKouza = dsTorihikiServiceKanri.createDsSoukinyouKouza();
                    dsSoukinyouKouza.setDskokno(dsKokyakuKanri.getDskokno());
                    dsSoukinyouKouza.setSyono(dsKokyakuKeiyaku.getSyono());
                    dsSoukinyouKouza.setKzsyuruikbn(C_KouzasyuruiKbn.YENKOUZA);
                    dsSoukinyouKouza.setBankcd(dsTourokuUkKouzaAnsyono.getBankcd());
                    dsSoukinyouKouza.setSitencd(dsTourokuUkKouzaAnsyono.getSitencd());
                    dsSoukinyouKouza.setYokinkbn(dsTourokuUkKouzaAnsyono.getYokinkbn());
                    dsSoukinyouKouza.setKouzano(dsTourokuUkKouzaAnsyono.getKouzano());
                    dsSoukinyouKouza.setKzdoukbn(dsTourokuUkKouzaAnsyono.getKzdoukbn());
                    if (C_Kzdou.DOUITU.eq(dsTourokuUkKouzaAnsyono.getKzdoukbn())) {
                        dsSoukinyouKouza.setKzmeiginmkn("");
                    }
                    else {
                        dsSoukinyouKouza.setKzmeiginmkn(dsTourokuUkKouzaAnsyono.getKzmeiginmkn());
                    }
                    dsSoukinyouKouza.setGyoumuKousinKinou(kinouId);
                    dsSoukinyouKouza.setGyoumuKousinsyaId(userId);
                    dsSoukinyouKouza.setGyoumuKousinTime(sysDateTimeMilli);

                    BizPropertyInitializer.initialize(dsSoukinyouKouza);

                    MT_DsTorihikiyouAnsyono dsTorihikiyouAnsyono = dsTorihikiServiceKanri.createDsTorihikiyouAnsyono();
                    dsTorihikiyouAnsyono.setDskokno(dsKokyakuKanri.getDskokno());
                    dsTorihikiyouAnsyono.setSyono(dsKokyakuKeiyaku.getSyono());
                    dsTorihikiyouAnsyono.setTokuteitrhkansyono(dsTourokuUkKouzaAnsyono.getTokuteitrhkansyono());
                    dsTorihikiyouAnsyono.setSetymd(syoriYmd);
                    dsTorihikiyouAnsyono.setGyoumuKousinKinou(kinouId);
                    dsTorihikiyouAnsyono.setGyoumuKousinsyaId(userId);
                    dsTorihikiyouAnsyono.setGyoumuKousinTime(sysDateTimeMilli);

                    BizPropertyInitializer.initialize(dsTorihikiyouAnsyono);

                    dsTourokuUkKanri.setTourokustatus(C_TourokustatusKbn.TOUROKUZUMI);
                    dsTourokuUkKanri.setDstourokukanryouymd(syoriYmd);
                    dsTourokuUkKanri.setGyoumuKousinKinou(kinouId);
                    dsTourokuUkKanri.setGyoumuKousinsyaId(userId);
                    dsTourokuUkKanri.setGyoumuKousinTime(sysDateTimeMilli);

                    dsTourokuUkKouzaAnsyono.setTokuteitrhkansyono("");
                    dsTourokuUkKouzaAnsyono.setGyoumuKousinKinou(kinouId);
                    dsTourokuUkKouzaAnsyono.setGyoumuKousinsyaId(userId);
                    dsTourokuUkKouzaAnsyono.setGyoumuKousinTime(sysDateTimeMilli);

                    dataUpd.add(dsTourokuUkKanri);

                    paperMosTrkmKensuu++;
                }
                else {
                    if (kykInfoUmuFlag) {
                        dsHenkouSikibetukey = dsSaibanSyori.saibanDsHenkouSikibetukey();

                        bakDsKokyakuKanri = tableMaintenanceUtil.exec(
                            dsKokyakuKanri.getDskokno(), dsHenkouSikibetukey);

                        if (bakDsKokyakuKanri == null) {
                            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EMA1009,
                                dsKokyakuKanri.getDskokno()));
                        }

                        dsKokyakuKeiyaku.setGyoumuKousinKinou(kinouId);
                        dsKokyakuKeiyaku.setGyoumuKousinsyaId(userId);
                        dsKokyakuKeiyaku.setGyoumuKousinTime(sysDateTimeMilli);
                        dsKokyakuKeiyaku.setPplessrenjidssymenttdkhyj(mosKihon.getPplessrenjidssymenttdkhyj());

                        if (kykTrhkServiceInfoUmuFlag) {
                            MT_DsTorihikiServiceKanri dsTorihikiServiceKanri =
                                dsKokyakuKeiyaku.createDsTorihikiServiceKanri();
                            dsTorihikiServiceKanri.setDskokno(dsKokyakuKanri.getDskokno());
                            dsTorihikiServiceKanri.setSyono(dsKokyakuKeiyaku.getSyono());
                            dsTorihikiServiceKanri.setDstrhkserviceriyoujkkbn(C_DsTrhkserviceRiyoujkKbn.RIYOU_KA);
                            dsTorihikiServiceKanri.setDstrhkserviceteisiriyuukbn(C_DsTrhkserviceTeisiRiyuuKbn.BLNK);
                            dsTorihikiServiceKanri.setDstrhkservicetourokuymd(syoriYmd);
                            dsTorihikiServiceKanri.setDstrhkservicekanyukeirokbn(
                                C_DsTrhkserviceKanyukeiroKbn.SINKEIYAKUDOUJI);
                            dsTorihikiServiceKanri.setGyoumuKousinKinou(kinouId);
                            dsTorihikiServiceKanri.setGyoumuKousinsyaId(userId);
                            dsTorihikiServiceKanri.setGyoumuKousinTime(sysDateTimeMilli);

                            BizPropertyInitializer.initialize(dsTorihikiServiceKanri);

                            MT_DsSoukinyouKouza dsSoukinyouKouza = dsTorihikiServiceKanri.createDsSoukinyouKouza();
                            dsSoukinyouKouza.setDskokno(dsKokyakuKanri.getDskokno());
                            dsSoukinyouKouza.setSyono(dsKokyakuKeiyaku.getSyono());
                            dsSoukinyouKouza.setKzsyuruikbn(uketoriKouzaJyouhou.getKzsyuruikbn());
                            dsSoukinyouKouza.setBankcd(uketoriKouzaJyouhou.getBankcd());
                            dsSoukinyouKouza.setSitencd(uketoriKouzaJyouhou.getSitencd());
                            dsSoukinyouKouza.setYokinkbn(uketoriKouzaJyouhou.getYokinkbn());
                            dsSoukinyouKouza.setKouzano(uketoriKouzaJyouhou.getKouzano());
                            dsSoukinyouKouza.setKzdoukbn(C_Kzdou.DOUITU);
                            dsSoukinyouKouza.setGyoumuKousinKinou(kinouId);
                            dsSoukinyouKouza.setGyoumuKousinsyaId(userId);
                            dsSoukinyouKouza.setGyoumuKousinTime(sysDateTimeMilli);

                            BizPropertyInitializer.initialize(dsSoukinyouKouza);

                            MT_DsTorihikiyouAnsyono dsTorihikiyouAnsyono =
                                dsTorihikiServiceKanri.createDsTorihikiyouAnsyono();
                            dsTorihikiyouAnsyono.setDskokno(dsKokyakuKanri.getDskokno());
                            dsTorihikiyouAnsyono.setSyono(dsKokyakuKeiyaku.getSyono());
                            dsTorihikiyouAnsyono.setTokuteitrhkansyono(mosKihon.getTokuteitrhkansyono());
                            dsTorihikiyouAnsyono.setSetymd(syoriYmd);
                            dsTorihikiyouAnsyono.setGyoumuKousinKinou(kinouId);
                            dsTorihikiyouAnsyono.setGyoumuKousinsyaId(userId);
                            dsTorihikiyouAnsyono.setGyoumuKousinTime(sysDateTimeMilli);

                            BizPropertyInitializer.initialize(dsTorihikiyouAnsyono);

                            paperLessTrkmKensuu++;
                        }
                    }
                    else {
                        continue;
                    }
                }

                if (dsHenkouSikibetukey != null) {
                    dsTetudukiRirekiTableEditParam.setDsKokyakuKanri(dsKokyakuKanri);
                    dsTetudukiRirekiTableEditParam.setBakDsKokyakuKanri(bakDsKokyakuKanri);
                    dsTetudukiRirekiTableEditParam.setHenkousikibetukey(dsHenkouSikibetukey);
                    dsTetudukiRirekiTableEditParam.setSyoriYmd(syoriYmd);
                    dsTetudukiRirekiTableEditParam.setDssyorikbn(C_DsSyoriKbn.TORIHIKI_SERVICE_TORIKOMI);
                    dsTetudukiRirekiTableEditParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);

                    dsTetudukiRirekiTableEdit.editDSTtdkRirekiTblBatch(dsTetudukiRirekiTableEditParam);
                }

                if (bakDsKokyakuKanri != null) {
                    bakDsKokyakuKanriInserter.add(bakDsKokyakuKanri);
                }

                directDomManager.update(dsKokyakuKanri);
            }

            batchLogger.info(MessageUtil.getMessage(
                MessageId.IBF0002, String.valueOf(paperMosTrkmKensuu), "ＤＳ取引サービス取込件数（紙申込）"));
            batchLogger.info(MessageUtil.getMessage(
                MessageId.IBF0002, String.valueOf(paperLessTrkmKensuu), "ＤＳ取引サービス取込件数（ペーパーレス申込）"));
            batchLogger.info(MessageUtil.getMessage(
                MessageId.IBF0002, String.valueOf(miTrkmKensuu), "ＤＳ取引サービス未取込件数"));
        }
    }
}
