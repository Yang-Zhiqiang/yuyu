package yuyu.batch.siharai.sisatei.sidnprendou;

import java.math.BigDecimal;
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
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoKekkaBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzcommon.IGkCommonKoumoku;
import yuyu.common.biz.bzcommon.SaibanBiz;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuPrm;
import yuyu.common.siharai.sicommon.SiMeisaiCommonCalc;
import yuyu.common.siharai.sicommon.SiMeisaiCommonCalcBean;
import yuyu.common.siharai.sicommon.SiMeisaiCommonHensyu;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_JimukakuteiKbn;
import yuyu.def.classification.C_KanryotuutioutKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_NayoseYouhi;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.JM_SiTyouhyoumsg;
import yuyu.def.db.entity.JT_SiDetail;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkJiyuu;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.JT_TtdkRireki;
import yuyu.def.db.entity.ZT_SiShrdetailTy;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.siharai.sorter.SortJT_SiRireki;
import yuyu.def.siharai.sorter.SortJT_TtdkRireki;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 保険金給付金支払 査定／支払 保険金給付金DNP連動TBL作成
 */
public class SiDnprendouBatch implements Batch {

    private final String TITLE = "DNP_TITLE";

    private final String OSIRASEMONGON = "DNP_OSIRASEMONGON";

    private final String KOUZAMASKINGMSG = "DNP_KOUZAMASKINGMSG";

    private final String MIDASI = "DNP_MIDASI";

    private final String FREEMSG = "DNP_FREEMSG";

    private final String SANDZEIKIN = "FREEMSG_SANDZEIKIN";

    private final String ZEIKINSYURUI = "FREEMSG_ZEIKINSYURUI";

    private final String SOUZOKUZEI = "FREEMSG_SOUZOKUZEI";

    private final String SYOTOKUZEI = "FREEMSG_SYOTOKUZEI";

    private final String ZOUYOZEI = "FREEMSG_ZOUYOZEI";

    private final String KAZEINENDO = "FREEMSG_KAZEINENDO";

    private final String TYOUSYOTST = "FREEMSG_TYOUSYOTST";

    private final String ZEIMUINFO = "FREEMSG_ZEIMUINFO";

    private final String ZEIMUINFOHIJNGAIKA = "FREEMSG_ZEIMUINFOHIJNGAIKA";

    private final String ZEIMUINFOHIJNYEN ="FREEMSG_ZEIMUINFOHIJNYEN";

    private final String KZITYSYOU = "FREEMSG_KZITYSYOU";

    private final String KYKSYAHNK = "FREEMSG_KYKSYAHNK";

    private final String SIHOSOKU = "FREEMSG_SIHOSOKU";

    private final String AZUKARIKIN = "FREEMSG_AZUKARIKIN";

    private final String MISYUUP = "FREEMSG_MISYUUP";

    private final String ZENNOUHNKN = "FREEMSG_ZENNOUHNKN";

    private final String MIKEIKAP = "FREEMSG_MIKEIKAP";

    private final String TEKIYOU = "DNP_TEKIYOU";

    private final int MEISAIHAIRETUSUU = 24;

    private final int FREEMSGSUU = 46;

    private final String SINDANSYO = "診断書";

    private final String MAI = "枚";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

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

        String tableID = "JT_SkKihon";
        String filterID = "Si001";
        String sysDateTimeMilli = BizDate.getSysDateTimeMilli();

        int shrdtlsyoKensuu = 0;
        String simisituutimeiShr = "";
        String simisituutimeiSds = "";
        List<JM_SiTyouhyoumsg> osirasemongonListShr = new ArrayList<>();
        List<JM_SiTyouhyoumsg> osirasemongonListSds = new ArrayList<>();
        String kouzaMaskingMsg = "";
        List<JM_SiTyouhyoumsg> midasiList = new ArrayList<>();
        List<JM_SiTyouhyoumsg> freeMsgListSandzeikin = new ArrayList<>();
        List<JM_SiTyouhyoumsg> freeMsgListZeikinsyurui = new ArrayList<>();
        List<JM_SiTyouhyoumsg> freeMsgListSouzokuzei = new ArrayList<>();
        List<JM_SiTyouhyoumsg> freeMsgListSyotokuzei = new ArrayList<>();
        List<JM_SiTyouhyoumsg> freeMsgListZouyozei = new ArrayList<>();
        List<JM_SiTyouhyoumsg> freeMsgListKazeinendo = new ArrayList<>();
        List<JM_SiTyouhyoumsg> freeMsgListTyousyotst = new ArrayList<>();
        List<JM_SiTyouhyoumsg> freeMsgListZeimuinfo = new ArrayList<>();
        List<JM_SiTyouhyoumsg> freeMsgListZeimuinfoHijnGaika = new ArrayList<>();
        List<JM_SiTyouhyoumsg> freeMsgListZeimuinfoHijnYen = new ArrayList<>();
        List<JM_SiTyouhyoumsg> freeMsgListKzitysyou = new ArrayList<>();
        List<JM_SiTyouhyoumsg> freeMsgListKyksyahnk = new ArrayList<>();
        List<JM_SiTyouhyoumsg> freeMsgListSihosoku = new ArrayList<>();
        List<JM_SiTyouhyoumsg> freeMsgListAzukarikin = new ArrayList<>();
        List<JM_SiTyouhyoumsg> freeMsgListMisyuup = new ArrayList<>();
        List<JM_SiTyouhyoumsg> freeMsgListZennouhnkn = new ArrayList<>();
        List<JM_SiTyouhyoumsg> freeMsgListMikeikap = new ArrayList<>();
        List<JM_SiTyouhyoumsg> freeMsgListSds = new ArrayList<>();
        String tekiyouSindansyo = "";
        BizDate sibouymd = null;
        String tyouhyousakuseiymd = "";
        String siharaiymd = "";
        String kouzano = "";

        simisituutimeiShr = siharaiDomManager.getSiTyouhyoumsg(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(),
            TITLE,
            1).
            getTyouhyoumsg();

        simisituutimeiSds = siharaiDomManager.getSiTyouhyoumsg(
            C_SyoruiCdKbn.HK_SHMEISAI_SDS.getValue(),
            TITLE,
            1).
            getTyouhyoumsg();

        osirasemongonListShr = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2
            (C_SyoruiCdKbn.HK_SHRMESS.getValue(),
                OSIRASEMONGON);

