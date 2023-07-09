CREATE VIEW BT_KijituTouraiHonbanKensyou AS SELECT
     syoriYmd ,         /* 処理年月日 */
     subSystemId ,         /* サブシステムＩＤ */
     tysytno ,         /* 抽出番号 */
     datakanrino ,         /* データ管理番号 */
     tysytnaiyou1 ,         /* 抽出内容１ */
     tysytnaiyou2 ,         /* 抽出内容２ */
     tysytnaiyou3 ,         /* 抽出内容３ */
     tysytnaiyou4 ,         /* 抽出内容４ */
     tysytnaiyou5 ,         /* 抽出内容５ */
     tysytnaiyou6 ,         /* 抽出内容６ */
     tysytnaiyou7 ,         /* 抽出内容７ */
     tysytnaiyou8 ,         /* 抽出内容８ */
     tysytnaiyou9 ,         /* 抽出内容９ */
     tysytnaiyou10 ,         /* 抽出内容１０ */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_KijituTouraiHonbanKensyou_Z;