package yuyu.batch.hozen.khkessan.khbikinjikoulistsks;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.hozen.khcommon.SetKessanNensibi;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_Bknkessankbn;
import yuyu.def.classification.C_BknsyutkKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SosikimasterUmuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.hozen.bean.report.KhKaiyakuBikinjikouListBean;
import yuyu.def.hozen.bean.report.KhKaiyakuBikinjikouListDataSourceBean;
import yuyu.def.hozen.file.csv.KhBikinJikouLstCsvfKaiyakuFile;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 契約保全 決算 契約保全備金時効リスト作成（解約）
 */
public class KhBikinJikouListSksBatch implements Batch {

    private  final String TABLE_ID = "IT_KhBikinkanri";

    private  final String RECOVERY_FILTER_ID =  "Bz001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private KhBikinJikouListSksBatchParam khBikinJikouListSksBatchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private BizDomManager bizDomManager;

    @Override
    public BatchParam getParam() {

        return khBikinJikouListSksBatchParam;
    }

    @Execute
    @Transactional
    public void Execute() {

        BizDate syoriYmd = khBikinJikouListSksBatchParam.getSyoriYmd();

        BizDate kessanYmd = khBikinJikouListSksBatchParam.getKessanYmd();

        String kakutyoujobCd = khBikinJikouListSksBatchParam.getIbKakutyoujobcd();

        List<KhBikinJikouLstCsvfKaiyakuFile> khBikinJikouLstCsvfKaiyakuFileList =
            new ArrayList<KhBikinJikouLstCsvfKaiyakuFile>();

        List<IReportDataSouceBean> khKaiyakuBikinjikouListDsbeanList = new ArrayList<>();

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, "<<バッチ処理年月日>>", syoriYmd.toString()));

        try (ExDBResults<IT_KhBikinkanri> khBikinkanriList = hozenDomManager.
            getKhBikinkanrisByKakutyoujobcdKessankijyunymd(kakutyoujobCd, kessanYmd)) {

            CreateReport createReport  = SWAKInjector.getInstance(CreateReport.class);

            ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                kinou.getSubSystemId(), kinou.getCategoryId(),
                kinou.getKinouId(), C_SyoruiCdKbn.KK_KAIYAKU_BIKINJIKOUKIST);

            String tyouhyouSakuseiYmd = DateFormatUtil.dateKANJINoEx(syoriYmd);

            String busituCd =bizDomManager.getTantouCd(C_TantouCdKbn.KAIYAKU).getBusitucd();

            BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

            String tantsituNm = "";

            BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(busituCd + "0000");

            if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())){

                tantsituNm = bzGetSosikiDataBean.getKanjisosikinm20();

            }

            SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);

            BizDate kessanNensibi = setKessanNensibi.exec(kessanYmd);

            String kessanNnd = DateFormatUtil.dateYKANJISeireki(kessanNensibi.getBizDateY()).concat("度");

            C_Bknkessankbn bknkessanKbn = C_Bknkessankbn.BLNK;

            if (kessanYmd.getMonth() == 3) {

                bknkessanKbn = C_Bknkessankbn.KESSAN;

            }
            else if (kessanYmd.getMonth() == 6) {

                bknkessanKbn = C_Bknkessankbn.SHNK;

            }
            else if (kessanYmd.getMonth() == 9) {

                bknkessanKbn = C_Bknkessankbn.HNK;

            }
            else if (kessanYmd.getMonth() == 12) {

                bknkessanKbn = C_Bknkessankbn.SHNK;

            }

            String hozonKkn = ViewReport.getHozonKknTani(C_SyoruiCdKbn.KK_KAIYAKU_BIKINJIKOUKIST);

            KhKaiyakuBikinjikouListBean khKaiyakuBikinjikouListBean = SWAKInjector
                .getInstance(KhKaiyakuBikinjikouListBean.class);

            khKaiyakuBikinjikouListBean.setIrTantsitunmkj(tantsituNm);

            khKaiyakuBikinjikouListBean.setIrTantocd(C_TantouCdKbn.KAIYAKU);

            khKaiyakuBikinjikouListBean.setIrKessannnd(kessanNnd);

            khKaiyakuBikinjikouListBean.setIrBknkessankbn(bknkessanKbn);

            khKaiyakuBikinjikouListBean.setIrTyouhyousakuseiymdwareki(tyouhyouSakuseiYmd);

            khKaiyakuBikinjikouListBean.setIrHozonkkn(hozonKkn);

            long outKensuu = 0;

            int pageNo = 1;

            int pageCount = 0;

            BizDateYM bknkktiYmKey = null;

            BizDateY bknkktiNndKey = null;

            C_Segcd hknsyuruiKey = null;

            C_BkncdKbn bkncdKey = null;

            KuBikinjikouListSksBean khBikinkouListSksYm = new KuBikinjikouListSksBean();

            KuBikinjikouListSksBean khBikinkouListSksY = new KuBikinjikouListSksBean();

            KuBikinjikouListSksBean khBikinkouListSksBx = new KuBikinjikouListSksBean();

            KuBikinjikouListSksBean khBikinkouListSksB = new KuBikinjikouListSksBean();

            for (IT_KhBikinkanri khBikinkanri : khBikinkanriList) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);

                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_ID);

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khBikinkanri.getSyono());

                String bknkktYmd = DateFormatUtil.dateKANJINoEx(khBikinkanri.getBknkktymd());

                String calckijyunYmd = DateFormatUtil.dateKANJINoEx(khBikinkanri.getCalckijyunymd());

                BizDateY kessanNensiY = setKessanNensibi.exec(khBikinkanri.getBknkktymd()).getBizDateY();

                String bknkktiNnd = DateFormatUtil.dateYKANJISeireki(kessanNensiY).concat("度");

                String bknkktiYm = DateFormatUtil.dateYmKANJINoEx(khBikinkanri.getBknkktymd().getBizDateYM());

                if (outKensuu == 0) {
                    bknkktiYmKey = khBikinkanri.getBknkktymd().getBizDateYM();

                    bknkktiNndKey = kessanNensiY;

                    hknsyuruiKey = khBikinkanri.getKbnkeirisegcd();

                    bkncdKey = khBikinkanri.getBkncdkbn();
                }
                else {
                    boolean flag = false;

                    if (BizDateUtil.compareYm(bknkktiYmKey, khBikinkanri.getBknkktymd().getBizDateYM()) !=
                        BizDateUtil.COMPARE_EQUAL ||
                        !khBikinkanri.getKbnkeirisegcd().eq(hknsyuruiKey) ||
                        !khBikinkanri.getBkncdkbn().eq(bkncdKey)) {

                        KhKaiyakuBikinjikouListDataSourceBean khKaiyakuBikinjikouListDsbean =
                            editKhBikinJikouListYM(bkncdKey, hknsyuruiKey, bknkktiNndKey, bknkktiYmKey,
                                khBikinkouListSksYm);

                        khKaiyakuBikinjikouListDsbeanList.add(khKaiyakuBikinjikouListDsbean);

                        bknkktiYmKey = khBikinkanri.getBknkktymd().getBizDateYM();

                        pageNo = pageNo + 1;

                        pageCount = 0;

                        khBikinkouListSksYm = new KuBikinjikouListSksBean();

                        flag = true;
                    }

                    if (kessanNensiY.compareTo(bknkktiNndKey) != 0 ||
                        !khBikinkanri.getKbnkeirisegcd().eq(hknsyuruiKey) ||
                        !khBikinkanri.getBkncdkbn().eq(bkncdKey)) {

                        KhKaiyakuBikinjikouListDataSourceBean khKaiyakuBikinjikouListDsbean =
                            editKhBikinJikouListY(bkncdKey, hknsyuruiKey, bknkktiNndKey, khBikinkouListSksY);

                        khKaiyakuBikinjikouListDsbeanList.add(khKaiyakuBikinjikouListDsbean);

                        bknkktiNndKey = kessanNensiY;

                        pageNo = pageNo + 1;

                        pageCount = 0;

                        khBikinkouListSksY = new KuBikinjikouListSksBean();

                        flag = true;
                    }

                    if (!khBikinkanri.getKbnkeirisegcd().eq(hknsyuruiKey) ||
                        !khBikinkanri.getBkncdkbn().eq(bkncdKey)) {

                        KhKaiyakuBikinjikouListDataSourceBean khKaiyakuBikinjikouListDsbean =
                            editKhBikinJikouListInsurance(bkncdKey, hknsyuruiKey, khBikinkouListSksBx);

                        khKaiyakuBikinjikouListDsbeanList.add(khKaiyakuBikinjikouListDsbean);

                        hknsyuruiKey = khBikinkanri.getKbnkeirisegcd();

                        pageNo = pageNo + 1;

                        pageCount = 0;

                        khBikinkouListSksBx = new KuBikinjikouListSksBean();

                        flag = true;
                    }

                    if (!khBikinkanri.getBkncdkbn().eq(bkncdKey)) {

                        KhKaiyakuBikinjikouListDataSourceBean khKaiyakuBikinjikouListDsbean =
                            editKhBikinJikouListCodeSet(bkncdKey, khBikinkouListSksB);

                        khKaiyakuBikinjikouListDsbeanList.add(khKaiyakuBikinjikouListDsbean);

                        bkncdKey = khBikinkanri.getBkncdkbn();

                        pageNo = pageNo + 1;

                        pageCount = 0;

                        khBikinkouListSksB = new KuBikinjikouListSksBean();

                        flag = true;
                    }

                    if (!flag) {

                        if (pageCount == 37) {

                            pageNo = pageNo + 1;

                            pageCount = 0;

                        }
                    }
                }

                outKensuu  =   outKensuu + 1;

                pageCount = pageCount + 1;

                khBikinkouListSksYm.setKensuu((khBikinkouListSksYm.getKensuu().add(BizNumber.valueOf(1))));

                khBikinkouListSksYm.setKingaku(khBikinkouListSksYm.getKingaku().add(khBikinkanri.getBkngk()));

                khBikinkouListSksY.setKensuu(khBikinkouListSksY.getKensuu().add(BizNumber.valueOf(1)));

                khBikinkouListSksY.setKingaku(khBikinkouListSksY.getKingaku().add(khBikinkanri.getBkngk()));

                khBikinkouListSksBx.setKensuu(khBikinkouListSksBx.getKensuu().add(BizNumber.valueOf(1)));

                khBikinkouListSksBx.setKingaku(khBikinkouListSksBx.getKingaku().add(khBikinkanri.getBkngk()));

                khBikinkouListSksB.setKensuu(khBikinkouListSksB.getKensuu().add(BizNumber.valueOf(1)));

                khBikinkouListSksB.setKingaku(khBikinkouListSksB.getKingaku().add(khBikinkanri.getBkngk()));

                KhKaiyakuBikinjikouListDataSourceBean khKaiyakuBikinjikouListDsbean =
                    SWAKInjector.getInstance(KhKaiyakuBikinjikouListDataSourceBean.class);

                khKaiyakuBikinjikouListDsbean.setIrBkncd(khBikinkanri.getBkncdkbn().toString());

                khKaiyakuBikinjikouListDsbean.setIrShrumu(khBikinkanri.getShrumu());

                khKaiyakuBikinjikouListDsbean.setIrBknkktiymdwareki(bknkktYmd);

                khKaiyakuBikinjikouListDsbean.setIrCalckijyunymdwareki(calckijyunYmd);

                khKaiyakuBikinjikouListDsbean.setIrSisyacd(khBikinkanri.getSisyacd());

                khKaiyakuBikinjikouListDsbean.setIrKigou(khBikinkanri.getSyouhncd().substring(0, 2));

                khKaiyakuBikinjikouListDsbean.setIrSyono(khBikinkanri.getSyono());

                khKaiyakuBikinjikouListDsbean.setIrBkngk(khBikinkanri.getBkngk());

                khKaiyakuBikinjikouListDsbean.setIrKihons(khBikinkanri.getKihons());

                khKaiyakuBikinjikouListDsbean.setIrTks(BizCurrency.valueOf(0));

                khKaiyakuBikinjikouListDsbean.setIrTkkigou("");

                khKaiyakuBikinjikouListDsbean.setIrKata("");

                khKaiyakuBikinjikouListDsbean.setIrSaisiumukbn("");

                khKaiyakuBikinjikouListDsbean.setIrSinsaumukbn(khBikinkanri.getSinsaumukbn());

                khKaiyakuBikinjikouListDsbean.setIrSoukiumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinjikouListDsbean.setIrSakugenumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinjikouListDsbean.setIrTenkanumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinjikouListDsbean.setIrKbnkeirihknsyuruinm(khBikinkanri.getKbnkeirisegcd());

                khKaiyakuBikinjikouListDsbean.setIrBknsyutkkbn(C_BknsyutkKbn.BLNK);

                khKaiyakuBikinjikouListDsbean.setIrBknkktinnd(bknkktiNnd);

                khKaiyakuBikinjikouListDsbean.setIrBknkktiym(bknkktiYm);

                khKaiyakuBikinjikouListDsbean.setIrSyuukeiinfo1("");

                khKaiyakuBikinjikouListDsbean.setIrSyuukeiinfo2("");

                khKaiyakuBikinjikouListDsbean.setIrSyuukeiinfo3("");

                khKaiyakuBikinjikouListDsbean.setIrSyuukeiinfo4("");

                khKaiyakuBikinjikouListDsbean.setIrSyuukeiinfo5("");

                khKaiyakuBikinjikouListDsbean.setIrUtiwake1("");

                khKaiyakuBikinjikouListDsbean.setIrKensuu1(BizNumber.valueOf(0));

                khKaiyakuBikinjikouListDsbean.setIrKingaku1(BizCurrency.valueOf(0));

                khKaiyakuBikinjikouListDsbean.setIrBikinjikoulistgoukeitani("");

                khKaiyakuBikinjikouListDsbean.setIrBikinjikoulistgoukeicount(BizNumber.valueOf(0));

                khKaiyakuBikinjikouListDsbean.setIrKingakugoukei(BizCurrency.valueOf(0));

                khKaiyakuBikinjikouListDsbean.setIrGoukeiumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinjikouListDsbeanList.add(khKaiyakuBikinjikouListDsbean);

                String syoriYmdSeireki = DateFormatUtil.dateKANJINoEx(syoriYmd);

                String kessanNendoMae = DateFormatUtil.dateYKANJISeireki(
                    setKessanNensibi.exec(khBikinkanri.getKessankijyunymd()).getBizDateY()).concat("度");

                String  dbknkessanKbn = "";

                if (khBikinkanri.getKessankijyunymd().getMonth() == 3) {

                    dbknkessanKbn = "決算" ;

                }
                else if (khBikinkanri.getKessankijyunymd().getMonth() ==  6) {

                    dbknkessanKbn = "四半期";

                }
                else if (khBikinkanri.getKessankijyunymd().getMonth() == 9) {

                    dbknkessanKbn = "半期";

                }
                else if (khBikinkanri.getKessankijyunymd().getMonth() == 12) {

                    dbknkessanKbn = "四半期";

                }
                kessanNnd = kessanNendoMae + dbknkessanKbn;

                KhBikinJikouLstCsvfKaiyakuFile khBikinJikouLstCsvfKaiyakuFile = SWAKInjector.getInstance(
                    KhBikinJikouLstCsvfKaiyakuFile.class);

                khBikinJikouLstCsvfKaiyakuFile.setIfcListnm("備金時効リスト");

                khBikinJikouLstCsvfKaiyakuFile.setIfcAtesaki(tantsituNm);

                khBikinJikouLstCsvfKaiyakuFile.setIfcSakuseiymdwareki(syoriYmdSeireki);

                khBikinJikouLstCsvfKaiyakuFile.setIfcPageno(String.valueOf(pageNo));

                khBikinJikouLstCsvfKaiyakuFile.setIfcHknsyurui(khBikinkanri.getKbnkeirisegcd().getContent());

                khBikinJikouLstCsvfKaiyakuFile.setIfcKessannnd(kessanNnd);

                khBikinJikouLstCsvfKaiyakuFile.setIfcBkncd(khBikinkanri.getBkncdkbn().toString());

                if (khBikinkanri.getShrumu().eq(C_UmuKbn.ARI)) {
                    khBikinJikouLstCsvfKaiyakuFile.setIfcShrhyj("*");
                }
                else if (khBikinkanri.getShrumu().eq(C_UmuKbn.NONE) ) {
                    khBikinJikouLstCsvfKaiyakuFile.setIfcShrhyj("");
                }

                khBikinJikouLstCsvfKaiyakuFile.setIfcBknkktiymdwareki(bknkktYmd);

                khBikinJikouLstCsvfKaiyakuFile.setIfcCalckijyunymdwareki(calckijyunYmd);

                khBikinJikouLstCsvfKaiyakuFile.setIfcSisyacd(khBikinkanri.getSisyacd());

                khBikinJikouLstCsvfKaiyakuFile.setIfcHknsyuruikigou(khBikinkanri.getSyouhncd().substring(0, 2));

                khBikinJikouLstCsvfKaiyakuFile.setIfcSyono(khBikinkanri.getSyono());

                khBikinJikouLstCsvfKaiyakuFile.setIfcBkngk(khBikinkanri.getBkngk().toString());

                khBikinJikouLstCsvfKaiyakuFile.setIfcKihons(khBikinkanri.getKihons().toString());

                khBikinJikouLstCsvfKaiyakuFile.setIfcTks("");

                khBikinJikouLstCsvfKaiyakuFile.setIfcTkkigou("");

                khBikinJikouLstCsvfKaiyakuFile.setIfcTkkata("");

                khBikinJikouLstCsvfKaiyakuFile.setIfcSaisikbn("");

                khBikinJikouLstCsvfKaiyakuFile.setIfcSinsahyj("");

                khBikinJikouLstCsvfKaiyakuFile.setIfcSoukihyj("");

                khBikinJikouLstCsvfKaiyakuFile.setIfcSkgnhyj("");

                khBikinJikouLstCsvfKaiyakuFile.setIfcTnknhyj("");

                khBikinJikouLstCsvfKaiyakuFileList.add(khBikinJikouLstCsvfKaiyakuFile);
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            if (outKensuu > 0) {
                KhKaiyakuBikinjikouListDataSourceBean khKaiyakuBikinjikouListDsbean =
                    editKhBikinJikouListYM(bkncdKey, hknsyuruiKey, bknkktiNndKey, bknkktiYmKey, khBikinkouListSksYm);

                khKaiyakuBikinjikouListDsbeanList.add(khKaiyakuBikinjikouListDsbean);

                khKaiyakuBikinjikouListDsbean =
                    editKhBikinJikouListY(bkncdKey, hknsyuruiKey, bknkktiNndKey, khBikinkouListSksY);

                khKaiyakuBikinjikouListDsbeanList.add(khKaiyakuBikinjikouListDsbean);

                khKaiyakuBikinjikouListDsbean =
                    editKhBikinJikouListInsurance(bkncdKey, hknsyuruiKey, khBikinkouListSksBx);

                khKaiyakuBikinjikouListDsbeanList.add(khKaiyakuBikinjikouListDsbean);

                khKaiyakuBikinjikouListDsbean =
                    editKhBikinJikouListCodeSet(bkncdKey, khBikinkouListSksB);

                khKaiyakuBikinjikouListDsbeanList.add(khKaiyakuBikinjikouListDsbean);

            }
            reportServicesBean.addParamObjects(khKaiyakuBikinjikouListDsbeanList,khKaiyakuBikinjikouListBean);
            reportServicesBean.setSyoriYmd(syoriYmd);
            createReport.execNoCommit(reportServicesBean);

            C_ErrorKbn errorKbn = bzFileUploadUtil.exec(C_FileSyuruiCdKbn.KH_BIKINJIKOULSTCSVFKAIYAKU,
                khBikinJikouLstCsvfKaiyakuFileList, true);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
            }


            batchLogger.info(MessageUtil.getMessage(
                MessageId.IBF0002, String.valueOf(outKensuu), "<<解約備金時効リスト>>"));

        }
    }

    private KhKaiyakuBikinjikouListDataSourceBean editKhBikinJikouListYM(C_BkncdKbn pBkncd, C_Segcd pHknsyurui,
        BizDateY pBknkktiNnd, BizDateYM pBknkktiYm, KuBikinjikouListSksBean pKuBikinjikouListSksBean) {

        KhKaiyakuBikinjikouListDataSourceBean khKaiyakuBikinjikouListDsbean = SWAKInjector
            .getInstance(KhKaiyakuBikinjikouListDataSourceBean.class);

        String bknkktiNnd = DateFormatUtil.dateYKANJISeireki(pBknkktiNnd).concat("度");

        String bknkktiYm = DateFormatUtil.dateYmKANJINoEx(pBknkktiYm);

        khKaiyakuBikinjikouListDsbean.setIrSyuukeiinfo1(pBkncd.toString());

        khKaiyakuBikinjikouListDsbean.setIrSyuukeiinfo2("");

        khKaiyakuBikinjikouListDsbean.setIrSyuukeiinfo3(pHknsyurui.getContent());

        khKaiyakuBikinjikouListDsbean.setIrSyuukeiinfo4(bknkktiNnd);

        khKaiyakuBikinjikouListDsbean.setIrSyuukeiinfo5(bknkktiYm);

        khKaiyakuBikinjikouListDsbean.setIrUtiwake1("主契約");

        khKaiyakuBikinjikouListDsbean.setIrKensuu1(pKuBikinjikouListSksBean.getKensuu());

        khKaiyakuBikinjikouListDsbean.setIrKingaku1(pKuBikinjikouListSksBean.getKingaku());

        khKaiyakuBikinjikouListDsbean.setIrBikinjikoulistgoukeitani(bknkktiYm);

        khKaiyakuBikinjikouListDsbean.setIrBikinjikoulistgoukeicount(pKuBikinjikouListSksBean.getKensuu());

        khKaiyakuBikinjikouListDsbean.setIrKingakugoukei(pKuBikinjikouListSksBean.getKingaku());

        khKaiyakuBikinjikouListDsbean.setIrGoukeiumukbn(C_UmuKbn.ARI);

        return khKaiyakuBikinjikouListDsbean;
    }

    private KhKaiyakuBikinjikouListDataSourceBean editKhBikinJikouListY(C_BkncdKbn pBkncd, C_Segcd pHknsyurui,
        BizDateY pBknkktiNnd, KuBikinjikouListSksBean pKuBikinjikouListSksBean) {

        KhKaiyakuBikinjikouListDataSourceBean khKaiyakuBikinjikouListDsbean = SWAKInjector
            .getInstance(KhKaiyakuBikinjikouListDataSourceBean.class);

        String bknkktiNnd = DateFormatUtil.dateYKANJISeireki(pBknkktiNnd).concat("度");


        khKaiyakuBikinjikouListDsbean.setIrBkncd("");

        khKaiyakuBikinjikouListDsbean.setIrShrumu(C_UmuKbn.NONE);

        khKaiyakuBikinjikouListDsbean.setIrBknkktiymdwareki("");

        khKaiyakuBikinjikouListDsbean.setIrCalckijyunymdwareki("");

        khKaiyakuBikinjikouListDsbean.setIrSisyacd("");

        khKaiyakuBikinjikouListDsbean.setIrKigou("");

        khKaiyakuBikinjikouListDsbean.setIrSyono("");

        khKaiyakuBikinjikouListDsbean.setIrBkngk(BizCurrency.valueOf(0));

        khKaiyakuBikinjikouListDsbean.setIrKihons(BizCurrency.valueOf(0));

        khKaiyakuBikinjikouListDsbean.setIrTks(BizCurrency.valueOf(0));

        khKaiyakuBikinjikouListDsbean.setIrTkkigou("");

        khKaiyakuBikinjikouListDsbean.setIrKata("");

        khKaiyakuBikinjikouListDsbean.setIrSaisiumukbn("");

        khKaiyakuBikinjikouListDsbean.setIrSinsaumukbn(C_UmuKbn.NONE);

        khKaiyakuBikinjikouListDsbean.setIrSoukiumukbn(C_UmuKbn.NONE);

        khKaiyakuBikinjikouListDsbean.setIrSakugenumukbn(C_UmuKbn.NONE);

        khKaiyakuBikinjikouListDsbean.setIrTenkanumukbn(C_UmuKbn.NONE);

        khKaiyakuBikinjikouListDsbean.setIrKbnkeirihknsyuruinm(C_Segcd.BLNK);

        khKaiyakuBikinjikouListDsbean.setIrBknsyutkkbn(C_BknsyutkKbn.BLNK);

        khKaiyakuBikinjikouListDsbean.setIrBknkktinnd("");

        khKaiyakuBikinjikouListDsbean.setIrBknkktiym("");

        khKaiyakuBikinjikouListDsbean.setIrSyuukeiinfo1(pBkncd.toString());

        khKaiyakuBikinjikouListDsbean.setIrSyuukeiinfo2("");

        khKaiyakuBikinjikouListDsbean.setIrSyuukeiinfo3(pHknsyurui.getContent());

        khKaiyakuBikinjikouListDsbean.setIrSyuukeiinfo4(bknkktiNnd);

        khKaiyakuBikinjikouListDsbean.setIrSyuukeiinfo5("");

        khKaiyakuBikinjikouListDsbean.setIrUtiwake1("主契約");

        khKaiyakuBikinjikouListDsbean.setIrKensuu1(pKuBikinjikouListSksBean.getKensuu());

        khKaiyakuBikinjikouListDsbean.setIrKingaku1(pKuBikinjikouListSksBean.getKingaku());

        khKaiyakuBikinjikouListDsbean.setIrBikinjikoulistgoukeitani(bknkktiNnd);

        khKaiyakuBikinjikouListDsbean.setIrBikinjikoulistgoukeicount(pKuBikinjikouListSksBean.getKensuu());

        khKaiyakuBikinjikouListDsbean.setIrKingakugoukei(pKuBikinjikouListSksBean.getKingaku());

        khKaiyakuBikinjikouListDsbean.setIrGoukeiumukbn(C_UmuKbn.ARI);

        return khKaiyakuBikinjikouListDsbean;
    }

    private KhKaiyakuBikinjikouListDataSourceBean editKhBikinJikouListInsurance(C_BkncdKbn pBkncd, C_Segcd pHknsyurui,
        KuBikinjikouListSksBean pKuBikinjikouListSksBean) {

        KhKaiyakuBikinjikouListDataSourceBean khKaiyakuBikinjikouListDsbean = SWAKInjector
            .getInstance(KhKaiyakuBikinjikouListDataSourceBean.class);

        khKaiyakuBikinjikouListDsbean.setIrBkncd("");

        khKaiyakuBikinjikouListDsbean.setIrShrumu(C_UmuKbn.NONE);

        khKaiyakuBikinjikouListDsbean.setIrBknkktiymdwareki("");

        khKaiyakuBikinjikouListDsbean.setIrCalckijyunymdwareki("");

        khKaiyakuBikinjikouListDsbean.setIrSisyacd("");

        khKaiyakuBikinjikouListDsbean.setIrKigou("");

        khKaiyakuBikinjikouListDsbean.setIrSyono("");

        khKaiyakuBikinjikouListDsbean.setIrBkngk(BizCurrency.valueOf(0));

        khKaiyakuBikinjikouListDsbean.setIrKihons(BizCurrency.valueOf(0));

        khKaiyakuBikinjikouListDsbean.setIrTks(BizCurrency.valueOf(0));

        khKaiyakuBikinjikouListDsbean.setIrTkkigou("");

        khKaiyakuBikinjikouListDsbean.setIrKata("");

        khKaiyakuBikinjikouListDsbean.setIrSaisiumukbn("");

        khKaiyakuBikinjikouListDsbean.setIrSinsaumukbn(C_UmuKbn.NONE);

        khKaiyakuBikinjikouListDsbean.setIrSoukiumukbn(C_UmuKbn.NONE);

        khKaiyakuBikinjikouListDsbean.setIrSakugenumukbn(C_UmuKbn.NONE);

        khKaiyakuBikinjikouListDsbean.setIrTenkanumukbn(C_UmuKbn.NONE);

        khKaiyakuBikinjikouListDsbean.setIrKbnkeirihknsyuruinm(C_Segcd.BLNK);

        khKaiyakuBikinjikouListDsbean.setIrBknsyutkkbn(C_BknsyutkKbn.BLNK);

        khKaiyakuBikinjikouListDsbean.setIrBknkktinnd("");

        khKaiyakuBikinjikouListDsbean.setIrBknkktiym("");

        khKaiyakuBikinjikouListDsbean.setIrSyuukeiinfo1(pBkncd.toString());

        khKaiyakuBikinjikouListDsbean.setIrSyuukeiinfo2("");

        khKaiyakuBikinjikouListDsbean.setIrSyuukeiinfo3(pHknsyurui.getContent());

        khKaiyakuBikinjikouListDsbean.setIrSyuukeiinfo4("合計");

        khKaiyakuBikinjikouListDsbean.setIrSyuukeiinfo5("");

        khKaiyakuBikinjikouListDsbean.setIrUtiwake1("主契約");

        khKaiyakuBikinjikouListDsbean.setIrKensuu1(pKuBikinjikouListSksBean.getKensuu());

        khKaiyakuBikinjikouListDsbean.setIrKingaku1(pKuBikinjikouListSksBean.getKingaku());

        khKaiyakuBikinjikouListDsbean.setIrBikinjikoulistgoukeitani(pHknsyurui.getContent());

        khKaiyakuBikinjikouListDsbean.setIrBikinjikoulistgoukeicount(pKuBikinjikouListSksBean.getKensuu());

        khKaiyakuBikinjikouListDsbean.setIrKingakugoukei(pKuBikinjikouListSksBean.getKingaku());

        khKaiyakuBikinjikouListDsbean.setIrGoukeiumukbn(C_UmuKbn.ARI);

        return khKaiyakuBikinjikouListDsbean;
    }

    private KhKaiyakuBikinjikouListDataSourceBean editKhBikinJikouListCodeSet(C_BkncdKbn pBkncd,
        KuBikinjikouListSksBean pKuBikinjikouListSksBean) {

        KhKaiyakuBikinjikouListDataSourceBean khKaiyakuBikinjikouListDsbean = SWAKInjector
            .getInstance(KhKaiyakuBikinjikouListDataSourceBean.class);

        khKaiyakuBikinjikouListDsbean.setIrBkncd("");

        khKaiyakuBikinjikouListDsbean.setIrShrumu(C_UmuKbn.NONE);

        khKaiyakuBikinjikouListDsbean.setIrBknkktiymdwareki("");

        khKaiyakuBikinjikouListDsbean.setIrCalckijyunymdwareki("");

        khKaiyakuBikinjikouListDsbean.setIrSisyacd("");

        khKaiyakuBikinjikouListDsbean.setIrKigou("");

        khKaiyakuBikinjikouListDsbean.setIrSyono("");

        khKaiyakuBikinjikouListDsbean.setIrBkngk(BizCurrency.valueOf(0));

        khKaiyakuBikinjikouListDsbean.setIrKihons(BizCurrency.valueOf(0));

        khKaiyakuBikinjikouListDsbean.setIrTks(BizCurrency.valueOf(0));

        khKaiyakuBikinjikouListDsbean.setIrTkkigou("");

        khKaiyakuBikinjikouListDsbean.setIrKata("");

        khKaiyakuBikinjikouListDsbean.setIrSaisiumukbn("");

        khKaiyakuBikinjikouListDsbean.setIrSinsaumukbn(C_UmuKbn.NONE);

        khKaiyakuBikinjikouListDsbean.setIrSoukiumukbn(C_UmuKbn.NONE);

        khKaiyakuBikinjikouListDsbean.setIrSakugenumukbn(C_UmuKbn.NONE);

        khKaiyakuBikinjikouListDsbean.setIrTenkanumukbn(C_UmuKbn.NONE);

        khKaiyakuBikinjikouListDsbean.setIrKbnkeirihknsyuruinm(C_Segcd.BLNK);

        khKaiyakuBikinjikouListDsbean.setIrBknsyutkkbn(C_BknsyutkKbn.BLNK);

        khKaiyakuBikinjikouListDsbean.setIrBknkktinnd("");

        khKaiyakuBikinjikouListDsbean.setIrBknkktiym("");

        khKaiyakuBikinjikouListDsbean.setIrSyuukeiinfo1(pBkncd.toString());

        khKaiyakuBikinjikouListDsbean.setIrSyuukeiinfo2("");

        khKaiyakuBikinjikouListDsbean.setIrSyuukeiinfo3("合計");

        khKaiyakuBikinjikouListDsbean.setIrSyuukeiinfo4("");

        khKaiyakuBikinjikouListDsbean.setIrSyuukeiinfo5("");

        khKaiyakuBikinjikouListDsbean.setIrUtiwake1("主契約");

        khKaiyakuBikinjikouListDsbean.setIrKensuu1(pKuBikinjikouListSksBean.getKensuu());

        khKaiyakuBikinjikouListDsbean.setIrKingaku1(pKuBikinjikouListSksBean.getKingaku());

        khKaiyakuBikinjikouListDsbean.setIrBikinjikoulistgoukeitani(pBkncd.toString());

        khKaiyakuBikinjikouListDsbean.setIrBikinjikoulistgoukeicount(pKuBikinjikouListSksBean.getKensuu());

        khKaiyakuBikinjikouListDsbean.setIrKingakugoukei(pKuBikinjikouListSksBean.getKingaku());

        khKaiyakuBikinjikouListDsbean.setIrGoukeiumukbn(C_UmuKbn.ARI);

        return khKaiyakuBikinjikouListDsbean;
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate()  {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }

    class KuBikinjikouListSksBean {

        public KuBikinjikouListSksBean(){

            kensuu = BizNumber.valueOf(0);

            kingaku = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        }

        private BizNumber kensuu;

        public BizNumber getKensuu() {
            return kensuu;
        }

        public void setKensuu(BizNumber pKensuu) {
            kensuu = pKensuu;
        }

        private BizCurrency kingaku;

        public BizCurrency getKingaku() {
            return kingaku;
        }

        public void setKingaku(BizCurrency pKingaku) {
            kingaku = pKingaku;
        }

    }
}
