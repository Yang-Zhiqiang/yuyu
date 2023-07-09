CREATE VIEW HM_SkSeibiSijiNaiyou AS SELECT
     skseibisijinaiyoucd ,         /* 新契約整備指示内容コード */
     skseibisijinaiyou ,         /* 新契約整備指示内容 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version ,         /* バージョン */
     hyoujijyun           /* 表示順 */
FROM HM_SkSeibiSijiNaiyou_Z;