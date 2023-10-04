package yuyu.batch.hozen.khansyuu.khminusuriagekykdtllistsks;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khansyuu.khminusuriagekykdtllistsks.dba.KhMinusUriageKykDtlListSksDao;
import yuyu.batch.hozen.khansyuu.khminusuriagekykdtllistsks.dba.MinusUriageKykDtlListSksTaisyouBean;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_SosikimasterUmuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_MinusUriageKykDtlList;
import yuyu.def.hozen.bean.report.KhMinusUriageKykDtlListBean;
import yuyu.def.hozen.bean.report.KhMinusUriageKykDtlListDataSourceBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 契約保全 案内収納 マイナス売上契約明細リスト作成
 * @author  清水　亜美
 * @version 2020/09/17 清水　亜美 : 新規作成<br />
 */
public class KhMinusUriageKykDtlListSksBatch implements Batch {

    /** 抽出対象テーブルID */
    private static final String TABLEID = IT_MinusUriageKykDtlList.TABLE_NAME;

    /** リカバリフィルタID */
    private static final String FILTERID = "Bz001";

    /** 担当室コード */
    private  static final String TANTOSITUCD = C_Tantositucd.SYUUNOUSV.getValue() + "0000";

    /** バッチログ出力用ロガー */
    @Inject
    private BatchLogger batchLogger;

    /** バッチパラメータ */
    @Inject
    private BzBatchParam bzBatchParam;

    /** 機能基幹テーブルエンティティ */
    @Inject
    private AS_Kinou kinou;

    /** マイナス売上契約明細リスト作成DAO */
    @Inject
    private KhMinusUriageKykDtlListSksDao khMinusUriageKykDtlListSksDao;

    /** （共通）リカバリデータ識別用BEAN */
    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    /** 業務基盤 DOM マネージャー */
    @Inject
    private BaseDomManager baseDomManager;

    /**
     * バッチパラメータを取得します。
     * @return バッチパラメータ
    */
    @Override
    public BatchParam getParam() {
        // インジェクション．バッチパラメータを返却する
        return bzBatchParam;
    }

