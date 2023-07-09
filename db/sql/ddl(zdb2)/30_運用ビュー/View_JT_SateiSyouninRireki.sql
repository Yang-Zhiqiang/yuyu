CREATE VIEW JT_SateiSyouninRireki AS SELECT
     skno ,         /* 請求番号 */
     syono ,         /* 証券番号 */
     sateisyouninskbtkey ,         /* 査定承認識別キー */
     seikyuurirekino ,         /* 請求履歴番号 */
     syorikekkakbn ,         /* 処理結果区分 */
     tennousakisousasyacd ,         /* 転送先操作者コード */
     hushrgeninkbn ,         /* 不支払原因区分 */
     higaitouriyuukbn ,         /* 非該当理由区分 */
     reportcomment ,         /* 帳票用コメント */
     sessyouyhkbn ,         /* 折衝要否区分 */
     sessyousisyacd ,         /* 折衝支社コード */
     kaiketuymd ,         /* 解決日 */
     kossyoricd ,         /* 更新処理コード */
     kossyorisscd ,         /* 更新処理詳細コード */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JT_SateiSyouninRireki_Z;