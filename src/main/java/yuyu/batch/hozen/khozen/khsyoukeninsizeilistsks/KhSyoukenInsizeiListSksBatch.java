package yuyu.batch.hozen.khozen.khsyoukeninsizeilistsks;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.report.ViewReport;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_InsizeiShryouhiKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_SosikimasterUmuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.hozen.bean.report.KhInsizeiListBean;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 契約保全 インターフェイス 証券印紙税リスト作成
 */
public class KhSyoukenInsizeiListSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private CreateReport createReport;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDateYM tysytYm = bzBatchParam.getSyoriYmd().addMonths(-1).getBizDateYM();

        BizDate tysytYmdFrom = BizDate.valueOf(tysytYm, 1);

        BizDate tysytYmdTo = BizDate.valueOf(tysytYm, 31).getRekijyou();

        Long hkMaisuu = hozenDomManager.getHokenSyoukenCountByTysytymdFromTysytymdToSinsaihkkbn(tysytYmdFrom,
            tysytYmdTo, C_SinsaihkKbn.SIN);

        Long youHkMaisuu = hozenDomManager.
            getHokenSyoukenCountByTysytymdFromTysytymdToSinsaihkkbnSyoukensaihkkbnInsizeishryouhikbn(tysytYmdFrom,
                tysytYmdTo, C_SinsaihkKbn.SAI, C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI, C_InsizeiShryouhiKbn.YOU);

        Long huyouHkMaisuu = hozenDomManager.
            getHokenSyoukenCountByTysytymdFromTysytymdToSinsaihkkbnSyoukensaihkkbnInsizeishryouhikbn(tysytYmdFrom,
                tysytYmdTo, C_SinsaihkKbn.SAI, C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI, C_InsizeiShryouhiKbn.HUYOU);

        Long saiHkMaisuu = hozenDomManager.
            getHokenSyoukenCountByTysytymdFromTysytymdToSinsaihkkbnSyoukensaihkkbn(tysytYmdFrom, tysytYmdTo,
                C_SinsaihkKbn.SAI, C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);

        String syoriYmd = DateFormatUtil.dateKANJI(bzBatchParam.getSyoriYmd());

        String sakuseiYm = DateFormatUtil.dateYmKANJI(tysytYm);

        ReportServicesBean sinkeiyakuReportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(), kinou.getCategoryId(), kinou.getKinouId(), C_SyoruiCdKbn.KK_INSIZEILIST_SKEI);

        Long insizeiSinkokuMaisuu = hkMaisuu + youHkMaisuu;

        BM_TantouCd bmTantouCdSyoukenYousei = bizDomManager.getTantouCd(C_TantouCdKbn.DAIRITENJIMUKANRI);

        String busituCd =bmTantouCdSyoukenYousei.getBusitucd();

        BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

        String busitunmSin = "";

        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(busituCd + "0000");

        if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())){

            busitunmSin = bzGetSosikiDataBean.getKanjisosikinm20();

        }

        String hozonkkn = ViewReport.getHozonKknTani(C_SyoruiCdKbn.KK_INSIZEILIST_SKEI);

        KhInsizeiListBean sinkeiyakuKhInsizeiListBean = SWAKInjector.getInstance(KhInsizeiListBean.class);

        sinkeiyakuKhInsizeiListBean.setIrTantsitunmkj(busitunmSin);
        sinkeiyakuKhInsizeiListBean.setIrSyoribiwareki(syoriYmd);
        sinkeiyakuKhInsizeiListBean.setIrTyouhyousakuseiymwareki(sakuseiYm);
        sinkeiyakuKhInsizeiListBean.setIrSyoseikihkmaisuu(hkMaisuu.intValue());
        sinkeiyakuKhInsizeiListBean.setIrSyosaiskmaisuuyou(youHkMaisuu.intValue());
        sinkeiyakuKhInsizeiListBean.setIrSyosaiskmaisuufuyou(huyouHkMaisuu.intValue());
        sinkeiyakuKhInsizeiListBean.setIrSyosaihkmaisuu(0);
        sinkeiyakuKhInsizeiListBean.setIrInsizeisinkokumaisuu(insizeiSinkokuMaisuu.intValue());
        sinkeiyakuKhInsizeiListBean.setIrHozonkkn(hozonkkn);

        sinkeiyakuReportServicesBean.addParamObjects(sinkeiyakuKhInsizeiListBean);
        sinkeiyakuReportServicesBean.setSyoriYmd(bzBatchParam.getSyoriYmd());

        ReportServicesBean saihkReportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(), kinou.getCategoryId(), kinou.getKinouId(), C_SyoruiCdKbn.KK_INSIZEILIST_SAI);

        BM_TantouCd bmTantouCdMeigiHenkou = bizDomManager.getTantouCd(C_TantouCdKbn.MEIGIHENKOU);

        busituCd =bmTantouCdMeigiHenkou.getBusitucd();

        bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

        String busitunmSai = "";

        bzGetSosikiDataBean = bzGetSosikiData.exec(busituCd + "0000");

        if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())){

            busitunmSai = bzGetSosikiDataBean.getKanjisosikinm20();

        }

        String hozonkkn1 = ViewReport.getHozonKknTani(C_SyoruiCdKbn.KK_INSIZEILIST_SAI);

        KhInsizeiListBean saihkKhInsizeiListBean = SWAKInjector.getInstance(KhInsizeiListBean.class);

        saihkKhInsizeiListBean.setIrTantsitunmkj(busitunmSai);
        saihkKhInsizeiListBean.setIrSyoribiwareki(syoriYmd);
        saihkKhInsizeiListBean.setIrTyouhyousakuseiymwareki(sakuseiYm);
        saihkKhInsizeiListBean.setIrSyoseikihkmaisuu(0);
        saihkKhInsizeiListBean.setIrSyosaiskmaisuuyou(0);
        saihkKhInsizeiListBean.setIrSyosaiskmaisuufuyou(0);
        saihkKhInsizeiListBean.setIrSyosaihkmaisuu(saiHkMaisuu.intValue());
        saihkKhInsizeiListBean.setIrInsizeisinkokumaisuu(saiHkMaisuu.intValue());
        saihkKhInsizeiListBean.setIrHozonkkn(hozonkkn1);

        saihkReportServicesBean.addParamObjects(saihkKhInsizeiListBean);
        saihkReportServicesBean.setSyoriYmd(bzBatchParam.getSyoriYmd());

        ReportServicesBean[] reportServicesBeans = {sinkeiyakuReportServicesBean, saihkReportServicesBean};

        createReport.exec(reportServicesBeans);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(insizeiSinkokuMaisuu)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(saiHkMaisuu)));

    }
}
