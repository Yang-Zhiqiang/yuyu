CREATE VIEW ST_SynypTukiTugtTykiyuHozon AS SELECT
     ztysrkijyunym ,         /* （中継用）数理用基準年月 */
     ztysrkakutyoujobcd ,         /* （中継用）数理用拡張ジョブコード */
     ztysequenceno ,         /* （中継用）シーケンス番号 */
     ztydatakanrino ,         /* （中継用）データ管理番号 */
     ztyjyuutouym ,         /* （中継用）充当年月 */
     ztyjyuutoukaisuu ,         /* （中継用）充当回数 */
     ztyrecordkbn ,         /* （中継用）レコード区分 */
     ztydenymd ,         /* （中継用）伝票日付 */
     ztysyoricd ,         /* （中継用）処理コード */
     ztyhenkousyoriymd ,         /* （中継用）変更処理年月日 */
     ztykbnkeiriyousegmentcd ,         /* （中継用）区分経理用セグメントコード */
     ztyzennoujiikkatubaraijytgk ,         /* （中継用）前納時一括払充当額 */
     ztysrdenrenno ,         /* （中継用）数理用伝票データ連番 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM ST_SynypTukiTugtTykiyuHozon_Z;