CREATE VIEW HM_SkHubiRenrakuNaiyou AS SELECT
     skhubirenrakunaiyoucd ,         /* 新契約不備連絡内容コード */
     skhubirenrakunaiyou ,         /* 新契約不備連絡内容 */
     tyoubunflg ,         /* 長文フラグ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HM_SkHubiRenrakuNaiyou_Z;