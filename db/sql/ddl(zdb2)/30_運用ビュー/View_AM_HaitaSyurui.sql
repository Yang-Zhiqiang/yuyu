CREATE VIEW AM_HaitaSyurui AS SELECT
     haitaSyuruiCd ,         /* 排他種類コード */
     haitaSyuruiNm ,         /* 排他種類名 */
     haitaKeyKousei ,         /* 排他キー構成 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AM_HaitaSyurui_Z;