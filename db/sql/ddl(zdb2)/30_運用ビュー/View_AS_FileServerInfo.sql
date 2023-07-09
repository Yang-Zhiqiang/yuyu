CREATE VIEW AS_FileServerInfo AS SELECT
     setteiNo ,         /* 設定番号 */
     tekiyouYmdFrom ,         /* 適用年月日（自） */
     setteiNm ,         /* 設定名 */
     setuzokusakiDomain ,         /* 接続先ドメイン */
     setuzokusakiIpAddress ,         /* 接続先ＩＰアドレス */
     setuzokusakiPortNo ,         /* 接続先ポート番号 */
     setuzokuUser ,         /* 接続ユーザー */
     setuzokuPassword ,         /* 接続先パスワード */
     angoukaKbn ,         /* 暗号化区分 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AS_FileServerInfo_Z;