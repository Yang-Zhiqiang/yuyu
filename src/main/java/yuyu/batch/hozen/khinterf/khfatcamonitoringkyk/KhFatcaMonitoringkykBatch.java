package yuyu.batch.hozen.khinterf.khfatcamonitoringkyk;

import java.util.ArrayList;
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
import yuyu.batch.hozen.khinterf.khfatcamonitoringkyk.dba.KhFatcaMonitoringknkykInfosByKakutyoujobcdNeSyoriYmdSyutkkbnBean;
import yuyu.batch.hozen.khinterf.khfatcamonitoringkyk.dba.KhFatcaMonitoringkykDao;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.hozen.khcommon.ConvertPALSyoumetucd;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.hozen.file.csv.KhFatcaMonitorKykDataFile;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * ＦＡＴＣＡ確認やＩＲＳあて報告が正しく行われていることを確認するために、</BR>
 * 当月にＦＡＴＣＡ確認が完了した契約を抽出する
 */
public class KhFatcaMonitoringkykBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam batchParam;

    @Inject
    private KhFatcaMonitoringkykDao khFatcaMonitoringkykDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private ConvertPALSyoumetucd convertPALSyoumetucd;

    private static final String TYSYTTAISYOUTABLEID = "IT_KykKihon";

    private static final String RECOVERYFILTERIDKBNID = "Kh001";

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = batchParam.getSyoriYmd();

        String kakutyoujobcd = batchParam.getIbKakutyoujobcd();

        int kensuCount = 0;
        List<KhFatcaMonitorKykDataFile> khFatcaMonitorKykDataFileList = new ArrayList<>();

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        BizDate tysytymd = syoriYmd.getBizDateYM().getPreviousMonth().getFirstDay();

        try (ExDBResults<KhFatcaMonitoringknkykInfosByKakutyoujobcdNeSyoriYmdSyutkkbnBean>
        rs = khFatcaMonitoringkykDao.getKhFatcaMonitoringknkykInfosByKakutyoujobcdNeSyoriYmdSyutkkbn(
            kakutyoujobcd, tysytymd, syoriYmd)) {

            for (KhFatcaMonitoringknkykInfosByKakutyoujobcdNeSyoriYmdSyutkkbnBean bean : rs) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobcd);

                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERIDKBNID);

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(bean.getIT_KykKihon().getKbnkey());

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(bean.getIT_KykKihon().getSyono());

                KhFatcaMonitorKykDataFile khFatcaMonitorKykDataFile = SWAKInjector
                    .getInstance(KhFatcaMonitorKykDataFile.class);

                String lastmeighnksyoriymd = "";

                String kykmeighnksyoriymd = "";

                String syoumetucd;

                if (C_Syoumetujiyuu.BLNK.eq(bean.getIT_KykSyouhn().getSyoumetujiyuu())) {
                    syoumetucd = "";
                }
                else {
                    syoumetucd = convertPALSyoumetucd.exec(bean.getIT_KykSyouhn().getSyoumetujiyuu());
                }

                if (bean.getIT_KykKihon().getLastmeihenymd() != null) {
                    lastmeighnksyoriymd = bean.getIT_KykKihon().getLastmeihenymd().toString();
                }

                if (bean.getIT_KykKihon().getLastkykmeighnkymd() != null) {

                    kykmeighnksyoriymd = bean.getIT_KykKihon().getLastkykmeighnkymd().toString();
                }

                khFatcaMonitorKykDataFile.setIfcFatcakaksyoriymd(bean.getIT_FatcaInfo().getSyoriYmd().toString());

                khFatcaMonitorKykDataFile.setIfcFatcakaksyorino(bean.getIT_FatcaInfo().getRenno().toString());

                khFatcaMonitorKykDataFile.setIfcFatcakaksyoricd(bean.getIT_FatcaInfo().getFatcahankeiikbn());

                khFatcaMonitorKykDataFile.setIfcFatcakaksyorisosikicd(bean.getIT_FatcaInfo().getSyorisosikicd());

                khFatcaMonitorKykDataFile.setIfcFatcakaktgkbn(bean.getIT_FatcaInfo().getFatcatgkbn());

                khFatcaMonitorKykDataFile.setIfcFatcakakkekkakbn(bean.getIT_FatcaInfo().getFatcakekkbn());

                khFatcaMonitorKykDataFile.setIfcFatcakakhingyoutaikbn("0");

                khFatcaMonitorKykDataFile.setIfcFatcakakbikknzsyno(bean.getIT_FatcaInfo().getBikknzsyno());

                if (bean.getIT_FatcaInfo().getKouryokuendymd() != null) {

                    khFatcaMonitorKykDataFile.setIfcFatcakakkryksyryymd(bean.getIT_FatcaInfo()
                        .getKouryokuendymd().toString());
                }
                else {

                    khFatcaMonitorKykDataFile.setIfcFatcakakkryksyryymd(null);
                }

                khFatcaMonitorKykDataFile.setIfcSyono(bean.getIT_KykKihon().getSyono());

                khFatcaMonitorKykDataFile.setIfcSyoumetucd(syoumetucd);

                if (bean.getIT_KykSyouhn().getSyoumetuymd() != null) {
                    khFatcaMonitorKykDataFile.setIfcSyoumetuymd(bean.getIT_KykSyouhn().getSyoumetuymd().toString());
                }

                khFatcaMonitorKykDataFile.setIfcOkyksmno(Strings.padEnd("0", 10, '0'));

                khFatcaMonitorKykDataFile.setIfcHjncd(Strings.padEnd("0", 9, '0'));

                khFatcaMonitorKykDataFile.setIfcDntcd(Strings.padEnd("0", 8, '0'));

                khFatcaMonitorKykDataFile.setIfcKykknmeigi(ConvertUtil.fromZenKataKana(bean.getIT_KykSya()
                    .getKyknmkn(), 1));

                khFatcaMonitorKykDataFile.setIfcKykkjmeigi(bean.getIT_KykSya().getKyknmkj());

                khFatcaMonitorKykDataFile.setIfcKykseiymd(bean.getIT_KykSya().getKykseiymd().toString());

                khFatcaMonitorKykDataFile.setIfcHjndaiknmeigi(Strings.padEnd(" ", 30, ' '));

                khFatcaMonitorKykDataFile.setIfcHjndaikjmeigi(Strings.padEnd("　", 38, '　'));

                khFatcaMonitorKykDataFile.setIfcHjndaiseiymd(Strings.padEnd("0", 8, '0'));

                khFatcaMonitorKykDataFile.setIfcTsinkihontikucd(bean.getIT_KykSya().getTsinyno() + " ");

                khFatcaMonitorKykDataFile.setIfcTsinkaiadr(bean.getIT_KykSya().getTsinadr1kj()
                    + bean.getIT_KykSya().getTsinadr2kj()
                    + bean.getIT_KykSya().getTsinadr3kj());

                khFatcaMonitorKykDataFile.setIfcTsintelno(bean.getIT_KykSya().getTsintelno());

                khFatcaMonitorKykDataFile.setIfcLastmeighnksyoriymd(lastmeighnksyoriymd);

                khFatcaMonitorKykDataFile.setIfcKykmeighnksyoriymd(kykmeighnksyoriymd);

                khFatcaMonitorKykDataFile.setIfcTysytkbn("92");

                khFatcaMonitorKykDataFile.setIfcCashvaluegkkeigk("0");

                khFatcaMonitorKykDataFile.setIfcKaiyakuhr("0");

                khFatcaMonitorKykDataFile.setIfcSznkyhkn("0");

                khFatcaMonitorKykDataFile.setIfcHaitoukin("0");

                khFatcaMonitorKykDataFile.setIfcMikeikap("0");

                khFatcaMonitorKykDataFile.setIfcAnnaifuyouriyuukbn(Strings.padEnd("0", 2, '0'));

                khFatcaMonitorKykDataFile.setIfcDatakanrino(Strings.padEnd("0", 11, '0'));

                khFatcaMonitorKykDataFile.setIfcKaiyakuhrstgkulfhyouji("0");

                khFatcaMonitorKykDataFile.setIfcBknjikoufhyoji("0");

                khFatcaMonitorKykDataFile.setIfcBkncd(Strings.padEnd("0", 4, '0'));

                khFatcaMonitorKykDataFile.setIfcSkKaiyakuhrbknjkufhyoji("0");

                khFatcaMonitorKykDataFile.setIfcSznkyhknrskthskyulfhyoji("0");

                khFatcaMonitorKykDataFile.setIfcSznkyhknbknyulfhyoji("0");

                khFatcaMonitorKykDataFile.setIfcTnrsksnytmttdulfhyoji("0");

                khFatcaMonitorKykDataFile.setIfcTnrsksnysustdulfhyoji("0");

                khFatcaMonitorKykDataFile.setIfcTnrsksnbknbnsndulfhyoji("0");

                khFatcaMonitorKykDataFile.setIfcTnrsksnyzntidulfhyoji("0");

                khFatcaMonitorKykDataFile.setIfcTnrsksnykrwratdulfhyoji("0");

                khFatcaMonitorKykDataFile.setIfcHyumeisaifhyoji("0");

                khFatcaMonitorKykDataFile.setIfcMikeikapbknjkufhyoji("0");

                khFatcaMonitorKykDataFile.setIfcOlskmkkphknulfhyouji("0");

                khFatcaMonitorKykDataFile.setIfcYobi01x01(Strings.padEnd("0", 8, '0'));

                khFatcaMonitorKykDataFile.setIfcYobi01x02(Strings.padEnd("0", 8, '0'));

                khFatcaMonitorKykDataFile.setIfcCvkeisanhukahyouji("0");

                khFatcaMonitorKykDataFile.setIfcKaiyakuhrerrkbn(" ");

                khFatcaMonitorKykDataFile.setIfcSznkyhknerrkbn(" ");

                khFatcaMonitorKykDataFile.setIfcHaitoukinerrkbn(" ");

                khFatcaMonitorKykDataFile.setIfcMikeikaperrkbn(" ");

                khFatcaMonitorKykDataFile.setIfcYobi02x01(Strings.padEnd("0", 8, '0'));

                khFatcaMonitorKykDataFile.setIfcYobi02x02(Strings.padEnd("0", 8, '0'));

                khFatcaMonitorKykDataFile.setIfcYobi02x03(Strings.padEnd("0", 8, '0'));

                khFatcaMonitorKykDataFile.setIfcYobi02x04(Strings.padEnd("0", 8, '0'));

                khFatcaMonitorKykDataFile.setIfcYobi02x05(Strings.padEnd("0", 8, '0'));

                khFatcaMonitorKykDataFile.setIfcYobi02x06(Strings.padEnd("0", 8, '0'));

                khFatcaMonitorKykDataFile.setIfcYobi02x07(Strings.padEnd("0", 8, '0'));


                khFatcaMonitorKykDataFile.setIfcYobi02x08(Strings.padEnd("0", 8, '0'));

                khFatcaMonitorKykDataFile.setIfcYobi02x09(Strings.padEnd("0", 8, '0'));

                khFatcaMonitorKykDataFile.setIfcYobi02x10(Strings.padEnd("0", 8, '0'));

                khFatcaMonitorKykDataFile.setIfcYobi02x11(Strings.padEnd("0", 8, '0'));

                khFatcaMonitorKykDataFile.setIfcYobi02x12(Strings.padEnd("0", 8, '0'));

                khFatcaMonitorKykDataFile.setIfcYobi02x13(Strings.padEnd("0", 8, '0'));

                khFatcaMonitorKykDataFile.setIfcYobi03(Strings.padEnd(" ", 127, ' '));

                khFatcaMonitorKykDataFileList.add(khFatcaMonitorKykDataFile);

                kensuCount++;
            }
            bzRecoveryDatasikibetuBean.initializeBlank();

        }

        bzFileUploadUtil.exec(C_FileSyuruiCdKbn.KH_FATCAMONITORKYKDATA, khFatcaMonitorKykDataFileList, false);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(kensuCount)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate()  {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();

    }
}
