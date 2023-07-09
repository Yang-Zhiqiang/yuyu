CREATE VIEW BM_ChkJhSaiteiP AS SELECT
     syouhncd ,         /* 商品コード */
     hrkkaisuu ,         /* 払込回数 */
     hrkkknfrom ,         /* 払込期間自 */
     hrkkknto ,         /* 払込期間至 */
     syusyouhnsdnofrom ,         /* （主契約）商品世代番号自 */
     syusyouhnsdnoto ,         /* （主契約）商品世代番号至 */
     channelcd ,         /* チャネルコード */
     tuukasyu ,         /* 通貨種類 */
     syouhinbetukey1 ,         /* 商品別キー１ */
     saiteip ,         /* 最低Ｐ */
     saiteip$ ,         /* 最低Ｐ(通貨型) */
     ptani ,         /* Ｐ単位 */
     ptani$ ,         /* Ｐ単位(通貨型) */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_ChkJhSaiteiP_Z;