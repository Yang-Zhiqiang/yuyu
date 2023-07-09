CREATE VIEW MT_DsHenkouRireki AS SELECT
     dskokno ,         /* ＤＳ顧客番号 */
     henkousikibetukey ,         /* 変更識別キー */
     renno ,         /* 連番 */
     tablenm ,         /* テーブル名称 */
     tableid ,         /* テーブルＩＤ */
     hnksyuruikbn ,         /* 変更種類区分 */
     hanbetukoumokunm ,         /* 判別項目名 */
     henkoukoumokuid ,         /* 変更項目ID */
     henkoukoumokunm ,         /* 変更項目名 */
     bfrnaiyouoriginal ,         /* 変更前内容原本 */
     bfrnaiyou ,         /* 変更前内容 */
     newnaiyouoriginal ,         /* 変更後内容原本 */
     newnaiyou ,         /* 変更後内容 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM MT_DsHenkouRireki_Z;