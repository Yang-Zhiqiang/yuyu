CREATE VIEW ST_SynypTukiYkgtIkouHozon AS SELECT
     srkijyunym ,         /* 数理用基準年月 */
     sequenceno ,         /* シーケンス番号 */
     syono ,         /* 証券番号 */
     jyutoustartym ,         /* 充当開始年月 */
     jyutouendym ,         /* 充当終了年月 */
     taisyakukbn ,         /* 貸借区分 */
     denymd ,         /* 伝票日付 */
     syoricd ,         /* 処理コード */
     syoriYmd ,         /* 処理年月日 */
     seg1cd ,         /* セグメント１コード */
     zennoujiikkatubaraijytgk ,         /* 前納時一括払充当額 */
     denrenno ,         /* 伝票データ連番 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM ST_SynypTukiYkgtIkouHozon_Z;