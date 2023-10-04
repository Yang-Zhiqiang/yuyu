package yuyu.batch.hozen.khansyuu.khyuukouseikekkahanei;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.db.MultipleEntityUpdater;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khansyuu.khyuukouseikekkahanei.dba.KhYuukouseiKekkaHaneiDao;
import yuyu.batch.hozen.khansyuu.khyuukouseikekkahanei.dba.YuukouseiKekkaHaneiDataBean;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiParam;
import yuyu.common.hozen.khcommon.CheckYuuyokkngai;
import yuyu.common.hozen.khcommon.EditJimuRenrakusyuunou;
import yuyu.common.hozen.khcommon.EditJimuRenrakusyuunouParam;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.SetCreditCardBrand;
import yuyu.common.hozen.khcommon.SetCreditUriageSeikyuubi;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_CardBrandKbn;
import yuyu.def.classification.C_CreditdataKbn;
import yuyu.def.classification.C_Dattaikeiro;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.classification.C_Yuukoukakkekka;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_CreditCardInfo;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_TRDattai;
import yuyu.def.db.entity.IT_YuukouKakErrorList;
import yuyu.def.db.entity.IT_YuukouKakKekkaKikyk;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.collect.Lists;

/**
 * 契約保全 案内収納 有効性確認結果反映
 * @author  沙　震国
 * @version 2019/10/09 沙　震国 : 新規作成<br />
 */
public class KhYuukouseiKekkaHaneiBatch implements Batch {

    /** 抽出対象テーブルID */
    private static final String TABLEID = IT_CreditCardInfo.TABLE_NAME;

    /** リカバリフィルタID */
    private static final String FILTERID = "Kh001";

    /** バッチログ出力用ロガー */
    @Inject
    private BatchLogger batchLogger;

    /** バッチパラメータ */
    @Inject
    private KhYuukouseiKekkaHaneiBatchParam bzBatchParam;

    /** 契約保全 DOM マネージャ */
    @Inject
    private HozenDomManager hozenDomManager;

    /** 有効性確認結果反映の機能DAO */
    @Inject
    private KhYuukouseiKekkaHaneiDao khYuukouseiKekkaHaneiDao;

