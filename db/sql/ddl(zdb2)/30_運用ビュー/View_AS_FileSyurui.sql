CREATE VIEW AS_FileSyurui AS SELECT
     fileSyuruiCd ,         /* ファイル種類コード */
     fileSyuruiNm ,         /* ファイル種類名 */
     fileSyuruiKbn ,         /* ファイル種類区分 */
     fileNmPattern ,         /* ファイル名パターン */
     downloadFileNm ,         /* ダウンロードファイル名 */
     fileType ,         /* ファイルタイプ */
     dataLayoutBeanClass ,         /* データレイアウトビーンクラス */
     createEmptyFileUmuKbn ,         /* 空ファイル出力有無区分 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AS_FileSyurui_Z;