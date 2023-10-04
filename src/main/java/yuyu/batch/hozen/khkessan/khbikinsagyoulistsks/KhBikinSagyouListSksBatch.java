package yuyu.batch.hozen.khkessan.khbikinsagyoulistsks;

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
import yuyu.def.hozen.bean.report.KhKaiyakuBikinsagyouListBean;
import yuyu.def.hozen.bean.report.KhKaiyakuBikinsagyouListDataSourceBean;
import yuyu.def.hozen.file.csv.KhBikinSgyLstCsvfKaiyakuFile;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 契約保全 決算  契約保全備金作業リスト作成（解約）
 */
public class KhBikinSagyouListSksBatch implements Batch {

    private final String TABLE_ID = "IT_KhBikinkanri";

    private final String RECOVERY_FILTER_ID = "Bz001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private KhBikinSagyouListSksBatchParam khBikinSagyouListSksBatchParam;

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
        return khBikinSagyouListSksBatchParam;
    }

    @Execute
    @Transactional
    public void Execute() {

        BizDate syoriYmd = khBikinSagyouListSksBatchParam.getSyoriYmd();

        BizDate ksnbiymd = khBikinSagyouListSksBatchParam.getKessanYmd();

        String kakutyoujobCd = khBikinSagyouListSksBatchParam.getIbKakutyoujobcd();

        List<KhBikinSgyLstCsvfKaiyakuFile> khBikinSgyLstCsvfKaiyakuFileList =
            new ArrayList<KhBikinSgyLstCsvfKaiyakuFile>();

        List<IReportDataSouceBean> khKaiyakuBikinsagyouListDsbeanList =
            new ArrayList<>();

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, "<<バッチ処理年月日>>", syoriYmd.toString()));

        try (ExDBResults<IT_KhBikinkanri> khBikinkanriList = hozenDomManager.
            getKhBikinkanrisByKakutyoujobcdKessankijyunymd(kakutyoujobCd, ksnbiymd)) {

            CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

            ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                kinou.getSubSystemId(), kinou.getCategoryId(), kinou.getKinouId(), C_SyoruiCdKbn.KK_KAIYAKU_BIKINSAGYOULIST);

            String tyouhyouSakuseiYmd = DateFormatUtil.dateKANJINoEx(syoriYmd);

            String busituCd =bizDomManager.getTantouCd(C_TantouCdKbn.KAIYAKU).getBusitucd();

            BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

            String tantsituNm = "";

            BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(busituCd + "0000");

            if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())){

                tantsituNm = bzGetSosikiDataBean.getKanjisosikinm20();

            }

            SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);
            BizDate kessanNensibi = setKessanNensibi.exec(ksnbiymd);

            String kessanNnd = DateFormatUtil.dateYKANJISeireki(kessanNensibi.getBizDateY()).concat("度");

            C_Bknkessankbn bknkessanKbn = C_Bknkessankbn.BLNK;

            if (ksnbiymd.getMonth() == 3) {

                bknkessanKbn = C_Bknkessankbn.KESSAN;

            }
            else if (ksnbiymd.getMonth() == 6) {

                bknkessanKbn = C_Bknkessankbn.SHNK;

            }
            else if (ksnbiymd.getMonth() == 9) {

                bknkessanKbn = C_Bknkessankbn.HNK;

            }
            else if (ksnbiymd.getMonth() == 12) {

                bknkessanKbn = C_Bknkessankbn.SHNK;

            }

            String hozonKkn = ViewReport.getHozonKknTani(C_SyoruiCdKbn.KK_KAIYAKU_BIKINSAGYOULIST);

            KhKaiyakuBikinsagyouListBean khKaiyakuBikinsagyouListBean =
                SWAKInjector.getInstance(KhKaiyakuBikinsagyouListBean.class);

            khKaiyakuBikinsagyouListBean.setIrTantsitunmkj(tantsituNm);

            khKaiyakuBikinsagyouListBean.setIrTantocd(C_TantouCdKbn.KAIYAKU);

            khKaiyakuBikinsagyouListBean.setIrKessannnd(kessanNnd);

            khKaiyakuBikinsagyouListBean.setIrBknkessankbn(bknkessanKbn);

            khKaiyakuBikinsagyouListBean.setIrTyouhyousakuseiymdwareki(tyouhyouSakuseiYmd);

            khKaiyakuBikinsagyouListBean.setIrHozonkkn(hozonKkn);

            long outKensuu = 0;

            int pageNo = 1;

            int pageCount = 0;

            long goukeiKensuu = 0;

            BizCurrency goukeiBikingk = BizCurrency.valueOf(0);

            BizDateYM bknkktiYmKey = null;

            BizDateY bknkktiNndKey = null;

            C_Segcd hknsyuruiKey = C_Segcd.BLNK;

            C_BkncdKbn bkncdKey = C_BkncdKbn.BLNK;

            KhBikinSagyouListBean bknkktiNndBean = new KhBikinSagyouListBean();

            KhBikinSagyouListBean hknsyuruiBean = new KhBikinSagyouListBean();

            KhBikinSagyouListBean bkncdBean = new KhBikinSagyouListBean();

            for (IT_KhBikinkanri khBikinkanri : khBikinkanriList) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);

                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_ID);

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khBikinkanri.getSyono());

                String bknkktYmd = DateFormatUtil.dateKANJINoEx(khBikinkanri.getBknkktymd());

                String calckijyunYmd = DateFormatUtil.dateKANJINoEx(khBikinkanri.getCalckijyunymd());

                BizDate kessanNensiYmd = setKessanNensibi.exec(khBikinkanri.getBknkktymd());

                BizDateY kessanNensiY = kessanNensiYmd.getBizDateY();

                String bknkktiNnd = DateFormatUtil.dateYKANJISeireki(kessanNensiY).concat("度");

                String bknkktiYm = DateFormatUtil.dateYmKANJINoEx(khBikinkanri.getBknkktymd().getBizDateYM());

                if (outKensuu == 0) {

                    bknkktiYmKey = khBikinkanri.getBknkktymd().getBizDateYM();

                    bknkktiNndKey = kessanNensiY;

                    hknsyuruiKey = khBikinkanri.getKbnkeirisegcd();

                    bkncdKey = khBikinkanri.getBkncdkbn();

                }
                else {
                    if ((BizDateUtil.compareYm(khBikinkanri.getBknkktymd().getBizDateYM(), bknkktiYmKey)
                        != BizDateUtil.COMPARE_EQUAL) ||
                        !(khBikinkanri.getKbnkeirisegcd().eq(hknsyuruiKey)) ||
                        !(khBikinkanri.getBkncdkbn().eq(bkncdKey))) {

                        String goukeiTani = DateFormatUtil.dateYmKANJINoEx(bknkktiYmKey);

                        KhKaiyakuBikinsagyouListDataSourceBean KhKaiyakuBikinsagyouListDsbean =
                            (KhKaiyakuBikinsagyouListDataSourceBean)khKaiyakuBikinsagyouListDsbeanList.get(
                                khKaiyakuBikinsagyouListDsbeanList.size() - 1);

                        KhKaiyakuBikinsagyouListDsbean.setIrGoukeitani(goukeiTani);

                        KhKaiyakuBikinsagyouListDsbean.setIrGoukeikbn1("主契約");

                        KhKaiyakuBikinsagyouListDsbean.setIrGoukeikensuu1(BizNumber.valueOf(goukeiKensuu));

                        KhKaiyakuBikinsagyouListDsbean.setIrGoukeibikingk1(goukeiBikingk);

                        bknkktiYmKey = khBikinkanri.getBknkktymd().getBizDateYM();

                        pageNo = pageNo + 1;

                        pageCount = 0;

                        goukeiKensuu = 0;

                        goukeiBikingk = BizCurrency.valueOf(0);

                        KhKaiyakuBikinsagyouListDataSourceBean khKaiyakuBikinsagyouListDsbean =
                            SWAKInjector.getInstance(KhKaiyakuBikinsagyouListDataSourceBean.class);

                        if (kessanNensiY.compareTo(bknkktiNndKey) != 0 || !(khBikinkanri.getKbnkeirisegcd().eq(hknsyuruiKey))
                            || !(khBikinkanri.getBkncdkbn().eq(bkncdKey))) {

                            String goukeiTani1 = DateFormatUtil.dateYKANJISeireki(bknkktiNndKey).concat("度");

                            khKaiyakuBikinsagyouListDsbean =
                                SWAKInjector.getInstance(KhKaiyakuBikinsagyouListDataSourceBean.class);

                            khKaiyakuBikinsagyouListDsbean.setIrBkncd("");

                            khKaiyakuBikinsagyouListDsbean.setIrKbnkeirihknsyuruiryakunm(C_Segcd.BLNK);

                            khKaiyakuBikinsagyouListDsbean.setIrBknkktiymdwareki("");

                            khKaiyakuBikinsagyouListDsbean.setIrCalckijyunymdwareki("");

                            khKaiyakuBikinsagyouListDsbean.setIrSisyacd("");

                            khKaiyakuBikinsagyouListDsbean.setIrKigou("");

                            khKaiyakuBikinsagyouListDsbean.setIrSyono("");

                            khKaiyakuBikinsagyouListDsbean.setIrBkngk(BizCurrency.valueOf(0));

                            khKaiyakuBikinsagyouListDsbean.setIrKihons(BizCurrency.valueOf(0));

                            khKaiyakuBikinsagyouListDsbean.setIrTks(BizCurrency.valueOf(0));

                            khKaiyakuBikinsagyouListDsbean.setIrTkkigou("");

                            khKaiyakuBikinsagyouListDsbean.setIrKata("");

                            khKaiyakuBikinsagyouListDsbean.setIrSaisiumukbn("");

                            khKaiyakuBikinsagyouListDsbean.setIrDoujibkn("");

                            khKaiyakuBikinsagyouListDsbean.setIrSokyuumukbn(C_UmuKbn.NONE);

                            khKaiyakuBikinsagyouListDsbean.setIrSoukiumukbn(C_UmuKbn.NONE);

                            khKaiyakuBikinsagyouListDsbean.setIrBknsgulisterrormsg("");

                            khKaiyakuBikinsagyouListDsbean.setIrSakugenumukbn(C_UmuKbn.NONE);

                            khKaiyakuBikinsagyouListDsbean.setIrNkumukbn(C_UmuKbn.NONE);

                            khKaiyakuBikinsagyouListDsbean.setIrTenkanumukbn(C_UmuKbn.NONE);

                            khKaiyakuBikinsagyouListDsbean.setIrKeimaeumukbn(C_UmuKbn.NONE);

                            khKaiyakuBikinsagyouListDsbean.setIrSaihoumukbn(C_UmuKbn.NONE);

                            khKaiyakuBikinsagyouListDsbean.setIrSzouumukbn(C_UmuKbn.NONE);

                            khKaiyakuBikinsagyouListDsbean.setIrBknsyutkkbn(C_BknsyutkKbn.BLNK);

                            khKaiyakuBikinsagyouListDsbean.setIrBknkktinnd("");

                            khKaiyakuBikinsagyouListDsbean.setIrBknkktiym("");

                            khKaiyakuBikinsagyouListDsbean.setIrGoukeitani(goukeiTani1);

                            khKaiyakuBikinsagyouListDsbean.setIrGoukeikbn1("主契約");

                            khKaiyakuBikinsagyouListDsbean.setIrGoukeikensuu1(bknkktiNndBean.getGoukeiKensuu());

                            khKaiyakuBikinsagyouListDsbean.setIrGoukeibikingk1(bknkktiNndBean.getGoukeiGk());

                            khKaiyakuBikinsagyouListDsbean.setIrGoukeiumukbn(C_UmuKbn.ARI);

                            khKaiyakuBikinsagyouListDsbeanList.add(khKaiyakuBikinsagyouListDsbean);

                            bknkktiNndKey = kessanNensiY;

                            pageNo = pageNo + 1;

                            bknkktiNndBean.setGoukeiKensuu(BizNumber.valueOf(0));

                            bknkktiNndBean.setGoukeiGk(BizCurrency.valueOf(0));
                        }


                        if (!(khBikinkanri.getKbnkeirisegcd().eq(hknsyuruiKey)) || !(khBikinkanri.getBkncdkbn().eq(bkncdKey))) {

                            khKaiyakuBikinsagyouListDsbean =
                                SWAKInjector.getInstance(KhKaiyakuBikinsagyouListDataSourceBean.class);

                            khKaiyakuBikinsagyouListDsbean.setIrBkncd("");

                            khKaiyakuBikinsagyouListDsbean.setIrKbnkeirihknsyuruiryakunm(C_Segcd.BLNK);

                            khKaiyakuBikinsagyouListDsbean.setIrBknkktiymdwareki("");

                            khKaiyakuBikinsagyouListDsbean.setIrCalckijyunymdwareki("");

                            khKaiyakuBikinsagyouListDsbean.setIrSisyacd("");

                            khKaiyakuBikinsagyouListDsbean.setIrKigou("");

                            khKaiyakuBikinsagyouListDsbean.setIrSyono("");

                            khKaiyakuBikinsagyouListDsbean.setIrBkngk(BizCurrency.valueOf(0));

                            khKaiyakuBikinsagyouListDsbean.setIrKihons(BizCurrency.valueOf(0));

                            khKaiyakuBikinsagyouListDsbean.setIrTks(BizCurrency.valueOf(0));

                            khKaiyakuBikinsagyouListDsbean.setIrTkkigou("");

                            khKaiyakuBikinsagyouListDsbean.setIrKata("");

                            khKaiyakuBikinsagyouListDsbean.setIrSaisiumukbn("");

                            khKaiyakuBikinsagyouListDsbean.setIrDoujibkn("");

                            khKaiyakuBikinsagyouListDsbean.setIrSokyuumukbn(C_UmuKbn.NONE);

                            khKaiyakuBikinsagyouListDsbean.setIrSoukiumukbn(C_UmuKbn.NONE);

                            khKaiyakuBikinsagyouListDsbean.setIrBknsgulisterrormsg("");

                            khKaiyakuBikinsagyouListDsbean.setIrSakugenumukbn(C_UmuKbn.NONE);

                            khKaiyakuBikinsagyouListDsbean.setIrNkumukbn(C_UmuKbn.NONE);

                            khKaiyakuBikinsagyouListDsbean.setIrTenkanumukbn(C_UmuKbn.NONE);

                            khKaiyakuBikinsagyouListDsbean.setIrKeimaeumukbn(C_UmuKbn.NONE);

                            khKaiyakuBikinsagyouListDsbean.setIrSaihoumukbn(C_UmuKbn.NONE);

                            khKaiyakuBikinsagyouListDsbean.setIrSzouumukbn(C_UmuKbn.NONE);

                            khKaiyakuBikinsagyouListDsbean.setIrBknsyutkkbn(C_BknsyutkKbn.BLNK);

                            khKaiyakuBikinsagyouListDsbean.setIrBknkktinnd("");

                            khKaiyakuBikinsagyouListDsbean.setIrBknkktiym("");

                            khKaiyakuBikinsagyouListDsbean.setIrGoukeitani(hknsyuruiKey.getContent());

                            khKaiyakuBikinsagyouListDsbean.setIrGoukeikbn1("主契約");

                            khKaiyakuBikinsagyouListDsbean.setIrGoukeikensuu1(hknsyuruiBean.getGoukeiKensuu());

                            khKaiyakuBikinsagyouListDsbean.setIrGoukeibikingk1(hknsyuruiBean.getGoukeiGk());

                            khKaiyakuBikinsagyouListDsbean.setIrGoukeiumukbn(C_UmuKbn.ARI);

                            khKaiyakuBikinsagyouListDsbeanList.add(khKaiyakuBikinsagyouListDsbean);

                            hknsyuruiKey = khBikinkanri.getKbnkeirisegcd();

                            pageNo = pageNo + 1;

                            hknsyuruiBean.setGoukeiKensuu(BizNumber.valueOf(0));

                            hknsyuruiBean.setGoukeiGk(BizCurrency.valueOf(0));

                        }
                        if (!khBikinkanri.getBkncdkbn().eq(bkncdKey)) {

                            khKaiyakuBikinsagyouListDsbean =
                                SWAKInjector.getInstance(KhKaiyakuBikinsagyouListDataSourceBean.class);

                            khKaiyakuBikinsagyouListDsbean.setIrBkncd("");

                            khKaiyakuBikinsagyouListDsbean.setIrKbnkeirihknsyuruiryakunm(C_Segcd.BLNK);

                            khKaiyakuBikinsagyouListDsbean.setIrBknkktiymdwareki("");

                            khKaiyakuBikinsagyouListDsbean.setIrCalckijyunymdwareki("");

                            khKaiyakuBikinsagyouListDsbean.setIrSisyacd("");

                            khKaiyakuBikinsagyouListDsbean.setIrKigou("");

                            khKaiyakuBikinsagyouListDsbean.setIrSyono("");

                            khKaiyakuBikinsagyouListDsbean.setIrBkngk(BizCurrency.valueOf(0));

                            khKaiyakuBikinsagyouListDsbean.setIrKihons(BizCurrency.valueOf(0));

                            khKaiyakuBikinsagyouListDsbean.setIrTks(BizCurrency.valueOf(0));

                            khKaiyakuBikinsagyouListDsbean.setIrTkkigou("");

                            khKaiyakuBikinsagyouListDsbean.setIrKata("");

                            khKaiyakuBikinsagyouListDsbean.setIrSaisiumukbn("");

                            khKaiyakuBikinsagyouListDsbean.setIrDoujibkn("");

                            khKaiyakuBikinsagyouListDsbean.setIrSokyuumukbn(C_UmuKbn.NONE);

                            khKaiyakuBikinsagyouListDsbean.setIrSoukiumukbn(C_UmuKbn.NONE);

                            khKaiyakuBikinsagyouListDsbean.setIrBknsgulisterrormsg("");

                            khKaiyakuBikinsagyouListDsbean.setIrSakugenumukbn(C_UmuKbn.NONE);

                            khKaiyakuBikinsagyouListDsbean.setIrNkumukbn(C_UmuKbn.NONE);

                            khKaiyakuBikinsagyouListDsbean.setIrTenkanumukbn(C_UmuKbn.NONE);

                            khKaiyakuBikinsagyouListDsbean.setIrKeimaeumukbn(C_UmuKbn.NONE);

                            khKaiyakuBikinsagyouListDsbean.setIrSaihoumukbn(C_UmuKbn.NONE);

                            khKaiyakuBikinsagyouListDsbean.setIrSzouumukbn(C_UmuKbn.NONE);

                            khKaiyakuBikinsagyouListDsbean.setIrBknsyutkkbn(C_BknsyutkKbn.BLNK);

                            khKaiyakuBikinsagyouListDsbean.setIrBknkktinnd("");

                            khKaiyakuBikinsagyouListDsbean.setIrBknkktiym("");

                            khKaiyakuBikinsagyouListDsbean.setIrGoukeitani(hknsyuruiKey.getContent());

                            khKaiyakuBikinsagyouListDsbean.setIrGoukeikbn1("主契約");

                            khKaiyakuBikinsagyouListDsbean.setIrGoukeikensuu1(bkncdBean.getGoukeiKensuu());

                            khKaiyakuBikinsagyouListDsbean.setIrGoukeibikingk1(bkncdBean.getGoukeiGk());

                            khKaiyakuBikinsagyouListDsbean.setIrGoukeiumukbn(C_UmuKbn.ARI);

                            khKaiyakuBikinsagyouListDsbeanList.add(khKaiyakuBikinsagyouListDsbean);

                            bkncdKey = khBikinkanri.getBkncdkbn();

                            pageNo = pageNo + 1;

                            bkncdBean.setGoukeiKensuu(BizNumber.valueOf(0));

                            bkncdBean.setGoukeiGk(BizCurrency.valueOf(0));

                        }


                    }
                    else{

                        if (pageCount == 19) {
                            pageNo = pageNo + 1;

                            pageCount = 0;
                        }
                    }

                }

                outKensuu = outKensuu + 1;

                pageCount = pageCount + 1;

                KhKaiyakuBikinsagyouListDataSourceBean khKaiyakuBikinsagyouListDsbean =
                    SWAKInjector.getInstance(KhKaiyakuBikinsagyouListDataSourceBean.class);

                khKaiyakuBikinsagyouListDsbean.setIrBkncd(khBikinkanri.getBkncdkbn().toString());

                khKaiyakuBikinsagyouListDsbean.setIrKbnkeirihknsyuruiryakunm(khBikinkanri.getKbnkeirisegcd());

                khKaiyakuBikinsagyouListDsbean.setIrBknkktiymdwareki(bknkktYmd);

                khKaiyakuBikinsagyouListDsbean.setIrCalckijyunymdwareki(calckijyunYmd);

                khKaiyakuBikinsagyouListDsbean.setIrSisyacd(khBikinkanri.getSisyacd());

                khKaiyakuBikinsagyouListDsbean.setIrKigou(khBikinkanri.getSyouhncd().substring(0, 2));

                khKaiyakuBikinsagyouListDsbean.setIrSyono(khBikinkanri.getSyono());

                khKaiyakuBikinsagyouListDsbean.setIrBkngk(khBikinkanri.getBkngk());

                khKaiyakuBikinsagyouListDsbean.setIrKihons(khBikinkanri.getKihons());

                khKaiyakuBikinsagyouListDsbean.setIrTks(BizCurrency.valueOf(0));

                khKaiyakuBikinsagyouListDsbean.setIrTkkigou("");

                khKaiyakuBikinsagyouListDsbean.setIrKata("");

                khKaiyakuBikinsagyouListDsbean.setIrSaisiumukbn("");

                khKaiyakuBikinsagyouListDsbean.setIrDoujibkn("");

                khKaiyakuBikinsagyouListDsbean.setIrSokyuumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinsagyouListDsbean.setIrSoukiumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinsagyouListDsbean.setIrBknsgulisterrormsg("");

                khKaiyakuBikinsagyouListDsbean.setIrSakugenumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinsagyouListDsbean.setIrNkumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinsagyouListDsbean.setIrTenkanumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinsagyouListDsbean.setIrKeimaeumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinsagyouListDsbean.setIrSaihoumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinsagyouListDsbean.setIrSzouumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinsagyouListDsbean.setIrBknsyutkkbn(C_BknsyutkKbn.BLNK);

                khKaiyakuBikinsagyouListDsbean.setIrBknkktinnd(bknkktiNnd);

                khKaiyakuBikinsagyouListDsbean.setIrBknkktiym(bknkktiYm);

                khKaiyakuBikinsagyouListDsbean.setIrGoukeitani("");

                khKaiyakuBikinsagyouListDsbean.setIrGoukeikbn1("");

                khKaiyakuBikinsagyouListDsbean.setIrGoukeikensuu1(BizNumber.valueOf(0));

                khKaiyakuBikinsagyouListDsbean.setIrGoukeibikingk1(BizCurrency.valueOf(0));

                khKaiyakuBikinsagyouListDsbean.setIrGoukeiumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinsagyouListDsbeanList.add(khKaiyakuBikinsagyouListDsbean);

                goukeiKensuu = goukeiKensuu + 1;
                goukeiBikingk = khBikinkanri.getBkngk().add(goukeiBikingk);

                bknkktiNndBean.setGoukeiKensuu(bknkktiNndBean.getGoukeiKensuu().add(BizNumber.valueOf(1)));

                bknkktiNndBean.setGoukeiGk(bknkktiNndBean.getGoukeiGk().add(khBikinkanri.getBkngk()));

                hknsyuruiBean.setGoukeiKensuu(hknsyuruiBean.getGoukeiKensuu().add(BizNumber.valueOf(1)));

                hknsyuruiBean.setGoukeiGk(hknsyuruiBean.getGoukeiGk().add(khBikinkanri.getBkngk()));

                bkncdBean.setGoukeiKensuu(bkncdBean.getGoukeiKensuu().add(BizNumber.valueOf(1)));

                bkncdBean.setGoukeiGk(bkncdBean.getGoukeiGk().add(khBikinkanri.getBkngk()));


                String syoriYmdSeireki = DateFormatUtil.dateKANJI(syoriYmd);

                String kessanNendoMae =  DateFormatUtil.dateYKANJISeireki(
                    setKessanNensibi.exec(khBikinkanri.getKessankijyunymd()).getBizDateY()).concat("度");

                String dbknkessanKbn = "";

                if (khBikinkanri.getKessankijyunymd().getMonth() == 3) {

                    dbknkessanKbn = "決算";

                }
                else if (khBikinkanri.getKessankijyunymd().getMonth() == 6) {
                    dbknkessanKbn = "四半期";

                }
                else if (khBikinkanri.getKessankijyunymd().getMonth() == 9) {
                    dbknkessanKbn = "半期";

                }
                else if (khBikinkanri.getKessankijyunymd().getMonth() == 12) {
                    dbknkessanKbn = "四半期";
                }

                kessanNnd = kessanNendoMae + dbknkessanKbn;

                KhBikinSgyLstCsvfKaiyakuFile khBikinSgyLstCsvfKaiyakuFile =
                    SWAKInjector.getInstance(KhBikinSgyLstCsvfKaiyakuFile.class);

                khBikinSgyLstCsvfKaiyakuFile.setIfcListnm("備金作業リスト");

                khBikinSgyLstCsvfKaiyakuFile.setIfcAtesaki(tantsituNm);

                khBikinSgyLstCsvfKaiyakuFile.setIfcSakuseiymdwareki(syoriYmdSeireki);

                khBikinSgyLstCsvfKaiyakuFile.setIfcPageno(String.valueOf(pageNo));

                khBikinSgyLstCsvfKaiyakuFile.setIfcKessannnd(kessanNnd);

                khBikinSgyLstCsvfKaiyakuFile.setIfcBkncd(khBikinkanri.getBkncdkbn().toString());

                khBikinSgyLstCsvfKaiyakuFile.setIfcHknsyurui(khBikinkanri.getKbnkeirisegcd().getContent());

                khBikinSgyLstCsvfKaiyakuFile.setIfcBknkktiymdwareki(bknkktYmd);

                khBikinSgyLstCsvfKaiyakuFile.setIfcCalckijyunymdwareki(calckijyunYmd);

                khBikinSgyLstCsvfKaiyakuFile.setIfcSisyacd(khBikinkanri.getSisyacd());

                khBikinSgyLstCsvfKaiyakuFile.setIfcHknsyuruikigou(khBikinkanri.getSyouhncd().substring(0, 2));

                khBikinSgyLstCsvfKaiyakuFile.setIfcSyono(khBikinkanri.getSyono());

                khBikinSgyLstCsvfKaiyakuFile.setIfcBkngk(khBikinkanri.getBkngk().toString());

                khBikinSgyLstCsvfKaiyakuFile.setIfcKihons(khBikinkanri.getKihons().toString());

                khBikinSgyLstCsvfKaiyakuFile.setIfcTks("");

                khBikinSgyLstCsvfKaiyakuFile.setIfcTkkigou("");

                khBikinSgyLstCsvfKaiyakuFile.setIfcTkkatakbn("");

                khBikinSgyLstCsvfKaiyakuFile.setIfcSaisikbn("");

                khBikinSgyLstCsvfKaiyakuFile.setIfcDoujibkn1("");

                khBikinSgyLstCsvfKaiyakuFile.setIfcDoujibkn2("");

                khBikinSgyLstCsvfKaiyakuFile.setIfcDoujibkn3("");

                khBikinSgyLstCsvfKaiyakuFile.setIfcDoujibkn4("");

                khBikinSgyLstCsvfKaiyakuFile.setIfcSokyuukbn("");

                khBikinSgyLstCsvfKaiyakuFile.setIfcSoukihyj("");

                khBikinSgyLstCsvfKaiyakuFile.setIfcErrormsg("");

                khBikinSgyLstCsvfKaiyakuFile.setIfcSkgnhyj("");

                khBikinSgyLstCsvfKaiyakuFile.setIfcNkhyj("");

                khBikinSgyLstCsvfKaiyakuFile.setIfcTnknhyj("");

                khBikinSgyLstCsvfKaiyakuFile.setIfcKykmaehyj("");

                khBikinSgyLstCsvfKaiyakuFile.setIfcSihknhyj("");

                khBikinSgyLstCsvfKaiyakuFile.setIfcSzoutysihyj("");

                khBikinSgyLstCsvfKaiyakuFileList.add(khBikinSgyLstCsvfKaiyakuFile);
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            if (outKensuu > 0) {

                String totalUnit1 = DateFormatUtil.dateYmKANJINoEx(bknkktiYmKey);
                KhKaiyakuBikinsagyouListDataSourceBean KhKaiyakuBikinsagyouListDsbean =
                    (KhKaiyakuBikinsagyouListDataSourceBean)khKaiyakuBikinsagyouListDsbeanList.get(
                        khKaiyakuBikinsagyouListDsbeanList.size() - 1);

                KhKaiyakuBikinsagyouListDsbean.setIrGoukeitani(totalUnit1);

                KhKaiyakuBikinsagyouListDsbean.setIrGoukeikbn1("主契約");

                KhKaiyakuBikinsagyouListDsbean.setIrGoukeikensuu1(BizNumber.valueOf(goukeiKensuu));

                KhKaiyakuBikinsagyouListDsbean.setIrGoukeibikingk1(goukeiBikingk);

                KhKaiyakuBikinsagyouListDsbean.setIrGoukeiumukbn(C_UmuKbn.NONE);

                KhKaiyakuBikinsagyouListDataSourceBean khKaiyakuBikinsagyouListDsbean =
                    SWAKInjector.getInstance(KhKaiyakuBikinsagyouListDataSourceBean.class);

                String totalUnit2 = DateFormatUtil.dateYKANJISeireki(bknkktiNndKey).concat("度");

                khKaiyakuBikinsagyouListDsbean.setIrBkncd("");

                khKaiyakuBikinsagyouListDsbean.setIrKbnkeirihknsyuruiryakunm(C_Segcd.BLNK);

                khKaiyakuBikinsagyouListDsbean.setIrBknkktiymdwareki("");

                khKaiyakuBikinsagyouListDsbean.setIrCalckijyunymdwareki("");

                khKaiyakuBikinsagyouListDsbean.setIrSisyacd("");

                khKaiyakuBikinsagyouListDsbean.setIrKigou("");

                khKaiyakuBikinsagyouListDsbean.setIrSyono("");

                khKaiyakuBikinsagyouListDsbean.setIrBkngk(BizCurrency.valueOf(0));

                khKaiyakuBikinsagyouListDsbean.setIrKihons(BizCurrency.valueOf(0));

                khKaiyakuBikinsagyouListDsbean.setIrTks(BizCurrency.valueOf(0));

                khKaiyakuBikinsagyouListDsbean.setIrTkkigou("");

                khKaiyakuBikinsagyouListDsbean.setIrKata("");

                khKaiyakuBikinsagyouListDsbean.setIrSaisiumukbn("");

                khKaiyakuBikinsagyouListDsbean.setIrDoujibkn("");

                khKaiyakuBikinsagyouListDsbean.setIrSokyuumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinsagyouListDsbean.setIrSoukiumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinsagyouListDsbean.setIrBknsgulisterrormsg("");

                khKaiyakuBikinsagyouListDsbean.setIrSakugenumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinsagyouListDsbean.setIrNkumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinsagyouListDsbean.setIrTenkanumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinsagyouListDsbean.setIrKeimaeumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinsagyouListDsbean.setIrSaihoumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinsagyouListDsbean.setIrSzouumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinsagyouListDsbean.setIrBknsyutkkbn(C_BknsyutkKbn.BLNK);

                khKaiyakuBikinsagyouListDsbean.setIrBknkktinnd("");

                khKaiyakuBikinsagyouListDsbean.setIrBknkktiym("");

                khKaiyakuBikinsagyouListDsbean.setIrGoukeitani(totalUnit2);

                khKaiyakuBikinsagyouListDsbean.setIrGoukeikbn1("主契約");

                khKaiyakuBikinsagyouListDsbean.setIrGoukeikensuu1(bknkktiNndBean.getGoukeiKensuu());

                khKaiyakuBikinsagyouListDsbean.setIrGoukeibikingk1(bknkktiNndBean.getGoukeiGk());

                khKaiyakuBikinsagyouListDsbean.setIrGoukeiumukbn(C_UmuKbn.ARI);

                khKaiyakuBikinsagyouListDsbeanList.add(khKaiyakuBikinsagyouListDsbean);

                khKaiyakuBikinsagyouListDsbean =
                    SWAKInjector.getInstance(KhKaiyakuBikinsagyouListDataSourceBean.class);

                khKaiyakuBikinsagyouListDsbean.setIrBkncd("");

                khKaiyakuBikinsagyouListDsbean.setIrKbnkeirihknsyuruiryakunm(C_Segcd.BLNK);

                khKaiyakuBikinsagyouListDsbean.setIrBknkktiymdwareki("");

                khKaiyakuBikinsagyouListDsbean.setIrCalckijyunymdwareki("");

                khKaiyakuBikinsagyouListDsbean.setIrSisyacd("");

                khKaiyakuBikinsagyouListDsbean.setIrKigou("");

                khKaiyakuBikinsagyouListDsbean.setIrSyono("");

                khKaiyakuBikinsagyouListDsbean.setIrBkngk(BizCurrency.valueOf(0));

                khKaiyakuBikinsagyouListDsbean.setIrKihons(BizCurrency.valueOf(0));

                khKaiyakuBikinsagyouListDsbean.setIrTks(BizCurrency.valueOf(0));

                khKaiyakuBikinsagyouListDsbean.setIrTkkigou("");

                khKaiyakuBikinsagyouListDsbean.setIrKata("");

                khKaiyakuBikinsagyouListDsbean.setIrSaisiumukbn("");

                khKaiyakuBikinsagyouListDsbean.setIrDoujibkn("");

                khKaiyakuBikinsagyouListDsbean.setIrSokyuumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinsagyouListDsbean.setIrSoukiumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinsagyouListDsbean.setIrBknsgulisterrormsg("");

                khKaiyakuBikinsagyouListDsbean.setIrSakugenumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinsagyouListDsbean.setIrNkumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinsagyouListDsbean.setIrTenkanumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinsagyouListDsbean.setIrKeimaeumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinsagyouListDsbean.setIrSaihoumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinsagyouListDsbean.setIrSzouumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinsagyouListDsbean.setIrBknsyutkkbn(C_BknsyutkKbn.BLNK);

                khKaiyakuBikinsagyouListDsbean.setIrBknkktinnd("");

                khKaiyakuBikinsagyouListDsbean.setIrBknkktiym("");

                khKaiyakuBikinsagyouListDsbean.setIrGoukeitani(hknsyuruiKey.getContent());

                khKaiyakuBikinsagyouListDsbean.setIrGoukeikbn1("主契約");

                khKaiyakuBikinsagyouListDsbean.setIrGoukeikensuu1(hknsyuruiBean.getGoukeiKensuu());

                khKaiyakuBikinsagyouListDsbean.setIrGoukeibikingk1(hknsyuruiBean.getGoukeiGk());

                khKaiyakuBikinsagyouListDsbean.setIrGoukeiumukbn(C_UmuKbn.ARI);

                khKaiyakuBikinsagyouListDsbeanList.add(khKaiyakuBikinsagyouListDsbean);

                khKaiyakuBikinsagyouListDsbean =
                    SWAKInjector.getInstance(KhKaiyakuBikinsagyouListDataSourceBean.class);

                khKaiyakuBikinsagyouListDsbean.setIrBkncd("");

                khKaiyakuBikinsagyouListDsbean.setIrKbnkeirihknsyuruiryakunm(C_Segcd.BLNK);

                khKaiyakuBikinsagyouListDsbean.setIrBknkktiymdwareki("");

                khKaiyakuBikinsagyouListDsbean.setIrCalckijyunymdwareki("");

                khKaiyakuBikinsagyouListDsbean.setIrSisyacd("");

                khKaiyakuBikinsagyouListDsbean.setIrKigou("");

                khKaiyakuBikinsagyouListDsbean.setIrSyono("");

                khKaiyakuBikinsagyouListDsbean.setIrBkngk(BizCurrency.valueOf(0));

                khKaiyakuBikinsagyouListDsbean.setIrKihons(BizCurrency.valueOf(0));

                khKaiyakuBikinsagyouListDsbean.setIrTks(BizCurrency.valueOf(0));

                khKaiyakuBikinsagyouListDsbean.setIrTkkigou("");

                khKaiyakuBikinsagyouListDsbean.setIrKata("");

                khKaiyakuBikinsagyouListDsbean.setIrSaisiumukbn("");

                khKaiyakuBikinsagyouListDsbean.setIrDoujibkn("");

                khKaiyakuBikinsagyouListDsbean.setIrSokyuumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinsagyouListDsbean.setIrSoukiumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinsagyouListDsbean.setIrBknsgulisterrormsg("");

                khKaiyakuBikinsagyouListDsbean.setIrSakugenumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinsagyouListDsbean.setIrNkumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinsagyouListDsbean.setIrTenkanumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinsagyouListDsbean.setIrKeimaeumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinsagyouListDsbean.setIrSaihoumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinsagyouListDsbean.setIrSzouumukbn(C_UmuKbn.NONE);

                khKaiyakuBikinsagyouListDsbean.setIrBknsyutkkbn(C_BknsyutkKbn.BLNK);

                khKaiyakuBikinsagyouListDsbean.setIrBknkktinnd("");

                khKaiyakuBikinsagyouListDsbean.setIrBknkktiym("");

                khKaiyakuBikinsagyouListDsbean.setIrGoukeitani(bkncdKey.toString());

                khKaiyakuBikinsagyouListDsbean.setIrGoukeikbn1("主契約");

                khKaiyakuBikinsagyouListDsbean.setIrGoukeikensuu1(bkncdBean.getGoukeiKensuu());

                khKaiyakuBikinsagyouListDsbean.setIrGoukeibikingk1(bkncdBean.getGoukeiGk());

                khKaiyakuBikinsagyouListDsbean.setIrGoukeiumukbn(C_UmuKbn.ARI);

                khKaiyakuBikinsagyouListDsbeanList.add(khKaiyakuBikinsagyouListDsbean);


            }

            reportServicesBean.addParamObjects(khKaiyakuBikinsagyouListDsbeanList,khKaiyakuBikinsagyouListBean);

            reportServicesBean.setSyoriYmd(syoriYmd);

            createReport.execNoCommit(reportServicesBean);

            C_ErrorKbn errorKbn = bzFileUploadUtil.exec(C_FileSyuruiCdKbn.KH_BIKINSGYLSTCSVFKAIYAKU,
                khBikinSgyLstCsvfKaiyakuFileList, true);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
            }

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(outKensuu), "<<解約備金作業リスト>>"));

        }

    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate()  {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }

    class KhBikinSagyouListBean {

        public KhBikinSagyouListBean() {

            goukeiKensuu = BizNumber.valueOf(0);

            goukeiGk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        }


        private BizNumber goukeiKensuu;

        public BizNumber getGoukeiKensuu() {
            return goukeiKensuu;
        }

        public void setGoukeiKensuu(BizNumber pGoukeiKensuu) {
            goukeiKensuu = pGoukeiKensuu;
        }

        private BizCurrency goukeiGk;

        public BizCurrency getGoukeiGk() {
            return goukeiGk;
        }

        public void setGoukeiGk(BizCurrency pGoukeiGk) {
            goukeiGk = pGoukeiGk;
        }
    }
}
