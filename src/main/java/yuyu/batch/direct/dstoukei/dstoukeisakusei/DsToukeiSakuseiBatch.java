package yuyu.batch.direct.dstoukei.dstoukeisakusei;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.classification.Classification;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.StringUtil;
import yuyu.batch.direct.dstoukei.dstoukeisakusei.dba.DsToukeiInfosBean;
import yuyu.batch.direct.dstoukei.dstoukeisakusei.dba.DsToukeiSakuseiDao;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.direct.file.csv.DsToukeiFile;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * ダイレクトサービス ＤＳ統計Ｆ作成</BR>
 * ＤＳ統計情報を取得し、ＤＳ統計Ｆを作成するバッチクラス。</BR>
 * ※対象データの件数は1000件以上となる可能性があり、大量データを扱う。</BR>
 */
public class DsToukeiSakuseiBatch implements Batch {

    private static final int CSVOUTPUTMAXRECORDS = 5000;

    private static final int CSVUPLOADMAXFILES = 100;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private DsToukeiSakuseiDao dsToukeiSakuseiDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        int count = 0;

        int csvOutPutRenban = 1;

        List<DsToukeiFile> dsToukeiFileDataLayoutList = new ArrayList<>();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        long dsKokyakuKeiyakuTblKensuu = dsToukeiSakuseiDao.getDsKokyakuKeiyakuKensuu();

        if(dsKokyakuKeiyakuTblKensuu > (CSVOUTPUTMAXRECORDS * CSVUPLOADMAXFILES)){
            batchLogger.error(MessageUtil.getMessage(MessageId.EIF1003, "ＤＳ統計Ｆ作成対象件数"));
            return;
        }

