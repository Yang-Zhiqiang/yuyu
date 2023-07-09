CREATE VIEW BM_ChkTkykHukaKahi AS SELECT
     tksyouhncd ,         /* 特約商品コード */
     syusyouhncd ,         /* 主契約商品コード */
     syusyouhnsdnofrom ,         /* （主契約）商品世代番号自 */
     syusyouhnsdnoto ,         /* （主契約）商品世代番号至 */
     channelcd ,         /* チャネルコード */
     hukakahikbn ,         /* 付加可否区分 */
     tkbairituhugou ,         /* 特約倍率符号 */
     tkbairitu ,         /* 特約倍率 */
     tkhukahissuumu ,         /* 特約付加必須有無 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_ChkTkykHukaKahi_Z;