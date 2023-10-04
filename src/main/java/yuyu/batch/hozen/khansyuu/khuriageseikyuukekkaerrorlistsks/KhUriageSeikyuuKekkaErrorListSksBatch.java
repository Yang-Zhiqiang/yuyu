package yuyu.batch.hozen.khansyuu.khuriageseikyuukekkaerrorlistsks;

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
import yuyu.batch.hozen.khansyuu.khuriageseikyuukekkaerrorlistsks.dba.KhUriageSeikyuuKekkaErrorListSksDao;
import yuyu.batch.hozen.khansyuu.khuriageseikyuukekkaerrorlistsks.dba.UriageSeikyuuKekkaErrorListSksTaisyouBean;
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
import yuyu.def.db.entity.IT_UriageSeikyuuKkErrorList;
import yuyu.def.hozen.bean.report.KhUriageSeikyuuKekkaErrorListBean;
import yuyu.def.hozen.bean.report.KhUriageSeikyuuKekkaErrorListDataSourceBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 契約保全 案内収納 売上請求結果エラーリスト作成
 * @author  林　延景
 * @version 2019/10/16 林　延景 : 新規作成<br />
 * @version 2020/09/14 朱　紅妍 : 2021年03月23日対応<br />
 */
public class KhUriageSeikyuuKekkaErrorListSksBatch implements Batch {

    /** 抽出対象テーブルID */
    private static final String TABLEID = IT_UriageSeikyuuKkErrorList.TABLE_NAME;

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

    /** 売上請求結果エラーリスト作成DAO */
    @Inject
    private KhUriageSeikyuuKekkaErrorListSksDao khUriageSeikyuuKekkaErrorListSksDao;

