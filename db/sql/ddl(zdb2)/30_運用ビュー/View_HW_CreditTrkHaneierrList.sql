CREATE VIEW HW_CreditTrkHaneierrList AS SELECT
     tyouhyouymd ,         /* 帳票作成日 */
     datarenno ,         /* データ連番 */
     mosno ,         /* 申込番号 */
     credittrkhoukbn ,         /* クレジットカード登録方法区分 */
     sosikicd ,         /* 組織コード */
     creditkessaiyouno ,         /* クレジットカード決済用番号 */
     credittrkhaneierrriyuu ,         /* クレジットカード登録反映エラー理由 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HW_CreditTrkHaneierrList_Z;