CREATE VIEW BM_BunsyonoSettei AS SELECT
     bunsyosyubetukbn ,         /* 文書種別区分 */
     aisyoumeikbn ,         /* 愛称名区分 */
     channelcd ,         /* チャネルコード */
     oyadrtencd ,         /* 親代理店コード */
     renno ,         /* 連番 */
     tekiyouYmdFrom ,         /* 適用年月日（自） */
     tekiyouYmdTo ,         /* 適用年月日（至） */
     bunsyono ,         /* 文書番号 */
     siorino ,         /* しおり番号 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_BunsyonoSettei_Z;