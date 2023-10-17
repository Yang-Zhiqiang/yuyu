package yuyu.batch.biz.bzkaikei.bztienrskutiwakelistsks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateFormat;
import jp.co.slcs.swak.date.BizDateFormat.FillStyle;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.bean.report.BzTienrskutiwakelistBean;
import yuyu.def.biz.bean.report.BzTienrskutiwakelistDataSourceBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.db.entity.AM_Sosiki;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.collect.Ordering;

/**
 * 業務共通 経理・会計 支払遅延利息内訳リスト作成
 */
public class BzTienrskUtiwakeListSksBatch implements Batch {

    private final String KAIYAKU = "RB30";

    private final String GENGAKU = "RB10";

    private final String SATEISHIBOU = "RC05";

    private final String BATCHKAIYAKU = "RBA2";

    private final String KHYENDTHNKHRSHR = "RB75";

    private final String HAITOUKINSHR = "RB76";

    //private final String NENKINITITOKIKIN = "E";

    //private final String TUUJOU = "F";

    //private final String SHIBOUITIZIKIN = "G";

    private final int ZERO = 0;
    private final int KETA = 15;

    private final String ZERO_FOURKETA = "0000";

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private CreateReport createReport;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BatchLogger batchLogger;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));

        List<BzTienrskUtiwakeListSksBean> bzTienrskUtiwakeListSksBeanLst = new ArrayList<>();
        Map<String, BzTienrskUtiwakeListSksBean> bzTienrskUtiwakeListSksBeanMap = new HashMap<>();
        BzTienrskUtiwakeListSksBean tempBzTienrskUtiwakeListSksBean = null;
        BizDate syoriDateBefore = null;
        BizDateYM denpyouDate = null;
        BizDate selYmdFrom = bzBatchParam.getSyoriYmd().getBizDateYM().getPreviousMonth().getFirstDay();
        BizDate selYmdTo = bzBatchParam.getSyoriYmd().getBizDateYM().getPreviousMonth().getLastDay();
        String mapKey = null;

        List<BT_DenpyoData> denpyoDataLst = bizDomManager.getDenpyoDatasByDenymdKanjyoukmkcds(selYmdFrom, selYmdTo);

        for (BT_DenpyoData denpyoData : denpyoDataLst) {

            BM_TantouCd tantouCd = selTantouKodo(denpyoData);

            mapKey = tantouCd.getBusitucd() + denpyoData.getSyoricd();

            if (bzTienrskUtiwakeListSksBeanMap.containsKey(mapKey)) {

                tempBzTienrskUtiwakeListSksBean = bzTienrskUtiwakeListSksBeanMap.get(mapKey);

                if (C_TaisyakuKbn.KASIKATA.eq(denpyoData.getTaisyakukbn())) {

                    tempBzTienrskUtiwakeListSksBean.setKasikatagk((
                        tempBzTienrskUtiwakeListSksBean.getKasikatagk() == null ? BizCurrency.valueOf(0) :
                            tempBzTienrskUtiwakeListSksBean.getKasikatagk()).add(denpyoData.getDenyenkagk()));
                }
                else if (C_TaisyakuKbn.KARIKATA.eq(denpyoData.getTaisyakukbn())) {

                    tempBzTienrskUtiwakeListSksBean.setKarikatagk((
                        tempBzTienrskUtiwakeListSksBean.getKarikatagk() == null ? BizCurrency.valueOf(0) :
                            tempBzTienrskUtiwakeListSksBean.getKarikatagk()).add(denpyoData.getDenyenkagk()));
                }

                tempBzTienrskUtiwakeListSksBean.setKensuu(tempBzTienrskUtiwakeListSksBean.getKensuu() + 1);
            }
            else {

                tempBzTienrskUtiwakeListSksBean = SWAKInjector.getInstance(BzTienrskUtiwakeListSksBean.class);

                String sosikiCd = tantouCd.getBusitucd() + ZERO_FOURKETA;
                AM_Sosiki sosiki = baseDomManager.getSosiki(sosikiCd);

                tempBzTienrskUtiwakeListSksBean.setShiharaiTienRisoCd(tantouCd.getBusitucd());
                tempBzTienrskUtiwakeListSksBean.setShiharaiTienRisoNm(sosiki.getKanjisosikinm20());
                tempBzTienrskUtiwakeListSksBean.setSyoriCd(denpyoData.getSyoricd());
                tempBzTienrskUtiwakeListSksBean.setKensuu(1);

                if (C_TaisyakuKbn.KASIKATA.eq(denpyoData.getTaisyakukbn())) {

                    tempBzTienrskUtiwakeListSksBean.setKasikatagk(denpyoData.getDenyenkagk());
                }
                else if (C_TaisyakuKbn.KARIKATA.eq(denpyoData.getTaisyakukbn())) {

                    tempBzTienrskUtiwakeListSksBean.setKarikatagk(denpyoData.getDenyenkagk());
                }

                bzTienrskUtiwakeListSksBeanMap.put(mapKey, tempBzTienrskUtiwakeListSksBean);
            }
        }

        bzTienrskUtiwakeListSksBeanLst = new ArrayList<>(bzTienrskUtiwakeListSksBeanMap.values());

        bzTienrskUtiwakeListSksBeanLst =
            Ordering.from(new BzTienrskUtiwakeListSksComparator()).sortedCopy(bzTienrskUtiwakeListSksBeanLst);

        syoriDateBefore = bzBatchParam.getSyoriYmd().getPreviousMonth();
        denpyouDate = syoriDateBefore.getBizDateYM();

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        for (BzTienrskUtiwakeListSksBean bzTienrskUtiwakeListSksBean : bzTienrskUtiwakeListSksBeanLst) {

            AS_Kinou asKinou = baseDomManager.getKinousBySyoricd(bzTienrskUtiwakeListSksBean.getSyoriCd()).get(ZERO);

            BzTienrskutiwakelistDataSourceBean bzTienrskutiwakelistBean =
                SWAKInjector.getInstance(BzTienrskutiwakelistDataSourceBean.class);

            bzTienrskutiwakelistBean.setIrHuridenatesakinm(bzTienrskUtiwakeListSksBean.getShiharaiTienRisoNm());
            bzTienrskutiwakelistBean.setIrSyoricd(bzTienrskUtiwakeListSksBean.getSyoriCd());
            if (asKinou.getKinouNm().length() > KETA) {
                bzTienrskutiwakelistBean.setIrSyorinm(asKinou.getKinouNm().substring(ZERO, KETA));
            } else {
                bzTienrskutiwakelistBean.setIrSyorinm(asKinou.getKinouNm());
            }
            bzTienrskutiwakelistBean.setIrKensuu(bzTienrskUtiwakeListSksBean.getKensuu());
            bzTienrskutiwakelistBean.setIrKarikatagk(bzTienrskUtiwakeListSksBean.getKarikatagk());
            bzTienrskutiwakelistBean.setIrKasikatagk(bzTienrskUtiwakeListSksBean.getKasikatagk());

            iReportDataSouceBeanLst.add(bzTienrskutiwakelistBean);
        }

        if (iReportDataSouceBeanLst.size() > 0) {

            BzTienrskutiwakelistBean bzTienrskutiwakelistBean =
                SWAKInjector.getInstance(BzTienrskutiwakelistBean.class);

            BizDateFormat fmt = new BizDateFormat("yyyy年MM月dd日", FillStyle.Blank);
            bzTienrskutiwakelistBean.setIrSyoribiwareki(fmt.format(bzBatchParam.getSyoriYmd()));
            fmt = new BizDateFormat("yyyy年MM月", FillStyle.None);
            bzTienrskutiwakelistBean.setIrDenym(ConvertUtil.toZenAll(fmt.format(denpyouDate), 1, 1));

            ReportServicesBean reportServicesBean =
                createReport.createNewReportServiceBean(kinou.getSubSystemId(), kinou.getCategoryId(),
                    kinou.getKinouId(), C_SyoruiCdKbn.CM_TIENRSKUTIWAKELIST);

            reportServicesBean.setSyoriYmd(bzBatchParam.getSyoriYmd());

            reportServicesBean.addParamObjects(iReportDataSouceBeanLst, bzTienrskutiwakelistBean);

            createReport.exec(reportServicesBean);
        }

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0001, String.valueOf(bzTienrskUtiwakeListSksBeanLst.size())));
    }

    private BM_TantouCd selTantouKodo(BT_DenpyoData pDenpyoData) {

        C_TantouCdKbn tantouCdKbn = C_TantouCdKbn.BLNK0;

        if (KAIYAKU.equals(pDenpyoData.getSyoricd())) {

            tantouCdKbn = C_TantouCdKbn.KAIYAKU;
        }
        else if (GENGAKU.equals(pDenpyoData.getSyoricd())) {

            tantouCdKbn = C_TantouCdKbn.KEIYAKUHENKOU;
        }
        else if (SATEISHIBOU.equals(pDenpyoData.getSyoricd())) {

            tantouCdKbn = C_TantouCdKbn.SIBOUTETUZUKI;
        }
        else if (BATCHKAIYAKU.equals(pDenpyoData.getSyoricd())) {

            tantouCdKbn = C_TantouCdKbn.DS;
        }
        else if (KHYENDTHNKHRSHR.equals(pDenpyoData.getSyoricd())) {

            tantouCdKbn = C_TantouCdKbn.DAIRITENJIMUHOZEN;
        }
        else if(HAITOUKINSHR.equals(pDenpyoData.getSyoricd())) {

            tantouCdKbn = C_TantouCdKbn.SOUKATU;
        }

        /*
        else if (NENKINITITOKIKIN.equals(pDenpyoData.getSyoricd()) ||
            TUUJOU.equals(pDenpyoData.getSyoricd()) || SHIBOUITIZIKIN.equals(pDenpyoData.getSyoricd())) {

            tantouCdKbn = C_TantouCdKbn.NENKIN;
        }
         */

        else {

            tantouCdKbn = pDenpyoData.getTantocd();
        }

        return bizDomManager.getTantouCd(tantouCdKbn);
    }
}
