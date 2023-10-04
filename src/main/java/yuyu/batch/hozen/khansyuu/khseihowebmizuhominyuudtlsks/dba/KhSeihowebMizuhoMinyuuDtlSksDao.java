package yuyu.batch.hozen.khansyuu.khseihowebmizuhominyuudtlsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.meta.QIT_DrtenMinyuKykNaiyou;

/**
 * 契約保全 案内収納 生保Ｗｅｂ・みずほ用未入明細作成機能DAOクラスです。
 * @author  臧广原
 * @version 2018/11/26 臧广原   : 新規作成<br />
 */
public class KhSeihowebMizuhoMinyuuDtlSksDao {

    /** 機能拡張エンティティマネージャ */
    @Inject
    private ExDBEntityManager exDBEntityManager;

    /**
     * 生保Ｗｅｂ・みずほ用未入明細作成Beanリスト（大量）取得 <br />
     * 拡張ジョブコード、処理年月を指定して生保Ｗｅｂ・みずほ用未入明細作成Beanを取得します。<br />
     * 該当するデータが存在しない場合は空（要素数が０）のリストを返します。<br />
     * @param pKakutyouJobCd         拡張ジョブコード
     * @param pSyoribiYm             処理年月
     * @return                       生保Ｗｅｂ・みずほ用未入明細作成Beanリスト（大量）
     */
    public ExDBResults<KhSeihowebMizuhoMinyuuDtlSksBean> getKhSeihowebMizuhoMinyuuDtlSksBeans(String pKakutyouJobCd,
        BizDateYM pSyoribiYm) {
        // WK．代理店未入契約明細内容テーブルエンティティメタデータ
        QIT_DrtenMinyuKykNaiyou qIT_DrtenMinyuKykNaiyou = new QIT_DrtenMinyuKykNaiyou("qIT_DrtenMinyuKykNaiyou");
        String sql = $SELECT + $NEW(KhSeihowebMizuhoMinyuuDtlSksBean.class,             // 生保Ｗｅｂ・みずほ用未入明細作成Bean．class
            qIT_DrtenMinyuKykNaiyou.kbnkey,                                             // WK．代理店未入契約明細内容テーブルエンティティメタデータ．区分キー
            qIT_DrtenMinyuKykNaiyou.syono,                                              // WK．代理店未入契約明細内容テーブルエンティティメタデータ．証券番号
            qIT_DrtenMinyuKykNaiyou.minyusyoriymd,                                      // WK．代理店未入契約明細内容テーブルエンティティメタデータ．未入処理日
            qIT_DrtenMinyuKykNaiyou.bosyuuym,                                           // WK．代理店未入契約明細内容テーブルエンティティメタデータ．募集年月
            qIT_DrtenMinyuKykNaiyou.kydatkikbnkj,                                       // WK．代理店未入契約明細内容テーブルエンティティメタデータ．共同扱区分（漢字）
            qIT_DrtenMinyuKykNaiyou.kyknm35keta,                                        // WK．代理店未入契約明細内容テーブルエンティティメタデータ．契約者名（３５桁）
            qIT_DrtenMinyuKykNaiyou.cifcd,                                              // WK．代理店未入契約明細内容テーブルエンティティメタデータ．ＣＩＦコード
            qIT_DrtenMinyuKykNaiyou.jyuutouym,                                          // WK．代理店未入契約明細内容テーブルエンティティメタデータ．充当年月
            qIT_DrtenMinyuKykNaiyou.hrkp.getTypeFieldName(),                            // WK．代理店未入契約明細内容テーブルエンティティメタデータ．払込保険料の通貨単位フィールド名
            qIT_DrtenMinyuKykNaiyou.hrkp.getValueFieldName(),                           // WK．代理店未入契約明細内容テーブルエンティティメタデータ．払込保険料の金額フィールド名
            qIT_DrtenMinyuKykNaiyou.keiyakuymd,                                         // WK．代理店未入契約明細内容テーブルエンティティメタデータ．契約年月日
            qIT_DrtenMinyuKykNaiyou.hhknnmkj,                                           // WK．代理店未入契約明細内容テーブルエンティティメタデータ．被保険者名（漢字）
            qIT_DrtenMinyuKykNaiyou.tsintelno,                                          // WK．代理店未入契約明細内容テーブルエンティティメタデータ．通信先電話番号
            qIT_DrtenMinyuKykNaiyou.dai2tsintelno,                                      // WK．代理店未入契約明細内容テーブルエンティティメタデータ．第２通信先電話番号
            qIT_DrtenMinyuKykNaiyou.bankcd,                                             // WK．代理店未入契約明細内容テーブルエンティティメタデータ．銀行コード
            qIT_DrtenMinyuKykNaiyou.sitencd,                                            // WK．代理店未入契約明細内容テーブルエンティティメタデータ．支店コード
            qIT_DrtenMinyuKykNaiyou.yokinkbn,                                           // WK．代理店未入契約明細内容テーブルエンティティメタデータ．預金種目区分
            qIT_DrtenMinyuKykNaiyou.kouzano,                                            // WK．代理店未入契約明細内容テーブルエンティティメタデータ．口座番号
            qIT_DrtenMinyuKykNaiyou.hrkkaisuu,                                          // WK．代理店未入契約明細内容テーブルエンティティメタデータ．払込回数
            qIT_DrtenMinyuKykNaiyou.hrkkeiro,                                           // WK．代理店未入契約明細内容テーブルエンティティメタデータ．払込経路
            qIT_DrtenMinyuKykNaiyou.tikiktbrisyuruikbn,                                 // WK．代理店未入契約明細内容テーブルエンティティメタデータ．定期一括払種類区分
            qIT_DrtenMinyuKykNaiyou.tsinkihontikucd,                                    // WK．代理店未入契約明細内容テーブルエンティティメタデータ．通信先基本地区コード
            qIT_DrtenMinyuKykNaiyou.kanjitsinkaiadr,                                    // WK．代理店未入契約明細内容テーブルエンティティメタデータ．漢字通信先下位住所
            qIT_DrtenMinyuKykNaiyou.kzmeiginmkn,                                        // WK．代理店未入契約明細内容テーブルエンティティメタデータ．口座名義人氏名（カナ）
            qIT_DrtenMinyuKykNaiyou.jkiannaikg.getTypeFieldName(),                      // WK．代理店未入契約明細内容テーブルエンティティメタデータ．次回案内金額の通貨単位フィールド名
            qIT_DrtenMinyuKykNaiyou.jkiannaikg.getValueFieldName(),                     // WK．代理店未入契約明細内容テーブルエンティティメタデータ．次回案内金額の金額フィールド名
            qIT_DrtenMinyuKykNaiyou.yykknmnryymd,                                       // WK．代理店未入契約明細内容テーブルエンティティメタデータ．猶予期間満了日
            qIT_DrtenMinyuKykNaiyou.hurihunokbn,                                        // WK．代理店未入契約明細内容テーブルエンティティメタデータ．振替不能理由区分
            qIT_DrtenMinyuKykNaiyou.nexthurikaeymd,                                     // WK．代理店未入契約明細内容テーブルエンティティメタデータ．次回振替日
            qIT_DrtenMinyuKykNaiyou.ikkatubaraikbn,                                     // WK．代理店未入契約明細内容テーブルエンティティメタデータ．一括払区分
            qIT_DrtenMinyuKykNaiyou.ikkatubaraikaisuu,                                  // WK．代理店未入契約明細内容テーブルエンティティメタデータ．一括払回数
            qIT_DrtenMinyuKykNaiyou.dairitencd1,                                        // WK．代理店未入契約明細内容テーブルエンティティメタデータ．代理店コード１
            qIT_DrtenMinyuKykNaiyou.bosyuucd1,                                          // WK．代理店未入契約明細内容テーブルエンティティメタデータ．募集人コード１
            qIT_DrtenMinyuKykNaiyou.drtenkanrisosikicd1,                                // WK．代理店未入契約明細内容テーブルエンティティメタデータ．代理店管理組織コード１
            qIT_DrtenMinyuKykNaiyou.drtenchannelsyuruikbn1,                             // WK．代理店未入契約明細内容テーブルエンティティメタデータ．代理店チャネル種類区分１
            qIT_DrtenMinyuKykNaiyou.dairitencd2,                                        // WK．代理店未入契約明細内容テーブルエンティティメタデータ．代理店コード２
            qIT_DrtenMinyuKykNaiyou.bosyuucd2,                                          // WK．代理店未入契約明細内容テーブルエンティティメタデータ．募集人コード２
            qIT_DrtenMinyuKykNaiyou.drtenkanrisosikicd2,                                // WK．代理店未入契約明細内容テーブルエンティティメタデータ．代理店管理組織コード２
            qIT_DrtenMinyuKykNaiyou.drtenchannelsyuruikbn2) +                           // WK．代理店未入契約明細内容テーブルエンティティメタデータ．代理店チャネル種類区分２
            $FROM(qIT_DrtenMinyuKykNaiyou) +                                            // WK．代理店未入契約明細内容テーブルエンティティメタデータ
            $WHERE + qIT_DrtenMinyuKykNaiyou.syoriym.eq(pSyoribiYm);                    // WK．代理店未入契約明細内容テーブルエンティティメタデータ．処理年月 ＝ I．処理年月

        // 検索結果
        ExDBResults<KhSeihowebMizuhoMinyuuDtlSksBean> exDBResults = exDBEntityManager.createJPQL(sql,
            KhSeihowebMizuhoMinyuuDtlSksBean.class).bind(qIT_DrtenMinyuKykNaiyou).getResults();

        // 【生保Ｗｅｂ・みずほ用未入明細作成Beanリスト（大量）＃setFilter】を実行する
        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        // 検索結果を返却する
        return exDBResults;
    }
}
