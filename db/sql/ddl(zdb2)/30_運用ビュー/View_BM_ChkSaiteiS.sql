CREATE VIEW BM_ChkSaiteiS AS SELECT
     syouhncd ,         /* 商品コード */
     syusyouhnsdnofrom ,         /* （主契約）商品世代番号自 */
     syusyouhnsdnoto ,         /* （主契約）商品世代番号至 */
     dntsdnumufrom ,         /* 団体集団有無自 */
     dntsdnumuto ,         /* 団体集団有無至 */
     hrkkknsmnkbnfrom ,         /* 払込期間歳満期区分自 */
     hrkkknsmnkbnto ,         /* 払込期間歳満期区分至 */
     hknkknfrom ,         /* 保険期間自 */
     hknkknto ,         /* 保険期間至 */
     saiteisknwtkumufrom ,         /* 最低Ｓ緩和特約有無自 */
     saiteisknwtkumuto ,         /* 最低Ｓ緩和特約有無至 */
     tuukasyu ,         /* 通貨種類 */
     saiteis ,         /* 最低Ｓ */
     saiteis$ ,         /* 最低Ｓ(通貨型) */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_ChkSaiteiS_Z;