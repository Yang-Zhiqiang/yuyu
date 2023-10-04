package yuyu.batch.hozen.khozen.khdseisantuibarai;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.db.MultipleEntityUpdater;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.batch.hozen.khozen.khdseisantuibarai.dba.KhDSeisanTuibaraiBean;
import yuyu.batch.hozen.khozen.khdseisantuibarai.dba.KhDSeisanTuibaraiDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.kaikei.BzDenpyouDataSks;
import yuyu.common.biz.kaikei.BzDenpyouDataTourokuBean;
import yuyu.common.biz.kaikei.BzFbSoukinDataSks;
import yuyu.common.biz.kaikei.BzFbSoukinDataSksBean;
import yuyu.common.biz.kaikei.BzGkfbSoukinDataSks;
import yuyu.common.biz.kaikei.BzGkfbSoukinDataSksBean;
import yuyu.common.hozen.khcommon.CommonSiwake;
import yuyu.common.hozen.khcommon.CommonSiwakeInBean;
import yuyu.common.hozen.khcommon.CommonSiwakeOutBean;
import yuyu.common.hozen.khcommon.EditTtdkKanryouParam;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KhozenTyouhyouCtl;
import yuyu.common.hozen.khcommon.TaisyouGkBean;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_KhDengkSyuruiKbn;
import yuyu.def.classification.C_ShrsyoriKbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyuShrgkSyoukeiKbn;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.db.entity.IT_DSeisanShrTysySyusei;
import yuyu.def.db.entity.IT_DSeisanTuibaraiKanri;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.entity.IT_KhFBSoukinData;
import yuyu.def.db.entity.IT_KhGaikaFBSoukinData;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 契約保全 Ｄ精算追払
 */
public class KhDSeisanTuibaraiBatch  implements Batch{

    private static final String TYSYTTAISYOU_TABLE_ID = IT_DSeisanTuibaraiKanri.TABLE_NAME;

    private static final String RECOVERY_FILTER_KBNID = "Kh001";

    private long haitoukinTuibaraiHatuseiKensuu = 0;

    private long dSeisanShrTysySyuseiTBLOutKensuu = 0;

    private long tysytRecordKensuu = 0;

    private KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

    private IT_KykKihon kykKihon = null;

    private IT_KhTtdkRireki khTtdkRireki = null;

    private String denrenNo = "";

