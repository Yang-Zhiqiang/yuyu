package yuyu.common.hozen.ascommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.EditKhMisslstParam;
import yuyu.common.hozen.khcommon.EditKhMisslstTbl;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.MessageId;
import yuyu.def.classification.C_Dbhanei;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 契約保全 案内収納共通 案内収納用バッチ処理不能契約ミスリスト作成
 */
public class AnsyuuBatSyoriHunoKykMisslistSks {

    private static int MISSLISTPAGE_ROWLIMIT = 17;

    private static int MIDASIMONGON_ROWLINECNT = 1;

    private int pageLimit = 3;

    private int errerLimit = 100;

    private List<EditKhMisslstParam> editKhMisslstParamList = new ArrayList<EditKhMisslstParam>();

    private int errorkensuu = 0;

    @Inject
    private static Logger logger;

    public void setPageLimit(int pPageLimit) {
        pageLimit = pPageLimit;
    }

    public void setErrerLimit(int pErrerLimit) {
        errerLimit = pErrerLimit;
    }

    public void addErrerMsg(String pSyono, String pMisslistmsg) {

        addErrerMsg(pSyono, pMisslistmsg, pMisslistmsg);
    }

    public void addErrerMsg(String pSyono, String pMisslistmsg, String pLogmsg) {

        logger.error("処理不能エラー。証券番号＝" + pSyono + "　エラーMSG＝" + pLogmsg);

        errorkensuu = errorkensuu + 1;

        if (errerLimit < errorkensuu) {

            throw new CommonBizAppException("許容上限を超える数のエラーを検知しました。　許容上限＝" + String.valueOf(errerLimit));
        }

        if (errorkensuu <= getMsgPrintLimit()) {

            int sequenceNo = errorkensuu + MIDASIMONGON_ROWLINECNT;

            EditKhMisslstParam editKhMisslstParam = SWAKInjector.getInstance(EditKhMisslstParam.class);
            editKhMisslstParam.setDataNo(sequenceNo);
            editKhMisslstParam.setSeqNo(sequenceNo);
            editKhMisslstParam.setMisslistMsg(pMisslistmsg);
            editKhMisslstParam.setDBhaneikbn(C_Dbhanei.NONE);
            editKhMisslstParam.setSyoNo(pSyono);

            editKhMisslstParamList.add(editKhMisslstParam);
        }
    }

    public boolean hasMisslistMsg() {

        if (editKhMisslstParamList.size() > 0) {
            return true;
        }

        return false;
    }

    public String createReport(KhozenCommonParam pKhozenCommonParam, BizDate pSyoriymd) {

        String midasiMongon = MessageUtil.getMessage(
            MessageId.EIF3060, String.valueOf(errorkensuu), String.valueOf(getMsgPrintLimit()));

        List<EditKhMisslstParam> reporteditKhMisslstParamList = new ArrayList<EditKhMisslstParam>();

        EditKhMisslstParam editKhMisslstParam = SWAKInjector.getInstance(EditKhMisslstParam.class);
        editKhMisslstParam.setDataNo(1);
        editKhMisslstParam.setSeqNo(1);
        editKhMisslstParam.setMisslistMsg(midasiMongon);
        editKhMisslstParam.setDBhaneikbn(C_Dbhanei.NONE);
        editKhMisslstParam.setSyoNo("");

        reporteditKhMisslstParamList.add(editKhMisslstParam);
        reporteditKhMisslstParamList.addAll(editKhMisslstParamList);

        EditKhMisslstTbl editKhMisslstTbl = SWAKInjector.getInstance(EditKhMisslstTbl.class);
        ReportServicesBean reportServicesBean = editKhMisslstTbl.editBean(
            C_SyoruiCdKbn.AS_MISSLIST_SYUUNOU, pKhozenCommonParam, reporteditKhMisslstParamList, pSyoriymd);

        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);
        String reportKey = createReport.execNoCommit(reportServicesBean);

        return reportKey;
    }

    private int getMsgPrintLimit() {

        int msgPrintLimit = (MISSLISTPAGE_ROWLIMIT * pageLimit) - MIDASIMONGON_ROWLINECNT;
        return msgPrintLimit;
    }
}
