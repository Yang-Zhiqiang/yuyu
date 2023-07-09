CREATE VIEW BT_SystemRenkei AS SELECT
     interfaceid ,         /* インターフェースＩＤ */
     syorihousiki ,         /* 処理方式 */
     henkanhoukou ,         /* 変換方向 */
     henkanmaelayoutid ,         /* 変換前レイアウトＩＤ */
     henkanmaelayoutname ,         /* 変換前レイアウト名 */
     henkangolayoutid ,         /* 変換後レイアウトＩＤ */
     henkangolayoutname ,         /* 変換後レイアウト名 */
     subSystemId ,         /* サブシステムＩＤ */
     renkeifiledirectory ,         /* 連携ファイル格納ディレクトリ */
     renkeifilenm ,         /* 連携ファイル名 */
     renkeifiletype ,         /* 連携ファイル種別 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_SystemRenkei_Z;