    /** （共通）リカバリデータ識別用BEAN */
    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    /**
     * バッチパラメータを取得します。
     * @return  バッチパラメータ
     */
    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    /**
     * バッチ処理
     */
    @Execute
    @Transactional
    public void execute() {

        // WK．契約保全共通パラメータ
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        // WK．処理件数
        long syoriKensu = 0;
        // WK．事務連絡票件数
        long jimurenrakuKensu = 0;
        // WK．機能ID
        String kinouid = khozenCommonParam.getFunctionId();
        // WK．ユーザーID
        String userId = khozenCommonParam.getUserID();
        // WK．システム日付時刻
        String sysDateTime = BizDate.getSysDateTimeMilli();
        // WK．事務連絡票(収納)編集用パラメータ
        EditJimuRenrakusyuunouParam editJimuRenrakusyuunouParam = SWAKInjector.getInstance(EditJimuRenrakusyuunouParam.class);
        // WK．テーブルメンテナンスユーティリティ
        TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);
        // WK．事務連絡票(収納)編集
        EditJimuRenrakusyuunou editJimuRenrakusyuunou = SWAKInjector.getInstance(EditJimuRenrakusyuunou.class);
        // WK．帳票作成共通処理クラス
        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);
        // WK．猶予期間外チェック
        CheckYuuyokkngai checkYuuyokkngai = SWAKInjector.getInstance(CheckYuuyokkngai.class);
        // クレジットカードブランド設定
        SetCreditCardBrand setCreditCardBrand = SWAKInjector.getInstance(SetCreditCardBrand.class);
        // WK．クレカ売上請求日設定
        SetCreditUriageSeikyuubi setCreditUriageSeikyuubi = SWAKInjector.getInstance(SetCreditUriageSeikyuubi.class);

        // --------------------------------------------
        // 起動パラメータメッセージ出力
        // --------------------------------------------
        // 処理年月日の出力
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));
        // 拡張ジョブコードの出力
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            bzBatchParam.getIbKakutyoujobcd()));
        // 並走区分の出力
        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1025, bzBatchParam.getHeisoukbn()));

        // --------------------------------------------
        // 案内処理
        // --------------------------------------------
        // 有効性確認結果反映対象（大量）取得
        try (ExDBResults<YuukouseiKekkaHaneiDataBean> yuukouseiKekkaHaneiDataBeanList =
            khYuukouseiKekkaHaneiDao.getYuukouseiKekkaHaneiDataBean(bzBatchParam.getIbKakutyoujobcd(),
                bzBatchParam.getHeisoukbn());

            // WK．大量データ登録（マルチ）クラス
            MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();
            // WK．大量データ更新（マルチ）クラス
            MultipleEntityUpdater multipleEntityUpdater = new MultipleEntityUpdater();) {

            // WK．有効性確認反映対象データBeanリストの件数分、以下の処理を繰り返す
            for (YuukouseiKekkaHaneiDataBean yuukouseiKekkaHaneiDataBean : yuukouseiKekkaHaneiDataBeanList) {

                // WK．証券番号 ← WK．有効性確認結果反映Bean．証券番号
                String syono = yuukouseiKekkaHaneiDataBean.getSyono();
                // WK．脱退ＴＲテーブルエンティティ ← null
                IT_TRDattai trdattai = null;
                // WK．有効確認エラーリストテーブルエンティティ ← null
                IT_YuukouKakErrorList yuukoukakerrorlist = null;

                // （ＩＢ）拡張ジョブコード
                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                // （ＩＢ）テーブルＩＤ
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                // （ＩＢ）リカバリフィルタＩＤ
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                // （ＩＢ）リカバリフィルタキー１
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(yuukouseiKekkaHaneiDataBean.getKbnkey());
                // （ＩＢ）リカバリフィルタキー２
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(syono);

                // --------------------------------------------
                // 処理可否判定
                // --------------------------------------------
                // 有効状態チェック
                CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);
                // 有効状態チェックパラメータ
                CheckYuukouJyoutaiParam checkYuukouJyoutaiParam = SWAKInjector.getInstance(CheckYuukouJyoutaiParam.class);

                // 証券番号 ← WK．証券番号
                checkYuukouJyoutaiParam.setSyono(syono);

                // WK．有効状態チェック結果区分 ←【有効状態チェック＃メイン処理】を実行する
                C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam,
                    checkYuukouJyoutaiParam);
                // WK．有効状態チェック結果区分 ＝ <有効状態チェック結果区分>不可
                if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {
                    //【有効状態チェック＃取得エンティティデタッチ処理】(CheckYuukouJyoutai#detachAllEntities)を実行する
                    checkYuukouJyoutai.detachAllEntities(syono);

                    // 次のレコードにスキップ
                    continue;
                }

                // 【契約保全 DOM マネージャ＃契約基本テーブルエンティティ取得（証券番号）】（HozenDomManager＃getKykKihon）を実行する
                IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);

                // 【契約保全 DOM マネージャ＃案内収納基本テーブルエンティティ取得(証券番号)】（HozenDomManager＃getAnsyuKihon）を実行する
                IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syono);

                // --------------------------------------------
                // 有効性確認結果反映
                // --------------------------------------------
                // WK．契約保全共通パラメータ．識別キー ← null
                khozenCommonParam.setSikibetuKey(null);

                // WK．変更識別キー ← 【契約保全共通パラメータ．識別キー取得】．実行結果
                String henkousikibetukey = khozenCommonParam.getSikibetuKey(syono);

                // 【テーブルメンテナンスユーティリティ＃バックアップ処理】を実行
                tableMaintenanceUtil.backUp(syono, henkousikibetukey);
                // （バッチ用）契約基本バックアップテーブルエンティティ
                khozenCommonParam.setBatchBakKykKihon(tableMaintenanceUtil.getBakKykKihon());
                // （バッチ用）案内収納基本バックアップテーブルエンティティ
                khozenCommonParam.setBatchBakAnsyuKihon(tableMaintenanceUtil.getBakAnsyuKihon());

                // WK．有効性確認結果（既契約）テーブルエンティティ ←【契約保全 DOM マネージャ＃有効性確認結果（既契約）情報取得（クレジットカード決済用番号指定）】．実行結果
                IT_YuukouKakKekkaKikyk yuukouKakKekkaKikyk = hozenDomManager.
                    getYuukouKakKekkaKikyk(yuukouseiKekkaHaneiDataBean.getCreditkessaiyouno());

                // 【クレカ売上請求日設定＃メイン処理】を実行する
                setCreditUriageSeikyuubi.exec(bzBatchParam.getSyoriYmd());

                // WK．次回売上請求日 ← 【クレカ売上請求日設定＃次回売上請求日取得】．実行結果
                BizDate jikaiUrskbi = setCreditUriageSeikyuubi.getJikaiUrskbi();

                // WK．有効確認結果
                C_Yuukoukakkekka yuukoukakkekka;
                // WK．有効確認年月
                BizDateYM yuukoukakym;

                // WK．有効性確認結果（既契約）テーブルエンティティ ＝ null の場合 （有効性確認OK）
                if (yuukouKakKekkaKikyk == null) {
                    // WK．有効確認結果 ← <有効確認結果>有効確認ＯＫ
                    yuukoukakkekka = C_Yuukoukakkekka.YUUKOUKAK_OK;
                    // WK．有効確認年月 ← WK．次回売上請求日の年月
                    yuukoukakym = jikaiUrskbi.getBizDateYM();
                }
                // 上記以外の場合
                else {
                    // WK．有効確認結果 ← WK．有効性確認結果（既契約）テーブルエンティティ．クレジットカード有効確認結果
                    yuukoukakkekka = yuukouKakKekkaKikyk.getCredityuukoukakkekka();
                    // WK．有効確認年月 ← WK．有効性確認結果（既契約）テーブルエンティティ．クレジットカード有効確認年月
                    yuukoukakym = yuukouKakKekkaKikyk.getCredityuukoukakym();

                    // WK．カードブランド区分 ← 【クレジットカードブランド設定＃メイン処理】．実行結果
                    C_CardBrandKbn  cardbrandkbn = setCreditCardBrand.exec(yuukouKakKekkaKikyk.getCreditcardno().substring(0, 6));

                    // 脱退ＴＲテーブルの追加処理
                    // WK．有効確認結果 ＝ <有効確認結果>有効確認ＮＧ の場合
                    if (C_Yuukoukakkekka.YUUKOUKAK_NG.eq(yuukoukakkekka)) {
                        // WK．脱退ＴＲテーブルエンティティの初期化
                        trdattai = new IT_TRDattai(syono, bzBatchParam.getSyoriYmd(), sysDateTime + "1");

                        // 脱退経路 ← <脱退経路>クレジット
                        trdattai.setDattaikeiro(C_Dattaikeiro.CREDIT);
                        // クレジットデータ区分 ← <クレジットデータ区分>有効性確認
                        trdattai.setCreditdatakbn(C_CreditdataKbn.YKKAKUNIN);
                        // 脱退年月 ← WK．有効確認年月
                        trdattai.setDattaiym(yuukoukakym);
                        // 定期一括払種類区分 ← WK．有効性確認結果反映Bean．定期一括払種類区分
                        trdattai.setTikiktbrisyuruikbn(yuukouseiKekkaHaneiDataBean.getTkiktbrisyuruikbn());
                        // 業務用更新機能ＩＤ ← WK．機能ID
                        trdattai.setGyoumuKousinKinou(kinouid);
                        // 業務用更新者ＩＤ ← WK．ユーザーID
                        trdattai.setGyoumuKousinsyaId(userId);
                        // 業務用更新時間 ← WK．システム日付時刻
                        trdattai.setGyoumuKousinTime(sysDateTime);
                        // クレジットカード決済用番号 ← WK．有効性確認結果（既契約）テーブルエンティティ．クレジットカード決済用番号
                        trdattai.setCreditkessaiyouno(yuukouKakKekkaKikyk.getCreditkessaiyouno());
                        // カードブランド区分 ← WK．カードブランド区分
                        trdattai.setCardbrandkbn(cardbrandkbn);
                        // 下４桁クレジット会員番号 ← WK．有効性確認結果（既契約）テーブルエンティティ．クレジットカード番号 の下４桁
                        trdattai.setCreditkaiinnosimo4keta(yuukouKakKekkaKikyk.getCreditcardno().
                            substring(yuukouKakKekkaKikyk.getCreditcardno().length() - 4));

                        // 【UiBean、エンティティの初期化を対応のクラス＃Entityを初期化メソッド】を実行する
                        BizPropertyInitializer.initialize(trdattai);
                    }

                    // WK．有効確認エラーリストテーブルエンティティの初期化
                    yuukoukakerrorlist = new IT_YuukouKakErrorList();

                    // 証券番号 ← WK．証券番号
                    yuukoukakerrorlist.setSyono(syono);
                    // クレジットカード決済用番号 ← WK．有効性確認結果（既契約）テーブルエンティティ．クレジットカード決済用番号
                    yuukoukakerrorlist.setCreditkessaiyouno(yuukouKakKekkaKikyk.getCreditkessaiyouno());
                    // 処理年月 ← バッチパラメータ．処理年月日 の年月
                    yuukoukakerrorlist.setSyoriym(bzBatchParam.getSyoriYmd().getBizDateYM());
                    // クレジットカード有効確認年月 ← WK．有効確認年月
                    yuukoukakerrorlist.setCredityuukoukakym(yuukoukakym);
                    // クレジットカード有効確認結果 ← WK．有効確認結果
                    yuukoukakerrorlist.setCredityuukoukakkekka(yuukoukakkekka);
                    // 業務用更新機能ＩＤ ← WK．機能ID
                    yuukoukakerrorlist.setGyoumuKousinKinou(kinouid);
                    // 業務用更新者ＩＤ ← WK．ユーザーID
                    yuukoukakerrorlist.setGyoumuKousinsyaId(userId);
                    // 業務用更新時間 ← WK．システム日付時刻
                    yuukoukakerrorlist.setGyoumuKousinTime(sysDateTime);

                    // 【UiBean、エンティティの初期化を対応のクラス＃Entityを初期化メソッド】を実行する
                    BizPropertyInitializer.initialize(yuukoukakerrorlist);
                }

                // クレカ情報テーブル更新処理
                // 【契約基本テーブルエンティティ＃クレカ情報テーブルエンティティ取得】（IT_KykKihon＃getCreditCardInfo）を実行する
                IT_CreditCardInfo creditcardinfo = kykKihon.getCreditCardInfo();

                // クレジットカード有効確認年月 ← WK．有効確認年月
                creditcardinfo.setCredityuukoukakym(yuukoukakym);
                // クレジットカード有効確認結果 ← WK．有効確認結果
                creditcardinfo.setCredityuukoukakkekka(yuukoukakkekka);
                // 業務用更新機能ＩＤ ← WK．機能ID
                creditcardinfo.setGyoumuKousinKinou(kinouid);
                // 業務用更新者ＩＤ ← WK．ユーザーID
                creditcardinfo.setGyoumuKousinsyaId(userId);
                // 業務用更新時間 ← WK．システム日付時刻
                creditcardinfo.setGyoumuKousinTime(sysDateTime);

                // 手続履歴テーブル編集処理
                // WK．手続履歴TBL編集パラメータ
                EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);

                // （バッチ用）契約基本テーブルエンティティ
                khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
                // （バッチ用）案内収納基本テーブルエンティティ
                khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

                // WK．手続履歴TBL編集パラメータに情報を設定する
                // 契約保全共通パラメータ ← WK．契約保全共通パラメータ
                editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
                // 証券番号 ← WK．証券番号
                editTtdkRirekiTblParam.setSyoNo(syono);
                // 処理日 ← バッチパラメータ．処理年月日
                editTtdkRirekiTblParam.setSyoriYmd(bzBatchParam.getSyoriYmd());
                // 変更履歴作成要否 ← <要否区分>要
                editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
                // システム時間 ← WK．システム日付時刻
                editTtdkRirekiTblParam.setSysTime(sysDateTime);

                // WK．契約保全手続履歴テーブルエンティティ
                IT_KhTtdkRireki khTtdkRireki = kykKihon.createKhTtdkRireki();
                // 変更識別キー ← WK．契約保全共通パラメータ．識別キー
                khTtdkRireki.setHenkousikibetukey(khozenCommonParam.getSikibetuKey(syono));

                // WK．手続履歴TBL編集
                EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);

                // 【手続履歴TBL編集＃メイン処理】を実行する
                editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);

                // --------------------------------------------
                // 帳票作成
                // --------------------------------------------
                // WK．有効状態チェック結果区分 ＝ <有効状態チェック結果区分>注意取扱可 の場合
                if (C_YuukoujyotaichkKbn.TYUUITRATKIKA.eq(yuukoujyotaichkKbn)) {
                    // WK．処理結果 ← 【猶予期間外チェック＃メイン処理】．実行結果
                    boolean checkResult = checkYuuyokkngai.exec(syono, jikaiUrskbi);

                    // WK．処理結果 ＝ false の場合
                    if (checkResult == false) {
                        // WK．事務連絡票メッセージList
                        List<String> jimuRenrakuHyouMsgList = Lists.newArrayList();

                        // WK．事務連絡票メッセージListの要素を追加する
                        // 事務連絡票メッセージ内容 ← "Ｐ未入消滅予定契約です。ハンド案内してください。"
                        jimuRenrakuHyouMsgList.add("Ｐ未入消滅予定契約です。ハンド案内してください。");

                        // WK．事務連絡票(収納)編集用パラメータに下記の通り設定する
                        editJimuRenrakusyuunouParam.setJimurenrakuMsgList(jimuRenrakuHyouMsgList);

                        // WK．帳票サービスBean ← 【事務連絡票(収納)編集＃メイン処理】．実行結果
                        ReportServicesBean reportServicesBean = editJimuRenrakusyuunou.exec(
                            khozenCommonParam,                       // WK．契約保全共通パラメータ
                            syono,                                   // WK．証券番号
                            C_SyoruiCdKbn.AS_JIMURENRAKU_SYUUNOU,    // <書類コード区分>事務連絡票（収納）
                            editJimuRenrakusyuunouParam ,            // WK．事務連絡票(収納)編集用パラメータ
                            bzBatchParam.getSyoriYmd());             // WK．処理年月日

                        // 【帳票作成共通処理クラス＃帳票作成】
                        createReport.execNoCommit(reportServicesBean);

                        // WK．事務連絡票件数のカウントアップ
                        jimurenrakuKensu++;
                    }

                }

                // --------------------------------------------
                // DB更新処理
                // --------------------------------------------
                // 契約基本情報更新
                multipleEntityUpdater.add(kykKihon);

                // WK．脱退ＴＲテーブルエンティティ ≠ null の場合
                if (trdattai != null) {
                    // 脱退ＴＲテーブル情報追加
                    multipleEntityInserter.add(trdattai);
                }
                // WK．有効確認エラーリストテーブルエンティティ ≠ null の場合
                if (yuukoukakerrorlist != null) {
                    // 有効確認エラーリストテーブル情報追加
                    multipleEntityInserter.add(yuukoukakerrorlist);
                }

                // --------------------------------------------
                // デタッチ処理
                // --------------------------------------------
                // WK．有効性確認結果（既契約）テーブルエンティティ ≠ null の場合
                if (yuukouKakKekkaKikyk != null) {
                    // 有効性確認結果（既契約）テーブルエンティティをデタッチする
                    yuukouKakKekkaKikyk.detach();
                }

                // WK．処理件数のカウントアップ
                syoriKensu++;

            }
        }

        // 【（共通）リカバリデータ識別用BEAN＃初期化（ブランク）処理】を実行する
        bzRecoveryDatasikibetuBean.initializeBlank();

        // 処理件数のログ出力
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0020, String.valueOf(syoriKensu)));
        // 事務連絡票件数の出力
        batchLogger.info(MessageUtil.getMessage(MessageId.IAC1001, "事務連絡票",String.valueOf(jimurenrakuKensu)));
        // 並走区分のログ出力
        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1026, bzBatchParam.getHeisoukbn()));
    }

    /**
     * バッチ異常終了時共通処理（リカバリ対応用）の呼出<br />
     * 異常終了時に呼び出される処理<br />
     */
    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        // WK．共通 バッチ異常終了時共通処理（リカバリ対応用）
        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        // 【バッチ異常終了時共通処理（リカバリ対応用）＃メイン処理】を実行する
        bzBatchAbendCommonRecovery.exec();
    }
}
