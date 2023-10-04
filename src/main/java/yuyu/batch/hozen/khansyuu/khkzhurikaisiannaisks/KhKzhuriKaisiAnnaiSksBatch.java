package yuyu.batch.hozen.khansyuu.khkzhurikaisiannaisks;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import jp.co.slcs.swak.util.string.IDataConvert;
import yuyu.batch.hozen.khansyuu.khkzhurikaisiannaisks.dba.KhKzhuriKaisiAnnaiSksDao;
import yuyu.batch.hozen.khansyuu.khkzhurikaisiannaisks.dba.KzhuriAnnaiDataBean;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoKekkaBean;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.IGkCommonKoumoku;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.ascommon.AnsyuuBatSyoriHunoKykMisslistSks;
import yuyu.common.hozen.ascommon.KeisanRsgaku;
import yuyu.common.hozen.khcommon.AnsyuuSetTetudukityuuiInfo;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiParam;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KhozenEdit;
import yuyu.common.hozen.khcommon.SetHurikaebi;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KouzahuriStartAnnai;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 案内収納 口座振替開始案内作成のバッチクラスです。
 * @author  張　東宝
 * @version 2016/12/21 張　東宝 : 新規作成<br />
 *          2017/03/22 張　東宝 : S社ナポレオン先行１次追加対応<br />
 *          2017/11/03 李　玥融 : 平準払商品対応<br />
 *          2018/11/06 姜　超   : 2019年3月25日対応<br />
 *          2018/12/10 倉田　功一 : 2019年3月25日対応<br />
 *          2019/02/21 椎葉　佳明 : 2019年3月25日対応<br />
 *          2020/11/18 任　暁芸 : 2021年3月15日対応<br />
 *          2021/01/22 永田　祥太 : 2021年3月15日対応<br />
 *
 */
public class KhKzhuriKaisiAnnaiSksBatch implements Batch {

    /** 抽出対象テーブルID */
    private static final String TABLEID = IT_AnsyuKihon.TABLE_NAME;

    /** リカバリフィルタID */
    private static final String FILTERID = "Kh001";

    /** メンバ変数．機能ID */
    private String kinouID;

    /** メンバ変数．更新者コード */
    private String kosID;

    /** メンバ変数．更新時間 */
    private String kosTime;

    /** メンバ変数．処理年月日 */
    private BizDate syoriYMD;

    /** メンバ変数．拡張ジョブコード */
    private String kakutyouJobcd;

    /** 契約保全共通パラメータ */
    private KhozenCommonParam kCcommonParam;

    /** バッチロガー */
    @Inject
    private BatchLogger batchLogger;

    /** バッチパラメータ */
    @Inject
    private BzBatchParam bzBatchParam;

    /** （共通）リカバリデータ識別用BEAN */
    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    /** 前納手続完了通知作成機能DAO */
    @Inject
    private KhKzhuriKaisiAnnaiSksDao khKzhuriKaisiAnnaiSksDao;

    /**
     * バッチパラメータを取得します。
     * @return  バッチパラメータ
     */
    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    /**
     * メイン処理
     */
    @Execute
    @Transactional
    public void execute() {

        // メンバ変数．契約保全共通パラメータを生成する
        kCcommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        // メンバ変数．機能ID ← メンバ変数．契約保全共通パラメータ.機能ID
        kinouID = kCcommonParam.getFunctionId();
        // メンバ変数．更新者コード ← メンバ変数．契約保全共通パラメータ.ユーザID
        kosID = kCcommonParam.getUserID();
        // メンバ変数．更新時間 ← システム日付時刻
        kosTime = BizDate.getSysDateTimeMilli();
        // メンバ変数．処理日 ← バッチパラメータ.処理年月日
        syoriYMD = bzBatchParam.getSyoriYmd();
        // メンバ変数．拡張ジョブコード ← バッチパラメータ．（ＩＢ）拡張ジョブコード
        kakutyouJobcd = bzBatchParam.getIbKakutyoujobcd();

        // WK．処理日_年月 ← バッチパラメータ.処理年月日（DDの部分の切捨て）
        BizDateYM syoriYM = bzBatchParam.getSyoriYmd().getBizDateYM();

        // WK．銀行情報取得
        BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);

