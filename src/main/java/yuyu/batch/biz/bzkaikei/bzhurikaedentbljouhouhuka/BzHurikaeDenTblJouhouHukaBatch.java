package yuyu.batch.biz.bzkaikei.bzhurikaedentbljouhouhuka;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HuridensksKbn;
import yuyu.def.db.entity.BT_HuriDenpyou;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 業務共通 経理･会計 振替伝票テーブル情報付加処理
 */
public class BzHurikaeDenTblJouhouHukaBatch implements Batch {

    private static final String TEKIYOUCD = "";

    private static final String KOUSAIHI_KBN = "0";

    private static final String JIGYOUHI_KMKCD = "41101";

    private static final String TABLEID = "BT_HuriDenpyou";

    private static final String FILTERID = "Bz105";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));

        try (ExDBUpdatableResults<BT_HuriDenpyou> huriDenpyouLst =
            bizDomManager.getHuriDenpyousByKakutyoujobcdSyoriYmdForUpdate(
                bzBatchParam.getIbKakutyoujobcd(), bzBatchParam.getSyoriYmd())) {

            int torihikiIndex = 0;

            String torihikiMoji = "";

            BT_HuriDenpyou maesyoriHuriDenpyou = null;

            String syoriMd = String.valueOf(bzBatchParam.getSyoriYmd().getBizDateMD());

            long syoriKensuu = 0;

            String torihikiBanngo = "";

            for (BT_HuriDenpyou tbHuriDenpyou: huriDenpyouLst) {

                boolean torihikiKasannKeka = false;

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(tbHuriDenpyou.getDensyskbn().getValue());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(tbHuriDenpyou.getDenrenno());

                torihikiKasannKeka = isKasannTorihikino(maesyoriHuriDenpyou, tbHuriDenpyou);

                if (torihikiKasannKeka == true) {

                    torihikiIndex = torihikiIndex + 1;

                    torihikiMoji = Strings.padStart(String.valueOf(torihikiIndex), 3, '0');

                    torihikiBanngo = syoriMd.concat(torihikiMoji);
                }

                tbHuriDenpyou.setTorihikino(torihikiBanngo);

                tbHuriDenpyou.setTekiyoucd(getTekiyoucdSaiban(tbHuriDenpyou));
                tbHuriDenpyou.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                tbHuriDenpyou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                syoriKensuu = syoriKensuu + 1;

                maesyoriHuriDenpyou = tbHuriDenpyou;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
        }
    }

    public boolean isKasannTorihikino(BT_HuriDenpyou pMaeBT_HuriDenpyou, BT_HuriDenpyou pfulikaeBT_HuriDenpyou) {

        boolean torihikiKeka = false;

        if (pMaeBT_HuriDenpyou == null || pfulikaeBT_HuriDenpyou == null) {

            torihikiKeka = true;
        }
        else if(C_HuridensksKbn.GYOUMUIGAI.eq(pfulikaeBT_HuriDenpyou.getHuridenskskbn()) ||
            C_HuridensksKbn.ONLINEFB.eq(pfulikaeBT_HuriDenpyou.getHuridenskskbn())) {

            if (pMaeBT_HuriDenpyou.getHuridenatesakicd().equals(pfulikaeBT_HuriDenpyou.getHuridenatesakicd())  &&
                pMaeBT_HuriDenpyou.getTantocd().eq(pfulikaeBT_HuriDenpyou.getTantocd()) &&
                BizDateUtil.compareYmd(pMaeBT_HuriDenpyou.getDenymd(), pfulikaeBT_HuriDenpyou.getDenymd()) == BizDateUtil.COMPARE_EQUAL &&
                pMaeBT_HuriDenpyou.getHuridenskskbn().eq(pfulikaeBT_HuriDenpyou.getHuridenskskbn()) &&
                pMaeBT_HuriDenpyou.getHuridenpyoukyktuukakbn().eq(pfulikaeBT_HuriDenpyou.getHuridenpyoukyktuukakbn()) &&
                pMaeBT_HuriDenpyou.getTuukasyu().eq(pfulikaeBT_HuriDenpyou.getTuukasyu()) &&
                pMaeBT_HuriDenpyou.getDengyoumucd().equals(pfulikaeBT_HuriDenpyou.getDengyoumucd())) {

                torihikiKeka = false;
            }
            else {

                torihikiKeka = true;
            }
        }
        else if (C_HuridensksKbn.HOZENYAKAN.eq(pfulikaeBT_HuriDenpyou.getHuridenskskbn())) {

            if (pMaeBT_HuriDenpyou.getHuridenatesakicd().equals(pfulikaeBT_HuriDenpyou.getHuridenatesakicd())  &&
                pMaeBT_HuriDenpyou.getTantocd().eq(pfulikaeBT_HuriDenpyou.getTantocd()) &&
                BizDateUtil.compareYmd(pMaeBT_HuriDenpyou.getDenymd(), pfulikaeBT_HuriDenpyou.getDenymd())
                == BizDateUtil.COMPARE_EQUAL &&
                pMaeBT_HuriDenpyou.getHuridenskskbn().eq(pfulikaeBT_HuriDenpyou.getHuridenskskbn()) &&
                pMaeBT_HuriDenpyou.getHuridenpyoukyktuukakbn().eq(pfulikaeBT_HuriDenpyou.getHuridenpyoukyktuukakbn()) &&
                pMaeBT_HuriDenpyou.getTuukasyu().eq(pfulikaeBT_HuriDenpyou.getTuukasyu()) &&
                pMaeBT_HuriDenpyou.getDengyoumucd().equals(pfulikaeBT_HuriDenpyou.getDengyoumucd()) &&
                pMaeBT_HuriDenpyou.getDenshrhoukbn().eq(pfulikaeBT_HuriDenpyou.getDenshrhoukbn())) {

                torihikiKeka = false;
            }
            else {

                torihikiKeka = true;
            }
        }
        else if (C_HuridensksKbn.KOBETU.eq(pfulikaeBT_HuriDenpyou.getHuridenskskbn())) {

            if (pMaeBT_HuriDenpyou.getHuridenatesakicd().equals(pfulikaeBT_HuriDenpyou.getHuridenatesakicd())  &&
                pMaeBT_HuriDenpyou.getTantocd().eq(pfulikaeBT_HuriDenpyou.getTantocd()) &&
                BizDateUtil.compareYmd(pMaeBT_HuriDenpyou.getDenymd(), pfulikaeBT_HuriDenpyou.getDenymd())
                == BizDateUtil.COMPARE_EQUAL &&
                pMaeBT_HuriDenpyou.getHuridenskskbn().eq(pfulikaeBT_HuriDenpyou.getHuridenskskbn()) &&
                pMaeBT_HuriDenpyou.getHuridenpyoukyktuukakbn().eq(pfulikaeBT_HuriDenpyou.getHuridenpyoukyktuukakbn()) &&
                pMaeBT_HuriDenpyou.getTuukasyu().eq(pfulikaeBT_HuriDenpyou.getTuukasyu()) &&
                pMaeBT_HuriDenpyou.getDengyoumucd().equals(pfulikaeBT_HuriDenpyou.getDengyoumucd()) &&
                pMaeBT_HuriDenpyou.getDenshrhoukbn().eq(pfulikaeBT_HuriDenpyou.getDenshrhoukbn()) &&
                pMaeBT_HuriDenpyou.getDensyorisyousaikbn().eq(pfulikaeBT_HuriDenpyou.getDensyorisyousaikbn()) &&
                pMaeBT_HuriDenpyou.getSyoricd().equals(pfulikaeBT_HuriDenpyou.getSyoricd()) &&
                pMaeBT_HuriDenpyou.getKeirisyono().equals(pfulikaeBT_HuriDenpyou.getKeirisyono()) &&
                pMaeBT_HuriDenpyou.getSougoukobetukbn().eq(pfulikaeBT_HuriDenpyou.getSougoukobetukbn()) &&
                pMaeBT_HuriDenpyou.getFurikaedenpyouitirenno().equals(
                    pfulikaeBT_HuriDenpyou.getFurikaedenpyouitirenno())) {

                torihikiKeka = false;
            }
            else {
                torihikiKeka = true;
            }
        }
        else if (C_HuridensksKbn.HONSYARYOUKIN.eq(pfulikaeBT_HuriDenpyou.getHuridenskskbn())) {

            if (pMaeBT_HuriDenpyou.getHuridenatesakicd().equals(pfulikaeBT_HuriDenpyou.getHuridenatesakicd())  &&
                pMaeBT_HuriDenpyou.getTantocd().eq(pfulikaeBT_HuriDenpyou.getTantocd()) &&
                BizDateUtil.compareYmd(pMaeBT_HuriDenpyou.getDenymd(), pfulikaeBT_HuriDenpyou.getDenymd())
                == BizDateUtil.COMPARE_EQUAL &&
                pMaeBT_HuriDenpyou.getHuridenskskbn().eq(pfulikaeBT_HuriDenpyou.getHuridenskskbn()) &&
                pMaeBT_HuriDenpyou.getHuridenpyoukyktuukakbn().eq(pfulikaeBT_HuriDenpyou.getHuridenpyoukyktuukakbn()) &&
                pMaeBT_HuriDenpyou.getTuukasyu().eq(pfulikaeBT_HuriDenpyou.getTuukasyu()) &&
                pMaeBT_HuriDenpyou.getDengyoumucd().equals(pfulikaeBT_HuriDenpyou.getDengyoumucd()) &&
                pMaeBT_HuriDenpyou.getDenshrhoukbn().eq(pfulikaeBT_HuriDenpyou.getDenshrhoukbn()) &&
                pMaeBT_HuriDenpyou.getDensyorisyousaikbn().eq(pfulikaeBT_HuriDenpyou.getDensyorisyousaikbn()) &&
                pMaeBT_HuriDenpyou.getSyoricd().equals(pfulikaeBT_HuriDenpyou.getSyoricd())) {

                torihikiKeka = false;
            }
            else {
                torihikiKeka = true;
            }
        }

        return torihikiKeka;
    }

    public String getTekiyoucdSaiban(BT_HuriDenpyou pHuriDenpyou) {

        if (JIGYOUHI_KMKCD.equals(pHuriDenpyou.getDenkanjokamokucd())) {

            return pHuriDenpyou.getJigyouhiutiwakecd() + KOUSAIHI_KBN;

        }
        if (!BizUtil.isBlank(pHuriDenpyou.getDenkarikanjyono())) {

            return pHuriDenpyou.getDenkarikanjyono();
        }

        return TEKIYOUCD;
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
