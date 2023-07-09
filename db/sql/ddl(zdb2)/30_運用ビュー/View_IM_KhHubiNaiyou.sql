CREATE VIEW IM_KhHubiNaiyou AS SELECT
     jimutetuzukicd ,         /* 事務手続コード */
     syoruiCd ,         /* 書類コード */
     hassinsakikbn ,         /* 発信先区分 */
     genponhnkykumu ,         /* 原本返却有無 */
     hubinaiyouhyoujijyun ,         /* 不備内容表示順 */
     hubinaiyoucd ,         /* 不備内容コード */
     hubinaiyou ,         /* 不備内容 */
     hubisyoruimsg ,         /* 不備書類用メッセージ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IM_KhHubiNaiyou_Z;