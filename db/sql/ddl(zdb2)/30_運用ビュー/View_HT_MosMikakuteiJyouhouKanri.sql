CREATE VIEW HT_MosMikakuteiJyouhouKanri AS SELECT
     mosno ,         /* 申込番号 */
     jimutetuzukicd ,         /* 事務手続コード */
     skeijimukbn ,         /* 新契約事務区分 */
     mosuketukekbn ,         /* 申込受付区分 */
     hknsyuruino ,         /* 保険種類番号 */
     dairitencd1 ,         /* 代理店コード１ */
     dairitencd2 ,         /* 代理店コード２ */
     jimuyoucd ,         /* 事務用コード */
     doujimosumu ,         /* 同時申込有無 */
     syono ,         /* 証券番号 */
     syorizumiflg ,         /* 処理済フラグ */
     sakujoyoteiymd ,         /* 削除予定日 */
     setmosno1 ,         /* セット申込番号１ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_MosMikakuteiJyouhouKanri_Z;