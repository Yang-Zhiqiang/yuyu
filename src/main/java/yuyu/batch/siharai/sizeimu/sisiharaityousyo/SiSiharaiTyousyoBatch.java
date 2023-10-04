package yuyu.batch.siharai.sizeimu.sisiharaityousyo;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuPrm;
import yuyu.common.siharai.sicommon.CalcSiTyousyo;
import yuyu.common.siharai.sicommon.CalcSiTyousyoBean;
import yuyu.common.siharai.sicommon.SetteiShrhousiteiKbn;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hkuktsyu;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_MousideninKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_ShrtysyhknsyuKbn;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UketorininSibouUmuKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KykSyaHenkouRireki;
import yuyu.def.db.entity.JT_Mouside;
import yuyu.def.db.entity.JT_SiDetail;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.entity.JT_SiTyousyo;
import yuyu.def.db.entity.JT_SiUkt;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkJiyuu;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.JT_TtdkRireki;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.sorter.SortIT_KykSyaHenkouRireki;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.siharai.sorter.SortJT_SiRireki;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 保険金給付金支払 税務 保険金給付金支払調書作成<br />
 */
public class SiSiharaiTyousyoBatch implements Batch {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoverDataBean;

    private JT_SiKykKihon siKykKihon;

    private JT_SiKykSyouhn siKykSyouhn;

    private BizDate syoriYMD = null;

    private int nyuuryokuKensuu = 0;

    private long shrTysyRenno = 0;