    /**
     * バッチ主処理
     */
    @Execute
    @Transactional
    public void execute() {

        // WK．処理年月日 ← 起動パラメータ．処理年月日
        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        // 拡張ジョブコード ← 起動パラメータ．拡張ジョブコード
        String ibKakutyoujobcd = bzBatchParam.getIbKakutyoujobcd();

        // ログ情報出力
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            ibKakutyoujobcd));

        // 事前準備
        // WK．処理件数 ← 0
        int syoriKensuu= 0;
        // WK．合計金額 ← 0
        BizCurrency goukeikingk = BizCurrency.valueOf(0);
        // WK．帳票項目用担当室名 ← ブランク
        String tantosituNm = "";
        // WK．処理年月 ← WK．処理年月日 の年月
        BizDateYM syoriYm = syoriYmd.getBizDateYM();
        // WK．処理年月前月 ← WK．処理年月 - 1ヶ月
        BizDateYM syoriYmZengetu = syoriYm.getPreviousMonth();
        // WK．基準年月日 ← WK．処理年月 + "16"日 の営業日補正後の日付（翌営業日）
        BizDate kijyunYmd = BizDate.valueOf(syoriYm, 16).getBusinessDay(CHolidayAdjustingMode.NEXT);

        // 担当室名取得
        // WK．組織情報取得 の初期化
        BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

        // WK．組織情報取得Bean ← 【組織情報取得#メイン処理(基準日なし)】．実行結果
        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(TANTOSITUCD);

        // WK．組織情報取得Bean．組織マスタ有無区分 ＝ <組織マスタ有無区分>あり の場合
        if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {
            // WK．帳票項目用担当室名 ← WK．組織情報取得Bean．漢字組織名（２０文字）
            tantosituNm = bzGetSosikiDataBean.getKanjisosikinm20();
        }

        // 明細List生成
        // WK．マイナス売上契約明細リスト帳票DSBEANリスト初期化
        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        // --------------------------------------------
        // マイナス売上契約明細リスト作成対象Beanリスト（大量）取得
        // --------------------------------------------
        // 対象期間設定
        // WK．対象期間（自）
        BizDate taisyoukknfrom;
        // WK．対象期間（至）
        BizDate taisyoukknto;
        // WK．処理年月日 ≧ WK．基準年月日 の場合
        if(syoriYmd.compareTo(kijyunYmd) >= 0){
            // WK．対象期間（自） ← WK．処理年月 + "1"日
            taisyoukknfrom = BizDate.valueOf(syoriYm, 1);
            // WK．対象期間（至） ← WK．処理年月 + "15"日
            taisyoukknto = BizDate.valueOf(syoriYm, 15);
        } else {
            // WK．対象期間（自） ← WK．処理年月前月 + "16"日
            taisyoukknfrom = BizDate.valueOf(syoriYmZengetu, 16);
            // WK．対象期間（至） ← WK．処理年月前月 + 末日
            taisyoukknto = syoriYmZengetu.getLastDay();
        }

        // WK．マイナス売上契約明細リスト作成対象Beanリスト（大量） ←
        //【マイナス売上契約明細リスト作成DAO＃マイナス売上契約明細リスト作成対象Beanリスト（大量）取得 （拡張ジョブコード, 対象期間（自）, 対象期間（至））】．実行結果
        try (ExDBResults<MinusUriageKykDtlListSksTaisyouBean> sksTaisyouBeansLst =
            khMinusUriageKykDtlListSksDao.getMinusUriageKykDtlListSksTaisyouBeans(ibKakutyoujobcd, taisyoukknfrom, taisyoukknto);) {

            // WK．マイナス売上契約明細リスト作成対象Beanリスト（大量）の件数分、以下の処理を繰り返す（添え字： n = 0～）
            for (MinusUriageKykDtlListSksTaisyouBean sksTaisyouBean : sksTaisyouBeansLst) {
                // （共通）リカバリデータ識別用BEAN設定
                // （ＩＢ）拡張ジョブコード ← WK．拡張ジョブコード
                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobcd);
                // （ＩＢ）テーブルＩＤ ← 定数．抽出対象テーブルＩＤ
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                // （ＩＢ）リカバリフィルタＩＤ ← 定数．リカバリフィルタＩＤ
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                // （ＩＢ）リカバリフィルタキー１ ← WK．マイナス売上契約明細リスト作成対象Beanリスト（大量）[n]．証券番号
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(sksTaisyouBean.getSyono());

                // 機能名取得
                // WK．機能名 ← 【業務基盤 DOM マネージャー＃機能基幹テーブルエンティティ取得（機能ＩＤ）】．実行結果．機能名
                String kinounm = baseDomManager.getKinou(sksTaisyouBean.getKinouid()).getKinouNm();

                // WK．マイナス売上契約明細リスト帳票DSBEAN初期化
                KhMinusUriageKykDtlListDataSourceBean dataSourceBean = SWAKInjector.getInstance(KhMinusUriageKykDtlListDataSourceBean.class);

                // WK．マイナス売上契約明細リスト帳票DSBEANに下記の通り設定する。
                // （ＩＲ）証券番号 ← WK．マイナス売上契約明細リスト作成対象Beanリスト（大量）[n]．証券番号
                dataSourceBean.setIrSyono(sksTaisyouBean.getSyono());
                // （ＩＲ）売上年月日 ← WK．マイナス売上契約明細リスト作成対象Beanリスト（大量）[n]．売上年月日
                dataSourceBean.setIrUriageymd(sksTaisyouBean.getUriagenengappi());
                // （ＩＲ）クレジットカード決済用番号 ← WK．マイナス売上契約明細リスト作成対象Beanリスト（大量）[n]．クレジットカード決済用番号
                dataSourceBean.setIrCreditkessaiyouno(sksTaisyouBean.getCreditkessaiyouno());
                // （ＩＲ）充当年月 ← WK．マイナス売上契約明細リスト作成対象Beanリスト（大量）[n]．充当年月
                dataSourceBean.setIrJyuutouym(sksTaisyouBean.getJyuutouym());
                // （ＩＲ）クレジットカード売上金額 ← WK．マイナス売上契約明細リスト作成対象Beanリスト（大量）[n]．クレジットカード売上金額
                dataSourceBean.setIrCredituriagegk(sksTaisyouBean.getCredituriagegk());
                // （ＩＲ）機能名 ← WK．機能名
                dataSourceBean.setIrKinounm(kinounm);

                // WK．マイナス売上契約明細リストDSBEANリスト ← WK．マイナス売上契約明細リスト帳票DSBEAN
                iReportDataSouceBeanLst.add(dataSourceBean);

                // WK．処理件数 ← WK．処理件数 + 1
                syoriKensuu = syoriKensuu + 1;
                // WK．合計金額 ← WK．合計金額 + WK．マイナス売上契約明細リスト作成対象Beanリスト（大量）[n]．クレジットカード売上金額
                goukeikingk = goukeikingk.add(sksTaisyouBean.getCredituriagegk());
            }

            // （共通）リカバリデータ識別用BEANの初期化
            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        // WK．処理件数 ＞ 0 の場合
        if (syoriKensuu > 0) {
            // マイナス売上契約明細リスト編集
            // WK．マイナス売上契約明細リスト帳票BEAN初期化
            KhMinusUriageKykDtlListBean khMinusUriageKykDtlListBean = SWAKInjector.getInstance(
                KhMinusUriageKykDtlListBean.class);

            // WK．売上請求結果エラーリスト帳票BEANに下記の通り設定する。
            // （ＩＲ）担当室名 ← WK．帳票項目用担当室名
            khMinusUriageKykDtlListBean.setIrTantousitunm(tantosituNm);
            // （ＩＲ）処理日 ← WK．処理年月日
            khMinusUriageKykDtlListBean.setIrSyoribi(syoriYmd);
            // （ＩＲ）件数 ← WK．処理件数
            khMinusUriageKykDtlListBean.setIrKensuu(syoriKensuu);
            // （ＩＲ）合計金額 ← WK．合計金額
            khMinusUriageKykDtlListBean.setIrGoukeikingk(goukeikingk);

            // WK．帳票作成共通クラス の初期化
            CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

            // WK．帳票サービスBean ← 【帳票作成共通クラス＃帳票サービスBeanの作成処理】．実行結果
            ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                kinou.getSubSystemId(),                                   // 機能基幹テーブルエンティティ．サブシステムＩＤ
                kinou.getCategoryId(),                                    // 機能基幹テーブルエンティティ．カテゴリＩＤ
                kinou.getKinouId(),                                       // 機能基幹テーブルエンティティ．機能ＩＤ
                C_SyoruiCdKbn.AS_MINUSURIAGEKYKDTLLIST);                  // <書類コード区分>マイナス売上契約明細リスト

            // WK．帳票サービスBeanに対し、【帳票サービスBean＃パラメータオブジェクト追加処理】を実行する
            reportServicesBean.addParamObjects(iReportDataSouceBeanLst, khMinusUriageKykDtlListBean, syoriYmd);

            // WK．帳票作成共通クラスに対し、【帳票作成共通クラス＃帳票作成】を実行する。
            createReport.execNoCommit(reportServicesBean);
        }

        // --------------------------------------------
        // 前回対象分の削除
        // --------------------------------------------
        // 売上年月日設定
        // WK．売上年月日
        BizDate uriagenengappi;
        // WK．処理年月日 ≧ WK．基準年月日 の場合
        if(syoriYmd.compareTo(kijyunYmd) >= 0){
            // WK．売上年月日 ← WK．処理年月 + "1"日
            uriagenengappi = BizDate.valueOf(syoriYm, 1);
        } else {
            // WK．売上年月日 ← WK．処理年月前月 + "16"日
            uriagenengappi = BizDate.valueOf(syoriYmZengetu, 16);
        }

        // 【マイナス売上契約明細リスト作成DAO#マイナス売上契約明細リストテーブル削除】．実行結果
        khMinusUriageKykDtlListSksDao.deleteMinusUriageKykDtlList(uriagenengappi);

        // バッチログ出力（処理件数）
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    /**
     * バッチ異常終了時共通処理（リカバリ対応用）の呼出<br />
     * 異常終了時に呼び出される処理<br />
     */
    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        // WK．共通 バッチ異常終了時共通処理（リカバリ対応用）
        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        // 【バッチ異常終了時共通処理（リカバリ対応用）＃メイン処理】を実行する
        bzBatchAbendCommonRecovery.exec();
    }
}
