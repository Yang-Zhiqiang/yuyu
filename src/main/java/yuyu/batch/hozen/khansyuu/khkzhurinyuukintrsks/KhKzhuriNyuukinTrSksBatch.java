package yuyu.batch.hozen.khansyuu.khkzhurinyuukintrsks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khansyuu.khkzhurinyuukintrsks.dba.KhKzhuriNyuukinTrSksDao;
import yuyu.batch.hozen.khansyuu.khkzhurinyuukintrsks.dba.SyuunouKekkaData2Bean;
import yuyu.batch.hozen.khansyuu.khkzhurinyuukintrsks.dba.SyuunouKekkaDataBean;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.SaibanBiz;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.classification.C_Dattaikeiro;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HurihunoKbn;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_KhSyuunouKekkaData;
import yuyu.def.db.entity.IT_TRDattai;
import yuyu.def.db.entity.IT_TRMinyuu;
import yuyu.def.db.entity.IT_TRNyuukin;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 案内収納 口座振替入金ＴＲ作成
 */
public class KhKzhuriNyuukinTrSksBatch implements Batch {

    private int DATARENNO = 1;

    private static final String TABLEID = IT_KhSyuunouKekkaData.TABLE_NAME;

    private static final String FILTERID = "Bz001";

    private String kinouId;

    private String sousasyaCd;

    private String sysDateTimeMilli;

    private BizDate syoriYmd;

    private KhozenCommonParam khozenCommonParam;

    private String kakutyoujobCd;

    private String heisoukbn;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private KhKzhuriNyuukinTrSksBatchParam khKzhuriNyuukinTrSksBatchParam;

    @Inject
    private KhKzhuriNyuukinTrSksDao khKzhuriNyuukinTrSksDao;

