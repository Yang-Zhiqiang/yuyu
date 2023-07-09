CREATE VIEW JM_SyujyutuKyuuhu AS SELECT
     syujyutubunruicd ,         /* 手術分類コード */
     syouhncd ,         /* 商品コード */
     syouhnsdno ,         /* 商品世代番号 */
     kyuuhucd ,         /* 給付コード */
     syujyututekiyoukkanfrom ,         /* 手術適用期間（自） */
     syujyututekiyoukkanto ,         /* 手術適用期間（至） */
     syujyutukyhbairitu ,         /* 手術給付倍率 */
     kyuuhugendokikan ,         /* 給付限度期間 */
     syujyutusyurui ,         /* 手術種類 */
     tokusyusyujyutukbn ,         /* 特殊手術区分 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JM_SyujyutuKyuuhu_Z;