package yuyu.batch.siharai.sisatei.sisiharai;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.google.common.collect.Iterables;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.SaibanBiz;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzProcessForwardForBatch;
import yuyu.common.biz.koutei.BzProcessForwardForBatchInBean;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuPrm;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HushrGeninKbn;
import yuyu.def.classification.C_JimukakuteiKbn;
import yuyu.def.classification.C_MisyuumikeikaKbn;
import yuyu.def.classification.C_NayoseYouhi;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SeisankinKanritukaKbn;
import yuyu.def.classification.C_ShiharaikekkadataKbn;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_SyoriJyoutaiKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.DM_JimutetuzukiTask;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.def.db.entity.JT_MisyuupMkkpDetail;
import yuyu.def.db.entity.JT_MisyuupRendo;
import yuyu.def.db.entity.JT_SateiSyouninRireki;
import yuyu.def.db.entity.JT_SiDetail;
import yuyu.def.db.entity.JT_SiKekka;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkJiyuu;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.JT_TtdkRireki;
import yuyu.def.db.entity.ZT_SiShrdetailTy;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.siharai.sorter.SortJT_SateiSyouninRireki;
import yuyu.def.siharai.sorter.SortJT_SiRireki;
import yuyu.def.siharai.sorter.SortJT_Sk;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 保険金給付金支払 査定／支払 支払不支払
 */
public class SiSiharaiBatch implements Batch {

    private final String JTSIKEKKA = "支払・不支払　支払処理結果テーブル";

    private final String JTMISYUUPRENDO = "支払・不支払　未収Ｐ連動テーブル";

    private final String KOUTEIKANRYOU = "工程完了";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private WorkflowDomManager workflowDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

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

        String skKihonId = "JT_SkKihon";

        String recoveryId = "Si001";

        Integer shihaSyoriKekkaKennsu = 0;

        Integer misyuupRendoKennsu = 0;

        Integer kouteiKanryouKennsu = 0;

        List<BzProcessForwardForBatchInBean> bzProcessForwardForBatchInBeanLst = new ArrayList<>();

        try (EntityInserter<JT_SiKekka> siKekkaEntityInserter = new EntityInserter<>();

            EntityInserter<JT_MisyuupRendo> misyuupRendoEntityInserter = new EntityInserter<>();

            EntityInserter<ZT_SiShrdetailTy> siShrdetailTyEntityInserter = new EntityInserter<>()){

            JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();

            String gyoumuKousinTime = BizDate.getSysDateTimeMilli();

            try (ExDBUpdatableResults<JT_SkKihon> skKihonExDBResults = siharaiDomManager.getSkKihonsByKakutyoujobcdSyorijyoutaikbnShrkekkakbnNe(
                bzBatchParam.getIbKakutyoujobcd(), C_SyoriJyoutaiKbn.SYORITYUU, C_ShrKekkaKbn.BLNK)) {

                KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);
                KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);