    private BizDate syoriYmd = null;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private KhDSeisanTuibaraiDao khDSeisanTuibaraiDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {


        syoriYmd = bzBatchParam.getSyoriYmd();
        String ibKakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();


        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            ibKakutyoujobCd));

        BizDateY syoriYmdJigyounendo = syoriYmd.getBizDateY();


        try (
            ExDBResults<KhDSeisanTuibaraiBean> khDSeisanTuibaraiBeanList = khDSeisanTuibaraiDao
            .getKhDSeisanTuibaraiKanriByHaitounendo(ibKakutyoujobCd, syoriYmdJigyounendo);
            MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();
            MultipleEntityUpdater multipleEntityUpdater = new MultipleEntityUpdater();) {

            for (KhDSeisanTuibaraiBean khDSeisanTuibaraiBean : khDSeisanTuibaraiBeanList) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOU_TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_KBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khDSeisanTuibaraiBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(khDSeisanTuibaraiBean.getSyono());

                tysytRecordKensuu = tysytRecordKensuu + 1;

                commonKhDSeisanTuibarai(khDSeisanTuibaraiBean.getSyono());

                shrKhDSeisanTuibarai(khDSeisanTuibaraiBean, multipleEntityInserter);

                updateKhTtdkRireki(khDSeisanTuibaraiBean.getSyono(), C_UmuKbn.ARI);

                multipleEntityUpdater.add(kykKihon);
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(tysytRecordKensuu), "抽出レコード件数"));

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(haitoukinTuibaraiHatuseiKensuu),
                "配当金追払 あり"));

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(dSeisanShrTysySyuseiTBLOutKensuu),
                "Ｄ精算支払調書修正テーブル"));
        }
    }

    private void commonKhDSeisanTuibarai(String pSyoNo) {

        updateKykKihon(pSyoNo);

        khTtdkRireki = kykKihon.createKhTtdkRireki();

        khTtdkRireki.setHenkousikibetukey(khozenCommonParam.getSikibetuKey(pSyoNo));
    }

    private void shrKhDSeisanTuibarai(KhDSeisanTuibaraiBean pKhDSeisanTuibaraiBean, MultipleEntityInserter pMultipleEntityInserter) {

        creatDenpyouJouhou(pKhDSeisanTuibaraiBean, pMultipleEntityInserter);

        creatKhShrRireki(pKhDSeisanTuibaraiBean);

        if (C_YouhiKbn.YOU.eq(pKhDSeisanTuibaraiBean.getTuutisakuseiyouhikbn())) {

            creatTtdkKanryouTuuti(pKhDSeisanTuibaraiBean);
        }

        if (C_YouhiKbn.YOU.eq(pKhDSeisanTuibaraiBean.getShrtysykurikosiyouhi())) {

            creatDSeisanShrTysySyusei(pKhDSeisanTuibaraiBean, pMultipleEntityInserter);
        }

        creatToukeiJouhou(pKhDSeisanTuibaraiBean, pMultipleEntityInserter);

        haitoukinTuibaraiHatuseiKensuu++;

    }

    private void updateKhTtdkRireki(String pSyoNo, C_UmuKbn pUmuKbn) {

        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);
        EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);

        editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
        editTtdkRirekiTblParam.setSyoNo(pSyoNo);
        editTtdkRirekiTblParam.setSyoriYmd(syoriYmd);
        editTtdkRirekiTblParam.setShrSyousaiUmu(pUmuKbn);
        editTtdkRirekiTblParam.setSysTime(BizDate.getSysDateTimeMilli());
        editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.HUYOU);
        editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);
    }

    private void updateKykKihon(String pSyoNo) {

        kykKihon = hozenDomManager.getKykKihon(pSyoNo);

        khozenCommonParam.setSikibetuKey(null);
        khozenCommonParam.getSikibetuKey(pSyoNo);

        kykKihon.setSyhenkouymd(syoriYmd);
        kykKihon.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
        kykKihon.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
        kykKihon.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
    }

    private void creatDenpyouJouhou(KhDSeisanTuibaraiBean pKhDSeisanTuibaraiBean, MultipleEntityInserter pMultipleEntityInserter) {

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        TaisyouGkBean taisyouGkBeanHaitoukin = SWAKInjector.getInstance(TaisyouGkBean.class);
        TaisyouGkBean taisyouGkBeanGstsgk = SWAKInjector.getInstance(TaisyouGkBean.class);
        TaisyouGkBean taisyouGkBeanShrgk = SWAKInjector.getInstance(TaisyouGkBean.class);
        List<TaisyouGkBean> taisyouGkBeanList = new ArrayList<>();
        CommonSiwakeInBean commonSiwakeInBean = SWAKInjector.getInstance(CommonSiwakeInBean.class);
        CommonSiwake commonSiwake = SWAKInjector.getInstance(CommonSiwake.class);
        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = SWAKInjector.getInstance(BzDenpyouDataTourokuBean.class);
        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
        C_UmuKbn gstszeigkUmuKbn = C_UmuKbn.NONE;


        CurrencyType syuCurrencyType = henkanTuuka.henkanTuukaKbnToType(pKhDSeisanTuibaraiBean.getKyktuukasyu());

        taisyouGkBeanHaitoukin.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_D);
        taisyouGkBeanHaitoukin.setTaisyouGk(pKhDSeisanTuibaraiBean.getShrtuukasonotashrkngk().add(
            pKhDSeisanTuibaraiBean.getShrtuukashrtienrsk()));
        taisyouGkBeanHaitoukin.setKeiyakutuukaGk(BizCurrency.valueOf(0, syuCurrencyType));
        taisyouGkBeanList.add(taisyouGkBeanHaitoukin);

        taisyouGkBeanGstsgk.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.GENSENTYOUSYU);
        taisyouGkBeanGstsgk.setTaisyouGk(pKhDSeisanTuibaraiBean.getShrtuukagstszeigk());
        taisyouGkBeanGstsgk.setKeiyakutuukaGk(BizCurrency.valueOf(0, syuCurrencyType));
        taisyouGkBeanList.add(taisyouGkBeanGstsgk);

        taisyouGkBeanShrgk.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRGK);
        taisyouGkBeanShrgk.setTaisyouGk(pKhDSeisanTuibaraiBean.getShrtuukashrgkgoukei());
        taisyouGkBeanShrgk.setKeiyakutuukaGk(BizCurrency.valueOf(0, syuCurrencyType));
        taisyouGkBeanList.add(taisyouGkBeanShrgk);

        if (C_UmuKbn.ARI.eq(pKhDSeisanTuibaraiBean.getGsbunritaisyou())) {

            gstszeigkUmuKbn = C_UmuKbn.ARI;
        }

        commonSiwakeInBean.setKinouId(khozenCommonParam.getFunctionId());
        commonSiwakeInBean.setDenYmd(pKhDSeisanTuibaraiBean.getShrymd());
        commonSiwakeInBean.setTuukasyu(pKhDSeisanTuibaraiBean.getShrtuukasyu());
        commonSiwakeInBean.setSyoriYmd(syoriYmd);
        commonSiwakeInBean.setKykYmd(pKhDSeisanTuibaraiBean.getKykymd());
        commonSiwakeInBean.setSyouhnCd(pKhDSeisanTuibaraiBean.getSyouhncd());
        commonSiwakeInBean.setSyouhnsdNo(pKhDSeisanTuibaraiBean.getSyouhnsdno());
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.BLNK);
        commonSiwakeInBean.setShrhousiteiKbn(pKhDSeisanTuibaraiBean.getShrhousiteikbn());
        commonSiwakeInBean.setKyktuukaSyu(pKhDSeisanTuibaraiBean.getKyktuukasyu());
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.ZERO);
        commonSiwakeInBean.setGstszeigkUmuKbn(gstszeigkUmuKbn);
        commonSiwakeInBean.setAzukarikinUmuKbn(C_UmuKbn.NONE);
        commonSiwakeInBean.setHaitoukinTuibaraiHanteiKbn(pKhDSeisanTuibaraiBean.getDseisantetudukimeikbn());
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanList);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        boolean ibKakokawaserateshiteiFlg = true;
        BizDate ibKakokawaserateshiteiYmd = pKhDSeisanTuibaraiBean.getSyoruiukeymd();

        if (C_Tuukasyu.JPY.eq(pKhDSeisanTuibaraiBean.getShrtuukasyu())) {

            ibKakokawaserateshiteiFlg = false;
            ibKakokawaserateshiteiYmd = null;

        }

        bzDenpyouDataTourokuBean.setIbSyono(pKhDSeisanTuibaraiBean.getSyono());
        bzDenpyouDataTourokuBean.setIbHuridenatesakicd(commonSiwakeOutBean.getHuridenatesakiCd());
        bzDenpyouDataTourokuBean.setIbTantocd(commonSiwakeOutBean.getTantoCd());
        bzDenpyouDataTourokuBean.setIbDenymd(commonSiwakeOutBean.getDenyMd());
        bzDenpyouDataTourokuBean.setIbTuukasyu(commonSiwakeOutBean.getTuukasyu());
        bzDenpyouDataTourokuBean.setIbHuridenskskbn(commonSiwakeOutBean.getHuridensksKbn());
        bzDenpyouDataTourokuBean.setIbDenhnknhoukbn(commonSiwakeOutBean.getDenhnknhouKbn());
        bzDenpyouDataTourokuBean.setIbDenshrhoukbn(commonSiwakeOutBean.getDenshrhouKbn());
        bzDenpyouDataTourokuBean.setIbSyoriymd(commonSiwakeOutBean.getSyoriYmd());
        bzDenpyouDataTourokuBean.setIbSyoricd(commonSiwakeOutBean.getSyoriCd());
        bzDenpyouDataTourokuBean.setIbSyorisosikicd(commonSiwakeOutBean.getHuridenatesakiCd() + "0000");
        bzDenpyouDataTourokuBean.setIbKyktuukasyu(pKhDSeisanTuibaraiBean.getKyktuukasyu());
        bzDenpyouDataTourokuBean.setIbGyoumuKousinsyaId(khozenCommonParam.getUserID());
        bzDenpyouDataTourokuBean.setIbKakokawaserateshiteiflg(ibKakokawaserateshiteiFlg);
        bzDenpyouDataTourokuBean.setIbKakokawaserateshiteiymd(ibKakokawaserateshiteiYmd);
        bzDenpyouDataTourokuBean.setIbShrhousiteiKbn(pKhDSeisanTuibaraiBean.getShrhousiteikbn());
        bzDenpyouDataTourokuBean.setIbSyouhncd(pKhDSeisanTuibaraiBean.getSyouhncd());
        bzDenpyouDataTourokuBean.setIbSyouhnsdno(pKhDSeisanTuibaraiBean.getSyouhnsdno());
        bzDenpyouDataTourokuBean.setBzSiwakeMeisaiBeanList(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst());

        List<IT_KhDenpyoData> khDenpyoDataList = bzDenpyouDataSks.execKh(bzDenpyouDataTourokuBean);
        for (IT_KhDenpyoData KhDenpyoData : khDenpyoDataList) {

            pMultipleEntityInserter.add(KhDenpyoData);
        }
        denrenNo = khDenpyoDataList.get(0).getDenrenno();
        String dengyoumuCd = khDenpyoDataList.get(0).getDengyoumucd();


        if (C_InputShrhousiteiKbn.FBSOUKIN.eq(pKhDSeisanTuibaraiBean.getInputshrhousiteikbn())) {
            if (C_Tuukasyu.JPY.eq(pKhDSeisanTuibaraiBean.getShrtuukasyu())) {
                BzFbSoukinDataSksBean bzFbSoukinDataSksBean = SWAKInjector.getInstance(BzFbSoukinDataSksBean.class);
                BzFbSoukinDataSks bzFbSoukinDataSks = SWAKInjector.getInstance(BzFbSoukinDataSks.class);
                bzFbSoukinDataSksBean.setDenbyouyouDataRenbon(denrenNo);
                bzFbSoukinDataSksBean.setEdaNo(bzDenpyouDataSks.getEdano());
                bzFbSoukinDataSksBean.setDenSysKbn(commonSiwakeOutBean.getDensysKbn());
                bzFbSoukinDataSksBean.setSyoriCd(commonSiwakeOutBean.getSyoriCd());
                bzFbSoukinDataSksBean.setSyoriSosikiCd(commonSiwakeOutBean.getHuridenatesakiCd() + "0000");
                bzFbSoukinDataSksBean.setSyoriYmd(commonSiwakeOutBean.getSyoriYmd());
                bzFbSoukinDataSksBean.setDenYmd(commonSiwakeOutBean.getDenyMd());
                bzFbSoukinDataSksBean.setSyoNo(pKhDSeisanTuibaraiBean.getSyono());
                bzFbSoukinDataSksBean.setShrHouSiteiKbn(pKhDSeisanTuibaraiBean.getShrhousiteikbn());
                bzFbSoukinDataSksBean.setBankCd(pKhDSeisanTuibaraiBean.getBankcd());
                bzFbSoukinDataSksBean.setSitenCd(pKhDSeisanTuibaraiBean.getSitencd());
                bzFbSoukinDataSksBean.setYokinKbn(pKhDSeisanTuibaraiBean.getYokinkbn());
                bzFbSoukinDataSksBean.setKouzaNo(pKhDSeisanTuibaraiBean.getKouzano());
                bzFbSoukinDataSksBean.setKzMeigiNmKn(pKhDSeisanTuibaraiBean.getKzmeiginmkn());
                bzFbSoukinDataSksBean.setSouKingk(pKhDSeisanTuibaraiBean.getYenshrgkgoukei());
                bzFbSoukinDataSksBean.setKykTuukasyu(pKhDSeisanTuibaraiBean.getKyktuukasyu());
                bzFbSoukinDataSksBean.setGaikaTaikagk(BizCurrency.valueOf(0));
                bzFbSoukinDataSksBean.setSoukinKwsRate(BizNumber.ZERO);
                bzFbSoukinDataSksBean.setKinouId(khozenCommonParam.getFunctionId());
                bzFbSoukinDataSksBean.setUserId(khozenCommonParam.getUserID());
                bzFbSoukinDataSksBean.setDengyoumuCd(dengyoumuCd);

                IT_KhFBSoukinData khFBSoukinData = bzFbSoukinDataSks.execKh(bzFbSoukinDataSksBean);
                pMultipleEntityInserter.add(khFBSoukinData);
            }

            else {

                BzGkfbSoukinDataSks bzGkfbSoukinDataSks = SWAKInjector.getInstance(BzGkfbSoukinDataSks.class);
                BzGkfbSoukinDataSksBean bzGkfbSoukinDataSksBean = SWAKInjector.getInstance(BzGkfbSoukinDataSksBean.class);
                BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);

                BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(pKhDSeisanTuibaraiBean.getBankcd(),
                    pKhDSeisanTuibaraiBean.getSitencd());
                String kzMeigiNmEi = ConvertUtil.toHanAll(pKhDSeisanTuibaraiBean.getKzmeiginmkn(), 0, 0);

                bzGkfbSoukinDataSksBean.setDenRenno(denrenNo);
                bzGkfbSoukinDataSksBean.setEdaNo(bzDenpyouDataSks.getEdano());
                bzGkfbSoukinDataSksBean.setDenSysKbn(C_DensysKbn.HOZEN);
                bzGkfbSoukinDataSksBean.setSyoriCd(commonSiwakeOutBean.getSyoriCd());
                bzGkfbSoukinDataSksBean.setSyoriSosikiCd(commonSiwakeOutBean.getHuridenatesakiCd() + "0000");
                bzGkfbSoukinDataSksBean.setSyoriYmd(commonSiwakeOutBean.getSyoriYmd());
                bzGkfbSoukinDataSksBean.setDenYmd(commonSiwakeOutBean.getDenyMd());
                bzGkfbSoukinDataSksBean.setSyono(pKhDSeisanTuibaraiBean.getSyono());
                bzGkfbSoukinDataSksBean.setShrHouSiteiKbn(pKhDSeisanTuibaraiBean.getShrhousiteikbn());
                bzGkfbSoukinDataSksBean.setBankCd(pKhDSeisanTuibaraiBean.getBankcd());
                bzGkfbSoukinDataSksBean.setBankNmEj(bzGetBankDataBean.getBankNmEj());
                bzGkfbSoukinDataSksBean.setSitenCd(pKhDSeisanTuibaraiBean.getSitencd());
                bzGkfbSoukinDataSksBean.setSitenNmEj(bzGetBankDataBean.getSitenNmEj());
                bzGkfbSoukinDataSksBean.setKouzaNo(pKhDSeisanTuibaraiBean.getKouzano());
                bzGkfbSoukinDataSksBean.setKzMeigiNmEi(kzMeigiNmEi);
                bzGkfbSoukinDataSksBean.setShrTuukaSyu(pKhDSeisanTuibaraiBean.getKyktuukasyu());
                bzGkfbSoukinDataSksBean.setGaikaShrgk(pKhDSeisanTuibaraiBean.getShrtuukashrgkgoukei());
                bzGkfbSoukinDataSksBean.setKykTuukaSyu(pKhDSeisanTuibaraiBean.getKyktuukasyu());
                bzGkfbSoukinDataSksBean.setCrossRateShrgk(BizCurrency.valueOf(0));
                bzGkfbSoukinDataSksBean.setSoukinKwsRate(BizNumber.ZERO);
                bzGkfbSoukinDataSksBean.setKinouId(khozenCommonParam.getFunctionId());
                bzGkfbSoukinDataSksBean.setUserId(khozenCommonParam.getUserID());
                bzGkfbSoukinDataSksBean.setDengyoumuCd(dengyoumuCd);

                IT_KhGaikaFBSoukinData khGaikaFBSoukinData = bzGkfbSoukinDataSks.execKh(bzGkfbSoukinDataSksBean);
                pMultipleEntityInserter.add(khGaikaFBSoukinData);

            }
        }
    }

    private void creatKhShrRireki(KhDSeisanTuibaraiBean pKhDSeisanTuibaraiBean) {

        IT_KhShrRireki khShrRireki = khTtdkRireki.createKhShrRireki();

        khShrRireki.setShrymd(pKhDSeisanTuibaraiBean.getShrymd());
        khShrRireki.setShrsyoriymd(syoriYmd);
        khShrRireki.setShrsyorikbn(C_ShrsyoriKbn.DSEISANTUIBARAI);
        khShrRireki.setKouryokuhasseiymd(pKhDSeisanTuibaraiBean.getKouryokuhasseiymd());
        khShrRireki.setShrtienrskkisanymd(pKhDSeisanTuibaraiBean.getShrtienrskkisanymd());
        khShrRireki.setTienrsknissuu(pKhDSeisanTuibaraiBean.getTienrsknissuu());
        khShrRireki.setSinsagendokknkbn(C_SinsaGendoKknKbn.BLNK);
        khShrRireki.setZeitratkikbn(C_ZeitratkiKbn.BLNK);
        khShrRireki.setGsbunritaisyou(pKhDSeisanTuibaraiBean.getGsbunritaisyou());
        khShrRireki.setYenshrtkumu(pKhDSeisanTuibaraiBean.getYenshrtkumu());
        khShrRireki.setKyktuukasyu(pKhDSeisanTuibaraiBean.getKyktuukasyu());
        khShrRireki.setSyushrgkkeisyukbn(C_SyuShrgkSyoukeiKbn.D);
        khShrRireki.setSyushrgkkei(pKhDSeisanTuibaraiBean.getShrtuukasonotashrkngk());
        khShrRireki.setShrtuukasyu(pKhDSeisanTuibaraiBean.getShrtuukasyu());
        khShrRireki.setShrtuukashrgkgoukei(pKhDSeisanTuibaraiBean.getShrtuukashrgkgoukei());
        khShrRireki.setShrtuukasyushrgkkei(pKhDSeisanTuibaraiBean.getShrtuukasonotashrkngk());
        khShrRireki.setShrtuukagstszeigk(pKhDSeisanTuibaraiBean.getShrtuukagstszeigk());
        khShrRireki.setShrtuukashrtienrsk(pKhDSeisanTuibaraiBean.getShrtuukashrtienrsk());
        khShrRireki.setYenshrgkgoukei(pKhDSeisanTuibaraiBean.getYenshrgkgoukei());
        khShrRireki.setYensyushrgkkei(pKhDSeisanTuibaraiBean.getSonotashrkngkyen());
        khShrRireki.setYenkansanhaitoukin(pKhDSeisanTuibaraiBean.getYenkansanhaitoukin());
        khShrRireki.setYengstszeigk(pKhDSeisanTuibaraiBean.getYengstszeigk());
        khShrRireki.setYengstszeigknationaltax(pKhDSeisanTuibaraiBean.getYengstszeigknationaltax());
        khShrRireki.setYengstszeigklocaltax(pKhDSeisanTuibaraiBean.getYengstszeigklocaltax());
        khShrRireki.setNztodouhukencd(pKhDSeisanTuibaraiBean.getNztodouhukencd());
        khShrRireki.setYenshrtienrsk(pKhDSeisanTuibaraiBean.getYenshrtienrsk());
        khShrRireki.setYenhtykeihi(pKhDSeisanTuibaraiBean.getYenhtykeihi());
        khShrRireki.setYenkztgk(pKhDSeisanTuibaraiBean.getYenkztgk());
        khShrRireki.setZeimukwsratekjnymd(pKhDSeisanTuibaraiBean.getZeimukwsratekjnymd());
        khShrRireki.setZeimukwsrate(pKhDSeisanTuibaraiBean.getZeimukwsrate());
        khShrRireki.setInputshrhousiteikbn(pKhDSeisanTuibaraiBean.getInputshrhousiteikbn());
        khShrRireki.setShrhousiteikbn(pKhDSeisanTuibaraiBean.getShrhousiteikbn());
        khShrRireki.setKzsyuruikbn(pKhDSeisanTuibaraiBean.getKzsyuruikbn());
        khShrRireki.setBankcd(pKhDSeisanTuibaraiBean.getBankcd());
        khShrRireki.setSitencd(pKhDSeisanTuibaraiBean.getSitencd());
        khShrRireki.setYokinkbn(pKhDSeisanTuibaraiBean.getYokinkbn());
        khShrRireki.setKouzano(pKhDSeisanTuibaraiBean.getKouzano());
        khShrRireki.setKzdoukbn(pKhDSeisanTuibaraiBean.getKzdoukbn());
        khShrRireki.setKzmeiginmkn(pKhDSeisanTuibaraiBean.getKzmeiginmkn());
        khShrRireki.setDenrenno(denrenNo);
        khShrRireki.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
        khShrRireki.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
        khShrRireki.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
        khShrRireki.setYenshrkykhtykeihi(pKhDSeisanTuibaraiBean.getYenshrkykhtykeihi());
        khShrRireki.setKykhnkkaisuu(pKhDSeisanTuibaraiBean.getKykhnkkaisuu());
        khShrRireki.setYensonotahaitoukin(pKhDSeisanTuibaraiBean.getYensonotahaitoukin());
        khShrRireki.setGaikashrkwsratekjnymd(pKhDSeisanTuibaraiBean.getGaikashrkwsratekjnymd());
        khShrRireki.setGaikashrkwsrate(pKhDSeisanTuibaraiBean.getGaikashrkwsrate());
        khShrRireki.setSonotashrkngksiteituuka(pKhDSeisanTuibaraiBean.getSonotashrkngksiteituuka());
        khShrRireki.setShrtuukasonotashrkngk(pKhDSeisanTuibaraiBean.getShrtuukasonotashrkngk());
        khShrRireki.setSonotashrkngkyen(pKhDSeisanTuibaraiBean.getSonotashrkngkyen());
        khShrRireki.setYensynykngk(pKhDSeisanTuibaraiBean.getYensynykngk());
        khShrRireki.setShrtysykurikosiyouhi(pKhDSeisanTuibaraiBean.getShrtysykurikosiyouhi());

        BizPropertyInitializer.initialize(khShrRireki);

    }

    private void creatTtdkKanryouTuuti(KhDSeisanTuibaraiBean pKhDSeisanTuibaraiBean) {

        EditTtdkKanryouParam editTtdkKanryouParam = SWAKInjector.getInstance(EditTtdkKanryouParam.class);
        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        C_SyoruiCdKbn syoruiCd = null;

        if (C_UmuKbn.ARI.eq(pKhDSeisanTuibaraiBean.getGsbunritaisyou()) &&
            pKhDSeisanTuibaraiBean.getYengstszeigk().compareTo(
                BizCurrency.valueOf(0, pKhDSeisanTuibaraiBean.getYengstszeigk().getType())) > 0) {

            syoruiCd = C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR_ZEIMUNASI;
        }
        else if ((C_UmuKbn.ARI.eq(pKhDSeisanTuibaraiBean.getGsbunritaisyou()) &&
            pKhDSeisanTuibaraiBean.getYengstszeigk().compareTo(
                BizCurrency.valueOf(0, pKhDSeisanTuibaraiBean.getYengstszeigk().getType())) == 0) ||
                C_UmuKbn.NONE.eq(pKhDSeisanTuibaraiBean.getGsbunritaisyou())) {

            syoruiCd = C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR;
        }

        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.DTUIBARAI);
        editTtdkKanryouParam.setSyoruiCdKbn(syoruiCd);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setKaiyakuJiyuu(pKhDSeisanTuibaraiBean.getKaiyakujiyuu());
        editTtdkKanryouParam.setShsyno(pKhDSeisanTuibaraiBean.getSoukinsakiyno());
        editTtdkKanryouParam.setShsadr1kj(pKhDSeisanTuibaraiBean.getSoukinsakiadr1kj());
        editTtdkKanryouParam.setShsadr2kj(pKhDSeisanTuibaraiBean.getSoukinsakiadr2kj());
        editTtdkKanryouParam.setShsadr3kj(pKhDSeisanTuibaraiBean.getSoukinsakiadr3kj());
        editTtdkKanryouParam.setShsnmkj(pKhDSeisanTuibaraiBean.getSoukinsakinmkj());
        editTtdkKanryouParam.setDseisantetudukimeiKbn(pKhDSeisanTuibaraiBean.getDseisantetudukimeikbn());
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(pKhDSeisanTuibaraiBean.getDseisansouhusakihnsyukbn());
        editTtdkKanryouParam.setDseisanzeitratkiKbn(pKhDSeisanTuibaraiBean.getZeitratkiKbn());

        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);
        khozenTyouhyouCtl.setHassoukbn(C_HassouKbn.HONSYAKAISOU);

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam,
            pKhDSeisanTuibaraiBean.getSyono(),
            new C_SyoruiCdKbn[] { syoruiCd },
            C_YouhiKbn.HUYOU);

    }

    private void creatDSeisanShrTysySyusei(KhDSeisanTuibaraiBean pKhDSeisanTuibaraiBean, MultipleEntityInserter pMultipleEntityInserter) {

        IT_DSeisanShrTysySyusei dSeisanShrTysySyusei = new IT_DSeisanShrTysySyusei(pKhDSeisanTuibaraiBean.getSyono(),
            syoriYmd);

        dSeisanShrTysySyusei.setSeisandshrymd(pKhDSeisanTuibaraiBean.getShrymd());
        dSeisanShrTysySyusei.setSeisand(pKhDSeisanTuibaraiBean.getSonotashrkngkyen());
        dSeisanShrTysySyusei.setTyouseid(BizCurrency.valueOf(0));
        dSeisanShrTysySyusei.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
        dSeisanShrTysySyusei.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
        dSeisanShrTysySyusei.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        BizPropertyInitializer.initialize(dSeisanShrTysySyusei);

        pMultipleEntityInserter.add(dSeisanShrTysySyusei);
        dSeisanShrTysySyuseiTBLOutKensuu++;
    }

    private void creatToukeiJouhou(KhDSeisanTuibaraiBean pKhDSeisanTuibaraiBean, MultipleEntityInserter pMultipleEntityInserter) {

    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }
}
