CREATE VIEW AT_FileKengen AS SELECT
     roleCd ,         /* ロールコード */
     fileSyuruiCd ,         /* ファイル種類コード */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AT_FileKengen_Z;