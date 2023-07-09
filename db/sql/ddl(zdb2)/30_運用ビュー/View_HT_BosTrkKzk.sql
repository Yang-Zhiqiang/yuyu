CREATE VIEW HT_BosTrkKzk AS SELECT
     mosno ,         /* 申込番号 */
     trkkzkkbn ,         /* 登録家族区分 */
     trkkzknmkn ,         /* 登録家族名（カナ） */
     trkkzknmkj ,         /* 登録家族名（漢字） */
     trkkzknmkjkhukakbn ,         /* 登録家族名漢字化不可区分 */
     trkkzkseiymd ,         /* 登録家族生年月日 */
     trkkzksei ,         /* 登録家族性別 */
     trkkzktdk ,         /* 登録家族続柄 */
     trkkzktsindousiteikbn ,         /* 登録家族通信先同一指定区分 */
     trkkzkyno ,         /* 登録家族郵便番号 */
     trkkzkadr1kj ,         /* 登録家族住所１（漢字） */
     trkkzkadr2kj ,         /* 登録家族住所２（漢字） */
     trkkzkadr3kj ,         /* 登録家族住所３（漢字） */
     trkkzktelno ,         /* 登録家族電話番号 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_BosTrkKzk_Z;