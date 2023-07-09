CREATE VIEW JT_SdsGizouKaizanInfo AS SELECT
     skno ,         /* 請求番号 */
     syono ,         /* 証券番号 */
     seikyuurirekino ,         /* 請求履歴番号 */
     sindansyogizokaizanumukbn ,         /* 診断書偽造改竄有無区分 */
     sindansyogizokaizanjisikbn ,         /* 診断書偽造改竄確認実施区分 */
     sindansyogizokaizanriyuu ,         /* 診断書偽造改竄理由 */
     kossyoricd ,         /* 更新処理コード */
     kossyorisscd ,         /* 更新処理詳細コード */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JT_SdsGizouKaizanInfo_Z;