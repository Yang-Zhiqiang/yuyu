CREATE VIEW HM_SkHubiNaiyou AS SELECT
     skhubikoumokucd ,         /* 新契約不備項目コード */
     skhubinaiyoucd ,         /* 新契約不備内容コード */
     skhubinaiyou ,         /* 新契約不備内容 */
     skhubinaiyousentakumongon ,         /* 新契約不備内容選択文言 */
     skseibisijinaiyoucd ,         /* 新契約整備指示内容コード */
     skhubirenrakunaiyoucd ,         /* 新契約不備連絡内容コード */
     hyoujijyun ,         /* 表示順 */
     hyoujikahikbn ,         /* 表示可否区分 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HM_SkHubiNaiyou_Z;