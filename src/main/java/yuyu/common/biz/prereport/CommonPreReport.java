package yuyu.common.biz.prereport;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.RayConvertUtil;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyoruiTorikomiHouKbn;
import yuyu.def.db.entity.BM_TorikomiSyoruiHukaInfo;
import yuyu.infr.report.PreCreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.base.Strings;

/**
 * 帳票作成共通前処理クラスです。</br>
 * 帳票基盤から帳票作成を行う場合に、帳票基盤より帳票作成共通前処理（当処理）を実行する。</br>
 * 帳票作成共通前処理より、必要に応じて工程の開始/遷移、QRコード値の取得、到着予定の登録を行う。</br>
 * ＱＲコード値の取得が行われた場合、帳票サービスBeanのＱＲコード値に設定する。</br>
 * また、取込用表紙作成で「帳票作成時に工程を作成する書類」の表紙を作成する場合は帳票作成前工程操作処理、QRコード値取得処理、到着予定登録処理がそれぞれ個別に実行され、</br>
 * 外部用QR一括作成や、他システム（生保Web）へ連携し他システム側でQR画像化する場合等でQRコード値取得処理のみが個別に実行される。</br>
 * ※なお、取込用表紙作成で「帳票作成時に工程を作成しない書類」の表紙を作成する場合、およびQRシール用紙作成については本処理を使用せず</br>、
 * 　新契約業務チームにて作成予定の【新契約工程開始（新規）】および【新契約工程開始（申込番号指定）】にて工程操作、QRコード値取得、到着予定管理を行うため</br>
 * 　帳票基盤から「帳票作成共通前処理」が取込用表紙またはQRシール用紙の書類コードで実行された場合は各処理をスキップする。</br>
 */
public class CommonPreReport extends PreCreateReport {

    @Override
    public void exec(ReportServicesBean rsBean)
    {
        RayConvertUtil.toPrintableString(rsBean);

        if (rsBean == null || rsBean.getSyoruiCdKbns() == null || rsBean.getSyoruiCdKbns().length == 0) {
            return;
        }

        String wkKouteiKnrId = null;
        String wkQrCode = null;

        for (C_SyoruiCdKbn wkSyoruiCdKbn : rsBean.getSyoruiCdKbns()) {
            if (wkSyoruiCdKbn.eq(C_SyoruiCdKbn.WF_HYOUSI) ||
                wkSyoruiCdKbn.eq(C_SyoruiCdKbn.WF_QRSEAL)) {
                continue;
            }

            BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo = null;
            if (!Strings.isNullOrEmpty(C_SyoruiCdKbn.getContentByValue(wkSyoruiCdKbn.getValue()))) {
                BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
                torikomiSyoruiHukaInfo = bizDomManager.getTorikomiSyoruiHukaInfo(wkSyoruiCdKbn);
            }

            wkKouteiKnrId = ExecPreReportOperateProcess.execPreReportOperateProcess(wkSyoruiCdKbn.getValue(),rsBean);

            wkQrCode = GetQRCode.execGetQRCode(wkSyoruiCdKbn.getValue());

            SyoruiToutyakuYoteiTouroku.execSyoruiToutyakuYoteiTouroku(wkSyoruiCdKbn.getValue(), wkKouteiKnrId, wkQrCode);

            if (torikomiSyoruiHukaInfo != null && C_SyoruiTorikomiHouKbn.SCAN_QR.eq(torikomiSyoruiHukaInfo.getSyoruitorikomihoukbn()) && !Strings.isNullOrEmpty(wkQrCode)) {
                rsBean.setQrCode(wkQrCode);
            }
        }
    }
}