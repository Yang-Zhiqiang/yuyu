CREATE VIEW BM_ChkTargetTkMokuhyouti AS SELECT
     syouhncd ,         /* 商品コード */
     syusyouhnsdnofrom ,         /* （主契約）商品世代番号自 */
     syusyouhnsdnoto ,         /* （主契約）商品世代番号至 */
     channelcd ,         /* チャネルコード */
     targettkmokuhyouti ,         /* ターゲット特約目標値 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_ChkTargetTkMokuhyouti_Z;