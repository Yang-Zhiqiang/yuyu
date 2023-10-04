package yuyu.batch.hozen.khinterf.khsiharaikekkatorikomi;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.db.MultipleEntityUpdater;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khinterf.khsiharaikekkatorikomi.dba.KhSiharaiKekkaTorikomiDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzdairiten.BzGetTuukeiBunwari;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.EditDairitenTesuuryouTbl;
import yuyu.common.hozen.khcommon.EditHokenKykIdouRirekiTbl;
import yuyu.common.hozen.khcommon.EditHokenKykIdouRirekiTblBean;
import yuyu.common.hozen.khcommon.EditKhMisslstParam;
import yuyu.common.hozen.khcommon.EditKoujyonaiyouTbl;
import yuyu.common.hozen.khcommon.EditKykSyhnRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.GetKhTuusanyouKngk;
import yuyu.common.hozen.khcommon.GetKhTuusanyouKngkBean;
import yuyu.common.hozen.khcommon.HanteiLinc;
import yuyu.common.hozen.khcommon.HanteiLincBean;
import yuyu.common.hozen.khcommon.HanteiTyotikuseihokenBean;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KhozenTyouhyouCtl;
import yuyu.common.hozen.khcommon.KykSyouhnCommonParam;
import yuyu.common.hozen.khcommon.SetTyotikuseihokenhyouji;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.common.hozen.khcommon.ZennouKoujyogakuKeisanParam;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.biz.sorter.SortBT_TjtIdouNyKh;
import yuyu.def.classification.C_Dbhanei;
import yuyu.def.classification.C_DiritenplannmKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HouteiTyotkseiSyouhnHyjKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HushrGeninKbn;
import yuyu.def.classification.C_KiharaiPseisanNaiyouKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KjsymnytblhensyuusyoriKbn;
import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_ShiharaikekkadataKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.classification.C_ZennouSeisanKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_IdouKhBosyuudr;
import yuyu.def.db.entity.BT_IdouKhMeigi;
import yuyu.def.db.entity.BT_TjtIdouNyKh;
import yuyu.def.db.entity.HT_BAK_SmbcStyKanri;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_Azukarikin;
import yuyu.def.db.entity.IT_BAK_KhDenpyoData;
import yuyu.def.db.entity.IT_BAK_KhFBSoukinData;
import yuyu.def.db.entity.IT_BAK_KhGaikaFBSoukinData;
import yuyu.def.db.entity.IT_BAK_KhHenkouUktk;
import yuyu.def.db.entity.IT_BAK_KhSntkInfoTouroku;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KhLincKihon;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KihrkmpSeisanRireki;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_SyouhnTokujou;
import yuyu.def.db.entity.IT_TrkKzk;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.db.entity.JT_SiKekka;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 支払結果情報取込クラス
 */
public class KhSiharaiKekkaTorikomiBatch implements Batch {

    private String kinouID;
    private String kosID;
    private String kosTime;
    private String sikibetukey;
    private int dataNo = 0;
    private  BizDateYM seisekiym;
    private List<IT_KykSyouhn> syuKykSyouhnLst;
    private List<EditKhMisslstParam> editKkMisslstParamLst;
    private KhozenCommonParam kCcommonParam;
    public final String tableID = "JT_SiKekka";
    public final String filterID = "Bz001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam batchParam;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private KhSiharaiKekkaTorikomiDao khSiharaiKekkaTorikomiDao;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void exec() {

        kCcommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        kinouID = kCcommonParam.getFunctionId();
        kosID = kCcommonParam.getUserID();
        kosTime = BizDate.getSysDateTimeMilli();

        BizDate syoriYMD = batchParam.getSyoriYmd();

        editKkMisslstParamLst = new ArrayList<>();
        try (MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();
            MultipleEntityUpdater multipleEntityUpdater = new MultipleEntityUpdater();
            ExDBResults<JT_SiKekka> siKekkaLst = siharaiDomManager.getSiKekkasByKakutyoujobcdSyoriYmd(
                batchParam.getIbKakutyoujobcd(), syoriYMD)) {

            for (JT_SiKekka siKekka : siKekkaLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(batchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(tableID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(filterID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(siKekka.getSyono());

                dataNo++;
                setSiharaiKekka(siKekka, syoriYMD, multipleEntityInserter, multipleEntityUpdater);
            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        if (editKkMisslstParamLst.size() > 0) {
            setMisslist(syoriYMD, editKkMisslstParamLst);
        }

        if (editKkMisslstParamLst.size() == 0) {
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0019, String.valueOf(dataNo)));
        }
        else {
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0018, String.valueOf(dataNo)));
        }

    }

    private void setSiharaiKekka(JT_SiKekka pSiKekka, BizDate pSyoriYMD, MultipleEntityInserter pMultipleEntityInserter,
        MultipleEntityUpdater pMultipleEntityUpdater) {

        kCcommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        C_ShiharaikekkadataKbn shiharaikekkaDataKbn = pSiKekka.getShiharaikekkadatakbn();

        String syoNo = pSiKekka.getSyono();

        C_SyutkKbn syutkKbn = pSiKekka.getSyutkkbn();

        sikibetukey = kCcommonParam.getSikibetuKey(syoNo);

        if (!C_SyutkKbn.SYU.eq(syutkKbn)) {

            throw new CommonBizAppException("主契約以外のレコードです。証券番号 ＝" + syoNo);
        }

        if (!C_ShiharaikekkadataKbn.SYOUMETU.eq(shiharaikekkaDataKbn)) {

            throw new CommonBizAppException("消滅情報以外のレコードです。証券番号 ＝" + syoNo);
        }

        int seqNo = 0;
        long kariukekinData = 0;
        boolean fstPBeforePMen = false;
        BizDateYM fstPKouryokuHasseiYm = null;
        int fstPNyksy = 0;
        int fstPNyksm = 0;
        BizDateYM pMenKouryokuHasseiYm = null;
        int pMenNyksy = 0;
        int pMenNyksm = 0;
        BizCurrency pMenIktp = BizCurrency.valueOf(0);

        EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);

        C_Syoumetujiyuu syoumetuJiyuu = pSiKekka.getSyoumetujiyuu();

        // ソースからコメントアウト

        //        IT_AnsyuKihon ansyuKihon = kCcommonParam.getAnsyuuKihon(syoNo);
        //        BizDateYM henmaeJkipJytYm = ansyuKihon.getJkipjytym();
        //
        //        if (C_ShiharaikekkadataKbn.PMEN.eq(shiharaikekkaDataKbn) ||
        //                (C_ShiharaikekkadataKbn.SYOUMETU.eq(shiharaikekkaDataKbn) &&
        //                        !C_Syoumetujiyuu.MENSEKI.eq(syoumetuJiyuu) &&
        //                        !C_Syoumetujiyuu.SBKAIJO.eq(syoumetuJiyuu))) {
        //
        //            BizDateYM nextHrkYM = pSiKekka.getNexthrkym();
        //
        //            if (BizDateUtil.compareYm(henmaeJkipJytYm, nextHrkYM) != BizDateUtil.COMPARE_EQUAL) {
        //
        //                String errorMessage = MessageUtil.getMessage(MessageId.EIF0020,
        //                        DateFormatUtil.viewYM(nextHrkYM), DateFormatUtil.viewYM(henmaeJkipJytYm));
        //
        //                seqNo++;
        //
        //                EditKhMisslstParam editKkMisslstP = SWAKInjector.getInstance(EditKhMisslstParam.class);
        //
        //                editKkMisslstP.setDataNo(dataNo);
        //                editKkMisslstP.setSeqNo(seqNo);
        //                editKkMisslstP.setMisslistMsg(errorMessage);
        //                editKkMisslstP.setDBhaneikbn(C_Dbhanei.SUMI);
        //                editKkMisslstP.setSyoNo(syoNo);
        //                editKkMisslstParamLst.add(editKkMisslstP);
        //            }
        //
        //            if ((C_ShiharaikekkadataKbn.SYOUMETU.eq(shiharaikekkaDataKbn)
        //                    && C_SyutkKbn.SYU.eq(syutkKbn)) ||
        //                    (C_ShiharaikekkadataKbn.PMEN.eq(shiharaikekkaDataKbn))) {
        //
        //                Map<CurrencyType, BizCurrency> sumKrkgkMp =
        //                        hozenDomManager.getKykKihon(syoNo).getKariukekinSumKrkgkByKrkseisanzumiflg(
        //                                C_Krkseisanzumiflg.SUMI);
        //
        //                kariukekinData = sumKrkgkMp.size();
        //
        //                BizCurrency krkGk = pSiKekka.getKrkgk();
        //                if (kariukekinData != 0) {
        //
        //                    totalKrkGk = sumKrkgkMp.get(BizCurrencyTypes.YEN);
        //                    if (!krkGk.equalsValue(totalKrkGk)) {
        //
        //                        String message = MessageUtil.getMessage(MessageId.EIF0021,
        //                                BizUtil.comma(krkGk.toString()) + "円",
        //                                BizUtil.comma(totalKrkGk.toString()) + "円");
        //
        //                        seqNo++;
        //
        //                        EditKhMisslstParam editKkMisslstP = SWAKInjector.getInstance(EditKhMisslstParam.class);
        //
        //                        editKkMisslstP.setDataNo(dataNo);
        //                        editKkMisslstP.setSeqNo(seqNo);
        //                        editKkMisslstP.setMisslistMsg(message);
        //                        editKkMisslstP.setDBhaneikbn(C_Dbhanei.SUMI);
        //                        editKkMisslstP.setSyoNo(syoNo);
        //                        editKkMisslstParamLst.add(editKkMisslstP);
        //                    }
        //                }
        //                else {
        //
        //                    if (krkGk.compareTo(BizCurrency.valueOf(0)) > 0) {
        //
        //                        String message = MessageUtil.getMessage(MessageId.EIF0021,
        //                                BizUtil.comma(krkGk.toString()) + "円", "0円");
        //
        //                        seqNo++;
        //
        //                        EditKhMisslstParam editKkMisslstP = SWAKInjector.getInstance(EditKhMisslstParam.class);
        //
        //                        editKkMisslstP.setDataNo(dataNo);
        //                        editKkMisslstP.setSeqNo(seqNo);
        //                        editKkMisslstP.setMisslistMsg(message);
        //                        editKkMisslstP.setDBhaneikbn(C_Dbhanei.SUMI);
        //                        editKkMisslstP.setSyoNo(syoNo);
        //                        editKkMisslstParamLst.add(editKkMisslstP);
        //                    }
        //                }
        //            }
        //        }

