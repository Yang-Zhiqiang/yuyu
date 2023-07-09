CREATE VIEW IT_KhGinkouMdhnMisyuuInfo AS SELECT
     kbnkey ,         /* 区分キー */
     datarenymd ,         /* データ連動日 */
     syono ,         /* 証券番号 */
     henkousikibetukey ,         /* 変更識別キー */
     gwbsydrtencd ,         /* ＧＷ＿募集代理店コード */
     gwdatakbn ,         /* ＧＷ＿データ区分 */
     gwdatasakuseiymd ,         /* ＧＷ＿データ作成日 */
     gwhknkaisyacd ,         /* ＧＷ＿保険会社コード */
     gwhknsyuruicd ,         /* ＧＷ＿保険種類コード */
     gwsyonosyuban ,         /* ＧＷ＿証券番号主番 */
     gwmisyuutatekaekbn ,         /* ＧＷ＿未収・立替区分 */
     gwmisyuutatekaeym ,         /* ＧＷ＿未収・立替発生年月 */
     gwmisyuukg ,         /* ＧＷ＿未収金額 */
     gwbnkaisuu ,         /* ＧＷ＿分割回数 */
     gwmisyuujiyuu ,         /* ＧＷ＿未収事由 */
     gwjikaidatakousinymd ,         /* ＧＷ＿次回データ更新日 */
     ikkatubaraikbn ,         /* 一括払区分 */
     ikkatubaraikaisuu ,         /* 一括払回数 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_KhGinkouMdhnMisyuuInfo_Z;