                for (JT_SkKihon skKihon : skKihonExDBResults) {

                    bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                    bzRecoveryDatasikibetuBean.setIbTableid(skKihonId);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(recoveryId);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(skKihon.getSyono());
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(skKihon.getSkno());

                    keiyakuPrm.setSyono(skKihon.getSyono());
                    keiyakuPrm.setINayoseyh(C_NayoseYouhi.HUYOU);

                    keiyakuInfoSyutoku.getInfos(keiyakuPrm);

                    JT_SiKykKihon siKykKihon = keiyakuInfoSyutoku.getKykKihons().get(0);

                    List<JT_SiKykSyouhn> siKykSyouhnLst = siKykKihon.getSiKykSyouhns();

                    for (JT_SiKykSyouhn siKykSyouhnIcnt : siKykSyouhnLst) {

                        if (C_SyutkKbn.SYU.eq(siKykSyouhnIcnt.getSyutkkbn())) {

                            siKykSyouhn = siKykSyouhnIcnt;

                            break;
                        }
                    }

                    List<JT_Sk> skLst = skKihon.getSks();

                    SortJT_Sk sortSk = SWAKInjector.getInstance(SortJT_Sk.class);
                    JT_Sk sk = sortSk.OrderJT_SkByPkDesc(skLst).get(0);

                    JM_SiSyouhnZokusei siSyouhnZokusei = siharaiDomManager.getSiSyouhnZokuseisBySyouhncd(siKykSyouhn.getSyouhncd());

                    int syohinHanteiKbn = SyouhinUtil.hantei(siKykSyouhn.getSyouhncd());

                    List<JT_SiKekka> siKekkaLst = siharaiDomManager.getSiKekkasBySyono(skKihon.getSyono());

                    if (siKekkaLst.size() == 0) {
                        if (C_SaisateiKbn.BLNK.eq(skKihon.getSaisateikbn())){

                            List<JT_SiRireki> siRirekiLst = skKihon.getSiRirekis();

                            SortJT_SiRireki sortSiRireki = SWAKInjector.getInstance(SortJT_SiRireki.class);

                            JT_SiRireki siRireki = sortSiRireki.OrderJT_SiRirekiByPkDesc(siRirekiLst).get(0);

                            List<JT_SateiSyouninRireki> sateiSyouninRirekiLst = skKihon.getSateiSyouninRirekisBySeikyuurirekino(siRireki.getSeikyuurirekino());

                            SortJT_SateiSyouninRireki sortJTSateiSyouninRireki = SWAKInjector.getInstance(SortJT_SateiSyouninRireki.class);

                            JT_SateiSyouninRireki sateiSyouninRireki = sortJTSateiSyouninRireki.OrderJT_SateiSyouninRirekiByPkDesc(sateiSyouninRirekiLst).get(0);

                            if (C_SeikyuuSyubetu.SB.eq(skKihon.getSeikyuusyubetu())) {

                                JT_SiKekka siKekka = new JT_SiKekka();

                                List<JT_SkJiyuu> skJiyuuLst = sk.getSkJiyuus();

                                JT_SkJiyuu skJiyuu = skJiyuuLst.get(0);
                                List<JT_SiDetail> siDetailLst = skJiyuu.getSiDetailsByKyhkgNe();

                                siKekka.setShiharaikekkadatakbn(C_ShiharaikekkadataKbn.SYOUMETU);

                                siKekka.setSyono(skKihon.getSyono());

                                siKekka.setSyouhncd(siKykSyouhn.getSyouhncd());

                                siKekka.setSyouhnsdno(siKykSyouhn.getSyouhnsdno());

                                siKekka.setKyksyouhnrenno(siKykSyouhn.getKyksyouhnrenno());

                                siKekka.setSyutkkbn(siKykSyouhn.getSyutkkbn());

                                siKekka.setKouryokuhasseiymd(skJiyuuLst.get(0).getSibouymd()) ;

                                if (C_HushrGeninKbn.MENSEKI_SNDJST.eq(sateiSyouninRireki.getHushrgeninkbn()) ||
                                    C_HushrGeninKbn.MENSEKI_JNDJST.eq(sateiSyouninRireki.getHushrgeninkbn()) ||
                                    C_HushrGeninKbn.MENSEKI_TNDJST.eq(sateiSyouninRireki.getHushrgeninkbn()) ||
                                    C_HushrGeninKbn.KOI.eq(sateiSyouninRireki.getHushrgeninkbn()) ||
                                    C_HushrGeninKbn.SONOTA_MS.eq(sateiSyouninRireki.getHushrgeninkbn())) {

                                    siKekka.setSyoumetujiyuu(C_Syoumetujiyuu.MENSEKI) ;
                                }

                                else if (C_HushrGeninKbn.KAIJYO_JD.eq(sateiSyouninRireki.getHushrgeninkbn()) ||
                                    C_HushrGeninKbn.KAIJYO_SONOTA.eq(sateiSyouninRireki.getHushrgeninkbn())) {

                                    siKekka.setSyoumetujiyuu(C_Syoumetujiyuu.SBKAIJO) ;
                                }

                                else if (C_HushrGeninKbn.MUKOU_SG.eq(sateiSyouninRireki.getHushrgeninkbn()) ||
                                    C_HushrGeninKbn.MUKOU_HHST.eq(sateiSyouninRireki.getHushrgeninkbn()) ||
                                    C_HushrGeninKbn.MUKOU_SONOTA.eq(sateiSyouninRireki.getHushrgeninkbn())) {

                                    siKekka.setSyoumetujiyuu(C_Syoumetujiyuu.SBMUKOU) ;
                                }

                                else if (C_HushrGeninKbn.SAI_GR.eq(sateiSyouninRireki.getHushrgeninkbn()) ||
                                    C_HushrGeninKbn.SAI_GH.eq(sateiSyouninRireki.getHushrgeninkbn()) ||
                                    C_HushrGeninKbn.SAI_JJ.eq(sateiSyouninRireki.getHushrgeninkbn()) ||
                                    C_HushrGeninKbn.SAI_SONOTA.eq(sateiSyouninRireki.getHushrgeninkbn())) {

                                    siKekka.setSyoumetujiyuu(C_Syoumetujiyuu.SIBOUSAIGAIHIGAITOU) ;
                                }

                                else if (C_HushrGeninKbn.SAI_MENSEKI_JKT.eq(sateiSyouninRireki.getHushrgeninkbn()) ||
                                    C_HushrGeninKbn.SAI_MENSEKI_SYK.eq(sateiSyouninRireki.getHushrgeninkbn()) ||
                                    C_HushrGeninKbn.SAI_MENSEKI_MMK.eq(sateiSyouninRireki.getHushrgeninkbn()) ||
                                    C_HushrGeninKbn.SAI_MENSEKI_SSN.eq(sateiSyouninRireki.getHushrgeninkbn()) ||
                                    C_HushrGeninKbn.SAI_MENSEKI_SONOTA.eq(sateiSyouninRireki.getHushrgeninkbn())) {

                                    siKekka.setSyoumetujiyuu(C_Syoumetujiyuu.SIBOUSAIGAIMENSEKI) ;
                                }

                                else if (siDetailLst.size() > 0){
                                    if (C_HokenkinsyuruiKbn.SBKYUUHUKIN.eq(siDetailLst.get(0).getHokenkinsyuruikbn())) {
                                        siKekka.setSyoumetujiyuu(C_Syoumetujiyuu.SIBOUKYUUHUKINSHR) ;

                                    }
                                    else {
                                        siKekka.setSyoumetujiyuu(C_Syoumetujiyuu.SIBOU) ;
                                    }
                                }

                                if (C_Tuukasyu.JPY.eq(sk.getKyktuukasyu())) {

                                    siKekka.setKrkgk(sk.getKrkgk());
                                }
                                else {

                                    siKekka.setKrkgk(sk.getYenkakrkgk());
                                }

                                siKekka.setDenymd(siRireki.getTyakkinymd());

                                siKekka.setJyuutouym(sk.getMikeikapjyuutouym());

                                siKekka.setJyutoukaisuuy(sk.getMikeikapjyuutoukaisuuy());

                                siKekka.setJyutoukaisuum(sk.getMikeikapjyuutoukaisuum());

                                if (C_Tuukasyu.JPY.eq(sk.getKyktuukasyu())) {

                                    siKekka.setSeisanpgoukei(sk.getMikeikap());
                                }
                                else {

                                    if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn())) {

                                        siKekka.setSeisanpgoukei(sk.getYenkamikeikap());
                                    }
                                    else if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn())) {

                                        siKekka.setSeisanpgoukei(sk.getMikeikap());
                                    }
                                    else {

                                        siKekka.setSeisanpgoukei(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                                    }
                                }

                                siKekka.setHushrgeninkbn(sateiSyouninRireki.getHushrgeninkbn());

                                siKekka.setSyoriYmd(syoriYmd);

                                if (C_Tuukasyu.JPY.eq(sk.getKyktuukasyu())) {

                                    siKekka.setZennouseisankgk(sk.getZennouseisankgk());
                                }
                                else {

                                    if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {

                                        siKekka.setZennouseisankgk(sk.getYenkazennouseisankgk());
                                    }
                                    else if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {

                                        siKekka.setZennouseisankgk(sk.getZennouseisankgk());
                                    }
                                    else {

                                        siKekka.setZennouseisankgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                                    }
                                }

                                if (C_Tuukasyu.JPY.eq(sk.getKyktuukasyu())) {

                                    siKekka.setZennouseisankgkshrtk(sk.getZennouseisankgk());
                                }
                                else {

                                    if (C_Tuukasyu.JPY.eq(sk.getShrtuukasyu())) {

                                        siKekka.setZennouseisankgkshrtk(sk.getYenkazennouseisankgk());
                                    }
                                    else {

                                        siKekka.setZennouseisankgkshrtk(sk.getZennouseisankgk());
                                    }
                                }

                                siKekka.setZitkazukarikingksiteituuka(sk.getZitkazukarikingksiteituuka());

                                siKekka.setZitkazukarikingkyen(sk.getZitkazukarikingkyen());

                                siKekka.setShrtuukasyu(sk.getShrtuukasyu());

                                siKekka.setShrkwsratekjnymd(sk.getShrkwsratekjnymd());

                                siKekka.setShrkwsrate(sk.getShrkwsrate());

                                siKekka.setZeimukwsrate(sk.getZeimukwsrate());

                                siKekka.setKossyoricd(kinou.getKinouId());

                                siKekka.setKossyorisscd(Iterables.getFirst(kinou.getKinouModes(), null).getKinouModeId());

                                siKekka.setGyoumuKousinsyaId(baseUserInfo.getUser().getUserId());

                                siKekka.setGyoumuKousinTime(gyoumuKousinTime);

                                if (siKekka.getSeisanpgoukei().compareTo(BizCurrency.valueOf(0, siKekka.getSeisanpgoukei().getType())) > 0) {

                                    siKekka.setMisyuumikeikakbn(C_MisyuumikeikaKbn.MIKEIKAP);
                                }
                                else {

                                    siKekka.setMisyuumikeikakbn(C_MisyuumikeikaKbn.BLNK);
                                }

                                BizPropertyInitializer.initialize(siKekka);

                                siKekkaEntityInserter.add(siKekka);

                                shihaSyoriKekkaKennsu++;

                                List<JT_MisyuupMkkpDetail> misyuupMkkpDetailLst = sk.getMisyuupMkkpDetails();

                                Integer misyuupRendoRenno = 1;

                                if (misyuupMkkpDetailLst.size() > 0) {
                                    for (int m = 0; m < misyuupMkkpDetailLst.size(); m++) {

                                        if (misyuupMkkpDetailLst.get(m).getDtlmisyuup().compareTo(BizCurrency.valueOf(
                                            0, misyuupMkkpDetailLst.get(m).getDtlmisyuup().getType())) > 0 ||
                                            misyuupMkkpDetailLst.get(m).getDtlmisyuupgaika().compareTo(BizCurrency.valueOf(
                                                0, misyuupMkkpDetailLst.get(m).getDtlmisyuupgaika().getType())) > 0) {

                                            JT_MisyuupRendo misyuupRendo = new JT_MisyuupRendo();

                                            misyuupRendo.setSyono(sk.getSyono());

                                            misyuupRendo.setDatarenno(misyuupRendoRenno);

                                            misyuupRendo.setNykkeiro(C_Nykkeiro.HKNKIN);

                                            misyuupRendo.setHrkkaisuu(misyuupMkkpDetailLst.get(m).getDtlmisyuuphrkkaisuu());

                                            misyuupRendo.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);

                                            misyuupRendo.setIktnyuukinnumu(C_UmuKbn.NONE);

                                            misyuupRendo.setMisyuupjyuutouym(misyuupMkkpDetailLst.get(m)
                                                .getDtlmisyuupjytym());

                                            if (C_Hrkkaisuu.NEN.eq(misyuupMkkpDetailLst.get(m).getDtlmisyuuphrkkaisuu())) {

                                                misyuupRendo.setMisyuupjyuutoukaisuuy(1);
                                            }
                                            else {

                                                misyuupRendo.setMisyuupjyuutoukaisuuy(0);
                                            }

                                            if (C_Hrkkaisuu.NEN.eq(misyuupMkkpDetailLst.get(m).getDtlmisyuuphrkkaisuu())) {

                                                misyuupRendo.setMisyuupjyuutoukaisuum(0);

                                            }
                                            else if (C_Hrkkaisuu.HALFY.eq(misyuupMkkpDetailLst.get(m).getDtlmisyuuphrkkaisuu())) {

                                                misyuupRendo.setMisyuupjyuutoukaisuum(6);
                                            }
                                            else if (C_Hrkkaisuu.TUKI.eq(misyuupMkkpDetailLst.get(m).getDtlmisyuuphrkkaisuu())) {

                                                misyuupRendo.setMisyuupjyuutoukaisuum(1);
                                            }

                                            if (C_Tuukasyu.JPY.eq(sk.getKyktuukasyu())) {

                                                misyuupRendo.setMisyuup(misyuupMkkpDetailLst.get(m).getDtlmisyuup());
                                            }
                                            else {

                                                if (C_Tuukasyu.JPY.eq(sk.getShrtuukasyu())) {

                                                    misyuupRendo.setMisyuup(misyuupMkkpDetailLst.get(m)
                                                        .getDtlmisyuupgaikayenknsnkngk());
                                                }
                                                else {

                                                    misyuupRendo.setMisyuup(misyuupMkkpDetailLst.get(m)
                                                        .getDtlmisyuupgaika());
                                                }
                                            }

                                            misyuupRendo.setRyosyuymd(siRireki.getTyakkinymd());

                                            misyuupRendo.setDenymd(siRireki.getTyakkinymd());

                                            if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == syohinHanteiKbn) {

                                                misyuupRendo.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.NONE);
                                            }
                                            else if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == syohinHanteiKbn) {

                                                misyuupRendo.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.BLNK);
                                            }

                                            misyuupRendo.setShrtuukasyu(sk.getShrtuukasyu());

                                            misyuupRendo.setNyknkwsratekijyunymd(sk.getShrkwsratekjnymd());

                                            misyuupRendo.setSyoriYmd(syoriYmd);

                                            misyuupRendo.setKossyoricd(kinou.getKinouId());

                                            misyuupRendo.setKossyorisscd(Iterables
                                                .getFirst(kinou.getKinouModes(), null).getKinouModeId());

                                            misyuupRendo.setGyoumuKousinsyaId(baseUserInfo.getUser().getUserId());

                                            misyuupRendo.setGyoumuKousinTime(gyoumuKousinTime);

                                            BizPropertyInitializer.initialize(misyuupRendo);

                                            misyuupRendoEntityInserter.add(misyuupRendo);

                                            misyuupRendoKennsu++;
                                            misyuupRendoRenno++;
                                        }
                                    }
                                }
                            }
                        }
                    }

                    BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

                    BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

                    if (C_SeikyuuSyubetu.SB.eq(skKihon.getSeikyuusyubetu())) {
                        bzGetProcessSummaryInBean.setJimuTetuzukiCd(TeisuuSiharai.JIMUTETUZUKICD_SISIBOU);
                    }
                    if (C_SeikyuuSyubetu.SDSSHR.eq(skKihon.getSeikyuusyubetu())) {
                        bzGetProcessSummaryInBean.setJimuTetuzukiCd(TeisuuSiharai.JIMUTETUZUKICD_SISINDANSYORYOU);
                    }

                    bzGetProcessSummaryInBean.setSyoNo(skKihon.getSyono());

                    bzGetProcessSummaryInBean.setSkNos(new String[] { skKihon.getSkno() });

                    bzGetProcessSummaryInBean.setSyukouteiSiborikomiUmu(C_UmuKbn.ARI);

                    List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary
                        .exec(bzGetProcessSummaryInBean);

                    if (bzGetProcessSummaryOutBeanLst.size() == 0) {
                        throw new BizAppException(MessageUtil.getMessage(MessageId.EBF0162));
                    }

                    if (!TeisuuSiharai.NODEID_SISIHARAI.equals(bzGetProcessSummaryOutBeanLst.get(0).getNowNodoId())) {
                        continue;
                    }

                    skKihon.setSyorijyoutaikbn(C_SyoriJyoutaiKbn.KANRYOU);

                    skKihon.setKossyoricd(kinou.getKinouId());

                    skKihon.setKossyorisscd(Iterables.getFirst(kinou.getKinouModes(), null).getKinouModeId());

                    skKihon.setGyoumuKousinsyaId(baseUserInfo.getUser().getUserId());

                    skKihon.setGyoumuKousinTime(gyoumuKousinTime);

                    String tetudukirirekiSikibetukey = SaibanBiz.getTetudukirirekiSikibetukey(skKihon.getSyono());

                    JT_TtdkRireki ttdkRireki = skKihon.createTtdkRireki();

                    ttdkRireki.setTtdkrrkskbtkey(tetudukirirekiSikibetukey);

                    ttdkRireki.setSyoriYmd(syoriYmd);

                    ttdkRireki.setSyorisosikicd("");

                    ttdkRireki.setJimukakuteiumukbn(C_JimukakuteiKbn.KAKUTEI);

                    ttdkRireki.setSeikyuurirekino(sk.getSeikyuurirekino());

                    ttdkRireki.setShrsikibetukey("");

                    ttdkRireki.setSateisyouninskbtkey("");

                    ttdkRireki.setSyanaicomment("");

                    ttdkRireki.setKossyoricd(kinou.getKinouId());

                    ttdkRireki.setKossyorisscd(Iterables.getFirst(kinou.getKinouModes(), null).getKinouModeId());

                    ttdkRireki.setGyoumuKousinsyaId(baseUserInfo.getUser().getUserId());

                    ttdkRireki.setGyoumuKousinTime(gyoumuKousinTime);

                    BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean = SWAKInjector.getInstance(
                        BzProcessForwardForBatchInBean.class);

                    if (C_SeikyuuSyubetu.SB.eq(skKihon.getSeikyuusyubetu())) {

                        List<DM_JimutetuzukiTask> jimutetuzukiTaskLst = workflowDomManager.getJimutetuzukiTasksByJimutetuzukicdWorkflowTskId(
                            TeisuuSiharai.JIMUTETUZUKICD_SISIBOU, TeisuuSiharai.NODEID_SISIHARAI);

                        bzProcessForwardForBatchInBean.setKouteiKanriId(bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriId());

                        bzProcessForwardForBatchInBean.setJimuTetuzukiCd(TeisuuSiharai.JIMUTETUZUKICD_SISIBOU);

                        bzProcessForwardForBatchInBean.setTaskNm(jimutetuzukiTaskLst.get(0).getWorkflowTskNm());

                        bzProcessForwardForBatchInBeanLst.add(bzProcessForwardForBatchInBean);

                        kouteiKanryouKennsu++;
                    }

                    if (C_SeikyuuSyubetu.SDSSHR.eq(skKihon.getSeikyuusyubetu())) {

                        List<DM_JimutetuzukiTask> jimutetuzukiTaskLst = workflowDomManager.getJimutetuzukiTasksByJimutetuzukicdWorkflowTskId(
                            TeisuuSiharai.JIMUTETUZUKICD_SISINDANSYORYOU, TeisuuSiharai.NODEID_SISIHARAI);

                        bzProcessForwardForBatchInBean.setKouteiKanriId(bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriId());

                        bzProcessForwardForBatchInBean.setJimuTetuzukiCd(TeisuuSiharai.JIMUTETUZUKICD_SISINDANSYORYOU);

                        bzProcessForwardForBatchInBean.setTaskNm(jimutetuzukiTaskLst.get(0).getWorkflowTskNm());

                        bzProcessForwardForBatchInBeanLst.add(bzProcessForwardForBatchInBean);

                        kouteiKanryouKennsu++;
                    }
                }

                bzRecoveryDatasikibetuBean.initializeBlank();

                BzProcessForwardForBatch bzProcessForwardForBatch = SWAKInjector.getInstance(BzProcessForwardForBatch.class);

                bzProcessForwardForBatch.exec(bzProcessForwardForBatchInBeanLst) ;

                batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(shihaSyoriKekkaKennsu), JTSIKEKKA));

                batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(misyuupRendoKennsu), JTMISYUUPRENDO));

                batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(kouteiKanryouKennsu), KOUTEIKANRYOU));

            }
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}


