CREATE VIEW HW_CreditTrkNgList AS SELECT
     tyouhyouymd ,         /* 帳票作成日 */
     datarenno ,         /* データ連番 */
     mosno ,         /* 申込番号 */
     creditkessaiyouno ,         /* クレジットカード決済用番号 */
     creditqrerrorcd ,         /* クレジットカードＱＲエラーコード */
     bluegateerrorcd ,         /* ＢｌｕｅＧａｔｅエラーコード */
     dbhaneikbn ,         /* ＤＢ反映区分 */
     credittrkhaneierrriyuu ,         /* クレジットカード登録反映エラー理由 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HW_CreditTrkNgList_Z;