    private String sysTime = "";

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));

        syoriYMD = bzBatchParam.getSyoriYmd();

        sysTime = BizDate.getSysDateTimeMilli();

        editSiUketorinin();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(nyuuryokuKensuu), kinou.getKinouNm()));

    }

    private void editSiUketorinin() {

        try (ExDBResults<JT_SkKihon> rst =
            siharaiDomManager.getSkKihonsByKakutyoujobcdSeikyuusyubetuNe(bzBatchParam.getIbKakutyoujobcd(),
                syoriYMD, C_ShrKekkaKbn.SHR, C_SeikyuuSyubetu.SDSSHR);) {

            shrTysyRenno = 0;
            nyuuryokuKensuu = 0;
            String tysytTaisyouTableId = "JT_SkKihon";
            String recoveryFilterId = "Si001";

            for (JT_SkKihon skKihon : rst) {

                String syoNo = skKihon.getSyono();

                bzRecoverDataBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoverDataBean.setIbTableid(tysytTaisyouTableId);
                bzRecoverDataBean.setIbRecoveryfilterid(recoveryFilterId);
                bzRecoverDataBean.setIbRecoveryfilterkey1(skKihon.getSyono());
                bzRecoverDataBean.setIbRecoveryfilterkey2(skKihon.getSkno());

                getData(syoNo);

                Integer sdSeikyuuRirekiNo   = siharaiDomManager.getSkMaxSeikyuurirekinoBySknoSyono(skKihon.getSkno(),
                    syoNo);

                JT_Sk sk = skKihon.getSkBySeikyuurirekino(sdSeikyuuRirekiNo);

                JT_Mouside mouside = skKihon.getMouside();

                SortJT_SiRireki sort = new SortJT_SiRireki();
                List<JT_SiRireki> siRirekiLst = sort.OrderJT_SiRirekiByPkDesc(skKihon.getSiRirekis());

                JT_SiRireki siRireki = siRirekiLst.get(0);

                List<JT_SkJiyuu> skJiyuuLst = sk.getSkJiyuus();

                JT_SkJiyuu skJiyuu = skJiyuuLst.get(0);

                List<JT_TtdkRireki> ttdkRirekiLst = skKihon.getTtdkRirekisByShrsikibetukey(siRireki.getShrsikibetukey());

                JT_TtdkRireki ttdkRireki = ttdkRirekiLst.get(0);

                List<JT_SiDetail> siDetaillst = skJiyuu.getSiDetails();

                C_UmuKbn outUmuKbn = editJTSiTyousyo(skKihon, sk, mouside, siRireki, ttdkRireki, skJiyuu, siDetaillst);

                if (C_UmuKbn.ARI.eq(outUmuKbn)) {

                    nyuuryokuKensuu++;
                }
                else {

                    continue;
                }
            }

            bzRecoverDataBean.initializeBlank();
        }
    }

    private void getData(String pSyoNo) {

        KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);
        KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);

        keiyakuPrm.setSyono(pSyoNo);

        keiyakuInfoSyutoku.getInfos(keiyakuPrm);

        List<JT_SiKykKihon> siKykKihonLst = keiyakuInfoSyutoku.getKykKihons();

        if (siKykKihonLst.get(0) == null) {

            throw new BizAppException(MessageId.EBS0004, JT_SiKykKihon.TABLE_NAME, JT_SiKykKihon.SYONO, pSyoNo);
        }
        siKykKihon = siKykKihonLst.get(0);

        List<JT_SiKykSyouhn> siKykSyouhnLst = new ArrayList<>();

        siKykSyouhnLst = siKykKihon.getSiKykSyouhns();

        for (JT_SiKykSyouhn siKykSyhn : siKykSyouhnLst) {
            if (C_SyutkKbn.SYU.eq(siKykSyhn.getSyutkkbn())) {
                siKykSyouhn = siKykSyhn;

                break;
            }
        }
    }

    private C_UmuKbn editJTSiTyousyo(JT_SkKihon pSkKihon, JT_Sk pSk, JT_Mouside pMouside, JT_SiRireki pSiRireki,
        JT_TtdkRireki pTtdkRireki, JT_SkJiyuu pSkJiyuu, List<JT_SiDetail> pSiDetailLst) {

        C_UmuKbn outUmuKbn = C_UmuKbn.NONE;

        int hhknNen = siKykSyouhn.getHhknnen();
        if (hhknNen > SiSiharaiTyousyoBatchConstants.NENJOUGEN) {
            hhknNen = SiSiharaiTyousyoBatchConstants.NENJOUGEN;
        }

        SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);
        int kyksyaNen = 0;

        int nenrei = setNenrei.exec(siKykSyouhn.getKykymd(), siKykKihon.getKykseiymd());

        if (nenrei != 0) {
            kyksyaNen = nenrei;

            if (kyksyaNen > SiSiharaiTyousyoBatchConstants.NENJOUGEN) {
                kyksyaNen = SiSiharaiTyousyoBatchConstants.NENJOUGEN;
            }
        }

        BizCurrency haraiKomiP;
        if (C_Tuukasyu.JPY.eq(pSk.getKyktuukasyu())) {
            haraiKomiP = pSk.getGoukeihituyoukeihi();
        } else {
            haraiKomiP = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        }

        CalcSiTyousyo calcSiTyousyo = SWAKInjector.getInstance(CalcSiTyousyo.class);
        C_ErrorKbn result = calcSiTyousyo.exec(pSk, siKykSyouhn.getSyouhncd());
        if (C_ErrorKbn.ERROR.eq(result)) {
            throw new BizAppException(MessageId.EBA0012, JT_Sk.TABLE_NAME);
        }
        CalcSiTyousyoBean calcSiTyousyoBean = calcSiTyousyo.getCalcSiTyousyoBean();

        if (C_UmuKbn.NONE.eq(calcSiTyousyoBean.getOutUm())) {
            return outUmuKbn;
        }

        String syoriTaisyouKbn = "";
        for (JT_SiDetail siDetail : pSiDetailLst) {
            if (C_HokenkinsyuruiKbn.SAIGAIHOKENKIN.eq(siDetail.getHokenkinsyuruikbn()) &&
                siDetail.getKyhkg().compareTo(BizCurrency.valueOf(0, siDetail.getKyhkg().getType())) > 0) {
                syoriTaisyouKbn = SiSiharaiTyousyoBatchConstants.SYORITAISYOUKBN_SAIGAI;
            }
            else {
                syoriTaisyouKbn = SiSiharaiTyousyoBatchConstants.SYORITAISYOUKBN_SIBOU;
            }
        }

        String shrtysytsinyno;
        String shrtysyadr1kj;
        String shrtysyadr2kj;
        String shrtysyadr3kj;
        if (C_SeikyuusyaKbn.KYKDAIRININ.eq(pSk.getSeikyuusyakbn())) {
            shrtysytsinyno = siKykKihon.getTsinyno();
            shrtysyadr1kj = siKykKihon.getTsinadr1kj();
            shrtysyadr2kj = siKykKihon.getTsinadr2kj();
            shrtysyadr3kj = siKykKihon.getTsinadr3kj();
        } else {
            shrtysytsinyno = pSk.getTsinyno();
            shrtysyadr1kj = pSk.getTsinadr1kj();
            shrtysyadr2kj = pSk.getTsinadr2kj();
            shrtysyadr3kj = pSk.getTsinadr3kj();
        }

        String kjUktNm = "";
        if (siKykKihon.getSbuktnin() > 1) {
            kjUktNm = ConvertUtil.toZenNumeric(siKykKihon.getSbuktnin().toString()).concat(
                SiSiharaiTyousyoBatchConstants.KJUKTNM_NINSUU);
        }
        else {
            if(pMouside != null){
                if (C_MousideninKbn.SOUZOKUNIN.eq(pMouside.getMousideninkbn()) ||
                    C_UketorininSibouUmuKbn.UKTSBARI.eq(pMouside.getUketorininsibouumukbn())) {
                    kjUktNm = SiSiharaiTyousyoBatchConstants.KJUKTNM_SOUZOKUNIN;
                }
                else if (C_SeikyuusyaKbn.KYKDAIRININ.eq(pSk.getSeikyuusyakbn())) {
                    kjUktNm = siKykKihon.getKyknmkj();
                }
                else {
                    kjUktNm = pSk.getSeikyuusyanmkj();
                }
            }
            else {
                if (C_SeikyuusyaKbn.KYKDAIRININ.eq(pSk.getSeikyuusyakbn())) {
                    kjUktNm = siKykKihon.getKyknmkj();
                } else {
                    kjUktNm = pSk.getSeikyuusyanmkj();
                }
            }
        }

        String kjDaihyouUktNm = "";
        if (C_SeikyuusyaKbn.UKTDAIHYOU.eq(pSk.getSeikyuusyakbn())) {
            kjDaihyouUktNm = pSk.getSeikyuusyanmkj();
        }

        BizCurrency shrTienRsk = BizCurrency.valueOf(0,  BizCurrencyTypes.YEN);

        BizCurrency kihonS = BizCurrency.valueOf(0,  BizCurrencyTypes.YEN);

        String tysySyuruiKbn = "";
        if (siKykKihon.getSbuktnin() > 1) {
            tysySyuruiKbn = SiSiharaiTyousyoBatchConstants.TYSYSYURUIKBN_UKT;
        }
        else {
            tysySyuruiKbn = SiSiharaiTyousyoBatchConstants.TYSYSYURUIKBN_SONOTA;
        }

        SetteiShrhousiteiKbn setteiShrhousiteiKbn = SWAKInjector.getInstance(SetteiShrhousiteiKbn.class);
        C_ShrhousiteiKbn shrhousiteiKbn = setteiShrhousiteiKbn.exec(pSk.getInputshrhousiteikbn(), pSk.getShrtuukasyu());

        BizCurrency syuseiJtshrD = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        String mnSaiannaiHnskaKbn = "";
        if ((C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(siKykKihon.getTtdktyuuikbn1()) ||
            C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(siKykKihon.getTtdktyuuikbn1()) ||
            C_TtdktyuuiKbn.SYOUMETUGOOUTAITYUUI.eq(siKykKihon.getTtdktyuuikbn1())) ||
            (C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(siKykKihon.getTtdktyuuikbn2()) ||
                C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(siKykKihon.getTtdktyuuikbn2()) ||
                C_TtdktyuuiKbn.SYOUMETUGOOUTAITYUUI.eq(siKykKihon.getTtdktyuuikbn2())) ||
                (C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(siKykKihon.getTtdktyuuikbn3()) ||
                    C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(siKykKihon.getTtdktyuuikbn3()) ||
                    C_TtdktyuuiKbn.SYOUMETUGOOUTAITYUUI.eq(siKykKihon.getTtdktyuuikbn3())) ||
                    (C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(siKykKihon.getTtdktyuuikbn4()) ||
                        C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(siKykKihon.getTtdktyuuikbn4()) ||
                        C_TtdktyuuiKbn.SYOUMETUGOOUTAITYUUI.eq(siKykKihon.getTtdktyuuikbn4())) ||
                        (C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(siKykKihon.getTtdktyuuikbn5()) ||
                            C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(siKykKihon.getTtdktyuuikbn5()) ||
                            C_TtdktyuuiKbn.SYOUMETUGOOUTAITYUUI.eq(siKykKihon.getTtdktyuuikbn5()))) {

            mnSaiannaiHnskaKbn = SiSiharaiTyousyoBatchConstants.TTDKTYUUI_HNSKA;
        }

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(siKykSyouhn.getSyouhncd(),
            siKykSyouhn.getSyouhnsdno());
        C_ShrtysyhknsyuKbn shrTysyHknSyuKbn = syouhnZokusei.getShrtysyhknsyukbn();

        String shrtysykurikosidisp;
        if (C_NaiteiKakuteiKbn.NAITEI.eq(pSk.getVhtnaiteikakuteikbn())) {
            shrtysykurikosidisp = SiSiharaiTyousyoBatchConstants.SHRTYSYKURIKOSIDISP_KURIKOSI;
        }
        else {
            shrtysykurikosidisp = SiSiharaiTyousyoBatchConstants.SHRTYSYKURIKOSIDISP_SAKUSEI;
        }

        String tblSakuseiHunoDisp = chkTapeSakuseiHunouHyouji(pSk.getInputshrhousiteikbn(), pMouside);

        String daihyouktKbn = SiSiharaiTyousyoBatchConstants.MISETTEI;
        if (C_SeikyuusyaKbn.UKTDAIHYOU.eq(pSk.getSeikyuusyakbn())) {
            if (pMouside != null){
                if (C_MousideninKbn.SOUZOKUNIN.eq(pMouside.getMousideninkbn()) ||
                    C_UketorininSibouUmuKbn.UKTSBARI.eq(pMouside.getUketorininsibouumukbn())) {
                    daihyouktKbn = SiSiharaiTyousyoBatchConstants.DAIHYOUKTKBN_UKT_EQ_SZK;
                }
                else {
                    daihyouktKbn = SiSiharaiTyousyoBatchConstants.DAIHYOUKTKBN_UKT_UNEQ_SZK;
                }
            }
            else {
                daihyouktKbn = SiSiharaiTyousyoBatchConstants.DAIHYOUKTKBN_UKT_UNEQ_SZK;
            }
        }

        String uktmnmeigibangou = SiSiharaiTyousyoBatchConstants.DEF_UKTMNMEIGIBANGOU;
        if (BizUtil.isBlank(pSk.getUktmnmeigibangou())) {
            uktmnmeigibangou = SiSiharaiTyousyoBatchConstants.DEF_UKTMNMEIGIBANGOU;
        }
        else {
            uktmnmeigibangou = pSk.getUktmnmeigibangou();
        }

        String kykmnmeigibangou = SiSiharaiTyousyoBatchConstants.DEF_KYKMNMEIGIBANGOU;
        if (BizUtil.isBlank(pSk.getKykmnmeigibangou())) {
            boolean keiukedouFlg = false;
            if (C_SeikyuusyaKbn.UKTHONNIN.eq(pSk.getSeikyuusyakbn())
                || C_SeikyuusyaKbn.KYKDAIRININ.eq(pSk.getSeikyuusyakbn())) {
                if (siKykKihon.getSbuktnin() == 1) {
                    for (JT_SiUkt tempSiUkt : siKykKihon.getSiUkts()) {
                        if ((C_Hkuktsyu.SBHKKUKT.eq(tempSiUkt.getHkuktsyu())
                            || C_Hkuktsyu.SBKYFKUKT.eq(tempSiUkt.getHkuktsyu()))
                            && C_UktKbn.KYK.eq(tempSiUkt.getUktkbn())) {
                            keiukedouFlg = true;
                            break;
                        }
                    }
                }
            }

            if(keiukedouFlg) {
                kykmnmeigibangou = uktmnmeigibangou;
            }
            else {
                kykmnmeigibangou = SiSiharaiTyousyoBatchConstants.DEF_KYKMNMEIGIBANGOU;
            }
        }
        else {
            kykmnmeigibangou = pSk.getKykmnmeigibangou();
        }

        String shrkykhtykeihiyouhyj = SiSiharaiTyousyoBatchConstants.SHRKYKHTYKEIHIYOUHYJ_NASI;
        if (pSk.getKykhnkkaisuu() > 0) {
            shrkykhtykeihiyouhyj = SiSiharaiTyousyoBatchConstants.SHRKYKHTYKEIHIYOUHYJ_ARI;
        }

        String oldtsinyno = "";
        String oldtsinadr1kj = "";
        String oldtsinadr2kj = "";
        String oldtsinadr3kj = "";
        String oldkyknmkj = "";

        if (SiSiharaiTyousyoBatchConstants.SHRKYKHTYKEIHIYOUHYJ_ARI.equals(shrkykhtykeihiyouhyj)){
            List<IT_KykSyaHenkouRireki> kykSyaHenkouRirekiLst = hozenDomManager.getKykSyaHenkouRirekisBySyonoMeigihnkjiyuu
                (pSkKihon.getSyono(), C_Meigihnkjiyuu.KYK);

            if (kykSyaHenkouRirekiLst.size() == 0) {
                throw new BizAppException(MessageId.EBS0005, IT_KykSyaHenkouRireki.TABLE_NAME, IT_KykSyaHenkouRireki.SYONO, pSkKihon.getSyono(),
                    IT_KykSyaHenkouRireki.MEIGIHNKJIYUU, C_Meigihnkjiyuu.KYK.getValue());
            }

            SortIT_KykSyaHenkouRireki sortKykSyaHenkouRireki = SWAKInjector.getInstance(SortIT_KykSyaHenkouRireki.class);
            kykSyaHenkouRirekiLst = sortKykSyaHenkouRireki.OrderIT_KykSyaHenkouRirekiByHenkouSikibetuKeyDesc(kykSyaHenkouRirekiLst);
            IT_KykSyaHenkouRireki kykSyaHenkouRireki = kykSyaHenkouRirekiLst.get(0);

            oldtsinyno = kykSyaHenkouRireki.getOldtsinyno();
            oldtsinadr1kj = kykSyaHenkouRireki.getOldtsinadr1kj();
            oldtsinadr2kj = kykSyaHenkouRireki.getOldtsinadr2kj();
            oldtsinadr3kj = kykSyaHenkouRireki.getOldtsinadr3kj();
            oldkyknmkj = kykSyaHenkouRireki.getOldkyknmkj();
        }

        Integer kykhnkkaisuu = 0;
        BizCurrency shrkykhtykeihi = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        if (SiSiharaiTyousyoBatchConstants.SHRKYKHTYKEIHIYOUHYJ_ARI.equals(shrkykhtykeihiyouhyj)){
            kykhnkkaisuu = pSk.getKykhnkkaisuu();
            shrkykhtykeihi = pSk.getShrkykhtykeihi();
        }

        JT_SiTyousyo siTyousyo = new JT_SiTyousyo();

        shrTysyRenno++;

        siTyousyo.setSyono(pSkKihon.getSyono());
        siTyousyo.setTyouhyouymd(syoriYMD);
        siTyousyo.setShrtysyrenno(shrTysyRenno);
        siTyousyo.setKacd(SiSiharaiTyousyoBatchConstants.TANTOUSITUCD_SHRGYOUMUSITU);
        siTyousyo.setTantocd(SiSiharaiTyousyoBatchConstants.TANTOUCDKBN_SIBOUTETUZUKI);
        siTyousyo.setHknsyukigou(siKykSyouhn.getSyouhncd().substring(0, 2));
        siTyousyo.setHknkkn(siKykSyouhn.getHknkkn());
        siTyousyo.setHrkkkn(siKykSyouhn.getHrkkkn());
        siTyousyo.setHhknnen(hhknNen);
        siTyousyo.setKyknen(kyksyaNen);
        siTyousyo.setKykymd(siKykSyouhn.getKykymd());
        siTyousyo.setHhknsei(siKykSyouhn.getHhknsei());
        siTyousyo.setHrkkaisuu(siKykKihon.getHrkkaisuu());
        siTyousyo.setHrkkeiro(siKykKihon.getHrkkeiro());

        if(C_Kykjyoutai.ITIJIBARAI.eq(siKykKihon.getKykjyoutai())) {
            siTyousyo.setAnnaihuyouriyuukbn(SiSiharaiTyousyoBatchConstants.ANNAIHUYOURIYUU_ITIJIBARAI);
        }
        else {
            siTyousyo.setAnnaihuyouriyuukbn(SiSiharaiTyousyoBatchConstants.ANNAIHUYOURIYUU_SONOTA);
        }
        siTyousyo.setHrkp(haraiKomiP);
        siTyousyo.setKouryokuhasseiymd(pSkJiyuu.getSibouymd());
        siTyousyo.setMfadrsiyouhyouji(SiSiharaiTyousyoBatchConstants.MFADRSIYOUHYOUJI_SIYOU);
        siTyousyo.setKihrpdmiseibidisp(SiSiharaiTyousyoBatchConstants.MISETTEI);
        siTyousyo.setKihrpseibiyoudisp(SiSiharaiTyousyoBatchConstants.MISETTEI);
        siTyousyo.setShrgk(calcSiTyousyoBean.getHokenkingaku());
        siTyousyo.setWarimsishrgkbizc(calcSiTyousyoBean.getWarimasihokenkingaku());
        siTyousyo.setZnnphrbizc(calcSiTyousyoBean.getZennouptou());
        siTyousyo.setTtkekstkganribizc(calcSiTyousyoBean.getKasitukikingaku());
        siTyousyo.setSshkdbizc(calcSiTyousyoBean.getMiharaihaitou());
        siTyousyo.setSshkshrgk(calcSiTyousyoBean.getSasihikis());
        siTyousyo.setMihrkmpbizc(calcSiTyousyoBean.getMiharaikomip());
        siTyousyo.setShrymd(pSiRireki.getTyakkinymd());
        siTyousyo.setSyorisosikicd(pTtdkRireki.getSyorisosikicd());
        siTyousyo.setSyoritaisyoukbn(syoriTaisyouKbn);
        siTyousyo.setShrtysytsinyno(shrtysytsinyno);
        siTyousyo.setShrtysyadr1kj(shrtysyadr1kj);
        siTyousyo.setShrtysyadr2kj(shrtysyadr2kj);
        siTyousyo.setShrtysyadr3kj(shrtysyadr3kj);
        siTyousyo.setKyknmkj(siKykKihon.getKyknmkj());
        siTyousyo.setHhknnmkj(siKykKihon.getHhknnmkj());
        siTyousyo.setUktnmkj(kjUktNm);
        siTyousyo.setKjdaihyouuktnm(kjDaihyouUktNm);
        siTyousyo.setShrtienrsk(shrTienRsk);
        siTyousyo.setKihons(kihonS);
        siTyousyo.setShrtysysyuruicd(tysySyuruiKbn);
        siTyousyo.setTeknjikihrpseibidisp(SiSiharaiTyousyoBatchConstants.MISETTEI);
        siTyousyo.setKihrkmp(calcSiTyousyoBean.getKibaraikomip());
        siTyousyo.setOnlinecentercutkbn(SiSiharaiTyousyoBatchConstants.ONLINECENTERCUTKBN_ONLINE);
        siTyousyo.setShrhousiteikbn(shrhousiteiKbn);
        siTyousyo.setHtykeihihnsyukbn(SiSiharaiTyousyoBatchConstants.HTYKEIHIHNSYUKBN_PDCB);
        siTyousyo.setSyuseijtshrdbizc(syuseiJtshrD);
        siTyousyo.setTouduketorihouhoukbn(SiSiharaiTyousyoBatchConstants.TOUDUKETORIHOUHOUKBN_TSG);
        siTyousyo.setNenkinkkn(0);
        siTyousyo.setBankcd(SiSiharaiTyousyoBatchConstants.DEF_BANKCD);
        siTyousyo.setBanknmkn("");
        siTyousyo.setSitencd(SiSiharaiTyousyoBatchConstants.DEF_SITENCD);
        siTyousyo.setSitennmkn("");
        siTyousyo.setYokinkbn(C_YokinKbn.BLNK);
        siTyousyo.setYokinknmkn("");
        siTyousyo.setKouzano(SiSiharaiTyousyoBatchConstants.DEF_KOUZANO);
        siTyousyo.setKzmeiginmkn("");
        siTyousyo.setSakuseiymd(syoriYMD);
        siTyousyo.setKykmnmeigibangou(kykmnmeigibangou);
        siTyousyo.setUktmnmeigibangou(uktmnmeigibangou);
        siTyousyo.setJigyoukykmndantaicd("");
        siTyousyo.setMnsaiannaihnskakbn(mnSaiannaiHnskaKbn);
        siTyousyo.setHuho2kykdisp(SiSiharaiTyousyoBatchConstants.HUHO2KYKDISP_RAY);
        siTyousyo.setShrtysyhknsyukbn(shrTysyHknSyuKbn);
        siTyousyo.setShrtysykurikosidisp(shrtysykurikosidisp);
        siTyousyo.setTsinyno(siKykKihon.getTsinyno());
        siTyousyo.setTsinadr1kj(siKykKihon.getTsinadr1kj());
        siTyousyo.setTsinadr2kj(siKykKihon.getTsinadr2kj());
        siTyousyo.setTsinadr3kj(siKykKihon.getTsinadr3kj());
        siTyousyo.setSynyhsjykykndisp(SiSiharaiTyousyoBatchConstants.MISETTEI);
        siTyousyo.setTblsakuseihunodisp(tblSakuseiHunoDisp);
        siTyousyo.setDaihyouktkbn(daihyouktKbn);
        siTyousyo.setGyoumuKousinKinou(kinou.getKinouId());
        siTyousyo.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        siTyousyo.setGyoumuKousinTime(sysTime);
        siTyousyo.setOldtsinyno(oldtsinyno);
        siTyousyo.setOldtsinadr1kj(oldtsinadr1kj);
        siTyousyo.setOldtsinadr2kj(oldtsinadr2kj);
        siTyousyo.setOldtsinadr3kj(oldtsinadr3kj);
        siTyousyo.setOldkyknmkj(oldkyknmkj);
        siTyousyo.setKykhnkkaisuu(kykhnkkaisuu);
        siTyousyo.setShrkykhtykeihiyouhyj(shrkykhtykeihiyouhyj);
        siTyousyo.setShrkykhtykeihi(shrkykhtykeihi);

        BizPropertyInitializer.initialize(siTyousyo);

        siharaiDomManager.insert(siTyousyo);

        outUmuKbn = C_UmuKbn.ARI;

        return outUmuKbn;

    }

    private String chkTapeSakuseiHunouHyouji(C_InputShrhousiteiKbn pInputShrhousiteiKbn,
        JT_Mouside pMouside) {

        String tblSakuseiHunoDisp = SiSiharaiTyousyoBatchConstants.TBLSAKUSEIHUNODISP_HIGAITOU;

        if (C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI.eq(pInputShrhousiteiKbn) ||
            C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(pInputShrhousiteiKbn)) {

            tblSakuseiHunoDisp = SiSiharaiTyousyoBatchConstants.TBLSAKUSEIHUNODISP_GAITOU;

            return tblSakuseiHunoDisp;
        }

        C_TtdktyuuiKbn ttdktyuuiKbn1 = siKykKihon.getTtdktyuuikbn1();
        C_TtdktyuuiKbn ttdktyuuiKbn2 = siKykKihon.getTtdktyuuikbn2();
        C_TtdktyuuiKbn ttdktyuuiKbn3 = siKykKihon.getTtdktyuuikbn3();
        C_TtdktyuuiKbn ttdktyuuiKbn4 = siKykKihon.getTtdktyuuikbn4();
        C_TtdktyuuiKbn ttdktyuuiKbn5 = siKykKihon.getTtdktyuuikbn5();

        if (C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(ttdktyuuiKbn1)
            || C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(ttdktyuuiKbn2)
            || C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(ttdktyuuiKbn3)
            || C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(ttdktyuuiKbn4)
            || C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(ttdktyuuiKbn5)) {

            tblSakuseiHunoDisp = SiSiharaiTyousyoBatchConstants.TBLSAKUSEIHUNODISP_GAITOU;

            return tblSakuseiHunoDisp;
        }

        if (C_TtdktyuuiKbn.MINJISAISEI.eq(ttdktyuuiKbn1)
            || C_TtdktyuuiKbn.MINJISAISEI.eq(ttdktyuuiKbn2)
            || C_TtdktyuuiKbn.MINJISAISEI.eq(ttdktyuuiKbn3)
            || C_TtdktyuuiKbn.MINJISAISEI.eq(ttdktyuuiKbn4)
            || C_TtdktyuuiKbn.MINJISAISEI.eq(ttdktyuuiKbn5)) {

            tblSakuseiHunoDisp = SiSiharaiTyousyoBatchConstants.TBLSAKUSEIHUNODISP_GAITOU;

            return tblSakuseiHunoDisp;
        }

        if (C_TtdktyuuiKbn.SYOUMETUJISEISAN.eq(ttdktyuuiKbn1)
            || C_TtdktyuuiKbn.SYOUMETUJISEISAN.eq(ttdktyuuiKbn2)
            || C_TtdktyuuiKbn.SYOUMETUJISEISAN.eq(ttdktyuuiKbn3)
            || C_TtdktyuuiKbn.SYOUMETUJISEISAN.eq(ttdktyuuiKbn4)
            || C_TtdktyuuiKbn.SYOUMETUJISEISAN.eq(ttdktyuuiKbn5)) {

            tblSakuseiHunoDisp = SiSiharaiTyousyoBatchConstants.TBLSAKUSEIHUNODISP_GAITOU;

            return tblSakuseiHunoDisp;
        }

        if (C_TtdktyuuiKbn.SYOUMETUJIHAITOUTYOUSEIYOU.eq(ttdktyuuiKbn1)
            || C_TtdktyuuiKbn.SYOUMETUJIHAITOUTYOUSEIYOU.eq(ttdktyuuiKbn2)
            || C_TtdktyuuiKbn.SYOUMETUJIHAITOUTYOUSEIYOU.eq(ttdktyuuiKbn3)
            || C_TtdktyuuiKbn.SYOUMETUJIHAITOUTYOUSEIYOU.eq(ttdktyuuiKbn4)
            || C_TtdktyuuiKbn.SYOUMETUJIHAITOUTYOUSEIYOU.eq(ttdktyuuiKbn5)) {

            tblSakuseiHunoDisp = SiSiharaiTyousyoBatchConstants.TBLSAKUSEIHUNODISP_GAITOU;

            return tblSakuseiHunoDisp;
        }

        if (C_TtdktyuuiKbn.SHRTYOUSYOSKSTEISI.eq(ttdktyuuiKbn1)
            || C_TtdktyuuiKbn.SHRTYOUSYOSKSTEISI.eq(ttdktyuuiKbn2)
            || C_TtdktyuuiKbn.SHRTYOUSYOSKSTEISI.eq(ttdktyuuiKbn3)
            || C_TtdktyuuiKbn.SHRTYOUSYOSKSTEISI.eq(ttdktyuuiKbn4)
            || C_TtdktyuuiKbn.SHRTYOUSYOSKSTEISI.eq(ttdktyuuiKbn5)) {

            tblSakuseiHunoDisp = SiSiharaiTyousyoBatchConstants.TBLSAKUSEIHUNODISP_GAITOU;

            return tblSakuseiHunoDisp;
        }

        if (C_TtdktyuuiKbn.KAIGAITOKOU.eq(ttdktyuuiKbn1)
            || C_TtdktyuuiKbn.KAIGAITOKOU.eq(ttdktyuuiKbn2)
            || C_TtdktyuuiKbn.KAIGAITOKOU.eq(ttdktyuuiKbn3)
            || C_TtdktyuuiKbn.KAIGAITOKOU.eq(ttdktyuuiKbn4)
            || C_TtdktyuuiKbn.KAIGAITOKOU.eq(ttdktyuuiKbn5)) {

            tblSakuseiHunoDisp = SiSiharaiTyousyoBatchConstants.TBLSAKUSEIHUNODISP_GAITOU;

            return tblSakuseiHunoDisp;
        }

        if (C_StknsetKbn.ARI.eq(siKykKihon.getStknsetkbn())) {

            tblSakuseiHunoDisp = SiSiharaiTyousyoBatchConstants.TBLSAKUSEIHUNODISP_GAITOU;

            return tblSakuseiHunoDisp;
        }

        if (pMouside != null){
            if (C_MousideninKbn.SOUZOKUNIN.eq(pMouside.getMousideninkbn()) ||
                C_UketorininSibouUmuKbn.UKTSBARI.eq(pMouside.getUketorininsibouumukbn())) {

                tblSakuseiHunoDisp = SiSiharaiTyousyoBatchConstants.TBLSAKUSEIHUNODISP_GAITOU;

                return tblSakuseiHunoDisp;
            }
        }

        return tblSakuseiHunoDisp;
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
