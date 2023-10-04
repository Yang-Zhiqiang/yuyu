package yuyu.batch.hozen.khansyuu.khkesikomisel;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khansyuu.khkesikomisel.dba.KhKesikomiSelDao;
import yuyu.batch.hozen.khansyuu.khkesikomisel.dba.NyuukinKakusyouDataBean;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.MessageId;
import yuyu.def.classification.C_CreditUriageSeikyuuKbn;
import yuyu.def.classification.C_CreditcardHrKskmKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.db.entity.IT_KhKesikomiData;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 案内収納 消込データ抽出
 */
public class KhKesikomiSelBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private KhKesikomiSelBatchParam khKesikomiSelBatchParam;

    @Inject
    private KhKesikomiSelDao khKesikomiSelDao;

    @Override
    public BatchParam getParam() {
        return khKesikomiSelBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = khKesikomiSelBatchParam.getSyoriYmd();
        String kakutyouJobcd = khKesikomiSelBatchParam.getIbKakutyoujobcd();
        C_Nykkeiro nykkeiro = khKesikomiSelBatchParam.getNykkeiro();
        String heisoukbn = khKesikomiSelBatchParam.getHeisoukbn();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyouJobcd));

        if (nykkeiro == null) {
            batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
                MessageId.IIW3012), null));
        }
        else {
            batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
                MessageId.IIW3012), nykkeiro.getValue()));
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1025, heisoukbn));

        if (nykkeiro == null || C_Nykkeiro.BLNK.eq(nykkeiro) || C_Nykkeiro.KZHRK.eq(nykkeiro) || C_Nykkeiro.CREDIT.eq(nykkeiro) ||
            C_Nykkeiro.BANK.eq(nykkeiro)) {
        }
        else {
            throw new BizAppException(MessageId.EBF0010, MessageUtil.getMessage(MessageId.IIW3012));
        }

        long syoriCnt = 0;
        long syoriCntKouhuri = 0;
        long syoriCntCredit = 0;
        long syoriCntHurikae = 0;
        KhozenCommonParam khCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        String gyoumuKousinkinouID = khCommonParam.getFunctionId();
        String gyoumuKousinsyaId = khCommonParam.getUserID();
        String gyoumuKousinTime = BizDate.getSysDateTimeMilli();

        try (ExDBResults<NyuukinKakusyouDataBean> nyuukinKakusyouDataBeanList = khKesikomiSelDao
            .getNyuukinKakusyouData(syoriYmd, nykkeiro,heisoukbn);
            EntityInserter<IT_KhKesikomiData> entityInserter = new EntityInserter<IT_KhKesikomiData>();) {

            for (NyuukinKakusyouDataBean nyuukinKakusyouDataBean : nyuukinKakusyouDataBeanList) {

                C_CreditcardHrKskmKbn creditcardHrKskmKbn = C_CreditcardHrKskmKbn.BLNK;
                String Kzhurikaebankcd = "";

                if (C_Nykkeiro.CREDIT.eq(nyuukinKakusyouDataBean.getNykkeiro())) {

                    if (C_CreditUriageSeikyuuKbn.TUUJYOU.eq(nyuukinKakusyouDataBean.getCreditUriageSeikyuuKbn())) {

                        creditcardHrKskmKbn = C_CreditcardHrKskmKbn.RAY_TEIREI_URIAGE;
                    }
                    else if (C_CreditUriageSeikyuuKbn.RINJI.eq(nyuukinKakusyouDataBean.getCreditUriageSeikyuuKbn())) {

                        creditcardHrKskmKbn = C_CreditcardHrKskmKbn.RAY_RINJI_URIAGE;
                    }
                }

                if (C_Nykkeiro.KZHRK.eq(nyuukinKakusyouDataBean.getNykkeiro())) {
                    Kzhurikaebankcd = nyuukinKakusyouDataBean.getKzhurikaebankcd();
                }

                IT_KhKesikomiData khKesikomiData = new IT_KhKesikomiData(nyuukinKakusyouDataBean.
                    getNyuukinkakusyouno(), nyuukinKakusyouDataBean.getSyono());

                khKesikomiData.setNyknaiyoukbn(nyuukinKakusyouDataBean.getNyknaiyoukbn());
                khKesikomiData.setNyuuryokukbn(nyuukinKakusyouDataBean.getNyuuryokukbn());
                khKesikomiData.setNykkeiro(nyuukinKakusyouDataBean.getNykkeiro());
                khKesikomiData.setJyuutouym(nyuukinKakusyouDataBean.getJyuutouym());
                khKesikomiData.setNyuukinkakusyounrkymd(nyuukinKakusyouDataBean.getNyuukinkakusyounrkymd());
                khKesikomiData.setRyosyuymd(nyuukinKakusyouDataBean.getRyosyuymd());
                khKesikomiData.setRsgaku(nyuukinKakusyouDataBean.getRsgaku());
                khKesikomiData.setNykdenymd(nyuukinKakusyouDataBean.getNykdenymd());
                khKesikomiData.setNyuukinkakusyounrkno(nyuukinKakusyouDataBean.getNyuukinkakusyounrkno());
                khKesikomiData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                khKesikomiData.setSuitono(nyuukinKakusyouDataBean.getSuitono());
                khKesikomiData.setSuitoubumoncd(nyuukinKakusyouDataBean.getSuitoubumoncd());
                khKesikomiData.setKzhurikaebankcd(Kzhurikaebankcd);
                khKesikomiData.setKarikanjyono(nyuukinKakusyouDataBean.getTabakarikanjyono());
                khKesikomiData.setHrkmyousinkkbn(nyuukinKakusyouDataBean.getHrkmyousinkkbn());
                khKesikomiData.setSuitososhikicd(nyuukinKakusyouDataBean.getSuitososhikicd());
                khKesikomiData.setCreditcardhrkskmkbn(creditcardHrKskmKbn);
                khKesikomiData.setGyoumuKousinKinou(gyoumuKousinkinouID);
                khKesikomiData.setGyoumuKousinsyaId(gyoumuKousinsyaId);
                khKesikomiData.setGyoumuKousinTime(gyoumuKousinTime);
                khKesikomiData.setSyuudaikocd(nyuukinKakusyouDataBean.getSyuudaikocd());

                BizPropertyInitializer.initialize(khKesikomiData);

                khKesikomiSelDao.addInsertEntity(entityInserter, khKesikomiData);

                if (C_Nykkeiro.KZHRK.eq(nyuukinKakusyouDataBean.getNykkeiro())) {
                    syoriCntKouhuri = syoriCntKouhuri + 1;
                }
                else if (C_Nykkeiro.CREDIT.eq(nyuukinKakusyouDataBean.getNykkeiro())) {
                    syoriCntCredit = syoriCntCredit + 1;
                }
                else if (C_Nykkeiro.BANK.eq(nyuukinKakusyouDataBean.getNykkeiro())) {
                    syoriCntHurikae = syoriCntHurikae + 1;
                }
                syoriCnt = syoriCnt + 1;
            }
        }

        if (nykkeiro == null || C_Nykkeiro.BLNK.eq(nykkeiro) || C_Nykkeiro.KZHRK.eq(nykkeiro)) {

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriCntKouhuri), "口振"));
        }
        if (nykkeiro == null || C_Nykkeiro.BLNK.eq(nykkeiro) || C_Nykkeiro.CREDIT.eq(nykkeiro)) {

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriCntCredit), "クレ払"));
        }
        if (nykkeiro == null || C_Nykkeiro.BLNK.eq(nykkeiro) || C_Nykkeiro.BANK.eq(nykkeiro)) {

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriCntHurikae), "振替"));
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriCnt), "合計"));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1026, String.valueOf(heisoukbn)));
    }
}