package yuyu.batch.hozen.khansyuu.khkesikomisel;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khansyuu.khkesikomisel.dba.KhKesikomiSelDao;
import yuyu.batch.hozen.khansyuu.khkesikomisel.dba.NyuukinKakusyouDataBean;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.MessageId;
import yuyu.def.classification.C_CreditUriageSeikyuuKbn;
import yuyu.def.classification.C_CreditcardHrKskmKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.db.entity.IT_KhKesikomiData;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 案内収納 消込データ抽出
 * @author  武娟
 * @version 2017/03/23 武 娟 : 新規作成<br />
 *          2017/10/23 李 玥融 : 平準払商品対応<br />
 *          2018/11/07 任 暁芸 : 2019年03月25日対応<br />
 *          2018/12/14 杉山 竜大 : 2019年03月25日対応<br />
 *          2019/10/22 王 金鵬 : 2020年3月24日対応 <br />
 *          2020/01/06 李 健   : 2020年03月24日対応（ネット口振対応）<br />
 *          2020/08/31 王 前   : 2021年03月23日対応<br />
 */
public class KhKesikomiSelBatch implements Batch {

    /** バッチロガー */
    @Inject
    private BatchLogger batchLogger;

    /** バッチパラメータ */
    @Inject
    private KhKesikomiSelBatchParam khKesikomiSelBatchParam;

    /** 消込データ抽出機能DAO */
    @Inject
    private KhKesikomiSelDao khKesikomiSelDao;

    /**
     * バッチパラメータを取得します。
     * @return  バッチパラメータ
     */
    @Override
    public BatchParam getParam() {
        return khKesikomiSelBatchParam;
    }

