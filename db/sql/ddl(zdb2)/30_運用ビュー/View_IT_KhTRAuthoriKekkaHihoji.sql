CREATE VIEW IT_KhTRAuthoriKekkaHihoji AS SELECT
     creditkessaiyouno ,         /* クレジットカード決済用番号 */
     syoriYmd ,         /* 処理年月日 */
     syono ,         /* 証券番号 */
     cardbrandkbn ,         /* カードブランド区分 */
     creditkaiinnosimo4keta ,         /* クレジット会員番号（下４桁） */
     authorijkkbn ,         /* オーソリ状況区分 */
     datajyusinymd ,         /* データ受信日 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_KhTRAuthoriKekkaHihoji_Z;