CREATE VIEW BM_ChkKeiyakuTaniSaikouS AS SELECT
     syouhncd ,         /* 商品コード */
     syusyouhnsdnofrom ,         /* （主契約）商品世代番号自 */
     syusyouhnsdnoto ,         /* （主契約）商品世代番号至 */
     saikous1 ,         /* 最高Ｓ１ */
     saikous1$ ,         /* 最高Ｓ１(通貨型) */
     saikous2 ,         /* 最高Ｓ２ */
     saikous2$ ,         /* 最高Ｓ２(通貨型) */
     saikous3 ,         /* 最高Ｓ３ */
     saikous3$ ,         /* 最高Ｓ３(通貨型) */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_ChkKeiyakuTaniSaikouS_Z;