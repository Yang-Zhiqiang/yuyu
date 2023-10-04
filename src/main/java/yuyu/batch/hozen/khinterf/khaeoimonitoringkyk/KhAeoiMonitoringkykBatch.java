package yuyu.batch.hozen.khinterf.khaeoimonitoringkyk;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import jp.co.slcs.swak.util.string.StringUtil;
import yuyu.batch.hozen.khinterf.khaeoimonitoringkyk.dba.KhAeoiMonitoringkykDao;
import yuyu.batch.hozen.khinterf.khaeoimonitoringkyk.dba.KhAeoiMonitoringkykInfosByKakutyoujobcdNeSyoriYmdSyutkkbnBean;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.hozen.khcommon.ConvertPALSyoumetucd;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.hozen.file.csv.KhAeoiMonitorKykDataFile;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 契約保全 インターフェイス ＡＥＯＩモニタリング契約抽出</BR>
 * 毎月月末時点で前月、当月に作成されたＡＥＯＩ情報をすべて抽出する。</BR>
 */
public class KhAeoiMonitoringkykBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private KhAeoiMonitoringkykBatchParam batchParam;

    @Inject
    private KhAeoiMonitoringkykDao khAeoiMonitoringkykDao;

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

        int tyusyutuKikan = batchParam.getTysytKikan() - 1;

        int kensuCount = 0;

        List<KhAeoiMonitorKykDataFile> khAeoiMonitorKykDataFileList = new ArrayList<>();

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        BizDate tysytymd = syoriYmd.addMonths(-tyusyutuKikan).getBizDateYM().getFirstDay();

        try (ExDBResults<KhAeoiMonitoringkykInfosByKakutyoujobcdNeSyoriYmdSyutkkbnBean>
        rs = khAeoiMonitoringkykDao.getKhAeoiMonitoringkykInfosByKakutyoujobcdNeSyoriYmdSyutkkbn(
            kakutyoujobcd, tysytymd, syoriYmd)) {

            for (KhAeoiMonitoringkykInfosByKakutyoujobcdNeSyoriYmdSyutkkbnBean bean : rs) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobcd);

                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERIDKBNID);

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(bean.getIT_KykKihon().getKbnkey());

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(bean.getIT_KykKihon().getSyono());

                KhAeoiMonitorKykDataFile khAeoiMonitorKykDataFile = SWAKInjector
                    .getInstance(KhAeoiMonitorKykDataFile.class);

                String syoumetucd;

                if (C_Syoumetujiyuu.BLNK.eq(bean.getIT_KykSyouhn().getSyoumetujiyuu())){
                    syoumetucd = "";
                }
                else {
                    syoumetucd = convertPALSyoumetucd.exec(bean.getIT_KykSyouhn().getSyoumetujiyuu());
                }

                khAeoiMonitorKykDataFile.setIfcAeoikaksyoriymd(bean.getIT_AeoiInfo().getAeoisyoriymd());
                khAeoiMonitorKykDataFile.setIfcAeoikaksyorino(bean.getIT_AeoiInfo().getRenno());
                khAeoiMonitorKykDataFile.setIfcAeoikaksyoricd(bean.getIT_AeoiInfo().getAeoisyorikbn());
                khAeoiMonitorKykDataFile.setIfcAeoikaksyorisosikicd(bean.getIT_AeoiInfo().getAeoisyorisosikicd());
                khAeoiMonitorKykDataFile.setIfcAeoikaktgkbn(bean.getIT_AeoiInfo().getAeoitaisyousyakbn());
                khAeoiMonitorKykDataFile.setIfcAeoikakkekkakbn(bean.getIT_AeoiInfo().getAeoikekkakbn());
                khAeoiMonitorKykDataFile.setIfcAeoikakhinsyuruikbn(bean.getIT_AeoiInfo().getAeoihoujinsyuruikbn());
                khAeoiMonitorKykDataFile.setIfcAeoikakkrykstymd(bean.getIT_AeoiInfo().getAeoikouryokusttymd());
                khAeoiMonitorKykDataFile.setIfcAeoikakkryksyryymd(bean.getIT_AeoiInfo().getAeoikouryokuendymd());
                khAeoiMonitorKykDataFile.setIfcFilekbn("1");
                khAeoiMonitorKykDataFile.setIfcSyono(bean.getIT_KykKihon().getSyono());
                khAeoiMonitorKykDataFile.setIfcSyoumetucd(syoumetucd);
                khAeoiMonitorKykDataFile.setIfcSyoumetuymd(
                    convertDateNullToBlank(bean.getIT_KykSyouhn().getSyoumetuymd()));
                khAeoiMonitorKykDataFile.setIfcOkyksmno(Strings.padEnd("0", 10, '0'));
                khAeoiMonitorKykDataFile.setIfcHjncd(Strings.padEnd("0", 9, '0'));
                khAeoiMonitorKykDataFile.setIfcDntcd(Strings.padEnd("0", 8, '0'));
                khAeoiMonitorKykDataFile.setIfcKykknmeigi(
                    ConvertUtil.fromZenKataKana(bean.getIT_KykSya().getKyknmkn(), 1));
                khAeoiMonitorKykDataFile.setIfcKykkjmeigi(bean.getIT_KykSya().getKyknmkj());
                khAeoiMonitorKykDataFile.setIfcKykseiymd(bean.getIT_KykSya().getKykseiymd().toString());
                khAeoiMonitorKykDataFile.setIfcHjndaiknmeigi(Strings.padEnd(" ", 30, ' '));
                khAeoiMonitorKykDataFile.setIfcHjndaikjmeigi(Strings.padEnd("　", 38, '　'));
                khAeoiMonitorKykDataFile.setIfcHjndaiseiymd(Strings.padEnd("0", 8, '0'));
                khAeoiMonitorKykDataFile.setIfcTsinkihontikucd(bean.getIT_KykSya().getTsinyno() + " ");
                khAeoiMonitorKykDataFile.setIfcTsinkaiadr(
                    StringUtil.rTrim(bean.getIT_KykSya().getTsinadr1kj()
                        + bean.getIT_KykSya().getTsinadr2kj()
                        + bean.getIT_KykSya().getTsinadr3kj()));
                khAeoiMonitorKykDataFile.setIfcTsintelno(bean.getIT_KykSya().getTsintelno());
                khAeoiMonitorKykDataFile.setIfcLastmeighnksyoriymd(
                    convertDateNullToBlank(bean.getIT_KykKihon().getLastmeihenymd()));
                khAeoiMonitorKykDataFile.setIfcKykmeighnksyoriymd(
                    convertDateNullToBlank(bean.getIT_KykKihon().getLastkykmeighnkymd()));
                khAeoiMonitorKykDataFile.setIfcTysytkbn("92");
                khAeoiMonitorKykDataFile.setIfcNenkinsyoumetucd(Strings.padEnd("0", 2, '0'));
                khAeoiMonitorKykDataFile.setIfcNenkinsyoumetuymd(BizDate.valueOf("00000000"));
                khAeoiMonitorKykDataFile.setIfcTkykarihyj("0");
                khAeoiMonitorKykDataFile.setIfcHengknktksytysythyj("0");
                khAeoiMonitorKykDataFile.setIfcNkshrtkykhyj("0");
                khAeoiMonitorKykDataFile.setIfcYobi01x01(Strings.padEnd("0", 8, '0'));
                khAeoiMonitorKykDataFile.setIfcYobi01x02(Strings.padEnd("0", 8, '0'));
                khAeoiMonitorKykDataFile.setIfcYobi01x03(Strings.padEnd("0", 8, '0'));
                khAeoiMonitorKykDataFile.setIfcYobi01x04(Strings.padEnd("0", 8, '0'));
                khAeoiMonitorKykDataFile.setIfcYobi01x05(Strings.padEnd("0", 8, '0'));
                khAeoiMonitorKykDataFile.setIfcYobi01x06(Strings.padEnd("0", 8, '0'));
                khAeoiMonitorKykDataFile.setIfcYobi02(Strings.padEnd(" ", 59, ' '));
                khAeoiMonitorKykDataFile.setIfcSueokimnkuktkbn("0");
                khAeoiMonitorKykDataFile.setIfcSueokitokmeigihyj("0");
                khAeoiMonitorKykDataFile.setIfcSueokihukusuumeigihyj("0");
                khAeoiMonitorKykDataFile.setIfcSueokibikinhyj("0");
                khAeoiMonitorKykDataFile.setIfcYobi03x26(Strings.padEnd(" ", 26, ' '));
                khAeoiMonitorKykDataFile.setIfcCashvaluegkkeigk("0");
                khAeoiMonitorKykDataFile.setIfcKaiyakuhr("0");
                khAeoiMonitorKykDataFile.setIfcSznkyhkn("0");
                khAeoiMonitorKykDataFile.setIfcHaitoukin("0");
                khAeoiMonitorKykDataFile.setIfcMikeikap("0");
                khAeoiMonitorKykDataFile.setIfcNkyousknnjynbkn(BizCurrency.valueOf(0));
                khAeoiMonitorKykDataFile.setIfcNkyoushrbkn(BizCurrency.valueOf(0));
                khAeoiMonitorKykDataFile.setIfcNkyouiktnkgk(BizCurrency.valueOf(0));
                khAeoiMonitorKykDataFile.setIfcNkyouhaitoujynbkn(BizCurrency.valueOf(0));
                khAeoiMonitorKykDataFile.setIfcNkyoukaiyakuhr(BizCurrency.valueOf(0));
                khAeoiMonitorKykDataFile.setIfcSueokiyousknnjynbkn(BizCurrency.valueOf(0));
                khAeoiMonitorKykDataFile.setIfcYobi04x01("0");
                khAeoiMonitorKykDataFile.setIfcYobi04x02("0");
                khAeoiMonitorKykDataFile.setIfcYobi04x03("0");
                khAeoiMonitorKykDataFile.setIfcYobi04x04("0");
                khAeoiMonitorKykDataFile.setIfcYobi04x05("0");
                khAeoiMonitorKykDataFile.setIfcYobi04x06("0");
                khAeoiMonitorKykDataFile.setIfcYobi04x07("0");
                khAeoiMonitorKykDataFile.setIfcYobi04x08("0");
                khAeoiMonitorKykDataFile.setIfcYobi04x09("0");
                khAeoiMonitorKykDataFile.setIfcHntiannaihuyouriyuukbn(Strings.padEnd("0", 2, '0'));
                khAeoiMonitorKykDataFile.setIfcDatakanrino(Strings.padEnd("0", 11, '0'));
                khAeoiMonitorKykDataFile.setIfcKaiyakuhrstgkulfhyouji("0");
                khAeoiMonitorKykDataFile.setIfcBknjikoufhyoji("0");
                khAeoiMonitorKykDataFile.setIfcBkncd(Strings.padEnd(" ", 4, ' '));
                khAeoiMonitorKykDataFile.setIfcSkKaiyakuhrbknjkufhyoji("0");
                khAeoiMonitorKykDataFile.setIfcSznkyhknrskthskyfhyj("0");
                khAeoiMonitorKykDataFile.setIfcSznkyhknbknyulfhyoji("0");
                khAeoiMonitorKykDataFile.setIfcTnrsksnytmttdulfhyoji("0");
                khAeoiMonitorKykDataFile.setIfcTnrsksnysustdulfhyoji("0");
                khAeoiMonitorKykDataFile.setIfcTnrsksnbknbnsndfhyj("0");
                khAeoiMonitorKykDataFile.setIfcTnrsksnyzntidulfhyoji("0");
                khAeoiMonitorKykDataFile.setIfcTnrsksnykrwratdulfhyoji("0");
                khAeoiMonitorKykDataFile.setIfcHyumeisaifhyoji("0");
                khAeoiMonitorKykDataFile.setIfcMikeikapbknjkufhyoji("0");
                khAeoiMonitorKykDataFile.setIfcOlskmkkphknfhyj("0");
                khAeoiMonitorKykDataFile.setIfcNkyouksnhytukivfhyj("0");
                khAeoiMonitorKykDataFile.setIfcNkyoubknjkufhyj("0");
                khAeoiMonitorKykDataFile.setIfcNkyouiktulfhyj("0");
                khAeoiMonitorKykDataFile.setIfcNkyouhaitoujynbknhyufhyj("0");
                khAeoiMonitorKykDataFile.setIfcNkyoukaiyakuhrulfhyj("0");
                khAeoiMonitorKykDataFile.setIfcSueokiyouksnlistsksfhyj("0");
                khAeoiMonitorKykDataFile.setIfcYobi05x01(Strings.padEnd("0", 8, '0'));
                khAeoiMonitorKykDataFile.setIfcYobi05x02(Strings.padEnd("0", 8, '0'));
                khAeoiMonitorKykDataFile.setIfcCvkeisanhukahyouji("0");
                khAeoiMonitorKykDataFile.setIfcKaiyakuhrerrkbn(" ");
                khAeoiMonitorKykDataFile.setIfcSznkyhknerrkbn(" ");
                khAeoiMonitorKykDataFile.setIfcHaitoukinerrkbn(" ");
                khAeoiMonitorKykDataFile.setIfcMikeikaperrkbn(" ");
                khAeoiMonitorKykDataFile.setIfcAnkenkanrino6(Strings.padEnd("0", 6, '0'));
                khAeoiMonitorKykDataFile.setIfcAnkenkanrinomaicvgk(BizCurrency.valueOf(0));
                khAeoiMonitorKykDataFile.setIfcCvgktyoukakbn("0");
                khAeoiMonitorKykDataFile.setIfcKykkjmeigihukusuuhyj("0");
                khAeoiMonitorKykDataFile.setIfcKykkjmeigikanrino(Strings.padEnd("0", 6, '0'));
                khAeoiMonitorKykDataFile.setIfcTelnohukusuuhyj("0");
                khAeoiMonitorKykDataFile.setIfcTelnokanrino(Strings.padEnd("0", 6, '0'));
                khAeoiMonitorKykDataFile.setIfcNyskykknmeigi(Strings.padEnd(" ", 25, ' '));
                khAeoiMonitorKykDataFile.setIfcNyskykkjmeigi(Strings.padEnd("　", 50, '　'));
                khAeoiMonitorKykDataFile.setIfcNystelno(Strings.padEnd(" ", 14, ' '));
                khAeoiMonitorKykDataFile.setIfcHjnkeitaikbn(Strings.padEnd("0", 2, '0'));
                khAeoiMonitorKykDataFile.setIfcHjnnm(Strings.padEnd(" ", 30, ' '));
                khAeoiMonitorKykDataFile.setIfcKjhjnnm(Strings.padEnd("　", 30, '　'));
                khAeoiMonitorKykDataFile.setIfcYobi06x01(Strings.padEnd("0", 8, '0'));
                khAeoiMonitorKykDataFile.setIfcYobi06x02(Strings.padEnd("0", 8, '0'));
                khAeoiMonitorKykDataFile.setIfcYobi06x03(Strings.padEnd("0", 8, '0'));
                khAeoiMonitorKykDataFile.setIfcYobi06x04(Strings.padEnd("0", 8, '0'));
                khAeoiMonitorKykDataFile.setIfcYobi06x05(Strings.padEnd("0", 8, '0'));
                khAeoiMonitorKykDataFile.setIfcYobi06x06(Strings.padEnd("0", 8, '0'));
                khAeoiMonitorKykDataFile.setIfcYobi06x07(Strings.padEnd("0", 8, '0'));
                khAeoiMonitorKykDataFile.setIfcYobi06x08(Strings.padEnd("0", 8, '0'));
                khAeoiMonitorKykDataFile.setIfcYobi06x09(Strings.padEnd("0", 8, '0'));
                khAeoiMonitorKykDataFile.setIfcYobi06x10(Strings.padEnd("0", 8, '0'));
                khAeoiMonitorKykDataFile.setIfcYobi06x11(Strings.padEnd("0", 8, '0'));
                khAeoiMonitorKykDataFile.setIfcYobi06x12(Strings.padEnd("0", 8, '0'));
                khAeoiMonitorKykDataFile.setIfcYobi06x13(Strings.padEnd("0", 8, '0'));
                khAeoiMonitorKykDataFile.setIfcYobi06x14(Strings.padEnd("0", 8, '0'));
                khAeoiMonitorKykDataFile.setIfcYobi06x15(Strings.padEnd("0", 8, '0'));
                khAeoiMonitorKykDataFile.setIfcYobi07(Strings.padEnd(" ", 207, ' '));

                khAeoiMonitorKykDataFileList.add(khAeoiMonitorKykDataFile);

                kensuCount++;
            }
            bzRecoveryDatasikibetuBean.initializeBlank();

        }

        bzFileUploadUtil.exec(C_FileSyuruiCdKbn.KH_AEOIMONITORKYKDATA, khAeoiMonitorKykDataFileList, false);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(kensuCount)));
    }

    private String convertDateNullToBlank(BizDate pHenkanZenDate) {

        String henkanGoDate = "";

        if (pHenkanZenDate != null) {
            henkanGoDate = pHenkanZenDate.toString();
        }

        return henkanGoDate;
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();

    }
}
