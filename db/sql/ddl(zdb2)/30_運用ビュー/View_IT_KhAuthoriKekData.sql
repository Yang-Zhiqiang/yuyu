CREATE VIEW IT_KhAuthoriKekData AS SELECT
     ansyuusyskbn ,         /* 案内収納用システム区分 */
     authorikkdatarenno ,         /* オーソリ結果データ連番 */
     syoriYmd ,         /* 処理年月日 */
     syono ,         /* 証券番号 */
     authorikanryoymd ,         /* オーソリ完了日 */
     creditcardno1 ,         /* クレジットカード番号１ */
     creditcardno2 ,         /* クレジットカード番号２ */
     creditcardno3 ,         /* クレジットカード番号３ */
     creditcardno4 ,         /* クレジットカード番号４ */
     creditcardykkigen ,         /* クレジットカード有効期限 */
     authoritrkkbn ,         /* オーソリ登録区分 */
     torihikicd ,         /* 取引コード */
     authorigk ,         /* オーソリ金額 */
     authorigk$ ,         /* オーソリ金額(通貨型) */
     syouninno ,         /* 承認番号 */
     tanmatusyorino ,         /* 端末処理通番 */
     authorijkkbn ,         /* オーソリ状況区分 */
     creditbrerrorcd ,         /* クレジット払エラーコード */
     jyuutouym ,         /* 充当年月 */
     hrkkaisuu ,         /* 払込回数 */
     authorikaisuu ,         /* オーソリ回数 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_KhAuthoriKekData_Z;