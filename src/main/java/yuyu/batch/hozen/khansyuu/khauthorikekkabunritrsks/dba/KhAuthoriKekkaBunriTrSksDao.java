package yuyu.batch.hozen.khansyuu.khauthorikekkabunritrsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.meta.QIT_BunrimaeAuthoriKekka;
import yuyu.def.db.meta.QIT_SkCreditCardTourokuKekka;

/**
 * 契約保全 案内収納 オーソリ結果分離およびＴＲ作成機能DAOクラス
 * @author 李　吉喆
 * @version 2019/10/23 李　吉喆 : 新規作成<br />
 */
public class KhAuthoriKekkaBunriTrSksDao {

    /** 機能拡張エンティティマネージャ */
    @Inject
    private ExDBEntityManager exDBEntityManager;

    /**
     * 分離前オーソリ結果Beanリスト(大量)取得<br />
     * 拡張ジョブコードを指定して、分離前オーソリ結果Beanリスト（大量）を取得します。<br />
     * @param   pKakutyoujobcd      拡張ジョブコード<br />
     * @return  分離前オーソリ結果Beanリスト(大量)<br />
     */
    public ExDBResults<BunrimaeAuthoriKekkaBean> getBunrimaeAuthoriKekka(String pKakutyoujobcd) {

        // WK．分離前オーソリ結果テーブルエンティティメタデータ
        QIT_BunrimaeAuthoriKekka qIT_BunrimaeAuthoriKekka = new QIT_BunrimaeAuthoriKekka("qIT_BunrimaeAuthoriKekka");

        // クエリ作成
        String sql = $SELECT + $NEW(BunrimaeAuthoriKekkaBean.class,           // $NEW ( 分離前オーソリ結果Beanクラス．class
            qIT_BunrimaeAuthoriKekka.creditkessaiyouno,                       // WK．分離前オーソリ結果テーブルエンティティメタデータ．クレジットカード決済用番号
            qIT_BunrimaeAuthoriKekka.datajyusinymd,                           // WK．分離前オーソリ結果テーブルエンティティメタデータ．データ受信日
            qIT_BunrimaeAuthoriKekka.syoriYmd,                                // WK．分離前オーソリ結果テーブルエンティティメタデータ．処理年月日
            qIT_BunrimaeAuthoriKekka.kaiintourokukbn,                         // WK．分離前オーソリ結果テーブルエンティティメタデータ．会員登録区分
            qIT_BunrimaeAuthoriKekka.creditcardno,                            // WK．分離前オーソリ結果テーブルエンティティメタデータ．クレジットカード番号
            qIT_BunrimaeAuthoriKekka.cardyuukoukigen4keta,                    // WK．分離前オーソリ結果テーブルエンティティメタデータ．クレジットカード有効期限（４桁）
            qIT_BunrimaeAuthoriKekka.authorigk7keta,                          // WK．分離前オーソリ結果テーブルエンティティメタデータ．オーソリ金額（７桁）
            qIT_BunrimaeAuthoriKekka.authorikekkaerrorcd,                     // WK．分離前オーソリ結果テーブルエンティティメタデータ．オーソリ結果エラーコード
            qIT_BunrimaeAuthoriKekka.bluegateerrorcd,                         // WK．分離前オーソリ結果テーブルエンティティメタデータ．ＢｌｕｅＧａｔｅエラーコード
            qIT_BunrimaeAuthoriKekka.hisimukekaisyacd,                        // WK．分離前オーソリ結果テーブルエンティティメタデータ．被仕向会社コード
            qIT_BunrimaeAuthoriKekka.wentryuserid,                            // WK．分離前オーソリ結果テーブルエンティティメタデータ．ＷエントリユーザＩＤ
            qIT_BunrimaeAuthoriKekka.errorcomment,                            // WK．分離前オーソリ結果テーブルエンティティメタデータ．エラーコメント
            qIT_BunrimaeAuthoriKekka.niniinfo,                                // WK．分離前オーソリ結果テーブルエンティティメタデータ．任意情報
            qIT_BunrimaeAuthoriKekka.datasyorijyoukyou,                       // WK．分離前オーソリ結果テーブルエンティティメタデータ．データ処理状況
            qIT_BunrimaeAuthoriKekka.gyoumuKousinKinou,                       // WK．分離前オーソリ結果テーブルエンティティメタデータ．業務用更新機能ＩＤ
            qIT_BunrimaeAuthoriKekka.gyoumuKousinsyaId,                       // WK．分離前オーソリ結果テーブルエンティティメタデータ．業務用更新者ＩＤ
            qIT_BunrimaeAuthoriKekka.gyoumuKousinTime) +                      // WK．分離前オーソリ結果テーブルエンティティメタデータ．業務用更新時間
            $FROM(qIT_BunrimaeAuthoriKekka);                                  // WK．分離前オーソリ結果テーブルエンティティメタデータ

        // クエリ実行
        ExDBResults<BunrimaeAuthoriKekkaBean> exDBResults = exDBEntityManager.createJPQL(
            sql, BunrimaeAuthoriKekkaBean.class).bind(qIT_BunrimaeAuthoriKekka).getResults();

        // 【分離前オーソリ結果Beanリスト（大量）#setFilter】を実行する。
        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        // 結果返却
        return exDBResults;
    }

    /**
     * 新契約クレジットカード登録結果情報全件削除</br>
     * 新契約クレジットカード登録結果テーブルエンティティを削除します。</br>
     * @return  削除件数
     */
    public int deleteSkCreditCardTourokuKekka() {

        // WK．新契約クレジットカード登録結果テーブルエンティティメタデータ
        QIT_SkCreditCardTourokuKekka qIT_SkCreditCardTourokuKekka = new QIT_SkCreditCardTourokuKekka("qIT_SkCreditCardTourokuKekka");

        // WK．クエリ
        String sql = $DELETE_FROM(qIT_SkCreditCardTourokuKekka);

        // 結果返却
        return exDBEntityManager.createJPQL(sql).bind(qIT_SkCreditCardTourokuKekka).executeUpdate();
    }
}
