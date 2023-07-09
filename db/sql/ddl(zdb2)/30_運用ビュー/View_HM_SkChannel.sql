CREATE VIEW HM_SkChannel AS SELECT
     channelcd ,         /* チャネルコード */
     oyadrtencd ,         /* 親代理店コード */
     aisyoumeichannelkbn ,         /* 愛称名チャネル区分 */
     kiteichkchannelcd ,         /* 規定チェック用チャネルコード */
     skeijimukbn ,         /* 新契約事務区分 */
     tyhyrenrakusikibetukbn ,         /* 帳票連絡先識別区分 */
     sortNo ,         /* ソート番号 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HM_SkChannel_Z;