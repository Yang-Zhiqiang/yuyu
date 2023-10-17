package yuyu.batch.biz.bzmaster.bzaddresstorikomi;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.common.biz.bzcommon.BzRenkeiHenkanUtil;
import yuyu.common.biz.bzcommon.KbnInfoBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_KihontikucdSyoumetuKbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_SystemRenkeiSyoriHousikiKbn;
import yuyu.def.classification.C_TodouhukenKbn;
import yuyu.def.db.entity.BM_Address;
import yuyu.def.db.entity.ZT_AcsAdrNmRn;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 連携用DB（ＡＣＳ住所名ＤＢ用Ｆテーブル（連））を読み込み、住所マスタに反映するクラス
 */
public class BzAddressTorikomiBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private ZdbDomManager zdbDomManager;

    @Inject
    private BzAddressTorikomiDao bzAddressTorikomiDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    public void execute() {

        Long acsAdrNmRnCount = zdbDomManager.getAcsAdrNmRnCount();

        if (acsAdrNmRnCount == 0) {

            throw new BizAppException(MessageId.EBF1001, "ＡＣＳ住所名ＤＢ用Ｆテーブル（連）");

        }

        deleteAddressData();

        BzRenkeiHenkanUtil<BM_Address, BM_Address> bzRenkeiHenkanUtil = new BzRenkeiHenkanUtil<>();
        Long goukeiSyoriCount = 0L;

        bzRenkeiHenkanUtil.initialize(BM_Address.class, C_SystemRenkeiSyoriHousikiKbn.KYOUYUU_DISC,
            C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY);

        for (int n = 0; n < 10; n++){
            goukeiSyoriCount += registAddressData(bzRenkeiHenkanUtil,n);
        }
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(goukeiSyoriCount)));
    }

    @Transactional
    void deleteAddressData() {

        bzAddressTorikomiDao.deleteAddress();
    }

    @Transactional
    Long registAddressData(BzRenkeiHenkanUtil<BM_Address, BM_Address> pBzRenkeiHenkanUtil,int pBunkatuKensakuti) {

        Long syoriCount = 0L;

        try (ExDBResults<ZT_AcsAdrNmRn> exDBResults =
            zdbDomManager.getAcsAdrNmRnsByZrnkihontikucdKeta7(String.valueOf(pBunkatuKensakuti));
            EntityInserter<BM_Address> entityInserter = new EntityInserter<>()) {

            BM_Address bmAddress = null;
            for (ZT_AcsAdrNmRn ztAcsAdrNmRn : exDBResults) {

                try {
                    Integer.parseInt(ztAcsAdrNmRn.getZrnkihontikucd().substring(0, 7));
                }
                catch (Exception e){
                    continue;
                }

                bmAddress = createAddressData(ztAcsAdrNmRn);

                bmAddress = pBzRenkeiHenkanUtil.convDouituBean(bmAddress);

                BizPropertyInitializer.initialize(bmAddress);

                entityInserter.add(bmAddress);

                syoriCount++;
            }
        }
        return syoriCount;
    }

    private BM_Address createAddressData(ZT_AcsAdrNmRn pZtAcsAdrNmRn) {

        BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);

        BM_Address bmAddress = new BM_Address();

        String adrkj = "";

        if (Integer.valueOf(pZtAcsAdrNmRn.getZrnkjkyoutotuusyounmketasuu()) == 0) {

            adrkj = pZtAcsAdrNmRn.getZrnkjadr();

        }
        else {

            adrkj = pZtAcsAdrNmRn.getZrnkjadr().
                substring(0, Integer.valueOf(pZtAcsAdrNmRn.getZrnkjsikugunnmketasuu())) +
                pZtAcsAdrNmRn.getZrnkjadr().substring(Integer.valueOf(pZtAcsAdrNmRn.getZrnkjsikugunnmketasuu()) +
                    Integer.valueOf(pZtAcsAdrNmRn.getZrnkjkyoutotuusyounmketasuu()));

        }

        String adrkn = "";

        if (Integer.valueOf(pZtAcsAdrNmRn.getZrnknkyoutotuusyounmketasuu()) == 0) {

            adrkn = pZtAcsAdrNmRn.getZrnknadr().replaceAll(" ", "");

        }
        else {

            adrkn = (pZtAcsAdrNmRn.getZrnknadr().
                substring(0, Integer.valueOf(pZtAcsAdrNmRn.getZrnknsikugunnmketasuu())) +
                pZtAcsAdrNmRn.getZrnknadr().substring(Integer.valueOf(pZtAcsAdrNmRn.getZrnknsikugunnmketasuu()) +
                    Integer.valueOf(pZtAcsAdrNmRn.getZrnknkyoutotuusyounmketasuu()))).replaceAll(" ", "");

        }

        String adrknblankari = "";

        if (Integer.valueOf(pZtAcsAdrNmRn.getZrnknkyoutotuusyounmketasuu()) == 0) {

            adrknblankari = pZtAcsAdrNmRn.getZrnknadr();

        }
        else {

            adrknblankari = pZtAcsAdrNmRn.getZrnknadr().
                substring(0, Integer.valueOf(pZtAcsAdrNmRn.getZrnknsikugunnmketasuu())) +
                pZtAcsAdrNmRn.getZrnknadr().substring(Integer.valueOf(pZtAcsAdrNmRn.getZrnknsikugunnmketasuu()) +
                    Integer.valueOf(pZtAcsAdrNmRn.getZrnknkyoutotuusyounmketasuu()));

        }

        bmAddress.setPostalCd(pZtAcsAdrNmRn.getZrnkihontikucd().substring(0, 7));
        bmAddress.setKihontikucdsimo1(pZtAcsAdrNmRn.getZrnkihontikucd().substring(7));
        bmAddress.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.valueOf(
            pZtAcsAdrNmRn.getZrnkihontikucdsyoumetukbn()));
        bmAddress.setKjadrkyoutotuusyounmari(pZtAcsAdrNmRn.getZrnkjadr());
        bmAddress.setKjtodouhukennmketasuu(Integer.valueOf(pZtAcsAdrNmRn.getZrnkjtodouhukennmketasuu()));
        bmAddress.setKjsikugunnmketasuu(Integer.valueOf(pZtAcsAdrNmRn.getZrnkjsikugunnmketasuu()));
        bmAddress.setKjsikutyousonnmketasuu(Integer.valueOf(pZtAcsAdrNmRn.getZrnkjsikutyousonnmketasuu()));
        bmAddress.setKjtyousonnmketasuu(Integer.valueOf(pZtAcsAdrNmRn.getZrnkjtyousonnmketasuu()));
        bmAddress.setKjkyoutotuusyounmketasuu(Integer.valueOf(pZtAcsAdrNmRn.getZrnkjkyoutotuusyounmketasuu()));
        bmAddress.setKjadrketasuu(Integer.valueOf(pZtAcsAdrNmRn.getZrnkjadrketasuu()));
        bmAddress.setKnadrkyoutotuusyounmari(pZtAcsAdrNmRn.getZrnknadr());
        bmAddress.setKntodouhukennmketasuu(Integer.valueOf(pZtAcsAdrNmRn.getZrnkntodouhukennmketasuu()));
        bmAddress.setKnsikugunnmketasuu(Integer.valueOf(pZtAcsAdrNmRn.getZrnknsikugunnmketasuu()));
        bmAddress.setKnsikutyousonnmketasuu(Integer.valueOf(pZtAcsAdrNmRn.getZrnknsikutyousonnmketasuu()));
        bmAddress.setKntyousonnmketasuu(Integer.valueOf(pZtAcsAdrNmRn.getZrnkntyousonnmketasuu()));
        bmAddress.setKnkyoutotuusyounmketasuu(Integer.valueOf(pZtAcsAdrNmRn.getZrnknkyoutotuusyounmketasuu()));
        bmAddress.setKnadrketasuu(Integer.valueOf(pZtAcsAdrNmRn.getZrnknadrketasuu()));
        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(pZtAcsAdrNmRn.getZrntodouhukencd(),
            C_TodouhukenKbn.class,C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY);
        bmAddress.setTodouhukencd(C_TodouhukenKbn.valueOf(kbnInfoBean.getKbnData()));
        bmAddress.setGyouseikukakucd(pZtAcsAdrNmRn.getZrngyouseikukakucd());
        bmAddress.setIkoumaekihontikucd(pZtAcsAdrNmRn.getZrnikoumaekihontikucd());
        bmAddress.setNewynohyouji(pZtAcsAdrNmRn.getZrnnewynohyouji());
        bmAddress.setAdrkj(adrkj);
        bmAddress.setAdrkn(adrkn);
        bmAddress.setAdrknblankari(adrknblankari);

        return bmAddress;
    }

}
