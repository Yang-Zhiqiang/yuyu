CREATE VIEW BT_HengakuEpsilonDenpyo AS SELECT
     hengakudenpyourecdkbn ,         /* 変額伝票レコード区分 */
     hengakusyuruikbn ,         /* 変額種類区分 */
     unitfundkbn ,         /* ユニットファンド区分 */
     tkbtkanjyouunitfundkbn ,         /* 特別勘定ユニットファンド区分 */
     kacd ,         /* 課コード */
     denymd ,         /* 伝票日付 */
     denpyoukbn ,         /* 伝票区分 */
     taisyakukbn ,         /* 貸借区分 */
     kamokucd ,         /* 科目コード */
     syoriYmd ,         /* 処理年月日 */
     fundsyoricd ,         /* ファンド処理コード */
     cfkbn ,         /* ＣＦ区分 */
     hasseiriyuukbn ,         /* 発生理由区分 */
     hasseikbn ,         /* 発生区分 */
     fundkingaku ,         /* ファンド金額 */
     fundkingaku$ ,         /* ファンド金額(通貨型) */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_HengakuEpsilonDenpyo_Z;