        osirasemongonListSds = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHMEISAI_SDS.getValue(),
            OSIRASEMONGON);

        kouzaMaskingMsg = siharaiDomManager.getSiTyouhyoumsg(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(),
            KOUZAMASKINGMSG,
            1).
            getTyouhyoumsg();

        midasiList = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(),
            MIDASI);

        freeMsgListSandzeikin = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(),
            SANDZEIKIN);

        freeMsgListZeikinsyurui = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(),
            ZEIKINSYURUI);

        freeMsgListSouzokuzei = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(),
            SOUZOKUZEI);

        freeMsgListSyotokuzei = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(),
            SYOTOKUZEI);

        freeMsgListZouyozei = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(),
            ZOUYOZEI);

        freeMsgListKazeinendo = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(),
            KAZEINENDO);

        freeMsgListTyousyotst = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(),
            TYOUSYOTST);

        freeMsgListZeimuinfo = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(),
            ZEIMUINFO);

        freeMsgListZeimuinfoHijnGaika = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(),
            ZEIMUINFOHIJNGAIKA);

        freeMsgListZeimuinfoHijnYen = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(),
            ZEIMUINFOHIJNYEN);

        freeMsgListKzitysyou = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(),
            KZITYSYOU);

        freeMsgListKyksyahnk = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(),
            KYKSYAHNK);

        freeMsgListSihosoku = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(),
            SIHOSOKU);

        freeMsgListAzukarikin = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(),
            AZUKARIKIN);

        freeMsgListMisyuup = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(),
            MISYUUP);

        freeMsgListZennouhnkn = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(),
            ZENNOUHNKN);

        freeMsgListMikeikap = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHRMESS.getValue(),
            MIKEIKAP);

        freeMsgListSds = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            C_SyoruiCdKbn.HK_SHMEISAI_SDS.getValue(),
            FREEMSG);

        tekiyouSindansyo = siharaiDomManager.getSiTyouhyoumsg(
            C_SyoruiCdKbn.HK_SHMEISAI_SDS.getValue(),
            TEKIYOU,
            1).
            getTyouhyoumsg();

        try (ExDBResults<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsByKakutyoujobcdGaibuinsatuoutymd(
            bzBatchParam.getIbKakutyoujobcd(),
            bzBatchParam.getSyoriYmd());
            EntityInserter<ZT_SiShrdetailTy> siShrdetailTyLst = new EntityInserter<>();
            EntityInserter<JT_TtdkRireki> ttdkRirekiLst = new EntityInserter<>();) {

            for (JT_SkKihon skKihon : skKihonLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(tableID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(filterID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(skKihon.getSyono());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(skKihon.getSkno());

                C_SeikyuuSyubetu seikyuuSyubetu = skKihon.getSeikyuusyubetu();

                KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);

                KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);

                keiyakuPrm.setSyono(skKihon.getSyono());

                keiyakuPrm.setINayoseyh(C_NayoseYouhi.HUYOU);

                keiyakuInfoSyutoku.getInfos(keiyakuPrm);

                List<JT_SiKykKihon> siKykKihonList = keiyakuInfoSyutoku.getKykKihons();

                JT_SiKykKihon siKykKihon = siKykKihonList.get(0);

                List<JT_SiKykSyouhn> siKykSyouhnLst= siKykKihon.getSiKykSyouhns();

                JT_SiKykSyouhn siKykSyouhnSyu = new JT_SiKykSyouhn();

                for (JT_SiKykSyouhn siKykSyouhn : siKykSyouhnLst) {
                    if (C_SyutkKbn.SYU.eq(siKykSyouhn.getSyutkkbn())) {
                        siKykSyouhnSyu = siKykSyouhn;

                        break;
                    }
                }

                JT_SkKihon skKihon1 = siharaiDomManager.getSkKihon(
                    skKihon.getSkno(),
                    skKihon.getSyono());

                List<JT_SiRireki> siRirekiList = skKihon1.getSiRirekis();

                SortJT_SiRireki sortJtSiRireki = SWAKInjector.getInstance(SortJT_SiRireki.class);

                siRirekiList = sortJtSiRireki.OrderJT_SiRirekiByPkDesc(siRirekiList);

                JT_SiRireki siRireki = siRirekiList.get(0);

                JT_Sk sk = skKihon1.getSkBySeikyuurirekino(siRireki.getSeikyuurirekino());

                if (!C_SeikyuuSyubetu.SDSSHR.eq(seikyuuSyubetu)) {
                    List<JT_SkJiyuu> skJiyuuList = sk.getSkJiyuus();

                    sibouymd = skJiyuuList.get(0).getSibouymd();
                }

                JT_TtdkRireki ttdkRireki = new JT_TtdkRireki();
                if (C_SeikyuuSyubetu.SDSSHR.eq(seikyuuSyubetu)) {

                    List<JT_TtdkRireki> ttdkRirekiList = skKihon1.getTtdkRirekisByShrsikibetukey(
                        siRireki.getShrsikibetukey());

                    SortJT_TtdkRireki sortJtTtdkRireki = SWAKInjector.getInstance(SortJT_TtdkRireki.class);

                    ttdkRirekiList = sortJtTtdkRireki.OrderJT_TtdkRirekiByPkDesc(ttdkRirekiList);

                    ttdkRireki = ttdkRirekiList.get(0);

                }

                List<JT_SiDetail> siDetailList = new ArrayList<>();
                if (C_SeikyuuSyubetu.SB.eq(seikyuuSyubetu)) {

                    siDetailList = siharaiDomManager.getSiDetailsBySknoSyonoSeikyuurirekino(
                        sk.getSkno(),
                        sk.getSyono(),
                        sk.getSeikyuurirekino());

                }

                String  toiawaseSosikicd = "";
                if (C_SeikyuuSyubetu.SDSSHR.eq(seikyuuSyubetu)) {

                    toiawaseSosikicd = ttdkRireki.getSyorisosikicd();
                }
                else {

                    toiawaseSosikicd = YuyuBizConfig.getInstance().getCallcentersosikicd();
                }

                BzGetSosikiMadogutiInfo bzGetSosikiMadogutiInfo = SWAKInjector.getInstance(BzGetSosikiMadogutiInfo.class);

                BzGetSosikiMadogutiInfoKekkaBean bzGetSosikiMadogutiInfoKekkaBean = bzGetSosikiMadogutiInfo.exec(
                    toiawaseSosikicd);

                String toiawasePostalCd = bzGetSosikiMadogutiInfoKekkaBean.getPostalCd();
                String toiawaseAdr1 = bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1();
                String toiawaseAdr2 = bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2();
                String toiawaseAdr3 = bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr3();
                String toiawaseTelno = bzGetSosikiMadogutiInfoKekkaBean.getTelno();

                BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);

                BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(
                    sk.getBankcd(),
                    sk.getSitencd(),
                    bzBatchParam.getSyoriYmd());

                String bankNmKj = bzGetBankDataBean.getBankNmKj();
                String sitenNmKj = bzGetBankDataBean.getReportSitenNm();
                String yokinNmKj = sk.getYokinkbn().getContent();
                if(IGkCommonKoumoku.BANKCD_YTGINKOU.equals(sk.getBankcd())){
                    kouzano = sk.getKouzano() + "1";
                } else {
                    kouzano = sk.getKouzano();
                }

                String shrmisisynykngk = "0";
                String shrmisikztkgk = "0";
                String shrmisihtykeihi = "0";

                if (C_SeikyuuSyubetu.SB.eq(seikyuuSyubetu)) {

                    SiMeisaiCommonCalc siMeisaiCommonCalc = SWAKInjector.getInstance(SiMeisaiCommonCalc.class);
                    SiMeisaiCommonCalcBean siMeisaiCommonCalcBean = SWAKInjector.getInstance(SiMeisaiCommonCalcBean.class);
                    siMeisaiCommonCalcBean.setKykTuukasyu(sk.getKyktuukasyu());
                    siMeisaiCommonCalcBean.setShrTuukasyu(sk.getShrtuukasyu());
                    siMeisaiCommonCalcBean.setKawaseRate(sk.getShrkwsrate());
                    siMeisaiCommonCalcBean.setGaikaknsnkwsrate(sk.getGaikaknsnkwsrate());
                    siMeisaiCommonCalcBean.setZeimukwsrate(sk.getZeimukwsrate());
                    siMeisaiCommonCalcBean.setHokenkngkgoukei(sk.getHokenkngkgoukei());
                    siMeisaiCommonCalcBean.setZennouseisankgk(sk.getZennouseisankgk());
                    siMeisaiCommonCalcBean.setYenkazennouseisankgk(sk.getYenkazennouseisankgk());
                    siMeisaiCommonCalcBean.setMisyuup(sk.getMisyuup());
                    siMeisaiCommonCalcBean.setMikeikap(sk.getMikeikap());
                    siMeisaiCommonCalcBean.setYenkamikeikap(sk.getYenkamikeikap());
                    siMeisaiCommonCalcBean.setHaitoukin(sk.getHaitoukin());
                    siMeisaiCommonCalcBean.setYenkahaitoukin(sk.getYenkahaitoukin());
                    siMeisaiCommonCalcBean.setSonotahaitoukin(sk.getSonotahaitoukin());
                    siMeisaiCommonCalcBean.setYenkasonotahaitoukin(sk.getYenkasonotahaitoukin());
                    siMeisaiCommonCalcBean.setZitkazukarikingksiteituuka(sk.getZitkazukarikingksiteituuka());
                    siMeisaiCommonCalcBean.setZitkazukarikingkyen(sk.getZitkazukarikingkyen());
                    siMeisaiCommonCalcBean.setYenkakrkgk(sk.getYenkakrkgk());
                    siMeisaiCommonCalcBean.setZeitratkikbn(siRireki.getZeitratkikbn());
                    siMeisaiCommonCalcBean.setSyouhinCd(siKykSyouhnSyu.getSyouhncd());

                    C_ErrorKbn errorKbn = siMeisaiCommonCalc.exec(siMeisaiCommonCalcBean);

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                        throw new BizAppException(MessageId.EJA1004, kinou.getKinouNm(), JT_Sk.SYONO, sk.getSyono());
                    }

                    shrmisisynykngk = siMeisaiCommonCalc.getShrmisisynykngk().toAdsoluteString();
                    shrmisikztkgk = siMeisaiCommonCalc.getShrmisikztkgk().toAdsoluteString();

                    if (C_ZeitratkiKbn.ITIJI.eq(siRireki.getZeitratkikbn())){
                        shrmisihtykeihi = sk.getGoukeihituyoukeihi().toAdsoluteString();
                    }

                }

                C_UmuKbn kykHnkUm = C_UmuKbn.NONE;

                if(sk.getKykhnkkaisuu() > 0){
                    kykHnkUm = C_UmuKbn.ARI;
                }

                String[] tekiyou = new String[MEISAIHAIRETUSUU + 1];
                for (int i = 0; i < tekiyou.length; i++) {

                    tekiyou[i] = "";
                }

                Long[] gkDetail = new Long[MEISAIHAIRETUSUU + 1];
                for (int i = 0; i < gkDetail.length; i++) {

                    gkDetail[i] = 0L;
                }

                String[] gkDetailTuukasyu = new String[MEISAIHAIRETUSUU + 1];
                for (int i = 0; i < gkDetailTuukasyu.length; i++) {

                    gkDetailTuukasyu[i] = "";
                }

                Integer[] gkmeisaihugou = new Integer[MEISAIHAIRETUSUU + 1];
                for (int i = 0; i < gkmeisaihugou.length; i++) {

                    gkmeisaihugou[i] = 0;
                }

                String[] detailBikou = new String[MEISAIHAIRETUSUU + 1];
                for (int i = 0; i < detailBikou.length; i++) {

                    detailBikou[i] = "";
                }

                if (C_SeikyuuSyubetu.SDSSHR.eq(seikyuuSyubetu)) {

                    tekiyou[0] = tekiyouSindansyo;

                    gkDetail[0] = new BigDecimal(sk.getShrgk().toString()).longValue();

                    gkDetailTuukasyu[0] = C_Tuukasyu.JPY.getValue();

                    detailBikou[0] = SINDANSYO + ConvertUtil.toZenAll(sk.getSindansyomaisuu().toString(), 1, 1) + MAI;
                }
                else {

                    SiMeisaiCommonHensyu siMeisaiCommonHensyu = SWAKInjector.getInstance(SiMeisaiCommonHensyu.class);

                    C_ErrorKbn errorKbn = siMeisaiCommonHensyu.siMeisaiHensyu(sk, siDetailList, sibouymd,
                        C_KanryotuutioutKbn.GAIBU);

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                        throw new BizAppException(MessageId.EJA1004, kinou.getKinouNm(), JT_Sk.SYONO, sk.getSyono());
                    }

                    for (int l = 0; l < siMeisaiCommonHensyu.getSiMeisaiHensyuResult().size(); l++) {

                        tekiyou[l] = siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(l).getTekiYou();

                        gkDetail[l] = siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(l).getRendouShrGkMeisai();

                        gkmeisaihugou[l] = siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(l).
                            getRendouShrknGkMeisaiHugou();

                        detailBikou[l] = siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(l).getDetailBikou();

                        if (!C_Tuukasyu.BLNK.eq(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().
                            get(l).getRendouShrGkMeisaiTuukasyu())) {

                            gkDetailTuukasyu[l] = siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(l).
                                getRendouShrGkMeisaiTuukasyu().getValue();
                        }
                    }

                }

                String shrGoukeiTuukasyu = gkDetailTuukasyu[0];
                Long shrGoukeiGk = 0L;

                if (C_SeikyuuSyubetu.SDSSHR.eq(seikyuuSyubetu)) {
                    shrGoukeiGk = new BigDecimal(sk.getShrgk().toString()).longValue();

                }
                else {
                    if (C_Tuukasyu.JPY.eq(sk.getKyktuukasyu())) {
                        shrGoukeiGk = new BigDecimal(sk.getShrgk().toString()).longValue();
                    }
                    else {
                        if (C_Tuukasyu.JPY.eq(sk.getShrtuukasyu())) {
                            shrGoukeiGk = new BigDecimal(sk.getYenshrgk().toString()).longValue();

                        }
                        else {
                            shrGoukeiGk = new BigDecimal(sk.getShrgk().multiply(100).toString()).longValue();

                        }
                    }
                }

                List<JM_SiTyouhyoumsg> freeMsgList = new ArrayList<>();

                freeMsgList.addAll(freeMsgListSandzeikin);

                freeMsgList.addAll(freeMsgListZeikinsyurui);

                freeMsgList.addAll(freeMsgListSouzokuzei);

                freeMsgList.addAll(freeMsgListSyotokuzei);

                freeMsgList.addAll(freeMsgListZouyozei);

                freeMsgList.addAll(freeMsgListKazeinendo);

                freeMsgList.addAll(freeMsgListTyousyotst);

                if (C_Tuukasyu.JPY.eq(sk.getShrtuukasyu())) {
                    if (C_ZeitratkiKbn.ITIJI.eq(siRireki.getZeitratkikbn())) {
                        if (!C_Kykjyoutai.ITIJIBARAI.eq(siKykKihon.getKykjyoutai())) {

                            freeMsgList.addAll(freeMsgListZeimuinfoHijnYen);
                        }

                        if (C_UmuKbn.ARI.eq(kykHnkUm)) {

                            freeMsgList.addAll(freeMsgListKyksyahnk);
                        }
                    }
                }
                else {

                    if (C_ZeitratkiKbn.ITIJI.eq(siRireki.getZeitratkikbn())) {
                        if (!C_Kykjyoutai.ITIJIBARAI.eq(siKykKihon.getKykjyoutai())) {

                            freeMsgList.addAll(freeMsgListZeimuinfoHijnGaika);

                        } else {

                            freeMsgList.addAll(freeMsgListZeimuinfo);
                        }

                        if (C_UmuKbn.ARI.eq(kykHnkUm)) {

                            freeMsgList.addAll(freeMsgListKyksyahnk);
                        }
                    }
                    else {

                        freeMsgList.addAll(freeMsgListKzitysyou);
                    }
                }

                if (sk.getAzukarikingk().compareTo(BizCurrency.valueOf(0, sk.getAzukarikingk().getType())) != 0 ||
                    sk.getMisyuup().compareTo(BizCurrency.valueOf(0, sk.getMisyuup().getType())) != 0 ||
                    sk.getZennouseisankgk().compareTo(BizCurrency.valueOf(0, sk.getZennouseisankgk().getType())) != 0 ||
                    sk.getMikeikap().compareTo(BizCurrency.valueOf(0, sk.getMikeikap().getType())) != 0) {

                    freeMsgList.addAll(freeMsgListSihosoku);

                    if (sk.getAzukarikingk().compareTo(BizCurrency.valueOf(0, sk.getAzukarikingk().getType())) != 0) {

                        freeMsgList.addAll(freeMsgListAzukarikin);
                    }

                    if (sk.getMisyuup().compareTo(BizCurrency.valueOf(0, sk.getMisyuup().getType())) != 0) {

                        freeMsgList.addAll(freeMsgListMisyuup);
                    }

                    if (sk.getZennouseisankgk().compareTo(
                        BizCurrency.valueOf(0, sk.getZennouseisankgk().getType())) != 0) {

                        freeMsgList.addAll(freeMsgListZennouhnkn);
                    }
                    else if (sk.getMikeikap().compareTo(BizCurrency.valueOf(0, sk.getMikeikap().getType())) != 0) {

                        freeMsgList.addAll(freeMsgListMikeikap);
                    }
                }

                String[] freemsghrt = new String[FREEMSGSUU];
                for (int m = 0; m < freeMsgList.size(); m++) {

                    freemsghrt[m] = freeMsgList.get(m).getTyouhyoumsg();
                }

                String syoruiCd = "";
                String simisituutimei = "";
                String simisiosirasemongon1x1 = "";
                String simisiosirasemongon1x2 = "";
                String simisiosirasemongon2x1 = "";
                String simisiosirasemongon2x2 = "";
                String simisiosirasemongon2x3 = "";
                String simisiosirasemongon2x4 = "";
                String simisiosirasemongon2x5 = "";
                String simisifreemsg1 = "";
                String simisifreemsg2 = "";
                String simisifreemsg3 = "";
                String simisifreemsg4 = "";
                String simisifreemsg5 = "";
                String simisifreemsg6 = "";
                String simisifreemsg7 = "";
                String simisifreemsg8 = "";
                String simisifreemsg9 = "";
                String simisifreemsg10 = "";
                String simisifreemsg11 = "";
                String simisifreemsg12 = "";
                String simisifreemsg13 = "";
                String simisifreemsg14 = "";
                String simisifreemsg15 = "";
                String simisifreemsg16 = "";
                String simisifreemsg17 = "";
                String simisifreemsg18 = "";
                String simisifreemsg19 = "";
                String simisifreemsg20 = "";
                String simisifreemsg21 = "";
                String simisifreemsg22 = "";
                String simisifreemsg23 = "";
                String simisifreemsg24 = "";
                String simisifreemsg25 = "";
                String simisifreemsg26 = "";
                String simisifreemsg27 = "";
                String simisifreemsg28 = "";
                String simisifreemsg29 = "";
                String simisifreemsg30 = "";
                String simisifreemsg31 = "";
                String simisifreemsg32 = "";
                String simisifreemsg33 = "";
                String simisifreemsg34 = "";
                String simisifreemsg35 = "";
                String simisifreemsg36 = "";
                String simisifreemsg37 = "";
                String simisifreemsg38 = "";
                String simisifreemsg39 = "";
                String simisifreemsg40 = "";
                String simisifreemsg41 = "";
                String simisifreemsg42 = "";
                String simisifreemsg43 = "";
                String simisifreemsg44 = "";
                String simisifreemsg45 = "";
                String simisifreemsg46 = "";
                String simisiosirasemongon3x1 = "";
                String simisiosirasemongon3x2 = "";
                if (C_SeikyuuSyubetu.SDSSHR.eq(seikyuuSyubetu)) {

                    syoruiCd = C_SyoruiCdKbn.HK_SHMEISAI_SDS.getValue().toUpperCase();
                    simisituutimei = simisituutimeiSds;
                    simisiosirasemongon1x1 = osirasemongonListSds.get(0).getTyouhyoumsg();
                    simisiosirasemongon1x2 = osirasemongonListSds.get(1).getTyouhyoumsg();
                    simisiosirasemongon2x1 = osirasemongonListSds.get(2).getTyouhyoumsg();
                    simisiosirasemongon2x2 = osirasemongonListSds.get(3).getTyouhyoumsg();
                    simisiosirasemongon2x3 = osirasemongonListSds.get(4).getTyouhyoumsg();
                    simisiosirasemongon2x4 = osirasemongonListSds.get(5).getTyouhyoumsg();
                    simisiosirasemongon2x5 = osirasemongonListSds.get(6).getTyouhyoumsg();
                    simisifreemsg1 = freeMsgListSds.get(0).getTyouhyoumsg();
                    simisifreemsg2 = freeMsgListSds.get(1).getTyouhyoumsg();
                    simisifreemsg3 = freeMsgListSds.get(2).getTyouhyoumsg();
                    simisifreemsg4 = freeMsgListSds.get(3).getTyouhyoumsg();
                    simisifreemsg5 = freeMsgListSds.get(4).getTyouhyoumsg();
                    simisifreemsg6 = freeMsgListSds.get(5).getTyouhyoumsg();
                    simisifreemsg7 = freeMsgListSds.get(6).getTyouhyoumsg();
                    simisifreemsg8 = freeMsgListSds.get(7).getTyouhyoumsg();
                    simisifreemsg9 = freeMsgListSds.get(8).getTyouhyoumsg();
                    simisifreemsg10 = freeMsgListSds.get(9).getTyouhyoumsg();
                    simisifreemsg11 = freeMsgListSds.get(10).getTyouhyoumsg();
                    simisifreemsg12 = freeMsgListSds.get(11).getTyouhyoumsg();
                    simisifreemsg13 = freeMsgListSds.get(12).getTyouhyoumsg();
                    simisifreemsg14 = freeMsgListSds.get(13).getTyouhyoumsg();
                    simisifreemsg15 = freeMsgListSds.get(14).getTyouhyoumsg();
                    simisifreemsg16 = freeMsgListSds.get(15).getTyouhyoumsg();
                    simisifreemsg17 = freeMsgListSds.get(16).getTyouhyoumsg();
                    simisifreemsg18 = freeMsgListSds.get(17).getTyouhyoumsg();
                    simisifreemsg19 = freeMsgListSds.get(18).getTyouhyoumsg();
                    simisifreemsg20 = freeMsgListSds.get(19).getTyouhyoumsg();
                    simisifreemsg21 = freeMsgListSds.get(20).getTyouhyoumsg();
                    simisifreemsg22 = freeMsgListSds.get(21).getTyouhyoumsg();
                    simisifreemsg23 = freeMsgListSds.get(22).getTyouhyoumsg();
                    simisifreemsg24 = freeMsgListSds.get(23).getTyouhyoumsg();
                    simisifreemsg25 = freeMsgListSds.get(24).getTyouhyoumsg();
                    simisifreemsg26 = freeMsgListSds.get(25).getTyouhyoumsg();
                    simisifreemsg27 = freeMsgListSds.get(26).getTyouhyoumsg();
                    simisifreemsg28 = freeMsgListSds.get(27).getTyouhyoumsg();
                    simisifreemsg29 = freeMsgListSds.get(28).getTyouhyoumsg();
                    simisifreemsg30 = freeMsgListSds.get(29).getTyouhyoumsg();
                    simisifreemsg31 = freeMsgListSds.get(30).getTyouhyoumsg();
                    simisifreemsg32 = freeMsgListSds.get(31).getTyouhyoumsg();
                    simisifreemsg33 = freeMsgListSds.get(32).getTyouhyoumsg();
                    simisifreemsg34 = freeMsgListSds.get(33).getTyouhyoumsg();
                    simisifreemsg35 = freeMsgListSds.get(34).getTyouhyoumsg();
                    simisifreemsg36 = freeMsgListSds.get(35).getTyouhyoumsg();
                    simisifreemsg37 = freeMsgListSds.get(36).getTyouhyoumsg();
                    simisifreemsg38 = freeMsgListSds.get(37).getTyouhyoumsg();
                    simisifreemsg39 = freeMsgListSds.get(38).getTyouhyoumsg();
                    simisifreemsg40 = freeMsgListSds.get(39).getTyouhyoumsg();
                    simisifreemsg41 = freeMsgListSds.get(40).getTyouhyoumsg();
                    simisifreemsg42 = freeMsgListSds.get(41).getTyouhyoumsg();
                    simisifreemsg43 = freeMsgListSds.get(42).getTyouhyoumsg();
                    simisifreemsg44 = freeMsgListSds.get(43).getTyouhyoumsg();
                    simisifreemsg45 = freeMsgListSds.get(44).getTyouhyoumsg();
                    simisifreemsg46 = freeMsgListSds.get(45).getTyouhyoumsg();
                    simisiosirasemongon3x1 = osirasemongonListSds.get(7).getTyouhyoumsg();
                    simisiosirasemongon3x2 = osirasemongonListSds.get(8).getTyouhyoumsg();

                }
                else {

                    syoruiCd = C_SyoruiCdKbn.HK_SHRMESS.getValue().toUpperCase();
                    simisituutimei = simisituutimeiShr;
                    simisiosirasemongon1x1 = osirasemongonListShr.get(0).getTyouhyoumsg();
                    simisiosirasemongon1x2 = osirasemongonListShr.get(1).getTyouhyoumsg();
                    simisiosirasemongon2x1 = osirasemongonListShr.get(2).getTyouhyoumsg();
                    simisiosirasemongon2x2 = osirasemongonListShr.get(3).getTyouhyoumsg();
                    simisiosirasemongon2x3 = osirasemongonListShr.get(4).getTyouhyoumsg();
                    simisiosirasemongon2x4 = osirasemongonListShr.get(5).getTyouhyoumsg();
                    simisiosirasemongon2x5 = osirasemongonListShr.get(6).getTyouhyoumsg();
                    simisiosirasemongon3x1 = osirasemongonListShr.get(7).getTyouhyoumsg();
                    simisiosirasemongon3x2 = osirasemongonListShr.get(8).getTyouhyoumsg();

                    simisifreemsg1 = freemsghrt[0];
                    simisifreemsg2 = freemsghrt[1];
                    simisifreemsg3 = freemsghrt[2];
                    simisifreemsg4 = freemsghrt[3];
                    simisifreemsg5 = freemsghrt[4];
                    simisifreemsg6 = freemsghrt[5];
                    simisifreemsg7 = freemsghrt[6];
                    simisifreemsg8 = freemsghrt[7];
                    simisifreemsg9 = freemsghrt[8];
                    simisifreemsg10 = freemsghrt[9];
                    simisifreemsg11 = freemsghrt[10];
                    simisifreemsg12 = freemsghrt[11];
                    simisifreemsg13 = freemsghrt[12];
                    simisifreemsg14 = freemsghrt[13];
                    simisifreemsg15 = freemsghrt[14];
                    simisifreemsg16 = freemsghrt[15];
                    simisifreemsg17 = freemsghrt[16];
                    simisifreemsg18 = freemsghrt[17];
                    simisifreemsg19 = freemsghrt[18];
                    simisifreemsg20 = freemsghrt[19];
                    simisifreemsg21 = freemsghrt[20];
                    simisifreemsg22 = freemsghrt[21];
                    simisifreemsg23 = freemsghrt[22];
                    simisifreemsg24 = freemsghrt[23];
                    simisifreemsg25 = freemsghrt[24];
                    simisifreemsg26 = freemsghrt[25];
                    simisifreemsg27 = freemsghrt[26];
                    simisifreemsg28 = freemsghrt[27];
                    simisifreemsg29 = freemsghrt[28];
                    simisifreemsg30 = freemsghrt[29];
                    simisifreemsg31 = freemsghrt[30];
                    simisifreemsg32 = freemsghrt[31];
                    simisifreemsg33 = freemsghrt[32];
                    simisifreemsg34 = freemsghrt[33];
                    simisifreemsg35 = freemsghrt[34];
                    simisifreemsg36 = freemsghrt[35];
                    simisifreemsg37 = freemsghrt[36];
                    simisifreemsg38 = freemsghrt[37];
                    simisifreemsg39 = freemsghrt[38];
                    simisifreemsg40 = freemsghrt[39];
                    simisifreemsg41 = freemsghrt[40];
                    simisifreemsg42 = freemsghrt[41];
                    simisifreemsg43 = freemsghrt[42];
                    simisifreemsg44 = freemsghrt[43];
                    simisifreemsg45 = freemsghrt[44];
                    simisifreemsg46 = freemsghrt[45];
                }

                ZT_SiShrdetailTy ztSiShrdetailTy = new ZT_SiShrdetailTy();

                ztSiShrdetailTy.setZtysyoruicd(syoruiCd);
                ztSiShrdetailTy.setZtytyouhyouymd(bzBatchParam.getSyoriYmd().toString());
                ztSiShrdetailTy.setZtysyono(sk.getSyono());
                ztSiShrdetailTy.setZtyhassoukbn(sk.getHassoukbn().getValue());
                ztSiShrdetailTy.setZtysyodouhuukbn(C_UmuKbn.NONE.getValue());
                ztSiShrdetailTy.setZtysikibetuno(sk.getSkno());
                ztSiShrdetailTy.setZtysikytkmkyobi1("");
                ztSiShrdetailTy.setZtyshskyno(sk.getTsinyno());
                ztSiShrdetailTy.setZtyshskadr1kj(sk.getTsinadr1kj());
                ztSiShrdetailTy.setZtyshskadr2kj(sk.getTsinadr2kj());
                ztSiShrdetailTy.setZtyshskadr3kj(sk.getTsinadr3kj());
                ztSiShrdetailTy.setZtyshsnmkjsimisi(sk.getSeikyuusyanmkj());
                ztSiShrdetailTy.setZtysimisituutimei(simisituutimei);
                ztSiShrdetailTy.setZtysimisiosirasemongon1x1(simisiosirasemongon1x1);
                ztSiShrdetailTy.setZtysimisiosirasemongon1x2(simisiosirasemongon1x2);
                ztSiShrdetailTy.setZtysimisiosirasemongon2x1(simisiosirasemongon2x1);
                ztSiShrdetailTy.setZtysimisiosirasemongon2x2(simisiosirasemongon2x2);
                ztSiShrdetailTy.setZtysimisiosirasemongon2x3(simisiosirasemongon2x3);
                ztSiShrdetailTy.setZtysimisiosirasemongon2x4(simisiosirasemongon2x4);
                ztSiShrdetailTy.setZtysimisiosirasemongon2x5(simisiosirasemongon2x5);
                ztSiShrdetailTy.setZtytawyno(toiawasePostalCd);
                ztSiShrdetailTy.setZtytawadr1kj30(toiawaseAdr1);
                ztSiShrdetailTy.setZtytawadr2kj30(toiawaseAdr2);
                ztSiShrdetailTy.setZtytawadr3kj30(toiawaseAdr3);
                ztSiShrdetailTy.setZtytawtelno(toiawaseTelno);
                ztSiShrdetailTy.setZtysimisiatenabuyobi1("");
                ztSiShrdetailTy.setZtysimisiatenabuyobi2("");
                ztSiShrdetailTy.setZtysyono2(sk.getSyono());
                ztSiShrdetailTy.setZtykyknmkj(siKykKihon.getKyknmkj());
                ztSiShrdetailTy.setZtyhhknnmkj(siKykKihon.getHhknnmkj());
                tyouhyousakuseiymd = DateFormatUtil.dateKANJINoEx(bzBatchParam.getSyoriYmd());
                tyouhyousakuseiymd = ConvertUtil.toZenNumeric(tyouhyousakuseiymd);
                tyouhyousakuseiymd = ConvertUtil.toZenHiraKana(tyouhyousakuseiymd);
                ztSiShrdetailTy.setZtytyouhyouymdwa(tyouhyousakuseiymd);
                siharaiymd = DateFormatUtil.dateKANJINoEx(siRireki.getTyakkinymd());
                siharaiymd = ConvertUtil.toZenNumeric(siharaiymd);
                siharaiymd = ConvertUtil.toZenHiraKana(siharaiymd);
                ztSiShrdetailTy.setZtysiharaibiwareki(siharaiymd);
                ztSiShrdetailTy.setZtybanknmkj(bankNmKj);
                ztSiShrdetailTy.setZtysitennmkj(sitenNmKj);
                ztSiShrdetailTy.setZtyyokinsyumokumeikanji(yokinNmKj);
                ztSiShrdetailTy.setZtykouzano12keta(kouzano);
                ztSiShrdetailTy.setZtykzmeiginmkn(sk.getKzmeiginmkn());
                ztSiShrdetailTy.setZtykouzamaskingmsg(kouzaMaskingMsg);
                ztSiShrdetailTy.setZtysimisisummarybuyobi1("");
                ztSiShrdetailTy.setZtysimisisummarybuyobi2("");
                ztSiShrdetailTy.setZtysimisitekiyouranmidasi(midasiList.get(0).getTyouhyoumsg());
                ztSiShrdetailTy.setZtysimisimeisairanmidasi(midasiList.get(1).getTyouhyoumsg());
                ztSiShrdetailTy.setZtysimisibikouranmidasi(midasiList.get(2).getTyouhyoumsg());
                ztSiShrdetailTy.setZtysimisimeisaibumidasiyobi("");
                ztSiShrdetailTy.setZtysimisitekiyou1(tekiyou[0]);
                ztSiShrdetailTy.setZtysimisikngkmisi1(gkDetail[0].toString());
                ztSiShrdetailTy.setZtysimisikngkmisituukasyu1(gkDetailTuukasyu[0]);
                ztSiShrdetailTy.setZtysimisimeisaibikou1(detailBikou[0]);
                ztSiShrdetailTy.setZtysimisikngkmisihugou1(gkmeisaihugou[0].toString());
                ztSiShrdetailTy.setZtysimisimeisaiyobi1("");
                ztSiShrdetailTy.setZtysimisitekiyou2(tekiyou[1]);
                ztSiShrdetailTy.setZtysimisikngkmisi2(gkDetail[1].toString());
                ztSiShrdetailTy.setZtysimisikngkmisituukasyu2(gkDetailTuukasyu[1]);
                ztSiShrdetailTy.setZtysimisimeisaibikou2(detailBikou[1]);
                ztSiShrdetailTy.setZtysimisikngkmisihugou2(gkmeisaihugou[1].toString());
                ztSiShrdetailTy.setZtysimisimeisaiyobi2("");
                ztSiShrdetailTy.setZtysimisitekiyou3(tekiyou[2]);
                ztSiShrdetailTy.setZtysimisikngkmisi3(gkDetail[2].toString());
                ztSiShrdetailTy.setZtysimisikngkmisituukasyu3(gkDetailTuukasyu[2]);
                ztSiShrdetailTy.setZtysimisimeisaibikou3(detailBikou[2]);
                ztSiShrdetailTy.setZtysimisikngkmisihugou3(gkmeisaihugou[2].toString());
                ztSiShrdetailTy.setZtysimisimeisaiyobi3("");
                ztSiShrdetailTy.setZtysimisitekiyou4(tekiyou[3]);
                ztSiShrdetailTy.setZtysimisikngkmisi4(gkDetail[3].toString());
                ztSiShrdetailTy.setZtysimisikngkmisituukasyu4(gkDetailTuukasyu[3]);
                ztSiShrdetailTy.setZtysimisimeisaibikou4(detailBikou[3]);
                ztSiShrdetailTy.setZtysimisikngkmisihugou4(gkmeisaihugou[3].toString());
                ztSiShrdetailTy.setZtysimisimeisaiyobi4("");
                ztSiShrdetailTy.setZtysimisitekiyou5(tekiyou[4]);
                ztSiShrdetailTy.setZtysimisikngkmisi5(gkDetail[4].toString());
                ztSiShrdetailTy.setZtysimisikngkmisituukasyu5(gkDetailTuukasyu[4]);
                ztSiShrdetailTy.setZtysimisimeisaibikou5(detailBikou[4]);
                ztSiShrdetailTy.setZtysimisikngkmisihugou5(gkmeisaihugou[4].toString());
                ztSiShrdetailTy.setZtysimisimeisaiyobi5("");
                ztSiShrdetailTy.setZtysimisitekiyou6(tekiyou[5]);
                ztSiShrdetailTy.setZtysimisikngkmisi6(gkDetail[5].toString());
                ztSiShrdetailTy.setZtysimisikngkmisituukasyu6(gkDetailTuukasyu[5]);
                ztSiShrdetailTy.setZtysimisimeisaibikou6(detailBikou[5]);
                ztSiShrdetailTy.setZtysimisikngkmisihugou6(gkmeisaihugou[5].toString());
                ztSiShrdetailTy.setZtysimisimeisaiyobi6("");
                ztSiShrdetailTy.setZtysimisitekiyou7(tekiyou[6]);
                ztSiShrdetailTy.setZtysimisikngkmisi7(gkDetail[6].toString());
                ztSiShrdetailTy.setZtysimisikngkmisituukasyu7(gkDetailTuukasyu[6]);
                ztSiShrdetailTy.setZtysimisimeisaibikou7(detailBikou[6]);
                ztSiShrdetailTy.setZtysimisikngkmisihugou7(gkmeisaihugou[6].toString());
                ztSiShrdetailTy.setZtysimisimeisaiyobi7("");
                ztSiShrdetailTy.setZtysimisitekiyou8(tekiyou[7]);
                ztSiShrdetailTy.setZtysimisikngkmisi8(gkDetail[7].toString());
                ztSiShrdetailTy.setZtysimisikngkmisituukasyu8(gkDetailTuukasyu[7]);
                ztSiShrdetailTy.setZtysimisimeisaibikou8(detailBikou[7]);
                ztSiShrdetailTy.setZtysimisikngkmisihugou8(gkmeisaihugou[7].toString());
                ztSiShrdetailTy.setZtysimisimeisaiyobi8("");
                ztSiShrdetailTy.setZtysimisitekiyou9(tekiyou[8]);
                ztSiShrdetailTy.setZtysimisikngkmisi9(gkDetail[8].toString());
                ztSiShrdetailTy.setZtysimisikngkmisituukasyu9(gkDetailTuukasyu[8]);
                ztSiShrdetailTy.setZtysimisimeisaibikou9(detailBikou[8]);
                ztSiShrdetailTy.setZtysimisikngkmisihugou9(gkmeisaihugou[8].toString());
                ztSiShrdetailTy.setZtysimisimeisaiyobi9("");
                ztSiShrdetailTy.setZtysimisitekiyou10(tekiyou[9]);
                ztSiShrdetailTy.setZtysimisikngkmisi10(gkDetail[9].toString());
                ztSiShrdetailTy.setZtysimisikngkmisituukasyu10(gkDetailTuukasyu[9]);
                ztSiShrdetailTy.setZtysimisimeisaibikou10(detailBikou[9]);
                ztSiShrdetailTy.setZtysimisikngkmisihugou10(gkmeisaihugou[9].toString());
                ztSiShrdetailTy.setZtysimisimeisaiyobi10("");
                ztSiShrdetailTy.setZtysimisitekiyou11(tekiyou[10]);
                ztSiShrdetailTy.setZtysimisikngkmisi11(gkDetail[10].toString());
                ztSiShrdetailTy.setZtysimisikngkmisituukasyu11(gkDetailTuukasyu[10]);
                ztSiShrdetailTy.setZtysimisimeisaibikou11(detailBikou[10]);
                ztSiShrdetailTy.setZtysimisikngkmisihugou11(gkmeisaihugou[10].toString());
                ztSiShrdetailTy.setZtysimisimeisaiyobi11("");
                ztSiShrdetailTy.setZtysimisitekiyou12(tekiyou[11]);
                ztSiShrdetailTy.setZtysimisikngkmisi12(gkDetail[11].toString());
                ztSiShrdetailTy.setZtysimisikngkmisituukasyu12(gkDetailTuukasyu[11]);
                ztSiShrdetailTy.setZtysimisimeisaibikou12(detailBikou[11]);
                ztSiShrdetailTy.setZtysimisikngkmisihugou12(gkmeisaihugou[11].toString());
                ztSiShrdetailTy.setZtysimisimeisaiyobi12("");
                ztSiShrdetailTy.setZtysimisitekiyou13(tekiyou[12]);
                ztSiShrdetailTy.setZtysimisikngkmisi13(gkDetail[12].toString());
                ztSiShrdetailTy.setZtysimisikngkmisituukasyu13(gkDetailTuukasyu[12]);
                ztSiShrdetailTy.setZtysimisimeisaibikou13(detailBikou[12]);
                ztSiShrdetailTy.setZtysimisikngkmisihugou13(gkmeisaihugou[12].toString());
                ztSiShrdetailTy.setZtysimisimeisaiyobi13("");
                ztSiShrdetailTy.setZtysimisitekiyou14(tekiyou[13]);
                ztSiShrdetailTy.setZtysimisikngkmisi14(gkDetail[13].toString());
                ztSiShrdetailTy.setZtysimisikngkmisituukasyu14(gkDetailTuukasyu[13]);
                ztSiShrdetailTy.setZtysimisimeisaibikou14(detailBikou[13]);
                ztSiShrdetailTy.setZtysimisikngkmisihugou14(gkmeisaihugou[13].toString());
                ztSiShrdetailTy.setZtysimisimeisaiyobi14("");
                ztSiShrdetailTy.setZtysimisitekiyou15(tekiyou[14]);
                ztSiShrdetailTy.setZtysimisikngkmisi15(gkDetail[14].toString());
                ztSiShrdetailTy.setZtysimisikngkmisituukasyu15(gkDetailTuukasyu[14]);
                ztSiShrdetailTy.setZtysimisimeisaibikou15(detailBikou[14]);
                ztSiShrdetailTy.setZtysimisikngkmisihugou15(gkmeisaihugou[14].toString());
                ztSiShrdetailTy.setZtysimisimeisaiyobi15("");
                ztSiShrdetailTy.setZtysimisitekiyou16(tekiyou[15]);
                ztSiShrdetailTy.setZtysimisikngkmisi16(gkDetail[15].toString());
                ztSiShrdetailTy.setZtysimisikngkmisituukasyu16(gkDetailTuukasyu[15]);
                ztSiShrdetailTy.setZtysimisimeisaibikou16(detailBikou[15]);
                ztSiShrdetailTy.setZtysimisikngkmisihugou16(gkmeisaihugou[15].toString());
                ztSiShrdetailTy.setZtysimisimeisaiyobi16("");
                ztSiShrdetailTy.setZtysimisitekiyou17(tekiyou[16]);
                ztSiShrdetailTy.setZtysimisikngkmisi17(gkDetail[16].toString());
                ztSiShrdetailTy.setZtysimisikngkmisituukasyu17(gkDetailTuukasyu[16]);
                ztSiShrdetailTy.setZtysimisimeisaibikou17(detailBikou[16]);
                ztSiShrdetailTy.setZtysimisikngkmisihugou17(gkmeisaihugou[16].toString());
                ztSiShrdetailTy.setZtysimisimeisaiyobi17("");
                ztSiShrdetailTy.setZtysimisitekiyou18(tekiyou[17]);
                ztSiShrdetailTy.setZtysimisikngkmisi18(gkDetail[17].toString());
                ztSiShrdetailTy.setZtysimisikngkmisituukasyu18(gkDetailTuukasyu[17]);
                ztSiShrdetailTy.setZtysimisimeisaibikou18(detailBikou[17]);
                ztSiShrdetailTy.setZtysimisikngkmisihugou18(gkmeisaihugou[17].toString());
                ztSiShrdetailTy.setZtysimisimeisaiyobi18("");
                ztSiShrdetailTy.setZtysimisitekiyou19(tekiyou[18]);
                ztSiShrdetailTy.setZtysimisikngkmisi19(gkDetail[18].toString());
                ztSiShrdetailTy.setZtysimisikngkmisituukasyu19(gkDetailTuukasyu[18]);
                ztSiShrdetailTy.setZtysimisimeisaibikou19(detailBikou[18]);
                ztSiShrdetailTy.setZtysimisikngkmisihugou19(gkmeisaihugou[18].toString());
                ztSiShrdetailTy.setZtysimisimeisaiyobi19("");
                ztSiShrdetailTy.setZtysimisitekiyou20(tekiyou[19]);
                ztSiShrdetailTy.setZtysimisikngkmisi20(gkDetail[19].toString());
                ztSiShrdetailTy.setZtysimisikngkmisituukasyu20(gkDetailTuukasyu[19]);
                ztSiShrdetailTy.setZtysimisimeisaibikou20(detailBikou[19]);
                ztSiShrdetailTy.setZtysimisikngkmisihugou20(gkmeisaihugou[19].toString());
                ztSiShrdetailTy.setZtysimisimeisaiyobi20("");
                ztSiShrdetailTy.setZtysimisitekiyou21(tekiyou[20]);
                ztSiShrdetailTy.setZtysimisikngkmisi21(gkDetail[20].toString());
                ztSiShrdetailTy.setZtysimisikngkmisituukasyu21(gkDetailTuukasyu[20]);
                ztSiShrdetailTy.setZtysimisimeisaibikou21(detailBikou[20]);
                ztSiShrdetailTy.setZtysimisikngkmisihugou21(gkmeisaihugou[20].toString());
                ztSiShrdetailTy.setZtysimisimeisaiyobi21("");
                ztSiShrdetailTy.setZtysimisitekiyou22(tekiyou[21]);
                ztSiShrdetailTy.setZtysimisikngkmisi22(gkDetail[21].toString());
                ztSiShrdetailTy.setZtysimisikngkmisituukasyu22(gkDetailTuukasyu[21]);
                ztSiShrdetailTy.setZtysimisimeisaibikou22(detailBikou[21]);
                ztSiShrdetailTy.setZtysimisikngkmisihugou22(gkmeisaihugou[21].toString());
                ztSiShrdetailTy.setZtysimisimeisaiyobi22("");
                ztSiShrdetailTy.setZtysimisitekiyou23(tekiyou[22]);
                ztSiShrdetailTy.setZtysimisikngkmisi23(gkDetail[22].toString());
                ztSiShrdetailTy.setZtysimisikngkmisituukasyu23(gkDetailTuukasyu[22]);
                ztSiShrdetailTy.setZtysimisimeisaibikou23(detailBikou[22]);
                ztSiShrdetailTy.setZtysimisikngkmisihugou23(gkmeisaihugou[22].toString());
                ztSiShrdetailTy.setZtysimisimeisaiyobi23("");
                ztSiShrdetailTy.setZtysimisitekiyou24(tekiyou[23]);
                ztSiShrdetailTy.setZtysimisikngkmisi24(gkDetail[23].toString());
                ztSiShrdetailTy.setZtysimisikngkmisituukasyu24(gkDetailTuukasyu[23]);
                ztSiShrdetailTy.setZtysimisimeisaibikou24(detailBikou[23]);
                ztSiShrdetailTy.setZtysimisikngkmisihugou24(gkmeisaihugou[23].toString());
                ztSiShrdetailTy.setZtysimisimeisaiyobi24("");
                ztSiShrdetailTy.setZtysimisitekiyou25(tekiyou[24]);
                ztSiShrdetailTy.setZtysimisikngkmisi25(gkDetail[24].toString());
                ztSiShrdetailTy.setZtysimisikngkmisituukasyu25(gkDetailTuukasyu[24]);
                ztSiShrdetailTy.setZtysimisimeisaibikou25(detailBikou[24]);
                ztSiShrdetailTy.setZtysimisikngkmisihugou25(gkmeisaihugou[24].toString());
                ztSiShrdetailTy.setZtysimisimeisaiyobi25("");
                ztSiShrdetailTy.setZtysimisimeisaibuyobi1x1("");
                ztSiShrdetailTy.setZtysimisimeisaibuyobi1x2("");
                ztSiShrdetailTy.setZtysimisimeisaibuyobi1x3("");
                ztSiShrdetailTy.setZtysimisimeisaibuyobi1x4("");
                ztSiShrdetailTy.setZtysimisimeisaibuyobi1x5("");
                ztSiShrdetailTy.setZtysimisimeisaibuyobi1x6("");
                ztSiShrdetailTy.setZtysimisisigoukeikingaku(shrGoukeiGk.toString());
                ztSiShrdetailTy.setZtysimisisigoukeituukasyu(shrGoukeiTuukasyu);
                ztSiShrdetailTy.setZtysimisimeisaibuyobi2("");
                ztSiShrdetailTy.setZtysimisituutiranmidasi(midasiList.get(3).getTyouhyoumsg());
                ztSiShrdetailTy.setZtysimisifreemsg1(simisifreemsg1);
                ztSiShrdetailTy.setZtysimisifreemsg2(simisifreemsg2);
                ztSiShrdetailTy.setZtysimisifreemsg3(simisifreemsg3);
                ztSiShrdetailTy.setZtysimisifreemsg4(simisifreemsg4);
                ztSiShrdetailTy.setZtysimisifreemsg5(simisifreemsg5);
                ztSiShrdetailTy.setZtysimisifreemsg6(simisifreemsg6);
                ztSiShrdetailTy.setZtysimisifreemsg7(simisifreemsg7);
                ztSiShrdetailTy.setZtysimisifreemsg8(simisifreemsg8);
                ztSiShrdetailTy.setZtysimisifreemsg9(simisifreemsg9);
                ztSiShrdetailTy.setZtysimisifreemsg10(simisifreemsg10);
                ztSiShrdetailTy.setZtysimisifreemsg11(simisifreemsg11);
                ztSiShrdetailTy.setZtysimisifreemsg12(simisifreemsg12);
                ztSiShrdetailTy.setZtysimisifreemsg13(simisifreemsg13);
                ztSiShrdetailTy.setZtysimisifreemsg14(simisifreemsg14);
                ztSiShrdetailTy.setZtysimisifreemsg15(simisifreemsg15);
                ztSiShrdetailTy.setZtysimisifreemsg16(simisifreemsg16);
                ztSiShrdetailTy.setZtysimisifreemsg17(simisifreemsg17);
                ztSiShrdetailTy.setZtysimisifreemsg18(simisifreemsg18);
                ztSiShrdetailTy.setZtysimisifreemsg19(simisifreemsg19);
                ztSiShrdetailTy.setZtysimisifreemsg20(simisifreemsg20);
                ztSiShrdetailTy.setZtysimisifreemsg21(simisifreemsg21);
                ztSiShrdetailTy.setZtysimisifreemsg22(simisifreemsg22);
                ztSiShrdetailTy.setZtysimisifreemsg23(simisifreemsg23);
                ztSiShrdetailTy.setZtysimisifreemsg24(simisifreemsg24);
                ztSiShrdetailTy.setZtysimisifreemsg25(simisifreemsg25);
                ztSiShrdetailTy.setZtysimisifreemsg26(simisifreemsg26);
                ztSiShrdetailTy.setZtysimisifreemsg27(simisifreemsg27);
                ztSiShrdetailTy.setZtysimisifreemsg28(simisifreemsg28);
                ztSiShrdetailTy.setZtysimisifreemsg29(simisifreemsg29);
                ztSiShrdetailTy.setZtysimisifreemsg30(simisifreemsg30);
                ztSiShrdetailTy.setZtysimisifreemsg31(simisifreemsg31);
                ztSiShrdetailTy.setZtysimisifreemsg32(simisifreemsg32);
                ztSiShrdetailTy.setZtysimisifreemsg33(simisifreemsg33);
                ztSiShrdetailTy.setZtysimisifreemsg34(simisifreemsg34);
                ztSiShrdetailTy.setZtysimisifreemsg35(simisifreemsg35);
                ztSiShrdetailTy.setZtysimisifreemsg36(simisifreemsg36);
                ztSiShrdetailTy.setZtysimisifreemsg37(simisifreemsg37);
                ztSiShrdetailTy.setZtysimisifreemsg38(simisifreemsg38);
                ztSiShrdetailTy.setZtysimisifreemsg39(simisifreemsg39);
                ztSiShrdetailTy.setZtysimisifreemsg40(simisifreemsg40);
                ztSiShrdetailTy.setZtysimisifreemsg41(simisifreemsg41);
                ztSiShrdetailTy.setZtysimisifreemsg42(simisifreemsg42);
                ztSiShrdetailTy.setZtysimisifreemsg43(simisifreemsg43);
                ztSiShrdetailTy.setZtysimisifreemsg44(simisifreemsg44);
                ztSiShrdetailTy.setZtysimisifreemsg45(simisifreemsg45);
                ztSiShrdetailTy.setZtysimisifreemsg46(simisifreemsg46);
                ztSiShrdetailTy.setZtysimisiosirasemongon3x1(simisiosirasemongon3x1);
                ztSiShrdetailTy.setZtysimisiosirasemongon3x2(simisiosirasemongon3x2);
                ztSiShrdetailTy.setZtysimisisynykngk(shrmisisynykngk);
                ztSiShrdetailTy.setZtysimisihtykeihi(shrmisihtykeihi);
                ztSiShrdetailTy.setZtykztkgk(shrmisikztkgk);
                ztSiShrdetailTy.setZtyzeitratkikbn(siRireki.getZeitratkikbn().getValue());
                ztSiShrdetailTy.setZtykykhenkouumukbn(kykHnkUm.getValue());
                ztSiShrdetailTy.setZtyshrkykhtykeihi(sk.getShrkykhtykeihi().toAdsoluteString());
                ztSiShrdetailTy.setZtysimisimeisaibuyobi3x1("");
                ztSiShrdetailTy.setZtysimisimeisaibuyobi3x2("");

                BizPropertyInitializer.initialize(ztSiShrdetailTy);

                siShrdetailTyLst.add(ztSiShrdetailTy);

                shrdtlsyoKensuu = shrdtlsyoKensuu + 1;

                String tetudukirirekiSikibetukey = SaibanBiz.getTetudukirirekiSikibetukey(skKihon.getSyono());

                JT_TtdkRireki jtTtdkRireki = new JT_TtdkRireki();

                jtTtdkRireki.setSkno(skKihon.getSkno());
                jtTtdkRireki.setSyono(skKihon.getSyono());
                jtTtdkRireki.setTtdkrrkskbtkey(tetudukirirekiSikibetukey);
                jtTtdkRireki.setSyoriYmd(bzBatchParam.getSyoriYmd());
                jtTtdkRireki.setSyorisosikicd("");
                jtTtdkRireki.setJimukakuteiumukbn(C_JimukakuteiKbn.KAKUTEI);
                jtTtdkRireki.setSeikyuurirekino(sk.getSeikyuurirekino());
                jtTtdkRireki.setShrsikibetukey("");
                jtTtdkRireki.setSateisyouninskbtkey("");
                jtTtdkRireki.setSyanaicomment("");
                jtTtdkRireki.setKossyoricd(kinou.getKinouId());
                jtTtdkRireki.setKossyorisscd(Iterables.getFirst(kinou.getKinouModes(), null).getKinouModeId());
                jtTtdkRireki.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                jtTtdkRireki.setGyoumuKousinTime(sysDateTimeMilli);

                BizPropertyInitializer.initialize(jtTtdkRireki);

                ttdkRirekiLst.add(jtTtdkRireki);

            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage(MessageId.IAC0020, String.valueOf(shrdtlsyoKensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

}
