package yuyu.batch.hozen.khinterf.khfatcamonitoringkaknin;

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
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.hozen.khcommon.ConvertPALSyoumetucd;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.hozen.file.csv.KhFatcaMonitorKykDataKakFile;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.KhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbnBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * ＦＡＴＣＡ確認やＩＲＳあて報告が正しく行われていることを確認するために、</BR>
 * ＦＡＴＣＡ確認中の契約を抽出する
 */
public class KhFatcaMonitoringKakninBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam batchParam;

    @Inject
    private HozenDomManager hozenDomManager;

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

        List<KhFatcaMonitorKykDataKakFile> khFatcaMonitorKykDataKakFileList = new ArrayList<>();

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        try (ExDBResults<KhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbnBean>
        rs = hozenDomManager.getKhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbn(
            kakutyoujobcd, syoriYmd.addMonths(-2))) {

            for (KhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbnBean bean : rs) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobcd);

                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERIDKBNID);

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(bean.getIT_KykKihon().getKbnkey());

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(bean.getIT_KykKihon().getSyono());

                if (bean.getIT_FatcaInfo().getKouryokuendymd() == null
                    || bean.getIT_FatcaInfo().getSyoriYmd().addMonths(2).getRekijyou()
                    .compareTo(bean.getIT_FatcaInfo().getKouryokuendymd()) < 0) {

                    KhFatcaMonitorKykDataKakFile khFatcaMonitorKykDataKakFile = SWAKInjector
                        .getInstance(KhFatcaMonitorKykDataKakFile.class);

                    String lastmeighnksyoriymd = "";

                    String kykmeighnksyoriymd = "";

                    String syoumetucd;

                    if (C_Syoumetujiyuu.BLNK.eq(bean.getIT_KykSyouhn().getSyoumetujiyuu())) {
                        syoumetucd = "";
                    }
                    else {
                        syoumetucd = convertPALSyoumetucd.exec(bean.getIT_KykSyouhn().getSyoumetujiyuu());
                    }

                    String tsinkihontikucd = bean.getIT_KykSya().getTsinyno() + " ";

                    if (bean.getIT_KykKihon().getLastmeihenymd() != null) {

                        lastmeighnksyoriymd = bean.getIT_KykKihon().getLastmeihenymd().toString();
                    }

                    if (bean.getIT_KykKihon().getLastkykmeighnkymd() != null) {

                        kykmeighnksyoriymd = bean.getIT_KykKihon().getLastkykmeighnkymd().toString();
                    }

                    khFatcaMonitorKykDataKakFile
                    .setIfcFatcakaksyoriymd(bean.getIT_FatcaInfo().getSyoriYmd().toString());

                    khFatcaMonitorKykDataKakFile.setIfcFatcakaksyorino(bean.getIT_FatcaInfo().getRenno().toString());

                    khFatcaMonitorKykDataKakFile.setIfcFatcakaksyoricd(bean.getIT_FatcaInfo().getFatcahankeiikbn());

                    khFatcaMonitorKykDataKakFile.setIfcFatcakaksyorisosikicd(bean.getIT_FatcaInfo().getSyorisosikicd());

                    khFatcaMonitorKykDataKakFile.setIfcFatcakaktgkbn(bean.getIT_FatcaInfo().getFatcatgkbn());

                    khFatcaMonitorKykDataKakFile.setIfcFatcakakkekkakbn(bean.getIT_FatcaInfo().getFatcakekkbn());

                    khFatcaMonitorKykDataKakFile.setIfcFatcakakhingyoutaikbn("0");

                    khFatcaMonitorKykDataKakFile.setIfcFatcakakbikknzsyno(bean.getIT_FatcaInfo().getBikknzsyno());

                    if (bean.getIT_FatcaInfo().getKouryokuendymd() != null) {

                        khFatcaMonitorKykDataKakFile.setIfcFatcakakkryksyryymd(bean.getIT_FatcaInfo()
                            .getKouryokuendymd().toString());
                    }
                    else {

                        khFatcaMonitorKykDataKakFile.setIfcFatcakakkryksyryymd(null);
                    }

                    khFatcaMonitorKykDataKakFile.setIfcSyono(bean.getIT_KykKihon().getSyono());

                    khFatcaMonitorKykDataKakFile.setIfcSyoumetucd(syoumetucd);

                    if (bean.getIT_KykSyouhn().getSyoumetuymd() != null) {
                        khFatcaMonitorKykDataKakFile.setIfcSyoumetuymd(bean.getIT_KykSyouhn().getSyoumetuymd().toString());
                    }

                    khFatcaMonitorKykDataKakFile.setIfcOkyksmno(Strings.padEnd("0", 10, '0'));

                    khFatcaMonitorKykDataKakFile.setIfcHjncd(Strings.padEnd("0", 9, '0'));

                    khFatcaMonitorKykDataKakFile.setIfcDntcd(Strings.padEnd("0", 8, '0'));

                    khFatcaMonitorKykDataKakFile.setIfcKykknmeigi(ConvertUtil.fromZenKataKana(bean.getIT_KykSya()
                        .getKyknmkn(), 1));

                    khFatcaMonitorKykDataKakFile.setIfcKykkjmeigi(bean.getIT_KykSya().getKyknmkj());

                    khFatcaMonitorKykDataKakFile.setIfcKykseiymd(bean.getIT_KykSya().getKykseiymd().toString());

                    khFatcaMonitorKykDataKakFile.setIfcHjndaiknmeigi(Strings.padEnd(" ", 30, ' '));

                    khFatcaMonitorKykDataKakFile.setIfcHjndaikjmeigi(Strings.padEnd("　", 38, '　'));

                    khFatcaMonitorKykDataKakFile.setIfcHjndaiseiymd(Strings.padEnd("0", 8, '0'));

                    khFatcaMonitorKykDataKakFile.setIfcTsinkihontikucd(tsinkihontikucd);

                    khFatcaMonitorKykDataKakFile.setIfcTsinkaiadr(bean.getIT_KykSya().getTsinadr1kj()
                        + bean.getIT_KykSya().getTsinadr2kj()
                        + bean.getIT_KykSya().getTsinadr3kj());

                    khFatcaMonitorKykDataKakFile.setIfcTsintelno(bean.getIT_KykSya().getTsintelno());

                    khFatcaMonitorKykDataKakFile.setIfcLastmeighnksyoriymd(lastmeighnksyoriymd);

                    khFatcaMonitorKykDataKakFile.setIfcKykmeighnksyoriymd(kykmeighnksyoriymd);

                    khFatcaMonitorKykDataKakFile.setIfcTysytkbn("03");

                    khFatcaMonitorKykDataKakFile.setIfcCashvaluegkkeigk("0");

                    khFatcaMonitorKykDataKakFile.setIfcKaiyakuhr("0");

                    khFatcaMonitorKykDataKakFile.setIfcSznkyhkn("0");

                    khFatcaMonitorKykDataKakFile.setIfcHaitoukin("0");

                    khFatcaMonitorKykDataKakFile.setIfcMikeikap("0");

                    khFatcaMonitorKykDataKakFile.setIfcAnnaifuyouriyuukbn(Strings.padEnd("0", 2, '0'));

                    khFatcaMonitorKykDataKakFile.setIfcDatakanrino(Strings.padEnd("0", 11, '0'));

                    khFatcaMonitorKykDataKakFile.setIfcKaiyakuhrstgkulfhyouji("0");

                    khFatcaMonitorKykDataKakFile.setIfcBknjikoufhyoji("0");

                    khFatcaMonitorKykDataKakFile.setIfcBkncd(Strings.padEnd("0", 4, '0'));

                    khFatcaMonitorKykDataKakFile.setIfcSkKaiyakuhrbknjkufhyoji("0");

                    khFatcaMonitorKykDataKakFile.setIfcSznkyhknrskthskyulfhyoji("0");

                    khFatcaMonitorKykDataKakFile.setIfcSznkyhknbknyulfhyoji("0");

                    khFatcaMonitorKykDataKakFile.setIfcTnrsksnytmttdulfhyoji("0");

                    khFatcaMonitorKykDataKakFile.setIfcTnrsksnysustdulfhyoji("0");

                    khFatcaMonitorKykDataKakFile.setIfcTnrsksnbknbnsndulfhyoji("0");

                    khFatcaMonitorKykDataKakFile.setIfcTnrsksnyzntidulfhyoji("0");

                    khFatcaMonitorKykDataKakFile.setIfcTnrsksnykrwratdulfhyoji("0");

                    khFatcaMonitorKykDataKakFile.setIfcHyumeisaifhyoji("0");

                    khFatcaMonitorKykDataKakFile.setIfcMikeikapbknjkufhyoji("0");

                    khFatcaMonitorKykDataKakFile.setIfcOlskmkkphknulfhyouji("0");

                    khFatcaMonitorKykDataKakFile.setIfcYobi01x01(Strings.padEnd("0", 8, '0'));

                    khFatcaMonitorKykDataKakFile.setIfcYobi01x02(Strings.padEnd("0", 8, '0'));

                    khFatcaMonitorKykDataKakFile.setIfcCvkeisanhukahyouji("0");

                    khFatcaMonitorKykDataKakFile.setIfcKaiyakuhrerrkbn(" ");

                    khFatcaMonitorKykDataKakFile.setIfcSznkyhknerrkbn(" ");

                    khFatcaMonitorKykDataKakFile.setIfcHaitoukinerrkbn(" ");

                    khFatcaMonitorKykDataKakFile.setIfcMikeikaperrkbn(" ");

                    khFatcaMonitorKykDataKakFile.setIfcYobi02x01(Strings.padEnd("0", 8, '0'));

                    khFatcaMonitorKykDataKakFile.setIfcYobi02x02(Strings.padEnd("0", 8, '0'));

                    khFatcaMonitorKykDataKakFile.setIfcYobi02x03(Strings.padEnd("0", 8, '0'));

                    khFatcaMonitorKykDataKakFile.setIfcYobi02x04(Strings.padEnd("0", 8, '0'));

                    khFatcaMonitorKykDataKakFile.setIfcYobi02x05(Strings.padEnd("0", 8, '0'));

                    khFatcaMonitorKykDataKakFile.setIfcYobi02x06(Strings.padEnd("0", 8, '0'));

                    khFatcaMonitorKykDataKakFile.setIfcYobi02x07(Strings.padEnd("0", 8, '0'));

                    khFatcaMonitorKykDataKakFile.setIfcYobi02x08(Strings.padEnd("0", 8, '0'));

                    khFatcaMonitorKykDataKakFile.setIfcYobi02x09(Strings.padEnd("0", 8, '0'));

                    khFatcaMonitorKykDataKakFile.setIfcYobi02x10(Strings.padEnd("0", 8, '0'));

                    khFatcaMonitorKykDataKakFile.setIfcYobi02x11(Strings.padEnd("0", 8, '0'));

                    khFatcaMonitorKykDataKakFile.setIfcYobi02x12(Strings.padEnd("0", 8, '0'));

                    khFatcaMonitorKykDataKakFile.setIfcYobi02x13(Strings.padEnd("0", 8, '0'));

                    khFatcaMonitorKykDataKakFile.setIfcYobi03(Strings.padEnd(" ", 127, ' '));

                    khFatcaMonitorKykDataKakFileList.add(khFatcaMonitorKykDataKakFile);

                    kensuCount++;
                }
            }
            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        bzFileUploadUtil.exec(C_FileSyuruiCdKbn.KH_FATCAMONITORKYKDATAKAK, khFatcaMonitorKykDataKakFileList, false);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(kensuCount)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate()  {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

}
