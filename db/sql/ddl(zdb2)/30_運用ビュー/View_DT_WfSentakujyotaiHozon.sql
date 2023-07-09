CREATE VIEW DT_WfSentakujyotaiHozon AS SELECT
     userId ,         /* ユーザーＩＤ */
     subSystemId ,         /* サブシステムＩＤ */
     jimutetuzukicd ,         /* 事務手続コード */
     skeiJimuKbnHzn ,         /* 新契約事務区分＿保存用 */
     mosUketukeKbnHzn ,         /* 申込受付区分＿保存用 */
     hokensyuruinohozon ,         /* 保険種類番号＿保存用 */
     dairitencd1 ,         /* 代理店コード１ */
     dairitencd2 ,         /* 代理店コード２ */
     drtencd3 ,         /* 代理店コード３ */
     drtencd4 ,         /* 代理店コード４ */
     drtencd5 ,         /* 代理店コード５ */
     koDairitenTaisyouKbn ,         /* 子代理店対象区分 */
     jimuyoucd ,         /* 事務用コード */
     jmycdMisetteiKbn ,         /* 事務用コード未設定区分 */
     djmskmKeiyakuKbn ,         /* 同時申込契約区分 */
     mosYmdFrom ,         /* 申込年月日（自） */
     mosYmdTo ,         /* 申込年月日（至） */
     jimustartYmdFrom ,         /* 事務開始年月日（自） */
     jimustartYmdTo ,         /* 事務開始年月日（至） */
     mosno ,         /* 申込番号 */
     syono ,         /* 証券番号 */
     nksysyno ,         /* 年金証書番号 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM DT_WfSentakujyotaiHozon_Z;