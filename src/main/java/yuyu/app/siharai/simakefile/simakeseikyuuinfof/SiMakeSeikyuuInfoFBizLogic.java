package yuyu.app.siharai.simakefile.simakeseikyuuinfof;

import static yuyu.app.siharai.simakefile.simakeseikyuuinfof.GenSiMakeSeikyuuInfoFConstants.*;
import static yuyu.app.siharai.simakefile.simakeseikyuuinfof.SiMakeSeikyuuInfoFConstants.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.siharai.simakefile.simakeseikyuuinfof.dba.SiMakeSeikyuuInfoFDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.SaibanBiz;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SiharaiSyoriJyoutaiKbn;
import yuyu.def.db.entity.AS_FileSyurui;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.JV_SeikyuuInfo;
import yuyu.def.siharai.file.csv.SiSeikyuuInfoLayoutFile;

import com.google.common.collect.Lists;

/**
 * 請求情報ファイル作成 のビジネスロジックです。
 */
public class SiMakeSeikyuuInfoFBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SiMakeSeikyuuInfoFUiBean uiBean;

    @Inject
    private SiMakeSeikyuuInfoFDao siMakeSeikyuuInfoFDao;

    @Inject
    private MessageManager messageManager;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private AS_Kinou kinou;

    void init() {
    }

    void clear() {
    }

    String kakuninBtnOnClickBL() {

        BizDate sysDate = BizDate.getSysDate();

        if (BizDateUtil.compareYmd(uiBean.getSibouymdfrom(), sysDate) == BizDateUtil.COMPARE_GREATER) {
            throw new BizLogicException(MessageId.EBF0124, MessageUtil.getMessage(DDID_OUTCONDITIONS_SIBOUYMDFROM
                .getErrorResourceKey()));
        }

        if (uiBean.getSibouymdfrom() != null && uiBean.getSibouymdto() != null) {
            if (BizDateUtil.compareYmd(uiBean.getSibouymdfrom(), uiBean.getSibouymdto()) == BizDateUtil.COMPARE_GREATER) {

                throw new BizLogicException(MessageId.EJA0051, MessageUtil.getMessage(DDID_OUTCONDITIONS_SIBOUYMDFROM
                    .getErrorResourceKey()));
            }
        }

        if (BizDateUtil.compareYmd(uiBean.getSiboukariymdfrom(), sysDate) == BizDateUtil.COMPARE_GREATER) {

            throw new BizLogicException(MessageId.EBF0124,
                MessageUtil.getMessage(DDID_OUTCONDITIONS_SIBOUKARIYMDFROM
                    .getErrorResourceKey()));
        }

        if (uiBean.getSiboukariymdfrom() != null && uiBean.getSiboukariymdto() != null) {
            if (BizDateUtil.compareYmd(uiBean.getSiboukariymdfrom(), uiBean.getSiboukariymdto()) == BizDateUtil.COMPARE_GREATER) {

                throw new BizLogicException(MessageId.EJA0051,
                    MessageUtil.getMessage(DDID_OUTCONDITIONS_SIBOUKARIYMDFROM
                        .getErrorResourceKey()));
            }
        }

        if (BizDateUtil.compareYmd(uiBean.getSyoruiukeymdfrom(), sysDate) == BizDateUtil.COMPARE_GREATER) {

            throw new BizLogicException(MessageId.EBF0124, MessageUtil.getMessage(DDID_OUTCONDITIONS_SYORUIUKEYMDFROM
                .getErrorResourceKey()));
        }

        if (uiBean.getSyoruiukeymdfrom() != null && uiBean.getSyoruiukeymdto() != null) {
            if (BizDateUtil.compareYmd(uiBean.getSyoruiukeymdfrom(), uiBean.getSyoruiukeymdto()) == BizDateUtil.COMPARE_GREATER) {

                throw new BizLogicException(MessageId.EJA0051,
                    MessageUtil.getMessage(DDID_OUTCONDITIONS_SYORUIUKEYMDFROM
                        .getErrorResourceKey()));
            }
        }

        if (BizDateUtil.compareYmd(uiBean.getShrymdfrom(), sysDate) == BizDateUtil.COMPARE_GREATER) {

            throw new BizLogicException(MessageId.EBF0124, MessageUtil.getMessage(DDID_OUTCONDITIONS_SHRYMDFROM
                .getErrorResourceKey()));
        }

        if (uiBean.getShrymdfrom() != null && uiBean.getShrymdto() != null) {
            if (BizDateUtil.compareYmd(uiBean.getShrymdfrom(), uiBean.getShrymdto()) == BizDateUtil.COMPARE_GREATER) {

                throw new BizLogicException(MessageId.EJA0051, MessageUtil.getMessage(DDID_OUTCONDITIONS_SHRYMDFROM
                    .getErrorResourceKey()));
            }
        }

        C_SeikyuuSyubetu seikyuusyubetu = null;

        if (C_SiharaiSyoriJyoutaiKbn.MISEIKYUU.eq(uiBean.getSiharaisyorijyoutaikbn())) {

            seikyuusyubetu = C_SeikyuuSyubetu.SBKRUKTK;
        }

        else if (C_SiharaiSyoriJyoutaiKbn.UKETUKETYUU.eq(uiBean.getSiharaisyorijyoutaikbn())
            || C_SiharaiSyoriJyoutaiKbn.SIHARAIZUMI.eq(uiBean.getSiharaisyorijyoutaikbn())) {

            seikyuusyubetu = C_SeikyuuSyubetu.SB;
        }

        else if (C_SiharaiSyoriJyoutaiKbn.SINDANSYORYOUSIHARAI.eq(uiBean.getSiharaisyorijyoutaikbn())) {

            seikyuusyubetu = C_SeikyuuSyubetu.SDSSHR;
        }

        List<JV_SeikyuuInfo> seikyuuinfo = siMakeSeikyuuInfoFDao.getSeikyuuInfoBySyuturyokutaisyou(
            uiBean.getSiharaisyorijyoutaikbn(), seikyuusyubetu, uiBean.getSibouymdfrom(), uiBean.getSibouymdto(),
            uiBean.getSiboukariymdfrom(), uiBean.getSiboukariymdto(), uiBean.getSyoruiukeymdfrom(),
            uiBean.getSyoruiukeymdto(), uiBean.getShrymdfrom(), uiBean.getShrymdto());

        if (seikyuuinfo.size() == 0) {

            throw new BizLogicException(MessageId.EBA0048);
        }

        else if (seikyuuinfo.size() > TYUUSYUTU_MAX_NUM) {

            throw new BizLogicException(MessageId.EBF0110);
        }

        uiBean.setSeikyuuInfoList(seikyuuinfo);

        messageManager.addMessageId(MessageId.QBA0001);

        return FORWARDNAME_CONFIRM;
    }

    String kakuteiBtnOnClickBL() {

        BizDate sysDate = BizDate.getSysDate();

        List<SiSeikyuuInfoLayoutFile> siSeikyuuInfoLayoutFileList = Lists.newArrayList();

        for (JV_SeikyuuInfo seikyuuInfo : uiBean.getSeikyuuInfoList()) {

            SiSeikyuuInfoLayoutFile siSeikyuuInfoLayoutFile = SWAKInjector
                .getInstance(SiSeikyuuInfoLayoutFile.class);

            if (seikyuuInfo.getTtdktyuuikbn1() != null) {
                siSeikyuuInfoLayoutFile.setIfcHnykttdktyuuikbn1(seikyuuInfo.getTtdktyuuikbn1().getContent());
                siSeikyuuInfoLayoutFile.setIfcHnykttdktyuuikbn2(seikyuuInfo.getTtdktyuuikbn2().getContent());
                siSeikyuuInfoLayoutFile.setIfcHnykttdktyuuikbn3(seikyuuInfo.getTtdktyuuikbn3().getContent());
                siSeikyuuInfoLayoutFile.setIfcHnykttdktyuuikbn4(seikyuuInfo.getTtdktyuuikbn4().getContent());
                siSeikyuuInfoLayoutFile.setIfcHnykttdktyuuikbn5(seikyuuInfo.getTtdktyuuikbn5().getContent());
            }

            if (seikyuuInfo.getUktkbn() != null) {
                siSeikyuuInfoLayoutFile.setIfcHnykuktkbn(seikyuuInfo.getUktkbn().getContent());
            }

            if (seikyuuInfo.getZeitratkikbn() != null) {
                siSeikyuuInfoLayoutFile.setIfcHnykzeitratkikbn(seikyuuInfo.getZeitratkikbn().getContent());
            }
            siSeikyuuInfoLayoutFile.setIfcSyono(seikyuuInfo.getSyono());
            siSeikyuuInfoLayoutFile.setIfcSkno(seikyuuInfo.getSkno());
            siSeikyuuInfoLayoutFile.setIfcSeikyuusyubetu(seikyuuInfo.getSeikyuusyubetu().getContent());
            siSeikyuuInfoLayoutFile.setIfcSaisateikbn(seikyuuInfo.getSaisateikbn());
            siSeikyuuInfoLayoutFile.setIfcSiboukariymd(seikyuuInfo.getSiboukaritrkymd());
            siSeikyuuInfoLayoutFile.setIfcSibouymd(seikyuuInfo.getSibouymd());
            siSeikyuuInfoLayoutFile.setIfcHnykgeninkbn(seikyuuInfo.getGeninkbn().getContent());
            siSeikyuuInfoLayoutFile.setIfcHnyksiinkbn(seikyuuInfo.getSiinkbn().getContent());
            siSeikyuuInfoLayoutFile.setIfcKykymd(seikyuuInfo.getKykymd());
            siSeikyuuInfoLayoutFile.setIfcKyknmkj(seikyuuInfo.getKyknmkj());
            siSeikyuuInfoLayoutFile.setIfcKyknmkn(seikyuuInfo.getKyknmkn());
            siSeikyuuInfoLayoutFile.setIfcHhknnmkj(seikyuuInfo.getHhknnmkj());
            siSeikyuuInfoLayoutFile.setIfcHhknnmkn(seikyuuInfo.getHhknnmkn());
            siSeikyuuInfoLayoutFile.setIfcHhknseiymd(seikyuuInfo.getHhknseiymd());
            siSeikyuuInfoLayoutFile.setIfcHhknsei(seikyuuInfo.getHhknsei());
            siSeikyuuInfoLayoutFile.setIfcSbuktnin(seikyuuInfo.getSbuktnin());
            siSeikyuuInfoLayoutFile.setIfcUktnmkj(seikyuuInfo.getUktnmkj());
            siSeikyuuInfoLayoutFile.setIfcUktseiymd(seikyuuInfo.getUktseiymd());
            siSeikyuuInfoLayoutFile.setIfcUktbnwari(seikyuuInfo.getUktbnwari());
            siSeikyuuInfoLayoutFile.setIfcSyouhncd(seikyuuInfo.getSyouhncd());
            siSeikyuuInfoLayoutFile.setIfcSaiteihosyouumu(seikyuuInfo.getInitsbjiyensitihsytkhukaumu());
            siSeikyuuInfoLayoutFile.setIfcTtdktyuuinaiyou1(seikyuuInfo.getTtdktyuuinaiyou1());
            siSeikyuuInfoLayoutFile.setIfcTtdktyuuinaiyou2(seikyuuInfo.getTtdktyuuinaiyou2());
            siSeikyuuInfoLayoutFile.setIfcTtdktyuuinaiyou3(seikyuuInfo.getTtdktyuuinaiyou3());
            siSeikyuuInfoLayoutFile.setIfcTtdktyuuikbnhsknaiyou1(seikyuuInfo.getTtdktyuuikbnhsknaiyou1());
            siSeikyuuInfoLayoutFile.setIfcTtdktyuuikbnsetymd1(seikyuuInfo.getTtdktyuuikbnsetymd1());
            siSeikyuuInfoLayoutFile.setIfcTtdktyuuikbnhsknaiyou2(seikyuuInfo.getTtdktyuuikbnhsknaiyou2());
            siSeikyuuInfoLayoutFile.setIfcTtdktyuuikbnsetymd2(seikyuuInfo.getTtdktyuuikbnsetymd2());
            siSeikyuuInfoLayoutFile.setIfcTtdktyuuikbnhsknaiyou3(seikyuuInfo.getTtdktyuuikbnhsknaiyou3());
            siSeikyuuInfoLayoutFile.setIfcTtdktyuuikbnsetymd3(seikyuuInfo.getTtdktyuuikbnsetymd3());
            siSeikyuuInfoLayoutFile.setIfcTtdktyuuikbnhsknaiyou4(seikyuuInfo.getTtdktyuuikbnhsknaiyou4());
            siSeikyuuInfoLayoutFile.setIfcTtdktyuuikbnsetymd4(seikyuuInfo.getTtdktyuuikbnsetymd4());
            siSeikyuuInfoLayoutFile.setIfcTtdktyuuikbnhsknaiyou5(seikyuuInfo.getTtdktyuuikbnhsknaiyou5());
            siSeikyuuInfoLayoutFile.setIfcTtdktyuuikbnsetymd5(seikyuuInfo.getTtdktyuuikbnsetymd5());
            siSeikyuuInfoLayoutFile.setIfcHnykseikyuusyakbn(seikyuuInfo.getSeikyuusyakbn().getContent());
            siSeikyuuInfoLayoutFile.setIfcSeikyuusyanmkn(seikyuuInfo.getSeikyuusyanmkn());
            siSeikyuuInfoLayoutFile.setIfcSeikyuusyanmkj(seikyuuInfo.getSeikyuusyanmkj());
            siSeikyuuInfoLayoutFile.setIfcTsinyno(seikyuuInfo.getTsinyno());
            siSeikyuuInfoLayoutFile.setIfcTsinadr1kj(seikyuuInfo.getTsinadr1kj());
            siSeikyuuInfoLayoutFile.setIfcTsinadr2kj(seikyuuInfo.getTsinadr2kj());
            siSeikyuuInfoLayoutFile.setIfcTsinadr3kj(seikyuuInfo.getTsinadr3kj());
            siSeikyuuInfoLayoutFile.setIfcSyoruiukeymd(seikyuuInfo.getSyoruiukeymd());
            siSeikyuuInfoLayoutFile.setIfcHubikanryouymd(seikyuuInfo.getHubikanryouymd());
            siSeikyuuInfoLayoutFile.setIfcHnykshrkekkakbn(seikyuuInfo.getShrkekkakbn().getContent());
            siSeikyuuInfoLayoutFile.setIfcSaigaihigaitoukbn(seikyuuInfo.getSaigaihigaitoukbn());
            siSeikyuuInfoLayoutFile.setIfcShrsyoriymd(seikyuuInfo.getShrsyoriymd());
            siSeikyuuInfoLayoutFile.setIfcShrymd(seikyuuInfo.getTyakkinymd());
            siSeikyuuInfoLayoutFile.setIfcShrkgbizc(seikyuuInfo.getShrgkkei());
            siSeikyuuInfoLayoutFile.setIfcShrtuukasyu(seikyuuInfo.getShrtuukasyu());
            siSeikyuuInfoLayoutFile.setIfcShrkwsrate(seikyuuInfo.getShrkwsrate());
            siSeikyuuInfoLayoutFile.setIfcShrkwsratekjnymd(seikyuuInfo.getShrkwsratekjnymd());
            siSeikyuuInfoLayoutFile.setIfcGaikaknsnkwsrate(seikyuuInfo.getGaikaknsnkwsrate());
            siSeikyuuInfoLayoutFile.setIfcGaikaknsnkwsratekjymd(seikyuuInfo.getGaikaknsnkwsratekjymd());
            siSeikyuuInfoLayoutFile.setIfcHokenkngkgoukeibizc(seikyuuInfo.getHokenkngkgoukei());
            siSeikyuuInfoLayoutFile.setIfcHaitoukinbizc(seikyuuInfo.getHaitoukin());
            siSeikyuuInfoLayoutFile.setIfcSonotahaitoukinbizc(seikyuuInfo.getSonotahaitoukin());
            siSeikyuuInfoLayoutFile.setIfcMisyuupbizc(seikyuuInfo.getMisyuup());
            siSeikyuuInfoLayoutFile.setIfcMikeikapbizc(seikyuuInfo.getMikeikap());
            siSeikyuuInfoLayoutFile.setIfcZennouseisankgkbizc(seikyuuInfo.getZennouseisankgk());
            siSeikyuuInfoLayoutFile.setIfcAzukarikingkbizc(seikyuuInfo.getAzukarikingk());
            siSeikyuuInfoLayoutFile.setIfcKrkgkbizc(seikyuuInfo.getKrkgk());
            siSeikyuuInfoLayoutFile.setIfcShrtienrskbizc(seikyuuInfo.getShrtienrsk());
            siSeikyuuInfoLayoutFile.setIfcYenshrgkbizc(seikyuuInfo.getYenshrgk());
            siSeikyuuInfoLayoutFile.setIfcYenhkgkgoukeibizc(seikyuuInfo.getYenhkgkgoukei());
            siSeikyuuInfoLayoutFile.setIfcYenkahaitoukinbizc(seikyuuInfo.getYenkahaitoukin());
            siSeikyuuInfoLayoutFile.setIfcYenkasonotahaitoukinbizc(seikyuuInfo.getYenkasonotahaitoukin());
            siSeikyuuInfoLayoutFile.setIfcYenkamisyuupbizc(seikyuuInfo.getYenkamisyuup());
            siSeikyuuInfoLayoutFile.setIfcYenkamikeikapbizc(seikyuuInfo.getYenkamikeikap());
            siSeikyuuInfoLayoutFile.setIfcYenkazennouseisankgkbizc(seikyuuInfo.getYenkazennouseisankgk());
            siSeikyuuInfoLayoutFile.setIfcYenkaazukarikingkbizc(seikyuuInfo.getYenkaazukarikingk());
            siSeikyuuInfoLayoutFile.setIfcYenkakrkgkbizc(seikyuuInfo.getYenkakrkgk());
            siSeikyuuInfoLayoutFile.setIfcYenshrtienrskbizc(seikyuuInfo.getYenshrtienrsk());
            siSeikyuuInfoLayoutFile.setIfcZitkazkrknsiteituukabizc(seikyuuInfo.getZitkazukarikingksiteituuka());
            siSeikyuuInfoLayoutFile.setIfcZitkazukarikingkyenbizc(seikyuuInfo.getZitkazukarikingkyen());
            siSeikyuuInfoLayoutFile.setIfcGaikaknsntkgkbizc(seikyuuInfo.getGaikaknsntkgk());
            siSeikyuuInfoLayoutFile.setIfcGaikaknsnkekkakgkbizc(seikyuuInfo.getGaikaknsnkekkakgk());
            siSeikyuuInfoLayoutFile.setIfcYenkaknsntkgkbizc(seikyuuInfo.getYenkaknsntkgk());
            siSeikyuuInfoLayoutFile.setIfcYenkaknsnkekkakgkbizc(seikyuuInfo.getYenkaknsnkekkakgk());
            siSeikyuuInfoLayoutFile.setIfcKyktuukasyukbn(seikyuuInfo.getKyktuukasyu());
            siSeikyuuInfoLayoutFile.setIfcShrhou(seikyuuInfo.getInputshrhousiteikbn().getContent());
            siSeikyuuInfoLayoutFile.setIfcZeimukwsrate(seikyuuInfo.getZeimukwsrate());
            siSeikyuuInfoLayoutFile.setIfcZeimukwsratekjnymd(seikyuuInfo.getZeimukwsratekjnymd());

            siSeikyuuInfoLayoutFileList.add(siSeikyuuInfoLayoutFile);
        }

        AS_FileSyurui syurui = baseDomManager.getFileSyurui(C_FileSyuruiCdKbn.SI_SEIKYUUINFO);

        if (syurui == null) {

            throw new BizLogicException(MessageId.EBF0129, MessageUtil.getMessage(kinou.getKinouNm()));
        }

        String downloadFileNm = syurui.getDownloadFileNm();

        if (downloadFileNm.matches(".*\\..*")) {
            downloadFileNm = downloadFileNm.split("\\.")[0];
        }

        String seikyuInfFRenNo = SaibanBiz.getSeikyuuInfoFRenNo(String.valueOf(sysDate));

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(C_FileSyuruiCdKbn.SI_SEIKYUUINFO, siSeikyuuInfoLayoutFileList,
            true, seikyuInfFRenNo);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            throw new BizLogicException(MessageId.EBF0129, MessageUtil.getMessage(kinou.getKinouNm()));
        }

        messageManager.addMessageId(MessageId.IAC0009);

        messageManager.addMessageId(MessageId.IBA1009, downloadFileNm + "_" + sysDate + "_" + seikyuInfFRenNo);

        return FORWARDNAME_RESULT;
    }

    String modoruBtnOnClickBL() {

        return FORWARDNAME_INPUTCONDITIONS;
    }
}