        List<IT_KykSyouhn> kykSyouhnLst = kCcommonParam.getKeiyakuSyouhin(syoNo, syutkKbn);
        IT_KykSyouhn kykSyouhnEntity = kykSyouhnLst.get(0);
        C_YuukousyoumetuKbn mFYuukousyoumetuKbn = kykSyouhnEntity.getYuukousyoumetukbn();
        C_Syoumetujiyuu mFSyoumetujiyuu = kykSyouhnEntity.getSyoumetujiyuu();
        C_Syoumetujiyuu shiharaiSyoumetuJiyuu = pSiKekka.getSyoumetujiyuu();
        C_HushrGeninKbn hushrGeninKbn = pSiKekka.getHushrgeninkbn();

        int syohinHanteiKbn = SyouhinUtil.hantei(kykSyouhnEntity.getSyouhncd());

        BM_SyouhnZokusei bmSyouhnZokusei = bizDomManager.getSyouhnZokusei(kykSyouhnEntity.getSyouhncd(), kykSyouhnEntity.getSyouhnsdno());

        if (bmSyouhnZokusei == null) {

            throw new CommonBizAppException("商品属性マスタにデータが存在しません。" +
                "商品コード：" + kykSyouhnEntity.getSyouhncd() + "　商品世代番号：" + kykSyouhnEntity.getSyouhnsdno());
        }



        if (!C_YuukousyoumetuKbn.SYOUMETU.eq(mFYuukousyoumetuKbn) &&
            (C_Syoumetujiyuu.MENSEKI.eq(shiharaiSyoumetuJiyuu) ||
                C_Syoumetujiyuu.SBKAIJO.eq(shiharaiSyoumetuJiyuu) ||
                C_Syoumetujiyuu.KAIJO.eq(shiharaiSyoumetuJiyuu) ||(
                    C_Syoumetujiyuu.SBMUKOU.eq(shiharaiSyoumetuJiyuu) &&
                    C_HushrGeninKbn.MUKOU_SONOTA.eq(hushrGeninKbn)
                    ))) {

            String message = MessageUtil.getMessage(MessageId.IIF1008, shiharaiSyoumetuJiyuu.getContent());
            seqNo++;

            EditKhMisslstParam editKkMisslstP = SWAKInjector.getInstance(EditKhMisslstParam.class);

            editKkMisslstP.setDataNo(dataNo);
            editKkMisslstP.setSeqNo(seqNo);
            editKkMisslstP.setMisslistMsg(message);
            editKkMisslstP.setDBhaneikbn(C_Dbhanei.SUMI);
            editKkMisslstP.setSyoNo(syoNo);

            editKkMisslstParamLst.add(editKkMisslstP);

            return;
        }

        else if (C_YuukousyoumetuKbn.SYOUMETU.eq(mFYuukousyoumetuKbn)) {
            if (!shiharaiSyoumetuJiyuu.eq(mFSyoumetujiyuu)) {

                String message = MessageUtil.getMessage(MessageId.IIF1009,shiharaiSyoumetuJiyuu.getContent());
                seqNo++;

                EditKhMisslstParam editKkMisslstP = SWAKInjector.getInstance(EditKhMisslstParam.class);

                editKkMisslstP.setDataNo(dataNo);
                editKkMisslstP.setSeqNo(seqNo);
                editKkMisslstP.setMisslistMsg(message);
                editKkMisslstP.setDBhaneikbn(C_Dbhanei.SUMI);
                editKkMisslstP.setSyoNo(syoNo);

                editKkMisslstParamLst.add(editKkMisslstP);
            }
            return;
        }

        //

        //        if (C_ShiharaikekkadataKbn.PMEN.eq(shiharaikekkaDataKbn)) {
        //
        //            BizDate kouryokuHasseiymd = pSiKekka.getKouryokuhasseiymd();
        //            BizDate kouryokuHasseiymdPrevDay = kouryokuHasseiymd.getPreviousDay();
        //
        //            keisanMsyMkeiP.exec(syoNo, kouryokuHasseiymdPrevDay, C_MisyuptsKbn.TSKKTK);
        //
        //            if (keisanMsyMkeiP.getMisyuP().compareTo(BizCurrency.valueOf(0)) > 0) {
        //
        //                Map<CurrencyType, BizCurrency> sumKrkgkMp = hozenDomManager.getKykKihon(
        //                        syoNo).getKariukekinSumKrkgkByNyknaiyoukbnKrkseisanzumiflg(
        //                                C_NyknaiyouKbn.PMENYOUP, C_Krkseisanzumiflg.SUMI);
        //
        //                kariukekinData = sumKrkgkMp.size();
        //
        //                if (kariukekinData != 0) {
        //
        //                    totalKrkGk = sumKrkgkMp.get(BizCurrencyTypes.YEN);
        //                    if (!keisanMsyMkeiP.getMisyuP().equalsValue(totalKrkGk)) {
        //
        //                        String message = MessageUtil.getMessage(MessageId.EIF0027,
        //                                BizUtil.comma(totalKrkGk.toString()) + "円",
        //                                BizUtil.comma(keisanMsyMkeiP.getMisyuP().toString()) + "円");
        //
        //                        seqNo++;
        //
        //                        EditKhMisslstParam editKkMisslstP = SWAKInjector.getInstance(EditKhMisslstParam.class);
        //
        //                        editKkMisslstP.setDataNo(dataNo);
        //                        editKkMisslstP.setSeqNo(seqNo);
        //                        editKkMisslstP.setMisslistMsg(message);
        //                        editKkMisslstP.setDBhaneikbn(C_Dbhanei.SUMI);
        //                        editKkMisslstP.setSyoNo(syoNo);
        //                        editKkMisslstParamLst.add(editKkMisslstP);
        //
        //                        totalKrkGk = keisanMsyMkeiP.getMisyuP();
        //
        //                    }
        //                }
        //                else {
        //                    String message = MessageUtil.getMessage(MessageId.EIF0027, "0円",
        //                            BizUtil.comma(keisanMsyMkeiP.getMisyuP().toString()) + "円");
        //
        //                    seqNo++;
        //
        //                    EditKhMisslstParam editKkMisslstP = SWAKInjector.getInstance(EditKhMisslstParam.class);
        //
        //                    editKkMisslstP.setDataNo(dataNo);
        //                    editKkMisslstP.setSeqNo(seqNo);
        //                    editKkMisslstP.setMisslistMsg(message);
        //                    editKkMisslstP.setDBhaneikbn(C_Dbhanei.NONE);
        //                    editKkMisslstP.setSyoNo(syoNo);
        //                    editKkMisslstParamLst.add(editKkMisslstP);
        //
        //                    return;
        //
        //                }
        //
        //            }
        //
        //        }
        //
        //        String uniqueId = uniqueKeyGenerator.generateUniqueKey();

        TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);
        tableMaintenanceUtil.backUp(syoNo, sikibetukey);

        BizDate kouryokuhasseiYMD = pSiKekka.getKouryokuhasseiymd();

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo);

        if (C_ShiharaikekkadataKbn.SYOUMETU.eq(shiharaikekkaDataKbn)) {

            if (C_SyutkKbn.SYU.eq(syutkKbn)) {

                kykKihon.setSyhenkouymd(pSyoriYMD);
                kykKihon.setGyoumuKousinKinou(kinouID);
                kykKihon.setGyoumuKousinsyaId(kosID);
                kykKihon.setGyoumuKousinTime(kosTime);

                kCcommonParam.setBatchKeiyakuKihon(kykKihon);
                kCcommonParam.setBatchAnsyuKihon(ansyuKihon);

                IT_KhTtdkRireki khTtdkRireki = kykKihon.createKhTtdkRireki();
                khTtdkRireki.setHenkousikibetukey(sikibetukey);

                editKykSyhnRirekiTbl.exec(
                    kCcommonParam,
                    syoNo);

                kykSyouhnLst = kykKihon.getKykSyouhns();

                for (IT_KykSyouhn kykSyouhn : kykSyouhnLst) {

                    kykSyouhn.setHenkousikibetukey(sikibetukey);
                    kykSyouhn.setYuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);
                    kykSyouhn.setSyoumetujiyuu(syoumetuJiyuu);
                    kykSyouhn.setSyoumetuymd(kouryokuhasseiYMD);
                    kykSyouhn.setGyoumuKousinKinou(kinouID);
                    kykSyouhn.setGyoumuKousinsyaId(kosID);
                    kykSyouhn.setGyoumuKousinTime(kosTime);
                }

                List<IT_SyouhnTokujou> syouhnTokujouLst = kykKihon.getSyouhnTokujous();

                for (IT_SyouhnTokujou syouhnTokujou : syouhnTokujouLst) {

                    syouhnTokujou.setHenkousikibetukey(sikibetukey);
                    syouhnTokujou.setGyoumuKousinKinou(kinouID);
                    syouhnTokujou.setGyoumuKousinsyaId(kosID);
                    syouhnTokujou.setGyoumuKousinTime(kosTime);
                }
            }
        }

        if (pSiKekka.getKrkgk().compareTo(BizCurrency.valueOf(0, pSiKekka.getKrkgk().getType())) > 0) {
            List<IT_Kariukekin> kariukekinList = khSiharaiKekkaTorikomiDao.getKariukekinsBySyono(kykKihon);

            for (IT_Kariukekin kariukekin : kariukekinList) {
                kariukekin.setSeisandenymd(pSiKekka.getDenymd());
                kariukekin.setKrkseisanzumiflg(C_Krkseisanzumiflg.SUMI);
                kariukekin.setGyoumuKousinKinou(kinouID);
                kariukekin.setGyoumuKousinsyaId(kosID);
                kariukekin.setGyoumuKousinTime(kosTime);
            }
        }

        if (pSiKekka.getZitkazukarikingkyen().compareTo(BizCurrency.valueOf(0,
            pSiKekka.getZitkazukarikingkyen().getType())) > 0 ||
            pSiKekka.getZitkazukarikingksiteituuka().compareTo(BizCurrency.valueOf(0,
                pSiKekka.getZitkazukarikingksiteituuka().getType())) > 0) {

            List<IT_Azukarikin> azukarikinList = khSiharaiKekkaTorikomiDao.getAzukarikinsBySyono(kykKihon);

            for (IT_Azukarikin azukarikin : azukarikinList) {

                azukarikin.setShrymd(pSiKekka.getDenymd());
                azukarikin.setShrsyoriymd(pSyoriYMD);
                azukarikin.setGyoumuKousinKinou(kinouID);
                azukarikin.setGyoumuKousinsyaId(kosID);
                azukarikin.setGyoumuKousinTime(kosTime);
            }
        }

        List<IT_Zennou> zennouList = new ArrayList<>();
        if (C_Kykjyoutai.ZENNOU.eq(kykSyouhnEntity.getKykjyoutai())) {
            zennouList = ansyuKihon.getZennouMsisnsBySyono();

            for (IT_Zennou zennou : zennouList) {

                zennou.setZennouseisankbn(C_ZennouSeisanKbn.SEISANZUMI);
                zennou.setZennouseisansyoriymd(pSyoriYMD);
                zennou.setZennouseisankgk(pSiKekka.getZennouseisankgk());
                zennou.setZennouseisankijyunymd(pSiKekka.getKouryokuhasseiymd());

                if (pSiKekka.getZennouseisankgk().compareTo(
                    BizCurrency.valueOf(0, pSiKekka.getZennouseisankgk().getType())) > 0) {

                    zennou.setZennouseisandenymd(pSiKekka.getDenymd());
                }
                zennou.setGyoumuKousinKinou(kinouID);
                zennou.setGyoumuKousinsyaId(kosID);
                zennou.setGyoumuKousinTime(kosTime);
            }
        }
        if (pSiKekka.getSeisanpgoukei().compareTo(BizCurrency.valueOf(0, pSiKekka.getSeisanpgoukei().getType())) > 0) {

            Integer renNo = hozenDomManager.getKihrkmpSeisanRirekiMaxRennoBySyono(syoNo);

            if (renNo != null) {
                renNo = renNo + 1;
            }
            else {
                renNo = 1;
            }

            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki = kykKihon.createKihrkmpSeisanRireki();

            kihrkmpSeisanRireki.setRenno(renNo);
            kihrkmpSeisanRireki.setHenkousikibetukey(sikibetukey);
            kihrkmpSeisanRireki.setKouryokuhasseiymd(pSiKekka.getKouryokuhasseiymd());
            kihrkmpSeisanRireki.setKihrkpssnaiyoukbn(C_KiharaiPseisanNaiyouKbn.SEISANP);
            kihrkmpSeisanRireki.setJyuutouym(pSiKekka.getJyuutouym());
            kihrkmpSeisanRireki.setSeijyutoukaisuum(pSiKekka.getJyutoukaisuum());
            kihrkmpSeisanRireki.setSeijyutoukaisuuy(pSiKekka.getJyutoukaisuuy());
            kihrkmpSeisanRireki.setMisyuumikeikakbn(pSiKekka.getMisyuumikeikakbn());
            kihrkmpSeisanRireki.setGyoumuKousinKinou(kinouID);
            kihrkmpSeisanRireki.setGyoumuKousinsyaId(kosID);
            kihrkmpSeisanRireki.setGyoumuKousinTime(kosTime);

            if (syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

                kihrkmpSeisanRireki.setZeimukwsratekjnymd(pSiKekka.getShrkwsratekjnymd());

                if (C_Tuukasyu.JPY.eq(pSiKekka.getShrtuukasyu())) {

                    kihrkmpSeisanRireki.setZeimukwsrate(pSiKekka.getShrkwsrate());
                }
                else {

                    kihrkmpSeisanRireki.setZeimukwsrate(pSiKekka.getZeimukwsrate());
                }
            }

            BizPropertyInitializer.initialize(kihrkmpSeisanRireki);

            EditKoujyonaiyouTbl editKoujyonaiyouTbl = SWAKInjector.getInstance(EditKoujyonaiyouTbl.class);
            if (C_Kykjyoutai.ZENNOU.eq(kykSyouhnEntity.getKykjyoutai())) {
                IT_Zennou zennou = zennouList.get(0);
                ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam =
                    SWAKInjector.getInstance(ZennouKoujyogakuKeisanParam.class);
                zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(zennou.getKjsmyouzennoukaisiymd());
                zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm(zennou.getKjsmyouzennoukikanm());
                zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(zennou.getKjsmyouzennounyuukinkgk());
                zennouKoujyogakuKeisanParam.setHrkp(kykKihon.getHrkp());
                zennouKoujyogakuKeisanParam.setHrkkaisuu(kykKihon.getHrkkaisuu());
                zennouKoujyogakuKeisanParam.setZennoukaisiymd(zennou.getZennoukaisiymd());
                zennouKoujyogakuKeisanParam.setZennourenno(zennou.getRenno());
                zennouKoujyogakuKeisanParam.setKjsmyouyenknsnkawaserate(zennou.getKjsmyouyenkansankwsrate());
                editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);
            }
            editKoujyonaiyouTbl.setCalcKjnYmd(pSiKekka.getKouryokuhasseiymd());
            editKoujyonaiyouTbl.setHenmaeJkipJytYm(ansyuKihon.getJkipjytym());
            editKoujyonaiyouTbl.setHenmaeHenkousikibetukey(sikibetukey);
            editKoujyonaiyouTbl.setKihrkpSeisanRenno(renNo);
            editKoujyonaiyouTbl.setKihrkpSeisanJytYm(pSiKekka.getJyuutouym());
            editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(pSiKekka.getJyutoukaisuuy());
            editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(pSiKekka.getJyutoukaisuum());
            editKoujyonaiyouTbl.setMkkp(pSiKekka.getSeisanpgoukei());
            BizNumber seisanjiYenkansanKwsrate = BizNumber.ZERO;
            if (C_Tuukasyu.JPY.eq(pSiKekka.getShrtuukasyu())) {

                seisanjiYenkansanKwsrate = pSiKekka.getShrkwsrate();
            }
            else {

                seisanjiYenkansanKwsrate = pSiKekka.getZeimukwsrate();
            }
            editKoujyonaiyouTbl.setSeisanjiYenkansanKwsrate(seisanjiYenkansanKwsrate);
            List<KykSyouhnCommonParam> kykSyouhnCommonParamLst = new ArrayList<>();
            kykSyouhnCommonParamLst.addAll(kykKihon.getKykSyouhns());
            editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamLst);


            editKoujyonaiyouTbl.exec(
                kCcommonParam,
                syoNo,
                C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_SYOUMETU,
                pSyoriYMD);
        }

        // ソースからコメントアウト

        //        else if (C_ShiharaikekkadataKbn.PMEN.eq(shiharaikekkaDataKbn)) {
        //
        //            C_Nykkeiro nykKeiro = C_Nykkeiro.BLNK;
        //            BizDate ryosyuYMD = null;
        //
        //            syuKykSyouhnLst = kCcommonParam.getKeiyakuSyouhin(syoNo, C_SyutkKbn.SYU);
        //
        //            String oldHkSikibetuKey = syuKykSyouhnLst.get(0).getHenkousikibetukey();
        //            BizDate kykYMD = syuKykSyouhnLst.get(0).getKykymd();
        //
        //            if (keisanMsyMkeiP.getMisyuP().compareTo(BizCurrency.valueOf(0)) > 0) {
        //
        //                List<IT_Kariukekin> kariukekinLst = hozenDomManager.getKykKihon(syoNo).
        //                        getKariukekinsByKrkseisanzumiflgNyknaiyoukbn(C_Krkseisanzumiflg.SUMI, C_NyknaiyouKbn.PMENYOUP);
        //
        //                SortIT_Kariukekin sort = new SortIT_Kariukekin();
        //                sort.OrderIT_KariukekinByNyosyuymdKrknoAsc(kariukekinLst);
        //
        //                ryosyuYMD = kariukekinLst.get(0).getRyosyuymd();
        //                nykKeiro = kariukekinLst.get(0).getNykkeiro();
        //            }
        //
        //            hrkP = kykKihon.getHrkp();
        //            hrkKaisuu = kykKihon.getHrkkaisuu();
        //
        //            if (keisanMsyMkeiP.getMisyuP().compareTo(BizCurrency.valueOf(0)) > 0
        //                    && BizDateUtil.compareYm(keisanMsyMkeiP.getMisyuPJyutouYM(),
        //                            kykYMD.getBizDateYM()) == BizDateUtil.COMPARE_EQUAL) {
        //
        //                BizDate sknnKaisiYmd = syuKykSyouhnLst.get(0).getSknnkaisiymd();
        //                List<BM_Simekiribi> simekiribiLst =
        //                        bizDomManager.getSimekiribisBySyorisimefromymdSyorisimetoymd(sknnKaisiYmd);
        //
        //                if (simekiribiLst.size() == 0) {
        //
        //                    throw new CommonBizAppException("締切日マスタにデータが存在しません。");
        //                }
        //
        //                BizDateYM seisekiymMos = simekiribiLst.get(0).getBosyuuym();
        //
        //                kykKihon.setFstpnyknymd(ryosyuYMD);
        //
        //                if (BizDateUtil.compareYm(seisekiymMos, seisekiym) == BizDateUtil.COMPARE_GREATER ||
        //                        BizDateUtil.compareYm(seisekiymMos, seisekiym) == BizDateUtil.COMPARE_EQUAL) {
        //
        //                    kykKihon.setSeisekiym(seisekiymMos);
        //                }
        //                else {
        //                    kykKihon.setSeisekiym(seisekiym);
        //                }
        //
        //                fstPBeforePMen = true;
        //                fstPKouryokuHasseiYm = pSiKekka.getNexthrkym();
        //
        //                if (C_Hrkkaisuu.NEN.eq(hrkKaisuu)) {
        //
        //                    fstPNyksy = 1;
        //                    fstPNyksm = 0;
        //                }
        //                else {
        //
        //                    fstPNyksy = 0;
        //                    fstPNyksm = Integer.valueOf(hrkKaisuu.getValue());
        //                }
        //
        //                if (keisanMsyMkeiP.getMisyuP().compareTo(hrkP) > 0) {
        //
        //                    BizDate nextHrkYm = BizDate.valueOf(pSiKekka.getNexthrkym() + "01");
        //                    BizDateSpan span = new BizDateSpan(0, Integer.valueOf(hrkKaisuu.getValue()), 0);
        //                    nextHrkYm = nextHrkYm.add(span).getRekijyou();
        //                    pMenKouryokuHasseiYm = nextHrkYm.getBizDateYM();
        //
        //                    if (C_Hrkkaisuu.NEN.eq(hrkKaisuu)) {
        //
        //                        pMenNyksy = keisanMsyMkeiP.getMisyuPJyutouKaisuuY() - 1;
        //                        pMenNyksm = keisanMsyMkeiP.getMisyuPJyutouKaisuuM();
        //                    }
        //                    else {
        //
        //                        pMenNyksy = keisanMsyMkeiP.getMisyuPJyutouKaisuuY();
        //                        pMenNyksm = keisanMsyMkeiP.getMisyuPJyutouKaisuuM() - Integer.valueOf(hrkKaisuu.getValue());
        //                    }
        //
        //                    pMenIktp = keisanMsyMkeiP.getMisyuP().subtract(hrkP);
        //                }
        //            }
        //
        //            kykKihon.setSyhenkouymd(pSyoriYMD);
        //            kykKihon.setGyoumuKousinKinou(kinouID);
        //            kykKihon.setGyoumuKousinsyaId(kosID);
        //            kykKihon.setGyoumuKousinTime(kosTime);
        //            hozenDomManager.update(kykKihon);
        //
        //            editKykSyhnRirekiTbl.exec(kCcommonParam, syoNo);
        //
        //            List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        //            for (IT_KykSyouhn kykSyouhn : kykSyouhnLst) {
        //
        //                kykSyouhn.setHenkousikibetukey(sikibetukey);
        //                kykSyouhn.setKykjyoutai(C_Kykjyoutai.PMEN);
        //                kykSyouhn.setKouryokuhasseiymd(kouryokuhasseiYMD);
        //                kykSyouhn.setGyoumuKousinKinou(kinouID);
        //                kykSyouhn.setGyoumuKousinsyaId(kosID);
        //                kykSyouhn.setGyoumuKousinTime(kosTime);
        //            }
        //            hozenDomManager.update(kykKihon);
        //
        //            List<IT_SyouhnTokujou> syouhnTokujouLst = kykKihon.getSyouhnTokujous();
        //            for (IT_SyouhnTokujou syouhnTokujou : syouhnTokujouLst) {
        //
        //                syouhnTokujou.setHenkousikibetukey(sikibetukey);
        //                syouhnTokujou.setGyoumuKousinKinou(kinouID);
        //                syouhnTokujou.setGyoumuKousinsyaId(kosID);
        //                syouhnTokujou.setGyoumuKousinTime(kosTime);
        //            }
        //            hozenDomManager.update(kykKihon);
        //
        //            if (keisanMsyMkeiP.getMisyuP().compareTo(BizCurrency.valueOf(0)) > 0) {
        //
        //                BizDate oikomiDenYmd = pSyoriYMD;
        //
        //                SetDenSimebi setDenSimebi = SWAKInjector.getInstance(SetDenSimebi.class);
        //                BizDate zengetumatuSimeYmd = setDenSimebi.exec(pSyoriYMD);
        //
        //                if ((BizDateUtil.compareYmd(zengetumatuSimeYmd, pSyoriYMD) == BizDateUtil.COMPARE_GREATER
        //                        || BizDateUtil.compareYmd(zengetumatuSimeYmd, pSyoriYMD) == BizDateUtil.COMPARE_EQUAL)
        //                        && BizDateUtil.compareYm(ryosyuYMD.getBizDateYM(), pSyoriYMD.getBizDateYM()) == BizDateUtil.COMPARE_LESSER) {
        //
        //                    BizDate tempSyoriYMD = pSyoriYMD;
        //                    tempSyoriYMD = tempSyoriYMD.getBizDateYM().getPreviousMonth().getLastDay();
        //                    if (tempSyoriYMD.isHoliday()) {
        //                        tempSyoriYMD = tempSyoriYMD.getBusinessDay(CHolidayAdjustingMode.PREVIOUS);
        //                    }
        //
        //                    oikomiDenYmd = tempSyoriYMD;
        //
        //                }
        //
        //                BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(pSiKekka.getSyouhncd(),
        //                        pSiKekka.getSyouhnsdno());
        //
        //                C_Segcd seg1Cd = syouhnZokusei.getSeg1cd();
        //                C_Segcd seg2Cd = syouhnZokusei.getSeg2cd();
        //
        //                List<CommonSiwakeBean> commonSiwakeBeanLst = new ArrayList<>();
        //
        //                for (int index = 0; index < keisanMsyMkeiP.getMisyuuPBeans().length; index++) {
        //
        //                    CommonSiwakeBean commonSiwakeBean = SWAKInjector.getInstance(CommonSiwakeBean.class);
        //                    commonSiwakeBean.setKeijyouP(keisanMsyMkeiP.getMisyuuPBeans()[index].getMisyuuP());
        //                    commonSiwakeBean.setHrkKaisuu(keisanMsyMkeiP.getMisyuuPBeans()[index].getMsyPHrkKaisuu());
        //                    commonSiwakeBean.setJyutouStartYm(keisanMsyMkeiP.getMisyuuPBeans()[index].getMsyPJytYm());
        //                    commonSiwakeBean.setJyutouKaisuuY(keisanMsyMkeiP.getMisyuuPBeans()[index].getMsyPJytKaisuuY());
        //                    commonSiwakeBean.setJyutouKaisuuM(keisanMsyMkeiP.getMisyuuPBeans()[index].getMsyPJytKaisuuM());
        //                    commonSiwakeBeanLst.add(commonSiwakeBean);
        //                }
        //
        //                CommonSiwake commonSiwake = SWAKInjector.getInstance(CommonSiwake.class);
        //
        //                commonSiwake.setFunctionId(kinouID);
        //                commonSiwake.setKykymd(kykYMD);
        //                commonSiwake.setDenymd(pSyoriYMD);
        //                commonSiwake.setSeisankrkgk(totalKrkGk);
        //                commonSiwake.setPinfos(commonSiwakeBeanLst.toArray(new CommonSiwakeBean[commonSiwakeBeanLst.size()]));
        //                commonSiwake.setSeg1cd(seg1Cd);
        //                commonSiwake.setSeg2cd(seg2Cd);
        //
        //                commonSiwake.exec();
        //                int siwakeSuu = commonSiwake.getSiwakesuu();
        //                C_Hjkmkcd[] hojyoKamokuCds = new C_Hjkmkcd[siwakeSuu];
        //                BizCurrency[] syouhizeiGks = new BizCurrency[siwakeSuu];
        //                for (int iCnt = 0; iCnt < siwakeSuu; iCnt++) {
        //                    hojyoKamokuCds[iCnt] = C_Hjkmkcd.BLNK;
        //                    syouhizeiGks[iCnt] = BizCurrency.valueOf(0);
        //                }
        //
        //                DenDataTrk denDataTrk = SWAKInjector.getInstance(DenDataTrk.class);
        //
        //                String denRenno = denDataTrk.exec(C_DensysKbn.HOZEN,
        //                        C_DensyoriKbn.MSYPJYT_PMENYOUP,
        //                        pSyoriYMD,
        //                        oikomiDenYmd,
        //                        siwakeSuu,
        //                        commonSiwake.getTaisyakukbns(),
        //                        commonSiwake.getKanjyoukmkcds(),
        //                        hojyoKamokuCds,
        //                        commonSiwake.getDengks(),
        //                        syouhizeiGks,
        //                        commonSiwake.getSeg1cd(),
        //                        commonSiwake.getSeg2cd(),
        //                        syoNo,
        //                        null,
        //                        null,
        //                        null,
        //                        null,
        //                        null,
        //                        0,
        //                        kinouID,
        //                        kosID);
        //
        //                for (int index = 0; index < keisanMsyMkeiP.getMisyuuPBeans().length; index++) {
        //
        //                    BizDateYM rrkJytStartYM = keisanMsyMkeiP.getMisyuuPBeans()[index].getMsyPJytYm();
        //                    C_UmuKbn rrkIktNyknUmu = keisanMsyMkeiP.getMisyuuPBeans()[index].getMsyPIkkatuNkUmu();
        //                    int jyutouKaisuuY = 0;
        //                    int jyutouKaisuuM = 0;
        //                    int pmenYouPJyutouKaisuu = 0;
        //                    BizCurrency ryosyuGK = BizCurrency.valueOf(0);
        //
        //                    if (C_UmuKbn.NONE.eq(rrkIktNyknUmu)) {
        //
        //                        if (C_Hrkkaisuu.NEN.eq(kykKihon.getHrkkaisuu())) {
        //
        //                            jyutouKaisuuY = 1;
        //                            jyutouKaisuuM = 0;
        //                        }
        //                        if (C_Hrkkaisuu.HALFY.eq(kykKihon.getHrkkaisuu())) {
        //
        //                            jyutouKaisuuY = 0;
        //                            jyutouKaisuuM = Integer.valueOf(kykKihon.getHrkkaisuu().getValue());
        //                        }
        //                        if (C_Hrkkaisuu.TUKI.eq(kykKihon.getHrkkaisuu())) {
        //                            jyutouKaisuuY = 0;
        //                            jyutouKaisuuM = Integer.valueOf(kykKihon.getHrkkaisuu().getValue());
        //                        }
        //
        //                        JtKaisukeisan jtKaisukeisan = SWAKInjector.getInstance(JtKaisukeisan.class);
        //                        jtKaisukeisan.exec(keisanMsyMkeiP.getMisyuuPBeans()[index].getMsyPJytKaisuuY(),
        //                                keisanMsyMkeiP.getMisyuuPBeans()[index].getMsyPJytKaisuuM(),
        //                                kykKihon.getHrkkaisuu());
        //
        //                        pmenYouPJyutouKaisuu = jtKaisukeisan.getJyutoukaisuu();
        //                        ryosyuGK = kykKihon.getHrkp();
        //                    }
        //                    if (C_UmuKbn.ARI.eq(rrkIktNyknUmu)) {
        //
        //                        ryosyuGK = keisanMsyMkeiP.getMisyuuPBeans()[index].getMisyuuP();
        //                        jyutouKaisuuY = keisanMsyMkeiP.getMisyuuPBeans()[index].getMsyPJytKaisuuY();
        //                        jyutouKaisuuM = keisanMsyMkeiP.getMisyuuPBeans()[index].getMsyPJytKaisuuM();
        //                        pmenYouPJyutouKaisuu = 1;
        //                    }
        //
        //                    for (int count = 0; count < pmenYouPJyutouKaisuu; count++) {
        //
        //                        BizDate jyutouEndYM = BizDate.valueOf(rrkJytStartYM + "01");
        //                        if (C_UmuKbn.NONE.eq(rrkIktNyknUmu)) {
        //                            jyutouEndYM = jyutouEndYM.add(new BizDateSpan(0,
        //                                    Integer.valueOf(kykKihon.getHrkkaisuu().getValue()) - 1, 0)).getRekijyou();
        //                        }
        //                        if (C_UmuKbn.ARI.eq(rrkIktNyknUmu)) {
        //                            jyutouEndYM = jyutouEndYM.add(new BizDateSpan(0, jyutouKaisuuM - 1, 0)).getRekijyou();
        //
        //                        }
        //
        //                        Integer maxRenNo = hozenDomManager.getNyknJissekiRirekiMaxRennoBySyonoJyutoustartym(
        //                                syoNo, rrkJytStartYM);
        //
        //                        int renNo = 0;
        //                        if (maxRenNo == null) {
        //                            renNo = 1;
        //                        }
        //                        else {
        //
        //                            renNo = maxRenNo + 1;
        //                        }
        //
        //                        IT_NyknJissekiRireki nyknJissekiRireki = kykKihon.createNyknJissekiRireki();
        //
        //                        nyknJissekiRireki.setSyono(syoNo);
        //                        nyknJissekiRireki.setJyutoustartym(rrkJytStartYM);
        //                        nyknJissekiRireki.setRenno(renNo);
        //                        nyknJissekiRireki.setJyutouendym(jyutouEndYM.getBizDateYM());
        //                        nyknJissekiRireki.setRyosyugk(ryosyuGK);
        //                        nyknJissekiRireki.setHrkp(kykKihon.getHrkp());
        //                        nyknJissekiRireki.setNyksyoriymd(pSyoriYMD);
        //                        nyknJissekiRireki.setRyosyuymd(ryosyuYMD);
        //                        nyknJissekiRireki.setNykdenno(denRenno);
        //                        nyknJissekiRireki.setNykdenymd(oikomiDenYmd);
        //                        nyknJissekiRireki.setNykkeiro(nykKeiro);
        //                        nyknJissekiRireki.setHrkkaisuu(kykKihon.getHrkkaisuu());
        //                        nyknJissekiRireki.setJyutoukaisuuy(jyutouKaisuuY);
        //                        nyknJissekiRireki.setJyutoukaisuum(jyutouKaisuuM);
        //                        nyknJissekiRireki.setNyknaiyoukbn(C_NyknaiyouKbn.PMENYOUP);
        //                        nyknJissekiRireki.setIktnyuukinnumu(rrkIktNyknUmu);
        //                        nyknJissekiRireki.setHenkousikibetukey(oldHkSikibetuKey);
        //                        nyknJissekiRireki.setGyoumuKousinKinou(kinouID);
        //                        nyknJissekiRireki.setGyoumuKousinsyaId(kosID);
        //                        nyknJissekiRireki.setGyoumuKousinTime(kosTime);
        //                        BizPropertyInitializer.initialize(nyknJissekiRireki);
        //
        //                        hozenDomManager.update(kykKihon);
        //
        //                        EditKoujyonaiyouTbl editKoujyonaiyouTbl = SWAKInjector.getInstance(EditKoujyonaiyouTbl.class);
        //
        //                        editKoujyonaiyouTbl.setIkkatuNyknUmu(rrkIktNyknUmu);
        //                        editKoujyonaiyouTbl.setNyknJskStartYm(rrkJytStartYM);
        //                        editKoujyonaiyouTbl.setNyknJskEndYm(jyutouEndYM.getBizDateYM());
        //                        editKoujyonaiyouTbl.setNyknJskRenno(renNo);
        //                        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(ryosyuYMD);
        //                        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(jyutouKaisuuY);
        //                        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(jyutouKaisuuM);
        //
        //                        editKoujyonaiyouTbl.exec(kCcommonParam,
        //                                syoNo,
        //                                C_KjsymnytblhensyuusyoriKbn.YOUPHANEI,
        //                                pSyoriYMD);
        //
        //                        rrkJytStartYM = jyutouEndYM.getNextMonth().getBizDateYM();
        //                    }
        //                }
        //
        //                List<IT_Kariukekin> kariukekinLst = kykKihon.getKariukekinsByKrkseisanzumiflgNyknaiyoukbn(
        //                        C_Krkseisanzumiflg.SUMI, C_NyknaiyouKbn.PMENYOUP);
        //                for (IT_Kariukekin kariukekin : kariukekinLst) {
        //                    kariukekin.setSeisandenymd(oikomiDenYmd);
        //                    kariukekin.setKrkseisanzumiflg(C_Krkseisanzumiflg.SUMI);
        //                    kariukekin.setGyoumuKousinKinou(kinouID);
        //                    kariukekin.setGyoumuKousinsyaId(kosID);
        //                    kariukekin.setGyoumuKousinTime(kosTime);
        //                }
        //                hozenDomManager.update(kykKihon);
        //
        //            }
        //
        //            ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo);
        //            ansyuKihon.setTokusin(null);
        //            hozenDomManager.update(ansyuKihon);
        //
        //            IT_AnsyuKihon ansyuKihon2 = hozenDomManager.getAnsyuKihon(syoNo);
        //            ansyuKihon2.setJkipjytym(kouryokuhasseiYMD.getBizDateYM());
        //            ansyuKihon2.setGyoumuKousinKinou(kinouID);
        //            ansyuKihon2.setGyoumuKousinsyaId(kosID);
        //            ansyuKihon2.setGyoumuKousinTime(kosTime);
        //            hozenDomManager.update(ansyuKihon2);
        //
        //            if (kariukekinData != 0) {
        //
        //                List<IT_Kariukekin> kariukekinLst = kykKihon.getKariukekinsByNotKrkseisanzumiflgNyknaiyoukbn(
        //                        C_Krkseisanzumiflg.SUMI, C_NyknaiyouKbn.PMENYOUP);
        //                for (IT_Kariukekin kariukekin : kariukekinLst) {
        //                    kariukekin.setSeisandenymd(pSiKekka.getDenymd());
        //                    kariukekin.setKrkseisanzumiflg(C_Krkseisanzumiflg.SUMI);
        //                    kariukekin.setGyoumuKousinKinou(kinouID);
        //                    kariukekin.setGyoumuKousinsyaId(kosID);
        //                    kariukekin.setGyoumuKousinTime(kosTime);
        //                }
        //                hozenDomManager.update(kykKihon);
        //            }
        //        }
        //        else if (C_ShiharaikekkadataKbn.GANSINDAN90INAI.eq(shiharaikekkaDataKbn)) {
        //
        //            kykKihon.setGansindankakuteiymd(pSiKekka.getGansindankakuteiymd());
        //            kykKihon.setSyhenkouymd(pSyoriYMD);
        //            kykKihon.setGyoumuKousinKinou(kinouID);
        //            kykKihon.setGyoumuKousinsyaId(kosID);
        //            kykKihon.setGyoumuKousinTime(kosTime);
        //            hozenDomManager.update(kykKihon);
        //
        //        }

        List<IT_KykSyouhn> kykSyouhnniLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();
        List<IT_KykUkt> sbuktKykUktLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);
        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();
        List<IT_KykUkt> stdrskKykUktLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.STDRSK);
        List<IT_KykUkt> kykdrnKykUktLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.KYKDRN);
        IT_TrkKzk trkKzk1 = null;
        IT_TrkKzk trkKzk2 = null;
        List<IT_TrkKzk> trkKzkLst = kykKihon.getTrkKzks();

        for (IT_TrkKzk trkKzk : trkKzkLst) {
            if (C_TrkKzkKbn.TRKKZK1.eq(trkKzk.getTrkkzkkbn())) {
                trkKzk1 = trkKzk;
            }
            else if (C_TrkKzkKbn.TRKKZK2.eq(trkKzk.getTrkkzkkbn())) {
                trkKzk2 = trkKzk;
            }
        }

        List<BT_TjtIdouNyKh> tjtIdouNyKhLst = bizDomManager.getTjtIdouNyKhsBySyono(syoNo);
        SortBT_TjtIdouNyKh tjtIdouNyKhSort = new SortBT_TjtIdouNyKh();
        tjtIdouNyKhLst = tjtIdouNyKhSort.OrderBT_TjtIdouNyKhByPkDesc(tjtIdouNyKhLst);

        Integer renno3Keta;
        if (tjtIdouNyKhLst.size() > 0) {
            renno3Keta = tjtIdouNyKhLst.get(0).getRenno3keta() + 1;
        }
        else {
            renno3Keta = 1;
        }

        GetKhTuusanyouKngk getKhTuusanyouKngk = SWAKInjector.getInstance(GetKhTuusanyouKngk.class);

        GetKhTuusanyouKngkBean getKhTuusanyouKngkBean = getKhTuusanyouKngk.
            getAlltsnkngk(bmSyouhnZokusei,
                kykSyouhnniLst.get(0),
                nyknJissekiRirekiLst.get(0),
                kykSonotaTkyk);

        SetTyotikuseihokenhyouji setTyotikuseihokenhyouji = SWAKInjector.getInstance(SetTyotikuseihokenhyouji.class);
        HanteiTyotikuseihokenBean hanteiTyotikuseihokenBean = SWAKInjector.getInstance(HanteiTyotikuseihokenBean.class);
        hanteiTyotikuseihokenBean.setSyouhnCd(kykSyouhnniLst.get(0).getSyouhncd());
        hanteiTyotikuseihokenBean.setSyouhnsdNo(kykSyouhnniLst.get(0).getSyouhnsdno());
        hanteiTyotikuseihokenBean.setHrkkaisuu(kykKihon.getHrkkaisuu());
        hanteiTyotikuseihokenBean.setHrkkeiro(kykKihon.getHrkkeiro());

        setTyotikuseihokenhyouji.hanteiTyotikuseihoken(hanteiTyotikuseihokenBean);

        C_UmuKbn houteityotkhknhyj = setTyotikuseihokenhyouji.getHouteityotkhknhyj();

        String sbuktUktnmkn1 = "";
        String sbuktUktnmkj1 = "";
        String sbuktUktnmkn2 = "";
        String sbuktUktnmkj2 = "";
        String sbuktUktnmkn3 = "";
        String sbuktUktnmkj3 = "";
        String sbuktUktnmkn4 = "";
        String sbuktUktnmkj4 = "";

        if (sbuktKykUktLst != null && sbuktKykUktLst.size() > 0) {

            if (C_UktKbn.TOKUTEIMEIGI.eq(sbuktKykUktLst.get(0).getUktkbn()) ) {

                sbuktUktnmkn1 = sbuktKykUktLst.get(0).getUktnmkn();

                if (!C_KjkhukaKbn.KJKHUKA.eq(sbuktKykUktLst.get(0).getUktnmkjkhukakbn())) {
                    sbuktUktnmkj1 = sbuktKykUktLst.get(0).getUktnmkj();
                }
            }

            for (int index= 1; index < sbuktKykUktLst.size(); index++) {

                if (index == 1) {

                    sbuktUktnmkn2 = sbuktKykUktLst.get(index).getUktnmkn();

                    if (!C_KjkhukaKbn.KJKHUKA.eq(sbuktKykUktLst.get(index).getUktnmkjkhukakbn())) {
                        sbuktUktnmkj2 = sbuktKykUktLst.get(index).getUktnmkj();
                    }
                }

                else if (index == 2) {

                    sbuktUktnmkn3 = sbuktKykUktLst.get(index).getUktnmkn();

                    if (!C_KjkhukaKbn.KJKHUKA.eq(sbuktKykUktLst.get(index).getUktnmkjkhukakbn())) {
                        sbuktUktnmkj3 = sbuktKykUktLst.get(index).getUktnmkj();
                    }

                }

                else if (index == 3) {

                    sbuktUktnmkn4 = sbuktKykUktLst.get(index).getUktnmkn();

                    if (!C_KjkhukaKbn.KJKHUKA.eq(sbuktKykUktLst.get(index).getUktnmkjkhukakbn())) {
                        sbuktUktnmkj4 = sbuktKykUktLst.get(index).getUktnmkj();
                    }
                }
            }
        }

        String stdrskUktnmkn = "";
        String stdrskUktnmkj = "";

        if (stdrskKykUktLst != null && stdrskKykUktLst.size() > 0) {

            if (C_UktKbn.TOKUTEIMEIGI.eq(stdrskKykUktLst.get(0).getUktkbn()) ) {

                stdrskUktnmkn = stdrskKykUktLst.get(0).getUktnmkn();

                if (!C_KjkhukaKbn.KJKHUKA.eq(stdrskKykUktLst.get(0).getUktnmkjkhukakbn())) {
                    stdrskUktnmkj = stdrskKykUktLst.get(0).getUktnmkj();
                }
            }
        }

        Integer kykhhKndouhyouji;
        if (C_Tdk.HONNIN.eq(kykSya.getKkkyktdk())) {

            kykhhKndouhyouji = 1;
        }
        else {

            kykhhKndouhyouji = 0;
        }

        String hhknnmkj = "";

        if (!C_KjkhukaKbn.KJKHUKA.eq(hhknSya.getHhknnmkjkhukakbn())) {

            hhknnmkj = hhknSya.getHhknnmkj();
        }

        String kyknmkn = "";
        String kyknmkj = "";
        BizDate kykseiymd = null;

        if (kykhhKndouhyouji == 0) {

            kyknmkn = kykSya.getKyknmkn();
            kykseiymd = kykSya.getKykseiymd();

            if (!C_KjkhukaKbn.KJKHUKA.eq(kykSya.getKyknmkjkhukakbn())) {

                kyknmkj = kykSya.getKyknmkj();
            }
        }
        C_TtdktyuuiKbn ttdktyuuiKbn1;
        C_TtdktyuuiKbn ttdktyuuiKbn2;
        C_TtdktyuuiKbn ttdktyuuiKbn3;
        C_TtdktyuuiKbn ttdktyuuiKbn4;
        C_TtdktyuuiKbn ttdktyuuiKbn5;
        if (khTtdkTyuui != null) {

            ttdktyuuiKbn1 = khTtdkTyuui.getTtdktyuuikbn1();
            ttdktyuuiKbn2 = khTtdkTyuui.getTtdktyuuikbn2();
            ttdktyuuiKbn3 = khTtdkTyuui.getTtdktyuuikbn3();
            ttdktyuuiKbn4 = khTtdkTyuui.getTtdktyuuikbn4();
            ttdktyuuiKbn5 = khTtdkTyuui.getTtdktyuuikbn5();
        }
        else {

            ttdktyuuiKbn1 = C_TtdktyuuiKbn.BLNK;
            ttdktyuuiKbn2 = C_TtdktyuuiKbn.BLNK;
            ttdktyuuiKbn3 = C_TtdktyuuiKbn.BLNK;
            ttdktyuuiKbn4 = C_TtdktyuuiKbn.BLNK;
            ttdktyuuiKbn5 = C_TtdktyuuiKbn.BLNK;
        }

        C_HouteiTyotkseiSyouhnHyjKbn houteiTyotkseiSyouhnHyj = C_HouteiTyotkseiSyouhnHyjKbn.HIGAITOU;

        if (C_UmuKbn.ARI.eq(houteityotkhknhyj)) {

            houteiTyotkseiSyouhnHyj = C_HouteiTyotkseiSyouhnHyjKbn.GAITOU;
        }

        BT_TjtIdouNyKh tjtIdouNyKh = new BT_TjtIdouNyKh();
        tjtIdouNyKh.setSyono(syoNo);
        tjtIdouNyKh.setRenno3keta(renno3Keta);
        tjtIdouNyKh.setRecordsakujyohyouji(0);
        tjtIdouNyKh.setYoukyuuno("");
        tjtIdouNyKh.setSyouhncd(kykSyouhnniLst.get(0).getSyouhncd());
        tjtIdouNyKh.setKykjyoutai(kykSyouhnniLst.get(0).getKykjyoutai());
        tjtIdouNyKh.setKykymd(kykSyouhnniLst.get(0).getKykymd());
        tjtIdouNyKh.setYuukousyoumetukbn(kykSyouhnniLst.get(0).getYuukousyoumetukbn());
        tjtIdouNyKh.setSyoumetujiyuu(kykSyouhnniLst.get(0).getSyoumetujiyuu());
        tjtIdouNyKh.setSyoumetuymd(kykSyouhnniLst.get(0).getSyoumetuymd());
        tjtIdouNyKh.setKyktuukasyu(kykSyouhnniLst.get(0).getKyktuukasyu());
        tjtIdouNyKh.setTsnyousibous(getKhTuusanyouKngkBean.getTsnyouSibous());
        tjtIdouNyKh.setTsnyouitijip(getKhTuusanyouKngkBean.getTsnyouItijip());
        tjtIdouNyKh.setTsnyounkgns(getKhTuusanyouKngkBean.getTsnyouNkgns());
        tjtIdouNyKh.setHrkkkn(kykSyouhnniLst.get(0).getHrkkkn());
        tjtIdouNyKh.setSntkhoukbn(kykKihon.getSntkhoukbn());
        tjtIdouNyKh.setBosyuuym(kykKihon.getBosyuuym());
        tjtIdouNyKh.setKykhhkndouhyouji(kykhhKndouhyouji);
        tjtIdouNyKh.setTtdktyuuikbn1(ttdktyuuiKbn1);
        tjtIdouNyKh.setTtdktyuuikbn2(ttdktyuuiKbn2);
        tjtIdouNyKh.setTtdktyuuikbn3(ttdktyuuiKbn3);
        tjtIdouNyKh.setTtdktyuuikbn4(ttdktyuuiKbn4);
        tjtIdouNyKh.setTtdktyuuikbn5(ttdktyuuiKbn5);
        tjtIdouNyKh.setSyouhnsdno(kykSyouhnniLst.get(0).getSyouhnsdno());
        tjtIdouNyKh.setKaigomaehrtkykumukbn(kykSonotaTkyk.getJyudkaigomeharaitkhukaumu());
        tjtIdouNyKh.setPyennykntkykumukbn(kykSonotaTkyk.getYennykntkhkumu());
        tjtIdouNyKh.setTsnyennyknkgk(getKhTuusanyouKngkBean.getTsnyouYennyknkgk());
        tjtIdouNyKh.setSkjmosno(kykKihon.getSkjmosno());
        tjtIdouNyKh.setGyoumuKousinKinou(kinouID);
        tjtIdouNyKh.setGyoumuKousinsyaId(kosID);
        tjtIdouNyKh.setGyoumuKousinTime(kosTime);
        tjtIdouNyKh.setSeiritujitrhkjikakkbn(kykKihon.getSeiritujitrhkjikakkbn());
        tjtIdouNyKh.setHouteityotkseisyouhnhyj(houteiTyotkseiSyouhnHyj);
        tjtIdouNyKh.setTsntuukasyu(getKhTuusanyouKngkBean.getTsnyouTuukasyu());
        tjtIdouNyKh.setHrkkeiro(kykKihon.getHrkkeiro());

        BizPropertyInitializer.initialize(tjtIdouNyKh);

        BT_IdouKhMeigi idouKhMeigi = tjtIdouNyKh.createIdouKhMeigi();

        idouKhMeigi.setHhknnmkn(hhknSya.getHhknnmkn());
        idouKhMeigi.setHhknnmkj(hhknnmkj);
        idouKhMeigi.setHhknseiymd(hhknSya.getHhknseiymd());
        idouKhMeigi.setHhknsei(hhknSya.getHhknsei());
        idouKhMeigi.setHhknyno(hhknSya.getHhknyno());
        idouKhMeigi.setHhknadr1kj("");
        idouKhMeigi.setHhknadr2kj("");
        idouKhMeigi.setHhknadr3kj("");
        idouKhMeigi.setHhkntelno("");
        idouKhMeigi.setHhknsykgycd(kykKihon.getHhknsykgycd());
        idouKhMeigi.setKyknmkn(kyknmkn);
        idouKhMeigi.setKyknmkj(kyknmkj);
        idouKhMeigi.setKykseiymd(kykseiymd);
        idouKhMeigi.setNenkinuktnmkana("");
        idouKhMeigi.setNenkinuktnmkanji("");
        idouKhMeigi.setNenkinuktseiymd(null);
        idouKhMeigi.setTsinyno(kykSya.getTsinyno());
        idouKhMeigi.setTsinadr1kj(kykSya.getTsinadr1kj());
        idouKhMeigi.setTsinadr2kj(kykSya.getTsinadr2kj());
        idouKhMeigi.setTsinadr3kj(kykSya.getTsinadr3kj());
        idouKhMeigi.setTsintelno(kykSya.getTsintelno());
        idouKhMeigi.setSbuktnmkn1(sbuktUktnmkn1);
        idouKhMeigi.setSbuktnmkj1(sbuktUktnmkj1);
        idouKhMeigi.setSbuktnmkn2(sbuktUktnmkn2);
        idouKhMeigi.setSbuktnmkj2(sbuktUktnmkj2);
        idouKhMeigi.setSbuktnmkn3(sbuktUktnmkn3);
        idouKhMeigi.setSbuktnmkj3(sbuktUktnmkj3);
        idouKhMeigi.setSbuktnmkn4(sbuktUktnmkn4);
        idouKhMeigi.setSbuktnmkj4(sbuktUktnmkj4);
        idouKhMeigi.setStdrsknmkn(stdrskUktnmkn);
        idouKhMeigi.setStdrsknmkj(stdrskUktnmkj);

        if (C_Hrkkeiro.KOUHURI.eq(kykKihon.getHrkkeiro())) {
            IT_Kouza kouza = kykKihon.getKouza();
            idouKhMeigi.setBankcd(kouza.getBankcd());
            idouKhMeigi.setSitencd(kouza.getSitencd());
            idouKhMeigi.setYokinkbn(kouza.getYokinkbn());
            idouKhMeigi.setKouzano(kouza.getKouzano());
            idouKhMeigi.setKzmeiginmkn(kouza.getKzmeiginmkn());
            idouKhMeigi.setKzkykdoukbn(kouza.getKzkykdoukbn());
        }

        String kykdairinmkn = "";
        String kykdairinmkj = "";
        if (kykdrnKykUktLst.size() > 0) {
            if (C_UktKbn.TOKUTEIMEIGI.eq(kykdrnKykUktLst.get(0).getUktkbn())) {
                kykdairinmkn = kykdrnKykUktLst.get(0).getUktnmkn();
                if (!C_KjkhukaKbn.KJKHUKA.eq(kykdrnKykUktLst.get(0).getUktnmkjkhukakbn())) {
                    kykdairinmkj = kykdrnKykUktLst.get(0).getUktnmkj();
                }
            }
        }

        String kzktourokunmkn1 = "";
        String kzktourokunmkj1 = "";
        if (trkKzk1 != null) {
            kzktourokunmkn1 = trkKzk1.getTrkkzknmkn();
            if (!C_KjkhukaKbn.KJKHUKA.eq(trkKzk1.getTrkkzknmkjkhukakbn())) {
                kzktourokunmkj1 = trkKzk1.getTrkkzknmkj();
            }
        }

        String kzktourokunmkn2 = "";
        String kzktourokunmkj2 = "";
        if (trkKzk2 != null) {
            kzktourokunmkn2 = trkKzk2.getTrkkzknmkn();
            if (!C_KjkhukaKbn.KJKHUKA.eq(trkKzk2.getTrkkzknmkjkhukakbn())) {
                kzktourokunmkj2 = trkKzk2.getTrkkzknmkj();
            }
        }
        idouKhMeigi.setKykdairinmkn(kykdairinmkn);
        idouKhMeigi.setKykdairinmkj(kykdairinmkj);
        idouKhMeigi.setKzktourokunmkn1(kzktourokunmkn1);
        idouKhMeigi.setKzktourokunmkj1(kzktourokunmkj1);
        idouKhMeigi.setKzktourokunmkn2(kzktourokunmkn2);
        idouKhMeigi.setKzktourokunmkj2(kzktourokunmkj2);
        BizPropertyInitializer.initialize(idouKhMeigi);

        BT_IdouKhBosyuudr idouKhBosyuudr = tjtIdouNyKh.createIdouKhBosyuudr();

        if (kykDairitenLst.size() == 1) {
            idouKhBosyuudr.setDairitencd1(kykDairitenLst.get(0).getDrtencd());
            idouKhBosyuudr.setBunwari1(kykDairitenLst.get(0).getBunwari());
            idouKhBosyuudr.setDairitencd2("");
            idouKhBosyuudr.setBunwari2(BizNumber.ZERO);
            idouKhBosyuudr.setKanrisosikicd1(kykDairitenLst.get(0).getDrtenkanrisosikicd());
            idouKhBosyuudr.setKanrisosikicd2("");
        }
        else if (kykDairitenLst.size() == 2) {

            BzGetTuukeiBunwari bzGetTuukeiBunwari = SWAKInjector.getInstance(BzGetTuukeiBunwari.class);
            bzGetTuukeiBunwari.exec(kykDairitenLst.get(0).getDrtencd(),
                kykDairitenLst.get(0).getOyadrtencd(),
                kykDairitenLst.get(0).getBunwari(),
                kykDairitenLst.get(1).getDrtencd(),
                kykDairitenLst.get(1).getOyadrtencd(),
                kykDairitenLst.get(1).getBunwari(),
                kykKihon.getSeirituymd().getBizDateYM(),
                bmSyouhnZokusei.getDrtsyouhinsikibetukbn(),
                kykKihon.getHrkkaisuu(),
                C_DiritenplannmKbn.BLNK);

            if (bzGetTuukeiBunwari.getErrorKbn().eq(C_ErrorKbn.ERROR)) {
                throw new CommonBizAppException("通計用代理店分担割合取得が実行できませんでした。");
            }

            idouKhBosyuudr.setDairitencd1(bzGetTuukeiBunwari.getDrtencd1());
            idouKhBosyuudr.setBunwari1(bzGetTuukeiBunwari.getBuntanWariai1());
            idouKhBosyuudr.setDairitencd2(bzGetTuukeiBunwari.getDrtencd2());
            idouKhBosyuudr.setBunwari2(bzGetTuukeiBunwari.getBuntanWariai2());
            idouKhBosyuudr.setKanrisosikicd1(kykDairitenLst.get(0).getDrtenkanrisosikicd());
            idouKhBosyuudr.setKanrisosikicd2(kykDairitenLst.get(1).getDrtenkanrisosikicd());
        }
        BizPropertyInitializer.initialize(idouKhBosyuudr);


        BizCurrency seisanpGoukei = pSiKekka.getSeisanpgoukei();
        C_SyoriKbn syoriKbn = null;

        if (C_ShiharaikekkadataKbn.SYOUMETU.eq(shiharaikekkaDataKbn)) {
            if (C_SyutkKbn.SYU.eq(syutkKbn)) {

                if (C_Syoumetujiyuu.SIBOU.eq(syoumetuJiyuu)||
                    C_Syoumetujiyuu.SIBOUSAIGAIHIGAITOU.eq(syoumetuJiyuu)||
                    C_Syoumetujiyuu.SIBOUSAIGAIMENSEKI.eq(syoumetuJiyuu)) {
                    syoriKbn = C_SyoriKbn.SIBOU;
                }

                else if (C_Syoumetujiyuu.SIBOUKYUUHUKINSHR.eq(syoumetuJiyuu)) {

                    syoriKbn = C_SyoriKbn.SBKYUUHUSHR;
                }

                else if (C_Syoumetujiyuu.MENSEKI.eq(syoumetuJiyuu)) {

                    syoriKbn = C_SyoriKbn.MENSEKI;
                }

                else if (C_Syoumetujiyuu.SBKAIJO.eq(syoumetuJiyuu)) {

                    syoriKbn = C_SyoriKbn.SBKAIJO;
                }

                else if (C_Syoumetujiyuu.SBMUKOU.eq(syoumetuJiyuu)) {

                    syoriKbn = C_SyoriKbn.SBMUKOU;
                }

                else if (C_Syoumetujiyuu.KOUDOSYOUGAI.eq(syoumetuJiyuu)) {

                    syoriKbn = C_SyoriKbn.KOUDOSYOUGAI;
                }

                else if (C_Syoumetujiyuu.KAIJO.eq(syoumetuJiyuu)) {

                    syoriKbn = C_SyoriKbn.KAIJO;
                }

                else if (C_Syoumetujiyuu.JIKOU.eq(syoumetuJiyuu)) {

                    syoriKbn = C_SyoriKbn.JIKOU;
                }
            }
        }

        EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);

        editTtdkRirekiTblParam.setCommonParam(kCcommonParam);
        editTtdkRirekiTblParam.setSyoNo(syoNo);
        editTtdkRirekiTblParam.setSyoriYmd(pSyoriYMD);
        editTtdkRirekiTblParam.setSyoriKbn(syoriKbn);
        editTtdkRirekiTblParam.setSysTime(kosTime);

        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);

        editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);

        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector
            .getInstance(EditHokenKykIdouRirekiTblBean.class);
        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(kCcommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo(syoNo);
        editHokenKykIdouRirekiTblBean.setSyoriYmd(pSyoriYMD);
        editHokenKykIdouRirekiTblBean.setSyoriKbn(syoriKbn);
        editHokenKykIdouRirekiTblBean.setSysDateTime(kosTime);
        editHokenKykIdouRirekiTblBean.setMikeikaP(pSiKekka.getSeisanpgoukei());
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(pSiKekka.getZennouseisankgk());

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        EditDairitenTesuuryouTbl editDairitenTesuuryouTbl = SWAKInjector.getInstance(EditDairitenTesuuryouTbl.class);

        editDairitenTesuuryouTbl.setBatchSyoriYmd(pSyoriYMD);

        if (fstPBeforePMen) {

            editDairitenTesuuryouTbl.exec(kCcommonParam,
                syoNo,
                C_TsrysyoriKbn.SEIRITUGOFSTPNYUUKIN,
                fstPKouryokuHasseiYm,
                fstPNyksy,
                fstPNyksm,
                BizCurrency.valueOf(0),
                BizCurrency.valueOf(0),
                pSyoriYMD,
                tableMaintenanceUtil.getBakKykKihon());

            editDairitenTesuuryouTbl.exec(kCcommonParam,
                syoNo,
                C_TsrysyoriKbn.PMEN,
                pMenKouryokuHasseiYm,
                pMenNyksy,
                pMenNyksm,
                seisanpGoukei,
                pMenIktp,
                tableMaintenanceUtil.getBakKykKihon());
        }

        else {

            C_TsrysyoriKbn tsrySyoriKbn;
            BizDateYM kouryokuHasseiYm;
            int nyksy;
            int nyksm;
            BizCurrency iktp = BizCurrency.valueOf(0);


            if (C_Syoumetujiyuu.SIBOU.eq(syoumetuJiyuu) ||
                C_Syoumetujiyuu.SIBOUSAIGAIHIGAITOU.eq(syoumetuJiyuu) ||
                C_Syoumetujiyuu.SIBOUSAIGAIMENSEKI.eq(syoumetuJiyuu) ||
                C_Syoumetujiyuu.SIBOUKYUUHUKINSHR.eq(syoumetuJiyuu) ||
                C_Syoumetujiyuu.SBMUKOU.eq(syoumetuJiyuu)) {

                tsrySyoriKbn = C_TsrysyoriKbn.SIBOU;
            }

            else if (C_Syoumetujiyuu.KOUDOSYOUGAI.eq(syoumetuJiyuu)) {

                tsrySyoriKbn = C_TsrysyoriKbn.KOUDOSYOUGAI;
            }
            else {

                tsrySyoriKbn = C_TsrysyoriKbn.BLNK;
            }

            if (seisanpGoukei.compareTo(BizCurrency.valueOf(0, pSiKekka.getSeisanpgoukei().getType())) > 0) {
                kouryokuHasseiYm = pSiKekka.getJyuutouym();
                nyksy = pSiKekka.getJyutoukaisuuy();
                nyksm = pSiKekka.getJyutoukaisuum();
                iktp = BizCurrency.valueOf(0, pSiKekka.getSeisanpgoukei().getType());
            }

            // ソースからコメントアウト

            //                    else if (C_ShiharaikekkadataKbn.PMEN.eq(shiharaikekkaDataKbn)
            //                            && keisanMsyMkeiP.getMisyuP().compareTo(BizCurrency.valueOf(0)) > 0) {
            //
            //                        kouryokuHasseiYm = pSiKekka.getNexthrkym();
            //                        nyksy = keisanMsyMkeiP.getMisyuPJyutouKaisuuY();
            //                        nyksm = keisanMsyMkeiP.getMisyuPJyutouKaisuuM();
            //                        iktp = keisanMsyMkeiP.getMisyuP();
            //                    }

            else {

                kouryokuHasseiYm = null;
                nyksy = 0;
                nyksm = 0;
                iktp = BizCurrency.valueOf(0, pSiKekka.getSeisanpgoukei().getType());
            }

            if (!C_SyoriKbn.JIKOU.eq(syoriKbn)) {

                editDairitenTesuuryouTbl.exec(kCcommonParam, syoNo, tsrySyoriKbn,
                    kouryokuHasseiYm, nyksy, nyksm, seisanpGoukei, iktp, tableMaintenanceUtil.getBakKykKihon());
            }
        }

        IT_KhLincKihon khLincKihon = kykKihon.getKhLincKihon();
        Long lincKanyuusyaNo = 0L;
        HanteiLinc hanteiLinc = SWAKInjector.getInstance(HanteiLinc.class);
        HanteiLincBean hanteiLincBean = SWAKInjector.getInstance(HanteiLincBean.class);
        if (khLincKihon != null) {

            lincKanyuusyaNo = khLincKihon.getLinckanyuusyano();
        }

        hanteiLincBean.setSyoriYmd(pSyoriYMD);
        hanteiLincBean.setBakKykKihon(tableMaintenanceUtil.getBakKykKihon());
        hanteiLincBean.setKykKihon(kykKihon);
        hanteiLincBean.setKanyuusyaNo(lincKanyuusyaNo);

        C_ErrorKbn hanteiLincErrorKbn = hanteiLinc.exec(hanteiLincBean, kCcommonParam);

        if (C_ErrorKbn.ERROR.eq(hanteiLincErrorKbn)) {

            String message = MessageUtil.getMessage(MessageId.EIC0010, "ＬＩＮＣ該当判定");
            seqNo++;
            EditKhMisslstParam editKkMisslstP = SWAKInjector.getInstance(EditKhMisslstParam.class);

            editKkMisslstP.setDataNo(dataNo);
            editKkMisslstP.setSeqNo(seqNo);
            editKkMisslstP.setMisslistMsg(message);
            editKkMisslstP.setDBhaneikbn(C_Dbhanei.SUMI);
            editKkMisslstP.setSyoNo(syoNo);

            editKkMisslstParamLst.add(editKkMisslstP);
            return;
        }

        if (tableMaintenanceUtil.getBakKykKihon() != null) {
            pMultipleEntityInserter.add(tableMaintenanceUtil.getBakKykKihon());
        }
        if (tableMaintenanceUtil.getBakAnsyuKihon() != null) {

            pMultipleEntityInserter.add(tableMaintenanceUtil.getBakAnsyuKihon());
        }
        if (tableMaintenanceUtil.getBakKhDenpyoDataList().size() != 0) {

            for (IT_BAK_KhDenpyoData bakKhDenpyoData : tableMaintenanceUtil.getBakKhDenpyoDataList()) {

                pMultipleEntityInserter.add(bakKhDenpyoData);
            }
        }
        if (tableMaintenanceUtil.getBakKhFBSoukinDataList().size() != 0) {

            for (IT_BAK_KhFBSoukinData bakKhFBSoukinData : tableMaintenanceUtil.getBakKhFBSoukinDataList()) {

                pMultipleEntityInserter.add(bakKhFBSoukinData);
            }
        }

        if (tableMaintenanceUtil.getBakKhGaikaFBSoukinDataList().size() != 0) {

            for (IT_BAK_KhGaikaFBSoukinData bakKhGaikaFBSoukinData : tableMaintenanceUtil.getBakKhGaikaFBSoukinDataList()) {

                pMultipleEntityInserter.add(bakKhGaikaFBSoukinData);
            }
        }

        if (tableMaintenanceUtil.getBakKhSntkInfoTourokuList().size() != 0) {

            for (IT_BAK_KhSntkInfoTouroku bakKhSntkInfoTouroku : tableMaintenanceUtil.getBakKhSntkInfoTourokuList()) {

                pMultipleEntityInserter.add(bakKhSntkInfoTouroku);
            }
        }

        if (tableMaintenanceUtil.getBakSmbcStyKanriList().size() != 0) {

            for (HT_BAK_SmbcStyKanri bakSmbcStyKanri : tableMaintenanceUtil.getBakSmbcStyKanriList()) {

                pMultipleEntityInserter.add(bakSmbcStyKanri);
            }
        }

        if (tableMaintenanceUtil.getBakKhHenkouUktkList().size() != 0) {

            for (IT_BAK_KhHenkouUktk bakKhHenkouUktk : tableMaintenanceUtil.getBakKhHenkouUktkList()) {

                pMultipleEntityInserter.add(bakKhHenkouUktk);
            }
        }

        pMultipleEntityInserter.add(tjtIdouNyKh);
        pMultipleEntityUpdater.add(kykKihon);
        pMultipleEntityUpdater.add(ansyuKihon);
    }

    private void setMisslist(BizDate pSyoriYMD, List<EditKhMisslstParam> pEditKkMisslstParamLst) {

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);

        khozenTyouhyouCtl.setEditKkMisslstParam(pEditKkMisslstParamLst);

        khozenTyouhyouCtl.setSyoriYmd(pSyoriYMD);

        khozenTyouhyouCtl.createTyouhyouTBL(kCcommonParam,
            new C_SyoruiCdKbn[] { C_SyoruiCdKbn.KK_SHRKEKKATORIKOMI_MISSLIST },
            C_YouhiKbn.HUYOU);
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

}