        // WK．口座振替日設定処理
        SetHurikaebi setHurikaebi = SWAKInjector.getInstance(SetHurikaebi.class);

        // WK．処理件数 ← 0
        long syoriKensuu = 0;

        // WK．有効状態チェックパラメータ ← null
        CheckYuukouJyoutaiParam checkYuukouJyoutaiParam = null;

        // WK．有効状態チェック
        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);

        // WK．組織窓口情報取得
        BzGetSosikiMadogutiInfo bzGetSosikiMadogutiInfo = SWAKInjector.getInstance(BzGetSosikiMadogutiInfo.class);

        // WK．領収金額計算
        KeisanRsgaku keisanRsgaku = SWAKInjector.getInstance(KeisanRsgaku.class);

        // WK．通貨変換処理
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        // ログ情報出力
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyouJobcd));

        // WK．口座振替開始案内作成Bean
        try ( ExDBResults<KzhuriAnnaiDataBean> kzhuriAnnaiDataBeanList =
            khKzhuriKaisiAnnaiSksDao.getKzhuriAnnaiDataBean(syoriYM, kakutyouJobcd);

            // WK．大量データ追加クラス
            EntityInserter<IT_KouzahuriStartAnnai> inserter = new EntityInserter<>();) {

            // WK．バッチ処理不能契約ミスリスト作成
            AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);

            // WK．口座振替案内データBeanの件数分、繰り返す
            for (KzhuriAnnaiDataBean dataBean : kzhuriAnnaiDataBeanList) {

                // WK．証券番号 ← WK．口座振替案内データBean［i］．証券番号
                String syono = dataBean.getSyono();

                // （ＩＢ）拡張ジョブコード ←メンバ変数．拡張ジョブコード
                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobcd);
                // （ＩＢ）テーブルＩＤ ← 定数．抽出対象テーブルID
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                // （ＩＢ）リカバリフィルタＩＤ ← 定数．リカバリフィルタID
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                // （ＩＢ）リカバリフィルタキー１ ←  WK．口座振替案内データBean［i］．区分キー
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(dataBean.getKbnkey());
                // （ＩＢ）リカバリフィルタキー２ ←  WK．証券番号
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(syono);

                //--------------------------------------
                //処理可否判定
                //--------------------------------------
                // WK．有効状態チェックパラメータ
                checkYuukouJyoutaiParam = SWAKInjector.getInstance(CheckYuukouJyoutaiParam.class);
                // WK．証券番号を設定する
                checkYuukouJyoutaiParam.setSyono(syono);
                // WK．有効状態チェック結果区分 ← 【有効状態チェック＃メイン処理】．実行結果
                C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(
                    kCcommonParam, checkYuukouJyoutaiParam);
                // WK．有効状態チェック結果区分 ＝ <有効状態チェック結果区分>不可 の場合
                if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {
                    // 次のレコードへスキップする
                    continue;
                }

                // WK．契約基本テーブルエンティティ ←
                //【口座振替開始案内作成機能DAO＃契約基本TBLエンティティ取得(証券番号)】．実行結果
                IT_KykKihon kykKihon = khKzhuriKaisiAnnaiSksDao.getKykKihon(syono);
                // WK．契約者テーブルエンティティ ←
                //【口座振替開始案内作成機能DAO＃契約者TBLエンティティ取得（契約基本TBLエンティティ）】．実行結果
                IT_KykSya kykSya = khKzhuriKaisiAnnaiSksDao.getKykSya(kykKihon);

                // WK．契約者テーブルエンティティ ＝ null の場合
                if (kykSya == null) {
                    // エラーメッセージを設定し、処理を終了する
                    throw new CommonBizAppException("契約者テーブルにデータが存在しません。");
                }

                // WK．被保険者テーブルエンティティ ←
                //【口座振替開始案内作成機能DAO＃契約者TBLエンティティ取得（契約基本TBLエンティティ）】．実行結果
                IT_HhknSya hhknSya = khKzhuriKaisiAnnaiSksDao.getHhknSya(kykKihon);

                // WK．被保険者テーブルエンティティ ＝ null の場合
                if (hhknSya == null) {
                    // エラーメッセージを設定し、処理を終了する
                    throw new CommonBizAppException("被保険者テーブルにデータが存在しません。");
                }

                // WK．口座テーブルエンティティ ←
                //【口座振替開始案内作成機能DAO＃口座TBLエンティティ取得（契約基本テーブルエンティティ）】．実行結果
                IT_Kouza kouza = khKzhuriKaisiAnnaiSksDao.getKouza(kykKihon);

                // WK．銀行情報取得Bean ← 【銀行情報取得＃メイン処理】．実行結果
                BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(kouza.getBankcd(), kouza.getSitencd());
                // WK．銀行名（漢字） ← WK．銀行情報取得Bean．銀行名（漢字）
                String bankNmKj = bzGetBankDataBean.getBankNmKj();
                // WK．帳票用支店名 ← WK．銀行情報取得Bean．帳票用支店名
                String reportSitenNm = bzGetBankDataBean.getReportSitenNm();

                // 【口座振替日設定処理＃メイン処理】を実行する
                setHurikaebi.exec(syoriYMD);
                // WK．振替日 ← 【口座振替日設定処理＃直後振替日返却処理】．実行結果
                BizDate hurikaeYmd = setHurikaebi.getTyokugoHurikaebi();
                // WK．直後振替日
                String tyokugoHurikaebi = FixedDateFormatter.formatMDZenkakuKanji(hurikaeYmd);

                // WK．商品属性マスタエンティティ ←
                //【口座振替開始案内作成機能DAO＃商品属性MSTエンティティ取得(商品コード、商品世代番号指定)】．実行結果
                BM_SyouhnZokusei syouhnZokusei = khKzhuriKaisiAnnaiSksDao.getSyouhnZokusei(
                    dataBean.getSyouhncd(), dataBean.getSyouhnsdno());

                // WK．商品名（証券用）
                String syouhnnmSyouken = syouhnZokusei.getSyouhnnmsyouken();

                // WK．口座番号 ←【契約保全文字列編集＃口座番号編集】．実行結果
                String kouzaNo = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, KhozenEdit.editKouzaNo(kouza.getBankcd(), kouza.getKouzano()));

                // WK．組織窓口情報取得結果Bean ← 【組織窓口情報取得＃メイン処理】を実行する
                BzGetSosikiMadogutiInfoKekkaBean bzGetSosikiMadogutiInfoKekkaBean = bzGetSosikiMadogutiInfo.exec(
                    YuyuBizConfig.getInstance().getCallcentersosikicd());

                // 【案内収納用契約管理注意情報取得クラス】の初期化
                AnsyuuSetTetudukityuuiInfo ansyuuSetTetudukityuuiInfo = SWAKInjector.getInstance(AnsyuuSetTetudukityuuiInfo.class);

                // 【案内収納用契約管理注意情報取得＃メイン処理】．実行結果
                C_KktyuitaKbn kktyuitaKbn = ansyuuSetTetudukityuuiInfo.exec(dataBean.getSyono());

                // WK．発送区分
                C_HassouKbn hassoukbn =null;

                // 【案内収納用契約管理注意情報取得】．実行結果 ＝
                // <契約管理注意取扱区分>伝言メモ(本社回送あり) の場合
                if (C_KktyuitaKbn.DNGNMEMOARI.eq(kktyuitaKbn)) {

                    // WK．発送区分 ← <発送区分>本社回送
                    hassoukbn = C_HassouKbn.HONSYAKAISOU;
                }
                // 上記以外の場合
                else {

                    // WK．発送区分 ← <発送区分>直送
                    hassoukbn = C_HassouKbn.TYOKUSOU;
                }

                // WK．充当月数 ← 起動パラメータ．処理年月日の年月 - （WK．口座振替案内データBean．次回Ｐ充当年月-1ヶ月）
                int jyuutouTukisuu = syoriYMD.getBizDateYM().subtractMonths(dataBean.getJkipjytym().addMonths(-1));

                // WK.領収金額計算結果区分 ← 【領収金額計算＃領収金額計算（契約基本）】．実行結果
                C_ErrorKbn keisanRsgakuKekkaKbn = keisanRsgaku.exec(
                    kykKihon,                   // WK．契約基本TBLエンテイティ
                    C_Nykkeiro.KZHRK,           // <入金経路>口座振替
                    C_NyknaiyouKbn.KEIZOKUP,    // <入金内容区分>継続Ｐ
                    hurikaeYmd,                 // WK．振替日
                    dataBean.getJkipjytym(),    // WK．口座振替案内データBean．次回Ｐ充当年月
                    0,                          // 0
                    jyuutouTukisuu);                // WK.充当月数

                // WK.領収金額
                BizCurrency rsgakuGoukei = null;

                // WK.領収金額計算結果区分 ＝ <エラー区分>処理OK の場合
                if (C_ErrorKbn.OK.eq(keisanRsgakuKekkaKbn)) {

                    // WK.領収金額 ← 【領収金額計算＃領収金額計算（契約基本）】．実行結果．領収金額合計
                    rsgakuGoukei = keisanRsgaku.getKeisanRsgkOutBean().getRsgakuGoukei();
                }
                // 上記以外の場合
                else {

                    // 【バッチ処理不能契約ミスリスト作成＃エラーメッセージ追加（ログメッセージ省略）】を実行する
                    ansyuuBatSyoriHunoKykMisslistSks.addErrerMsg(
                        kykKihon.getSyono(),
                        MessageUtil.getMessage(MessageId.EIA3055, keisanRsgaku.getErrorRiyuu()));

                    // 次のレコードにスキップする
                    continue;
                }

                // 口座振替開始案内フリーエリア編集
                // WK.口座振替開始案内フリーエリア１
                String kzhuriStartAnfreeArea1 = "";
                // WK.口座振替開始案内フリーエリア２
                String kzhuriStartAnfreeArea2 = "";
                // WK.口座振替開始案内フリーエリア３
                String kzhuriStartAnfreeArea3 = "";
                // WK.口座振替開始案内フリーエリア４
                String kzhuriStartAnfreeArea4 = "";
                // WK.口座振替開始案内フリーエリア５
                String kzhuriStartAnfreeArea5 = "";
                // WK.口座振替開始案内フリーエリア６
                String kzhuriStartAnfreeArea6 = "";
                // WK.口座振替開始案内フリーエリア７
                String kzhuriStartAnfreeArea7 = "";
                // WK.口座振替開始案内フリーエリア８
                String kzhuriStartAnfreeArea8 = "";
                // WK.口座振替開始案内フリーエリア９
                String kzhuriStartAnfreeArea9 = "";
                // WK.口座振替開始案内フリーエリア１０
                String kzhuriStartAnfreeArea10 = "";

                // 固定文言の編集
                // WK.口座振替開始案内フリーエリア１
                kzhuriStartAnfreeArea1 = "※保険料円貨払込特約（円貨払込額指定型）または保険料円貨払込特約（円貨";
                // WK.口座振替開始案内フリーエリア２
                kzhuriStartAnfreeArea2 = "　払込額変動型）の付加された契約は、円貨払込額（定期一括払いの場合は、";
                // WK.口座振替開始案内フリーエリア３
                kzhuriStartAnfreeArea3 = "　定期一括払円貨払込額）について「保険料」と表示しております。";

                // WK．領収通貨種類 ← 【通貨変換処理＃通貨変換処理】.実行結果
                C_Tuukasyu rsTuukasyu = henkanTuuka.henkanTuukaTypeToKbn(rsgakuGoukei.getType());
                // WK．保険料通貨種類 ← 【通貨変換処理＃通貨変換処理】.実行結果
                C_Tuukasyu hokenryouTuukasyu = henkanTuuka.henkanTuukaTypeToKbn(dataBean.getHokenryou().getType());

                // WK．保険料通貨種類 ≠ WK．領収通貨種類 の場合
                if (!rsTuukasyu.eq(hokenryouTuukasyu)) {

                    // WK.口座振替開始案内フリーエリア５
                    kzhuriStartAnfreeArea5 = "※保険料は本通知作成日の前月末営業日における当社所定の為替レートで";
                    // WK.口座振替開始案内フリーエリア６
                    kzhuriStartAnfreeArea6 = "　円換算した金額をお払い込みいただきます。";
                }

                // WK．振替口座３
                String hurikaeKz3 = null;
                // WK．口座テーブルエンティティ．銀行コード　＝　業務共通項目定義．（銀行コード）ゆうちょ銀行 の場合
                if (kouza.getBankcd().equals(IGkCommonKoumoku.BANKCD_YTGINKOU)) {
                    // WK．振替口座３ ← "通帳番号　" ＋　WK．口座番号
                    hurikaeKz3 = "通帳番号　" + kouzaNo;
                } else {
                    // WK．振替口座３ ← 預金種目区分の翻訳値　＋　"預金　　　　　　　　　口座番号　"　＋　WK．口座番号
                    hurikaeKz3 = kouza.getYokinkbn().getContent() + "預金　　　　　　　　　口座番号　" + kouzaNo;
                }

                // WK．口座振替開始案内テーブルエンテイティ
                IT_KouzahuriStartAnnai kouzahuriStartAnnai = new IT_KouzahuriStartAnnai(dataBean.getSyono());

                // WK．口座振替開始案内テーブルエンテイティ編集する
                kouzahuriStartAnnai.setTyouhyouymd(syoriYMD);                               // 帳票作成日
                kouzahuriStartAnnai.setKyknmkj(kykSya.getKyknmkj());                        // 契約者名（漢字）
                kouzahuriStartAnnai.setTsinyno(kykSya.getTsinyno());                        // 通信先郵便番号
                kouzahuriStartAnnai.setTsinadr1kj(kykSya.getTsinadr1kj());                  // 通信先住所１（漢字）
                kouzahuriStartAnnai.setTsinadr2kj(kykSya.getTsinadr2kj());                  // 通信先住所２（漢字）
                kouzahuriStartAnnai.setTsinadr3kj(kykSya.getTsinadr3kj());                  // 通信先住所３（漢字）
                kouzahuriStartAnnai.setKykymd(dataBean.getKykymd());                        // 契約日
                kouzahuriStartAnnai.setHhknnmkj(hhknSya.getHhknnmkj());                     // 被保険者名（漢字）
                kouzahuriStartAnnai.setSyouhnnm(syouhnnmSyouken);                           // 商品名
                kouzahuriStartAnnai.setTuutinm("口座振替開始のご案内");                     // 通知名称
                // 挨拶文言１
                kouzahuriStartAnnai.setAisatumongon1("当社の保険にご加入いただき誠にありがとうございます。");
                // 挨拶文言２
                kouzahuriStartAnnai.setAisatumongon2("お客さまのご契約は、「" + tyokugoHurikaebi +
                    "」の振替日からご指定");
                // 挨拶文言３
                kouzahuriStartAnnai.setAisatumongon3("の預金口座より保険料の振替を開始させていただきます。");
                // 挨拶文言４
                kouzahuriStartAnnai.setAisatumongon4("今後とも変わらぬご愛顧を賜りますようお願いいたします。");
                // 挨拶文言５
                kouzahuriStartAnnai.setAisatumongon5("");
                // 口座振替についてのお願い１
                kouzahuriStartAnnai.setKzhurikaeonegai1("・振替日は毎月２７日（金融機関休日の場合は翌営業日）ですので、振替日の");
                // 口座振替についてのお願い２
                kouzahuriStartAnnai.setKzhurikaeonegai2("　前営業日までに保険料を口座にご準備ください。");
                // 口座振替についてのお願い３
                kouzahuriStartAnnai.setKzhurikaeonegai3("");
                // 口座振替についてのお願い４
                kouzahuriStartAnnai.setKzhurikaeonegai4("・毎月の口座振替結果につきましては、“領収証”は発行いたしませんので、");
                // 口座振替についてのお願い５
                kouzahuriStartAnnai.setKzhurikaeonegai5("　お手元の預金通帳等でご確認くださいますようお願いいたします。");
                // 口座振替についてのお願い６
                kouzahuriStartAnnai.setKzhurikaeonegai6("");
                // 口座振替についてのお願い７
                kouzahuriStartAnnai.setKzhurikaeonegai7("・万一２７日に振り替えできない場合には、その旨をご通知させていただいた");
                // 口座振替についてのお願い８
                kouzahuriStartAnnai.setKzhurikaeonegai8("　うえで、特別な場合を除き翌月に２か月分の保険料を振り替えさせていただ");
                // 口座振替についてのお願い９
                kouzahuriStartAnnai.setKzhurikaeonegai9("　きます。");
                // 口座振替についてのお願い１０
                kouzahuriStartAnnai.setKzhurikaeonegai10("・翌月もご案内金額（２か月分）が振り替えできない場合、翌々月に３か月分");
                // 口座振替についてのお願い１１
                kouzahuriStartAnnai.setKzhurikaeonegai11("　まとめて振り替えさせていただきます。");
                // 口座振替についてのお願い１２
                kouzahuriStartAnnai.setKzhurikaeonegai12("・翌々月もご案内金額（３か月分）が振り替えできない場合、お払込猶予期間");
                // 口座振替についてのお願い１３
                kouzahuriStartAnnai.setKzhurikaeonegai13("　を過ぎると、ご契約が消滅しますのであらかじめご了承ください。");
                // 口座振替についてのお願い１４
                kouzahuriStartAnnai.setKzhurikaeonegai14("");
                // 口座振替についてのお願い１５
                kouzahuriStartAnnai.setKzhurikaeonegai15("");
                // 月払保険料（振替予定金額）
                kouzahuriStartAnnai.setTkbriphurikaeyoteigk(rsgakuGoukei.toString());
                // 振替口座補足文言
                kouzahuriStartAnnai.setHurikaekzhosokumongon("　　　　　　　　　（お客さま情報保護のため一部を＊表示）");
                // 振替口座１
                kouzahuriStartAnnai.setHurikaekz1(bankNmKj);
                // 振替口座２
                kouzahuriStartAnnai.setHurikaekz2(reportSitenNm);
                // 振替口座３
                kouzahuriStartAnnai.setHurikaekz3(hurikaeKz3);
                // 振替口座４
                kouzahuriStartAnnai.setHurikaekz4("口座名義人　" + kouza.getKzmeiginmkn() + "　様");
                // 振替口座５
                kouzahuriStartAnnai.setHurikaekz5("（改姓等で口座名義を変更されている場合は、表面の照会先までご連絡ください。）");
                // 問合せ先組織名（漢字）
                kouzahuriStartAnnai.setToiawasesosikinmkj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikinm());
                // 問合せ先郵便番号
                kouzahuriStartAnnai.setToiawaseyno(bzGetSosikiMadogutiInfoKekkaBean.getPostalCd());
                // 問合せ先住所１（漢字）
                kouzahuriStartAnnai.setToiawaseadr1kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1());
                // 問合せ先住所２（漢字）
                kouzahuriStartAnnai.setToiawaseadr2kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2());
                // 問合せ先住所３（漢字）
                kouzahuriStartAnnai.setToiawaseadr3kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr3());
                // 問合せ先電話番号
                kouzahuriStartAnnai.setToiawasetelno(bzGetSosikiMadogutiInfoKekkaBean.getTelno());
                // 問合せ先電話受付可能時間１
                kouzahuriStartAnnai.setToiawaseteluktkkanou1(YuyuBizConfig.getInstance().getUketimecallcenter1());
                // 問合せ先電話受付可能時間２
                kouzahuriStartAnnai.setToiawaseteluktkkanou2(YuyuBizConfig.getInstance().getUketimecallcenter2());
                // 書類コード
                kouzahuriStartAnnai.setSyoruiCd(C_SyoruiCdKbn.AS_KOUHURIKAISIANNAI);
                // 発送区分
                kouzahuriStartAnnai.setHassoukbn(hassoukbn);
                // 口座振替開始案内フリーエリア１
                kouzahuriStartAnnai.setKzhuristartanfreearea1(kzhuriStartAnfreeArea1);
                // 口座振替開始案内フリーエリア２
                kouzahuriStartAnnai.setKzhuristartanfreearea2(kzhuriStartAnfreeArea2);
                // 口座振替開始案内フリーエリア３
                kouzahuriStartAnnai.setKzhuristartanfreearea3(kzhuriStartAnfreeArea3);
                // 口座振替開始案内フリーエリア４
                kouzahuriStartAnnai.setKzhuristartanfreearea4(kzhuriStartAnfreeArea4);
                // 口座振替開始案内フリーエリア５
                kouzahuriStartAnnai.setKzhuristartanfreearea5(kzhuriStartAnfreeArea5);
                // 口座振替開始案内フリーエリア６
                kouzahuriStartAnnai.setKzhuristartanfreearea6(kzhuriStartAnfreeArea6);
                // 口座振替開始案内フリーエリア７
                kouzahuriStartAnnai.setKzhuristartanfreearea7(kzhuriStartAnfreeArea7);
                // 口座振替開始案内フリーエリア８
                kouzahuriStartAnnai.setKzhuristartanfreearea8(kzhuriStartAnfreeArea8);
                // 口座振替開始案内フリーエリア９
                kouzahuriStartAnnai.setKzhuristartanfreearea9(kzhuriStartAnfreeArea9);
                // 口座振替開始案内フリーエリア１０
                kouzahuriStartAnnai.setKzhuristartanfreearea10(kzhuriStartAnfreeArea10);
                kouzahuriStartAnnai.setGyoumuKousinKinou(kinouID);                    // 業務用更新機能ＩＤ
                kouzahuriStartAnnai.setGyoumuKousinsyaId(kosID);                      // 業務用更新者ＩＤ
                kouzahuriStartAnnai.setGyoumuKousinTime(kosTime);                     // 業務用更新時間

                // Entityを初期化
                BizPropertyInitializer.initialize(kouzahuriStartAnnai);

                // 【大量データ追加クラス＃対象データ追加】を実行する
                inserter.add(kouzahuriStartAnnai);

                // WK．処理件数 ← WK．処理件数 ＋ 1
                syoriKensuu = syoriKensuu + 1;
            }

            // 【案内収納用バッチ処理不能契約ミスリスト作成＃ミスリストメッセージ存在確認】 ＝ true の場合
            if (ansyuuBatSyoriHunoKykMisslistSks.hasMisslistMsg()) {

                // 【案内収納用バッチ処理不能契約ミスリスト作成＃帳票データ作成】を実行する
                ansyuuBatSyoriHunoKykMisslistSks.createReport(kCcommonParam, syoriYMD);
            }

            // 【（共通）リカバリデータ識別用BEAN＃初期化（ブランク）処理】を実行する
            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        // バッチログの出力
        batchLogger.info(MessageUtil.getMessage(MessageId.IAC0020, String.valueOf(syoriKensuu)));
    }

    /**
     * バッチ異常終了時共通処理（リカバリ対応用）の呼出<br />
     * 異常終了時に呼び出される処理<br />
     */
    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        // WK．バッチ異常終了時共通処理（リカバリ対応用）
        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        // 【バッチ異常終了時共通処理（リカバリ対応用）＃メイン処理】を実行する
        bzBatchAbendCommonRecovery.exec();
    }
}
