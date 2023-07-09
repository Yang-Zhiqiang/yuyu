CREATE VIEW BM_ChkHrkPTani AS SELECT
     syouhncd ,         /* 商品コード */
     hrkkaisuu ,         /* 払込回数 */
     syusyouhnsdnofrom ,         /* （主契約）商品世代番号自 */
     syusyouhnsdnoto ,         /* （主契約）商品世代番号至 */
     channelcd ,         /* チャネルコード */
     hrktuukasyu ,         /* 払込通貨種類 */
     hrkptani ,         /* 払込Ｐ単位 */
     hrkptani$ ,         /* 払込Ｐ単位(通貨型) */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_ChkHrkPTani_Z;