    @Override
    public BatchParam getParam() {
        return khKzhuriNyuukinTrSksBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003),
            khKzhuriNyuukinTrSksBatchParam.getSyoriYmd().toString()));

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW1018),
            String.valueOf(khKzhuriNyuukinTrSksBatchParam.getIbKakutyoujobcd())));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1025,
            khKzhuriNyuukinTrSksBatchParam.getHeisoukbn()));

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        kinouId = khozenCommonParam.getFunctionId();
        sousasyaCd = khozenCommonParam.getUserID();
        sysDateTimeMilli = BizDate.getSysDateTimeMilli();
        syoriYmd = khKzhuriNyuukinTrSksBatchParam.getSyoriYmd();
        kakutyoujobCd = khKzhuriNyuukinTrSksBatchParam.getIbKakutyoujobcd();
        heisoukbn = khKzhuriNyuukinTrSksBatchParam.getHeisoukbn();

        updateKhSyuunouKekkaData();

        insertTRNyuukinAndTRMinyuuAndTRDattai();
    }

    private void updateKhSyuunouKekkaData() {

        C_AnsyuusysKbn[] ansyuusysKbns = new C_AnsyuusysKbn[4];
        BizDate[] syoriymds = new BizDate[4];
        String syoNo = "";
        BizDateYM[] jyuutouYm = new BizDateYM[4];
        int[] jyutouKaisuuy = new int[4];
        int[] jyutouKaisuum = new int[4];
        BizCurrency[] rsKingaku = new BizCurrency[4];
        BizDate[] hurikaeYmd = new BizDate[4];
        String[] bankCd = new String[4];
        String[] sitenCd = new String[4];
        C_YokinKbn[] yokinKbn = new C_YokinKbn[4];
        String[] kouzaNo = new String[4];
        C_NyknaiyouKbn[] nykNaiyouKbn = new C_NyknaiyouKbn[4];
        C_HurihunoKbn[] hurihunoKbn = new C_HurihunoKbn[4];
        ArrayList<String> hurihunokbnLst = new ArrayList<>();
        String[] dispSyoNo = new String[4];
        C_Hrkkaisuu[] hrkkaisuu = new C_Hrkkaisuu[4];
        C_Syuudaikocd[] syuudaikoCd = new C_Syuudaikocd[4];

        try (ExDBResults<SyuunouKekkaDataBean> syuunouKekkaDataBeanLst =
            khKzhuriNyuukinTrSksDao.getKhSyuunouKekkaData1(kakutyoujobCd, heisoukbn);

            EntityUpdater<IT_KhSyuunouKekkaData> updater = new EntityUpdater<IT_KhSyuunouKekkaData>();) {

            int count = 0;

            for (SyuunouKekkaDataBean syuunouKekkaDataBean : syuunouKekkaDataBeanLst) {

                List<IT_KhSyuunouKekkaData> khSyuunouKekkaDataLst = new ArrayList<IT_KhSyuunouKekkaData>();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);

                if (!syoNo.equals(syuunouKekkaDataBean.getSyono())) {
                    if (hurihunokbnLst.size() > 1) {
                        bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(syoNo);

                        Collections.sort(hurihunokbnLst);

                        boolean kirikaeKekka = sasikaeJyuutouYm(hurihunokbnLst,
                            jyuutouYm,
                            jyutouKaisuuy,
                            jyutouKaisuum,
                            rsKingaku,
                            hurikaeYmd,
                            bankCd,
                            sitenCd,
                            yokinKbn,
                            kouzaNo,
                            nykNaiyouKbn,
                            hurihunoKbn,
                            hrkkaisuu,
                            syuudaikoCd);

                        if (kirikaeKekka) {
                            for (int i = 0; i < hurihunokbnLst.size(); i++) {

                                IT_KhSyuunouKekkaData editKhSyuunouKekkaData = khKzhuriNyuukinTrSksDao
                                    .getKhSyuunouKekkaData3(ansyuusysKbns[i], syoriymds[i], dispSyoNo[i], jyuutouYm[i]);

                                editKhSyuunouKekkaData.setBankcd(bankCd[i]);
                                editKhSyuunouKekkaData.setSitencd(sitenCd[i]);
                                editKhSyuunouKekkaData.setYokinkbn(yokinKbn[i]);
                                editKhSyuunouKekkaData.setKouzano(kouzaNo[i]);
                                editKhSyuunouKekkaData.setHurikaeymd(hurikaeYmd[i]);
                                editKhSyuunouKekkaData.setRsgaku(rsKingaku[i]);
                                editKhSyuunouKekkaData.setJyutoukaisuuy(jyutouKaisuuy[i]);
                                editKhSyuunouKekkaData.setJyutoukaisuum(jyutouKaisuum[i]);
                                editKhSyuunouKekkaData.setNyknaiyoukbn(nykNaiyouKbn[i]);
                                editKhSyuunouKekkaData.setHrkkaisuu(hrkkaisuu[i]);
                                editKhSyuunouKekkaData.setHurihunokbn(hurihunoKbn[i]);
                                editKhSyuunouKekkaData.setGyoumuKousinKinou(kinouId);
                                editKhSyuunouKekkaData.setGyoumuKousinsyaId(sousasyaCd);
                                editKhSyuunouKekkaData.setGyoumuKousinTime(sysDateTimeMilli);
                                editKhSyuunouKekkaData.setSyuudaikocd(syuudaikoCd[i]);

                                khSyuunouKekkaDataLst.add(editKhSyuunouKekkaData);
                            }

                            for (IT_KhSyuunouKekkaData khSyuunouKekkaData : khSyuunouKekkaDataLst) {

                                khKzhuriNyuukinTrSksDao.addUpdateEntity(updater, khSyuunouKekkaData);
                            }
                        }
                    }

                    ansyuusysKbns = new C_AnsyuusysKbn[4];
                    syoriymds = new BizDate[4];
                    syoNo = "";
                    jyuutouYm = new BizDateYM[4];
                    jyutouKaisuuy = new int[4];
                    jyutouKaisuum = new int[4];
                    rsKingaku = new BizCurrency[4];
                    hurikaeYmd = new BizDate[4];
                    bankCd = new String[4];
                    sitenCd = new String[4];
                    yokinKbn = new C_YokinKbn[4];
                    kouzaNo = new String[4];
                    nykNaiyouKbn = new C_NyknaiyouKbn[4];
                    hurihunoKbn = new C_HurihunoKbn[4];
                    hurihunokbnLst = new ArrayList<>();
                    dispSyoNo = new String[4];
                    hrkkaisuu = new C_Hrkkaisuu[4];
                    syuudaikoCd = new C_Syuudaikocd[4];

                    count = 0;
                }

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(syuunouKekkaDataBean.getSyono());

                ansyuusysKbns[count] = syuunouKekkaDataBean.getAnsyuusyskbn();
                syoriymds[count] = syuunouKekkaDataBean.getSyoriymd();
                dispSyoNo[count] = syuunouKekkaDataBean.getSyono();
                jyuutouYm[count] = syuunouKekkaDataBean.getJyuutouym();
                jyutouKaisuuy[count] = syuunouKekkaDataBean.getJyutoukaisuuy();
                jyutouKaisuum[count] = syuunouKekkaDataBean.getJyutoukaisuum();
                rsKingaku[count] = syuunouKekkaDataBean.getRyosyugk();
                hurikaeYmd[count] = syuunouKekkaDataBean.getHurikaeymd();
                bankCd[count] = syuunouKekkaDataBean.getBankcd();
                sitenCd[count] = syuunouKekkaDataBean.getSitencd();
                yokinKbn[count] = syuunouKekkaDataBean.getYokinkbn();
                kouzaNo[count] = syuunouKekkaDataBean.getKouzano();
                nykNaiyouKbn[count] = syuunouKekkaDataBean.getNyknaiyoukbn();
                hurihunoKbn[count] = syuunouKekkaDataBean.getHurihunokbn();
                syoNo = syuunouKekkaDataBean.getSyono();
                hrkkaisuu[count] = syuunouKekkaDataBean.getHrkkaisuu();
                syuudaikoCd[count] = syuunouKekkaDataBean.getSyuudaikocd();

                if (C_HurihunoKbn.SIKINHUSOKU.eq(syuunouKekkaDataBean.getHurihunokbn())) {

                    hurihunokbnLst.add("99");
                }
                else {

                    hurihunokbnLst.add(syuunouKekkaDataBean.getHurihunokbn().getValue());
                }

                count = count + 1;
            }

            if (hurihunokbnLst.size() > 1) {

                Collections.sort(hurihunokbnLst);

                boolean kirikaeKekka = sasikaeJyuutouYm(hurihunokbnLst,
                    jyuutouYm,
                    jyutouKaisuuy,
                    jyutouKaisuum,
                    rsKingaku,
                    hurikaeYmd,
                    bankCd,
                    sitenCd,
                    yokinKbn,
                    kouzaNo,
                    nykNaiyouKbn,
                    hurihunoKbn,
                    hrkkaisuu,
                    syuudaikoCd);

                if (kirikaeKekka) {
                    for (int i = 0; i < hurihunokbnLst.size(); i++) {

                        IT_KhSyuunouKekkaData editKhSyuunouKekkaData = khKzhuriNyuukinTrSksDao.getKhSyuunouKekkaData3(
                            ansyuusysKbns[i], syoriymds[i], dispSyoNo[i], jyuutouYm[i]);

                        editKhSyuunouKekkaData.setBankcd(bankCd[i]);
                        editKhSyuunouKekkaData.setSitencd(sitenCd[i]);
                        editKhSyuunouKekkaData.setYokinkbn(yokinKbn[i]);
                        editKhSyuunouKekkaData.setKouzano(kouzaNo[i]);
                        editKhSyuunouKekkaData.setHurikaeymd(hurikaeYmd[i]);
                        editKhSyuunouKekkaData.setRsgaku(rsKingaku[i]);
                        editKhSyuunouKekkaData.setJyutoukaisuuy(jyutouKaisuuy[i]);
                        editKhSyuunouKekkaData.setJyutoukaisuum(jyutouKaisuum[i]);
                        editKhSyuunouKekkaData.setNyknaiyoukbn(nykNaiyouKbn[i]);
                        editKhSyuunouKekkaData.setHrkkaisuu(hrkkaisuu[i]);
                        editKhSyuunouKekkaData.setHurihunokbn(hurihunoKbn[i]);
                        editKhSyuunouKekkaData.setGyoumuKousinKinou(kinouId);
                        editKhSyuunouKekkaData.setGyoumuKousinsyaId(sousasyaCd);
                        editKhSyuunouKekkaData.setGyoumuKousinTime(sysDateTimeMilli);
                        editKhSyuunouKekkaData.setSyuudaikocd(syuudaikoCd[i]);

                        khKzhuriNyuukinTrSksDao.addUpdateEntity(updater, editKhSyuunouKekkaData);
                    }
                }

            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }
    }

    private void insertTRNyuukinAndTRMinyuuAndTRDattai() {

        int syoriKensuu = 0;
        String syono = null;
        int  syonoRenTRMinyuu = 0;
        int  syonoRenTRDattai = 0;

        try (ExDBResults<SyuunouKekkaData2Bean> syuunouKekkaData2BeanLst =
            khKzhuriNyuukinTrSksDao.getKhSyuunouKekkaData2(kakutyoujobCd, heisoukbn);

            MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();) {

            for (SyuunouKekkaData2Bean syuunouKekkaData2Bean : syuunouKekkaData2BeanLst) {

                IT_TRNyuukin tRNyuukinTemp = null;
                IT_TRMinyuu tRMinyuuTemp = null;
                IT_TRDattai tRDattaiTemp = null;

                if (BizUtil.isBlank(syono) || !syuunouKekkaData2Bean.getSyono().equals(syono)) {
                    syono = syuunouKekkaData2Bean.getSyono();
                    syonoRenTRMinyuu = 1;
                    syonoRenTRDattai = 1;
                }

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(syuunouKekkaData2Bean.getSyono());

                String sikibetuKey = SaibanBiz.getNyukinTRRenban(syoriYmd.toString());

                if (C_HurihunoKbn.BLNK.eq(syuunouKekkaData2Bean.getHurihunokbn())) {

                    tRNyuukinTemp = new IT_TRNyuukin(
                        syuunouKekkaData2Bean.getSyono(), syoriYmd, sikibetuKey, DATARENNO);

                    tRNyuukinTemp.setNykkeiro(syuunouKekkaData2Bean.getNykkeiro());
                    tRNyuukinTemp.setHrkkaisuu(syuunouKekkaData2Bean.getHrkkaisuu());
                    tRNyuukinTemp.setNyknaiyoukbn(syuunouKekkaData2Bean.getNyknaiyoukbn());
                    C_TkiktbrisyuruiKbn tikiktbrisyuruikbn = syuunouKekkaData2Bean.getTikiktbrisyuruikbn();
                    if (C_TkiktbrisyuruiKbn.BLNK .eq(tikiktbrisyuruikbn)  ||
                        C_TkiktbrisyuruiKbn.NONE .eq(tikiktbrisyuruikbn)) {
                        tRNyuukinTemp.setIktnyuukinnumu(C_UmuKbn.NONE);
                    }
                    else if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(tikiktbrisyuruikbn)  ||
                        C_TkiktbrisyuruiKbn.TEIKI_12MONTHS .eq(tikiktbrisyuruikbn)) {
                        tRNyuukinTemp.setIktnyuukinnumu(C_UmuKbn.ARI);
                    }
                    tRNyuukinTemp.setJyuutouym(syuunouKekkaData2Bean.getJyuutouym());
                    tRNyuukinTemp.setJyutoukaisuuy(syuunouKekkaData2Bean.getJyutoukaisuuy());
                    tRNyuukinTemp.setJyutoukaisuum(syuunouKekkaData2Bean.getJyutoukaisuum());
                    tRNyuukinTemp.setRsgaku(syuunouKekkaData2Bean.getRyosyugk());
                    tRNyuukinTemp.setRyosyuymd(syuunouKekkaData2Bean.getHurikaeymd());
                    tRNyuukinTemp.setKzhurikaebankcd(syuunouKekkaData2Bean.getBankcd());
                    tRNyuukinTemp.setKzhurikaesitencd(syuunouKekkaData2Bean.getSitencd());
                    tRNyuukinTemp.setTikiktbrisyuruikbn(syuunouKekkaData2Bean.getTikiktbrisyuruikbn());
                    tRNyuukinTemp.setRstuukasyu(C_Tuukasyu.JPY);
                    tRNyuukinTemp.setGyoumuKousinKinou(kinouId);
                    tRNyuukinTemp.setGyoumuKousinsyaId(sousasyaCd);
                    tRNyuukinTemp.setGyoumuKousinTime(sysDateTimeMilli);
                    tRNyuukinTemp.setSyuudaikocd(syuunouKekkaData2Bean.getSyuudaikocd());

                    BizPropertyInitializer.initialize(tRNyuukinTemp);
                }

                else {
                    tRMinyuuTemp = new IT_TRMinyuu(syuunouKekkaData2Bean.getSyono(), syoriYmd, BizDate.getSysDateTimeMilli() + String.valueOf(syonoRenTRMinyuu));

                    tRMinyuuTemp.setNykkeiro(syuunouKekkaData2Bean.getNykkeiro());
                    tRMinyuuTemp.setNyknaiyoukbn(syuunouKekkaData2Bean.getNyknaiyoukbn());
                    tRMinyuuTemp.setJyuutouym(syuunouKekkaData2Bean.getJyuutouym());
                    tRMinyuuTemp.setJyutoukaisuuy(syuunouKekkaData2Bean.getJyutoukaisuuy());
                    tRMinyuuTemp.setJyutoukaisuum(syuunouKekkaData2Bean.getJyutoukaisuum());
                    tRMinyuuTemp.setRsgaku(syuunouKekkaData2Bean.getRyosyugk());
                    tRMinyuuTemp.setRyosyuymd(syuunouKekkaData2Bean.getHurikaeymd());
                    tRMinyuuTemp.setHurihunokbn(syuunouKekkaData2Bean.getHurihunokbn());
                    tRMinyuuTemp.setBankcd(syuunouKekkaData2Bean.getBankcd());
                    tRMinyuuTemp.setSitencd(syuunouKekkaData2Bean.getSitencd());
                    tRMinyuuTemp.setYokinkbn(syuunouKekkaData2Bean.getYokinkbn());
                    tRMinyuuTemp.setKouzano(syuunouKekkaData2Bean.getKouzano());
                    tRMinyuuTemp.setDantaikobetukbn(syuunouKekkaData2Bean.getDantaikobetukbn());
                    tRMinyuuTemp.setHrkkaisuu(syuunouKekkaData2Bean.getHrkkaisuu());
                    tRMinyuuTemp.setKzhurikaetkbtannaihyj(syuunouKekkaData2Bean.getKzhurikaetkbtannaihyj());
                    tRMinyuuTemp.setTikiktbrisyuruikbn(syuunouKekkaData2Bean.getTikiktbrisyuruikbn());
                    tRMinyuuTemp.setGyoumuKousinKinou(kinouId);
                    tRMinyuuTemp.setGyoumuKousinsyaId(sousasyaCd);
                    tRMinyuuTemp.setGyoumuKousinTime(sysDateTimeMilli);

                    BizPropertyInitializer.initialize(tRMinyuuTemp);

                    syonoRenTRMinyuu++;
                }

                if (C_HurihunoKbn.NOKOZA.eq(syuunouKekkaData2Bean.getHurihunokbn()) ||
                    C_HurihunoKbn.OTHER.eq(syuunouKekkaData2Bean.getHurihunokbn())) {

                    tRDattaiTemp = new IT_TRDattai(syuunouKekkaData2Bean.getSyono(), syoriYmd, BizDate.getSysDateTimeMilli() + String.valueOf(syonoRenTRDattai));

                    tRDattaiTemp.setDattaikeiro(C_Dattaikeiro.KOUHURI);
                    tRDattaiTemp.setSyuudaikocd(C_Syuudaikocd.BLNK);
                    tRDattaiTemp.setBankcd(syuunouKekkaData2Bean.getBankcd());
                    tRDattaiTemp.setSitencd(syuunouKekkaData2Bean.getSitencd());
                    tRDattaiTemp.setYokinkbn(syuunouKekkaData2Bean.getYokinkbn());
                    tRDattaiTemp.setKouzano(syuunouKekkaData2Bean.getKouzano());
                    tRDattaiTemp.setHurihunokbn(syuunouKekkaData2Bean.getHurihunokbn());
                    tRDattaiTemp.setHurikaeymd(syuunouKekkaData2Bean.getHurikaeymd());
                    tRDattaiTemp.setDattaiym(syuunouKekkaData2Bean.getJyuutouym());
                    tRDattaiTemp.setNykkeiro(syuunouKekkaData2Bean.getNykkeiro());
                    tRDattaiTemp.setNyknaiyoukbn(syuunouKekkaData2Bean.getNyknaiyoukbn());
                    tRDattaiTemp.setJyutoukaisuuy(syuunouKekkaData2Bean.getJyutoukaisuuy());
                    tRDattaiTemp.setJyutoukaisuum(syuunouKekkaData2Bean.getJyutoukaisuum());
                    tRDattaiTemp.setTikiktbrisyuruikbn(syuunouKekkaData2Bean.getTikiktbrisyuruikbn());
                    tRDattaiTemp.setGyoumuKousinKinou(kinouId);
                    tRDattaiTemp.setGyoumuKousinsyaId(sousasyaCd);
                    tRDattaiTemp.setGyoumuKousinTime(sysDateTimeMilli);

                    BizPropertyInitializer.initialize(tRDattaiTemp);

                    syonoRenTRDattai++;
                }

                syoriKensuu = syoriKensuu + 1;

                if (tRNyuukinTemp != null) {

                    khKzhuriNyuukinTrSksDao.addMultipleInsertEntity(multipleEntityInserter, tRNyuukinTemp);
                }

                if (tRMinyuuTemp != null) {

                    khKzhuriNyuukinTrSksDao.addMultipleInsertEntity(multipleEntityInserter, tRMinyuuTemp);
                }

                if (tRDattaiTemp != null) {

                    khKzhuriNyuukinTrSksDao.addMultipleInsertEntity(multipleEntityInserter, tRDattaiTemp);
                }
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1026, heisoukbn));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    private boolean sasikaeJyuutouYm(ArrayList<String> pHurihunokbnLst,
        BizDateYM[] pJyuutouyms,
        int[] pJyutoukaisuuys,
        int[] pJyutoukaisuums,
        BizCurrency[] pRsgakus,
        BizDate[] pHurikaeymds,
        String[] pBankcds,
        String[] pSitencds,
        C_YokinKbn[] pYokinkbns,
        String[] pKouzanos,
        C_NyknaiyouKbn[] pNyknaiyoukbns,
        C_HurihunoKbn[] pHurihunokbns,
        C_Hrkkaisuu[] pHrkkaisuus,
        C_Syuudaikocd[] pSyuudaikocd) {

        if (pHurihunokbnLst.size() <= 1) {
            return false;
        }

        if (pHurihunokbnLst.size() == 2) {

            if (C_HurihunoKbn.BLNK.eq(pHurihunokbns[0])) {
                return false;
            }

            if (!C_HurihunoKbn.BLNK.eq(pHurihunokbns[0]) &&
                !C_HurihunoKbn.BLNK.eq(pHurihunokbns[1])) {
                return false;
            }

            if (!pHurihunokbns[0].getValue().equals(pHurihunokbnLst.get(0))) {

                Integer jyutouKaisuuY = pJyutoukaisuuys[1];
                Integer JyutouKaisuuM = pJyutoukaisuums[1];
                BizCurrency rsGaku = pRsgakus[1];
                BizDate hurikaeYmd = pHurikaeymds[1];
                String bankCd = pBankcds[1];
                String sitenCd = pSitencds[1];
                C_YokinKbn yokinKbn = pYokinkbns[1];
                String kouzaNo = pKouzanos[1];
                C_NyknaiyouKbn nykNaiyouKbn = pNyknaiyoukbns[1];
                C_HurihunoKbn huriHunoKbn = pHurihunokbns[1];
                C_Hrkkaisuu hrkkaisuu = pHrkkaisuus[1];
                C_Syuudaikocd syuudaikoCd = pSyuudaikocd[1];

                pJyutoukaisuuys[1] = pJyutoukaisuuys[0];
                pJyutoukaisuums[1] = pJyutoukaisuums[0];
                pRsgakus[1] = pRsgakus[0];
                pHurikaeymds[1] = pHurikaeymds[0];
                pBankcds[1] = pBankcds[0];
                pSitencds[1] = pSitencds[0];
                pYokinkbns[1] = pYokinkbns[0];
                pKouzanos[1] = pKouzanos[0];
                pNyknaiyoukbns[1] = pNyknaiyoukbns[0];
                pHurihunokbns[1] = pHurihunokbns[0];
                pHrkkaisuus[1] = pHrkkaisuus[0];
                pSyuudaikocd[1] = pSyuudaikocd[0];

                pJyutoukaisuuys[0] = jyutouKaisuuY;
                pJyutoukaisuums[0] = JyutouKaisuuM;
                pRsgakus[0] = rsGaku;
                pHurikaeymds[0] = hurikaeYmd;
                pBankcds[0] = bankCd;
                pSitencds[0] = sitenCd;
                pYokinkbns[0] = yokinKbn;
                pKouzanos[0] = kouzaNo;
                pNyknaiyoukbns[0] = nykNaiyouKbn;
                pHurihunokbns[0] = huriHunoKbn;
                pHrkkaisuus[0] = hrkkaisuu;
                pSyuudaikocd[0] = syuudaikoCd;

                return true;
            }
        }
        else {
            if (C_HurihunoKbn.BLNK.eq(pHurihunokbns[0]) &&
                C_HurihunoKbn.BLNK.eq(pHurihunokbns[1])) {
                return false;
            }

            if (!C_HurihunoKbn.BLNK.eq(pHurihunokbns[0]) &&
                !C_HurihunoKbn.BLNK.eq(pHurihunokbns[1]) &&
                !C_HurihunoKbn.BLNK.eq(pHurihunokbns[2])) {
                return false;
            }

            if (C_HurihunoKbn.BLNK.eq(pHurihunokbns[0]) &&
                !C_HurihunoKbn.BLNK.eq(pHurihunokbns[1]) &&
                !C_HurihunoKbn.BLNK.eq(pHurihunokbns[2])) {
                return false;
            }

            String[] hanteiHurihunoKbns = new String[3];

            if (C_HurihunoKbn.SIKINHUSOKU.eq(pHurihunokbns[0])) {
                hanteiHurihunoKbns[0] = "99";
            }
            else {
                hanteiHurihunoKbns[0] = pHurihunokbns[0].getValue();
            }

            if (C_HurihunoKbn.SIKINHUSOKU.eq(pHurihunokbns[1])) {
                hanteiHurihunoKbns[1] = "99";
            }
            else {
                hanteiHurihunoKbns[1] = pHurihunokbns[1].getValue();
            }

            if (C_HurihunoKbn.SIKINHUSOKU.eq(pHurihunokbns[2])) {
                hanteiHurihunoKbns[2] = "99";
            }
            else {
                hanteiHurihunoKbns[2] = pHurihunokbns[2].getValue();
            }

            if (!hanteiHurihunoKbns[0].equals(pHurihunokbnLst.get(0)) &&
                !hanteiHurihunoKbns[1].equals(pHurihunokbnLst.get(1))) {
                Integer jyutouKaisuuY = pJyutoukaisuuys[1];
                Integer JyutouKaisuuM = pJyutoukaisuums[1];
                BizCurrency rsGaku = pRsgakus[1];
                BizDate hurikaeYmd = pHurikaeymds[1];
                String bankCd = pBankcds[1];
                String sitenCd = pSitencds[1];
                C_YokinKbn yokinKbn = pYokinkbns[1];
                String kouzaNo = pKouzanos[1];
                C_NyknaiyouKbn nykNaiyouKbn = pNyknaiyoukbns[1];
                C_HurihunoKbn huriHunoKbn = pHurihunokbns[1];
                C_Hrkkaisuu hrkkaisuu = pHrkkaisuus[1];
                C_Syuudaikocd syuudaikoCd = pSyuudaikocd[1];
                String hanteiHurihunoKbn = hanteiHurihunoKbns[1];

                pJyutoukaisuuys[1] = pJyutoukaisuuys[0];
                pJyutoukaisuums[1] = pJyutoukaisuums[0];
                pRsgakus[1] = pRsgakus[0];
                pHurikaeymds[1] = pHurikaeymds[0];
                pBankcds[1] = pBankcds[0];
                pSitencds[1] = pSitencds[0];
                pYokinkbns[1] = pYokinkbns[0];
                pKouzanos[1] = pKouzanos[0];
                pNyknaiyoukbns[1] = pNyknaiyoukbns[0];
                pHurihunokbns[1] = pHurihunokbns[0];
                pHrkkaisuus[1] = pHrkkaisuus[0];
                pSyuudaikocd[1] = pSyuudaikocd[0];
                hanteiHurihunoKbns[1] = hanteiHurihunoKbns[0];

                pJyutoukaisuuys[0] = jyutouKaisuuY;
                pJyutoukaisuums[0] = JyutouKaisuuM;
                pRsgakus[0] = rsGaku;
                pHurikaeymds[0] = hurikaeYmd;
                pBankcds[0] = bankCd;
                pSitencds[0] = sitenCd;
                pYokinkbns[0] = yokinKbn;
                pKouzanos[0] = kouzaNo;
                pNyknaiyoukbns[0] = nykNaiyouKbn;
                pHurihunokbns[0] = huriHunoKbn;
                pHrkkaisuus[0] = hrkkaisuu;
                pSyuudaikocd[0] = syuudaikoCd;
                hanteiHurihunoKbns[0] = hanteiHurihunoKbn;
            }

            if (!hanteiHurihunoKbns[1].equals(pHurihunokbnLst.get(1)) &&
                !hanteiHurihunoKbns[2].equals(pHurihunokbnLst.get(2))) {
                Integer jyutouKaisuuY = pJyutoukaisuuys[2];
                Integer JyutouKaisuuM = pJyutoukaisuums[2];
                BizCurrency rsGaku = pRsgakus[2];
                BizDate hurikaeYmd = pHurikaeymds[2];
                String bankCd = pBankcds[2];
                String sitenCd = pSitencds[2];
                C_YokinKbn yokinKbn = pYokinkbns[2];
                String kouzaNo = pKouzanos[2];
                C_NyknaiyouKbn nykNaiyouKbn = pNyknaiyoukbns[2];
                C_HurihunoKbn huriHunoKbn = pHurihunokbns[2];
                C_Hrkkaisuu hrkkaisuu = pHrkkaisuus[2];
                C_Syuudaikocd syuudaikoCd = pSyuudaikocd[2];
                String hanteiHurihunoKbn = hanteiHurihunoKbns[2];

                pJyutoukaisuuys[2] = pJyutoukaisuuys[1];
                pJyutoukaisuums[2] = pJyutoukaisuums[1];
                pRsgakus[2] = pRsgakus[1];
                pHurikaeymds[2] = pHurikaeymds[1];
                pBankcds[2] = pBankcds[1];
                pSitencds[2] = pSitencds[1];
                pYokinkbns[2] = pYokinkbns[1];
                pKouzanos[2] = pKouzanos[1];
                pNyknaiyoukbns[2] = pNyknaiyoukbns[1];
                pHurihunokbns[2] = pHurihunokbns[1];
                pHrkkaisuus[2] = pHrkkaisuus[1];
                pSyuudaikocd[2] = pSyuudaikocd[1];
                hanteiHurihunoKbns[2] = hanteiHurihunoKbns[1];

                pJyutoukaisuuys[1] = jyutouKaisuuY;
                pJyutoukaisuums[1] = JyutouKaisuuM;
                pRsgakus[1] = rsGaku;
                pHurikaeymds[1] = hurikaeYmd;
                pBankcds[1] = bankCd;
                pSitencds[1] = sitenCd;
                pYokinkbns[1] = yokinKbn;
                pKouzanos[1] = kouzaNo;
                pNyknaiyoukbns[1] = nykNaiyouKbn;
                pHurihunokbns[1] = huriHunoKbn;
                pHrkkaisuus[1] = hrkkaisuu;
                pSyuudaikocd[1] = syuudaikoCd;
                hanteiHurihunoKbns[1] = hanteiHurihunoKbn;

            }

            if (!hanteiHurihunoKbns[2].equals(pHurihunokbnLst.get(2)) &&
                !hanteiHurihunoKbns[0].equals(pHurihunokbnLst.get(0))) {
                Integer jyutouKaisuuY = pJyutoukaisuuys[0];
                Integer JyutouKaisuuM = pJyutoukaisuums[0];
                BizCurrency rsGaku = pRsgakus[0];
                BizDate hurikaeYmd = pHurikaeymds[0];
                String bankCd = pBankcds[0];
                String sitenCd = pSitencds[0];
                C_YokinKbn yokinKbn = pYokinkbns[0];
                String kouzaNo = pKouzanos[0];
                C_NyknaiyouKbn nykNaiyouKbn = pNyknaiyoukbns[0];
                C_HurihunoKbn huriHunoKbn = pHurihunokbns[0];
                C_Hrkkaisuu hrkkaisuu = pHrkkaisuus[0];
                C_Syuudaikocd syuudaikoCd = pSyuudaikocd[0];
                String hanteiHurihunoKbn = hanteiHurihunoKbns[0];

                pJyutoukaisuuys[0] = pJyutoukaisuuys[2];
                pJyutoukaisuums[0] = pJyutoukaisuums[2];
                pRsgakus[0] = pRsgakus[2];
                pHurikaeymds[0] = pHurikaeymds[2];
                pBankcds[0] = pBankcds[2];
                pSitencds[0] = pSitencds[2];
                pYokinkbns[0] = pYokinkbns[2];
                pKouzanos[0] = pKouzanos[2];
                pNyknaiyoukbns[0] = pNyknaiyoukbns[2];
                pHurihunokbns[0] = pHurihunokbns[2];
                pHrkkaisuus[0] = pHrkkaisuus[2];
                pSyuudaikocd[0] = pSyuudaikocd[2];
                hanteiHurihunoKbns[0] = hanteiHurihunoKbns[2];

                pJyutoukaisuuys[2] = jyutouKaisuuY;
                pJyutoukaisuums[2] = JyutouKaisuuM;
                pRsgakus[2] = rsGaku;
                pHurikaeymds[2] = hurikaeYmd;
                pBankcds[2] = bankCd;
                pSitencds[2] = sitenCd;
                pYokinkbns[2] = yokinKbn;
                pKouzanos[2] = kouzaNo;
                pNyknaiyoukbns[2] = nykNaiyouKbn;
                pHurihunokbns[2] = huriHunoKbn;
                pHrkkaisuus[2] = hrkkaisuu;
                pSyuudaikocd[2] = syuudaikoCd;
                hanteiHurihunoKbns[2] = hanteiHurihunoKbn;
            }
        }
        return true;
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
