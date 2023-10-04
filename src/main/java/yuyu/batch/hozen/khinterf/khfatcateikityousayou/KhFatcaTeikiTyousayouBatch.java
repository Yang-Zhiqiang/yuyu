package yuyu.batch.hozen.khinterf.khfatcateikityousayou;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.hozen.khcommon.ConvertPALSyoumetucd;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.hozen.file.csv.KhFatcaTeikiTyousaDataFile;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.FatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbnBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 契約保全 インターフェイス ＦＡＴＣＡ定期調査要抽出クラス
 */
public class KhFatcaTeikiTyousayouBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    private static final  String TABLEID = "IT_FatcaInfo";

    private static final String FILTERID = "Kh001";

    @Inject
    private ConvertPALSyoumetucd convertPALSyoumetucd;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        int syoriKensuu = 0;

        List<KhFatcaTeikiTyousaDataFile> khFatcaTeikiTyousaDataFileList = new ArrayList<KhFatcaTeikiTyousaDataFile>();

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        String ibKakutyoujobcd = bzBatchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            ibKakutyoujobcd));
        try(ExDBResults<FatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbnBean>
        fattatckbnBeanList =hozenDomManager.

        getFatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbn(
            bzBatchParam.getIbKakutyoujobcd(),
            bzBatchParam.getSyoriYmd().getBizDateY().addYears(-3))){

            Iterator<FatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbnBean> nyknmeisaiIter =
                fattatckbnBeanList.iterator();

            while (nyknmeisaiIter.hasNext()) {

                FatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbnBean
                fattatckbnBean = nyknmeisaiIter.next();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(fattatckbnBean.getIT_FatcaInfo().getKbnkey());

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(fattatckbnBean.getIT_FatcaInfo().getSyono());

                KhFatcaTeikiTyousaDataFile khFatcaTeikiTyousaDataFile =
                    SWAKInjector.getInstance(KhFatcaTeikiTyousaDataFile.class);

                String ifcLastmeighnksyoriymd = "";

                String ifcKykmeighnksyoriymd = "";

                String ifcKouryokuEndymd = "";

                String syoumetucd = "";

                String ifcSyoumetuymd = "";

                if(!fattatckbnBean.getIT_KykSyouhn().getSyoumetujiyuu().eq(C_Syoumetujiyuu.BLNK)){
                    syoumetucd = convertPALSyoumetucd.exec(fattatckbnBean.getIT_KykSyouhn().getSyoumetujiyuu());
                }

                String zrntsinkihontikucd = fattatckbnBean.getIT_KykSya().getTsinyno() + " ";

                if(fattatckbnBean.getIT_KykKihon().getLastmeihenymd() != null) {

                    ifcLastmeighnksyoriymd = String.valueOf(fattatckbnBean.getIT_KykKihon().getLastmeihenymd());
                }

                if(fattatckbnBean.getIT_KykKihon().getLastkykmeighnkymd() != null) {

                    ifcKykmeighnksyoriymd = String.valueOf(fattatckbnBean.getIT_KykKihon().getLastkykmeighnkymd());
                }

                if (fattatckbnBean.getIT_FatcaInfo().getKouryokuendymd() != null) {

                    ifcKouryokuEndymd = fattatckbnBean.getIT_FatcaInfo().getKouryokuendymd().toString();
                }

                if(fattatckbnBean.getIT_KykSyouhn().getSyoumetuymd() != null){

                    ifcSyoumetuymd = fattatckbnBean.getIT_KykSyouhn().getSyoumetuymd().toString();
                }

                khFatcaTeikiTyousaDataFile.
                setIfcFatcakaksyoriymd(String.valueOf(fattatckbnBean.getIT_FatcaInfo().getSyoriYmd()));

                khFatcaTeikiTyousaDataFile.
                setIfcFatcakaksyorino(String.valueOf(fattatckbnBean.getIT_FatcaInfo().getRenno()));

                khFatcaTeikiTyousaDataFile.
                setIfcFatcakaksyoricd(fattatckbnBean.getIT_FatcaInfo().getFatcahankeiikbn());

                khFatcaTeikiTyousaDataFile.
                setIfcFatcakaksyorisosikicd(fattatckbnBean.getIT_FatcaInfo().getSyorisosikicd());

                khFatcaTeikiTyousaDataFile.setIfcFatcakaktgkbn(fattatckbnBean.getIT_FatcaInfo().getFatcatgkbn());

                khFatcaTeikiTyousaDataFile.setIfcFatcakakkekkakbn(fattatckbnBean.getIT_FatcaInfo().getFatcakekkbn());

                khFatcaTeikiTyousaDataFile.setIfcFatcakakhingyoutaikbn("0");

                khFatcaTeikiTyousaDataFile.setIfcFatcakakbikknzsyno(fattatckbnBean.getIT_FatcaInfo().getBikknzsyno());

                khFatcaTeikiTyousaDataFile.setIfcFatcakakkryksyryymd(ifcKouryokuEndymd);

                khFatcaTeikiTyousaDataFile.setIfcSyono(fattatckbnBean.getIT_FatcaInfo().getSyono());

                khFatcaTeikiTyousaDataFile.setIfcSyoumetucd(syoumetucd);

                khFatcaTeikiTyousaDataFile.setIfcSyoumetuymd(ifcSyoumetuymd);

                khFatcaTeikiTyousaDataFile.setIfcOkyksmno(Strings.padEnd("", 10, '0'));

                khFatcaTeikiTyousaDataFile.setIfcHjncd(Strings.padEnd("", 9, '0'));

                khFatcaTeikiTyousaDataFile.setIfcDntcd(Strings.padEnd("", 8, '0'));

                khFatcaTeikiTyousaDataFile.
                setIfcKykknmeigi(ConvertUtil.fromZenKataKana(fattatckbnBean.getIT_KykSya().getKyknmkn(), 1));

                khFatcaTeikiTyousaDataFile.setIfcKykkjmeigi(fattatckbnBean.getIT_KykSya().getKyknmkj());

                khFatcaTeikiTyousaDataFile.
                setIfcKykseiymd(String.valueOf(fattatckbnBean.getIT_KykSya().getKykseiymd()));

                khFatcaTeikiTyousaDataFile.
                setIfcHjndaiknmeigi(Strings.padEnd("", 30, ' '));

                khFatcaTeikiTyousaDataFile.
                setIfcHjndaikjmeigi(Strings.padEnd("", 38, '　'));

                khFatcaTeikiTyousaDataFile.
                setIfcHjndaiseiymd(Strings.padEnd("", 8, '0'));

                khFatcaTeikiTyousaDataFile.setIfcTsinkihontikucd(zrntsinkihontikucd);

                khFatcaTeikiTyousaDataFile.setIfcTsinkaiadr(fattatckbnBean.getIT_KykSya().getTsinadr1kj()
                    + fattatckbnBean.getIT_KykSya().getTsinadr2kj()
                    + fattatckbnBean.getIT_KykSya().getTsinadr3kj());
                khFatcaTeikiTyousaDataFile.setIfcTsintelno(fattatckbnBean.getIT_KykSya().getTsintelno());

                khFatcaTeikiTyousaDataFile.setIfcLastmeighnksyoriymd(ifcLastmeighnksyoriymd);

                khFatcaTeikiTyousaDataFile.setIfcKykmeighnksyoriymd(ifcKykmeighnksyoriymd);

                khFatcaTeikiTyousaDataFile.setIfcTysytkbn("08");

                khFatcaTeikiTyousaDataFile.setIfcCashvaluegkkeigk("0");

                khFatcaTeikiTyousaDataFile.setIfcKaiyakuhr("0");

                khFatcaTeikiTyousaDataFile.setIfcSznkyhkn("0");

                khFatcaTeikiTyousaDataFile.setIfcHaitoukin("0");

                khFatcaTeikiTyousaDataFile.setIfcMikeikap("0");

                khFatcaTeikiTyousaDataFile.setIfcCvkeisanhukahyouji("0");

                khFatcaTeikiTyousaDataFile.setIfcKaiyakuhrerrkbn(" ");

                khFatcaTeikiTyousaDataFile.setIfcSznkyhknerrkbn(" ");

                khFatcaTeikiTyousaDataFile.setIfcHaitoukinerrkbn(" ");

                khFatcaTeikiTyousaDataFile.setIfcMikeikaperrkbn(" ");

                khFatcaTeikiTyousaDataFileList.add(khFatcaTeikiTyousaDataFile);

                syoriKensuu ++;
            }
        }
        bzRecoveryDatasikibetuBean.initializeBlank();

        bzFileUploadUtil.exec(C_FileSyuruiCdKbn.KH_FATCATEIKITYOUSADATA, khFatcaTeikiTyousaDataFileList,false);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));

    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate()  {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }
}
