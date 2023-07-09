CREATE VIEW IT_KhAuthoriData AS SELECT
     ansyuusyskbn ,         /* 案内収納用システム区分 */
     syoriYmd ,         /* 処理年月日 */
     syono ,         /* 証券番号 */
     authorikaisuu ,         /* オーソリ回数 */
     creditcardno1 ,         /* クレジットカード番号１ */
     creditcardno2 ,         /* クレジットカード番号２ */
     creditcardno3 ,         /* クレジットカード番号３ */
     creditcardno4 ,         /* クレジットカード番号４ */
     creditcardykkigen ,         /* クレジットカード有効期限 */
     authorigk ,         /* オーソリ金額 */
     authorigk$ ,         /* オーソリ金額(通貨型) */
     jkipjytym ,         /* 次回Ｐ充当年月 */
     hrkkaisuu ,         /* 払込回数 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_KhAuthoriData_Z;