        if(dsKokyakuKeiyakuTblKensuu <= 0) {
            dsToukeiSakuseiFileUpLoad(C_FileSyuruiCdKbn.DS_TOUKEIFILE, dsToukeiFileDataLayoutList,
                true, String.valueOf(csvOutPutRenban));
        }
        else {
            try(ExDBResults<DsToukeiInfosBean> dsToukeiInfosBeanListBig
                = dsToukeiSakuseiDao.getDsToukeiInfosOrderByKoknoSyono()){
                for (DsToukeiInfosBean dsToukeiInfosBean : dsToukeiInfosBeanListBig){
                    DsToukeiFile dsToukeiFileDataLayout = SWAKInjector.getInstance(DsToukeiFile.class);

                    dsToukeiFileDataLayout.setIfcDskokno(dsToukeiInfosBean.
                        getDskokno());
                    dsToukeiFileDataLayout.setIfcDskokyakujtkbn(dsToukeiInfosBean.
                        getDskokyakujtkbn().toString());
                    dsToukeiFileDataLayout.setIfcDskokyakusakuseiymd(convertObjectNullToBlank(dsToukeiInfosBean.
                        getDskokyakusakuseiymd()));
                    dsToukeiFileDataLayout.setIfcDsteisiriyuukbn(dsToukeiInfosBean.
                        getDsteisiriyuukbn().toString());
                    dsToukeiFileDataLayout.setIfcDskokyakumukouymd(convertObjectNullToBlank(dsToukeiInfosBean.
                        getDskokyakumukouymd()));
                    dsToukeiFileDataLayout.setIfcSeisahuyouhyj(dsToukeiInfosBean.
                        getSeisahuyouhyj().toString());
                    dsToukeiFileDataLayout.setIfcDskokyakuseiymd(convertObjectNullToBlank(dsToukeiInfosBean.
                        getDskokyakuseiymd()));
                    dsToukeiFileDataLayout.setIfcDskokyakuyno(dsToukeiInfosBean.
                        getDskokyakuyno());
                    dsToukeiFileDataLayout.setIfcDskanyuukeirokbn(dsToukeiInfosBean.
                        getDskanyuukeirokbn().toString());
                    dsToukeiFileDataLayout.setIfcDskrhnnkakcdsetkbn(dsToukeiInfosBean.
                        getDskrhnnkakcdsetkbn().toString());
                    dsToukeiFileDataLayout.setIfcDskrhnnkakcdsetymd(convertObjectNullToBlank(dsToukeiInfosBean.
                        getDskrhnnkakcdsetymd()));
                    dsToukeiFileDataLayout.setIfcDskrhnnkakcdyuukouymd(convertObjectNullToBlank(dsToukeiInfosBean.
                        getDskrhnnkakcdyuukouymd()));
                    dsToukeiFileDataLayout.setIfcDshnnkakcdsetymd(convertObjectNullToBlank(dsToukeiInfosBean.
                        getDshnnkakcdsetymd()));
                    dsToukeiFileDataLayout.setIfcDskrhnnkakcdttshjyhsymd(convertObjectNullToBlank(dsToukeiInfosBean.
                        getDskrhnnkakcdttshjyhsymd()));
                    dsToukeiFileDataLayout.setIfcDskrhnnkakcdttyhkbn(dsToukeiInfosBean.
                        getDskrhnnkakcdttyhkbn().toString());
                    dsToukeiFileDataLayout.setIfcDskrhnnkakcdtttydnjykbn(dsToukeiInfosBean.
                        getDskrhnnkakcdtttydnjykbn().toString());
                    dsToukeiFileDataLayout.setIfcSyokailoginymd(convertObjectNullToBlank(dsToukeiInfosBean.
                        getSyokailoginymd()));
                    dsToukeiFileDataLayout.setIfcSyokailogintime(dsToukeiInfosBean.
                        getSyokailogintime());
                    dsToukeiFileDataLayout.setIfcSyokailoginbaitaikbn(dsToukeiInfosBean.
                        getSyokailoginbaitaikbn().toString());
                    dsToukeiFileDataLayout.setIfcSaisinloginymd(convertObjectNullToBlank(dsToukeiInfosBean.
                        getSaisinloginymd()));
                    dsToukeiFileDataLayout.setIfcSaisinlogintime(dsToukeiInfosBean.
                        getSaisinlogintime());
                    dsToukeiFileDataLayout.setIfcSaisinloginbaitaikbn(dsToukeiInfosBean.
                        getSaisinloginbaitaikbn().toString());
                    dsToukeiFileDataLayout.setIfcDshnnkakcderrorks(convertObjectNullToBlank(dsToukeiInfosBean.
                        getDshnnkakcderrorkaisuu()));
                    dsToukeiFileDataLayout.setIfcDskokyakunmerrorks(convertObjectNullToBlank(dsToukeiInfosBean.
                        getDskokyakunmerrorkaisuu()));
                    dsToukeiFileDataLayout.setIfcDskokyakuseiymderrorks(convertObjectNullToBlank(dsToukeiInfosBean.
                        getDskokyakuseiymderrorkaisuu()));
                    dsToukeiFileDataLayout.setIfcDskokyakutelnoerrorks(convertObjectNullToBlank(dsToukeiInfosBean.
                        getDskokyakutelnoerrorkaisuu()));
                    dsToukeiFileDataLayout.setIfcSyono(dsToukeiInfosBean.
                        getSyono());
                    dsToukeiFileDataLayout.setIfcDskykkanyuuymd(convertObjectNullToBlank(dsToukeiInfosBean.
                        getDskykkanyuuymd()));
                    dsToukeiFileDataLayout.setIfcDskykhenkouymd(convertObjectNullToBlank(dsToukeiInfosBean.
                        getDskykhenkouymd()));
                    dsToukeiFileDataLayout.setIfcDskykmukouhyj(dsToukeiInfosBean.
                        getDskykmukouhyj().toString());
                    dsToukeiFileDataLayout.setIfcDskykmukouymd(convertObjectNullToBlank(dsToukeiInfosBean.
                        getDskykmukouymd()));
                    dsToukeiFileDataLayout.setIfcDsmailtourokujyoutaikbn(dsToukeiInfosBean.
                        getDsmailtourokujyoutaikbn().toString());
                    dsToukeiFileDataLayout.setIfcDsmailaddress(convertItemValueToAsta(dsToukeiInfosBean.
                        getDsmailaddress()));
                    dsToukeiFileDataLayout.setIfcDsmailsousinjyoutaikbn(dsToukeiInfosBean.
                        getDsmailsousinjyoutaikbn().toString());
                    dsToukeiFileDataLayout.setIfcDsmailsousintisrykbn(dsToukeiInfosBean.
                        getDsmailsousintisrykbn().toString());
                    dsToukeiFileDataLayout.setIfcDstourokuymdtime(dsToukeiInfosBean.
                        getDstourokuymdtime());
                    dsToukeiFileDataLayout.setIfcDskousinymdtime(dsToukeiInfosBean.
                        getDskousinymdtime());
                    dsToukeiFileDataLayout.setIfcSkjmosno(dsToukeiInfosBean.
                        getSkjmosno());
                    dsToukeiFileDataLayout.setIfcMosuketukekbn(dsToukeiInfosBean.
                        getMosuketukekbn().toString());
                    dsToukeiFileDataLayout.setIfcKyksei(dsToukeiInfosBean.
                        getKyksei().toString());
                    dsToukeiFileDataLayout.setIfcBsyujoyadrtencd(dsToukeiInfosBean.
                        getBsyujoyadrtencd());
                    dsToukeiFileDataLayout.setIfcBsyujdrtencd(dsToukeiInfosBean.
                        getBsyujdrtencd());
                    dsToukeiFileDataLayout.setIfcPplessmailaddrkostime(convertObjectNullToBlank(dsToukeiInfosBean.
                        getGyoumuKousinTime()));
                    dsToukeiFileDataLayout
                    .setIfcDstrhkserviceriyoujkkbn(convertClassificationNullToBlank(dsToukeiInfosBean
                        .getDstrhkserviceriyoujkkbn()));
                    dsToukeiFileDataLayout
                    .setIfcDstrhkservicetsriyuukbn(convertClassificationNullToBlank(dsToukeiInfosBean
                        .getDstrhkserviceteisiriyuukbn()));
                    dsToukeiFileDataLayout.setIfcDstrhkservicetourokuymd(convertObjectNullToBlank(dsToukeiInfosBean
                        .getDstrhkservicetourokuymd()));
                    dsToukeiFileDataLayout.setIfcDstrhkservicemukouymd(convertObjectNullToBlank(dsToukeiInfosBean
                        .getDstrhkservicemukouymd()));
                    dsToukeiFileDataLayout.setIfcDstrhkservicekkkbn(convertClassificationNullToBlank(dsToukeiInfosBean
                        .getDstrhkservicekanyukeirokbn()));
                    dsToukeiFileDataLayout.setIfcDssoukinkzsyuruikbn(convertClassificationNullToBlank(dsToukeiInfosBean
                        .getKzsyuruikbn()));
                    dsToukeiFileDataLayout.setIfcDssoukinkinyuucd(convertObjectNullToBlank(dsToukeiInfosBean
                        .getBankcd()));
                    dsToukeiFileDataLayout.setIfcDssoukinkinyuusitencd(convertObjectNullToBlank(dsToukeiInfosBean
                        .getSitencd()));
                    dsToukeiFileDataLayout.setIfcDssoukinyokin(convertClassificationNullToBlank(dsToukeiInfosBean
                        .getYokinkbn()));
                    dsToukeiFileDataLayout.setIfcDssoukinkouzano(convertItemValueToAsta(dsToukeiInfosBean
                        .getKouzano()));
                    dsToukeiFileDataLayout.setIfcKzdoukbn(convertClassificationNullToBlank(dsToukeiInfosBean
                        .getKzdoukbn()));
                    dsToukeiFileDataLayout.setIfcTokuteitrhkansyono(convertItemValueToAsta(dsToukeiInfosBean
                        .getTokuteitrhkansyono()));
                    dsToukeiFileDataLayout.setIfcTktrhkansyonoerrorkaisuu(convertObjectNullToBlank(dsToukeiInfosBean
                        .getTktrhkansyonoerrorkaisuu()));
                    dsToukeiFileDataLayout.setIfcTktrhkansyonosetymd(convertObjectNullToBlank(dsToukeiInfosBean
                        .getSetymd()));
                    dsToukeiFileDataLayout.setIfcPplessrjdssymnttdkhyj(dsToukeiInfosBean.getPplessrenjidssymenttdkhyj()
                        .getValue());

                    dsToukeiFileDataLayoutList.add(dsToukeiFileDataLayout);

                    count++;

                    if(CSVOUTPUTMAXRECORDS == dsToukeiFileDataLayoutList.size() || dsKokyakuKeiyakuTblKensuu == count){
                        dsToukeiSakuseiFileUpLoad(C_FileSyuruiCdKbn.DS_TOUKEIFILE, dsToukeiFileDataLayoutList,
                            true, String.valueOf(csvOutPutRenban));

                        dsToukeiFileDataLayoutList.removeAll(dsToukeiFileDataLayoutList);

                        csvOutPutRenban++;
                    }
                }
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IAC0020, String.valueOf(count)));
    }

    private String convertObjectNullToBlank(Object pHenkanZenObject) {

        String henkanGoString = "";

        if (pHenkanZenObject != null) {
            henkanGoString = pHenkanZenObject.toString();
        }

        return henkanGoString;
    }

    private String convertClassificationNullToBlank(Classification<?> pHenkanZenClassification) {

        String henkanGoString = "";

        if (pHenkanZenClassification != null) {
            henkanGoString = pHenkanZenClassification.getValue();
        }

        return henkanGoString;
    }

    private String convertItemValueToAsta(String pItemValue) {

        String henkanGoItemValue = "";

        if (!StringUtil.isNullOrBlank(pItemValue)) {
            henkanGoItemValue = "*";
        }

        return henkanGoItemValue;
    }

    private void dsToukeiSakuseiFileUpLoad(C_FileSyuruiCdKbn pFileSyuruiCdKbn,
        List<DsToukeiFile> pBeanLst, boolean pfileDateFlg, String pRenban) {

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(pFileSyuruiCdKbn, pBeanLst, pfileDateFlg, pRenban);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
        }
    }
}