    /**
     * バッチ処理
     */
    @Execute
    @Transactional
    public void execute() {

        // WK．処理年月日 ← 【バッチパラメータ．処理年月日】．実行結果
        BizDate syoriYmd = khKesikomiSelBatchParam.getSyoriYmd();
        // WK．拡張ジョブコード ← 【バッチパラメータ．（ＩＢ）拡張ジョブコード】．実行結果
        String kakutyouJobcd = khKesikomiSelBatchParam.getIbKakutyoujobcd();
        // WK．入金経路 ← 【バッチパラメータ．入金経路】．実行結果
        C_Nykkeiro nykkeiro = khKesikomiSelBatchParam.getNykkeiro();
        // WK．並走区分 ← 【バッチパラメータ．並走区分】．実行結果
        String heisoukbn = khKesikomiSelBatchParam.getHeisoukbn();

        // 起動パラメータメッセージを出力する
        // 処理年月日の出力
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        // 拡張ジョブコードの出力
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyouJobcd));

        // 入金経路の出力
        // WK．入金経路＝nullの場合
        if (nykkeiro == null) {
            batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
                MessageId.IIW3012), null));
        }
        // 上記以外の場合
        else {
            batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
                MessageId.IIW3012), nykkeiro.getValue()));
        }

        // 並走区分の出力
        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1025, heisoukbn));

        // パラメータチェック
        // WK．入金経路＝null または WK．入金経路＝<入金経路>ブランク または WK．入金経路＝<入金経路>口座振替 または
        // WK．入金経路＝<入金経路>クレジット または WK．入金経路＝<入金経路>銀行の場合
        if (nykkeiro == null || C_Nykkeiro.BLNK.eq(nykkeiro) || C_Nykkeiro.KZHRK.eq(nykkeiro) || C_Nykkeiro.CREDIT.eq(nykkeiro) ||
            C_Nykkeiro.BANK.eq(nykkeiro)) {
            // 処理を継続する
        }
        // 上記以外の場合
        else {
            // システムエラーで終了する
            throw new BizAppException(MessageId.EBF0010, MessageUtil.getMessage(MessageId.IIW3012));
        }

        // WK．処理件数 ← 0
        long syoriCnt = 0;
        // WK．処理件数（口振） ← 0
        long syoriCntKouhuri = 0;
        // WK．処理件数（クレ払） ← 0
        long syoriCntCredit = 0;
        // WK．処理件数（振替） ← 0
        long syoriCntHurikae = 0;
        // WK．契約保全共通パラメータ
        KhozenCommonParam khCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        // WK．業務用更新機能ＩＤ ← WK．契約保全共通パラメータ．機能ID
        String gyoumuKousinkinouID = khCommonParam.getFunctionId();
        // WK．業務用更新者ＩＤ ← WK．契約保全共通パラメータ．ユーザID
        String gyoumuKousinsyaId = khCommonParam.getUserID();
        // WK．業務用更新時間 ← 【基盤．BizDate＃getSysDateTimeMilli】．実行結果
        String gyoumuKousinTime = BizDate.getSysDateTimeMilli();

        // 入金確証情報取得
        try (ExDBResults<NyuukinKakusyouDataBean> nyuukinKakusyouDataBeanList = khKesikomiSelDao
            .getNyuukinKakusyouData(syoriYmd, nykkeiro,heisoukbn);
            // 大量データ登録用クラスのインスタンスを生成する。
            EntityInserter<IT_KhKesikomiData> entityInserter = new EntityInserter<IT_KhKesikomiData>();) {

            // WK．入金確証データBeanリスト（大量）の件数分、以下の処理を繰り返す
            for (NyuukinKakusyouDataBean nyuukinKakusyouDataBean : nyuukinKakusyouDataBeanList) {

                // 以下の項目を初期化する。
                // WK．クレ払消込区分 ← <クレ払消込区分>ブランク
                C_CreditcardHrKskmKbn creditcardHrKskmKbn = C_CreditcardHrKskmKbn.BLNK;
                // WK．口座振替銀行コード ← ブランク
                String Kzhurikaebankcd = "";

                // WK．入金確証データBean．入金経路 ＝ <入金経路>クレジットの場合
                if (C_Nykkeiro.CREDIT.eq(nyuukinKakusyouDataBean.getNykkeiro())) {

                    // WK．入金確証データBean．クレジットカード売上請求区分 ＝ <クレジットカード売上請求区分>通常売上請求 の場合
                    if (C_CreditUriageSeikyuuKbn.TUUJYOU.eq(nyuukinKakusyouDataBean.getCreditUriageSeikyuuKbn())) {

                        // WK．クレ払消込区分 ← <クレ払消込区分>ＲＡＹ(定例売上)
                        creditcardHrKskmKbn = C_CreditcardHrKskmKbn.RAY_TEIREI_URIAGE;
                    }
                    // 上記以外 かつ WK．入金確証データBean．クレジットカード売上請求区分 ＝ <クレジットカード売上請求区分>臨時売上請求 の場合
                    else if (C_CreditUriageSeikyuuKbn.RINJI.eq(nyuukinKakusyouDataBean.getCreditUriageSeikyuuKbn())) {

                        // WK．クレ払消込区分 ← <クレ払消込区分>ＲＡＹ(臨時売上)
                        creditcardHrKskmKbn = C_CreditcardHrKskmKbn.RAY_RINJI_URIAGE;
                    }
                }

                // WK．入金確証データBean．入金経路＝ <入金経路>口座振替の場合
                if (C_Nykkeiro.KZHRK.eq(nyuukinKakusyouDataBean.getNykkeiro())) {
                    // WK．口座振替銀行コード ← WK．入金確証データBean．口座振替銀行コード
                    Kzhurikaebankcd = nyuukinKakusyouDataBean.getKzhurikaebankcd();
                }

                // WK．消込データテーブルエンティティを初期化する
                IT_KhKesikomiData khKesikomiData = new IT_KhKesikomiData(nyuukinKakusyouDataBean.
                    getNyuukinkakusyouno(), nyuukinKakusyouDataBean.getSyono());

                // WK．消込データテーブルエンティティを編集する。
                // 入金内容区分 ← WK．入金確証データBean．入金内容区分
                khKesikomiData.setNyknaiyoukbn(nyuukinKakusyouDataBean.getNyknaiyoukbn());
                // 入力区分 ← WK．入金確証データBean．入力区分
                khKesikomiData.setNyuuryokukbn(nyuukinKakusyouDataBean.getNyuuryokukbn());
                // 入金経路 ← WK．入金確証データBean．入金経路
                khKesikomiData.setNykkeiro(nyuukinKakusyouDataBean.getNykkeiro());
                // 充当年月 ← WK．入金確証データBean．充当年月
                khKesikomiData.setJyuutouym(nyuukinKakusyouDataBean.getJyuutouym());
                // 入金確証入力年月日 ← WK．入金確証データBean．入金確証入力年月日
                khKesikomiData.setNyuukinkakusyounrkymd(nyuukinKakusyouDataBean.getNyuukinkakusyounrkymd());
                // 領収日 ← WK．入金確証データBean．領収日
                khKesikomiData.setRyosyuymd(nyuukinKakusyouDataBean.getRyosyuymd());
                // 領収金額 ← WK．入金確証データBean．領収金額
                khKesikomiData.setRsgaku(nyuukinKakusyouDataBean.getRsgaku());
                // 入金伝票日付 ← WK．入金確証データBean．入金伝票日付
                khKesikomiData.setNykdenymd(nyuukinKakusyouDataBean.getNykdenymd());
                // 入金確証入力番号
                khKesikomiData.setNyuukinkakusyounrkno(nyuukinKakusyouDataBean.getNyuukinkakusyounrkno());
                // 貸借区分 ← <貸借区分>借方
                khKesikomiData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                // 出納番号
                khKesikomiData.setSuitono(nyuukinKakusyouDataBean.getSuitono());
                // 出納部門コード ← WK．入金確証データBean．出納部門コード
                khKesikomiData.setSuitoubumoncd(nyuukinKakusyouDataBean.getSuitoubumoncd());
                // 口座振替銀行コード ← WK．口座振替銀行コード
                khKesikomiData.setKzhurikaebankcd(Kzhurikaebankcd);
                // 仮勘定番号 ← WK．入金確証データBean．束仮勘定番号
                khKesikomiData.setKarikanjyono(nyuukinKakusyouDataBean.getTabakarikanjyono());
                // 振込用紙入金区分 ← WK．入金確証データBean．振込用紙入金区分
                khKesikomiData.setHrkmyousinkkbn(nyuukinKakusyouDataBean.getHrkmyousinkkbn());
                // 出納組織コード ← WK．入金確証データBean．出納組織コード
                khKesikomiData.setSuitososhikicd(nyuukinKakusyouDataBean.getSuitososhikicd());
                // クレ払消込区分 ← WK．クレ払消込区分
                khKesikomiData.setCreditcardhrkskmkbn(creditcardHrKskmKbn);
                // 業務用更新機能ＩＤ ← WK．業務用更新機能ＩＤ
                khKesikomiData.setGyoumuKousinKinou(gyoumuKousinkinouID);
                // 業務用更新者ＩＤ ← WK．業務用更新者ＩＤ
                khKesikomiData.setGyoumuKousinsyaId(gyoumuKousinsyaId);
                // 業務用更新時間 ← WK．業務用更新時間
                khKesikomiData.setGyoumuKousinTime(gyoumuKousinTime);
                // 収納代行社コード ← WK．入金確証データBean．収納代行社コード
                khKesikomiData.setSyuudaikocd(nyuukinKakusyouDataBean.getSyuudaikocd());

                // エンティティの初期化
                BizPropertyInitializer.initialize(khKesikomiData);

                // 消込データ追加
                khKesikomiSelDao.addInsertEntity(entityInserter, khKesikomiData);

                // 処理件数カウントアップ
                // WK．入金確証データBean．入金経路＝ <入金経路>口座振替の場合
                if (C_Nykkeiro.KZHRK.eq(nyuukinKakusyouDataBean.getNykkeiro())) {
                    // WK．処理件数（口振）←  WK．処理件数（口振）+ 1
                    syoriCntKouhuri = syoriCntKouhuri + 1;
                }
                // 上記以外 かつ WK．入金確証データBean．入金経路＝ <入金経路>クレジットの場合
                else if (C_Nykkeiro.CREDIT.eq(nyuukinKakusyouDataBean.getNykkeiro())) {
                    // WK．処理件数（クレ払）←  WK．処理件数（クレ払）+ 1
                    syoriCntCredit = syoriCntCredit + 1;
                }
                // 上記以外 かつ WK．入金確証データBean．入金経路＝ <入金経路>銀行の場合
                else if (C_Nykkeiro.BANK.eq(nyuukinKakusyouDataBean.getNykkeiro())) {
                    // WK．処理件数（振替）←  WK．処理件数（振替） ＋ 1
                    syoriCntHurikae = syoriCntHurikae + 1;
                }
                // WK．処理件数 ←  WK．処理件数 ＋1
                syoriCnt = syoriCnt + 1;
            }
        }

        // WK．入金経路＝ null または WK．入金経路＝ <入金経路>ブランク または
        // WK．入金経路＝ <入金経路>口座振替の場合
        if (nykkeiro == null || C_Nykkeiro.BLNK.eq(nykkeiro) || C_Nykkeiro.KZHRK.eq(nykkeiro)) {

            // バッチログの出力
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriCntKouhuri), "口振"));
        }
        // WK．入金経路＝ null または WK．入金経路＝ <入金経路>ブランク または
        // WK．入金経路＝ <入金経路>クレジットの場合
        if (nykkeiro == null || C_Nykkeiro.BLNK.eq(nykkeiro) || C_Nykkeiro.CREDIT.eq(nykkeiro)) {

            // バッチログの出力
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriCntCredit), "クレ払"));
        }
        // WK．入金経路＝ null または WK．入金経路 ＝ <入金経路>ブランク または
        // WK．入金経路 ＝ <入金経路>銀行の場合
        if (nykkeiro == null || C_Nykkeiro.BLNK.eq(nykkeiro) || C_Nykkeiro.BANK.eq(nykkeiro)) {

            // バッチログの出力
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriCntHurikae), "振替"));
        }

        // バッチログの出力
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriCnt), "合計"));
        // 並走区分の出力
        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1026, String.valueOf(heisoukbn)));
    }
}