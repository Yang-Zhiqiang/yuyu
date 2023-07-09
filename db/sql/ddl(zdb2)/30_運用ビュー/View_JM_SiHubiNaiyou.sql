CREATE VIEW JM_SiHubiNaiyou AS SELECT
     jimutetuzukicd ,         /* 事務手続コード */
     syoruiCd ,         /* 書類コード */
     hubinaiyoucd ,         /* 不備内容コード */
     hubinaiyou ,         /* 不備内容 */
     hubisyoruimsg ,         /* 不備書類用メッセージ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JM_SiHubiNaiyou_Z;