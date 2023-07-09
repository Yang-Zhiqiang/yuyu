CREATE VIEW IT_HengakuCfDenpyo AS SELECT
     denrenno ,         /* 伝票データ連番 */
     edano ,         /* 枝番号 */
     unitfundkbn ,         /* ユニットファンド区分 */
     tantocd ,         /* 担当コード */
     syoriYmd ,         /* 処理年月日 */
     denymd ,         /* 伝票日付 */
     taisyakukbn ,         /* 貸借区分 */
     kanjyoukmkcd ,         /* 勘定科目コード */
     tuukasyu ,         /* 通貨種類 */
     dengaikagk ,         /* 伝票金額（外貨） */
     dengaikagk$ ,         /* 伝票金額（外貨）(通貨型) */
     denyenkagk ,         /* 伝票金額（円） */
     denyenkagk$ ,         /* 伝票金額（円）(通貨型) */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_HengakuCfDenpyo_Z;