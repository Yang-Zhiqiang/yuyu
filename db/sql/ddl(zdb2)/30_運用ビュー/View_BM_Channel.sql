CREATE VIEW BM_Channel AS SELECT
     channelcd ,         /* チャネルコード */
     channelnm ,         /* チャネル名 */
     jimuschemekbn ,         /* 事務スキーム区分 */
     drtensikibetukbn ,         /* 代理店識別区分 */
     gwdrtensikibetukbn ,         /* ＧＷ代理店識別区分 */
     gwsousinsakisikibetusi ,         /* ＧＷ送信先識別子 */
     tyhyrenrakusikibetukbn ,         /* 帳票連絡先識別区分 */
     sortNo ,         /* ソート番号 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_Channel_Z;