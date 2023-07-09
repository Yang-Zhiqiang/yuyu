CREATE VIEW IT_BAK_HengakuCf AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     trkssikibetukey ,         /* 取消識別キー */
     henkousikibetukey ,         /* 変更識別キー */
     unitfundkbn ,         /* ユニットファンド区分 */
     syoriYmd ,         /* 処理年月日 */
     renno ,         /* 連番 */
     cfkbn ,         /* ＣＦ区分 */
     hasseiriyuukbn ,         /* 発生理由区分 */
     tuukasyu ,         /* 通貨種類 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_BAK_HengakuCf_Z;