    /** （共通）リカバリデータ識別用BEAN */
    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    /** 業務基盤 DOM マネージャー */
    @Inject
    private BaseDomManager baseDomManager;

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
            String.valueOf(bzBatchParam.getSyoriYmd())));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            ibKakutyoujobcd));

        // 事前準備
        // WK．処理件数 ← 0
        int syoriKensuu= 0;
        // WK．帳票項目用担当室名 ← ブランク
        String tantosituNm = "";

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
        // WK．売上請求結果エラーリスト帳票DSBEANリスト初期化
        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        // --------------------------------------------
        // 売上請求結果エラーリスト作成対象Beanリスト（大量）取得
        // --------------------------------------------

        // WK．売上請求結果エラーリスト作成対象Beanリスト（大量） ←
        //【売上請求結果エラーリスト作成DAO#売上請求結果エラーリスト作成対象Beanリスト（大量）取得 （拡張ジョブコード, 処理年月日）】．実行結果
        try (ExDBResults<UriageSeikyuuKekkaErrorListSksTaisyouBean> sksTaisyouBeansLst =
            khUriageSeikyuuKekkaErrorListSksDao.getUriageSeikyuuKekkaErrorListSksTaisyouBeans(ibKakutyoujobcd, syoriYmd);) {

            // WK．売上請求結果エラーリスト作成対象Beanリスト（大量）の件数分、以下の処理を繰り返す（添え字： ｎ = 0～）
            for (UriageSeikyuuKekkaErrorListSksTaisyouBean sksTaisyouBean : sksTaisyouBeansLst) {
                // （共通）リカバリデータ識別用BEAN設定
                // （ＩＢ）拡張ジョブコード ← WK．拡張ジョブコード
                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobcd);
                // （ＩＢ）テーブルＩＤ ← 定数．抽出対象テーブルＩＤ
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                // （ＩＢ）リカバリフィルタＩＤ ← 定数．リカバリフィルタＩＤ
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                // （ＩＢ）リカバリフィルタキー１ ← WK．売上請求結果エラーリスト作成対象Beanリスト（大量）[n]．証券番号
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(sksTaisyouBean.getSyono());

                // WK．機能基幹テーブル ←【業務基盤 DOM マネージャー＃機能基幹テーブルエンティティ取得（機能ＩＤ）】．実行結果
                AS_Kinou kinouTbl = baseDomManager.getKinou(sksTaisyouBean.getKinouId());
                // WK．機能名 ← WK．機能基幹テーブル．機能名
                String kinouNm = kinouTbl.getKinouNm();

                // WK．売上請求結果エラーリスト帳票DSBEAN初期化
                KhUriageSeikyuuKekkaErrorListDataSourceBean dataSourceBean = SWAKInjector.getInstance(
                    KhUriageSeikyuuKekkaErrorListDataSourceBean.class);

                // WK．売上請求結果エラーリスト帳票DSBEANに下記の通り設定する。
                // （ＩＲ）証券番号 ← WK．売上請求結果エラーリスト作成対象Beanリスト（大量）[n]．証券番号
                dataSourceBean.setIrSyono(sksTaisyouBean.getSyono());
                // （ＩＲ）クレジットカード決済用番号 ← WK．売上請求結果エラーリスト作成対象Beanリスト（大量）[n]．クレジットカード決済用番号
                dataSourceBean.setIrCreditkessaiyouno(sksTaisyouBean.getCreditkessaiyouno());
                // （ＩＲ）売上年月日 ← WK．売上請求結果エラーリスト作成対象Beanリスト（大量）[n]．売上年月日
                dataSourceBean.setIrUriageymd(sksTaisyouBean.getUriagenengappi());
                // （ＩＲ）クレジットカード売上金額 ← WK．売上請求結果エラーリスト作成対象Beanリスト（大量）[n]．クレジットカード売上金額
                dataSourceBean.setIrCredituriagegk(sksTaisyouBean.getCredituriagegk());
                // （ＩＲ）クレジットカード売上請求ＮＧ事由 ← WK．売上請求結果エラーリスト作成対象Beanリスト（大量）[n]．クレジットカード売上請求NG事由
                dataSourceBean.setIrCredituriagengjiyuu(sksTaisyouBean.getCredituriagengjiyuu());
                // （ＩＲ）エラーコード ← WK．売上請求結果エラーリスト作成対象Beanリスト（大量）[n]．売上請求エラーコード
                dataSourceBean.setIrErrorcd(sksTaisyouBean.getUriageseikyuuerrorcd());
                // （ＩＲ）オーソリ ← WK．売上請求結果エラーリスト作成対象Beanリスト（大量）[n]．オーソリ区分
                dataSourceBean.setIrAuthorikbn(sksTaisyouBean.getAuthorikbn());
                // （ＩＲ）機能名 ← WK．機能名
                dataSourceBean.setIrKinounm(kinouNm);
                // （ＩＲ）クレジットカード売上請求区分 ← WK．売上請求結果エラーリスト作成対象Beanリスト（大量）[n]．クレジットカード売上請求区分
                dataSourceBean.setIrCredituriageseikyuukbn(sksTaisyouBean.getCredituriageseikyuukbn());

                // WK．売上請求結果エラーリストDSBEANリスト ← WK．売上請求結果エラーリスト帳票DSBEAN
                iReportDataSouceBeanLst.add(dataSourceBean);

                // 件数のカウントアップ
                // WK．処理件数 ← WK．処理件数 ＋ 1
                syoriKensuu = syoriKensuu + 1;
            }

            // （共通）リカバリデータ識別用BEANの初期化
            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        // WK．処理件数 ＞ 0 の場合
        if (syoriKensuu > 0) {
            // 売上請求結果エラーリスト編集
            // WK．売上請求結果エラーリスト帳票BEAN初期化
            KhUriageSeikyuuKekkaErrorListBean uriageSeikyuuKekkaErrorListBean = SWAKInjector.getInstance(
                KhUriageSeikyuuKekkaErrorListBean.class);

            // WK．売上請求結果エラーリスト帳票BEANに下記の通り設定する。
            // （ＩＲ）担当室名 ← WK．帳票項目用担当室名
            uriageSeikyuuKekkaErrorListBean.setIrTantousitunm(tantosituNm);
            // （ＩＲ）処理日 ← WK．処理年月日
            uriageSeikyuuKekkaErrorListBean.setIrSyoribi(syoriYmd);
            // （ＩＲ）件数 ← WK．処理件数
            uriageSeikyuuKekkaErrorListBean.setIrKensuu(syoriKensuu);

            // WK．帳票作成共通クラス の初期化
            CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

            // WK．帳票サービスBean ← 【帳票作成共通クラス＃帳票サービスBeanの作成処理】．実行結果
            ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                kinou.getSubSystemId(),                                   // 機能基幹テーブルエンティティ．サブシステムＩＤ
                kinou.getCategoryId(),                                    // 機能基幹テーブルエンティティ．カテゴリＩＤ
                kinou.getKinouId(),                                       // 機能基幹テーブルエンティティ．機能ＩＤ
                C_SyoruiCdKbn.AS_URIAGESEIKYUUKEKKA_ERRORLIST);           // <書類コード区分>売上請求結果エラーリスト

            // WK．帳票サービスBeanに対し、【帳票サービスBean＃パラメータオブジェクト追加処理】を実行する
            reportServicesBean.addParamObjects(iReportDataSouceBeanLst, uriageSeikyuuKekkaErrorListBean, syoriYmd);

            // WK．帳票作成共通クラスに対し、【帳票作成共通クラス＃帳票作成】を実行する。
            createReport.execNoCommit(reportServicesBean);
        }

        // 前回対象分の削除
        // 【売上請求結果エラーリスト作成DAO#売上請求結果エラーリストテーブル削除】．実行結果
        khUriageSeikyuuKekkaErrorListSksDao.deleteUriageSeikyuuKekkaErrorList(syoriYmd);

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
